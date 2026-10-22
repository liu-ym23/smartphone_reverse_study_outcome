package com.ss.android.lark.flow.feed.cell.chat.chatdismiss;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.activity.ActivityAnimationManager;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.flow.feed.utils.FlowEventManager;
import com.ss.android.lark.flow.feed.utils.d;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/flow/feed/cell/chat/chatdismiss/FlowChatDismissDialog;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getEnterAnimationConfig", "Lcom/ss/android/lark/base/activity/ActivityAnimationManager$AnimationConfig;", "getExitAnimationConfig", "setStatusBarTransparent", "Companion", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowChatDismissDialog extends BaseFragmentActivity {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b implements FlowChatDismissBottomSheet.c {
        public final /* synthetic */ FlowChatDismissDialog a;

        public b(FlowChatDismissDialog r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.flow.feed.cell.chat.chatdismiss.FlowChatDismissBottomSheet.c
        public final void h4(String r3) {
            Intrinsics.checkNotNullParameter(r3, "source");
            Lazy r0 = FlowEventManager.a;
            Intrinsics.checkNotNullParameter("EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED", "eventName");
            CopyOnWriteArrayList r1 = (CopyOnWriteArrayList) ((ConcurrentHashMap) FlowEventManager.a.getValue()).get("EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED");     // Catch: Throwable -> L10
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();     // Catch: Throwable -> L10
        L7:
            if (r2.hasNext() == false) goto L12;
            ((d) r2.next()).a(r3);     // Catch: Throwable -> L10
        L12:
            this.a.finish();
            return;
        L10:
            th = move-exception;
            Log.e("FlowEventManager", "publishEvent error, EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED, error: " + th.getMessage());
            goto L12
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(FlowChatDismissDialog.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final ActivityAnimationManager.AnimationConfig getEnterAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(0, 0);
    }

    public final ActivityAnimationManager.AnimationConfig getExitAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(0, 0);
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowChatDismissDialog.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public FlowChatDismissDialog() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L35
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L35
    L8:
        super.onCreate(r6);
        StatusBarUtil.setTransparent(this);     // Catch: Throwable -> L11
    L12:
        Bundle r7 = getIntent().getExtras();
        String r0 = "";
        if (r7 == null) goto L16;
        String r8 = r7.getString("key_avatar_key");
        if (r8 == null) goto L16;
    L17:
        Bundle r1 = getIntent().getExtras();
        if (r1 == null) goto L21;
        String r2 = r1.getString("key_entity_id");
        if (r2 == null) goto L21;
    L22:
        Bundle r3 = getIntent().getExtras();
        if (r3 == null) goto L26;
        String r4 = r3.getString("key_main_title");
        if (r4 == null) goto L26;
    L27:
        Bundle r5 = getIntent().getExtras();
        if (r5 == null) goto L33;
        String r9 = r5.getString("key_sub_title");
        if (r9 == null) goto L33;
        r0 = r9;
    L33:
        FlowChatDismissBottomSheet r10 = new FlowChatDismissBottomSheet(this);
        FlowChatDismissBottomSheet.b r11 = new FlowChatDismissBottomSheet.b(r8, r2, r4, r0);
        Intrinsics.checkNotNullParameter(r11, "data");
        r10.c = r11;
        r10.c();
        r10.e = new b(this);
        r10.b().a.setVisibility(0);
        LinearLayout r12 = r10.b().b;
        OneShotPreDrawListener.add(r12, new com.ss.android.lark.flow.feed.cell.chat.chatdismiss.b(r12));
        r10.b().c.setAlpha(0.0f);
        r10.b().c.animate().alpha(1.0f).setDuration(300).start();
        r10.b().c.setFocusableInTouchMode(true);
        r10.b().c.requestFocus();
        r10.b().c.setOnKeyListener(new c(r10));
        return;
    L26:
        r4 = "";
    L21:
        r2 = "";
    L16:
        r8 = "";
        goto L17
    }
}
