package com.obric.oui.toast;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OToastModal$showInDialog$1 extends Lambda implements Function0<ViewGroup> {
    final /* synthetic */ Dialog $dialog;

    OToastModal$showInDialog$1(Dialog r1) {
        this.$dialog = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewGroup invoke() {
        Dialog r0 = this.$dialog;
        boolean r1 = false;
        if (r0 == null) goto L9;
        if (r0.isShowing() != true) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L17;
        Window r3 = this.$dialog.getWindow();
        if (r3 != null) goto L13;
        View r4 = null;
    L15:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L20;
        Object r5 = ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
    L19:
        return (ViewGroup) r5;
    L20:
        return null;
    L13:
        r4 = r3.getDecorView();
        goto L15
    L17:
        r5 = ZeusTransformUtils.preCheckCast(null, ViewGroup.class, "com.obric.memorydata.plugin");
        goto L19
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewGroup invoke() {
        return invoke();
    }
}
