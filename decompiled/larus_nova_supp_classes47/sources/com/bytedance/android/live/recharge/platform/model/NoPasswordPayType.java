package com.bytedance.android.live.recharge.platform.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/NoPasswordPayType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "NOT_USE_NO_PASSWORD", "USE_DY_OR_ZFB_PAY", "USE_ONE_STEP_PAY", "USE_RECHARGE_PANEL", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum NoPasswordPayType extends Enum<NoPasswordPayType> {
    public static final a Companion = null;
    public static final NoPasswordPayType NOT_USE_NO_PASSWORD = null;
    public static final NoPasswordPayType USE_DY_OR_ZFB_PAY = null;
    public static final NoPasswordPayType USE_ONE_STEP_PAY = null;
    public static final NoPasswordPayType USE_RECHARGE_PANEL = null;
    public static final /* synthetic */ NoPasswordPayType[] a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        NoPasswordPayType r1 = new NoPasswordPayType("NOT_USE_NO_PASSWORD", 0, 0);
        NOT_USE_NO_PASSWORD = r1;
        NoPasswordPayType r2 = new NoPasswordPayType("USE_DY_OR_ZFB_PAY", 1, 1);
        USE_DY_OR_ZFB_PAY = r2;
        NoPasswordPayType r3 = new NoPasswordPayType("USE_ONE_STEP_PAY", 2, 2);
        USE_ONE_STEP_PAY = r3;
        NoPasswordPayType r4 = new NoPasswordPayType("USE_RECHARGE_PANEL", 3, 3);
        USE_RECHARGE_PANEL = r4;
        a = new NoPasswordPayType[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static NoPasswordPayType valueOf(String r1) {
        return (NoPasswordPayType) r27.a.a(NoPasswordPayType.class, r1);
    }

    public static NoPasswordPayType[] values() {
        return (NoPasswordPayType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public NoPasswordPayType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
