package ega;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.obric.assistant.settings.VoicePrintScene;
import com.obric.assistant.util.StartActivityForResultHelper;
import com.obric.audio.enroll.vm.EnrollViewModel;
import f06.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import t19.s;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final c a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[VoicePrintScene.values().length];
            r0[VoicePrintScene.VOICE_WAKE_UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[VoicePrintScene.VOICE_AUTHENTICATE_ON_LOCKED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[VoicePrintScene.NOISE_REDUCTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b implements g1.c {
        public final /* synthetic */ Function0<Unit> a;
        public final /* synthetic */ Function0<Unit> b;

        public final void onGoSettingsDialogDismiss(boolean r1) {
        }

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
        }

        public b(Function0<Unit> r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "grantedList");
            Intrinsics.checkNotNullParameter(r3, "deniedList");
            if (r1 == true) goto L5;
        L7:
            this.b.invoke();
            return;
        L5:
            if ((!r2.isEmpty()) == false) goto L7;
            this.a.invoke();
        }
    }

    static {
        a = new c();
    }

    public c() {
    }

    public static void a(Context r24, VoicePrintScene r25, Function0 r26, Function0 r27) {
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r25, "scene");
        Intrinsics.checkNotNullParameter(r26, "onPermissionGranted");
        Intrinsics.checkNotNullParameter(r27, "onPermissionDenied");
        if ((r24 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r5 = (FragmentActivity) r24;
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        Application r0 = AppHost.a.getApplication();
        ArrayList r3 = new ArrayList();
        String r13 = "android.permission.RECORD_AUDIO";
        Object[] r14 = {"android.permission.RECORD_AUDIO"};
        f06.b r12 = new f06.b("auto_cert_com_obric_assistant_settings_util_VoicePrintSettingHelper_android_app_Application_checkSelfPermission");
        g06.a r6 = (g06.a) ApiHookConfig.b.get(102608);
        if (r6 == null) goto L11;
        f06.a[] r7 = r6.i;
    L12:
        f06.a[] r11 = r7;
        int r10 = r11.length;
        int r9 = 0;
    L14:
        if (r9 >= r10) goto L21;
        f06.a r8 = r11[r9];
        int r19 = r9;
        int r20 = r10;
        f06.a[] r21 = r11;
        f06.b r22 = r12;
        String r23 = r13;
        d r15 = r8.preInvoke(102608, "android/app/Application", "checkSelfPermission", r0, r14, "int", r22);     // Catch: Exception -> L30
        if (r15.a == true) goto L23;
        r3.add(r8);     // Catch: Exception -> L30
    L23:
        if (r15.a == false) goto L25;
        int r1 = ((Integer) r15.b).intValue();
        String r4 = r23;
    L26:
        if (r1 != 0) goto L28;
        r26.invoke();
        return;
    L28:
        i2 r2 = i2.b;
        g1.a.b(r5, CollectionsKt.mutableListOf(new String[]{r4}), new b(r26, r27), null, null, 56);
        return;
    L25:
        r4 = r23;
        r1 = r0.checkSelfPermission(r4);
    L20:
        r9 = r19 + 1;
        r10 = r20;
        r11 = r21;
        r12 = r22;
        r13 = r23;
        goto L14
    L21:
        r23 = r13;
        r15 = new d(false, null);
        goto L23
    L11:
        r7 = ApiHookConfig.d;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    public static void b(Context r6, VoicePrintScene r7, final Function0 r8, Function0 r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "scene");
        Intrinsics.checkNotNullParameter(r8, "onActivityResult");
        Intrinsics.checkNotNullParameter(r9, "onFailed");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        boolean r1 = h.a;     // Catch: Throwable -> L16
        boolean r2 = h.a(null);     // Catch: Throwable -> L16
        Intent r3 = new Intent("com.obric.sva.sdk.ACTION_START_ENROLL");     // Catch: Throwable -> L16
        r3.setClassName(r6.getPackageName(), "com.obric.audio.enroll.ui.VoicePrintEnrollActivity");     // Catch: Throwable -> L16
        r3.putExtra("IS_DARK_MODE", r2);     // Catch: Throwable -> L16
        int r10 = a.a[r7.ordinal()];     // Catch: Throwable -> L16
        if (r10 != 1) goto L6;
        String r11 = EnrollViewModel.VOICE_WAKEUP;
    L14:
        r3.putExtra("start_from", r11);     // Catch: Throwable -> L16
        StartActivityForResultHelper.a.startActivityForResult(r3, new ega.b(r8), null);     // Catch: Throwable -> L16
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L19:
        if (Result.exceptionOrNull-impl(r12) == null) goto L23;
        s.j(s.a, r6, r6.getString(2131912709), null, false, 28);
        r9.invoke();
        return;
    L23:
        return;
    L6:
        if (r10 != 2) goto L8;
        r11 = EnrollViewModel.VOICE_AUTHORIZATION;
        goto L14
    L8:
        if (r10 != 3) goto L11;
        r11 = EnrollViewModel.NOISE_REDUCTION;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
