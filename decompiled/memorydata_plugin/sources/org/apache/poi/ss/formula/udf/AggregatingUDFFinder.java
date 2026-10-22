package org.apache.poi.ss.formula.udf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.poi.ss.formula.atp.AnalysisToolPak;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
public class AggregatingUDFFinder implements UDFFinder {
    public static final UDFFinder DEFAULT = null;
    private final Collection<UDFFinder> _usedToolPacks;

    static {
        DEFAULT = new AggregatingUDFFinder(new UDFFinder[]{AnalysisToolPak.instance});
    }

    public AggregatingUDFFinder(UDFFinder... r3) {
        ArrayList r0 = new ArrayList(r3.length);
        this._usedToolPacks = r0;
        r0.addAll(Arrays.asList(r3));
    }

    @Override // org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String r4) {
        Iterator<UDFFinder> r3 = this._usedToolPacks.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        FreeRefFunction r0 = ((UDFFinder) ZeusTransformUtils.preCheckCast(r3.next(), UDFFinder.class, "com.obric.memorydata.plugin")).findFunction(r4);
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }
}
