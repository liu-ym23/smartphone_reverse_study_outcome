package com.ss.android.lark.officesdk;

import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponentBuilder;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class w implements OfficeSDKUserComponentBuilder {
    public final y a;
    public UserSession b;

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKUserComponentBuilder
    public final OfficeSDKUserComponent build() {
        Preconditions.checkBuilderRequirement(this.b, UserSession.class);
        return new x(this.a);
    }

    public w(y r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKUserComponentBuilder
    public final OfficeSDKUserComponentBuilder userSession(UserSession r1) {
        this.b = (UserSession) Preconditions.checkNotNull(r1);
        return this;
    }
}
