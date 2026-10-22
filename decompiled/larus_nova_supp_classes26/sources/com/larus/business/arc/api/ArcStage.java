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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/larus/business/arc/api/ArcStage;", "", "<init>", "(Ljava/lang/String;I)V", "PREPARE", "EXECUTE", "FINALIZE", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ArcStage extends Enum<ArcStage> {
    public static final a Companion = null;

    @SerialName("execute")
    public static final ArcStage EXECUTE = null;

    @SerialName("finalize")
    public static final ArcStage FINALIZE = null;

    @SerialName("prepare")
    public static final ArcStage PREPARE = null;
    public static final Lazy<juc.d<Object>> a = null;
    public static final /* synthetic */ ArcStage[] b = null;
    public static final /* synthetic */ EnumEntries c = null;

    public static final class a {
        public a() {
        }

        public final juc.d<ArcStage> serializer() {
            return (juc.d) ArcStage.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<ArcStage> getEntries() {
        return c;
    }

    static {
        ArcStage r0 = new ArcStage("PREPARE", 0);
        PREPARE = r0;
        ArcStage r1 = new ArcStage("EXECUTE", 1);
        EXECUTE = r1;
        ArcStage r3 = new ArcStage("FINALIZE", 2);
        FINALIZE = r3;
        ArcStage[] r5 = {r0, r1, r3};
        b = r5;
        c = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
        a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new w());
    }

    public static ArcStage[] values() {
        return (ArcStage[]) b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return a;
    }

    public static ArcStage valueOf(String r1) {
        return (ArcStage) r27.a.a(ArcStage.class, r1);
    }

    public ArcStage(String r1, int r2) {
        super(r1, r2);
    }
}
