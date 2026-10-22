package p59;

import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.nl.n;
import com.larus.dora.impl.nl.permission.CategoryWhenNotGranted;
import com.larus.dora.impl.nl.permission.ProactivePermission;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import com.larus.dora.impl.util.b0;
import com.larus.permission.api.IPermissionX;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CategoryWhenNotGranted.values().length];
            r0[CategoryWhenNotGranted.NEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CategoryWhenNotGranted.LOOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CategoryWhenNotGranted.INTERRUPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: p59.b$b, reason: collision with other inner class name */
    public static final class C0136b implements IPermissionX.c {
        public final /* synthetic */ Fragment a;
        public final /* synthetic */ List<ProactivePermission> b;
        public final /* synthetic */ CategoryWhenNotGranted c;
        public final /* synthetic */ int d;
        public final /* synthetic */ List<ProactivePermission> e;
        public final /* synthetic */ List<ProactivePermission> f;
        public final /* synthetic */ Function3<Boolean, List<? extends ProactivePermission>, List<? extends ProactivePermission>, Unit> g;

        public final void onSettingPageReturn() {
            StringBuilder r0 = new StringBuilder("checkPermission: ");
            ProactivePermission r10 = ProactivePermission.NOTIFICATION_LISTENER;
            r0.append(r10);
            r0.append(" onSettingPageReturn");
            g49.d.d("ProactivePermissionX", r0.toString());
            boolean r9 = n.d();
            int r1 = b.a;
            b.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, r9, r10);
        }

        public final void b(String r2) {
            g49.d.d("ProactivePermissionX", "checkPermission: " + ProactivePermission.NOTIFICATION_LISTENER + " onGoSettingsDialogShow");
        }

        public final void a(boolean r11, String r12) {
            StringBuilder r13 = new StringBuilder("checkPermission: ");
            ProactivePermission r9 = ProactivePermission.NOTIFICATION_LISTENER;
            r13.append(r9);
            r13.append(" onGoSettingsDialogDismiss: isConfirmed=");
            r13.append(r11);
            g49.d.d("ProactivePermissionX", r13.toString());
            if (r11 == true) goto L6;
            int r14 = b.a;
            b.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, false, r9);
            return;
        }

        public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "grantedList");
            Intrinsics.checkNotNullParameter(r3, "deniedList");
            g49.d.d("ProactivePermissionX", "checkPermission: " + ProactivePermission.NOTIFICATION_LISTENER + " allGranted=" + r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0136b(Fragment r1, List<? extends ProactivePermission> r2, CategoryWhenNotGranted r3, int r4, List<ProactivePermission> r5, List<ProactivePermission> r6, Function3<? super Boolean, ? super List<? extends ProactivePermission>, ? super List<? extends ProactivePermission>, Unit> r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public static final class c implements g1.c {
        public final /* synthetic */ Fragment a;
        public final /* synthetic */ List<ProactivePermission> b;
        public final /* synthetic */ CategoryWhenNotGranted c;
        public final /* synthetic */ int d;
        public final /* synthetic */ List<ProactivePermission> e;
        public final /* synthetic */ List<ProactivePermission> f;
        public final /* synthetic */ Function3<Boolean, List<? extends ProactivePermission>, List<? extends ProactivePermission>, Unit> g;

        public final void onGoSettingsDialogShow() {
            g49.d.d("ProactivePermissionX", "checkPermission: " + ProactivePermission.POST_NOTIFICATION + " onGoSettingsDialogShow");
        }

        public final void onSettingPageReturn() {
            g49.d.d("ProactivePermissionX", "checkPermission: " + ProactivePermission.POST_NOTIFICATION + " onSettingPageReturn");
            int r0 = b.a;
            a(b.d());
        }

        public final void a(boolean r11) {
            int r0 = b.a;
            b.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, r11, ProactivePermission.POST_NOTIFICATION);
        }

        public final void onGoSettingsDialogDismiss(boolean r3) {
            g49.d.d("ProactivePermissionX", "checkPermission: " + ProactivePermission.POST_NOTIFICATION + " onGoSettingsDialogDismiss: isConfirmed=" + r3);
            if (r3 == true) goto L6;
            a(false);
            return;
        }

        public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            Intrinsics.checkNotNullParameter(r4, "deniedList");
            if (r5 == false) goto L5;
            return;
        L5:
            g49.d.d("ProactivePermissionX", "checkPermission: " + ProactivePermission.POST_NOTIFICATION + " allGranted=" + r2);
            a(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Fragment r1, List<? extends ProactivePermission> r2, CategoryWhenNotGranted r3, int r4, List<ProactivePermission> r5, List<ProactivePermission> r6, Function3<? super Boolean, ? super List<? extends ProactivePermission>, ? super List<? extends ProactivePermission>, Unit> r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    static {
    }

    public b() {
    }

    public static boolean d() {
        if (Build.VERSION.SDK_INT < 33) goto L9;
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.POST_NOTIFICATIONS") != 0) goto L7;
        return true;
    L7:
        return false;
    L9:
        return NotificationManagerCompat.from(AppHost.a.getApplication()).areNotificationsEnabled();
    }

    public static boolean e(DoraOnboardingBaseFragment r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "permissions");
        boolean r0 = true;
        if (r3.contains(ProactivePermission.POST_NOTIFICATION) == false) goto L5;
        boolean r4 = d();
    L7:
        if (r3.contains(ProactivePermission.NOTIFICATION_LISTENER) == false) goto L15;
        if (r4 == true) goto L10;
    L12:
        r0 = false;
    L14:
        return r0;
    L10:
        if (n.d() == false) goto L12;
    L15:
        return r4;
    L5:
        r4 = true;
        goto L7
    }

    public static void c(Fragment r8, List r9, CategoryWhenNotGranted r10, Function3 r11) {
        Intrinsics.checkNotNullParameter(r8, "fragment");
        Intrinsics.checkNotNullParameter(r9, "permissions");
        Intrinsics.checkNotNullParameter(r10, "category");
        Intrinsics.checkNotNullParameter(r11, "onResult");
        b(r8, r9, r10, 0, new ArrayList(), new ArrayList(), r11);
    }

    public static void b(Fragment r13, List r14, CategoryWhenNotGranted r15, int r16, List r17, List r18, Function3 r110) {
        g49.d.d("ProactivePermissionX", "checkPermission: start loopCheck=" + r16 + ", loopCount=" + r16);
        ProactivePermission r9 = ProactivePermission.POST_NOTIFICATION;
        if (r14.contains(r9) == false) goto L17;
        boolean r0 = d();
        g49.d.d("ProactivePermissionX", "checkPermission: " + r9 + " isGranted=" + r0);
        if (r0 == true) goto L16;
        c r12 = new c(r13, r14, r15, r16, r17, r18, r110);
        g49.d.d("ProactivePermissionX", "checkPermission: " + r9 + " requestPermission");
        b0.a.getClass();
        b0.F();
        if (Build.VERSION.SDK_INT < 33) goto L9;
        List r1 = CollectionsKt.mutableListOf(new String[]{"android.permission.POST_NOTIFICATIONS"});
        i2 r2 = i2.b;
        g1.a.a(r13, r1, r12, null, null, 24);
        return;
    L9:
        FragmentActivity r3 = r13.getContext();
        if ((r3 instanceof FragmentActivity) == false) goto L12;
        FragmentActivity r4 = r3;
    L13:
        if (r4 == null) goto L33;
        i2.b.l(r4, "android.permission.POST_NOTIFICATIONS", null, r12);
        return;
    L33:
        return;
    L12:
        r4 = null;
        goto L13
    L16:
        r17.add(r9);
    L17:
        ProactivePermission r5 = ProactivePermission.NOTIFICATION_LISTENER;
        if (r14.contains(r5) == false) goto L30;
        boolean r6 = n.d();
        g49.d.d("ProactivePermissionX", "checkPermission: " + r5 + " isGranted=" + r6);
        if (r6 == true) goto L29;
        b0.a.getClass();
        b0.F();
        C0136b r10 = new C0136b(r13, r14, r15, r16, r17, r18, r110);
        if (r13.isStateSaved() == false) goto L24;
        g49.d.d("ProactivePermissionX", "fragment is state saved");
        return;
    L24:
        Context r7 = r13.getContext();
        if (r7 == null) goto L35;
        r10.b(null);
        CommonDialog.a r8 = new CommonDialog.a();
        r8.i(r7.getString(2131902205));
        r8.g(r7.getString(2131902200));
        r8.z = false;
        CommonDialog.a.f(r8, new p59.c(r10, r7, r13), r7.getString(2131903063), false, 12);
        CommonDialog.a.e(r8, new d(r10), r7.getString(2131902465), 4);
        r8.a().T90(r13.getParentFragmentManager(), null);
        return;
    L35:
        return;
    L29:
        r17.add(r5);
    L30:
        boolean r11 = r18.isEmpty();
        g49.d.d("ProactivePermissionX", "checkPermission: all permission checked, allGranted=" + r11 + ", grantedPermissions=" + r17 + ", deniedPermissions=" + r18);
        r110.invoke(Boolean.valueOf(r11), r17, r18);
    }

    public static final void a(Fragment r10, List r11, CategoryWhenNotGranted r12, int r13, List r14, List r15, Function3 r16, boolean r17, ProactivePermission r18) {
        if (r17 == false) goto L14;
        ArrayList r6 = new ArrayList();
        Iterator r3 = r11.iterator();
    L6:
        if (r3.hasNext() == false) goto L13;
        Object r7 = r3.next();
        if (((ProactivePermission) r7) == r18) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == false) goto L6;
        r6.add(r7);
        goto L6
    L10:
        r8 = false;
        goto L11
    L13:
        r14.add(r18);
        Unit r0 = Unit.INSTANCE;
        b(r10, r6, r12, r13 + 1, r14, r15, r16);
        return;
    L14:
        int r4 = a.a[r12.ordinal()];
        if (r4 != 1) goto L17;
        ArrayList r9 = new ArrayList();
        Iterator r5 = r11.iterator();
    L26:
        if (r5.hasNext() == false) goto L33;
        Object r20 = r5.next();
        if (((ProactivePermission) r20) == r18) goto L30;
        boolean r21 = true;
    L31:
        if (r21 == false) goto L26;
        r9.add(r20);
        goto L26
    L30:
        r21 = false;
        goto L31
    L33:
        r15.add(r18);
        Unit r1 = Unit.INSTANCE;
        b(r10, r9, r12, r13 + 1, r14, r15, r16);
        return;
    L17:
        if (r4 != 2) goto L19;
        b(r10, r11, r12, r13 + 1, r14, r15, r16);
        return;
    L19:
        if (r4 != 3) goto L22;
        Boolean r2 = Boolean.FALSE;
        r15.add(r18);
        Unit r22 = Unit.INSTANCE;
        r16.invoke(r2, r14, r15);
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    }
}
