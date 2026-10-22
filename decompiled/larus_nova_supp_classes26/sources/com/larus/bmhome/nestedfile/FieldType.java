package com.larus.bmhome.nestedfile;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/nestedfile/FieldType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATE_UNKNOWN", "REVIEW_STATE", "PARSE_STATE", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FieldType extends Enum<FieldType> {
    public static final a Companion = null;
    public static final FieldType PARSE_STATE = null;
    public static final FieldType REVIEW_STATE = null;
    public static final FieldType STATE_UNKNOWN = null;
    public static final /* synthetic */ FieldType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static FieldType a(Integer r7) {
            FieldType[] r0 = FieldType.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L14;
            FieldType r4 = r0[r3];
            int r5 = r4.getValue();
            if (r7 != null) goto L8;
        L10:
            boolean r6 = false;
        L11:
            if (r6 == true) goto L15;
            r3 = r3 + 1;
        L15:
            if (r4 == null) goto L17;
            return r4;
        L17:
            return FieldType.STATE_UNKNOWN;
        L8:
            if (r5 != r7.intValue()) goto L10;
            r6 = true;
            goto L11
        L14:
            r4 = null;
            goto L15
        }
    }

    public static EnumEntries<FieldType> getEntries() {
        return b;
    }

    static {
        FieldType r0 = new FieldType("STATE_UNKNOWN", 0, 0);
        STATE_UNKNOWN = r0;
        FieldType r1 = new FieldType("REVIEW_STATE", 1, 1);
        REVIEW_STATE = r1;
        FieldType r3 = new FieldType("PARSE_STATE", 2, 2);
        PARSE_STATE = r3;
        FieldType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static FieldType[] values() {
        return (FieldType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FieldType valueOf(String r1) {
        return (FieldType) r27.a.a(FieldType.class, r1);
    }

    public FieldType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
