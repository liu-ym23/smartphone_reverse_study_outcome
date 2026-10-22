package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/moa/MoaLoginPanelType;", "", "<init>", "(Ljava/lang/String;I)V", "PRIVACY", "LOGIN", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MoaLoginPanelType extends Enum<MoaLoginPanelType> {
    public static final MoaLoginPanelType LOGIN = null;
    public static final MoaLoginPanelType PRIVACY = null;
    public static final /* synthetic */ MoaLoginPanelType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MoaLoginPanelType> getEntries() {
        return b;
    }

    static {
        MoaLoginPanelType r0 = new MoaLoginPanelType("PRIVACY", 0);
        PRIVACY = r0;
        MoaLoginPanelType r1 = new MoaLoginPanelType("LOGIN", 1);
        LOGIN = r1;
        MoaLoginPanelType[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static MoaLoginPanelType[] values() {
        return (MoaLoginPanelType[]) a.clone();
    }

    public static MoaLoginPanelType valueOf(String r1) {
        return (MoaLoginPanelType) r27.a.a(MoaLoginPanelType.class, r1);
    }

    public MoaLoginPanelType(String r1, int r10) {
        super(r1, r10);
    }
}
