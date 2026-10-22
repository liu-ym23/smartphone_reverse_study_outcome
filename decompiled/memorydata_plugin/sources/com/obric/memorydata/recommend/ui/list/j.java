package com.obric.memorydata.recommend.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ItemRecommendMemoryCardBinding;
import com.obric.memorydata.recommend.databinding.ItemRecommendMemoryDataBinding;
import com.obric.memorydata.recommend.databinding.ItemRecommendMemoryTimeBinding;
import com.obric.memorydata.recommend.databinding.ItemRecommendPortraitDataBinding;
import com.obric.memorydata.recommend.databinding.ItemRecommendTodoDataBinding;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u000e*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u000eB\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/RecommendMemoryItemViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/viewbinding/ViewBinding;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "binding", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", "bind", "", "memoryItem", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class j<T extends ViewBinding> extends RecyclerView.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12710a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f12711b;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/RecommendMemoryItemViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "create", "Lcom/obric/memorydata/recommend/ui/list/RecommendMemoryItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "type", "", "createCardViewHolder", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final j<?> b(ViewGroup r5, int r6) {
            ItemRecommendMemoryCardBinding r4 = ItemRecommendMemoryCardBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r5, false);
            Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
            if (r6 != MemoryListItemType.TYPE_DATA.ordinal()) goto L7;
            r4.cardContentVs.setLayoutResource(ZeusTransformUtils.mapRes(R.layout.item_recommend_memory_data, "layout", "item_recommend_memory_data"));
            ItemRecommendMemoryDataBinding r7 = ItemRecommendMemoryDataBinding.bind(r4.cardContentVs.inflate());
            Intrinsics.checkNotNullExpressionValue(r7, "bind(...)");
            Object r8 = new e(r7, r4);
        L12:
            return (j) ZeusTransformUtils.preCheckCast(r8, j.class, "com.obric.memorydata.plugin");
        L7:
            if (r6 != MemoryListItemType.TYPE_PORTRAIT.ordinal()) goto L10;
            r4.cardContentVs.setLayoutResource(ZeusTransformUtils.mapRes(R.layout.item_recommend_portrait_data, "layout", "item_recommend_portrait_data"));
            ItemRecommendPortraitDataBinding r9 = ItemRecommendPortraitDataBinding.bind(r4.cardContentVs.inflate());
            Intrinsics.checkNotNullExpressionValue(r9, "bind(...)");
            r8 = new i(r9, r4);
            goto L12
        L10:
            if (r6 != MemoryListItemType.TYPE_TODO.ordinal()) goto L14;
            r4.cardContentVs.setLayoutResource(ZeusTransformUtils.mapRes(R.layout.item_recommend_todo_data, "layout", "item_recommend_todo_data"));
            ItemRecommendTodoDataBinding r10 = ItemRecommendTodoDataBinding.bind(r4.cardContentVs.inflate());
            Intrinsics.checkNotNullExpressionValue(r10, "bind(...)");
            r8 = new l(r10, r4);
            goto L12
        L14:
            throw new IllegalArgumentException("Unknown view type: " + r6);
        }

        public final j<?> a(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            if (r4 != MemoryListItemType.TYPE_TIME.ordinal()) goto L6;
            ItemRecommendMemoryTimeBinding r5 = ItemRecommendMemoryTimeBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r3, false);
            Intrinsics.checkNotNullExpressionValue(r5, "inflate(...)");
            return (j) ZeusTransformUtils.preCheckCast(new h(r5), j.class, "com.obric.memorydata.plugin");
        L6:
            return b(r3, r4);
        }
    }

    static {
        f12710a = new a(null);
    }

    public j(T r3) {
        T r4 = (T) ZeusTransformUtils.wrapperContextForParams(r3, ViewBinding.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "binding");
        super(r4.getRoot());
        this.f12711b = r4;
    }

    public final T a() {
        return this.f12711b;
    }

    public abstract void a(f r1);
}
