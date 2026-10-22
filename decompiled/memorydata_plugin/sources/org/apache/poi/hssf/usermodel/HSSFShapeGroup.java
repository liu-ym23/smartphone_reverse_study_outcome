package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordTypes;
import org.apache.poi.ddf.EscherSpgrRecord;
import org.apache.poi.hssf.record.ObjRecord;

/* JADX INFO: loaded from: classes7.dex */
public class HSSFShapeGroup extends HSSFShape implements HSSFShapeContainer {
    private final EscherSpgrRecord _spgrRecord;
    private final List<HSSFShape> shapes;

    /* JADX INFO: renamed from: org.apache.poi.hssf.usermodel.HSSFShapeGroup$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ddf$EscherRecordTypes = null;

        static {
            int[] r0 = new int[EscherRecordTypes.values().length];
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes = r0;
            r0[EscherRecordTypes.CLIENT_ANCHOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.CHILD_ANCHOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.SPGR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public HSSFShapeGroup(EscherContainerRecord r4, ObjRecord r5) {
        super(r4, r5);
        this.shapes = new ArrayList();
        EscherContainerRecord r6 = (EscherContainerRecord) ZeusTransformUtils.preCheckCast(r4.getChildContainers().get(0), EscherContainerRecord.class, "com.obric.memorydata.plugin");
        this._spgrRecord = (EscherSpgrRecord) ZeusTransformUtils.preCheckCast(r6.getChild(0), EscherSpgrRecord.class, "com.obric.memorydata.plugin");
        Iterator<EscherRecord> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        EscherRecord r8 = (EscherRecord) ZeusTransformUtils.preCheckCast(r7.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.forTypeID(r8.getRecordId()).ordinal()];
        if (r0 == 1) goto L11;
        if (r0 != 2) goto L4;
        HSSFAnchor r1 = new HSSFChildAnchor((EscherChildAnchorRecord) ZeusTransformUtils.preCheckCast(r8, EscherChildAnchorRecord.class, "com.obric.memorydata.plugin"));
    L12:
        this.anchor = r1;
        goto L4
    L11:
        r1 = new HSSFClientAnchor((EscherClientAnchorRecord) ZeusTransformUtils.preCheckCast(r8, EscherClientAnchorRecord.class, "com.obric.memorydata.plugin"));
        goto L12
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public void addShape(HSSFShape r2) {
        r2.setPatriarch(getPatriarch());
        r2.setParent(this);
        this.shapes.add(r2);
    }

    @Override // java.lang.Iterable
    public Iterator<HSSFShape> iterator() {
        return this.shapes.iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<HSSFShape> spliterator() {
        return this.shapes.spliterator();
    }
}
