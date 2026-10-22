package com.bytedance.android.live.revenue.common.player.vendor.link;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$layoutTypeIndex$2 extends FunctionReferenceImpl implements Function0<Integer> {
    public RevSeiFrame$layoutTypeIndex$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseLayoutTypeIndex", "parseLayoutTypeIndex()I", 0);
    }

    public final int invoke() {
        return StringsKt.indexOf$default(((RevSeiFrame) ((CallableReference) this).receiver).C, "layout_type", 0, false, 6, null);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m385invoke() {
        return Integer.valueOf(invoke());
    }
}
