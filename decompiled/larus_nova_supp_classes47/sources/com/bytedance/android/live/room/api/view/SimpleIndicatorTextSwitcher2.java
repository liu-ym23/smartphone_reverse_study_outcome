package com.bytedance.android.live.room.api.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.Metadata;
import p81.d;
import p81.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/room/api/view/SimpleIndicatorTextSwitcher2;", "Landroid/widget/TextSwitcher;", "", "c", "I", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "currentIndex", "e", "getMeasureMaxWidth", "setMeasureMaxWidth", "measureMaxWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleIndicatorTextSwitcher2 extends TextSwitcher {
    public e a;
    public final ArrayList<d> b;
    public int c;
    public Disposable d;
    public int e;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Disposable r0 = this.d;
        if (r0 != null) goto L5;
    L10:
        Animation r1 = getInAnimation();
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        Animation r2 = getOutAnimation();
        if (r2 == null) goto L16;
        r2.cancel();
    L16:
        super.onDetachedFromWindow();
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    public final int getCurrentIndex() {
        return this.c;
    }

    public final int getMeasureMaxWidth() {
        return this.e;
    }

    public final void setCurrentIndex(int r1) {
        this.c = r1;
    }

    public final void setMeasureMaxWidth(int r1) {
        this.e = r1;
    }

    public SimpleIndicatorTextSwitcher2(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new e();
        this.b = new ArrayList();
        this.e = -1;
        setInAnimation(AnimationUtils.loadAnimation(getContext(), 2130772001));
        setOutAnimation(AnimationUtils.loadAnimation(getContext(), 2130772002));
    }
}
