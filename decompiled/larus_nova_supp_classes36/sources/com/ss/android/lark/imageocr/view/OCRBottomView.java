package com.ss.android.lark.imageocr.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.imagewidget.ImageWidgetFG;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0003'()B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0015J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0014J\b\u0010\u001c\u001a\u00020\u0015H\u0002J \u0010\u001d\u001a\u00020\u00152\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!H\u0002J.\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020 2\b\b\u0001\u0010$\u001a\u00020\n2\b\b\u0001\u0010%\u001a\u00020\n2\b\b\u0001\u0010&\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/imageocr/view/OCRBottomView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "marginPad", "screenWidth", "marginBase", "margin", "getMargin", "()I", "itemListener", "Lcom/ss/android/lark/imageocr/view/OCRBottomView$IBottomItemListener;", "initView", "", "setItemListener", "showAllMode", "showSelectMode", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateBtnMargin", "updateBottomList", "bottomList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/imageocr/view/OCRBottomView$BottomItemBean;", "Lkotlin/collections/ArrayList;", "updateOneBottom", "item", "layoutId", "iconId", "txtId", "Companion", "BottomItemBean", "IBottomItemListener", "imageocr_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OCRBottomView extends FrameLayout {
    public final int a;
    public final int b;
    public final int c;
    public c d;

    public static final class a {
        public final int a;
        public final int b;
        public final int c;

        public a(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b {
    }

    public interface c {
        void h(int r1);
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ OCRBottomView b;

        public d(a r1, OCRBottomView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Log.i("OCRBottomView", "bottom item click:" + this.a.a);
            c r3 = this.b.d;
            if (r3 == null) goto L6;
            r3.h(this.a.a);
            return;
        }
    }

    static {
    }

    public final void a() {
        Log.i("OCRBottomView", "showAllMode");
        setVisibility(0);
        b(CollectionsKt.arrayListOf(new a[]{new a(1, 2131254165, 2131891161), new a(2, 2131254801, 2131891170), new a(3, 2131254206, 2131891164)}));
    }

    private final int getMargin() {
        if (DeviceUtils.isPad() == false) goto L6;
        return this.a;
    L6:
        if (ImageWidgetFG.a() == false) goto L12;
        int r0 = getMeasuredWidth();
        if (r0 > 0) goto L14;
        r0 = this.b;
        Log.e("OCRBottomView", "getMargin, use screenWidth: " + r0);
    L14:
        return (r0 - this.c) / 3;
    L12:
        return (this.b - this.c) / 3;
    }

    public OCRBottomView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void b(ArrayList<a> r5) {
        c((a) ListProtector.get(r5, 0), 2131381286, 2131381285, 2131381287);
        c((a) ListProtector.get(r5, 1), 2131381289, 2131381288, 2131381290);
        c((a) ListProtector.get(r5, 2), 2131381292, 2131381291, 2131381293);
    }

    public final void setItemListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "itemListener");
        this.d = r2;
    }

    public OCRBottomView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        ViewGroup.LayoutParams r4 = findViewById(2131381286).getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int r0 = getMargin();
        ((ViewGroup.MarginLayoutParams) r4).rightMargin = r0;
        ViewGroup.LayoutParams r5 = findViewById(2131381289).getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int r6 = getMargin();
        ((ViewGroup.MarginLayoutParams) r5).rightMargin = r6;
    }

    public OCRBottomView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = UIUtils.getDimens(getContext(), 2131167862);
        this.b = UIHelper.getWindowWidth(getContext());
        this.c = UIUtils.dp2px(getContext(), 200.0f);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(2131561531, this, true);
    }

    public final void c(a r2, int r3, int r4, int r5) {
        View r6 = findViewById(r3);
        ImageView r7 = (ImageView) findViewById(r4);
        TextView r8 = (TextView) findViewById(r5);
        r7.setImageResource(r2.b);
        r8.setText(r2.c);
        r6.setOnClickListener(new d(r2, this));
    }
}
