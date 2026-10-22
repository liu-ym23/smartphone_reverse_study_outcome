package com.obric.aikernel.res.update;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    public static final boolean a(UpdateResult r10, PackageUpdater.b r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "constriction");
        r10.setCaller(r11.b());
        if (r11.f() <= r10.getPrior()) goto L5;
        r10.setPrior(r11.f());
        boolean r12 = true;
    L7:
        if (r11.a() == true) goto L12;
        if (r10.getBackground() == false) goto L12;
        r10.setBackground(false);
        return true;
    L12:
        return r12;
    L5:
        r12 = false;
        goto L7
    }

    public static final String b(String r10, String r11, String r12, boolean r13, c r14) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "fileName");
        Intrinsics.checkNotNullParameter(r14, "state");
        StringBuilder r15 = new StringBuilder();
        r15.append("install: ");
        r15.append(r10);
        r15.append('-');
        r15.append(r11);
        r15.append(" prepareFiles ");
        r15.append(r12);
        r15.append(" by ");
        if (r13 == false) goto L5;
        String r16 = "mv";
    L6:
        r15.append(r16);
        r15.append(" sourceExists=");
        r15.append(r14.a());
        r15.append(" sourceIsDirectory=");
        r15.append(r14.b());
        r15.append(" targetExists=");
        r15.append(r14.c());
        r15.append(" targetTempExists=");
        r15.append(r14.d());
        return r15.toString();
    L5:
        r16 = "cp";
        goto L6
    }

    public static final boolean c(UpdateResult r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, TypedValues.CycleType.S_WAVE_PHASE);
        Intrinsics.checkNotNullParameter(r12, "reason");
        if (r10.getFinished() == true) goto L5;
    L8:
        r10.fail("update failed phase=" + r11 + " stage=" + r10.getStage() + ' ' + r12);
        com.obric.aikernel.runtime.utils.d.f5417a.f("PackageUpdater", "finishStageFailureIfNeeded force terminal failure phase=" + r11 + " reason=" + r12 + " result=" + PackageUpdaterKt.s(r10));
        return true;
    L5:
        if (r10.getSuccess() == true) goto L8;
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "finishStageFailureIfNeeded keep existing failure phase=" + r11 + " result=" + PackageUpdaterKt.s(r10));
        return false;
    }

    public static final boolean d(Collection<Pair<Boolean, Boolean>> r10) {
        Intrinsics.checkNotNullParameter(r10, "downloadStates");
        if (r10.isEmpty() == true) goto L14;
        Iterator<T> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L14;
        Pair r12 = (Pair) r11.next();
        boolean r13 = ((Boolean) r12.component1()).booleanValue();
        boolean r14 = ((Boolean) r12.component2()).booleanValue();
        if (r13 == false) goto L12;
        if (r14 == false) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == false) goto L7;
        return true;
    L12:
        r15 = false;
    L14:
        return false;
    }

    public static final c e(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "src");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        return new c(r10.exists(), r10.isDirectory(), r11.exists(), new File(r11.getPath() + "_temp").exists());
    }

    public static final boolean f(Throwable r10) {
        return r10 instanceof ApiTimeoutCancellationException;
    }

    public static final boolean g(boolean r10, boolean r11) {
        if (r10 == true) goto L5;
        if (r11 == true) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean h(Collection<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "failedTaskStates");
        if (r10.isEmpty() == true) goto L10;
        Iterator<T> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L10;
        if ((!com.obric.aikernel.res.downloader.b.b(((Number) r11.next()).intValue())) == false) goto L7;
        return true;
    L10:
        return false;
    }

    public static final boolean i(Throwable r10, int r11) {
        if ((r10 instanceof CancellationException) == false) goto L8;
        if (r11 == 0) goto L7;
        return false;
    L7:
        return !f(r10);
    L8:
        return false;
    }

    public static final boolean j(boolean r10, boolean r11) {
        if (r10 == true) goto L5;
        if (r11 == true) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean k(String r10) {
        Intrinsics.checkNotNullParameter(r10, "caller");
        if (Intrinsics.areEqual(r10, ":init") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r10, ":autoupdate") == true) goto L8;
        return false;
    }
}
