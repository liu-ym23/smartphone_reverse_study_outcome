package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationAecPolicy;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.h;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.j;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.l;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final Function0<Boolean> a;
    public final Function1<Boolean, Unit> b;
    public final Function1<Boolean, Unit> c;
    public final Function1<Integer, Unit> d;
    public final Function2<j, String, Boolean> e;
    public boolean f;
    public String g;
    public String h;
    public boolean i;
    public Integer j;
    public boolean k;

    public final boolean a(String r8) {
        if (this.f == true) goto L5;
        return false;
    L5:
        String r0 = this.g;
        if (r0 != null) goto L8;
        return false;
    L8:
        boolean r2 = this.k;
        this.b.invoke(Boolean.valueOf(r2));
        int r3 = l.a;
        Intrinsics.checkNotNullParameter(r0, "targetLanguage");
        if (StringsKt.isBlank(r0) == false) goto L11;
        j r4 = null;
    L12:
        if (r4 != null) goto L14;
        return false;
    L14:
        boolean r9 = ((Boolean) this.e.invoke(r4, r8)).booleanValue();
        if (r9 == false) goto L17;
        this.g = null;
    L17:
        return r9;
    L11:
        r4 = new j(true, CollectionsKt.listOf(r0), r2, MmAIInterpretationAecPolicy.TRANSCRIPT_ONLY);
        goto L12
    }

    public final boolean b(boolean r2) {
        int r0 = 0;
        if (r2 == true) goto L5;
    L19:
        return false;
    L5:
        if (this.f == false) goto L19;
        int r3 = h.a;
        if (this.k == false) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L18;
        r0 = 100;
    L18:
        return c(r0);
    L10:
        if (this.i == true) goto L13;
        r4 = false;
        goto L14
    }

    public final boolean c(int r2) {
        Integer r0 = this.j;
        if (r0 != null) goto L6;
    L9:
        this.j = Integer.valueOf(r2);
        this.d.invoke(Integer.valueOf(r2));
        return true;
    L6:
        if (r0.intValue() != r2) goto L9;
        return false;
    }

    public final d d(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        this.k = ((Boolean) this.a.invoke()).booleanValue();
        boolean r0 = true;
        if (r5 != null) goto L5;
    L7:
        r5 = null;
    L8:
        boolean r2 = false;
        if (r5 != null) goto L16;
        this.g = null;
        this.h = null;
        this.i = false;
        boolean r7 = this.k;
        this.b.invoke(Boolean.valueOf(r7));
        if (this.f == false) goto L15;
        int r8 = h.a;
        r2 = c(100);
    L15:
        return new d(r7, r2, this.i);
    L16:
        String r1 = this.h;
        if (r1 != null) goto L19;
    L21:
        this.g = r5;
        this.h = r5;
        boolean r9 = this.k;
        this.b.invoke(Boolean.valueOf(r9));
        boolean r10 = a(r6);
        boolean r3 = b(true);
        if (r10 == true) goto L27;
        if (r3 == true) goto L27;
        r0 = false;
    L27:
        return new d(r9, r0, this.i);
    L19:
        if (Intrinsics.areEqual(r1, r5) == true) goto L21;
        this.i = false;
        goto L21
    L5:
        if ((!StringsKt.isBlank(r5)) == false) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function0<Boolean> r2, Function1<? super Boolean, Unit> r3, Function1<? super Boolean, Unit> r4, Function1<? super Integer, Unit> r5, Function2<? super j, ? super String, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r2, "currentPlaybackMutedProvider");
        Intrinsics.checkNotNullParameter(r3, "updatePlaybackMutedState");
        Intrinsics.checkNotNullParameter(r4, "setPlaybackDigitalMute");
        Intrinsics.checkNotNullParameter(r5, "setPlaybackVolume");
        Intrinsics.checkNotNullParameter(r6, "applyRtcAction");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.k = ((Boolean) r2.invoke()).booleanValue();
    }
}
