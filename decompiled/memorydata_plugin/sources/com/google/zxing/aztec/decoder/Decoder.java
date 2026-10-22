package com.google.zxing.aztec.decoder;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.util.f;
import com.bytedance.crash.NpthBus;
import com.loc.o;
import com.tom_roush.pdfbox.pdmodel.a.c.a;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public final class Decoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f5060a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f5061b = null;
    private static final String[] c = null;
    private static final String[] d = null;
    private static final String[] e = null;
    private static final Charset f = null;

    private static final enum Table extends Enum<Table> {
        private static final /* synthetic */ Table[] $VALUES = null;
        public static final Table BINARY = null;
        public static final Table DIGIT = null;
        public static final Table LOWER = null;
        public static final Table MIXED = null;
        public static final Table PUNCT = null;
        public static final Table UPPER = null;

        static {
            Table r0 = new Table("UPPER", 0);
            UPPER = r0;
            Table r1 = new Table("LOWER", 1);
            LOWER = r1;
            Table r3 = new Table("MIXED", 2);
            MIXED = r3;
            Table r5 = new Table("DIGIT", 3);
            DIGIT = r5;
            Table r7 = new Table("PUNCT", 4);
            PUNCT = r7;
            Table r9 = new Table("BINARY", 5);
            BINARY = r9;
            $VALUES = new Table[]{r0, r1, r3, r5, r7, r9};
        }

        private Table(String r1, int r2) {
            super(r1, r2);
        }

        public static Table valueOf(String r2) {
            return (Table) ZeusTransformUtils.preCheckCast(Enum.valueOf(Table.class, r2), Table.class, "com.obric.memorydata.plugin");
        }

        public static Table[] values() {
            return (Table[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Table[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f5060a = new String[]{"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", a.f16161b, ExifInterface.LONGITUDE_EAST, "F", NpthBus.UUID_SUFIX_3_1_3, i.n, "I", "J", "K", i.u, "M", "N", "O", i.m, "Q", "R", "S", ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
        f5061b = new String[]{"CTRL_PS", " ", "a", "b", "c", "d", "e", f.f1488a, o.f, o.g, "i", o.j, "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", BaseSwitches.V, "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
        c = new String[]{"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
        d = new String[]{"FLG(n)", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", Marker.ANY_NON_NULL_MARKER, ",", "-", ".", "/", ParameterizedMessage.ERROR_MSG_SEPARATOR, ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
        e = new String[]{"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
        f = StandardCharsets.ISO_8859_1;
    }
}
