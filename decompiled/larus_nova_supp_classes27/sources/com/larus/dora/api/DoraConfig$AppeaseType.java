package com.larus.dora.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/api/DoraConfig$AppeaseType;", "", "type", "", "scene", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getType", "()I", "getScene", "()Ljava/lang/String;", "UNKNOW", "VOICE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraConfig$AppeaseType extends Enum<DoraConfig$AppeaseType> {
    public static final DoraConfig$AppeaseType UNKNOW = null;
    public static final DoraConfig$AppeaseType VOICE = null;
    public static final /* synthetic */ DoraConfig$AppeaseType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String scene;
    private final int type;

    public static EnumEntries<DoraConfig$AppeaseType> getEntries() {
        return b;
    }

    static {
        DoraConfig$AppeaseType r0 = new DoraConfig$AppeaseType("UNKNOW", 0, 0, "none");
        UNKNOW = r0;
        DoraConfig$AppeaseType r1 = new DoraConfig$AppeaseType("VOICE", 1, 1, "audio_comfort");
        VOICE = r1;
        DoraConfig$AppeaseType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static DoraConfig$AppeaseType[] values() {
        return (DoraConfig$AppeaseType[]) a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public final int getType() {
        return this.type;
    }

    public static DoraConfig$AppeaseType valueOf(String r1) {
        return (DoraConfig$AppeaseType) a.a(DoraConfig$AppeaseType.class, r1);
    }

    public DoraConfig$AppeaseType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.type = r3;
        this.scene = r4;
    }
}
