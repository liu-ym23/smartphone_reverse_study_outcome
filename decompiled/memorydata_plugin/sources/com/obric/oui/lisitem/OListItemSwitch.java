package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/lisitem/OListItemSwitch;", "Lcom/obric/oui/lisitem/OListItemSettings;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mOSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "mOnCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "getSwitch", "inflateContent", "", "isChecked", "", "isPressable", "setChecked", "checked", "setEnabled", "enabled", "setOnCheckedChangeListener", "listener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemSwitch extends OListItemSettings {
    private final OSwitch c;
    private CompoundButton.OnCheckedChangeListener d;

    public OListItemSwitch(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r11);
        setClickable(false);
        OSwitch r12 = new OSwitch(r3, null, 0, 6, null);
        r12.setClickable(true);
        r12.setOnCheckedChangeListener(new $$Lambda$OListItemSwitch$scFe_SflehhV3hdTCzOTgJAF90(this));
        this.c = r12;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r13.gravity = 17;
        r13.leftMargin = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4);
        r13.rightMargin = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4);
        a((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(OListItemSwitch r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        CompoundButton.OnCheckedChangeListener r4 = r1.d;
        if (r4 == null) goto L7;
        r4.onCheckedChanged(r2, r3);
        return;
    }

    /* JADX INFO: renamed from: lambda$scFe-_SflehhV3hdTCzOTgJAF90, reason: not valid java name */
    public static /* synthetic */ void m1319lambda$scFe_SflehhV3hdTCzOTgJAF90(OListItemSwitch r0, CompoundButton r1, boolean r2) {
        a(r0, r1, r2);
    }

    @Override // com.obric.oui.lisitem.OListItemSettings, com.obric.oui.lisitem.OListItemGeneral
    public void a() {
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.o_listitem_switch, "layout", "o_listitem_switch"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public final OSwitch getSwitch() {
        return this.c;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout
    public boolean k() {
        return false;
    }

    public final void setChecked(boolean r1) {
        this.c.setChecked(r1);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        this.c.setAlpha(1.0f);
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r3) {
        this.d = (CompoundButton.OnCheckedChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, CompoundButton.OnCheckedChangeListener.class, "com.obric.memorydata.plugin");
    }
}
