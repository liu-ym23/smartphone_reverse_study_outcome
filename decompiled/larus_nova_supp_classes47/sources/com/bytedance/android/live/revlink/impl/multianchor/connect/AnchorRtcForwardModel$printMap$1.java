package com.bytedance.android.live.revlink.impl.multianchor.connect;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010&\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "K", "V", "<name for destructuring parameter 0>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class AnchorRtcForwardModel$printMap$1 extends Lambda implements Function1<Map.Entry<Object, Object>, CharSequence> {
    public static final AnchorRtcForwardModel$printMap$1 INSTANCE = null;

    static {
        INSTANCE = new AnchorRtcForwardModel$printMap$1();
    }

    public AnchorRtcForwardModel$printMap$1() {
        super(1);
    }

    public final CharSequence invoke(Map.Entry<Object, Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "<name for destructuring parameter 0>");
        Object r0 = r4.getKey();
        Object r5 = r4.getValue();
        StringBuilder r1 = new StringBuilder("Key: ");
        String r2 = null;
        if (r0 == null) goto L5;
        String r3 = r0.toString();
    L6:
        r1.append(r3);
        r1.append(" | Value: ");
        if (r5 == null) goto L9;
        r2 = r5.toString();
    L9:
        r1.append(r2);
        return r1.toString();
    L5:
        r3 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Map.Entry) r1);
    }
}
