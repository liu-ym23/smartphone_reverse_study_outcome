package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherRGBProperty;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordTypes;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherSpgrRecord;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class PPDrawing extends RecordAtom implements Iterable<EscherRecord> {
    private final byte[] _header;
    private long _type;
    private EscherDgRecord dg;
    private final EscherContainerRecord dgContainer;
    private EscherTextboxWrapper[] textboxWrappers;

    public PPDrawing() {
        this.dgContainer = new EscherContainerRecord();
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putUShort(r0, 0, 15);
        LittleEndian.putUShort(r0, 2, RecordTypes.PPDrawing.typeID);
        LittleEndian.putInt(r0, 4, 0);
        this.textboxWrappers = new EscherTextboxWrapper[0];
        create();
    }

    PPDrawing(byte[] r4, int r5, int r6) {
        EscherContainerRecord r7 = new EscherContainerRecord();
        this.dgContainer = r7;
        int r0 = r5 + 8;
        byte[] r8 = Arrays.copyOfRange(r4, r5, r0);
        this._header = r8;
        this._type = LittleEndian.getUShort(r8, 2);
        r7.fillFields(r4, r0, new HSLFEscherRecordFactory());
        if (r7.getRecordId() != EscherRecordTypes.DG_CONTAINER.typeID) goto L7;
        this.dg = (EscherDgRecord) ZeusTransformUtils.preCheckCast(r7.getChildById(EscherRecordTypes.DG.typeID), EscherDgRecord.class, "com.obric.memorydata.plugin");
        this.textboxWrappers = (EscherTextboxWrapper[]) ZeusTransformUtils.preCheckCast(Stream.of(r7).flatMap(findEscherContainer(EscherRecordTypes.SPGR_CONTAINER)).flatMap(findEscherContainer(EscherRecordTypes.SP_CONTAINER)).flatMap($$Lambda$PPDrawing$KiEtvmpAE2hfcPkeQ15nGE0npso.INSTANCE).toArray($$Lambda$PPDrawing$wilCwF6814o1FUBseDPiCFJUV_4.INSTANCE), EscherTextboxWrapper[].class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new IllegalArgumentException("Unexpected record type: " + r7.getRecordId());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void create() {
        this.dgContainer.setRecordId(EscherContainerRecord.DG_CONTAINER);
        this.dgContainer.setOptions(15);
        EscherDgRecord r0 = new EscherDgRecord();
        this.dg = r0;
        r0.setOptions(16);
        this.dg.setNumShapes(1);
        this.dgContainer.addChildRecord(this.dg);
        EscherContainerRecord r1 = new EscherContainerRecord();
        r1.setOptions(15);
        r1.setRecordId(EscherContainerRecord.SPGR_CONTAINER);
        EscherContainerRecord r3 = new EscherContainerRecord();
        r3.setOptions(15);
        r3.setRecordId(EscherContainerRecord.SP_CONTAINER);
        EscherSpgrRecord r4 = new EscherSpgrRecord();
        r4.setOptions(1);
        r3.addChildRecord(r4);
        EscherSpRecord r2 = new EscherSpRecord();
        r2.setOptions((short) ((ShapeType.NOT_PRIMITIVE.nativeId << 4) + 2));
        r2.setFlags(5);
        r3.addChildRecord(r2);
        r1.addChildRecord(r3);
        this.dgContainer.addChildRecord(r1);
        EscherContainerRecord r5 = new EscherContainerRecord();
        r5.setOptions(15);
        r5.setRecordId(EscherContainerRecord.SP_CONTAINER);
        EscherSpRecord r6 = new EscherSpRecord();
        r6.setOptions((short) ((ShapeType.RECT.nativeId << 4) + 2));
        r6.setFlags(3072);
        r5.addChildRecord(r6);
        EscherOptRecord r7 = new EscherOptRecord();
        r7.setRecordId(EscherOptRecord.RECORD_ID);
        r7.addEscherProperty(new EscherRGBProperty(EscherPropertyTypes.FILL__FILLCOLOR, 134217728));
        r7.addEscherProperty(new EscherRGBProperty(EscherPropertyTypes.FILL__FILLBACKCOLOR, 134217733));
        r7.addEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.FILL__RECTRIGHT, 10064750));
        r7.addEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.FILL__RECTBOTTOM, 7778750));
        r7.addEscherProperty(new EscherBoolProperty(EscherPropertyTypes.FILL__NOFILLHITTEST, 1179666));
        r7.addEscherProperty(new EscherBoolProperty(EscherPropertyTypes.LINESTYLE__NOLINEDRAWDASH, 524288));
        r7.addEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.SHAPE__BLACKANDWHITESETTINGS, 9));
        r7.addEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.SHAPE__BACKGROUNDSHAPE, 65537));
        r5.addChildRecord(r7);
        this.dgContainer.addChildRecord(r5);
    }

    private static Function<EscherContainerRecord, Stream<EscherContainerRecord>> findEscherContainer(final EscherRecordTypes r1) {
        return new $$Lambda$PPDrawing$IAx4fuX547Lh_AKFlmpfNMKbDWY(r1);
    }

    private static Stream<StyleTextProp9Atom> findInProgBinaryTag(Record r4) {
        Record[] r5 = r4.getChildRecords();
        if (r5 == null) goto L17;
        if (r5.length != 2) goto L17;
        if (ZeusTransformUtils.instanceOf(r5[0], CString.class) == false) goto L17;
        if (ZeusTransformUtils.instanceOf(r5[1], BinaryTagDataBlob.class) == false) goto L17;
        if ("___PPT9".equals(((CString) ZeusTransformUtils.preCheckCast(r5[0], CString.class, "com.obric.memorydata.plugin")).getText()) == false) goto L17;
        StyleTextProp9Atom r6 = (StyleTextProp9Atom) ZeusTransformUtils.preCheckCast(((BinaryTagDataBlob) ZeusTransformUtils.preCheckCast(r5[1], BinaryTagDataBlob.class, "com.obric.memorydata.plugin")).findFirstOfType(RecordTypes.StyleTextProp9Atom.typeID), StyleTextProp9Atom.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L17;
        return Stream.of(r6);
    L17:
        return Stream.empty();
    }

    private static Optional<StyleTextProp9Atom> findInSpContainer(EscherContainerRecord r2) {
        return ((Stream) ZeusTransformUtils.preCheckCast(firstEscherRecord(r2, EscherRecordTypes.CLIENT_DATA).map($$Lambda$OHASAFlqdiFlSmHDlGh_0zalQ4.INSTANCE).map($$Lambda$2uajARPg7zs3QXdN3ekutEAqAgM.INSTANCE).orElseGet($$Lambda$PPDrawing$cCGlUYZBvl9Zymt4g0wOcziB0gg.INSTANCE), Stream.class, "com.obric.memorydata.plugin")).filter(sameHSLF(RecordTypes.ProgTags)).flatMap($$Lambda$PPDrawing$sMYRaWVRctwvqbBOwZGXkRdHWr4.INSTANCE).filter(sameHSLF(RecordTypes.ProgBinaryTag)).flatMap($$Lambda$PPDrawing$eaPlaCYWUik0FOHfaV_Zy_EkBT0.INSTANCE).findFirst();
    }

    private static <T extends EscherRecord> Optional<T> firstEscherRecord(Iterable<EscherRecord> r2, EscherRecordTypes r3) {
        return StreamSupport.stream(((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin")).spliterator(), false).filter(sameEscher(r3)).map($$Lambda$PPDrawing$H3n2SI_N5BJEECBum9jG2fTplok.INSTANCE).findFirst();
    }

    private static Stream<EscherTextboxWrapper> getTextboxHelper(EscherContainerRecord r4) {
        Optional r0 = firstEscherRecord(r4, EscherRecordTypes.CLIENT_TEXTBOX);
        if (r0.isPresent() == false) goto L5;
        final EscherTextboxWrapper r1 = new EscherTextboxWrapper((EscherTextboxRecord) ZeusTransformUtils.preCheckCast(r0.get(), EscherTextboxRecord.class, "com.obric.memorydata.plugin"));
        findInSpContainer(r4).ifPresent(new $$Lambda$xiSerAFXrufLRaKkD55DTkAar4(r1));
        firstEscherRecord(r4, EscherRecordTypes.SP).map($$Lambda$CesoHbKtXiEMK9QkPkQ9bqYft1o.INSTANCE).ifPresent(new $$Lambda$KO8WoNS1VW4SIYfT9E1uSdgpY(r1));
        return Stream.of(r1);
    L5:
        return Stream.empty();
    }

    public static /* synthetic */ Stream lambda$KiEtvmpAE2hfcPkeQ15nGE0npso(EscherContainerRecord r0) {
        return getTextboxHelper(r0);
    }

    public static /* synthetic */ Stream lambda$cCGlUYZBvl9Zymt4g0wOcziB0gg() {
        return Stream.empty();
    }

    public static /* synthetic */ Stream lambda$eaPlaCYWUik0FOHfaV_Zy_EkBT0(Record r0) {
        return findInProgBinaryTag(r0);
    }

    static /* synthetic */ Stream lambda$findEscherContainer$6(EscherRecordTypes r0, EscherContainerRecord r1) {
        return r1.getChildContainers().stream().filter(sameEscher(r0));
    }

    static /* synthetic */ Stream lambda$findInSpContainer$1(Record r0) {
        return Stream.of(r0.getChildRecords());
    }

    static /* synthetic */ EscherRecord lambda$firstEscherRecord$5(EscherRecord r0) {
        return r0;
    }

    static /* synthetic */ EscherTextboxWrapper[] lambda$new$0(int r0) {
        return new EscherTextboxWrapper[r0];
    }

    static /* synthetic */ boolean lambda$sameEscher$4(EscherRecordTypes r0, EscherRecord r1) {
        if (r1.getRecordId() != r0.typeID) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean lambda$sameHSLF$3(RecordTypes r2, Record r3) {
        if (r3.getRecordType() != r2.typeID) goto L5;
        return true;
    L5:
        return false;
    }

    private static Predicate<EscherRecord> sameEscher(final EscherRecordTypes r1) {
        return new $$Lambda$PPDrawing$_vy0i_retGASAkjmbgHaufBr8A(r1);
    }

    private static Predicate<Record> sameHSLF(final RecordTypes r1) {
        return new $$Lambda$PPDrawing$BVZeFnfiGY6zZnDBMK3yOJgg10o(r1);
    }

    @Override // org.apache.poi.hslf.record.RecordAtom, org.apache.poi.hslf.record.Record
    public Record[] getChildRecords() {
        return null;
    }

    public EscherContainerRecord getDgContainer() {
        return this.dgContainer;
    }

    public List<EscherRecord> getEscherRecords() {
        return Collections.singletonList(this.dgContainer);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("escherRecords", new $$Lambda$d1mswtb4RkKDK8KHPzZ469uKGE(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return this._type;
    }

    public EscherTextboxWrapper[] getTextboxWrappers() {
        return this.textboxWrappers;
    }

    @Override // java.lang.Iterable
    public Iterator<EscherRecord> iterator() {
        return getEscherRecords().iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<EscherRecord> spliterator() {
        return getEscherRecords().spliterator();
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r7) {
        EscherTextboxWrapper[] r0 = this.textboxWrappers;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0[r3].writeOut(null);
        r3 = r3 + 1;
        goto L3
    L5:
        int r2 = this.dgContainer.getRecordSize() + 0;
        LittleEndian.putInt(this._header, 4, r2);
        r7.write(this._header);
        byte[] r4 = new byte[r2];
        this.dgContainer.serialize(0, r4);
        r7.write(r4);
    }
}
