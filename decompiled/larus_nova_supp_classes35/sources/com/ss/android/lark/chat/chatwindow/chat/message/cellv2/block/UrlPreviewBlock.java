package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chameleon.basewebview.BizScene;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.o1;
import com.ss.android.lark.chatwindow.view.preview.UrlPreviewBinder;
import com.ss.android.lark.chatwindow.view.preview.UrlPreviewCollapsingHelper;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UrlPreviewBlock implements com.ss.android.lark.blueprint.i<y6b.a<BaseTextContentVO<?>>, BaseTextContentVO<?>>, e6b.a {
    public static final e6b.c h = null;
    public final com.ss.android.lark.blueprint.g a;
    public final IMMessageKeys$Blocks b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final List<com.ss.android.lark.blueprint.j> g;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View>, f2b.b {
        public final View a;
        public final Function0<View> b;
        public final ViewStub c;
        public final FrameLayout d;
        public final LinearLayout e;
        public ViewGroup f;

        public static final class a {
        }

        static {
        }

        @Override // f2b.b
        public final void b() {
        }

        public final ViewGroup d() {
            ViewGroup r0 = this.f;
            if (r0 != null) goto L6;
            View r1 = this.c.inflate();
            LinearLayout r2 = (LinearLayout) r1.findViewById(2131391960);
            this.f = r2;
            r1.findViewById(2131369241);
            TextView r3 = (TextView) r1.findViewById(2131391963);
            TextView r4 = (TextView) r1.findViewById(2131391952);
            ImageView r5 = (ImageView) r1.findViewById(2131391957);
            ImageView r6 = (ImageView) r1.findViewById(2131392351);
            ImageView r7 = (ImageView) r1.findViewById(2131382453);
            Intrinsics.checkNotNull(r5);
            zz7.a.a(r5, 30);
            Intrinsics.checkNotNull(r3);
            LarkFont r8 = LarkFont.BODY1;
            zz7.a.d(r3, r8);
            Intrinsics.checkNotNull(r4);
            zz7.a.d(r4, r8);
            return r2;
        L6:
            return r0;
        }

        public final View e() {
            return (View) this.b.invoke();
        }

        @Override // f2b.b
        public final LarkFont a() {
            return LarkFont.BODY1;
        }

        @Override // f2b.b
        public final LarkFont c() {
            return LarkFont.BODY1;
        }

        public final View getView() {
            return this.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(View r2, Function0<? extends View> r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "provideCollapsingView");
            this.a = r2;
            this.b = r3;
            this.c = (ViewStub) r2.findViewById(2131391962);
            this.d = (FrameLayout) r2.findViewById(2131369281);
            this.e = (LinearLayout) r2.findViewById(2131391959);
        }
    }

    public final Class<BaseTextContentVO<?>> b() {
        return null;
    }

    static {
        h = new e6b.c(null);
    }

    public final m2b.a f() {
        return (m2b.a) this.c.getValue();
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.b;
    }

    public UrlPreviewBlock(com.ss.android.lark.blueprint.g r4) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        this.a = r4;
        IMMessageKeys$Blocks r5 = IMMessageKeys$Blocks.URL_PREVIEW;
        this.b = r5;
        this.c = LazyKt.lazy(new UrlPreviewBlock$chatContext$2(this));
        this.d = LazyKt.lazy(new UrlPreviewBlock$callbackHub$2(this));
        this.e = LazyKt.lazy(new UrlPreviewBlock$messageCellConfig$2(this));
        this.f = LazyKt.lazy(new UrlPreviewBlock$mMessagePreviewBinder$2(this));
        this.g = CollectionsKt.listOf(new com.ss.android.lark.blueprint.j[]{h, r5});
    }

    @Override // e6b.a
    public final e6b.a.C0216a e(com.ss.android.lark.blueprint.j r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return new e6b.a.C0216a(this.g.indexOf(r3), this.g.size());
    }

    public final void a(com.ss.android.lark.blueprint.m<y6b.a<BaseTextContentVO<?>>> r4, com.ss.android.lark.blueprint.q<y6b.a<BaseTextContentVO<?>>> r5) {
        Intrinsics.checkNotNullParameter(r4, "cell");
        Intrinsics.checkNotNullParameter(r5, "layout");
        com.ss.android.lark.blueprint.i.a.a(r4, r5);
        v4b.d r6 = (v4b.d) this.e.getValue();
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.c == true) goto L8;
        return;
    L8:
        if (f().e0() == false) goto L11;
        return;
    L11:
        if ((r4 instanceof h3b.b) == false) goto L13;
        h3b.b r7 = (h3b.b) r4;
    L14:
        if (r7 == null) goto L51;
        BlueprintCellViewHolder r8 = ((BlueprintCell) r7).h;
        if (r8 == null) goto L52;
        View r9 = ((RecyclerView.ViewHolder) r8).itemView;
        if (r9 == null) goto L53;
        int r10 = com.ss.android.lark.chatwindow.view.preview.i.a;
        Object r11 = r9.getTag(2131388117);
        if ((r11 instanceof List) == false) goto L22;
        List r12 = (List) r11;
    L23:
        if (r12 == null) goto L32;
        Iterator r13 = r12.iterator();
    L26:
        if (r13.hasNext() == false) goto L32;
        Object r1 = r13.next();
        ConcurrentHashMap<Integer, Long> r2 = o1.a;
        if ((r1 instanceof String) == false) goto L30;
        String r3 = (String) r1;
    L31:
        o1.c(r3);
        goto L26
    L30:
        r3 = null;
    L32:
        Object r14 = r9.getTag(2131391949);
        if (r14 != null) goto L35;
        return;
    L35:
        if ((r14 instanceof LinkedHashMap) == false) goto L55;
        Iterator r15 = ((Map) r14).entrySet().iterator();
    L38:
        if (r15.hasNext() == false) goto L57;
        Map.Entry r16 = (Map.Entry) r15.next();
        if ((r16.getValue() instanceof t6c.d) == false) goto L38;
        Object r17 = r16.getValue();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.ss.android.lark.tangram.base.render.Render");
        t6c.d.b(((t6c.d) r17).g);
        goto L38
    L57:
        return;
    L55:
        return;
    L22:
        r12 = null;
        goto L23
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L13:
        r7 = null;
        goto L14
    }

    public static final boolean d(UrlPreviewBlock r1, com.ss.android.lark.blueprint.m r2, y6b.a r3) {
        r1.getClass();
        if ((r2 instanceof h3b.b) == false) goto L5;
        h3b.b r4 = (h3b.b) r2;
    L6:
        if (r4 == null) goto L8;
        Intrinsics.checkNotNullParameter(r1, BizScene.BLOCK);
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        return r4.n(r3);
    L8:
        return false;
    L5:
        r4 = null;
        goto L6
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<BaseTextContentVO<?>>> r28, com.ss.android.lark.blueprint.q<y6b.a<BaseTextContentVO<?>>> r29, y6b.a<BaseTextContentVO<?>> r30) {
        Intrinsics.checkNotNullParameter(r28, "cell");
        Intrinsics.checkNotNullParameter(r29, "layout");
        Intrinsics.checkNotNullParameter(r30, Keys.API_RETURN_KEY_DATA);
        f3b.d r3 = new f3b.d(r30, f().getChat(), f().x8());
        v4b.d r4 = (v4b.d) this.e.getValue();
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L10;
    L13:
        boolean r6 = true;
    L14:
        e6b.c r7 = h;
        if (r6 == true) goto L180;
        Integer r8 = r3.k();
        if (r8 != null) goto L20;
    L22:
        h6b.g r9 = h6b.g.b;
        String r10 = r30.getId();
        Map<String, PreviewHangPoint> r11 = r30.b().C;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "messageId");
        Intrinsics.checkNotNullParameter("[URLPreview] can create cardPreview", "tag");
        if (r11 != null) goto L25;
    L28:
        boolean r12 = true;
    L29:
        if (r12 == true) goto L36;
        StringBuffer r13 = new StringBuffer("hangPointsInfo = {");
        Iterator<Map.Entry<String, PreviewHangPoint>> r14 = r11.entrySet().iterator();
    L33:
        if (r14.hasNext() == false) goto L35;
        Map.Entry<String, PreviewHangPoint> r15 = r14.next();
        r13.append("{elementID: = " + r15.getValue().getHangPointId() + ",previewID: = " + r15.getValue().getPreviewId() + ", isLazyLoad: = " + r15.getValue().isLazyLoad() + " },");
        goto L33
    L35:
        r13.append("}");
        Log.i("[URLPreview] can create cardPreview", "messageID:" + r10 + ", " + r13);
    L36:
        IMMessageKeys$Slots r16 = IMMessageKeys$Slots.CONTENT;
        final com.ss.android.lark.blueprint.k r17 = r29.c(r7, r16, new UrlPreviewBlock$showPreview$collapsingBlockView$1(this));
        b r18 = (b) r29.c(this.b, r16, new UrlPreviewBlock$showPreview$containerBlockView$1(this, r17));
        m7b.c r2 = (m7b.c) this.f.getValue();
        x0 r19 = new x0(this, r28, r30);
        b3b.f r20 = (b3b.f) this.d.getValue();
        r2.getClass();
        int r21 = r3.k().intValue();
        h3b.b r110 = null;
        if (r21 == 1) goto L43;
        if (r21 == 2) goto L42;
        if (r21 == 4) goto L41;
        com.ss.android.lark.chatwindow.view.preview.c r22 = null;
    L44:
        boolean r23 = r22 instanceof UrlPreviewBinder;
        if (r23 == true) goto L47;
    L106:
        r18.e().setVisibility(8);
        if (r22 != null) goto L111;
        r18.d.setVisibility(8);
        r18.e.setVisibility(8);
        ViewGroup r24 = r18.f;
        if (r24 == null) goto L120;
        r24.setVisibility(8);
    L120:
        ViewGroup r25 = null;
    L129:
        boolean r26 = false;
    L134:
        if (r25 == null) goto L148;
        if (r2.b.e0() == true) goto L144;
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.messenger.url_preview.multiple_urls") == true) goto L146;
        if (r3.m() > 1) goto L144;
    L146:
        h2b.a r27 = r3.l(r22.getPreviewType());
        r22.a(r27, r22.b(r27, r25));
    L144:
        if (r23 == false) goto L146;
        r18.e.setVisibility(8);
    L148:
        ViewGroup r31 = r18.f;
        if (r31 == null) goto L151;
        r31.setOnLongClickListener(new y0(this, r28, r30));
    L151:
        r18.e.setOnLongClickListener(new z0(this, r28, r30));
        boolean r111 = r28 instanceof h3b.b;
        if (r111 == false) goto L154;
        h3b.b r32 = (h3b.b) r28;
    L155:
        if (r32 == null) goto L157;
        BlueprintCellViewHolder r33 = ((BlueprintCell) r32).h;
    L158:
        LinearLayout r34 = r18.e;
        View r112 = r17.getView();
        int r35 = UrlPreviewCollapsingHelper.o;
        m2b.a r36 = f();
        Intrinsics.checkNotNullParameter(r36, "chatContext");
        if (r36.q8() == false) goto L161;
    L164:
        r26 = true;
    L165:
        if (r26 == false) goto L168;
        new UrlPreviewCollapsingHelper(f(), r30, ChatCoreModule.a().getFeatureGatingDependency(), r33, r34, r112, new w0(this)).a();
    L168:
        if (r111 == false) goto L170;
        r110 = (h3b.b) r28;
    L170:
        h3b.b r1 = r110;
        if (r1 == null) goto L177;
        BlueprintCellViewHolder r37 = ((BlueprintCell) r1).h;
        if (r37 == null) goto L177;
        View r38 = ((RecyclerView.ViewHolder) r37).itemView;
        if (r38 == null) goto L177;
        r38.setTag(2131391949, r30.b().B);
        com.ss.android.lark.chatwindow.view.preview.i.c(r38, r30.b().C);
    L177:
        com.ss.android.lark.biz.im.api.message.params.b0 r39 = f().d0(com.ss.android.lark.biz.im.api.message.params.b0.class);
        if (r39 == null) goto L191;
        int r40 = UIUtils.dp2px(this.a.getContext(), r39.a);
        LinearLayout r41 = r18.e;
        r41.setPadding(r41.getPaddingLeft(), r41.getPaddingTop(), r41.getPaddingRight(), r40);
        return;
    L191:
        return;
    L161:
        if (r36.isAIChat() == true) goto L164;
        if (r36.Y() == false) goto L165;
    L157:
        r33 = null;
        goto L158
    L154:
        r32 = null;
        goto L155
    L111:
        int r42 = r22.getPreviewType();
        if (r42 != 1) goto L114;
        r18.d.setVisibility(8);
        r18.e.setVisibility(8);
        ViewGroup r43 = r18.f;
        if (r43 == null) goto L133;
        r26 = false;
        r43.setVisibility(0);
        r25 = r18.f;
        goto L134
    L133:
        r26 = false;
        r25 = r18.d();
        r25.setVisibility(0);
        goto L134
    L114:
        if (r42 != 2) goto L116;
        r18.d.setVisibility(0);
        r18.e.setVisibility(8);
        ViewGroup r44 = r18.f;
        if (r44 == null) goto L128;
        r44.setVisibility(8);
    L128:
        r25 = r18.d;
        goto L129
    L116:
        if (r42 == 4) goto L121;
        r18.d.setVisibility(8);
        r18.e.setVisibility(8);
        ViewGroup r45 = r18.f;
        if (r45 == null) goto L120;
        r45.setVisibility(8);
        goto L120
    L121:
        r18.e.setVisibility(0);
        ViewGroup r46 = r18.f;
        if (r46 == null) goto L124;
        r46.setVisibility(8);
    L124:
        r18.d.setVisibility(8);
        r25 = r18.e;
        goto L129
    L47:
        if ((r3.l(r22.getPreviewType()) instanceof h2b.c) == false) goto L106;
        Map<String, PreviewHangPoint> r47 = ((h2b.c) r3.l(r22.getPreviewType())).a;
        ChatHitPointExtraParams.UrlAnalysisScene r48 = ChatHitPointExtraParams.UrlAnalysisScene.CHAT;
        if (r2.b.e0() == false) goto L52;
        r48 = ChatHitPointExtraParams.UrlAnalysisScene.MERGE_FORWARD;
    L54:
        int r49 = com.ss.android.lark.chatwindow.view.preview.i.a;
        Intrinsics.checkNotNullParameter(r48, "scene");
        if (r47 == null) goto L106;
        Iterator<Map.Entry<String, PreviewHangPoint>> r50 = r47.entrySet().iterator();
    L59:
        if (r50.hasNext() == false) goto L106;
        PreviewHangPoint r51 = r50.next().getValue();
        ConcurrentHashMap<Integer, Long> r113 = o1.a;
        Long r114 = o1.a(r51.getPreviewId() + r48.getValue());
        StringBuilder r115 = new StringBuilder("sendMessageInlineRenderEndTime no endTime:");
        if (r114 != null) goto L63;
        boolean r116 = true;
    L64:
        r115.append(r116);
        r115.append(",previewEntity is Empty:");
        if (r51.getUrlCardPreviewEntity() != null) goto L67;
        boolean r117 = true;
    L68:
        r115.append(r117);
        r115.append(",previweID:");
        r115.append(r51.getPreviewId());
        Log.d("[URLPreview]BuryPointUtil", r115.toString());
        if (r114 != null) goto L105;
        if (r51.getUrlCardPreviewEntity() == null) goto L105;
        UrlCardPreviewEntity r52 = r51.getUrlCardPreviewEntity();
        Intrinsics.checkNotNullParameter(r48, "scene");
        if (r52 == null) goto L105;
        UrlInlinePreviewEntity r53 = r52.getInlineEntity();
        if (r53 == null) goto L105;
        Long r118 = o1.a(r53.getPreviewId());
        if (r118 != null) goto L80;
        Log.i("[URLPreview]BuryPointUtil", "startTime is null ,inline not from 0 to 1 , scene:" + r48.getValue() + ", previewId: " + r53.getPreviewId());
        goto L105
    L80:
        long r210 = System.currentTimeMillis();
        if (r53.getNeedReload() == false) goto L83;
        com.ss.android.lark.statistics.chat.g r119 = new com.ss.android.lark.statistics.chat.g("1");
    L84:
        s5c.d r120 = r48.plus(r119).plus(new com.ss.android.lark.statistics.chat.f(String.valueOf(r210 - r118.longValue())));
        Url r54 = r53.getUrl();
        if (r54 == null) goto L87;
        String r55 = r54.getAndroidUrl();
    L88:
        if (r55 != null) goto L90;
    L93:
        boolean r56 = true;
    L94:
        if (r56 == false) goto L98;
        Url r57 = r53.getUrl();
        if (r57 == null) goto L102;
        String r58 = r57.getUrl();
    L101:
        String r211 = r58;
    L103:
        int r59 = com.ss.android.lark.chatwindow.view.preview.i.a;
        s5c.d r60 = com.ss.android.lark.chatwindow.view.preview.i.a(r120, r53.getPreviewId(), r211, r118.longValue(), r210);
        Lazy r121 = ChatHitPointNew.a;
        Intrinsics.checkNotNullParameter(r60, "param");
        JSONObject r61 = r60.plus(ChatParamUtils.e()).toJson();
        ChatHitPointNew.d().sendEvent("url_preview_inline_render_dev", r61);
        Log.d("[URLPreview]", "INLINE INLINE INLINE INLINE,paramJson:" + r61);
        o1.b(r53.getPreviewId() + r48.getValue(), Long.valueOf(System.currentTimeMillis()));
    L102:
        r211 = null;
        goto L103
    L98:
        Url r62 = r53.getUrl();
        if (r62 == null) goto L102;
        r58 = r62.getAndroidUrl();
        goto L101
    L90:
        if (r55.length() == 0) goto L93;
        r56 = false;
        goto L94
    L87:
        r55 = null;
        goto L88
    L83:
        r119 = new com.ss.android.lark.statistics.chat.g(DocTabPayload.DocType.UNKNOWN);
    L105:
        r50 = r50;
        goto L59
    L67:
        r117 = false;
        goto L68
    L63:
        r116 = false;
        goto L64
    L52:
        if (r2.b.m() == false) goto L54;
        r48 = ChatHitPointExtraParams.UrlAnalysisScene.CHAT_DETAIL;
        goto L54
    L41:
        m2b.a r63 = r2.b;
        Intrinsics.checkNotNullParameter(r3, "provider");
        FragmentActivity r64 = r2.a;
        Intrinsics.checkNotNullParameter(r64, "context");
        r22 = new UrlPreviewBinder(r64, r19, r3, r63, r20);
        goto L44
    L42:
        m7b.b r65 = new m7b.b(r18, r3, r19);
        FragmentActivity r66 = r2.a;
        Intrinsics.checkNotNullParameter(r66, "context");
        r22 = new com.ss.android.lark.chatwindow.view.preview.a(r66, new m7b.a(r65), r65.b);
        goto L44
    L43:
        m7b.f r67 = new m7b.f(r18, r3, r19);
        FragmentActivity r68 = r2.a;
        Intrinsics.checkNotNullParameter(r68, "context");
        r22 = new com.ss.android.lark.chatwindow.view.preview.d(r68, r67.c, new m7b.d(r67), new m7b.e(r67));
        goto L44
    L25:
        if (r11.isEmpty() == true) goto L28;
        r12 = false;
        goto L29
    L20:
        if (r8.intValue() != 0) goto L22;
    L180:
        IMMessageKeys$Blocks r69 = this.b;
        IMMessageKeys$Slots r70 = IMMessageKeys$Slots.CONTENT;
        com.ss.android.lark.blueprint.k r71 = r29.o(r69, r70);
        if (r71 == null) goto L183;
        vza.c r72 = this.a.d;
        IMMessageKeys$Blocks r73 = this.b;
        r72.getClass();
        Intrinsics.checkNotNullParameter(r73, "blockKey");
        Intrinsics.checkNotNullParameter(r71, "blockView");
        r72.b(r73, vza.c.b, r71);
    L183:
        com.ss.android.lark.blueprint.k r74 = r29.o(r7, r70);
        if (r74 == null) goto L193;
        vza.c r75 = this.a.d;
        IMMessageKeys$Blocks r76 = this.b;
        r75.getClass();
        Intrinsics.checkNotNullParameter(r76, "blockKey");
        Intrinsics.checkNotNullParameter(r74, "blockView");
        r75.b(r76, vza.c.b, r74);
        return;
    L193:
        return;
    L10:
        if (r30.t() == MessageDLPState.BLOCK) goto L13;
        r6 = false;
        goto L14
    L5:
        if (r4.c == true) goto L7;
        r5 = true;
        goto L8
    }

    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r1, com.ss.android.lark.blueprint.q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }

    public final void c(BlueprintCell r1, com.ss.android.lark.blueprint.q r2, Object r3, Object r4) {
        com.ss.android.lark.blueprint.i.a.b(this, r1, r2, (y6b.a) r3, (BaseTextContentVO) r4);
    }
}
