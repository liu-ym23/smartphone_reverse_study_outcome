package vg8;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.layout.widget.ThreeLoadingIndicator;
import com.larus.bmhome.chat.layout.widget.handler.p;
import com.larus.bmhome.chat.layout.widget.handler.q;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.business.markdown.api.model.MarkdownNodeModifyType;
import com.larus.business.markdown.impl.markwon.MarkwonStruct;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import dg8.s;
import fh8.r;
import fh8.t;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.node.Text;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public final String a;
    public List<? extends uvc.b> b;
    public uvc.b c;
    public boolean d;
    public boolean e;
    public final ConcurrentHashMap<String, CharSequence> f;
    public v0 g;
    public ThreeLoadingIndicator h;
    public lw8.d i;
    public String j;
    public Message k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public View p;

    public static final class a {
    }

    static {
    }

    public final void c() {
        if (this.j == null) goto L13;
        Message r0 = this.k;
        if (r0 == null) goto L13;
        CoroutineScope r1 = p.a;
        String r2 = r0.getMessageId();
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        String r3 = this.j;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewAlphaTag");
        r3 = null;
    L12:
        p.d(r2, r3);
    L13:
        v0 r4 = this.g;
        if (r4 == null) goto L17;
        r4.a();
        return;
    }

    public m(String r1) {
        this.a = r1;
        this.f = new ConcurrentHashMap();
        this.l = LazyKt.lazy(new g());
        this.m = LazyKt.lazy(new h());
        this.n = LazyKt.lazy(new i());
        this.o = LazyKt.lazy(new j());
    }

    public final View b(ViewGroup r6) {
        View r0 = this.p;
        if (r0 != null) goto L6;
        View r1 = new View(r6.getContext());
        this.p = r1;
        r1.setBackgroundResource(v19.c.b(2130970714, r1.getContext(), 2131239237));
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-1, i5.r0());
        r7.setMargins(i5.q(), i5.n0(), i5.t(), i5.n0());
        r1.setLayoutParams(r7);
        return r1;
    L6:
        return r0;
    }

    public final void d(LinearLayout r10) {
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = false;
        this.i = null;
        if (r10 == null) goto L21;
        int r2 = r10.getChildCount();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L27;
        View r4 = r10.getChildAt(r3);
        if ((r4 instanceof FrameLayout) == false) goto L9;
        FrameLayout r5 = (FrameLayout) r4;
    L10:
        if (r5 == null) goto L20;
        int r6 = r5.getChildCount();
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L20;
        rt8.a r8 = r5.getChildAt(r7);
        if ((r8 instanceof rt8.a) == false) goto L16;
        rt8.a r9 = r8;
    L17:
        if (r9 == null) goto L19;
        com.larus.utils.l.a(r9);
        r9.a();
    L19:
        r7 = r7 + 1;
        goto L12
    L16:
        r9 = null;
    L20:
        r3 = r3 + 1;
        goto L5
    L9:
        r5 = null;
        goto L10
    L27:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v30, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r2v35, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v9, types: [vg8.f] */
    /* JADX WARN: Type inference failed for: r77v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout, java.lang.Object] */
    public final void e(LinearLayout r77, String r78, t r79, fh8.l r80, Function1<? super ow8.a, Unit> r81, Function1<? super ow8.a, Unit> r82, Function1<? super ow8.a, Unit> r83, Map<String, ? extends Object> r84, fh8.f r85, Block r86, r r87) {
        Intrinsics.checkNotNullParameter(r77, "viewGroup");
        Intrinsics.checkNotNullParameter(r78, "content");
        Intrinsics.checkNotNullParameter(r79, "renderViewConfig");
        Intrinsics.checkNotNullParameter(r80, "markdownRenderConfig");
        Intrinsics.checkNotNullParameter(r81, "onClick");
        Intrinsics.checkNotNullParameter(r82, "onLongClick");
        Intrinsics.checkNotNullParameter(r83, "onGenerate");
        Intrinsics.checkNotNullParameter(r85, "commonInputData");
        long r17 = SystemClock.elapsedRealtime();
        Message r0 = r85.b;
        if (r0 != null) goto L5;
        r0 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L5:
        Message r5 = r0;
        ChatParam r26 = new ChatParam(null, null, r85.f, r85.e, r85.a, 227);
        gw8.c r16 = (gw8.c) this.l.getValue();
        if (r16 != null) goto L8;
        return;
    L8:
        int r1 = r79.g;
        if (r1 == 0) goto L11;
        int r9 = r1;
    L12:
        Intrinsics.checkNotNullParameter(r79, "<this>");
        t.a r2 = new t.a();
        r2.a = r79.a;
        r2.b = r79.b;
        r2.c = r79.c;
        r2.d = r79.d;
        r2.e = r79.e;
        r2.f = r79.f;
        r2.i = r79.h;
        r2.g = r79.i;
        r2.h = r9;
        t r8 = r2.a();
        fh8.g r3 = fh8.h.a(r85);
        r3.w = Integer.valueOf(r9);
        fh8.f r19 = r3.a();
        int r4 = 2131240674;
        if (this.g != null) goto L20;
        if (r79.d == false) goto L17;
        int r6 = 2131240674;
    L18:
        v0 r7 = new v0(r77, r6, r77.getContext());
        this.g = r7;
        r77.setTag(2131386671, r7);
        goto L20
    L17:
        r6 = 2131240017;
    L20:
        if (this.h == null) goto L22;
    L26:
        lw8.d r10 = r80.l;
        if (r10 == null) goto L30;
        this.i = com.larus.bmhome.chat.markdown.richtext.c.a(r10, r77.getResources());
    L49:
        lw8.d r11 = this.i;
        if (r11 != null) goto L52;
        return;
    L52:
        this.j = r80.c;
        this.k = r5;
        if (r84 == null) goto L55;
        Object r12 = r84.get("cellComponentInfo");
    L57:
        if ((r12 instanceof com.larus.bmhome.chat.list.cell.text.cells.base.c) == false) goto L59;
        com.larus.bmhome.chat.list.cell.text.cells.base.c r13 = (com.larus.bmhome.chat.list.cell.text.cells.base.c) r12;
    L60:
        if (r84 == null) goto L62;
        Object r14 = r84.get("componentContext");
    L64:
        if ((r14 instanceof ec8.b) == false) goto L66;
        ec8.b r15 = (ec8.b) r14;
    L67:
        ec8.b r18 = r15;
        com.larus.bmhome.chat.list.cell.text.cells.base.c r110 = r13;
        MarkwonStruct r20 = o.a.a(r77.getContext(), r80, r11, r9, this.a, r19);
        if (r110 == null) goto L159;
        if (r18 == null) goto L159;
        if (this.d == false) goto L73;
    L75:
        boolean r21 = false;
    L76:
        Context r22 = r77.getContext();
        boolean r23 = com.larus.bmhome.chat.bean.d.f0(r5);
        CopyOnWriteArraySet<String> r24 = com.larus.bmhome.chat.markdown.imagegroup.c.a;
        if (com.larus.bmhome.chat.markdown.imagegroup.c.a(r80.e) == true) goto L81;
        if (r21 == true) goto L81;
        boolean r25 = false;
    L82:
        uvc.b r27 = this.c;
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r110, "componentInfo");
        int r28 = r110.b;
        if (r28 >= 0) goto L85;
    L134:
        int r29 = r9;
        ec8.b.d r30 = new ec8.b.d(r18.g(r22, r5, r110, r23, r20), true, true);
    L136:
        if (r80.b == true) goto L138;
    L140:
        boolean r31 = false;
    L141:
        r80.b = r31;
        if (r8.i == true) goto L144;
    L146:
        boolean r32 = false;
    L147:
        r8.i = r32;
        if (r30.b == false) goto L157;
        uvc.b r33 = r30.a;
        if (r33 == null) goto L155;
        t r710 = r8;
        ec8.b.d r75 = r30;
        int r210 = r29;
        List r34 = a(r19, r5, r26, r8, r80, r11, r81, r82, r83, r80.c, r84, null, r87, null, false, null);
        gw8.c.a.getClass();
        gw8.c r35 = gw8.c.a.b();
        if (r35 == null) goto L154;
        ec8.b.d r36 = r75;
        m r111 = this;
        r35.createMarkdownWidget(r77.getContext(), r210, r36.c, r33, r77, r111.c, r34);
        Unit r37 = Unit.INSTANCE;
    L156:
        r111.c = r36.a;
        r111.e = r36.c;
    L158:
        Unit r38 = Unit.INSTANCE;
        fh8.l r112 = r80;
        m r113 = r111;
        boolean r39 = false;
        boolean r114 = true;
    L309:
        boolean r40 = r112.b;
        r113.d = !r40;
        v0 r41 = r113.g;
        if (r41 == null) goto L318;
        r41.k = r40;
        if (r40 == true) goto L315;
        r41.a();
    L317:
        Unit r42 = Unit.INSTANCE;
        goto L318
    L315:
        if (((Boolean) r41.h.getValue()).booleanValue() == false) goto L317;
        r41.o = r114;
        r41.a();
        t0.a.postDelayed(r41.l, 2000);
    L318:
        v0 r43 = r113.g;
        if (r43 == null) goto L321;
        r43.b();
        Unit r44 = Unit.INSTANCE;
    L321:
        CopyOnWriteArraySet<String> r45 = com.larus.bmhome.chat.markdown.imagegroup.c.a;
        String r46 = r112.e;
        Intrinsics.checkNotNullParameter(r46, "forceRefreshId");
        com.larus.bmhome.chat.markdown.imagegroup.c.a.remove(r46);
        if (r710.i == true) goto L329;
        View r47 = r113.p;
        if (r47 == null) goto L326;
        r77.removeView(r47);
        r113.p = null;
        Unit r48 = Unit.INSTANCE;
    L326:
        FLogger.a.d("MarkdownRenderHelper", "renderMarkdownWidgets1 enableIncrementalTextNode[" + r39 + "] cost " + (SystemClock.elapsedRealtime() - r17));
        return;
    L329:
        if (r77.indexOfChild(b(r77)) == (-1)) goto L331;
        boolean r115 = true;
    L332:
        if (r115 == false) goto L335;
        FLogger.a.d("MarkdownRenderHelper", "renderMarkdownWidgets2 enableIncrementalTextNode[" + r39 + "] cost " + (SystemClock.elapsedRealtime() - r17));
        return;
    L335:
        r77.addView(b(r77));
        FLogger.a.d("MarkdownRenderHelper", "renderMarkdownWidgets3 enableIncrementalTextNode[" + r39 + "] cost " + (SystemClock.elapsedRealtime() - r17));
        return;
    L331:
        r115 = false;
        goto L332
    L154:
        r111 = this;
        r36 = r75;
        goto L156
    L155:
        r111 = this;
        r710 = r8;
        r36 = r30;
        r77.removeAllViews();
        Unit r49 = Unit.INSTANCE;
        goto L156
    L157:
        r111 = this;
        r710 = r8;
        goto L158
    L144:
        if (r30.c == false) goto L146;
        r32 = true;
        goto L147
    L138:
        if (r30.c == false) goto L140;
        r31 = true;
        goto L141
    L85:
        if (com.larus.bmhome.chat.bean.d.I0(r5) == true) goto L134;
        List<uvc.b> r116 = r18.c.b;
        if (r116 == null) goto L90;
        boolean r117 = !r116.isEmpty();
    L91:
        Boolean r118 = Boolean.valueOf(r117);
        r29 = r9;
        List<uvc.b> r50 = r18.c.b;
        if (r50 == null) goto L94;
        uvc.b r51 = (uvc.b) CollectionsKt.getOrNull(r50, r28);
    L95:
        Pair r52 = new Pair(r118, r51);
        if (((Boolean) r52.getFirst()).booleanValue() == false) goto L105;
        uvc.b r53 = (uvc.b) r52.getSecond();
        List<uvc.b> r54 = r18.c.b;
        if (r54 == null) goto L102;
        boolean r55 = true;
        if (r28 != (r54.size() - 1)) goto L103;
        boolean r56 = true;
    L104:
        r30 = new ec8.b.d(r53, r55, r56);
    L103:
        r56 = false;
        goto L104
    L102:
        r55 = true;
        goto L103
    L105:
        int r57 = com.larus.im.d.a;
        com.larus.im.internal.stream.b r58 = com.larus.im.internal.stream.b.a;
        String r59 = r5.getMessageId();
        if (r59 != null) goto L108;
        r59 = "";
    L108:
        List r119 = com.larus.im.bean.message.a.S(r5);
        if (r119 == null) goto L115;
        com.larus.im.bean.message.c r120 = (com.larus.im.bean.message.c) CollectionsKt.firstOrNull(r119);
        if (r120 == null) goto L115;
        Integer r121 = r120.c;
        if (r121 == null) goto L115;
        int r122 = r121.intValue();
    L116:
        Integer r60 = r58.d(r59, r122);
        if (r25 == false) goto L125;
        if (r23 == true) goto L125;
        uvc.b r61 = r18.g(r22, r5, r110, r23, r20);
        if (r28 != (r110.c - 1)) goto L122;
        boolean r62 = true;
    L123:
        ec8.b.d r63 = new ec8.b.d(r61, true, r62);
    L133:
        r30 = r63;
        goto L136
    L122:
        r62 = false;
    L125:
        if (r60 != null) goto L127;
    L129:
        r18.h("create node to cache.");
        List r64 = r18.f(r22, r5, r23, r20);
        if (r64 != null) goto L132;
        r63 = new ec8.b.d(true, 4);
        goto L133
    L132:
        r18.d = new ec8.b.a(r60, r64);
        r63 = r18.e(r28, r27, r25);
        goto L133
    L127:
        if (Intrinsics.areEqual(r18.d.a, r60) == false) goto L129;
        r18.h("get node from cache.");
        r63 = r18.e(r28, r27, r25);
    L115:
        r122 = -1;
        goto L116
    L94:
        r51 = null;
        goto L95
    L90:
        r117 = false;
    L81:
        r25 = true;
        goto L82
    L73:
        if (this.e == false) goto L75;
        r21 = true;
    L159:
        r710 = r8;
        int r211 = r9;
        if (com.larus.platform.exp.h.a == false) goto L162;
        boolean r65 = ((Boolean) this.m.getValue()).booleanValue();
    L163:
        if (r65 == true) goto L165;
        String r66 = r78;
    L167:
        if (r80.b == false) goto L239;
        Lazy r67 = e.a;
        ?? r123 = r77;
        Intrinsics.checkNotNullParameter(r123, "view");
        Intrinsics.checkNotNullParameter(r66, "latestContent");
        ?? r124 = r123;
        if (e.b() == false) goto L240;
        uvc.b r125 = (uvc.b) ((Map) e.c.getValue()).get(r123);
        r124 = r123;
        if (r125 == null) goto L240;
        String r68 = r125.f;
        if (r68 == null) goto L238;
        uvc.b r69 = r125;
    L178:
        if ((r69 instanceof TableCell) == true) goto L186;
        if ((r69 instanceof TableBlock) == true) goto L186;
        uvc.b r70 = r69.c;
        if (r70 == null) goto L184;
        r69 = r70;
        goto L178
    L184:
        boolean r71 = r69 instanceof Text;
    L187:
        if (r71 == false) goto L238;
        if (r66.length() >= r68.length()) goto L191;
        String r72 = r68;
    L218:
        boolean r73 = false;
    L219:
        if (r73 == false) goto L238;
        uvc.b r74 = r125;
    L221:
        uvc.b r76 = r74.c;
        if (r76 == null) goto L225;
        r74 = r76;
        goto L221
    L225:
        if ((r74 instanceof Text) == false) goto L227;
        Text r88 = (Text) r74;
    L228:
        if (r88 != null) goto L230;
        boolean r89 = false;
    L231:
        if (r89 == false) goto L238;
        uvc.b r90 = e.a(r125);
        ?? r126 = r123;
        if (r90 == null) goto L241;
        Pair r91 = TuplesKt.to(r90, r66.substring(r72.length()));
        ?? r127 = r123;
    L242:
        if (r91 == null) goto L244;
        uvc.b r92 = (uvc.b) r91.getFirst();
    L245:
        if (r91 == null) goto L247;
        String r212 = (String) r91.getSecond();
    L248:
        if (r92 == null) goto L250;
        boolean r213 = true;
    L251:
        final Ref.ObjectRef r93 = new Ref.ObjectRef();
        if (r92 != null) goto L296;
        String r94 = r66;
        ?? r95 = r127;
        fh8.l r128 = r80;
        uvc.b r96 = gw8.c.b.c(r16, r77.getContext(), r94, !r80.b, r11, r20, new f(r93), null, 64);
        if (r96 != null) goto L256;
        r96 = null;
    L293:
        if (r96 != null) goto L295;
        return;
    L295:
        uvc.b r214 = r96;
        ?? r97 = r95;
    L298:
        if (r128.b == true) goto L300;
        e.c(r77);
    L300:
        String r129 = r128.c;
        if (r92 == null) goto L303;
        boolean r215 = true;
    L304:
        List r99 = a(r19, r5, r26, r710, r80, r11, r81, r82, r83, r129, r84, r86, r87, r77, r215, r212);
        gw8.c.a.getClass();
        gw8.c r100 = gw8.c.a.b();
        if (r100 == null) goto L307;
        Context r101 = r77.getContext();
        r112 = r80;
        r114 = true;
        boolean r102 = !r112.b;
        r113 = this;
        boolean r103 = r113.d;
        List<? extends uvc.b> r104 = r113.b;
        CopyOnWriteArraySet<String> r105 = com.larus.bmhome.chat.markdown.imagegroup.c.a;
        List<? extends uvc.b> r106 = r100.createMarkdownWidgets(r101, r211, r214, r102, r103, r11, r77, r104, r99, com.larus.bmhome.chat.markdown.imagegroup.c.a(r112.e), r20);
    L308:
        r113.b = r106;
        r39 = r213;
        goto L309
    L307:
        r114 = true;
        r113 = this;
        r112 = r80;
        r106 = null;
        goto L308
    L303:
        r215 = false;
        goto L304
    L256:
        if (r128.b == false) goto L293;
        Set r107 = (Set) r93.element;
        if (r107 == null) goto L260;
        MarkdownNodeModifyType r108 = (MarkdownNodeModifyType) CollectionsKt.singleOrNull(r107);
    L262:
        if (r108 != MarkdownNodeModifyType.ASTERISK_TOKEN_REMOVED) goto L264;
    L269:
        boolean r130 = true;
    L270:
        if (r130 == true) goto L272;
        e.c(r77);
        goto L293
    L272:
        Lazy r109 = e.a;
        Intrinsics.checkNotNullParameter(r95, "view");
        Intrinsics.checkNotNullParameter(r96, "node");
        if (e.b() == false) goto L293;
        uvc.b r131 = r96;
    L277:
        if ((r131 instanceof TableCell) == true) goto L285;
        if ((r131 instanceof TableBlock) == true) goto L285;
        uvc.b r132 = r131.c;
        if (r132 == null) goto L283;
        r131 = r132;
        goto L277
    L283:
        boolean r133 = r131 instanceof Text;
    L286:
        if (r133 == false) goto L293;
        uvc.b r134 = e.a(r96);
        if (r134 == null) goto L293;
        ((Map) e.c.getValue()).put(r95, r134);
    L285:
        r133 = false;
        goto L286
    L264:
        if (r108 == MarkdownNodeModifyType.UNDERSCORE_TOKEN_REMOVED) goto L269;
        if (r107 == null) goto L269;
        r130 = false;
        goto L270
    L260:
        r108 = null;
        goto L262
    L296:
        r97 = r127;
        r128 = r80;
        r214 = r92;
        goto L298
    L250:
        r213 = false;
        goto L251
    L247:
        r212 = null;
        goto L248
    L244:
        r92 = null;
    L241:
        r91 = null;
        r127 = r126;
        goto L242
    L230:
        r88.h += r66.substring(r125.f.length());
        r125.f = r66;
        r89 = true;
        goto L231
    L227:
        r88 = null;
        goto L228
    L191:
        if (r68.length() > 10) goto L193;
        boolean r135 = StringsKt.startsWith$default(r66, r68, false, 2, null);
        String r711 = r68;
    L199:
        if (r135 == true) goto L202;
        r72 = r711;
        goto L218
    L202:
        if (r711.length() <= 0) goto L204;
        boolean r136 = true;
    L205:
        if (r136 == false) goto L209;
        r72 = r711;
        if (((Set) e.a.getValue()).contains(Character.valueOf(r72.charAt(StringsKt.getLastIndex(r711)))) == true) goto L218;
    L210:
        int r137 = r72.length();
        int r138 = r66.length();
    L211:
        if (r137 >= r138) goto L216;
        if (((Set) e.a.getValue()).contains(Character.valueOf(r66.charAt(r137))) == true) goto L218;
        r137 = r137 + 1;
        goto L211
    L216:
        r73 = true;
        goto L219
    L209:
        r72 = r711;
        goto L210
    L204:
        r136 = false;
        goto L205
    L193:
        r711 = r68;
        if (StringsKt.regionMatches$default(r66, 0, r68, 0, 5, false, 16, null) == true) goto L196;
    L198:
        r135 = false;
        goto L199
    L196:
        if (StringsKt.regionMatches$default(r66, r711.length() - 5, r711, r711.length() - 5, 5, false, 16, null) == false) goto L198;
        r135 = true;
    L186:
        r71 = false;
    L238:
        e.c(r77);
        r126 = r123;
    L240:
        r126 = r124;
        goto L241
    L239:
        r124 = r77;
        goto L240
    L165:
        Regex r139 = com.larus.bmhome.chat.markdown.richtext.n.a;
        r66 = com.larus.bmhome.chat.markdown.richtext.n.k(r78);
        goto L167
    L162:
        r65 = z2.a.enableMessageMention();
        goto L163
    L66:
        r15 = null;
        goto L67
    L62:
        r14 = null;
        goto L64
    L59:
        r13 = null;
        goto L60
    L55:
        r12 = null;
        goto L57
    L30:
        if (this.i != null) goto L49;
        Lazy r140 = s.a;
        Context r610 = r77.getContext();
        boolean r141 = r79.d;
        Integer r611 = Integer.valueOf(i5.r0());
        Integer r142 = Integer.valueOf(r8.g);
        if (r142.intValue() <= 0) goto L34;
        boolean r143 = true;
    L35:
        if (r143 == false) goto L37;
        Integer r612 = r142;
    L38:
        boolean r144 = r80.h;
        if (((Boolean) this.n.getValue()).booleanValue() == true) goto L47;
        Boolean r145 = r80.k;
        if (r145 == null) goto L43;
        boolean r146 = r145.booleanValue();
    L44:
        if (r146 == true) goto L47;
        boolean r712 = false;
    L48:
        this.i = s.a(r610, false, r141, r5, r611, r612, r144, r712, r80.i, r80.j, 256);
        goto L49
    L43:
        r146 = false;
    L47:
        r712 = true;
        goto L48
    L37:
        r612 = null;
        goto L38
    L34:
        r143 = false;
        goto L35
    L22:
        if (r79.d == true) goto L25;
        r4 = 2131240017;
    L25:
        this.h = new ThreeLoadingIndicator(r77, r4, r77.getContext(), null);
        goto L26
    L11:
        r9 = w.c(w.a, r77.getContext(), r5, r79.f, Boolean.valueOf(r79.d), r79.e, false, null, r77, 96);
        goto L12
    }

    public final List a(fh8.f r83, Message r84, ChatParam r85, t r86, fh8.l r87, lw8.d r88, final Function1 r89, final Function1 r90, Function1 r91, String r92, Map r93, Block r94, r r95, View r96, boolean r97, String r99) {
        boolean r10 = r87.a;
        final boolean r11 = r87.d;
        if (r93 == null) goto L5;
        Object r12 = r93.get("current_page");
    L7:
        if ((r12 instanceof String) == false) goto L9;
        String r13 = (String) r12;
    L9:
        hf8.b r14 = new hf8.b();
        r14.e = r83;
        r14.a = this.f;
        r14.k = this.g;
        r14.l = this.h;
        r14.A = r95;
        Intrinsics.checkNotNullParameter(r84, "data");
        r14.b = r84;
        String r2 = r84.getSenderId();
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        BotModel r15 = new BotModel(r2, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        Intrinsics.checkNotNullParameter(r15, "bot");
        r14.c = r15;
        Intrinsics.checkNotNullParameter(r85, "chatParam");
        r14.d = r85;
        r14.f = r83.q;
        r14.g = Boolean.valueOf(r86.d);
        Intrinsics.checkNotNullParameter(r88, "customMarkDownInfo");
        r14.h = r88;
        r14.i = r83.n;
        r14.j = r83.o;
        r14.m = new k(r11, r89);
        r14.n = new l(r11, r90);
        r14.o = 0;
        r14.r = Boolean.valueOf(r87.b);
        r14.s = Boolean.valueOf(r10);
        r14.t = Boolean.FALSE;
        r14.u = new q(r86.a, r86.b, r86.c, r86.h);
        Intrinsics.checkNotNullParameter(r92, "viewTag");
        r14.q = r92;
        r14.v = r91;
        r14.p = Boolean.valueOf(r11);
        r14.y = r93;
        r14.z = r94;
        r14.C = Integer.valueOf(r86.g);
        r14.B = r83.s;
        r14.D = r96;
        r14.E = r97;
        r14.F = r99;
        pw8.b[] r1 = new pw8.b[1];
        if (r95 == null) goto L15;
    L18:
        pw8.b r3 = new com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1.l(r14.a());
    L19:
        r1[0] = r3;
        return CollectionsKt.mutableListOf(r1);
    L15:
        if (((Boolean) this.o.getValue()).booleanValue() == true) goto L18;
        r3 = new com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online.k(r14.a());
        goto L19
    L5:
        r12 = null;
        goto L7
    }
}
