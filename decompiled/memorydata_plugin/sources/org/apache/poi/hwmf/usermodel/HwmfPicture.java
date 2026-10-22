package org.apache.poi.hwmf.usermodel;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hwmf.record.HwmfRecord;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfPicture implements Iterable<HwmfRecord>, GenericRecord {
    private static final c LOG = null;
    public static int MAX_RECORD_LENGTH = 100000000;
    final List<HwmfRecord> records;

    static {
        LOG = b.a(HwmfPicture.class);
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<? extends GenericRecord> getGenericChildren() {
        return getRecords();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    public List<HwmfRecord> getRecords() {
        return Collections.unmodifiableList(this.records);
    }

    @Override // java.lang.Iterable
    public Iterator<HwmfRecord> iterator() {
        return getRecords().iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<HwmfRecord> spliterator() {
        return getRecords().spliterator();
    }
}
