package com.larus.bmhome.taskskill.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/taskskill/model/ExposedSkillSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RECORDED", "FILLED_FROM_DEFAULT", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExposedSkillSource extends Enum<ExposedSkillSource> {
    public static final a Companion = null;
    public static final ExposedSkillSource FILLED_FROM_DEFAULT = null;
    public static final ExposedSkillSource RECORDED = null;
    public static final /* synthetic */ ExposedSkillSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ExposedSkillSource> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.taskskill.model.ExposedSkillSource$a] */
    static {
        ExposedSkillSource r0 = new ExposedSkillSource("RECORDED", 0, 1);
        RECORDED = r0;
        ExposedSkillSource r1 = new ExposedSkillSource("FILLED_FROM_DEFAULT", 1, 2);
        FILLED_FROM_DEFAULT = r1;
        ExposedSkillSource[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
        Companion = new a();
    }

    public static ExposedSkillSource[] values() {
        return (ExposedSkillSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ExposedSkillSource valueOf(String r1) {
        return (ExposedSkillSource) r27.a.a(ExposedSkillSource.class, r1);
    }

    public ExposedSkillSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
