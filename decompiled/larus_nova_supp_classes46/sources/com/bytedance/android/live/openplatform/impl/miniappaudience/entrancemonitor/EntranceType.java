package com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/entrancemonitor/EntranceType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Shelf", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EntranceType extends Enum<EntranceType> {
    public static final EntranceType Shelf = null;
    public static final /* synthetic */ EntranceType[] a = null;
    private final String value;

    static {
        EntranceType r1 = new EntranceType();
        Shelf = r1;
        a = new EntranceType[]{r1};
    }

    public static EntranceType valueOf(String r1) {
        return (EntranceType) a.a(EntranceType.class, r1);
    }

    public static EntranceType[] values() {
        return (EntranceType[]) a.clone();
    }

    public EntranceType() {
        super("Shelf", 0);
        this.value = "shelf";
    }

    public final String getValue() {
        return this.value;
    }
}
