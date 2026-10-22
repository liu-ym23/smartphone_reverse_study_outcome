package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class ConditionType {
    public static final ConditionType CELL_VALUE_IS = null;
    public static final ConditionType COLOR_SCALE = null;
    public static final ConditionType DATA_BAR = null;
    public static final ConditionType FILTER = null;
    public static final ConditionType FORMULA = null;
    public static final ConditionType ICON_SET = null;
    private static Map<Integer, ConditionType> lookup;
    public final byte id;
    public final String type;

    static {
        lookup = new HashMap();
        CELL_VALUE_IS = new ConditionType(1, "cellIs");
        FORMULA = new ConditionType(2, "expression");
        COLOR_SCALE = new ConditionType(3, "colorScale");
        DATA_BAR = new ConditionType(4, "dataBar");
        FILTER = new ConditionType(5, null);
        ICON_SET = new ConditionType(6, "iconSet");
    }

    private ConditionType(int r2, String r3) {
        this.id = (byte) r2;
        this.type = r3;
        lookup.put(Integer.valueOf(r2), this);
    }

    public static ConditionType forId(byte r0) {
        return forId(r0);
    }

    public static ConditionType forId(int r2) {
        return (ConditionType) ZeusTransformUtils.preCheckCast(lookup.get(Integer.valueOf(r2)), ConditionType.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        return this.id + " - " + this.type;
    }
}
