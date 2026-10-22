package com.ss.android.lark.imageocr.view;

import android.app.Activity;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.imageocr.ImageOCRKit;
import com.ss.android.lark.imageocr.select.SelectTextView;
import com.ss.android.lark.log.Log;
import klb.c;
import klb.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001 B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/ss/android/lark/imageocr/view/OCRPickTextView;", "Lcom/ss/android/lark/imageocr/select/SelectTextView;", "Lcom/ss/android/lark/imageocr/span/OCRPhoneSpan$IPhoneSpanClickListener;", "Lcom/ss/android/lark/imageocr/span/OCRUrlSpan$IUrlSpanClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "isLongPress", "", "setOnLongClickListener", "", "listener", "Landroid/view/View$OnLongClickListener;", "onPhoneClick", "view", "Landroid/view/View;", "phone", "", "onUrlClick", "url", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "imageocr_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OCRPickTextView extends SelectTextView implements c.a, e.b {
    public boolean h;

    public static final class a {
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ OCRPickTextView a;
        public final /* synthetic */ View.OnLongClickListener b;

        public b(OCRPickTextView r1, View.OnLongClickListener r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            this.a.h = true;
            return this.b.onLongClick(r3);
        }
    }

    static {
    }

    public OCRPickTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // com.ss.android.lark.imageocr.select.SelectTextView, android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        if (r3 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        this.h = false;
    L11:
        return super.onTouchEvent(r3);
    L5:
        if (r3.getAction() != 0) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r2) {
        if (r2 == null) goto L5;
        super.setOnLongClickListener(new b(this, r2));
        return;
    }

    public OCRPickTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // klb.c.a
    public final void a(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "phone");
        if (this.h == false) goto L5;
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L12;
        Log.i("OCRPickTextView", "onPhoneClick");
        ImageOCRKit.a().b();
        return;
    L12:
        return;
    L7:
        r4 = false;
        goto L8
    }

    @Override // klb.e.b
    public final void b(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "url");
        if (this.h == false) goto L5;
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L12;
        Log.i("OCRPickTextView", "onUrlClick");
        ImageOCRKit.a().a();
        return;
    L12:
        return;
    L7:
        r4 = false;
        goto L8
    }

    public OCRPickTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Context r5 = getContext();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.app.Activity");
        Activity r6 = (Activity) r5;
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(0);
    }
}
