package org.apache.poi.xddf.usermodel.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextTabAlignType;

/* JADX INFO: loaded from: classes7.dex */
public final enum TabAlignment extends Enum<TabAlignment> {
    private static final /* synthetic */ TabAlignment[] $VALUES = null;
    public static final TabAlignment CENTER = null;
    public static final TabAlignment DECIMAL = null;
    public static final TabAlignment LEFT = null;
    public static final TabAlignment RIGHT = null;
    private static final HashMap<STTextTabAlignType.Enum, TabAlignment> reverse = null;
    final STTextTabAlignType.Enum underlying;

    static {
        int r3 = 0;
        TabAlignment r0 = new TabAlignment("CENTER", 0, STTextTabAlignType.d);
        CENTER = r0;
        TabAlignment r1 = new TabAlignment("DECIMAL", 1, STTextTabAlignType.f);
        DECIMAL = r1;
        TabAlignment r2 = new TabAlignment("LEFT", 2, STTextTabAlignType.c);
        LEFT = r2;
        TabAlignment r4 = new TabAlignment("RIGHT", 3, STTextTabAlignType.e);
        RIGHT = r4;
        $VALUES = new TabAlignment[]{r0, r1, r2, r4};
        reverse = new HashMap();
        TabAlignment[] r5 = values();
        int r6 = r5.length;
    L3:
        if (r3 >= r6) goto L5;
        TabAlignment r7 = r5[r3];
        reverse.put(r7.underlying, r7);
        r3 = r3 + 1;
        goto L3
    }

    private TabAlignment(String r1, int r2, STTextTabAlignType.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static TabAlignment valueOf(String r2) {
        return (TabAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(TabAlignment.class, r2), TabAlignment.class, "com.obric.memorydata.plugin");
    }

    static TabAlignment valueOf(STTextTabAlignType.Enum r2) {
        return (TabAlignment) ZeusTransformUtils.preCheckCast(reverse.get(r2), TabAlignment.class, "com.obric.memorydata.plugin");
    }

    public static TabAlignment[] values() {
        return (TabAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TabAlignment[].class, "com.obric.memorydata.plugin");
    }
}
