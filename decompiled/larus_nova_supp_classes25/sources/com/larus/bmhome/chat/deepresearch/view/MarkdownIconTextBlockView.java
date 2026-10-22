package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusBlockItemMarkdownTextWithIconBinding;
import com.larus.mainbot.impl.databinding.LarusBlockItemMarkdownTextWithIconSubBinding;
import com.larus.platform.model.MarkDownSelectorSettings;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001,\u0018\u0000 L2\u00020\u0001:\u0001LB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010'\u001a\u00020\u0016H\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\u0010\u0010.\u001a\u00020/2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u001a\u00100\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J(\u00106\u001a\u00020/2\b\u00107\u001a\u0004\u0018\u0001082\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020;\u0018\u00010:H\u0016J\u0012\u0010<\u001a\u00020/2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u0006\u0010=\u001a\u00020/J\u001a\u0010>\u001a\u00020/2\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u0016J\u001a\u0010B\u001a\u00020/2\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u0016J4\u0010C\u001a\u00020/2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0016H\u0002J\b\u0010H\u001a\u00020/H\u0014J\b\u0010I\u001a\u00020/H\u0016J\u0012\u0010J\u001a\u00020\u00162\b\u00107\u001a\u0004\u0018\u000108H\u0002J(\u0010K\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u0001082\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020;\u0018\u00010:H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u000e\u0010)\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010&\u001a\u0004\b3\u00104¨\u0006M"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/view/MarkdownIconTextBlockView;", "Lcom/larus/bmhome/chat/deepresearch/view/AbsBlockView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemMarkdownTextWithIconBinding;", "iconBinding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemMarkdownTextWithIconSubBinding;", "mobMessage", "Lcom/larus/im/bean/message/Message;", "mobBotModel", "Lcom/larus/im/bean/bot/BotModel;", "mobChatKey", "", "Ljava/lang/Long;", "isProgressContent", "", "currentPage", "", "mobPreviousPage", "mobResearchId", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "markDownSelectHelper", "Lcom/larus/bmhome/chat/api/IMarkDownSelectHelper;", "getMarkDownSelectHelper", "()Lcom/larus/bmhome/chat/api/IMarkDownSelectHelper;", "markDownSelectorSettings", "Lcom/larus/platform/model/MarkDownSelectorSettings;", "getMarkDownSelectorSettings", "()Lcom/larus/platform/model/MarkDownSelectorSettings;", "markDownSelectorSettings$delegate", "Lkotlin/Lazy;", "isTripleClickEnabled", "isReClickEnabled", "latestDoubleClickTime", "latestTripleClickTime", "clickRunnable", "com/larus/bmhome/chat/deepresearch/view/MarkdownIconTextBlockView$clickRunnable$1", "Lcom/larus/bmhome/chat/deepresearch/view/MarkdownIconTextBlockView$clickRunnable$1;", "bindRecycleView", "", "init", "markdownRenderHelper", "Lcom/larus/bmhome/chat/list/cell/text/markdown/MarkdownRenderHelper;", "getMarkdownRenderHelper", "()Lcom/larus/bmhome/chat/list/cell/text/markdown/MarkdownRenderHelper;", "markdownRenderHelper$delegate", "bindData", "data", "Lcom/larus/im/bean/message/block/Block;", "extra", "", "", "tryMobCardShow", "performSingleClick", "performDoubleClick", "markdownTextView", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "isReClick", "performTripleClick", "doPerformClick", "fragment", "Lcom/larus/trace/tracknode/TraceFragment;", "clickFrom", "clickCount", "onDetachedFromWindow", "onViewRecycled", "needShowIcon", "getMaxContentWidth", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MarkdownIconTextBlockView extends AbsBlockView {
    public static final /* synthetic */ int r = 0;
    public LarusBlockItemMarkdownTextWithIconBinding b;
    public LarusBlockItemMarkdownTextWithIconSubBinding c;
    public Message d;
    public BotModel e;
    public Long f;
    public boolean g;
    public String h;
    public String i;
    public String j;
    public RecyclerView k;
    public final com.larus.bmhome.chat.api.z l;
    public final Lazy m;
    public long n;
    public long o;
    public final b p;
    public final Lazy q;

    public static final class a {
    }

    public static final class b implements Runnable {
        public int a;
        public CustomMarkdownTextView b;
        public final /* synthetic */ MarkdownIconTextBlockView c;

        public final void a() {
            int r0 = this.a;
            if (r0 != 1) goto L6;
            this.c.getClass();
            zh8.a.a.getReceiver().c().i6("MarkdownIconTextBlockView performSingleClick", true);
        L13:
            this.a = 0;
            return;
        L6:
            if (r0 != 2) goto L9;
            MarkdownIconTextBlockView r1 = this.c;
            r1.n = SystemClock.elapsedRealtime();
            this.c.g(this.b, false);
            goto L13
        L9:
            if (r0 != 3) goto L13;
            MarkdownIconTextBlockView r2 = this.c;
            int r3 = MarkdownIconTextBlockView.r;
            if (r2.f() == false) goto L13;
            MarkdownIconTextBlockView r4 = this.c;
            r4.o = SystemClock.elapsedRealtime();
            this.c.h(this.b, false);
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(MarkdownIconTextBlockView r1) {
            this.c = r1;
        }
    }

    public static final class c implements com.larus.bmhome.chat.api.d0 {
        public final /* synthetic */ CustomMarkdownTextView a;
        public final /* synthetic */ MarkdownIconTextBlockView b;

        public c(CustomMarkdownTextView r1, MarkdownIconTextBlockView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void a(View r2, int r3, int r4) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (Intrinsics.areEqual(r2, this.a) == true) goto L7;
            return;
        L7:
            if (r4 == 2) goto L9;
            return;
        L9:
            if (MarkdownIconTextBlockView.d(this.b) == false) goto L14;
            final MarkdownIconTextBlockView r5 = this.b;
            final CustomMarkdownTextView r6 = this.a;
            r2.postDelayed(new o0(r5, r6), 100);
            return;
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void b(SelectionRangeType r1, int r2, int r3, boolean r4, boolean r5, Rect r6, String r7) {
            com.larus.bmhome.chat.api.d0.a.a(r1, r7);
        }
    }

    static {
    }

    public MarkdownIconTextBlockView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MarkdownIconTextBlockView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final MarkDownSelectorSettings getMarkDownSelectorSettings() {
        return (MarkDownSelectorSettings) this.m.getValue();
    }

    private final vg8.m getMarkdownRenderHelper() {
        return (vg8.m) this.q.getValue();
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void c() {
        vg8.m r0 = getMarkdownRenderHelper();
        LarusBlockItemMarkdownTextWithIconBinding r1 = this.b;
        if (r1 == null) goto L5;
        LinearLayout r2 = r1.c;
    L6:
        r0.d(r2);
        b r3 = this.p;
        r3.a = 0;
        com.larus.utils.t0.a.removeCallbacks(r3);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean f() {
        if (getMarkDownSelectorSettings().getTripleClickStrategy() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMarkdownRenderHelper().c();
    }

    public final com.larus.bmhome.chat.api.z getMarkDownSelectHelper() {
        return this.l;
    }

    public static final boolean d(MarkdownIconTextBlockView r0) {
        if (r0.getMarkDownSelectorSettings().getDoubleClickShiftStrategy() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(final Block r27, Map<String, Object> r28) {
        String r3 = null;
        if (r28 == null) goto L5;
        Object r4 = r28.get("block_view_extra_message");
    L6:
        this.d = (Message) r4;
        if (r28 == null) goto L9;
        Object r5 = r28.get("block_view_extra_bot_model");
    L11:
        if ((r5 instanceof BotModel) == false) goto L13;
        BotModel r6 = (BotModel) r5;
    L14:
        this.e = r6;
        if (r28 == null) goto L17;
        Object r7 = r28.get("block_view_extra_chat_key");
    L19:
        if ((r7 instanceof Long) == false) goto L21;
        Long r8 = (Long) r7;
    L22:
        if (r8 != null) goto L24;
        r8 = 0L;
    L24:
        this.f = r8;
        if (r28 == null) goto L27;
        Object r9 = r28.get("block_view_extra_current_page");
    L29:
        if ((r9 instanceof String) == false) goto L31;
        String r10 = (String) r9;
    L32:
        this.h = r10;
        if (r28 == null) goto L35;
        Object r11 = r28.get("block_view_extra_previous_page");
    L37:
        if ((r11 instanceof String) == false) goto L39;
        String r12 = (String) r11;
    L40:
        this.i = r12;
        if (r28 == null) goto L43;
        Object r13 = r28.get("block_view_extra_mob_research_id");
    L45:
        if ((r13 instanceof String) == false) goto L47;
        String r14 = (String) r13;
    L48:
        this.j = r14;
        if (r28 == null) goto L51;
        Object r15 = r28.get("block_view_markdown_common_input");
    L53:
        if ((r15 instanceof fh8.f) == false) goto L55;
        fh8.f r16 = (fh8.f) r15;
    L56:
        if (r16 != null) goto L58;
        r16 = new fh8.g().a();
    L58:
        boolean r17 = Intrinsics.areEqual(this.h, "dr_process_detail");
        this.g = r17;
        boolean r18 = true;
        String r19 = AbsBlockView.a.f(r27, r17, true);
        if (r19 != null) goto L61;
    L64:
        boolean r20 = true;
    L66:
        if (r20 == false) goto L73;
        LarusBlockItemMarkdownTextWithIconBinding r1 = this.b;
        if (r1 == null) goto L230;
        FrameLayout r2 = r1.a;
        if (r2 == null) goto L231;
        r2.setVisibility(8);
        return;
    L231:
        return;
    L230:
        return;
    L73:
        LarusBlockItemMarkdownTextWithIconBinding r21 = this.b;
        if (r21 == null) goto L78;
        FrameLayout r22 = r21.a;
        if (r22 == null) goto L78;
        r22.setVisibility(0);
    L78:
        LarusBlockItemMarkdownTextWithIconBinding r23 = this.b;
        if (r23 == null) goto L229;
        if (r28 == null) goto L82;
        Object r24 = r28.get("block_view_extra_max_width");
    L84:
        if ((r24 instanceof Integer) == false) goto L86;
        Integer r25 = (Integer) r24;
    L87:
        if (r25 == null) goto L89;
        int r26 = r25.intValue();
    L90:
        if (r27 != null) goto L92;
    L94:
        boolean r110 = false;
    L95:
        if (r110 == false) goto L101;
        if (this.g == false) goto L99;
        int r111 = i5.l0();
    L114:
        int r29 = r26 - r111;
        if (this.g == true) goto L117;
    L116:
        boolean r112 = false;
    L126:
        if (r112 == true) goto L136;
        LinearLayout r113 = r23.c;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L135;
        FrameLayout.LayoutParams r115 = (FrameLayout.LayoutParams) r114;
        r115.setMarginStart(0);
        r113.setLayoutParams(r115);
        LarusBlockItemMarkdownTextWithIconSubBinding r116 = this.c;
        if (r116 == null) goto L156;
        LinearLayout r117 = r116.a;
        if (r117 == null) goto L156;
        r117.setVisibility(8);
    L156:
        if (r27 != null) goto L158;
    L160:
        boolean r118 = false;
    L161:
        if (r118 == false) goto L193;
        LarusBlockItemMarkdownTextWithIconBinding r119 = this.b;
        if (r119 == null) goto L167;
        LinearLayout r120 = r119.c;
        if (r120 == null) goto L167;
        r120.setVisibility(0);
    L167:
        LarusBlockItemMarkdownTextWithIconSubBinding r121 = this.c;
        if (r121 == null) goto L172;
        AppCompatTextView r122 = r121.c;
        if (r122 == null) goto L172;
        r122.setVisibility(8);
    L172:
        LarusBlockItemMarkdownTextWithIconSubBinding r30 = this.c;
        if (r30 == null) goto L178;
        ShimmerTextView r31 = r30.c;
        if (r31 == null) goto L178;
        r31.x();
    L178:
        if (this.g == false) goto L180;
        fh8.t.a r32 = new fh8.t.a();
        r32.a = ContextCompat.getColor(getContext(), v19.c.b(2130972082, getContext(), 2131103146));
        r32.b = i5.o();
        r32.c = i5.E();
        r32.d = false;
        r32.i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        r32.e = false;
        r32.f = 0;
        r32.g = false;
        r32.h = r29;
        i5.l0();
        fh8.t r33 = r32.a();
    L181:
        fh8.t r123 = r33;
        fh8.l r34 = new fh8.l(false, false, "markdownIconTextBlock-" + r27.getBlockId(), false, null, false, true, false, false, null, null, 3952);
        fh8.g r35 = fh8.h.a(r16);
        r35.j = r34.e;
        fh8.f r124 = r35.a();
        vg8.m r36 = getMarkdownRenderHelper();
        LinearLayout r125 = r23.c;
        String r37 = "";
        if (r19 != null) goto L184;
        String r126 = "";
    L185:
        Function1 r127 = new g0(this);
        Function1 r128 = new h0(this);
        Function1 r129 = new i0();
        Pair[] r38 = new Pair[3];
        StringBuilder r39 = new StringBuilder();
        Message r130 = this.d;
        if (r130 == null) goto L188;
        r3 = r130.getMessageId();
    L188:
        r39.append(r3);
        r39.append("-deepThink");
        r38[0] = TuplesKt.to("forceRefreshId", r39.toString());
        r38[1] = TuplesKt.to("viewAlphaTag", "deep_thinking");
        String r40 = this.h;
        if (r40 == null) goto L192;
        r37 = r40;
    L192:
        r38[2] = TuplesKt.to("current_page", r37);
        fh8.e.a(r36, r125, r126, r123, r34, r127, r128, r129, MapsKt.mutableMapOf(r38), r124, null, null, 1536);
    L218:
        String r41 = AbsBlockView.a.d(r27);
        if (r41 != null) goto L221;
    L224:
        if (r18 == true) goto L233;
        ExposureTrackerExtKt.a(this, new l0(r27, this));
        return;
    L233:
        return;
    L221:
        if (r41.length() == 0) goto L224;
        r18 = false;
        goto L224
    L184:
        r126 = r19;
        goto L185
    L180:
        fh8.t.a r42 = new fh8.t.a();
        r42.d = false;
        r42.e = false;
        r42.f = 0;
        r42.i = new RectF(i5.q(), 0.0f, i5.q(), 0.0f);
        r42.g = false;
        r42.h = r29;
        r33 = r42.a();
        goto L181
    L193:
        LarusBlockItemMarkdownTextWithIconBinding r43 = this.b;
        if (r43 == null) goto L198;
        LinearLayout r44 = r43.c;
        if (r44 == null) goto L198;
        r44.setVisibility(8);
    L198:
        LarusBlockItemMarkdownTextWithIconSubBinding r45 = this.c;
        if (r45 == null) goto L203;
        AppCompatTextView r46 = r45.c;
        if (r46 == null) goto L203;
        r46.setVisibility(0);
    L203:
        LarusBlockItemMarkdownTextWithIconSubBinding r47 = this.c;
        if (r47 == null) goto L208;
        AppCompatTextView r48 = r47.c;
        if (r48 == null) goto L208;
        we8.a.b(r48, i5.t(), false, null, null, 12);
    L208:
        LarusBlockItemMarkdownTextWithIconSubBinding r49 = this.c;
        if (r49 == null) goto L213;
        AppCompatTextView r50 = r49.c;
        if (r50 == null) goto L213;
        r50.setText(r19);
    L213:
        LarusBlockItemMarkdownTextWithIconSubBinding r51 = this.c;
        if (r51 == null) goto L218;
        ShimmerTextView r52 = r51.c;
        if (r52 == null) goto L218;
        int r53 = ShimmerTextView.h;
        r52.z(false);
        goto L218
    L158:
        if (r27.isFinish() != true) goto L160;
        r118 = true;
        goto L161
    L135:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L136:
        LinearLayout r131 = r23.c;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
        if (r132 == null) goto L228;
        FrameLayout.LayoutParams r133 = (FrameLayout.LayoutParams) r132;
        r133.setMarginStart(i5.Q());
        r131.setLayoutParams(r133);
        if (this.c != null) goto L147;
        LayoutInflater r134 = LayoutInflater.from(getContext());
        FrameLayout r135 = r23.b;
        View r136 = r134.inflate(2131561836, r135, false);
        r135.addView(r136);
        int r137 = 2131368711;
        SimpleDraweeView r138 = ViewBindings.findChildViewById(r136, 2131368711);
        if (r138 == null) goto L146;
        r137 = 2131368723;
        ShimmerTextView r139 = (ShimmerTextView) ViewBindings.findChildViewById(r136, 2131368723);
        if (r139 == null) goto L146;
        this.c = new LarusBlockItemMarkdownTextWithIconSubBinding((LinearLayout) r136, r138, r139);
    L146:
        throw new NullPointerException("Missing required view with ID: ".concat(r136.getResources().getResourceName(r137)));
    L147:
        LarusBlockItemMarkdownTextWithIconSubBinding r140 = this.c;
        if (r140 == null) goto L150;
        SimpleDraweeView r141 = r140.b;
    L151:
        AbsBlockView.a.e(r141, r27);
        LarusBlockItemMarkdownTextWithIconSubBinding r142 = this.c;
        if (r142 == null) goto L156;
        SimpleDraweeView r143 = r142.b;
        if (r143 == null) goto L156;
        r143.setVisibility(0);
        goto L156
    L150:
        r141 = null;
        goto L151
    L228:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L117:
        if (r27 != null) goto L119;
    L121:
        boolean r144 = false;
    L122:
        if (r144 == true) goto L116;
        r112 = true;
        goto L126
    L119:
        if (r27.getBlockType() != j.o) goto L121;
        r144 = true;
        goto L122
    L99:
        r111 = i5.Q();
        goto L114
    L101:
        if (this.g == true) goto L103;
    L102:
        boolean r145 = false;
    L111:
        if (r145 == false) goto L113;
        r111 = i5.l0();
        goto L114
    L113:
        r111 = i5.Q();
        goto L114
    L103:
        if (r27 != null) goto L105;
    L107:
        boolean r146 = false;
    L108:
        if (r146 == true) goto L102;
        r145 = true;
        goto L111
    L105:
        if (r27.getBlockType() != j.o) goto L107;
        r146 = true;
        goto L108
    L92:
        if (r27.getBlockType() != j.o) goto L94;
        r110 = true;
        goto L95
    L89:
        r26 = 0;
        goto L90
    L86:
        r25 = null;
        goto L87
    L82:
        r24 = null;
        goto L84
    L229:
        return;
    L61:
        if (r19.length() == 0) goto L64;
        r20 = false;
        goto L66
    L55:
        r16 = null;
        goto L56
    L51:
        r15 = null;
        goto L53
    L47:
        r14 = null;
        goto L48
    L43:
        r13 = null;
        goto L45
    L39:
        r12 = null;
        goto L40
    L35:
        r11 = null;
        goto L37
    L31:
        r10 = null;
        goto L32
    L27:
        r9 = null;
        goto L29
    L21:
        r8 = null;
        goto L22
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = null;
        goto L14
    L9:
        r5 = null;
        goto L11
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        View r5 = LayoutInflater.from(r3).inflate(2131561835, this, false);
        addView(r5);
        FrameLayout r6 = (FrameLayout) r5;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r5, 2131368713);
        if (r1 == null) goto L7;
        this.b = new LarusBlockItemMarkdownTextWithIconBinding(r6, r6, r1);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131368713)));
    }

    public final void g(CustomMarkdownTextView r8, boolean r9) {
        FLogger.a.i("MarkdownIconTextBlockView", "performDoubleClick, isReClick:" + r9);
        LarusBlockItemMarkdownTextWithIconBinding r0 = this.b;
        if (r0 == null) goto L7;
        FrameLayout r1 = r0.a;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        TraceFragment r2 = (TraceFragment) FragmentManager.findFragment(r1);
    L8:
        e(r2, r8, "double_click_text", 2, r9);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void h(CustomMarkdownTextView r8, boolean r9) {
        FLogger.a.i("MarkdownIconTextBlockView", "performTripleClick, isReClick:" + r9);
        LarusBlockItemMarkdownTextWithIconBinding r0 = this.b;
        if (r0 == null) goto L7;
        FrameLayout r1 = r0.a;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        TraceFragment r2 = (TraceFragment) FragmentManager.findFragment(r1);
    L8:
        e(r2, r8, "triple_click_text", 3, r9);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public MarkdownIconTextBlockView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.l = ILegacyChatUiServiceDelegate.b.F8();
        this.m = LazyKt.lazy(new j0());
        this.p = new b(this);
        this.q = LazyKt.lazy(new k0());
    }

    public /* synthetic */ MarkdownIconTextBlockView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void e(TraceFragment r24, CustomMarkdownTextView r25, String r26, int r27, boolean r28) {
        com.larus.bmhome.chat.api.z r2 = this.l;
        if (r2 == null) goto L17;
        TraceFragment r3 = r24;
        if ((r3 instanceof by7.e) == true) goto L8;
        r3 = null;
    L8:
        BotModel r4 = this.e;
        Long r7 = this.f;
        if (r7 == null) goto L11;
        long r8 = r7.longValue();
    L12:
        if (r25 != null) goto L14;
        CustomMarkdownTextView r10 = null;
    L15:
        com.larus.bmhome.chat.api.z.a.a(r2, r3, r4, "default", r8, r10, this.d, r26, this.h, this.k, true, r27, r28, null, new c(r25, this), false, null, null, null, 512000);
        return;
    L14:
        r10 = r25;
        goto L15
    L11:
        r8 = 0;
        goto L12
    }
}
