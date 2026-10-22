package dn;

import ai.j0;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.geckox.listener.GeckoUpdateListener$GeckoParams;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.ies.web.jsbridge2.p;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.google.common.base.b0;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import ko.r;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.g;
import kotlinx.serialization.internal.c1;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements eu.b, eu.a {
    public static final Activity F(cj.d r5, String r10) {
        com.bytedance.ies.bullet.core.container.e r11 = (com.bytedance.ies.bullet.core.container.e) I(r5, com.bytedance.ies.bullet.core.container.e.class);
        Context r12 = null;
        if (r11 == null) goto L25;
        com.bytedance.ies.bullet.core.e r13 = r11.getBulletContext();
        if (r13 == null) goto L25;
        com.bytedance.ies.bullet.core.b r14 = (com.bytedance.ies.bullet.core.b) r13.s.getValue();
        if (r14 == null) goto L25;
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        com.bytedance.ies.bullet.core.d r15 = com.bytedance.ies.bullet.core.d.f5288b;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Map r16 = (Map) r15.f5289a.get(r14.f5273a);
        if (r16 == null) goto L20;
        Iterator r17 = r16.keySet().iterator();
    L12:
        if (r17.hasNext() == false) goto L20;
        String r18 = (String) r17.next();
        com.bytedance.ies.bullet.core.container.e r19 = (com.bytedance.ies.bullet.core.container.e) r16.get(r18);
        if (r19 == null) goto L16;
        String r20 = r19.getSessionId();
    L18:
        if (Intrinsics.areEqual(r20, r10) == false) goto L12;
        com.bytedance.ies.bullet.core.container.e r21 = (com.bytedance.ies.bullet.core.container.e) r16.get(r18);
    L21:
        if (r21 == null) goto L25;
        com.bytedance.ies.bullet.core.e r22 = r21.getBulletContext();
        if (r22 == null) goto L25;
        r12 = r22.f5294h;
        goto L25
    L16:
        r20 = null;
    L20:
        r21 = null;
    L25:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.app.Activity");
        return (Activity) r12;
    }

    public static Typeface G(int r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "fontName");
        Intrinsics.checkNotNullParameter(r11, "fontStyle");
        boolean r12 = Intrinsics.areEqual(r11, "italic");
        if (r5 <= 500) goto L6;
        if (r12 == false) goto L6;
        int r13 = 3;
    L12:
        switch(r10.hashCode()) {
            case -1536685117: goto L35;
            case -1431958525: goto L30;
            case -1081737434: goto L25;
            case 109326717: goto L20;
            case 1126973893: goto L15;
            default: goto L37;
        };
    L15:
        if (r10.equals("cursive") == false) goto L37;
        return Typeface.create(Typeface.SANS_SERIF, r13);
    L20:
        if (r10.equals("serif") == false) goto L37;
        return Typeface.create(Typeface.SERIF, r13);
    L25:
        if (r10.equals("fantasy") == false) goto L37;
        return Typeface.create(Typeface.SANS_SERIF, r13);
    L30:
        if (r10.equals("monospace") == false) goto L37;
        return Typeface.create(Typeface.MONOSPACE, r13);
    L35:
        if (r10.equals("sans-serif") == false) goto L37;
        return Typeface.create(Typeface.SANS_SERIF, r13);
    L37:
        return Typeface.create(Typeface.SERIF, r13);
    L6:
        if (r5 <= 500) goto L8;
        r13 = 1;
        goto L12
    L8:
        if (r12 == false) goto L10;
        r13 = 2;
        goto L12
    L10:
        r13 = 0;
        goto L12
    }

    public static p H(String r10) {
        Intrinsics.checkNotNullParameter(r10, "fontStyle");
        p r5 = new p(7);
        r5.f6303b = "normal";
        r5.f6304c = "serif";
        int r11 = 0;
        List r12 = StringsKt.K(r10, new String[]{" "}, 0, 6);
        int r13 = r12.size();
    L3:
        if (r11 >= r13) goto L31;
        if (StringsKt.g((CharSequence) r12.get(r11), "px") == false) goto L8;
        r5.e = Float.valueOf(Float.parseFloat(StringsKt.F((String) r12.get(r11), "px", "")));
    L30:
        r11 = r11 + 1;
        goto L3
    L8:
        if (Intrinsics.areEqual(r12.get(r11), "small-caps") == true) goto L30;
        if (Intrinsics.areEqual(r12.get(r11), "italic") == false) goto L13;
    L29:
        String r14 = (String) r12.get(r11);
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r5.f6303b = r14;
        goto L30
    L13:
        if (Intrinsics.areEqual(r12.get(r11), "normal") == true) goto L29;
        if (((Integer) r5.d) == null) goto L19;
        String r15 = (String) r12.get(r11);
        r5.d = (Integer) s4.b.f21815a.get(r15);
        goto L30
    L19:
        if (Intrinsics.areEqual(r12.get(r11), "serif") == false) goto L21;
    L28:
        String r16 = (String) r12.get(r11);
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r5.f6304c = r16;
        goto L30
    L21:
        if (Intrinsics.areEqual(r12.get(r11), "sans-serif") == true) goto L28;
        if (Intrinsics.areEqual(r12.get(r11), "cursive") == true) goto L28;
        if (Intrinsics.areEqual(r12.get(r11), "monospace") == true) goto L28;
        if (Intrinsics.areEqual(r12.get(r11), "fantasy") == false) goto L30;
    L31:
        return r5;
    }

    public static final Object I(cj.d r5, Class r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_SERVICE);
        if (r5 == null) goto L5;
        rb.b r11 = (rb.b) r5.a(rb.b.class);
    L6:
        if (r11 == null) goto L11;
        Object r12 = r11.a(r10);
        if (r12 == null) goto L11;
        return r12;
    L11:
        if (r5 != null) goto L13;
        return null;
    L13:
        return r5.a(r10);
    L5:
        r11 = null;
        goto L6
    }

    public static String J(Context r10, boolean r11, String r12) {
        if ((r10 instanceof LynxContext) == true) goto L5;
        return r12;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L78;
        LynxContext r13 = kk.a.i(r10);
        if (r13 != null) goto L10;
        LynxLog.b(4, "ImageUrlRedirectUtils", "redirecting url failed due to no context available");
        return r12;
    L10:
        if (r11 == false) goto L12;
        k r14 = r13.d;
    L13:
        if (r14 == null) goto L79;
        String r5 = r13.f10149q;
        if (TraceController.g == false) goto L17;
        HashMap r15 = new HashMap();
        r15.put("url", r12);
        TraceEvent.b(0, "Interceptor.shouldRedirectImageUrl", r15);
    L17:
        String r16 = null;
        String r17 = r14.shouldRedirectImageUrl(r12);     // Catch: Exception -> L20
    L22:
        TraceEvent.a(0, "Interceptor.shouldRedirectImageUrl");
        if (r17 == null) goto L26;
        r16 = r17;
    L54:
        if (r16 != null) goto L56;
        return r12;
    L56:
        if (r16.startsWith("res:///") == false) goto L71;
        int r18 = 7;
    L59:
        if (r18 >= r16.length()) goto L71;
        char r19 = r16.charAt(r18);
        if (r19 < '0') goto L66;
        if (r19 > '9') goto L66;
        r18 = r18 + 1;
    L66:
        int r20 = r16.indexOf(46);
        if (r20 >= 0) goto L81;
        r20 = r16.length();
    L81:
        return com.lynx.jsbridge.a.d(r13.getResources().getIdentifier(r16.substring(7, r20), "drawable", r13.getPackageName()), "res:///");
    L71:
        return r16;
    L26:
        if (TextUtils.isEmpty(r12) == true) goto L54;
        if (r12.startsWith("./") == false) goto L54;
        if (TextUtils.isEmpty(r5) == true) goto L54;
        int r110 = r5.lastIndexOf("/");
        if (r110 <= 0) goto L54;
        StringBuilder r111 = sk.a.a(r5.substring(0, r110));
        r111.append(r12.substring(1));
        r16 = r111.toString();
        LynxLog.b(1, "ImageUrlRedirectUtils", "shouldRedirectImageUrl use local image url:" + r16);
        if (r16.startsWith("http") == true) goto L54;
        if (r16.startsWith("file://") == true) goto L54;
        if (r16.startsWith("content://") == true) goto L54;
        if (r16.startsWith("res://") == true) goto L54;
        if (r16.startsWith("data:") == true) goto L54;
        if (r16.startsWith("assets:///") == false) goto L48;
        r16 = r16.replace("assets:///", "asset:///");
        goto L54
    L48:
        if (r16.startsWith("assets://") == false) goto L51;
        r16 = r16.replace("assets://", "asset:///");
        goto L54
    L51:
        if (r16.startsWith("asset:///") == true) goto L54;
        r16 = "file://".concat(r16);
    L20:
        e = move-exception;
        LynxLog.b(1, "ImageUrlRedirectUtils", "shouldRedirectImageUrl occurred with exception: " + e.getMessage());
        r17 = null;
        goto L22
    L79:
        return r12;
    L12:
        r14 = r13.f10139c;
        goto L13
    L78:
        return r12;
    }

    public static StringBuilder K(long r5, String r10, String r11) {
        return j0.t(r5, r10, r11);
    }

    public static void L(String r11, Long r12) {
        File r5 = new File(r11);
        File[] r10 = r5.listFiles();
        if (r10 != null) goto L5;
    L77:
        r5.delete();
        return;
    L5:
        if (r10.length == 0) goto L77;
        ArrayList r13 = new ArrayList();
        int r14 = r10.length;
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L14;
        File r16 = r10[r15];
        if (r16.isDirectory() == false) goto L12;
        r13.add(r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L14:
        if (r13.isEmpty() == false) goto L16;
        return;
    L16:
        LinkedHashMap r17 = ra.b.f21714a;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L25
        ra.a r19 = ra.b.a(r11);     // Catch: Throwable -> L25
        r19.f21713c.lock();     // Catch: Throwable -> L27
        if (r19.f21711a <= 0) goto L21;
    L29:
        ReentrantLock r20 = r19.f21713c;     // Catch: Throwable -> L25
        boolean r21 = false;
    L30:
        r20.unlock();     // Catch: Throwable -> L25
        Object r22 = Result.m124constructorimpl(Boolean.valueOf(r21));     // Catch: Throwable -> L25
    L34:
        Boolean r23 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r22) == false) goto L38;
        r22 = r23;
    L38:
        if (((Boolean) r22).booleanValue() == true) goto L40;
        return;
    L40:
        List r24 = StringsKt.K(r11, new String[]{"/"}, 0, 6);
        if (r24.size() >= 2) goto L43;
        int r25 = 0;
    L63:
        LinkedHashMap r26 = ra.b.f21714a;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L67
        ra.a r28 = ra.b.a(r11);     // Catch: Throwable -> L67
        r28.f21713c.lock();     // Catch: Throwable -> L69
        r28.f21712b = false;     // Catch: Throwable -> L69
        r28.f21713c.unlock();     // Catch: Throwable -> L67
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L67
    L73:
        if (r25 <= 0) goto L75;
        com.lynx.tasm.behavior.utils.d.i();
    L75:
        GeckoLogger.a("channel version delete: " + r11 + ", newVersion: " + r12 + ", deleteCount: " + r25);
        return;
    L69:
        th = move-exception;
        r28.f21713c.unlock();     // Catch: Throwable -> L67
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L73
    L43:
        String r30 = (String) j0.e(r24, 2);
        String r31 = (String) j0.e(r24, 1);
        String r32 = String.valueOf(r12);
        if (r12 != null) goto L50;
        ChannelMeta r33 = com.bytedance.iesgurd.meta.e.a(r30, r31);
        if (r33 == null) goto L50;
        Long r34 = r33.getId();
        if (r34 == null) goto L50;
        r32 = String.valueOf(r34.longValue());
    L50:
        Iterator r35 = r13.iterator();
        r25 = 0;
    L52:
        if (r35.hasNext() == false) goto L63;
        File r36 = (File) r35.next();
        String r37 = r36.getName();
        if (StringsKt.k(r37, "--updating") == true) goto L56;
        if (Intrinsics.areEqual(r37, r32) == true) goto L52;
        com.lynx.tasm.behavior.utils.d.f(r36);
    L59:
        r25 = r25 + 1;
        goto L52
    L56:
        if (Intrinsics.areEqual(hf.f.f17318b, r30 + '_' + r31) == true) goto L52;
        com.lynx.tasm.behavior.utils.d.f(r36);
        goto L59
    L21:
        if (r19.f21712b == true) goto L29;
        r19.f21712b = true;     // Catch: Throwable -> L27
        r20 = r19.f21713c;     // Catch: Throwable -> L25
        r21 = true;
        goto L30
    L27:
        th = move-exception;
        r19.f21713c.unlock();     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r22 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L34
    }

    public static void M(String r5, String r10) {
        new GeckoUpdateListener$GeckoParams(r5, r10, 0);     // Catch: Throwable -> L7
        Iterator r11 = pa.b.f21323a.iterator();     // Catch: Throwable -> L7
    L4:
        if (r11.hasNext() == false) goto L9;
        ((pa.a) r11.next()).getClass();     // Catch: Throwable -> L7
    L9:
        com.bytedance.iesgurd.c r12 = new com.bytedance.iesgurd.c(r5, r10);
        Iterator r13 = com.bytedance.iesgurd.a.f6593a.entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        ((com.bytedance.iesgurd.b) ((Map.Entry) r13.next()).getValue()).b(r12);
        goto L11
    L13:
        return;
    L7:
        th = move-exception;
        GeckoLogger.b("GeckoUpdateListener onCleanRes exception: " + th.getMessage() + '-' + th.getStackTrace());
        goto L9
    }

    public static int P(int r5, int r10) {
        if (r10 > 1073741823) goto L5;
        boolean r11 = true;
    L6:
        b0.e("min (%s) must be less than or equal to max (%s)", r10, 1073741823, r11);
        return Math.min(Math.max(r5, r10), 1073741823);
    L5:
        r11 = false;
        goto L6
    }

    public static boolean R(List r5) {
        if (r5 != null) goto L4;
    L7:
        return true;
    L4:
        if (r5.size() == 0) goto L7;
        return false;
    }

    public static ArrayList S(String r5, JSONObject r10) {
        JSONArray r11 = r10.optJSONArray(r5);     // Catch: Exception -> L15
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.length() <= 0) goto L21;
        int r12 = r11.length();     // Catch: Exception -> L15
        ArrayList r13 = new ArrayList(r12);     // Catch: Exception -> L15
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L12;
        String r15 = r11.getString(r14);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r15) == true) goto L11;
        r13.add(r15);     // Catch: Exception -> L15
    L11:
        r14 = r14 + 1;
        goto L7
    L12:
        return r13;
    L21:
        return null;
    L22:
        return null;
    }

    public static ArrayList T(String r5, JSONObject r10) {
        JSONArray r11 = r10.optJSONArray(r5);     // Catch: Exception -> L15
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.length() <= 0) goto L21;
        int r12 = r11.length();     // Catch: Exception -> L15
        ArrayList r13 = new ArrayList(r12);     // Catch: Exception -> L15
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L12;
        String r15 = r11.getString(r14);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r15) == true) goto L11;
        r13.add(Pattern.compile(r15));     // Catch: Exception -> L15
    L11:
        r14 = r14 + 1;
        goto L7
    L12:
        return r13;
    L21:
        return null;
    L22:
        return null;
    }

    public static int U(long r5) {
        if (r5 <= 2147483647L) goto L7;
        return Integer.MAX_VALUE;
    L7:
        if (r5 >= (-2147483648L)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) r5;
    }

    @Override // eu.a
    public long A(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return j();
    }

    @Override // eu.b
    public boolean B() {
        return true;
    }

    @Override // eu.a
    public eu.b D(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return m(r5.g(r10));
    }

    @Override // eu.b
    public abstract byte E();

    public abstract void N(r r5, go.a r10);

    public abstract void O(r r5, go.a r10);

    public void Q() {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(getClass()) + " can't retrieve untyped values");
    }

    @Override // eu.a
    public float a(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return p();
    }

    @Override // eu.a
    public char b(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return t();
    }

    @Override // eu.b
    public int c(g r5) {
        Intrinsics.checkNotNullParameter(r5, "enumDescriptor");
        Q();
        throw null;
    }

    @Override // eu.a
    public byte d(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return E();
    }

    @Override // eu.a
    public boolean e(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return s();
    }

    @Override // eu.b
    public abstract int g();

    @Override // eu.b
    public eu.a i(g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return this;
    }

    @Override // eu.b
    public abstract long j();

    @Override // eu.a
    public String k(g r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return z();
    }

    @Override // eu.b
    public eu.b m(g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return this;
    }

    @Override // eu.a
    public double n(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return q();
    }

    @Override // eu.b
    public abstract short o();

    @Override // eu.b
    public float p() {
        Q();
        throw null;
    }

    @Override // eu.b
    public double q() {
        Q();
        throw null;
    }

    @Override // eu.a
    public short r(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return o();
    }

    @Override // eu.b
    public boolean s() {
        Q();
        throw null;
    }

    @Override // eu.b
    public char t() {
        Q();
        throw null;
    }

    @Override // eu.a
    public void u(g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
    }

    @Override // eu.a
    public int v(c1 r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return g();
    }

    @Override // eu.b
    public Object w(kotlinx.serialization.b r5) {
        Intrinsics.checkNotNullParameter(r5, "deserializer");
        return r5.a(this);
    }

    @Override // eu.a
    public Object y(g r5, int r10, kotlinx.serialization.b r11, Object r12) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r11, "deserializer");
        Intrinsics.checkNotNullParameter(r11, "deserializer");
        return w(r11);
    }

    @Override // eu.b
    public String z() {
        Q();
        throw null;
    }
}
