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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/larus/business/arc/api/ArcBizStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "NOT_STARTED", "UNKNOWN", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ArcBizStatus extends Enum<ArcBizStatus> {
    public static final a Companion = null;

    @SerialName("failed")
    public static final ArcBizStatus FAILED = null;

    @SerialName("not_started")
    public static final ArcBizStatus NOT_STARTED = null;

    @SerialName("success")
    public static final ArcBizStatus SUCCESS = null;

    @SerialName("unknown")
    public static final ArcBizStatus UNKNOWN = null;
    public static final Lazy<juc.d<Object>> a = null;
    public static final /* synthetic */ ArcBizStatus[] b = null;
    public static final /* synthetic */ EnumEntries c = null;

    public static final class a {
        public a() {
        }

        public final juc.d<ArcBizStatus> serializer() {
            return (juc.d) ArcBizStatus.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<ArcBizStatus> getEntries() {
        return c;
    }

    static {
        ArcBizStatus r0 = new ArcBizStatus("SUCCESS", 0);
        SUCCESS = r0;
        ArcBizStatus r1 = new ArcBizStatus("FAILED", 1);
        FAILED = r1;
        ArcBizStatus r3 = new ArcBizStatus("NOT_STARTED", 2);
        NOT_STARTED = r3;
        ArcBizStatus r5 = new ArcBizStatus("UNKNOWN", 3);
        UNKNOWN = r5;
        ArcBizStatus[] r7 = {r0, r1, r3, r5};
        b = r7;
        c = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
        a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new f());
    }

    public static ArcBizStatus[] values() {
        return (ArcBizStatus[]) b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return a;
    }

    public static ArcBizStatus valueOf(String r1) {
        return (ArcBizStatus) r27.a.a(ArcBizStatus.class, r1);
    }

    public ArcBizStatus(String r1, int r2) {
        super(r1, r2);
    }
}
