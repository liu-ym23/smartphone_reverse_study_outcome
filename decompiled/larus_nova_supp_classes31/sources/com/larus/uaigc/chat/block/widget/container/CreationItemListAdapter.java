package com.larus.uaigc.chat.block.widget.container;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.Message;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.uaigc.chat.block.widget.image.ImageItemViewHolder;
import com.larus.uaigc.chat.block.widget.video.VideoItemViewHolder;
import com.larus.uaigc.chat.markdown.image.component.k;
import com.larus.uaigc.impl.databinding.LarusItemMarkdownCreationImageScrollBinding;
import com.larus.uaigc.impl.databinding.LarusWidgetCreationBlockVideoItemBinding;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kc8.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:Bê\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012/\u0010\u000b\u001a+\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\f\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0015\u0012\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130\u0015\u0012\u001e\u0010\u0018\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019\u00122\u0010\u001d\u001a.\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001e0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0015¢\u0006\u0004\b \u0010!J\u0014\u0010)\u001a\u00020\u00132\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0%J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020,H\u0016J\u0018\u00102\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\r2\u0006\u00103\u001a\u00020\u0017H\u0002J\u0010\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0002H\u0016J\b\u00106\u001a\u00020,H\u0016J\u0018\u00107\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H\u0016J&\u00107\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001c09H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u000b\u001a+\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R<\u0010\u001d\u001a.\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001e0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R*\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0%2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006;"}, d2 = {"Lcom/larus/uaigc/chat/block/widget/container/CreationItemListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "imageEditorDepend", "Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;", "videoEditorDepend", "Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "clickListener", "Lkotlin/Function3;", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "Lcom/larus/uaigc/bean/chat/VideoPlayParams;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "longClickListenerBinder", "Lkotlin/Function2;", "onExpose", "", "messageGetter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/larus/im/bean/message/Message;", "", "commonParamGetter", "", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function2;", "value", "", "dataList", "getDataList", "()Ljava/util/List;", "refreshData", "data", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "reportItemExposure", "percentage", "onViewRecycled", "holder", "getItemCount", "onBindViewHolder", "payloads", "", "DiffCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationItemListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final CoroutineScope a;
    public final com.larus.uaigc.chat.markdown.image.component.a b;
    public final k c;
    public final q d;
    public final Function3<cz9.b, iy9.b, View, Unit> e;
    public final Function2<cz9.b, View, Unit> f;
    public final Function2<cz9.b, Float, Unit> g;
    public final Function1<Continuation<? super Message>, Object> h;
    public final Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> i;
    public List<? extends cz9.b> j;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/chat/block/widget/container/CreationItemListAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<cz9.b> a;
        public final List<cz9.b> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DiffCallback(List<? extends cz9.b> r2, List<? extends cz9.b> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItems");
            Intrinsics.checkNotNullParameter(r3, "newItems");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r2, int r3) {
            return ((cz9.b) ListProtector.get(this.a, r2)).d((cz9.b) ListProtector.get(this.b, r3));
        }

        public final boolean areItemsTheSame(int r2, int r3) {
            if (r2 == r3) goto L4;
        L6:
            return false;
        L4:
            if (((cz9.b) ListProtector.get(this.a, r2)).getViewType() != ((cz9.b) ListProtector.get(this.b, r3)).getViewType()) goto L6;
            return true;
        }

        public final Object getChangePayload(int r2, int r3) {
            return ((cz9.b) ListProtector.get(this.a, r2)).c((cz9.b) ListProtector.get(this.b, r3));
        }
    }

    public final int getItemCount() {
        return this.j.size();
    }

    public final int getItemViewType(int r2) {
        cz9.b r3 = (cz9.b) CollectionsKt.getOrNull(this.j, r2);
        if (r3 != null) goto L5;
        return 0;
    L5:
        return r3.getViewType();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewRecycled(r2);
        ExposureTrackerExtKt.c(r2.itemView);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        cz9.b r4 = (cz9.b) CollectionsKt.getOrNull(this.j, r3);
        if (r4 != null) goto L6;
        return;
    L6:
        if ((r2 instanceof cz9.g) == false) goto L8;
        cz9.g r5 = (cz9.g) r2;
    L9:
        if (r5 == null) goto L12;
        r5.p2(r4);
        return;
    L12:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        if (r12 != 2) goto L5;
        final LarusWidgetCreationBlockVideoItemBinding r1 = LarusWidgetCreationBlockVideoItemBinding.a(LayoutInflater.from(r11.getContext()), r11);
        VideoItemViewHolder r13 = new VideoItemViewHolder(r1, this.a, this.d, new a(this, r1), new b(this));
        cz9.f.a(((RecyclerView.ViewHolder) r13).itemView, r13, CreationItemListAdapter$onCreateViewHolder$3$1.INSTANCE, this, CreationItemListAdapter$onCreateViewHolder$3$2.INSTANCE);
        return r13;
    L5:
        final LarusItemMarkdownCreationImageScrollBinding r2 = LarusItemMarkdownCreationImageScrollBinding.a(LayoutInflater.from(r11.getContext()), r11);
        ImageItemViewHolder r14 = new ImageItemViewHolder(r2, this.a, this.b, this.c, this.d, this.h, this.i, new c(this, r2), new d(this));
        cz9.f.a(((RecyclerView.ViewHolder) r14).itemView, r14, CreationItemListAdapter$onCreateViewHolder$6$1.INSTANCE, this, CreationItemListAdapter$onCreateViewHolder$6$2.INSTANCE);
        return r14;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5, List<Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        Object r0 = CollectionsKt.firstOrNull(r6);
        cz9.g r2 = null;
        if ((r0 instanceof cz9.a) == false) goto L5;
        cz9.a r1 = (cz9.a) r0;
    L6:
        if (r1 != null) goto L8;
        super.onBindViewHolder(r4, r5, r6);
        return;
    L8:
        if ((r4 instanceof cz9.g) == false) goto L10;
        r2 = (cz9.g) r4;
    L10:
        if (r2 == null) goto L15;
        r2.updateSize(r1.a, r1.b);
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public CreationItemListAdapter(LifecycleCoroutineScope r2, com.larus.uaigc.chat.markdown.image.component.a r3, k r4, q r5, com.larus.uaigc.chat.block.create.horizontal.f r6, com.larus.uaigc.chat.block.create.horizontal.g r7, com.larus.uaigc.chat.block.create.horizontal.h r8, Function1 r9, Function2 r10) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r6, "clickListener");
        Intrinsics.checkNotNullParameter(r7, "longClickListenerBinder");
        Intrinsics.checkNotNullParameter(r8, "onExpose");
        Intrinsics.checkNotNullParameter(r9, "messageGetter");
        Intrinsics.checkNotNullParameter(r10, "commonParamGetter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = CollectionsKt.emptyList();
    }
}
