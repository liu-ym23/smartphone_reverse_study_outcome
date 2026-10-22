package com.bytedance.android.live.profit.format.voicechat.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/model/VoiceChatPrivilegeSource;", "", "", "type", "J", "getType", "()J", "GIFT", "VIP", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VoiceChatPrivilegeSource extends Enum<VoiceChatPrivilegeSource> {
    public static final VoiceChatPrivilegeSource GIFT = null;
    public static final VoiceChatPrivilegeSource VIP = null;
    public static final /* synthetic */ VoiceChatPrivilegeSource[] a = null;
    private final long type;

    static {
        VoiceChatPrivilegeSource r1 = new VoiceChatPrivilegeSource("GIFT", 0, 1);
        GIFT = r1;
        VoiceChatPrivilegeSource r2 = new VoiceChatPrivilegeSource("VIP", 1, 2);
        VIP = r2;
        a = new VoiceChatPrivilegeSource[]{r1, r2};
    }

    public static VoiceChatPrivilegeSource valueOf(String r1) {
        return (VoiceChatPrivilegeSource) r27.a.a(VoiceChatPrivilegeSource.class, r1);
    }

    public static VoiceChatPrivilegeSource[] values() {
        return (VoiceChatPrivilegeSource[]) a.clone();
    }

    public final long getType() {
        return this.type;
    }

    public VoiceChatPrivilegeSource(String r1, int r2, long r3) {
        super(r1, r2);
        this.type = r3;
    }
}
