package com.bytedance.android.bcm.impl2.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/bcm/impl2/model/BcmAllowMode;", "", "", "target", "", "isEnabled", "modeByte", "I", "getModeByte", "()I", "MANUAL", "EVENT", "bcm-impl-v2_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum BcmAllowMode extends Enum<BcmAllowMode> {
    public static final BcmAllowMode EVENT = null;
    public static final BcmAllowMode MANUAL = null;
    public static final /* synthetic */ BcmAllowMode[] a = null;
    private final int modeByte;

    static {
        BcmAllowMode r10 = new BcmAllowMode("MANUAL", 0, 1);
        MANUAL = r10;
        BcmAllowMode r11 = new BcmAllowMode("EVENT", 1, 2);
        EVENT = r11;
        a = new BcmAllowMode[]{r10, r11};
    }

    public static BcmAllowMode valueOf(String r1) {
        return (BcmAllowMode) a.a(BcmAllowMode.class, r1);
    }

    public static BcmAllowMode[] values() {
        return (BcmAllowMode[]) a.clone();
    }

    public final int getModeByte() {
        return this.modeByte;
    }

    public final boolean isEnabled(int r10) {
        if ((r10 & this.modeByte) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public BcmAllowMode(String r1, int r10, int r11) {
        super(r1, r10);
        this.modeByte = r11;
    }
}
