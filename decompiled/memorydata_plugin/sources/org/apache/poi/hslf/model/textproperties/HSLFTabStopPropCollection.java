package org.apache.poi.hslf.model.textproperties;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.poi.sl.usermodel.TabStop;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.LittleEndianOutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class HSLFTabStopPropCollection extends TextProp {
    private final List<HSLFTabStop> tabStops;

    public HSLFTabStopPropCollection() {
        super(0, 1048576, "tabStops");
        this.tabStops = new ArrayList();
    }

    public HSLFTabStopPropCollection(HSLFTabStopPropCollection r2) {
        super(r2);
        final ArrayList r0 = new ArrayList();
        this.tabStops = r0;
        r2.tabStops.stream().map($$Lambda$F8E3DXpLAMiQ4ofBfO31xMxzu4.INSTANCE).forEach(new $$Lambda$HGhqFVxP9JLUry8hXBb_MNwyImE(r0));
    }

    public static List<HSLFTabStop> readTabStops(LittleEndianInput r6) {
        LittleEndianInput r7 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r6, LittleEndianInput.class, "com.obric.memorydata.plugin");
        int r0 = r7.readUShort();
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1.add(new HSLFTabStop(r7.readShort(), TabStop.TabStopType.fromNativeId(r7.readShort())));
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static void writeTabStops(LittleEndianOutput r3, List<HSLFTabStop> r4) {
        LittleEndianOutput r5 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        r5.writeShort(r6.size());
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        HSLFTabStop r0 = (HSLFTabStop) ZeusTransformUtils.preCheckCast(r7.next(), HSLFTabStop.class, "com.obric.memorydata.plugin");
        r5.writeShort(r0.getPosition());
        r5.writeShort(r0.getType().nativeId);
        goto L4
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public HSLFTabStopPropCollection copy() {
        return new HSLFTabStopPropCollection(this);
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public /* bridge */ /* synthetic */ TextProp copy() {
        return copy();
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public boolean equals(Object r4) {
        if (this != r4) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, HSLFTabStopPropCollection.class) == true) goto L9;
        return false;
    L9:
        HSLFTabStopPropCollection r5 = (HSLFTabStopPropCollection) ZeusTransformUtils.preCheckCast(r4, HSLFTabStopPropCollection.class, "com.obric.memorydata.plugin");
        if (super.equals(r5) == true) goto L13;
        return false;
    L13:
        return this.tabStops.equals(r5.tabStops);
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HSLFTabStopPropCollection$gLZHdZEiZZYGlWPtf6OAV_G2KUk(this), "tabStops", new $$Lambda$tl9j0E2QHucrHcOgx1dJRoiEps(this));
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public int getSize() {
        return (this.tabStops.size() * 4) + 2;
    }

    public List<HSLFTabStop> getTabStops() {
        return this.tabStops;
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public int getValue() {
        return this.tabStops.size();
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.tabStops});
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$HSLFTabStopPropCollection() {
        return super.getGenericProperties();
    }

    public void parseProperty(byte[] r2, int r3) {
        this.tabStops.addAll(readTabStops(new LittleEndianByteArrayInputStream(r2, r3)));
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public String toString() {
        StringBuilder r0 = new StringBuilder(super.toString());
        r0.append(" [ ");
        Iterator<HSLFTabStop> r5 = this.tabStops.iterator();
        boolean r1 = true;
    L4:
        if (r5.hasNext() == false) goto L9;
        HSLFTabStop r2 = (HSLFTabStop) ZeusTransformUtils.preCheckCast(r5.next(), HSLFTabStop.class, "com.obric.memorydata.plugin");
        if (r1 == true) goto L8;
        r0.append(", ");
    L8:
        r0.append(r2.getType());
        r0.append(" @ ");
        r0.append(r2.getPosition());
        r1 = false;
        goto L4
    L9:
        r0.append(" ]");
        return r0.toString();
    }

    public void writeProperty(OutputStream r2) {
        writeTabStops(new LittleEndianOutputStream(r2), this.tabStops);
    }
}
