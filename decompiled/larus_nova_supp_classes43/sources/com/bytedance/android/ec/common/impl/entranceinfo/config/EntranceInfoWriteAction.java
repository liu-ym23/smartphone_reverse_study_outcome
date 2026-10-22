package com.bytedance.android.ec.common.impl.entranceinfo.config;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/common/impl/entranceinfo/config/EntranceInfoWriteAction;", "", "", a.KEY_LUBAN_VALUE, "I", "getValue", "()I", "PUT", "REMOVE", "CHANGE", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EntranceInfoWriteAction extends Enum<EntranceInfoWriteAction> {
    public static final EntranceInfoWriteAction CHANGE = null;
    public static final EntranceInfoWriteAction PUT = null;
    public static final EntranceInfoWriteAction REMOVE = null;
    public static final /* synthetic */ EntranceInfoWriteAction[] a = null;
    private final int value;

    static {
        EntranceInfoWriteAction r10 = new EntranceInfoWriteAction("PUT", 0, 1);
        PUT = r10;
        EntranceInfoWriteAction r11 = new EntranceInfoWriteAction("REMOVE", 1, 2);
        REMOVE = r11;
        EntranceInfoWriteAction r12 = new EntranceInfoWriteAction("CHANGE", 2, 3);
        CHANGE = r12;
        a = new EntranceInfoWriteAction[]{r10, r11, r12};
    }

    public static EntranceInfoWriteAction valueOf(String r1) {
        return (EntranceInfoWriteAction) r27.a.a(EntranceInfoWriteAction.class, r1);
    }

    public static EntranceInfoWriteAction[] values() {
        return (EntranceInfoWriteAction[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public EntranceInfoWriteAction(String r1, int r10, int r11) {
        super(r1, r10);
        this.value = r11;
    }
}
