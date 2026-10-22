package com.bytedance.android.live.effect.sticker.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R#\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0015\u001a\n \u000b*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u001a\u001a\n \u000b*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001e\u001a\n \u000b*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\"R\u001d\u0010&\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u0014R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\r\u001a\u0004\b)\u0010*¨\u00064"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerPanelIntroductionPage;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "title", "", "setTitle", "", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$EffectSubTipInfo;", "list", "setIntroductionInfoList", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getBackButton", "()Landroid/widget/ImageView;", "backButton", "Landroid/widget/TextView;", "b", "getTitleTextView", "()Landroid/widget/TextView;", "titleTextView", "Landroidx/recyclerview/widget/RecyclerView;", "c", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "d", "getSingeIntroductionItem", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "singeIntroductionItem", "Lcom/facebook/drawee/view/SimpleDraweeView;", "e", "getSingeIntroductionImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "singeIntroductionImageView", "f", "getSingeIntroductionTextView", "singeIntroductionTextView", "Lcom/bytedance/android/live/effect/sticker/ui/StickerIntroductionInfoAdapter;", "g", "getAdapter", "()Lcom/bytedance/android/live/effect/sticker/ui/StickerIntroductionInfoAdapter;", "adapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerPanelIntroductionPage extends ConstraintLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ StickerPanelIntroductionPage a;

        public a(StickerPanelIntroductionPage r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.setVisibility(4);
            RecyclerView r3 = StickerPanelIntroductionPage.R5(this.a);
            if (r3 == null) goto L6;
            r3.removeAllViews();
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ StickerPanelIntroductionPage a;

        public b(StickerPanelIntroductionPage r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r0 = StickerPanelIntroductionPage.R5(this.a);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setVisibility(0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public StickerPanelIntroductionPage(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StickerPanelIntroductionPage(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final StickerIntroductionInfoAdapter getAdapter() {
        return (StickerIntroductionInfoAdapter) this.g.getValue();
    }

    private final ImageView getBackButton() {
        return (ImageView) this.a.getValue();
    }

    private final RecyclerView getRecyclerView() {
        return (RecyclerView) this.c.getValue();
    }

    private final SimpleDraweeView getSingeIntroductionImageView() {
        return (SimpleDraweeView) this.e.getValue();
    }

    private final ConstraintLayout getSingeIntroductionItem() {
        return (ConstraintLayout) this.d.getValue();
    }

    private final TextView getSingeIntroductionTextView() {
        return (TextView) this.f.getValue();
    }

    private final TextView getTitleTextView() {
        return (TextView) this.b.getValue();
    }

    public static final /* synthetic */ RecyclerView R5(StickerPanelIntroductionPage r0) {
        return r0.getRecyclerView();
    }

    public static final /* synthetic */ ConstraintLayout S5(StickerPanelIntroductionPage r0) {
        return r0.getSingeIntroductionItem();
    }

    public final void setIntroductionInfoList(List<Sticker.EffectSubTipInfo> r6) {
        Intrinsics.checkNotNullParameter(r6, "list");
        if (r6.isEmpty() == false) goto L6;
        return;
    L6:
        if (r6.size() != 1) goto L20;
        Sticker.EffectSubTipInfo r7 = (Sticker.EffectSubTipInfo) CollectionsKt.firstOrNull(r6);
        RecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L10;
        r0.setVisibility(4);
    L10:
        if (r7 == null) goto L17;
        AbstractDraweeController r1 = Fresco.newDraweeControllerBuilder().setUri(r7.getTipImageUrl()).setAutoPlayAnimations(true).build();
        SimpleDraweeView r2 = getSingeIntroductionImageView();
        if (r2 == null) goto L14;
        r2.setController(r1);
    L14:
        TextView r3 = getSingeIntroductionTextView();
        if (r3 == null) goto L17;
        r3.setText(r7.getTip());
    L17:
        ConstraintLayout r8 = getSingeIntroductionItem();
        if (r8 == null) goto L27;
        r8.setVisibility(0);
        return;
    L27:
        return;
    L20:
        ConstraintLayout r4 = getSingeIntroductionItem();
        if (r4 == null) goto L23;
        r4.setVisibility(4);
    L23:
        StickerIntroductionInfoAdapter r5 = getAdapter();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "list");
        ((ArrayList) r5.a).clear();
        ArrayList r9 = (ArrayList) r5.a;
        r9.addAll(r6);
        ListProtector.add(r5.a, 0, new Sticker.EffectSubTipInfo("", ""));
        List<Sticker.EffectSubTipInfo> r11 = r5.a;
        ArrayList r12 = (ArrayList) r11;
        r12.add(new Sticker.EffectSubTipInfo("", ""));
        r5.notifyDataSetChanged();
        RecyclerView r13 = getRecyclerView();
        if (r13 == null) goto L29;
        r13.post(new b(this));
        return;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        TextView r0 = getTitleTextView();
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerPanelIntroductionPage(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new StickerPanelIntroductionPage$backButton$2(this));
        this.b = LazyKt.lazy(new StickerPanelIntroductionPage$titleTextView$2(this));
        this.c = LazyKt.lazy(new StickerPanelIntroductionPage$recyclerView$2(this));
        this.d = LazyKt.lazy(new StickerPanelIntroductionPage$singeIntroductionItem$2(this));
        this.e = LazyKt.lazy(new StickerPanelIntroductionPage$singeIntroductionImageView$2(this));
        this.f = LazyKt.lazy(new StickerPanelIntroductionPage$singeIntroductionTextView$2(this));
        this.g = LazyKt.lazy(StickerPanelIntroductionPage$adapter$2.INSTANCE);
        ViewGroup.inflate(r2, 2131565934, this);
        RecyclerView r5 = getRecyclerView();
        if (r5 == null) goto L5;
        LinearLayoutManager r6 = new LinearLayoutManager(r2);
        r6.setOrientation(0);
        Unit r7 = Unit.INSTANCE;
        r5.setLayoutManager(r6);
    L5:
        new LinearSnapHelper().attachToRecyclerView(getRecyclerView());
        RecyclerView r8 = getRecyclerView();
        if (r8 == null) goto L8;
        r8.setAdapter(getAdapter());
    L8:
        ImageView r9 = getBackButton();
        if (r9 == null) goto L12;
        r9.setOnClickListener(new a(this));
        return;
    }

    public /* synthetic */ StickerPanelIntroductionPage(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
