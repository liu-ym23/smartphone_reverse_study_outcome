package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/BaseGiftComboView;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "countDownTime", BuildConfig.FLAVOR, "setCountDownTime", BuildConfig.FLAVOR, "isGroupSend", "setIsGroupSend", "isSeriesSend", "setIsSeriesSend", BuildConfig.FLAVOR, "count", "setComboCount", BuildConfig.FLAVOR, "giftType", "setGiftType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseGiftComboView extends FrameLayout {
    public BaseGiftComboView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseGiftComboView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public abstract void a(long r1);

    public abstract void b(h2 r1);

    public abstract void c(Runnable r1, int r2, int r3);

    public abstract void d();

    public abstract void e(h2 r1, l1 r2, com.bytedance.android.livesdk.gift.model.n r3);

    public void f() {
    }

    public void g() {
    }

    public abstract void setComboCount(int r1);

    public abstract void setCountDownTime(long r1);

    public abstract void setGiftType(String r1);

    public abstract void setIsGroupSend(boolean r1);

    public abstract void setIsSeriesSend(boolean r1);

    public BaseGiftComboView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ BaseGiftComboView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
