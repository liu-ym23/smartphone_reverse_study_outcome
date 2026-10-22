package com.larus.bmhome.chat.list.cell.text.components.middle;

import android.content.Context;
import android.graphics.RectF;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.doclink.MessageDocPreviewInlineRenderer;
import com.larus.bmhome.chat.doclink.MessageDocPreviewRepository;
import com.larus.bmhome.chat.e5;
import com.larus.bmhome.chat.helper.n0;
import com.larus.bmhome.chat.layout.widget.ThreeLoadingIndicator;
import com.larus.bmhome.chat.layout.widget.p0;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.cells.base.CellComponentType;
import com.larus.bmhome.chat.list.cell.text.interceptor.ErrorEnum;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.utils.w2;
import com.larus.bmhome.utils.z1;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.impl.markwon.MarkwonStruct;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageTag;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MiddleTextComponent extends bd8.b implements com.larus.bmhome.chat.list.cell.text.components.middle.a {
    public static final Lazy<Message> S = null;
    public static final Lazy<Message> T = null;
    public List<? extends uvc.b> A;
    public boolean B;
    public Integer C;
    public Pair<MarkwonStruct, MarkwonStruct> D;
    public final Lazy E;
    public String F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public LinearLayout M;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public final wg8.c Q;
    public final Lazy R;
    public final AttachReceiver l;
    public Message m;
    public fh8.f n;
    public final Lazy o;
    public Integer p;
    public String q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public lw8.d u;
    public ec8.b v;
    public List<String> w;
    public final ConcurrentHashMap<String, CharSequence> x;
    public final Lazy y;
    public boolean z;

    public static final class a {
    }

    @Override // bd8.b
    public final boolean G(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return true;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.middle.a
    public final void c() {
        this.B = false;
        this.A = null;
    }

    static {
        S = LazyKt.lazy(new r());
        T = LazyKt.lazy(new s());
    }

    @Override // bd8.b
    public final void B() {
        this.Q.e();
        ((ThreeLoadingIndicator) this.O.getValue()).a();
        P().a();
        CoroutineScope r0 = com.larus.bmhome.chat.layout.widget.handler.p.a;
        Message r1 = this.m;
        if (r1 == null) goto L5;
        String r2 = r1.getMessageId();
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        com.larus.bmhome.chat.layout.widget.handler.p.d(r2, Q());
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // bd8.b
    public final void C() {
        LinearLayout r0 = this.M;
        if (r0 == null) goto L5;
        ExposureTrackerExtKt.c(r0);
    L5:
        com.larus.bmhome.chat.layout.item.i r1 = this.d;
        if (r1 == null) goto L42;
        Message r3 = this.m;
        if (r3 == null) goto L11;
        List<String> r4 = com.larus.bmhome.chat.bean.d.K(r3);
    L13:
        if (r4 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L42;
        if (((Boolean) this.K.getValue()).booleanValue() == true) goto L42;
        Lazy r6 = z1.a;
        int r7 = r1.getBoxType();
        Integer r8 = r1.getImmerseBgColor();
        IChatMessageShareAbility r9 = (IChatMessageShareAbility) this.I.getValue();
        if (r9 != null) goto L27;
    L29:
        boolean r10 = false;
    L30:
        Message r11 = this.m;
        if (r11 != null) goto L33;
    L35:
        boolean r12 = false;
    L37:
        if (r1.getWidth() != z1.h(r7, r8, r10, r12, 16)) goto L39;
        boolean r2 = true;
    L40:
        if (r2 == false) goto L42;
        boolean r13 = !((Boolean) this.L.getValue()).booleanValue();
    L43:
        if (r13 == false) goto L45;
        return;
    L45:
        ec8.b r14 = this.v;
        if (r14 == null) goto L48;
        Intrinsics.checkNotNullParameter(MiddleTextComponent.class, "clazz");
        r14.b.remove(MiddleTextComponent.class);
    L48:
        LinearLayout r15 = this.M;
        if (r15 == null) goto L67;
        int r16 = r15.getChildCount();
        int r17 = 0;
    L51:
        if (r17 >= r16) goto L67;
        View r18 = r15.getChildAt(r17);
        if ((r18 instanceof FrameLayout) == false) goto L55;
        FrameLayout r19 = (FrameLayout) r18;
    L56:
        if (r19 == null) goto L66;
        int r20 = r19.getChildCount();
        int r21 = 0;
    L58:
        if (r21 >= r20) goto L66;
        CustomMarkdownTextView r22 = r19.getChildAt(r21);
        if ((r22 instanceof CustomMarkdownTextView) == false) goto L62;
        CustomMarkdownTextView r23 = r22;
    L63:
        if (r23 == null) goto L65;
        com.larus.utils.l.a(r23);
        r23.a();
    L65:
        r21 = r21 + 1;
        goto L58
    L62:
        r23 = null;
    L66:
        r17 = r17 + 1;
        goto L51
    L55:
        r19 = null;
    L67:
        LinearLayout r24 = this.M;
        if (r24 == null) goto L70;
        r24.removeAllViews();
    L70:
        this.B = false;
        this.z = false;
        this.A = null;
        this.x.clear();
        this.D = null;
        this.u = null;
        this.C = null;
        return;
    L39:
        r2 = false;
        goto L40
    L33:
        if (com.larus.bmhome.chat.bean.d.J0(r11) != true) goto L35;
        r12 = true;
        goto L37
    L27:
        if (r9.H1() != true) goto L29;
        r10 = true;
        goto L30
    L15:
        if (r4.isEmpty() == true) goto L18;
        r5 = false;
        goto L19
    L11:
        r4 = null;
    L42:
        r13 = false;
        goto L43
    }

    public final de8.c N() {
        return (de8.c) this.G.getValue();
    }

    public final v0 P() {
        return (v0) this.N.getValue();
    }

    public final String Q() {
        StringBuilder r0 = new StringBuilder("text-");
        com.larus.bmhome.chat.list.cell.text.cells.base.c r1 = this.h;
        Integer r2 = null;
        if (r1 == null) goto L5;
        CellComponentType r3 = r1.a;
    L6:
        r0.append(r3);
        r0.append('-');
        com.larus.bmhome.chat.list.cell.text.cells.base.c r4 = this.h;
        if (r4 == null) goto L9;
        r2 = Integer.valueOf(r4.b);
    L9:
        r0.append(r2);
        return r0.toString();
    L5:
        r3 = null;
        goto L6
    }

    @Override // bd8.b
    public final Map<String, Object> u() {
        List<String> r0 = this.w;
        if (r0 == null) goto L7;
        Map<String, Object> r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("node_type_list", r0.toString())});
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new LinkedHashMap();
    }

    @Override // bd8.b
    public final void z() {
        wg8.c r0 = this.Q;
        r0.j.a = 0;
        r0.d = false;
        P().b();
        ((ThreeLoadingIndicator) this.O.getValue()).d();
        Message r1 = this.m;
        if (r1 != null) goto L5;
        return;
    L5:
        com.larus.bmhome.chat.api.a0 r2 = ILegacyChatUiServiceDelegate.b.r8();
        if (r2 == null) goto L9;
        r2.a(r1, this.c, this.e);
        return;
    }

    public final void K(h0 r17) {
        z2 r1 = z2.a;
        if (r1.enableMessageUrlPreview() == true) goto L5;
        return;
    L5:
        Message r2 = r17.d;
        if (i3.a.f() == false) goto L8;
        return;
    L8:
        String r3 = r2.getMessageId();
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        if (StringsKt.isBlank(r3) == false) goto L14;
        return;
    L14:
        BotModel r5 = r17.f;
        if (r17.g == false) goto L17;
        String r0 = hc8.c.a.d(r2, r5, true, true);
    L18:
        Regex r6 = com.larus.bmhome.chat.markdown.richtext.n.a;
        com.larus.bmhome.chat.markdown.richtext.i r7 = com.larus.bmhome.chat.markdown.richtext.n.m(r0, r1.enableMessageMention(), 4);
        List<String> r8 = r7.e;
        if (r8.isEmpty() == false) goto L21;
        return;
    L21:
        ArrayList r4 = new ArrayList();
        L(this.M, r4);
        if (r4.isEmpty() == false) goto L24;
        return;
    L24:
        String r9 = M(r2);
        LinkedHashMap r10 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r4, 10)), 16));
        Iterator r11 = r4.iterator();
    L26:
        if (r11.hasNext() == false) goto L31;
        Object r12 = r11.next();
        CharSequence r13 = ((CustomMarkdownTextView) r12).getText();
        if (r13 != null) goto L30;
        r13 = "";
    L30:
        r10.put(r12, r13);
        goto L26
    L31:
        FLogger.a.i("MiddleTextComponent", "bindDownstreamInlineDocPreview request urlCount=" + r8.size() + ", hasMessageId=true");
        if (S(r9) == true) goto L34;
        return;
    L34:
        MessageDocPreviewRepository r14 = MessageDocPreviewRepository.a;
        J(r7, MessageDocPreviewRepository.e(r3, r8), r10, "cache");
        Fragment r15 = this.c;
        if (r15 == null) goto L43;
        LifecycleCoroutineScope r16 = LifecycleOwnerKt.getLifecycleScope(r15);
        if (r16 == null) goto L44;
        BuildersKt.launch$default(r16, null, null, new MiddleTextComponent$bindDownstreamInlineDocPreviewIfNeeded$1(r3, r8, this, r9, r7, r10, null), 3, null);
        return;
    L44:
        return;
    L43:
        return;
    L17:
        r0 = hc8.b.a.a(hc8.c.a, r2, r5, true, 8);
        goto L18
    }

    public final String M(Message r4) {
        String r0 = r4.getMessageId();
        String r1 = null;
        if (r0 != null) goto L5;
    L9:
        String r2 = r4.getLocalMessageId();
        if (r2 != null) goto L12;
    L14:
        if (r1 != null) goto L17;
        return String.valueOf(r4.getLocalIndex());
    L17:
        return r1;
    L12:
        if ((!StringsKt.isBlank(r2)) == false) goto L14;
        r1 = r2;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L9;
        return r0;
    }

    public final boolean S(String r3) {
        Message r0 = this.m;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = M(r0);
    L7:
        if (Intrinsics.areEqual(r2, r3) == false) goto L18;
        LinearLayout r4 = this.M;
        if (r4 == null) goto L11;
        Object r5 = r4.getTag();
    L12:
        Message r6 = this.m;
        if (r6 == null) goto L16;
        r1 = r6.getMessageId();
    L16:
        if (Intrinsics.areEqual(r5, r1) == false) goto L18;
        return true;
    L11:
        r5 = null;
    L18:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    @Override // bd8.b
    public final void v(Message r18) {
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r18, "message");
        Message r1 = this.m;
        String r2 = null;
        if (r1 == null) goto L5;
        MessageTag r3 = com.larus.bmhome.chat.bean.d.D(r1);
    L7:
        if (r3 == MessageTag.MessageTag_Unknown) goto L31;
        Message r4 = this.m;
        if (r4 == null) goto L11;
        String r6 = com.larus.bmhome.chat.bean.d.Z0(r4);
    L12:
        LruCache r5 = ko8.a.a;
        Message r7 = this.m;
        if (r7 == null) goto L15;
        String r8 = r7.getMessageId();
    L16:
        Message r9 = this.m;
        if (r9 == null) goto L19;
        r2 = r9.getSenderId();
    L19:
        String r10 = r2;
        Message r11 = this.m;
        if (r11 == null) goto L24;
        String r12 = r11.getContent();
        if (r12 == null) goto L24;
        boolean r13 = StringsKt.isBlank(r12);
    L25:
        de8.c r14 = N();
        if (r14 == null) goto L28;
        long r15 = r14.n;
    L29:
        IAIChatControlTraceService.a.Lb(r8, r10, r6, 1, r13, false, false, r15, null, null, null, null);
        return;
    L28:
        r15 = 0;
    L24:
        r13 = true;
        goto L25
    L15:
        r8 = null;
        goto L16
    L11:
        r6 = null;
        goto L12
    L31:
        return;
    L5:
        r3 = null;
        goto L7
    }

    public MiddleTextComponent(int r2, AttachReceiver r3) {
        Intrinsics.checkNotNullParameter(r3, "attachReceiver");
        super(true, r2);
        this.l = r3;
        this.n = new fh8.f(0);
        this.o = LazyKt.lazy(new z());
        this.r = LazyKt.lazy(new c(this));
        this.s = LazyKt.lazy(new d());
        this.t = LazyKt.lazy(new e(this));
        this.x = new ConcurrentHashMap();
        this.y = LazyKt.lazy(new f());
        this.E = LazyKt.lazy(new g());
        this.G = LazyKt.lazy(new h(this));
        this.H = LazyKt.lazy(new i(this));
        this.I = LazyKt.lazy(new j(this));
        this.J = LazyKt.lazy(new k(this));
        this.K = LazyKt.lazy(new a0());
        this.L = LazyKt.lazy(new b0());
        this.N = LazyKt.lazy(new c0(this));
        this.O = LazyKt.lazy(new d0(this));
        this.P = LazyKt.lazy(new e0(this));
        this.Q = new wg8.c();
        this.R = LazyKt.lazy(new g0(r3));
    }

    public static void L(View r1, List r2) {
        if ((r1 instanceof CustomMarkdownTextView) == false) goto L6;
        ((ArrayList) r2).add(r1);
        return;
    L6:
        if ((r1 instanceof ViewGroup) == false) goto L13;
        Iterator r3 = ViewGroupKt.getChildren((ViewGroup) r1).iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        L((View) r3.next(), r2);
        goto L9
    L14:
        return;
    }

    public final void R(uvc.b r33, h0 r34) {
        Message r2 = this.m;
        if (r2 == null) goto L7;
        boolean r3 = true;
        if (com.larus.im.bean.message.a.C0(r2) != true) goto L7;
    L8:
        String r4 = null;
        if (r3 == false) goto L28;
        if (r33.b != null) goto L28;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L42;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new MiddleTextComponent$internalRender$1(r34, null), 3, null);
    L20:
        this.A = null;
        CoroutineScope r0 = com.larus.bmhome.chat.layout.widget.handler.p.a;
        Message r1 = this.m;
        if (r1 == null) goto L23;
        r4 = r1.getMessageId();
    L23:
        if (r4 != null) goto L25;
        r4 = "";
    L25:
        com.larus.bmhome.chat.layout.widget.handler.p.d(r4, Q());
        return;
    L42:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L17
        r34.j.removeAllViews();     // Catch: Throwable -> L17
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Result.box-impl(r6);
    L17:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        lw8.d r8 = this.u;
        if (r8 != null) goto L31;
        r8 = new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
    L31:
        lw8.d r10 = r8;
        gw8.c.a.getClass();
        gw8.c r9 = gw8.c.a.b();
        if (r9 == null) goto L34;
        List<? extends uvc.b> r11 = r9.createMarkdownWidgets(r34.getContext(), r34.i, r33, r34.e, this.B, r10, r34.j, this.A, r34.k, r34.l, O(r34.getContext(), r34.e, r10, r34.i));
    L35:
        this.A = r11;
        if (r34.e == true) goto L38;
        return;
    L38:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L40;
        K(r34);
        return;
    L40:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new MiddleTextComponent$internalRender$4(this, r34, null), 3, null);
        return;
    L34:
        r11 = null;
    L7:
        r3 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.bmhome.chat.list.cell.text.components.middle.x] */
    public final uvc.b T(h0 r36, final Function3<? super Integer, ? super Long, ? super lw8.m, Unit> r37) {
        Intrinsics.checkNotNullParameter(r36, "renderParams");
        long r2 = System.currentTimeMillis();
        if (r36.g == false) goto L5;
        String r4 = hc8.c.a.d(r36.d, r36.f, true, true);
    L7:
        if (z2.a.enableMessageMention() == false) goto L10;
        Regex r5 = com.larus.bmhome.chat.markdown.richtext.n.a;
        r4 = com.larus.bmhome.chat.markdown.richtext.n.k(r4);
    L10:
        final String r7 = r4;
        final long r6 = System.currentTimeMillis() - r2;
        lw8.d r3 = this.u;
        if (r3 != null) goto L13;
        r3 = new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
    L13:
        lw8.d r9 = r3;
        return gw8.c.b.c(r36.b, r36.getContext(), r7, r36.e, r9, O(r36.getContext(), r36.e, r9, r36.i), null, new x(r37, r7, r6), 32);
    L5:
        r4 = hc8.b.a.a(hc8.c.a, r36.d, r36.f, true, 8);
        goto L7
    }

    public final void V(Message r8, BotModel r9) {
        Integer r0 = this.C;
        String r1 = "";
        if (r0 == null) goto L16;
        if (r0.intValue() != 24) goto L16;
        Message r2 = this.m;
        if (r2 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L16;
    L30:
        boolean r4 = true;
    L31:
        if (r4 == true) goto L34;
        this.C = Integer.valueOf(r8.getMessageStatusLocal());
        return;
    L34:
        this.C = Integer.valueOf(r8.getMessageStatusLocal());
        U(r8, r9, false);
        CopyOnWriteArraySet<String> r5 = com.larus.bmhome.chat.markdown.imagegroup.c.a;
        String r6 = r8.getMessageId();
        if (r6 != null) goto L38;
        r6 = "";
    L38:
        if (com.larus.bmhome.chat.markdown.imagegroup.c.a(r6) == false) goto L44;
        U(r8, r9, true);
        String r10 = r8.getMessageId();
        if (r10 == null) goto L43;
        r1 = r10;
    L43:
        Intrinsics.checkNotNullParameter(r1, "forceRefreshId");
        com.larus.bmhome.chat.markdown.imagegroup.c.a.remove(r1);
    L44:
        com.larus.bmhome.chat.api.a0 r11 = ILegacyChatUiServiceDelegate.b.r8();
        if (r11 == null) goto L48;
        r11.a(r8, this.c, this.e);
        return;
    L48:
        return;
    L10:
        if (r2.getMessageStatusLocal() != 20) goto L12;
        r3 = true;
    L16:
        if (((Boolean) this.y.getValue()).booleanValue() == false) goto L30;
        if (com.larus.bmhome.chat.bean.d.Q0(r8) == false) goto L30;
        StringBuilder r7 = new StringBuilder();
        r7.append(r8.getMessageId());
        r7.append('_');
        int r12 = com.larus.im.d.a;
        com.larus.im.internal.stream.b r13 = com.larus.im.internal.stream.b.a;
        String r14 = r8.getMessageId();
        if (r14 != null) goto L24;
        r14 = "";
    L24:
        r7.append(r13.c(r14));
        String r15 = r7.toString();
        if (r8.getMessageStatusLocal() == 20) goto L27;
    L29:
        this.F = r15;
        goto L30
    L27:
        if (Intrinsics.areEqual(this.F, r15) == false) goto L29;
        r4 = false;
        goto L31
    }

    public final void U(final Message r57, final BotModel r58, boolean r59) {
        long r13 = System.currentTimeMillis();
        gw8.c.a.getClass();
        gw8.c r16 = gw8.c.a.b();
        if (r16 != null) goto L5;
        return;
    L5:
        LinearLayout r2 = this.M;
        if (r2 == null) goto L8;
        r2.setTag(r57.getMessageId());
    L8:
        LinearLayout r12 = this.M;
        if (r12 != null) goto L11;
        return;
    L11:
        Context r17 = r12.getContext();
        if (r17 != null) goto L14;
        return;
    L14:
        ChatParam r3 = (ChatParam) this.H.getValue();
        if (r3 != null) goto L24;
        LruCache r4 = ko8.a.a;
        String r8 = r57.getConversationId();
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        wc9.e r5 = (wc9.e) r4.get(r8);
        if (r5 == null) goto L22;
        String r9 = ic8.n.f(r5);
    L23:
        r3 = new ChatParam(null, null, null, null, r9, 239);
        goto L24
    L22:
        r9 = null;
    L24:
        fh8.g r6 = new fh8.g();
        r6.b = r57;
        r6.d = r58.getBotId();
        LruCache r7 = ko8.a.a;
        de8.c r10 = N();
        if (r10 == null) goto L27;
        long r11 = r10.n;
    L28:
        r6.a = ko8.a.e(r11);
        r6.e = r3.d;
        r6.f = r3.c;
        q0 r14 = this.e;
        if (r14 == null) goto L32;
        LruSet<String> r15 = r14.E7();
        if (r15 == null) goto L32;
    L33:
        r6.g = r15;
        q0 r18 = this.e;
        if (r18 == null) goto L40;
        q0.a r19 = r18.getProvider();
        if (r19 == null) goto L40;
        com.larus.bmhome.chat.component.collection.o r20 = r19.i2();
        if (r20 == null) goto L40;
        boolean r21 = r20.i0();
    L41:
        r6.h = Boolean.valueOf(r21);
        r6.l = new b(this);
        q0 r22 = this.e;
        if (r22 == null) goto L44;
        q0.a r23 = r22.getProvider();
    L45:
        r6.m = r23;
        r6.n = this.l;
        BaseCompositeTextCell<?> r24 = this.f;
        if (r24 == null) goto L50;
        RecyclerView r25 = ((BaseMessageListCell) r24).b;
        if (r25 == null) goto L50;
        RecyclerView.Adapter<?> r26 = r25.getAdapter();
    L51:
        r6.o = r26;
        r6.k = this.p;
        r6.q = this.e;
        r6.i = new m(this);
        this.n = r6.a();
        if (this.u != null) goto L65;
        Lazy r27 = dg8.s.a;
        com.larus.bmhome.chat.layout.item.i r28 = this.d;
        if (r28 == null) goto L56;
        boolean r29 = r28.getUseSubscribedColor();
    L57:
        de8.c r30 = N();
        if (r30 != null) goto L60;
    L62:
        boolean r31 = false;
    L63:
        this.u = dg8.s.a(r17, r29, r31, r57, null, null, false, ((e5) this.P.getValue()).e, false, false, 1904);
        goto L65
    L60:
        if (r30.C() != true) goto L62;
        r31 = true;
        goto L63
    L56:
        r29 = false;
    L65:
        de8.c r32 = N();
        if (r32 == null) goto L68;
        Integer r110 = r32.m();
    L69:
        if (r110 == null) goto L71;
        boolean r111 = true;
    L72:
        if (r111 == false) goto L77;
        Context r33 = getContext();
        if (r33 != null) goto L76;
        r33 = AppHost.a.getApplication();
    L76:
        int r34 = ContextCompat.getColor(r33, 2131103298);
    L81:
        if (r111 == false) goto L83;
        int r35 = i5.o();
    L84:
        hf8.b r36 = new hf8.b();
        r36.e = this.n;
        r36.a = this.x;
        Intrinsics.checkNotNullParameter(r57, "data");
        r36.b = r57;
        Intrinsics.checkNotNullParameter(r58, "bot");
        r36.c = r58;
        ChatParam r37 = (ChatParam) this.H.getValue();
        if (r37 != null) goto L94;
        LruCache r38 = ko8.a.a;
        String r112 = r57.getConversationId();
        if (r112 != null) goto L89;
        r112 = "";
    L89:
        wc9.e r39 = (wc9.e) r38.get(r112);
        if (r39 == null) goto L92;
        String r113 = ic8.n.f(r39);
    L93:
        r37 = new ChatParam(null, null, null, null, r113, 239);
        goto L94
    L92:
        r113 = null;
    L94:
        Intrinsics.checkNotNullParameter(r37, "chatParam");
        r36.d = r37;
        r36.f = this.e;
        r36.u = new com.larus.bmhome.chat.layout.widget.handler.q(r34, r35, -1, new RectF(c7.b(16), c7.b(12), c7.b(16), c7.b(12)));
        de8.c r40 = N();
        if (r40 == null) goto L97;
        Integer r114 = r40.m();
    L98:
        if (r114 == null) goto L100;
        boolean r115 = true;
    L101:
        r36.g = Boolean.valueOf(r115);
        lw8.d r41 = this.u;
        if (r41 != null) goto L104;
        r41 = new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
    L104:
        Intrinsics.checkNotNullParameter(r41, "customMarkDownInfo");
        r36.h = r41;
        q0 r42 = this.e;
        if (r42 == null) goto L107;
        q0.a r116 = r42.getProvider();
    L108:
        r36.i = r116;
        q0 r43 = this.e;
        if (r43 == null) goto L111;
        ComponentFeature r117 = r43.J7();
    L112:
        r36.j = r117;
        v0 r44 = P();
        r44.f = false;
        r44.g = false;
        r44.n = true;
        r44.m = false;
        r36.k = r44;
        r36.l = (ThreeLoadingIndicator) this.O.getValue();
        r36.m = new o(this);
        r36.n = new p(this, r58);
        r36.o = this.p;
        if (com.larus.bmhome.chat.bean.d.f0(r57) == false) goto L115;
    L119:
        boolean r45 = false;
    L120:
        r36.r = Boolean.valueOf(r45);
        if (com.larus.bmhome.chat.bean.d.e0(r57) == true) goto L123;
    L127:
        boolean r46 = false;
    L128:
        r36.s = Boolean.valueOf(r46);
        if (com.larus.bmhome.chat.bean.d.I0(r57) == false) goto L131;
    L134:
        boolean r47 = true;
    L135:
        r36.t = Boolean.valueOf(r47);
        String r48 = Q();
        Intrinsics.checkNotNullParameter(r48, "viewTag");
        r36.q = r48;
        r36.w = new q(this, r57);
        r36.p = Boolean.FALSE;
        pw8.b[] r49 = new pw8.b[1];
        if (((Boolean) this.o.getValue()).booleanValue() == false) goto L138;
        pw8.b r50 = new com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1.l(r36.a());
    L139:
        r49[0] = r50;
        List r51 = CollectionsKt.mutableListOf(r49);
        if (((e5) this.P.getValue()).a == false) goto L156;
        u29.b r52 = (u29.b) this.R.getValue();
        if (r52 == null) goto L150;
        de8.c r53 = N();
        if (r53 == null) goto L146;
        Integer r54 = r53.m();
    L147:
        com.larus.bmhome.chat.layout.widget.handler.c r55 = r52.zL(r57, r54);
        if (r55 == null) goto L150;
        r51.add(r55);
        goto L150
    L146:
        r54 = null;
    L150:
        de8.c r56 = N();
        if (r56 == null) goto L153;
        long r60 = r56.n;
    L154:
        r51.add(new com.larus.bmhome.chat.layout.widget.handler.o(r57, r60));
        com.larus.bmhome.chat.layout.widget.handler.f r61 = (com.larus.bmhome.chat.layout.widget.handler.f) this.s.getValue();
        r61.getClass();
        Intrinsics.checkNotNullParameter(r57, "<set-?>");
        r61.a = r57;
        r51.add(r61);
        goto L156
    L153:
        r60 = 0;
    L156:
        if (r57.getMessageStatusLocal() != 23) goto L158;
    L167:
        boolean r62 = true;
    L168:
        FLogger r63 = FLogger.a;
        r63.d("MiddleTextComponent", "finished: " + r62);
        com.larus.bmhome.chat.layout.widget.handler.w r64 = com.larus.bmhome.chat.layout.widget.handler.w.a;
        com.larus.bmhome.chat.layout.item.i r65 = this.d;
        if (r65 == null) goto L171;
        Integer r66 = Integer.valueOf(r65.getBoxType());
    L172:
        de8.c r67 = N();
        if (r67 == null) goto L175;
        Integer r68 = r67.m();
    L176:
        if (r68 == null) goto L178;
        boolean r69 = true;
    L179:
        Boolean r118 = Boolean.valueOf(r69);
        IChatMessageShareAbility r70 = (IChatMessageShareAbility) this.I.getValue();
        if (r70 != null) goto L182;
    L184:
        boolean r119 = false;
    L185:
        boolean r120 = r62;
        int r210 = com.larus.bmhome.chat.layout.widget.handler.w.c(r64, r17, r57, r66, r118, r119, false, null, this.d, 96);
        r63.d("MiddleTextComponent", "unUse cacheMarkdownInfo!");
        boolean r121 = com.larus.bmhome.chat.bean.d.Q0(r57);
        ce8.d r71 = (ce8.d) this.t.getValue();
        if (r71 == null) goto L188;
        ExecutorCoroutineDispatcher r211 = r71.fi();
    L189:
        boolean r122 = ((e5) this.P.getValue()).b;
        boolean r123 = ((e5) this.P.getValue()).c;
        lw8.d r72 = this.u;
        if (r72 != null) goto L192;
        r72 = new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
    L192:
        h0 r73 = new h0(r13, r16, r17, r57, r120, r58, r122, r72, r210, r12, r51, r59);
        if (r123 == false) goto L203;
        if (r120 == true) goto L196;
    L197:
        if (r211 == null) goto L203;
        Fragment r74 = this.c;
        if (r74 == null) goto L203;
        LifecycleCoroutineScope r75 = LifecycleOwnerKt.getLifecycleScope(r74);
        if (r75 == null) goto L203;
        h0 r76 = r73;
        HashMap r77 = null;
        BuildersKt.launch$default(r75, r211, null, new MiddleTextComponent$renderAsync$1(this, r76, null), 2, null);
    L204:
        if (r123 == false) goto L207;
        if (r120 == true) goto L207;
        if (r211 == null) goto L207;
    L259:
        this.B = r120;
        this.z = r121;
        v0 r0 = P();
        if (r57.getMessageStatusLocal() != 20) goto L262;
    L265:
        boolean r124 = true;
    L266:
        r0.k = r124;
        if (r124 == true) goto L270;
        r0.a();
    L273:
        ThreeLoadingIndicator r1 = (ThreeLoadingIndicator) this.O.getValue();
        if (com.larus.bmhome.chat.bean.d.I0(r57) == false) goto L276;
    L279:
        boolean r125 = true;
    L280:
        r1.b(r125);
        return;
    L276:
        if (wf9.b.b(r57) == true) goto L279;
        r125 = false;
        goto L280
    L270:
        if (((Boolean) r0.h.getValue()).booleanValue() == false) goto L273;
        r0.o = true;
        r0.a();
        t0.a.postDelayed(r0.l, 2000);
        goto L273
    L262:
        if (com.larus.bmhome.chat.bean.d.Q0(r57) == true) goto L265;
        r124 = false;
    L207:
        ug8.g r78 = ug8.g.a;
        Intrinsics.checkNotNullParameter(r76, "params");
        ug8.h r79 = ug8.g.h;
        if (r79 != null) goto L282;
    L216:
        final h0 r80 = r76;
    L220:
        long r81 = System.currentTimeMillis() - r80.a;
        final Ref.ObjectRef r82 = new Ref.ObjectRef();
        uvc.b r83 = T(r80, new n(r82, r80, this));
        if (r83 == null) goto L259;
        R(r83, r80);
        if (r80.e == false) goto L259;
        long r84 = System.currentTimeMillis() - r80.a;
        Long r212 = (Long) r82.element;
        boolean r85 = r80.g;
        Long r126 = Long.valueOf(r81);
        Long r213 = Long.valueOf(r84);
        Boolean r214 = Boolean.FALSE;
        LinkedHashMap r86 = new LinkedHashMap();
        LinearLayout r87 = this.M;
        if (r87 == null) goto L248;
        Iterator r88 = ViewGroupKt.getChildren(r87).iterator();
    L229:
        if (r88.hasNext() == false) goto L248;
        View r89 = (View) r88.next();
        Object r90 = r89.getTag(2131379591);
        if ((r90 instanceof HashMap) == false) goto L233;
        HashMap r127 = (HashMap) r90;
    L234:
        if (r127 == null) goto L236;
        r86.putAll(r127);
    L236:
        Object r91 = r89.getTag(2131379589);
        if ((r91 instanceof HashMap) == false) goto L239;
        HashMap r128 = (HashMap) r91;
    L240:
        if (r128 == null) goto L242;
        r86.putAll(r128);
    L242:
        Object r92 = r89.getTag(2131379590);
        if ((r92 instanceof HashMap) == false) goto L245;
        HashMap r129 = (HashMap) r92;
    L246:
        if (r129 == null) goto L229;
        r86.putAll(r129);
        goto L229
    L245:
        r129 = r77;
        goto L246
    L239:
        r128 = r77;
        goto L240
    L233:
        r127 = r77;
    L248:
        Set r93 = r86.keySet();
        ArrayList r94 = new ArrayList();
        Iterator r95 = r93.iterator();
    L250:
        if (r95.hasNext() == false) goto L254;
        Object r96 = r95.next();
        if ((r96 instanceof String) == false) goto L250;
        r94.add(r96);
        goto L250
    L254:
        this.w = r94;
        Fragment r97 = this.c;
        if (r97 == null) goto L259;
        LifecycleCoroutineScope r99 = LifecycleOwnerKt.getLifecycleScope(r97);
        if (r99 == null) goto L259;
        BuildersKt.launch$default(r99, Dispatchers.getIO(), null, new MiddleTextComponent$trackTextCellMarkdownRender$2(r94, r126, r212, r213, r214, null, r85, null), 2, null);
        goto L259
    L282:
        Pair<h0, ErrorEnum> r100 = r79.a(r76);     // Catch: Exception -> L217
        r80 = (h0) r100.component1();     // Catch: Exception -> L217
        if (((ErrorEnum) r100.component2()) == null) goto L216;
        ug8.g.c(r76.d);     // Catch: Exception -> L214
    L214:
        e = e;
    L219:
        FLogger.a.e("MarkdownRenderInterceptorManager", "render params error, current latest message id : " + ug8.g.i + ' ', e);
    L217:
        e = e;
        r80 = r76;
        goto L219
    L196:
        if (this.z == true) goto L197;
    L203:
        r76 = r73;
        r77 = null;
        goto L204
    L188:
        r211 = null;
        goto L189
    L182:
        if (r70.H1() != true) goto L184;
        r119 = true;
        goto L185
    L178:
        r69 = false;
        goto L179
    L175:
        r68 = null;
        goto L176
    L171:
        r66 = null;
        goto L172
    L158:
        if (r57.getMessageStatusLocal() == 22) goto L167;
        if (com.larus.bmhome.chat.bean.d.I0(r57) == false) goto L162;
    L166:
        r62 = false;
        goto L168
    L162:
        if (r57.getMessageStatusLocal() == 20) goto L166;
        if (com.larus.bmhome.chat.bean.d.Q0(r57) == true) goto L166;
    L138:
        r50 = new com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online.k(r36.a());
        goto L139
    L131:
        if (wf9.b.b(r57) == true) goto L134;
        r47 = false;
        goto L135
    L123:
        if (r57.getMessageStatusLocal() != 23) goto L125;
    L126:
        r46 = true;
        goto L128
    L125:
        if (r57.getMessageStatusLocal() != 22) goto L127;
    L115:
        if (r57.getMessageStatusLocal() != 20) goto L117;
    L118:
        r45 = true;
        goto L120
    L117:
        if (com.larus.bmhome.chat.bean.d.Q0(r57) == false) goto L119;
    L111:
        r117 = null;
        goto L112
    L107:
        r116 = null;
        goto L108
    L100:
        r115 = false;
        goto L101
    L97:
        r114 = null;
        goto L98
    L83:
        r35 = i5.t();
        goto L84
    L77:
        Context r101 = getContext();
        if (r101 != null) goto L80;
        r101 = AppHost.a.getApplication();
    L80:
        r34 = ContextCompat.getColor(r101, v19.c.b(2130972079, getContext(), 2131103136));
        goto L81
    L71:
        r111 = false;
        goto L72
    L68:
        r110 = null;
    L50:
        r26 = null;
        goto L51
    L44:
        r23 = null;
    L40:
        r21 = false;
    L32:
        r15 = new LruSet(1);
        goto L33
    L27:
        r11 = 0;
        goto L28
    }

    @Override // com.larus.bmhome.chat.list.cell.text.components.middle.a
    public final void a(Message r12, BotModel r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r13, "bot");
        String r1 = null;
        LinearLayout r2 = null;
        boolean r3 = false;
        if (com.larus.bmhome.chat.bean.d.f0(r12) == false) goto L23;
        String r0 = com.larus.im.bean.message.a.K(r12);
        if (r0 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L23;
        LinearLayout r15 = this.M;
        if (r15 != null) goto L15;
        return;
    L15:
        if (r15.getVisibility() != 8) goto L18;
        r3 = true;
    L18:
        if ((!r3) == false) goto L20;
        r2 = r15;
    L20:
        if (r2 == null) goto L86;
        e1.o(r2);
        return;
    L86:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r4 = false;
    L23:
        LinearLayout r5 = this.M;
        if (r5 == null) goto L36;
        if (r5.getVisibility() != 0) goto L28;
        boolean r6 = true;
    L30:
        if ((!r6) == true) goto L33;
        r5 = null;
    L33:
        if (r5 == null) goto L36;
        e1.x(r5);
        goto L36
    L28:
        r6 = false;
    L36:
        if (com.larus.bmhome.chat.bean.d.x0(r12) == false) goto L83;
        n0 r7 = n0.a;
        String r8 = r12.getMessageId();
        r7.getClass();
        int r9 = w2.a(r8);
        List r10 = r12.getSubList();
        if (r10 == null) goto L40;
        Message r11 = (Message) CollectionsKt.getOrNull(r10, r9);
    L41:
        FLogger r16 = FLogger.a;
        r16.d("MiddleTextComponent", "refreshMainContent index:" + r9);
        if (r11 != null) goto L44;
    L54:
        boolean r17 = true;
    L55:
        if (r17 == false) goto L59;
        r16.d("MiddleTextComponent", "refreshMainContent subMessage null");
        V((Message) S.getValue(), r13);
        P().b();
        if (r14 == false) goto L87;
        n0.i(r12, r9);
        return;
    L87:
        return;
    L59:
        if (r11 != null) goto L61;
    L70:
        if (r3 == false) goto L72;
        V((Message) T.getValue(), r13);
        return;
    L72:
        if (r11 == null) goto L74;
        String r18 = r11.getMessageId();
    L76:
        if (Intrinsics.areEqual(r18, this.q) == true) goto L81;
        c();
        if (r11 == null) goto L80;
        r1 = r11.getMessageId();
    L80:
        this.q = r1;
    L81:
        if (r11 == null) goto L90;
        V(r11, r13);
        return;
    L90:
        return;
    L74:
        r18 = null;
        goto L76
    L61:
        if (r11.getMessageStatusLocal() != 22) goto L70;
        String r19 = r11.getMessageId();
        if (r19 != null) goto L65;
    L67:
        boolean r110 = false;
    L68:
        if (r110 == false) goto L70;
        r3 = true;
        goto L70
    L65:
        if (StringsKt.contains$default(r19, "#", false, 2, null) != true) goto L67;
        r110 = true;
        goto L68
    L44:
        if (r11.getMessageStatusLocal() != 20) goto L53;
        String r20 = r11.getMessageId();
        if (r20 != null) goto L48;
    L50:
        boolean r21 = false;
    L51:
        if (r21 == false) goto L53;
    L48:
        if (StringsKt.contains$default(r20, "#", false, 2, null) != true) goto L50;
        r21 = true;
    L53:
        r17 = false;
        goto L55
    L40:
        r11 = null;
        goto L41
    L83:
        V(r12, r13);
    }

    @Override // bd8.b
    public final void w(Message r74, int r75, ec8.b r76) {
        Intrinsics.checkNotNullParameter(r74, "message");
        Intrinsics.checkNotNullParameter(r74, "message");
        Integer r4 = null;
        if (this.m != null) goto L5;
    L15:
        this.m = r74;
        this.p = Integer.valueOf(r75);
        com.larus.bmhome.chat.component.cvs.y r3 = (com.larus.bmhome.chat.component.cvs.y) this.r.getValue();
        if (r3 == null) goto L19;
        BotModel r5 = r3.j0();
        if (r5 == null) goto L19;
    L23:
        a(r74, r5, true);
        if (r76 == null) goto L26;
        r76.b(this, com.larus.bmhome.chat.list.cell.text.components.middle.a.class);
    L26:
        LinearLayout r6 = this.M;
        if (r6 == null) goto L29;
        ExposureTrackerExtKt.a(r6, new l(this));
    L29:
        this.v = r76;
        FLogger r2 = FLogger.a;
        StringBuilder r7 = new StringBuilder("singAniRun=");
        r7.append(P().k);
        r7.append(" multiAniRun=");
        r7.append(((ThreeLoadingIndicator) this.O.getValue()).h);
        r7.append("    msgId=");
        r7.append(r74.getMessageId());
        r7.append(" , boxHeight=");
        com.larus.bmhome.chat.layout.item.i r1 = this.d;
        if (r1 == null) goto L32;
        r4 = Integer.valueOf(r1.getHeight());
    L32:
        r7.append(r4);
        r7.append(" prefrom data is >>>>");
        r2.i("TextHolder", r7.toString());
        return;
    L19:
        String r8 = r74.getSenderId();
        if (r8 != null) goto L22;
        r8 = "unknown";
    L22:
        r5 = new BotModel(r8, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L23
    L5:
        if (o0.d(r74.getMessageId()) == false) goto L15;
        Message r9 = this.m;
        if (r9 == null) goto L9;
        String r10 = r9.getMessageId();
    L11:
        if (Intrinsics.areEqual(r10, r74.getMessageId()) == true) goto L15;
        String r11 = r74.getMessageId();
        if (r11 == null) goto L15;
        com.larus.bmhome.chat.markdown.imagegroup.c.b(r11);
        goto L15
    L9:
        r10 = null;
        goto L11
    }

    public final void J(com.larus.bmhome.chat.markdown.richtext.i r11, MessageDocPreviewRepository.a r12, Map<CustomMarkdownTextView, ? extends CharSequence> r13, String r14) {
        if (r12.b.isEmpty() == true) goto L5;
    L7:
        Iterator<Map.Entry<CustomMarkdownTextView, ? extends CharSequence>> r15 = r13.entrySet().iterator();
        int r0 = 0;
    L9:
        if (r15.hasNext() == false) goto L16;
        Map.Entry<CustomMarkdownTextView, ? extends CharSequence> r1 = r15.next();
        CustomMarkdownTextView r2 = r1.getKey();
        CharSequence r4 = r1.getValue();
        if (r2.getParent() == null) goto L9;
        int r3 = MessageDocPreviewInlineRenderer.a;
        MessageDocPreviewInlineRenderer.e r5 = MessageDocPreviewInlineRenderer.b(r2, r4, r11, r12.a, r12.b, MessageDocPreviewInlineRenderer.Style.DOWNSTREAM, new y(this));
        if (r5.b <= 0) goto L9;
        r2.setText(r5.a);
        r2.setMovementMethod(new p0(null));
        r0 = r0 + r5.b;
        goto L9
    L16:
        FLogger.a.i("MiddleTextComponent", "bindDownstreamInlineDocPreview source=" + r14 + ", renderCount=" + r0);
        return;
    L5:
        if (r12.a.isEmpty() == false) goto L7;
    }

    public final MarkwonStruct O(Context r9, boolean r10, lw8.d r11, int r12) {
        com.larus.bmhome.chat.layout.widget.handler.w r0 = com.larus.bmhome.chat.layout.widget.handler.w.a;
        fh8.f r1 = this.n;
        r0.getClass();
        Map r2 = com.larus.bmhome.chat.layout.widget.handler.w.a(r1);
        if (r10 == false) goto L9;
        Pair<MarkwonStruct, MarkwonStruct> r3 = this.D;
        if (r3 == null) goto L7;
        MarkwonStruct r4 = (MarkwonStruct) r3.getSecond();
    L8:
        if (r4 != null) goto L9;
    L15:
        gw8.c.a.getClass();
        gw8.c r5 = gw8.c.a.b();
        if (r5 == null) goto L18;
        lw8.h r13 = r5.createCacheMarkwonStruct(r9, Integer.valueOf(r12), r11, r2, r10);
    L20:
        if ((r13 instanceof MarkwonStruct) == false) goto L22;
        MarkwonStruct r14 = (MarkwonStruct) r13;
    L23:
        if (r10 == false) goto L25;
        Pair<MarkwonStruct, MarkwonStruct> r15 = new Pair(null, r14);
    L26:
        this.D = r15;
    L27:
        if (r10 == false) goto L31;
        Pair<MarkwonStruct, MarkwonStruct> r16 = this.D;
        if (r16 == null) goto L34;
        MarkwonStruct r17 = (MarkwonStruct) r16.getSecond();
    L35:
        if (r17 == null) goto L38;
        r17.f = r2;
        return r17;
    L38:
        return null;
    L34:
        r17 = null;
        goto L35
    L31:
        Pair<MarkwonStruct, MarkwonStruct> r18 = this.D;
        if (r18 == null) goto L34;
        r17 = (MarkwonStruct) r18.getFirst();
        goto L35
    L25:
        r15 = new Pair(r14, null);
        goto L26
    L22:
        r14 = null;
        goto L23
    L18:
        r13 = null;
        goto L20
    L7:
        r4 = null;
    L9:
        if (r10 == true) goto L27;
        Pair<MarkwonStruct, MarkwonStruct> r6 = this.D;
        if (r6 == null) goto L13;
        MarkwonStruct r7 = (MarkwonStruct) r6.getFirst();
    L14:
        if (r7 != null) goto L27;
    L13:
        r7 = null;
        goto L14
    }

    @Override // bd8.b
    public final List<View> x(int r2, Context r3, BaseMessageListCell<?> r4, com.larus.bmhome.chat.layout.item.i r5, q0 r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.x(r2, r3, r4, r5, r6, r7);
        LinearLayout r8 = new LinearLayout(r3);
        r8.setOrientation(1);
        this.M = r8;
        if (r5 == null) goto L5;
        r5.addView(r8, r2, new LinearLayout.LayoutParams(-2, -2));
    L5:
        r8.setClipToPadding(false);
        ((wg8.f) this.E.getValue()).a = r4;
        wg8.c r9 = this.Q;
        r9.a = r4;
        r9.b = r5;
        return CollectionsKt.listOf(r8);
    }
}
