package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.bk1;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j40.o3;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0017\tB'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/common/AnchorPauseTipsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getLeaveViewRadiusPx", "getLayoutResource", "visibility", "", "setVisibility", "Lcom/bytedance/android/live/core/widget/HSImageView;", "b", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getWebpAnimView", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "setWebpAnimView", "(Lcom/bytedance/android/live/core/widget/HSImageView;)V", "webpAnimView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorPauseTipsView extends ConstraintLayout {
    public Map<Integer, View> a;
    public HSImageView b;
    public boolean c;
    public int d;

    public static final class a {
    }

    public static final class b extends ViewOutlineProvider {
        public final float a;

        public b(float r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r6, Outline r7) {
            Intrinsics.checkNotNullParameter(r6, "view");
            Intrinsics.checkNotNullParameter(r7, "outline");
            r7.setRoundRect(new Rect(r6.getPaddingLeft(), r6.getPaddingTop(), r6.getWidth() - r6.getPaddingRight(), r6.getHeight() - r6.getPaddingBottom()), this.a);
        }
    }

    static {
    }

    public AnchorPauseTipsView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorPauseTipsView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public int getLayoutResource() {
        return 2131565143;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getLeaveViewRadiusPx() {
        int r0 = this.d;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        return getMeasuredWidth() / 2;
    }

    public final void R5() {
        ((TextView) _$_findCachedViewById(2131388920)).setVisibility(8);
        ((TextView) _$_findCachedViewById(2131367861)).setVisibility(8);
    }

    public final HSImageView getWebpAnimView() {
        return this.b;
    }

    public final void S5(boolean r4) {
        ((TextView) _$_findCachedViewById(2131388920)).setVisibility(0);
        ((TextView) _$_findCachedViewById(2131367861)).setVisibility(0);
        if (r4 == false) goto L5;
        String r5 = s1.B(2131919212);
    L6:
        ((TextView) _$_findCachedViewById(2131388920)).setText(r5);
        return;
    L5:
        r5 = s1.B(2131919274);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int r6) {
        super/*android.view.ViewGroup*/.setVisibility(r6);
        if (r6 != 0) goto L48;
        StackTraceElement[] r7 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r7 != null) goto L7;
        return;
    L7:
        int r0 = r7.length;
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L13;
        if (Intrinsics.areEqual(r7[r2].getMethodName(), "setVisibility") == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        r1 = r2;
    L13:
        int r3 = r1 + 8;
    L15:
        if (r3 < r7.length) goto L17;
        r3 = r3 - 1;
        goto L15
    L17:
        int r4 = r7.length;
        if (r3 < 0) goto L52;
        if (r4 <= r3) goto L49;
        int r5 = r7.length;
        if (r1 < 0) goto L50;
        if (r5 <= r1) goto L53;
        StringBuilder r8 = new StringBuilder("anchor pause: ");
        if (r3 < r1) goto L37;
    L27:
        int r9 = r7.length;
        if (r3 < 0) goto L36;
        if (r9 <= r3) goto L47;
        r8.append(r7[r3].getFileName() + '.' + r7[r3].getMethodName());
        if (r3 == r1) goto L34;
        r8.append("-");
    L34:
        if (r3 == r1) goto L37;
        r3 = r3 - 1;
        goto L27
    L47:
        return;
    L36:
        return;
    L37:
        String r10 = r8.toString();
        if (r10 == null) goto L51;
        ALogger.d("AnchorPauseTipsView", r10);
        return;
    L51:
        return;
    L53:
        return;
    L50:
        return;
    L49:
        return;
    L52:
        return;
    }

    public final void setWebpAnimView(HSImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public static /* synthetic */ void U5(AnchorPauseTipsView r2, float r3) {
        r2.T5(2131251823, r3, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        if (this.c == false) goto L6;
        setOutlineProvider(new b(getLeaveViewRadiusPx()));
        setClipToOutline(true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorPauseTipsView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(getLayoutResource(), this, true);
        this.b = findViewById(2131362582);
        AbstractDraweeController r5 = Fresco.newDraweeControllerBuilder().setUri(((bk1) o3.a.getValue()).a).setAutoPlayAnimations(true).build();
        this.b.setController(r5);
        setClipToPadding(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void T5(int r2, float r3, boolean r4) {
        this.b.setActualImageResource(r2);
        int r5 = (int) UIUtils.dip2Px(getContext(), r3);
        this.b.setPadding(r5, r5, r5, r5);
        if (r4 == false) goto L6;
        setBackgroundColor(ColorProtector.parseColor("#7F000000"));
        return;
    }

    public /* synthetic */ AnchorPauseTipsView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
