package u7a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.LLog;
import com.lynx.xelement.webview.LynxUIWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Bitmap.Config.values().length];
            a = r0;
            r0[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[Bitmap.Config.ALPHA_8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[Bitmap.Config.RGB_565.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class b {
        public boolean a;
        public boolean b;

        public b() {
            this.a = false;
            this.b = false;
        }
    }

    public static b b(f6a.a r4) {
        b r0 = new b();
        if (r4 != null) goto L5;
        r0.a = false;
    L27:
        return r0;
    L5:
        ReadableType r2 = r4.getType();
        if (r2 != ReadableType.Boolean) goto L9;
        r0.a = r4.asBoolean();
        r0.b = false;
        goto L27
    L9:
        if (r2 != ReadableType.String) goto L27;
        String r5 = r4.asString();
        if (TextUtils.isEmpty(r5) == false) goto L13;
    L26:
        r0.a = false;
        r0.b = false;
        goto L27
    L13:
        if (VoiceDisplayScene.NONE.equals(r5) == true) goto L26;
        if ("false".equals(r5) == true) goto L26;
        if (LynxUIWebView.DEFAULT.equals(r5) == false) goto L20;
    L25:
        r0.a = true;
        r0.b = false;
        goto L27
    L20:
        if ("true".equals(r5) == true) goto L25;
        if ("await".equals(r5) == false) goto L27;
        r0.a = true;
        r0.b = true;
        goto L27
    }

    public static Rect c(ReadableMap r8) {
        if (r8 != null) goto L33;
        return null;
    L33:
    L15:
        th = move-exception;
        LLog.e("ImageUtils", "parseRegionToDecode error: " + th.getMessage());
    L17:
        Rect r0 = null;
    L18:
        if (r0 != null) goto L21;
        LLog.w("ImageUtils", "parseRegionToDecode: rect is null");
        return null;
    L21:
        int r9 = r0.left;
        if (r9 < 0) goto L31;
        int r1 = r0.top;
        if (r1 < 0) goto L31;
        if (r0.right <= r9) goto L31;
        if (r0.bottom <= r1) goto L31;
        return r0;
    L31:
        LLog.w("ImageUtils", "parseRegionToDecode: invalid rect " + r0);
        return null;
    L6:
        if (r8.hasKey("x") == false) goto L17;
        if (r8.hasKey("y") == false) goto L17;
        if (r8.hasKey("width") == false) goto L17;
        if (r8.hasKey("height") == false) goto L17;
        int r3 = (int) r8.getDouble("x");     // Catch: Throwable -> L15
        int r2 = (int) r8.getDouble("y");     // Catch: Throwable -> L15
        r0 = new Rect(r3, r2, ((int) r8.getDouble("width")) + r3, ((int) r8.getDouble("height")) + r2);     // Catch: Throwable -> L15
        goto L18
    }

    public static int a(int r2, int r3, Bitmap.Config r4) {
        int r5 = r2 * r3;
        int r6 = a.a[r4.ordinal()];
        int r7 = 4;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L7;
        r7 = 1;
        goto L15
    L7:
        if (r6 == 3) goto L12;
        if (r6 == 4) goto L12;
        throw new UnsupportedOperationException("Current Bitmap.Config is not supported");
    L12:
        r7 = 2;
    L15:
        return r5 * r7;
    }
}
