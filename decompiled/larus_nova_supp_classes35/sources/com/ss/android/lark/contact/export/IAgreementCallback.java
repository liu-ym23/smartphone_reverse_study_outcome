package com.ss.android.lark.contact.export;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.ICallback;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/contact/export/IAgreementCallback;", "Lcom/larksuite/framework/callback/ICallback;", "onAgree", BuildConfig.FLAVOR, "onRefuse", "onError", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contact-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAgreementCallback extends ICallback {
    void onAgree();

    void onError(ErrorResult r1);

    void onRefuse();
}
