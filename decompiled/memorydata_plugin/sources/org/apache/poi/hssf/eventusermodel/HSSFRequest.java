package org.apache.poi.hssf.eventusermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;

/* JADX INFO: loaded from: classes7.dex */
public class HSSFRequest {
    private final Map<Short, List<HSSFListener>> _records;

    public HSSFRequest() {
        this._records = new HashMap(50);
    }

    static /* synthetic */ List lambda$addListener$0(Short r1) {
        return new ArrayList(1);
    }

    public void addListener(HSSFListener r3, short r4) {
        HSSFListener r5 = (HSSFListener) ZeusTransformUtils.wrapperContextForParams(r3, HSSFListener.class, "com.obric.memorydata.plugin");
        ((List) ZeusTransformUtils.preCheckCast(this._records.computeIfAbsent(Short.valueOf(r4), $$Lambda$HSSFRequest$6dzpjI0R6zJsxy3PLYUIGro5hog.INSTANCE), List.class, "com.obric.memorydata.plugin")).add(r5);
    }

    public void addListenerForAllRecords(HSSFListener r5) {
        HSSFListener r6 = (HSSFListener) ZeusTransformUtils.wrapperContextForParams(r5, HSSFListener.class, "com.obric.memorydata.plugin");
        short[] r0 = RecordFactory.getAllKnownRecordSIDs();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        addListener(r6, r0[r2]);
        r2 = r2 + 1;
        goto L3
    }

    public short processRecord(Record r5) {
        List r4 = (List) ZeusTransformUtils.preCheckCast(this._records.get(Short.valueOf(r5.getSid())), List.class, "com.obric.memorydata.plugin");
        short r0 = 0;
        if (r4 == null) goto L13;
        Iterator r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L13;
        Object r2 = r6.next();
        if (ZeusTransformUtils.instanceOf(r2, AbortableHSSFListener.class) == true) goto L9;
        ((HSSFListener) ZeusTransformUtils.preCheckCast(r2, HSSFListener.class, "com.obric.memorydata.plugin")).processRecord(r5);
        goto L6
    L9:
        r0 = ((AbortableHSSFListener) ZeusTransformUtils.preCheckCast(r2, AbortableHSSFListener.class, "com.obric.memorydata.plugin")).abortableProcessRecord(r5);
        if (r0 == 0) goto L6;
    L13:
        return r0;
    }
}
