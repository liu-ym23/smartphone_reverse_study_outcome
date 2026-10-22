package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCircleImgSwitch;", "Lcom/obric/oui/lisitem/OListItemCircleImg;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mOSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "mOnCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "isChecked", "", "setChecked", "", "checked", "setOnCheckedChangeListener", "listener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemCircleImgSwitch extends OListItemCircleImg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OSwitch f13975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f13976b;

    public OListItemCircleImgSwitch(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r11);
        OSwitch r12 = new OSwitch(r3, null, 0, 6, null);
        r12.setClickable(true);
        r12.setOnCheckedChangeListener(new $$Lambda$OListItemCircleImgSwitch$D3pB1Uc8OXrPq6jETOqNGtPhHeU(this));
        this.f13975a = r12;
        setTrailingView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(OListItemCircleImgSwitch r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        CompoundButton.OnCheckedChangeListener r4 = r1.f13976b;
        if (r4 == null) goto L7;
        r4.onCheckedChanged(r2, r3);
        return;
    }

    public static /* synthetic */ void lambda$D3pB1Uc8OXrPq6jETOqNGtPhHeU(OListItemCircleImgSwitch r0, CompoundButton r1, boolean r2) {
        a(r0, r1, r2);
    }

    public final void setChecked(boolean r1) {
        this.f13975a.setChecked(r1);
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r3) {
        this.f13976b = (CompoundButton.OnCheckedChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, CompoundButton.OnCheckedChangeListener.class, "com.obric.memorydata.plugin");
    }
}
