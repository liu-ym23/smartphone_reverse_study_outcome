package com.ss.android.lark.flow.group.page;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.activity.ActivityAnimationManager;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.flow.chat.view.sheet.FlowBottomSheet;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/flow/group/page/FlowQRCodeGroupCardActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "bottomSheet", "Lcom/ss/android/lark/flow/group/page/FlowQRCodeGroupCardBottomSheet;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getEnterAnimationConfig", "Lcom/ss/android/lark/base/activity/ActivityAnimationManager$AnimationConfig;", "getExitAnimationConfig", "setStatusBarTransparent", "tryHandleErrorResult", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "showErrorToast", "defaultMsg", "", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowQRCodeGroupCardActivity extends BaseFragmentActivity {
    public static final /* synthetic */ int b = 0;
    public com.ss.android.lark.flow.group.page.a a;

    public static final class a {
        public static void a(Context r5, Chat r6, String r7, String r8, boolean r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "chat");
            Intrinsics.checkNotNullParameter(r7, "inviterId");
            Intrinsics.checkNotNullParameter(r8, "token");
            Intent r0 = new Intent(r5, FlowQRCodeGroupCardActivity.class);
            Bundle r1 = new Bundle();
            String r2 = r6.getId();
            String r3 = "";
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r1.putString("key_chat_id", r2);
            String r4 = r6.getAvatarKey();
            if (r4 != null) goto L8;
            r4 = "";
        L8:
            r1.putString("key_avatar_key", r4);
            String r11 = r6.getEntityId();
            if (r11 != null) goto L11;
            r11 = "";
        L11:
            r1.putString("key_entity_id", r11);
            String r12 = r6.getName();
            if (r12 == null) goto L15;
            r3 = r12;
        L15:
            r1.putString("key_name", r3);
            r1.putInt("key_member_count", r6.getMemberCount());
            r1.putString("key_inviter_id", r7);
            r1.putString("key_token", r8);
            r1.putBoolean("key_is_expired", r9);
            r1.putBoolean("key_is_dismiss", r10);
            r0.putExtras(r1);
            r5.startActivity(r0);
        }
    }

    public static final class b implements FlowBottomSheet.b {
        public final /* synthetic */ FlowQRCodeGroupCardActivity a;

        @Override // com.ss.android.lark.flow.chat.view.sheet.FlowBottomSheet.b
        public final void onDismiss() {
            this.a.finish();
        }

        public b(FlowQRCodeGroupCardActivity r1) {
            this.a = r1;
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
        r2.i("ActivityLancet", "finish ".concat(FlowQRCodeGroupCardActivity.class.getName()));
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
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowQRCodeGroupCardActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public FlowQRCodeGroupCardActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.flow.group.page.FlowQRCodeGroupCardActivity$onCreate$1] */
    public final void onCreate(Bundle r12) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L68
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L68
    L8:
        super.onCreate(r12);
        StatusBarUtil.setTransparent(this);     // Catch: Throwable -> L11
    L12:
        Bundle r13 = getIntent().getExtras();
        if (r13 == null) goto L18;
        String r14 = r13.getString("key_chat_id");
        if (r14 == null) goto L18;
        String r2 = r14;
    L19:
        Bundle r15 = getIntent().getExtras();
        if (r15 == null) goto L25;
        String r16 = r15.getString("key_avatar_key");
        if (r16 == null) goto L25;
        String r3 = r16;
    L26:
        Bundle r17 = getIntent().getExtras();
        if (r17 == null) goto L32;
        String r18 = r17.getString("key_entity_id");
        if (r18 == null) goto L32;
        String r4 = r18;
    L33:
        Bundle r19 = getIntent().getExtras();
        if (r19 == null) goto L39;
        String r110 = r19.getString("key_name");
        if (r110 == null) goto L39;
        String r5 = r110;
    L40:
        Bundle r111 = getIntent().getExtras();
        if (r111 == null) goto L43;
        int r6 = r111.getInt("key_member_count");
    L44:
        Bundle r112 = getIntent().getExtras();
        if (r112 == null) goto L50;
        String r113 = r112.getString("key_inviter_id");
        if (r113 == null) goto L50;
        String r7 = r113;
    L51:
        Bundle r114 = getIntent().getExtras();
        if (r114 == null) goto L57;
        String r115 = r114.getString("key_token");
        if (r115 == null) goto L57;
        String r8 = r115;
    L58:
        Bundle r116 = getIntent().getExtras();
        if (r116 == null) goto L61;
        boolean r9 = r116.getBoolean("key_is_expired");
    L62:
        Bundle r117 = getIntent().getExtras();
        if (r117 == null) goto L65;
        boolean r10 = r117.getBoolean("key_is_dismiss");
    L66:
        com.ss.android.lark.flow.group.page.a r118 = new com.ss.android.lark.flow.group.page.a(this, new AnonymousClass1(this));
        com.ss.android.lark.flow.group.page.a.C0053a r0 = new com.ss.android.lark.flow.group.page.a.C0053a(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        Intrinsics.checkNotNullParameter(r0, "data");
        r118.f = r0;
        r118.e();
        r118.b = new b(this);
        this.a = r118;
        r118.d();
        return;
    L65:
        r10 = false;
        goto L66
    L61:
        r9 = false;
    L57:
        r8 = "";
    L50:
        r7 = "";
        goto L51
    L43:
        r6 = 0;
    L39:
        r5 = "";
    L32:
        r4 = "";
    L25:
        r3 = "";
    L18:
        r2 = "";
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1(ErrorResult r1, String r2) {
        if (r1 == null) goto L7;
        String r3 = r1.getDisplayMsg(r2);
        if (r3 == null) goto L7;
        r2 = r3;
    L7:
        UDToast.makeToast(this, r2).show();
    }
}
