package com.bytedance.android.live.screenrotate.rotate;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.screenrotation.rotate.RotateInnerRequest;
import com.bytedance.android.live.room.api.screenrotation.rotate.e;
import com.bytedance.android.live.room.api.screenrotation.rotate.f;
import com.bytedance.android.live.room.api.screenrotation.rotate.g;
import io.reactivex.subjects.PublishSubject;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements e {
    public static final PublishSubject<RotateInnerRequest<?>> a = null;
    public static final PublishSubject b = null;
    public static final d c = null;

    public d() {
    }

    static {
        c = new d();
        PublishSubject<RotateInnerRequest<?>> r0 = PublishSubject.create();
        a = r0;
        b = r0;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.e
    public final PublishSubject a() {
        return b;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.e
    public final void b(f r6, Function1<? super g<Object>, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "orientation");
        Intrinsics.checkNotNullParameter(r6, "orientation");
        g r1 = new g();
        if (r7 == null) goto L5;
        Unit r8 = (Unit) r7.invoke(r1);
    L5:
        RotateInnerRequest r9 = new RotateInnerRequest(String.valueOf(System.currentTimeMillis()), r6, r1);
        SimpleAlogArgsBuilder r10 = new SimpleAlogArgsBuilder();
        r10.d("ScreenRotation");
        r10.c("request rotate");
        int r3 = 0;
        Pair[] r2 = {TuplesKt.to("orientation", r9.e), TuplesKt.to("rotateType", r9.b), TuplesKt.to("source", r9.a), TuplesKt.to("payload", r9.c)};
    L6:
        if (r3 >= 4) goto L13;
        Pair r0 = r2[r3];
        if (r0 == null) goto L12;
        Object r4 = r0.getSecond();
        if (r4 == null) goto L12;
        r10.a((String) r0.getFirst(), r4);
    L12:
        r3 = r3 + 1;
        goto L6
    L13:
        f81.a.a(r10.b());
        a.onNext(r9);
    }
}
