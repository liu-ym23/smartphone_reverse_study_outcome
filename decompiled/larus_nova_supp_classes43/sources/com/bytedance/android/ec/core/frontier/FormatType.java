package com.bytedance.android.ec.core.frontier;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/frontier/FormatType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "JSON", "PROTOBUF", "THRIFT", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FormatType extends Enum<FormatType> {
    public static final FormatType JSON = null;
    public static final FormatType PROTOBUF = null;
    public static final FormatType THRIFT = null;
    public static final /* synthetic */ FormatType[] a = null;
    private final String type;

    static {
        FormatType r1 = new FormatType("JSON", 0, "application/json");
        JSON = r1;
        FormatType r10 = new FormatType("PROTOBUF", 1, "application/vnd.google.protobuf");
        PROTOBUF = r10;
        FormatType r11 = new FormatType("THRIFT", 2, "thrift");
        THRIFT = r11;
        a = new FormatType[]{r1, r10, r11};
    }

    public static FormatType valueOf(String r1) {
        return (FormatType) r27.a.a(FormatType.class, r1);
    }

    public static FormatType[] values() {
        return (FormatType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public FormatType(String r1, int r10, String r11) {
        super(r1, r10);
        this.type = r11;
    }
}
