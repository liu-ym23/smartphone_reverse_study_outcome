package org.apache.poi.poifs.property;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSStream;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class PropertyTable {
    private static final c LOG = null;
    private final POIFSBigBlockSize _bigBigBlockSize;
    private final HeaderBlock _header_block;
    private final List<Property> _properties;

    static {
        LOG = b.a(PropertyTable.class);
    }

    public PropertyTable(HeaderBlock r2) {
        this._properties = new ArrayList();
        this._header_block = r2;
        this._bigBigBlockSize = r2.getBigBlockSize();
        addProperty(new RootProperty());
    }

    PropertyTable(HeaderBlock r8, Iterable<ByteBuffer> r9) {
        Iterable r10 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r9, Iterable.class, "com.obric.memorydata.plugin");
        this._properties = new ArrayList();
        this._header_block = r8;
        this._bigBigBlockSize = r8.getBigBlockSize();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        ByteBuffer r12 = (ByteBuffer) ZeusTransformUtils.preCheckCast(r11.next(), ByteBuffer.class, "com.obric.memorydata.plugin");
        if (r12.hasArray() == true) goto L8;
    L12:
        byte[] r2 = IOUtils.safelyAllocate(this._bigBigBlockSize.getBigBlockSize(), POIFSFileSystem.getMaxRecordLength());
        int r3 = r2.length;
        if (r12.remaining() >= this._bigBigBlockSize.getBigBlockSize()) goto L15;
        LOG.atWarn().a("Short Property Block, {} bytes instead of the expected {}", v.a(r12.remaining()), v.a(this._bigBigBlockSize.getBigBlockSize()));
        r3 = r12.remaining();
    L15:
        r12.get(r2, 0, r3);
        byte[] r13 = r2;
    L16:
        PropertyFactory.convertToProperties(r13, this._properties);
        goto L4
    L8:
        if (r12.arrayOffset() != 0) goto L12;
        if (r12.array().length != this._bigBigBlockSize.getBigBlockSize()) goto L12;
        r13 = r12.array();
        goto L16
    L18:
        if (this._properties.get(0) == null) goto L24;
        populatePropertyTree((DirectoryProperty) ZeusTransformUtils.preCheckCast(this._properties.get(0), DirectoryProperty.class, "com.obric.memorydata.plugin"));
        return;
    }

    public PropertyTable(HeaderBlock r3, POIFSFileSystem r4) {
        this(r3, new POIFSStream(r4, r3.getPropertyStart()));
    }

    private boolean isValidIndex(int r4) {
        if (Property.isValidIndex(r4) == true) goto L5;
        return false;
    L5:
        if (r4 >= 0) goto L7;
    L11:
        LOG.atWarn().a("Property index {} outside the valid range 0..{}", v.a(r4), v.a(this._properties.size()));
        return false;
    L7:
        if (r4 >= this._properties.size()) goto L11;
        return true;
    }

    private void populatePropertyTree(DirectoryProperty r5) {
        int r0 = r5.getChildIndex();
        if (Property.isValidIndex(r0) == true) goto L5;
        return;
    L5:
        Stack r1 = new Stack();
    L6:
        r1.push(this._properties.get(r0));
    L8:
        if (r1.empty() == true) goto L21;
        Property r2 = (Property) ZeusTransformUtils.preCheckCast(r1.pop(), Property.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        r5.addChild(r2);
        if (r2.isDirectory() == false) goto L15;
        populatePropertyTree((DirectoryProperty) ZeusTransformUtils.preCheckCast(r2, DirectoryProperty.class, "com.obric.memorydata.plugin"));
    L15:
        int r3 = r2.getPreviousChildIndex();
        if (isValidIndex(r3) == false) goto L18;
        r1.push(this._properties.get(r3));
    L18:
        r0 = r2.getNextChildIndex();
        if (isValidIndex(r0) == false) goto L8;
    }

    public void addProperty(Property r1) {
        this._properties.add(r1);
    }

    public RootProperty getRoot() {
        return (RootProperty) ZeusTransformUtils.preCheckCast(this._properties.get(0), RootProperty.class, "com.obric.memorydata.plugin");
    }

    public void removeProperty(Property r1) {
        this._properties.remove(r1);
    }

    public void setStartBlock(int r1) {
        this._header_block.setPropertyStart(r1);
    }
}
