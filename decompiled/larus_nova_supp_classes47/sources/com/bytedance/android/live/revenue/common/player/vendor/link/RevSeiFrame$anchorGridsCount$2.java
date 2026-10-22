package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.android.live.revlink.impl.multianchor.model.WindowType;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import z41.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$anchorGridsCount$2 extends FunctionReferenceImpl implements Function0<Integer> {
    public RevSeiFrame$anchorGridsCount$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseAnchorGridsCount", "parseAnchorGridsCount()I", 0);
    }

    public final int invoke() {
        RevSeiFrame r0 = (RevSeiFrame) ((CallableReference) this).receiver;
        Lazy r1 = RevSeiFrame.D;
        if (r0.h() == true) goto L5;
    L20:
        Integer r2 = r0.n();
        if (r2 != null) goto L24;
    L26:
        p0 r3 = r0.b();
        if (r3 == null) goto L41;
        List r4 = r3.e();
        if (r4 != null) goto L31;
        return 0;
    L31:
        return r4.size();
    L41:
        return 0;
    L24:
        if (r2.intValue() != 2) goto L26;
        return 2;
    L5:
        if (g.o.b() == false) goto L20;
        p0 r5 = r0.b();
        if (r5 == null) goto L37;
        List r6 = r5.h();
        if (r6 == null) goto L38;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L12:
        if (r8.hasNext() == false) goto L39;
        Object r9 = r8.next();
        if (((RevSeiRegion) r9).getWindowType() != WindowType.Anchor.ordinal()) goto L16;
        boolean r10 = true;
    L17:
        if (r10 == false) goto L12;
        r7.add(r9);
        goto L12
    L16:
        r10 = false;
        goto L17
    L39:
        return r7.size();
    L38:
        return 0;
    L37:
        return 0;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m365invoke() {
        return Integer.valueOf(invoke());
    }
}
