package com.bytedance.common.wschannel;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final enum TransportMode extends Enum<TransportMode> {
    private static final /* synthetic */ TransportMode[] $VALUES = null;
    public static final TransportMode HTTP2 = null;
    public static final TransportMode TLS = null;
    public static final TransportMode TLS_PROXY = null;
    public static final TransportMode TUDP = null;
    public static final TransportMode TUDP_PROXY = null;
    final int mTypeValue;

    static {
        TransportMode r10 = new TransportMode("TUDP", 0, 0);
        TUDP = r10;
        TransportMode r11 = new TransportMode("TLS", 1, 1);
        TLS = r11;
        TransportMode r12 = new TransportMode("HTTP2", 2, 2);
        HTTP2 = r12;
        TransportMode r13 = new TransportMode("TUDP_PROXY", 3, 3);
        TUDP_PROXY = r13;
        TransportMode r14 = new TransportMode("TLS_PROXY", 4, 4);
        TLS_PROXY = r14;
        $VALUES = new TransportMode[]{r10, r11, r12, r13, r14};
    }

    private TransportMode(String r10, int r11, int r12) {
        super(r10, r11);
        this.mTypeValue = r12;
    }

    @Nullable
    public static TransportMode convertToMode() {
        return null;
    }

    public static TransportMode valueOf(String r10) {
        return (TransportMode) Enum.valueOf(TransportMode.class, r10);
    }

    public static TransportMode[] values() {
        return (TransportMode[]) $VALUES.clone();
    }

    public int getTypeValue() {
        return this.mTypeValue;
    }
}
