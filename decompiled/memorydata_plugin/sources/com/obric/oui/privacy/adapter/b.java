package com.obric.oui.privacy.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/privacy/adapter/PrivacySheetAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/obric/oui/privacy/PrivacyItem;", "(Ljava/util/List;)V", "switchItemCount", "", "getSwitchItemCount", "()I", "switchItemCount$delegate", "Lkotlin/Lazy;", "switchStartIndex", "getSwitchStartIndex", "switchStartIndex$delegate", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b extends RecyclerView.Adapter<RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14387a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f14388b;
    private final Lazy c;
    private final Lazy d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/privacy/adapter/PrivacySheetAdapter$Companion;", "", "()V", "TYPE_PERMISSION", "", "TYPE_SWITCH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14387a = new a(null);
    }

    public b(List<? extends d> r3) {
        List<d> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "items");
        this.f14388b = r4;
        this.c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new PrivacySheetAdapter$switchItemCount$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new PrivacySheetAdapter$switchStartIndex$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final int a() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.c.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final /* synthetic */ List a(b r0) {
        return r0.f14388b;
    }

    private final int b() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.d.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r2) {
        d r1 = (d) ZeusTransformUtils.preCheckCast(this.f14388b.get(r2), d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, d.b.class) == false) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, d.a.class) == false) goto L10;
        return 1;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.v a(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 0) goto L5;
        c.a r5 = c.f14389a;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "parent.context");
        Object r2 = r5.a(r6);
    L11:
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(r2, RecyclerView.v.class, "com.obric.memorydata.plugin");
    L5:
        if (r4 != 1) goto L8;
        com.obric.oui.privacy.adapter.a.C0770a r7 = com.obric.oui.privacy.adapter.a.f14385a;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r8, "parent.context");
        r2 = r7.a(r8);
        goto L11
    L8:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unknown viewType: ", Integer.valueOf(r4)));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L6;
        d.b r0 = (d.b) ZeusTransformUtils.preCheckCast(this.f14388b.get(r5), d.b.class, "com.obric.memorydata.plugin");
        ((c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin")).a(r0, r5, a(), b());
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.privacy.adapter.a.class) == false) goto L10;
        d.a r3 = (d.a) ZeusTransformUtils.preCheckCast(this.f14388b.get(r5), d.a.class, "com.obric.memorydata.plugin");
        ((com.obric.oui.privacy.adapter.a) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.privacy.adapter.a.class, "com.obric.memorydata.plugin")).a(r3);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.f14388b.size();
    }
}
