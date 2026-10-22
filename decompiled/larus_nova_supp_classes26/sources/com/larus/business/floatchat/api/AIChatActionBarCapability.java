package com.larus.business.floatchat.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/business/floatchat/api/AIChatActionBarCapability;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN_CAMERA", "MUSIC_GENERATION", "IMAGE_GENERATION", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AIChatActionBarCapability extends Enum<AIChatActionBarCapability> {
    public static final AIChatActionBarCapability IMAGE_GENERATION = null;
    public static final AIChatActionBarCapability MUSIC_GENERATION = null;
    public static final AIChatActionBarCapability OPEN_CAMERA = null;
    public static final /* synthetic */ AIChatActionBarCapability[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AIChatActionBarCapability> getEntries() {
        return b;
    }

    static {
        AIChatActionBarCapability r0 = new AIChatActionBarCapability("OPEN_CAMERA", 0);
        OPEN_CAMERA = r0;
        AIChatActionBarCapability r1 = new AIChatActionBarCapability("MUSIC_GENERATION", 1);
        MUSIC_GENERATION = r1;
        AIChatActionBarCapability r3 = new AIChatActionBarCapability("IMAGE_GENERATION", 2);
        IMAGE_GENERATION = r3;
        AIChatActionBarCapability[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AIChatActionBarCapability[] values() {
        return (AIChatActionBarCapability[]) a.clone();
    }

    public static AIChatActionBarCapability valueOf(String r1) {
        return (AIChatActionBarCapability) a.a(AIChatActionBarCapability.class, r1);
    }

    public AIChatActionBarCapability(String r1, int r2) {
        super(r1, r2);
    }
}
