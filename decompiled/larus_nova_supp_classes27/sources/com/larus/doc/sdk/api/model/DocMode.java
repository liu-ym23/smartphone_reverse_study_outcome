package com.larus.doc.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/doc/sdk/api/model/DocMode;", "", "<init>", "(Ljava/lang/String;I)V", "READ_ONLY", "NORMAL_EDIT", "AI_EDIT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocMode extends Enum<DocMode> {
    public static final DocMode AI_EDIT = null;
    public static final DocMode NORMAL_EDIT = null;
    public static final DocMode READ_ONLY = null;
    public static final /* synthetic */ DocMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DocMode> getEntries() {
        return b;
    }

    static {
        DocMode r0 = new DocMode("READ_ONLY", 0);
        READ_ONLY = r0;
        DocMode r1 = new DocMode("NORMAL_EDIT", 1);
        NORMAL_EDIT = r1;
        DocMode r3 = new DocMode("AI_EDIT", 2);
        AI_EDIT = r3;
        DocMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DocMode[] values() {
        return (DocMode[]) a.clone();
    }

    public static DocMode valueOf(String r1) {
        return (DocMode) a.a(DocMode.class, r1);
    }

    public DocMode(String r1, int r2) {
        super(r1, r2);
    }
}
