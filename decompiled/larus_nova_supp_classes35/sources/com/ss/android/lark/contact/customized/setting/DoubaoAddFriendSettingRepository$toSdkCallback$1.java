package com.ss.android.lark.contact.customized.setting;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/contact/customized/setting/DoubaoAddFriendSettingRepository$toSdkCallback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "onSuccess", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "(Ljava/lang/Object;)V", "onError", Keys.API_RETURN_KEY_ERROR, "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoAddFriendSettingRepository$toSdkCallback$1 implements IGetDataCallback<Object> {
    final /* synthetic */ ltb.a<Object> $callback;

    public DoubaoAddFriendSettingRepository$toSdkCallback$1(ltb.a<Object> r1) {
        this.$callback = r1;
    }

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_ERROR);
        Log.e("Contact_AddFriendSetting", "toSdkCallback error code=" + r3.getErrorCode() + " msg=" + r3.getErrorMsg() + " logId=" + r3.getLogId());
        this.$callback.onError(r3.getErrorCode(), r3.getErrorMsg());
    }

    public void onSuccess(Object r2) {
        this.$callback.onSuccess(r2);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }
}
