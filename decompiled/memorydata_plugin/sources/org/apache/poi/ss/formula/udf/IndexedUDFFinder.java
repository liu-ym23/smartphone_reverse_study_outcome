package org.apache.poi.ss.formula.udf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
public class IndexedUDFFinder extends AggregatingUDFFinder {
    private final HashMap<Integer, String> _funcMap;

    public IndexedUDFFinder(UDFFinder... r1) {
        super(r1);
        this._funcMap = new HashMap();
    }

    @Override // org.apache.poi.ss.formula.udf.AggregatingUDFFinder, org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String r3) {
        FreeRefFunction r0 = super.findFunction(r3);
        if (r0 == null) goto L5;
        int r1 = getFunctionIndex(r3);
        this._funcMap.put(Integer.valueOf(r1), r3);
    L5:
        return r0;
    }

    public int getFunctionIndex(String r1) {
        return r1.hashCode();
    }

    public String getFunctionName(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(this._funcMap.get(Integer.valueOf(r2)), String.class, "com.obric.memorydata.plugin");
    }
}
