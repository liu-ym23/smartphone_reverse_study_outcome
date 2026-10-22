package com.bytedance.android.ec.common.api.card;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/common/api/card/ExternalCardPriority;", "", "", a.KEY_LUBAN_VALUE, "I", "getValue", "()I", "EXPLAIN_CARD_HIGH_PRIORITY", "EXTERNAL_CARD_HIGH_PRIORITY", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ExternalCardPriority extends Enum<ExternalCardPriority> {
    public static final ExternalCardPriority EXPLAIN_CARD_HIGH_PRIORITY = null;
    public static final ExternalCardPriority EXTERNAL_CARD_HIGH_PRIORITY = null;
    public static final /* synthetic */ ExternalCardPriority[] a = null;
    private final int value;

    static {
        ExternalCardPriority r1 = new ExternalCardPriority("EXPLAIN_CARD_HIGH_PRIORITY", 0, 0);
        EXPLAIN_CARD_HIGH_PRIORITY = r1;
        ExternalCardPriority r10 = new ExternalCardPriority("EXTERNAL_CARD_HIGH_PRIORITY", 1, 1);
        EXTERNAL_CARD_HIGH_PRIORITY = r10;
        a = new ExternalCardPriority[]{r1, r10};
    }

    public static ExternalCardPriority valueOf(String r1) {
        return (ExternalCardPriority) r27.a.a(ExternalCardPriority.class, r1);
    }

    public static ExternalCardPriority[] values() {
        return (ExternalCardPriority[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ExternalCardPriority(String r1, int r10, int r11) {
        super(r1, r10);
        this.value = r11;
    }
}
