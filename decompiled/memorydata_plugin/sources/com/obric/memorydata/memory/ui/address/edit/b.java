package com.obric.memorydata.memory.ui.address.edit;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.api.model.AddressInfo;
import com.obric.memorydata.memory.databinding.ItemAddressSearchBinding;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.i;
import com.obric.oui.orecyclerview.widget.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 !2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003!\"#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\r\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\b2\n\u0010\u0019\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J*\u0010\u0018\u001a\u00020\b2\n\u0010\u0019\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J$\u0010\u001e\u001a\u00020\b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressSearchAdapter;", "Lcom/obric/oui/orecyclerview/widget/ListAdapter;", "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "Lcom/obric/memorydata/memory/ui/address/edit/AddressSearchAdapter$AddressViewHolder;", "<init>", "()V", "onItemClickListener", "Lkotlin/Function1;", "", "currentSearchKeyword", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "setOnItemClickListener", "listener", "setSearchKeyword", "keyword", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "payloads", "", "", "onCurrentListChanged", "previousList", "currentList", "Companion", "AddressViewHolder", "DiffCallback", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends q<AddressInfo, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0522b f10583a = null;
    private Function1<? super AddressInfo, Unit> c;
    private String d;
    private RecyclerView e;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J:\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0010J\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\n\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressSearchAdapter$AddressViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/obric/memorydata/memory/databinding/ItemAddressSearchBinding;", "<init>", "(Lcom/obric/memorydata/memory/ui/address/edit/AddressSearchAdapter;Lcom/obric/memorydata/memory/databinding/ItemAddressSearchBinding;)V", "bind", "", MemoryKeyInfoEntity.KEY_ADDRESS, "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "position", "", "itemCount", "keyword", "", "onClick", "Lkotlin/Function1;", "updateCardPosition", "getCurrentAddress", "highlightKeyword", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "resolveCardPosition", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f10584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ItemAddressSearchBinding f10585b;

        public a(b r3, ItemAddressSearchBinding r4) {
            Intrinsics.checkNotNullParameter(r4, "binding");
            this.f10584a = r3;
            super((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
            this.f10585b = r4;
        }

        private final AddressInfo a() {
            int r0 = o();
            if (r0 != (-1)) goto L6;
            return null;
        L6:
            return b.a(this.f10584a, r0);
        }

        private final CharSequence a(String r8, String r9) {
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L10;
        L7:
            Object r10 = ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        L9:
            return (CharSequence) r10;
        L10:
            int r11 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), r9, 0, true, 2, null);
            if (r11 == (-1)) goto L7;
            SpannableStringBuilder r1 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"));
            r1.setSpan(new ForegroundColorSpan(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6"), null)), r11, r9.length() + r11, 33);
            r10 = ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
            goto L9
        L5:
            r7 = false;
            goto L6
        }

        private static final void a(a r1, Function1 r2, View r3) {
            Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
            AddressInfo r5 = r1.a();
            if (r5 == null) goto L6;
            r4.invoke(r5);
            return;
        }

        private final int c(int r1, int r2) {
            if (r2 > 1) goto L5;
            return 0;
        L5:
            if (r1 != 0) goto L8;
            return 1;
        L8:
            if (r1 != (r2 - 1)) goto L10;
            return 3;
        L10:
            return 2;
        }

        /* JADX INFO: renamed from: lambda$T3JFL_Y_fqdVDBzQ-Hj2W1Javiw, reason: not valid java name */
        public static /* synthetic */ void m774lambda$T3JFL_Y_fqdVDBzQHj2W1Javiw(a r0, Function1 r1, View r2) {
            a(r0, r1, r2);
        }

        public final void a(int r4, int r5) {
            OCardListItem.a((OCardListItem) ZeusTransformUtils.preCheckCast(this.f10585b.addressItem, OCardListItem.class, "com.obric.memorydata.plugin"), c(r4, r5), false, 2, null);
        }

        public final void a(AddressInfo r4, int r5, int r6, String r7, Function1<? super AddressInfo, Unit> r8) {
            final Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, MemoryKeyInfoEntity.KEY_ADDRESS);
            Intrinsics.checkNotNullParameter(r7, "keyword");
            Intrinsics.checkNotNullParameter(r9, "onClick");
            DeviceAdaptiveCardListItem r0 = this.f10585b.addressItem;
            r0.setTitle(a(r4.getName(), r7));
            r0.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r4.getDetail(), CharSequence.class, "com.obric.memorydata.plugin"));
            r0.b(false);
            r0.c(true);
            r0.d(true);
            r0.e(false);
            r0.f(false);
            a(r5, r6);
            r0.setOnContentClickListener(new $$Lambda$b$a$T3JFL_Y_fqdVDBzQHj2W1Javiw(this, r9));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressSearchAdapter$Companion;", "", "<init>", "()V", "PAYLOAD_CARD_POSITION", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0522b {
        private C0522b() {
        }

        public /* synthetic */ C0522b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressSearchAdapter$DiffCallback;", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends i.e<AddressInfo> {
        public c() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(AddressInfo r2, AddressInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItem");
            Intrinsics.checkNotNullParameter(r3, "newItem");
            if (Intrinsics.areEqual(r2.getName(), r3.getName()) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(r2.getDetail(), r3.getDetail()) == false) goto L7;
            return true;
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean a(AddressInfo r3, AddressInfo r4) {
            return a2((AddressInfo) ZeusTransformUtils.preCheckCast(r3, AddressInfo.class, "com.obric.memorydata.plugin"), (AddressInfo) ZeusTransformUtils.preCheckCast(r4, AddressInfo.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public boolean b2(AddressInfo r1, AddressInfo r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.i.e
        public /* synthetic */ boolean b(AddressInfo r3, AddressInfo r4) {
            return b2((AddressInfo) ZeusTransformUtils.preCheckCast(r3, AddressInfo.class, "com.obric.memorydata.plugin"), (AddressInfo) ZeusTransformUtils.preCheckCast(r4, AddressInfo.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f10583a = new C0522b(null);
    }

    public b() {
        super((i.e) ZeusTransformUtils.preCheckCast(new c(), i.e.class, "com.obric.memorydata.plugin"));
        this.d = "";
    }

    public static final /* synthetic */ AddressInfo a(b r1, int r2) {
        return (AddressInfo) ZeusTransformUtils.preCheckCast(r1.b(r2), AddressInfo.class, "com.obric.memorydata.plugin");
    }

    private static final Unit a(b r3) {
        if (r3.d() <= 0) goto L6;
        r3.a(0, r3.d(), "payload_card_position");
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit a(b r1, AddressInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Function1<? super AddressInfo, Unit> r3 = r1.c;
        if (r3 == null) goto L6;
        r3.invoke(r2);
    L6:
        return Unit.INSTANCE;
    }

    private static final void a(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    public static /* synthetic */ Unit lambda$2bK1cks56275RbZ7RbHxfZM_7Ts(b r0, AddressInfo r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$dPxt3sn-l06goKwyqO-K9sUULf8, reason: not valid java name */
    public static /* synthetic */ void m772lambda$dPxt3snl06goKwyqOK9sUULf8(Function0 r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$ipdZ-u50TFlcjXIRdk_wy4BkNs0, reason: not valid java name */
    public static /* synthetic */ Unit m773lambda$ipdZu50TFlcjXIRdk_wy4BkNs0(b r0) {
        return a(r0);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public void a(a r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        AddressInfo r0 = b(r9);
        Intrinsics.checkNotNullExpressionValue(r0, "getItem(...)");
        r8.a((AddressInfo) ZeusTransformUtils.preCheckCast(r0, AddressInfo.class, "com.obric.memorydata.plugin"), r9, d(), this.d, new $$Lambda$b$2bK1cks56275RbZ7RbHxfZM_7Ts(this));
    }

    public void a(a r3, int r4, List<Object> r5) {
        List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if (r6.contains("payload_card_position") == false) goto L6;
        r3.a(r4, d());
        return;
    L6:
        super.a((RecyclerView.v) ZeusTransformUtils.preCheckCast(r3, RecyclerView.v.class, "com.obric.memorydata.plugin"), r4, r6);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4, List r5) {
        List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), r4, r6);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.a(r2);
        this.e = r2;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        this.d = r2;
    }

    @Override // com.obric.oui.orecyclerview.widget.q
    public void a(List<AddressInfo> r3, List<AddressInfo> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "previousList");
        Intrinsics.checkNotNullParameter(r6, "currentList");
        super.a(r5, r6);
        if (r5.size() != r6.size()) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L14;
        final Function0 r7 = new $$Lambda$b$ipdZu50TFlcjXIRdk_wy4BkNs0(this);
        RecyclerView r2 = this.e;
        if (r2 == null) goto L10;
        r2.post(new $$Lambda$b$dPxt3snl06goKwyqOK9sUULf8(r7));
        return;
    L10:
        r7.invoke();
        return;
    }

    public final void a(Function1<? super AddressInfo, Unit> r3) {
        Function1<? super AddressInfo, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.c = r4;
    }

    public a b(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ItemAddressSearchBinding r5 = ItemAddressSearchBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r3, false);
        Intrinsics.checkNotNullExpressionValue(r5, "inflate(...)");
        return new a(this, r5);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void b(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        if (this.e != r2) goto L5;
        this.e = null;
    L5:
        super.b(r2);
    }
}
