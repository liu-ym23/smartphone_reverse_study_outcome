package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d2<T, R> implements Function {
    public final /* synthetic */ t1.c a;

    public d2(t1.c r1) {
        this.a = r1;
    }

    public final Object apply(Object r7) {
        String r8 = (String) r7;
        Intrinsics.checkNotNullParameter(r8, "keyWord");
        long r0 = System.currentTimeMillis();
        t1.c r2 = this.a;
        Integer r4 = null;
        if (r2.r == false) goto L32;
        boolean r3 = false;
        r2.r = false;
        com.bytedance.android.livesdk.interactivity.api.h r5 = com.bytedance.android.livesdk.interactivity.api.q.g();
        if ((r5 instanceof InteractivityPlatformContext) == true) goto L7;
        r5 = null;
    L7:
        InteractivityPlatformContext r6 = (InteractivityPlatformContext) r5;
        if (r6 == null) goto L12;
        com.bytedance.live.datacontext.n<c32.c> r9 = r6.getWordAssociateResult();
        if (r9 == null) goto L12;
        c32.c r10 = (c32.c) r9.getValue();
    L13:
        if (r10 == null) goto L15;
        r3 = true;
    L15:
        if (r3 == false) goto L17;
        MainThreadPostUtils.b(new c2(this));
        return Observable.empty();
    L17:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r11 = this.a.b.V();
        if (r11 == null) goto L22;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r13 = r11.g;
        if (r13 == null) goto L22;
        r4 = Integer.valueOf(r13.i);
    L22:
        Iterator<T> r14 = this.a.m.iterator();
    L24:
        if (r14.hasNext() == false) goto L50;
        int r15 = ((Number) r14.next()).intValue();
        if (r4 == null) goto L24;
        if (r15 != r4.intValue()) goto L24;
        return Observable.empty();
    L50:
        return t1.c.g(this.a, r8, r0);
    L12:
        r10 = null;
        goto L13
    L32:
        com.bytedance.android.livesdk.interactivity.api.h r16 = com.bytedance.android.livesdk.interactivity.api.q.g();
        if ((r16 instanceof InteractivityPlatformContext) == true) goto L35;
        r16 = null;
    L35:
        InteractivityPlatformContext r17 = (InteractivityPlatformContext) r16;
        if (r17 == null) goto L41;
        com.bytedance.live.datacontext.n<c32.c> r18 = r17.getWordAssociateResult();
        if (r18 == null) goto L41;
        r18.setValue(null);
    L41:
        return t1.c.g(this.a, r8, r0);
    }
}
