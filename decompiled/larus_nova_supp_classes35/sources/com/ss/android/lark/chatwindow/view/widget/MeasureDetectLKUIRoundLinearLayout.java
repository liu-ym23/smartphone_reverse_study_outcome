package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0014J\u0006\u0010\u000e\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/MeasureDetectLKUIRoundLinearLayout;", "Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "measureTimes", BuildConfig.FLAVOR, "onMeasure", BuildConfig.FLAVOR, "widthMeasureSpec", "heightMeasureSpec", "getMeasureTimes", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MeasureDetectLKUIRoundLinearLayout extends LKUIRoundLinearLayout {
    public int r;

    public final int getMeasureTimes() {
        return this.r;
    }

    public MeasureDetectLKUIRoundLinearLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public MeasureDetectLKUIRoundLinearLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int r1, int r2) {
        super/*android.widget.LinearLayout*/.onMeasure(r1, r2);
        this.r++;
    }
}
