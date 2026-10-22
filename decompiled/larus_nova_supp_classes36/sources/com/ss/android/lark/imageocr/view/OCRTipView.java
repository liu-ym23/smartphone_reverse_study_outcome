package com.ss.android.lark.imageocr.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010#\u001a\u00020$H\u0002J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001c\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b \u0010!¨\u0006("}, d2 = {"Lcom/ss/android/lark/imageocr/view/OCRTipView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "kvRepo", "Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "getKvRepo", "()Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "kvRepo$delegate", "Lkotlin/Lazy;", "tipView", "Landroid/widget/ImageView;", "clickTipDrawable", "Landroid/graphics/drawable/Drawable;", "getClickTipDrawable", "()Landroid/graphics/drawable/Drawable;", "clickTipDrawable$delegate", "twoFingerTipDrawable", "getTwoFingerTipDrawable", "twoFingerTipDrawable$delegate", "tipTxt", "Landroid/widget/TextView;", "getTipTxt", "()Landroid/widget/TextView;", "tipTxt$delegate", "initView", "", "showClickTipIfNeed", "showTwoFingerTipIfNeed", "Companion", "imageocr_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OCRTipView extends LinearLayout {
    public final Activity a;
    public final Lazy b;
    public final ImageView c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ OCRTipView a;

        public a(OCRTipView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.a.getVisibility() != 0) goto L6;
            this.a.setVisibility(8);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    private final Drawable getClickTipDrawable() {
        return (Drawable) this.d.getValue();
    }

    private final KVRepo getKvRepo() {
        return (KVRepo) this.b.getValue();
    }

    private final TextView getTipTxt() {
        return (TextView) this.f.getValue();
    }

    private final Drawable getTwoFingerTipDrawable() {
        return (Drawable) this.e.getValue();
    }

    public final void a() {
        Log.i("OCRTipView", "showClickTipIfNeed");
        if (getKvRepo().getBoolean("KEY_HAS_SHOW_CLICK_TIP", false) == true) goto L6;
        getKvRepo().putBoolean("KEY_HAS_SHOW_CLICK_TIP", true);
        setVisibility(0);
        this.c.setImageDrawable(getClickTipDrawable());
        getTipTxt().setText(UIUtils.getString(this.a, 2131891175));
        return;
    }

    public final void b() {
        Log.i("OCRTipView", "showTwoFingerTipIfNeed");
        if (getKvRepo().getBoolean("KEY_HAS_SHOW_TWO_FINGER_TIP", false) == true) goto L6;
        getKvRepo().putBoolean("KEY_HAS_SHOW_TWO_FINGER_TIP", true);
        setVisibility(0);
        this.c.setImageDrawable(getTwoFingerTipDrawable());
        getTipTxt().setText(UIUtils.getString(this.a, 2131891174));
        return;
    }

    public OCRTipView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public OCRTipView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public OCRTipView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        Context r6 = getContext();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.app.Activity");
        Activity r7 = (Activity) r6;
        this.a = r7;
        this.b = LazyKt.lazy(OCRTipView$kvRepo$2.INSTANCE);
        ImageView r8 = new ImageView(getContext());
        this.c = r8;
        this.d = LazyKt.lazy(new OCRTipView$clickTipDrawable$2(this));
        this.e = LazyKt.lazy(new OCRTipView$twoFingerTipDrawable$2(this));
        this.f = LazyKt.lazy(new OCRTipView$tipTxt$2(this));
        setOrientation(1);
        setVisibility(8);
        setBackgroundColor(UIUtils.getColor(getContext(), 2131106513));
        setHorizontalGravity(17);
        setVerticalGravity(17);
        setOnClickListener(new a(this));
        removeAllViews();
        addView(r8, new LinearLayout.LayoutParams(UIUtils.dp2px(r7, 90.0f), UIUtils.dp2px(r7, 90.0f)));
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-2, -2);
        r9.topMargin = UIUtils.dp2px(r7, 18.0f);
        addView(getTipTxt(), r9);
    }
}
