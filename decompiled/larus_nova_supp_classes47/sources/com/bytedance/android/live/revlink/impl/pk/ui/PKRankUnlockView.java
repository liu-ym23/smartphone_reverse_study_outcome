package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PKRankUnlockView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function0;", "", "onClick", "setOnRandomMatchBtnClick", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRankUnlockView extends FrameLayout {
    public final FrameLayout a;
    public final View b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public zy0.d i;
    public int j;
    public Function0<Unit> k;
    public final a l;

    public static final class a implements Function1<yy0.d, Unit> {
        public a() {
        }

        public final Object invoke(Object r2) {
            yy0.d r3 = (yy0.d) r2;
            Intrinsics.checkNotNullParameter(r3, "p1");
            r3.d(PKRankUnlockView$callBackObject$1$invoke$1.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public PKRankUnlockView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PKRankUnlockView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zy0.d r0 = this.i;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void setOnRandomMatchBtnClick(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onClick");
        this.k = r2;
    }

    public PKRankUnlockView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.k = PKRankUnlockView$onRandomBtnClick$1.INSTANCE;
        View r5 = FrameLayout.inflate(r2, 2131566360, this);
        HSImageView r6 = r5.findViewById(2131383674);
        this.e = (TextView) r5.findViewById(2131383675);
        this.a = (FrameLayout) r5.findViewById(2131383681);
        this.b = r5.findViewById(2131383679);
        this.c = (TextView) r5.findViewById(2131383688);
        this.d = (TextView) r5.findViewById(2131383677);
        this.f = (TextView) r5.findViewById(2131383689);
        this.g = (TextView) r5.findViewById(2131383628);
        this.h = (TextView) r5.findViewById(2131383676);
        this.l = new a();
    }

    public /* synthetic */ PKRankUnlockView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
