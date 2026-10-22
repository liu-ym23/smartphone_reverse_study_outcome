package com.larus.dora.obric.onboarding;

import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class p {
    public final Fragment a;
    public final ObricDoraGOnboardingFragmentV2Binding b;
    public final ObricDoraGOnboardingViewModelV2 c;
    public final long d;
    public long e;
    public final long f;
    public boolean g;

    public static final class a {
    }

    static {
    }

    public p a() {
        return null;
    }

    public abstract void b();

    public void c(int r1, int r2) {
    }

    public boolean d() {
        return false;
    }

    public p e() {
        return null;
    }

    public p f() {
        return null;
    }

    public p(Fragment r4, ObricDoraGOnboardingFragmentV2Binding r5, ObricDoraGOnboardingViewModelV2 r6) {
        long r0 = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullParameter(r4, "fragment");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r0;
        this.f = 1500;
    }
}
