package com.bytedance.android.live.revenue.common.player.vendor.link;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$isGameLink$2 extends FunctionReferenceImpl implements Function0<Boolean> {
    public RevSeiFrame$isGameLink$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseIfIsGameLink", "parseIfIsGameLink()Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m380invoke() {
        RevSeiFrame r0 = (RevSeiFrame) ((CallableReference) this).receiver;
        if (StringsKt.contains$default(r0.C, "multi_view_data", false, 2, null) == true) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r0.C, "horizontal_grids", false, 2, null) == false) goto L11;
        d51.c r1 = d51.c.A0;
        r1.getClass();
        if (((Boolean) d51.c.o.getValue(r1, d51.c.a[13])).booleanValue() == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m380invoke());
    }
}
