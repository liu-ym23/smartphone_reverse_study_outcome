package com.bytedance.android.live.room.api.panel;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/room/api/panel/RemoveReason;", "", "", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "Destroy", "UnRegister", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RemoveReason extends Enum<RemoveReason> {
    public static final RemoveReason Destroy = null;
    public static final RemoveReason UnRegister = null;
    public static final /* synthetic */ RemoveReason[] a = null;
    private final String reason;

    static {
        RemoveReason r1 = new RemoveReason("Destroy", 0, "Destroy");
        Destroy = r1;
        RemoveReason r2 = new RemoveReason("UnRegister", 1, "UnRegister");
        UnRegister = r2;
        a = new RemoveReason[]{r1, r2};
    }

    public static RemoveReason valueOf(String r1) {
        return (RemoveReason) r27.a.a(RemoveReason.class, r1);
    }

    public static RemoveReason[] values() {
        return (RemoveReason[]) a.clone();
    }

    public final String getReason() {
        return this.reason;
    }

    public RemoveReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.reason = r3;
    }
}
