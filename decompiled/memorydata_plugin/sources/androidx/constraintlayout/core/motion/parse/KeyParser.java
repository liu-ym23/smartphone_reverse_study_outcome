package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public class KeyParser {

    private interface DataType {
        int get(int r1);
    }

    private interface Ids {
        int get(String r1);
    }

    public KeyParser() {
    }

    public static void main(String[] r0) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static TypedBundle parse(String r10, Ids r11, DataType r12) {
        Ids r13 = (Ids) ZeusTransformUtils.wrapperContextForParams(r11, Ids.class, "com.obric.memorydata.plugin");
        DataType r14 = (DataType) ZeusTransformUtils.wrapperContextForParams(r12, DataType.class, "com.obric.memorydata.plugin");
        TypedBundle r0 = new TypedBundle();
        CLObject r15 = CLParser.parse(r10);     // Catch: CLParsingException -> L24
        int r2 = r15.size();     // Catch: CLParsingException -> L24
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L26;
        CLKey r4 = (CLKey) ZeusTransformUtils.preCheckCast(r15.get(r3), CLKey.class, "com.obric.memorydata.plugin");     // Catch: CLParsingException -> L24
        String r5 = r4.content();     // Catch: CLParsingException -> L24
        CLElement r6 = r4.getValue();     // Catch: CLParsingException -> L24
        int r7 = r13.get(r5);     // Catch: CLParsingException -> L24
        if (r7 != (-1)) goto L8;
        System.err.println("unknown type " + r5);     // Catch: CLParsingException -> L24
    L23:
        r3 = r3 + 1;
        goto L4
    L8:
        int r8 = r14.get(r7);     // Catch: CLParsingException -> L24
        if (r8 != 1) goto L12;
        r0.add(r7, r15.getBoolean(r3));     // Catch: CLParsingException -> L24
        goto L23
    L12:
        if (r8 != 2) goto L14;
        r0.add(r7, r6.getInt());     // Catch: CLParsingException -> L24
        PrintStream r9 = System.out;     // Catch: CLParsingException -> L24
        String r16 = "parse " + r5 + " INT_MASK > " + r6.getInt();     // Catch: CLParsingException -> L24
    L19:
        r9.println(r16);     // Catch: CLParsingException -> L24
        goto L23
    L14:
        if (r8 != 4) goto L16;
        r0.add(r7, r6.getFloat());     // Catch: CLParsingException -> L24
        r9 = System.out;     // Catch: CLParsingException -> L24
        r16 = "parse " + r5 + " FLOAT_MASK > " + r6.getFloat();     // Catch: CLParsingException -> L24
        goto L19
    L16:
        if (r8 != 8) goto L23;
        r0.add(r7, r6.content());     // Catch: CLParsingException -> L24
        r9 = System.out;     // Catch: CLParsingException -> L24
        r16 = "parse " + r5 + " STRING_MASK > " + r6.content();     // Catch: CLParsingException -> L24
    L26:
        return r0;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public static TypedBundle parseAttributes(String r2) {
        return parse(r2, $$Lambda$hNmrxjz972As46Jl5Po5RJ1Nm6c.INSTANCE, $$Lambda$HghhCyRcCZ40GTQ2whRMSAC7hA.INSTANCE);
    }
}
