package s1a;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.context.internal.VContextStore;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final Fragment c(ComponentFeature r1) throws Exception {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return com.larus.ui.arch.component.internal.attach.a.b(r1, r1);
    }

    public static final boolean d(ComponentFeature r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (q1a.a.a(r2, r2).getResources().getConfiguration().orientation != 2) goto L6;
        boolean r3 = true;
    L7:
        Object r4 = Result.constructor-impl(Boolean.valueOf(r3));     // Catch: Throwable -> L9
    L11:
        Boolean r1 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L15;
        r4 = r1;
    L15:
        return ((Boolean) r4).booleanValue();
    L6:
        r3 = false;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static final boolean e(ComponentFeature r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Bundle r3 = com.larus.ui.arch.component.internal.attach.a.b(r2, r2).getArguments();     // Catch: Throwable -> L10
        boolean r1 = false;
        if (r3 != null) goto L6;
    L8:
        Object r4 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L10
    L12:
        Boolean r5 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L16;
        r4 = r5;
    L16:
        return ((Boolean) r4).booleanValue();
    L6:
        if (r3.getBoolean("O_WINDOW_CHAT") != true) goto L8;
        r1 = true;
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static final t1a.b g(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        FragmentManager r0 = r5.getFragmentManager();
        if (x1a.a.a == false) goto L5;
    L13:
        if (r0 != null) goto L19;
        x1a.b r6 = x1a.a.c;
        if (r6 == null) goto L18;
        r6.ensureNotReachHere(new IllegalStateException("Fragment is detached from Activity or not added to Activity."), "VContextExt.kt");
    L18:
        return new t0();
    L19:
        boolean r1 = c.a;
        if (c.a == true) goto L23;
        VContextStore.Companion.getClass();
        return VContextStore.a.a(r5).getOrInit(h(r5.requireActivity()));
    L23:
        b r2 = b.a;
        monitor-enter(r2);
        Intrinsics.checkNotNullParameter(r5, "fragment");     // Catch: Throwable -> L34
        t1a.b r3 = b.b.get(r5);     // Catch: Throwable -> L34
        monitor-exit(r2);
        if (r3 == null) goto L29;
        return r3;
    L29:
        boolean r4 = r5.getRetainInstance();
        VContextStore.Companion.getClass();
        t1a.b r7 = VContextStore.a.a(r5).getOrInit(h(r5.requireActivity()));
        if (r4 == false) goto L33;
        return r7;
    L33:
        return r2.a(r5, r0, r7);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (r5.isDetached() == false) goto L13;
        x1a.b r8 = x1a.a.c;
        if (r8 == null) goto L9;
        r8.ensureNotReachHere(new IllegalStateException("Fragment is detached from Activity or not added to Activity."), "VContextExt.kt");
    L9:
        boolean r9 = c.a;
        if (c.a == true) goto L13;
        return new s0();
    }

    public static final FragmentActivity getActivity(ComponentFeature r1) throws Exception {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return q1a.a.a(r1, r1);
    }

    public static final t1a.b h(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        VContextStore.Companion.getClass();
        return VContextStore.getOrInit$default(VContextStore.a.a(r2), null, 1, null);
    }

    public static final void f(Fragment r1, Class<? extends t1a.a> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        g(r1).l(JvmClassMappingKt.getKotlinClass(r2));
    }

    public static final void a(Fragment r1, t1a.a r2, Class<? extends t1a.a> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "ability");
        Intrinsics.checkNotNullParameter(r3, "clazz");
        g(r1).k(r2, JvmClassMappingKt.getKotlinClass(r3));
    }

    public static final void b(FragmentActivity r1, t1a.a r2, Class<? extends t1a.a> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "ability");
        Intrinsics.checkNotNullParameter(r3, "clazz");
        h(r1).k(r2, JvmClassMappingKt.getKotlinClass(r3));
    }
}
