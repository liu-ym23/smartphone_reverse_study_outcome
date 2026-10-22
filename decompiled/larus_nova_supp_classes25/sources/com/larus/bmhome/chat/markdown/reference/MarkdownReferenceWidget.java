package com.larus.bmhome.chat.markdown.reference;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.auth.DeepThinkingConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.adapter.MessageReferenceAdapter;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.AtMostHeightLinearLayout;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import com.larus.mainbot.impl.databinding.LarusMdThinkEmphasizeSearchReferenceBinding;
import com.larus.platform.service.AccountService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import fh8.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import usc.f;
import v19.d6;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 j2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001jB\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00108\u001a\u00020\u000bH\u0002JW\u00109\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010\u00022\u0006\u0010;\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010<\u001a\u0004\u0018\u00010\r2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\b\u0010>\u001a\u0004\u0018\u00010?2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010AH\u0016¢\u0006\u0002\u0010CJ>\u00109\u001a\u00020\u00192\u0006\u0010D\u001a\u0002072\u0006\u0010E\u001a\u00020F2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\r2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u0014\u0018\u00010HH\u0016J9\u0010J\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A2\b\u0010<\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010KJ5\u0010L\u001a\u00020B2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010MJ.\u0010N\u001a\u00020B2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u0014\u0018\u00010H2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010D\u001a\u000207H\u0002J\u0012\u0010O\u001a\u00020B2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\b\u0010P\u001a\u00020BH\u0002J\b\u0010Q\u001a\u00020BH\u0002J\b\u0010R\u001a\u00020BH\u0002J5\u0010S\u001a\u00020B2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A2\n\b\u0003\u0010<\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010MJ\b\u0010T\u001a\u00020BH\u0002J\u0018\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020XH\u0002J\u0010\u0010Y\u001a\u00020I2\u0006\u0010V\u001a\u00020\rH\u0002J\u0018\u0010Z\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020XH\u0002J\b\u0010[\u001a\u00020IH\u0002J\b\u0010\\\u001a\u00020BH\u0002J\b\u0010]\u001a\u00020^H\u0002J\b\u0010_\u001a\u00020BH\u0002J\b\u0010`\u001a\u00020BH\u0002J\b\u0010a\u001a\u00020BH\u0002J\b\u0010b\u001a\u00020BH\u0002J\b\u0010c\u001a\u00020\u000bH\u0002J\b\u0010d\u001a\u00020BH\u0002J\b\u0010e\u001a\u00020fH\u0002J\b\u0010g\u001a\u00020hH\u0016J\b\u0010i\u001a\u00020BH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b*\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R?\u00100\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u0002 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010\u00020\u0002\u0018\u000101018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\"\u001a\u0004\b3\u00104R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/larus/bmhome/chat/markdown/reference/MarkdownReferenceWidget;", "Lcom/larus/bmhome/chat/markdown/reference/AbsSearchResultBlockWidget;", "Lcom/larus/bmhome/chat/markdown/reference/SearchReferenceData;", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isUserClick", "", "lastStage", "", "Ljava/lang/Integer;", "toolType", "Lcom/larus/bmhome/chat/markdown/reference/ToolType;", "referenceData", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "spanSize", "Landroid/util/Size;", "haveInflateView", "haveReportCardShow", "lastOnItemCompletelyShowCallBackWrapper", "Lcom/larus/common_ui/utils/OnItemCompletelyShowCallBackWrapper;", "enableTrackerOptimize", "getEnableTrackerOptimize", "()Z", "enableTrackerOptimize$delegate", "Lkotlin/Lazy;", "markDownReferenceView", "Lcom/larus/bmhome/chat/markdown/reference/EmphasizeReferenceViewImpl;", "getMarkDownReferenceView", "()Lcom/larus/bmhome/chat/markdown/reference/EmphasizeReferenceViewImpl;", "markDownReferenceView$delegate", "referenceListZoomInView", "Lcom/larus/bmhome/chat/markdown/reference/ReferenceListZoomInView;", "getReferenceListZoomInView", "()Lcom/larus/bmhome/chat/markdown/reference/ReferenceListZoomInView;", "referenceListZoomInView$delegate", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "isFold", "typeToken", "Lcom/google/gson/reflect/TypeToken;", "kotlin.jvm.PlatformType", "getTypeToken", "()Lcom/google/gson/reflect/TypeToken;", "typeToken$delegate", "currentTextView", "Landroid/widget/TextView;", "isHaveSearchKeywordsAndReference", "bindData", "data", "maxWidth", "backgroundResource", "forceHideArrow", "blockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "onClickInterceptor", "Lkotlin/Function0;", "", "(Lcom/larus/bmhome/chat/markdown/reference/SearchReferenceData;ILcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;Lkotlin/jvm/functions/Function0;)Landroid/util/Size;", "textView", ChatDraftItem.TYPE_TEXT, "Landroid/text/Spanned;", "payload", "", "", "internalBindData", "(ILjava/lang/Boolean;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;)Landroid/util/Size;", "refreshWidgetUI", "(Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;)V", "parseAndInitData", "initData", "tryInitWidgetLayout", "initReferenceBinding", "updateMarkdownLoading", "updateReferenceTitle", "initReferenceList", "itemShowFilter", "index", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemCardId", "itemShowCallBack", "transformCardType", "updateReferenceList", "createReferenceListAdapter", "Lcom/larus/bmhome/chat/adapter/MessageReferenceAdapter;", "mobCardShow", "clickSearchInWebSearchAndScholarSearch", "clickSearchInLinkReader", "generateDataListSource", "shouldHideMarkdownReference", "refreshReferenceWidget", "provideChatParam", "Lcom/larus/bmhome/chat/ChatParam;", "asView", "Landroid/view/View;", "onRecycle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MarkdownReferenceWidget extends AbsSearchResultBlockWidget<SearchReferenceData> implements f {
    public static final /* synthetic */ int r = 0;
    public boolean a;
    public Integer b;
    public ToolType c;
    public SearchReferenceData d;
    public final ArrayList<Object> e;
    public usc.e f;
    public Size g;
    public boolean h;
    public boolean i;
    public d6 j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public fh8.f n;
    public boolean o;
    public final Lazy p;
    public TextView q;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToolType.values().length];
            r0[ToolType.LinkReader.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ToolType.SearchPlugin.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ToolType.ScholarSearch.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
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
        this.a = false;
        this.i = false;
        getMarkDownReferenceView().b();
    }

    private final boolean getEnableTrackerOptimize() {
        return ((Boolean) this.k.getValue()).booleanValue();
    }

    private final e getMarkDownReferenceView() {
        return (e) this.l.getValue();
    }

    private final ReferenceListZoomInView getReferenceListZoomInView() {
        return (ReferenceListZoomInView) this.m.getValue();
    }

    private final TypeToken<SearchReferenceData> getTypeToken() {
        return (TypeToken) this.p.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.bmhome.chat.markdown.reference.n] */
    public final void k() {
        if (r.b(this.d) == true) goto L6;
        return;
    L6:
        if (this.i == false) goto L8;
        return;
    L8:
        this.i = true;
        final ?? r0 = new n(this);
        if (getEnableTrackerOptimize() == false) goto L11;
        t0.a(new o(r0));
        return;
    L11:
        Unit r1 = (Unit) r0.invoke();
    }

    public final ChatParam l() {
        fh8.f r0 = this.n;
        String r1 = null;
        if (r0 == null) goto L5;
        String r6 = r0.f;
    L6:
        if (r0 == null) goto L9;
        r1 = r0.a;
    L9:
        return new ChatParam(null, null, r6, "chat", r1, 227);
    L5:
        r6 = null;
        goto L6
    }

    public MarkdownReferenceWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void i(fh8.f r4) {
        this.n = r4;
        ToolType.a r5 = ToolType.Companion;
        SearchReferenceData r0 = this.d;
        List<Reference> r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getToolType();
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r5.getClass();
        ToolType r6 = ToolType.a.a(r2);
        this.c = r6;
        if (r.d(r6) == false) goto L37;
        SearchReferenceData r7 = this.d;
        if (r7 == null) goto L13;
        List<String> r8 = r7.getQueries();
    L14:
        List<String> r9 = r8;
        boolean r3 = false;
        if (r9 != null) goto L17;
    L20:
        boolean r10 = true;
    L21:
        if (r10 == false) goto L36;
        SearchReferenceData r11 = this.d;
        if (r11 == null) goto L25;
        r1 = r11.getReference();
    L25:
        List<Reference> r12 = r1;
        if (r12 != null) goto L28;
    L31:
        boolean r13 = true;
    L32:
        if (r13 == false) goto L36;
        if (r.d(this.c) == false) goto L36;
        r3 = true;
        goto L36
    L28:
        if (r12.isEmpty() == true) goto L31;
        r13 = false;
    L36:
        if (r3 == true) goto L37;
        return;
    L17:
        if (r9.isEmpty() == true) goto L20;
        r10 = false;
        goto L21
    L13:
        r8 = null;
    L37:
        this.o = true;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public MarkdownReferenceWidget(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = -1;
        this.c = ToolType.None;
        this.e = new ArrayList();
        this.g = new Size(0, 0);
        this.k = LazyKt.lazy(new h());
        this.l = LazyKt.lazy(new i());
        this.m = LazyKt.lazy(new j(r2));
        e0 r4 = (e0) AuthModelDelegate.b.e().getValue();
        if (r4 == null) goto L9;
        LaunchInfo r5 = r4.a;
        if (r5 == null) goto L9;
        DeepThinkingConfig r6 = r5.S();
        if (r6 == null) goto L9;
        boolean r7 = r6.b();
    L10:
        this.o = r7;
        this.p = LazyKt.lazy(new k());
        return;
    L9:
        r7 = true;
        goto L10
    }

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
    public final Size j(int r21, Boolean r22, final Function0<Unit> r23, Integer r24) {
        Integer r2 = null;
        boolean r3 = true;
        int r4 = 0;
        if (this.d == null) goto L27;
        fh8.f r1 = this.n;
        if (r1 == null) goto L10;
        Message r5 = r1.b;
        if (r5 == null) goto L10;
        Integer r6 = Integer.valueOf(r5.getMessageStatusLocal());
    L11:
        if (r6 != null) goto L14;
    L15:
        if (r6 != null) goto L18;
    L20:
        boolean r7 = false;
    L23:
        if (r.c(this.d) == false) goto L26;
        if (r7 == true) goto L27;
    L26:
        if (r.a(this.d) == true) goto L27;
        boolean r8 = false;
    L29:
        if (r8 == false) goto L32;
        this.g = new Size(0, 0);
        getMarkDownReferenceView().b();
        return this.g;
    L32:
        LarusMdThinkEmphasizeSearchReferenceBinding r9 = getMarkDownReferenceView().a;
        if (r9 == null) goto L37;
        AtMostHeightLinearLayout r10 = r9.a;
        if (r10 == null) goto L37;
        e1.x(r10);
    L37:
        this.e.clear();
        SearchReferenceData r11 = this.d;
        if (r11 == null) goto L51;
        List<Reference> r12 = r11.getReference();
        if (r12 == null) goto L51;
        Iterator<T> r13 = r12.iterator();
    L43:
        if (r13.hasNext() == false) goto L51;
        Reference r14 = (Reference) r13.next();
        TextCard r15 = r14.getTextCard();
        if (r15 == null) goto L47;
        this.e.add(r15);
    L47:
        VideoCard r16 = r14.getVideoCard();
        if (r16 == null) goto L43;
        this.e.add(r16);
    L51:
        if (this.h == true) goto L64;
        AtMostHeightLinearLayout r17 = getMarkDownReferenceView().c(getContext(), this);
        if (r17 == null) goto L60;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L59;
        r18.width = -1;
        r18.height = -1;
        r17.setLayoutParams(r18);
        goto L60
    L59:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L60:
        AtMostHeightRecyclerView r19 = getMarkDownReferenceView().a();
        if (r19 == null) goto L63;
        r19.setLayoutManager(new LinearLayoutManager(getContext()));
        r19.addItemDecoration(new MarkdownReferenceWidget$initReferenceList$1$1(this));
        y6.h(r19, this.j);
        this.j = y6.e(r19, new MarkdownReferenceWidget$initReferenceList$1$3(this), new MarkdownReferenceWidget$initReferenceList$1$2(this), new MarkdownReferenceWidget$initReferenceList$1$4(this));
    L63:
        k();
        this.h = true;
    L64:
        Integer r20 = this.b;
        int r25 = Stage.Searching.getValue();
        if (r20 != null) goto L68;
    L70:
        boolean r26 = false;
    L71:
        if (r26 == true) goto L73;
    L75:
        boolean r27 = false;
    L76:
        RecyclerView r28 = getMarkDownReferenceView().a();
        if (r28 == null) goto L121;
        if (r.b(this.d) == true) goto L81;
    L83:
        boolean r29 = false;
    L84:
        if (r29 == false) goto L86;
        int r30 = 0;
    L87:
        r28.setVisibility(r30);
        if (AccountService.a.isEnterpriseAccount() == false) goto L114;
        ArrayList<Object> r31 = this.e;
        if ((r31 instanceof Collection) == true) goto L92;
    L94:
        Iterator<Object> r32 = r31.iterator();
    L96:
        if (r32.hasNext() == false) goto L111;
        Object r33 = r32.next();
        boolean r34 = r33 instanceof TextCard;
        if (r34 == false) goto L108;
        if (r34 == false) goto L101;
        TextCard r35 = (TextCard) r33;
    L102:
        if (r35 == null) goto L104;
        String r36 = r35.getIconUrl();
    L106:
        if (o0.d(r36) == false) goto L108;
        boolean r37 = true;
    L109:
        if (r37 == true) goto L96;
        boolean r38 = false;
    L112:
        if (r38 == false) goto L114;
        boolean r39 = true;
    L115:
        ArrayList<Object> r40 = this.e;
        Function1 r110 = new l(this);
        Context r111 = getContext();
        fh8.f r41 = this.n;
        if (r41 == null) goto L118;
        String r112 = r41.a;
    L119:
        r28.setAdapter(new MessageReferenceAdapter(r39, r40, r110, r111, false, r112, true, false, new m(this)));
        getMarkDownReferenceView().g(r27, this.o);
        goto L121
    L118:
        r112 = null;
        goto L119
    L104:
        r36 = null;
        goto L106
    L101:
        r35 = null;
    L108:
        r37 = false;
    L111:
        r38 = true;
        goto L112
    L92:
        if (r31.isEmpty() == false) goto L94;
    L114:
        r39 = false;
        goto L115
    L86:
        r30 = 8;
        goto L87
    L81:
        if (this.o == true) goto L83;
        r29 = true;
    L121:
        if (r.c(this.d) == false) goto L135;
        usc.e r42 = this.f;
        if (r42 == null) goto L125;
        r42.j();
    L125:
        fh8.f r43 = this.n;
        if (r43 == null) goto L130;
        String r44 = r43.j;
        if (r44 == null) goto L130;
        com.larus.bmhome.chat.markdown.imagegroup.c.b(r44);
    L130:
        e r45 = getMarkDownReferenceView();
        boolean r46 = this.o;
        ToolType r47 = this.c;
        SearchReferenceData r48 = this.d;
        r45.getClass();
        Intrinsics.checkNotNullParameter(r47, "toolType");
        DeepThinkCommonToolHeader r49 = r45.b;
        if (r49 == null) goto L133;
        r49.c(com.larus.bmhome.chat.markdown.reference.a.b(r48));
    L133:
        r45.f(r24);
        r45.d(r46, r47, r48, r22);
    L137:
        TextView r50 = this.q;
        if (r50 == null) goto L142;
        ViewParent r51 = r50.getParent();
        if (r51 == null) goto L142;
        ViewParent r52 = r51.getParent();
    L144:
        if ((r52 instanceof ViewGroup) == false) goto L146;
        ViewGroup r53 = (ViewGroup) r52;
    L147:
        if (r53 == null) goto L149;
        Object r54 = r53.getTag(2131386671);
    L151:
        if ((r54 instanceof v0) == true) goto L153;
    L158:
        e r55 = getMarkDownReferenceView();
        SearchReferenceData r56 = this.d;
        boolean r57 = this.o;
        int r58 = y.a(r21);
        r55.getClass();
        if (r56 == null) goto L163;
        List<String> r59 = r56.getQueries();
        if (r59 == null) goto L163;
        int r60 = r59.size();
    L164:
        boolean r61 = r.c(r56);
        int r113 = View.MeasureSpec.makeMeasureSpec(r58, Integer.MIN_VALUE);
        DeepThinkCommonToolHeader r114 = r55.b;
        if (r114 == null) goto L167;
        r114.measure(r113, 0);
    L167:
        DeepThinkCommonToolHeader r115 = r55.b;
        if (r115 == null) goto L178;
        Integer r116 = Integer.valueOf(r115.getMeasuredHeight());
        if (r116.intValue() <= 0) goto L172;
        boolean r117 = true;
    L173:
        if (r117 == true) goto L176;
        r116 = null;
    L176:
        if (r116 == null) goto L178;
        int r118 = r116.intValue();
    L179:
        if (r57 == true) goto L183;
        if (r61 == true) goto L183;
        boolean r119 = false;
    L184:
        if (r57 == false) goto L186;
    L191:
        boolean r62 = true;
    L192:
        int r120 = View.MeasureSpec.makeMeasureSpec(r58 - (i5.c() * 2), Integer.MIN_VALUE);
        if (r62 == true) goto L204;
        LarusMdThinkEmphasizeSearchReferenceBinding r63 = r55.a;
        if (r63 == null) goto L199;
        TextView r64 = r63.c;
        if (r64 == null) goto L199;
        r64.measure(r120, 0);
    L199:
        LarusMdThinkEmphasizeSearchReferenceBinding r65 = r55.a;
        if (r65 == null) goto L204;
        TextView r66 = r65.c;
        if (r66 == null) goto L204;
        int r67 = r66.getMeasuredHeight();
    L205:
        if (r119 == true) goto L216;
        LarusMdThinkEmphasizeSearchReferenceBinding r121 = r55.a;
        if (r121 == null) goto L211;
        RecyclerView r122 = r121.d;
        if (r122 == null) goto L211;
        r122.measure(r113, 0);
    L211:
        LarusMdThinkEmphasizeSearchReferenceBinding r123 = r55.a;
        if (r123 == null) goto L216;
        RecyclerView r124 = r123.d;
        if (r124 == null) goto L216;
        int r125 = r124.getMeasuredHeight();
    L217:
        int r126 = (r118 + r67) + r125;
        if (r57 == false) goto L220;
        if (r61 == true) goto L220;
    L226:
        DeepThinkCommonToolHeader r68 = r55.b;
        if (r68 == null) goto L230;
        r4 = r68.getMeasuredWidth();
    L230:
        this.g = new Size(r4, r126);
        k();
        SearchReferenceData r69 = this.d;
        if (r69 == null) goto L233;
        r2 = r69.getStage();
    L233:
        this.b = r2;
        return this.g;
    L220:
        if (r56 != null) goto L222;
    L224:
        r3 = false;
    L225:
        if (r3 == true) goto L226;
        r4 = r58;
        goto L230
    L222:
        if (r56.isHeaderWrapContent() != true) goto L224;
    L216:
        r125 = 0;
    L204:
        r67 = 0;
        goto L205
    L186:
        if (((Boolean) r55.d.getValue()).booleanValue() == false) goto L191;
        if (r60 == 0) goto L191;
        if (r61 == true) goto L191;
        r62 = false;
    L183:
        r119 = true;
        goto L184
    L172:
        r117 = false;
    L178:
        r118 = ((Number) r55.c.getValue()).intValue();
    L163:
        r60 = 0;
        goto L164
    L153:
        if (r.c(this.d) == false) goto L156;
        v0 r70 = (v0) r54;
        r70.o = true;
        r70.a();
        r70.j = 0;
        goto L158
    L156:
        if (r.b(this.d) == false) goto L158;
        v0 r71 = (v0) r54;
        r71.o = false;
        r71.b();
        goto L158
    L149:
        r54 = null;
        goto L151
    L146:
        r53 = null;
    L142:
        r52 = null;
        goto L144
    L135:
        if (r.b(this.d) == false) goto L137;
        getMarkDownReferenceView().e(this.c, this.a, this.d, this.e, getContext(), this.o, r24, r22, new g(r23, this));
        goto L137
    L73:
        if (r.b(this.d) == false) goto L75;
        r27 = true;
        goto L76
    L68:
        if (r20.intValue() != r25) goto L70;
        r26 = true;
        goto L71
    L18:
        if (r6.intValue() != 22) goto L20;
    L21:
        r7 = true;
        goto L23
    L14:
        if (r6.intValue() == 23) goto L21;
    L10:
        r6 = null;
    L27:
        r8 = true;
        goto L29
    }

    public final Size d(TextView r6, Spanned r7, final usc.e r8, int r9, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r6, "textView");
        Intrinsics.checkNotNullParameter(r7, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r8, "span");
        fh8.f r0 = fh8.h.b(r10);
        final TypeToken<SearchReferenceData> r1 = getTypeToken();
        if (r0 == null) goto L5;
        final Message r2 = r0.b;
    L6:
        Intrinsics.checkNotNullParameter("MarkdownReferenceWidget", "source");
        Intrinsics.checkNotNullParameter(r8, "span");
        Intrinsics.checkNotNullParameter(r1, "data");
        Object r11 = fh8.b.a(r8, new lh8.a(r2, r8, r1));     // Catch: Exception -> L9
    L11:
        this.d = (SearchReferenceData) r11;
        this.q = r6;
        this.f = r8;
        i(fh8.h.b(r10));
        return j(r9, null, null, null);
    L9:
        e = move-exception;
        FLogger.a.e("MarkdownReferenceWidget", "bindData called failed, " + e.getMessage());
        EnsureManager.ensureNotReachHere(e);
        r11 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.markdown.reference.AbsSearchResultBlockWidget
    public final Size g(SearchReferenceData r1, int r2, fh8.f r3, Integer r4, Boolean r5, Function0 r6) {
        this.d = r1;
        i(r3);
        return j(r2, r5, r6, r4);
    }
}
