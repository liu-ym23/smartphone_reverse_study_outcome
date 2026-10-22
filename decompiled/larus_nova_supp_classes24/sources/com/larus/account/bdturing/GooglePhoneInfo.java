package com.larus.account.bdturing;

import androidx.fragment.app.Fragment;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.account.base.provider.IGooglePhoneLoginProvider;
import com.larus.login.impl.VerificationCodeFragment;
import com.larus.login.impl.activity.PhoneLoginActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J*\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/account/bdturing/GooglePhoneInfo;", "Lcom/larus/account/base/provider/IGooglePhoneLoginProvider;", "<init>", "()V", "TAG", "", "getPhoneNumberByGoogle", "", "fragment", "Landroidx/fragment/app/Fragment;", "getPhoneNumberBySim", "callback", "Lcom/larus/account/base/api/IGooglePhoneNumber;", "autoGetSms", "Lcom/larus/account/base/api/IAutoSmsCode;", "endSmsListener", "getPhoneNumberByActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "looseCheckPhoneNumber", "", "phoneNumber", "strictCheckPhoneNumber", "init", "providePlatform", "Lcom/larus/account/base/model/LoginPlatform;", "logout", "forceLogout", "Lcom/larus/account/base/api/IAccountCallback;", "businessScene", "phonelogin_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class GooglePhoneInfo implements IGooglePhoneLoginProvider {
    @Override // com.larus.account.base.provider.IGooglePhoneLoginProvider
    public final void a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
    }

    @Override // com.larus.account.base.provider.IGooglePhoneLoginProvider
    public final void i(PhoneLoginActivity.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    @Override // com.larus.account.base.provider.IGooglePhoneLoginProvider
    public final void q() {
    }

    @Override // com.larus.account.base.provider.IGooglePhoneLoginProvider
    public final void w(VerificationCodeFragment.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public GooglePhoneInfo() {
    }
}
