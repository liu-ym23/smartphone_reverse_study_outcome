package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class ExOleObjAtom extends RecordAtom {
    private static final int[] DRAWASPECT_MASKS = null;
    private static final String[] DRAWASPECT_NAMES = null;
    private byte[] _data;
    private byte[] _header;

    public static final enum OleType extends Enum<OleType> {
        private static final /* synthetic */ OleType[] $VALUES = null;
        public static final OleType CONTROL = null;
        public static final OleType EMBEDDED = null;
        public static final OleType LINKED = null;

        static {
            OleType r0 = new OleType("EMBEDDED", 0);
            EMBEDDED = r0;
            OleType r1 = new OleType("LINKED", 1);
            LINKED = r1;
            OleType r3 = new OleType("CONTROL", 2);
            CONTROL = r3;
            $VALUES = new OleType[]{r0, r1, r3};
        }

        private OleType(String r1, int r2) {
            super(r1, r2);
        }

        public static OleType valueOf(String r2) {
            return (OleType) ZeusTransformUtils.preCheckCast(Enum.valueOf(OleType.class, r2), OleType.class, "com.obric.memorydata.plugin");
        }

        public static OleType[] values() {
            return (OleType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OleType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Subtype extends Enum<Subtype> {
        private static final /* synthetic */ Subtype[] $VALUES = null;
        public static final Subtype CLIPART_GALLERY = null;
        public static final Subtype DEFAULT = null;
        public static final Subtype EQUATION = null;
        public static final Subtype EXCEL = null;
        public static final Subtype EXCEL_CHART = null;
        public static final Subtype GRAPH = null;
        public static final Subtype IMAGE = null;
        public static final Subtype MEDIA_PLAYER = null;
        public static final Subtype NOTEIT = null;
        public static final Subtype ORGANIZATION_CHART = null;
        public static final Subtype POWERPOINT_PRESENTATION = null;
        public static final Subtype POWERPOINT_SLIDE = null;
        public static final Subtype PROJECT = null;
        public static final Subtype SOUND = null;
        public static final Subtype WORDART = null;
        public static final Subtype WORD_TABLE = null;

        static {
            Subtype r0 = new Subtype("DEFAULT", 0);
            DEFAULT = r0;
            Subtype r1 = new Subtype("CLIPART_GALLERY", 1);
            CLIPART_GALLERY = r1;
            Subtype r3 = new Subtype("WORD_TABLE", 2);
            WORD_TABLE = r3;
            Subtype r5 = new Subtype("EXCEL", 3);
            EXCEL = r5;
            Subtype r7 = new Subtype("GRAPH", 4);
            GRAPH = r7;
            Subtype r9 = new Subtype("ORGANIZATION_CHART", 5);
            ORGANIZATION_CHART = r9;
            Subtype r11 = new Subtype("EQUATION", 6);
            EQUATION = r11;
            Subtype r13 = new Subtype("WORDART", 7);
            WORDART = r13;
            Subtype r15 = new Subtype("SOUND", 8);
            SOUND = r15;
            Subtype r14 = new Subtype("IMAGE", 9);
            IMAGE = r14;
            Subtype r12 = new Subtype("POWERPOINT_PRESENTATION", 10);
            POWERPOINT_PRESENTATION = r12;
            Subtype r10 = new Subtype("POWERPOINT_SLIDE", 11);
            POWERPOINT_SLIDE = r10;
            Subtype r8 = new Subtype("PROJECT", 12);
            PROJECT = r8;
            Subtype r6 = new Subtype("NOTEIT", 13);
            NOTEIT = r6;
            Subtype r4 = new Subtype("EXCEL_CHART", 14);
            EXCEL_CHART = r4;
            Subtype r2 = new Subtype("MEDIA_PLAYER", 15);
            MEDIA_PLAYER = r2;
            $VALUES = new Subtype[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
        }

        private Subtype(String r1, int r2) {
            super(r1, r2);
        }

        public static Subtype valueOf(String r2) {
            return (Subtype) ZeusTransformUtils.preCheckCast(Enum.valueOf(Subtype.class, r2), Subtype.class, "com.obric.memorydata.plugin");
        }

        public static Subtype[] values() {
            return (Subtype[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Subtype[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        DRAWASPECT_MASKS = new int[]{1, 2, 4, 8};
        DRAWASPECT_NAMES = new String[]{"CONTENT", "THUMBNAIL", "ICON", "DOCPRINT"};
    }

    public ExOleObjAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        this._data = new byte[24];
        LittleEndian.putShort(r0, 0, 1);
        LittleEndian.putShort(this._header, 2, (short) getRecordType());
        LittleEndian.putInt(this._header, 4, this._data.length);
    }

    public ExOleObjAtom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        byte[] r5 = IOUtils.safelyClone(r2, r0, r4 - 8, 10485760);
        this._data = r5;
        if (r5.length < 24) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("The length of the data for a ExOleObjAtom must be at least 24 bytes, but was only " + this._data.length);
    }

    public int getDrawAspect() {
        return LittleEndian.getInt(this._data, 0);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("drawAspect", GenericRecordUtil.getBitsAsString(new $$Lambda$L7BRqv90xheQro1jRAxF3nEK3KE(this), DRAWASPECT_MASKS, DRAWASPECT_NAMES), "type", GenericRecordUtil.safeEnum(OleType.values(), new $$Lambda$oYKXoPJr6KsW2uQje6Lo1UZ6qBY(this)), "objID", new $$Lambda$22vyve0YiY3rkJSsTvlRpRkjEIo(this), "subType", GenericRecordUtil.safeEnum(Subtype.values(), new $$Lambda$4AM3OQ2TSPwedcOOTdE9idKu034(this)), "objStgDataRef", new $$Lambda$NYZtKCkeI4broRzL7IS9stlkwbc(this), "options", new $$Lambda$psXuYtD3UZ9qqnnMhOfrCAC5Z78(this));
    }

    public int getObjID() {
        return LittleEndian.getInt(this._data, 8);
    }

    public int getObjStgDataRef() {
        return LittleEndian.getInt(this._data, 16);
    }

    public int getOptions() {
        return LittleEndian.getInt(this._data, 20);
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.ExOleObjAtom.typeID;
    }

    public int getSubType() {
        return LittleEndian.getInt(this._data, 12);
    }

    public int getType() {
        return LittleEndian.getInt(this._data, 4);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._data);
    }
}
