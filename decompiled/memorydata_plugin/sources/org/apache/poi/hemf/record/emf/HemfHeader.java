package org.apache.poi.hemf.record.emf;

import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.Dimension2DDouble;
import org.apache.poi.util.GenericRecordJsonWriter;

/* JADX INFO: loaded from: classes7.dex */
public class HemfHeader implements HemfRecord {
    private long bOpenGL;
    private final Rectangle2D boundsRectangle;
    private long bytes;
    private long cbPixelFormat;
    private String description;
    private final Dimension2D deviceDimension;
    private final Rectangle2D frameRectangle;
    private int handles;
    private boolean hasExtension1;
    private boolean hasExtension2;
    private final Dimension2D microDimension;
    private final Dimension2D milliDimension;
    private long nPalEntries;
    private long offPixelFormat;
    private long records;

    public HemfHeader() {
        this.boundsRectangle = new Rectangle2D.Double();
        this.frameRectangle = new Rectangle2D.Double();
        this.deviceDimension = new Dimension2DDouble();
        this.milliDimension = new Dimension2DDouble();
        this.microDimension = new Dimension2DDouble();
    }

    public Rectangle2D getBoundsRectangle() {
        return this.boundsRectangle;
    }

    public long getBytes() {
        return this.bytes;
    }

    public long getCbPixelFormat() {
        return this.cbPixelFormat;
    }

    public String getDescription() {
        return this.description;
    }

    public Dimension2D getDeviceDimension() {
        return this.deviceDimension;
    }

    @Override // org.apache.poi.hemf.record.emf.HemfRecord
    public HemfRecordType getEmfRecordType() {
        return HemfRecordType.header;
    }

    public Rectangle2D getFrameRectangle() {
        return this.frameRectangle;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("boundsRectangle", new $$Lambda$xauSMUi4r3W6V0FmT6Rig6E_BE(this));
        r0.put("frameRectangle", new $$Lambda$FIXw58rZMF3m25tAtBEu_M2Iw(this));
        r0.put("bytes", new $$Lambda$zsC1pOaXXoFHUmwGxURYGExKrsA(this));
        r0.put("records", new $$Lambda$7xEwyKFs3dhuanB59guqvuNDPs(this));
        r0.put("handles", new $$Lambda$zBQSxP8lsKXBaCFZ8bZpSKkrvw(this));
        r0.put("description", new $$Lambda$hORayK8J_Ug7D_ewbSWRccdt5xs(this));
        r0.put("nPalEntries", new $$Lambda$tWut0sofd6ssisW6vvtirOOisA(this));
        r0.put("hasExtension1", new $$Lambda$31oXcXnzLZ9YRRS1X4t0JZ1SFNE(this));
        r0.put("cbPixelFormat", new $$Lambda$AlONILk0JiQhfZVkHGUSyQu7yQ(this));
        r0.put("offPixelFormat", new $$Lambda$nu1YTDSflqVux_8l9HjbfTqfXs(this));
        r0.put("bOpenGL", new $$Lambda$ahsWbF8gY87eTKDsLXvM9k0cgc(this));
        r0.put("hasExtension2", new $$Lambda$FSKxg4CnuAonsTZNswPft77d0jk(this));
        r0.put("deviceDimension", new $$Lambda$k8O2qR7mJJYbKSZmiOWy0ap83Q(this));
        r0.put("milliDimension", new $$Lambda$WIiKqZHSyacDzBnnZzYnKJKwg0s(this));
        r0.put("microDimension", new $$Lambda$bJnuCwFgwkeZ4L9RfNhgUGsMIM(this));
        return Collections.unmodifiableMap(r0);
    }

    public int getHandles() {
        return this.handles;
    }

    public Dimension2D getMicroDimension() {
        return this.microDimension;
    }

    public Dimension2D getMilliDimension() {
        return this.milliDimension;
    }

    public long getNPalEntries() {
        return this.nPalEntries;
    }

    public long getOffPixelFormat() {
        return this.offPixelFormat;
    }

    public long getRecords() {
        return this.records;
    }

    public long getbOpenGL() {
        return this.bOpenGL;
    }

    public boolean isHasExtension1() {
        return this.hasExtension1;
    }

    public boolean isHasExtension2() {
        return this.hasExtension2;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
