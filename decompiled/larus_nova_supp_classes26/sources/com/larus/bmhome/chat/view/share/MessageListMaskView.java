package com.larus.bmhome.chat.view.share;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qo8.g;
import qo8.i;
import qo8.j;
import qo8.k;
import qo8.l;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0014J\u0010\u0010(\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001b\u0010\u000e\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0017\u0010\u0010R\u001b\u0010\u0019\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001a\u0010\u0010R\u001b\u0010\u001c\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001d\u0010\u0010R\u001b\u0010\u001f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b \u0010\u0010¨\u0006+"}, d2 = {"Lcom/larus/bmhome/chat/view/share/MessageListMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isImmersiveMode", "", "immersiveBgColor", "Ljava/lang/Integer;", "maxPicHeight", "getMaxPicHeight", "()I", "maxPicHeight$delegate", "Lkotlin/Lazy;", "maxDiff", "getMaxDiff", "maxDiff$delegate", "normalFooterHeight", "getNormalFooterHeight", "normalFooterHeight$delegate", "normalMessageListBottomMaskHeight", "getNormalMessageListBottomMaskHeight", "normalMessageListBottomMaskHeight$delegate", "immersiveFooterHeight", "getImmersiveFooterHeight", "immersiveFooterHeight$delegate", "immersiveMessageListBottomMaskHeight", "getImmersiveMessageListBottomMaskHeight", "immersiveMessageListBottomMaskHeight$delegate", "initParams", "", "(ZLjava/lang/Integer;)V", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawNormalMaskForMessageList", "drawImmersiveMaskForMessageList", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageListMaskView extends View {
    public static final /* synthetic */ int i = 0;
    public boolean a;
    public Integer b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public MessageListMaskView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MessageListMaskView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getImmersiveFooterHeight() {
        return ((Number) this.g.getValue()).intValue();
    }

    private final int getImmersiveMessageListBottomMaskHeight() {
        return ((Number) this.h.getValue()).intValue();
    }

    private final int getMaxDiff() {
        return ((Number) this.d.getValue()).intValue();
    }

    private final int getMaxPicHeight() {
        return ((Number) this.c.getValue()).intValue();
    }

    private final int getNormalFooterHeight() {
        return ((Number) this.e.getValue()).intValue();
    }

    private final int getNormalMessageListBottomMaskHeight() {
        return ((Number) this.f.getValue()).intValue();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r23) {
        Intrinsics.checkNotNullParameter(r23, "canvas");
        super.onDraw(r23);
        FLogger.a.d("MessageListMaskView", "onDraw: canvas.height = " + Integer.valueOf(r23.getHeight()) + ", canvas.width = " + Integer.valueOf(r23.getWidth()) + ", view.height = " + getHeight() + ", view.width = " + getWidth());
        if (r23.getHeight() >= getMaxPicHeight()) goto L7;
        if ((getMaxPicHeight() - r23.getHeight()) > getMaxDiff()) goto L7;
    L8:
        setVisibility(0);
        if (this.a == false) goto L17;
        int r4 = r23.getHeight() - getImmersiveFooterHeight();
        int r3 = r4 - getImmersiveMessageListBottomMaskHeight();
        if (r4 <= 0) goto L28;
        if (r3 <= 0) goto L29;
        if (r4 <= r3) goto L30;
        Integer r5 = this.b;
        if (r5 == null) goto L31;
        Intrinsics.checkNotNull(r5);
        int r12 = ColorUtils.setAlphaComponent(r5.intValue(), 255);
        Integer r6 = this.b;
        Intrinsics.checkNotNull(r6);
        LinearGradient r7 = new LinearGradient(0.0f, r4, 0.0f, r3, r12, ColorUtils.setAlphaComponent(r6.intValue(), 0), Shader.TileMode.CLAMP);
        Paint r8 = new Paint();
        r8.setShader(r7);
        r23.drawRect(new Rect(0, r3, r23.getWidth(), r4), r8);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L17:
        int r9 = r23.getHeight() - getNormalFooterHeight();
        int r10 = r9 - getNormalMessageListBottomMaskHeight();
        if (r9 <= 0) goto L33;
        if (r10 <= 0) goto L34;
        if (r9 <= r10) goto L35;
        boolean r11 = h.a;
        if (h.a(null) == false) goto L24;
        LinearGradient r13 = new LinearGradient(0.0f, r9, 0.0f, r10, ColorProtector.parseColor("#FF161616"), ColorProtector.parseColor("#00161616"), Shader.TileMode.CLAMP);
    L25:
        Paint r14 = new Paint();
        r14.setShader(r13);
        r23.drawRect(new Rect(0, r10, r23.getWidth(), r9), r14);
        return;
    L24:
        r13 = new LinearGradient(0.0f, r9, 0.0f, r10, ColorProtector.parseColor("#FFFFFFFF"), ColorProtector.parseColor("#00FFFFFF"), Shader.TileMode.CLAMP);
        goto L25
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L7:
        if (r23.getHeight() >= getMaxPicHeight()) goto L8;
        setVisibility(8);
    }

    public MessageListMaskView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = LazyKt.lazy(new g());
        this.d = LazyKt.lazy(new qo8.h());
        this.e = LazyKt.lazy(new i());
        this.f = LazyKt.lazy(new j());
        this.g = LazyKt.lazy(new k());
        this.h = LazyKt.lazy(new l());
    }

    public /* synthetic */ MessageListMaskView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
