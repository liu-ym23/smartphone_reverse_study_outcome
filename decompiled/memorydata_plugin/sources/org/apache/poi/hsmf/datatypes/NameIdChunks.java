package org.apache.poi.hsmf.datatypes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hpsf.ClassID;

/* JADX INFO: loaded from: classes7.dex */
public final class NameIdChunks {

    public static final enum PredefinedPropertySet extends Enum<PredefinedPropertySet> {
        private static final /* synthetic */ PredefinedPropertySet[] $VALUES = null;
        public static final PredefinedPropertySet PSETID_ADDRESS = null;
        public static final PredefinedPropertySet PSETID_AIR_SYNC = null;
        public static final PredefinedPropertySet PSETID_APPOINTMENT = null;
        public static final PredefinedPropertySet PSETID_ATTACHMENT = null;
        public static final PredefinedPropertySet PSETID_COMMON = null;
        public static final PredefinedPropertySet PSETID_LOG = null;
        public static final PredefinedPropertySet PSETID_MEETING = null;
        public static final PredefinedPropertySet PSETID_MESSAGING = null;
        public static final PredefinedPropertySet PSETID_NOTE = null;
        public static final PredefinedPropertySet PSETID_POST_RSS = null;
        public static final PredefinedPropertySet PSETID_SHARING = null;
        public static final PredefinedPropertySet PSETID_TASK = null;
        public static final PredefinedPropertySet PSETID_UNIFIED_MESSAGING = null;
        public static final PredefinedPropertySet PSETID_XML_EXTRACTED_ENTITIES = null;
        private final ClassID classID;

        static {
            PredefinedPropertySet r0 = new PredefinedPropertySet("PSETID_COMMON", 0, "00062008-0000-0000-C000-000000000046");
            PSETID_COMMON = r0;
            PredefinedPropertySet r1 = new PredefinedPropertySet("PSETID_ADDRESS", 1, "00062004-0000-0000-C000-000000000046");
            PSETID_ADDRESS = r1;
            PredefinedPropertySet r3 = new PredefinedPropertySet("PSETID_APPOINTMENT", 2, "00062002-0000-0000-C000-000000000046");
            PSETID_APPOINTMENT = r3;
            PredefinedPropertySet r5 = new PredefinedPropertySet("PSETID_MEETING", 3, "6ED8DA90-450B-101B-98DA-00AA003F1305");
            PSETID_MEETING = r5;
            PredefinedPropertySet r7 = new PredefinedPropertySet("PSETID_LOG", 4, "0006200A-0000-0000-C000-000000000046");
            PSETID_LOG = r7;
            PredefinedPropertySet r9 = new PredefinedPropertySet("PSETID_MESSAGING", 5, "41F28F13-83F4-4114-A584-EEDB5A6B0BFF");
            PSETID_MESSAGING = r9;
            PredefinedPropertySet r11 = new PredefinedPropertySet("PSETID_NOTE", 6, "0006200E-0000-0000-C000-000000000046");
            PSETID_NOTE = r11;
            PredefinedPropertySet r13 = new PredefinedPropertySet("PSETID_POST_RSS", 7, "00062041-0000-0000-C000-000000000046");
            PSETID_POST_RSS = r13;
            PredefinedPropertySet r12 = new PredefinedPropertySet("PSETID_TASK", 8, "00062003-0000-0000-C000-000000000046");
            PSETID_TASK = r12;
            PredefinedPropertySet r10 = new PredefinedPropertySet("PSETID_UNIFIED_MESSAGING", 9, "4442858E-A9E3-4E80-B900-317A210CC15B");
            PSETID_UNIFIED_MESSAGING = r10;
            PredefinedPropertySet r8 = new PredefinedPropertySet("PSETID_AIR_SYNC", 10, "71035549-0739-4DCB-9163-00F0580DBBDF");
            PSETID_AIR_SYNC = r8;
            PredefinedPropertySet r6 = new PredefinedPropertySet("PSETID_SHARING", 11, "00062040-0000-0000-C000-000000000046");
            PSETID_SHARING = r6;
            PredefinedPropertySet r4 = new PredefinedPropertySet("PSETID_XML_EXTRACTED_ENTITIES", 12, "23239608-685D-4732-9C55-4C95CB4E8E33");
            PSETID_XML_EXTRACTED_ENTITIES = r4;
            PredefinedPropertySet r2 = new PredefinedPropertySet("PSETID_ATTACHMENT", 13, "96357F7F-59E1-47D0-99A7-46515C183B54");
            PSETID_ATTACHMENT = r2;
            $VALUES = new PredefinedPropertySet[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2};
        }

        private PredefinedPropertySet(String r1, int r2, String r3) {
            super(r1, r2);
            this.classID = new ClassID(r3);
        }

        public static PredefinedPropertySet valueOf(String r2) {
            return (PredefinedPropertySet) ZeusTransformUtils.preCheckCast(Enum.valueOf(PredefinedPropertySet.class, r2), PredefinedPropertySet.class, "com.obric.memorydata.plugin");
        }

        public static PredefinedPropertySet[] values() {
            return (PredefinedPropertySet[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PredefinedPropertySet[].class, "com.obric.memorydata.plugin");
        }

        public ClassID getClassID() {
            return this.classID;
        }
    }

    public static final enum PropertySetType extends Enum<PropertySetType> {
        private static final /* synthetic */ PropertySetType[] $VALUES = null;
        public static final PropertySetType PS_INTERNET_HEADERS = null;
        public static final PropertySetType PS_MAPI = null;
        public static final PropertySetType PS_PUBLIC_STRINGS = null;
        private final ClassID classID;

        static {
            PropertySetType r0 = new PropertySetType("PS_MAPI", 0, "00020328-0000-0000-C000-000000000046");
            PS_MAPI = r0;
            PropertySetType r1 = new PropertySetType("PS_PUBLIC_STRINGS", 1, "00020329-0000-0000-C000-000000000046");
            PS_PUBLIC_STRINGS = r1;
            PropertySetType r3 = new PropertySetType("PS_INTERNET_HEADERS", 2, "00020386-0000-0000-C000-000000000046");
            PS_INTERNET_HEADERS = r3;
            $VALUES = new PropertySetType[]{r0, r1, r3};
        }

        private PropertySetType(String r1, int r2, String r3) {
            super(r1, r2);
            this.classID = new ClassID(r3);
        }

        static /* synthetic */ ClassID access$000(PropertySetType r0) {
            return r0.classID;
        }

        public static PropertySetType valueOf(String r2) {
            return (PropertySetType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PropertySetType.class, r2), PropertySetType.class, "com.obric.memorydata.plugin");
        }

        public static PropertySetType[] values() {
            return (PropertySetType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PropertySetType[].class, "com.obric.memorydata.plugin");
        }

        public ClassID getClassID() {
            return this.classID;
        }
    }
}
