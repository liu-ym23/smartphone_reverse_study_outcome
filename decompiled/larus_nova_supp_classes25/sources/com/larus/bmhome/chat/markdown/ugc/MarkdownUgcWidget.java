package com.larus.bmhome.chat.markdown.ugc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ContentCover;
import com.larus.bmhome.video.ItemType;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.impl.databinding.LarusMdUgcRecycleviewBinding;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.r2;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.service.z2;
import com.larus.platform.uimodel.ArticleParam;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ>\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u000e2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u000203\u0018\u000102H\u0016J \u00104\u001a\u0002052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u000eH\u0002J\b\u00106\u001a\u000205H\u0002J\b\u00107\u001a\u00020\u0017H\u0002J\u0018\u00108\u001a\u0002052\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020'H\u0002J\u0018\u0010<\u001a\u0002052\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020'H\u0002J2\u0010=\u001a\u0002052\b\u0010;\u001a\u0004\u0018\u00010'2\u0006\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u000eH\u0002J\u0012\u0010B\u001a\u00020\u00172\b\u0010;\u001a\u0004\u0018\u00010'H\u0002J2\u0010C\u001a\u0002052\b\u0010;\u001a\u0004\u0018\u00010'2\u0006\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u000eH\u0002J\b\u0010D\u001a\u00020\u000eH\u0002J\b\u0010E\u001a\u00020:H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/larus/bmhome/chat/markdown/ugc/MarkdownUgcWidget;", "Landroid/widget/FrameLayout;", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "textView", "Landroid/widget/TextView;", ChatDraftItem.TYPE_TEXT, "Landroid/text/Spanned;", "COVER_WIDTH", "", "VIEW_HOLDER_HEIGHT", "spanSize", "Landroid/util/Size;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "mobMessage", "Lcom/larus/im/bean/message/Message;", "mobChatType", "", "mobConversationId", "mobBotId", "mobCurrentPage", "mobPreviousPage", "mobLruSet", "Lcom/larus/bmhome/chat/search/LruSet;", "lastBindJob", "Lkotlinx/coroutines/Job;", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "mobCardPosition", "listAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "listContent", "", "Lcom/larus/bmhome/video/Content;", "extraUgcData", "Lcom/larus/bmhome/chat/markdown/ugc/MarkdownUgcExtraData;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusMdUgcRecycleviewBinding;", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "videoTitleHeight", "bindData", "maxWidth", "payload", "", "", "updateSize", "", "initView", "getModuleType", "openArticleActivity", "view", "Landroid/view/View;", "data", "openVideoActivity", "mobCardShow", "moduleType", "targetWidth", "targetHeight", "index", "getSlideMode", "mobCardClick", "getWidgetOrder", "asView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MarkdownUgcWidget extends FrameLayout implements usc.f {
    public static final /* synthetic */ int u = 0;
    public TextView a;
    public Spanned b;
    public final int c;
    public Size d;
    public usc.e e;
    public Message f;
    public String g;
    public String h;
    public String i;
    public String j;
    public LruSet<String> k;
    public Job l;
    public q0.a m;
    public int n;
    public final RecyclerView.Adapter<?> o;
    public List<Content> p;
    public MarkdownUgcExtraData q;
    public LarusMdUgcRecycleviewBinding r;
    public fh8.f s;
    public final int t;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/markdown/ugc/MarkdownUgcWidget$bindData$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/bmhome/video/Content;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b extends TypeToken<List<? extends Content>> {
        public b() {
        }
    }

    static {
    }

    public final void a() {
    }

    public final View asView() {
        return this;
    }

    public final Integer b(Size r1, TextView r2, Canvas r3, Paint r4) {
        return null;
    }

    public final Size c(TextView r1, usc.e r2, Map<String, ? extends Object> r3) {
        return null;
    }

    public final void e() {
    }

    public final void f() {
    }

    private final String getModuleType() {
        List<Content> r0 = this.p;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return "single_card";
    L9:
        return "multiple_card";
    L5:
        if (r0.size() != 1) goto L7;
        r1 = true;
        goto L7
    }

    private final int getWidgetOrder() {
        int r0 = this.n;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        ri8.c r1 = ri8.c.a;
        Integer r2 = ri8.c.k(this.b, this.e);
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L9:
        this.n = r3;
        return r3;
    L8:
        r3 = -1;
        goto L9
    }

    public MarkdownUgcWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ String j(MarkdownUgcWidget r0) {
        return r0.getModuleType();
    }

    public static String m(Content r1) {
        if (r1 != null) goto L5;
        return "";
    L5:
        Integer r2 = r1.getItemType();
        int r0 = ItemType.VIDEO.getValue();
        if (r2 != null) goto L9;
    L11:
        return "ugc_graphic";
    L9:
        if (r2.intValue() != r0) goto L11;
        return "ugc_video";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.bmhome.chat.markdown.ugc.c] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public MarkdownUgcWidget(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        int r6 = i5.y0(v19.c.b(2130971205, null, 2131166779));
        this.c = i5.y0(v19.c.b(2130971340, null, 2131167049));
        this.d = new Size(0, 0);
        this.n = -1;
        this.o = ILegacyChatUiServiceDelegate.b.W8(r4, r6, new c(this));
        this.t = c7.b(33);
    }

    /* JADX WARN: Type inference failed for: r10v3, types: [com.larus.bmhome.chat.markdown.ugc.f] */
    public static Unit h(final MarkdownUgcWidget r8, final Content r9, View r10) {
        Intrinsics.checkNotNullParameter(r9, "content");
        Intrinsics.checkNotNullParameter(r10, "view");
        final String r7 = r8.getModuleType();
        final int r4 = r10.getWidth();
        final int r5 = r10.getHeight();
        List<Content> r11 = r8.p;
        if (r11 == null) goto L5;
        final int r6 = r11.indexOf(r9);
    L6:
        final ?? r12 = new f(r8, r9, r4, r5, r6, r7);
        if (z2.a.enableTrackerOptimize() == false) goto L9;
        t0.a(new g(r12));
    L11:
        return Unit.INSTANCE;
    L9:
        r12.invoke();
        goto L11
    L5:
        r6 = -1;
        goto L6
    }

    public static final void k(MarkdownUgcWidget r28, View r29, Content r30) {
        List<Content> r1 = r28.p;
        boolean r2 = false;
        if (r1 == null) goto L5;
        int r3 = r1.indexOf(r30);
    L6:
        fh8.f r4 = r28.s;
        String r5 = null;
        if (r4 == null) goto L9;
        String r21 = r4.d;
    L10:
        if (r4 == null) goto L14;
        Message r6 = r4.b;
        if (r6 == null) goto L14;
        String r22 = r6.getSectionId();
    L15:
        String r8 = r30.getItemId();
        MarkdownUgcExtraData r7 = r28.q;
        if (r7 == null) goto L23;
        Integer r9 = r7.getVideoScene();
        if (r9 == null) goto L23;
        if (r9.intValue() != 2) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == true) goto L26;
        EnterVideoMethod r11 = EnterVideoMethod.SEARCH_VIDEO_PAGE;
    L27:
        String r12 = r11.getValue();
        int r13 = r3 + 1;
        MarkdownUgcExtraData r14 = r28.q;
        if (r14 == null) goto L35;
        Integer r15 = r14.getVideoScene();
        if (r15 == null) goto L35;
        if (r15.intValue() != 2) goto L35;
        boolean r16 = true;
    L36:
        if (r16 == false) goto L40;
        Message r17 = r28.f;
        if (r17 == null) goto L44;
        String r18 = com.larus.bmhome.chat.bean.d.x(r17).getReqId();
    L43:
        String r19 = r18;
    L45:
        Integer r20 = r30.getItemType();
        int r23 = ItemType.VIDEO.getValue();
        if (r20 != null) goto L49;
    L51:
        String r24 = "ugc_graphic";
    L52:
        String r110 = r24;
        String r111 = String.valueOf(r28.getWidgetOrder());
        String r112 = String.valueOf(r13);
        Message r25 = r28.f;
        if (r25 == null) goto L57;
        Map r26 = r25.getExt();
        if (r26 == null) goto L57;
        String r113 = (String) r26.get("rich_media_type");
    L58:
        MarkdownUgcExtraData r27 = r28.q;
        if (r27 == null) goto L66;
        Integer r31 = r27.getVideoScene();
        if (r31 == null) goto L66;
        if (r31.intValue() != 2) goto L66;
        r2 = true;
    L66:
        if (r2 == false) goto L68;
        String r32 = "recommend";
    L69:
        String r114 = r32;
        Message r33 = r28.f;
        if (r33 == null) goto L72;
        r5 = r33.getMessageId();
    L72:
        ArticleParam r34 = new ArticleParam(r8, r12, Integer.valueOf(r13), null, 1, r19, r110, r111, r112, r113, r114, "within_text", r5, r21, r22, null, null, null, 229384, null);
        IFlowSdkDepend r35 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r35 == null) goto L78;
        r2 r36 = r35.A0();
        if (r36 == null) goto L79;
        r36.m(r28.getContext(), r34, r29);
        return;
    L79:
        return;
    L78:
        return;
    L68:
        r32 = "slideshow";
    L57:
        r113 = null;
        goto L58
    L49:
        if (r20.intValue() != r23) goto L51;
        r24 = "ugc_video";
    L44:
        r19 = null;
        goto L45
    L40:
        MarkdownUgcExtraData r37 = r28.q;
        if (r37 == null) goto L44;
        r18 = r37.getReqId();
    L35:
        r16 = false;
        goto L36
    L26:
        r11 = EnterVideoMethod.FLOW_CLICK_RECOMMEND_VIDEO_CARD;
    L23:
        r10 = false;
    L14:
        r22 = null;
        goto L15
    L9:
        r21 = null;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public static final void l(MarkdownUgcWidget r85, View r86, Content r87) {
        List<Content> r0 = r85.p;
        if (r0 == null) goto L8;
        List<Content> r1 = r0;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L9;
        Content r5 = (Content) r2.next();
        r4.add(new MediaEntity(null, r5.getItemId(), null, null, null, null, null, null, null, null, null, null, r5.getSource(), null, null, null, 0, null, null, null, null, null, null, null, 16773117, null));
    L9:
        if (r4 == null) goto L11;
        ArrayList r34 = new ArrayList(r4);
    L12:
        MediaEntityContainer r35 = new MediaEntityContainer(null, r34, null, null, false, 0, 0, null, 253, null);
        fh8.f r3 = r85.s;
        if (r3 == null) goto L15;
        String r37 = r3.d;
    L16:
        if (r3 == null) goto L20;
        Message r6 = r3.b;
        if (r6 == null) goto L20;
        String r38 = r6.getMessageId();
    L21:
        fh8.f r7 = r85.s;
        if (r7 == null) goto L26;
        Message r8 = r7.b;
        if (r8 == null) goto L26;
        String r51 = r8.getSectionId();
    L27:
        fh8.f r9 = r85.s;
        if (r9 == null) goto L32;
        Message r10 = r9.b;
        if (r10 == null) goto L32;
        String r39 = r10.getConversationId();
    L33:
        fh8.f r11 = r85.s;
        if (r11 == null) goto L38;
        Message r12 = r11.b;
        if (r12 == null) goto L38;
        String r58 = r12.getReplyId();
    L39:
        fh8.f r13 = r85.s;
        if (r13 == null) goto L42;
        String r53 = r13.a;
    L43:
        MarkdownUgcExtraData r14 = r85.q;
        if (r14 == null) goto L46;
        String r15 = r14.getReqId();
    L47:
        List<Content> r16 = r85.p;
        boolean r17 = false;
        if (r16 == null) goto L50;
        int r41 = r16.indexOf(r87);
    L51:
        ContentCover r18 = r87.getCover();
        if (r18 != null) goto L54;
    L62:
        IconImage r19 = null;
    L63:
        if (r34 == null) goto L67;
        MediaEntity r20 = (MediaEntity) CollectionsKt.firstOrNull(r34);
        if (r20 == null) goto L67;
        Integer r36 = r20.getSource_from();
    L68:
        if (r19 == null) goto L73;
        ImageObj r21 = r19.imageOri;
        if (r21 == null) goto L73;
        String r22 = r21.url;
        if (r22 == null) goto L73;
    L74:
        String r43 = r22;
        fh8.f r23 = r85.s;
        if (r23 == null) goto L77;
        boolean r24 = Intrinsics.areEqual(r23.h, Boolean.TRUE);
    L78:
        if (r24 == false) goto L80;
        EnterVideoMethod r25 = EnterVideoMethod.COLLECTION_VIDEO_PAGE;
    L81:
        String r42 = r25.getValue();
        Map r45 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_method", "click_video_card"), TuplesKt.to("previous_page", "chat")});
        MarkdownUgcExtraData r26 = r85.q;
        if (r26 == null) goto L89;
        Integer r27 = r26.getVideoScene();
        if (r27 == null) goto L89;
        if (r27.intValue() != 2) goto L89;
        boolean r28 = true;
    L90:
        if (r28 == true) goto L92;
        EnterVideoMethod r29 = EnterVideoMethod.SEARCH_VIDEO_PAGE;
    L93:
        String r60 = r29.getValue();
        String r44 = MainBotServiceDelegate.b.a();
        if (r19 == null) goto L98;
        ImageObj r30 = r19.imageOri;
        if (r30 == null) goto L98;
        int r48 = r30.width;
    L99:
        if (r19 == null) goto L103;
        ImageObj r31 = r19.imageOri;
        if (r31 == null) goto L103;
        int r47 = r31.height;
    L104:
        MarkdownUgcExtraData r32 = r85.q;
        if (r32 == null) goto L112;
        Integer r33 = r32.getVideoScene();
        if (r33 == null) goto L112;
        if (r33.intValue() != 2) goto L112;
        boolean r40 = true;
    L113:
        if (r40 == false) goto L118;
        Message r46 = r85.f;
        if (r46 == null) goto L117;
        r15 = com.larus.bmhome.chat.bean.d.x(r46).getReqId();
        goto L118
    L117:
        String r52 = null;
    L119:
        VideoParam.RecommendType r54 = VideoParam.RecommendType.Search;
        MarkdownUgcExtraData r49 = r85.q;
        if (r49 == null) goto L122;
        Integer r56 = r49.getVideoScene();
    L123:
        MarkdownUgcExtraData r50 = r85.q;
        if (r50 == null) goto L126;
        ArrayList<String> r57 = r50.getQuery();
    L127:
        Integer r55 = r87.getItemType();
        int r59 = ItemType.VIDEO.getValue();
        if (r55 != null) goto L131;
    L133:
        String r61 = "ugc_graphic";
    L134:
        String r68 = r61;
        String r69 = String.valueOf(r85.getWidgetOrder());
        int r62 = r41 + 1;
        String r70 = String.valueOf(r62);
        Message r63 = r85.f;
        if (r63 == null) goto L139;
        Map r64 = r63.getExt();
        if (r64 == null) goto L139;
        String r71 = (String) r64.get("rich_media_type");
    L140:
        MarkdownUgcExtraData r65 = r85.q;
        if (r65 == null) goto L148;
        Integer r66 = r65.getVideoScene();
        if (r66 == null) goto L148;
        if (r66.intValue() != 2) goto L148;
        boolean r67 = true;
    L149:
        if (r67 == false) goto L151;
        String r72 = "recommend";
    L152:
        String r73 = r72;
        String r610 = r87.getItemId();
        MarkdownUgcExtraData r74 = r85.q;
        if (r74 == null) goto L160;
        Integer r75 = r74.getVideoScene();
        if (r75 == null) goto L160;
        if (r75.intValue() != 2) goto L160;
        r17 = true;
    L160:
        if (r17 == false) goto L181;
        Message r76 = r85.f;
        if (r76 == null) goto L181;
        Regex r77 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r76, "<this>");
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L175
        Map r79 = r76.getExt();     // Catch: Throwable -> L175
        if (r79 == null) goto L170;
        String r80 = (String) r79.get("text_area_ugc_gid_list");     // Catch: Throwable -> L175
        if (r80 == null) goto L170;
        List r81 = StringsKt.split$default(r80, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L175
        ArrayList r82 = null;
    L179:
        if (r81 == null) goto L182;
        r82 = new ArrayList(r81);
    L182:
        VideoParam r83 = new VideoParam(r34, r35, r36, r37, r38, r39, null, r41, r42, r43, r44, r45, null, r47, r48, null, false, r51, r52, r53, r54, false, r56, r57, r58, null, r60, r610, null, 1, Integer.valueOf(r62), null, null, null, r68, r69, r70, r71, r73, "within_text", r82, null, null, null, false, 0, null, null, -1843294144, 130563);
        IFlowSdkDepend r84 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r84 == null) goto L193;
        r2 r88 = r84.A0();
        if (r88 == null) goto L194;
        r88.r(r85.getContext(), r83, r86, new i(r87, r85));
        return;
    L194:
        return;
    L193:
        return;
    L170:
        r82 = null;
        Object r89 = Result.constructor-impl(null);     // Catch: Throwable -> L173
    L178:
        Result.exceptionOrNull-impl(r89);
        r81 = r82;
    L173:
        th = th;
    L177:
        Result.Companion r90 = Result.Companion;
        r89 = Result.constructor-impl(ResultKt.createFailure(th));
    L175:
        th = th;
        r82 = null;
    L181:
        r82 = null;
        goto L182
    L151:
        r72 = "slideshow";
    L148:
        r67 = false;
    L139:
        r71 = null;
        goto L140
    L131:
        if (r55.intValue() != r59) goto L133;
        r61 = "ugc_video";
        goto L134
    L126:
        r57 = null;
        goto L127
    L122:
        r56 = null;
    L118:
        r52 = r15;
    L112:
        r40 = false;
    L103:
        r47 = 0;
    L98:
        r48 = 0;
        goto L99
    L92:
        r29 = EnterVideoMethod.FLOW_CLICK_RECOMMEND_VIDEO_CARD;
    L89:
        r28 = false;
        goto L90
    L80:
        r25 = EnterVideoMethod.SEARCH_VIDEO_PAGE;
        goto L81
    L77:
        r24 = false;
    L73:
        r22 = "";
    L67:
        r36 = null;
        goto L68
    L54:
        if (r18.getSelectedCover() == null) goto L57;
        r19 = r18.getSelectedCover();
        goto L63
    L57:
        if (r18.getOriginCover() == null) goto L60;
        r19 = r18.getOriginCover();
        goto L63
    L60:
        if (r18.getDynamicCover() == null) goto L62;
        r19 = r18.getDynamicCover();
        goto L63
    L50:
        r41 = 0;
        goto L51
    L46:
        r15 = null;
        goto L47
    L42:
        r53 = null;
    L38:
        r58 = null;
    L32:
        r39 = null;
    L26:
        r51 = null;
    L20:
        r38 = null;
        goto L21
    L15:
        r37 = null;
        goto L16
    L11:
        r34 = null;
        goto L12
    L8:
        r4 = null;
        goto L9
    }

    public final Size d(TextView r11, Spanned r12, final usc.e r13, int r14, Map<String, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r11, "textView");
        Intrinsics.checkNotNullParameter(r12, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r13, "span");
        final fh8.f r2 = fh8.h.b(r15);
        String r3 = null;
        if (r2 == null) goto L5;
        q0.a r4 = r2.n;
    L6:
        this.m = r4;
        this.a = r11;
        if (r15 == null) goto L9;
        fh8.f r16 = fh8.h.b(r15);
    L10:
        this.s = r16;
        this.b = r12;
        this.e = r13;
        this.p = (List) fh8.b.a(r13, new com.larus.bmhome.chat.markdown.ugc.b(this, r2, r13));
        MarkdownUgcExtraData r17 = (MarkdownUgcExtraData) new Gson().fromJson(r13.l(), MarkdownUgcExtraData.class);     // Catch: Exception -> L15
    L17:
        this.q = r17;
        Job r18 = this.l;
        boolean r0 = true;
        if (r18 == null) goto L20;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);
    L20:
        this.l = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new MarkdownUgcWidget$bindData$2(this, r2, r11, null), 3, null);
        int r19 = r12.getSpanStart(r13);
        int r110 = r12.getSpanEnd(r13);
        int r111 = 0;
        if (r19 != 0) goto L23;
        boolean r112 = true;
    L25:
        if (r110 == r12.length()) goto L28;
        r0 = false;
    L28:
        MarkdownUgcExtraData r113 = this.q;
        if (r113 == null) goto L31;
        r3 = r113.getRecommendTitle();
    L31:
        boolean r114 = o0.d(r3);
        if (r114 == false) goto L34;
        int r115 = this.t;
    L35:
        if (r112 == false) goto L37;
        setPaddingRelative(getPaddingStart(), 0, getPaddingEnd(), i5.z());
        int r116 = getPaddingTop();
        int r117 = getPaddingBottom();
    L46:
        Size r118 = new Size(r14, this.c + (r115 + (r116 + r117)));
        this.d = r118;
        return r118;
    L37:
        if (r0 == false) goto L42;
        if (r114 == false) goto L40;
        int r119 = 0;
    L41:
        setPaddingRelative(getPaddingStart(), r119, getPaddingEnd(), 0);
        r116 = getPaddingTop();
        r117 = getPaddingBottom();
        goto L46
    L40:
        r119 = i5.c();
        goto L41
    L42:
        if (r114 == true) goto L45;
        r111 = i5.c();
    L45:
        setPaddingRelative(getPaddingStart(), r111, getPaddingEnd(), i5.z());
        r116 = getPaddingTop();
        r117 = getPaddingBottom();
        goto L46
    L34:
        r115 = 0;
        goto L35
    L23:
        r112 = false;
    L15:
        e = move-exception;
        FLogger.a.e("MarkdownUgcWidget", "bindData called failed, " + e.getMessage());
        r17 = null;
    L48:
        e = move-exception;
        FLogger.a.e("MarkdownUgcWidget", "bindData called failed, " + e.getMessage());
        EnsureManager.ensureNotReachHere(e);
        return this.d;
    L9:
        r16 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public static Unit g(Content r43, MarkdownUgcWidget r44, int r45, int r46, int r47, String r48) {
        ri8.c r1 = ri8.c.a;
        if (r43 == null) goto L5;
        String r3 = r43.getItemId();
    L6:
        Message r2 = r44.f;
        if (r2 == null) goto L9;
        String r4 = r2.getMessageId();
    L10:
        String r5 = r44.g;
        Message r6 = r44.f;
        if (r6 == null) goto L13;
        String r7 = r6.getReplyId();
    L14:
        String r8 = r44.i;
        String r9 = r44.j;
        boolean r10 = false;
        if (r43 == null) goto L22;
        Integer r11 = r43.getItemType();
        int r12 = ItemType.VIDEO.getValue();
        if (r11 == null) goto L22;
        if (r11.intValue() != r12) goto L22;
        boolean r13 = true;
    L23:
        if (r13 == false) goto L25;
        String r14 = "video";
    L26:
        String r15 = r14;
        String r16 = r44.h;
        String r17 = ri8.c.h(r45, r46);
        int r18 = r44.getWidgetOrder();
        int r19 = r47 + 1;
        if (r43 == null) goto L29;
        String r20 = r43.getItemId();
    L30:
        MarkdownUgcExtraData r110 = r44.q;
        if (r110 == null) goto L38;
        Integer r111 = r110.getVideoScene();
        if (r111 == null) goto L38;
        if (r111.intValue() != 2) goto L38;
        boolean r112 = true;
    L39:
        if (r112 == false) goto L43;
        Message r113 = r44.f;
        if (r113 == null) goto L47;
        String r114 = com.larus.bmhome.chat.bean.d.x(r113).getReqId();
    L46:
        String r21 = r114;
    L48:
        String r22 = m(r43);
        MarkdownUgcExtraData r0 = r44.q;
        if (r0 == null) goto L56;
        Integer r23 = r0.getVideoScene();
        if (r23 == null) goto L56;
        if (r23.intValue() != 2) goto L56;
        r10 = true;
    L56:
        if (r10 == false) goto L58;
        String r24 = "recommend";
    L59:
        if (r43 == null) goto L61;
        String r25 = r43.getItemId();
    L62:
        ri8.c.m(r3, r4, r5, r7, r8, r9, Integer.valueOf(r18), Integer.valueOf(r19), r24, "within_text", r15, r16, r17, r48, "open_media", null, null, r20, r21, r22, r25, null, "ugc", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -6193152, 63);
        return Unit.INSTANCE;
    L61:
        r25 = null;
        goto L62
    L58:
        r24 = "slideshow";
    L47:
        r21 = null;
        goto L48
    L43:
        MarkdownUgcExtraData r115 = r44.q;
        if (r115 == null) goto L47;
        r114 = r115.getReqId();
    L38:
        r112 = false;
        goto L39
    L29:
        r20 = null;
        goto L30
    L25:
        r14 = "graphic";
    L22:
        r13 = false;
        goto L23
    L13:
        r7 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static Unit i(MarkdownUgcWidget r42, Content r43, int r44, int r45, int r46, String r47) {
        ri8.c r1 = ri8.c.a;
        LruSet<String> r2 = r42.k;
        if (r43 == null) goto L5;
        String r3 = r43.getItemId();
    L6:
        Message r4 = r42.f;
        if (r4 == null) goto L9;
        String r5 = r4.getMessageId();
    L10:
        String r6 = r42.g;
        Message r7 = r42.f;
        if (r7 == null) goto L13;
        String r8 = r7.getReplyId();
    L14:
        String r9 = r42.i;
        String r10 = r42.j;
        if (r43 == null) goto L22;
        Integer r11 = r43.getItemType();
        int r12 = ItemType.VIDEO.getValue();
        if (r11 == null) goto L22;
        if (r11.intValue() != r12) goto L22;
        boolean r13 = true;
    L23:
        if (r13 == false) goto L25;
        String r14 = "video";
    L26:
        String r15 = r14;
        String r16 = r42.h;
        String r17 = ri8.c.h(r44, r45);
        int r18 = r42.getWidgetOrder();
        int r19 = r46 + 1;
        if (r43 == null) goto L29;
        String r110 = r43.getItemId();
    L30:
        MarkdownUgcExtraData r20 = r42.q;
        if (r20 == null) goto L38;
        Integer r21 = r20.getVideoScene();
        if (r21 == null) goto L38;
        if (r21.intValue() != 2) goto L38;
        boolean r22 = true;
    L39:
        if (r22 == false) goto L43;
        Message r23 = r42.f;
        if (r23 == null) goto L47;
        String r24 = com.larus.bmhome.chat.bean.d.x(r23).getReqId();
    L46:
        String r111 = r24;
    L48:
        String r25 = m(r43);
        MarkdownUgcExtraData r0 = r42.q;
        if (r0 == null) goto L56;
        Integer r26 = r0.getVideoScene();
        if (r26 == null) goto L56;
        if (r26.intValue() != 2) goto L56;
        boolean r27 = true;
    L57:
        if (r27 == false) goto L59;
        String r28 = "recommend";
    L60:
        if (r43 == null) goto L62;
        String r29 = r43.getItemId();
    L63:
        ri8.c.n(r2, r3, r5, r6, r8, r9, r10, Integer.valueOf(r18), Integer.valueOf(r19), r28, "within_text", r15, r16, r17, r47, null, r110, r111, r25, r29, null, "ugc", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -3112960, 63);
        return Unit.INSTANCE;
    L62:
        r29 = null;
        goto L63
    L59:
        r28 = "slideshow";
    L56:
        r27 = false;
    L47:
        r111 = null;
        goto L48
    L43:
        MarkdownUgcExtraData r30 = r42.q;
        if (r30 == null) goto L47;
        r24 = r30.getReqId();
    L38:
        r22 = false;
        goto L39
    L29:
        r110 = null;
        goto L30
    L25:
        r14 = "graphic";
    L22:
        r13 = false;
        goto L23
    L13:
        r8 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
