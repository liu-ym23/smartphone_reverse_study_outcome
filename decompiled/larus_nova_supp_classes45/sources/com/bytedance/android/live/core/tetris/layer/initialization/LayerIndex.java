package com.bytedance.android.live.core.tetris.layer.initialization;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/initialization/LayerIndex;", "", "", "toString", "", "index", "I", "getIndex", "()I", "INDEX_SERVICE", "INDEX_XML", "INDEX_0", "INDEX_1", "INDEX_2", "INDEX_3", "INDEX_4", "INDEX_5", "INDEX_6", "INDEX_7", "INDEX_8", "INDEX_9", "INDEX_10", "INDEX_11", "INDEX_12", "INDEX_UNKNOWN", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LayerIndex extends Enum<LayerIndex> {
    public static final LayerIndex INDEX_0 = null;
    public static final LayerIndex INDEX_1 = null;
    public static final LayerIndex INDEX_10 = null;
    public static final LayerIndex INDEX_11 = null;
    public static final LayerIndex INDEX_12 = null;
    public static final LayerIndex INDEX_2 = null;
    public static final LayerIndex INDEX_3 = null;
    public static final LayerIndex INDEX_4 = null;
    public static final LayerIndex INDEX_5 = null;
    public static final LayerIndex INDEX_6 = null;
    public static final LayerIndex INDEX_7 = null;
    public static final LayerIndex INDEX_8 = null;
    public static final LayerIndex INDEX_9 = null;
    public static final LayerIndex INDEX_SERVICE = null;
    public static final LayerIndex INDEX_UNKNOWN = null;
    public static final LayerIndex INDEX_XML = null;
    public static final /* synthetic */ LayerIndex[] a = null;
    private final int index;

    public static LayerIndex valueOf(String r1) {
        return (LayerIndex) a.a(LayerIndex.class, r1);
    }

    public static LayerIndex[] values() {
        return (LayerIndex[]) a.clone();
    }

    static {
        LayerIndex r1 = new LayerIndex("INDEX_SERVICE", 0, -2);
        INDEX_SERVICE = r1;
        LayerIndex r2 = new LayerIndex("INDEX_XML", 1, -1);
        INDEX_XML = r2;
        LayerIndex r3 = new LayerIndex("INDEX_0", 2, 0);
        INDEX_0 = r3;
        LayerIndex r4 = new LayerIndex("INDEX_1", 3, 1);
        INDEX_1 = r4;
        LayerIndex r5 = new LayerIndex("INDEX_2", 4, 2);
        INDEX_2 = r5;
        LayerIndex r6 = new LayerIndex("INDEX_3", 5, 3);
        INDEX_3 = r6;
        LayerIndex r7 = new LayerIndex("INDEX_4", 6, 4);
        INDEX_4 = r7;
        LayerIndex r8 = new LayerIndex("INDEX_5", 7, 5);
        INDEX_5 = r8;
        LayerIndex r9 = new LayerIndex("INDEX_6", 8, 6);
        INDEX_6 = r9;
        LayerIndex r11 = new LayerIndex("INDEX_7", 9, 7);
        INDEX_7 = r11;
        LayerIndex r12 = new LayerIndex("INDEX_8", 10, 8);
        INDEX_8 = r12;
        LayerIndex r13 = new LayerIndex("INDEX_9", 11, 9);
        INDEX_9 = r13;
        LayerIndex r14 = new LayerIndex("INDEX_10", 12, 10);
        INDEX_10 = r14;
        LayerIndex r15 = new LayerIndex("INDEX_11", 13, 11);
        INDEX_11 = r15;
        LayerIndex r16 = new LayerIndex("INDEX_12", 14, 12);
        INDEX_12 = r16;
        LayerIndex r17 = new LayerIndex("INDEX_UNKNOWN", 15, 100);
        INDEX_UNKNOWN = r17;
        a = new LayerIndex[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17};
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.index);
    }

    public final int getIndex() {
        return this.index;
    }

    public LayerIndex(String r1, int r2, int r3) {
        super(r1, r2);
        this.index = r3;
    }
}
