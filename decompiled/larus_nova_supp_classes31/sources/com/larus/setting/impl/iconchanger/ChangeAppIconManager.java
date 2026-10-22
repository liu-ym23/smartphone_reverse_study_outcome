package com.larus.setting.impl.iconchanger;

import android.content.Context;
import android.os.Build;
import android.util.Size;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.e0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.larus.common_ui.dialog.l1;
import com.larus.common_ui.dialog.p0;
import com.larus.home.api.main.AppIconsType;
import com.larus.home.api.main.HomeService;
import com.larus.image.loader.b0;
import com.larus.permission.api.IPermissionX;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import v19.c7;
import v19.q5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ChangeAppIconManager {
    public static WeakReference<CommonDialog> a;
    public static boolean b;
    public static final Set<Integer> c = null;
    public static boolean d;
    public static Job e;
    public static Job f;
    public static boolean g;

    public static final class a implements gp9.a {
        public a() {
        }

        public final void a() {
            WeakReference<CommonDialog> r0 = ChangeAppIconManager.a;
            ChangeAppIconManager.b = false;
        }
    }

    public static final class b implements q5 {
        public b() {
        }

        public final void gotoToSystemPage() {
            WeakReference<CommonDialog> r0 = ChangeAppIconManager.a;
            ChangeAppIconManager.b = false;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(u r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class d implements p0 {
        public final /* synthetic */ Function1<CommonDialog, Unit> a;
        public final /* synthetic */ Ref.ObjectRef<CommonDialog> b;

        public final void confirm() {
            Function1<CommonDialog, Unit> r0 = this.a;
            if (r0 == null) goto L6;
            r0.invoke(this.b.element);
            return;
        }

        public d(Function1<? super CommonDialog, Unit> r1, Ref.ObjectRef<CommonDialog> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements l1 {
        public final /* synthetic */ Function0<Unit> a;

        public final void a() {
            Function0<Unit> r0 = this.a;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        public e(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    static {
        b = true;
        c = new LinkedHashSet();
        d = true;
    }

    public static boolean a() {
        c1 r0 = (c1) AuthModelDelegate.b.c().getValue();
        if (r0 == null) goto L11;
        e0 r1 = (e0) r0.d;
        if (r1 == null) goto L11;
        List r2 = r1.p();
        if (r2 == null) goto L11;
        if (r2.size() != c.size()) goto L11;
        return true;
    L11:
        return false;
    }

    public static void b() {
        if (g == false) goto L5;
        return;
    L5:
        g = true;
        AccountService.a.E(new w());
        AppHost.Companion r0 = AppHost.a;
        r0.a().j(new ChangeAppIconManager$registerBackGroundListener$2());
        e = BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new ChangeAppIconManager$initActivityOnResumeListener$1(null), 3, null);
        if (z2.a.getBasicExperienceAnrOptConfig().a() == false) goto L8;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ChangeAppIconManager$initActivityOnResumeListener$2(null), 3, null);
    L9:
        r0.getApplication().registerActivityLifecycleCallbacks(new v());
        IPermissionX.a.g(new a());
        v19.a.a(new b());
        return;
    L8:
        c();
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.setting.impl.iconchanger.u] */
    public static void c() {
        Transformations.map(AuthModelDelegate.b.c(), new t()).observeForever(new c(new u()));
    }

    public static void f() {
        if (a() == false) goto L5;
        return;
    L5:
        boolean r0 = Fresco.hasBeenInitialized();
        FLogger.a.i("ChangeAppIconDynamicImgLoader", "preload frescoInitialized = " + r0);
        if (r0 == true) goto L8;
        return;
    L8:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ChangeAppIconManager$preload$1(null), 2, null);
    }

    public static void e(boolean r9) {
        Job r0 = f;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        f = BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new ChangeAppIconManager$postShowSyncDialog$1(r9, null), 3, null);
    }

    public static void h(final int r13) {
        HomeService r0 = HomeService.a;
        AppHost.Companion r1 = AppHost.a;
        Integer r2 = r0.H(r1.getApplication());
        if (r2 == null) goto L27;
        int r3 = r2.intValue();
        Integer r4 = (Integer) r0.s().get(Integer.valueOf(r13));
        FragmentActivity r5 = r1.a().getCurrentActivity();
        String r6 = null;
        if ((r5 instanceof FragmentActivity) == false) goto L7;
        final FragmentActivity r7 = r5;
    L8:
        FLogger r8 = FLogger.a;
        r8.i("ChangeAppIconDynamicImgLoader", "currentUseAppIconId=" + r3 + " shouldShowAppIconId=" + r13);
        if (r3 != r13) goto L11;
        return;
    L11:
        if (r4 == null) goto L28;
        String r9 = "res://" + r1.getApplication().getPackageName() + '/' + r4.intValue();
        if (Build.VERSION.SDK_INT < 29) goto L15;
        boolean r10 = true;
    L16:
        if (r10 == false) goto L29;
        r8.i("ChangeAppIconDynamicImgLoader", "currentUseAppIconId=" + r3 + " shouldShowAppIconId=" + r13 + " enableShowSyncDialog=" + d);
        if (d == true) goto L20;
        return;
    L20:
        d = false;
        if (r7 == null) goto L23;
        r6 = r7.getString(2131900713, new Object[]{r1.getAppStringName()});
    L23:
        if (r6 != null) goto L25;
        r6 = "";
    L25:
        g(r7, r6, r9, new r(), new s(r7, r13));
        return;
    L29:
        return;
    L15:
        r10 = false;
        goto L16
    L28:
        return;
    L7:
        r7 = null;
        goto L8
    }

    public static void d(Context r4, AppIconsType r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onAppBackground isBack = ");
        AppHost.Companion r2 = AppHost.a;
        r1.append(r2.a().isAppBackground());
        r0.i("ChangeAppIconDynamicImgLoader", r1.toString());
        if (r2.a().isAppBackground() == true) goto L5;
        return;
    L5:
        HomeService r3 = HomeService.a;
        Integer r6 = r3.H(r4);
        if (r6 == null) goto L16;
        int r7 = r6.intValue();
        et9.e.a().stopAudio();
        if (Build.VERSION.SDK_INT < 29) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == true) goto L13;
        return;
    L13:
        if (r7 == r5.getAppIconId()) goto L18;
        r3.w(r4, r5);
        return;
    L18:
        return;
    L10:
        r8 = false;
        goto L11
    }

    public static void g(FragmentActivity r7, String r8, String r9, Function0 r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r8, "title");
        if (r7 != null) goto L5;
        return;
    L5:
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        WeakReference<CommonDialog> r2 = a;     // Catch: Exception -> L18
        if (r2 == null) goto L16;
        CommonDialog r3 = r2.get();     // Catch: Exception -> L18
        if (r3 == null) goto L16;
        r3.dismiss();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Exception -> L18
        Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L18
        if (r4 == null) goto L16;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L18
    L16:
        CommonDialog.a r5 = new CommonDialog.a();     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(r8, "title");     // Catch: Exception -> L18
        r5.a = r8;     // Catch: Exception -> L18
        r5.c = Float.valueOf(c7.b(16));     // Catch: Exception -> L18
        r5.e = b0.a(r9, "change_app_icon", false, false, 6);     // Catch: Exception -> L18
        Size r12 = new Size(c7.b(80), c7.b(80));     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(r12, "size");     // Catch: Exception -> L18
        r5.f = r12;     // Catch: Exception -> L18
        r5.d = true;     // Catch: Exception -> L18
        f0 r13 = new f0(null, Integer.valueOf(ContextCompat.getColor(r7, 2131103203)), null, 5);     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(r13, "commonDialogTextStyleConfig");     // Catch: Exception -> L18
        r5.D = r13;     // Catch: Exception -> L18
        CommonDialog.a.f(r5, new d(r11, r1), r7.getString(2131900720), false, 12);     // Catch: Exception -> L18
        r5.w = true;     // Catch: Exception -> L18
        r5.b = false;     // Catch: Exception -> L18
        e r14 = new e(r10);     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(r14, "listener");     // Catch: Exception -> L18
        r5.v = r14;     // Catch: Exception -> L18
        CommonDialog r15 = r5.b(ContextCompat.getColor(r7, 2131103203));     // Catch: Exception -> L18
        r1.element = r15;     // Catch: Exception -> L18
        r15.T90(r7.getSupportFragmentManager(), null);     // Catch: Exception -> L18
        a = new WeakReference(r1.element);     // Catch: Exception -> L18
        return;
    }
}
