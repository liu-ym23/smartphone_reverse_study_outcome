package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTileFlipMode;

/* JADX INFO: loaded from: classes7.dex */
public final enum TileFlipMode extends Enum<TileFlipMode> {
    private static final /* synthetic */ TileFlipMode[] $VALUES = null;
    public static final TileFlipMode NONE = null;
    public static final TileFlipMode X = null;
    public static final TileFlipMode XY = null;
    public static final TileFlipMode Y = null;
    private static final HashMap<STTileFlipMode.Enum, TileFlipMode> reverse = null;
    final STTileFlipMode.Enum underlying;

    static {
        int r3 = 0;
        TileFlipMode r0 = new TileFlipMode("NONE", 0, STTileFlipMode.c);
        NONE = r0;
        TileFlipMode r1 = new TileFlipMode("X", 1, STTileFlipMode.d);
        X = r1;
        TileFlipMode r2 = new TileFlipMode("XY", 2, STTileFlipMode.f);
        XY = r2;
        TileFlipMode r4 = new TileFlipMode("Y", 3, STTileFlipMode.e);
        Y = r4;
        $VALUES = new TileFlipMode[]{r0, r1, r2, r4};
        reverse = new HashMap();
        TileFlipMode[] r5 = values();
        int r6 = r5.length;
    L3:
        if (r3 >= r6) goto L5;
        TileFlipMode r7 = r5[r3];
        reverse.put(r7.underlying, r7);
        r3 = r3 + 1;
        goto L3
    }

    private TileFlipMode(String r1, int r2, STTileFlipMode.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static TileFlipMode valueOf(String r2) {
        return (TileFlipMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(TileFlipMode.class, r2), TileFlipMode.class, "com.obric.memorydata.plugin");
    }

    static TileFlipMode valueOf(STTileFlipMode.Enum r2) {
        return (TileFlipMode) ZeusTransformUtils.preCheckCast(reverse.get(r2), TileFlipMode.class, "com.obric.memorydata.plugin");
    }

    public static TileFlipMode[] values() {
        return (TileFlipMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TileFlipMode[].class, "com.obric.memorydata.plugin");
    }
}
