package org.apache.poi.hsmf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.POIReadOnlyDocument;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: classes7.dex */
public class MAPIMessage extends POIReadOnlyDocument {
    private static final Pattern GUESS_7_BIT_ENCODING_PATTERN = null;
    private static final c LOG = null;

    public static final enum MESSAGE_CLASS extends Enum<MESSAGE_CLASS> {
        private static final /* synthetic */ MESSAGE_CLASS[] $VALUES = null;
        public static final MESSAGE_CLASS APPOINTMENT = null;
        public static final MESSAGE_CLASS CONTACT = null;
        public static final MESSAGE_CLASS NOTE = null;
        public static final MESSAGE_CLASS POST = null;
        public static final MESSAGE_CLASS STICKY_NOTE = null;
        public static final MESSAGE_CLASS TASK = null;
        public static final MESSAGE_CLASS UNKNOWN = null;
        public static final MESSAGE_CLASS UNSPECIFIED = null;

        static {
            MESSAGE_CLASS r0 = new MESSAGE_CLASS("APPOINTMENT", 0);
            APPOINTMENT = r0;
            MESSAGE_CLASS r1 = new MESSAGE_CLASS("CONTACT", 1);
            CONTACT = r1;
            MESSAGE_CLASS r3 = new MESSAGE_CLASS("NOTE", 2);
            NOTE = r3;
            MESSAGE_CLASS r5 = new MESSAGE_CLASS("POST", 3);
            POST = r5;
            MESSAGE_CLASS r7 = new MESSAGE_CLASS("STICKY_NOTE", 4);
            STICKY_NOTE = r7;
            MESSAGE_CLASS r9 = new MESSAGE_CLASS("TASK", 5);
            TASK = r9;
            MESSAGE_CLASS r11 = new MESSAGE_CLASS("UNKNOWN", 6);
            UNKNOWN = r11;
            MESSAGE_CLASS r13 = new MESSAGE_CLASS("UNSPECIFIED", 7);
            UNSPECIFIED = r13;
            $VALUES = new MESSAGE_CLASS[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private MESSAGE_CLASS(String r1, int r2) {
            super(r1, r2);
        }

        public static MESSAGE_CLASS valueOf(String r2) {
            return (MESSAGE_CLASS) ZeusTransformUtils.preCheckCast(Enum.valueOf(MESSAGE_CLASS.class, r2), MESSAGE_CLASS.class, "com.obric.memorydata.plugin");
        }

        public static MESSAGE_CLASS[] values() {
            return (MESSAGE_CLASS[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MESSAGE_CLASS[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        LOG = b.a(MAPIMessage.class);
        GUESS_7_BIT_ENCODING_PATTERN = Pattern.compile("content-type:.*?charset=[\"']?([^;'\"]+)[\"']?", 2);
    }

    public MAPIMessage() {
        super(new POIFSFileSystem());
    }
}
