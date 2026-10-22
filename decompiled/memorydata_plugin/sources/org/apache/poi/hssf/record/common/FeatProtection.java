package org.apache.poi.hssf.record.common;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FeatProtection implements SharedFeature {
    private int fSD;
    private int passwordVerifier;
    private byte[] securityDescriptor;
    private String title;

    public FeatProtection() {
        this.securityDescriptor = new byte[0];
    }

    public FeatProtection(RecordInputStream r2) {
        this.fSD = r2.readInt();
        this.passwordVerifier = r2.readInt();
        this.title = StringUtil.readUnicodeString(r2);
        this.securityDescriptor = r2.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public int getDataSize() {
        return (StringUtil.getEncodedSize(this.title) + 8) + this.securityDescriptor.length;
    }

    public int getFSD() {
        return this.fSD;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("FSD", new $$Lambda$cwTIvJHmQhQDXiGbjkbsaP62JQ(this), "passwordVerifier", new $$Lambda$kEbhloHTp0LXmRMR0tWrDQ7vPo(this), "title", new $$Lambda$OmURxje4HHSDOnAREQcJ4748dE8(this), "securityDescriptor", new $$Lambda$FeatProtection$wWyb8_d0a5Ho27y4lFND0FRZjTM(this));
    }

    public int getPasswordVerifier() {
        return this.passwordVerifier;
    }

    public String getTitle() {
        return this.title;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$FeatProtection() {
        return this.securityDescriptor;
    }
}
