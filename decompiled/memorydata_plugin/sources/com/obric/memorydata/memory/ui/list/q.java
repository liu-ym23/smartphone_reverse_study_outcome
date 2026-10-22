package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAddressMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoRelationshipMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.memorydata.memory.databinding.ItemCommonMemoryCardBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryListBinding;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0018\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryCardViewHolder;", "Lcom/obric/memorydata/memory/ui/list/MemoryListCommonViewHolder;", "stubBinding", "Lcom/obric/memorydata/memory/databinding/ItemCommonMemoryCardBinding;", "binding", "Lcom/obric/memorydata/memory/databinding/ItemMemoryListBinding;", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "itemRelatedPage", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemCommonMemoryCardBinding;Lcom/obric/memorydata/memory/databinding/ItemMemoryListBinding;Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;)V", "updateAppIcon", "", "item", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "hasBind", "", "processMarkdownContent", "", Params.CONTENT, "bind", "memoryItem", "updateTime", "updateHighlight", "currentQuery", "", "currentMemoryContent", "setSourceViewVisible", "isVisible", "CardContent", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ItemCommonMemoryCardBinding f11326b;
    private boolean t;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryCardViewHolder$CardContent;", "", "title", "", Params.CONTENT, "icon", "", EventBody.KEY_CATEGORY, "titleMaxLines", "forceShowSource", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZ)V", "getTitle", "()Ljava/lang/String;", "getContent", "getIcon", "()I", "getCategory", "getTitleMaxLines", "getForceShowSource", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11328b;
        private final int c;
        private final String d;
        private final int e;
        private final boolean f;

        public a(String r2, String r3, int r4, String r5, int r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "title");
            Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r5, EventBody.KEY_CATEGORY);
            this.f11327a = r2;
            this.f11328b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public /* synthetic */ a(String r8, String r9, int r10, String r11, int r12, boolean r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 16) == 0) goto L5;
            r12 = 1;
        L5:
            int r5 = r12;
            if ((r14 & 32) == 0) goto L8;
            r13 = false;
        L8:
            this(r8, r9, r10, r11, r5, r13);
        }

        public final String a() {
            return this.f11327a;
        }

        public final String b() {
            return this.f11328b;
        }

        public final int c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11327a, r6.f11327a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11328b, r6.f11328b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final boolean f() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((this.f11327a.hashCode() * 31) + this.f11328b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e)) * 31) + Boolean.hashCode(this.f);
        }

        public String toString() {
            return "CardContent(title=" + this.f11327a + ", content=" + this.f11328b + ", icon=" + this.c + ", category=" + this.d + ", titleMaxLines=" + this.e + ", forceShowSource=" + this.f + ')';
        }
    }

    public q(ItemCommonMemoryCardBinding r2, ItemMemoryListBinding r3, SelectionStateManager r4, MemoryListItemViewHolder.Companion.ItemRelatedPage r5) {
        Intrinsics.checkNotNullParameter(r2, "stubBinding");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r5, "itemRelatedPage");
        super(r3, r4, r5);
        this.f11326b = r2;
    }

    private final String a(String r7) {
        return StringsKt.replace$default(r7, "*", "", false, 4, null);
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryListItemViewHolder
    public void a(com.obric.memorydata.memory.ui.data.a r13, List<String> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "currentQuery");
        if (r13 != null) goto L5;
    L14:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryListItemViewHolder", "item == null || item !is MemoryItem.ListEntity", null, 4, null);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L14;
        TextView r2 = this.f11326b.tvTitle;
        Intrinsics.checkNotNull(r2);
        int r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6"));
        com.obric.memorydata.utils.aq.a(r2, r2.getText().toString(), r15, r5, null, com.obric.memorydata.utils.al.f13166a.b(), 8, null);
        TextView r3 = this.f11326b.tvSubtitle;
        TextView r16 = this.f11326b.tvSubtitle;
        Intrinsics.checkNotNullExpressionValue(r16, "tvSubtitle");
        if (((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L10;
        boolean r17 = true;
    L11:
        if (r17 == false) goto L16;
        Intrinsics.checkNotNull(r3);
        int r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6"));
        com.obric.memorydata.utils.aq.a(r3, r3.getText().toString(), r15, r6, null, com.obric.memorydata.utils.al.f13166a.b(), 8, null);
        return;
    L16:
        return;
    L10:
        r17 = false;
        goto L11
    }

    @Override // com.obric.memorydata.memory.ui.list.v, com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r25) {
        Intrinsics.checkNotNullParameter(r25, "memoryItem");
        super.b(r25);
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "bind memoryItem: " + r25 + ", hasBind: " + this.t);
        Integer r3 = null;
        if (ZeusTransformUtils.instanceOf(r25, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.h r2 = (com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r25, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin");
    L6:
        if (r2 == null) goto L140;
        MemoryEntity r4 = r2.b();
        if (r4 == null) goto L141;
        r4.getSourceQuery();
        boolean r7 = true;
        if (ZeusTransformUtils.instanceOf(r4, OrderFlightMemoryEntity.class) == false) goto L13;
        a r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), com.obric.memorydata.memory.ui.e.f10891a.b((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r4, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_order_flight, "drawable", "ic_memory_list_order_flight"), "机票", 0, false, 48, null);
    L105:
        ItemCommonMemoryCardBinding r9 = this.f11326b;
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "title: " + r6.a() + ", content: " + r6.b());
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "packageName: $" + r4.getSourcePackageName() + ", sourceAppName: " + r4.getSourceAppName() + ", category: " + r6.d());
        if (r6.f() == false) goto L108;
        r9.ivIcon.setImageResource(r6.c());
        r9.tvCategory.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6.d(), CharSequence.class, "com.obric.memorydata.plugin"));
    L123:
        TextView r5 = r9.tvTitle;
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        r5.setMaxLines(r6.e());
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6.b(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L126;
        r9.tvSubtitle.setVisibility(8);
    L127:
        TextView r8 = r9.memoryTime;
        com.obric.memorydata.memory.utils.f r10 = com.obric.memorydata.memory.utils.f.f11537a;
        long r11 = ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r25, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getLastModifiedTime();
        if (d() != MemoryListItemViewHolder.Companion.ItemRelatedPage.SEARCH_PAGE) goto L130;
    L133:
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(r10.a(r11, r7), CharSequence.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.memory.ui.data.a r12 = a();
        if (r12 == null) goto L137;
        List<String> r13 = r12.a();
        if (r13 == null) goto L137;
    L138:
        a(r25, r13);
        return;
    L137:
        r13 = CollectionsKt.emptyList();
        goto L138
    L130:
        if (d() == MemoryListItemViewHolder.Companion.ItemRelatedPage.DETAIL_PAGE) goto L133;
        r7 = false;
        goto L133
    L126:
        r9.tvSubtitle.setVisibility(0);
        r9.tvSubtitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        goto L127
    L108:
        af r14 = ae.f11174a.a(r4.getProductType(), MemorySourceIconScene.LIST);
        com.obric.memorydata.utils.icon.b r15 = com.obric.memorydata.utils.icon.b.f13229a;
        Context r16 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r16, "getContext(...)");
        ImageView r17 = r9.ivIcon;
        Intrinsics.checkNotNullExpressionValue(r17, "ivIcon");
        String r18 = r4.getSourcePackageName();
        int r19 = r6.c();
        if (r14 == null) goto L111;
        String r110 = r14.b();
    L112:
        if (r14 == null) goto L114;
        r3 = Integer.valueOf(r14.a());
    L114:
        Integer r111 = r3;
        if (r14 == null) goto L117;
        boolean r20 = r14.c();
    L118:
        com.obric.memorydata.utils.icon.b.a(r15, r16, r17, r18, null, r19, null, null, r110, r111, r20, 104, null);
        TextView r21 = r9.tvCategory;
        if (MemorySourceFilter.Companion.c(r4.getProductType()) != 0) goto L121;
        String r22 = com.obric.memorydata.utils.c.f13193a.a(r4.getSourcePackageName(), r4.getSourceAppName());
    L122:
        r21.setText((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin"));
        goto L123
    L121:
        r22 = MemorySourceFilter.Companion.a(r4.getProductType(), r4.getSourceAppName());
        goto L122
    L117:
        r20 = true;
        goto L118
    L111:
        r110 = null;
        goto L112
    L13:
        if (ZeusTransformUtils.instanceOf(r4, OrderTrainMemoryEntity.class) == false) goto L16;
        r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), com.obric.memorydata.memory.ui.e.f10891a.b((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r4, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_order_train, "drawable", "ic_memory_list_order_train"), "车票", 0, false, 48, null);
        goto L105
    L16:
        if (ZeusTransformUtils.instanceOf(r4, OrderHotelMemoryEntity.class) == false) goto L19;
        r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), com.obric.memorydata.memory.ui.e.f10891a.b((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r4, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_order_hotel, "drawable", "ic_memory_list_order_hotel"), "酒店", 0, false, 48, null);
        goto L105
    L19:
        if (ZeusTransformUtils.instanceOf(r4, OrderMovieTicketMemoryEntity.class) == false) goto L22;
        r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), com.obric.memorydata.memory.ui.e.f10891a.b((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r4, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_order_movie_ticket, "drawable", "ic_memory_list_order_movie_ticket"), "电影", 0, false, 48, null);
        goto L105
    L22:
        if (ZeusTransformUtils.instanceOf(r4, OrderTicketMemoryEntity.class) == false) goto L25;
        r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), com.obric.memorydata.memory.ui.e.f10891a.b((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r4, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_order_ticket, "drawable", "ic_memory_list_order_ticket"), "票务", 0, false, 48, null);
        goto L105
    L25:
        if (ZeusTransformUtils.instanceOf(r4, OrderCommonMemoryEntity.class) == false) goto L28;
        r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), com.obric.memorydata.memory.ui.e.a(com.obric.memorydata.memory.ui.e.f10891a, (OrderCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r4, OrderCommonMemoryEntity.class, "com.obric.memorydata.plugin"), false, 2, null), ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_order_common, "drawable", "ic_memory_list_order_common"), "订单", 0, false, 48, null);
        goto L105
    L28:
        if (ZeusTransformUtils.instanceOf(r4, CollectContentMemoryEntity.class) == false) goto L34;
        String r112 = com.obric.memorydata.memory.ui.f.f10920a.a(r4);
        String r113 = ((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r4, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getSummary();
        int r114 = com.obric.memorydata.utils.icon.b.f13229a.a();
        String r23 = ((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r4, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getAppName();
        if (r23 != null) goto L32;
        r23 = "收藏内容";
    L32:
        r6 = new a(r112, r113, r114, r23, 0, false, 48, null);
        goto L105
    L34:
        if (ZeusTransformUtils.instanceOf(r4, CollectStoreMemoryEntity.class) == false) goto L43;
        String r115 = com.obric.memorydata.memory.ui.f.f10920a.a(r4);
        String r24 = ((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r4, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getAddress();
        if (r24 != null) goto L38;
        r24 = com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_card_store_default, TypedValues.Custom.S_STRING, "memory_card_store_default"));
    L38:
        String r116 = r24;
        int r117 = com.obric.memorydata.utils.icon.b.f13229a.a();
        String r26 = ((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r4, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getAppName();
        if (r26 != null) goto L41;
        r26 = "收藏店铺";
    L41:
        r6 = new a(r115, r116, r117, r26, 0, false, 48, null);
        goto L105
    L43:
        if (ZeusTransformUtils.instanceOf(r4, EventScheduleMemoryEntity.class) == false) goto L46;
        r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), com.obric.memorydata.memory.ui.e.f10891a.b((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r4, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_event_schedule, "drawable", "ic_memory_list_event_schedule"), "日程", 0, false, 48, null);
        goto L105
    L46:
        if (ZeusTransformUtils.instanceOf(r4, EventTodoMemoryEntity.class) == false) goto L48;
        r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), com.obric.memorydata.memory.ui.e.a(com.obric.memorydata.memory.ui.e.f10891a, (EventTodoMemoryEntity) ZeusTransformUtils.preCheckCast(r4, EventTodoMemoryEntity.class, "com.obric.memorydata.plugin"), false, 2, null), ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_event_todo, "drawable", "ic_memory_list_event_todo"), "待办", 0, false, 48, null);
        goto L105
    L48:
        String r118 = "ic_memory_list_info_documents";
        if (ZeusTransformUtils.instanceOf(r4, InfoDocumentsMemoryEntity.class) == false) goto L52;
        r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), "", ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_info_documents, "drawable", "ic_memory_list_info_documents"), InfoCommonMemoryEntity.InfoKeyType.IDENTIFICATION, 3, true);
        goto L105
    L52:
        if (ZeusTransformUtils.instanceOf(r4, InfoAddressMemoryEntity.class) == false) goto L55;
        r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), "", ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_info_address, "drawable", "ic_memory_list_info_address"), "常用地址", 3, true);
        goto L105
    L55:
        if (ZeusTransformUtils.instanceOf(r4, InfoAnniversaryMemoryEntity.class) == false) goto L58;
        r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), "", ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_info_anniversary, "drawable", "ic_memory_list_info_anniversary"), InfoCommonMemoryEntity.InfoKeyType.ANNIVERSARY, 3, true);
        goto L105
    L58:
        if (ZeusTransformUtils.instanceOf(r4, InfoRelationshipMemoryEntity.class) == false) goto L61;
        r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), "", ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_info_relationship, "drawable", "ic_memory_list_info_relationship"), InfoCommonMemoryEntity.InfoKeyType.RELATIONSHIP, 3, true);
        goto L105
    L61:
        if (ZeusTransformUtils.instanceOf(r4, InfoCommonMemoryEntity.class) == false) goto L102;
        String r119 = com.obric.memorydata.memory.ui.f.f10920a.a(r4);
        String r27 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r4, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoKey();
        if (Intrinsics.areEqual(r27, InfoCommonMemoryEntity.InfoKeyType.ADDRESS) == false) goto L67;
        int r28 = ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_info_address, "drawable", "ic_memory_list_info_address");
    L65:
        int r120 = r28;
        String r29 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r4, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoKey();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L98;
        r29 = null;
    L98:
        if (r29 != null) goto L100;
        r29 = IRecommendSettings.ProfileTag.OTHER;
    L100:
        r6 = new a(r119, "", r120, r29, 3, true);
        goto L105
    L67:
        if (Intrinsics.areEqual(r27, InfoCommonMemoryEntity.InfoKeyType.ANNIVERSARY) == false) goto L70;
        r28 = ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_info_anniversary, "drawable", "ic_memory_list_info_anniversary");
        goto L65
    L70:
        if (Intrinsics.areEqual(r27, InfoCommonMemoryEntity.InfoKeyType.RELATIONSHIP) == false) goto L73;
    L71:
        r28 = ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_info_relationship, "drawable", "ic_memory_list_info_relationship");
        goto L65
    L73:
        if (Intrinsics.areEqual(r27, InfoCommonMemoryEntity.InfoKeyType.IDENTIFICATION) == false) goto L77;
        int r30 = R.drawable.ic_memory_list_info_documents;
    L75:
        r28 = ZeusTransformUtils.mapRes(r30, "drawable", r118);
        goto L65
    L77:
        if (Intrinsics.areEqual(r27, PersonalTag.f11118a.b()) == true) goto L71;
        if (Intrinsics.areEqual(r27, PersonalTag.f11118a.c()) == true) goto L71;
        if (Intrinsics.areEqual(r27, PersonalTag.f11118a.e()) == false) goto L84;
    L93:
        r30 = R.drawable.ic_memory_list_info_hobby;
        r118 = "ic_memory_list_info_hobby";
        goto L75
    L84:
        if (Intrinsics.areEqual(r27, PersonalTag.f11118a.f()) == true) goto L93;
        if (Intrinsics.areEqual(r27, PersonalTag.f11118a.d()) == false) goto L90;
        r30 = R.drawable.ic_memory_list_info_habit;
        r118 = "ic_memory_list_info_habit";
        goto L75
    L90:
        if (Intrinsics.areEqual(r27, PersonalTag.f11118a.g()) == false) goto L92;
        r30 = R.drawable.ic_memory_list_info_goal;
        r118 = "ic_memory_list_info_goal";
        goto L75
    L92:
        r30 = R.drawable.ic_memory_list_info_common;
        r118 = "ic_memory_list_info_common";
        goto L75
    L102:
        if (ZeusTransformUtils.instanceOf(r4, CommonTextMemoryEntity.class) == false) goto L104;
        r6 = new a(com.obric.memorydata.memory.ui.f.f10920a.a(r4), a(((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r4, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getSummary()), com.obric.memorydata.utils.icon.b.f13229a.a(), com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_card_common_text_title, TypedValues.Custom.S_STRING, "memory_card_common_text_title")), 0, false, 48, null);
        goto L105
    L104:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryListItemViewHolder", "memoryEntity is not of any MemoryEntity! ", null, 4, null);
        r6 = new a("", "", com.obric.memorydata.utils.icon.b.f13229a.a(), "", 0, false, 48, null);
        goto L105
    L141:
        return;
    L140:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.memorydata.memory.ui.list.v
    public String c() {
        return this.f11326b.tvTitle.getText().toString();
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryListItemViewHolder
    public void c(com.obric.memorydata.memory.ui.data.a r19) {
        Integer r4 = null;
        if (ZeusTransformUtils.instanceOf(r19, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.h r1 = (com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r19, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L23;
        af r2 = ae.f11174a.a(r1.b().getProductType(), MemorySourceIconScene.LIST);
        com.obric.memorydata.utils.icon.b r5 = com.obric.memorydata.utils.icon.b.f13229a;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "getContext(...)");
        ImageView r7 = this.f11326b.ivIcon;
        Intrinsics.checkNotNullExpressionValue(r7, "ivIcon");
        String r8 = r1.b().getSourcePackageName();
        if (com.obric.memorydata.utils.at.a(r1.b().getSourcePackageName()) == false) goto L10;
        Drawable r9 = this.f11326b.ivIcon.getDrawable();
    L12:
        if (r2 == null) goto L14;
        String r13 = r2.b();
    L15:
        if (r2 == null) goto L17;
        r4 = Integer.valueOf(r2.a());
    L17:
        Integer r14 = r4;
        if (r2 == null) goto L20;
        boolean r0 = r2.c();
    L21:
        com.obric.memorydata.utils.icon.b.a(r5, r6, r7, r8, r9, 0, null, null, r13, r14, r0, 112, null);
        return;
    L20:
        r0 = true;
        goto L21
    L14:
        r13 = null;
        goto L15
    L10:
        r9 = null;
        goto L12
    L23:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.memorydata.memory.ui.list.MemoryListItemViewHolder
    public void d(com.obric.memorydata.memory.ui.data.a r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        ItemCommonMemoryCardBinding r0 = this.f11326b;
        if (ZeusTransformUtils.instanceOf(r7, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.h r8 = (com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin");
    L6:
        if (r8 == null) goto L18;
        MemoryEntity r9 = r8.b();
        if (r9 == null) goto L19;
        TextView r1 = r0.memoryTime;
        com.obric.memorydata.memory.utils.f r2 = com.obric.memorydata.memory.utils.f.f11537a;
        long r3 = r9.getLastModifiedTime();
        if (d() != MemoryListItemViewHolder.Companion.ItemRelatedPage.SEARCH_PAGE) goto L12;
    L15:
        boolean r6 = true;
    L16:
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2.a(r3, r6), CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        if (d() == MemoryListItemViewHolder.Companion.ItemRelatedPage.DETAIL_PAGE) goto L15;
        r6 = false;
        goto L16
    L19:
        return;
    L18:
        return;
    L5:
        r8 = null;
        goto L6
    }
}
