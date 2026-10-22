package io.reactivex.exceptions;

import android.content.Context;
import android.graphics.LinearGradient;
import android.net.Uri;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.crash.n;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.squareup.javapoet.e;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import com.squareup.kotlinpoet.a0;
import com.squareup.kotlinpoet.b0;
import com.squareup.kotlinpoet.e0;
import com.squareup.kotlinpoet.f0;
import com.squareup.kotlinpoet.g0;
import com.squareup.kotlinpoet.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import ls.c;
import org.json.JSONObject;
import td.b;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f17607c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17609b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f17608a = r10;
        this.f17609b = r5;
    }

    public static StaticLayout a(CharSequence r5, EditText r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "charSequence");
        Intrinsics.checkNotNullParameter(r10, "editText");
        int r12 = r10.getGravity();
        if (r12 == 3) goto L10;
        if (r12 != 5) goto L6;
        Layout.Alignment r13 = Layout.Alignment.ALIGN_OPPOSITE;
    L11:
        int r14 = r10.getTextDirection();
        if (r14 != 3) goto L14;
        TextDirectionHeuristic r15 = TextDirectionHeuristics.LTR;
    L20:
        StaticLayout.Builder r16 = StaticLayout.Builder.obtain(r5, 0, r5.length(), r10.getPaint(), r11).setAlignment(r13).setTextDirection(r15).setLineSpacing(r10.getLineSpacingExtra(), r10.getLineSpacingMultiplier()).setIncludePad(r10.getIncludeFontPadding());
        r16.setUseLineSpacingFromFallbacks(true);
        return r16.build();
    L14:
        if (r14 == 4) goto L18;
        if (r14 == 5) goto L17;
        r15 = TextDirectionHeuristics.LTR;
        goto L20
    L17:
        r15 = TextDirectionHeuristics.LOCALE;
        goto L20
    L18:
        r15 = TextDirectionHeuristics.RTL;
        goto L20
    L6:
        if (r12 == 17) goto L8;
        r13 = Layout.Alignment.ALIGN_NORMAL;
        goto L11
    L8:
        r13 = Layout.Alignment.ALIGN_CENTER;
        goto L11
    L10:
        r13 = Layout.Alignment.ALIGN_NORMAL;
        goto L11
    }

    public static final String b(Uri r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "bid");
        if (Intrinsics.areEqual(r5.getScheme(), "http") == true) goto L15;
        if (Intrinsics.areEqual(r5.getScheme(), IIvyAIPackageResourceService.SCHEMA) == true) goto L15;
        String r11 = h(r5, "a_surl");
        if (r11 != null) goto L13;
        r11 = h(r5, "surl");
        if (r11 != null) goto L13;
        return h(r5, "url");
    L13:
        return r11;
    L15:
        return r5.toString();
    }

    public static void c(String r5) {
        if (n.f4062j.isDebugMode() == false) goto L6;
        Log.d("npth", String.valueOf(r5));
        return;
    }

    public static void d(String r5, Serializable r10) {
        if (n.f4062j.isDebugMode() == false) goto L6;
        Log.i("npth", r5 + " " + r10);
        return;
    }

    public static void e(String r5, String r10) {
        if (n.f4062j.isDebugMode() == false) goto L6;
        Log.e("npth", r5 + " " + r10);
        return;
    }

    public static void f(Throwable r5) {
        if (n.f4062j.isDebugMode() == false) goto L6;
        Log.e("npth", "NPTH Catch Error", r5);
        return;
    }

    public static void g(JSONObject r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 == null) goto L11;
        Iterator<String> r11 = r10.keys();
    L6:
        if (r11.hasNext() == false) goto L17;
        String r12 = r11.next();
        if (r5.has(r12) == true) goto L6;
        r5.put(r12, r10.get(r12));
        goto L6
    L17:
        return;
    }

    public static final String h(Uri r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        return r5.getQueryParameter(r10);
    L5:
        return null;
    }

    public static void i(String r5) {
        if (n.f4062j.isDebugMode() == false) goto L6;
        Log.i("npth", String.valueOf(r5));
        return;
    }

    public static void j(Throwable r5) {
        if (n.f4062j.isDebugMode() == false) goto L6;
        Log.w("npth", "NPTH Catch Error", r5);
        return;
    }

    public static c k(CharSequence r14, TextPaint r15, float r16, TextUtils.TruncateAt r17, Function1 r18, Function1 r19) {
        Intrinsics.checkNotNullParameter(r14, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r15, "paint");
        Intrinsics.checkNotNullParameter(r18, "startXForWidth");
        Intrinsics.checkNotNullParameter(r19, "gradientFactory");
        if (r17 != null) goto L5;
    L7:
        CharSequence r10 = r14;
    L8:
        char[] r11 = r10.toString().toCharArray();
        float[] r12 = new float[r11.length];
        if (r11.length == 0) goto L12;
        r15.getTextWidths(r11, 0, r11.length, r12);
    L12:
        float r13 = ArraysKt.sum(r12);
        c r5 = new c(r14, r10, r11, r12, r16, r17, r15.getTextSize(), r13, ((Number) r18.invoke(Float.valueOf(r13))).floatValue());
        r5.f19791j = (LinearGradient) r19.invoke(r5);
        return r5;
    L5:
        if (r16 <= 0.0f) goto L7;
        r10 = TextUtils.ellipsize(r14, r15, r16, r17);
        goto L8
    }

    public static void l(String r5) {
        if (n.f4062j.isDebugMode() == false) goto L6;
        Log.w("npth", r5);
        return;
    }

    public static void m(String r5, String r10) {
        if (b.f22124a == false) goto L6;
        Log.d(r5, r10);
        return;
    }

    public static void n(String r5, String r10, Throwable r11) {
        if (b.f22124a == false) goto L6;
        Log.e(r5, r10, r11);
        return;
    }

    public static boolean o(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return f0.g(r10, "get()", "set()", null, null, 60);
    }

    public static void p(Context r5, String r10) {
        if (f17607c != null) goto L5;
        f17607c = r5;
    L5:
        com.bytedance.librarian.b r11 = com.bytedance.librarian.b.f6775m;
        if (r11 == null) goto L8;
        r11.f(r10);
        return;
    L8:
        System.loadLibrary(r10);
    }

    public static final com.squareup.kotlinpoet.c q(e r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5, x.e.b()) == false) goto L6;
        return b0.d;
    L6:
        if (Intrinsics.areEqual(r5, x.f.b()) == false) goto L9;
        return b0.e;
    L9:
        if (Intrinsics.areEqual(r5, x.f15025j.b()) == false) goto L12;
        return b0.f15084i;
    L12:
        if (Intrinsics.areEqual(r5, x.g.b()) == false) goto L15;
        return b0.f;
    L15:
        if (Intrinsics.areEqual(r5, x.f15023h.b()) == false) goto L18;
        return b0.g;
    L18:
        if (Intrinsics.areEqual(r5, x.f15024i.b()) == false) goto L21;
        return b0.f15083h;
    L21:
        if (Intrinsics.areEqual(r5, x.f15026k.b()) == false) goto L24;
        return b0.f15085j;
    L24:
        if (Intrinsics.areEqual(r5, x.f15027l.b()) == false) goto L27;
        return b0.f15086k;
    L27:
        if (Intrinsics.areEqual(r5, x.f15028m) == false) goto L30;
        return b0.f15080a;
    L30:
        if (Intrinsics.areEqual(r5, ws.a.f22899a) == false) goto L33;
        return b0.f15088m;
    L33:
        if (Intrinsics.areEqual(r5, ws.a.f22900b) == false) goto L36;
        return b0.f15087l;
    L36:
        if (Intrinsics.areEqual(r5, ws.a.f22901c) == false) goto L39;
        return b0.f15089n;
    L39:
        if (Intrinsics.areEqual(r5, ws.a.d) == false) goto L42;
        return b0.f15090o;
    L42:
        if (Intrinsics.areEqual(r5, ws.a.e) == false) goto L45;
        return b0.f15091p;
    L45:
        if (Intrinsics.areEqual(r5, ws.a.f) == true) goto L66;
        int r10 = r5.r().size();
        String r11 = r5.f14959w;
        if (r10 != 1) goto L51;
        com.squareup.kotlinpoet.c r12 = new com.squareup.kotlinpoet.c(r11, new String[]{r5.f14961y});
    L67:
        return r12;
    L51:
        SpreadBuilder r13 = new SpreadBuilder(2);
        r13.add(CollectionsKt.first(r5.r()));
        Object[] r14 = CollectionsKt.i(r5.r(), 1).toArray(new String[0]);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r13.addSpread(r14);
        r12 = new com.squareup.kotlinpoet.c(r11, (String[]) r13.toArray(new String[r13.size()]));
        goto L67
    L66:
        return b0.f15098x;
    }

    public static final a0 r(x r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof e) == true) goto L92;
        u r5 = null;
        if ((r10 instanceof v) == false) goto L14;
        v r11 = (v) r10;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        com.squareup.kotlinpoet.c r12 = q(r11.f15021x);
        List r13 = r11.f15022y;
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator r15 = r13.iterator();
    L9:
        if (r15.hasNext() == false) goto L11;
        r14.add(r((x) r15.next()));
        goto L9
    L11:
        Object[] r16 = r14.toArray(new a0[0]);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a0[] r17 = (a0[]) r16;
        a0[] r18 = (a0[]) Arrays.copyOf(r17, r17.length);
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r18, "typeArguments");
        a0 r19 = new u(r5, r12, ArraysKt.toList(r18));
    L93:
        return r19;
    L14:
        if ((r10 instanceof com.squareup.javapoet.a0) == false) goto L27;
        com.squareup.javapoet.a0 r20 = (com.squareup.javapoet.a0) r10;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        boolean r21 = r20.f14952x.isEmpty();
        String r22 = r20.f14951w;
        if (r21 == false) goto L18;
        List r23 = e0.f15133i;
        Intrinsics.checkNotNullParameter(r22, "name");
        return com.lynx.tasm.base.a.m(r22, e0.f15133i, null);
    L18:
        List r24 = e0.f15133i;
        List r25 = r20.f14952x;
        ArrayList r26 = new ArrayList(CollectionsKt.h(r25));
        Iterator r27 = r25.iterator();
    L20:
        if (r27.hasNext() == false) goto L22;
        r26.add(r((x) r27.next()));
        goto L20
    L22:
        Object[] r28 = r26.toArray(new a0[0]);
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a0[] r29 = (a0[]) r28;
        a0[] r30 = (a0[]) Arrays.copyOf(r29, r29.length);
        Intrinsics.checkNotNullParameter(r22, "name");
        Intrinsics.checkNotNullParameter(r30, "bounds");
        List r31 = ArraysKt.toList(r30);
        if (r31.isEmpty() == false) goto L95;
        r31 = e0.f15133i;
    L95:
        return com.lynx.tasm.base.a.m(r22, r31, null);
    L27:
        if ((r10 instanceof com.squareup.javapoet.b0) == false) goto L36;
        com.squareup.javapoet.b0 r32 = (com.squareup.javapoet.b0) r10;
        Intrinsics.checkNotNullParameter(r32, "<this>");
        if (r32.f14956x.size() != 1) goto L31;
        a0 r33 = r((x) CollectionsKt.first(r32.f14956x));
        Intrinsics.checkNotNullParameter(r33, "inType");
        r19 = new g0(CollectionsKt.listOf(b0.f15080a), CollectionsKt.listOf(r33));
        goto L93
    L31:
        x r34 = (x) r32.f14955w.get(0);
        if (Intrinsics.areEqual(r34, x.f15028m) == true) goto L96;
        a0 r35 = r(r34);
        Intrinsics.checkNotNullParameter(r35, "outType");
        r19 = new g0(CollectionsKt.listOf(r35), CollectionsKt.emptyList());
        goto L93
    L96:
        return b0.f15099y;
    L36:
        if ((r10 instanceof com.squareup.javapoet.c) == false) goto L59;
        com.squareup.javapoet.c r36 = (com.squareup.javapoet.c) r10;
        x r37 = r36.f14958w;
        if (Intrinsics.areEqual(r37, x.f) == false) goto L41;
        return b0.f15092q;
    L41:
        if (Intrinsics.areEqual(r37, x.f15025j) == false) goto L44;
        return b0.f15093r;
    L44:
        if (Intrinsics.areEqual(r37, x.g) == false) goto L47;
        return b0.s;
    L47:
        if (Intrinsics.areEqual(r37, x.f15023h) == false) goto L50;
        return b0.f15094t;
    L50:
        if (Intrinsics.areEqual(r37, x.f15024i) == false) goto L53;
        return b0.f15095u;
    L53:
        if (Intrinsics.areEqual(r37, x.f15026k) == false) goto L56;
        return b0.f15096v;
    L56:
        if (Intrinsics.areEqual(r37, x.f15027l) == true) goto L103;
        com.squareup.kotlinpoet.c r38 = b0.f15081b;
        a0[] r39 = {r(r36.f14958w)};
        Intrinsics.checkNotNullParameter(r38, "<this>");
        Intrinsics.checkNotNullParameter(r39, "typeArguments");
        r19 = new u(r5, r38, ArraysKt.toList(r39));
        goto L93
    L103:
        return b0.f15097w;
    L59:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.j() == false) goto L62;
        x r40 = r10.m();
    L64:
        if (Intrinsics.areEqual(r40, x.e) == false) goto L67;
        return b0.d;
    L67:
        if (Intrinsics.areEqual(r40, x.f) == false) goto L70;
        return b0.e;
    L70:
        if (Intrinsics.areEqual(r40, x.f15025j) == false) goto L73;
        return b0.f15084i;
    L73:
        if (Intrinsics.areEqual(r40, x.g) == false) goto L76;
        return b0.f;
    L76:
        if (Intrinsics.areEqual(r40, x.f15023h) == false) goto L79;
        return b0.g;
    L79:
        if (Intrinsics.areEqual(r40, x.f15024i) == false) goto L82;
        return b0.f15083h;
    L82:
        if (Intrinsics.areEqual(r40, x.f15026k) == false) goto L85;
        return b0.f15085j;
    L85:
        if (Intrinsics.areEqual(r40, x.f15027l) == false) goto L89;
        return b0.f15086k;
    L89:
        throw new IllegalStateException(("Unrecognized type " + r10).toString());
    L62:
        r40 = r10;
        goto L64
    L92:
        return q((e) r10);
    }
}
