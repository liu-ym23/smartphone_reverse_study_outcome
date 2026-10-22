package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/BaseWindScreenAnimEnterTrayView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", BuildConfig.FLAVOR, "textSize", BuildConfig.FLAVOR, "setTextSize", "Lcom/bytedance/android/live/base/model/message/e;", "getComboInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseWindScreenAnimEnterTrayView extends ConstraintLayout {
    public c a;

    public BaseWindScreenAnimEnterTrayView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseWindScreenAnimEnterTrayView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public abstract void R5(k32.d r1);

    public void S5(com.bytedance.android.live.base.model.message.d r2, com.bytedance.android.livesdk.interactivity.enteranim.utils.d r3) {
        Intrinsics.checkNotNullParameter(r2, "nextCombo");
        Intrinsics.checkNotNullParameter(r3, "onComboListener");
    }

    public boolean T5(com.bytedance.android.livesdk.interactivity.enteranim.utils.e r2) {
        Intrinsics.checkNotNullParameter(r2, "onComboListener");
        return false;
    }

    public abstract void U5(int r1, int r2);

    public com.bytedance.android.live.base.model.message.e getComboInfo() {
        return null;
    }

    public abstract void setTextSize(float r1);

    public BaseWindScreenAnimEnterTrayView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ BaseWindScreenAnimEnterTrayView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
