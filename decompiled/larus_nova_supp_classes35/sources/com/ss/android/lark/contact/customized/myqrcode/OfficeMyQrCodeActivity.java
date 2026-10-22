package com.ss.android.lark.contact.customized.myqrcode;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.contact.base.common_ui.OfficeInvBaseFragmentActivity;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.externalinvite.OfficeInviteExternalActivity;
import com.ss.android.lark.contact.customized.myqrcode.view.OfficeMyQrCodeFragment;
import com.ss.android.lark.inv.export.util.c;
import com.ss.android.lark.inv.export.util.d;
import com.ss.android.lark.inv.export.util.e;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/contact/customized/myqrcode/OfficeMyQrCodeActivity;", "Lcom/ss/android/lark/contact/base/common_ui/OfficeInvBaseFragmentActivity;", "<init>", "()V", "finish", BuildConfig.FLAVOR, "onDestroy", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMyQrCodeActivity extends OfficeInvBaseFragmentActivity {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static void a(Context r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            HashMap r0 = c.a(new Pair[]{Pair.create("from_scenes", r5), Pair.create("IS_MY_QR", "true")});
            Intrinsics.checkNotNull(r0);
            if (r0.containsKey("IS_MY_QR") == true) goto L6;
            r0.put("IS_MY_QR", String.valueOf(Intrinsics.areEqual("my_qrcode", r0.get("scenes"))));
        L6:
            if (Boolean.parseBoolean((String) r0.get("IS_MY_QR")) == false) goto L12;
            Bundle r6 = new Bundle();
            Iterator r1 = r0.entrySet().iterator();
        L9:
            if (r1.hasNext() == false) goto L11;
            Map.Entry r2 = (Map.Entry) r1.next();
            r6.putString((String) r2.getKey(), (String) r2.getValue());
            goto L9
        L11:
            Intent r3 = new Intent(r4, OfficeMyQrCodeActivity.class);
            r3.putExtras(r6);
            r4.startActivity(r3);
            return;
        L12:
            int r7 = OfficeInviteExternalActivity.a;
            OfficeInviteExternalActivity.a.a(r4, (String) r0.get("from_scenes"));
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0107 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.contact.base.common_ui.OfficeInvBaseFragmentActivity
    public final void finish() {
        super.finish();
        e.a(this);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(OfficeMyQrCodeActivity.class.getName()));
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
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(Bridge.TRANSFER_MAX_SIZE);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.contact.base.common_ui.OfficeInvBaseFragmentActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(OfficeMyQrCodeActivity.class.getName()));
    L5:
        super.onDestroy();
        e.a(this);
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

    public OfficeMyQrCodeActivity() {
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
        if (OfficeContactUtils.g(this) == false) goto L17;
        Bundle r3 = getIntent().getExtras();
        OfficeMyQrCodeFragment r0 = new OfficeMyQrCodeFragment();
        r0.setArguments(r3);
        d.a(this, r0);
        return;
    }
}
