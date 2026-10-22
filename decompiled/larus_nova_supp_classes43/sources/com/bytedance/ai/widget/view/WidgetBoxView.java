package com.bytedance.ai.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.utils.h;
import com.bytedance.ai.utils.i;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0003?@AB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020!H\u0002J \u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\fJ\u0010\u0010-\u001a\u00020!2\b\u0010.\u001a\u0004\u0018\u00010\u0017J\b\u0010/\u001a\u0004\u0018\u00010\u0017J\u0010\u00100\u001a\u00020!2\b\u00101\u001a\u0004\u0018\u00010\u0019J\u0010\u00102\u001a\u00020!2\u0006\u00103\u001a\u000204H\u0014J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u00109\u001a\u0004\u0018\u00010:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010=\u001a\u0004\u0018\u00010:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010<¨\u0006B"}, d2 = {"Lcom/bytedance/ai/widget/view/WidgetBoxView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ai/utils/IMotionProvider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "titleBar", "Landroid/view/View;", "divider", "appIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", BdpAwemeConstant.KEY_APP_NAME, "Landroid/widget/TextView;", "floatTitleBar", "floatAppIcon", "floatAppName", "contentView", "debugOverlayDrawable", "Landroid/graphics/drawable/Drawable;", "touchEventCallback", "Lcom/bytedance/ai/widget/view/WidgetBoxView$TouchEventCallback;", "longPressController", "Lcom/bytedance/ai/utils/IWidgetLongPressController;", "getLongPressController", "()Lcom/bytedance/ai/utils/IWidgetLongPressController;", "setLongPressController", "(Lcom/bytedance/ai/utils/IWidgetLongPressController;)V", "setBorder", "", "backgroundColor", "strokeColor", "applyTheme", "setTitleBar", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "iconUrl", "titleType", "Lcom/bytedance/ai/widget/view/WidgetBoxView$TitleType;", "setContent", "view", "setDebugOverlay", "drawable", "getDebugOverlay", "listenTouchEvent", "callback", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "lastMotionX", "", "getLastMotionX", "()Ljava/lang/Float;", "lastMotionY", "getLastMotionY", "TouchEventCallback", "TitleType", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetBoxView extends LinearLayout implements h {
    public static final float l = 0.0f;
    public static final int m = 0;
    public final View a;
    public final View b;
    public final SimpleDraweeView c;
    public final TextView d;
    public final View e;
    public final SimpleDraweeView f;
    public final TextView g;
    public final LinearLayout h;
    public Drawable i;
    public b j;
    public i k;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/widget/view/WidgetBoxView$TitleType;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "FLOAT", "NONE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TitleType extends Enum<TitleType> {
        public static final TitleType FLOAT = null;
        public static final TitleType NONE = null;
        public static final TitleType NORMAL = null;
        public static final /* synthetic */ TitleType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<TitleType> getEntries() {
            return b;
        }

        static {
            TitleType r0 = new TitleType("NORMAL", 0, 0);
            NORMAL = r0;
            TitleType r1 = new TitleType("FLOAT", 1, 1);
            FLOAT = r1;
            TitleType r10 = new TitleType("NONE", 2, 2);
            NONE = r10;
            TitleType[] r11 = {r0, r1, r10};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static TitleType[] values() {
            return (TitleType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static TitleType valueOf(String r1) {
            return (TitleType) r27.a.a(TitleType.class, r1);
        }

        public TitleType(String r1, int r10, int r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    public static final class a {
    }

    public interface b {
        boolean onTouchEvent(MotionEvent r1);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TitleType.values().length];
            r0[TitleType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[TitleType.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[TitleType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public WidgetBoxView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public WidgetBoxView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 4, 0);
    }

    static {
        l = n2.a.a(8);
        m = n2.a.a(1);
    }

    @Override // com.bytedance.ai.utils.h
    public Float getLastMotionX() {
        i r0 = this.k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLastMotionX();
    }

    @Override // com.bytedance.ai.utils.h
    public Float getLastMotionY() {
        i r0 = this.k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLastMotionY();
    }

    public final Drawable getDebugOverlay() {
        return this.i;
    }

    public final i getLongPressController() {
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.dispatchDraw(r10);
        Drawable r0 = this.i;
        if (r0 == null) goto L6;
        r0.setBounds(0, 0, getWidth(), getHeight());
        r0.draw(r10);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        b r0 = this.j;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r11 = false;
    L9:
        if (r11 == false) goto L12;
        MotionEvent r12 = MotionEvent.obtain(r10);
        r12.setAction(3);
        super.dispatchTouchEvent(r12);
        r12.recycle();
        return true;
    L12:
        i r13 = this.k;
        if (r13 != null) goto L15;
    L17:
        if (r1 == false) goto L21;
        MotionEvent r14 = MotionEvent.obtain(r10);
        r14.setAction(3);
        super.dispatchTouchEvent(r14);
        r14.recycle();
        return true;
    L21:
        return super.dispatchTouchEvent(r10);
    L15:
        if (r13.dispatchTouchEvent(r10) != true) goto L17;
        r1 = true;
        goto L17
    L5:
        if (r0.onTouchEvent(r10) != true) goto L7;
        r11 = true;
        goto L9
    }

    public final void setContent(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        this.h.addView(r10, -1, -2);
    }

    public final void setDebugOverlay(Drawable r10) {
        Drawable r0 = this.i;
        if (r0 != r10) goto L6;
        return;
    L6:
        if (r0 == null) goto L8;
        r0.setCallback(null);
    L8:
        if (r10 == null) goto L10;
        r10.setCallback(this);
    L11:
        this.i = r10;
        invalidate();
        return;
    L10:
        r10 = null;
        goto L11
    }

    public final void setLongPressController(i r1) {
        this.k = r1;
    }

    public WidgetBoxView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        LayoutInflater.from(r10).inflate(2131558719, this, true);
        setOrientation(1);
        this.a = findViewById(2131388807);
        this.b = findViewById(2131369197);
        this.c = findViewById(2131363092);
        this.d = (TextView) findViewById(2131363102);
        this.e = findViewById(2131372964);
        this.f = findViewById(2131372918);
        this.g = (TextView) findViewById(2131372919);
        this.h = (LinearLayout) findViewById(2131393192);
    }

    public /* synthetic */ WidgetBoxView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
