package com.lynx.tasm.behavior.shadow.text;

import android.graphics.PointF;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.utils.i;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import y6a.l;
import z6a.j;
import z6a.k;
import z6a.m;
import z6a.n;
import z6a.o;
import z6a.q;
import z6a.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BaseTextShadowNode extends ShadowNode {
    public static Method J = null;
    public static Object K = null;
    public static boolean L = true;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public String I;
    public final com.lynx.tasm.behavior.shadow.text.a v;
    public boolean w;
    public boolean x;
    public boolean y;
    public float z;

    public static class a {
        public final int a;
        public final int b;
        public final Object c;

        public final void a(SpannableStringBuilder r5) {
            int r0 = this.a;
            if (r0 != 0) goto L5;
            int r1 = 18;
        L6:
            Object r2 = this.c;
            if ((r2 instanceof com.lynx.tasm.behavior.ui.text.a) == false) goto L9;
        L10:
            r1 = 33;
        L11:
            r5.setSpan(r2, r0, this.b, r1);
            return;
        L9:
            if ((r2 instanceof n) == false) goto L11;
        L5:
            r1 = 34;
            goto L6
        }

        public a(int r1, int r2, Object r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public boolean K() {
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class C() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("androidx.emoji2.text.EmojiCompat");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("androidx.emoji2.text.EmojiCompat");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("androidx.emoji2.text.EmojiCompat");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("androidx.emoji2.text.EmojiCompat");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("androidx.emoji2.text.EmojiCompat");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("androidx.emoji2.text.EmojiCompat");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("androidx.emoji2.text.EmojiCompat");
    }

    public BaseTextShadowNode() {
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = 1.0E21f;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = false;
        this.F = 0;
        this.I = null;
        this.v = new com.lynx.tasm.behavior.shadow.text.a();
    }

    public final void M(boolean r3) {
        this.w = r3;
        setFontSize(this.v.n);
        int r4 = 0;
    L4:
        if (r4 >= l()) goto L9;
        ShadowNode r0 = k(r4);
        if ((r0 instanceof BaseTextShadowNode) == false) goto L8;
        ((BaseTextShadowNode) r0).M(this.w);
    L8:
        r4 = r4 + 1;
        goto L4
    }

    public final void N(float r3) {
        this.z = r3;
        if (this.w == false) goto L7;
        LynxContext r0 = this.m;
        if (r0 == null) goto L7;
        r3 = r3 * r0.getFontScale();
    L7:
        com.lynx.tasm.behavior.shadow.text.a r1 = this.v;
        if (r1.k == r3) goto L11;
        r1.k = r3;
        q();
        return;
    }

    @LynxProp(name = "custom-baseline-shift")
    public void setBaselineShift(String r7) {
    L11:
        th = move-exception;
        q();
        throw th;
    L13:
        e = move-exception;
        LLog.e("BaseTextShadowNode", e.toString());     // Catch: Throwable -> L11
        com.lynx.tasm.behavior.shadow.text.a r8 = this.v;     // Catch: Throwable -> L11
        r8.p = 0.0f;     // Catch: Throwable -> L11
        r8.f = -1;     // Catch: Throwable -> L11
    L15:
        q();
        return;
    L4:
        if (r7.contains("px") == false) goto L7;
        float r9 = Float.parseFloat(r7.substring(0, r7.indexOf("px")).trim());     // Catch: Throwable -> L11 Exception -> L13
        com.lynx.tasm.behavior.shadow.text.a r0 = this.v;     // Catch: Throwable -> L11 Exception -> L13
        r0.p = i.b(r9, 0.0f);     // Catch: Throwable -> L11 Exception -> L13
        this.v.f = 3;     // Catch: Throwable -> L11 Exception -> L13
    L21:
    L7:
        if (r7.contains("%") == false) goto L9;
        String r10 = r7.substring(0, r7.indexOf("%")).trim();     // Catch: Throwable -> L11 Exception -> L13
        com.lynx.tasm.behavior.shadow.text.a r1 = this.v;     // Catch: Throwable -> L11 Exception -> L13
        float r11 = Float.parseFloat(r10) * 0.01f;     // Catch: Throwable -> L11 Exception -> L13
        com.lynx.tasm.behavior.shadow.text.a r2 = this.v;     // Catch: Throwable -> L11 Exception -> L13
        r1.p = r11 * r2.n;     // Catch: Throwable -> L11 Exception -> L13
        r2.f = 3;     // Catch: Throwable -> L11 Exception -> L13
        goto L21
    L9:
        float r12 = Float.parseFloat(r7.trim());     // Catch: Throwable -> L11 Exception -> L13
        com.lynx.tasm.behavior.shadow.text.a r3 = this.v;     // Catch: Throwable -> L11 Exception -> L13
        r3.p = r12 * r3.n;     // Catch: Throwable -> L11 Exception -> L13
        r3.f = 3;     // Catch: Throwable -> L11 Exception -> L13
        goto L21
    }

    @LynxProp(name = "color")
    public void setColor(f6a.a r8) {
        ReadableType r0 = r8.getType();
        ReadableType r1 = ReadableType.Array;
        if (r0 != r1) goto L23;
        this.v.c = null;
        ReadableArray r9 = r8.asArray();
        if (r9.size() >= 2) goto L7;
    L21:
        this.v.O = null;
    L29:
        q();
        return;
    L7:
        if (r9.getType(1) != r1) goto L21;
        long r3 = r9.getLong(0);
        if (r3 != 2) goto L15;
        com.lynx.tasm.behavior.shadow.text.a r2 = this.v;
        r2.O = new a7a.f(r9.getArray(1));
        if (this.E == false) goto L29;
        this.v.O.i(true);
        goto L29
    L15:
        if (r3 != 3) goto L18;
        com.lynx.tasm.behavior.shadow.text.a r4 = this.v;
        r4.O = new a7a.i(r9.getArray(1));
        goto L29
    L18:
        if (r3 != 4) goto L20;
        com.lynx.tasm.behavior.shadow.text.a r5 = this.v;
        r5.O = new a7a.a(r9.getArray(1));
        goto L29
    L20:
        this.v.O = null;
        goto L29
    L23:
        if (r0 != ReadableType.Int) goto L26;
        com.lynx.tasm.behavior.shadow.text.a r6 = this.v;
        r6.c = Integer.valueOf(r8.asInt());
        this.v.O = null;
        goto L29
    L26:
        if (r0 != ReadableType.Long) goto L28;
        com.lynx.tasm.behavior.shadow.text.a r7 = this.v;
        r7.c = Integer.valueOf((int) r8.asLong());
        this.v.O = null;
        goto L29
    L28:
        com.lynx.tasm.behavior.shadow.text.a r10 = this.v;
        r10.c = null;
        r10.O = null;
        goto L29
    }

    @LynxProp(defaultInt = 0, name = "direction")
    public void setDirection(int r2) {
        this.v.e = r2;
        q();
    }

    @LynxProp(name = "bitmap-gradient")
    public void setEnableBitmapGradient(boolean r2) {
        this.E = r2;
        a7a.b r0 = this.v.O;
        if (r0 == null) goto L6;
        r0.i(r2);
        return;
    }

    @LynxProp(name = "android-emoji-compat")
    public void setEnableEmojiCompat(boolean r6) {
        this.H = r6;
        if (r6 == true) goto L5;
    L13:
        q();
        return;
    L5:
        if (L == false) goto L13;
        if (J != null) goto L13;
        Class r0 = C();     // Catch: Exception -> L11
        K = r0.getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L11
        J = r0.getDeclaredMethod("process", new Class[]{CharSequence.class});     // Catch: Exception -> L11
        r0.getDeclaredMethod("setEmojiSpanIndicatorColor", new Class[]{Integer.TYPE}).invoke(K, new Object[]{0});     // Catch: Exception -> L11
    L11:
        e = move-exception;
        L = false;
        LLog.e("lynx_BaseTextShadowNode", "enable emoji e: " + e);
        goto L13
    }

    @LynxProp(name = "enable-font-scaling")
    public void setEnableFontScaling(String r3) {
        LynxContext r0 = this.m;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(90, r0.getInstanceId());
    L5:
        M(Boolean.parseBoolean(r3));
    }

    @LynxProp(name = "font-family")
    public void setFontFamily(String r2) {
        if (r2 == null) goto L4;
    L7:
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.equals(this.v.u) == true) goto L13;
        this.v.u = r2;
        q();
        return;
    L13:
        return;
    L4:
        if (TextUtils.isEmpty(this.v.u) == true) goto L7;
        this.v.u = null;
        q();
    }

    @LynxProp(name = "font-feature-settings")
    public void setFontFeatureSettings(ReadableArray r6) {
        if (r6 != null) goto L4;
    L13:
        this.v.E = null;
    L14:
        q();
        return;
    L4:
        if (r6.size() == 0) goto L13;
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L8:
        if (r1 >= (r6.size() / 2)) goto L12;
        if (r1 <= 0) goto L11;
        r0.append(",");
    L11:
        int r2 = r1 * 2;
        String r3 = r6.getString(r2);
        int r4 = r6.getInt(r2 + 1);
        r0.append("'");
        r0.append(r3);
        r0.append("' ");
        r0.append(r4);
        r1 = r1 + 1;
        goto L8
    L12:
        com.lynx.tasm.behavior.shadow.text.a r7 = this.v;
        r7.E = r0.toString();
        goto L14
    }

    @LynxProp(defaultFloat = 1.0E21f, name = "font-size")
    public void setFontSize(float r2) {
        if (this.w == false) goto L8;
        LynxContext r0 = this.m;
        if (r0 == null) goto L8;
        r2 = r2 * r0.getFontScale();
    L8:
        if (com.lynx.tasm.utils.b.a(this.v.n, r2) == true) goto L10;
        this.v.n = r2;
    L10:
        q();
    }

    @LynxProp(defaultInt = 0, name = "font-style")
    public void setFontStyle(int r3) {
        if (r3 != 0) goto L7;
        com.lynx.tasm.behavior.shadow.text.a r0 = this.v;
        if (r0.h == 0) goto L7;
        r0.h = 0;
        q();
    L7:
        if (r3 == 1) goto L9;
        if (r3 == 2) goto L9;
        return;
    L9:
        com.lynx.tasm.behavior.shadow.text.a r4 = this.v;
        if (r4.h == 2) goto L14;
        r4.h = 2;
        q();
        return;
    }

    @LynxProp(name = "font-variation-settings")
    public void setFontVariationSettings(ReadableArray r7) {
        if (r7 != null) goto L4;
    L13:
        this.v.D = null;
    L14:
        q();
        return;
    L4:
        if (r7.size() == 0) goto L13;
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L8:
        if (r1 >= (r7.size() / 2)) goto L12;
        if (r1 <= 0) goto L11;
        r0.append(",");
    L11:
        int r2 = r1 * 2;
        String r3 = r7.getString(r2);
        double r4 = r7.getDouble(r2 + 1);
        r0.append("'");
        r0.append(r3);
        r0.append("' ");
        r0.append(r4);
        r1 = r1 + 1;
        goto L8
    L12:
        com.lynx.tasm.behavior.shadow.text.a r8 = this.v;
        r8.D = r0.toString();
        goto L14
    }

    @LynxProp(defaultInt = 0, name = "font-weight")
    public void setFontWeight(int r3) {
        com.lynx.tasm.behavior.shadow.text.a r0 = this.v;
        if (r3 == r0.g) goto L6;
        r0.g = r3;
        q();
        return;
    }

    @LynxProp(name = "include-font-padding")
    public void setIncludeFontPadding(boolean r2) {
        this.v.t = r2;
        q();
    }

    @LynxProp(defaultFloat = 1.0E21f, name = "letter-spacing")
    public void setLetterSpacing(float r2) {
        this.v.l = r2;
        q();
    }

    @LynxProp(defaultFloat = 1.0E21f, name = "line-height")
    public void setLineHeight(float r2) {
        if (this.A == true) goto L6;
        N(r2);
        return;
    }

    @LynxProp(defaultFloat = 0.0f, name = "line-spacing")
    public void setLineSpacing(float r2) {
        this.v.m = r2;
        q();
    }

    @LynxProp(name = "text")
    public void setText(f6a.a r1) {
        this.I = b.b(r1);
        q();
    }

    @LynxProp(defaultInt = 3, name = "text-align")
    public void setTextAlign(int r2) {
        this.v.d = r2;
        q();
    }

    @LynxProp(name = "text-decoration")
    public void setTextDecoration(ReadableArray r4) {
        if (r4 != null) goto L5;
    L9:
        com.lynx.tasm.behavior.shadow.text.a r5 = this.v;
        r5.J = 0;
        r5.K = 4;
        r5.L = 0;
        q();
        return;
    L5:
        if (r4.size() != 3) goto L9;
        int r0 = r4.getInt(0);
        int r1 = r4.getInt(1);
        int r6 = r4.getInt(2);
        com.lynx.tasm.behavior.shadow.text.a r2 = this.v;
        r2.J = r0;
        r2.K = r1;
        r2.L = r6;
        q();
    }

    @LynxProp(name = "text-fake-bold")
    public void setTextFakeBold(boolean r1) {
        this.x = r1;
        q();
    }

    @LynxProp(name = "text-indent")
    public void setTextIndent(ReadableArray r3) {
        if (r3 != null) goto L4;
    L7:
        this.v.o = null;
    L8:
        q();
        return;
    L4:
        if (r3.size() != 2) goto L7;
        com.lynx.tasm.behavior.shadow.text.a r0 = this.v;
        r0.o = new t(r3);
        goto L8
    }

    @LynxProp(name = "text-maxlength")
    public void setTextMaxLength(String r5) {
        this.v.b = Integer.valueOf(r5).intValue();     // Catch: Throwable -> L7
        q();     // Catch: Throwable -> L7
        com.lynx.tasm.behavior.shadow.text.a r6 = this.v;
        if (r6.b >= 0) goto L11;
    L6:
        r6.b = -1;
        return;
    L11:
        return;
    L7:
        this.v.b = -1;     // Catch: Throwable -> L12
        LLog.e("lynx_BaseTextShadowNode", "setTextMaxLength with invalid value:" + r5);     // Catch: Throwable -> L12
        r6 = this.v;
        if (r6.b < 0) goto L6;
        return;
    L12:
        th = move-exception;
        com.lynx.tasm.behavior.shadow.text.a r0 = this.v;
        if (r0.b >= 0) goto L16;
        r0.b = -1;
    L16:
        throw th;
    }

    @LynxProp(name = "text-maxline")
    public void setTextMaxLine(String r5) {
        this.v.a = Integer.parseInt(r5);     // Catch: Throwable -> L8
        com.lynx.tasm.behavior.shadow.text.a r6 = this.v;
        if (r6.a >= 0) goto L7;
    L6:
        r6.a = -1;
    L7:
        q();
        return;
    L8:
        this.v.a = -1;     // Catch: Throwable -> L13
        LLog.e("lynx_BaseTextShadowNode", "setTextMaxLine with invalid value:" + r5);     // Catch: Throwable -> L13
        r6 = this.v;
        if (r6.a >= 0) goto L7;
    L13:
        th = move-exception;
        com.lynx.tasm.behavior.shadow.text.a r0 = this.v;
        if (r0.a >= 0) goto L17;
        r0.a = -1;
    L17:
        q();
        throw th;
    }

    @LynxProp(defaultInt = 0, name = "text-overflow")
    public void setTextOverflow(int r2) {
        this.v.j = r2;
        q();
    }

    @LynxProp(name = "text-shadow")
    public void setTextShadow(ReadableArray r3) {
        this.v.I = null;
        if (r3 != null) goto L5;
        return;
    L5:
        ArrayList r4 = (ArrayList) com.lynx.tasm.behavior.ui.g.b(r3);
        if (r4.size() != 0) goto L8;
        return;
    L8:
        this.v.I = (com.lynx.tasm.behavior.ui.g) ListProtector.get(r4, 0);
    }

    @LynxProp(name = "text-stroke-color")
    public void setTextStrokeColor(f6a.a r4) {
        ReadableType r0 = r4.getType();
        if (r0 != ReadableType.Int) goto L6;
        com.lynx.tasm.behavior.shadow.text.a r1 = this.v;
        r1.M = r4.asInt();
    L9:
        q();
        return;
    L6:
        if (r0 != ReadableType.Long) goto L8;
        com.lynx.tasm.behavior.shadow.text.a r2 = this.v;
        r2.M = (int) r4.asLong();
        goto L9
    L8:
        this.v.M = 0;
        goto L9
    }

    @LynxProp(defaultFloat = 0.0f, name = "text-stroke-width")
    public void setTextStrokeWidth(float r2) {
        this.v.N = r2;
        q();
    }

    @LynxProp(name = "text-vertical-align")
    public void setTextVerticalAlign(String r2) {
        if ("top".equals(r2) == false) goto L6;
        this.v.f = 0;
    L11:
        q();
        return;
    L6:
        if ("center".equals(r2) == false) goto L9;
        this.v.f = 1;
        goto L11
    L9:
        if ("bottom".equals(r2) == false) goto L11;
        this.v.f = 2;
        goto L11
    }

    @LynxProp(name = "use-web-line-height")
    public void setUseWebLineHeight(boolean r2) {
        if (this.y == r2) goto L8;
        this.y = r2;
        float r3 = this.z;
        if (r3 == 1.0E21f) goto L9;
        setLineHeight(r3);
        return;
    L9:
        return;
    }

    @LynxProp(defaultInt = 0, name = "white-space")
    public void setWhiteSpace(int r2) {
        this.v.i = r2;
        q();
    }

    @LynxProp(name = "word-break")
    public void setWordBreakStrategy(int r3) {
        if (r3 == 2) goto L10;
        if (r3 == 1) goto L10;
        if (r3 != 0) goto L8;
        this.F = 2;
    L13:
        q();
        return;
    L8:
        this.F = 0;
    L10:
        if (this.B == false) goto L12;
        this.D = r3;
        goto L13
    L12:
        this.F = 1;
        goto L13
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public void w(LynxContext r3) {
        this.m = r3;
        this.A = r3.isTextRefactorEnabled();
        this.B = r3.isNewClipModeEnabled();
        this.C = r3.isTextBoringLayoutEnabled();
        this.v.t = r3.getDefaultTextIncludePadding();
        this.v.n = Math.round(i.b(14.0f, r3.getScreenMetrics().density));
    }

    @LynxProp(name = "font-optical-sizing")
    public void setFontFeatureSettings(int r3) {
        com.lynx.tasm.behavior.shadow.text.a r0 = this.v;
        boolean r1 = true;
        if (r3 == 1) goto L6;
        r1 = false;
    L6:
        r0.F = r1;
        q();
    }

    public void G(SpannableStringBuilder r14, List<a> r15) {
        com.lynx.tasm.behavior.shadow.text.a r0 = this.v;
        r0.q = false;
        r0.r = false;
        this.G = false;
        int r1 = r14.length();
        if (l() != 0) goto L7;
        String r2 = this.I;
        if (r2 == null) goto L7;
        E(r14, r2, false);
    L7:
        int r3 = l();
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L49;
        ShadowNode r5 = k(r4);
        if ((r5 instanceof RawTextShadowNode) == false) goto L15;
        RawTextShadowNode r6 = (RawTextShadowNode) r5;
        String r7 = r6.v;
        if (r7 == null) goto L46;
        E(r14, r7, r6.w);
    L46:
        r4 = r4 + 1;
        goto L8
    L15:
        if ((r5 instanceof AbsInlineImageShadowNode) == false) goto L27;
        r14.append("I");
        AbsInlineImageShadowNode r8 = (AbsInlineImageShadowNode) r5;
        int r9 = r14.length() - 1;
        int r10 = r14.length();
        com.lynx.tasm.behavior.ui.text.a r11 = r8.O();
        r8.S(r11);
        com.lynx.tasm.behavior.ui.utils.e r12 = r8.P;
        if (r12 == null) goto L21;
        BackgroundDrawable r13 = (BackgroundDrawable) r12.b;
        if (r13 == null) goto L21;
        r13.setBounds(0, 0, (int) Math.ceil(r8.h.c()), (int) Math.ceil((int) r8.h.a()));
        r8.P.n(r8.O);
        r11.n = r8.P;
    L22:
        r11.m = r8.v.p;
        a r16 = new a(r9, r10, r11);
        ArrayList r17 = (ArrayList) r15;
        r17.add(r16);
        if (r8.r() == false) goto L25;
        r17.add(new a(r9, r10, r8.A()));
    L25:
        this.v.q = true;
    L21:
        r11.l = r8.O;
        goto L22
    L27:
        if ((r5 instanceof NativeLayoutNodeRef) == false) goto L33;
        r14.append("B");
        NativeLayoutNodeRef r18 = (NativeLayoutNodeRef) r5;
        int r19 = r14.length() - 1;
        int r20 = r14.length();
        r18.x = r19;
        r18.v = r19;
        r18.y = r20;
        r18.w = r20;
        n r21 = new n();
        y6a.n r22 = r18.n;
        if (r22 == null) goto L31;
        int r110 = r22.a;
        float r23 = r22.b;
        r21.a = r110;
        r21.b = r23;
    L31:
        a r24 = new a(r19, r20, r21);
        ArrayList r25 = (ArrayList) r15;
        r25.add(r24);
        r25.add(new a(r19, r20, r18.A()));
        this.v.r = true;
        goto L46
    L33:
        if ((r5 instanceof BaseTextShadowNode) == false) goto L48;
        if ((r5 instanceof InlineTruncationShadowNode) == true) goto L46;
        BaseTextShadowNode r26 = (BaseTextShadowNode) r5;
        com.lynx.tasm.behavior.shadow.text.a r27 = r26.v;
        if (r27.c == null) goto L40;
    L45:
        r26.G(r14, r15);
        com.lynx.tasm.behavior.shadow.text.a r28 = this.v;
        boolean r29 = r28.q;
        com.lynx.tasm.behavior.shadow.text.a r30 = r26.v;
        r28.q = r29 | r30.q;
        r28.r |= r30.r;
        this.G = r26.G | this.G;
        goto L46
    L40:
        if (r27.N <= 0.0f) goto L45;
        Integer r31 = this.v.c;
        if (r31 == null) goto L44;
        r27.c = Integer.valueOf(r31.intValue());
        goto L45
    L44:
        r27.c = -16777216;
        goto L45
    L48:
        throw new RuntimeException("Unexpected view type nested under text node: " + r5.getClass());
    L49:
        int r111 = r14.length();
        if (r111 <= r1) goto L61;
        F(r1, r111, r15);
        return;
    }

    public final CharSequence H(String r6, boolean r7) {
        if (this.H == false) goto L13;
        if (L == false) goto L13;
        return (CharSequence) J.invoke(K, new Object[]{I(r6, r7)});
    L9:
        e = move-exception;
        LLog.w("lynx_BaseTextShadowNode", "process emoji: " + e);
        return I(r6, r7);
    L13:
        return I(r6, r7);
    }

    public final CharSequence I(String r11, boolean r12) {
        int r0 = 2;
        int r1 = 0;
        if (r12 == false) goto L50;
        int r13 = this.D;
        if (r13 == 1) goto L8;
        if (r13 == 2) goto L9;
        r0 = 0;
    L9:
        com.lynx.tasm.behavior.utils.f.a r14 = null;
        if (r11 != null) goto L13;
        return null;
    L13:
        if (r0 == 0) goto L15;
    L17:
        int r4 = r11.length();
        StringBuilder r5 = new StringBuilder(r4);
        if (r0 == 0) goto L20;
        r14 = new com.lynx.tasm.behavior.utils.f.a();
    L20:
        if (r1 >= r4) goto L68;
        if (r11.charAt(r1) != '\\') goto L45;
        int r6 = r1 + 1;
        if (r6 >= r4) goto L45;
        StringBuilder r7 = new StringBuilder();
    L26:
        if (r6 < r4) goto L28;
    L58:
        r5.append((char) CastIntegerProtector.parseInt(r7.toString(), 16));     // Catch: Exception -> L44
        r1 = r1 + r7.length();
    L46:
        if (r0 == 0) goto L48;
        r14.a(r5, r0);
    L48:
        r1 = r1 + 1;
    L44:
        r5.append(r11.charAt(r1));
        goto L46
    L28:
        if (r6 >= (r1 + 5)) goto L58;
        char r8 = r11.charAt(r6);
        if (r8 < '0') goto L34;
        if (r8 > '9') goto L34;
    L41:
        r7.append(r8);
        r6 = r6 + 1;
    L34:
        if (r8 < 'A') goto L38;
        if (r8 <= 'Z') goto L41;
    L38:
        if (r8 < 'a') goto L58;
        if (r8 > 'z') goto L58;
    L45:
        r5.append(r11.charAt(r1));
        goto L46
    L68:
        return r5.toString();
    L15:
        if (r11.indexOf(92) >= 0) goto L17;
        return r11;
    L8:
        r0 = 1;
        goto L9
    L50:
        int r15 = this.D;
        if (r15 == 1) goto L54;
        if (r15 != 2) goto L57;
    L55:
        r1 = r0;
    L57:
        return com.lynx.tasm.behavior.utils.f.a(r11, r1);
    L54:
        r0 = 1;
        goto L55
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void j(ShadowNode r1, int r2) {
        super.j(r1, r2);
        if ((r1 instanceof BaseTextShadowNode) == false) goto L6;
        ((BaseTextShadowNode) r1).M(this.w);
        return;
    }

    public final void D(Layout r10, SpannableStringBuilder r11, PointF r12) {
        int r1 = 0;
    L4:
        if (r1 >= l()) goto L30;
        ShadowNode r2 = k(r1);
        if ((r2 instanceof NativeLayoutNodeRef) == false) goto L25;
        NativeLayoutNodeRef r3 = (NativeLayoutNodeRef) r2;
        y6a.b r4 = new y6a.b();
        if (r3.v < r10.getText().length()) goto L10;
        r3.C(r4);
    L29:
        r1 = r1 + 1;
        goto L4
    L10:
        n[] r5 = (n[]) r11.getSpans(r3.v, r3.w, n.class);
        if (r5.length != 1) goto L13;
        n r6 = r5[0];
    L14:
        int r7 = r10.getLineForOffset(r3.v);
        float r8 = r10.getPrimaryHorizontal(r3.v) + r12.x;
        if (r10.isRtlCharAt(r3.v) == false) goto L20;
        if (r6 != null) goto L18;
        int r9 = 0;
    L19:
        r8 = r8 - r9;
        goto L20
    L18:
        r9 = r6.g;
    L20:
        r4.a = r8;
        if (r6 == null) goto L23;
        r4.b = r6.b(r10.getLineTop(r7), r10.getLineBottom(r7), r10.getLineAscent(r7), r10.getLineDescent(r7)) + r12.y;
    L23:
        r3.C(r4);
        goto L29
    L13:
        r6 = null;
        goto L14
    L25:
        if ((r2 instanceof InlineTextShadowNode) == false) goto L27;
    L28:
        ((BaseTextShadowNode) r2).D(r10, r11, r12);
        goto L29
    L27:
        if ((r2 instanceof InlineTruncationShadowNode) == false) goto L29;
    }

    public void E(SpannableStringBuilder r1, String r2, boolean r3) {
        r1.append(H(r2, r3));
    }

    public void F(int r12, int r13, List<a> r14) {
        if (K() == true) goto L7;
        if (this.v.c == null) goto L7;
    L8:
        Integer r0 = this.v.c;
        if (r0 != null) goto L11;
        int r1 = -16777216;
    L12:
        j r3 = new j(r1);
        com.lynx.tasm.behavior.shadow.text.a r2 = this.v;
        float r4 = r2.N;
        if (r4 <= 0.0f) goto L17;
        int r5 = r2.M;
        if (r5 == 0) goto L17;
        r3.b = r5;
        r3.c = r4;
        this.G = true;
    L17:
        ArrayList r6 = (ArrayList) r14;
        r6.add(new a(r12, r13, r3));
    L18:
        com.lynx.tasm.behavior.shadow.text.a r7 = this.v;
        boolean r8 = false;
        if (r7.K == 4) goto L21;
    L29:
        int r9 = r7.J;
        if ((r9 & 1) == 0) goto L32;
        boolean r10 = true;
    L34:
        if ((r9 & 2) == 0) goto L36;
        boolean r11 = true;
    L37:
        if (r10 == true) goto L39;
        if (r11 == true) goto L39;
    L41:
        if (this.v.f != (-1)) goto L43;
    L45:
        y6a.n r15 = this.n;
        if (r15 == null) goto L51;
        if (r15.a == 0) goto L51;
        k r16 = new k();
        y6a.n r17 = this.n;
        int r18 = r17.a;
        float r19 = r17.b;
        r16.a = r18;
        r16.b = r19;
        a r20 = new a(r12, r13, r16);
        ((ArrayList) r14).add(r20);
    L51:
        if (l.a(this.v.k) == false) goto L53;
    L62:
        com.lynx.tasm.behavior.shadow.text.a r21 = this.v;
        if (r21.G != 0) goto L65;
    L69:
        boolean r22 = false;
    L70:
        if (r22 == false) goto L72;
    L71:
        boolean r23 = true;
    L73:
        if (r23 == false) goto L83;
        com.lynx.tasm.behavior.shadow.text.a r24 = this.v;
        float r25 = r24.k;
        boolean r26 = this.A;
        int r27 = r24.G;
        if (r24.j == 0) goto L77;
    L81:
        a r28 = new a(r12, r13, new z6a.f(r25, r26, r27, r8));
        ((ArrayList) r14).add(r28);
        goto L83
    L77:
        if (r24.a != 1) goto L79;
    L80:
        r8 = true;
        goto L81
    L79:
        if (r24.i != 1) goto L81;
    L83:
        if (this.v.I == null) goto L86;
        a r29 = new a(r12, r13, new o(this.v.I));
        ((ArrayList) r14).add(r29);
    L86:
        if (this.v.l == 1.0E21f) goto L89;
        a r30 = new a(r12, r13, new z6a.e(this.v.l));
        ((ArrayList) r14).add(r30);
    L89:
        if (Build.VERSION.SDK_INT >= 28) goto L91;
    L95:
        com.lynx.tasm.behavior.shadow.text.a r31 = this.v;
        int r32 = r31.h;
        if (r32 == 1) goto L100;
        if (r32 == 2) goto L100;
        if (r31.e() == 1) goto L100;
    L102:
        if (this.v.O == null) goto L105;
        ArrayList r110 = (ArrayList) r14;
        r110.add(new a(r12, r13, new m(this.v.O)));
        return;
    L105:
        return;
    L100:
        a r33 = new a(r12, r13, new StyleSpan(this.v.e()));
        ((ArrayList) r14).add(r33);
        goto L102
    L91:
        if (this.x == true) goto L95;
        if (K() == true) goto L102;
        com.lynx.tasm.behavior.shadow.text.a r34 = this.v;
        int r35 = r34.h;
        int r36 = r34.g;
        String r37 = r34.u;
        String r38 = r34.c();
        com.lynx.tasm.behavior.shadow.text.a r39 = this.v;
        a r40 = new a(r12, r13, new z6a.g(r35, r36, r37, r38, r39.E, r39.B));
        ((ArrayList) r14).add(r40);
        goto L102
    L72:
        r23 = false;
        goto L73
    L65:
        if (r21.r == true) goto L69;
        if (r21.q == true) goto L69;
        r22 = true;
        goto L70
    L53:
        if (this.C == false) goto L71;
        if (this.A == false) goto L71;
        com.lynx.tasm.behavior.shadow.text.a r41 = this.v;
        if (r41.i != 1) goto L71;
        if (r41.q == true) goto L71;
        if (r41.r == true) goto L71;
    L43:
        if (Build.VERSION.SDK_INT <= 28) goto L45;
        com.lynx.tasm.behavior.shadow.text.a r42 = this.v;
        a r43 = new a(r12, r13, new z6a.d(r42.f, r42.p));
        ((ArrayList) r14).add(r43);
    L39:
        com.lynx.tasm.behavior.shadow.text.a r44 = this.v;
        a r45 = new a(r12, r13, new q(r10, r11, r44.K, r44.L));
        ((ArrayList) r14).add(r45);
        goto L41
    L36:
        r11 = false;
        goto L37
    L32:
        r10 = false;
        goto L34
    L21:
        if (r7.L != 0) goto L29;
        if ((r7.J & 2) == 0) goto L27;
        a r46 = new a(r12, r13, new LynxStrikethroughSpan());
        ((ArrayList) r14).add(r46);
    L27:
        if ((this.v.J & 1) == 0) goto L41;
        a r47 = new a(r12, r13, new LynxUnderlineSpan());
        ((ArrayList) r14).add(r47);
        goto L41
    L11:
        r1 = r0.intValue();
    L7:
        if (this.v.N <= 0.0f) goto L18;
        goto L8
    }

    public final void J(CharSequence r6, Set r7, int r8) {
        int r1 = 0;
    L4:
        if (r1 >= l()) goto L20;
        ShadowNode r2 = k(r1);
        if ((r2 instanceof NativeLayoutNodeRef) == false) goto L15;
        NativeLayoutNodeRef r3 = (NativeLayoutNodeRef) r2;
        if (r3.v >= r6.length()) goto L13;
        int r4 = r3.v;
        if (r4 >= r8) goto L13;
        if (r6.charAt(r4) != "B".charAt(0)) goto L13;
    L19:
        r1 = r1 + 1;
    L13:
        HashSet r5 = (HashSet) r7;
        r5.add(Integer.valueOf(r3.b));
        goto L19
    L15:
        if ((r2 instanceof BaseTextShadowNode) == false) goto L19;
        if ((r2 instanceof InlineTruncationShadowNode) == true) goto L19;
        ((BaseTextShadowNode) r2).J(r6, r7, r8);
        goto L19
    }

    public final void L(SpannableStringBuilder r12, y6a.j r13, y6a.g r14) {
        int r1 = 0;
    L4:
        if (r1 >= l()) goto L16;
        ShadowNode r2 = k(r1);
        if ((r2 instanceof NativeLayoutNodeRef) == false) goto L11;
        NativeLayoutNodeRef r3 = (NativeLayoutNodeRef) r2;
        y6a.k r4 = r3.D(r14, r13);
        n[] r5 = (n[]) r12.getSpans(r3.v, r3.w, n.class);
        int r6 = r5.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L15;
        n r8 = r5[r7];
        int r9 = (int) Math.floor(r4.a[0]);
        int r10 = (int) Math.ceil(r4.a[1]);
        int r11 = (int) Math.ceil(r4.a[2]);
        r8.g = r9;
        r8.f = r10;
        r8.h = r11;
        r7 = r7 + 1;
    L15:
        r1 = r1 + 1;
        goto L4
    L11:
        if ((r2 instanceof BaseTextShadowNode) == false) goto L15;
        if ((r2 instanceof InlineTruncationShadowNode) == true) goto L15;
        ((BaseTextShadowNode) r2).L(r12, r13, r14);
        goto L15
    }
}
