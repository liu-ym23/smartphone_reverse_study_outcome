package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public final class EscherArrayProperty extends EscherComplexProperty implements Iterable<byte[]> {
    private static int MAX_RECORD_LENGTH = 100000;
    private final boolean emptyComplexPart;
    private boolean sizeIncludesHeaderSize;

    static {
    }

    public EscherArrayProperty(short r1, int r2) {
        super(r1, r2);
        boolean r3 = true;
        this.sizeIncludesHeaderSize = true;
        if (r2 == 0) goto L6;
        r3 = false;
    L6:
        this.emptyComplexPart = r3;
    }

    private static int getActualSizeOfElements(short r0) {
        if (r0 < 0) goto L4;
        return r0;
    L4:
        return (short) ((-r0) >> 2);
    }

    public byte[] getElement(int r3) {
        int r0 = getActualSizeOfElements(getSizeOfElements());
        return IOUtils.safelyClone(getComplexData(), (r3 * r0) + 6, r0, MAX_RECORD_LENGTH);
    }

    @Override // org.apache.poi.ddf.EscherComplexProperty, org.apache.poi.ddf.EscherProperty, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherArrayProperty$S9WRbcTfZfj0qLzmKtqhkOIkA8c(this), "numElements", new $$Lambda$sbKldV7hAM5G4rbIbQuySV2xdqI(this), "numElementsInMemory", new $$Lambda$yvDQAcMYCd72C9Ed4J4snfVaY(this), "sizeOfElements", new $$Lambda$IiAp5NbteQgyPFB0eJDRuhcjjRk(this), "elements", new $$Lambda$EscherArrayProperty$U5q7ajGQnmirXirZBfCJCZ5hsE(this));
    }

    public int getNumberOfElementsInArray() {
        if (this.emptyComplexPart == false) goto L6;
        return 0;
    L6:
        return LittleEndian.getUShort(getComplexData(), 0);
    }

    public int getNumberOfElementsInMemory() {
        if (this.emptyComplexPart == false) goto L6;
        return 0;
    L6:
        return LittleEndian.getUShort(getComplexData(), 2);
    }

    public short getSizeOfElements() {
        if (this.emptyComplexPart == false) goto L6;
        return 0;
    L6:
        return LittleEndian.getShort(getComplexData(), 4);
    }

    @Override // java.lang.Iterable
    public Iterator<byte[]> iterator() {
        return new AnonymousClass1(this);
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherArrayProperty() {
        return super.getGenericProperties();
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$EscherArrayProperty() {
        return (List) ZeusTransformUtils.preCheckCast(StreamSupport.stream(spliterator(), false).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ddf.EscherComplexProperty, org.apache.poi.ddf.EscherProperty
    public int serializeSimplePart(byte[] r2, int r3) {
        LittleEndian.putShort(r2, r3, getId());
        int r0 = getComplexData().length;
        if (this.sizeIncludesHeaderSize == true) goto L5;
        r0 = r0 - 6;
    L5:
        LittleEndian.putInt(r2, r3 + 2, r0);
        return 6;
    }

    public int setArrayData(byte[] r5, int r6) {
        if (this.emptyComplexPart == false) goto L5;
        resizeComplexData(0);
    L10:
        return getComplexData().length;
    L5:
        short r0 = LittleEndian.getShort(r5, r6);
        short r2 = LittleEndian.getShort(r5, r6 + 4);
        int r3 = getComplexData().length;
        int r4 = getActualSizeOfElements(r2) * r0;
        if (r4 != r3) goto L8;
        resizeComplexData(r4 + 6, 0);
        this.sizeIncludesHeaderSize = false;
    L8:
        setComplexData(r5, r6);
        goto L10
    }

    @Override // java.lang.Iterable
    public Spliterator<byte[]> spliterator() {
        return Spliterators.spliterator(iterator(), getNumberOfElementsInArray(), 0);
    }
}
