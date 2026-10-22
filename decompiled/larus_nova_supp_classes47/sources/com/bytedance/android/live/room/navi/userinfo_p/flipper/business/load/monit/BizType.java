package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/BizType;", "", "", "value", "J", "getValue", "()J", "ANCHOR_BIZ_PANEL", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BizType extends Enum<BizType> {
    public static final BizType ANCHOR_BIZ_PANEL = null;
    public static final /* synthetic */ BizType[] a = null;
    private final long value;

    static {
        BizType r1 = new BizType();
        ANCHOR_BIZ_PANEL = r1;
        a = new BizType[]{r1};
    }

    public static BizType valueOf(String r1) {
        return (BizType) r27.a.a(BizType.class, r1);
    }

    public static BizType[] values() {
        return (BizType[]) a.clone();
    }

    public BizType() {
        super("ANCHOR_BIZ_PANEL", 0);
        this.value = 1;
    }

    public final long getValue() {
        return this.value;
    }
}
