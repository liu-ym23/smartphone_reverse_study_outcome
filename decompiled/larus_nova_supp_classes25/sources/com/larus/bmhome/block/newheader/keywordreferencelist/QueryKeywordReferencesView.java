package com.larus.bmhome.block.newheader.keywordreferencelist;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.MessageReferenceAdapter;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.im.bean.message.TextCard;
import com.larus.platform.service.AccountService;
import com.larus.utils.e1;
import com.larus.utils.o0;
import hb8.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kb8.b;
import kb8.c;
import kb8.d;
import kb8.e;
import kb8.f;
import kb8.g;
import kb8.h;
import kb8.i;
import kb8.n;
import kb8.o;
import kb8.u;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u0005B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0004H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003H\u0002J\u0006\u0010%\u001a\u00020\u000bJ\b\u0010&\u001a\u00020\"H\u0002J\u0018\u0010'\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\"H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010 \u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/bmhome/block/newheader/keywordreferencelist/QueryKeywordReferencesView;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/block/newheader/keywordreferencelist/QueryKeywordReferencesViewInput;", "Lcom/larus/bmhome/block/newheader/keywordreferencelist/QueryKeywordReferencesViewOutput;", "Lcom/larus/bmhome/block/newheader/IRecyclableLifecycle;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isLayoutInitialized", "", "foldStatus", "Lcom/larus/bmhome/chat/bean/DeepThinkFoldStatus;", "list", "", "Lcom/larus/bmhome/block/newheader/keywordreferencelist/ReferenceWrapper;", "tvSearchKeyWords", "Landroid/widget/TextView;", "getTvSearchKeyWords", "()Landroid/widget/TextView;", "tvSearchKeyWords$delegate", "Lkotlin/Lazy;", "rvReferenceList", "Lcom/larus/bmhome/chat/layout/widget/AtMostHeightRecyclerView;", "getRvReferenceList", "()Lcom/larus/bmhome/chat/layout/widget/AtMostHeightRecyclerView;", "rvReferenceList$delegate", "output", "bindData", "", "input", "setupSearchKeywords", "getAnimationMeasureHeight", "initLayout", "setupAdapter", "notifyLastItemShow", "onRecycle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class QueryKeywordReferencesView extends LinearLayout implements a {
    public static final /* synthetic */ int g = 0;
    public boolean a;
    public DeepThinkFoldStatus b;
    public List<u> c;
    public final Lazy d;
    public final Lazy e;
    public n f;

    public QueryKeywordReferencesView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public QueryKeywordReferencesView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final AtMostHeightRecyclerView getRvReferenceList() {
        return (AtMostHeightRecyclerView) this.e.getValue();
    }

    private final TextView getTvSearchKeyWords() {
        return (TextView) this.d.getValue();
    }

    @Override // hb8.a
    public final void f() {
        if (this.a == false) goto L6;
        getRvReferenceList().setAdapter(null);
        return;
    }

    public final int getAnimationMeasureHeight() {
        return getRvReferenceList().getMeasuredHeight() + getTvSearchKeyWords().getMeasuredHeight();
    }

    private final void setupSearchKeywords(i r2) {
        if (r2.b.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        e1.o(getTvSearchKeyWords());
        return;
    L8:
        e1.x(getTvSearchKeyWords());
        getTvSearchKeyWords().setText(r2.b);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void a(final i r21, final n r22) {
        Intrinsics.checkNotNullParameter(r21, "input");
        Intrinsics.checkNotNullParameter(r22, "output");
        if (this.a == true) goto L6;
        getRvReferenceList().setLayoutManager(new LinearLayoutManager(getContext()));
        getRvReferenceList().addItemDecoration(new QueryKeywordReferencesView$initLayout$1(this));
        y6.d(getRvReferenceList(), new d(this), new e(this), null, new f(this), 9);
        this.a = true;
    L6:
        this.b = r21.g;
        this.c = r21.c;
        this.f = r22;
        we8.a.b(getTvSearchKeyWords(), i5.o(), false, null, null, 12);
        String r6 = null;
        if (r21.f == false) goto L14;
        RecyclerView.Adapter r3 = getRvReferenceList().getAdapter();
        if ((r3 instanceof MessageReferenceAdapter) == false) goto L11;
        MessageReferenceAdapter r4 = (MessageReferenceAdapter) r3;
    L12:
        if (r4 == null) goto L14;
        r4.h = false;
        r4.notifyItemChanged(r4.j - 1);
        goto L14
    L11:
        r4 = null;
    L14:
        setupSearchKeywords(r21);
        if (r21.c.isEmpty() == false) goto L17;
        return;
    L17:
        if (r21.a == false) goto L78;
        List<u> r5 = r21.c;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r8 = r5.iterator();
    L21:
        if (r8.hasNext() == false) goto L23;
        r7.add(((u) r8.next()).a);
        goto L21
    L23:
        List r12 = CollectionsKt.toMutableList(r7);
        if (AccountService.a.isEnterpriseAccount() == false) goto L50;
        List r9 = r12;
        if ((r9 instanceof Collection) == true) goto L28;
    L30:
        Iterator r10 = r9.iterator();
    L32:
        if (r10.hasNext() == false) goto L47;
        Object r11 = r10.next();
        boolean r13 = r11 instanceof TextCard;
        if (r13 == false) goto L44;
        if (r13 == false) goto L37;
        TextCard r14 = (TextCard) r11;
    L38:
        if (r14 == null) goto L40;
        String r15 = r14.getIconUrl();
    L42:
        if (o0.d(r15) == false) goto L44;
        boolean r16 = true;
    L45:
        if (r16 == true) goto L32;
        boolean r17 = false;
    L48:
        if (r17 == false) goto L50;
        boolean r18 = true;
    L51:
        if (r18 == false) goto L53;
        getRvReferenceList().setPadding(c7.b(16), c7.b(10), c7.b(16), 0);
    L54:
        AtMostHeightRecyclerView r19 = getRvReferenceList();
        Context r110 = getContext();
        o r20 = r21.d;
        if (r20 == null) goto L57;
        boolean r111 = r20.d;
    L58:
        if (r20 == null) goto L60;
        boolean r112 = r20.f;
    L61:
        if (r20 == null) goto L63;
        r6 = r20.e;
    L63:
        if (r6 != null) goto L65;
        String r113 = "";
    L66:
        r19.setAdapter(new MessageReferenceAdapter(r18, r12, new g(r22), r110, r111, r113, false, r112, new h(r21)));
        if (r21.e == false) goto L77;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(getRvReferenceList(), "alpha", new float[]{0.0f, 1.0f});
        r1.setDuration(500);
        r1.start();
        return;
    L77:
        return;
    L65:
        r113 = r6;
        goto L66
    L60:
        r112 = false;
        goto L61
    L57:
        r111 = false;
        goto L58
    L53:
        getRvReferenceList().setPadding(0, c7.b(10), 0, 0);
        goto L54
    L40:
        r15 = null;
        goto L42
    L37:
        r14 = null;
    L44:
        r16 = false;
    L47:
        r17 = true;
        goto L48
    L28:
        if (r9.isEmpty() == false) goto L30;
    L50:
        r18 = false;
        goto L51
    }

    public QueryKeywordReferencesView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = DeepThinkFoldStatus.CompleteFold;
        this.d = LazyKt.lazy(new b(r2));
        this.e = LazyKt.lazy(new c(r2));
        setOrientation(1);
        addView(getTvSearchKeyWords(), new LinearLayout.LayoutParams(-1, -2));
        addView(getRvReferenceList(), new LinearLayout.LayoutParams(-1, -2));
    }

    public /* synthetic */ QueryKeywordReferencesView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
