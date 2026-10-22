package com.bytedance.ai.applet.granting;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/applet/granting/GrantStatus;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PENDING", "GRANTED", "DENIED", "REVOKED", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GrantStatus extends Enum<GrantStatus> {
    public static final a Companion = null;
    public static final GrantStatus DENIED = null;
    public static final GrantStatus GRANTED = null;
    public static final GrantStatus PENDING = null;
    public static final GrantStatus REVOKED = null;
    public static final /* synthetic */ GrantStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static GrantStatus a(Integer r10) {
            if (r10 != null) goto L5;
        L7:
            if (r10 != null) goto L10;
        L12:
            if (r10 != null) goto L15;
        L17:
            if (r10 == null) goto L23;
            if (r10.intValue() != 3) goto L23;
            return GrantStatus.REVOKED;
        L23:
            return GrantStatus.PENDING;
        L15:
            if (r10.intValue() != 2) goto L17;
            return GrantStatus.DENIED;
        L10:
            if (r10.intValue() != 1) goto L12;
            return GrantStatus.GRANTED;
        L5:
            if (r10.intValue() != 0) goto L7;
            return GrantStatus.PENDING;
        }
    }

    public static EnumEntries<GrantStatus> getEntries() {
        return b;
    }

    static {
        GrantStatus r0 = new GrantStatus("PENDING", 0, 0);
        PENDING = r0;
        GrantStatus r1 = new GrantStatus("GRANTED", 1, 1);
        GRANTED = r1;
        GrantStatus r10 = new GrantStatus("DENIED", 2, 2);
        DENIED = r10;
        GrantStatus r11 = new GrantStatus("REVOKED", 3, 3);
        REVOKED = r11;
        GrantStatus[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
        Companion = new a();
    }

    public static GrantStatus[] values() {
        return (GrantStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static GrantStatus valueOf(String r1) {
        return (GrantStatus) r27.a.a(GrantStatus.class, r1);
    }

    public GrantStatus(String r1, int r10, int r11) {
        super(r1, r10);
        this.value = r11;
    }
}
