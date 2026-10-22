package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003@ABB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0002J(\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0018\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0002J0\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0017H\u0002J\u0018\u00105\u001a\u0002022\u0006\u00106\u001a\u0002022\u0006\u0010.\u001a\u000207H\u0002J \u00108\u001a\u00020\u001e2\u0006\u00106\u001a\u0002022\u0006\u0010.\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0017H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020;H\u0014J\u0010\u0010<\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010>J\b\u0010?\u001a\u00020 H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/fields/UserFieldsView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textPaint", "Landroid/text/TextPaint;", "dividerPaint", "Landroid/graphics/Paint;", "getDividerPaint", "()Landroid/graphics/Paint;", "dividerPaint$delegate", "Lkotlin/Lazy;", "elements", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/fields/UserFieldsView$Element;", "Lkotlin/collections/ArrayList;", "dividerWidth", BuildConfig.FLAVOR, "dividerHeight", "dividerMargin", "maxWidth", Keys.API_RETURN_KEY_DATA, "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/fields/UserFields;", "setUserFields", BuildConfig.FLAVOR, "hasContent", BuildConfig.FLAVOR, "getCurrentFields", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "calcDefaultSize", "size", "measureSpec", "onSizeChanged", SRStrategy.MEDIAINFO_KEY_WIDTH, "h", "oldw", "oldh", "updateElements", "width", "height", "addTwoTextElement", "first", BuildConfig.FLAVOR, "second", "textBaseline", "ellipseText", "text", BuildConfig.FLAVOR, "addSingleTextElement", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateTheme", "themeType", "Lcom/ss/android/lark/chat/entity/theme/TitleTheme$ThemeType;", "isChatTitleLeftAlignEnable", "Element", "TextElement", "DividerElement", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserFieldsView extends View {
    public final TextPaint a;
    public final Lazy b;
    public final ArrayList<b> c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c h;

    public final class a implements b {
        public final float a;
        public final float b;
        public final float c;
        public final float d;
        public final /* synthetic */ UserFieldsView e;

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.UserFieldsView.b
        public final void draw(Canvas r8) {
            Intrinsics.checkNotNullParameter(r8, "canvas");
            r8.drawRect(this.a, this.b, this.c, this.d, UserFieldsView.a(this.e));
        }

        public a(UserFieldsView r2, float r3, float r4) {
            this.e = r2;
            this.a = r3;
            this.b = r4;
            this.c = r3 + r2.d;
            this.d = r4 + r2.e;
        }
    }

    public interface b {
        void draw(Canvas r1);
    }

    public final class c implements b {
        public final String a;
        public final float b;
        public final float c;
        public final /* synthetic */ UserFieldsView d;

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.UserFieldsView.b
        public final void draw(Canvas r5) {
            Intrinsics.checkNotNullParameter(r5, "canvas");
            r5.drawText(this.a, this.b, this.c, this.d.a);
        }

        public c(UserFieldsView r2, String r3, float r4, float r5) {
            Intrinsics.checkNotNullParameter(r3, "text");
            this.d = r2;
            this.a = r3;
            this.b = r4;
            this.c = r5;
        }
    }

    public UserFieldsView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public UserFieldsView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Paint getDividerPaint() {
        return (Paint) this.b.getValue();
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c getCurrentFields() {
        return this.h;
    }

    public static final /* synthetic */ Paint a(UserFieldsView r0) {
        return r0.getDividerPaint();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).draw(r3);
        goto L4
    }

    public final void setUserFields(com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c r2) {
        this.h = r2;
        int r3 = getWidth();
        int r0 = getHeight();
        if (r3 <= 0) goto L6;
        if (r0 <= 0) goto L6;
        d(r3, r0);
    L6:
        requestLayout();
    }

    public final String c(String r3, Number r4) {
        return TextUtils.ellipsize(r3, this.a, r4.floatValue(), TextUtils.TruncateAt.END).toString();
    }

    public final void d(int r19, int r20) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c r2 = this.h;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.d;
    L6:
        if (r2 == null) goto L8;
        r3 = r2.e;
    L8:
        this.c.clear();
        Paint.FontMetrics r5 = this.a.getFontMetrics();
        float r6 = r20;
        float r7 = r5.bottom;
        float r8 = r5.top;
        float r9 = ((r6 - (r7 - r8)) / 2.0f) - r8;
        if (r4 == null) goto L13;
        if (r3 != null) goto L13;
        b(r4, r19, r9);
        return;
    L13:
        if (r4 != null) goto L17;
        if (r3 == null) goto L17;
        b(r3, r19, r9);
        return;
    L17:
        if (r4 == null) goto L52;
        if (r3 == null) goto L53;
        float r10 = this.a.measureText(r4);
        float r11 = this.a.measureText(r3);
        float r1 = r19;
        float r12 = this.d;
        float r13 = this.f;
        float r14 = ((r1 - r12) / 2.0f) - r13;
        float r15 = (r6 - this.e) / 2.0f;
        float r16 = 0.0f;
        if (r10 <= r14) goto L30;
        if (r11 >= r14) goto L30;
        float r17 = r1 - r11;
        float r18 = (r17 - r12) - (2 * r13);
        String r21 = c(r4, Float.valueOf(r18));
        float r22 = r18 - this.a.measureText(r21);
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.chat.header_left_title") == true) goto L26;
    L28:
        this.c.add(new a(this, ((r17 - this.d) - this.f) - r16, r15));
        this.c.add(new c(this, r21, r22 - r16, r9));
        this.c.add(new c(this, r3, r17 - r16, r9));
        return;
    L26:
        if (r22 <= 0.0f) goto L28;
        r16 = r22;
    L30:
        if (r10 < r14) goto L32;
    L34:
        float r23 = r1 / 2.0f;
        float r110 = r13 + r23;
        if (r10 > r14) goto L37;
    L44:
        if (r10 <= r14) goto L46;
        return;
    L46:
        if (r11 <= r14) goto L48;
        return;
    L48:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.chat.header_left_title") == false) goto L50;
        r16 = (r23 - this.f) - r10;
    L50:
        this.c.add(new a(this, (r14 + this.f) - r16, r15));
        this.c.add(new c(this, r4, ((r23 - this.f) - r10) - r16, r9));
        this.c.add(new c(this, r3, r110 - r16, r9));
        return;
    L37:
        if (r11 <= r14) goto L44;
        String r24 = c(r4, Float.valueOf(r14));
        float r25 = r14 - this.a.measureText(r24);
        String r26 = c(r3, Float.valueOf(r14));
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.chat.header_left_title") == true) goto L41;
    L43:
        this.c.add(new a(this, (r14 + this.f) - r16, r15));
        this.c.add(new c(this, r24, r25 - r16, r9));
        this.c.add(new c(this, r26, r110 - r16, r9));
        return;
    L41:
        if (r25 <= 0.0f) goto L43;
        r16 = r25;
        goto L43
    L32:
        if (r11 <= r14) goto L34;
        float r27 = (r12 + r10) + (2 * r13);
        this.c.add(new a(this, r10 + r13, r15));
        this.c.add(new c(this, r4, 0.0f, r9));
        this.c.add(new c(this, c(r3, Float.valueOf(r1 - r27)), r27, r9));
        return;
    L53:
        return;
    L52:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r6, int r7) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c r0 = this.h;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.d;
    L6:
        if (r0 == null) goto L8;
        r1 = r0.e;
    L8:
        float r3 = 0.0f;
        if (r2 == null) goto L11;
        float r4 = this.a.measureText(r2);
    L12:
        if (r1 == null) goto L14;
        float r5 = this.a.measureText(r1);
    L15:
        float r8 = r4 + r5;
        if (r8 <= 0.0f) goto L18;
        float r9 = RangesKt.coerceAtMost((r8 + (2 * this.f)) + this.d, this.g);
    L20:
        if (r9 <= 0.0f) goto L22;
        r3 = this.a.getFontMetrics().bottom - this.a.getFontMetrics().top;
    L22:
        int r10 = MathKt.roundToInt(r9);
        int r11 = View.MeasureSpec.getMode(r6);
        int r12 = View.MeasureSpec.getSize(r6);
        if (r11 == Integer.MIN_VALUE) goto L27;
        if (r11 != 1073741824) goto L28;
        r10 = r12;
    L28:
        int r13 = MathKt.roundToInt(r3);
        int r14 = View.MeasureSpec.getMode(r7);
        int r15 = View.MeasureSpec.getSize(r7);
        if (r14 == Integer.MIN_VALUE) goto L33;
        if (r14 != 1073741824) goto L34;
        r13 = r15;
    L34:
        setMeasuredDimension(r10, r13);
        return;
    L33:
        r13 = Math.min(r13, r15);
        goto L34
    L27:
        r10 = Math.min(r10, r12);
        goto L28
    L18:
        r9 = 0.0f;
        goto L20
    L14:
        r5 = 0.0f;
        goto L15
    L11:
        r4 = 0.0f;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public UserFieldsView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        TextPaint r5 = new TextPaint(1);
        this.a = r5;
        this.b = LazyKt.lazy(new UserFieldsView$dividerPaint$2(r2));
        this.c = new ArrayList();
        this.d = y9c.d.b(r2, 1.0f);
        this.e = y9c.d.b(r2, 10.0f);
        this.f = y9c.d.b(r2, 4.0f);
        this.g = y9c.d.b(r2, 175.0f);
        r5.setTextSize(y9c.d.b(r2, 10.0f));
        r5.setColor(y9c.d.c(r2, 2131106620));
    }

    public final void b(String r5, int r6, float r7) {
        float r0 = this.a.measureText(r5);
        float r1 = r6;
        float r2 = 0.0f;
        if (r0 <= r1) goto L6;
        c r3 = new c(this, c(r5, Integer.valueOf(r6)), 0.0f, r7);
    L10:
        this.c.add(r3);
        return;
    L6:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.chat.header_left_title") == true) goto L9;
        r2 = (r1 - r0) / 2.0f;
    L9:
        r3 = new c(this, r5, r2, r7);
        goto L10
    }

    public /* synthetic */ UserFieldsView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        d(r1, r2);
    }
}
