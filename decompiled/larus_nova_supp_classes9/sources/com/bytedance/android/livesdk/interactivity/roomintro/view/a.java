package com.bytedance.android.livesdk.interactivity.roomintro.view;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ b0 b;

    public a(FragmentActivity r1, b0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Response r5 = (Response) r4;
        if (((BaseResponse) r5).data != null) goto L5;
        String r6 = rm3.c.a;
        rm3.c.f(this.a, 2131923023, false, 28);
        return;
    L5:
        RoomIntroDialog r0 = new RoomIntroDialog();
        r0.e = (com.bytedance.android.livesdk.interactivity.api.roomintro.api.b) ((BaseResponse) r5).data;
        r0.f = this.b;
        FragmentManager r7 = this.a.getSupportFragmentManager();
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog", r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r0, r1) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r0.show(r7, "com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog");
        return;
    }
}
