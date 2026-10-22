package com.larus.bmhome.taskskill.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/taskskill/model/ExposureScopeType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CONVERSATION", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExposureScopeType extends Enum<ExposureScopeType> {
    public static final ExposureScopeType CONVERSATION = null;
    public static final /* synthetic */ ExposureScopeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ExposureScopeType> getEntries() {
        return b;
    }

    static {
        ExposureScopeType r0 = new ExposureScopeType();
        CONVERSATION = r0;
        ExposureScopeType[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public ExposureScopeType() {
        super("CONVERSATION", 0);
        this.value = 1;
    }

    public static ExposureScopeType[] values() {
        return (ExposureScopeType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ExposureScopeType valueOf(String r1) {
        return (ExposureScopeType) r27.a.a(ExposureScopeType.class, r1);
    }
}
