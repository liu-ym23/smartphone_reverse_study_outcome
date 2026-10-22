package com.larus.dora.impl.dynamic;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.dynamic.dsl.DslTemplateType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 52\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u00015B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010\u0017\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019J\u0010\u0010\u001a\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001c\u0010\u001b\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u000f\u001a\u00020\u0010J\u0014\u0010\u001c\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\fJ\u000e\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\fJ\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u001e\u0010(\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010*\u001a\u00020'H\u0016J\u0016\u0010+\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010,\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010-\u001a\u00020'H\u0016J\u0010\u0010.\u001a\u00020'2\u0006\u0010*\u001a\u00020'H\u0016J\u000e\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u00020\f2\u0006\u00103\u001a\u000204R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/dora/impl/dynamic/DslCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "actionHandler", "Lcom/larus/dora/impl/dynamic/event/ActionHandler;", "<init>", "(Lcom/larus/dora/impl/dynamic/event/ActionHandler;)V", "items", "", "loadMoreListener", "Lkotlin/Function0;", "", "isLoading", "", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "handler", "Landroid/os/Handler;", "setLoadMoreListener", "listener", "setCards", "newItems", "", "setCardContext", "setData", "addData", "removeData", "data", "onLoadMoreComplete", "updateConnectionState", "newState", "updateDeviceInfoState", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onViewDetachedFromWindow", "onViewRecycled", "getItemCount", "getItemViewType", "enableLoadMore", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "handleEvent", "event", "Lcom/larus/dora/impl/dynamic/DslCardAdapter$Companion$DslCardAdapterEvent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DslCardAdapter extends RecyclerView.Adapter<BaseViewHolder<c59.i>> {
    public static final /* synthetic */ int g = 0;
    public final e59.a a;
    public final List<c59.i> b;
    public boolean c;
    public d59.b d;
    public volatile e59.b e;
    public final Handler f;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DslCardAdapter$a$a, reason: collision with other inner class name */
        public interface InterfaceC0061a {

            /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DslCardAdapter$a$a$a, reason: collision with other inner class name */
            public static final class C0062a implements InterfaceC0061a {
                public static final C0062a a = null;

                static {
                    a = new C0062a();
                }

                public C0062a() {
                }
            }

            /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DslCardAdapter$a$a$b */
            public static final class b implements InterfaceC0061a {
                public static final b a = null;

                static {
                    a = new b();
                }

                public b() {
                }
            }

            /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DslCardAdapter$a$a$c */
            public static final class c implements InterfaceC0061a {
                public static final c a = null;

                static {
                    a = new c();
                }

                public c() {
                }
            }

            /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DslCardAdapter$a$a$d */
            public static final class d implements InterfaceC0061a {
                public static final d a = null;

                static {
                    a = new d();
                }

                public d() {
                }
            }
        }
    }

    static {
    }

    public DslCardAdapter() {
        this(null);
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public final void E2() {
        int r0 = getItemCount();
        final int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        int r2 = getItemViewType(r1);
        if (DslTemplateType.PRODUCT_DISPLAY.ordinal() != r2) goto L7;
    L8:
        this.f.post(new j1(this, r1));
    L9:
        r1 = r1 + 1;
        goto L3
    L7:
        if (DslTemplateType.SINGLE_DEVICE_PRODUCT_DISPLAY.ordinal() != r2) goto L9;
    }

    public DslCardAdapter(e59.a r2) {
        this.a = r2;
        this.b = new ArrayList();
        this.e = e59.b.d.a;
        this.f = new Handler(Looper.getMainLooper());
    }

    public final void A2(d59.b r3) {
        this.d = r3;
        g49.d.d("DslNodeAdapter", "setCardContext, cardContext: " + r3);
    }

    public final void B2(List<c59.i> r3) {
        Intrinsics.checkNotNullParameter(r3, "newItems");
        g49.d.d("DslNodeAdapter", "setCards, newItems: " + r3.size());
        ((ArrayList) this.b).clear();
        ((ArrayList) this.b).addAll(r3);
        this.f.post(new i1(this));
    }

    public final void D2(e59.b r2) {
        Intrinsics.checkNotNullParameter(r2, "newState");
        if (Intrinsics.areEqual(this.e, r2) == false) goto L5;
        return;
    L5:
        this.e = r2;
        this.f.post(new k1(this));
    }

    public final int getItemViewType(int r3) {
        if (((ArrayList) this.b).isEmpty() == false) goto L5;
        return 0;
    L5:
        if (((c59.i) ListProtector.get(this.b, r3)).b == null) goto L13;
        DslTemplateType r4 = ((c59.i) ListProtector.get(this.b, r3)).a;
        if (r4 != null) goto L10;
        return 0;
    L10:
        return r4.ordinal();
    L13:
        return 0;
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        BaseViewHolder r3 = (BaseViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewDetachedFromWindow(r3);
        r3.V3();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        BaseViewHolder r3 = (BaseViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        r3.onViewRecycled();
    }

    public final void y2(a.InterfaceC0061a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (Intrinsics.areEqual(r2, a.InterfaceC0061a.c.a) == false) goto L6;
        this.f.post(new e1(this));
        return;
    L6:
        if (Intrinsics.areEqual(r2, a.InterfaceC0061a.C0062a.a) == false) goto L9;
        this.f.post(new f1(this));
        return;
    L9:
        if (Intrinsics.areEqual(r2, a.InterfaceC0061a.d.a) == false) goto L12;
        this.f.post(new g1(this));
        return;
    L12:
        if (Intrinsics.areEqual(r2, a.InterfaceC0061a.b.a) == false) goto L16;
        this.f.post(new h1(this));
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final void z2(c59.i r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        final int r4 = ((ArrayList) this.b).indexOf(r3);
        if (r4 == (-1)) goto L6;
        ListProtector.remove(this.b, r4);
        this.f.post(new m1(this, r4));
        return;
    }

    public final void C2(List<c59.i> r2, d59.b r3) {
        Intrinsics.checkNotNullParameter(r2, "newItems");
        Intrinsics.checkNotNullParameter(r3, "cardContext");
        this.d = r3;
        ((ArrayList) this.b).clear();
        ArrayList r4 = (ArrayList) this.b;
        r4.addAll(r2);
        this.f.post(new l1(this));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        BaseViewHolder r5 = (BaseViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        r5.U3();
        r5.T3(ListProtector.get(this.b, r4), this.e, this.d);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        BaseViewHolder r4 = com.larus.dora.impl.dynamic.viewholder.n.a(r2, r3);
        e59.a r5 = this.a;
        if (r5 == null) goto L5;
        Intrinsics.checkNotNullParameter(r5, "handler");
        r4.a = r5;
    L5:
        return r4;
    }
}
