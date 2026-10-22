package org.apache.poi.hwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hwpf.model.FieldsDocumentPart;
import org.apache.poi.hwpf.model.FieldsTables;
import org.apache.poi.hwpf.model.PlexOfField;

/* JADX INFO: loaded from: classes7.dex */
public class FieldsImpl implements Fields {
    private Map<FieldsDocumentPart, Map<Integer, FieldImpl>> _fieldsByOffset;
    private PlexOfFieldComparator comparator;

    /* JADX INFO: renamed from: org.apache.poi.hwpf.usermodel.FieldsImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class PlexOfFieldComparator implements Serializable, Comparator<PlexOfField> {
        private PlexOfFieldComparator() {
        }

        /* synthetic */ PlexOfFieldComparator(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(PlexOfField r3, PlexOfField r4) {
            return compare2((PlexOfField) ZeusTransformUtils.preCheckCast(r3, PlexOfField.class, "com.obric.memorydata.plugin"), (PlexOfField) ZeusTransformUtils.preCheckCast(r4, PlexOfField.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(PlexOfField r1, PlexOfField r2) {
            return Integer.compare(r1.getFcStart(), r2.getFcStart());
        }
    }

    public FieldsImpl(FieldsTables r7) {
        this.comparator = new PlexOfFieldComparator(null);
        this._fieldsByOffset = new HashMap(FieldsDocumentPart.values().length);
        FieldsDocumentPart[] r0 = FieldsDocumentPart.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        FieldsDocumentPart r3 = r0[r2];
        ArrayList<PlexOfField> r4 = r7.getFieldsPLCF(r3);
        this._fieldsByOffset.put(r3, parseFieldStructure(r4));
        r2 = r2 + 1;
        goto L3
    }

    private static int binarySearch(List<PlexOfField> r6, int r7, int r8, int r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        checkIndexForBinarySearch(r10.size(), r7, r8);
        int r0 = r8 - 1;
        int r2 = -1;
        int r3 = r7;
    L3:
        if (r3 > r0) goto L10;
        r2 = (r3 + r0) >>> 1;
        int r4 = ((PlexOfField) ZeusTransformUtils.preCheckCast(r10.get(r2), PlexOfField.class, "com.obric.memorydata.plugin")).getFcStart();
        if (r4 == r9) goto L6;
        if (r4 < r9) goto L8;
        r0 = r2 - 1;
        goto L3
    L8:
        r3 = r2 + 1;
        goto L3
    L6:
        return r2;
    L10:
        if (r2 >= 0) goto L20;
        int r1 = r8;
    L12:
        if (r7 >= r8) goto L17;
        if (r9 >= ((PlexOfField) ZeusTransformUtils.preCheckCast(r10.get(r7), PlexOfField.class, "com.obric.memorydata.plugin")).getFcStart()) goto L16;
        r1 = r7;
    L16:
        r7 = r7 + 1;
        goto L12
    L17:
        int r11 = -r1;
    L19:
        return r11 - 1;
    L20:
        r11 = -r2;
        goto L19
    }

    private static void checkIndexForBinarySearch(int r0, int r1, int r2) {
        if (r1 > r2) goto L9;
        if (r0 < r2) goto L7;
        if (r1 < 0) goto L7;
        return;
    L7:
        throw new ArrayIndexOutOfBoundsException();
    L9:
        throw new IllegalArgumentException();
    }

    private Map<Integer, FieldImpl> parseFieldStructure(List<PlexOfField> r5) {
        List<PlexOfField> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L13;
        if (r6.isEmpty() == true) goto L13;
        r6.sort(this.comparator);
        ArrayList r0 = new ArrayList((r6.size() / 3) + 1);
        parseFieldStructureImpl(r6, 0, r6.size(), r0);
        HashMap r4 = new HashMap(r0.size());
        Iterator<FieldImpl> r7 = r0.iterator();
    L9:
        if (r7.hasNext() == false) goto L11;
        FieldImpl r1 = (FieldImpl) ZeusTransformUtils.preCheckCast(r7.next(), FieldImpl.class, "com.obric.memorydata.plugin");
        r4.put(Integer.valueOf(r1.getFieldStartOffset()), r1);
        goto L9
    L11:
        return r4;
    L13:
        return new HashMap();
    }

    private void parseFieldStructureImpl(List<PlexOfField> r9, int r10, int r11, List<FieldImpl> r12) {
        List<PlexOfField> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<FieldImpl> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
    L3:
        if (r10 >= r11) goto L31;
        PlexOfField r0 = (PlexOfField) ZeusTransformUtils.preCheckCast(r13.get(r10), PlexOfField.class, "com.obric.memorydata.plugin");
        r10 = r10 + 1;
        if (r0.getFld().getBoundaryType() != 19) goto L3;
        int r2 = binarySearch(r13, r10, r11, r0.getFcEnd());
        if (r2 < 0) goto L3;
        PlexOfField r3 = (PlexOfField) ZeusTransformUtils.preCheckCast(r13.get(r2), PlexOfField.class, "com.obric.memorydata.plugin");
        int r4 = r3.getFld().getBoundaryType();
        if (r4 != 20) goto L12;
        int r5 = binarySearch(r13, r2, r11, r3.getFcEnd());
        if (r5 < 0) goto L3;
        PlexOfField r6 = (PlexOfField) ZeusTransformUtils.preCheckCast(r13.get(r5), PlexOfField.class, "com.obric.memorydata.plugin");
        if (r6.getFld().getBoundaryType() != 21) goto L3;
        r14.add(new FieldImpl(r0, r3, r6));
        if ((r0.getFcStart() + 1) >= (r3.getFcStart() - 1)) goto L28;
        parseFieldStructureImpl(r13, r10, r2, r14);
    L28:
        if ((r3.getFcStart() + 1) >= (r6.getFcStart() - 1)) goto L30;
        parseFieldStructureImpl(r13, r2 + 1, r5, r14);
    L30:
        r10 = r5 + 1;
        goto L3
    L12:
        if (r4 != 21) goto L3;
        r14.add(new FieldImpl(r0, null, r3));
        if ((r0.getFcStart() + 1) >= (r3.getFcStart() - 1)) goto L17;
        parseFieldStructureImpl(r13, r10, r2, r14);
    L17:
        r10 = r2 + 1;
        goto L3
    }
}
