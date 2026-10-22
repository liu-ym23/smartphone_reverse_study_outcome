package com.obric.assistant.omnidetailpage.blockview;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k extends BaseControllerListener<Object> {
    public final /* synthetic */ j a;
    public final /* synthetic */ ifa.c.b b;

    public k(j r1, ifa.c.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r10, Throwable r11) {
        ifa.c.b r12 = this.a.k;
        if (r12 == null) goto L5;
        String r13 = r12.a;
    L7:
        if (Intrinsics.areEqual(r13, this.b.a) == false) goto L19;
        ifa.c.b r14 = this.a.k;
        if (r14 == null) goto L11;
        String r15 = r14.c;
    L13:
        if (Intrinsics.areEqual(r15, this.b.c) == false) goto L20;
        j r16 = this.a;
        ifa.c.b r0 = this.b;
        Job r1 = r16.m;
        if (r1 == null) goto L17;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L17:
        r16.m = BuildersKt.launch$default(r16.d, null, null, new LocalMediaViewHolder$loadExtractedFirstFrame$1(r16, r0, null), 3, null);
        return;
    L20:
        return;
    L11:
        r15 = null;
        goto L13
    L19:
        return;
    L5:
        r13 = null;
        goto L7
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ifa.c.b r4 = this.a.k;
        String r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.a;
    L7:
        if (Intrinsics.areEqual(r6, this.b.a) == false) goto L15;
        ifa.c.b r7 = this.a.k;
        if (r7 == null) goto L12;
        r5 = r7.c;
    L12:
        if (Intrinsics.areEqual(r5, this.b.c) == false) goto L16;
        this.a.g.setVisibility(0);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
