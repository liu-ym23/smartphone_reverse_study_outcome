package com.obric.assistant.card.layout.viewholder.abs;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.utils.e1;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.adapter.AppEntityListAdapter;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pca.b;
import pca.c;
import qca.a;
import qca.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\u0019\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ@\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u0007J5\u00104\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u00028\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H$¢\u0006\u0002\u00105J.\u00106\u001a\u00020+2\u0006\u00107\u001a\u0002082\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0004J\u0010\u0010;\u001a\u00020+2\b\u0010<\u001a\u0004\u0018\u00010:J\u0010\u0010?\u001a\u00020+2\b\u0010<\u001a\u0004\u0018\u00010>J\b\u0010@\u001a\u00020+H\u0016J\b\u0010A\u001a\u00020+H\u0016R\u0016\u0010\u0005\u001a\u00028\u0001X\u0084\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/abs/AbsCardItemViewHolder;", "T", "V", "Landroidx/viewbinding/ViewBinding;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "autoSetClickListener", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroidx/viewbinding/ViewBinding;Z)V", "getViewBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "hasSetGray", "getHasSetGray", "()Z", "setHasSetGray", "(Z)V", "value", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "currentEntityGroup", "getCurrentEntityGroup", "()Ljava/util/List;", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "pageType", "Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$PageType;", "getPageType", "()Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$PageType;", "setPageType", "(Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$PageType;)V", "bind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entityGroup", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "isDeleted", "isRefreshed", "onBind", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "setEventListener", "view", "Landroid/view/View;", "itemClickListener", "Lcom/obric/assistant/card/layout/listener/OnItemClickListener;", "setOnItemClickListener", "listener", "itemLongClickListener", "Lcom/obric/assistant/card/layout/listener/OnItemLongClickListener;", "setOnLongClickListener", "onViewDetached", "onViewAttached", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemViewHolder<T, V extends ViewBinding> extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int i = 0;
    public final V a;
    public final boolean b;
    public final Lazy c;
    public List<? extends Object> d;
    public final Lazy e;
    public AppEntityListAdapter.PageType f;
    public b g;
    public c h;

    public abstract void T3(MessageExtraForViewHolder r1, T r2, int r3, boolean r4, boolean r5);

    public void U3() {
    }

    public void V3() {
    }

    public final Context getContext() {
        return (Context) this.c.getValue();
    }

    public AbsCardItemViewHolder(V r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        super(r2.getRoot());
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new qca.c(this));
        this.d = CollectionsKt.emptyList();
        this.e = LazyKt.lazy(new d(this));
    }

    public final void W3(View r3, final List<? extends Object> r4, final Object r5, final int r6) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "entityGroup");
        Intrinsics.checkNotNullParameter(r5, "entity");
        final b r0 = this.g;
        if (r0 == null) goto L5;
        e1.d(r3, new a(r0, r4, r5, r6));
    L5:
        final c r7 = this.h;
        if (r7 == null) goto L9;
        r3.setOnLongClickListener(new qca.b(r7));
        return;
    }
}
