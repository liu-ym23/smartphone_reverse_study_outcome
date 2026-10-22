package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordTypes;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EmbeddedObjectRefSubRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SubRecord;
import org.apache.poi.hssf.record.TextObjectRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public class HSSFShapeFactory {

    /* JADX INFO: renamed from: org.apache.poi.hssf.usermodel.HSSFShapeFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ddf$EscherRecordTypes = null;

        static {
            int[] r0 = new int[EscherRecordTypes.values().length];
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes = r0;
            r0[EscherRecordTypes.CLIENT_DATA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.CLIENT_TEXTBOX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static void createShapeTree(EscherContainerRecord r11, final EscherAggregate r12, HSSFShapeContainer r13, final DirectoryNode r14) {
        HSSFShapeContainer r15 = (HSSFShapeContainer) ZeusTransformUtils.wrapperContextForParams(r13, HSSFShapeContainer.class, "com.obric.memorydata.plugin");
        ObjRecord r4 = null;
        if (r11.getRecordId() != EscherContainerRecord.SPGR_CONTAINER) goto L12;
        EscherClientDataRecord r0 = (EscherClientDataRecord) ZeusTransformUtils.preCheckCast(((EscherContainerRecord) ZeusTransformUtils.preCheckCast(r11.getChild(0), EscherContainerRecord.class, "com.obric.memorydata.plugin")).getChildById(EscherClientDataRecord.RECORD_ID), EscherClientDataRecord.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        r4 = (ObjRecord) ZeusTransformUtils.preCheckCast(r12.getShapeToObjMapping().get(r0), ObjRecord.class, "com.obric.memorydata.plugin");
    L7:
        final HSSFShapeGroup r1 = new HSSFShapeGroup(r11, r4);
        List<EscherContainerRecord> r16 = r11.getChildContainers();
        if (r16.size() <= 1) goto L10;
        r16.subList(1, r16.size()).forEach(new $$Lambda$HSSFShapeFactory$X48KWdkQCdUDNYueuaQGU6BVm2M(r12, r1, r14));
    L10:
        r15.addShape(r1);
        return;
    L12:
        if (r11.getRecordId() != EscherContainerRecord.SP_CONTAINER) goto L66;
        Map<EscherRecord, Record> r2 = r12.getShapeToObjMapping();
        Iterator<EscherRecord> r3 = r11.iterator();
        TextObjectRecord r6 = null;
    L15:
        if (r3.hasNext() == false) goto L22;
        EscherRecord r7 = (EscherRecord) ZeusTransformUtils.preCheckCast(r3.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        int r9 = AnonymousClass1.$SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.forTypeID(r7.getRecordId()).ordinal()];
        if (r9 != 1) goto L18;
        r4 = (ObjRecord) ZeusTransformUtils.preCheckCast(r2.get(r7), ObjRecord.class, "com.obric.memorydata.plugin");
        goto L15
    L18:
        if (r9 != 2) goto L15;
        r6 = (TextObjectRecord) ZeusTransformUtils.preCheckCast(r2.get(r7), TextObjectRecord.class, "com.obric.memorydata.plugin");
        goto L15
    L22:
        if (r4 == null) goto L56;
        if (isEmbeddedObject(r4) == false) goto L27;
        r15.addShape(new HSSFObjectData(r11, r4, r14));
        return;
    L27:
        short r17 = ((CommonObjectDataSubRecord) ZeusTransformUtils.preCheckCast(r4.getSubRecords().get(0), CommonObjectDataSubRecord.class, "com.obric.memorydata.plugin")).getObjectType();
        if (r17 == 1) goto L53;
        if (r17 != 2) goto L31;
        HSSFShape r18 = new HSSFSimpleShape(r11, r4, r6);
    L54:
        r15.addShape(r18);
        return;
    L31:
        if (r17 != 6) goto L33;
        r18 = new HSSFTextbox(r11, r4, r6);
        goto L54
    L33:
        if (r17 != 8) goto L35;
        r18 = new HSSFPicture(r11, r4);
        goto L54
    L35:
        if (r17 != 20) goto L37;
        r18 = new HSSFCombobox(r11, r4);
        goto L54
    L37:
        if (r17 != 25) goto L39;
        r18 = new HSSFComment(r11, r4, r6, r12.getNoteRecordByObj(r4));
        goto L54
    L39:
        if (r17 == 30) goto L41;
        r18 = new HSSFSimpleShape(r11, r4, r6);
        goto L54
    L41:
        EscherOptRecord r19 = (EscherOptRecord) ZeusTransformUtils.preCheckCast(r11.getChildById(EscherOptRecord.RECORD_ID), EscherOptRecord.class, "com.obric.memorydata.plugin");
        if (r19 != null) goto L45;
        r18 = new HSSFSimpleShape(r11, r4, r6);
        goto L54
    L45:
        if (r19.lookup(EscherPropertyTypes.GEOMETRY__VERTICES) == null) goto L47;
        r18 = new HSSFPolygon(r11, r4, r6);
        goto L54
    L47:
        r18 = new HSSFSimpleShape(r11, r4, r6);
        goto L54
    L53:
        r18 = new HSSFSimpleShape(r11, r4);
        goto L54
    L56:
        throw new RecordFormatException("EscherClientDataRecord can't be found.");
    }

    private static boolean isEmbeddedObject(ObjRecord r3) {
        Iterator<SubRecord> r4 = r3.getSubRecords().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        if (ZeusTransformUtils.instanceOf((SubRecord) ZeusTransformUtils.preCheckCast(r4.next(), SubRecord.class, "com.obric.memorydata.plugin"), EmbeddedObjectRefSubRecord.class) == false) goto L4;
        return true;
    L9:
        return false;
    }

    static /* synthetic */ void lambda$createShapeTree$0(EscherAggregate r0, HSSFShapeGroup r1, DirectoryNode r2, EscherContainerRecord r3) {
        createShapeTree(r3, r0, r1, r2);
    }
}
