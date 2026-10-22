package com.larus.slides.impl.select;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.slides.biz.impl.databinding.LarusSlidesItemGenerateImageBinding;
import com.larus.slides.biz.impl.databinding.LarusSlidesLayoutBotEditErrorLayBinding;
import com.larus.utils.e1;
import com.lynx.lottieadapter.LottieAdapterView;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\u001a\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u0004H\u0016J;\u0010$\u001a\u00020\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2%\b\u0002\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R7\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R+\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/slides/impl/select/GenerateImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "defaultImageWidth", "", "defaultImageHeight", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "dataList", "", "Lcom/larus/slides/impl/select/GenerateImageViewHolder$GenerateImageItemData;", "onItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClick", "getOnItemLongClick", "setOnItemLongClick", "outerAnyImageSet", "", "success", "internalFinalImageSet", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "refreshData", "data", "onAnyImageSet", "DiffCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GenerateImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Integer a;
    public final Integer b;
    public List<GenerateImageViewHolder.b> c;
    public Function1<? super Integer, Unit> d;
    public Function1<? super Integer, Unit> e;
    public Function1<? super Boolean, Unit> f;
    public final c g;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/slides/impl/select/GenerateImageAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/slides/impl/select/GenerateImageViewHolder$GenerateImageItemData;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<GenerateImageViewHolder.b> a;
        public final List<GenerateImageViewHolder.b> b;

        public final boolean areItemsTheSame(int r1, int r2) {
            if (r1 != r2) goto L4;
            return true;
        L4:
            return false;
        }

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public DiffCallback(List<GenerateImageViewHolder.b> r2, List<GenerateImageViewHolder.b> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItems");
            Intrinsics.checkNotNullParameter(r3, "newItems");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r3, int r4) {
            GenerateImageViewHolder.b r5 = (GenerateImageViewHolder.b) ListProtector.get(this.b, r4);
            GenerateImageViewHolder.b r6 = (GenerateImageViewHolder.b) ListProtector.get(this.a, r3);
            if (r5.a == r6.a) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(r5.e, r6.e) == false) goto L9;
            if (Intrinsics.areEqual(r5.g, r6.g) == false) goto L9;
            return true;
        }
    }

    public final int getItemCount() {
        return this.c.size();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.larus.slides.impl.select.c] */
    public GenerateImageAdapter(Integer r1, Integer r2) {
        this.a = r1;
        this.b = r2;
        this.c = CollectionsKt.emptyList();
        this.g = new c(this);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r18, final int r19) {
        Intrinsics.checkNotNullParameter(r18, "holder");
        final GenerateImageViewHolder.b r3 = (GenerateImageViewHolder.b) CollectionsKt.getOrNull(this.c, r19);
        if (r3 == null) goto L34;
        Uri r5 = null;
        if ((r18 instanceof GenerateImageViewHolder) == false) goto L7;
        final GenerateImageViewHolder r4 = (GenerateImageViewHolder) r18;
    L8:
        if (r4 == null) goto L34;
        Intrinsics.checkNotNullParameter(r3, "data");
        final Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = r3.h;
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        Integer r8 = r3.i;
        r7.element = r8;
        Object r9 = r6.element;
        if (r9 == null) goto L16;
        if (r8 == null) goto L16;
        if (((Number) r9).intValue() <= 0) goto L16;
        if (((Number) r7.element).intValue() <= 0) goto L16;
    L17:
        r4.a.c.post(new q(r6, r7, r4));
        if (r3.a == false) goto L20;
        r4.a.c.getHierarchy().setPlaceholderImage(2131102539);
        e1.o(r4.a.d);
        e1.o(r4.a.g);
        e1.x(r4.a.b.a);
        LarusSlidesItemGenerateImageBinding r10 = r4.a;
        r10.b.c.setText(r10.a.getContext().getString(2131906093));
        goto L34
    L20:
        r4.a.c.getHierarchy().setPlaceholderImage(2131239857);
        e1.x(r4.a.c);
        e1.o(r4.a.b.a);
        final SimpleDraweeView r11 = r4.a.c;
        String r12 = r3.b;
        if (r12 == null) goto L23;
        r5 = UriProtector.parse(r12);
    L23:
        final Function1 r13 = new r(r3, r4);
        final boolean r14 = false;
        final Integer r15 = null;
        final Integer r16 = null;
        final boolean r17 = false;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        ImageLoaderKt.x(r11, r5, "slides_generate_image_view_holder", null, new com.larus.slides.impl.select.utils.h(r14, r17, r11, r13, r16, r15), 4);
        if (r3.b != null) goto L34;
        if (r3.g == null) goto L34;
        if (r4.a.d.getVisibility() != 0) goto L30;
        boolean r20 = true;
    L31:
        if (r20 == true) goto L33;
        e1.x(r4.a.d);
        e1.o(r4.a.g);
        r4.a.e.setRepeatMode(1);
        r4.a.e.setRepeatCount(-1);
        r4.a.e.setAnimation("lottie/ai_img_loading.json");
        r4.a.e.playAnimation();
    L33:
        r4.a.f.setText(r4.a.a.getContext().getString(2131906092) + ' ' + r3.g + '%');
        goto L34
    L30:
        r20 = false;
    L16:
        r6.element = r4.b;
        r7.element = r4.c;
        goto L17
    L7:
        r4 = null;
    L34:
        e1.d(r18.itemView, new a(this, r19));
        r18.itemView.setOnLongClickListener(new b(this, r19));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "parent");
        View r16 = LayoutInflater.from(r14.getContext()).inflate(2131563136, r14, false);
        int r0 = 2131371759;
        View r1 = ViewBindings.findChildViewById(r16, 2131371759);
        if (r1 == null) goto L21;
        FrameLayout r2 = (FrameLayout) r1;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r1, 2131388741);
        if (r4 == null) goto L19;
        LarusSlidesLayoutBotEditErrorLayBinding r7 = new LarusSlidesLayoutBotEditErrorLayBinding(r2, r2, r4);
        r0 = 2131374931;
        SimpleDraweeView r8 = ViewBindings.findChildViewById(r16, 2131374931);
        if (r8 == null) goto L21;
        r0 = 2131383311;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131383311);
        if (r9 == null) goto L21;
        r0 = 2131383320;
        LottieAdapterView r10 = ViewBindings.findChildViewById(r16, 2131383320);
        if (r10 == null) goto L21;
        r0 = 2131383332;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r16, 2131383332);
        if (r11 == null) goto L21;
        r0 = 2131393018;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r16, 2131393018);
        if (r12 == null) goto L21;
        return new GenerateImageViewHolder(new LarusSlidesItemGenerateImageBinding((FrameLayout) r16, r7, r8, r9, r10, r11, r12), this.a, this.b, this.g);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(2131388741)));
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r0)));
    }
}
