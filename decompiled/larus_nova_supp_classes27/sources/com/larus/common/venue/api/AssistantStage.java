package com.larus.common.venue.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/common/venue/api/AssistantStage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Init", "Enter", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AssistantStage extends Enum<AssistantStage> {
    public static final AssistantStage Enter = null;
    public static final AssistantStage Init = null;
    public static final /* synthetic */ AssistantStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<AssistantStage> getEntries() {
        return b;
    }

    static {
        AssistantStage r0 = new AssistantStage("Init", 0, "init");
        Init = r0;
        AssistantStage r1 = new AssistantStage("Enter", 1, "enter");
        Enter = r1;
        AssistantStage[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static AssistantStage[] values() {
        return (AssistantStage[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AssistantStage valueOf(String r1) {
        return (AssistantStage) a.a(AssistantStage.class, r1);
    }

    public AssistantStage(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
