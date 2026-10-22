package com.larus.avlink.env.diary.style;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.avlink.impl.databinding.LarusItemDiaryStyleAddBinding;
import com.larus.avlink.impl.databinding.LarusItemDiaryStyleBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.l0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0019\u001a\u001b\u001cB5\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001c\u0010\u0016\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00182\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/avlink/env/diary/style/DiaryStyleAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/avlink/env/diary/style/DiaryStyleItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onItemClick", "Lkotlin/Function1;", "", "onItemLongClick", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "maxCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "setData", "items", "", "Companion", "StyleViewHolder", "AddViewHolder", "DiffCallback", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DiaryStyleAdapter extends ListAdapter<e0, RecyclerView.ViewHolder> {
    public final Function1<e0, Unit> a;
    public final Function2<View, e0, Unit> b;
    public int c;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/avlink/env/diary/style/DiaryStyleAdapter$AddViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/avlink/impl/databinding/LarusItemDiaryStyleAddBinding;", "onItemClick", "Lkotlin/Function1;", "Lcom/larus/avlink/env/diary/style/DiaryStyleItem;", "", "<init>", "(Lcom/larus/avlink/impl/databinding/LarusItemDiaryStyleAddBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "maxCount", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class AddViewHolder extends RecyclerView.ViewHolder {
        public final LarusItemDiaryStyleAddBinding a;
        public final Function1<e0, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public AddViewHolder(LarusItemDiaryStyleAddBinding r2, Function1<? super e0, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            Intrinsics.checkNotNullParameter(r3, "onItemClick");
            super(r2.a);
            this.a = r2;
            this.b = r3;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/env/diary/style/DiaryStyleAdapter$StyleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/avlink/impl/databinding/LarusItemDiaryStyleBinding;", "onItemClick", "Lkotlin/Function1;", "Lcom/larus/avlink/env/diary/style/DiaryStyleItem;", "", "onItemLongClick", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lcom/larus/avlink/impl/databinding/LarusItemDiaryStyleBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "bind", "item", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class StyleViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int d = 0;
        public final LarusItemDiaryStyleBinding a;
        public final Function1<e0, Unit> b;
        public final Function2<View, e0, Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        public StyleViewHolder(LarusItemDiaryStyleBinding r2, Function1<? super e0, Unit> r3, Function2<? super View, ? super e0, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            Intrinsics.checkNotNullParameter(r3, "onItemClick");
            Intrinsics.checkNotNullParameter(r4, "onItemLongClick");
            super(r2.a);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class a {
    }

    public static final class b extends DiffUtil.ItemCallback<e0> {
        public b() {
        }

        public final boolean areContentsTheSame(Object r2, Object r3) {
            e0 r4 = (e0) r2;
            e0 r5 = (e0) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean areItemsTheSame(Object r2, Object r3) {
            e0 r4 = (e0) r2;
            e0 r5 = (e0) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4.a, r5.a);
        }
    }

    static {
    }

    public final int getItemViewType(int r1) {
        return ((e0) getItem(r1)).g ? 1 : 0;
    }

    public DiaryStyleAdapter(o r2, p r3) {
        Intrinsics.checkNotNullParameter(r2, "onItemClick");
        Intrinsics.checkNotNullParameter(r3, "onItemLongClick");
        super(new b());
        this.a = r2;
        this.b = r3;
        this.c = 30;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        boolean r2 = true;
        int r3 = 0;
        if ((r9 instanceof StyleViewHolder) == false) goto L49;
        final StyleViewHolder r11 = (StyleViewHolder) r9;
        final e0 r12 = (e0) getItem(r10);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "item");
        final LarusItemDiaryStyleBinding r0 = r11.a;
        String r1 = r12.b;
        int r5 = 8;
        if (r1.length() <= 8) goto L7;
        r1 = r1.substring(0, 8) + "...";
    L7:
        r0.c.setText(r1);
        r0.d.setText(r12.c);
        String r4 = r12.d;
        if (r4 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == true) goto L16;
        r0.b.setVisibility(0);
        l0.b(new com.larus.avlink.env.diary.style.b(r0, r12));
    L17:
        ImageView r7 = r0.e;
        if (r12.e == false) goto L20;
        int r8 = 0;
    L21:
        r7.setVisibility(r8);
        if (r12.f == true) goto L24;
    L26:
        boolean r13 = false;
    L27:
        TextView r14 = r0.f;
        if (r13 == false) goto L30;
        r5 = 0;
    L30:
        r14.setVisibility(r5);
        if (r0.b.getVisibility() != 0) goto L33;
        boolean r15 = true;
    L34:
        if (r15 == false) goto L36;
    L42:
        if (r2 == false) goto L44;
        r3 = r0.a.getResources().getDimensionPixelSize(v19.c.b(2130971480, r0.a.getContext(), 2131167331));
    L44:
        ViewGroup.LayoutParams r16 = r0.c.getLayoutParams();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        if (r17.getMarginStart() == r3) goto L47;
        r17.setMarginStart(r3);
        r0.c.setLayoutParams(r17);
    L47:
        r0.a.setOnClickListener(new c(r11, r12));
        r0.a.setOnLongClickListener(new d(r11, r12));
        r0.a.setSelected(r12.e);
        return;
    L36:
        if (r0.f.getVisibility() != 0) goto L38;
        boolean r18 = true;
    L39:
        if (r18 == true) goto L42;
        r2 = false;
        goto L42
    L38:
        r18 = false;
        goto L39
    L33:
        r15 = false;
        goto L34
    L24:
        if (StringsKt.startsWith$default(StringsKt.trim(r12.b).toString(), "自定义风格", false, 2, null) == true) goto L26;
        r13 = true;
        goto L27
    L20:
        r8 = 8;
        goto L21
    L16:
        r0.b.setVisibility(8);
        goto L17
    L10:
        if (r4.length() == 0) goto L13;
        r6 = false;
        goto L14
    L49:
        if ((r9 instanceof AddViewHolder) == false) goto L53;
        final AddViewHolder r19 = (AddViewHolder) r9;
        final e0 r110 = (e0) getItem(r10);
        int r20 = this.c;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r110, "item");
        r19.a.b.setText(((RecyclerView.ViewHolder) r19).itemView.getContext().getString(2131903853, new Object[]{Integer.valueOf(r20)}));
        r19.a.a.setOnClickListener(new com.larus.avlink.env.diary.style.a(r19, r110));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        if (r11 != 1) goto L11;
        ConstraintLayout r12 = LayoutInflater.from(r10.getContext()).inflate(2131562547, r10, false);
        int r13 = 2131369059;
        if (((TextView) ViewBindings.findChildViewById(r12, 2131369059)) == null) goto L10;
        r13 = 2131369060;
        TextView r0 = (TextView) ViewBindings.findChildViewById(r12, 2131369060);
        if (r0 == null) goto L10;
        return new AddViewHolder(new LarusItemDiaryStyleAddBinding(r12, r0), this.a);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    L11:
        ConstraintLayout r14 = LayoutInflater.from(r10.getContext()).inflate(2131562546, r10, false);
        int r15 = 2131369066;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r14, 2131369066);
        if (r4 == null) goto L24;
        r15 = 2131369068;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r14, 2131369068);
        if (r5 == null) goto L24;
        r15 = 2131369069;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r14, 2131369069);
        if (r6 == null) goto L24;
        r15 = 2131369071;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r14, 2131369071);
        if (r7 == null) goto L24;
        r15 = 2131369073;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r14, 2131369073);
        if (r8 == null) goto L24;
        return new StyleViewHolder(new LarusItemDiaryStyleBinding(r14, r4, r5, r6, r7, r8), this.a, this.b);
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
