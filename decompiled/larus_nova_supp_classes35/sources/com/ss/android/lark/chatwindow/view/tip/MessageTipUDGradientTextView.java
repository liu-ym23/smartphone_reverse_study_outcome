package com.ss.android.lark.chatwindow.view.tip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.gradient.UDGradientDrawableKt;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/tip/MessageTipUDGradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gradient", "Lcom/larksuite/component/universe_design/gradient/UDGradientDrawable;", "boundsRect", "Landroid/graphics/Rect;", "onDraw", BuildConfig.FLAVOR, "canvas", "Landroid/graphics/Canvas;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageTipUDGradientTextView extends AppCompatTextView {
    public final com.larksuite.component.universe_design.gradient.a a;
    public final Rect b;

    public MessageTipUDGradientTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MessageTipUDGradientTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        this.b.set(0, 0, getWidth(), getHeight());
        com.larksuite.component.universe_design.gradient.a r0 = this.a;
        Rect r1 = this.b;
        r0.setBounds(r1);
        int r2 = r10.saveLayer(r1.left, r1.top, r1.right, r1.bottom, null);
        super/*android.widget.TextView*/.onDraw(r10);
        r0.b((PorterDuffXfermode) UDGradientDrawableKt.a.getValue());
        r0.draw(r10);
        r10.restoreToCount(r2);
        r0.b(null);
    }

    public MessageTipUDGradientTextView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        int r7 = com.larksuite.component.universe_design.gradient.b.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        com.larksuite.component.universe_design.gradient.a r8 = new com.larksuite.component.universe_design.gradient.a(ArraysKt.toIntArray(new Integer[]{Integer.valueOf(UDColorUtils.getColor(r4, 2131100156)), Integer.valueOf(UDColorUtils.getColor(r4, 2131100157)), Integer.valueOf(UDColorUtils.getColor(r4, 2131100157)), Integer.valueOf(UDColorUtils.getColor(r4, 2131100156))}));
        r8.mutate();
        this.a = r8;
        this.b = new Rect();
    }

    public /* synthetic */ MessageTipUDGradientTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
