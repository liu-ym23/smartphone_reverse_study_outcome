package com.bytedance.android.live.gift.tray;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/gift/tray/RelativeEnterAnimPos;", "", "UP", "DOWN", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RelativeEnterAnimPos extends Enum<RelativeEnterAnimPos> {
    public static final RelativeEnterAnimPos DOWN = null;
    public static final RelativeEnterAnimPos UP = null;
    public static final /* synthetic */ RelativeEnterAnimPos[] a = null;

    static {
        RelativeEnterAnimPos r1 = new RelativeEnterAnimPos("UP", 0);
        UP = r1;
        RelativeEnterAnimPos r2 = new RelativeEnterAnimPos("DOWN", 1);
        DOWN = r2;
        a = new RelativeEnterAnimPos[]{r1, r2};
    }

    public static RelativeEnterAnimPos valueOf(String r1) {
        return (RelativeEnterAnimPos) a.a(RelativeEnterAnimPos.class, r1);
    }

    public static RelativeEnterAnimPos[] values() {
        return (RelativeEnterAnimPos[]) a.clone();
    }

    public RelativeEnterAnimPos(String r1, int r2) {
        super(r1, r2);
    }
}
