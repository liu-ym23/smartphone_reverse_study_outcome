package com.obric.oui.dialog.v2.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.c;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.h;
import com.obric.oui.dialog.v2.common.ODialogListItemView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\f¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionItemView;", "Lcom/obric/oui/dialog/v2/common/ODialogListItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getCheckMark", "Landroid/view/View;", "isChecked", "", "setCheckStyle", "", "style", "Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle;", "setChecked", "checked", "toggleCheckState", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionItemView extends ODialogListItemView {
    public static final Companion f = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion;", "", "()V", "TAG", "", "CheckStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle;", "", "(Ljava/lang/String;I)V", "NONE", "ICON", "CHECKBOX", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum CheckStyle extends Enum<CheckStyle> {
            private static final /* synthetic */ CheckStyle[] $VALUES = null;
            public static final CheckStyle CHECKBOX = null;
            public static final CheckStyle ICON = null;
            public static final CheckStyle NONE = null;

            private static final /* synthetic */ CheckStyle[] $values() {
                return new CheckStyle[]{NONE, ICON, CHECKBOX};
            }

            static {
                NONE = new CheckStyle("NONE", 0);
                ICON = new CheckStyle("ICON", 1);
                CHECKBOX = new CheckStyle("CHECKBOX", 2);
                $VALUES = $values();
            }

            private CheckStyle(String r1, int r2) {
                super(r1, r2);
            }

            public static CheckStyle valueOf(String r2) {
                return (CheckStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(CheckStyle.class, r2), CheckStyle.class, "com.obric.memorydata.plugin");
            }

            public static CheckStyle[] values() {
                return (CheckStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CheckStyle[].class, "com.obric.memorydata.plugin");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13832a = null;

        static {
            int[] r0 = new int[Companion.CheckStyle.values().length];
            r0[Companion.CheckStyle.ICON.ordinal()] = 1;
            r0[Companion.CheckStyle.CHECKBOX.ordinal()] = 2;
            r0[Companion.CheckStyle.NONE.ordinal()] = 3;
            f13832a = r0;
        }
    }

    static {
        f = new Companion(null);
    }

    public OSelectionItemView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        setCheckStyle(Companion.CheckStyle.NONE);
        a(true);
    }

    public /* synthetic */ OSelectionItemView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    private final View getCheckMark() {
        c r0 = c.f13403a;
        View r4 = getTrailingContainer().getChildAt(0);
        if (r4 != null) goto L6;
    L4:
        r4 = null;
    L7:
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L11;
        return null;
    L11:
        return r5.getChildAt(0);
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L4;
        goto L4
    }

    public final void setCheckStyle(Companion.CheckStyle r7) {
        Intrinsics.checkNotNullParameter(r7, "style");
        int r8 = a.f13832a[r7.ordinal()];
        ImageView r1 = null;
        if (r8 != 1) goto L5;
        ImageView r9 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r9.setImageDrawable(ResourcesCompat.getDrawable(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.oui_select_list_item_checker, "drawable", "oui_select_list_item_checker"), null));
        r1 = r9;
    L13:
        if (r1 == null) goto L15;
        FrameLayout r10 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 17;
        r10.addView((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), new ViewGroup.LayoutParams(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 32), -2));
        return;
    L15:
        getTrailingContainer().setVisibility(8);
        return;
    L5:
        if (r8 != 2) goto L7;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        r1 = (ImageView) ZeusTransformUtils.preCheckCast(new OCheckBox(r2), ImageView.class, "com.obric.memorydata.plugin");
        goto L13
    L7:
        if (r8 == 3) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    public final void setChecked(boolean r3) {
        View r2 = getCheckMark();
        if (ZeusTransformUtils.instanceOf(r2, OCheckBox.class) == false) goto L6;
        ((OCheckBox) ZeusTransformUtils.preCheckCast(r2, OCheckBox.class, "com.obric.memorydata.plugin")).setChecked(r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, ImageView.class) == false) goto L12;
        ImageView r4 = (ImageView) ZeusTransformUtils.preCheckCast(r2, ImageView.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L10;
        int r5 = 0;
    L11:
        r4.setVisibility(r5);
        return;
    L10:
        r5 = 4;
        goto L11
    L12:
        com.obric.oui.c.a.b.b("OSelectionItemView", "checkMark is not OCheckBox or ImageView");
    }
}
