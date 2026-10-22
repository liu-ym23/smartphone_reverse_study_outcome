package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/BitableDocumentType;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "into", "Llark_bitable/proto/BitableDocumentType;", "intoInt", "Main", "Record", "AddRecord", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum BitableDocumentType extends Enum<BitableDocumentType> {
    public static final BitableDocumentType AddRecord = null;
    public static final a Companion = null;
    public static final BitableDocumentType Main = null;
    public static final BitableDocumentType Record = null;
    public static final /* synthetic */ BitableDocumentType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BitableDocumentType.values().length];
            r0[BitableDocumentType.Main.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[BitableDocumentType.Record.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[BitableDocumentType.AddRecord.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static EnumEntries<BitableDocumentType> getEntries() {
        return b;
    }

    public static BitableDocumentType valueOf(String r1) {
        return (BitableDocumentType) r27.a.a(BitableDocumentType.class, r1);
    }

    public static BitableDocumentType[] values() {
        return (BitableDocumentType[]) a.clone();
    }

    static {
        BitableDocumentType r0 = new BitableDocumentType("Main", 0, 1);
        Main = r0;
        BitableDocumentType r1 = new BitableDocumentType("Record", 1, 2);
        Record = r1;
        BitableDocumentType r10 = new BitableDocumentType("AddRecord", 2, 3);
        AddRecord = r10;
        BitableDocumentType[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public final lark_bitable.proto.BitableDocumentType into() {
        int r0 = b.a[ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L10;
        return lark_bitable.proto.BitableDocumentType.VAR_BITABLE_DOCUMENT_TYPE_ADD_RECORD;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return lark_bitable.proto.BitableDocumentType.VAR_BITABLE_DOCUMENT_TYPE_RECORD;
    L13:
        return lark_bitable.proto.BitableDocumentType.VAR_BITABLE_DOCUMENT_TYPE_MAIN;
    }

    public final int intoInt() {
        int r0 = b.a[ordinal()];
        int r1 = 1;
        if (r0 == 1) goto L11;
        r1 = 2;
        if (r0 == 2) goto L11;
        r1 = 3;
        if (r0 == 3) goto L11;
        throw new NoWhenBranchMatchedException();
    L11:
        return r1;
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final BitableDocumentType fromInt(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L15;
        if (r1 != 3) goto L10;
        return AddRecord;
    L10:
        throw new RuntimeException("Unmatched primitive enum value: BitableDocumentType with ");
    L15:
        return Record;
    L13:
        return Main;
    }

    public BitableDocumentType(String r1, int r10, int r11) {
        super(r1, r10);
        this.value = r11;
    }
}
