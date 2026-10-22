package com.bytedance.android.live.core.tetris.layout;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layout/ViewState;", "", "UN_CREATED", "CREATING", "CREATED", "USING", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ViewState extends Enum<ViewState> {
    public static final ViewState CREATED = null;
    public static final ViewState CREATING = null;
    public static final ViewState UN_CREATED = null;
    public static final ViewState USING = null;
    public static final /* synthetic */ ViewState[] a = null;

    static {
        ViewState r1 = new ViewState("UN_CREATED", 0);
        UN_CREATED = r1;
        ViewState r2 = new ViewState("CREATING", 1);
        CREATING = r2;
        ViewState r3 = new ViewState("CREATED", 2);
        CREATED = r3;
        ViewState r4 = new ViewState("USING", 3);
        USING = r4;
        a = new ViewState[]{r1, r2, r3, r4};
    }

    public static ViewState valueOf(String r1) {
        return (ViewState) a.a(ViewState.class, r1);
    }

    public static ViewState[] values() {
        return (ViewState[]) a.clone();
    }

    public ViewState(String r1, int r2) {
        super(r1, r2);
    }
}
