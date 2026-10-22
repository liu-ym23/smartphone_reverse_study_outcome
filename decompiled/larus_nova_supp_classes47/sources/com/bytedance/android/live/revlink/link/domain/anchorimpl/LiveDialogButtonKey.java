package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/link/domain/anchorimpl/LiveDialogButtonKey;", "", "HORIZONTAL_1", "HORIZONTAL_2", "VERTICAL_1", "VERTICAL_2", "VERTICAL_3", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LiveDialogButtonKey extends Enum<LiveDialogButtonKey> {
    public static final LiveDialogButtonKey HORIZONTAL_1 = null;
    public static final LiveDialogButtonKey HORIZONTAL_2 = null;
    public static final LiveDialogButtonKey VERTICAL_1 = null;
    public static final LiveDialogButtonKey VERTICAL_2 = null;
    public static final LiveDialogButtonKey VERTICAL_3 = null;
    public static final /* synthetic */ LiveDialogButtonKey[] a = null;

    static {
        LiveDialogButtonKey r1 = new LiveDialogButtonKey("HORIZONTAL_1", 0);
        HORIZONTAL_1 = r1;
        LiveDialogButtonKey r2 = new LiveDialogButtonKey("HORIZONTAL_2", 1);
        HORIZONTAL_2 = r2;
        LiveDialogButtonKey r3 = new LiveDialogButtonKey("VERTICAL_1", 2);
        VERTICAL_1 = r3;
        LiveDialogButtonKey r4 = new LiveDialogButtonKey("VERTICAL_2", 3);
        VERTICAL_2 = r4;
        LiveDialogButtonKey r5 = new LiveDialogButtonKey("VERTICAL_3", 4);
        VERTICAL_3 = r5;
        a = new LiveDialogButtonKey[]{r1, r2, r3, r4, r5};
    }

    public static LiveDialogButtonKey valueOf(String r1) {
        return (LiveDialogButtonKey) r27.a.a(LiveDialogButtonKey.class, r1);
    }

    public static LiveDialogButtonKey[] values() {
        return (LiveDialogButtonKey[]) a.clone();
    }

    public LiveDialogButtonKey(String r1, int r2) {
        super(r1, r2);
    }
}
