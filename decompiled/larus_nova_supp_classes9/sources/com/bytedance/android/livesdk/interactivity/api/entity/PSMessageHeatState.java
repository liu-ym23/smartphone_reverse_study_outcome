package com.bytedance.android.livesdk.interactivity.api.entity;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/entity/PSMessageHeatState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "Companion", "a", "HOT", "NORMAL", "COLD", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSMessageHeatState extends Enum<PSMessageHeatState> {
    public static final PSMessageHeatState COLD = null;
    public static final a Companion = null;
    public static final PSMessageHeatState HOT = null;
    public static final PSMessageHeatState NORMAL = null;
    public static final /* synthetic */ PSMessageHeatState[] a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        PSMessageHeatState r2 = new PSMessageHeatState("HOT", 0, 3);
        HOT = r2;
        PSMessageHeatState r0 = new PSMessageHeatState("NORMAL", 1, 2);
        NORMAL = r0;
        PSMessageHeatState r1 = new PSMessageHeatState("COLD", 2, 1);
        COLD = r1;
        a = new PSMessageHeatState[]{r2, r0, r1};
        Companion = new a();
    }

    public static PSMessageHeatState valueOf(String r1) {
        return (PSMessageHeatState) r27.a.a(PSMessageHeatState.class, r1);
    }

    public static PSMessageHeatState[] values() {
        return (PSMessageHeatState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PSMessageHeatState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
