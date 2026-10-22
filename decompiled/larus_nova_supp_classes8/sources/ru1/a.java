package ru1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.parse.ExpressNodeType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ExpressNodeType.values().length];
        a = r0;
        r0[ExpressNodeType.PARAM.ordinal()] = 1;
        r0[ExpressNodeType.CONST_FLOAT.ordinal()] = 2;
        r0[ExpressNodeType.CONST_INT.ordinal()] = 3;
        r0[ExpressNodeType.CONST_DOUBLE.ordinal()] = 4;
        r0[ExpressNodeType.CONST_LONG.ordinal()] = 5;
        r0[ExpressNodeType.CONST_BOOLEAN.ordinal()] = 6;
        r0[ExpressNodeType.OPERATOR_AND.ordinal()] = 7;
        r0[ExpressNodeType.OPERATOR_OR.ordinal()] = 8;
        r0[ExpressNodeType.OPERATOR_COMPARE.ordinal()] = 9;
    }
}
