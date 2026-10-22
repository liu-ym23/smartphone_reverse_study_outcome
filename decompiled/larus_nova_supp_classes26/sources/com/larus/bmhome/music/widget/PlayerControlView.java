package com.larus.bmhome.music.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.larus.bmhome.music.databinding.LarusViewMusicPlayerControlBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\u001e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dJ\u001e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020 J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0002J\u0006\u0010%\u001a\u00020\u0017J\u0006\u0010&\u001a\u00020\u0017J\u0012\u0010'\u001a\u00020\u00172\b\b\u0002\u0010(\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcom/larus/bmhome/music/widget/PlayerControlView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canPlayPrevious", "", "canPlayNext", "themeResource", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "binding", "Lcom/larus/bmhome/music/databinding/LarusViewMusicPlayerControlBinding;", "getBinding", "()Lcom/larus/bmhome/music/databinding/LarusViewMusicPlayerControlBinding;", "binding$delegate", "Lkotlin/Lazy;", "onAttachedToWindow", "", "setPlay", "setPause", "applyCanPlayPrevious", "can", "onClickListener", "Lkotlin/Function0;", "applyCanPlayNext", "setStartClickListener", "Landroid/view/View$OnClickListener;", "setPauseClickListener", "expandTouchDelegate", "delegate", "Landroid/view/View;", "setUIToDark", "setUIToLight", "setUIWithResource", "resource", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayerControlView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public PlayerControlView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PlayerControlView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final LarusViewMusicPlayerControlBinding getBinding() {
        return (LarusViewMusicPlayerControlBinding) this.a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        final AppCompatImageView r0 = getBinding().d;
        Object r1 = r0.getParent();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.View");
        final View r2 = (View) r1;
        r2.post(new o2(r0, r2));
        final AppCompatImageView r3 = getBinding().c;
        Object r4 = r3.getParent();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.View");
        final View r5 = (View) r4;
        r5.post(new o2(r3, r5));
    }

    private final void setUIWithResource(Resources r5) {
        getBinding().d.setImageDrawable(ResourcesCompat.getDrawable(r5, 2131241624, null));
        getBinding().c.setImageDrawable(ResourcesCompat.getDrawable(r5, 2131241623, null));
        getBinding().e.setImageDrawable(ResourcesCompat.getDrawable(r5, v19.c.b(2130971778, null, 2131241625), null));
        getBinding().b.setImageDrawable(ResourcesCompat.getDrawable(r5, v19.c.b(2130971776, null, 2131241617), null));
    }

    public final void setPauseClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        com.larus.utils.e1.c(getBinding().c, r2);
    }

    public final void setStartClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        com.larus.utils.e1.c(getBinding().d, r2);
    }

    public PlayerControlView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Context r5 = m2.a;
        m2.a.getResources();
        this.a = LazyKt.lazy(new p2(r2, this));
    }

    public /* synthetic */ PlayerControlView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
