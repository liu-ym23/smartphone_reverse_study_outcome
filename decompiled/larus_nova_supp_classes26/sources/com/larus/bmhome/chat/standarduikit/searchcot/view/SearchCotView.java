package com.larus.bmhome.chat.standarduikit.searchcot.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.bmhome.chat.adapter.MessageReferenceAdapter;
import com.larus.bmhome.chat.layout.widget.AtMostHeightLinearLayout;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.chat.markdown.reference.Stage;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.reference.e;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import com.larus.mainbot.impl.databinding.LarusMdThinkEmphasizeSearchReferenceBinding;
import com.larus.platform.service.AccountService;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jn8.a;
import jn8.b;
import jn8.d;
import jn8.f;
import jn8.g;
import jn8.h;
import jn8.i;
import jn8.j;
import jn8.k;
import kn8.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.d6;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0003H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006%"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/searchcot/view/SearchCotView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/searchcot/view/SearchCotViewInput;", "Lcom/larus/bmhome/chat/standarduikit/searchcot/view/SearchCotViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "searchCotOutput", "emphasizeSearchCotView", "Lcom/larus/bmhome/chat/markdown/reference/EmphasizeReferenceViewImpl;", "getEmphasizeSearchCotView", "()Lcom/larus/bmhome/chat/markdown/reference/EmphasizeReferenceViewImpl;", "emphasizeSearchCotView$delegate", "Lkotlin/Lazy;", "messageReferenceAdapter", "Lcom/larus/bmhome/chat/adapter/MessageReferenceAdapter;", "lastOnItemCompletelyShowCallBackWrapper", "Lcom/larus/common_ui/utils/OnItemCompletelyShowCallBackWrapper;", "isUserClick", "", "lastStage", "", "Ljava/lang/Integer;", "bindData", "", "input", "output", "currentToolTitle", "", "updateReferenceTitle", "updateReferenceList", "updateSearchLoading", "shouldShowAnimation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchCotView extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public k a;
    public final Lazy b;
    public d6 c;
    public boolean d;
    public Integer e;

    private final e getEmphasizeSearchCotView() {
        return (e) this.b.getValue();
    }

    public SearchCotView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public SearchCotView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.b = LazyKt.lazy(new a());
        this.e = -1;
        AtMostHeightLinearLayout r5 = getEmphasizeSearchCotView().c(r3, this);
        if (r5 == null) goto L9;
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (r0 == null) goto L8;
        r0.width = -2;
        r0.height = -1;
        r5.setLayoutParams(r0);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [jn8.g] */
    public final void b(final j r24, c.b r25) {
        Intrinsics.checkNotNullParameter(r24, "input");
        Intrinsics.checkNotNullParameter(r25, "output");
        this.a = r25;
        Integer r9 = r24.g;
        if (Intrinsics.areEqual(r24.m, Boolean.TRUE) == false) goto L6;
        getEmphasizeSearchCotView().b();
        return;
    L6:
        LarusMdThinkEmphasizeSearchReferenceBinding r0 = getEmphasizeSearchCotView().a;
        if (r0 == null) goto L11;
        AtMostHeightLinearLayout r1 = r0.a;
        if (r1 == null) goto L11;
        e1.x(r1);
    L11:
        final SearchReferenceData r3 = new SearchReferenceData(r24.c, r24.d, r24.e, r24.f, r24.g, r24.h, r24.i, r24.j, r24.k, false, 512, null);
        ToolType.a r2 = ToolType.Companion;
        String r4 = r24.k;
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r2.getClass();
        final ToolType r5 = ToolType.a.a(r4);
        Integer r6 = r24.g;
        int r7 = Stage.Searching.getValue();
        if (r6 != null) goto L18;
    L27:
        Integer r8 = r24.g;
        int r10 = Stage.Searched.getValue();
        if (r8 != null) goto L31;
    L47:
        AtMostHeightRecyclerView r11 = getEmphasizeSearchCotView().a();
        if (r11 == null) goto L134;
        final ArrayList r14 = new ArrayList();
        List<Reference> r12 = r24.d;
        if (r12 == null) goto L61;
        Iterator<T> r13 = r12.iterator();
    L53:
        if (r13.hasNext() == false) goto L61;
        Reference r15 = (Reference) r13.next();
        TextCard r16 = r15.getTextCard();
        if (r16 != null) goto L56;
        VideoCard r17 = r15.getVideoCard();
        if (r17 == null) goto L53;
        r14.add(r17);
        goto L53
    L56:
        r14.add(r16);
    L61:
        if (r11.getLayoutManager() != null) goto L63;
        r11.setLayoutManager(new LinearLayoutManager(getContext()));
        r11.addItemDecoration(new SearchCotView$updateReferenceList$1$2());
    L63:
        y6.h(r11, this.c);
        this.c = y6.e(r11, new b(r24), new jn8.c(r14), new d(this, r24));
        Integer r18 = r24.g;
        int r19 = Stage.Searched.getValue();
        if (r18 != null) goto L67;
    L74:
        boolean r20 = false;
    L75:
        if (r20 == false) goto L77;
        int r21 = 0;
    L78:
        r11.setVisibility(r21);
        if (r20 == false) goto L134;
        if (AccountService.a.isEnterpriseAccount() == true) goto L84;
    L106:
        boolean r110 = false;
    L107:
        Function1 r111 = new jn8.e(r24, this);
        Context r112 = getContext();
        String r22 = r24.n;
        if (r22 != null) goto L110;
        String r113 = "";
    L111:
        r11.setAdapter(new MessageReferenceAdapter(r110, r14, r111, r112, false, r113, true, false, new f(r24)));
        Integer r23 = this.e;
        int r26 = Stage.Searching.getValue();
        if (r23 != null) goto L115;
    L117:
        boolean r27 = false;
    L118:
        Integer r28 = r24.g;
        int r29 = Stage.Searched.getValue();
        if (r28 != null) goto L122;
    L124:
        boolean r30 = false;
    L125:
        if (r27 == false) goto L128;
        if (r30 == false) goto L128;
        boolean r31 = true;
    L129:
        e r32 = getEmphasizeSearchCotView();
        Boolean r33 = r24.l;
        if (r33 == null) goto L132;
        boolean r34 = r33.booleanValue();
    L133:
        r32.g(r31, r34);
        goto L134
    L132:
        r34 = true;
    L128:
        r31 = false;
        goto L129
    L122:
        if (r28.intValue() != r29) goto L124;
        r30 = true;
        goto L125
    L115:
        if (r23.intValue() != r26) goto L117;
        r27 = true;
        goto L118
    L110:
        r113 = r22;
        goto L111
    L84:
        if (r14.isEmpty() == true) goto L103;
        Iterator r35 = r14.iterator();
    L88:
        if (r35.hasNext() == false) goto L103;
        Object r36 = r35.next();
        boolean r37 = r36 instanceof TextCard;
        if (r37 == false) goto L100;
        String r38 = null;
        if (r37 == false) goto L94;
        TextCard r39 = (TextCard) r36;
    L95:
        if (r39 == null) goto L98;
        r38 = r39.getIconUrl();
    L98:
        if (o0.d(r38) == false) goto L100;
        boolean r40 = true;
    L101:
        if (r40 == true) goto L88;
        boolean r41 = false;
    L104:
        if (r41 == false) goto L106;
        r110 = true;
        goto L107
    L94:
        r39 = null;
    L100:
        r40 = false;
    L103:
        r41 = true;
        goto L104
    L77:
        r21 = 8;
        goto L78
    L67:
        if (r18.intValue() != r19) goto L74;
        Boolean r42 = r24.l;
        if (r42 == null) goto L71;
        boolean r43 = r42.booleanValue();
    L72:
        if (r43 == true) goto L74;
        r20 = true;
        goto L75
    L71:
        r43 = true;
    L134:
        Integer r44 = r24.g;
        int r45 = Stage.Searching.getValue();
        if (r44 != null) goto L138;
    L142:
        Integer r46 = r24.g;
        int r47 = Stage.Searched.getValue();
        if (r46 != null) goto L146;
    L150:
        this.e = r9;
        r25.e();
        return;
    L146:
        if (r46.intValue() != r47) goto L150;
        k r48 = this.a;
        if (r48 == null) goto L150;
        r48.a(false);
        goto L150
    L138:
        if (r44.intValue() != r45) goto L142;
        k r49 = this.a;
        if (r49 == null) goto L150;
        r49.a(true);
        goto L150
    L31:
        if (r8.intValue() != r10) goto L47;
        final ArrayList r50 = new ArrayList();
        List<Reference> r51 = r24.d;
        if (r51 == null) goto L43;
        Iterator<T> r52 = r51.iterator();
    L36:
        if (r52.hasNext() == false) goto L43;
        Reference r53 = (Reference) r52.next();
        TextCard r54 = r53.getTextCard();
        if (r54 == null) goto L40;
        r50.add(r54);
    L40:
        VideoCard r55 = r53.getVideoCard();
        if (r55 == null) goto L36;
        r50.add(r55);
    L43:
        final ?? r114 = new g(this, r5, r3, r50, r24);
        if (Intrinsics.areEqual(r24.t, Boolean.TRUE) == false) goto L46;
        r114.invoke();
        goto L47
    L46:
        post(new h(r114));
        goto L47
    L18:
        if (r6.intValue() != r7) goto L27;
        e r56 = getEmphasizeSearchCotView();
        Boolean r57 = r24.l;
        if (r57 == null) goto L22;
        boolean r58 = r57.booleanValue();
    L23:
        Integer r59 = r24.q;
        Boolean r60 = r24.r;
        r56.getClass();
        Intrinsics.checkNotNullParameter(r5, "toolType");
        DeepThinkCommonToolHeader r115 = r56.b;
        if (r115 == null) goto L26;
        r115.c(com.larus.bmhome.chat.markdown.reference.a.b(r3));
    L26:
        r56.f(r59);
        r56.d(r58, r5, r3, r60);
        goto L47
    L22:
        r58 = true;
        goto L23
    }

    public static Unit a(final SearchCotView r10, ToolType r11, SearchReferenceData r12, ArrayList r13, final j r14) {
        e r0 = r10.getEmphasizeSearchCotView();
        boolean r2 = r10.d;
        Context r5 = r10.getContext();
        Boolean r1 = r14.l;
        if (r1 == null) goto L5;
        boolean r6 = r1.booleanValue();
    L6:
        r0.e(r11, r2, r12, r13, r5, r6, r14.q, r14.r, new i(r14, r10));
        return Unit.INSTANCE;
    L5:
        r6 = true;
        goto L6
    }
}
