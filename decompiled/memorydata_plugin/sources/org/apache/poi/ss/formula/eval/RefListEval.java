package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class RefListEval implements ValueEval {
    private final List<ValueEval> list;

    public RefListEval(ValueEval r3, ValueEval r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        this.list = new ArrayList();
        add(r5);
        add(r6);
    }

    private void add(ValueEval r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        boolean r1 = ZeusTransformUtils.instanceOf(r5, RefListEval.class);
        List<ValueEval> r3 = this.list;
        if (r1 == false) goto L5;
        r3.addAll(((RefListEval) ZeusTransformUtils.preCheckCast(r5, RefListEval.class, "com.obric.memorydata.plugin")).list);
        return;
    L5:
        r3.add(r5);
    }

    public List<ValueEval> getList() {
        return this.list;
    }
}
