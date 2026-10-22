package com.larus.chat.gallery.impl.preview.provider;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.chat.gallery.api.PreviewMediaType;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 12\u00020\u0001:\u0003/01B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00190\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00190\u001bJ$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0014\u0010'\u001a\u00020\u00192\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0012J\u0006\u0010+\u001a\u00020\u0016J\b\u0010,\u001a\u00020\u0019H\u0002J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/provider/PreviewBottomContainerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "callbackInputFragment", "visibleInputFragment", "showInput", "", "getShowInput", "()Z", "showSelection", "getShowSelection", "adapter", "Lcom/larus/chat/gallery/impl/preview/provider/PreviewBottomContainerFragment$SelectedMediaAdapter;", "selectedItems", "", "Lcom/larus/chat/gallery/api/PreviewMediaItem;", "currentItemKey", "", "selectedList", "Landroidx/recyclerview/widget/RecyclerView;", "inputContainerId", "", "callbackContainerId", "configure", "", "onSelectedItemClick", "Lkotlin/Function1;", "onSelectedItemRemove", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "updateSelection", "items", "updateCurrentItem", "itemKey", "floatingOverlayHeight", "renderSelection", "dp", "value", "SelectedMediaAdapter", "SelectedMediaViewHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewBottomContainerFragment extends Fragment {
    public static final /* synthetic */ int l = 0;
    public Fragment d;
    public Fragment e;
    public b f;
    public List<com.larus.chat.gallery.api.o> g;
    public String h;
    public RecyclerView i;
    public int j;
    public int k;

    public static final class a {
    }

    public static final class b extends RecyclerView.Adapter<c> {
        public final Function1<com.larus.chat.gallery.api.o, Unit> a;
        public final Function1<com.larus.chat.gallery.api.o, Unit> b;
        public final boolean c;
        public List<com.larus.chat.gallery.api.o> d;
        public String e;

        public final int getItemCount() {
            return this.d.size();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
            final c r14 = (c) r12;
            Intrinsics.checkNotNullParameter(r14, "holder");
            final com.larus.chat.gallery.api.o r4 = (com.larus.chat.gallery.api.o) ListProtector.get(this.d, r13);
            boolean r6 = Intrinsics.areEqual(r4.a, this.e);
            int r7 = 1;
            if (r13 != CollectionsKt.getLastIndex(this.d)) goto L5;
            boolean r15 = true;
        L6:
            r14.getClass();
            Intrinsics.checkNotNullParameter(r4, "item");
            com.larus.chat.gallery.api.o r0 = r14.k;
            String r2 = null;
            if (r0 == null) goto L9;
            String r1 = r0.a;
        L11:
            if (Intrinsics.areEqual(r1, r4.a) == true) goto L13;
            r14.l = null;
            r14.e = null;
            r14.c.setAlpha(0.0f);
            r14.d.setAlpha(0.0f);
            ImageLoaderKt.d(r14.c);
            ImageLoaderKt.d(r14.d);
        L13:
            r14.k = r4;
            RecyclerView.LayoutParams r3 = ((RecyclerView.ViewHolder) r14).itemView.getLayoutParams();
            if ((r3 instanceof RecyclerView.LayoutParams) == false) goto L16;
            RecyclerView.LayoutParams r5 = r3;
        L17:
            if (r5 == null) goto L22;
            if (r15 == false) goto L20;
            int r16 = 0;
        L21:
            r5.setMarginEnd(r16);
            goto L22
        L20:
            r16 = r14.T3(2);
        L22:
            com.larus.chat.gallery.impl.preview.datasource.n r17 = com.larus.chat.gallery.impl.preview.datasource.n.a;
            String r8 = r4.d;
            if (r8 != null) goto L25;
        L28:
            r2 = r4.b;
        L29:
            r17.getClass();
            String r18 = com.larus.chat.gallery.impl.preview.datasource.n.a(r2);
            if (r14.a == true) goto L32;
        L50:
            final boolean r9 = false;
        L51:
            final Pair<String, Boolean> r10 = TuplesKt.to(r18, Boolean.valueOf(r9));
            if (Intrinsics.areEqual(r14.l, r10) == true) goto L57;
            r14.l = r10;
            SimpleDraweeView r11 = r14.e;
            SimpleDraweeView r19 = r14.c;
            if (r11 != r19) goto L56;
            r19 = r14.d;
        L56:
            final SimpleDraweeView r20 = r19;
            r20.setAlpha(0.0f);
            ImageLoaderKt.y(r20, r18, "preview_selected_media", new v(r20, r9, r14, r4, r10), 4);
        L57:
            if (r6 == false) goto L59;
            r7 = 3;
        L59:
            int r110 = r14.T3((r7 * 2) + 64);
            r14.f.setLayoutParams(new FrameLayout.LayoutParams(r110, r110, 17));
            View r111 = r14.f;
            GradientDrawable r21 = new GradientDrawable();
            r21.setCornerRadius(r14.T3(4));
            r21.setStroke(r14.T3(r7), r14.j);
            r21.setColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r14).itemView.getContext(), R.color.transparent));
            r111.setBackground(r21);
            return;
        L32:
            if (r4.getType() != PreviewMediaType.VIDEO) goto L50;
            String r22 = r4.d;
            if (r22 != null) goto L36;
        L39:
            boolean r23 = true;
        L40:
            if (r23 == false) goto L50;
            String r24 = StringsKt.trim(r4.b).toString();
            if (StringsKt.startsWith(r24, "content://", true) == false) goto L44;
        L47:
            boolean r25 = true;
        L48:
            if (r25 == false) goto L50;
            r9 = true;
            goto L51
        L44:
            if (com.larus.chat.gallery.impl.preview.datasource.n.c(r24) != null) goto L47;
            r25 = false;
            goto L48
        L36:
            if (StringsKt.isBlank(r22) == true) goto L39;
            r23 = false;
            goto L40
        L25:
            if ((!StringsKt.isBlank(r8)) == false) goto L27;
            r2 = r8;
        L27:
            if (r2 != null) goto L29;
        L16:
            r5 = null;
            goto L17
        L9:
            r1 = null;
            goto L11
        L5:
            r15 = false;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return new c(r4, this.a, this.b, this.c);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super com.larus.chat.gallery.api.o, Unit> r2, Function1<? super com.larus.chat.gallery.api.o, Unit> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "onItemClick");
            Intrinsics.checkNotNullParameter(r3, "onItemRemove");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = CollectionsKt.emptyList();
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final boolean a;
        public final float b;
        public final SimpleDraweeView c;
        public final SimpleDraweeView d;
        public SimpleDraweeView e;
        public final View f;
        public final FrameLayout g;
        public final AppCompatImageView h;
        public final View i;
        public final int j;
        public com.larus.chat.gallery.api.o k;
        public Pair<String, Boolean> l;

        public final int T3(int r2) {
            return (int) (r2 * this.b);
        }

        public c(ViewGroup r11, final Function1<? super com.larus.chat.gallery.api.o, Unit> r12, final Function1<? super com.larus.chat.gallery.api.o, Unit> r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r11, "parent");
            Intrinsics.checkNotNullParameter(r12, "onItemClick");
            Intrinsics.checkNotNullParameter(r13, "onItemRemove");
            super(new FrameLayout(r11.getContext()));
            this.a = r14;
            Resources r15 = r11.getResources();
            this.b = WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics()).density;
            SimpleDraweeView r16 = new SimpleDraweeView(r11.getContext());
            this.c = r16;
            SimpleDraweeView r0 = new SimpleDraweeView(r11.getContext());
            this.d = r0;
            this.f = new View(r11.getContext());
            this.g = new FrameLayout(r11.getContext());
            this.h = new AppCompatImageView(r11.getContext());
            this.i = new View(r11.getContext());
            this.j = ContextCompat.getColor(r11.getContext(), v19.c.b(2130972312, r11.getContext(), 2131103298));
            int r1 = T3(70);
            int r2 = T3(64);
            View r3 = ((RecyclerView.ViewHolder) this).itemView;
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.widget.FrameLayout");
            FrameLayout r4 = (FrameLayout) r3;
            RecyclerView.LayoutParams r5 = new RecyclerView.LayoutParams(r1, r1);
            r5.setMarginEnd(T3(2));
            r4.setLayoutParams(r5);
            Iterator r17 = CollectionsKt.listOf(new SimpleDraweeView[]{r16, r0}).iterator();
        L4:
            if (r17.hasNext() == false) goto L6;
            SimpleDraweeView r6 = (SimpleDraweeView) r17.next();
            r6.setAlpha(0.0f);
            r6.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            r6.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(T3(4)));
            r6.getHierarchy().setFadeDuration(0);
            r4.addView(r6, new FrameLayout.LayoutParams(r2, r2, 17));
            goto L4
        L6:
            r4.addView(this.f, new FrameLayout.LayoutParams(r1, r1, 17));
            FrameLayout r18 = this.g;
            AppCompatImageView r7 = this.h;
            r7.setImageResource(2131243165);
            r7.setBackgroundResource(2131243166);
            float r8 = this.b;
            r7.setPadding((int) (3.5f * r8), (int) (3.5f * r8), (int) (3.5f * r8), (int) (3.5f * r8));
            r7.setImportantForAccessibility(2);
            FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(T3(18), T3(18), 8388661);
            r9.topMargin = T3(5);
            r9.setMarginEnd(T3(5));
            Unit r10 = Unit.INSTANCE;
            r18.addView(r7, r9);
            View r19 = this.i;
            r19.setContentDescription(r11.getContext().getString(2131898799));
            r18.addView(r19, new FrameLayout.LayoutParams(T3(30), T3(30), 8388661));
            r4.addView(r18, new FrameLayout.LayoutParams(r2, r2, 17));
            r4.setOnClickListener(new w(this, r12));
            this.i.setOnClickListener(new x(this, r13));
        }
    }

    static {
    }

    public final void T90() {
        RecyclerView r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.chat.gallery.api.o r1 = (com.larus.chat.gallery.api.o) CollectionsKt.singleOrNull(this.g);
        int r3 = 0;
        if (requireArguments().getBoolean("show_selection") == false) goto L15;
        boolean r4 = true;
        if (this.g.size() > 1) goto L16;
        if (r1 == null) goto L15;
        String r2 = this.h;
        if (r2 == null) goto L15;
        if (Intrinsics.areEqual(r1.a, r2) == true) goto L15;
    L16:
        if (r4 == true) goto L19;
        r3 = 8;
    L19:
        r0.setVisibility(r3);
        b r5 = this.f;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r5 = null;
    L22:
        List<com.larus.chat.gallery.api.o> r6 = this.g;
        final String r7 = this.h;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "items");
        final List<com.larus.chat.gallery.api.o> r8 = r5.d;
        final String r9 = r5.e;
        final List<com.larus.chat.gallery.api.o> r10 = CollectionsKt.toList(r6);
        DiffUtil.DiffResult r11 = DiffUtil.calculateDiff(new PreviewBottomContainerFragment$SelectedMediaAdapter$submit$diff$1(r8, r10, r9, r7));
        r5.d = r10;
        r5.e = r7;
        r11.dispatchUpdatesTo(r5);
        return;
    L15:
        r4 = false;
        goto L16
    }

    public PreviewBottomContainerFragment() {
        this.g = CollectionsKt.emptyList();
        this.j = -1;
        this.k = -1;
    }

    public final int S90(int r3) {
        Resources r0 = getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public final void U90(String r5) {
        Intrinsics.checkNotNullParameter(r5, "itemKey");
        this.h = r5;
        T90();
        Iterator<com.larus.chat.gallery.api.o> r0 = this.g.iterator();
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r0.next().a, r5) == true) goto L10;
        r2 = r2 + 1;
    L10:
        Integer r6 = Integer.valueOf(r2);
        if (r6.intValue() < 0) goto L13;
        r1 = true;
    L13:
        if (r1 == true) goto L16;
        r6 = null;
    L16:
        if (r6 == null) goto L23;
        int r7 = r6.intValue();
        RecyclerView r3 = this.i;
        if (r3 == null) goto L24;
        r3.scrollToPosition(r7);
        return;
    L24:
        return;
    L23:
        return;
    L9:
        r2 = -1;
        goto L10
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        Fragment r6 = this.e;
        if (r6 != null) goto L5;
    L11:
        Fragment r7 = this.d;
        if (r7 == null) goto L21;
        if (r7 == r6) goto L21;
        if (getChildFragmentManager().findFragmentByTag("PreviewGalleryCallbackInputFragment") != null) goto L21;
        FragmentTransaction r8 = getChildFragmentManager().beginTransaction();
        int r1 = this.k;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "PreviewGalleryCallbackInputFragment", r1) == true) goto L20;
        r8 = r8.replace(r1, r7, "PreviewGalleryCallbackInputFragment");
    L20:
        r8.commitNowAllowingStateLoss();
    L21:
        T90();
        return;
    L5:
        if (getChildFragmentManager().findFragmentByTag("PreviewGalleryInputFragment") != null) goto L11;
        FragmentTransaction r9 = getChildFragmentManager().beginTransaction();
        int r2 = this.j;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "PreviewGalleryInputFragment", r2) == true) goto L10;
        r9 = r9.replace(r2, r6, "PreviewGalleryInputFragment");
    L10:
        r9.commitNowAllowingStateLoss();
        goto L11
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        if (this.f != null) goto L5;
        this.f = new b(new s(), new t(), requireArguments().getBoolean("show_selection"));
    L5:
        Context r10 = requireContext();
        this.j = View.generateViewId();
        this.k = View.generateViewId();
        FrameLayout r11 = new FrameLayout(r10);
        r11.setBackgroundResource(R.color.transparent);
        RecyclerView r0 = new RecyclerView(r10);
        this.i = r0;
        r0.setLayoutManager(new LinearLayoutManager(r10, 0, false));
        b r1 = this.f;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r1 = null;
    L8:
        r0.setAdapter(r1);
        r0.setPadding(S90(9), S90(9), S90(9), S90(9));
        r0.setClipToPadding(false);
        r0.setBackgroundResource(R.color.transparent);
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, S90(88), 80);
        r12.bottomMargin = S90(144);
        Unit r2 = Unit.INSTANCE;
        r11.addView(r0, r12);
        FrameLayout r13 = new FrameLayout(r10);
        r13.setId(this.j);
        if (requireArguments().getBoolean("show_input") == false) goto L11;
        int r3 = 0;
    L12:
        r13.setVisibility(r3);
        r11.addView(r13, new FrameLayout.LayoutParams(-1, -2, 80));
        if (this.d == this.e) goto L15;
        FrameLayout r14 = new FrameLayout(r10);
        r14.setId(this.k);
        r14.setVisibility(8);
        r11.addView(r14, new FrameLayout.LayoutParams(0, 0));
    L15:
        ViewCompat.setOnApplyWindowInsetsListener(r11, new u(this));
        ViewCompat.requestApplyInsets(r11);
        return r11;
    L11:
        r3 = 8;
        goto L12
    }
}
