package w7a;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Base64;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFace;
import com.lynx.tasm.utils.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static b a;

    /* JADX INFO: renamed from: w7a.a$a, reason: collision with other inner class name */
    public static class C0121a extends b {
        public C0121a() {
        }
    }

    public static abstract class b {
        public b() {
        }

        public Typeface a(LynxContext r4, FontFace.TYPE r5, String r6) {
            if (TextUtils.isEmpty(r6) == false) goto L5;
        L17:
            return null;
        L5:
            if (r5 == FontFace.TYPE.LOCAL) goto L17;
            int r7 = r6.indexOf("base64,");
            if (r6.startsWith("data:") == false) goto L17;
            if (r7 == (-1)) goto L17;
            return m.c(r4, Base64.decode(r6.substring(r7 + 7), 0));
        L15:
            e = move-exception;
            r4.reportResourceError(30203, r6, LynxResourceModule.FONT_TYPE, e.getMessage());
            goto L17
        }
    }

    public a() {
    }

    static {
        a = new C0121a();
    }

    public static b a(LynxContext r1) {
        if (r1.getFontLoader() == null) goto L7;
        return r1.getFontLoader();
    L7:
        return a;
    }
}
