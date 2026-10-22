package we8;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.font.FontLevel;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final Lazy a = null;
    public static final Map<Integer, Integer> b = null;
    public static final Lazy c = null;
    public static volatile int d;

    static {
        Lazy r0 = LazyKt.lazy(new b());
        a = r0;
        FontLevel r2 = FontLevel.EXTRA_SMALL;
        FontLevel r3 = FontLevel.STANDARD;
        FontLevel r4 = FontLevel.SUPER_EXTRA_LARGE;
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r2.getValue()), 14), TuplesKt.to(Integer.valueOf(FontLevel.SMALL.getValue()), 15), TuplesKt.to(Integer.valueOf(r3.getValue()), 17), TuplesKt.to(Integer.valueOf(FontLevel.LARGE.getValue()), 19), TuplesKt.to(Integer.valueOf(FontLevel.EXTRA_LARGE.getValue()), 21), TuplesKt.to(Integer.valueOf(r4.getValue()), 26)});
        c = LazyKt.lazy(new c());
        d = r3.getValue();
        ir9.c r1 = z2.a.getFontSizeAllowConfig();
        if (r1 == null) goto L14;
        int r7 = ((Keva) r0.getValue()).getInt("font_size_level", Integer.MIN_VALUE);
        if (r1.a() == true) goto L10;
        if (r7 != r2.getValue()) goto L10;
    L13:
        ((Keva) r0.getValue()).storeInt("font_size_level", r3.getValue());
    L10:
        if (r1.b() == true) goto L14;
        if (r7 == r4.getValue()) goto L13;
    L14:
        int r5 = ((Keva) r0.getValue()).getInt("font_size_level", Integer.MIN_VALUE);
        if (r5 >= r2.getValue()) goto L17;
        int r6 = r3.getValue();
    L18:
        d = r6;
        FLogger r8 = FLogger.a;
        r8.i("FontAdjustManager", "updateFontLevel, localLevel: " + r5 + ", _innerCurrentFontLevel: " + d);
        final String r9 = f.a(d);
        r8.i("FontAdjustManager", "setAppLogFontSizeHeader: ".concat(r9));
        t0.a(new d(r9));
        return;
    L17:
        r6 = r5;
        goto L18
    }

    public static int a(boolean r0) {
        if (r0 == false) goto L5;
        return 0;
    L5:
        return b(d);
    }

    public static int b(int r6) {
        Integer r0 = d(r6);
        Integer r1 = b.get(Integer.valueOf(FontLevel.STANDARD.getValue()));
        if (r0 == null) goto L11;
        if (r1 == null) goto L11;
        if (AppHost.a.isDebug() == false) goto L10;
        FLogger.a.i("FontAdjustManager", "getFontSizeDiff,targetSize(" + r6 + ':' + r0 + ") - standardSize(" + r1 + ") diff: " + (r0.intValue() - r1.intValue()));
    L10:
        return r0.intValue() - r1.intValue();
    L11:
        FLogger.a.e("FontAdjustManager", "getFontSizeDiff, level: " + r6 + ", targetSize: " + r0 + ", standardSize: " + r1);
        return 0;
    }

    public static Integer d(int r2) {
        Integer r0 = (Integer) ((Map) c.getValue()).get(Integer.valueOf(r2));
        if (r0 == null) goto L5;
        return r0;
    L5:
        return b.get(Integer.valueOf(r2));
    }

    public static int c(int r6, int r7) {
        Integer r0 = d(r6);
        if (r7 != FontLevel.STANDARD.getValue()) goto L5;
        Integer r1 = b.get(Integer.valueOf(r7));
    L7:
        if (r0 == null) goto L12;
        if (r1 == null) goto L12;
        FLogger.a.i("FontAdjustManager", "getFontSizeDiff, level(" + r6 + ':' + r0 + ") - preLevel(" + r7 + ':' + r1 + ") diff: " + (r0.intValue() - r1.intValue()));
        return r0.intValue() - r1.intValue();
    L12:
        FLogger.a.i("FontAdjustManager", "getFontSizeDiff, level: " + r6 + ", preLevel: " + r7 + ", targetSize: " + r0 + ", preSize: " + r1);
        return 0;
    L5:
        r1 = d(r7);
        goto L7
    }
}
