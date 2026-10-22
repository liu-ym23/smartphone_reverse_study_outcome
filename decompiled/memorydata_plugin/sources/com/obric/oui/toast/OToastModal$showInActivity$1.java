package com.obric.oui.toast;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OToastModal$showInActivity$1 extends Lambda implements Function0<ViewGroup> {
    final /* synthetic */ Activity $activity;

    OToastModal$showInActivity$1(Activity r3) {
        this.$activity = ZeusTransformUtils.wrapperContext2Activity((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewGroup invoke() {
        Activity r0 = this.$activity;
        if (r0 != null) goto L5;
    L16:
        Object r3 = ZeusTransformUtils.preCheckCast(null, ViewGroup.class, "com.obric.memorydata.plugin");
    L18:
        return (ViewGroup) r3;
    L5:
        if (r0.isFinishing() == true) goto L16;
        if (this.$activity.isDestroyed() == true) goto L16;
        Window r4 = ZeusTransformUtils.getWindow(this.$activity, "com.obric.memorydata.plugin");
        if (r4 != null) goto L12;
        View r5 = null;
    L14:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L19;
        r3 = ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");
        goto L18
    L19:
        return null;
    L12:
        r5 = r4.getDecorView();
        goto L14
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewGroup invoke() {
        return invoke();
    }
}
