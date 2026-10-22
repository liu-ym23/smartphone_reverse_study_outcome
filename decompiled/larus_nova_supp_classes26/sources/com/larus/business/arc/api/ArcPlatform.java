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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/larus/business/arc/api/ArcPlatform;", "", "<init>", "(Ljava/lang/String;I)V", "ANDROID", "HARMONY", "IOS", "UNKNOWN", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ArcPlatform extends Enum<ArcPlatform> {

    @SerialName("android")
    public static final ArcPlatform ANDROID = null;
    public static final a Companion = null;

    @SerialName("harmony")
    public static final ArcPlatform HARMONY = null;

    @SerialName("ios")
    public static final ArcPlatform IOS = null;

    @SerialName("unknown")
    public static final ArcPlatform UNKNOWN = null;
    public static final Lazy<juc.d<Object>> a = null;
    public static final /* synthetic */ ArcPlatform[] b = null;
    public static final /* synthetic */ EnumEntries c = null;

    public static final class a {
        public a() {
        }

        public final juc.d<ArcPlatform> serializer() {
            return (juc.d) ArcPlatform.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<ArcPlatform> getEntries() {
        return c;
    }

    static {
        ArcPlatform r0 = new ArcPlatform("ANDROID", 0);
        ANDROID = r0;
        ArcPlatform r1 = new ArcPlatform("HARMONY", 1);
        HARMONY = r1;
        ArcPlatform r3 = new ArcPlatform("IOS", 2);
        IOS = r3;
        ArcPlatform r5 = new ArcPlatform("UNKNOWN", 3);
        UNKNOWN = r5;
        ArcPlatform[] r7 = {r0, r1, r3, r5};
        b = r7;
        c = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
        a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new q());
    }

    public static ArcPlatform[] values() {
        return (ArcPlatform[]) b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return a;
    }

    public static ArcPlatform valueOf(String r1) {
        return (ArcPlatform) r27.a.a(ArcPlatform.class, r1);
    }

    public ArcPlatform(String r1, int r2) {
        super(r1, r2);
    }
}
