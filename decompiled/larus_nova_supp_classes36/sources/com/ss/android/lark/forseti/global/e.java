package com.ss.android.lark.forseti.global;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.forseti.chain.ForsetiChainFragment;
import com.ss.android.lark.forseti.chain.s;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public final FragmentActivity a;
    public final ForsetiAttachInfo b;
    public final ForsetiChainFragment.b c;
    public final ForsetiColumnsDraggingHelper d;
    public final ForsetiActivityChainManager.b e;
    public final com.ss.android.lark.api.bean.config.a f;
    public final s g;
    public final ForsetiChainFragment h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        ForsetiChainFragment.b r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ForsetiColumnsDraggingHelper r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.e.hashCode()) * 31;
        com.ss.android.lark.api.bean.config.a r8 = this.f;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((((r7 + r2) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ForsetiContext(activity=" + this.a + ", attachInfo=" + this.b + ", triggerAnimation=" + this.c + ", draggingHelper=" + this.d + ", forsetiStructureNotifier=" + this.e + ", forsetiChainConfig=" + this.f + ", chainAdapter=" + this.g + ", forsetiChainFragment=" + this.h + ')';
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public e(FragmentActivity r2, ForsetiAttachInfo r3, ForsetiChainFragment.b r4, ForsetiColumnsDraggingHelper r5, ForsetiActivityChainManager.b r6, com.ss.android.lark.api.bean.config.a r7, s r8, ForsetiChainFragment r9) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "attachInfo");
        Intrinsics.checkNotNullParameter(r6, "forsetiStructureNotifier");
        Intrinsics.checkNotNullParameter(r8, "chainAdapter");
        Intrinsics.checkNotNullParameter(r9, "forsetiChainFragment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
