package com.ss.android.lark.officesdk;

import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder {
    public final o a;

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent.OfficeSDKGlobalComponentBuilder
    public final OfficeSDKGlobalComponent build() {
        return new l(this.a);
    }

    public k(o r1) {
        this.a = r1;
    }
}
