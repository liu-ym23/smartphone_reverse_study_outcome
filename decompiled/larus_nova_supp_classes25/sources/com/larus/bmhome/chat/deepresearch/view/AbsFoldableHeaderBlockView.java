package com.larus.bmhome.chat.deepresearch.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.module.ImageBlock;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.CodeBlock;
import com.larus.im.bean.message.block.GenImageBlock;
import com.larus.im.bean.message.block.LinkReaderBlock;
import com.larus.im.bean.message.block.LocalLifeBlock;
import com.larus.im.bean.message.block.ResearchStatusBlock;
import com.larus.im.bean.message.block.RoutePlanBlock;
import com.larus.im.bean.message.block.SearchResultBlock;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.bean.message.block.VideoReaderBlock;
import com.larus.mainbot.impl.databinding.LarusBlockItemHeaderFoldTextBinding;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001e\u00105\u001a\u0002062\u0006\u0010\u001a\u001a\u00020\u000f2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001cJ\b\u00107\u001a\u0004\u0018\u00010\u0011J\u001a\u00108\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J(\u00109\u001a\u0002062\b\u0010:\u001a\u0004\u0018\u00010;2\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020=\u0018\u00010\u0017H\u0016J\u001a\u0010>\u001a\u0002062\u0006\u0010?\u001a\u00020\u000f2\b\b\u0002\u0010@\u001a\u00020\u000fH\u0002J\b\u0010A\u001a\u00020\u000fH\u0016J\"\u0010B\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110C2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u0012\u0010D\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\n\u0010E\u001a\u0004\u0018\u00010FH&R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001c\u0010,\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006G"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/view/AbsFoldableHeaderBlockView;", "Lcom/larus/bmhome/chat/deepresearch/view/AbsBlockView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemHeaderFoldTextBinding;", "isProgressContent", "", "currentPage", "", "getCurrentPage", "()Ljava/lang/String;", "setCurrentPage", "(Ljava/lang/String;)V", "foldState", "", "animator", "Landroid/animation/ValueAnimator;", "disableFoldExpandClick", "clickInterceptor", "Lkotlin/Function0;", "mobMessage", "Lcom/larus/im/bean/message/Message;", "getMobMessage", "()Lcom/larus/im/bean/message/Message;", "setMobMessage", "(Lcom/larus/im/bean/message/Message;)V", "mobBotModel", "Lcom/larus/im/bean/bot/BotModel;", "getMobBotModel", "()Lcom/larus/im/bean/bot/BotModel;", "setMobBotModel", "(Lcom/larus/im/bean/bot/BotModel;)V", "mobResearchId", "getMobResearchId", "setMobResearchId", "mobPreviousPage", "getMobPreviousPage", "setMobPreviousPage", "toolHeader", "Lcom/larus/bmhome/chat/markdown/view/DeepThinkCommonToolHeader;", "getToolHeader", "()Lcom/larus/bmhome/chat/markdown/view/DeepThinkCommonToolHeader;", "setToolHeader", "(Lcom/larus/bmhome/chat/markdown/view/DeepThinkCommonToolHeader;)V", "configureFoldInteraction", "", "currentToolTitle", "init", "bindData", "data", "Lcom/larus/im/bean/message/block/Block;", "extra", "", "refreshImageViewFoldStatus", "foldStatus", "withAnim", "enableFold", "getBlockIconUrls", "Lkotlin/Pair;", "getDataListIdentifier", "getContentBlockView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class AbsFoldableHeaderBlockView extends AbsBlockView {
    public static final /* synthetic */ int m = 0;
    public LarusBlockItemHeaderFoldTextBinding b;
    public String c;
    public Map<String, Boolean> d;
    public ValueAnimator e;
    public boolean f;
    public Function0<Boolean> g;
    public Message h;
    public BotModel i;
    public String j;
    public String k;
    public DeepThinkCommonToolHeader l;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            View r4 = this.a;
            boolean r0 = this.b;
            ViewGroup.LayoutParams r1 = r4.getLayoutParams();
            if (r1 == null) goto L10;
            if (r0 == false) goto L6;
            int r2 = 0;
        L7:
            r1.height = r2;
            r4.setLayoutParams(r1);
            return;
        L6:
            r2 = -2;
            goto L7
        L10:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }

        public a(View r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public boolean d() {
        return true;
    }

    public abstract View getContentBlockView();

    public final String getCurrentPage() {
        return this.c;
    }

    public final BotModel getMobBotModel() {
        return this.i;
    }

    public final Message getMobMessage() {
        return this.h;
    }

    public final String getMobPreviousPage() {
        return this.k;
    }

    public final String getMobResearchId() {
        return this.j;
    }

    public final DeepThinkCommonToolHeader getToolHeader() {
        return this.l;
    }

    public AbsFoldableHeaderBlockView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final String e(Block r1) {
        if (r1 == null) goto L5;
        String r2 = r1.getBlockId();
        if (r2 == null) goto L5;
        return r2;
    L5:
        return "";
    }

    public final void setCurrentPage(String r1) {
        this.c = r1;
    }

    public final void setMobBotModel(BotModel r1) {
        this.i = r1;
    }

    public final void setMobMessage(Message r1) {
        this.h = r1;
    }

    public final void setMobPreviousPage(String r1) {
        this.k = r1;
    }

    public final void setMobResearchId(String r1) {
        this.j = r1;
    }

    public final void setToolHeader(DeepThinkCommonToolHeader r1) {
        this.l = r1;
    }

    public AbsFoldableHeaderBlockView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public void a(final Block r12, final Map<String, Object> r13) {
        Function0 r0 = null;
        if (r13 == null) goto L5;
        Object r1 = r13.get("block_view_extra_current_page");
    L7:
        if ((r1 instanceof String) == false) goto L9;
        String r2 = (String) r1;
    L10:
        this.c = r2;
        if (r13 == null) goto L13;
        Object r3 = r13.get("block_view_extra_fold_states");
    L15:
        if (TypeIntrinsics.isMutableMap(r3) == false) goto L17;
        Map<String, Boolean> r4 = (Map) r3;
    L18:
        this.d = r4;
        if (r13 == null) goto L21;
        Object r5 = r13.get("block_view_extra_message");
    L23:
        if ((r5 instanceof Message) == false) goto L25;
        Message r6 = (Message) r5;
    L26:
        this.h = r6;
        if (r13 == null) goto L29;
        Object r7 = r13.get("block_view_extra_previous_page");
    L31:
        if ((r7 instanceof String) == false) goto L33;
        String r8 = (String) r7;
    L34:
        this.k = r8;
        if (r13 == null) goto L37;
        Object r9 = r13.get("block_view_extra_bot_model");
    L39:
        if ((r9 instanceof BotModel) == false) goto L41;
        BotModel r10 = (BotModel) r9;
    L42:
        this.i = r10;
        if (r13 == null) goto L45;
        Object r11 = r13.get("block_view_extra_mob_research_id");
    L47:
        if ((r11 instanceof String) == false) goto L49;
        String r14 = (String) r11;
    L50:
        this.j = r14;
        if (r13 == null) goto L53;
        Object r15 = r13.get("block_view_outer_block_status");
    L55:
        if ((r15 instanceof Boolean) == false) goto L57;
        Boolean r16 = (Boolean) r15;
    L59:
        if (r12 != null) goto L61;
    L63:
        boolean r17 = false;
    L64:
        if (r17 == false) goto L66;
    L69:
        boolean r18 = true;
    L70:
        String r19 = AbsBlockView.a.f(r12, Intrinsics.areEqual(this.c, "dr_process_detail"), false);
        if (r19 != null) goto L73;
    L76:
        boolean r20 = true;
    L78:
        if (r20 == false) goto L85;
        LarusBlockItemHeaderFoldTextBinding r110 = this.b;
        if (r110 == null) goto L284;
        LinearLayout r111 = r110.a;
        if (r111 == null) goto L285;
        r111.setVisibility(8);
        return;
    L285:
        return;
    L284:
        return;
    L85:
        LarusBlockItemHeaderFoldTextBinding r21 = this.b;
        if (r21 == null) goto L90;
        LinearLayout r22 = r21.a;
        if (r22 == null) goto L90;
        r22.setVisibility(0);
    L90:
        if (r18 == false) goto L94;
        View r23 = getContentBlockView();
        if (r23 == null) goto L100;
        r23.setVisibility(0);
    L100:
        if (r12 != null) goto L102;
        Pair r24 = new Pair(null, null);
    L259:
        String r25 = (String) r24.component1();
        String r26 = (String) r24.component2();
        DeepThinkCommonToolHeader r27 = this.l;
        if (r27 == null) goto L262;
        r27.b(ToolType.Default, true, r25, r26);
    L262:
        Map<String, Boolean> r28 = this.d;
        if (r28 == null) goto L267;
        Boolean r29 = r28.get(e(r12));
        if (r29 == null) goto L267;
        boolean r30 = r29.booleanValue();
    L269:
        if (d() == false) goto L278;
        if (r18 == false) goto L278;
        boolean r31 = this.f;
        if (r31 == true) goto L275;
        r0 = new d(this, r12, r13);
    L275:
        Function0 r112 = r0;
        DeepThinkCommonToolHeader r32 = this.l;
        if (r32 == null) goto L282;
        r32.d(ToolType.SearchPlugin, r19, r30, Boolean.valueOf(r31), r112);
    L282:
        f(r30, false);
        return;
    L278:
        if (r18 == false) goto L282;
        DeepThinkCommonToolHeader r33 = this.l;
        if (r33 == null) goto L282;
        r33.d(ToolType.SearchPlugin, r19, r30, Boolean.TRUE, null);
    L267:
        r30 = false;
        goto L269
    L102:
        int r34 = r12.getBlockType();
        if (r34 != j.e) goto L118;
        BlockContent r35 = r12.getContent();
        if (r35 == null) goto L109;
        TextBlock r36 = r35.getTextBlock();
        if (r36 == null) goto L109;
        String r37 = r36.iconUrl;
    L110:
        BlockContent r38 = r12.getContent();
        if (r38 == null) goto L115;
        TextBlock r39 = r38.getTextBlock();
        if (r39 == null) goto L115;
        String r40 = r39.iconUrlDark;
    L116:
        r24 = new Pair(r37, r40);
    L115:
        r40 = null;
    L109:
        r37 = null;
        goto L110
    L118:
        if (r34 != j.k) goto L133;
        BlockContent r41 = r12.getContent();
        if (r41 == null) goto L124;
        SearchResultBlock r42 = r41.getSearchResultBlock();
        if (r42 == null) goto L124;
        String r43 = r42.iconUrl;
    L125:
        BlockContent r44 = r12.getContent();
        if (r44 == null) goto L130;
        SearchResultBlock r45 = r44.getSearchResultBlock();
        if (r45 == null) goto L130;
        String r46 = r45.iconUrlDark;
    L131:
        r24 = new Pair(r43, r46);
    L130:
        r46 = null;
    L124:
        r43 = null;
        goto L125
    L133:
        if (r34 != j.l) goto L148;
        BlockContent r47 = r12.getContent();
        if (r47 == null) goto L139;
        SearchResultBlock r48 = r47.getSearchResultBlock();
        if (r48 == null) goto L139;
        String r49 = r48.iconUrl;
    L140:
        BlockContent r50 = r12.getContent();
        if (r50 == null) goto L145;
        SearchResultBlock r51 = r50.getSearchResultBlock();
        if (r51 == null) goto L145;
        String r52 = r51.iconUrlDark;
    L146:
        r24 = new Pair(r49, r52);
    L145:
        r52 = null;
    L139:
        r49 = null;
        goto L140
    L148:
        if (r34 != j.m) goto L163;
        BlockContent r53 = r12.getContent();
        if (r53 == null) goto L154;
        LinkReaderBlock r54 = r53.getLinkReaderBlock();
        if (r54 == null) goto L154;
        String r55 = r54.iconUrl;
    L155:
        BlockContent r56 = r12.getContent();
        if (r56 == null) goto L160;
        LinkReaderBlock r57 = r56.getLinkReaderBlock();
        if (r57 == null) goto L160;
        String r58 = r57.iconUrlDark;
    L161:
        r24 = new Pair(r55, r58);
    L160:
        r58 = null;
    L154:
        r55 = null;
        goto L155
    L163:
        if (r34 != j.n) goto L178;
        BlockContent r59 = r12.getContent();
        if (r59 == null) goto L169;
        VideoReaderBlock r60 = r59.getVideoReaderBlock();
        if (r60 == null) goto L169;
        String r61 = r60.iconUrl;
    L170:
        BlockContent r62 = r12.getContent();
        if (r62 == null) goto L175;
        VideoReaderBlock r63 = r62.getVideoReaderBlock();
        if (r63 == null) goto L175;
        String r64 = r63.iconUrlDark;
    L176:
        r24 = new Pair(r61, r64);
    L175:
        r64 = null;
    L169:
        r61 = null;
        goto L170
    L178:
        if (r34 != j.o) goto L193;
        BlockContent r65 = r12.getContent();
        if (r65 == null) goto L184;
        CodeBlock r66 = r65.getCodeBlock();
        if (r66 == null) goto L184;
        String r67 = r66.iconUrl;
    L185:
        BlockContent r68 = r12.getContent();
        if (r68 == null) goto L190;
        CodeBlock r69 = r68.getCodeBlock();
        if (r69 == null) goto L190;
        String r70 = r69.iconUrlDark;
    L191:
        r24 = new Pair(r67, r70);
    L190:
        r70 = null;
    L184:
        r67 = null;
        goto L185
    L193:
        if (r34 != j.p) goto L208;
        BlockContent r71 = r12.getContent();
        if (r71 == null) goto L199;
        LocalLifeBlock r72 = r71.getLocalLifeBlock();
        if (r72 == null) goto L199;
        String r73 = r72.iconUrl;
    L200:
        BlockContent r74 = r12.getContent();
        if (r74 == null) goto L205;
        LocalLifeBlock r75 = r74.getLocalLifeBlock();
        if (r75 == null) goto L205;
        String r76 = r75.iconUrlDark;
    L206:
        r24 = new Pair(r73, r76);
    L205:
        r76 = null;
    L199:
        r73 = null;
        goto L200
    L208:
        if (r34 != j.q) goto L219;
        GenImageBlock r77 = AbsBlockView.a.a(r12);
        if (r77 == null) goto L212;
        String r78 = r77.iconUrl;
    L213:
        if (r77 == null) goto L215;
        String r79 = r77.iconUrlDark;
    L216:
        Pair r80 = new Pair(r78, r79);
    L217:
        r24 = r80;
        goto L259
    L215:
        r79 = null;
        goto L216
    L212:
        r78 = null;
        goto L213
    L219:
        if (r34 != j.s) goto L229;
        ImageBlock r81 = AbsBlockView.a.b(r12);
        if (r81 == null) goto L223;
        String r82 = r81.iconUrl;
    L224:
        if (r81 == null) goto L226;
        String r83 = r81.iconUrlDark;
    L227:
        r80 = new Pair(r82, r83);
        goto L217
    L226:
        r83 = null;
        goto L227
    L223:
        r82 = null;
        goto L224
    L229:
        if (r34 != j.u) goto L244;
        BlockContent r84 = r12.getContent();
        if (r84 == null) goto L235;
        ResearchStatusBlock r85 = r84.getResearchStatusBlock();
        if (r85 == null) goto L235;
        String r86 = r85.iconUrl;
    L236:
        BlockContent r87 = r12.getContent();
        if (r87 == null) goto L241;
        ResearchStatusBlock r88 = r87.getResearchStatusBlock();
        if (r88 == null) goto L241;
        String r89 = r88.iconUrlDark;
    L242:
        r24 = new Pair(r86, r89);
    L241:
        r89 = null;
    L235:
        r86 = null;
        goto L236
    L244:
        if (r34 != j.x) goto L258;
        BlockContent r90 = r12.getContent();
        if (r90 == null) goto L250;
        RoutePlanBlock r91 = r90.getRoutePlanBlock();
        if (r91 == null) goto L250;
        String r92 = r91.iconUrl;
    L251:
        BlockContent r93 = r12.getContent();
        if (r93 == null) goto L256;
        RoutePlanBlock r94 = r93.getRoutePlanBlock();
        if (r94 == null) goto L256;
        String r95 = r94.iconUrlDark;
    L257:
        r24 = new Pair(r92, r95);
    L256:
        r95 = null;
    L250:
        r92 = null;
        goto L251
    L258:
        r24 = new Pair(null, null);
        goto L259
    L94:
        DeepThinkCommonToolHeader r96 = this.l;
        if (r96 == null) goto L97;
        r96.c(CollectionsKt.listOf(r19));
    L97:
        View r97 = getContentBlockView();
        if (r97 == null) goto L100;
        r97.setVisibility(8);
        goto L100
    L73:
        if (r19.length() == 0) goto L76;
        r20 = false;
        goto L78
    L66:
        if (Intrinsics.areEqual(r16, Boolean.TRUE) == true) goto L69;
        r18 = false;
        goto L70
    L61:
        if (r12.isFinish() != true) goto L63;
        r17 = true;
        goto L64
    L57:
        r16 = null;
        goto L59
    L53:
        r15 = null;
        goto L55
    L49:
        r14 = null;
        goto L50
    L45:
        r11 = null;
        goto L47
    L41:
        r10 = null;
        goto L42
    L37:
        r9 = null;
        goto L39
    L33:
        r8 = null;
        goto L34
    L29:
        r7 = null;
        goto L31
    L25:
        r6 = null;
        goto L26
    L21:
        r5 = null;
        goto L23
    L17:
        r4 = null;
        goto L18
    L13:
        r3 = null;
        goto L15
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public void b(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        setOrientation(1);
        View r4 = LayoutInflater.from(r2).inflate(2131561833, this, false);
        addView(r4);
        DeepThinkCommonToolHeader r0 = (DeepThinkCommonToolHeader) ViewBindings.findChildViewById(r4, 2131368660);
        if (r0 == null) goto L7;
        this.b = new LarusBlockItemHeaderFoldTextBinding((LinearLayout) r4, r0);
        this.l = r0;
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(2131368660)));
    }

    public final void f(boolean r6, boolean r7) {
        final View r0 = getContentBlockView();
        if (r0 == null) goto L30;
        int r1 = 0;
        if (r7 == false) goto L22;
        r0.measure(0, 0);
        int r8 = r0.getMeasuredHeight();
        ValueAnimator r2 = this.e;
        if (r2 == null) goto L10;
        r2.cancel();
    L10:
        if (r6 == false) goto L12;
        ValueAnimator r9 = ObjectAnimator.ofInt(new int[]{Math.min(r8, r0.getHeight()), 0});
    L13:
        this.e = r9;
        if (r9 == null) goto L16;
        r9.addListener(new a(r0, r6));
    L16:
        ValueAnimator r10 = this.e;
        if (r10 == null) goto L19;
        r10.addUpdateListener(new e(r0));
    L19:
        ValueAnimator r11 = this.e;
        if (r11 == null) goto L31;
        r11.start();
        return;
    L31:
        return;
    L12:
        r9 = ObjectAnimator.ofInt(new int[]{0, r8});
        goto L13
    L22:
        ViewGroup.LayoutParams r12 = r0.getLayoutParams();
        if (r12 == null) goto L29;
        if (r6 == true) goto L27;
        r1 = -2;
    L27:
        r12.height = r1;
        r0.setLayoutParams(r12);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public AbsFoldableHeaderBlockView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
    }
}
