package com.ss.android.lark.contact.customized.mobileinvite;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.contact.base.common_ui.OfficeInvBaseFragmentActivity;
import com.ss.android.lark.contact.base.contact_mobile_invite.InviteExternalContactV2Fragment;
import com.ss.android.lark.contact.base.utils.InvRouterParam$From;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.inv.export.util.d;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.a1;
import com.ss.android.lark.utils.q;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import h08.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/contact/customized/mobileinvite/OfficeInviteExternalContactActivity;", "Lcom/ss/android/lark/contact/base/common_ui/OfficeInvBaseFragmentActivity;", "<init>", "()V", "mFrom", BuildConfig.FLAVOR, "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", BuildConfig.FLAVOR, "resultCode", Keys.API_RETURN_KEY_DATA, "Landroid/content/Intent;", "onBackPressed", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteExternalContactActivity extends OfficeInvBaseFragmentActivity {
    public static final /* synthetic */ int b = 0;
    public String a;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.contact.base.common_ui.OfficeInvBaseFragmentActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(OfficeInviteExternalContactActivity.class.getName()));
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
        r1.addFlags(Bridge.TRANSFER_MAX_SIZE);     // Catch: Throwable -> L42
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
        if (Intrinsics.areEqual(InvRouterParam$From.ONBOARDING, this.a) == false) goto L14;
        String r0 = UIHelper.getString(2131890884);
        int r1 = q.a.a;
        long r2 = System.currentTimeMillis();
        if ((r2 - q.a) >= 2000) goto L12;
        int r3 = q.b + 1;
        q.b = r3;
        if (r3 != 2) goto L16;
        Intent r4 = new Intent("android.intent.action.MAIN");
        r4.addCategory("android.intent.category.HOME");
        r4.setFlags(268435456);
        LarkContext.getApplication().startActivity(r4);
        b r5 = q.c;
        if (r5 == null) goto L11;
        r5.a();
    L11:
        q.a = 0;
        return;
    L16:
        return;
    L12:
        q.b = 1;
        b r6 = LKUIToast.newGlobal(LarkContext.getApplication(), r0.toString());
        q.c = r6;
        r6.getClass();
        r6.b.b.d = -2;
        r6.c();
        q.a = r2;
        return;
    L14:
        super.onBackPressed();
    }

    @Override // com.ss.android.lark.contact.base.common_ui.OfficeInvBaseFragmentActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(OfficeInviteExternalContactActivity.class.getName()));
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

    public OfficeInviteExternalContactActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r2);
        if (OfficeContactUtils.g(this) == false) goto L20;
        int r3 = InviteExternalContactV2Fragment.n;
        Bundle r4 = getIntent().getExtras();
        InviteExternalContactV2Fragment r0 = new InviteExternalContactV2Fragment();
        r0.setArguments(r4);
        d.a(this, r0);
        String r5 = getIntent().getStringExtra("from_scenes");
        if (r5 != null) goto L16;
        r5 = BuildConfig.FLAVOR;
    L16:
        this.a = r5;
        return;
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r1, r2, r3);
        if (r1 == 10086) goto L5;
        return;
    L5:
        if (r2 != (-1)) goto L7;
        Log.i("Contact_InviteExternal", "onActivityResult country code");
        return;
    L7:
        boolean r4 = a1.f;
        a1.a.a.a.sendEmptyMessage(2131361935);
    }
}
