package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class InteractiveInfoAtom extends RecordAtom {
    private static final int[] FLAGS_MASKS = null;
    private static final String[] FLAGS_NAMES = null;
    private final byte[] _data;
    private final byte[] _header;

    public static final enum Action extends Enum<Action> {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final Action CUSTOM_SHOW = null;
        public static final Action HYPERLINK = null;
        public static final Action JUMP = null;
        public static final Action MACRO = null;
        public static final Action MEDIA = null;
        public static final Action NONE = null;
        public static final Action OLE = null;
        public static final Action RUN_PROGRAM = null;

        static {
            Action r0 = new Action("NONE", 0);
            NONE = r0;
            Action r1 = new Action("MACRO", 1);
            MACRO = r1;
            Action r3 = new Action("RUN_PROGRAM", 2);
            RUN_PROGRAM = r3;
            Action r5 = new Action("JUMP", 3);
            JUMP = r5;
            Action r7 = new Action("HYPERLINK", 4);
            HYPERLINK = r7;
            Action r9 = new Action("OLE", 5);
            OLE = r9;
            Action r11 = new Action("MEDIA", 6);
            MEDIA = r11;
            Action r13 = new Action("CUSTOM_SHOW", 7);
            CUSTOM_SHOW = r13;
            $VALUES = new Action[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private Action(String r1, int r2) {
            super(r1, r2);
        }

        public static Action valueOf(String r2) {
            return (Action) ZeusTransformUtils.preCheckCast(Enum.valueOf(Action.class, r2), Action.class, "com.obric.memorydata.plugin");
        }

        public static Action[] values() {
            return (Action[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Action[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Jump extends Enum<Jump> {
        private static final /* synthetic */ Jump[] $VALUES = null;
        public static final Jump END_SHOW = null;
        public static final Jump FIRST_SLIDE = null;
        public static final Jump LAST_SLIDE = null;
        public static final Jump LAST_SLIDE_VIEWED = null;
        public static final Jump NEXT_SLIDE = null;
        public static final Jump NONE = null;
        public static final Jump PREVIOUS_SLIDE = null;

        static {
            Jump r0 = new Jump("NONE", 0);
            NONE = r0;
            Jump r1 = new Jump("NEXT_SLIDE", 1);
            NEXT_SLIDE = r1;
            Jump r3 = new Jump("PREVIOUS_SLIDE", 2);
            PREVIOUS_SLIDE = r3;
            Jump r5 = new Jump("FIRST_SLIDE", 3);
            FIRST_SLIDE = r5;
            Jump r7 = new Jump("LAST_SLIDE", 4);
            LAST_SLIDE = r7;
            Jump r9 = new Jump("LAST_SLIDE_VIEWED", 5);
            LAST_SLIDE_VIEWED = r9;
            Jump r11 = new Jump("END_SHOW", 6);
            END_SHOW = r11;
            $VALUES = new Jump[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private Jump(String r1, int r2) {
            super(r1, r2);
        }

        public static Jump valueOf(String r2) {
            return (Jump) ZeusTransformUtils.preCheckCast(Enum.valueOf(Jump.class, r2), Jump.class, "com.obric.memorydata.plugin");
        }

        public static Jump[] values() {
            return (Jump[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Jump[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Link extends Enum<Link> {
        private static final /* synthetic */ Link[] $VALUES = null;
        public static final Link CUSTOM_SHOW = null;
        public static final Link FIRST_SLIDE = null;
        public static final Link LAST_SLIDE = null;
        public static final Link NEXT_SLIDE = null;
        public static final Link NULL = null;
        public static final Link OTHER_FILE = null;
        public static final Link OTHER_PRESENTATION = null;
        public static final Link PREVIOUS_SLIDE = null;
        public static final Link SLIDE_NUMBER = null;
        public static final Link URL = null;

        static {
            Link r0 = new Link("NEXT_SLIDE", 0);
            NEXT_SLIDE = r0;
            Link r1 = new Link("PREVIOUS_SLIDE", 1);
            PREVIOUS_SLIDE = r1;
            Link r3 = new Link("FIRST_SLIDE", 2);
            FIRST_SLIDE = r3;
            Link r5 = new Link("LAST_SLIDE", 3);
            LAST_SLIDE = r5;
            Link r7 = new Link("CUSTOM_SHOW", 4);
            CUSTOM_SHOW = r7;
            Link r9 = new Link("SLIDE_NUMBER", 5);
            SLIDE_NUMBER = r9;
            Link r11 = new Link("URL", 6);
            URL = r11;
            Link r13 = new Link("OTHER_PRESENTATION", 7);
            OTHER_PRESENTATION = r13;
            Link r15 = new Link("OTHER_FILE", 8);
            OTHER_FILE = r15;
            Link r14 = new Link("NULL", 9);
            NULL = r14;
            $VALUES = new Link[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        }

        private Link(String r1, int r2) {
            super(r1, r2);
        }

        public static Link valueOf(String r2) {
            return (Link) ZeusTransformUtils.preCheckCast(Enum.valueOf(Link.class, r2), Link.class, "com.obric.memorydata.plugin");
        }

        public static Link[] values() {
            return (Link[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Link[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        FLAGS_MASKS = new int[]{1, 2, 4, 8};
        FLAGS_NAMES = new String[]{"ANIMATED", "STOP_SOUND", "CUSTOM_SHOW_RETURN", "VISITED"};
    }

    public InteractiveInfoAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        byte[] r1 = new byte[16];
        this._data = r1;
        LittleEndian.putShort(r0, 2, (short) getRecordType());
        LittleEndian.putInt(r0, 4, r1.length);
    }

    public InteractiveInfoAtom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        byte[] r5 = IOUtils.safelyClone(r2, r0, r4 - 8, getMaxRecordLength());
        this._data = r5;
        if (r5.length < 16) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("The length of the data for a InteractiveInfoAtom must be at least 16 bytes, but was only " + r5.length);
    }

    public byte getAction() {
        return this._data[8];
    }

    public byte getFlags() {
        return this._data[11];
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("hyperlinkID", new $$Lambda$s3tHA1X7q5K1_wKLg0x9cKrCGHQ(this), "soundRef", new $$Lambda$lpZDf3KH7Vw4GTMbOJRbioVqEzQ(this), "action", GenericRecordUtil.safeEnum(Action.values(), new $$Lambda$2uYd_LFf6nobsL1iCklEXPEnwiQ(this)), "jump", GenericRecordUtil.safeEnum(Jump.values(), new $$Lambda$0490cntSBNDxPPk21_ngzngw4Jo(this)), "hyperlinkType", GenericRecordUtil.safeEnum(Link.values(), new $$Lambda$zRQboF9iUDso5vYKRFOvueGQQg(this), Link.NULL), "flags", GenericRecordUtil.getBitsAsString(new $$Lambda$UPyWn8Oo13Q9fZ_1VrE9ogU20Q(this), FLAGS_MASKS, FLAGS_NAMES));
    }

    public int getHyperlinkID() {
        return LittleEndian.getInt(this._data, 4);
    }

    public byte getHyperlinkType() {
        return this._data[12];
    }

    public byte getJump() {
        return this._data[10];
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.InteractiveInfoAtom.typeID;
    }

    public int getSoundRef() {
        return LittleEndian.getInt(this._data, 0);
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._data);
    }
}
