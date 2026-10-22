package zl8;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.util.Size;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import bm8.i;
import cm8.f;
import cm8.h;
import cm8.j;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.bmhome.chat.layout.widget.AppletWidget;
import com.larus.bmhome.chat.layout.widget.b1;
import com.larus.bmhome.chat.layout.widget.u;
import com.larus.bmhome.chat.standarduikit.markdown.view.MarkdownAppletContainer;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.mainbot.ECommerceSettingsConfig;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.p0;
import com.larus.utils.t0;
import com.larus.utils.y0;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import fh8.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final Context a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public i f;

    public static final class a {
    }

    static {
    }

    public final MarkdownAppletContainer b() {
        return (MarkdownAppletContainer) this.b.getValue();
    }

    public final void c() {
        MarkdownAppletContainer r0 = b();
        j r1 = (j) this.c.getValue();
        r1.getClass();
        f r2 = r1.b;
        if (r2 == null) goto L7;
        Message r3 = r2.c;
        if (r3 == null) goto L7;
        String r4 = r3.getMessageId();
    L8:
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        String r5 = r4;
        f r6 = r1.b;
        if (r6 == null) goto L15;
        Message r7 = r6.c;
        if (r7 == null) goto L15;
        String r8 = r7.getSenderId();
    L16:
        f r9 = r1.b;
        if (r9 == null) goto L21;
        Message r10 = r9.c;
        if (r10 == null) goto L21;
        String r11 = r10.getConversationId();
    L22:
        f r12 = r1.b;
        if (r12 == null) goto L27;
        Message r13 = r12.c;
        if (r13 == null) goto L27;
        String r14 = r13.getSenderId();
    L28:
        f r15 = r1.b;
        if (r15 == null) goto L33;
        Message r16 = r15.c;
        if (r16 == null) goto L33;
        String r17 = r16.getReplyId();
    L34:
        cm8.a r18 = r1.c;
        if (r18 == null) goto L37;
        Fragment r19 = r18.getFragment();
    L38:
        cm8.a r20 = r1.c;
        if (r20 == null) goto L41;
        int r110 = r20.c1();
    L42:
        cm8.a r21 = r1.c;
        if (r21 != null) goto L45;
    L47:
        boolean r22 = false;
    L48:
        b1 r111 = new b1(r5, r8, r11, r14, r17, r19, r110, r22);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r111, "data");
        AppletWidget r23 = r0.a;
        if (r23 == null) goto L51;
        r23.e(r111.f, r111.a, r111.b, r111.c, r111.d, r111.e, r111.g, r111.h);
    L51:
        AppletWidget r24 = r0.a;
        if (r24 == null) goto L55;
        r24.r.clear();
        return;
    L55:
        return;
    L45:
        if (r21.a1() != true) goto L47;
        r22 = true;
        goto L48
    L41:
        r110 = -1;
        goto L42
    L37:
        r19 = null;
    L33:
        r17 = null;
    L27:
        r14 = null;
    L21:
        r11 = null;
    L15:
        r8 = null;
    L7:
        r4 = null;
        goto L8
    }

    public e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new zl8.a(this));
        this.c = LazyKt.lazy(new b(this));
        this.d = LazyKt.lazy(new c());
        this.e = LazyKt.lazy(new d());
    }

    public final boolean d(f r7) {
        if (r7.e == true) goto L6;
        return true;
    L6:
        if (((List) this.d.getValue()).isEmpty() == false) goto L8;
        return true;
    L8:
        String r8 = r7.d;
        if (r8 != null) goto L56;
        return false;
    L56:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        Object r3 = Result.constructor-impl(UriProtector.parse(r8));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r3) == false) goto L18;
        r3 = null;
    L18:
        Uri r4 = (Uri) r3;
        if (r4 != null) goto L22;
        String r9 = null;
    L41:
        if (r9 != null) goto L43;
        return false;
    L43:
        List r5 = (List) this.d.getValue();
        if ((r5 instanceof Collection) == true) goto L46;
    L48:
        Iterator r6 = r5.iterator();
    L50:
        if (r6.hasNext() == false) goto L54;
        if (StringsKt.endsWith$default(r9, (String) r6.next(), false, 2, null) == false) goto L50;
        return true;
    L54:
        return false;
    L46:
        if (r5.isEmpty() == false) goto L48;
    L22:
        if (Intrinsics.areEqual(r4.getScheme(), "http") == false) goto L24;
    L58:
        Object r10 = Result.constructor-impl(UriProtector.parse(r8).getHost());     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r10) == false) goto L40;
        r10 = null;
    L40:
        r9 = (String) r10;
    L35:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L24:
        if (Intrinsics.areEqual(r4.getScheme(), "https") == true) goto L58;
        String r12 = y0.f(r4, "surl");
        if (r12 != null) goto L32;
        String r13 = y0.f(r4, ShareType.URL);
        if (r13 == null) goto L58;
        r8 = r13;
        goto L58
    L32:
        r8 = r12;
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public final Size e(f r6) {
        Intrinsics.checkNotNullParameter(r6, "vmData");
        if (d(r6) == false) goto L5;
        MarkdownAppletContainer r7 = b();
        i r0 = this.f;
        if (r0 == null) goto L23;
        r7.getClass();
        int r1 = r0.a.a;
        AppletWidget r2 = r7.a;
        if (r2 == null) goto L22;
        int r3 = r2.getMeasuredHeight();
        if (r3 == 0) goto L22;
        bm8.b r4 = r0.a;
        if (r4.f == false) goto L16;
    L19:
        int r5 = 1;
    L20:
        r7.b = new Size(r1, r3 + (r0.a.d * r5));
        goto L22
    L16:
        if (r4.g == true) goto L19;
        r5 = 2;
    L22:
        return new Size(r7.b.getWidth(), r7.b.getHeight());
    L23:
        return r7.b;
    L5:
        return new Size(0, 0);
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [android.widget.FrameLayout, com.larus.bmhome.chat.standarduikit.markdown.view.MarkdownAppletContainer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v70, types: [android.widget.FrameLayout, com.larus.bmhome.chat.standarduikit.markdown.view.MarkdownAppletContainer] */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.widget.FrameLayout, com.larus.bmhome.chat.standarduikit.markdown.view.MarkdownAppletContainer, java.lang.Object] */
    public final void a(final f r34, cm8.e r35) {
        Intrinsics.checkNotNullParameter(r34, "vmData");
        if (d(r34) == true) goto L6;
        FLogger.a.w("MarkdownAppletContainerAssembler", "bindData shouldMount false, templateUrl: " + r34.d);
        this.f = null;
        ?? r0 = b();
        r0.removeAllViews();
        r0.a = null;
        r0.b = new Size(0, 0);
        r0.c = false;
        r0.d = null;
        r0.setVisibility(8);
        return;
    L6:
        final j r3 = (j) this.c.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r34, "vmData");
        r3.b = r34;
        r3.c = r35;
        t0.a(new h(r34, r3));
        j r4 = (j) this.c.getValue();
        r4.getClass();
        double r10 = Double.NaN;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        f r2 = r4.b;     // Catch: Throwable -> L21
        if (r2 == null) goto L16;
        String r5 = r2.b;     // Catch: Throwable -> L21
        if (r5 == null) goto L16;
        JSONObject r12 = new JSONObject(r5);     // Catch: Throwable -> L21
        String r13 = r12.optString("mixture_card_id");     // Catch: Throwable -> L21
        String r14 = r12.optString("fpa_common_param");     // Catch: Throwable -> L14
        r10 = r12.optDouble("aspect_ratio");     // Catch: Throwable -> L19
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Result.constructor-impl(r6);     // Catch: Throwable -> L19
    L25:
        String r7 = r13;
        f r15 = r4.b;
        if (r15 == null) goto L28;
        int r16 = r15.j;
    L29:
        if (r15 == null) goto L31;
        int r17 = r15.k;
    L32:
        if (r15 == null) goto L34;
        int r18 = r15.a;
    L35:
        int r19 = y.a(r18);
        if (Double.isNaN(r10) == true) goto L38;
        int r8 = (int) (r10 * ((double) r19));
    L39:
        f r9 = r4.b;
        if (r9 != null) goto L42;
    L44:
        boolean r11 = false;
    L45:
        if (r11 == false) goto L47;
        int r20 = 0;
    L48:
        int r110 = WidgetRenderDelegate.a.i(r7, r8) + (r20 * 2);
        f r21 = r4.b;
        if (r21 != null) goto L51;
    L53:
        boolean r111 = false;
    L54:
        if (r111 == false) goto L68;
        if (r21 != null) goto L57;
    L59:
        boolean r112 = false;
    L60:
        if (r112 == false) goto L68;
        if (r21 == null) goto L64;
        String r22 = r21.d;
        if (r22 == null) goto L64;
    L66:
        if (Intrinsics.areEqual(y0.f(UriProtector.parse(r22), "disable_full_card_border"), "1") == true) goto L68;
        boolean r23 = true;
    L69:
        f r113 = r4.b;
        if (r113 != null) goto L72;
    L74:
        boolean r114 = false;
    L75:
        cm8.a r24 = r4.c;
        if (r24 == null) goto L80;
        com.larus.bmhome.chat.exposure.a r25 = r24.b1();
        if (r25 == null) goto L80;
        Rect r26 = r25.a();
    L81:
        if (r26 == null) goto L83;
        int r115 = r26.top;
    L84:
        int r116 = m0.a;
        int r27 = m0.a(r4.a);
        if (r26 == null) goto L87;
        int r28 = r26.bottom;
    L88:
        int r29 = r27 - r28;
        f r30 = r4.b;
        if (r30 == null) goto L93;
        String r210 = r7;
        boolean r31 = true;
        if (r30.f != true) goto L94;
        boolean r211 = true;
    L95:
        if (r30 != null) goto L97;
    L99:
        boolean r212 = false;
    L100:
        if (r30 != null) goto L102;
    L104:
        boolean r213 = false;
    L105:
        bm8.b r32 = new bm8.b(r19, r8, r110, r20, r211, r212, r213, r114);
        Boolean r33 = Boolean.valueOf(r23);
        f r36 = r4.b;
        if (r36 != null) goto L108;
    L110:
        boolean r37 = false;
    L111:
        if (r37 == false) goto L113;
        Float r38 = Float.valueOf(i5.r0());
    L114:
        f r39 = r4.b;
        if (r39 != null) goto L117;
    L119:
        boolean r40 = false;
    L120:
        if (r40 == false) goto L122;
        Integer r41 = Integer.valueOf(ContextCompat.getColor(r4.a, 2131103162));
    L123:
        f r42 = r4.b;
        if (r42 == null) goto L128;
        int r117 = 1;
        if (r42.e != true) goto L129;
        boolean r43 = true;
    L130:
        if (r43 == false) goto L132;
        Integer r44 = Integer.valueOf(r117);
    L133:
        bm8.a r45 = new bm8.a(r33, r38, r41, r44);
        f r46 = r4.b;
        if (r46 == null) goto L138;
        Message r47 = r46.c;
        if (r47 == null) goto L138;
        String r48 = r47.getMessageId();
    L139:
        if (r48 != null) goto L141;
        r48 = "";
    L141:
        f r49 = r4.b;
        if (r49 == null) goto L146;
        Message r50 = r49.c;
        if (r50 == null) goto L146;
        String r51 = r50.getSenderId();
    L147:
        f r52 = r4.b;
        if (r52 == null) goto L152;
        Message r53 = r52.c;
        if (r53 == null) goto L152;
        String r54 = r53.getConversationId();
    L153:
        f r55 = r4.b;
        if (r55 == null) goto L158;
        Message r56 = r55.c;
        if (r56 == null) goto L158;
        String r118 = r56.getSectionId();
    L159:
        f r57 = r4.b;
        if (r57 == null) goto L164;
        Message r58 = r57.c;
        if (r58 == null) goto L164;
        String r119 = r58.getReplyId();
    L165:
        f r59 = r4.b;
        if (r59 == null) goto L168;
        String r120 = r59.b;
    L169:
        cm8.a r60 = r4.c;
        if (r60 == null) goto L172;
        Fragment r121 = r60.getFragment();
    L173:
        cm8.a r61 = r4.c;
        if (r61 == null) goto L176;
        int r214 = r61.c1();
    L177:
        f r62 = r4.b;
        if (r62 == null) goto L190;
        Message r63 = r62.c;
        if (r63 == null) goto L190;
        Map r64 = r63.getExt();
        if (r64 == null) goto L190;
        Map r65 = MapsKt.toMutableMap(r64);
        if (r65 == null) goto L190;
        if (r14 == null) goto L189;
        String r122 = p0.a(r14);
        if (r122 == null) goto L189;
        r65.put("fpa_common_param", r122);
        Unit r66 = Unit.INSTANCE;
    L189:
        Unit r67 = Unit.INSTANCE;
        Map r215 = r65;
    L191:
        Pair[] r68 = new Pair[5];
        f r69 = r4.b;
        if (r69 == null) goto L196;
        Message r70 = r69.c;
        if (r70 == null) goto L196;
        Long r71 = Long.valueOf(r70.getCreateTime());
    L197:
        r68[0] = TuplesKt.to("createTime", r71);
        cm8.a r72 = r4.c;
        if (r72 == null) goto L200;
        Boolean r73 = r72.d1();
    L201:
        r68[1] = TuplesKt.to("hasFirstFeedShow", r73);
        cm8.a r74 = r4.c;
        if (r74 == null) goto L204;
        Long r75 = r74.e1();
    L205:
        r68[2] = TuplesKt.to("coldStartTime", r75);
        cm8.a r76 = r4.c;
        if (r76 == null) goto L208;
        Boolean r77 = r76.W();
    L209:
        r68[3] = TuplesKt.to("hasPageFirstFeedShow", r77);
        cm8.a r78 = r4.c;
        if (r78 == null) goto L212;
        Long r79 = r78.O();
    L213:
        r68[4] = TuplesKt.to("openPageTime", r79);
        Map r80 = MapsKt.mapOf(r68);
        cm8.a r81 = r4.c;
        if (r81 != null) goto L216;
    L218:
        boolean r82 = false;
    L219:
        f r123 = r4.b;
        if (r123 == null) goto L222;
        String r216 = r123.d;
    L223:
        cm8.a r124 = r4.c;
        if (r124 == null) goto L226;
        String r217 = r124.m();
    L227:
        cm8.a r83 = r4.c;
        if (r83 == null) goto L230;
        String r84 = r83.Z0();
    L231:
        Map r310 = MapsKt.mapOf(new Pair[]{TuplesKt.to("is_full_width", Boolean.valueOf(r114)), TuplesKt.to("block_margin", MapsKt.mapOf(new Pair[]{TuplesKt.to("left", Integer.valueOf((int) c7.d(Integer.valueOf(r16)))), TuplesKt.to("top", 0), TuplesKt.to("right", Integer.valueOf((int) c7.d(Integer.valueOf(r17)))), TuplesKt.to("bottom", 0)})), TuplesKt.to("chat_focus_screen_margin", MapsKt.mapOf(new Pair[]{TuplesKt.to("top", Integer.valueOf((int) c7.d(Integer.valueOf(r115)))), TuplesKt.to("bottom", Integer.valueOf((int) c7.d(Integer.valueOf(r29))))}))});
        String r125 = r48;
        int r85 = 4;
        i r86 = new i(r32, r45, new u(r125, r51, r54, r118, r119, r120, r121, r214, r215, r80, r210, r82, r216, null, null, r217, r84, r310, 24576));
        final j.b r87 = ((j) this.c.getValue()).e;
        this.f = r86;
        ?? r88 = b();
        r88.getClass();
        Intrinsics.checkNotNullParameter(r86, "input");
        Intrinsics.checkNotNullParameter(r87, "output");
        r88.setVisibility(0);
        bm8.b r89 = r86.a;
        r88.c = r89.h;
        if (r88.a == null) goto L245;
        r88.a(r86.b, r89.e);
        AppletWidget r90 = r88.a;
        if (r90 == null) goto L241;
        if (r90.getMeasuredHeight() != 0) goto L238;
        boolean r311 = true;
    L239:
        e1.y(r90, !r311);
        goto L241
    L238:
        r311 = false;
    L241:
        AppletWidget r91 = r88.a;
        if (r91 == null) goto L258;
        r91.b(r86.c);
    L258:
        if (((ECommerceSettingsConfig) this.e.getValue()).getEnableAutoExposureManager() == false) goto L284;
        List r92 = ((ECommerceSettingsConfig) this.e.getValue()).getAutoExposureWidgetIdList();
        if (r92 != null) goto L263;
        r92 = CollectionsKt.emptyList();
    L263:
        List r93 = r92;
        if (r93.isEmpty() == true) goto L284;
        String r94 = new JSONObject(r34.b).optString("widget_id");     // Catch: Throwable -> L276
        Intrinsics.checkNotNull(r94);     // Catch: Throwable -> L276
        if (r94.length() <= 0) goto L270;
        boolean r126 = true;
    L271:
        if (r126 == true) goto L274;
        r94 = null;
    L274:
        Object r95 = Result.constructor-impl(r94);     // Catch: Throwable -> L276
    L279:
        if (Result.isFailure-impl(r95) == false) goto L281;
        Object r96 = null;
    L282:
        String r97 = (String) r96;
        if (r97 == null) goto L284;
        boolean r98 = r93.contains(r97);
    L286:
        if (r98 == false) goto L311;
        ?? r99 = b();
        com.larus.bmhome.chat.exposure.a r100 = r35.b1();
        u r101 = r86.c;
        String r102 = r101.k;
        String r103 = r101.f;
        if (r100 != null) goto L290;
        r99.getClass();
        return;
    L290:
        AppletWidget r104 = r99.a;
        if (r104 == null) goto L314;
        r100.b(String.valueOf(r99.hashCode()), r104, new bm8.h(r99, r102, r103));     // Catch: Throwable -> L295
        r100.e.a();     // Catch: Throwable -> L295
        Object r105 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L295
    L297:
        Throwable r106 = Result.exceptionOrNull-impl(r105);
        if (r106 == null) goto L313;
        FLogger.a.e("MarkdownAppletContainer", "registerAutoExposureManager failed: " + r106);
        return;
    L313:
        return;
    L295:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L297
    L314:
        return;
    L311:
        return;
    L281:
        r96 = r95;
        goto L282
    L270:
        r126 = false;
    L276:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r95 = Result.constructor-impl(ResultKt.createFailure(th));
    L284:
        r98 = false;
        goto L286
    L245:
        AppletWidget r109 = new AppletWidget(r88.getContext(), r86.a.a, 0.0f, 0.0f, 0.0f, 0.0f);
        r88.a = r109;
        ConstraintLayout.LayoutParams r127 = new ConstraintLayout.LayoutParams(-2, -2);
        r127.setMarginStart(0);
        r127.setMarginEnd(0);
        r109.setLayoutParams(r127);
        r88.a(r86.b, r86.a.e);
        r109.addOnLayoutChangeListener(new bm8.c(r87));
        FrameLayout.LayoutParams r128 = new FrameLayout.LayoutParams(-1, -2);
        bm8.b r129 = r86.a;
        if (r129.f == false) goto L248;
        int r130 = i5.Y();
    L249:
        r128.topMargin = r130;
        Unit r131 = Unit.INSTANCE;
        r88.addView(r109, r128);
        if (ChatWindowServiceDelegate.b.d(r88.getContext()) == false) goto L253;
    L256:
        r109.setVisibility(r85);
        r109.b(r86.c);
        bm8.b r132 = r86.a;
        r88.b = new Size(r132.a, r132.c);
        goto L258
    L253:
        if (r86.a.c == 0) goto L256;
        r85 = 0;
        goto L256
    L248:
        r130 = r129.d;
        goto L249
    L230:
        r84 = null;
        goto L231
    L226:
        r217 = null;
        goto L227
    L222:
        r216 = null;
        goto L223
    L216:
        if (r81.a1() != true) goto L218;
        r82 = true;
        goto L219
    L212:
        r79 = null;
        goto L213
    L208:
        r77 = null;
        goto L209
    L204:
        r75 = null;
        goto L205
    L200:
        r73 = null;
    L196:
        r71 = null;
    L190:
        r215 = null;
        goto L191
    L176:
        r214 = -1;
        goto L177
    L172:
        r121 = null;
        goto L173
    L168:
        r120 = null;
    L164:
        r119 = null;
    L158:
        r118 = null;
    L152:
        r54 = null;
    L146:
        r51 = null;
    L138:
        r48 = null;
        goto L139
    L132:
        r44 = null;
    L129:
        r43 = false;
        goto L130
    L128:
        r117 = 1;
        goto L129
    L122:
        r41 = null;
        goto L123
    L117:
        if (r39.e != true) goto L119;
        r40 = true;
        goto L120
    L113:
        r38 = null;
        goto L114
    L108:
        if (r36.e != true) goto L110;
        r37 = true;
        goto L111
    L102:
        if (r30.h != r31) goto L104;
        r213 = true;
        goto L105
    L97:
        if (r30.g != r31) goto L99;
        r212 = true;
    L94:
        r211 = false;
        goto L95
    L93:
        r210 = r7;
        r31 = true;
        goto L94
    L87:
        r28 = 0;
        goto L88
    L83:
        r115 = 0;
    L80:
        r26 = null;
        goto L81
    L72:
        if (r113.i != true) goto L74;
        r114 = true;
    L64:
        r22 = "";
        goto L66
    L57:
        if (r21.f != true) goto L59;
        r112 = true;
    L68:
        r23 = false;
        goto L69
    L51:
        if (r21.e != true) goto L53;
        r111 = true;
        goto L54
    L47:
        r20 = i5.r0();
        goto L48
    L42:
        if (r9.f != true) goto L44;
        r11 = true;
        goto L45
    L38:
        r8 = r4.a.getResources().getDimensionPixelOffset(v19.c.b(2130971179, r4.a, 2131166727));
        goto L39
    L34:
        int r133 = m0.a;
        r18 = m0.b(r4.a);
        goto L35
    L31:
        r17 = 0;
        goto L32
    L28:
        r16 = 0;
    L19:
        th = th;
    L24:
        Result.Companion r134 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        th = th;
    L23:
        r14 = null;
    L16:
        r6 = null;
        r14 = null;
        r13 = "";
    L21:
        th = th;
        r13 = "";
        goto L23
    }
}
