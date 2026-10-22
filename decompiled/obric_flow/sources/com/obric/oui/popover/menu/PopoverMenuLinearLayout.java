package com.obric.oui.popover.menu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001:\u00019B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dRT\u0010)\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R*\u00108\u001a\u00020\n2\u0006\u00102\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u0010\u000e¨\u0006:"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "pressed", "", "setPressed", "(Z)V", "", "a", "F", "getPressedCornerRadius", "()F", "setPressedCornerRadius", "(F)V", "pressedCornerRadius", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "b", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "getIndexPos", "()Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "setIndexPos", "(Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;)V", "indexPos", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "pressedColor", "c", "Lkotlin/jvm/functions/Function2;", "getNotifyPressedCallback", "()Lkotlin/jvm/functions/Function2;", "setNotifyPressedCallback", "(Lkotlin/jvm/functions/Function2;)V", "notifyPressedCallback", "Landroid/graphics/drawable/GradientDrawable;", "d", "Landroid/graphics/drawable/GradientDrawable;", "getStateBackground", "()Landroid/graphics/drawable/GradientDrawable;", "setStateBackground", "(Landroid/graphics/drawable/GradientDrawable;)V", "stateBackground", "value", "f", "Z", "getForceDark", "()Z", "setForceDark", "forceDark", "Index", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PopoverMenuLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f14141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Index f14142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2 f14143c;
    public GradientDrawable d;
    public int e;
    public boolean f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "", "FIRST", "LAST", "OTHER", "ONLY_ONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Index extends Enum<Index> {
        public static final Index FIRST = null;
        public static final Index LAST = null;
        public static final Index ONLY_ONE = null;
        public static final Index OTHER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Index[] f14144a = null;

        static {
            Index r5 = new Index("FIRST", 0);
            FIRST = r5;
            Index r10 = new Index("LAST", 1);
            LAST = r10;
            Index r11 = new Index("OTHER", 2);
            OTHER = r11;
            Index r12 = new Index("ONLY_ONE", 3);
            ONLY_ONE = r12;
            f14144a = new Index[]{r5, r10, r11, r12};
        }

        public static Index valueOf(String r5) {
            return (Index) Enum.valueOf(Index.class, r5);
        }

        public static Index[] values() {
            return (Index[]) f14144a.clone();
        }
    }

    @JvmOverloads
    public PopoverMenuLinearLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final boolean getForceDark() {
        return this.f;
    }

    public final Index getIndexPos() {
        return this.f14142b;
    }

    public final Function2<Boolean, Integer, Unit> getNotifyPressedCallback() {
        return this.f14143c;
    }

    public final float getPressedCornerRadius() {
        return this.f14141a;
    }

    public final GradientDrawable getStateBackground() {
        return this.d;
    }

    public final void setForceDark(boolean r5) {
        GradientDrawable r10 = null;
        if (r5 == false) goto L8;
        this.e = Color.parseColor("#1affffff");
        Drawable r11 = ContextCompat.getDrawable(getContext(), R$drawable.o_pop_list_item_dark);
        if ((r11 instanceof GradientDrawable) == false) goto L7;
        r10 = (GradientDrawable) r11;
    L7:
        this.d = r10;
    L12:
        GradientDrawable r12 = this.d;
        if (r12 == null) goto L16;
        setBackground(r12);
    L16:
        this.f = r5;
        return;
    L8:
        this.e = ContextCompat.getColor(getContext(), R$color.oui_state_overlay_pressed);
        Drawable r13 = ContextCompat.getDrawable(getContext(), R$drawable.o_pop_list_item);
        if ((r13 instanceof GradientDrawable) == false) goto L11;
        r10 = (GradientDrawable) r13;
    L11:
        this.d = r10;
        goto L12
    }

    public final void setIndexPos(Index r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14142b = r5;
    }

    public final void setNotifyPressedCallback(Function2<? super Boolean, ? super Integer, Unit> r5) {
        this.f14143c = r5;
    }

    @Override // android.view.View
    @RequiresApi(29)
    public void setPressed(boolean r5) {
        super.setPressed(r5);
        Function2 r10 = this.f14143c;
        if (r10 == null) goto L7;
        r10.mo2invoke(Boolean.valueOf(r5), Integer.valueOf(this.e));
        return;
    }

    public final void setPressedCornerRadius(float r5) {
        this.f14141a = r5;
    }

    public final void setStateBackground(GradientDrawable r5) {
        this.d = r5;
    }

    @JvmOverloads
    public PopoverMenuLinearLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ PopoverMenuLinearLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public PopoverMenuLinearLayout(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14141a = com.lynx.tasm.utils.a.E(20, this);
        this.f14142b = Index.OTHER;
        this.e = ContextCompat.getColor(r5, R$color.oui_state_overlay_pressed);
    }
}
