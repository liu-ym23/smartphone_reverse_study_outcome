package com.ss.android.lark.flow.chat.page;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.Gson;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0014J\b\u0010\u000e\u001a\u00020\nH\u0016J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/flow/chat/page/FlowChatWindowSelectMessagesActivity;", "Lcom/ss/android/lark/flow/chat/page/FlowChatActivity;", "Lcom/ss/android/lark/chat/chatwindow/ISetChatWindowResult;", "<init>", "()V", "randomKey", "", "setResultCalled", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onBackPressed", "setChatWindowResult", "resultCode", "", "data", "Landroid/content/Intent;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowChatWindowSelectMessagesActivity extends FlowChatActivity implements i2b.a {
    public static final Companion g = null;
    public static final Map<String, IGetDataCallback<List<String>>> h = null;
    public String e;
    public boolean f;

    public static final class Companion {
        public Companion() {
        }

        public static void a(String r3, List r4) {
            int r1 = 0;
            if (r3.length() != 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L10;
            Log.e("FlowChatWindowSelectMessagesActivity", "random key is empty");
            return;
        L10:
            IGetDataCallback<List<String>> r2 = FlowChatWindowSelectMessagesActivity.h.remove(r3);
            if (r2 == null) goto L17;
            r2.onSuccess(r4);
            StringBuilder r5 = new StringBuilder("invoke callback onSuccess, list size is ");
            if (r4 == null) goto L15;
            r1 = r4.size();
        L15:
            r5.append(r1);
            Log.i("FlowChatWindowSelectMessagesActivity", r5.toString());
            return;
        L17:
            Log.e("FlowChatWindowSelectMessagesActivity", "callback from callback map for key " + r3 + " is null");
            return;
        L5:
            r0 = false;
            goto L7
        }

        public final void startActivity(Activity r4, String r5, Map<String, String> r6, final IGetDataCallback<List<String>> r7) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            Intrinsics.checkNotNullParameter(r5, "chatId");
            Intrinsics.checkNotNullParameter(r7, "callback");
            final String r0 = UUID.randomUUID().toString();
            Log.i("FlowChatWindowSelectMessagesActivity", "startActivity called, generate random key for this request: " + r0);
            FlowChatWindowSelectMessagesActivity.h.put(r0, r7);
            if (r6 != null) goto L5;
        L8:
            String r8 = null;
        L9:
            ChatBundle.a r1 = new ChatBundle.a();
            r1.a = r5;
            r1.u = r0;
            r1.v = r8;
            ChatBundle r9 = new ChatBundle(r1);
            Log.i("FlowChatWindowSelectMessagesActivity", "startActivity, call openChat");
            int r10 = FlowChatModule.d;
            FlowChatModule r11 = FlowChatModule.a.a();
            Intrinsics.checkNotNull(r9);
            r11.e(r4, r9, new FlowChatWindowSelectMessagesActivity$Companion$startActivity$1(r7, r0));
            return;
        L5:
            if ((!r6.isEmpty()) == false) goto L8;
            r8 = new Gson().toJson(r6);     // Catch: Throwable -> L11
            goto L9
        }
    }

    static {
        g = new Companion();
        h = new LinkedHashMap();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.flow.chat.page.FlowChatActivity, com.ss.android.lark.flow.chat.page.Hilt_FlowChatActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(FlowChatWindowSelectMessagesActivity.class.getName()));
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

    public final void onBackPressed() {
        Log.i("FlowChatWindowSelectMessagesActivity", "onBackPressed");
        String r1 = this.e;
        if (r1 != null) goto L5;
        Log.e("FlowChatWindowSelectMessagesActivity", "random key is null when pressing back");
    L9:
        super.onBackPressed();
        return;
    L5:
        if (this.f == true) goto L7;
        Log.i("FlowChatWindowSelectMessagesActivity", "invoke callback when onBackPressed");
        Companion.a(r1, null);
        goto L9
    L7:
        Log.i("FlowChatWindowSelectMessagesActivity", "setResult called, no need to invoke callback when pressing back");
        goto L9
    }

    @Override // com.ss.android.lark.flow.chat.page.FlowChatActivity, com.ss.android.lark.flow.chat.page.Hilt_FlowChatActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowChatWindowSelectMessagesActivity.class.getName()));
    L5:
        super.onDestroy();
        Log.i("FlowChatWindowSelectMessagesActivity", "onDestroy");
        String r1 = this.e;
        if (r1 == null) goto L10;
        boolean r2 = h.containsKey(r1);
        Log.i("FlowChatWindowSelectMessagesActivity", "callback in callbackMap is " + r2);
        if (r2 == false) goto L12;
        Log.i("FlowChatWindowSelectMessagesActivity", "invoke callback when onDestroy");
        Companion.a(r1, null);
        return;
    L12:
        return;
    L10:
        Log.e("FlowChatWindowSelectMessagesActivity", "random key is null, no need to clean resource when destroy activity");
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

    public FlowChatWindowSelectMessagesActivity() {
    }

    public final void MS(Intent r3) {
        Log.i("FlowChatWindowSelectMessagesActivity", "setChatWindowResult");
        String r1 = this.e;
        if (r1 == null) goto L5;
        Companion.a(r1, r3.getStringArrayListExtra("key_selected_message_id_list"));
        this.f = true;
        return;
    L5:
        Log.e("FlowChatWindowSelectMessagesActivity", "random key is null when set chat window result");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.flow.chat.page.FlowChatActivity
    public final void onCreate(Bundle r3) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r3);
        Log.i("FlowChatWindowSelectMessagesActivity", "onCreate");
        Intent r4 = getIntent();
        if (r4 == null) goto L15;
        Bundle r5 = r4.getExtras();
        if (r5 == null) goto L15;
        fxa.b r6 = fxa.a.a(r5);
    L16:
        if (r6 == null) goto L19;
        String r7 = r6.c();
        if (r7 == null) goto L19;
    L20:
        this.e = r7;
        if (r7.length() != 0) goto L23;
        boolean r8 = true;
    L24:
        if (r8 == false) goto L26;
        Log.e(((BaseFragmentActivity) this).PARENT_TAG, "random key is null or empty");
        finish();
        return;
    L26:
        Log.i("FlowChatWindowSelectMessagesActivity", "random key is " + this.e);
        return;
    L23:
        r8 = false;
    L19:
        r7 = "";
    L15:
        r6 = null;
        goto L16
    }
}
