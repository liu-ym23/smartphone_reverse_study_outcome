package com.bytedance.android.live.liveinteract.voicechat.match.logger;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/match/logger/JumpType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CLICK", "WAITING_TIMEOUT", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum JumpType extends Enum<JumpType> {
    public static final JumpType CLICK = null;
    public static final JumpType WAITING_TIMEOUT = null;
    public static final /* synthetic */ JumpType[] a = null;
    private final String value;

    static {
        JumpType r1 = new JumpType("CLICK", 0, "click");
        CLICK = r1;
        JumpType r2 = new JumpType("WAITING_TIMEOUT", 1, "waiting_timeout");
        WAITING_TIMEOUT = r2;
        a = new JumpType[]{r1, r2};
    }

    public static JumpType valueOf(String r1) {
        return (JumpType) a.a(JumpType.class, r1);
    }

    public static JumpType[] values() {
        return (JumpType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public JumpType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
