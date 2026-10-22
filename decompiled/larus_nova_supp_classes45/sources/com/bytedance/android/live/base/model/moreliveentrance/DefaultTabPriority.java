package com.bytedance.android.live.base.model.moreliveentrance;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/moreliveentrance/DefaultTabPriority;", "", "", "value", "I", "getValue", "()I", "DEFAULT", "RED_POINT", "MORE_LIVE", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DefaultTabPriority extends Enum<DefaultTabPriority> {
    public static final DefaultTabPriority DEFAULT = null;
    public static final DefaultTabPriority MORE_LIVE = null;
    public static final DefaultTabPriority RED_POINT = null;
    public static final /* synthetic */ DefaultTabPriority[] a = null;
    private final int value;

    static {
        DefaultTabPriority r1 = new DefaultTabPriority("DEFAULT", 0, 0);
        DEFAULT = r1;
        DefaultTabPriority r2 = new DefaultTabPriority("RED_POINT", 1, 1);
        RED_POINT = r2;
        DefaultTabPriority r3 = new DefaultTabPriority("MORE_LIVE", 2, 2);
        MORE_LIVE = r3;
        a = new DefaultTabPriority[]{r1, r2, r3};
    }

    public static DefaultTabPriority valueOf(String r1) {
        return (DefaultTabPriority) r27.a.a(DefaultTabPriority.class, r1);
    }

    public static DefaultTabPriority[] values() {
        return (DefaultTabPriority[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public DefaultTabPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
