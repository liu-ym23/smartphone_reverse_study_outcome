package com.ss.android.lark.myai.export.model;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/myai/export/model/DataType;", "", "<init>", "(Ljava/lang/String;I)V", "STRING", "JSON_STRING", "MARKDOWN_STRING", "RAW", "myai-export-officesdk_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum DataType extends Enum<DataType> {
    public static final DataType JSON_STRING = null;
    public static final DataType MARKDOWN_STRING = null;
    public static final DataType RAW = null;
    public static final DataType STRING = null;
    public static final /* synthetic */ DataType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DataType> getEntries() {
        return b;
    }

    static {
        DataType r0 = new DataType("STRING", 0);
        STRING = r0;
        DataType r1 = new DataType("JSON_STRING", 1);
        JSON_STRING = r1;
        DataType r3 = new DataType("MARKDOWN_STRING", 2);
        MARKDOWN_STRING = r3;
        DataType r5 = new DataType("RAW", 3);
        RAW = r5;
        DataType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DataType[] values() {
        return (DataType[]) a.clone();
    }

    public static DataType valueOf(String r1) {
        return (DataType) a.a(DataType.class, r1);
    }

    public DataType(String r1, int r2) {
        super(r1, r2);
    }
}
