package com.larus.dora.impl.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.dora.impl.device.DoraBaseFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0014\u0010\u001f\u001a\u00020\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0010\u0010!\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u001c\u0010\"\u001a\u00020\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u0002J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/dynamic/DoraDynamicListFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "Lcom/larus/dora/impl/dynamic/event/ActionHandler;", "<init>", "()V", "value", "Landroidx/recyclerview/widget/RecyclerView;", "rvDynamicList", "getRvDynamicList", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/larus/dora/impl/dynamic/DslCardAdapter;", "adapter", "getAdapter", "()Lcom/larus/dora/impl/dynamic/DslCardAdapter;", "items", "", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "doraViewModelAction", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setCards", "newItems", "setCardContext", "setData", "setActionHandler", "actionHandler", "getCurrentPageName", "", "onAction", "action", "Lcom/larus/dora/impl/dynamic/event/ViewHolderAction;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDynamicListFragment extends DoraBaseFragment implements e59.a {
    public RecyclerView f;
    public DslCardAdapter g;
    public List<c59.i> h;
    public d59.b i;
    public e59.a j;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "DoraDynamicListFragment";
    }

    public DoraDynamicListFragment() {
        this.h = CollectionsKt.emptyList();
    }

    @Override // e59.a
    public final void onAction(e59.e r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if ((r3 instanceof e59.e.c) == false) goto L9;
        g49.d.d("DoraDynamicListFragment", "onAction: RemoveRequest");
        c59.i r4 = ((e59.e.c) r3).a;
        if (r4 == null) goto L13;
        DslCardAdapter r0 = this.g;
        if (r0 == null) goto L14;
        r0.z2(r4);
        return;
    L14:
        return;
    L13:
        return;
    L9:
        e59.a r1 = this.j;
        if (r1 == null) goto L16;
        r1.onAction(r3);
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        RecyclerView r4 = r2.findViewById(2131384941);
        this.f = r4;
        if (r4 == null) goto L5;
        r4.setLayoutManager(new LinearLayoutManager(r4.getContext()));
        r4.setNestedScrollingEnabled(true);
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    L5:
        this.g = new DslCardAdapter(this);
        RecyclerView r5 = this.f;
        if (r5 == null) goto L10;
        r5.setLayoutManager(new LinearLayoutManager(getContext()));
        r5.addItemDecoration(new LastItemMarginDecoration(c7.b(28)));
        r5.setItemAnimator(null);
        r5.setAdapter(this.g);
        final DslCardAdapter r6 = this.g;
        if (r6 == null) goto L10;
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        r5.addOnScrollListener(new DslCardAdapter$enableLoadMore$1(r6));
    L10:
        DslCardAdapter r7 = this.g;
        if (r7 == null) goto L13;
        r7.B2(this.h);
    L13:
        d59.b r8 = this.i;
        if (r8 == null) goto L19;
        DslCardAdapter r9 = this.g;
        if (r9 == null) goto L20;
        r9.A2(r8);
        return;
    L20:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562172, r3, false);
    }
}
