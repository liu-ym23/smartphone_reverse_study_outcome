package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements l {
    public final MmSubtitleScrollMode a;
    public final List<h> b;
    public final boolean c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmSubtitleVMState(scrollMode=" + this.a + ", subtitleList=" + this.b + ", isSubtitleDegraded=" + this.c + ')';
    }

    public /* synthetic */ a(int r3) {
        this(MmSubtitleScrollMode.FOLLOW, CollectionsKt.emptyList(), false);
    }

    public a(MmSubtitleScrollMode r2, List<h> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "scrollMode");
        Intrinsics.checkNotNullParameter(r3, "subtitleList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static a a(a r1, MmSubtitleScrollMode r2, List r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.b;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = r1.c;
    L11:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "scrollMode");
        Intrinsics.checkNotNullParameter(r3, "subtitleList");
        return new a(r2, r3, r4);
    }
}
