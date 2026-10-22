package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "Companion", "a", "Audience", "Anchor", "OtherAnchor", "Guest", "MicTeamAnchor", "AllMic", "GroupLive", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ReceiverType extends Enum<ReceiverType> {
    public static final ReceiverType AllMic = null;
    public static final ReceiverType Anchor = null;
    public static final ReceiverType Audience = null;
    public static final a Companion = null;
    public static final ReceiverType GroupLive = null;
    public static final ReceiverType Guest = null;
    public static final ReceiverType MicTeamAnchor = null;
    public static final ReceiverType OtherAnchor = null;
    public static final /* synthetic */ ReceiverType[] a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        ReceiverType r2 = new ReceiverType("Audience", 0, 1);
        Audience = r2;
        ReceiverType r3 = new ReceiverType("Anchor", 1, 2);
        Anchor = r3;
        ReceiverType r4 = new ReceiverType("OtherAnchor", 2, 3);
        OtherAnchor = r4;
        ReceiverType r5 = new ReceiverType("Guest", 3, 4);
        Guest = r5;
        ReceiverType r6 = new ReceiverType("MicTeamAnchor", 4, 5);
        MicTeamAnchor = r6;
        ReceiverType r7 = new ReceiverType("AllMic", 5, 6);
        AllMic = r7;
        ReceiverType r8 = new ReceiverType("GroupLive", 6, 7);
        GroupLive = r8;
        a = new ReceiverType[]{r2, r3, r4, r5, r6, r7, r8};
        Companion = new a();
    }

    public static ReceiverType valueOf(String r1) {
        return (ReceiverType) r27.a.a(ReceiverType.class, r1);
    }

    public static ReceiverType[] values() {
        return (ReceiverType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ReceiverType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
