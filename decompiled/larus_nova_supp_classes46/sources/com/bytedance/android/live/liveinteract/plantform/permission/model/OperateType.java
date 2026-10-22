package com.bytedance.android.live.liveinteract.plantform.permission.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/permission/model/OperateType;", "", "", "opTypeStr", "Ljava/lang/String;", "getOpTypeStr", "()Ljava/lang/String;", "APPLY", "REPLY", "PRE_APPLY", "RESUME", "JOIN", "PRE_REPLY", "MIDI", "UniversalAnimForSaas", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum OperateType extends Enum<OperateType> {
    public static final OperateType APPLY = null;
    public static final OperateType JOIN = null;
    public static final OperateType MIDI = null;
    public static final OperateType PRE_APPLY = null;
    public static final OperateType PRE_REPLY = null;
    public static final OperateType REPLY = null;
    public static final OperateType RESUME = null;
    public static final OperateType UniversalAnimForSaas = null;
    public static final /* synthetic */ OperateType[] a = null;
    private final String opTypeStr;

    public static OperateType valueOf(String r1) {
        return (OperateType) a.a(OperateType.class, r1);
    }

    public static OperateType[] values() {
        return (OperateType[]) a.clone();
    }

    static {
        OperateType r1 = new OperateType("APPLY", 0, "apply");
        APPLY = r1;
        OperateType r2 = new OperateType("REPLY", 1, "replay");
        REPLY = r2;
        OperateType r3 = new OperateType("PRE_APPLY", 2, "pre_apply");
        PRE_APPLY = r3;
        OperateType r4 = new OperateType("RESUME", 3, "resume");
        RESUME = r4;
        OperateType r5 = new OperateType("JOIN", 4, "join");
        JOIN = r5;
        OperateType r6 = new OperateType("PRE_REPLY", 5, "pre_reply");
        PRE_REPLY = r6;
        OperateType r7 = new OperateType("MIDI", 6, "midi");
        MIDI = r7;
        OperateType r8 = new OperateType("UniversalAnimForSaas", 7, "universal_anim_for_saas");
        UniversalAnimForSaas = r8;
        a = new OperateType[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public final String getOpTypeStr() {
        return this.opTypeStr;
    }

    public OperateType(String r1, int r2, String r3) {
        super(r1, r2);
        this.opTypeStr = r3;
    }
}
