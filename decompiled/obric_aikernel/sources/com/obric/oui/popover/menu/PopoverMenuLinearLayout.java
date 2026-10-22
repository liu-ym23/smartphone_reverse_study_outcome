package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u00011B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020!¢\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cRT\u0010)\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110!¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00062"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "Landroid/widget/LinearLayout;", "", "pressed", "", "setPressed", "", "c", "F", "getPressedCornerRadius", "()F", "setPressedCornerRadius", "(F)V", "pressedCornerRadius", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "g", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "getIndexPos", "()Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "setIndexPos", "(Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;)V", "indexPos", EventBody.KEY_VALUE, "j", "Z", "getForceDark", "()Z", "setForceDark", "(Z)V", "forceDark", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "", "pressedColor", "h", "Lkotlin/jvm/functions/Function2;", "getNotifyPressedCallback", "()Lkotlin/jvm/functions/Function2;", "setNotifyPressedCallback", "(Lkotlin/jvm/functions/Function2;)V", "notifyPressedCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Index", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class PopoverMenuLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f7157c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Index f7158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Function2<? super Boolean, ? super Integer, Unit> f7159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7161j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST", "LAST", "OTHER", "ONLY_ONE", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Index extends Enum<Index> {
        private static final /* synthetic */ Index[] $VALUES = null;
        public static final Index FIRST = null;
        public static final Index LAST = null;
        public static final Index ONLY_ONE = null;
        public static final Index OTHER = null;

        static {
            Index r10 = new Index("FIRST", 0);
            FIRST = r10;
            Index r11 = new Index("LAST", 1);
            LAST = r11;
            Index r12 = new Index("OTHER", 2);
            OTHER = r12;
            Index r13 = new Index("ONLY_ONE", 3);
            ONLY_ONE = r13;
            $VALUES = new Index[]{r10, r11, r12, r13};
        }

        private Index(String r10, int r11) {
            super(r10, r11);
        }

        public static Index valueOf(String r10) {
            return (Index) Enum.valueOf(Index.class, r10);
        }

        public static Index[] values() {
            return (Index[]) $VALUES.clone();
        }
    }

    @JvmOverloads
    public PopoverMenuLinearLayout(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public PopoverMenuLinearLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public PopoverMenuLinearLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        this.f7157c = TypedValue.applyDimension(1, 20, r13.getDisplayMetrics());
        this.f7158g = Index.OTHER;
        this.f7160i = ContextCompat.getColor(r10, c.oui_state_overlay_pressed);
    }

    public /* synthetic */ PopoverMenuLinearLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final boolean getForceDark() {
        return this.f7161j;
    }

    public final Index getIndexPos() {
        return this.f7158g;
    }

    public final Function2<Boolean, Integer, Unit> getNotifyPressedCallback() {
        return this.f7159h;
    }

    public final float getPressedCornerRadius() {
        return this.f7157c;
    }

    public final void setForceDark(boolean r10) {
        if (r10 == false) goto L4;
        int r11 = Color.parseColor("#FF45474F");
    L5:
        this.f7160i = r11;
        this.f7161j = r10;
        return;
    L4:
        r11 = ContextCompat.getColor(getContext(), c.oui_state_overlay_pressed);
        goto L5
    }

    public final void setIndexPos(Index r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7158g = r10;
    }

    public final void setNotifyPressedCallback(Function2<? super Boolean, ? super Integer, Unit> r10) {
        this.f7159h = r10;
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        super.setPressed(r10);
        Function2<? super Boolean, ? super Integer, Unit> r11 = this.f7159h;
        if (r11 == null) goto L6;
        Unit r12 = r11.invoke(Boolean.valueOf(r10), Integer.valueOf(this.f7160i));
    L6:
        if (r10 == false) goto L8;
        GradientDrawable r13 = new GradientDrawable();
        r13.setColor(this.f7160i);
        float r14 = this.f7157c;
        r13.setCornerRadii(new float[]{r14, r14, r14, r14, r14, r14, r14, r14});
        Unit r15 = Unit.INSTANCE;
        setBackground(r13);
        return;
    L8:
        setBackgroundColor(0);
    }

    public final void setPressedCornerRadius(float r10) {
        this.f7157c = r10;
    }
}
