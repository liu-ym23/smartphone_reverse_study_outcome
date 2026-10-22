package com.bytedance.ai.bridge.method.calendar.remote;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ai/bridge/method/calendar/remote/CalDavResponse$HrefRelation", "", "Lcom/bytedance/ai/bridge/method/calendar/remote/CalDavResponse$HrefRelation;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CalDavResponse$HrefRelation extends Enum<CalDavResponse$HrefRelation> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CalDavResponse$HrefRelation f1810a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CalDavResponse$HrefRelation f1811b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CalDavResponse$HrefRelation f1812c = null;
    public static final /* synthetic */ CalDavResponse$HrefRelation[] d = null;

    static {
        CalDavResponse$HrefRelation r5 = new CalDavResponse$HrefRelation("SELF", 0);
        f1810a = r5;
        CalDavResponse$HrefRelation r10 = new CalDavResponse$HrefRelation("MEMBER", 1);
        f1811b = r10;
        CalDavResponse$HrefRelation r11 = new CalDavResponse$HrefRelation("OTHER", 2);
        f1812c = r11;
        CalDavResponse$HrefRelation[] r12 = {r5, r10, r11};
        d = r12;
        EnumEntriesKt.enumEntries(r12);
    }

    public CalDavResponse$HrefRelation(String r5, int r10) {
        super(r5, r10);
    }

    public static CalDavResponse$HrefRelation valueOf(String r5) {
        return (CalDavResponse$HrefRelation) Enum.valueOf(CalDavResponse$HrefRelation.class, r5);
    }

    public static CalDavResponse$HrefRelation[] values() {
        return (CalDavResponse$HrefRelation[]) d.clone();
    }
}
