package com.ss.android.lark.contact.customized.setting;

import com.bytedance.lark.pb.settings.v1.UpdateDoubaoAddFriendSettingResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.contact.api.model.DoubaoAddFriendSettingType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/contact/customized/setting/DoubaoAddFriendSettingRepository$updateSetting$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/bytedance/lark/pb/settings/v1/UpdateDoubaoAddFriendSettingResponse;", "onSuccess", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "onError", Keys.API_RETURN_KEY_ERROR, "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoAddFriendSettingRepository$updateSetting$1 implements IGetDataCallback<UpdateDoubaoAddFriendSettingResponse> {
    final /* synthetic */ ltb.a<Unit> $callback;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ DoubaoAddFriendSettingType $settingType;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_ERROR);
        Log.e("Contact_AddFriendSetting", "updateSetting error type=" + this.$settingType + " enabled=" + this.$enabled + " code=" + r3.getErrorCode());
        this.$callback.onError(r3.getErrorCode(), r3.getErrorMsg());
    }

    public void onSuccess(UpdateDoubaoAddFriendSettingResponse r2) {
        Log.i("Contact_AddFriendSetting", "updateSetting success type=" + this.$settingType + " enabled=" + this.$enabled);
        this.$callback.onSuccess(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((UpdateDoubaoAddFriendSettingResponse) r1);
    }

    public DoubaoAddFriendSettingRepository$updateSetting$1(DoubaoAddFriendSettingType r1, boolean r2, ltb.a<Unit> r3) {
        this.$settingType = r1;
        this.$enabled = r2;
        this.$callback = r3;
    }
}
