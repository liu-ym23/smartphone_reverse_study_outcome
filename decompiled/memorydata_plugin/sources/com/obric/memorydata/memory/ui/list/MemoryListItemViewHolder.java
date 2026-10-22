package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.memory.databinding.ItemAudioMemoryDataBinding;
import com.obric.memorydata.memory.databinding.ItemAutoMemoryProDataBinding;
import com.obric.memorydata.memory.databinding.ItemCommonMemoryCardBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryDetailFooterBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryListBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryRelationTitleBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryTimeBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryTimeLineBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryTopicBinding;
import com.obric.memorydata.memory.databinding.ItemRecommendMemoryDataBinding;
import com.obric.memorydata.memory.ui.data.MemoryItemType;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000 \u001b*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001bB\u001b\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/viewbinding/ViewBinding;", "Lcom/obric/memorydata/memory/ui/data/MemoryItemViewHolder;", "binding", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "<init>", "(Landroidx/viewbinding/ViewBinding;Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", "getSelectionManager", "()Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "updateSelection", "", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "checkboxVisible", "", "updateHighlight", "item", "currentQuery", "", "", "updateAppIcon", "updateTime", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class MemoryListItemViewHolder<T extends ViewBinding> extends com.obric.memorydata.memory.ui.data.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f11052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f11053b;
    private final SelectionStateManager t;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J8\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "create", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "type", "", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "itemRelatedPage", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;", "isTimeLineMode", "", "createCardViewHolder", "ItemRelatedPage", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;", "", "<init>", "(Ljava/lang/String;I)V", "LIST_PAGE", "DETAIL_PAGE", "SEARCH_PAGE", "CONTEXT_AWARENESS_PAGE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final enum ItemRelatedPage extends Enum<ItemRelatedPage> {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ ItemRelatedPage[] $VALUES = null;
            public static final ItemRelatedPage CONTEXT_AWARENESS_PAGE = null;
            public static final ItemRelatedPage DETAIL_PAGE = null;
            public static final ItemRelatedPage LIST_PAGE = null;
            public static final ItemRelatedPage SEARCH_PAGE = null;

            private static final /* synthetic */ ItemRelatedPage[] $values() {
                return new ItemRelatedPage[]{LIST_PAGE, DETAIL_PAGE, SEARCH_PAGE, CONTEXT_AWARENESS_PAGE};
            }

            static {
                LIST_PAGE = new ItemRelatedPage("LIST_PAGE", 0);
                DETAIL_PAGE = new ItemRelatedPage("DETAIL_PAGE", 1);
                SEARCH_PAGE = new ItemRelatedPage("SEARCH_PAGE", 2);
                CONTEXT_AWARENESS_PAGE = new ItemRelatedPage("CONTEXT_AWARENESS_PAGE", 3);
                ItemRelatedPage[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            }

            private ItemRelatedPage(String r1, int r2) {
                super(r1, r2);
            }

            public static EnumEntries<ItemRelatedPage> getEntries() {
                return $ENTRIES;
            }

            public static ItemRelatedPage valueOf(String r2) {
                return (ItemRelatedPage) ZeusTransformUtils.preCheckCast(Enum.valueOf(ItemRelatedPage.class, r2), ItemRelatedPage.class, "com.obric.memorydata.plugin");
            }

            public static ItemRelatedPage[] values() {
                return (ItemRelatedPage[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ItemRelatedPage[].class, "com.obric.memorydata.plugin");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ MemoryListItemViewHolder a(Companion r6, ViewGroup r7, int r8, SelectionStateManager r9, ItemRelatedPage r10, boolean r11, int r12, Object r13) {
            if ((r12 & 4) == 0) goto L5;
            r9 = null;
        L5:
            SelectionStateManager r3 = r9;
            if ((r12 & 8) == 0) goto L8;
            r10 = ItemRelatedPage.LIST_PAGE;
        L8:
            ItemRelatedPage r4 = r10;
            if ((r12 & 16) == 0) goto L12;
            r11 = false;
        L12:
            return r6.a(r7, r8, r3, r4, r11);
        }

        private final MemoryListItemViewHolder<?> b(ViewGroup r4, int r5, SelectionStateManager r6, ItemRelatedPage r7, boolean r8) {
            ItemMemoryListBinding r3 = ItemMemoryListBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r4, false);
            Intrinsics.checkNotNullExpressionValue(r3, "inflate(...)");
            View r9 = r3.timeLine;
            if (r8 == false) goto L5;
            r9.setVisibility(0);
        L7:
            if (r5 != MemoryItemType.TYPE_SHORT_ENTITY.ordinal()) goto L11;
            r3.cardContentVs.setLayoutResource(ZeusTransformUtils.mapRes(R.layout.item_recommend_memory_data, "layout", "item_recommend_memory_data"));
            ItemRecommendMemoryDataBinding r10 = ItemRecommendMemoryDataBinding.bind(r3.cardContentVs.inflate());
            Intrinsics.checkNotNullExpressionValue(r10, "bind(...)");
            Object r11 = new bf(r10, r3, r6, r7);
        L17:
            return (MemoryListItemViewHolder) ZeusTransformUtils.preCheckCast(r11, MemoryListItemViewHolder.class, "com.obric.memorydata.plugin");
        L11:
            if (r5 != MemoryItemType.TYPE_AUDIO_ENTITY.ordinal()) goto L14;
            r3.cardContentVs.setLayoutResource(ZeusTransformUtils.mapRes(R.layout.item_audio_memory_data, "layout", "item_audio_memory_data"));
            ItemAudioMemoryDataBinding r12 = ItemAudioMemoryDataBinding.bind(r3.cardContentVs.inflate());
            Intrinsics.checkNotNullExpressionValue(r12, "bind(...)");
            r11 = new c(r12, r3, r6, r7);
            goto L17
        L14:
            if (r5 != MemoryItemType.TYPE_AUTO_MEMORY_PRO.ordinal()) goto L16;
            r3.cardContentVs.setLayoutResource(ZeusTransformUtils.mapRes(R.layout.item_auto_memory_pro_data, "layout", "item_auto_memory_pro_data"));
            ItemAutoMemoryProDataBinding r13 = ItemAutoMemoryProDataBinding.bind(r3.cardContentVs.inflate());
            Intrinsics.checkNotNullExpressionValue(r13, "bind(...)");
            r11 = new d(r13, r3, r6, r7);
            goto L17
        L16:
            r3.cardContentVs.setLayoutResource(ZeusTransformUtils.mapRes(R.layout.item_common_memory_card, "layout", "item_common_memory_card"));
            ItemCommonMemoryCardBinding r14 = ItemCommonMemoryCardBinding.bind(r3.cardContentVs.inflate());
            Intrinsics.checkNotNullExpressionValue(r14, "bind(...)");
            r11 = new q(r14, r3, r6, r7);
            goto L17
        L5:
            r9.setVisibility(8);
            goto L7
        }

        public final MemoryListItemViewHolder<?> a(ViewGroup r5, int r6, SelectionStateManager r7, ItemRelatedPage r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r5, "parent");
            Intrinsics.checkNotNullParameter(r8, "itemRelatedPage");
            if (r6 != MemoryItemType.TYPE_TIME.ordinal()) goto L8;
            if (r9 == false) goto L6;
            ItemMemoryTimeLineBinding r10 = ItemMemoryTimeLineBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r5, false);
            Intrinsics.checkNotNullExpressionValue(r10, "inflate(...)");
            Object r4 = new aj(r10, r7);
        L19:
            return (MemoryListItemViewHolder) ZeusTransformUtils.preCheckCast(r4, MemoryListItemViewHolder.class, "com.obric.memorydata.plugin");
        L6:
            ItemMemoryTimeBinding r11 = ItemMemoryTimeBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r5, false);
            Intrinsics.checkNotNullExpressionValue(r11, "inflate(...)");
            r4 = new ak(r11, r7);
            goto L19
        L8:
            if (r6 != MemoryItemType.TYPE_RELATION_TITLE.ordinal()) goto L12;
            ItemMemoryRelationTitleBinding r12 = ItemMemoryRelationTitleBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r5, false);
            Intrinsics.checkNotNullExpressionValue(r12, "inflate(...)");
            r4 = new ad(r12, null, 2, null);
            goto L19
        L12:
            if (r6 != MemoryItemType.TYPE_EPISODIC_TOPIC.ordinal()) goto L15;
            ItemMemoryTopicBinding r13 = ItemMemoryTopicBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r5, false);
            Intrinsics.checkNotNullExpressionValue(r13, "inflate(...)");
            r4 = new s(r13, r7);
            goto L19
        L15:
            if (r6 != MemoryItemType.TYPE_MEMORY_FOOTER.ordinal()) goto L18;
            ItemMemoryDetailFooterBinding r14 = ItemMemoryDetailFooterBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r5, false);
            Intrinsics.checkNotNullExpressionValue(r14, "inflate(...)");
            r4 = new t(r14);
            goto L19
        L18:
            return b(r5, r6, r7, r8, r9);
        }
    }

    static {
        f11052a = new Companion(null);
    }

    public MemoryListItemViewHolder(T r3, SelectionStateManager r4) {
        T r5 = (T) ZeusTransformUtils.wrapperContextForParams(r3, ViewBinding.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "binding");
        View r0 = r5.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        super(r0);
        this.f11053b = r5;
        this.t = r4;
    }

    public /* synthetic */ MemoryListItemViewHolder(ViewBinding r2, SelectionStateManager r3, int r4, DefaultConstructorMarker r5) {
        ViewBinding r6 = (ViewBinding) ZeusTransformUtils.wrapperContextForParams(r2, ViewBinding.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        this(r6, r3);
    }

    public static /* synthetic */ void a(MemoryListItemViewHolder r0, com.obric.memorydata.memory.ui.data.a r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L14;
        if ((r3 & 2) == 0) goto L11;
        SelectionStateManager r5 = r0.t;
        if (r5 == null) goto L10;
        kotlinx.coroutines.flow.ar<Boolean> r6 = r5.b();
        if (r6 == null) goto L10;
        r2 = ((Boolean) ZeusTransformUtils.preCheckCast(r6.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L10:
        r2 = false;
    L11:
        r0.a(r1, r2);
        return;
    L14:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSelection");
    }

    public void a(com.obric.memorydata.memory.ui.data.a r1, List<String> r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "currentQuery");
    }

    public void a(com.obric.memorydata.memory.ui.data.a r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "memoryItem");
    }

    public void c(com.obric.memorydata.memory.ui.data.a r1) {
    }

    public void d(com.obric.memorydata.memory.ui.data.a r1) {
        Intrinsics.checkNotNullParameter(r1, "item");
    }

    public final T h() {
        return this.f11053b;
    }

    public final SelectionStateManager i() {
        return this.t;
    }
}
