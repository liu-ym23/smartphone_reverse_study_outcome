package com.ss.android.lark.chatwindow.view.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import b3b.t;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.c1;
import com.ss.android.lark.chat.utils.f0;
import com.ss.android.lark.chat.utils.o1;
import com.ss.android.lark.chat.utils.s;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.RenderRouterEntity;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.WidthMode;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.statistics.chat.l;
import com.ss.android.lark.statistics.chat.m;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import z5c.j0;
import z5c.p3;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UrlPreviewBinder implements com.ss.android.lark.chatwindow.view.preview.c<b, h2b.c> {
    public final Context a;
    public final View.OnLongClickListener b;
    public final f2b.a c;
    public final m2b.a d;
    public final t e;
    public final Lazy f;
    public final boolean g;
    public c h;

    public static final class a {
    }

    public static final class b extends com.ss.android.lark.chatwindow.view.preview.c.a {
        public b(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public interface c {
        boolean a(LKUIRoundableLayout r1, PreviewHangPoint r2);
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final int getPreviewType() {
        return 4;
    }

    public static boolean g(y6b.a r1) {
        if ((r1 instanceof y6b.c) == false) goto L9;
        y6b.c r2 = (y6b.c) r1;
        if (r2.Y() == false) goto L7;
    L8:
        return true;
    L7:
        if (r2.Z() == true) goto L8;
    L9:
        return false;
    }

    public static void h(PreviewHangPoint r15) {
        int r0 = i.a;
        ConcurrentHashMap<Integer, Long> r1 = o1.a;
        Long r2 = o1.a(r15.getPreviewId());
        if (r2 != null) goto L5;
        Log.i("[URLPreview]BuryPointUtil", "messageOnScreenTime is null ,card not from 0 to 1,previewId:" + r15.getPreviewId());
        return;
    L5:
        long r8 = System.currentTimeMillis();
        boolean r10 = true;
        if (r15.isLazyLoad() != true) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        com.ss.android.lark.statistics.chat.g r4 = new com.ss.android.lark.statistics.chat.g("1");
    L12:
        s5c.d r5 = i.a(s5c.d.b.b(new com.ss.android.lark.statistics.chat.j(), r4), r15.getPreviewId(), r15.getUrl(), r2.longValue(), r8);
        UrlCardPreviewEntity r6 = r15.getUrlCardPreviewEntity();
        Long r7 = null;
        if (r6 == null) goto L15;
        UrlPreviewBody r9 = r6.getPreviewBody();
    L16:
        if (r9 == null) goto L22;
        Map<String, UrlPreviewState> r11 = r9.getStates();
        if (r11 == null) goto L22;
        UrlPreviewState r12 = r11.get(r9.getCurrentStateId());
        if (r12 == null) goto L22;
        String r13 = r12.getTemplateId();
    L23:
        if (r13 != null) goto L25;
    L28:
        boolean r14 = true;
    L29:
        if (r14 == true) goto L40;
        UrlPreviewTemplate r16 = r9.getTemplates().get(r13);
        if (r16 == null) goto L35;
        Map<String, UrlPreviewComponent> r17 = r16.getElements();
        if (r17 == null) goto L35;
        int r18 = r17.size();
    L36:
        r5 = r5.plus(new com.ss.android.lark.statistics.chat.d(String.valueOf(r18)));
        if (r9.getUrlPreviewComponents() != null) goto L40;
        r5 = r5.plus(new com.ss.android.lark.statistics.chat.k(r13));
    L35:
        r18 = 0;
    L40:
        if (r6 != null) goto L42;
    L44:
        boolean r19 = false;
    L46:
        if (r19 == false) goto L49;
        com.ss.android.lark.statistics.chat.e r20 = new com.ss.android.lark.statistics.chat.e("none");
    L53:
        s5c.d r21 = r5.plus(r20);
        if (r9 != null) goto L56;
    L58:
        r10 = false;
    L59:
        if (r10 == false) goto L62;
        m r22 = new m("none");
    L65:
        s5c.d r23 = r21.plus(r22).plus(new l(String.valueOf(r8 - r2.longValue())));
        Lazy r24 = ChatHitPointNew.a;
        Intrinsics.checkNotNullParameter(r23, "param");
        JSONObject r25 = r23.plus(ChatParamUtils.e()).toJson();
        ChatHitPointNew.d().sendEvent("url_preview_card_render_dev", r25);
        Log.d("[URLPreview]", "CARD CARD CARD CARD,paramJson:" + r25);
        o1.b(r15.getPreviewId() + BrowserDependency.UrlClickType.CARD, Long.valueOf(System.currentTimeMillis()));
        return;
    L62:
        if (r9 == null) goto L64;
        r7 = Long.valueOf(r9.getUiRenderTime());
    L64:
        r22 = new m(String.valueOf(r7));
        goto L65
    L56:
        if (r9.getUiRenderTime() != 0) goto L58;
    L49:
        if (r6 == null) goto L51;
        Long r26 = Long.valueOf(r6.getComponentTreeTime());
    L52:
        r20 = new com.ss.android.lark.statistics.chat.e(String.valueOf(r26));
        goto L53
    L51:
        r26 = null;
        goto L52
    L42:
        if (r6.getComponentTreeTime() != 0) goto L44;
        r19 = true;
        goto L46
    L25:
        if (r13.length() == 0) goto L28;
        r14 = false;
    L22:
        r13 = null;
        goto L23
    L15:
        r9 = null;
        goto L16
    L11:
        r4 = new com.ss.android.lark.statistics.chat.g(DocTabPayload.DocType.UNKNOWN);
        goto L12
    L8:
        r3 = false;
        goto L9
    }

    public final int e(y6b.a<v5b.a<?>> r10) {
        m2b.a r0 = this.d;
        y6b.c r1 = null;
        if (r0 == null) goto L7;
        lya.a r2 = r0.l();
        if (r2 == null) goto L7;
        Integer r4 = r2.a();
    L8:
        boolean r3 = true;
        boolean r5 = false;
        if (d.a[r10.getType().ordinal()] != 1) goto L65;
        Context r6 = this.a;
        m2b.a r7 = this.d;
        if (r7 != null) goto L13;
    L15:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L22;
        int r11 = u2b.j.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        int r12 = u2b.j.n(r6, r4) - (u2b.j.f * 2);
        int r9 = u2b.j.m;
    L19:
        int r13 = r9 * 2;
    L20:
        int r14 = r12 - r13;
    L107:
        return r14;
    L22:
        m2b.a r15 = this.d;
        if (r15 != null) goto L25;
    L27:
        boolean r16 = false;
    L28:
        if (r16 == true) goto L30;
    L32:
        m2b.a r17 = this.d;
        if (r17 != null) goto L35;
    L37:
        boolean r18 = false;
    L38:
        if (r18 == false) goto L40;
        int r19 = u2b.j.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        r12 = (u2b.j.n(r6, r4) - (u2b.j.g * 2)) - (u2b.j.m * 2);
        r13 = u2b.j.n;
        goto L20
    L40:
        m2b.a r20 = this.d;
        if (r20 != null) goto L43;
    L45:
        r3 = false;
    L46:
        if (r3 == false) goto L64;
        boolean r21 = r10 instanceof y6b.c;
        if (r21 == true) goto L50;
        r14 = u2b.j.h(r6, false, r4);
        goto L107
    L50:
        y6b.c r110 = (y6b.c) r10;
        if (r110.Y() == false) goto L58;
        int r22 = u2b.j.a;
        if (r21 == false) goto L55;
        r1 = r110;
    L55:
        if (r1 == null) goto L57;
        r5 = r1.V1;
    L57:
        r14 = u2b.j.h(r6, r5, r4);
        goto L107
    L58:
        int r23 = u2b.j.a;
        if (r21 == false) goto L61;
        r1 = r110;
    L61:
        if (r1 == null) goto L63;
        r5 = r1.V1;
    L63:
        r14 = u2b.j.g(r6, r5, r4);
        goto L107
    L64:
        int r24 = u2b.j.a;
        r14 = u2b.j.c(r6, r4, s.c(r10));
        goto L107
    L43:
        if (r20.Y() != true) goto L45;
    L35:
        if (r17.q() != true) goto L37;
        r18 = true;
        goto L38
    L30:
        if (this.d.q() == true) goto L32;
        int r111 = u2b.j.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        r12 = u2b.j.n(r6, r4) - (u2b.j.g * 2);
        r9 = u2b.j.m;
        goto L19
    L25:
        if (r15.r() != true) goto L27;
        r16 = true;
        goto L28
    L13:
        if (r7.m() != true) goto L15;
        r8 = true;
        goto L17
    L65:
        int r25 = c1.a;
        if (c1.a(r10, this.d, null) == true) goto L68;
    L83:
        m2b.a r26 = this.d;
        if (r26 == null) goto L111;
        o3b.a r27 = r26.H8();
        if (r27 == null) goto L112;
        Context r28 = this.a;
        boolean r29 = g(r10);
        boolean r30 = r10 instanceof y6b.c;
        if (r30 == false) goto L90;
        y6b.c r31 = (y6b.c) r10;
    L91:
        if (r31 == null) goto L93;
        boolean r32 = r31.V1;
    L95:
        if (this.d.m() == false) goto L97;
    L104:
        boolean r112 = false;
    L106:
        return r27.b(r28, r4, r29, r32, r112);
    L97:
        if (this.d.Y() == true) goto L99;
    L101:
        if (r30 == false) goto L103;
        r1 = (y6b.c) r10;
    L103:
        r112 = q7b.c.a(r1, this.d);
        goto L106
    L99:
        if (g(r10) == false) goto L101;
    L93:
        r32 = false;
        goto L95
    L90:
        r31 = null;
        goto L91
    L112:
        return 0;
    L111:
        return 0;
    L68:
        if (r10.d() == true) goto L83;
        m2b.a r33 = this.d;
        if (r33 == null) goto L108;
        o3b.a r34 = r33.H8();
        if (r34 == null) goto L109;
        Context r35 = this.a;
        boolean r36 = g(r10);
        boolean r37 = r10 instanceof y6b.c;
        if (r37 == false) goto L76;
        y6b.c r38 = (y6b.c) r10;
    L77:
        if (r38 == null) goto L79;
        boolean r39 = r38.V1;
    L80:
        if (r37 == false) goto L110;
        r1 = (y6b.c) r10;
    L110:
        return r34.d(r35, r4, r36, r39, q7b.c.a(r1, this.d));
    L79:
        r39 = false;
        goto L80
    L76:
        r38 = null;
        goto L77
    L109:
        return 0;
    L108:
        return 0;
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final /* bridge */ /* synthetic */ void a(h2b.a r1, com.ss.android.lark.chatwindow.view.preview.c.a r2) {
        c((h2b.c) r1, (b) r2);
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.c
    public final com.ss.android.lark.chatwindow.view.preview.c.a b(h2b.a r1, ViewGroup r2) {
        h2b.c r3 = (h2b.c) r1;
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new b(r2);
    }

    public final void c(h2b.c r18, b r19) {
        if (r18 == null) goto L121;
        Map<String, PreviewHangPoint> r1 = r18.a;
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L121;
        if (r19 == null) goto L15;
        ViewGroup r3 = r19.a;
    L16:
        if (r3 == null) goto L121;
        ViewGroup r10 = r19.a;
        r10.setVisibility(0);
        Map<String, PreviewHangPoint> r0 = r18.a;
        j6b.k r4 = j6b.k.b;
        String r11 = BuildConfig.FLAVOR;
        if (r0 != null) goto L21;
        LinkedHashMap r12 = null;
    L36:
        int r13 = r18.d.size();
        int r5 = 0;
        int r14 = 0;
        int r15 = 0;
    L38:
        if (r14 >= r13) goto L60;
        if (r15 > 3) goto L60;
        String r6 = (String) ListProtector.get(r18.d, r14);
        if (r12 == null) goto L59;
        PreviewHangPoint r7 = (PreviewHangPoint) r12.get(r6);
        if (r7 == null) goto L59;
        com.ss.android.lark.storage.kv.repo.a r8 = h6b.f.a();
        String r9 = r7.getPreviewId();
        if (r9 != null) goto L50;
        r9 = BuildConfig.FLAVOR;
    L50:
        if (r8.getBoolean(r9, false) == false) goto L54;
        r15 = r15 + 1;
        View r16 = r10.getChildAt(r15 - 1);
        if (r16 == null) goto L59;
        r16.setVisibility(8);
        goto L59
    L54:
        int r17 = r5 + 1;
        if (r7.isValidCardData() == false) goto L58;
        f(r10, r7, r18, r15, r15);
        r15 = r15 + 1;
    L58:
        r5 = r17;
    L59:
        r14 = r14 + 1;
    L60:
        r10.setTag(2131388118, Integer.valueOf(r5));
        if (r15 != 0) goto L94;
        if (r12 != null) goto L64;
    L66:
        boolean r20 = false;
    L67:
        if (r20 == false) goto L94;
        PreviewHangPoint r21 = (PreviewHangPoint) ListProtector.get(CollectionsKt.toMutableList(r12.values()), 0);
        if (r18.e == true) goto L79;
        String r22 = r21.getPreviewId();
        if (r22 != null) goto L73;
    L75:
        boolean r23 = false;
    L76:
        if (r23 == true) goto L79;
        r10.setVisibility(8);
        return;
    L73:
        if (StringsKt.startsWith$default(r22, "URLPreview", false, 2, null) != true) goto L75;
        r23 = true;
    L79:
        com.ss.android.lark.storage.kv.repo.a r24 = h6b.f.a();
        String r25 = r21.getMessageId();
        if (r25 != null) goto L83;
        r25 = BuildConfig.FLAVOR;
    L83:
        if (r24.getBoolean(r25, false) == true) goto L92;
        com.ss.android.lark.storage.kv.repo.a r26 = h6b.f.a();
        String r27 = r21.getPreviewId();
        if (r27 == null) goto L89;
        r11 = r27;
    L89:
        if (r26.getBoolean(r11, false) == true) goto L92;
        int r28 = 8;
        f(r10, r21, r18, r15, r15);
        r15 = r15 + 1;
    L96:
        if (r15 >= r10.getChildCount()) goto L105;
        int r29 = r10.getChildCount();
        if (r15 > r29) goto L105;
    L99:
        View r30 = r10.getChildAt(r15);
        if (r30 == null) goto L102;
        r30.setVisibility(r28);
    L102:
        if (r15 == r29) goto L105;
        r15 = r15 + 1;
    L105:
        if (this.g == true) goto L107;
        Iterator r31 = ViewGroupKt.getChildren(r10).iterator();
        int r32 = 8;
    L111:
        if (r31.hasNext() == false) goto L118;
        if (((View) r31.next()).getVisibility() != 0) goto L115;
        boolean r33 = true;
    L116:
        if (r33 == false) goto L111;
        r32 = 0;
        goto L111
    L115:
        r33 = false;
        goto L116
    L118:
        r10.setVisibility(r32);
        return;
    L107:
        if (r10.getChildCount() != 0) goto L141;
        r10.setVisibility(r28);
        return;
    L141:
        return;
    L92:
        r10.setVisibility(8);
        return;
    L64:
        if (r12.size() != 1) goto L66;
        r20 = true;
    L94:
        r28 = 8;
        goto L96
    L21:
        Collection<PreviewHangPoint> r34 = r0.values();
        LinkedHashMap r35 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r34, 10)), 16));
        Iterator<T> r36 = r34.iterator();
    L23:
        if (r36.hasNext() == false) goto L28;
        Object r37 = r36.next();
        String r38 = ((PreviewHangPoint) r37).getPreviewId();
        if (r38 != null) goto L27;
        r38 = BuildConfig.FLAVOR;
    L27:
        r35.put(r38, r37);
        goto L23
    L28:
        Collection r39 = r35.values();
        LinkedHashMap r40 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r39, 10)), 16));
        Iterator r41 = r39.iterator();
    L30:
        if (r41.hasNext() == false) goto L35;
        Object r42 = r41.next();
        String r43 = ((PreviewHangPoint) r42).getHangPointId();
        if (r43 != null) goto L34;
        r43 = BuildConfig.FLAVOR;
    L34:
        r40.put(r43, r42);
        goto L30
    L35:
        r12 = r40;
        goto L36
    L15:
        r3 = null;
        goto L16
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
    }

    public final bdb.a d(int r5, t6c.d r6) {
        m2b.a r7 = this.d;
        com.ss.android.lark.chat.chatwindow.chat.message.actionimpl.a r0 = null;
        Chat r1 = null;
        if (r7 == null) goto L5;
        FragmentActivity r8 = r7.getContext();
    L6:
        if (r8 == null) goto L11;
        Scene r2 = Scene.Chat;
        m2b.a r3 = this.d;
        if (r3 == null) goto L10;
        r1 = r3.getChat();
    L10:
        r0 = new com.ss.android.lark.chat.chatwindow.chat.message.actionimpl.a(r8, r2, r1);
    L11:
        bdb.a.c r9 = new bdb.a.c();
        if (r0 == null) goto L14;
        Intrinsics.checkNotNullParameter(mya.a.class, "actionHandlerApiClass");
        Intrinsics.checkNotNullParameter(r0, "handlerImpl");
        r9.a.put(mya.a.class, r0);
    L14:
        bdb.a.C0012a r4 = new bdb.a.C0012a();
        r4.a = this.b;
        r4.b = r9;
        r4.c = new vcb.c(r6);
        return new bdb.a(r4);
    L5:
        r8 = null;
        goto L6
    }

    public UrlPreviewBinder(Context r2, View.OnLongClickListener r3, f2b.a r4, m2b.a r5, t r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "modelProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = LazyKt.lazy(UrlPreviewBinder$isDisableNoFlashBind$2.INSTANCE);
        this.g = ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.fix.close_preview_bubble_height");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(ViewGroup r20, PreviewHangPoint r21, h2b.c r22, int r23, int r24) {
        if (r24 >= 0) goto L5;
    L13:
        LKUIRoundableLayout r4 = new LKUIRoundableLayout(r20.getContext(), null, 6, 0);
    L14:
        if (r4 != null) goto L16;
        r4 = new LKUIRoundableLayout(r20.getContext(), null, 6, 0);
    L16:
        r4.setOnClickListener(new h(this, r21, r4));
        r4.setOnLongClickListener(this.b);
        m2b.a r5 = this.d;
        if (r5 != null) goto L19;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == true) goto L31;
        m2b.a r7 = this.d;
        if (r7 != null) goto L27;
    L29:
        boolean r8 = false;
    L30:
        if (r8 == true) goto L31;
        if (this.c.g().e() == false) goto L35;
        float r9 = 10.0f;
    L36:
        r4.setRadius(r9);
        y6b.a r10 = this.c.g();
        if (r10.getType() != Message.Type.FILE) goto L39;
        Integer r11 = 2131103351;
    L115:
        if (r11 == null) goto L117;
        r4.setBorderColor(UDColorUtils.getColor(r4.getContext(), r11.intValue()));
        r4.setBorderWidth(1.0f);
    L118:
        r4.setId(2131382951);
        if (r20.indexOfChild(r4) == (-1)) goto L121;
        boolean r12 = true;
    L122:
        if (r12 == true) goto L124;
        r20.addView(r4);
    L124:
        xcb.b r1 = r22.c.get(r21.getPreviewId());
        if (r1 == null) goto L127;
        t6c.d r2 = r1.b;
    L128:
        g r13 = new g(r22, this);
        if (r2 == null) goto L158;
        q6c.b r3 = r2.a;
        if ((r3 instanceof q6c.b) == false) goto L133;
        q6c.b r14 = r3;
    L134:
        if (r14 == null) goto L136;
        r6c.a r15 = ((q6c.a) r14).a;
    L138:
        if ((r15 instanceof vcb.d) == false) goto L141;
        vcb.d r16 = (vcb.d) r15;
    L141:
        if ((r3 instanceof com.ss.android.lark.chat.preview.components.c) == false) goto L145;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.chat.preview.components.FrameLayoutComponent");
        if ((((q6c.a) ((com.ss.android.lark.chat.preview.components.c) r3)).a instanceof vcb.d) == false) goto L145;
        com.ss.android.lark.chat.preview.components.c r17 = r2.a;
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.ss.android.lark.chat.preview.components.FrameLayoutComponent");
        r6c.a r18 = ((q6c.a) r17).a;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.ss.android.lark.export.dependency.UrlPreviewDependency");
        vcb.d r19 = (vcb.d) r18;
        r19.c = r13;
        r19.f = ((Boolean) this.f.getValue()).booleanValue();
    L145:
        wcb.a r25 = r2.a;
        if ((r25 instanceof wcb.a) == false) goto L150;
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type com.ss.android.lark.export.empty.EmptyLayoutComponent");
        if ((((q6c.a) r25).a instanceof vcb.d) == false) goto L150;
        wcb.a r26 = r2.a;
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type com.ss.android.lark.export.empty.EmptyLayoutComponent");
        r6c.a r27 = ((q6c.a) r26).a;
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type com.ss.android.lark.export.dependency.UrlPreviewDependency");
        vcb.d r28 = (vcb.d) r27;
        r28.f = ((Boolean) this.f.getValue()).booleanValue();
        r28.e = d(e(this.c.g()), r2);
    L150:
        long r110 = System.currentTimeMillis();
        r2.a(r4);
        r2.f();
        ConcurrentHashMap<Integer, Long> r29 = o1.a;
        if (o1.a(r21.getPreviewId() + BrowserDependency.UrlClickType.CARD) != null) goto L233;
        UrlCardPreviewEntity r30 = r21.getUrlCardPreviewEntity();
        if (r30 == null) goto L157;
        UrlPreviewBody r31 = r30.getPreviewBody();
        if (r31 == null) goto L157;
        r31.setUiRenderTime(System.currentTimeMillis() - r110);
    L157:
        h(r21);
        h6b.g.b.b(r21.getUrlCardPreviewEntity(), "[URLPreview] create cardPreview");
    L233:
        p7b.a r32 = p7b.a.a;
        if (r21.isMessageLink() == true) goto L237;
        r32 = null;
    L237:
        int r33 = s5b.a.a;
        r4.setTag(2131365563, r32);
        int r34 = c1.a;
        if (c1.a(this.c.g(), this.d, null) == false) goto L240;
        float[] r35 = f0.b(this.c.g());
        int r36 = 0;
        r4.setRadius(r35[0], r35[1], r35[2], r35[3]);
    L242:
        if (r4.getLayoutParams() == null) goto L247;
        if ((r4.getLayoutParams() instanceof LinearLayout.LayoutParams) == true) goto L247;
        r4.setLayoutParams(new LinearLayout.LayoutParams(r4.getLayoutParams()));
    L247:
        if (r21.isMessageLink() == false) goto L249;
        r4.setLayoutParams(new LinearLayout.LayoutParams(r4.getLayoutParams().width, -2));
    L249:
        ViewGroup.LayoutParams r37 = r4.getLayoutParams();
        if ((r37 instanceof ViewGroup.MarginLayoutParams) == false) goto L252;
        ViewGroup.MarginLayoutParams r38 = (ViewGroup.MarginLayoutParams) r37;
    L253:
        if (r38 == null) goto L257;
        if (r23 <= 0) goto L256;
        r36 = UIHelper.dp2px(8.0f);
    L256:
        r38.topMargin = r36;
    L257:
        f2b.a r39 = this.c;
        int r40 = i.a;
        Intrinsics.checkNotNullParameter(r21, "previewHangPoint");
        Intrinsics.checkNotNullParameter(r39, "modelProvider");
        HashMap r41 = new HashMap();
        String r42 = r21.getUrl();
        Object r43 = "none";
        if (r42 != null) goto L260;
        r42 = "none";
    L260:
        r41.put("url_domain_path", r42);
        String r44 = r21.getPreviewId();
        if (r44 != null) goto L263;
        r44 = "none";
    L263:
        r41.put("url_id", r44);
        UrlCardPreviewEntity r45 = r21.getUrlCardPreviewEntity();
        if (r45 == null) goto L266;
        r41.put(Keys.API_RETURN_KEY_VERSION, String.valueOf(r45.getInlineEntity().getVersion()));
    L266:
        String r46 = r39.getChatId();
        y6b.a r47 = r39.g();
        Lazy r48 = ChatHitPointNew.a;
        Map<String, Object> r49 = ChatParamUtils.f(r46);
        if (r49 == null) goto L281;
        JSONObject r50 = new JSONObject(r49);
        if ((r47 instanceof y6b.c) == false) goto L275;
        Iterator r51 = ChatParamUtils.i((y6b.c) r47).entrySet().iterator();
    L273:
        if (r51.hasNext() == false) goto L275;
        Map.Entry r52 = (Map.Entry) r51.next();
        r50.put((String) r52.getKey(), r52.getValue());
    L275:
        Iterator r53 = r41.entrySet().iterator();
    L277:
        if (r53.hasNext() == false) goto L279;
        Map.Entry r54 = (Map.Entry) r53.next();
        r50.put((String) r54.getKey(), r54.getValue());
        goto L277
    L279:
        ChatHitPointNew.d().sendEvent("im_url_render_view", r50);
    L281:
        if (this.c.g().getType() != Message.Type.FILE) goto L284;
        MessageHitPoint r55 = MessageHitPoint.a;
        r55.getClass();
        s5c.a r56 = r.T1;
        s5c.a r57 = p3.c;
        r56.getClass();
        r55.a().sendEvent("im_chat_excel_show_click", s5c.d.b.b(r56, r57).plus(j0.c).toJson());
    L284:
        if (r21.isMessageLink() == false) goto L326;
        Map<String, MessageLink> r58 = this.c.g().z();
        if (r58 == null) goto L294;
        UrlCardPreviewEntity r59 = r21.getUrlCardPreviewEntity();
        if (r59 == null) goto L292;
        UrlInlinePreviewEntity r60 = r59.getInlineEntity();
        if (r60 == null) goto L292;
        String r61 = r60.getPreviewId();
    L293:
        MessageLink r62 = r58.get(r61);
    L295:
        m2b.a r63 = this.d;
        if (r63 == null) goto L298;
        String r64 = r63.getChatId();
    L299:
        String r65 = r21.getMessageId();
        if (r62 == null) goto L327;
        HashMap r66 = new HashMap();
        r66.put("occasion", "chat");
        if (r64 != null) goto L305;
        r64 = "none";
    L305:
        r66.put("occasion_id", r64);
        if (r65 != null) goto L308;
        r65 = "none";
    L308:
        r66.put("msg_id", r65);
        r66.put("root_msg_cnt", Integer.valueOf(r62.entity_ids.size()));
        MessageLink.MetaInfo r67 = r62.meta_info;
        if (r67 == null) goto L314;
        Object r68 = r67.from_chat_id;
        if (r68 == null) goto L314;
        r43 = r68;
    L314:
        r66.put("root_chat_id", r43);
        r66.put("root_msg_id", h6b.g.b.a(r62.entity_ids));
        Intrinsics.checkNotNullParameter(r66, "extraParams");
        Map<String, Object> r69 = ChatParamUtils.e();
        if (r69 == null) goto L328;
        JSONObject r70 = new JSONObject(r69);
        Iterator r71 = r66.entrySet().iterator();
    L319:
        if (r71.hasNext() == false) goto L321;
        Map.Entry r72 = (Map.Entry) r71.next();
        r70.put((String) r72.getKey(), r72.getValue());
        goto L319
    L321:
        ChatHitPointNew.d().sendEvent("im_msg_link_card_view", r70);
        return;
    L328:
        return;
    L327:
        return;
    L298:
        r64 = null;
    L292:
        r61 = null;
        goto L293
    L294:
        r62 = null;
        goto L295
    L326:
        return;
    L252:
        r38 = null;
        goto L253
    L240:
        r36 = 0;
        goto L242
    L136:
        r15 = null;
        goto L138
    L133:
        r14 = null;
        goto L134
    L158:
        UrlCardPreviewEntity r73 = r21.getUrlCardPreviewEntity();
        if (r73 == null) goto L163;
        UrlPreviewBody r74 = r73.getPreviewBody();
        if (r74 == null) goto L163;
        String r75 = r74.getCurrentStateId();
    L165:
        if (r21.getUrlCardPreviewEntity() == null) goto L233;
        UrlCardPreviewEntity r111 = r21.getUrlCardPreviewEntity();
        Intrinsics.checkNotNull(r111);
        r111.getInlineEntity();
        int r112 = e(this.c.g());
        int r113 = edb.c.a;
        Context r114 = this.a;
        RenderRouterEntity r115 = r111.getRenderRouterEntity();
        if (r115 == null) goto L170;
        WidthMode r116 = r115.getWidthMode();
    L171:
        int r117 = RangesKt.coerceAtMost(r112, edb.c.b(r114, r116));
        UrlInlinePreviewEntity r118 = r111.getInlineEntity();
        boolean r76 = StringsKt.startsWith(r118.getPreviewId(), "URLPreview", true);
        y6b.a r119 = this.c.g();
        if ((r119 instanceof y6b.c) == false) goto L174;
        String r77 = ChatParamUtils.a;
        Map r78 = ChatParamUtils.i((y6b.c) r119);
    L175:
        Map<String, ? extends Object> r79 = MapsKt.toMutableMap(r78);
        r79.putAll(ChatHitPointNew.a(r119));
        m2b.a r80 = this.d;
        if (r80 == null) goto L180;
        Chat r81 = r80.getChat();
        if (r81 == null) goto L180;
        String r82 = r81.getId();
    L181:
        m2b.a r83 = this.d;
        if (r83 == null) goto L186;
        Chat r84 = r83.getChat();
        if (r84 == null) goto L186;
        String r85 = r84.getName();
    L187:
        Map<String, MessageLink> r120 = r119.z();
        if (r120 == null) goto L190;
        MessageLink r121 = r120.get(r118.getPreviewId());
    L190:
        int r122 = e(r119);
        Context r123 = this.a;
        RenderRouterEntity r124 = r111.getRenderRouterEntity();
        if (r124 == null) goto L193;
        WidthMode r125 = r124.getWidthMode();
    L194:
        RangesKt.coerceAtMost(r122, edb.c.b(r123, r125));
        URLPreviewParams.a r126 = new URLPreviewParams.a();
        r126.a = r118.getPreviewId();
        r126.b = r76;
        Url r86 = r118.getUrl();
        if (r86 == null) goto L197;
        String r87 = r86.getUrl();
    L198:
        r126.c = r87;
        r126.d = this.c.isGroup();
        Intrinsics.checkNotNullParameter(r79, "messageParams");
        r126.e = r79;
        r126.f = r82;
        r126.g = r85;
        r126.h = r118.getSourceId();
        UrlInlinePreviewEntity.AppInfo r88 = r118.getAppInfo();
        if (r88 == null) goto L201;
        Long r89 = r88.getAppId();
    L202:
        r126.i = r89;
        UrlInlinePreviewEntity.AppInfo r90 = r118.getAppInfo();
        if (r90 == null) goto L205;
        Long r91 = r90.getSceneType();
    L206:
        r126.j = r91;
        r126.k = Boolean.valueOf(r119.e());
        MessageEditInfo r92 = r119.u();
        if (r92 == null) goto L209;
        boolean r93 = r92.isEdited();
    L210:
        r126.l = r93;
        r126.m = new vcb.c(null);
        URLPreviewParams r127 = new URLPreviewParams(r126);
        Context r128 = this.a;
        m2b.a r94 = this.d;
        if (r94 == null) goto L217;
        Fragment r95 = r94.R();
        if (r95 == null) goto L217;
        LiveData r96 = r95.getViewLifecycleOwnerLiveData();
        if (r96 == null) goto L217;
        LifecycleOwner r129 = (LifecycleOwner) r96.getValue();
    L218:
        vcb.d r97 = new vcb.d(r128, r129, r13, r127, null, ((Boolean) this.f.getValue()).booleanValue());
        com.ss.android.lark.chat.preview.creator.a r98 = new com.ss.android.lark.chat.preview.creator.a(r97, this.b);
        long r130 = System.currentTimeMillis();
        q6c.b r99 = r98.c(r111, r75);
        long r131 = System.currentTimeMillis();
        r111.setComponentTreeTime(r131 - r130);
        t6c.d r100 = com.ss.android.lark.chat.preview.creator.a.a(r4, r99, r117);
        if (r100 == null) goto L224;
        Map<String, xcb.b> r101 = r22.c;
        String r102 = r21.getPreviewId();
        if (r102 != null) goto L223;
        r102 = BuildConfig.FLAVOR;
    L223:
        xcb.b r103 = r101.put(r102, new xcb.b(r111, r100));
    L224:
        r97.e = d(r117, r100);
        if (r100 == null) goto L227;
        r100.a(r4);
        r100.f();
    L227:
        ConcurrentHashMap<Integer, Long> r104 = o1.a;
        if (o1.a(r21.getPreviewId() + BrowserDependency.UrlClickType.CARD) != null) goto L233;
        UrlPreviewBody r105 = r111.getPreviewBody();
        if (r105 == null) goto L232;
        r105.setUiRenderTime(System.currentTimeMillis() - r131);
    L232:
        h(r21);
        h6b.g.b.b(r21.getUrlCardPreviewEntity(), "[URLPreview] create cardPreview");
    L217:
        r129 = null;
        goto L218
    L209:
        r93 = false;
        goto L210
    L205:
        r91 = null;
        goto L206
    L201:
        r89 = null;
        goto L202
    L197:
        r87 = null;
        goto L198
    L193:
        r125 = null;
    L186:
        r85 = null;
    L180:
        r82 = null;
        goto L181
    L174:
        r78 = new HashMap();
        goto L175
    L170:
        r116 = null;
    L163:
        r75 = null;
        goto L165
    L127:
        r2 = null;
        goto L128
    L121:
        r12 = false;
        goto L122
    L117:
        r4.setBorderColor(0);
        r4.setBorderWidth(0.0f);
        goto L118
    L39:
        boolean r132 = ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.messenger.url_card");
        int r133 = c1.a;
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r134 = m3b.a.a;
        Intrinsics.checkNotNullParameter(r10, "vo");
        Intrinsics.checkNotNullParameter(r10, "vo");
        if (r10.e() == true) goto L42;
        Log.i("SingleUrlCardModeDecider", "not single url");
    L60:
        UrlPreviewEntity.SingleCardMode r135 = null;
    L62:
        if (r135 != null) goto L64;
    L69:
        Log.i("SingleUrlCardModeDecider", "singleCardMode=" + r135 + ", needShowSingleCard=" + r132);
        boolean r136 = r10.e();
        if (r132 == false) goto L73;
        if (r136 == false) goto L73;
        boolean r137 = true;
    L74:
        boolean r138 = r10.c();
        if (r137 == true) goto L78;
        if (r138 == false) goto L78;
        r11 = 2131109341;
    L78:
        m2b.a r139 = this.d;
        if (r139 == null) goto L81;
        boolean r140 = r139.m();
    L82:
        m2b.a r141 = this.d;
        if (r141 == null) goto L85;
        boolean r142 = r141.Y();
    L86:
        m2b.a r143 = this.d;
        if (r143 != null) goto L89;
    L91:
        boolean r144 = false;
    L92:
        if (r140 == true) goto L114;
        if (r142 == true) goto L114;
        if (r144 == true) goto L114;
        String r145 = r10.i();
        if (r145 != null) goto L99;
    L101:
        boolean r146 = false;
    L102:
        MessageEditInfo r106 = r10.u();
        if (r106 != null) goto L105;
    L107:
        boolean r107 = false;
    L108:
        if (r137 == false) goto L113;
        if (r146 == true) goto L113;
        if (r107 == true) goto L113;
        r11 = null;
    L113:
        r11 = 2131109340;
        goto L115
    L105:
        if (r106.isEdited() != true) goto L107;
        r107 = true;
        goto L108
    L99:
        if (r145.length() <= 0) goto L101;
        r146 = true;
    L114:
        r11 = 2131109341;
        goto L115
    L89:
        if (r143.r() != true) goto L91;
        r144 = true;
        goto L92
    L85:
        r142 = false;
        goto L86
    L81:
        r140 = false;
    L73:
        r137 = false;
        goto L74
    L64:
        if (r135 == UrlPreviewEntity.SingleCardMode.AUTO) goto L69;
        if (r135 != UrlPreviewEntity.SingleCardMode.INLINE_NOT_DISPLAY) goto L68;
        r132 = true;
        goto L69
    L68:
        r132 = false;
        goto L69
    L42:
        T r147 = r10.b();
        if ((r147 instanceof BaseTextContentVO) == false) goto L45;
        BaseTextContentVO r148 = (BaseTextContentVO) r147;
    L46:
        if (r148 == null) goto L60;
        Map<String, PreviewHangPoint> r149 = r148.C;
        if (r149.size() == 1) goto L51;
        Log.i("SingleUrlCardModeDecider", "previewHangPoints size not 1");
        goto L60
    L51:
        PreviewHangPoint r150 = (PreviewHangPoint) CollectionsKt.firstOrNull(r149.values());
        if (r150 != null) goto L54;
        Log.i("SingleUrlCardModeDecider", "hangPoint is null");
        goto L60
    L54:
        UrlCardPreviewEntity r151 = r150.getUrlCardPreviewEntity();
        if (r151 == null) goto L57;
        UrlInlinePreviewEntity r152 = r151.getInlineEntity();
    L58:
        if (r152 != null) goto L61;
        Log.i("SingleUrlCardModeDecider", "inlineEntity is null");
        goto L60
    L61:
        r135 = r152.getSingleCardMode();
        goto L62
    L57:
        r152 = null;
        goto L58
    L45:
        r148 = null;
        goto L46
    L35:
        r9 = 6.0f;
        goto L36
    L27:
        if (r7.Y() != true) goto L29;
        r8 = true;
    L31:
        r9 = 8.0f;
        goto L36
    L19:
        if (r5.m() != true) goto L21;
        r6 = true;
        goto L22
    L5:
        if (r24 >= r20.getChildCount()) goto L13;
        View r108 = r20.getChildAt(r24);
        if (r108 == null) goto L10;
        r108.setVisibility(0);
    L10:
        if ((r108 instanceof LKUIRoundableLayout) == false) goto L12;
        r4 = (LKUIRoundableLayout) r108;
        goto L14
    L12:
        r4 = null;
        goto L14
    }
}
