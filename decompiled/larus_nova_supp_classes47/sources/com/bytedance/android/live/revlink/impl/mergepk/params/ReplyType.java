package com.bytedance.android.live.revlink.impl.mergepk.params;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/params/ReplyType;", "", "Undefined", "Accept", "Reject", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ReplyType extends Enum<ReplyType> {
    public static final ReplyType Accept = null;
    public static final ReplyType Reject = null;
    public static final ReplyType Undefined = null;
    public static final /* synthetic */ ReplyType[] a = null;

    static {
        ReplyType r1 = new ReplyType("Undefined", 0);
        Undefined = r1;
        ReplyType r2 = new ReplyType("Accept", 1);
        Accept = r2;
        ReplyType r3 = new ReplyType("Reject", 2);
        Reject = r3;
        a = new ReplyType[]{r1, r2, r3};
    }

    public static ReplyType valueOf(String r1) {
        return (ReplyType) a.a(ReplyType.class, r1);
    }

    public static ReplyType[] values() {
        return (ReplyType[]) a.clone();
    }

    public ReplyType(String r1, int r2) {
        super(r1, r2);
    }
}
