package com.larus.platform.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/LarkSocialImModuleState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_LOADED", "LOADING", "READY", "FAILED", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum LarkSocialImModuleState extends Enum<LarkSocialImModuleState> {
    public static final LarkSocialImModuleState FAILED = null;
    public static final LarkSocialImModuleState LOADING = null;
    public static final LarkSocialImModuleState NOT_LOADED = null;
    public static final LarkSocialImModuleState READY = null;
    public static final /* synthetic */ LarkSocialImModuleState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LarkSocialImModuleState> getEntries() {
        return b;
    }

    static {
        LarkSocialImModuleState r0 = new LarkSocialImModuleState("NOT_LOADED", 0);
        NOT_LOADED = r0;
        LarkSocialImModuleState r1 = new LarkSocialImModuleState("LOADING", 1);
        LOADING = r1;
        LarkSocialImModuleState r3 = new LarkSocialImModuleState("READY", 2);
        READY = r3;
        LarkSocialImModuleState r5 = new LarkSocialImModuleState("FAILED", 3);
        FAILED = r5;
        LarkSocialImModuleState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static LarkSocialImModuleState[] values() {
        return (LarkSocialImModuleState[]) a.clone();
    }

    public static LarkSocialImModuleState valueOf(String r1) {
        return (LarkSocialImModuleState) a.a(LarkSocialImModuleState.class, r1);
    }

    public LarkSocialImModuleState(String r1, int r2) {
        super(r1, r2);
    }
}
