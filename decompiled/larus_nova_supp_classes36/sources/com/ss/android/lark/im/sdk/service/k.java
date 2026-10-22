package com.ss.android.lark.im.sdk.service;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactViewModel;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k<T> implements RxScheduledExecutor.Consumer {
    public final /* synthetic */ IGetDataCallback<Chatter> a;

    public k(OfficeExternalContactViewModel.fetchSelfCardHeader.1 r1) {
        this.a = r1;
    }

    public final void consume(Object r2) {
        Chatter r3 = (Chatter) r2;
        if (r3 == null) goto L5;
        this.a.onSuccess(r3);
        return;
    L5:
        IGetDataCallback<Chatter> r4 = this.a;
        int r0 = ImSdkChatterServiceImplV2.c;
        r4.onError(ImSdkChatterServiceImplV2.a.a("Can't find target chatter!"));
    }
}
