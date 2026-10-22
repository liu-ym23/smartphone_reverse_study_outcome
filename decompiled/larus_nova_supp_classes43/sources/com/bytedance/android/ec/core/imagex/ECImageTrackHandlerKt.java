package com.bytedance.android.ec.core.imagex;

import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECImageTrackHandlerKt {
    public static final void a(u r10, ImageRequest r11, Function1<? super f, Unit> r12) {
        if (r11 == null) goto L5;
        int r13 = r11.hashCode();
    L6:
        String r14 = String.valueOf(r13);
        f r1 = (f) r10.y.get(r14);
        if (r1 != null) goto L9;
        r1 = new f(0);
        r10.y.put(r14, r1);
        Unit r15 = Unit.INSTANCE;
    L9:
        r12.invoke(r1);
        return;
    L5:
        r13 = 0;
        goto L6
    }

    public static final void b(u r10, ImageRequest r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$recordRequestEnd");
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.d.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        Object r0 = null;
        if (r12 == null) goto L8;
        Object r1 = r12.opt(com.bytedance.android.ec.core.event.a.KEY_DURATION);
    L10:
        if ((r1 instanceof Number) == true) goto L12;
        r1 = null;
    L12:
        Number r13 = (Number) r1;
        final long r14 = -1;
        if (r13 == null) goto L15;
        final long r15 = r13.longValue();
    L16:
        if (r12 == null) goto L18;
        Object r16 = r12.opt("timestamp");
    L20:
        if ((r16 instanceof Number) == false) goto L23;
        r0 = r16;
    L23:
        Number r17 = (Number) r0;
        if (r17 == null) goto L27;
        r14 = r17.longValue();
    L27:
        if (r14 >= 0) goto L29;
        return;
    L29:
        if (r15 < 0) goto L33;
        a(r10, r11, new ECImageTrackHandlerKt$recordRequestEnd$1(r15, r14));
        return;
    L33:
        return;
    L18:
        r16 = null;
        goto L20
    L15:
        r15 = -1;
        goto L16
    L8:
        r1 = null;
        goto L10
    }
}
