package com.obric.assistant;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/DoraAuthTrustType;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SYSTEM_AUTHENTICATION", "VOICE_PRINT", "ALWAYS", "NOT_ALLOWED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraAuthTrustType extends Enum<DoraAuthTrustType> {
    public static final DoraAuthTrustType ALWAYS = null;
    public static final DoraAuthTrustType NOT_ALLOWED = null;
    public static final DoraAuthTrustType SYSTEM_AUTHENTICATION = null;
    public static final DoraAuthTrustType VOICE_PRINT = null;
    public static final /* synthetic */ DoraAuthTrustType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<DoraAuthTrustType> getEntries() {
        return b;
    }

    static {
        DoraAuthTrustType r0 = new DoraAuthTrustType("SYSTEM_AUTHENTICATION", 0, 0);
        SYSTEM_AUTHENTICATION = r0;
        DoraAuthTrustType r1 = new DoraAuthTrustType("VOICE_PRINT", 1, 1);
        VOICE_PRINT = r1;
        DoraAuthTrustType r3 = new DoraAuthTrustType("ALWAYS", 2, 2);
        ALWAYS = r3;
        DoraAuthTrustType r5 = new DoraAuthTrustType("NOT_ALLOWED", 3, 3);
        NOT_ALLOWED = r5;
        DoraAuthTrustType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DoraAuthTrustType[] values() {
        return (DoraAuthTrustType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DoraAuthTrustType valueOf(String r1) {
        return (DoraAuthTrustType) r27.a.a(DoraAuthTrustType.class, r1);
    }

    public DoraAuthTrustType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
