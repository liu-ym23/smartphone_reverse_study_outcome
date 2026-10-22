package com.bytedance.android.live.revlink.link.core.service;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "v", "invoke", "(Ljava/lang/Object;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 5, 1})
final class AnchorDynamicLayoutImpl$printList$1 extends Lambda implements Function1<Object, CharSequence> {
    public static final AnchorDynamicLayoutImpl$printList$1 INSTANCE = null;

    static {
        INSTANCE = new AnchorDynamicLayoutImpl$printList$1();
    }

    public AnchorDynamicLayoutImpl$printList$1() {
        super(1);
    }

    public final CharSequence invoke(Object r3) {
        StringBuilder r0 = new StringBuilder("Value: ");
        if (r3 == null) goto L5;
        String r4 = r3.toString();
    L6:
        r0.append(r4);
        return r0.toString();
    L5:
        r4 = null;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m927invoke(Object r1) {
        return invoke(r1);
    }
}
