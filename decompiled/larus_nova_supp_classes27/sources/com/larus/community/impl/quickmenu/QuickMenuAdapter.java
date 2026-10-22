package com.larus.community.impl.quickmenu;

import android.content.res.ColorStateList;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o29.c;
import o29.d;
import o29.e;
import o29.f;
import o29.j;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u000b2\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/community/impl/quickmenu/QuickMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/community/impl/quickmenu/QuickMenuAdapter$QuickMenuViewHolder;", "onItemClickListener", "Lcom/larus/community/impl/quickmenu/OnQuickMenuItemClickListener;", "<init>", "(Lcom/larus/community/impl/quickmenu/OnQuickMenuItemClickListener;)V", "menuItems", "", "Lcom/larus/community/impl/quickmenu/QuickMenuItem;", "setMenuItems", "", "items", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "QuickMenuViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickMenuAdapter extends RecyclerView.Adapter<QuickMenuViewHolder> {
    public final c a;
    public List<j> b;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/community/impl/quickmenu/QuickMenuAdapter$QuickMenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/community/impl/quickmenu/QuickMenuAdapter;Landroid/view/View;)V", "iconImageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "badgeImageView", "iconBorderView", "titleTextView", "Landroid/widget/TextView;", "subtitleTextView", "arrowImageView", "Landroid/widget/ImageView;", "bind", "", "item", "Lcom/larus/community/impl/quickmenu/QuickMenuItem;", "position", "", "loadIcon", "applyHighlightState", "applyGradientTextColor", "setupGradientText", "textView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class QuickMenuViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int h = 0;
        public final SimpleDraweeView a;
        public final SimpleDraweeView b;
        public final View c;
        public final TextView d;
        public final TextView e;
        public final ImageView f;
        public final /* synthetic */ QuickMenuAdapter g;

        public final void T3(TextView r10) {
            TextPaint r0 = r10.getPaint();
            r0.setShader(new LinearGradient(0.0f, 0.0f, r0.measureText(r10.getText().toString()), 0.0f, new int[]{ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131103236), ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131103234), ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131103235)}, null, Shader.TileMode.CLAMP));
        }

        public QuickMenuViewHolder(QuickMenuAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.g = r2;
            super(r3);
            this.a = r3.findViewById(2131376403);
            this.b = r3.findViewById(2131376400);
            this.c = r3.findViewById(2131379913);
            this.d = (TextView) r3.findViewById(2131390943);
            this.e = (TextView) r3.findViewById(2131390942);
            this.f = (ImageView) r3.findViewById(2131376399);
        }
    }

    public QuickMenuAdapter() {
        this(null);
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public QuickMenuAdapter(c r1) {
        this.a = r1;
        this.b = CollectionsKt.emptyList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r22, final int r23) {
        QuickMenuViewHolder r1 = (QuickMenuViewHolder) r22;
        Intrinsics.checkNotNullParameter(r1, "holder");
        final j r3 = (j) ListProtector.get(this.b, r23);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "item");
        r1.d.setText(r3.b);
        String r4 = r3.c;
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        int r7 = 8;
        if (r5 == false) goto L12;
        r1.e.setVisibility(8);
    L13:
        ImageLoaderKt.x(r1.a, r3.d, r3.f, null, new e(), 4);
        ImageLoaderKt.x(r1.b, r3.e, r3.f + "badge", null, new f(), 4);
        View r6 = r1.c;
        if (r3.g == false) goto L16;
        r7 = 0;
    L16:
        r6.setVisibility(r7);
        if (r3.g == false) goto L20;
        r1.c.setBackground(new o29.a(i5.b(), i5.r0(), new int[]{ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103159), ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103159)}, null));
    L20:
        if (r3.h == false) goto L22;
        ((RecyclerView.ViewHolder) r1).itemView.setBackground(new o29.a(i5.b(), i5.q(), new int[]{ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103230), ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103228), ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103229)}, new int[]{ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103233), ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103231), ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103232)}));
        ImageViewCompat.setImageTintList(r1.f, ColorStateList.valueOf(ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103227)));
        r1.T3(r1.d);
        r1.T3(r1.e);
    L23:
        ((RecyclerView.ViewHolder) r1).itemView.setVisibility(0);
        View r8 = ((RecyclerView.ViewHolder) r1).itemView;
        final QuickMenuAdapter r9 = r1.g;
        r8.setOnClickListener(new d(r9, r3, r23));
        r1.f.setVisibility(0);
        return;
    L22:
        ((RecyclerView.ViewHolder) r1).itemView.setBackground(new o29.a(i5.b(), i5.q(), new int[]{ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103159), ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103159)}, new int[]{ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131102545), ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131102545)}));
        ImageViewCompat.setImageTintList(r1.f, ColorStateList.valueOf(ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103140)));
        r1.d.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103136));
        r1.e.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131103143));
        goto L23
    L12:
        r1.e.setVisibility(0);
        r1.e.setText(r3.c);
        goto L13
    L5:
        if (r4.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562623, r3, false);
        Intrinsics.checkNotNull(r5);
        return new QuickMenuViewHolder(this, r5);
    }
}
