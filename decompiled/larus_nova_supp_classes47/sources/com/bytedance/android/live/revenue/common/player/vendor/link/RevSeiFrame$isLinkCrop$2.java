package com.bytedance.android.live.revenue.common.player.vendor.link;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$isLinkCrop$2 extends FunctionReferenceImpl implements Function0<Boolean> {
    public RevSeiFrame$isLinkCrop$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseIsLinkCrop", "parseIsLinkCrop()Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m382invoke() {
        RevSeiFrame r0 = (RevSeiFrame) ((CallableReference) this).receiver;
        Lazy r1 = RevSeiFrame.D;
        if (r0.r() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m382invoke());
    }
}
