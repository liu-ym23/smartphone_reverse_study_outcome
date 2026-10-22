package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livehostapi.business.shareinter.ILiveIMSharePostscriptListener;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMContact;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements ILiveIMSharePostscriptListener {
    public final /* synthetic */ AudienceShareIMElement a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ View c;

    public final void onOutSideClick() {
        ALogger.i("MoreMixSharePanel", "onOutSideClick");
        WeakReference<b2> r0 = this.a.p.c();
        if (r0 == null) goto L8;
        b2 r1 = r0.get();
        if (r1 == null) goto L9;
        r1.c();
        return;
    L9:
        return;
    }

    public final void onMsgSend(List<? extends LiveIMContact> r3) {
        Intrinsics.checkNotNullParameter(r3, "toIMContact");
        ALogger.i("MoreMixSharePanel", "onMsgSend");
        AudienceShareIMElement.n(this.a, r3);
        AudienceShareIMElement.o(this.a);
        WeakReference<b2> r4 = this.a.p.c();
        if (r4 == null) goto L8;
        b2 r5 = r4.get();
        if (r5 == null) goto L9;
        r5.c();
        return;
    L9:
        return;
    }

    public final void panelShow(boolean r3) {
        ALogger.i("MoreMixSharePanel", "panelShow: " + r3);
        if (r3 == false) goto L7;
        View r4 = this.c;
        if (r4 == null) goto L11;
        r4.setVisibility(0);
        return;
    L11:
        return;
    L7:
        View r5 = this.c;
        if (r5 == null) goto L13;
        r5.setVisibility(8);
        return;
    }

    public final void showKeyBoard(boolean r4) {
        ALogger.i("MoreMixSharePanel", "showKeyBoard: " + r4);
        AudienceShareIMElement r0 = this.a;
        View r1 = r0.h;
        if (r1 == null) goto L22;
        if (r4 == false) goto L12;
        int r5 = r1.getHeight();
        View r2 = r0.i;
        if (r2 == null) goto L9;
        r2.setTranslationY(r5);
    L9:
        View r3 = r0.i;
        if (r3 == null) goto L19;
        r3.post(new l(r0, r5));
        return;
    L19:
        return;
    L12:
        View r6 = r0.i;
        if (r6 == null) goto L15;
        r6.setTranslationY(0.0f);
    L15:
        View r7 = r0.i;
        if (r7 == null) goto L21;
        a1.k(r7, -2);
        return;
    L21:
        return;
    }

    public k(AudienceShareIMElement r1, ViewGroup r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
