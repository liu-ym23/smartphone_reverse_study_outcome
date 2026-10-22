package com.larus.bmhome.chat.component.share;

import android.content.Context;
import by7.e;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.bmhome.share.panel.h;
import com.larus.bmhome.utils.i;
import com.larus.network.bean.BizResponse;
import com.larus.platform.exp.LarkSocialExp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e0 implements Function1 {
    public final /* synthetic */ ChatShareBottomComponent a;

    public /* synthetic */ e0(ChatShareBottomComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r89) {
        ChatShareBottomComponent r1 = this.a;
        BizResponse r2 = (BizResponse) r89;
        int r3 = ChatShareBottomComponent.R;
        u7 r4 = r1.Z3();
        if (r4 == null) goto L6;
        r4.dismissLoading();
    L6:
        if (r2.isSuccess() == false) goto L22;
        ShareServiceDelegate r5 = ShareServiceDelegate.b;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Context r6 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1).getContext();
        SaveMessageShareInfo r7 = (SaveMessageShareInfo) r2.getData();
        if (r7 == null) goto L10;
        String r8 = r7.getShareUrl();
    L12:
        if (i.f(r1.h()) == false) goto L16;
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.b() == false) goto L16;
        ShareScene r9 = ShareScene.OFFICE_SHARE_CHAT;
    L17:
        ShareScene r10 = r9;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        e r11 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1);
        if ((r11 instanceof e) == false) goto L20;
        e r12 = r11;
    L21:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r13 = r5.p(com.larus.ui.arch.component.internal.attach.a.b(r1, r1).getContext(), r1.E3());
        Intrinsics.checkNotNullParameter(r1, "<this>");
        IShareService.a.c(r5, r6, r8, r13, com.larus.ui.arch.component.internal.attach.a.b(r1, r1).getString(2131909359), r10, new h(r1.h(), r1.E3(), null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r1.c4(), null, null, null, false, null, null, null, null, -4, -1, 1021), r12, null, 288);
    L24:
        return Unit.INSTANCE;
    L20:
        r12 = null;
    L16:
        r9 = ShareScene.MESSAGES_LINK;
        goto L17
    L10:
        r8 = null;
        goto L12
    L22:
        t19.s r14 = t19.s.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r14.g(com.larus.ui.arch.component.internal.attach.a.b(r1, r1).getContext(), 2131900870, false);
        goto L24
    }
}
