package com.larus.dora.impl.dynamic.widget;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.dora.impl.databinding.LarusDoraItemNewcomerGuideBinding;
import com.larus.platform.model.NewcomerGuideItem;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003)*+B'\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0017\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u001c\u0010\u001b\u001a\u00020\b2\n\u0010\u001c\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J$\u0010\u001f\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020!H\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0016J\u0014\u0010&\u001a\u00020\b2\n\u0010\u001c\u001a\u00060\u0003R\u00020\u0000H\u0016J\u0014\u0010'\u001a\u00020\b2\n\u0010\u001c\u001a\u00060\u0003R\u00020\u0000H\u0016J\b\u0010(\u001a\u00020\bH\u0002R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/platform/model/NewcomerGuideItem;", "Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideAdapter$ViewHolder;", "onItemClick", "Lkotlin/Function3;", "", "", "", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "gradientColors", "", "loadingDrawable", "Landroid/graphics/drawable/Drawable;", "getLoadingDrawable", "()Landroid/graphics/drawable/Drawable;", "loadingDrawable$delegate", "Lkotlin/Lazy;", "logger", "Lcom/larus/dora/api/util/DoraLogger;", "loadingAnimator", "Landroid/animation/ValueAnimator;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "onCurrentListChanged", "previousList", "", "currentList", "onDetachedFromRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewRecycled", "onViewDetachedFromWindow", "stopAnimation", "Companion", "DiffCallback", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewcomerGuideAdapter extends ListAdapter<NewcomerGuideItem, ViewHolder> {
    public static final /* synthetic */ int f = 0;
    public final Function3<NewcomerGuideItem, Integer, String, Unit> a;
    public final int[] b;
    public final Lazy c;
    public final g49.d d;
    public ValueAnimator e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/platform/model/NewcomerGuideItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<NewcomerGuideItem> {
        public DiffCallback() {
        }

        public final boolean areContentsTheSame(Object r2, Object r3) {
            NewcomerGuideItem r4 = (NewcomerGuideItem) r2;
            NewcomerGuideItem r5 = (NewcomerGuideItem) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean areItemsTheSame(Object r2, Object r3) {
            NewcomerGuideItem r4 = (NewcomerGuideItem) r2;
            NewcomerGuideItem r5 = (NewcomerGuideItem) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4.getId(), r5.getId());
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraItemNewcomerGuideBinding;", "<init>", "(Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideAdapter;Lcom/larus/dora/impl/databinding/LarusDoraItemNewcomerGuideBinding;)V", "value", "Lcom/larus/platform/model/NewcomerGuideItem;", "currentItem", "getCurrentItem", "()Lcom/larus/platform/model/NewcomerGuideItem;", "", "resolvedText", "getResolvedText", "()Ljava/lang/String;", "bind", "", "item", "setTextWithIcon", "textView", "Landroid/widget/TextView;", "text", "isLoading", "", "updateFocusState", "progress", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int e = 0;
        public final LarusDoraItemNewcomerGuideBinding a;
        public NewcomerGuideItem b;
        public String c;
        public final /* synthetic */ NewcomerGuideAdapter d;

        public final void T3(float r4) {
            g49.d r0 = this.d.d;
            g49.d.a("NewcomerGuideAdapter", "updateFocusState() called: progress=" + r4);
            if (r4 <= 0.9f) goto L5;
            float r5 = (r4 - 0.9f) / 0.1f;
        L6:
            this.a.d.setShadowColor(Color.argb((int) (41 * r5), 0, 0, 0));
            if (r4 <= 0.9f) goto L9;
            TextView r6 = this.a.b;
            final NewcomerGuideAdapter r1 = this.d;
            r6.post(new h(this, r1));
            return;
        L9:
            this.a.b.getPaint().setShader(null);
            TextView r7 = this.a.b;
            r7.setTextColor(v19.c.a(2130972081, r7.getContext(), 2131103143));
            return;
        L5:
            r5 = 0.0f;
            goto L6
        }

        public ViewHolder(NewcomerGuideAdapter r2, LarusDoraItemNewcomerGuideBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            this.d = r2;
            super(r3.a);
            this.a = r3;
            this.c = "";
        }
    }

    public static final class a {
    }

    static {
    }

    public final void y2() {
        ValueAnimator r0 = this.e;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animatable r1 = null;
        this.e = null;
        Drawable r2 = (Drawable) this.c.getValue();
        if (r2 == null) goto L8;
        r2.setCallback(null);
    L8:
        Object r3 = (Drawable) this.c.getValue();
        if ((r3 instanceof Animatable) == false) goto L12;
        r1 = (Animatable) r3;
    L12:
        if (r1 != null) goto L14;
    L16:
        g49.d.a("NewcomerGuideAdapter", "stopAnimation() called");
        return;
    L14:
        if (r1.isRunning() == false) goto L16;
        r1.stop();
        g49.d.a("NewcomerGuideAdapter", "stopAnimation() called for Animatable");
        goto L16
    }

    public final int getItemCount() {
        if (getCurrentList().isEmpty() == false) goto L6;
        return 0;
    L6:
        if (getCurrentList().size() < 2) goto L11;
        return Integer.MAX_VALUE;
    L11:
        return getCurrentList().size();
    }

    public NewcomerGuideAdapter(l r3) {
        Intrinsics.checkNotNullParameter(r3, "onItemClick");
        super(new DiffCallback());
        this.a = r3;
        this.b = new int[]{ColorProtector.parseColor("#9966FF"), ColorProtector.parseColor("#FF5D8B"), ColorProtector.parseColor("#FFA54D")};
        this.c = LazyKt.lazy(new g());
        this.d = g49.d.a;
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onDetachedFromRecyclerView(r2);
        y2();
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        ViewHolder r3 = (ViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewDetachedFromWindow(r3);
        y2();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        ViewHolder r3 = (ViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r3);
        y2();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        final ViewHolder r11 = (ViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        if (getCurrentList().isEmpty() == false) goto L6;
        return;
    L6:
        if (getCurrentList().size() < 2) goto L8;
        final NewcomerGuideItem r12 = (NewcomerGuideItem) getItem(r10 % getCurrentList().size());
    L9:
        Intrinsics.checkNotNull(r12);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "item");
        r11.b = r12;
        String r0 = r12.getTitleKey();
        String r2 = "";
        if (r0 != null) goto L12;
        r0 = "";
    L12:
        String r3 = r12.getTitleText();
        boolean r4 = true;
        if (r3 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L25;
        String r1 = r12.getTitleText();
        if (r1 == null) goto L38;
        r2 = r1;
    L38:
        r11.c = r2;
        boolean r6 = r12.isLoading();
        g49.d r7 = r11.d.d;
        g49.d.a("NewcomerGuideAdapter", "bind() called with: item.titleKey=" + r0 + ", isLoading=" + r6);
        TextView r8 = r11.a.b;
        g49.d r13 = r11.d.d;
        g49.d.a("NewcomerGuideAdapter", "setTextWithIcon() called: isLoading=" + r6 + ", text=" + r2);
        StringBuilder r14 = new StringBuilder();
        r14.append(r2);
        r14.append("  ");
        SpannableString r15 = new SpannableString(r14.toString());
        r15.setSpan(new k(c7.b(14), r6, r11.d, r8), r15.length() - 2, r15.length(), 33);
        r8.setText(r15);
        g49.d r16 = r11.d.d;
        g49.d.a("NewcomerGuideAdapter", "setTextWithIcon() set text with ReplacementSpan");
        if (r6 == false) goto L41;
        r11.a.a.setScaleX(1.0f);
        r11.a.a.setScaleY(1.0f);
        r11.a.a.setAlpha(1.0f);
        r11.T3(1.0f);
    L41:
        ConstraintLayout r17 = r11.a.c;
        final NewcomerGuideAdapter r18 = r11.d;
        e1.d(r17, new i(r11, r12, r18));
        return;
    L25:
        if (r0.length() > 0) goto L28;
        r4 = false;
    L28:
        if (r4 == true) goto L30;
    L32:
        String r20 = r0;
    L33:
        AppHost.Companion r21 = AppHost.a;
        int r22 = r21.getApplication().getResources().getIdentifier(r20, "string", r21.getApplication().getPackageName());
        if (r22 == 0) goto L36;
        r2 = r21.getApplication().getString(r22);
    L37:
        Intrinsics.checkNotNull(r2);
        goto L38
    L36:
        r2 = r0;
        goto L37
    L30:
        if (StringsKt.startsWith$default(r0, "larus_", false, 2, null) == true) goto L32;
        r20 = "larus_".concat(r0);
        goto L33
    L15:
        if (r3.length() == 0) goto L18;
        r5 = false;
        goto L19
    L8:
        r12 = (NewcomerGuideItem) getItem(r10);
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        ConstraintLayout r6 = LayoutInflater.from(r4.getContext()).inflate(2131562214, r4, false);
        int r7 = 2131374089;
        TextView r0 = (TextView) ViewBindings.findChildViewById(r6, 2131374089);
        if (r0 == null) goto L11;
        r7 = 2131375711;
        ConstraintLayout r1 = ViewBindings.findChildViewById(r6, 2131375711);
        if (r1 == null) goto L11;
        r7 = 2131386038;
        ShadowLayout r2 = (ShadowLayout) ViewBindings.findChildViewById(r6, 2131386038);
        if (r2 == null) goto L11;
        return new ViewHolder(this, new LarusDoraItemNewcomerGuideBinding(r6, r0, r1, r2));
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }

    public final void onCurrentListChanged(List<NewcomerGuideItem> r2, List<NewcomerGuideItem> r3) {
        Intrinsics.checkNotNullParameter(r2, "previousList");
        Intrinsics.checkNotNullParameter(r3, "currentList");
        super.onCurrentListChanged(r2, r3);
        notifyDataSetChanged();
    }
}
