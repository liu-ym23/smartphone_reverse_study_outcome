package com.obric.oui.popover.menu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001.B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\nH\u0017R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015RL\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", EventBody.KEY_VALUE, "", "forceDark", "getForceDark", "()Z", "setForceDark", "(Z)V", "indexPos", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "getIndexPos", "()Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "setIndexPos", "(Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;)V", "notifyPressedCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "pressed", "pressedColor", "", "getNotifyPressedCallback", "()Lkotlin/jvm/functions/Function2;", "setNotifyPressedCallback", "(Lkotlin/jvm/functions/Function2;)V", "pressedCornerRadius", "", "getPressedCornerRadius", "()F", "setPressedCornerRadius", "(F)V", "stateBackground", "Landroid/graphics/drawable/GradientDrawable;", "getStateBackground", "()Landroid/graphics/drawable/GradientDrawable;", "setStateBackground", "(Landroid/graphics/drawable/GradientDrawable;)V", "setPressed", i.j, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PopoverMenuLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f14346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Index f14347b;
    private Function2<? super Boolean, ? super Integer, Unit> c;
    private GradientDrawable d;
    private int e;
    private boolean f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "", "(Ljava/lang/String;I)V", "FIRST", "LAST", "OTHER", "ONLY_ONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Index extends Enum<Index> {
        private static final /* synthetic */ Index[] $VALUES = null;
        public static final Index FIRST = null;
        public static final Index LAST = null;
        public static final Index ONLY_ONE = null;
        public static final Index OTHER = null;

        private static final /* synthetic */ Index[] $values() {
            return new Index[]{FIRST, LAST, OTHER, ONLY_ONE};
        }

        static {
            FIRST = new Index("FIRST", 0);
            LAST = new Index("LAST", 1);
            OTHER = new Index("OTHER", 2);
            ONLY_ONE = new Index("ONLY_ONE", 3);
            $VALUES = $values();
        }

        private Index(String r1, int r2) {
            super(r1, r2);
        }

        public static Index valueOf(String r2) {
            return (Index) ZeusTransformUtils.preCheckCast(Enum.valueOf(Index.class, r2), Index.class, "com.obric.memorydata.plugin");
        }

        public static Index[] values() {
            return (Index[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Index[].class, "com.obric.memorydata.plugin");
        }
    }

    public PopoverMenuLinearLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public PopoverMenuLinearLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public PopoverMenuLinearLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f14346a = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 20);
        this.f14347b = Index.OTHER;
        this.e = ContextCompat.getColor(r6, ZeusTransformUtils.mapRes(R.color.oui_state_overlay_pressed, TypedValues.Custom.S_COLOR, "oui_state_overlay_pressed"));
    }

    public /* synthetic */ PopoverMenuLinearLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public final boolean getForceDark() {
        return this.f;
    }

    public final Index getIndexPos() {
        return this.f14347b;
    }

    public final Function2<Boolean, Integer, Unit> getNotifyPressedCallback() {
        return this.c;
    }

    public final float getPressedCornerRadius() {
        return this.f14346a;
    }

    public final GradientDrawable getStateBackground() {
        return this.d;
    }

    public final void setForceDark(boolean r8) {
        GradientDrawable r0 = null;
        if (r8 == false) goto L7;
        this.e = Color.parseColor("#1affffff");
        Drawable r1 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_pop_list_item_dark, "drawable", "o_pop_list_item_dark"));
        if (ZeusTransformUtils.instanceOf(r1, GradientDrawable.class) == true) goto L9;
    L10:
        this.d = r0;
        GradientDrawable r2 = this.d;
        if (r2 == null) goto L14;
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r2, Drawable.class, "com.obric.memorydata.plugin"));
    L14:
        this.f = r8;
        return;
    L9:
        r0 = (GradientDrawable) ZeusTransformUtils.preCheckCast(r1, GradientDrawable.class, "com.obric.memorydata.plugin");
        goto L10
    L7:
        this.e = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_state_overlay_pressed, TypedValues.Custom.S_COLOR, "oui_state_overlay_pressed"));
        r1 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_pop_list_item, "drawable", "o_pop_list_item"));
        if (ZeusTransformUtils.instanceOf(r1, GradientDrawable.class) == false) goto L10;
        goto L9
    }

    public final void setIndexPos(Index r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14347b = r2;
    }

    public final void setNotifyPressedCallback(Function2<? super Boolean, ? super Integer, Unit> r3) {
        this.c = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        super.setPressed(r2);
        Function2<? super Boolean, ? super Integer, Unit> r0 = this.c;
        if (r0 == null) goto L7;
        r0.invoke(Boolean.valueOf(r2), Integer.valueOf(this.e));
        return;
    }

    public final void setPressedCornerRadius(float r1) {
        this.f14346a = r1;
    }

    public final void setStateBackground(GradientDrawable r1) {
        this.d = r1;
    }
}
