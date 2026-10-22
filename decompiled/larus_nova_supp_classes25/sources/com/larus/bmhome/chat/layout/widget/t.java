package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.IChatAzerothService;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.share.FileExportTypeChooseDialog;
import com.larus.bmhome.chat.e5;
import com.larus.bmhome.utils.z3;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusBlockTextAidocBinding;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t extends FrameLayout implements po8.o {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public kc8.b f;
    public fb8.f g;
    public final Lazy h;

    private final LarusBlockTextAidocBinding getBinding() {
        return (LarusBlockTextAidocBinding) this.h.getValue();
    }

    private final de8.c getChatArgumentData() {
        return (de8.c) this.d.getValue();
    }

    private final ChatParam getChatParam() {
        return (ChatParam) this.c.getValue();
    }

    private final boolean getExportIconStyleOpt() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    private final vg8.m getMarkdownRenderHelper() {
        return (vg8.m) this.a.getValue();
    }

    private final e5 getSettingsConfig() {
        return (e5) this.e.getValue();
    }

    private final LinearLayout getMarkdownContainer() {
        return getBinding().j;
    }

    public t(final Context r80) {
        Intrinsics.checkNotNullParameter(r80, "context");
        super(r80);
        this.a = LazyKt.lazy(new a());
        this.b = LazyKt.lazy(new k());
        this.c = LazyKt.lazy(new l(this));
        this.d = LazyKt.lazy(new m(this));
        this.e = LazyKt.lazy(new n(this));
        BotModel r2 = new BotModel(null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, Integer.MAX_VALUE, null);
        ChatParam r3 = new ChatParam(null, null, null, null, null, 255);
        de8.c r15 = new de8.c(null, null, false, null, null, false, null, null, null, null, false, false, null, 0, 32767);
        e5 r4 = new e5(0);
        Intrinsics.checkNotNullParameter(r2, "botModel");
        Intrinsics.checkNotNullParameter(r3, "chatParam");
        Intrinsics.checkNotNullParameter("other_default", "chatType");
        Intrinsics.checkNotNullParameter(r15, "chatArgumentData");
        Intrinsics.checkNotNullParameter(r4, "chatSettingsConfig");
        this.h = LazyKt.lazy(new o(r80, this));
    }

    public static boolean d(Bundle r3) {
        if (r3 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L14;
        if (r3 == null) goto L11;
        String r4 = r3.getString("as_container");
    L13:
        if (Intrinsics.areEqual(r4, "READONLY_FORWARD_DETAIL") == true) goto L14;
        return false;
    L11:
        r4 = null;
    L14:
        return true;
    L5:
        if (r3.getBoolean("preview_collection_readonly") != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void a(int r8) {
        int r0 = getBinding().a.getHeight();
        int r1 = 0;
        if (r8 < 0) goto L5;
        int r9 = 0;
    L6:
        ViewGroup.MarginLayoutParams r2 = null;
        if (r9 != 0) goto L12;
        if (getBinding().c.getVisibility() != 8) goto L36;
        getBinding().g.setBackgroundColor(0);
        getBinding().h.setText(null);
        com.larus.utils.e1.x(getBinding().c);
    L36:
        ViewGroup.LayoutParams r3 = getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L39;
        r2 = (ViewGroup.MarginLayoutParams) r3;
    L39:
        if (r2 == null) goto L41;
        r1 = r2.topMargin;
    L41:
        getBinding().g.setTranslationY(r9 - r1);
        return;
    L12:
        if (getBinding().c.getVisibility() != 0) goto L36;
        getBinding().g.setBackgroundColor(getContext().getResources().getColor(v19.c.b(2130970529, getContext(), 2131102529)));
        com.larus.utils.e1.o(getBinding().c);
        fb8.f r4 = this.g;
        if (r4 == null) goto L22;
        Block r5 = r4.a;
        if (r5 == null) goto L22;
        BlockContent r6 = r5.getContent();
        if (r6 == null) goto L22;
        TextBlock r7 = r6.getTextBlock();
        if (r7 == null) goto L22;
        String r10 = r7.summary;
    L24:
        if (TextUtils.isEmpty(r10) == true) goto L36;
        TextView r11 = getBinding().h;
        fb8.f r12 = this.g;
        if (r12 == null) goto L34;
        Block r13 = r12.a;
        if (r13 == null) goto L34;
        BlockContent r14 = r13.getContent();
        if (r14 == null) goto L34;
        TextBlock r15 = r14.getTextBlock();
        if (r15 == null) goto L34;
        String r16 = r15.summary;
    L35:
        r11.setText(r16);
    L34:
        r16 = null;
    L22:
        r10 = null;
        goto L24
    L5:
        r9 = Math.min(-r8, r0);
        goto L6
    }

    public final void e(String r13) {
        de8.c r0 = getChatArgumentData();
        TraceFragment r1 = null;
        if (r0 == null) goto L5;
        Bundle r2 = r0.b;
    L7:
        if (d(r2) == true) goto L26;
        de8.c r3 = getChatArgumentData();
        if (r3 == null) goto L11;
        Bundle r4 = r3.a;
    L13:
        if (d(r4) == true) goto L26;
        kc8.b r5 = this.f;
        if (r5 == null) goto L21;
        kc8.y r6 = r5.a;
        if (r6 == null) goto L21;
        Fragment r7 = r6.a;
        if (r7 == null) goto L21;
        Bundle r8 = r7.getArguments();
    L23:
        if (d(r8) == true) goto L26;
        boolean r9 = false;
    L27:
        if (r9 == false) goto L30;
        t19.s r14 = t19.s.a;
        Context r10 = getContext();
        r14.getClass();
        t19.s.b(r10, 2131897916, false);
        return;
    L30:
        fb8.f r11 = this.g;
        if (r11 == null) goto L33;
        Message r12 = r11.j();
    L34:
        if (r12 == null) goto L37;
        String r15 = r12.getConversationId();
        if (r15 == null) goto L37;
    L38:
        String r16 = r15;
        kc8.b r17 = this.f;
        if (r17 == null) goto L47;
        kc8.y r18 = r17.a;
        if (r18 == null) goto L47;
        Function0<wc9.e> r19 = r18.e;
        if (r19 == null) goto L47;
        wc9.e r20 = (wc9.e) r19.invoke();
        if (r20 == null) goto L47;
        boolean r21 = ic8.n.v(r20);
    L48:
        kc8.b r22 = this.f;
        if (r22 == null) goto L57;
        kc8.y r23 = r22.a;
        if (r23 == null) goto L57;
        Function0<BotModel> r24 = r23.l;
        if (r24 == null) goto L57;
        BotModel r25 = (BotModel) r24.invoke();
        if (r25 == null) goto L57;
        String r26 = r25.getBotId();
    L58:
        IFlowSdkDepend r27 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r27 == null) goto L75;
        r27.N();
        com.larus.home.impl.sdk.n1 r28 = com.larus.home.impl.sdk.n1.a;
        Context r29 = getContext();
        kc8.b r30 = this.f;
        if (r30 == null) goto L65;
        kc8.y r31 = r30.a;
        if (r31 == null) goto L65;
        Fragment r32 = r31.a;
    L67:
        if ((r32 instanceof TraceFragment) == false) goto L69;
        r1 = (TraceFragment) r32;
    L69:
        if (r1 == null) goto L72;
        String r33 = r1.k();
        if (r33 == null) goto L72;
    L73:
        r28.Q1(r12, r16, r21, r26, r29, r13, r33, "mobile");
        return;
    L72:
        r33 = "chat";
    L65:
        r32 = null;
        goto L67
    L75:
        return;
    L57:
        r26 = null;
    L47:
        r21 = true;
    L37:
        r15 = "";
        goto L38
    L33:
        r12 = null;
    L21:
        r8 = null;
        goto L23
    L11:
        r4 = null;
    L26:
        r9 = true;
        goto L27
    L5:
        r2 = null;
        goto L7
    }

    public final void f(fb8.f r8) {
        com.larus.utils.e1.o(getBinding().f);
        boolean r0 = false;
        if (r8 == null) goto L18;
        List r1 = com.larus.im.bean.message.a.d(r8.j());
        if ((!r1.isEmpty()) == false) goto L18;
        Iterator r2 = r1.iterator();
        int r4 = 0;
    L9:
        if (r2.hasNext() == false) goto L14;
        if (Intrinsics.areEqual(((Block) r2.next()).getBlockId(), r8.a.getBlockId()) == true) goto L16;
        r4 = r4 + 1;
    L16:
        if (r4 != (r1.size() - 2)) goto L18;
        r0 = true;
        goto L18
    L14:
        r4 = -1;
    L18:
        if (r0 == false) goto L25;
        com.larus.utils.e1.x(getBinding().b);
        ViewGroup.LayoutParams r9 = getBinding().b.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
    L23:
        if (r10 == null) goto L29;
        r10.topMargin = i5.q();
        return;
    L29:
        return;
    L22:
        r10 = null;
        goto L23
    L25:
        com.larus.utils.e1.o(getBinding().b);
    }

    public static Unit b(t r25, AppCompatImageView r26) {
        Intrinsics.checkNotNullParameter(r26, "it");
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L5;
        r1.D0();
        com.larus.home.impl.sdk.b1.a.c("office_reply_message_doc_markdown_download");
    L5:
        fb8.f r2 = r25.g;
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L82;
        String r4 = null;
        if (z2.a.exportFileConfig().getEnableMenuExportToDoc() == false) goto L15;
        r25.e("ai_doc_card_download_button");
    L67:
        kc8.b r5 = r25.f;
        if (r5 == null) goto L72;
        kc8.y r6 = r5.a;
        if (r6 == null) goto L72;
        Fragment r7 = r6.a;
    L74:
        if ((r7 instanceof by7.e) == false) goto L76;
        by7.e r18 = (by7.e) r7;
    L77:
        JSONObject r8 = new JSONObject();
        fb8.f r0 = r25.g;
        if (r0 == null) goto L80;
        r4 = r0.j().getMessageId();
    L80:
        r8.put("message_id", r4);
        tx9.u0.d("message_card", "download", null, null, null, "chat", null, null, null, null, null, null, r8, r18, 4060);
        goto L82
    L76:
        r18 = null;
    L72:
        r7 = null;
        goto L74
    L15:
        fb8.f r9 = r25.g;
        if (r9 == null) goto L67;
        Message r10 = r9.j();
        String r11 = r10.getConversationId();
        List r12 = CollectionsKt.listOf(new com.larus.bmhome.chat.component.share.v0(r10.getMessageId(), Integer.valueOf(r10.getContentType())));
        kc8.b r13 = r25.f;
        if (r13 == null) goto L24;
        kc8.y r14 = r13.a;
        if (r14 == null) goto L24;
        Function0<BotModel> r15 = r14.l;
        if (r15 == null) goto L24;
        BotModel r16 = (BotModel) r15.invoke();
    L25:
        de8.c r17 = r25.getChatArgumentData();
        if (r17 == null) goto L28;
        long r19 = r17.n;
    L29:
        long r110 = r19;
        String r111 = UUID.randomUUID().toString();
        int r20 = FileExportTypeChooseDialog.w;
        if (r11 != null) goto L32;
        String r21 = "";
    L33:
        if (r16 == null) goto L35;
        String r22 = r16.getName();
    L36:
        if (r22 != null) goto L38;
        String r112 = "";
    L39:
        if (r16 == null) goto L41;
        String r23 = r16.getBotId();
    L42:
        if (r23 != null) goto L44;
        String r113 = "";
    L45:
        Map r24 = r10.getExt();
        if (r24 == null) goto L48;
        String r27 = (String) r24.get("deep_research_id");
    L49:
        if (r27 != null) goto L51;
        String r114 = "";
    L52:
        IChatAzerothService r28 = com.larus.bmhome.x.a();
        if (r28 != null) goto L55;
    L57:
        boolean r29 = false;
    L58:
        FileExportTypeChooseDialog r30 = FileExportTypeChooseDialog.a.b(r21, r12, null, r112, r113, r111, r110, null, r114, null, null, r29, "chat", "message_card", 1668);
        kc8.b r31 = r25.f;
        if (r31 == null) goto L67;
        kc8.y r32 = r31.a;
        if (r32 == null) goto L67;
        Fragment r33 = r32.a;
        if (r33 == null) goto L67;
        FragmentManager r34 = r33.getChildFragmentManager();
        if (r34 == null) goto L67;
        FileExportTypeChooseDialog.a.c(r30, r34);
        goto L67
    L55:
        if (r28.a(r10) != true) goto L57;
        r29 = true;
        goto L58
    L51:
        r114 = r27;
        goto L52
    L48:
        r27 = null;
        goto L49
    L44:
        r113 = r23;
        goto L45
    L41:
        r23 = null;
        goto L42
    L38:
        r112 = r22;
        goto L39
    L35:
        r22 = null;
        goto L36
    L32:
        r21 = r11;
        goto L33
    L28:
        r19 = 0;
    L24:
        r16 = null;
    L82:
        return Unit.INSTANCE;
    L8:
        if (com.larus.bmhome.chat.bean.d.j0(r2.j()) != true) goto L10;
        r3 = true;
        goto L11
    }

    public final void c(fb8.f r92, kc8.b r93) {
        Intrinsics.checkNotNullParameter(r92, "blockModel");
        this.g = r92;
        this.f = r93;
        Message r2 = r92.j();
        if (r93 == null) goto L9;
        kc8.y r3 = r93.a;
        if (r3 == null) goto L9;
        Integer r4 = r3.t;
        if (r4 == null) goto L9;
        int r21 = r4.intValue();
    L10:
        kc8.b r5 = this.f;
        if (r5 == null) goto L18;
        kc8.y r6 = r5.a;
        if (r6 == null) goto L18;
        Function0<BotModel> r7 = r6.l;
        if (r7 == null) goto L18;
        BotModel r8 = (BotModel) r7.invoke();
        if (r8 == null) goto L18;
    L19:
        BotModel r13 = r8;
        kc8.b r9 = this.f;
        if (r9 == null) goto L24;
        kc8.y r10 = r9.a;
        if (r10 == null) goto L24;
        Integer r12 = r10.j;
    L25:
        ChatParam r11 = getChatParam();
        if (r11 != null) goto L35;
        LruCache r14 = ko8.a.a;
        String r15 = r2.getConversationId();
        if (r15 != null) goto L30;
        r15 = "";
    L30:
        wc9.e r16 = (wc9.e) r14.get(r15);
        if (r16 == null) goto L33;
        String r19 = ic8.n.f(r16);
    L34:
        ChatParam r17 = new ChatParam(null, null, null, null, r19, 239);
    L36:
        LruCache r18 = ko8.a.a;
        de8.c r20 = getChatArgumentData();
        if (r20 == null) goto L39;
        long r22 = r20.n;
    L40:
        String r110 = ko8.a.e(r22);
        de8.c r23 = getChatArgumentData();
        if (r23 != null) goto L43;
        r23 = new de8.c(null, null, false, null, null, false, null, null, null, null, false, false, null, 0, 32767);
    L43:
        de8.c r111 = r23;
        e5 r112 = getSettingsConfig();
        de8.c r24 = getChatArgumentData();
        if (r24 == null) goto L46;
        Integer r25 = r24.m();
    L47:
        int r26 = 0;
        if (r25 == null) goto L50;
        boolean r27 = true;
    L51:
        Boolean r113 = Boolean.valueOf(r27);
        de8.c r28 = getChatArgumentData();
        if (r28 == null) goto L54;
        Integer r114 = r28.m();
    L55:
        kc8.b r29 = this.f;
        if (r29 == null) goto L60;
        kc8.y r30 = r29.a;
        if (r30 == null) goto L60;
        com.larus.bmhome.chat.api.q0 r210 = r30.x;
    L61:
        if (r29 == null) goto L65;
        kc8.y r31 = r29.a;
        if (r31 == null) goto L65;
        RecyclerView.Adapter<?> r211 = r31.w;
    L66:
        if (r29 == null) goto L70;
        kc8.y r32 = r29.a;
        if (r32 == null) goto L70;
        boolean r212 = Intrinsics.areEqual(r32.h, Boolean.TRUE);
    L71:
        final com.larus.bmhome.chat.deepresearch.view.p0 r33 = new com.larus.bmhome.chat.deepresearch.view.p0(r12, r13, r17, r110, r111, r112, r113, r114, r210, r21, r211, r212, new f(this), new g(this), new h(this));
        Message r115 = r92.j();
        Block r116 = r92.a;
        boolean r34 = r92.n();
        if (r93 == null) goto L78;
        kc8.y r35 = r93.a;
        if (r35 == null) goto L78;
        Boolean r36 = r35.i;
        if (r36 == null) goto L78;
        boolean r37 = r36.booleanValue();
    L79:
        fh8.f r213 = z3.a(r93, r92.j()).a();
        StringBuilder r0 = new StringBuilder("text_block_msgId_");
        r0.append(r115.getMessageId());
        r0.append("_blockId_");
        if (r116 == null) goto L82;
        String r1 = r116.getBlockId();
    L83:
        r0.append(r1);
        String r38 = r0.toString();
        if (r115.getMessageStatusLocal() != 23) goto L86;
    L96:
        boolean r117 = true;
    L98:
        if (r115.getMessageStatusLocal() != 23) goto L100;
    L101:
        if (r34 == false) goto L103;
        boolean r214 = true;
    L104:
        fh8.t.a r118 = new fh8.t.a();
        r118.a = ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136));
        r118.b = i5.t();
        r118.c = i5.H();
        r118.d = Intrinsics.areEqual(r33.g, Boolean.TRUE);
        r118.e = r33.l;
        r118.f = r33.a;
        r118.g = false;
        r118.i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        boolean r39 = r33.l;
        Context r40 = getContext();
        if (r40 == null) goto L108;
        r26 = com.larus.bmhome.chat.layout.widget.handler.w.c(com.larus.bmhome.chat.layout.widget.handler.w.a, r40, r115, 0, Boolean.FALSE, r39, false, null, this, 96);
    L108:
        r118.h = r26;
        fh8.t r41 = r118.a();
        boolean r310 = !r117;
        StringBuilder r42 = new StringBuilder("msgId:");
        r42.append(r115.getMessageId());
        r42.append("-blockId:");
        if (r116 == null) goto L111;
        String r43 = r116.getBlockId();
    L112:
        r42.append(r43);
        fh8.l r119 = new fh8.l(r214, r310, r38, false, r42.toString(), r37, false, false, false, null, null, 4032);
        vg8.m r120 = getMarkdownRenderHelper();
        LinearLayout r121 = getMarkdownContainer();
        if (r116 == null) goto L115;
        String r44 = qf8.a.c(r116, r115, 2);
    L116:
        if (r44 != null) goto L118;
        r44 = "";
    L118:
        fh8.e.a(r120, r121, r44, r41, r119, new p(r33), new q(r33), new r(r33), null, r213, r116, null, 1152);
        z2.a.w3();
        if (getExportIconStyleOpt() == false) goto L127;
        AppCompatImageView r45 = getBinding().i;
        if (r45 == null) goto L127;
        AppCompatImageView r46 = getBinding().i;
        if (r46 == null) goto L125;
        Context r47 = r46.getContext();
    L126:
        r45.setImageResource(v19.c.b(2130971671, r47, 2131241008));
        goto L127
    L125:
        r47 = null;
    L127:
        fb8.f r48 = this.g;
        if (r48 != null) goto L130;
    L132:
        boolean r49 = false;
    L133:
        if (r49 == false) goto L184;
        getBinding().d.setColorFilter(null);
        getBinding().i.setColorFilter(null);
        getBinding().e.setColorFilter(null);
        fb8.f r50 = this.g;
        if (r50 == null) goto L173;
        Message r51 = r50.j();
        kc8.b r52 = this.f;
        if (r52 == null) goto L163;
        kc8.y r53 = r52.a;
        if (r53 == null) goto L163;
        com.larus.bmhome.chat.api.q0 r54 = r53.x;
        if (r54 == null) goto L163;
        List<wq8.a> r55 = r54.D7();
        if (r55 == null) goto L163;
        Iterator<T> r56 = r55.iterator();
    L146:
        if (r56.hasNext() == false) goto L157;
        Object r57 = r56.next();
        wq8.a r58 = (wq8.a) r57;
        if (com.larus.bmhome.chat.bean.d.O0(r58.getMessage()) == false) goto L150;
    L154:
        boolean r59 = false;
    L155:
        if (r59 == false) goto L146;
    L158:
        wq8.a r60 = (wq8.a) r57;
        if (r60 == null) goto L163;
        Message r61 = r60.getMessage();
        if (r61 == null) goto L163;
        String r62 = r61.getMessageId();
    L165:
        if (Intrinsics.areEqual(r62, r51.getMessageId()) == false) goto L172;
        com.larus.utils.e1.o(getBinding().b);
        com.larus.utils.e1.x(getBinding().f);
        getBinding().f.setAlpha(1.0f);
        ViewGroup.LayoutParams r63 = getBinding().f.getLayoutParams();
        if ((r63 instanceof ViewGroup.MarginLayoutParams) == false) goto L169;
        ViewGroup.MarginLayoutParams r64 = (ViewGroup.MarginLayoutParams) r63;
    L170:
        if (r64 == null) goto L173;
        r64.topMargin = i5.q();
        goto L173
    L169:
        r64 = null;
        goto L170
    L172:
        f(this.g);
        goto L173
    L150:
        if (com.larus.bmhome.chat.bean.d.c0(r58.getMessage()) == true) goto L154;
        if (com.larus.bmhome.chat.bean.d.L0(r58.getMessage()) == true) goto L154;
        r59 = true;
        goto L155
    L157:
        r57 = null;
    L163:
        r62 = null;
    L173:
        com.larus.utils.e1.d(getBinding().d, new s(this));
        com.larus.utils.e1.d(getBinding().i, new b(this));
        com.larus.utils.e1.d(getBinding().e, new c(this));
        com.larus.utils.e1.d(getBinding().f, new d(this));
        ExposeXTrackerExtKt.b(getBinding().f, new e(this));
        kc8.b r65 = this.f;
        if (r65 == null) goto L178;
        kc8.y r66 = r65.a;
        if (r66 == null) goto L178;
        Fragment r67 = r66.a;
    L180:
        if ((r67 instanceof by7.e) == false) goto L182;
        by7.e r215 = (by7.e) r67;
    L183:
        tx9.u0.e("message_card", null, null, null, "chat", null, null, null, null, null, null, r215, 2030);
    L201:
        IFlowSdkDepend r68 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r68 == null) goto L210;
        r68.N();
        com.larus.home.impl.sdk.n1.a.v();
        return;
    L210:
        return;
    L182:
        r215 = null;
    L178:
        r67 = null;
        goto L180
    L184:
        getBinding().d.setColorFilter(getContext().getResources().getColor(2131103682));
        getBinding().i.setColorFilter(getContext().getResources().getColor(2131103682));
        getBinding().e.setColorFilter(getContext().getResources().getColor(2131103682));
        fb8.f r69 = this.g;
        if (r69 == null) goto L191;
        Block r70 = r69.a;
        if (r70 == null) goto L191;
        if (r70.isFinish() != true) goto L191;
        boolean r71 = true;
    L192:
        if (r71 == false) goto L199;
        com.larus.utils.e1.x(getBinding().f);
        getBinding().f.setAlpha(0.3f);
        ViewGroup.LayoutParams r72 = getBinding().f.getLayoutParams();
        if ((r72 instanceof ViewGroup.MarginLayoutParams) == false) goto L196;
        ViewGroup.MarginLayoutParams r73 = (ViewGroup.MarginLayoutParams) r72;
    L197:
        if (r73 == null) goto L200;
        r73.topMargin = i5.q();
    L200:
        com.larus.utils.e1.o(getBinding().b);
        goto L201
    L196:
        r73 = null;
        goto L197
    L199:
        com.larus.utils.e1.o(getBinding().f);
    L191:
        r71 = false;
        goto L192
    L130:
        if (com.larus.bmhome.chat.bean.d.j0(r48.j()) != true) goto L132;
        r49 = true;
        goto L133
    L115:
        r44 = null;
        goto L116
    L111:
        r43 = null;
    L103:
        r214 = false;
        goto L104
    L100:
        if (r115.getMessageStatusLocal() != 22) goto L103;
    L86:
        if (r115.getMessageStatusLocal() == 22) goto L96;
        if (com.larus.bmhome.chat.bean.d.I0(r115) == false) goto L90;
    L93:
        if (r34 == false) goto L96;
        r117 = false;
        goto L98
    L90:
        if (r115.getMessageStatusLocal() == 20) goto L93;
        if (com.larus.bmhome.chat.bean.d.Q0(r115) == false) goto L96;
    L82:
        r1 = null;
    L78:
        r37 = false;
    L70:
        r212 = false;
    L65:
        r211 = null;
    L60:
        r210 = null;
        goto L61
    L54:
        r114 = null;
        goto L55
    L50:
        r27 = false;
        goto L51
    L46:
        r25 = null;
        goto L47
    L39:
        r22 = 0;
        goto L40
    L33:
        r19 = null;
        goto L34
    L35:
        r17 = r11;
    L24:
        r12 = null;
    L18:
        r8 = new BotModel(r2.getSenderId(), null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    L9:
        r21 = -1;
        goto L10
    }
}
