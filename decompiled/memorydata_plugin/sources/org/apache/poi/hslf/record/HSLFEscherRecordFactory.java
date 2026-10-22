package org.apache.poi.hslf.record;

import java.util.function.Supplier;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherRecord;

/* JADX INFO: loaded from: classes7.dex */
public class HSLFEscherRecordFactory extends DefaultEscherRecordFactory {
    public HSLFEscherRecordFactory() {
    }

    @Override // org.apache.poi.ddf.DefaultEscherRecordFactory
    public Supplier<? extends EscherRecord> getConstructor(short r2, short r3) {
        if (r3 != EscherPlaceholder.RECORD_ID) goto L7;
        return $$Lambda$xRR8NCxH9LLn3IL7p6YqJFRuXs.INSTANCE;
    L7:
        if (r3 != EscherClientDataRecord.RECORD_ID) goto L11;
        return $$Lambda$CWL7EP08x83CT5QQ5rdsqEaRrM.INSTANCE;
    L11:
        return super.getConstructor(r2, r3);
    }
}
