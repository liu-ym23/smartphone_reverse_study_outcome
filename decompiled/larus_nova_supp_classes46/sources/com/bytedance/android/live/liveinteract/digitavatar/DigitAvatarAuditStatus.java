package com.bytedance.android.live.liveinteract.digitavatar;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/DigitAvatarAuditStatus;", "", "", "statusValue", "I", "getStatusValue", "()I", "PASS", "NOT_PASS", "AUDITING", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DigitAvatarAuditStatus extends Enum<DigitAvatarAuditStatus> {
    public static final DigitAvatarAuditStatus AUDITING = null;
    public static final DigitAvatarAuditStatus NOT_PASS = null;
    public static final DigitAvatarAuditStatus PASS = null;
    public static final /* synthetic */ DigitAvatarAuditStatus[] a = null;
    private final int statusValue;

    static {
        DigitAvatarAuditStatus r2 = new DigitAvatarAuditStatus("PASS", 0, 2);
        PASS = r2;
        DigitAvatarAuditStatus r3 = new DigitAvatarAuditStatus("NOT_PASS", 1, 3);
        NOT_PASS = r3;
        DigitAvatarAuditStatus r0 = new DigitAvatarAuditStatus("AUDITING", 2, 1);
        AUDITING = r0;
        a = new DigitAvatarAuditStatus[]{r2, r3, r0};
    }

    public static DigitAvatarAuditStatus valueOf(String r1) {
        return (DigitAvatarAuditStatus) r27.a.a(DigitAvatarAuditStatus.class, r1);
    }

    public static DigitAvatarAuditStatus[] values() {
        return (DigitAvatarAuditStatus[]) a.clone();
    }

    public final int getStatusValue() {
        return this.statusValue;
    }

    public DigitAvatarAuditStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.statusValue = r3;
    }
}
