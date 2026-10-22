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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/larus/business/arc/api/ArcRegion;", "", "<init>", "(Ljava/lang/String;I)V", "MAINLAND", "OVERSEA", "UNKNOWN", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ArcRegion extends Enum<ArcRegion> {
    public static final a Companion = null;

    @SerialName("mainland")
    public static final ArcRegion MAINLAND = null;

    @SerialName("oversea")
    public static final ArcRegion OVERSEA = null;

    @SerialName("unknown")
    public static final ArcRegion UNKNOWN = null;
    public static final Lazy<juc.d<Object>> a = null;
    public static final /* synthetic */ ArcRegion[] b = null;
    public static final /* synthetic */ EnumEntries c = null;

    public static final class a {
        public a() {
        }

        public final juc.d<ArcRegion> serializer() {
            return (juc.d) ArcRegion.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<ArcRegion> getEntries() {
        return c;
    }

    static {
        ArcRegion r0 = new ArcRegion("MAINLAND", 0);
        MAINLAND = r0;
        ArcRegion r1 = new ArcRegion("OVERSEA", 1);
        OVERSEA = r1;
        ArcRegion r3 = new ArcRegion("UNKNOWN", 2);
        UNKNOWN = r3;
        ArcRegion[] r5 = {r0, r1, r3};
        b = r5;
        c = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
        a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new r());
    }

    public static ArcRegion[] values() {
        return (ArcRegion[]) b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return a;
    }

    public static ArcRegion valueOf(String r1) {
        return (ArcRegion) r27.a.a(ArcRegion.class, r1);
    }

    public ArcRegion(String r1, int r2) {
        super(r1, r2);
    }
}
