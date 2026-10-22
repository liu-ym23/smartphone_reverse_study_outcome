package com.bytedance.android.live.core.tetris.layer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/TetrisComponentKey;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "UNIQUE_NATIVE_VIEW", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TetrisComponentKey extends Enum<TetrisComponentKey> {
    public static final TetrisComponentKey UNIQUE_NATIVE_VIEW = null;
    public static final /* synthetic */ TetrisComponentKey[] a = null;
    private final String key;

    static {
        TetrisComponentKey r1 = new TetrisComponentKey();
        UNIQUE_NATIVE_VIEW = r1;
        a = new TetrisComponentKey[]{r1};
    }

    public static TetrisComponentKey valueOf(String r1) {
        return (TetrisComponentKey) a.a(TetrisComponentKey.class, r1);
    }

    public static TetrisComponentKey[] values() {
        return (TetrisComponentKey[]) a.clone();
    }

    public TetrisComponentKey() {
        super("UNIQUE_NATIVE_VIEW", 0);
        this.key = "unique_native";
    }

    public final String getKey() {
        return this.key;
    }
}
