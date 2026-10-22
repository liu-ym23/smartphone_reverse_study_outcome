package com.bytedance.android.livesdk.gift.platform.business.normal.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r02.b;
import s02.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/BaseNormalGiftCombView;", "Landroid/widget/LinearLayout;", BuildConfig.FLAVOR, "showCombo", BuildConfig.FLAVOR, "setShowCombo", BuildConfig.FLAVOR, "orientation", "setRoomOrientation", "Ls02/b;", "callback", "setGiftControllerCallback", "Ls02/c;", "listener", "setClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseNormalGiftCombView extends LinearLayout {
    public BaseNormalGiftCombView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseNormalGiftCombView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public abstract void d(ViewGroup r1);

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h(b.C0268b r1, boolean r2);

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public abstract void l();

    public abstract void m(NormalGiftMessage r1);

    public abstract void n(int r1, int r2);

    public abstract void setClickListener(c r1);

    public abstract void setGiftControllerCallback(s02.b r1);

    public abstract void setRoomOrientation(int r1);

    public abstract void setShowCombo(boolean r1);

    public BaseNormalGiftCombView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ BaseNormalGiftCombView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
