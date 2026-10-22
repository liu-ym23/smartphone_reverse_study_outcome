package com.larus.account.base.provider;

import androidx.fragment.app.Fragment;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.login.impl.VerificationCodeFragment;
import com.larus.login.impl.activity.PhoneLoginActivity;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0017"}, d2 = {"Lcom/larus/account/base/provider/IGooglePhoneLoginProvider;", "Lcom/larus/account/base/provider/ILoginProvider;", "getPhoneNumberByGoogle", "", "fragment", "Landroidx/fragment/app/Fragment;", "getPhoneNumberBySim", "callback", "Lcom/larus/account/base/api/IGooglePhoneNumber;", "autoGetSms", "Lcom/larus/account/base/api/IAutoSmsCode;", "endSmsListener", "getPhoneNumberByActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "looseCheckPhoneNumber", "", "phoneNumber", "", "strictCheckPhoneNumber", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface IGooglePhoneLoginProvider extends ILoginProvider {
    void a(Fragment r1);

    void i(PhoneLoginActivity.a r1);

    void q();

    void w(VerificationCodeFragment.b r1);
}
