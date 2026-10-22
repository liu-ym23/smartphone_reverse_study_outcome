package com.larus.bmhome.view.actionbar.edit.component;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB1\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/DropdownItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownItemHolder;", "dropdownBoxId", "", "callback", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderCallback;", "disabledOptionProvider", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/lang/Integer;Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderCallback;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Integer;", "maxWidth", "getMaxWidth", "()I", "setMaxWidth", "(I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownItemAdapter extends ListAdapter<com.larus.bmhome.actionbar.model.w, DropdownItemHolder> {
    public static final DropdownItemAdapter$Companion$DIFF_CALLBACK$1 e = null;
    public final Integer a;
    public final b1 b;
    public final Function1<Long, Boolean> c;
    public int d;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.view.actionbar.edit.component.DropdownItemAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        e = new DropdownItemAdapter$Companion$DIFF_CALLBACK$1();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        final DropdownItemHolder r11 = (DropdownItemHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        final com.larus.bmhome.actionbar.model.w r12 = (com.larus.bmhome.actionbar.model.w) getItem(r10);
        Intrinsics.checkNotNull(r12);
        Long r0 = r12.a;
        RecyclerView.Adapter r2 = null;
        if (r0 == null) goto L9;
        long r3 = r0.longValue();
        Function1<Long, Boolean> r1 = this.c;
        if (r1 == null) goto L7;
        Boolean r4 = (Boolean) r1.invoke(Long.valueOf(r3));
    L8:
        boolean r5 = Intrinsics.areEqual(r4, Boolean.TRUE);
    L10:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "data");
        View r6 = ((RecyclerView.ViewHolder) r11).itemView;
        if (r5 == false) goto L13;
        float r7 = 0.3f;
    L14:
        r6.setAlpha(r7);
        Integer r8 = r12.s;
        if (r8 != null) goto L18;
    L20:
        if (r8 != null) goto L23;
    L25:
        r11.e.setText(r12.b);
        r11.g.removeAllViews();
        com.larus.bmhome.view.actionbar.edit.component.a r13 = b.d(r12);
        if (r13 != null) goto L28;
        com.larus.utils.e1.o(r11.g);
    L29:
        Map r14 = r12.q;
        if (r14 == null) goto L32;
        String r15 = (String) r14.get("sub_display");
    L33:
        if (r15 == null) goto L35;
        com.larus.utils.e1.x(r11.h);
        r11.h.setText(r15);
    L36:
        com.larus.utils.e1.d(((RecyclerView.ViewHolder) r11).itemView, new z0(r12, r11));
        boolean r16 = v19.h.a;
        if (v19.h.a(null) == false) goto L41;
        com.larus.bmhome.actionbar.model.g1 r17 = r12.g;
        if (r17 != null) goto L42;
        r17 = r12.f;
    L42:
        if (r17 == null) goto L73;
        Integer r18 = r17.c;
        if (r18 != null) goto L46;
    L69:
        SimpleDraweeView r19 = r11.f;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        r20.width = j19.c.c(20);
        r20.height = j19.c.c(20);
        Integer r21 = r17.e;
        if (r21 == null) goto L72;
        r19.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(c7.c(Integer.valueOf(r21.intValue()))));
    L72:
        ImageLoaderKt.u(r19, r17.b, "template_item_photo");
        com.larus.utils.e1.x(r19);
    L74:
        RecyclerView r110 = ((RecyclerView.ViewHolder) r11).itemView.getParent();
        if ((r110 instanceof RecyclerView) == false) goto L77;
        RecyclerView r111 = r110;
    L78:
        if (r111 == null) goto L80;
        r2 = r111.getAdapter();
    L80:
        int r112 = r11.getAdapterPosition();
        if (r2 == null) goto L83;
        Object r22 = Integer.valueOf(r2.getItemCount() - 1);
    L85:
        if ((r22 instanceof Integer) == true) goto L88;
    L90:
        com.larus.utils.e1.x(r11.d);
    L91:
        ((RecyclerView.ViewHolder) r11).itemView.measure(0, 0);
        int r23 = ((RecyclerView.ViewHolder) r11).itemView.getMeasuredWidth();
        if (r23 <= this.d) goto L95;
        this.d = r23;
        return;
    L95:
        return;
    L88:
        if (r112 != ((Number) r22).intValue()) goto L90;
        com.larus.utils.e1.o(r11.d);
        goto L91
    L83:
        r22 = Boolean.FALSE;
        goto L85
    L77:
        r111 = null;
        goto L78
    L46:
        if (r18.intValue() <= 0) goto L48;
        boolean r24 = true;
    L49:
        if (r24 == true) goto L52;
        r18 = null;
    L52:
        if (r18 == null) goto L69;
        int r113 = r18.intValue();
        Integer r25 = r17.d;
        if (r25 != null) goto L56;
    L67:
        com.larus.utils.e1.o(r11.f);
        SimpleDraweeView r114 = Unit.INSTANCE;
    L68:
        if (r114 != null) goto L74;
    L56:
        if (r25.intValue() <= 0) goto L58;
        boolean r26 = true;
    L59:
        if (r26 == true) goto L62;
        r25 = null;
    L62:
        if (r25 == null) goto L67;
        int r27 = r25.intValue();
        ViewGroup.LayoutParams r28 = r11.f.getLayoutParams();
        r28.width = j19.c.c(Integer.valueOf(r113));
        r28.height = j19.c.c(Integer.valueOf(r27));
        r114 = r11.f;
        r114.requestLayout();
        ImageLoaderKt.u(r114, r17.b, "template_item_photo");
        Integer r29 = r17.e;
        if (r29 == null) goto L66;
        r114.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(c7.c(Integer.valueOf(r29.intValue()))));
    L66:
        com.larus.utils.e1.x(r114);
        goto L68
    L58:
        r26 = false;
        goto L59
    L48:
        r24 = false;
        goto L49
    L73:
        com.larus.utils.e1.o(r11.f);
        goto L74
    L41:
        r17 = r12.f;
        goto L42
    L35:
        com.larus.utils.e1.o(r11.h);
        goto L36
    L32:
        r15 = null;
        goto L33
    L28:
        r11.g.addView(b.a(((RecyclerView.ViewHolder) r11).itemView.getContext(), r13), new FrameLayout.LayoutParams(-2, -2));
        com.larus.utils.e1.x(r11.g);
        goto L29
    L23:
        if (r8.intValue() != 1) goto L25;
        com.larus.utils.e1.x(r11.c);
        goto L25
    L18:
        if (r8.intValue() != 0) goto L20;
        com.larus.utils.e1.o(r11.c);
        goto L25
    L13:
        r7 = 1.0f;
        goto L14
    L7:
        r4 = null;
        goto L8
    L9:
        r5 = false;
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ConstraintLayout r5 = LayoutInflater.from(r3.getContext()).inflate(2131562462, r3, false);
        int r6 = 2131374690;
        if (ViewBindings.findChildViewById(r5, 2131374690) == null) goto L19;
        r6 = 2131374691;
        if (ViewBindings.findChildViewById(r5, 2131374691) == null) goto L19;
        r6 = 2131374697;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131374697)) == null) goto L19;
        r6 = 2131375736;
        if (ViewBindings.findChildViewById(r5, 2131375736) == null) goto L19;
        r6 = 2131378904;
        if (((LinearLayout) ViewBindings.findChildViewById(r5, 2131378904)) == null) goto L19;
        r6 = 2131390825;
        if (ViewBindings.findChildViewById(r5, 2131390825) == null) goto L19;
        r6 = 2131390830;
        if (ViewBindings.findChildViewById(r5, 2131390830) == null) goto L19;
        return new DropdownItemHolder(r5, this.a, this.b);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DropdownItemAdapter(Integer r2, b1 r3, Function1<? super Long, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(e);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
