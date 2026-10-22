package com.larus.agents.api;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/agents/api/OfficeTaskPreferenceSaveResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "MAX_CHARACTER_LIMIT_EXCEEDED", "SECURITY_RISK", "FAILURE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum OfficeTaskPreferenceSaveResult extends Enum<OfficeTaskPreferenceSaveResult> {
    public static final OfficeTaskPreferenceSaveResult FAILURE = null;
    public static final OfficeTaskPreferenceSaveResult MAX_CHARACTER_LIMIT_EXCEEDED = null;
    public static final OfficeTaskPreferenceSaveResult SECURITY_RISK = null;
    public static final OfficeTaskPreferenceSaveResult SUCCESS = null;
    public static final /* synthetic */ OfficeTaskPreferenceSaveResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeTaskPreferenceSaveResult> getEntries() {
        return b;
    }

    static {
        OfficeTaskPreferenceSaveResult r0 = new OfficeTaskPreferenceSaveResult("SUCCESS", 0);
        SUCCESS = r0;
        OfficeTaskPreferenceSaveResult r1 = new OfficeTaskPreferenceSaveResult("MAX_CHARACTER_LIMIT_EXCEEDED", 1);
        MAX_CHARACTER_LIMIT_EXCEEDED = r1;
        OfficeTaskPreferenceSaveResult r3 = new OfficeTaskPreferenceSaveResult("SECURITY_RISK", 2);
        SECURITY_RISK = r3;
        OfficeTaskPreferenceSaveResult r5 = new OfficeTaskPreferenceSaveResult("FAILURE", 3);
        FAILURE = r5;
        OfficeTaskPreferenceSaveResult[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static OfficeTaskPreferenceSaveResult[] values() {
        return (OfficeTaskPreferenceSaveResult[]) a.clone();
    }

    public static OfficeTaskPreferenceSaveResult valueOf(String r1) {
        return (OfficeTaskPreferenceSaveResult) a.a(OfficeTaskPreferenceSaveResult.class, r1);
    }

    public OfficeTaskPreferenceSaveResult(String r1, int r2) {
        super(r1, r2);
    }
}
