package com.bytedance.android.live.room.navi.tetris;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ AnchorRoomNavigatorTetris a;

    public c(AnchorRoomNavigatorTetris r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        SharedPrefHelper r8 = SharedPrefHelper.b(this.a.K().getContext());
        r8.l("live.pref.PREF_CLOSE_LIVE_POPUP", Boolean.TRUE);
        r8.a();
        AnchorRoomNavigatorTetris r9 = this.a;
        View r0 = r9.x;
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L6:
        r9.w = new LivePopupWindow(View.inflate(r1, 2131565135, null), s1.f(141.0f), s1.f(49.0f), true);
        if ((r9.r instanceof View) == true) goto L9;
        return;
    L9:
        if (r9.W() == false) goto L23;
        LivePopupWindow r2 = r9.w;
        if (r2 == null) goto L20;
        ImageView r3 = r9.r;
        if (r3 == null) goto L19;
        OverlaySource r4 = PopupWindowLancet.resolveSource(r3);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r2, r3, r4) == true) goto L20;
        r2.showAsDropDown(r3, 0, 0, 5);
        PopupWindowLancet.trackAfterShow(r2, r4, r3);
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L20:
        r9.z = Observable.timer(r9.B, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r9));
        return;
    L23:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
