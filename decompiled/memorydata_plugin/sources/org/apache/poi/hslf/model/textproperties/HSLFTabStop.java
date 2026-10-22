package org.apache.poi.hslf.model.textproperties;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.sl.usermodel.TabStop;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HSLFTabStop implements GenericRecord, TabStop {
    private int position;
    private TabStop.TabStopType type;

    public HSLFTabStop(int r1, TabStop.TabStopType r2) {
        this.position = r1;
        this.type = r2;
    }

    public HSLFTabStop(HSLFTabStop r2) {
        this.position = r2.position;
        this.type = r2.type;
    }

    public HSLFTabStop copy() {
        return new HSLFTabStop(this);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, HSLFTabStop.class) == true) goto L8;
        return false;
    L8:
        HSLFTabStop r6 = (HSLFTabStop) ZeusTransformUtils.preCheckCast(r5, HSLFTabStop.class, "com.obric.memorydata.plugin");
        if (this.position == r6.position) goto L12;
        return false;
    L12:
        if (this.type == r6.type) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("type", new $$Lambda$Q3HZCwBaOsNjdm0M8w69KVVIKyI(this), "position", new $$Lambda$JHY2BTOseVcnqif0ldh__We_A(this));
    }

    public int getPosition() {
        return this.position;
    }

    @Override // org.apache.poi.sl.usermodel.TabStop
    public TabStop.TabStopType getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.position), this.type});
    }

    public String toString() {
        return this.type + " @ " + this.position;
    }
}
