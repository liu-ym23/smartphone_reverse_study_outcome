package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.doclink.MessageDocPreviewInlineRenderer;
import com.larus.bmhome.chat.doclink.MessageDocPreviewRepository;
import com.larus.bmhome.chat.e5;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class MarkdownTextBlockView extends AbsBlockView {
    public static final /* synthetic */ int l = 0;
    public final Lazy b;
    public fh8.f c;
    public float d;
    public float e;
    public Message f;
    public Block g;
    public List<Block> h;
    public RectF i;
    public CoroutineScope j;
    public String k;

    public static final class a {
    }

    static {
    }

    public LinearLayout getMarkdownContainer() {
        return this;
    }

    private final vg8.m getMarkdownRenderHelper() {
        return (vg8.m) this.b.getValue();
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void c() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onViewRecycled, messageId: ");
        Message r2 = this.f;
        if (r2 == null) goto L5;
        String r3 = r2.getMessageId();
    L6:
        r1.append(r3);
        r1.append("===");
        Block r4 = this.g;
        if (r4 == null) goto L9;
        String r5 = r4.getBlockId();
    L10:
        r1.append(r5);
        r1.append("===sizeChangedWidth: ");
        r1.append(this.e);
        r1.append(", sizeChangedHeight: ");
        r1.append(this.d);
        r0.i("MarkdownTextBlockView", r1.toString());
        CoroutineScopeKt.cancel$default(this.j, null, 1, null);
        this.j = CoroutineScopeKt.MainScope();
        this.k = null;
        getMarkdownRenderHelper().d(this);
        this.h = CollectionsKt.emptyList();
        this.i = null;
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        CoroutineScopeKt.cancel$default(this.j, null, 1, null);
        this.j = CoroutineScopeKt.MainScope();
        this.k = null;
        super.onDetachedFromWindow();
        getMarkdownRenderHelper().c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.larus.bmhome.chat.layout.widget.v0 r0 = getMarkdownRenderHelper().g;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public MarkdownTextBlockView(Context r79) {
        Intrinsics.checkNotNullParameter(r79, "context");
        super(r79);
        this.b = LazyKt.lazy(new q0());
        this.c = new fh8.g().a();
        BotModel r1 = new BotModel(null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, Integer.MAX_VALUE, null);
        ChatParam r2 = new ChatParam(null, null, null, null, null, 255);
        de8.c r15 = new de8.c(null, null, false, null, null, false, null, null, null, null, false, false, null, 0, 32767);
        e5 r3 = new e5(0);
        Intrinsics.checkNotNullParameter(r1, "botModel");
        Intrinsics.checkNotNullParameter(r2, "chatParam");
        Intrinsics.checkNotNullParameter("other_default", "chatType");
        Intrinsics.checkNotNullParameter(r15, "chatArgumentData");
        Intrinsics.checkNotNullParameter(r3, "chatSettingsConfig");
        this.h = CollectionsKt.emptyList();
        this.j = CoroutineScopeKt.MainScope();
    }

    public final void setEmbeddedMetaInfoBlocks$impl_mainlandRelease(List<Block> r2) {
        Intrinsics.checkNotNullParameter(r2, "blocks");
        this.h = r2;
    }

    public static void g(View r1, List r2) {
        if ((r1 instanceof CustomMarkdownTextView) == false) goto L6;
        ((ArrayList) r2).add(r1);
        return;
    L6:
        if ((r1 instanceof ViewGroup) == false) goto L13;
        Iterator r3 = ViewGroupKt.getChildren((ViewGroup) r1).iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        g((View) r3.next(), r2);
        goto L9
    L14:
        return;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(Block r49, Map<String, Object> r50) {
        e(null, new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null), r49, true, new p0(0), new f1(false), this.c);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public void b(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        setOrientation(1);
    }

    public String h(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (r3 == null) goto L5;
        String r4 = qf8.a.b(r3, r2, this.h);
    L6:
        if (r4 != null) goto L9;
        return "";
    L9:
        return r4;
    L5:
        r4 = null;
        goto L6
    }

    public final void d(com.larus.bmhome.chat.markdown.richtext.i r11, MessageDocPreviewRepository.a r12, Map<CustomMarkdownTextView, ? extends CharSequence> r13, String r14) {
        if (r12.b.isEmpty() == true) goto L5;
    L7:
        Iterator<Map.Entry<CustomMarkdownTextView, ? extends CharSequence>> r15 = r13.entrySet().iterator();
        int r0 = 0;
    L9:
        if (r15.hasNext() == false) goto L16;
        Map.Entry<CustomMarkdownTextView, ? extends CharSequence> r1 = r15.next();
        CustomMarkdownTextView r2 = r1.getKey();
        CharSequence r4 = r1.getValue();
        r2.getClass();
        if (r2.getParent() == null) goto L9;
        int r3 = MessageDocPreviewInlineRenderer.a;
        MessageDocPreviewInlineRenderer.e r5 = MessageDocPreviewInlineRenderer.b(r2, r4, r11, r12.a, r12.b, MessageDocPreviewInlineRenderer.Style.DOWNSTREAM, new v0(this));
        if (r5.b <= 0) goto L9;
        r2.setText(r5.a);
        r2.setMovementMethod(new com.larus.bmhome.chat.layout.widget.p0(null));
        r0 = r0 + r5.b;
        goto L9
    L16:
        FLogger.a.i("MarkdownTextBlockView", "bindInlineDocPreview source=" + r14 + ", renderCount=" + r0);
        return;
    L5:
        if (r12.a.isEmpty() == false) goto L7;
    }

    public final void f(List<CustomMarkdownTextView> r16, Message r17, String r18, String r19) {
        z2 r1 = z2.a;
        if (r1.enableMessageUrlPreview() == true) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (r19 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        return;
    L14:
        if (i3.a.f() == false) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(this.k, r19) == true) goto L19;
    L21:
        if (r2 == true) goto L23;
        return;
    L23:
        String r3 = r17.getMessageId();
        if (r3 != null) goto L27;
        r3 = "";
    L27:
        if (StringsKt.isBlank(r3) == false) goto L29;
        return;
    L29:
        Regex r6 = com.larus.bmhome.chat.markdown.richtext.n.a;
        com.larus.bmhome.chat.markdown.richtext.i r7 = com.larus.bmhome.chat.markdown.richtext.n.m(r18, r1.enableMessageMention(), 4);
        List<String> r8 = r7.e;
        if (r8.isEmpty() == false) goto L32;
        return;
    L32:
        ArrayList r4 = (ArrayList) r16;
        if (r4.isEmpty() == false) goto L35;
        return;
    L35:
        LinkedHashMap r9 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r16, 10)), 16));
        Iterator<T> r0 = r16.iterator();
    L37:
        if (r0.hasNext() == false) goto L42;
        Object r10 = r0.next();
        CustomMarkdownTextView r11 = (CustomMarkdownTextView) r10;
        r11.getClass();
        CharSequence r12 = r11.getText();
        if (r12 != null) goto L41;
        r12 = "";
    L41:
        r9.put(r10, r12);
        goto L37
    L42:
        FLogger.a.i("MarkdownTextBlockView", "bindInlineDocPreview request urlCount=" + r8.size() + ", hasMessageId=true, viewCount=" + r4.size());
        MessageDocPreviewRepository r13 = MessageDocPreviewRepository.a;
        d(r7, MessageDocPreviewRepository.e(r3, r8), r9, "cache");
        BuildersKt.launch$default(this.j, null, null, new MarkdownTextBlockView$bindInlineDocPreviewIfNeeded$1(r3, r8, this, r19, r7, r9, null), 3, null);
        return;
    L19:
        if (getParent() == null) goto L21;
        r2 = true;
        goto L21
    L8:
        if (StringsKt.isBlank(r19) == true) goto L11;
        r5 = false;
        goto L12
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.e = r1;
        this.d = r2;
    }

    public void e(final RectF r40, final Message r41, final Block r42, final boolean r43, final p0 r44, final f1 r45, fh8.f r46) {
        Intrinsics.checkNotNullParameter(r41, "message");
        Intrinsics.checkNotNullParameter(r44, "config");
        Intrinsics.checkNotNullParameter(r45, "msgBoxConfig");
        Intrinsics.checkNotNullParameter(r46, "commonInputData");
        this.f = r41;
        this.g = r42;
        StringBuilder r0 = new StringBuilder("text_block_msgId_");
        r0.append(r41.getMessageId());
        r0.append("_blockId_");
        if (r42 == null) goto L5;
        String r2 = r42.getBlockId();
    L6:
        r0.append(r2);
        String r19 = r0.toString();
        if (r41.getMessageStatusLocal() != 23) goto L9;
    L18:
        boolean r1 = true;
    L19:
        if (r1 == true) goto L23;
        if (r43 == false) goto L23;
        boolean r29 = false;
    L25:
        if (r41.getMessageStatusLocal() != 23) goto L27;
    L28:
        if (r43 == false) goto L30;
        boolean r17 = true;
    L31:
        fh8.t.a r3 = new fh8.t.a();
        Context r4 = getContext();
        Boolean r5 = r44.g;
        Boolean r6 = Boolean.TRUE;
        if (Intrinsics.areEqual(r5, r6) == false) goto L34;
        int r7 = 2131103298;
    L35:
        r3.a = ContextCompat.getColor(r4, r7);
        if (Intrinsics.areEqual(r44.g, r6) == false) goto L38;
        int r8 = i5.o();
    L39:
        r3.b = r8;
        if (Intrinsics.areEqual(r44.g, r6) == false) goto L42;
        int r9 = -1;
    L43:
        r3.c = r9;
        r3.d = Intrinsics.areEqual(r44.g, r6);
        r3.e = r44.l;
        r3.f = r44.a;
        r3.i = r40;
        r3.g = false;
        fh8.t r30 = r3.a();
        boolean r18 = !r29;
        StringBuilder r10 = new StringBuilder("msgId:");
        r10.append(r41.getMessageId());
        r10.append("-blockId:");
        if (r42 == null) goto L46;
        String r11 = r42.getBlockId();
    L47:
        r10.append(r11);
        fh8.l r12 = new fh8.l(r17, r18, r19, false, r10.toString(), r45.a, false, false, false, null, null, 4032);
        fh8.g r13 = fh8.h.a(r46);
        r13.j = r12.e;
        r13.i = new r0(this, r40, r41, r42, r43, r44, r45);
        this.c = r13.a();
        final String r14 = h(r41, r42);
        JobKt.cancelChildren$default(this.j.getCoroutineContext(), null, 1, null);
        String r15 = r41.getMessageId();
        if (r15 != null) goto L50;
    L54:
        r15 = r41.getLocalMessageId();
        if (r15 != null) goto L57;
    L59:
        r15 = null;
    L60:
        if (r15 != null) goto L62;
        r15 = String.valueOf(r41.getLocalIndex());
    L62:
        StringBuilder r16 = new StringBuilder();
        r16.append(r15);
        r16.append(':');
        if (r42 == null) goto L65;
        String r20 = r42.getBlockId();
    L66:
        if (r20 != null) goto L68;
        r20 = "";
    L68:
        r16.append(r20);
        r16.append(':');
        r16.append(r14.hashCode());
        this.k = r16.toString();
        if (r29 == false) goto L76;
        FLogger r21 = FLogger.a;
        StringBuilder r22 = new StringBuilder("bindData, messageId: ");
        r22.append(r41.getMessageId());
        r22.append("===");
        if (r42 == null) goto L73;
        String r23 = r42.getBlockId();
    L74:
        r22.append(r23);
        r22.append("===, content: ");
        r22.append(r14.length());
        r22.append("===sizeChangedHeight:");
        r22.append(this.d);
        r22.append("==sizeChangedWidth:");
        r22.append(this.e);
        r21.i("MarkdownTextBlockView", r22.toString());
        goto L76
    L73:
        r23 = null;
    L76:
        if (ObricFeatureServiceDelegate.b.a() == false) goto L108;
        z2 r24 = z2.a;
        RectF r25 = this.i;
        if (r25 == null) goto L104;
        if (r40 != null) goto L81;
    L101:
        boolean r26 = false;
    L102:
        if (r26 == true) goto L104;
        getMarkdownRenderHelper().d(getMarkdownContainer());
        goto L104
    L81:
        if (r25.left != r40.left) goto L83;
        boolean r27 = true;
    L84:
        if (r27 == false) goto L101;
        if (r25.top != r40.top) goto L88;
        boolean r28 = true;
    L89:
        if (r28 == false) goto L101;
        if (r25.right != r40.right) goto L93;
        boolean r31 = true;
    L94:
        if (r31 == false) goto L101;
        if (r25.bottom != r40.bottom) goto L98;
        boolean r32 = true;
    L99:
        if (r32 == false) goto L101;
        r26 = true;
        goto L102
    L98:
        r32 = false;
        goto L99
    L93:
        r31 = false;
        goto L94
    L88:
        r28 = false;
        goto L89
    L83:
        r27 = false;
    L104:
        if (r40 == null) goto L106;
        RectF r33 = new RectF(r40);
    L107:
        this.i = r33;
        goto L108
    L106:
        r33 = null;
    L108:
        fh8.e.a(getMarkdownRenderHelper(), getMarkdownContainer(), r14, r30, r12, new s0(r44), new t0(r44), new u0(r44), null, this.c, r42, null, 1152);
        if (r29 == false) goto L111;
        final String r34 = this.k;
        final LinearLayout r110 = getMarkdownContainer();
        r110.post(new w0(this, r41, r14, r34, r110));
    L111:
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r35 = ICommerceMembershipService.a.a();
        if (r35 != null) goto L114;
    L116:
        boolean r111 = false;
    L117:
        if (r111 == false) goto L153;
        ICommerceMembershipService r36 = ICommerceMembershipService.a.a();
        if (r36 == null) goto L121;
        String r112 = r36.t(r14);
    L122:
        ICommerceMembershipService r37 = ICommerceMembershipService.a.a();
        if (r37 == null) goto L125;
        uz8.c r113 = r37.z(r112);
    L126:
        ICommerceMembershipService r210 = ICommerceMembershipService.a.a();
        if (r210 == null) goto L154;
        if (r113 == null) goto L130;
        String r38 = r113.a;
    L132:
        if (com.larus.utils.o0.d(r38) == false) goto L136;
        if (r113 == null) goto L135;
        String r39 = r113.a;
    L137:
        String r211 = r39;
    L139:
        if (r113 == null) goto L141;
        String r212 = r113.b;
    L142:
        if (r113 == null) goto L144;
        String r213 = r113.c;
    L145:
        if (r113 == null) goto L147;
        String r310 = r113.d;
    L148:
        if (r113 == null) goto L150;
        String r311 = r113.f;
    L151:
        ICommerceMembershipService.b.b(r210, r211, "chat", r212, r213, r310, r311, null, null, null, null, null, null, 4032);
        return;
    L150:
        r311 = null;
        goto L151
    L147:
        r310 = null;
        goto L148
    L144:
        r213 = null;
        goto L145
    L141:
        r212 = null;
        goto L142
    L135:
        r211 = null;
        goto L139
    L136:
        r39 = "answer_quota_limit";
        goto L137
    L130:
        r38 = null;
        goto L132
    L154:
        return;
    L125:
        r113 = null;
        goto L126
    L121:
        r112 = null;
        goto L122
    L153:
        return;
    L114:
        if (r35.l(r14) != true) goto L116;
        r111 = true;
        goto L117
    L65:
        r20 = null;
        goto L66
    L57:
        if ((!StringsKt.isBlank(r15)) == false) goto L59;
    L50:
        if ((!StringsKt.isBlank(r15)) == true) goto L53;
        r15 = null;
    L53:
        if (r15 != null) goto L62;
    L46:
        r11 = null;
        goto L47
    L42:
        r9 = i5.H();
        goto L43
    L38:
        r8 = i5.t();
        goto L39
    L34:
        r7 = v19.c.b(2130972079, getContext(), 2131103136);
    L30:
        r17 = false;
        goto L31
    L27:
        if (r41.getMessageStatusLocal() != 22) goto L30;
    L23:
        r29 = true;
        goto L25
    L9:
        if (r41.getMessageStatusLocal() == 22) goto L18;
        if (com.larus.bmhome.chat.bean.d.I0(r41) == false) goto L13;
    L17:
        r1 = false;
        goto L19
    L13:
        if (r41.getMessageStatusLocal() == 20) goto L17;
        if (com.larus.bmhome.chat.bean.d.Q0(r41) == true) goto L17;
    L5:
        r2 = null;
        goto L6
    }
}
