package com.ss.android.lark.contact.customized.myqrcode.repository;

import com.bytedance.lark.pb.im.v2.GetContactTokenResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.contact.base.entity.bean.ContactAvatarSourceStrategy;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/contact/customized/myqrcode/repository/OfficeInviteMsgRepository$asyncGetInviteMsgFromLocal$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/bytedance/lark/pb/im/v2/GetContactTokenResponse;", "onSuccess", BuildConfig.FLAVOR, "response", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteMsgRepository$asyncGetInviteMsgFromLocal$1 implements IGetDataCallback<GetContactTokenResponse> {
    final /* synthetic */ Function1<z8b.a, Unit> $consumer;

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeInviteMsgRepository$asyncGetInviteMsgFromLocal$1(Function1<? super z8b.a, Unit> r1) {
        this.$consumer = r1;
    }

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("ContactModule_", r3.getDebugMsg());
        Function1<z8b.a, Unit> r0 = this.$consumer;
        z8b.a r1 = new z8b.a();
        r1.c = r3;
        r0.invoke(r1);
    }

    public void onSuccess(GetContactTokenResponse r3) {
        Function1<z8b.a, Unit> r0 = this.$consumer;
        if (r3 != null) goto L5;
        z8b.a r4 = null;
    L6:
        r0.invoke(r4);
        return;
    L5:
        r4 = z8b.a.a(r3, ContactAvatarSourceStrategy.LOGIN_CHATTER);
        goto L6
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((GetContactTokenResponse) r1);
    }
}
