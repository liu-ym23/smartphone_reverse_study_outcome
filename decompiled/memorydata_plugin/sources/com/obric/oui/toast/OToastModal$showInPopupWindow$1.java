package com.obric.oui.toast;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OToastModal$showInPopupWindow$1 extends Lambda implements Function0<ViewGroup> {
    final /* synthetic */ PopupWindow $popupWindow;
    final /* synthetic */ b this$0;

    OToastModal$showInPopupWindow$1(PopupWindow r1, b r2) {
        this.$popupWindow = r1;
        this.this$0 = r2;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewGroup invoke() {
        PopupWindow r0 = this.$popupWindow;
        boolean r1 = false;
        if (r0 == null) goto L9;
        if (r0.isShowing() != true) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L15;
        View r2 = this.$popupWindow.getContentView();
        if (r2 != null) goto L16;
        return null;
    L16:
        return b.a(this.this$0, r2);
    L15:
        return (ViewGroup) ZeusTransformUtils.preCheckCast(null, ViewGroup.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewGroup invoke() {
        return invoke();
    }
}
