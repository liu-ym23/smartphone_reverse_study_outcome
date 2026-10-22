package com.bytedance.android.ec.core.imagex.opt;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class NetImagePreloader$reportEvent$alias$2 extends Lambda implements Function1<String, CharSequence> {
    public static final NetImagePreloader$reportEvent$alias$2 INSTANCE = null;

    static {
        INSTANCE = new NetImagePreloader$reportEvent$alias$2();
    }

    public NetImagePreloader$reportEvent$alias$2() {
        super(1);
    }

    public final CharSequence invoke(String r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        return "(" + r10 + ')';
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
