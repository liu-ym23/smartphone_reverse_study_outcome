package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public class KeyParser {

    private interface DataType {
        int get(int r10);
    }

    private interface Ids {
        int get(String r10);
    }

    public KeyParser() {
    }

    public static void main(String[] r10) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static TypedBundle parse(String r10, Ids r11, DataType r12) {
        TypedBundle r13 = new TypedBundle();
        CLObject r14 = CLParser.parse(r10);     // Catch: CLParsingException -> L24
        int r15 = r14.size();     // Catch: CLParsingException -> L24
        int r16 = 0;
    L4:
        if (r16 >= r15) goto L26;
        CLKey r17 = (CLKey) r14.get(r16);     // Catch: CLParsingException -> L24
        String r18 = r17.content();     // Catch: CLParsingException -> L24
        CLElement r19 = r17.getValue();     // Catch: CLParsingException -> L24
        int r20 = r11.get(r18);     // Catch: CLParsingException -> L24
        if (r20 != (-1)) goto L8;
        System.err.println("unknown type " + r18);     // Catch: CLParsingException -> L24
    L23:
        r16 = r16 + 1;
        goto L4
    L8:
        int r21 = r12.get(r20);     // Catch: CLParsingException -> L24
        if (r21 != 1) goto L12;
        r13.add(r20, r14.getBoolean(r16));     // Catch: CLParsingException -> L24
        goto L23
    L12:
        if (r21 != 2) goto L14;
        r13.add(r20, r19.getInt());     // Catch: CLParsingException -> L24
        PrintStream r22 = System.out;     // Catch: CLParsingException -> L24
        String r23 = "parse " + r18 + " INT_MASK > " + r19.getInt();     // Catch: CLParsingException -> L24
    L19:
        r22.println(r23);     // Catch: CLParsingException -> L24
        goto L23
    L14:
        if (r21 != 4) goto L16;
        r13.add(r20, r19.getFloat());     // Catch: CLParsingException -> L24
        r22 = System.out;     // Catch: CLParsingException -> L24
        r23 = "parse " + r18 + " FLOAT_MASK > " + r19.getFloat();     // Catch: CLParsingException -> L24
        goto L19
    L16:
        if (r21 != 8) goto L23;
        r13.add(r20, r19.content());     // Catch: CLParsingException -> L24
        r22 = System.out;     // Catch: CLParsingException -> L24
        r23 = "parse " + r18 + " STRING_MASK > " + r19.content();     // Catch: CLParsingException -> L24
    L26:
        return r13;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public static TypedBundle parseAttributes(String r10) {
        return parse(r10, b.f239a, a.f238a);
    }
}
