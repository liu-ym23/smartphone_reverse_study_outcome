package com.bytedance.android.live.core.tetris.componentx.descriptor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/tetris/componentx/descriptor/ComponentType;", "", "TETRIS", "WIDGET", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ComponentType extends Enum<ComponentType> {
    public static final ComponentType TETRIS = null;
    public static final ComponentType WIDGET = null;
    public static final /* synthetic */ ComponentType[] a = null;

    static {
        ComponentType r1 = new ComponentType("TETRIS", 0);
        TETRIS = r1;
        ComponentType r2 = new ComponentType("WIDGET", 1);
        WIDGET = r2;
        a = new ComponentType[]{r1, r2};
    }

    public static ComponentType valueOf(String r1) {
        return (ComponentType) a.a(ComponentType.class, r1);
    }

    public static ComponentType[] values() {
        return (ComponentType[]) a.clone();
    }

    public ComponentType(String r1, int r2) {
        super(r1, r2);
    }
}
