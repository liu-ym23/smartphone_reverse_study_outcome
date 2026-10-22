package com.bytedance.android.live.effect.sticker.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R#\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0016R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00063"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteImageView;", "a", "Lkotlin/Lazy;", "getMIconIV", "()Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteImageView;", "mIconIV", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "b", "getMTipTV", "()Landroid/widget/TextView;", "mTipTV", "Landroid/view/View;", "c", "getClickProxy", "()Landroid/view/View;", "clickProxy", "", "d", "getMTipTextNormal", "()Ljava/lang/String;", "mTipTextNormal", "e", "getMTipTextSelected", "mTipTextSelected", "Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteView$a;", "i", "Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteView$a;", "getFavoriteStatusListener", "()Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteView$a;", "setFavoriteStatusListener", "(Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteView$a;)V", "favoriteStatusListener", "", "j", "Z", "getShowEnable", "()Z", "setShowEnable", "(Z)V", "showEnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerFavoriteView extends LinearLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public boolean f;
    public Sticker g;
    public boolean h;
    public a i;
    public boolean j;
    public Sticker k;
    public boolean l;
    public boolean m;

    public interface a {
        void a(Sticker r1, boolean r2);
    }

    public StickerFavoriteView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StickerFavoriteView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final View getClickProxy() {
        return (View) this.c.getValue();
    }

    private final StickerFavoriteImageView getMIconIV() {
        return (StickerFavoriteImageView) this.a.getValue();
    }

    private final TextView getMTipTV() {
        return (TextView) this.b.getValue();
    }

    private final String getMTipTextNormal() {
        return (String) this.d.getValue();
    }

    private final String getMTipTextSelected() {
        return (String) this.e.getValue();
    }

    public final a getFavoriteStatusListener() {
        return this.i;
    }

    public final boolean getShowEnable() {
        return this.j;
    }

    public static final /* synthetic */ StickerFavoriteImageView a(StickerFavoriteView r0) {
        return r0.getMIconIV();
    }

    public static final /* synthetic */ TextView b(StickerFavoriteView r0) {
        return r0.getMTipTV();
    }

    public static final /* synthetic */ String c(StickerFavoriteView r0) {
        return r0.getMTipTextNormal();
    }

    public static final /* synthetic */ String d(StickerFavoriteView r0) {
        return r0.getMTipTextSelected();
    }

    public final void setFavoriteStatusListener(a r1) {
        this.i = r1;
    }

    public final void setShowEnable(boolean r1) {
        this.j = r1;
    }

    public final void e(Sticker r2, boolean r3) {
        if (this.h == true) goto L5;
        this.k = r2;
        this.l = r3;
        this.m = true;
        return;
    L5:
        f(r2, r3, new StickerFavoriteView$refresh$1(this));
    }

    public StickerFavoriteView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new StickerFavoriteView$mIconIV$2(this));
        this.b = LazyKt.lazy(new StickerFavoriteView$mTipTV$2(this));
        this.c = LazyKt.lazy(new StickerFavoriteView$clickProxy$2(this));
        this.d = LazyKt.lazy(new StickerFavoriteView$mTipTextNormal$2(r2));
        this.e = LazyKt.lazy(new StickerFavoriteView$mTipTextSelected$2(r2));
        this.h = true;
        this.j = true;
        this.l = true;
        LinearLayout.inflate(r2, 2131565857, this);
        View.OnClickListener r5 = new StickerFavoriteView$bindClickListener$listener$1(this);
        setOnClickListener(r5);
        getClickProxy().setOnClickListener(r5);
        r3.e(getClickProxy(), new StickerFavoriteView$bindClickListener$1(this));
        getMIconIV().setOnStateChangeListener(new n(this));
    }

    public final void f(Sticker r2, boolean r3, Function0<Unit> r4) {
        if (this.j == true) goto L6;
        setVisibility(8);
        return;
    L6:
        if (r2 != null) goto L9;
        setVisibility(4);
        return;
    L9:
        setVisibility(0);
        this.g = r2;
        this.f = r3;
        r4.invoke();
    }

    public /* synthetic */ StickerFavoriteView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
