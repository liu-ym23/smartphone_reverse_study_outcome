package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftSelectView;", "Landroid/widget/FrameLayout;", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getSelectView", "()Landroid/widget/TextView;", "setSelectView", "(Landroid/widget/TextView;)V", "selectView", "Landroid/view/View;", "g", "Landroid/view/View;", "getBottomBackgroundView", "()Landroid/view/View;", "setBottomBackgroundView", "(Landroid/view/View;)V", "bottomBackgroundView", "Landroid/content/Context;", "mContext", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UgcGiftSelectView extends FrameLayout {
    public Pair<Float, Animator> a;
    public Animator b;
    public HSImageView c;
    public TextView d;
    public TextView e;
    public py.k f;
    public View g;
    public View h;
    public View i;
    public View j;
    public View k;
    public TextView l;
    public TextView m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.preview.view.b a;

        public b(com.bytedance.android.livesdk.gift.platform.core.preview.view.b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.c.invoke();
        }
    }

    public static final class c implements View.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    static {
    }

    public UgcGiftSelectView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public UgcGiftSelectView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View getBottomBackgroundView() {
        return this.g;
    }

    public final TextView getSelectView() {
        return this.e;
    }

    public final void a(com.bytedance.android.livesdk.gift.platform.core.preview.view.b r3) {
        if (r3 == null) goto L16;
        View r0 = this.k;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        TextView r1 = this.e;
        if (r1 == null) goto L9;
        r1.setText(s1.B(r3.b));
    L9:
        View r2 = this.k;
        if (r2 == null) goto L12;
        r2.setOnClickListener(new b(r3));
    L12:
        View r4 = this.g;
        if (r4 == null) goto L17;
        r4.setBackgroundResource(r3.a);
        return;
    L17:
        return;
    }

    public final void setBottomBackgroundView(View r1) {
        this.g = r1;
    }

    public final void setSelectView(TextView r1) {
        this.e = r1;
    }

    public UgcGiftSelectView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        super(r2, r3, r4);
        FrameLayout.inflate(r2, 2131565264, this);
        this.k = findViewById(2131364437);
        this.c = findViewById(2131373729);
        this.d = (TextView) findViewById(2131373745);
        this.e = (TextView) findViewById(2131385822);
        this.g = findViewById(2131364416);
        this.h = findViewById(2131384840);
        TextView r5 = (TextView) findViewById(2131385893);
        this.j = findViewById(2131379091);
        this.l = (TextView) findViewById(2131368992);
        this.m = (TextView) findViewById(2131373743);
        this.i = findViewById(2131389138);
    }

    public /* synthetic */ UgcGiftSelectView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void b(py.k r4, String r5, String r6, com.bytedance.android.livesdk.gift.platform.core.preview.view.b r7) {
        ImageLoader.bindImage(this.c, r4, s1.j(2131168604), s1.j(2131168604));
        this.f = r4;
        TextView r8 = this.d;
        if (r8 == null) goto L5;
        r8.setText(r5);
    L5:
        TextView r9 = this.m;
        if (r9 == null) goto L8;
        r9.setText(r5);
    L8:
        TextView r10 = this.l;
        if (r10 == null) goto L11;
        r10.setText(r6);
    L11:
        View r11 = this.i;
        if (r11 == null) goto L14;
        r11.setOnClickListener(c.a);
    L14:
        a(r7);
    }
}
