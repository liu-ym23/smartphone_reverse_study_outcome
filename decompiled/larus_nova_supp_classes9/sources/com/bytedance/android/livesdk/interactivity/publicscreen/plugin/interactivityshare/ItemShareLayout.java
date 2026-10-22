package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.interactivityshare;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l;
import com.bytedance.bdlocation.BuildConfig;
import g52.a;
import g52.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/interactivityshare/ItemShareLayout;", "Landroid/widget/RelativeLayout;", "Lg52/a;", BuildConfig.FLAVOR, "color", BuildConfig.FLAVOR, "setTouchBackgroundColor", "Lg52/b;", "d", "Lg52/b;", "getDispatchCallback", "()Lg52/b;", "setDispatchCallback", "(Lg52/b;)V", "dispatchCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemShareLayout extends RelativeLayout implements a {
    public Map<Integer, View> a;
    public final RectF b;
    public final Paint c;
    public b d;

    public ItemShareLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ItemShareLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public b getDispatchCallback() {
        return this.d;
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
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

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        NoMoreSpaceTextView r0 = a(2131388367);
        Integer r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = Integer.valueOf(r0.getWidth());
    L6:
        float r3 = r2.intValue();
        LinearLayout r4 = (LinearLayout) a(2131386072);
        if (r4 == null) goto L9;
        r1 = Integer.valueOf(r4.getWidth());
    L9:
        this.b.set(0.0f, 0.0f, Math.max(r3, r1.intValue() + UtilityKotlinExtentionsKt.h(16)), getHeight());
        float r6 = 12;
        r5.drawRoundRect(this.b, UtilityKotlinExtentionsKt.h(r6), UtilityKotlinExtentionsKt.h(r6), this.c);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        NoMoreSpaceTextView r1 = a(2131388367);
        Integer r2 = null;
        if (r1 == null) goto L8;
        Integer r3 = Integer.valueOf(r1.getWidth());
    L9:
        float r4 = r3.intValue();
        LinearLayout r6 = (LinearLayout) a(2131386072);
        if (r6 == null) goto L13;
        r2 = Integer.valueOf(r6.getWidth());
    L13:
        if (r5.getX() <= Math.max(r4, r2.intValue() + UtilityKotlinExtentionsKt.h(16))) goto L16;
        return false;
    L16:
        return super.onTouchEvent(r5);
    L8:
        r3 = null;
        goto L9
    }

    @Override // g52.a
    public void setDispatchCallback(b r1) {
        this.d = r1;
    }

    public final void setTouchBackgroundColor(int r2) {
        this.c.setColor(r2);
        invalidate();
    }

    public ItemShareLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.b = new RectF();
        Paint r5 = new Paint();
        r5.setStyle(Paint.Style.FILL);
        r5.setAntiAlias(true);
        int r6 = l.a;
        r5.setColor(l.b);
        Unit r7 = Unit.INSTANCE;
        this.c = r5;
        setWillNotDraw(false);
    }

    public /* synthetic */ ItemShareLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
