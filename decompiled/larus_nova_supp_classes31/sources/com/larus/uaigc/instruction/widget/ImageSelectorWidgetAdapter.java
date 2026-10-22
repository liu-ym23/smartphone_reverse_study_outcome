package com.larus.uaigc.instruction.widget;

import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.uaigc.impl.databinding.LarusUaigcItemActionbarImageSelectorHolderBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vz9.d;
import vz9.e;
import vz9.f;
import vz9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004()*+B,\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001b\b\u0002\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0018\u001a\u00020\b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0013J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\u0018\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J&\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "callback", "Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;", "headerViewDsl", "Lkotlin/Function1;", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter$HeaderComponentBuilder;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;Lkotlin/jvm/functions/Function1;)V", "headerComponentBuilder", "headerComponent", "Lcom/larus/uaigc/instruction/widget/HeaderComponent;", "dataList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "offset", "", "getItemCount", "currentList", "getCurrentList", "()Ljava/util/List;", "submitList", "data", "getItem", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "getItemViewType", "Companion", "HeaderComponentBuilder", "DiffCallback", "ChangePayload", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageSelectorWidgetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final /* synthetic */ int e = 0;
    public final d a;
    public final com.larus.uaigc.instruction.widget.a b;
    public List<w> c;
    public final int d;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "newItems", "<init>", "(Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter;Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class DiffCallback extends DiffUtil.Callback {
        public final List<w> a;
        public final List<w> b;
        public final /* synthetic */ ImageSelectorWidgetAdapter c;

        public final int getNewListSize() {
            return this.b.size() + this.c.d;
        }

        public final int getOldListSize() {
            return this.a.size() + this.c.d;
        }

        public final boolean areContentsTheSame(int r6, int r7) {
            int r0 = this.c.d;
            boolean r1 = true;
            if (r6 < r0) goto L25;
            if (r7 < r0) goto L25;
            int r3 = ImageSelectorWidgetAdapter.e;
            w r8 = (w) ListProtector.get(this.a, r6 - r0);
            w r9 = (w) ListProtector.get(this.b, r7 - this.c.d);
            if (Intrinsics.areEqual(r8.b, r9.b) == true) goto L9;
        L22:
            r1 = false;
        L23:
            FLogger.a.i("ImageSelectorWidgetAdapter", "result is " + r1 + " , oldItem is " + r8.b + " newItem is " + r9.b);
            return r1;
        L9:
            if (Intrinsics.areEqual(r8.d, r9.d) == false) goto L22;
            g1 r2 = r8.f;
            String r4 = null;
            if (r2 == null) goto L13;
            String r5 = r2.b;
        L14:
            g1 r10 = r9.f;
            if (r10 == null) goto L18;
            r4 = r10.b;
        L18:
            if (Intrinsics.areEqual(r5, r4) == false) goto L22;
            if (Intrinsics.areEqual(r8.s, r9.s) == false) goto L22;
        L13:
            r5 = null;
        L25:
            if (r6 == r7) goto L29;
            return false;
        L29:
            return true;
        }

        public final boolean areItemsTheSame(int r3, int r4) {
            int r0 = this.c.d;
            if (r3 >= r0) goto L8;
            if (r4 >= r0) goto L8;
            if (r3 != r4) goto L13;
            return true;
        L13:
            return false;
        L8:
            if (r3 < r0) goto L12;
            if (r4 < r0) goto L12;
            int r1 = ImageSelectorWidgetAdapter.e;
            w r5 = (w) ListProtector.get(this.a, r3 - r0);
            w r6 = (w) ListProtector.get(this.b, r4 - this.c.d);
            return Intrinsics.areEqual(r5.a, r6.a);
        L12:
            return false;
        }

        public final Object getChangePayload(int r4, int r5) {
            int r0 = this.c.d;
            if (r4 < r0) goto L24;
            if (r5 < r0) goto L29;
            int r2 = ImageSelectorWidgetAdapter.e;
            w r6 = (w) ListProtector.get(this.a, r4 - r0);
            w r7 = (w) ListProtector.get(this.b, r5 - this.c.d);
            if (Intrinsics.areEqual(r6.b, r7.b) == true) goto L9;
            return null;
        L9:
            if (Intrinsics.areEqual(r6.d, r7.d) == false) goto L26;
            g1 r1 = r6.f;
            if (r1 == null) goto L13;
            String r3 = r1.b;
        L14:
            g1 r8 = r7.f;
            if (r8 == null) goto L17;
            String r9 = r8.b;
        L19:
            if (Intrinsics.areEqual(r3, r9) == true) goto L21;
            return null;
        L21:
            if (Intrinsics.areEqual(r6.s, r7.s) == false) goto L23;
            return null;
        L23:
            return new e(r7.s);
        L17:
            r9 = null;
            goto L19
        L13:
            r3 = null;
            goto L14
        L26:
            return null;
        L29:
            return null;
        L24:
            return null;
        }

        public DiffCallback(ImageSelectorWidgetAdapter r2, List<w> r3, List<w> r4) {
            Intrinsics.checkNotNullParameter(r3, "oldItems");
            Intrinsics.checkNotNullParameter(r4, "newItems");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public static final class a {
    }

    public static final class b {
        public Function1<? super ViewGroup, ? extends View> a;
        public Function1<? super HeaderViewHolder, Unit> b;

        public b() {
            this.a = new f();
            this.b = new g();
        }
    }

    static {
    }

    public final int getItemCount() {
        return this.c.size() + this.d;
    }

    public final int getItemViewType(int r2) {
        if (r2 >= this.d) goto L5;
        return 1;
    L5:
        return 0;
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewAttachedToWindow(r2);
        if ((r2 instanceof ImageSelectorHolder) == false) goto L5;
        ImageSelectorHolder r3 = (ImageSelectorHolder) r2;
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.c == false) goto L11;
        return;
    L11:
        if (r3.U3() == true) goto L13;
        return;
    L13:
        if (r3.c == true) goto L23;
        Animatable r4 = r3.g;
        if (r4 == null) goto L21;
        r4.start();
        return;
    L21:
        return;
    L23:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewDetachedFromWindow(r2);
        if ((r2 instanceof ImageSelectorHolder) == false) goto L5;
        ImageSelectorHolder r3 = (ImageSelectorHolder) r2;
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.c == true) goto L13;
        r3.V3();
        return;
    L13:
        return;
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List, java.util.List<com.larus.bmhome.actionbar.model.w>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList] */
    public final void submitList(List<w> r11) {
        if (r11 == null) goto L7;
        List<w> r12 = r11;
        ?? r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r13 = r12.iterator();
    L5:
        if (r13.hasNext() == false) goto L8;
        r0.add(w.a((w) r13.next(), null, null, null, null, null, null, 8388607));
    L8:
        DiffUtil.DiffResult r14 = DiffUtil.calculateDiff(new DiffCallback(this, this.c, r0), false);
        this.c = r0;
        r14.dispatchUpdatesTo(this);
        return;
    L7:
        r0 = CollectionsKt.emptyList();
        goto L8
    }

    public ImageSelectorWidgetAdapter(d r2, Function1<? super b, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
        b r4 = new b();
        this.c = CollectionsKt.emptyList();
        if (r3 == null) goto L6;
        r3.invoke(r4);
        this.b = new com.larus.uaigc.instruction.widget.a(r4);
    L6:
        if (this.b == null) goto L8;
        int r5 = 1;
    L9:
        this.d = r5;
        return;
    L8:
        r5 = 0;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof HeaderViewHolder) == false) goto L8;
        com.larus.uaigc.instruction.widget.a r5 = this.b;
        if (r5 == null) goto L11;
        HeaderViewHolder r6 = (HeaderViewHolder) r3;
        Intrinsics.checkNotNullParameter(r6, "holder");
        r5.a.b.invoke(r6);
        return;
    L11:
        return;
    L8:
        if ((r3 instanceof ImageSelectorHolder) == false) goto L13;
        ((ImageSelectorHolder) r3).T3((w) ListProtector.get(this.c, r4 - this.d));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 1) goto L11;
        com.larus.uaigc.instruction.widget.a r1 = this.b;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r0 = (View) r1.a.a.invoke(r3);
        if (r0 == null) goto L8;
    L12:
        return new HeaderViewHolder(r0);
    L8:
        r0 = new View(r3.getContext());
        goto L12
    L11:
        return new ImageSelectorHolder(LarusUaigcItemActionbarImageSelectorHolderBinding.a(LayoutInflater.from(r3.getContext()), r3).a, this.a, false);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        Object r5 = CollectionsKt.firstOrNull(r4);
        if ((r5 instanceof e) == false) goto L5;
        e r6 = (e) r5;
    L7:
        if ((r2 instanceof ImageSelectorHolder) == false) goto L21;
        if (r6 == null) goto L21;
        ImageSelectorHolder r7 = (ImageSelectorHolder) r2;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r6, "payload");
        Integer r8 = r6.a;
        if (r8 != null) goto L13;
    L15:
        if (r8 != null) goto L18;
        return;
    L18:
        if (r8.intValue() != 1) goto L24;
        e1.x(r7.f);
        return;
    L24:
        return;
    L13:
        if (r8.intValue() != 0) goto L15;
        e1.o(r7.f);
        return;
    L21:
        onBindViewHolder(r2, r3);
        return;
    L5:
        r6 = null;
        goto L7
    }
}
