package com.larus.uaigc.instruction.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.platform.service.z2;
import com.larus.uaigc.impl.databinding.LarusUaigcItemActionbarImageListPlaceHolderBinding;
import com.larus.uaigc.impl.databinding.LarusUaigcItemActionbarImageSelectorHolderBinding;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vz9.d;
import vz9.h;
import vz9.i;
import vz9.j;
import vz9.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004*+,-B,\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001b\b\u0002\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0010J\u001e\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\u001eH\u0002J&\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00102\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0018\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/larus/uaigc/instruction/widget/ImageSelectorWithMoreWidgetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "callback", "Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;", "headerViewDsl", "Lkotlin/Function1;", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWithMoreWidgetAdapter$HeaderComponentBuilder;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;Lkotlin/jvm/functions/Function1;)V", "headerComponentBuilder", "headerComponent", "Lcom/larus/uaigc/instruction/widget/HeaderComponent;", "offset", "", "dataList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "getItemCount", "getItem", "position", "refreshData", "data", "calDiff", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "isForceDisableGifAnim", "onBindViewHolder", "holder", "payloads", "", "", "getItemViewType", "Companion", "HeaderComponentBuilder", "DiffCallback", "ChangePayload", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageSelectorWithMoreWidgetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Lazy<JSONObject> e = null;
    public final d a;
    public final com.larus.uaigc.instruction.widget.b b;
    public final int c;
    public List<w> d;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/instruction/widget/ImageSelectorWithMoreWidgetAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "newItems", "<init>", "(Lcom/larus/uaigc/instruction/widget/ImageSelectorWithMoreWidgetAdapter;Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class DiffCallback extends DiffUtil.Callback {
        public final List<w> a;
        public final List<w> b;
        public final /* synthetic */ ImageSelectorWithMoreWidgetAdapter c;

        public final int getNewListSize() {
            return this.b.size() + this.c.c;
        }

        public final int getOldListSize() {
            return this.a.size() + this.c.c;
        }

        public final boolean areContentsTheSame(int r6, int r7) {
            int r0 = this.c.c;
            if (r6 < r0) goto L24;
            if (r7 < r0) goto L24;
            int r8 = r6 - r0;
            int r9 = r7 - r0;
            g1 r1 = ((w) ListProtector.get(this.a, r8)).f;
            String r3 = null;
            if (r1 == null) goto L9;
            String r2 = r1.b;
        L10:
            g1 r4 = ((w) ListProtector.get(this.b, r9)).f;
            if (r4 == null) goto L14;
            r3 = r4.b;
        L14:
            if (Intrinsics.areEqual(r2, r3) == true) goto L16;
        L22:
            return false;
        L16:
            if (Intrinsics.areEqual(((w) ListProtector.get(this.a, r8)).b, ((w) ListProtector.get(this.b, r9)).b) == false) goto L22;
            if (Intrinsics.areEqual(((w) ListProtector.get(this.a, r8)).d, ((w) ListProtector.get(this.b, r9)).d) == false) goto L22;
            if (Intrinsics.areEqual(((w) ListProtector.get(this.a, r8)).s, ((w) ListProtector.get(this.b, r9)).s) == false) goto L22;
            return true;
        L9:
            r2 = null;
        L24:
            if (r6 == r7) goto L29;
            return false;
        L29:
            return true;
        }

        public final boolean areItemsTheSame(int r5, int r6) {
            int r0 = this.c.c;
            if (r5 >= r0) goto L9;
            if (r6 >= r0) goto L9;
            if (r5 == r6) goto L17;
            return false;
        L17:
            return true;
        L9:
            if (r5 < r0) goto L16;
            if (r6 < r0) goto L16;
            if (((w) ListProtector.get(this.a, r5 - r0)).getType() == ((w) ListProtector.get(this.b, r6 - this.c.c)).getType()) goto L18;
            return false;
        L18:
            return true;
        L16:
            return false;
        }

        public final Object getChangePayload(int r4, int r5) {
            int r0 = this.c.c;
            if (r4 < r0) goto L22;
            if (r5 < r0) goto L22;
            w r6 = (w) ListProtector.get(this.b, r5 - r0);
            w r7 = (w) ListProtector.get(this.a, r4 - this.c.c);
            g1 r1 = r7.f;
            if (r1 == null) goto L9;
            String r2 = r1.b;
        L10:
            g1 r3 = r6.f;
            if (r3 == null) goto L13;
            String r8 = r3.b;
        L15:
            if (Intrinsics.areEqual(r2, r8) == false) goto L22;
            if (Intrinsics.areEqual(r7.b, r6.b) == false) goto L22;
            if (Intrinsics.areEqual(r7.d, r6.d) == false) goto L22;
            return new i();
        L13:
            r8 = null;
            goto L15
        L9:
            r2 = null;
        L22:
            return null;
        }

        public DiffCallback(ImageSelectorWithMoreWidgetAdapter r2, List<w> r3, List<w> r4) {
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
        public final k b;

        public b() {
            this.a = new j();
            this.b = new k();
        }
    }

    static {
        e = LazyKt.lazy(new h());
    }

    public final int getItemCount() {
        return this.d.size() + this.c;
    }

    public final int getItemViewType(int r3) {
        int r0 = this.c;
        if (r3 >= r0) goto L6;
        return 1;
    L6:
        if (((w) ListProtector.get(this.d, r3 - r0)).getType() != 4) goto L8;
        return 2;
    L8:
        return 0;
    }

    public ImageSelectorWithMoreWidgetAdapter(d r2, Function1<? super b, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
        b r4 = new b();
        this.d = CollectionsKt.emptyList();
        if (r3 == null) goto L6;
        r3.invoke(r4);
        this.b = new com.larus.uaigc.instruction.widget.b(r4);
    L6:
        if (this.b == null) goto L8;
        int r5 = 1;
    L9:
        this.c = r5;
        return;
    L8:
        r5 = 0;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof HeaderViewHolder) == false) goto L8;
        com.larus.uaigc.instruction.widget.b r5 = this.b;
        if (r5 == null) goto L11;
        HeaderViewHolder r6 = (HeaderViewHolder) r3;
        Intrinsics.checkNotNullParameter(r6, "holder");
        r5.a.b.invoke(r6);
        return;
    L11:
        return;
    L8:
        if ((r3 instanceof ImageSelectorHolder) == false) goto L13;
        ((ImageSelectorHolder) r3).T3((w) ListProtector.get(this.d, r4 - this.c));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        boolean r1 = true;
        if (r9 != 1) goto L5;
        com.larus.uaigc.instruction.widget.b r2 = this.b;
        if (r2 == null) goto L37;
        Intrinsics.checkNotNullParameter(r8, "parent");
        View r0 = (View) r2.a.a.invoke(r8);
        if (r0 == null) goto L37;
    L39:
        return new HeaderViewHolder(r0);
    L37:
        r0 = new View(r8.getContext());
        goto L39
    L5:
        if (r9 != 2) goto L40;
        RoundFrameLayout r10 = LayoutInflater.from(r8.getContext()).inflate(2131563190, r8, false);
        View r3 = ViewBindings.findChildViewById(r10, 2131377861);
        if (r3 == null) goto L32;
        return new ImagePlaceHolder(new LarusUaigcItemActionbarImageListPlaceHolderBinding(r10, r3));
    L32:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(2131377861)));
    L40:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        JSONObject r12 = (JSONObject) e.getValue();     // Catch: Throwable -> L13
        if (r12 == null) goto L10;
        double r5 = r12.optDouble("cpu_score");     // Catch: Throwable -> L13
    L11:
        Object r13 = Result.constructor-impl(Double.valueOf(r5));     // Catch: Throwable -> L13
    L16:
        if (Result.exceptionOrNull-impl(r13) == null) goto L19;
        r13 = Double.valueOf(0.0d);
    L19:
        double r4 = ((Number) r13).doubleValue();
        Double r14 = z2.a.getVideoStyleAnimConfig().a();
        if (r14 == null) goto L22;
        double r6 = r14.doubleValue();
    L24:
        if (r4 < r6) goto L42;
        r1 = false;
    L42:
        return new ImageSelectorHolder(LarusUaigcItemActionbarImageSelectorHolderBinding.a(LayoutInflater.from(r8.getContext()), r8).a, this.a, r1);
    L22:
        r6 = 8.0d;
        goto L24
    L10:
        r5 = 0.0d;
    L13:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public final void y2(List<w> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "data");
        List<w> r13 = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r0.add(w.a((w) r14.next(), null, null, null, null, null, null, 8388607));
        goto L4
    L6:
        if (r12 == false) goto L8;
        DiffUtil.DiffResult r15 = DiffUtil.calculateDiff(new DiffCallback(this, this.d, r0), false);
        this.d = r0;
        r15.dispatchUpdatesTo(this);
        return;
    L8:
        this.d = r0;
        notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        onBindViewHolder(r2, r3);
    }
}
