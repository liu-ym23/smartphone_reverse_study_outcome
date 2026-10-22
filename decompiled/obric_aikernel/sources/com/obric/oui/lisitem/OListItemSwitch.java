package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/lisitem/OListItemSwitch;", "Lcom/obric/oui/lisitem/OListItemSettings;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "listener", "", "setOnCheckedChangeListener", "", "checked", "setChecked", "enabled", "setEnabled", "Lcom/obric/oui/oswitch/OSwitch;", "getSwitch", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OListItemSwitch extends OListItemSettings {
    private final OSwitch G;
    private CompoundButton.OnCheckedChangeListener H;

    static final class a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OListItemSwitch f6904a;

        a(OListItemSwitch r10) {
            this.f6904a = r10;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r10, boolean r11) {
            CompoundButton.OnCheckedChangeListener r12 = OListItemSwitch.j(this.f6904a);
            if (r12 == null) goto L6;
            r12.onCheckedChanged(r10, r11);
            return;
        }
    }

    public OListItemSwitch(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        setClickable(false);
        OSwitch r12 = new OSwitch(r10, null, 0, 6, null);
        r12.setClickable(true);
        r12.setOnCheckedChangeListener(new a(this));
        Unit r13 = Unit.INSTANCE;
        this.G = r12;
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        r14.gravity = 17;
        float r15 = 4;
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        r14.leftMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r15, r16.getDisplayMetrics()));
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        r14.rightMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r15, r17.getDisplayMetrics()));
        h(r12, r14);
    }

    public static final /* synthetic */ CompoundButton.OnCheckedChangeListener j(OListItemSwitch r10) {
        return r10.H;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout
    public boolean b() {
        return false;
    }

    @Override // com.obric.oui.lisitem.OListItemSettings, com.obric.oui.lisitem.OListItemGeneral
    public void d() {
        LayoutInflater.from(getContext()).inflate(h.o_listitem_switch, this);
    }

    public final OSwitch getSwitch() {
        return this.G;
    }

    public final void setChecked(boolean r10) {
        this.G.setChecked(r10);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        this.G.setAlpha(1.0f);
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r10) {
        this.H = r10;
    }
}
