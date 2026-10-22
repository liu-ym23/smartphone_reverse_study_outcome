package org.apache.poi.hssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes7.dex */
public final class RecordStream {
    private int _countRead;
    private final int _endIx;
    private final List<Record> _list;
    private int _nextIndex;

    public RecordStream(List<Record> r3, int r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this(r5, r4, r5.size());
    }

    public RecordStream(List<Record> r3, int r4, int r5) {
        this._list = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this._nextIndex = r4;
        this._endIx = r5;
        this._countRead = 0;
    }

    public int getCountRead() {
        return this._countRead;
    }

    public Record getNext() {
        if (hasNext() == false) goto L7;
        this._countRead++;
        List<Record> r0 = this._list;
        int r1 = this._nextIndex;
        this._nextIndex = r1 + 1;
        return (Record) ZeusTransformUtils.preCheckCast(r0.get(r1), Record.class, "com.obric.memorydata.plugin");
    L7:
        throw new NoSuchElementException("Attempt to read past end of record stream");
    }

    public boolean hasNext() {
        if (this._nextIndex >= this._endIx) goto L5;
        return true;
    L5:
        return false;
    }

    public Class<? extends Record> peekNextClass() {
        if (hasNext() == true) goto L7;
        return null;
    L7:
        return ((Record) ZeusTransformUtils.preCheckCast(this._list.get(this._nextIndex), Record.class, "com.obric.memorydata.plugin")).getClass();
    }

    public Record peekNextRecord() {
        if (hasNext() == true) goto L7;
        return null;
    L7:
        return (Record) ZeusTransformUtils.preCheckCast(this._list.get(this._nextIndex), Record.class, "com.obric.memorydata.plugin");
    }

    public int peekNextSid() {
        if (hasNext() == true) goto L7;
        return -1;
    L7:
        return ((Record) ZeusTransformUtils.preCheckCast(this._list.get(this._nextIndex), Record.class, "com.obric.memorydata.plugin")).getSid();
    }
}
