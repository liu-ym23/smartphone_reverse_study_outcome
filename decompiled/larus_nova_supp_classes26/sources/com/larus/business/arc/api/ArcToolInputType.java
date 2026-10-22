package com.larus.business.arc.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/business/arc/api/ArcToolInputType;", "", "<init>", "(Ljava/lang/String;I)V", "STRING", "BOOLEAN", "INTEGER", "NUMBER", "OBJECT", "ARRAY", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ArcToolInputType extends Enum<ArcToolInputType> {

    @SerialName("array")
    public static final ArcToolInputType ARRAY = null;

    @SerialName("boolean")
    public static final ArcToolInputType BOOLEAN = null;
    public static final a Companion = null;

    @SerialName("integer")
    public static final ArcToolInputType INTEGER = null;

    @SerialName("number")
    public static final ArcToolInputType NUMBER = null;

    @SerialName("object")
    public static final ArcToolInputType OBJECT = null;

    @SerialName("string")
    public static final ArcToolInputType STRING = null;
    public static final Lazy<juc.d<Object>> a = null;
    public static final /* synthetic */ ArcToolInputType[] b = null;
    public static final /* synthetic */ EnumEntries c = null;

    public static EnumEntries<ArcToolInputType> getEntries() {
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.business.arc.api.ArcToolInputType$a] */
    static {
        ArcToolInputType r0 = new ArcToolInputType("STRING", 0);
        STRING = r0;
        ArcToolInputType r1 = new ArcToolInputType("BOOLEAN", 1);
        BOOLEAN = r1;
        ArcToolInputType r3 = new ArcToolInputType("INTEGER", 2);
        INTEGER = r3;
        ArcToolInputType r5 = new ArcToolInputType("NUMBER", 3);
        NUMBER = r5;
        ArcToolInputType r7 = new ArcToolInputType("OBJECT", 4);
        OBJECT = r7;
        ArcToolInputType r9 = new ArcToolInputType("ARRAY", 5);
        ARRAY = r9;
        ArcToolInputType[] r11 = {r0, r1, r3, r5, r7, r9};
        b = r11;
        c = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
        a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new z());
    }

    public static ArcToolInputType[] values() {
        return (ArcToolInputType[]) b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return a;
    }

    public static ArcToolInputType valueOf(String r1) {
        return (ArcToolInputType) r27.a.a(ArcToolInputType.class, r1);
    }

    public ArcToolInputType(String r1, int r2) {
        super(r1, r2);
    }
}
