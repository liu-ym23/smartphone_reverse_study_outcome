package com.bytedance.android.live.service.grouppurchasetip;

import android.view.View;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AnchorGroupPurchaseTipManager$showPopupWindow$1 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public AnchorGroupPurchaseTipManager$showPopupWindow$1(a r8) {
        super(1, r8, a.class, "onNoNoticeButtonClick", "onNoNoticeButtonClick(Landroid/view/View;)V", 0);
    }

    public final void invoke(View r6) {
        a r7 = (a) ((CallableReference) this).receiver;
        int r0 = a.f;
        r7.getClass();
        j0.l().sendLog("livesdk_showcase_notice_click", MapsKt.emptyMap(), new Object[]{IRoom.class});
        e<us0.a> r8 = ts0.a.a;
        us0.a r1 = (us0.a) r8.getValue();
        r1.c(true);
        r1.d(r1.b() + 1);
        f.d(r8, r1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
