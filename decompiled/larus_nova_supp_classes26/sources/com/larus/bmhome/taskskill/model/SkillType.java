package com.larus.bmhome.taskskill.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/taskskill/model/SkillType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "USER", "SYSTEM", "ENTERPRISE", "LOCAL", "STORE", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SkillType extends Enum<SkillType> {
    public static final a Companion = null;
    public static final SkillType ENTERPRISE = null;
    public static final SkillType LOCAL = null;
    public static final SkillType STORE = null;
    public static final SkillType SYSTEM = null;
    public static final SkillType USER = null;
    public static final /* synthetic */ SkillType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static SkillType a(int r6) {
            SkillType[] r0 = SkillType.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            SkillType r4 = r0[r3];
            if (r4.getValue() != r6) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 == null) goto L14;
            return r4;
        L14:
            return SkillType.SYSTEM;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }
    }

    public static EnumEntries<SkillType> getEntries() {
        return b;
    }

    static {
        SkillType r0 = new SkillType("USER", 0, 1);
        USER = r0;
        SkillType r1 = new SkillType("SYSTEM", 1, 2);
        SYSTEM = r1;
        SkillType r4 = new SkillType("ENTERPRISE", 2, 3);
        ENTERPRISE = r4;
        SkillType r6 = new SkillType("LOCAL", 3, 4);
        LOCAL = r6;
        SkillType r8 = new SkillType("STORE", 4, 5);
        STORE = r8;
        SkillType[] r10 = {r0, r1, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
        Companion = new a();
    }

    public static SkillType[] values() {
        return (SkillType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SkillType valueOf(String r1) {
        return (SkillType) r27.a.a(SkillType.class, r1);
    }

    public SkillType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
