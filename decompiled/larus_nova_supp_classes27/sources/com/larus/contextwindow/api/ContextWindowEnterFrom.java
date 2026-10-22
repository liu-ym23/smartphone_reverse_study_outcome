package com.larus.contextwindow.api;

import com.larus.doc.sdk.api.VoiceInputFrom;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowEnterFrom;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "ACTION_BAR", "NATIVE", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContextWindowEnterFrom extends Enum<ContextWindowEnterFrom> {
    public static final ContextWindowEnterFrom ACTION_BAR = null;
    public static final ContextWindowEnterFrom NATIVE = null;
    public static final ContextWindowEnterFrom UNKNOWN = null;
    public static final /* synthetic */ ContextWindowEnterFrom[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String wireValue;

    public static EnumEntries<ContextWindowEnterFrom> getEntries() {
        return b;
    }

    static {
        ContextWindowEnterFrom r0 = new ContextWindowEnterFrom("ACTION_BAR", 0, VoiceInputFrom.ACTION_BAR);
        ACTION_BAR = r0;
        ContextWindowEnterFrom r1 = new ContextWindowEnterFrom("NATIVE", 1, "native");
        NATIVE = r1;
        ContextWindowEnterFrom r2 = new ContextWindowEnterFrom("UNKNOWN", 2, "unknown");
        UNKNOWN = r2;
        ContextWindowEnterFrom[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static ContextWindowEnterFrom[] values() {
        return (ContextWindowEnterFrom[]) a.clone();
    }

    public final String getWireValue() {
        return this.wireValue;
    }

    public static ContextWindowEnterFrom valueOf(String r1) {
        return (ContextWindowEnterFrom) a.a(ContextWindowEnterFrom.class, r1);
    }

    public ContextWindowEnterFrom(String r1, int r2, String r3) {
        super(r1, r2);
        this.wireValue = r3;
    }
}
