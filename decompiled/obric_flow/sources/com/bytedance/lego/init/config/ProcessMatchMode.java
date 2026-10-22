package com.bytedance.lego.init.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lego/init/config/ProcessMatchMode;", "", "(Ljava/lang/String;I)V", "STRICT", "ENDWITH", "CONTAIN", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final enum ProcessMatchMode extends Enum<ProcessMatchMode> {
    private static final /* synthetic */ ProcessMatchMode[] $VALUES = null;
    public static final ProcessMatchMode CONTAIN = null;
    public static final ProcessMatchMode ENDWITH = null;
    public static final ProcessMatchMode STRICT = null;

    static {
        ProcessMatchMode r5 = new ProcessMatchMode("STRICT", 0);
        STRICT = r5;
        ProcessMatchMode r10 = new ProcessMatchMode("ENDWITH", 1);
        ENDWITH = r10;
        ProcessMatchMode r11 = new ProcessMatchMode("CONTAIN", 2);
        CONTAIN = r11;
        $VALUES = new ProcessMatchMode[]{r5, r10, r11};
    }

    public ProcessMatchMode(String r5, int r10) {
        super(r5, r10);
    }

    public static ProcessMatchMode valueOf(String r5) {
        return (ProcessMatchMode) Enum.valueOf(ProcessMatchMode.class, r5);
    }

    public static ProcessMatchMode[] values() {
        return (ProcessMatchMode[]) $VALUES.clone();
    }
}
