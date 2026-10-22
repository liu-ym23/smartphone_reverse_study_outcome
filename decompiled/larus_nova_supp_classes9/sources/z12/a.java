package z12;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.vs.panel.view.VSGiftDialogFragmentNew;
import com.bytedance.ies.sdk.widgets.DataCenter;
import h12.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements f {
    public a() {
    }

    @Override // h12.f
    public final VSGiftDialogFragmentNew a(Context r3, DataCenter r4, GiftViewModelManager r5, LocateGiftInfo r6) {
        Intrinsics.checkNotNullParameter(r3, "outerContext");
        if (u.p() == false) goto L12;
        VSGiftDialogFragmentNew r0 = new VSGiftDialogFragmentNew();
        r0.i = r3;
        if (r4 == null) goto L9;
        Boolean r7 = (Boolean) r4.get("data_is_anchor", Boolean.FALSE);
        if (r7 == null) goto L9;
        boolean r8 = r7.booleanValue();
    L10:
        r0.h = r8;
        r0.j = r4;
        r0.k = r5;
        r0.l = r6;
        return r0;
    L9:
        r8 = false;
        goto L10
    L12:
        return null;
    }
}
