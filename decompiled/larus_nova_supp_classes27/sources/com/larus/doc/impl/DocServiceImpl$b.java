package com.larus.doc.impl;

import com.larus.bmhome.auth.CocoSetting;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.home.api.main.AppIconsType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DocServiceImpl$b implements IIMCallback<BotModel> {
    public final /* synthetic */ CompletableDeferred<String> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public DocServiceImpl$b(CompletableDeferred<String> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final void onSuccess(Object r6) {
        BotModel r7 = (BotModel) r6;
        Intrinsics.checkNotNullParameter(r7, "result");
        AppIconsType.a r0 = AppIconsType.Companion;
        String r8 = r7.getBotIconMappedAppIcon();
        String r1 = null;
        if (r8 == null) goto L5;
        Integer r9 = StringsKt.toIntOrNull(r8);
    L6:
        r0.getClass();
        AppIconsType r10 = AppIconsType.a.a(r9);
        if (r10 != null) goto L10;
        r10 = AppIconsType.DEFAULT;
    L10:
        int r11 = r10.getAppIconId();
        FLogger.a.i("DocServiceImpl", "getAppIconUrl, curAppIconId = " + r11);
        com.larus.bmhome.chat.api.e0 r2 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r2 == null) goto L30;
        LaunchInfo r3 = r2.a;
        if (r3 == null) goto L30;
        List r4 = r3.s();
        if (r4 == null) goto L30;
        Iterator r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L28;
        Object r12 = r5.next();
        Integer r13 = ((CocoSetting) r12).a();
        if (r13 != null) goto L23;
    L25:
        boolean r14 = false;
    L26:
        if (r14 == false) goto L18;
    L29:
        CocoSetting r15 = (CocoSetting) r12;
    L31:
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("getAppIconUrl, url = ");
        if (r15 == null) goto L34;
        r1 = r15.e();
    L34:
        r17.append(r1);
        r16.i("DocServiceImpl", r17.toString());
        CompletableDeferred<String> r18 = this.a;
        if (r15 == null) goto L38;
        String r20 = r15.e();
        if (r20 == null) goto L38;
    L39:
        r18.complete(r20);
        return;
    L38:
        r20 = "";
        goto L39
    L23:
        if (r13.intValue() != r11) goto L25;
        r14 = true;
        goto L26
    L28:
        r12 = null;
    L30:
        r15 = null;
        goto L31
    L5:
        r9 = null;
        goto L6
    }
}
