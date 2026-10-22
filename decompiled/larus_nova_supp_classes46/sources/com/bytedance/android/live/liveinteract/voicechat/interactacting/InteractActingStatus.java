package com.bytedance.android.live.liveinteract.voicechat.interactacting;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/interactacting/InteractActingStatus;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "START", "END", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum InteractActingStatus extends Enum<InteractActingStatus> {
    public static final InteractActingStatus END = null;
    public static final InteractActingStatus START = null;
    public static final InteractActingStatus UNKNOWN = null;
    public static final /* synthetic */ InteractActingStatus[] a = null;
    private final int value;

    static {
        InteractActingStatus r1 = new InteractActingStatus("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        InteractActingStatus r2 = new InteractActingStatus("START", 1, 1);
        START = r2;
        InteractActingStatus r3 = new InteractActingStatus("END", 2, 2);
        END = r3;
        a = new InteractActingStatus[]{r1, r2, r3};
    }

    public static InteractActingStatus valueOf(String r1) {
        return (InteractActingStatus) a.a(InteractActingStatus.class, r1);
    }

    public static InteractActingStatus[] values() {
        return (InteractActingStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public InteractActingStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
