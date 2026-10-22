package com.larus.dora.impl.onboarding.g.v2;

import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class f {
    public final Fragment a;
    public final LarusDoraGOnboardingFragmentV2Binding b;
    public final DoraGOnboardingViewModelV2 c;
    public final long d;
    public Job e;
    public long f;
    public final long g;
    public boolean h;
    public boolean i;

    public static final class a {
    }

    static {
    }

    public f a() {
        return null;
    }

    public abstract void b();

    public f c() {
        return null;
    }

    public f d() {
        return null;
    }

    public void e(int r1, int r2) {
    }

    public boolean f() {
        return this instanceof m;
    }

    public f g() {
        return null;
    }

    public void h(boolean r1) {
    }

    public f(Fragment r4, LarusDoraGOnboardingFragmentV2Binding r5, DoraGOnboardingViewModelV2 r6) {
        long r0 = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullParameter(r4, "fragment");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r0;
        this.g = 1500;
    }
}
