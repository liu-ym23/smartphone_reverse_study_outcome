package com.lynx.tasm.behavior.shadow.text;

import an.e;
import an.h;
import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.emoji2.text.EmojiCompat;
import com.bumptech.glide.load.engine.j;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.r;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.u0;
import com.lynx.tasm.utils.g;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import k5.d;
import pm.a;
import ym.i;
import ym.l;
import ym.n;
import zm.b;
import zm.f;
import zm.k;
import zm.m;
import zm.o;
import zm.q;
import zm.s;
import zm.t;
import zm.u;

/* JADX INFO: loaded from: classes2.dex */
public class BaseTextShadowNode extends ShadowNode {
    public static Method H = null;
    public static Object I = null;
    public static boolean J = true;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public boolean F;
    public String G;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q f10357v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10358w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10359x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f10360y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f10361z;

    public BaseTextShadowNode() {
        this.f10358w = false;
        this.f10359x = false;
        this.f10360y = false;
        this.f10361z = 1.0E21f;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = 0;
        this.G = null;
        this.f10357v = new q();
    }

    public boolean A() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void f(int r5, ShadowNode r10) {
        super.f(r5, r10);
        if ((r10 instanceof BaseTextShadowNode) == false) goto L6;
        ((BaseTextShadowNode) r10).z(this.f10358w);
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public void h(b0 r5) {
        this.f10349m = r5;
        u0 r10 = r5.K;
        boolean r11 = false;
        if (r10 == null) goto L5;
        boolean r12 = r10.s;
    L6:
        this.A = r12;
        if (r10 == null) goto L9;
        boolean r13 = r10.f10983v;
    L10:
        this.B = r13;
        if (r10 == null) goto L13;
        boolean r14 = r10.f10982u;
    L14:
        this.C = r14;
        if (r10 == null) goto L17;
        r11 = r10.f10985x;
    L17:
        q r15 = this.f10357v;
        r15.f23528t = r11;
        r15.f23523n = Math.round(g.a(14.0f, r5.f10152u.density));
        return;
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    public final String s(String r10, boolean r11) {
        int r5 = 0;
        int r12 = 2;
        if (r11 == false) goto L51;
        int r13 = this.D;
        if (r13 == 1) goto L8;
        if (r13 == 2) goto L9;
        r12 = 0;
    L9:
        j r14 = null;
        if (r10 != null) goto L13;
        return null;
    L13:
        if (r12 == 0) goto L15;
    L17:
        int r15 = r10.length();
        StringBuilder r16 = new StringBuilder(r15);
        if (r12 == 0) goto L20;
        r14 = new j();
    L20:
        if (r5 >= r15) goto L50;
        if (r10.charAt(r5) != '\\') goto L45;
        int r17 = r5 + 1;
        if (r17 >= r15) goto L45;
        StringBuilder r18 = new StringBuilder();
    L26:
        if (r17 < r15) goto L28;
    L59:
        r16.append((char) Integer.parseInt(r18.toString(), 16));     // Catch: Exception -> L44
        r5 = r5 + r18.length();
    L46:
        if (r12 == 0) goto L48;
        r14.a(r16, r12);
    L48:
        r5 = r5 + 1;
    L44:
        r16.append(r10.charAt(r5));
        goto L46
    L28:
        if (r17 >= (r5 + 5)) goto L59;
        char r19 = r10.charAt(r17);
        if (r19 < '0') goto L34;
        if (r19 > '9') goto L34;
    L41:
        r18.append(r19);
        r17 = r17 + 1;
    L34:
        if (r19 < 'A') goto L38;
        if (r19 <= 'Z') goto L41;
    L38:
        if (r19 < 'a') goto L59;
        if (r19 > 'z') goto L59;
    L45:
        r16.append(r10.charAt(r5));
        goto L46
    L50:
        return r16.toString();
    L15:
        if (r10.indexOf(92) >= 0) goto L17;
        return r10;
    L8:
        r12 = 1;
        goto L9
    L51:
        int r20 = this.D;
        if (r20 == 1) goto L56;
        if (r20 != 2) goto L58;
        r5 = 2;
    L58:
        return d.d(r5, r10);
    L56:
        r5 = 1;
        goto L58
    }

    @c0(name = "custom-baseline-shift")
    public void setBaselineShift(String r10) {
        q r5 = this.f10357v;
    L8:
        e = move-exception;
        LynxLog.b(4, "BaseTextShadowNode", e.toString());     // Catch: Throwable -> L6
        r5.f23525p = 0.0f;     // Catch: Throwable -> L6
        r5.f = -1;     // Catch: Throwable -> L6
        n();
        return;
    L4:
        if (r10.contains("px") == false) goto L11;
        r5.f23525p = g.a(Float.parseFloat(r10.substring(0, r10.indexOf("px")).trim()), 0.0f);     // Catch: Throwable -> L6 Exception -> L8
        r5.f = 3;     // Catch: Throwable -> L6 Exception -> L8
    L14:
        n();
        return;
    L11:
        if (r10.contains("%") == false) goto L13;
        r5.f23525p = (Float.parseFloat(r10.substring(0, r10.indexOf("%")).trim()) * 0.01f) * r5.f23523n;     // Catch: Throwable -> L6 Exception -> L8
        r5.f = 3;     // Catch: Throwable -> L6 Exception -> L8
        goto L14
    L13:
        r5.f23525p = Float.parseFloat(r10.trim()) * r5.f23523n;     // Catch: Throwable -> L6 Exception -> L8
        r5.f = 3;     // Catch: Throwable -> L6 Exception -> L8
    L6:
        th = move-exception;
        n();
        throw th;
    }

    @c0(name = "color")
    public void setColor(a r10) {
        ReadableType r5 = r10.getType();
        ReadableType r11 = ReadableType.Array;
        q r12 = this.f10357v;
        if (r5 != r11) goto L18;
        r12.f23516c = null;
        ReadableArray r13 = r10.asArray();
        if (r13.size() >= 2) goto L7;
    L16:
        r12.M = null;
    L24:
        n();
        return;
    L7:
        if (r13.getType(1) != r11) goto L16;
        long r14 = r13.getLong(0);
        if (r14 != 2) goto L13;
        r12.M = new e(r13.getArray(1));
        goto L24
    L13:
        if (r14 != 3) goto L15;
        r12.M = new h(r13.getArray(1));
        goto L24
    L15:
        r12.M = null;
        goto L24
    L18:
        if (r5 != ReadableType.Int) goto L21;
        r12.f23516c = Integer.valueOf(r10.asInt());
        r12.M = null;
        goto L24
    L21:
        if (r5 != ReadableType.Long) goto L23;
        r12.f23516c = Integer.valueOf((int) r10.asLong());
        r12.M = null;
        goto L24
    L23:
        r12.f23516c = null;
        r12.M = null;
        goto L24
    }

    @c0(defaultInt = 0, name = "direction")
    public void setDirection(int r5) {
        this.f10357v.e = r5;
        n();
    }

    @c0(name = "bitmap-gradient")
    public void setEnableBitmapGradient(boolean r5) {
        an.a r10 = this.f10357v.M;
        if (r10 == null) goto L6;
        r10.d(r5);
        return;
    }

    @c0(name = "android-emoji-compat")
    public void setEnableEmojiCompat(boolean r5) {
        if (r5 == true) goto L4;
    L12:
        n();
        return;
    L4:
        if (J == false) goto L12;
        if (H != null) goto L12;
        I = EmojiCompat.class.getDeclaredMethod("get", null).invoke(null, null);     // Catch: Exception -> L10
        H = EmojiCompat.class.getDeclaredMethod("process", new Class[]{CharSequence.class});     // Catch: Exception -> L10
        EmojiCompat.class.getDeclaredMethod("setEmojiSpanIndicatorColor", new Class[]{Integer.TYPE}).invoke(I, new Object[]{0});     // Catch: Exception -> L10
    L10:
        e = move-exception;
        J = false;
        LynxLog.b(4, "lynx_BaseTextShadowNode", "enable emoji e: " + e);
        goto L12
    }

    @c0(name = "enable-font-scaling")
    public void setEnableFontScaling(String r5) {
        b0 r10 = this.f10349m;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(80, r10.A);
    L5:
        z(Boolean.parseBoolean(r5));
    }

    @c0(name = "font-family")
    public void setFontFamily(String r5) {
        q r10 = this.f10357v;
        if (r5 == null) goto L5;
    L8:
        if (r5 != null) goto L10;
        return;
    L10:
        if (r5.equals(r10.f23529u) == true) goto L14;
        r10.f23529u = r5;
        n();
        return;
    L14:
        return;
    L5:
        if (TextUtils.isEmpty(r10.f23529u) == true) goto L8;
        r10.f23529u = null;
        n();
    }

    @c0(name = "font-feature-settings")
    public void setFontFeatureSettings(ReadableArray r10) {
        q r5 = this.f10357v;
        if (r10 != null) goto L5;
    L12:
        r5.D = null;
    L13:
        n();
        return;
    L5:
        if (r10.size() == 0) goto L12;
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L9:
        if (r12 >= (r10.size() / 2)) goto L11;
        int r13 = r12 * 2;
        String r14 = r10.getString(r13);
        int r15 = r10.getInt(r13 + 1);
        r11.append("'");
        r11.append(r14);
        r11.append("' ");
        r11.append(r15);
        r11.append(",");
        r12 = r12 + 1;
        goto L9
    L11:
        r5.D = r11.toString();
        goto L13
    }

    @c0(defaultFloat = 1.0E21f, name = "font-size")
    public void setFontSize(float r5) {
        if (this.f10358w == false) goto L10;
        b0 r10 = this.f10349m;
        if (r10 == null) goto L10;
        if (r10.H != null) goto L9;
        r10.H = Float.valueOf(r10.getResources().getConfiguration().fontScale);
    L9:
        r5 = r5 * r10.H.floatValue();
    L10:
        q r11 = this.f10357v;
        if (com.lynx.tasm.utils.a.k(r11.f23523n, r5) == true) goto L13;
        r11.f23523n = r5;
    L13:
        n();
    }

    @c0(defaultInt = 0, name = "font-style")
    public void setFontStyle(int r5) {
        q r10 = this.f10357v;
        if (r5 != 0) goto L8;
        if (r10.f23517h == 0) goto L8;
        r10.f23517h = 0;
        n();
    L8:
        if (r5 == 1) goto L11;
        if (r5 == 2) goto L11;
        return;
    L11:
        if (r10.f23517h == 2) goto L15;
        r10.f23517h = 2;
        n();
        return;
    }

    @c0(name = "font-variation-settings")
    public void setFontVariationSettings(ReadableArray r10) {
        q r5 = this.f10357v;
        if (r10 != null) goto L5;
    L12:
        r5.C = null;
    L13:
        n();
        return;
    L5:
        if (r10.size() == 0) goto L12;
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L9:
        if (r12 >= (r10.size() / 2)) goto L11;
        int r13 = r12 * 2;
        String r14 = r10.getString(r13);
        double r15 = r10.getDouble(r13 + 1);
        r11.append("'");
        r11.append(r14);
        r11.append("' ");
        r11.append(r15);
        r11.append(",");
        r12 = r12 + 1;
        goto L9
    L11:
        r5.C = r11.toString();
        goto L13
    }

    @c0(defaultInt = 0, name = "font-weight")
    public void setFontWeight(int r5) {
        q r10 = this.f10357v;
        if (r5 == r10.g) goto L6;
        r10.g = r5;
        n();
        return;
    }

    @c0(name = "include-font-padding")
    public void setIncludeFontPadding(boolean r5) {
        this.f10357v.f23528t = r5;
        n();
    }

    @c0(defaultFloat = 1.0E21f, name = "letter-spacing")
    public void setLetterSpacing(float r5) {
        this.f10357v.f23521l = r5;
        n();
    }

    @c0(defaultFloat = 1.0E21f, name = "line-height")
    public void setLineHeight(float r5) {
        if (this.A == true) goto L16;
        this.f10361z = r5;
        if (this.f10358w == false) goto L12;
        b0 r10 = this.f10349m;
        if (r10 == null) goto L12;
        if (r10.H != null) goto L11;
        r10.H = Float.valueOf(r10.getResources().getConfiguration().fontScale);
    L11:
        r5 = r5 * r10.H.floatValue();
    L12:
        q r11 = this.f10357v;
        if (r11.f23520k == r5) goto L17;
        r11.f23520k = r5;
        n();
        return;
    L17:
        return;
    }

    @c0(defaultFloat = 0.0f, name = "line-spacing")
    public void setLineSpacing(float r5) {
        this.f10357v.f23522m = r5;
        n();
    }

    @c0(name = MessageIndication.CONTENT_TYPE_TEXT)
    public void setText(@Nullable a r10) {
        DecimalFormat r5 = t.f23539a;
        if (r10 == null) goto L15;
        int r11 = s.f23538a[r10.getType().ordinal()];
        if (r11 != 1) goto L8;
        String r12 = r10.asString();
    L28:
        this.G = r12;
        n();
        return;
    L8:
        if (r11 != 2) goto L10;
        r12 = String.valueOf(r10.asInt());
        goto L28
    L10:
        if (r11 != 3) goto L12;
        r12 = String.valueOf(r10.asLong());
        goto L28
    L12:
        if (r11 != 4) goto L14;
        double r13 = r10.asDouble();
        if (r13 < 9.223372036854776E18d) goto L20;
    L24:
        r12 = t.f23539a.format(r13);
        goto L28
    L20:
        if (r13 <= (-9.223372036854776E18d)) goto L24;
        long r14 = (long) Math.floor(r13);
        if (r13 != r14) goto L24;
        r12 = String.valueOf(r14);
        goto L28
    L14:
        if (r11 != 5) goto L15;
        r12 = String.valueOf(r10.asBoolean());
    L15:
        r12 = null;
        goto L28
    }

    @c0(defaultInt = 3, name = "text-align")
    public void setTextAlign(int r5) {
        this.f10357v.d = r5;
        n();
    }

    @c0(name = "text-decoration")
    public void setTextDecoration(ReadableArray r5) {
        q r10 = this.f10357v;
        if (r5 != null) goto L5;
    L9:
        r10.H = 0;
        r10.I = 4;
        r10.J = 0;
        n();
        return;
    L5:
        if (r5.size() != 3) goto L9;
        int r11 = r5.getInt(0);
        int r12 = r5.getInt(1);
        int r13 = r5.getInt(2);
        r10.H = r11;
        r10.I = r12;
        r10.J = r13;
        n();
    }

    @c0(name = "text-fake-bold")
    public void setTextFakeBold(boolean r5) {
        this.f10359x = r5;
        n();
    }

    @c0(name = "text-indent")
    public void setTextIndent(ReadableArray r5) {
        q r10 = this.f10357v;
        if (r5 != null) goto L5;
    L8:
        r10.f23524o = null;
    L9:
        n();
        return;
    L5:
        if (r5.size() != 2) goto L8;
        r10.f23524o = new u(r5);
        goto L9
    }

    @c0(name = "text-maxlength")
    public void setTextMaxLength(String r5) {
        q r10 = this.f10357v;
        r10.f23515b = Integer.valueOf(r5).intValue();     // Catch: Throwable -> L8
        n();     // Catch: Throwable -> L8
        if (r10.f23515b >= 0) goto L21;
        r10.f23515b = -1;
        return;
    L21:
        return;
    L8:
        r10.f23515b = -1;     // Catch: Throwable -> L13
        LynxLog.b(4, "lynx_BaseTextShadowNode", "setTextMaxLength with invalid value:" + r5);     // Catch: Throwable -> L13
        if (r10.f23515b >= 0) goto L22;
        r10.f23515b = -1;
        return;
    L22:
        return;
    L13:
        th = move-exception;
        if (r10.f23515b >= 0) goto L17;
        r10.f23515b = -1;
    L17:
        throw th;
    }

    @c0(name = "text-maxline")
    public void setTextMaxLine(String r10) {
        q r5 = this.f10357v;
        r5.f23514a = Integer.parseInt(r10);     // Catch: Throwable -> L9
        if (r5.f23514a >= 0) goto L7;
        r5.f23514a = -1;
    L7:
        n();
        return;
    L9:
        r5.f23514a = -1;     // Catch: Throwable -> L15
        LynxLog.b(4, "lynx_BaseTextShadowNode", "setTextMaxLine with invalid value:" + r10);     // Catch: Throwable -> L15
        if (r5.f23514a >= 0) goto L13;
        r5.f23514a = -1;
    L13:
        n();
        return;
    L15:
        th = move-exception;
        if (r5.f23514a >= 0) goto L19;
        r5.f23514a = -1;
    L19:
        n();
        throw th;
    }

    @c0(defaultInt = 0, name = "text-overflow")
    public void setTextOverflow(int r5) {
        this.f10357v.f23519j = r5;
        n();
    }

    @c0(name = "text-shadow")
    public void setTextShadow(@Nullable ReadableArray r5) {
        q r10 = this.f10357v;
        r10.G = null;
        if (r5 == null) goto L10;
        ArrayList r11 = r.a(r5);
        if (r11.size() != 0) goto L8;
        return;
    L8:
        r10.G = (r) r11.get(0);
        return;
    }

    @c0(name = "text-stroke-color")
    public void setTextStrokeColor(a r5) {
        ReadableType r10 = r5.getType();
        ReadableType r11 = ReadableType.Int;
        q r12 = this.f10357v;
        if (r10 != r11) goto L6;
        r12.K = r5.asInt();
    L9:
        n();
        return;
    L6:
        if (r10 != ReadableType.Long) goto L8;
        r12.K = (int) r5.asLong();
        goto L9
    L8:
        r12.K = 0;
        goto L9
    }

    @c0(defaultFloat = 0.0f, name = "text-stroke-width")
    public void setTextStrokeWidth(float r5) {
        this.f10357v.L = r5;
        n();
    }

    @c0(name = "text-vertical-align")
    public void setTextVerticalAlign(String r5) {
        boolean r10 = "top".equals(r5);
        q r11 = this.f10357v;
        if (r10 == false) goto L6;
        r11.f = 0;
    L11:
        n();
        return;
    L6:
        if ("center".equals(r5) == false) goto L9;
        r11.f = 1;
        goto L11
    L9:
        if ("bottom".equals(r5) == false) goto L11;
        r11.f = 2;
        goto L11
    }

    @c0(name = "use-web-line-height")
    public void setUseWebLineHeight(boolean r5) {
        if (this.f10360y == r5) goto L8;
        this.f10360y = r5;
        float r10 = this.f10361z;
        if (r10 == 1.0E21f) goto L9;
        setLineHeight(r10);
        return;
    L9:
        return;
    }

    @c0(defaultInt = 0, name = "white-space")
    public void setWhiteSpace(int r5) {
        this.f10357v.f23518i = r5;
        n();
    }

    @c0(name = "word-break")
    public void setWordBreakStrategy(int r5) {
        if (r5 == 2) goto L10;
        if (r5 == 1) goto L10;
        if (r5 != 0) goto L8;
        this.E = 2;
    L13:
        n();
        return;
    L8:
        this.E = 0;
    L10:
        if (this.B == false) goto L12;
        this.D = r5;
        goto L13
    L12:
        this.E = 1;
        goto L13
    }

    public void t(int r12, int r13, ArrayList r14) {
        boolean r5 = A();
        q r10 = this.f10357v;
        if (r5 == true) goto L7;
        if (r10.f23516c == null) goto L7;
    L8:
        Integer r11 = r10.f23516c;
        if (r11 != null) goto L11;
        int r15 = ViewCompat.MEASURED_STATE_MASK;
    L12:
        zm.j r16 = new zm.j(r15);
        float r17 = r10.L;
        if (r17 <= 0.0f) goto L17;
        int r18 = r10.K;
        if (r18 == 0) goto L17;
        r16.f23495b = r18;
        r16.f23496c = r17;
        this.F = true;
    L17:
        r14.add(new b(r12, r13, r16));
    L18:
        boolean r19 = false;
        if (r10.I == 4) goto L21;
    L29:
        int r20 = r10.H;
        if ((r20 & 1) == 0) goto L32;
        boolean r21 = true;
    L34:
        if ((r20 & 2) == 0) goto L36;
        boolean r22 = true;
    L37:
        if (r21 == true) goto L39;
        if (r22 == true) goto L39;
    L41:
        if (r10.f == (-1)) goto L43;
        r14.add(new b(r12, r13, new zm.d(r10.f23525p, r10.f)));
    L43:
        n r23 = this.f10350n;
        if (r23 == null) goto L49;
        if (r23.f23307a == 0) goto L49;
        k r24 = new k();
        r24.f23499c = 0;
        r24.e = 1.0E21f;
        n r25 = this.f10350n;
        int r26 = r25.f23307a;
        float r27 = r25.f23308b;
        r24.f23497a = r26;
        r24.f23498b = r27;
        r14.add(new b(r12, r13, r24));
    L49:
        if (ym.k.b(r10.f23520k) == true) goto L61;
        if (this.C == true) goto L53;
    L66:
        float r28 = r10.f23520k;
        boolean r29 = this.A;
        int r30 = r10.F;
        if (r10.f23519j == 0) goto L69;
    L73:
        r14.add(new b(r12, r13, new f(r30, r28, r29, r19)));
    L75:
        if (r10.G == null) goto L78;
        r14.add(new b(r12, r13, new o(r10.G)));
    L78:
        if (r10.f23521l == 1.0E21f) goto L81;
        r14.add(new b(r12, r13, new zm.e(r10.f23521l)));
    L81:
        if (this.f10359x == false) goto L83;
        int r110 = r10.f23517h;
        if (r110 == 1) goto L99;
        if (r110 == 2) goto L99;
        if (r10.d() == 1) goto L99;
    L101:
        if (r10.M == null) goto L104;
        r14.add(new b(r12, r13, new m(r10.M)));
        return;
    L104:
        return;
    L99:
        r14.add(new b(r12, r13, new StyleSpan(r10.d())));
        goto L101
    L83:
        if (A() == true) goto L101;
        int r31 = r10.f23517h;
        int r32 = r10.g;
        String r33 = r10.f23529u;
        if (r10.E == true) goto L88;
        String r34 = r10.C;
    L87:
        String r35 = r34;
        r14.add(new b(r12, r13, new zm.g(r33, r31, r32, r35, r10.A, r10.D)));
        goto L101
    L88:
        String r36 = r10.C;
        if (r36 != null) goto L92;
        r36 = "";
    L92:
        StringBuilder r37 = com.lynx.tasm.utils.j.d(r36, "'opsz' ");
        r37.append(r10.f23523n);
        r34 = r37.toString();
        goto L87
    L69:
        if (r10.f23514a != 1) goto L71;
    L72:
        r19 = true;
        goto L73
    L71:
        if (r10.f23518i != 1) goto L73;
    L53:
        if (this.A == false) goto L66;
        if (r10.f23518i != 1) goto L66;
        if (r10.f23526q == true) goto L66;
        if (r10.f23527r == true) goto L66;
    L61:
        if (r10.F == 0) goto L75;
        if (r10.f23527r == true) goto L75;
        if (r10.f23526q == true) goto L75;
    L39:
        r14.add(new b(r12, r13, new zm.r(r10.I, r10.J, r21, r22)));
        goto L41
    L36:
        r22 = false;
        goto L37
    L32:
        r21 = false;
        goto L34
    L21:
        if (r10.J != 0) goto L29;
        if ((r10.H & 2) == 0) goto L27;
        r14.add(new b(r12, r13, new LynxStrikethroughSpan()));
    L27:
        if ((r10.H & 1) == 0) goto L41;
        r14.add(new b(r12, r13, new LynxUnderlineSpan()));
        goto L41
    L11:
        r15 = r11.intValue();
    L7:
        if (r10.L <= 0.0f) goto L18;
        goto L8
    }

    public final void u(Layout r11, SpannableStringBuilder r12, PointF r13) {
        int r5 = 0;
    L4:
        if (r5 >= j()) goto L43;
        ShadowNode r10 = e(r5);
        if ((r10 instanceof NativeLayoutNodeRef) == false) goto L38;
        NativeLayoutNodeRef r14 = (NativeLayoutNodeRef) r10;
        ym.b r15 = new ym.b();
        r15.f23293a = 0.0f;
        r15.f23294b = 0.0f;
        if (r14.f10342v < r11.getText().length()) goto L10;
        r14.s(r15);
    L42:
        r5 = r5 + 1;
        goto L4
    L10:
        zm.n[] r16 = (zm.n[]) r12.getSpans(r14.f10342v, r14.f10343w, zm.n.class);
        if (r16.length != 1) goto L13;
        zm.n r17 = r16[0];
    L14:
        int r18 = r11.getLineForOffset(r14.f10342v);
        float r19 = r11.getPrimaryHorizontal(r14.f10342v) + r13.x;
        if (r11.isRtlCharAt(r14.f10342v) == false) goto L20;
        if (r17 != null) goto L18;
        int r20 = 0;
    L19:
        r19 = r19 - r20;
        goto L20
    L18:
        r20 = r17.g;
    L20:
        r15.f23293a = r19;
        if (r17 == null) goto L36;
        int r21 = r11.getLineTop(r18);
        int r22 = r11.getLineBottom(r18);
        int r23 = r11.getLineAscent(r18);
        int r24 = r11.getLineDescent(r18);
        if (r17.e == true) goto L26;
        r22 = r22 - r24;
        int r25 = r17.f;
    L25:
        r21 = r22 - r25;
    L35:
        r15.f23294b = r21 + r13.y;
        goto L36
    L26:
        int r26 = r17.f23456a;
        if (r26 == 4) goto L35;
        if (r26 != 7) goto L31;
        r25 = r17.f;
        goto L25
    L31:
        if (r26 == 11) goto L33;
        r21 = (r21 - r23) + r17.f23458c;
        goto L35
    L33:
        r21 = ((r22 + r21) - r17.f) / 2;
    L36:
        r14.s(r15);
        goto L42
    L13:
        r17 = null;
        goto L14
    L38:
        if ((r10 instanceof InlineTextShadowNode) == false) goto L40;
    L41:
        ((BaseTextShadowNode) r10).u(r11, r12, r13);
        goto L42
    L40:
        if ((r10 instanceof InlineTruncationShadowNode) == false) goto L42;
    }

    public void v(SpannableStringBuilder r5, String r10, boolean r11) {
        r5.append(s(r10, r11));
    }

    public void w(SpannableStringBuilder r27, ArrayList r28) {
        int r5 = r27.length();
        if (j() != 0) goto L7;
        String r10 = this.G;
        if (r10 == null) goto L7;
        v(r27, r10, false);
    L7:
        int r11 = j();
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L58;
        ShadowNode r13 = e(r12);
        if ((r13 instanceof RawTextShadowNode) == false) goto L15;
        RawTextShadowNode r14 = (RawTextShadowNode) r13;
        String r15 = r14.f10362v;
        if (r15 == null) goto L14;
        v(r27, r15, r14.f10363w);
    L14:
        r11 = r11;
        r12 = r12;
    L55:
        r12 = r12 + 1;
        r11 = r11;
        goto L8
    L15:
        boolean r16 = r13 instanceof AbsInlineImageShadowNode;
        q r17 = this.f10357v;
        if (r16 == false) goto L35;
        r27.append("I");
        AbsInlineImageShadowNode r18 = (AbsInlineImageShadowNode) r13;
        int r19 = r27.length() - 1;
        int r110 = r27.length();
        com.lynx.tasm.behavior.ui.text.a r111 = r18.E();
        r18.C(r111);
        com.lynx.tasm.behavior.ui.utils.g r112 = r18.N;
        if (r112 == null) goto L28;
        BackgroundDrawable r113 = (BackgroundDrawable) r112.f10750b;
        if (r113 == null) goto L28;
        ShadowNode r114 = (ShadowNode) r18.f10337h.f23310b;
        int r115 = (int) Math.ceil(r114.f10334a.g(r114.f10335b));
        ShadowNode r116 = (ShadowNode) r18.f10337h.f23310b;
        r113.setBounds(0, 0, r115, (int) Math.ceil((int) r116.f10334a.a(r116.f10335b)));
        com.lynx.tasm.behavior.ui.utils.g r20 = r18.N;
        int r21 = r18.M;
        r20.e = r21;
        if (r21 == 0) goto L24;
    L26:
        ((BackgroundDrawable) r20.d()).setColor(r21);
    L27:
        r111.f10702n = r18.N;
    L29:
        r111.f10701m = r18.f10357v.f23525p;
        r28.add(new b(r19, r110, r111));
        if (r18.o() == false) goto L34;
        r28.add(new b(r19, r110, new zm.h(r18.f10335b, r18.f10352p, r18.f10353q, r18.f10356u, r18.f10354r, r18.s, r18.f10355t)));
    L34:
        r17.f23526q = true;
        goto L55
    L24:
        if (r20.f10750b != null) goto L26;
    L28:
        r111.f10700l = r18.M;
        goto L29
    L35:
        r11 = r11;
        r12 = r12;
        if ((r13 instanceof NativeLayoutNodeRef) == false) goto L42;
        r27.append("B");
        NativeLayoutNodeRef r22 = (NativeLayoutNodeRef) r13;
        int r23 = r27.length() - 1;
        int r24 = r27.length();
        r22.f10344x = r23;
        r22.f10342v = r23;
        r22.f10345y = r24;
        r22.f10343w = r24;
        zm.n r25 = new zm.n();
        r25.f23456a = 0;
        r25.f23457b = 0.0f;
        n r26 = r22.f10350n;
        if (r26 == null) goto L40;
        int r117 = r26.f23307a;
        float r29 = r26.f23308b;
        r25.f23456a = r117;
        r25.f23457b = r29;
    L40:
        r28.add(new b(r23, r24, r25));
        r28.add(new b(r23, r24, new l(r22.f10335b, r22.f10352p, r22.f10353q, r22.f10356u, r22.f10354r, r22.s, r22.f10355t)));
        r17.f23527r = true;
        goto L55
    L42:
        if ((r13 instanceof BaseTextShadowNode) == false) goto L57;
        if ((r13 instanceof InlineTruncationShadowNode) == true) goto L55;
        BaseTextShadowNode r30 = (BaseTextShadowNode) r13;
        q r31 = r30.f10357v;
        if (r31.f23516c == null) goto L49;
    L54:
        r30.w(r27, r28);
        boolean r32 = r17.f23526q;
        q r33 = r30.f10357v;
        r17.f23526q = r32 | r33.f23526q;
        r17.f23527r |= r33.f23527r;
        this.F |= r30.F;
        goto L55
    L49:
        if (r31.L <= 0.0f) goto L54;
        Integer r34 = r17.f23516c;
        if (r34 == null) goto L53;
        r31.f23516c = r34;
        goto L54
    L53:
        r31.f23516c = Integer.valueOf(ViewCompat.MEASURED_STATE_MASK);
        goto L54
    L57:
        throw new RuntimeException("Unexpected view type nested under text node: " + r13.getClass());
    L58:
        int r35 = r27.length();
        if (r35 <= r5) goto L69;
        t(r5, r35, r28);
        return;
    }

    public final void x(SpannableStringBuilder r13, i r14, ym.g r15) {
        int r5 = 0;
    L4:
        if (r5 >= j()) goto L16;
        ShadowNode r10 = e(r5);
        if ((r10 instanceof NativeLayoutNodeRef) == false) goto L11;
        NativeLayoutNodeRef r11 = (NativeLayoutNodeRef) r10;
        ym.j r12 = r11.a(r15, r14);
        zm.n[] r16 = (zm.n[]) r13.getSpans(r11.f10342v, r11.f10343w, zm.n.class);
        int r17 = r16.length;
        int r18 = 0;
    L8:
        if (r18 >= r17) goto L15;
        zm.n r19 = r16[r18];
        float[] r20 = (float[]) r12.f23302a;
        int r21 = (int) Math.ceil(r20[0]);
        int r22 = (int) Math.ceil(r20[1]);
        int r23 = (int) Math.ceil(r20[2]);
        r19.g = r21;
        r19.f = r22;
        r19.f23505h = r23;
        r18 = r18 + 1;
    L15:
        r5 = r5 + 1;
        goto L4
    L11:
        if ((r10 instanceof BaseTextShadowNode) == false) goto L15;
        if ((r10 instanceof InlineTruncationShadowNode) == true) goto L15;
        ((BaseTextShadowNode) r10).x(r13, r14, r15);
        goto L15
    }

    public final void y(CharSequence r10, HashSet r11, int r12) {
        int r5 = 0;
    L4:
        if (r5 >= j()) goto L20;
        ShadowNode r13 = e(r5);
        if ((r13 instanceof NativeLayoutNodeRef) == false) goto L15;
        NativeLayoutNodeRef r14 = (NativeLayoutNodeRef) r13;
        if (r14.f10342v >= r10.length()) goto L13;
        int r15 = r14.f10342v;
        if (r15 >= r12) goto L13;
        if (r10.charAt(r15) != "B".charAt(0)) goto L13;
    L19:
        r5 = r5 + 1;
    L13:
        r11.add(Integer.valueOf(r14.f10335b));
        goto L19
    L15:
        if ((r13 instanceof BaseTextShadowNode) == false) goto L19;
        if ((r13 instanceof InlineTruncationShadowNode) == true) goto L19;
        ((BaseTextShadowNode) r13).y(r10, r11, r12);
        goto L19
    }

    public final void z(boolean r5) {
        this.f10358w = r5;
        setFontSize(this.f10357v.f23523n);
        int r10 = 0;
    L4:
        if (r10 >= j()) goto L9;
        ShadowNode r11 = e(r10);
        if ((r11 instanceof BaseTextShadowNode) == false) goto L8;
        ((BaseTextShadowNode) r11).z(this.f10358w);
    L8:
        r10 = r10 + 1;
        goto L4
    }

    @c0(name = "font-optical-sizing")
    public void setFontFeatureSettings(int r5) {
        boolean r10 = true;
        if (r5 == 1) goto L6;
        r10 = false;
    L6:
        this.f10357v.E = r10;
        n();
    }
}
