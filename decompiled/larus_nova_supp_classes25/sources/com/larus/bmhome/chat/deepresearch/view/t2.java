package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LinkReaderBlock;
import com.larus.im.bean.message.block.SearchQueryBlock;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusBlockItemTextSwitchBinding;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t2 extends AbsBlockView {
    public LarusBlockItemTextSwitchBinding b;
    public Message c;
    public BotModel d;
    public String e;
    public String f;
    public String g;
    public po8.z h;

    public t2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v27, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v37, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List] */
    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(final Block r14, Map<String, Object> r15) {
        String r0 = "";
        String r1 = null;
        if (r15 == null) goto L5;
        Object r2 = r15.get("block_view_extra_message");
    L7:
        if ((r2 instanceof Message) == false) goto L9;
        Message r3 = (Message) r2;
    L10:
        this.c = r3;
        if (r15 == null) goto L13;
        Object r4 = r15.get("block_view_extra_bot_model");
    L15:
        if ((r4 instanceof BotModel) == false) goto L17;
        BotModel r5 = (BotModel) r4;
    L18:
        this.d = r5;
        if (r15 == null) goto L21;
        Object r6 = r15.get("block_view_extra_mob_research_id");
    L23:
        if ((r6 instanceof String) == false) goto L25;
        String r7 = (String) r6;
    L26:
        this.e = r7;
        if (r15 == null) goto L29;
        Object r8 = r15.get("block_view_extra_previous_page");
    L31:
        if ((r8 instanceof String) == false) goto L33;
        String r9 = (String) r8;
    L34:
        this.f = r9;
        if (r15 == null) goto L37;
        Object r16 = r15.get("block_view_extra_current_page");
    L39:
        if ((r16 instanceof String) == false) goto L41;
        String r17 = (String) r16;
    L42:
        this.g = r17;
        final LarusBlockItemTextSwitchBinding r18 = this.b;
        boolean r10 = true;
        if (r18 == null) goto L310;
        AbsBlockView.a.e(r18.b, r14);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L220
        if (r14 == null) goto L48;
        Integer r12 = Integer.valueOf(r14.getBlockType());     // Catch: Throwable -> L220
    L49:
        int r13 = j.k;     // Catch: Throwable -> L220
        if (r12 != null) goto L53;
    L182:
        int r19 = j.m;     // Catch: Throwable -> L220
        if (r12 != null) goto L186;
    L218:
        ?? r20 = CollectionsKt.emptyList();     // Catch: Throwable -> L220
    L225:
        ?? r21 = r20;
        if (r14 != null) goto L228;
    L230:
        boolean r22 = false;
    L231:
        if (r22 == false) goto L259;
        po8.z r23 = this.h;
        if (r23 == null) goto L235;
        r23.b();
    L235:
        TextSwitcher r24 = r18.d;
        if (r24 == null) goto L238;
        r24.setInAnimation(null);
    L238:
        TextSwitcher r25 = r18.d;
        if (r25 == null) goto L241;
        r25.setOutAnimation(null);
    L241:
        TextSwitcher r26 = r18.d;
        if (r21 == 0) goto L247;
        String r27 = (String) CollectionsKt.getOrNull(r21, 0);
        if (r27 == null) goto L247;
        r0 = r27;
    L247:
        r26.setText(r0);
        Object r28 = r18.d.getNextView();
        if ((r28 instanceof ShimmerTextView) == false) goto L250;
        ShimmerTextView r29 = (ShimmerTextView) r28;
    L251:
        Object r110 = r18.d.getCurrentView();
        if ((r110 instanceof ShimmerTextView) == false) goto L254;
        ShimmerTextView r111 = (ShimmerTextView) r110;
    L255:
        if (r29 == null) goto L257;
        r29.x();
    L257:
        if (r111 == null) goto L265;
        r111.x();
    L265:
        if (r14 == null) goto L267;
        Integer r112 = Integer.valueOf(r14.getBlockType());
    L268:
        int r30 = j.k;
        if (r112 != null) goto L272;
    L283:
        boolean r113 = false;
    L284:
        if (r113 == false) goto L305;
        LarusBlockItemTextSwitchBinding r114 = this.b;
        if (r114 == null) goto L290;
        AppCompatTextView r115 = r114.c;
        if (r115 == null) goto L290;
        r115.setVisibility(0);
    L290:
        LarusBlockItemTextSwitchBinding r116 = this.b;
        if (r116 == null) goto L295;
        AppCompatTextView r31 = r116.c;
        if (r31 == null) goto L295;
        we8.a.b(r31, i5.o(), false, null, null, 12);
    L295:
        LarusBlockItemTextSwitchBinding r117 = this.b;
        if (r117 == null) goto L300;
        AppCompatTextView r118 = r117.c;
        if (r118 == null) goto L300;
        r118.setLineHeight(i5.E());
    L300:
        LarusBlockItemTextSwitchBinding r119 = this.b;
        if (r119 == null) goto L310;
        AppCompatTextView r120 = r119.c;
        if (r120 == null) goto L310;
        r120.setText(AbsBlockView.a.f(r14, false, false));
        goto L310
    L305:
        LarusBlockItemTextSwitchBinding r121 = this.b;
        if (r121 == null) goto L310;
        AppCompatTextView r122 = r121.c;
        if (r122 == null) goto L310;
        r122.setVisibility(8);
        goto L310
    L272:
        if (r112.intValue() != r30) goto L283;
        if (r14.isFinish() == false) goto L283;
        BlockContent r123 = r14.getContent();
        if (r123 == null) goto L281;
        SearchQueryBlock r124 = r123.getSearchQueryBlock();
        if (r124 == null) goto L281;
        r1 = r124.summaryV2;
    L281:
        if (com.larus.utils.o0.d(r1) == false) goto L283;
        r113 = true;
        goto L284
    L267:
        r112 = null;
        goto L268
    L254:
        r111 = null;
        goto L255
    L250:
        r29 = null;
        goto L251
    L259:
        po8.z r32 = this.h;
        if (r32 == null) goto L262;
        r32.b();
    L262:
        po8.z r33 = new po8.z(r18.d, r21, 1000, new o2(r18));
        this.h = r33;
        r33.a(r18.d.getContext());
        po8.z r125 = this.h;
        if (r125 == null) goto L265;
        r125.c();
        goto L265
    L228:
        if (r14.isFinish() != true) goto L230;
        r22 = true;
        goto L231
    L186:
        if (r12.intValue() != r19) goto L218;
        if (r14 == null) goto L208;
        BlockContent r34 = r14.getContent();     // Catch: Throwable -> L220
        if (r34 == null) goto L208;
        LinkReaderBlock r35 = r34.getLinkReaderBlock();     // Catch: Throwable -> L220
        if (r35 == null) goto L208;
        List r36 = r35.items;     // Catch: Throwable -> L220
        if (r36 == null) goto L208;
        ArrayList r37 = new ArrayList();     // Catch: Throwable -> L220
        Iterator r38 = r36.iterator();     // Catch: Throwable -> L220
    L196:
        if (r38.hasNext() == false) goto L207;
        TextCard r39 = (TextCard) r38.next();     // Catch: Throwable -> L220
        StringCompanionObject r40 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L220
        BlockContent r41 = r14.getContent();     // Catch: Throwable -> L220
        if (r41 == null) goto L203;
        LinkReaderBlock r42 = r41.getLinkReaderBlock();     // Catch: Throwable -> L220
        if (r42 == null) goto L203;
        String r43 = r42.summary;     // Catch: Throwable -> L220
        if (r43 == null) goto L203;
    L204:
        String r44 = String.format(r43, Arrays.copyOf(new Object[]{r39}, 1));     // Catch: Throwable -> L220
        if (r44 == null) goto L196;
        r37.add(r44);     // Catch: Throwable -> L220
    L203:
        r43 = "";
        goto L204
    L207:
        r20 = r37;
    L209:
        if (r20 != 0) goto L225;
        BlockContent r45 = r14.getContent();     // Catch: Throwable -> L220
        if (r45 == null) goto L216;
        LinkReaderBlock r46 = r45.getLinkReaderBlock();     // Catch: Throwable -> L220
        if (r46 == null) goto L216;
        String r47 = r46.summary;     // Catch: Throwable -> L220
        if (r47 == null) goto L216;
    L217:
        r20 = CollectionsKt.listOf(r47);     // Catch: Throwable -> L220
    L216:
        r47 = "";
    L208:
        r20 = 0;
        goto L209
    L53:
        if (r12.intValue() != r13) goto L182;
        BlockContent r48 = r14.getContent();     // Catch: Throwable -> L220
        if (r48 == null) goto L59;
        SearchQueryBlock r49 = r48.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r49 == null) goto L59;
        String r50 = r49.summaryV2;     // Catch: Throwable -> L220
    L60:
        if (r50 != null) goto L62;
    L65:
        boolean r51 = true;
    L67:
        if (r51 == false) goto L106;
        BlockContent r52 = r14.getContent();     // Catch: Throwable -> L220
        if (r52 == null) goto L95;
        SearchQueryBlock r53 = r52.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r53 == null) goto L95;
        List r54 = r53.queries;     // Catch: Throwable -> L220
        if (r54 == null) goto L95;
        r20 = new ArrayList();     // Catch: Throwable -> L220
        Iterator r55 = r54.iterator();     // Catch: Throwable -> L220
    L76:
        if (r55.hasNext() == false) goto L96;
        String r56 = (String) r55.next();     // Catch: Throwable -> L220
        StringCompanionObject r57 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L220
        BlockContent r58 = r14.getContent();     // Catch: Throwable -> L220
        if (r58 == null) goto L83;
        SearchQueryBlock r59 = r58.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r59 == null) goto L83;
        String r60 = r59.summary;     // Catch: Throwable -> L220
        if (r60 == null) goto L83;
    L84:
        Object[] r61 = new Object[2];     // Catch: Throwable -> L220
        r61[0] = r56;     // Catch: Throwable -> L220
        BlockContent r62 = r14.getContent();     // Catch: Throwable -> L220
        if (r62 == null) goto L91;
        SearchQueryBlock r63 = r62.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r63 == null) goto L91;
        List r64 = r63.queries;     // Catch: Throwable -> L220
        if (r64 == null) goto L91;
        Integer r65 = Integer.valueOf(r64.size());     // Catch: Throwable -> L220
    L92:
        r61[1] = r65;     // Catch: Throwable -> L220
        String r66 = String.format(r60, Arrays.copyOf(r61, 2));     // Catch: Throwable -> L220
        if (r66 == null) goto L76;
        r20.add(r66);     // Catch: Throwable -> L220
    L91:
        r65 = null;
    L83:
        r60 = "";
    L96:
        if (r20 != 0) goto L225;
        BlockContent r67 = r14.getContent();     // Catch: Throwable -> L220
        if (r67 == null) goto L103;
        SearchQueryBlock r68 = r67.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r68 == null) goto L103;
        String r69 = r68.summary;     // Catch: Throwable -> L220
        if (r69 == null) goto L103;
    L104:
        r20 = CollectionsKt.listOf(r69);     // Catch: Throwable -> L220
    L103:
        r69 = "";
    L95:
        r20 = 0;
        goto L96
    L106:
        if (r14.isFinish() == false) goto L145;
        BlockContent r70 = r14.getContent();     // Catch: Throwable -> L220
        if (r70 == null) goto L135;
        SearchQueryBlock r71 = r70.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r71 == null) goto L135;
        List r72 = r71.queries;     // Catch: Throwable -> L220
        if (r72 == null) goto L135;
        ArrayList r73 = new ArrayList();     // Catch: Throwable -> L220
        Iterator r74 = r72.iterator();     // Catch: Throwable -> L220
    L115:
        if (r74.hasNext() == false) goto L134;
        String r75 = (String) r74.next();     // Catch: Throwable -> L220
        StringCompanionObject r76 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L220
        BlockContent r77 = r14.getContent();     // Catch: Throwable -> L220
        if (r77 == null) goto L122;
        SearchQueryBlock r78 = r77.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r78 == null) goto L122;
        String r79 = r78.summaryV2;     // Catch: Throwable -> L220
        if (r79 == null) goto L122;
    L123:
        Object[] r80 = new Object[1];     // Catch: Throwable -> L220
        BlockContent r81 = r14.getContent();     // Catch: Throwable -> L220
        if (r81 == null) goto L130;
        SearchQueryBlock r82 = r81.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r82 == null) goto L130;
        List r83 = r82.queries;     // Catch: Throwable -> L220
        if (r83 == null) goto L130;
        Integer r84 = Integer.valueOf(r83.size());     // Catch: Throwable -> L220
    L131:
        r80[0] = r84;     // Catch: Throwable -> L220
        String r85 = String.format(r79, Arrays.copyOf(r80, 1));     // Catch: Throwable -> L220
        if (r85 == null) goto L115;
        r73.add(r85);     // Catch: Throwable -> L220
    L130:
        r84 = null;
    L122:
        r79 = "";
        goto L123
    L134:
        r20 = r73;
    L136:
        if (r20 != 0) goto L225;
        BlockContent r86 = r14.getContent();     // Catch: Throwable -> L220
        if (r86 == null) goto L143;
        SearchQueryBlock r87 = r86.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r87 == null) goto L143;
        String r88 = r87.summaryV2;     // Catch: Throwable -> L220
        if (r88 == null) goto L143;
    L144:
        r20 = CollectionsKt.listOf(r88);     // Catch: Throwable -> L220
    L143:
        r88 = "";
    L135:
        r20 = 0;
        goto L136
    L145:
        BlockContent r89 = r14.getContent();     // Catch: Throwable -> L220
        if (r89 == null) goto L172;
        SearchQueryBlock r90 = r89.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r90 == null) goto L172;
        List r91 = r90.queries;     // Catch: Throwable -> L220
        if (r91 == null) goto L172;
        r20 = new ArrayList();     // Catch: Throwable -> L220
        Iterator r92 = r91.iterator();     // Catch: Throwable -> L220
    L153:
        if (r92.hasNext() == false) goto L173;
        String r93 = (String) r92.next();     // Catch: Throwable -> L220
        StringCompanionObject r94 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L220
        BlockContent r95 = r14.getContent();     // Catch: Throwable -> L220
        if (r95 == null) goto L160;
        SearchQueryBlock r96 = r95.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r96 == null) goto L160;
        String r97 = r96.summaryV2;     // Catch: Throwable -> L220
        if (r97 == null) goto L160;
    L161:
        Object[] r99 = new Object[2];     // Catch: Throwable -> L220
        r99[0] = r93;     // Catch: Throwable -> L220
        BlockContent r100 = r14.getContent();     // Catch: Throwable -> L220
        if (r100 == null) goto L168;
        SearchQueryBlock r101 = r100.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r101 == null) goto L168;
        List r102 = r101.queries;     // Catch: Throwable -> L220
        if (r102 == null) goto L168;
        Integer r103 = Integer.valueOf(r102.size());     // Catch: Throwable -> L220
    L169:
        r99[1] = r103;     // Catch: Throwable -> L220
        String r104 = String.format(r97, Arrays.copyOf(r99, 2));     // Catch: Throwable -> L220
        if (r104 == null) goto L153;
        r20.add(r104);     // Catch: Throwable -> L220
    L168:
        r103 = null;
    L160:
        r97 = "";
    L173:
        if (r20 != 0) goto L225;
        BlockContent r105 = r14.getContent();     // Catch: Throwable -> L220
        if (r105 == null) goto L180;
        SearchQueryBlock r106 = r105.getSearchQueryBlock();     // Catch: Throwable -> L220
        if (r106 == null) goto L180;
        String r107 = r106.summaryV2;     // Catch: Throwable -> L220
        if (r107 == null) goto L180;
    L181:
        r20 = CollectionsKt.listOf(r107);     // Catch: Throwable -> L220
    L180:
        r107 = "";
    L172:
        r20 = 0;
        goto L173
    L62:
        if (r50.length() == 0) goto L65;
        r51 = false;
    L59:
        r50 = null;
        goto L60
    L48:
        r12 = null;
    L220:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Throwable r109 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r109 == null) goto L224;
        com.larus.platform.service.g.a.ensureNotReachHere(r109);
        FLogger.a.i("AbsBlockView", r109.toString());
        r20 = CollectionsKt.emptyList();
        goto L225
    L224:
        r20 = CollectionsKt.emptyList();
    L310:
        String r126 = AbsBlockView.a.d(r14);
        if (r126 != null) goto L313;
    L316:
        if (r10 == true) goto L341;
        ExposureTrackerExtKt.a(this, new q2(r14, this));
        return;
    L341:
        return;
    L313:
        if (r126.length() == 0) goto L316;
        r10 = false;
        goto L316
    L41:
        r17 = null;
        goto L42
    L37:
        r16 = null;
        goto L39
    L33:
        r9 = null;
        goto L34
    L29:
        r8 = null;
        goto L31
    L25:
        r7 = null;
        goto L26
    L21:
        r6 = null;
        goto L23
    L17:
        r5 = null;
        goto L18
    L13:
        r4 = null;
        goto L15
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(final Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        View r7 = LayoutInflater.from(r5).inflate(2131561842, this, false);
        addView(r7);
        int r0 = 2131368711;
        SimpleDraweeView r1 = ViewBindings.findChildViewById(r7, 2131368711);
        if (r1 == null) goto L11;
        r0 = 2131368657;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r7, 2131368657);
        if (r2 == null) goto L11;
        r0 = 2131384405;
        TextSwitcher r3 = (TextSwitcher) ViewBindings.findChildViewById(r7, 2131384405);
        if (r3 == null) goto L11;
        final LarusBlockItemTextSwitchBinding r4 = new LarusBlockItemTextSwitchBinding((LinearLayout) r7, r1, r2, r3);
        this.b = r4;
        r3.setFactory(new p2(r4, r5));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }
}
