package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum PageOrder extends Enum<PageOrder> {
    private static final /* synthetic */ PageOrder[] $VALUES = null;
    public static final PageOrder DOWN_THEN_OVER = null;
    public static final PageOrder OVER_THEN_DOWN = null;
    private static PageOrder[] _table;
    private final int order;

    static {
        int r2 = 0;
        PageOrder r0 = new PageOrder("DOWN_THEN_OVER", 0, 1);
        DOWN_THEN_OVER = r0;
        PageOrder r1 = new PageOrder("OVER_THEN_DOWN", 1, 2);
        OVER_THEN_DOWN = r1;
        $VALUES = new PageOrder[]{r0, r1};
        _table = new PageOrder[3];
        PageOrder[] r3 = values();
        int r4 = r3.length;
    L3:
        if (r2 >= r4) goto L5;
        PageOrder r5 = r3[r2];
        _table[r5.getValue()] = r5;
        r2 = r2 + 1;
        goto L3
    }

    private PageOrder(String r1, int r2, int r3) {
        super(r1, r2);
        this.order = r3;
    }

    public static PageOrder valueOf(int r1) {
        return _table[r1];
    }

    public static PageOrder valueOf(String r2) {
        return (PageOrder) ZeusTransformUtils.preCheckCast(Enum.valueOf(PageOrder.class, r2), PageOrder.class, "com.obric.memorydata.plugin");
    }

    public static PageOrder[] values() {
        return (PageOrder[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PageOrder[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.order;
    }
}
