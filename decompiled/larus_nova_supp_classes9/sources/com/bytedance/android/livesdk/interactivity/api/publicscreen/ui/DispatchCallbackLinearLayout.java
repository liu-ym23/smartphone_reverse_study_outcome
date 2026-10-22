package com.bytedance.android.livesdk.interactivity.api.publicscreen.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import g52.a;
import g52.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/ui/DispatchCallbackLinearLayout;", "Landroid/widget/LinearLayout;", "Lg52/a;", "Lg52/b;", "a", "Lg52/b;", "getDispatchCallback", "()Lg52/b;", "setDispatchCallback", "(Lg52/b;)V", "dispatchCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DispatchCallbackLinearLayout extends LinearLayout implements a {
    public b a;

    public b getDispatchCallback() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        b r0 = getDispatchCallback();
        if (r0 == null) goto L6;
        r0.c(r2);
    L6:
        return super.dispatchTouchEvent(r2);
    }

    @Override // g52.a
    public void setDispatchCallback(b r1) {
        this.a = r1;
    }

    public DispatchCallbackLinearLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
