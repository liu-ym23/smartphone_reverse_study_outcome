package com.larus.camera.impl.starter;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final a a = null;

    /* JADX INFO: renamed from: com.larus.camera.impl.starter.a$a, reason: collision with other inner class name */
    public static final class C0079a implements g1.c {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        public final void onGoSettingsDialogDismiss(boolean r1) {
        }

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0079a(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "grantedList");
            Intrinsics.checkNotNullParameter(r3, "deniedList");
            FLogger.a.i("CameraChecker", "checkRecordPermission, result:" + r1);
            this.a.invoke(Boolean.valueOf(r1));
        }
    }

    public static final class b implements g1.c {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Function1<Boolean, Unit> b;

        public final void onGoSettingsDialogShow() {
            if (this.a == false) goto L6;
            FLogger.a.i("CameraChecker", "scan camera permission settings dialog show");
            return;
        }

        public final void onSettingPageReturn() {
            if (this.a == false) goto L6;
            FLogger.a.i("CameraChecker", "scan camera permission settings page return");
            return;
        }

        public final void onGoSettingsDialogDismiss(boolean r4) {
            if (this.a == false) goto L6;
            FLogger.a.i("CameraChecker", "scan camera permission settings dialog dismiss, isConfirmed:" + r4);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(boolean r1, Function1<? super Boolean, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onResult(boolean r5, List<String> r6, List<String> r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r6, "grantedList");
            Intrinsics.checkNotNullParameter(r7, "deniedList");
            if (this.a == false) goto L5;
            FLogger.a.i("CameraChecker", "scan camera permission result, allGranted:" + r5 + ", grantedList:" + r6 + ", deniedList:" + r7 + ", isGoSettingsDialogShown:" + r8);
        L6:
            this.b.invoke(Boolean.valueOf(r5));
            return;
        L5:
            FLogger.a.i("CameraChecker", "checkRecordPermission, result:" + r5);
            goto L6
        }
    }

    static {
        a = new a();
    }

    public a() {
    }

    public static boolean c() {
        return d(new String[]{"android.permission.CAMERA"});
    }

    public static boolean d(String[] r5) {
        Intrinsics.checkNotNullParameter(r5, "permissions");
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        String r3 = r5[r2];
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), r3) != 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static void a(FragmentActivity r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r8, "requestCallBack");
        List r2 = CollectionsKt.mutableListOf(new String[]{"android.permission.RECORD_AUDIO"});
        i2 r0 = i2.b;
        C0079a r3 = new C0079a(r8);
        JSONObject r5 = new JSONObject();
        r5.put("enter_method", "camera");
        Unit r9 = Unit.INSTANCE;
        g1.a.b(r7, r2, r3, null, r5, 40);
    }

    public static void b(FragmentActivity r7, String r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "enterMethod");
        Intrinsics.checkNotNullParameter(r9, "requestCallBack");
        List r2 = CollectionsKt.mutableListOf(new String[]{"android.permission.CAMERA"});
        boolean r0 = Intrinsics.areEqual(r8, "scan");
        if (r0 == false) goto L5;
        FLogger.a.i("CameraChecker", "scan camera permission request start, hasPermission:" + c());
    L5:
        i2 r1 = i2.b;
        b r3 = new b(r0, r9);
        JSONObject r5 = new JSONObject();
        r5.put("enter_method", r8);
        Unit r10 = Unit.INSTANCE;
        g1.a.b(r7, r2, r3, null, r5, 40);
    }
}
