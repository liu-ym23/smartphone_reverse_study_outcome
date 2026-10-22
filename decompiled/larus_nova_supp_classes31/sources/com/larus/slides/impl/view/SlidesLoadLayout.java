package com.larus.slides.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vm9.b;
import vm9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\tH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/slides/impl/view/SlidesLoadLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "Lcom/larus/office/base/page/IHostLoadingAndErrorLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnRetryListener", "Lcom/larus/office/base/page/OnRetryListener;", "init", "", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "fail", "errCode", "message", "", "getView", "showStatusViewWithNewErrorOpt", "setOnRetryListener", "listener", "loading", "hide", "isDocDeleteError", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesLoadLayout extends FrameLayout implements View.OnTouchListener, b {
    public static final /* synthetic */ int b = 0;
    public e a;

    public static final class a {
    }

    static {
    }

    public SlidesLoadLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SlidesLoadLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void b() {
        setVisibility(0);
        FLogger.a.d("SlidesLoadLayout", "final loading");
        findViewById(2131386901).setVisibility(0);
        findViewById(2131386897).setVisibility(8);
        setOnClickListener(null);
    }

    public View getView() {
        return this;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Intrinsics.checkNotNullParameter(r3, "event");
        return true;
    }

    public final void hide() {
        setVisibility(8);
        FLogger.a.d("SlidesLoadLayout", "final hide");
    }

    public void setOnRetryListener(e r1) {
        this.a = r1;
    }

    public final void a(final int r6, String r7) {
        boolean r0 = false;
        setVisibility(0);
        View r1 = findViewById(2131386901);
        if (r1 == null) goto L5;
        r1.setVisibility(8);
    L5:
        FLogger.a.i("SlidesLoadLayout", "Slides load failed: errCode=" + r6 + ", message=" + r7 + ", loading=" + r1);
        findViewById(2131386897).setVisibility(0);
        ImageView r8 = (ImageView) findViewById(2131386898);
        TextView r2 = (TextView) findViewById(2131386899);
        if (r6 != (-55)) goto L8;
        r0 = true;
    L8:
        if (r0 == false) goto L10;
        r8.setImageResource(2131243115);
        r2.setText(2131909867);
        r2.setTextColor(getContext().getResources().getColor(2131103143));
        return;
    L10:
        r8.setImageResource(2131243118);
        r2.setText(2131899634);
        r2.setTextColor(getContext().getResources().getColor(2131103136));
        findViewById(2131386900).setOnClickListener(new yw9.a(this, r6));
    }

    public SlidesLoadLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        FrameLayout.inflate(getContext(), 2131563140, this);
        b();
    }

    public /* synthetic */ SlidesLoadLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r3 & 4) == 0) goto L8;
        int r5 = -1;
    L9:
        this(r1, r2, r5);
        return;
    L8:
        r5 = 0;
        goto L9
    }
}
