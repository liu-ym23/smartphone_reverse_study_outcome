package wub;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h;
import java.util.LinkedHashMap;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final LinkedHashMap<Long, h> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static String a(String r6) {
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        StringBuilder r1 = new StringBuilder(r6.length());
        int r3 = 0;
    L11:
        if (r3 >= r6.length()) goto L21;
        char r4 = r6.charAt(r3);
        if (CharsKt.isWhitespace(r4) == true) goto L19;
        switch(r4) {
            case 33: goto L16;
            case 34: goto L16;
            case 39: goto L16;
            case 40: goto L16;
            case 41: goto L16;
            case 44: goto L16;
            case 46: goto L16;
            case 58: goto L16;
            case 59: goto L16;
            case 63: goto L16;
            case 91: goto L16;
            case 93: goto L16;
            case 8216: goto L16;
            case 8217: goto L16;
            case 8220: goto L16;
            case 8221: goto L16;
            case 12289: goto L16;
            case 12290: goto L16;
            case 12304: goto L16;
            case 12305: goto L16;
            case 65281: goto L16;
            case 65288: goto L16;
            case 65289: goto L16;
            case 65292: goto L16;
            case 65306: goto L16;
            case 65307: goto L16;
            case 65311: goto L16;
            default: goto L15;
        };
    L15:
        boolean r5 = false;
    L17:
        if (r5 == true) goto L19;
        r1.append(r4);
        goto L19
    L16:
        r5 = true;
    L19:
        r3 = r3 + 1;
        goto L11
    L21:
        return r1.toString();
    L5:
        r0 = false;
        goto L6
    }
}
