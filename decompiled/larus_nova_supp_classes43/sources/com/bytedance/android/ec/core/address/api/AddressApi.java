package com.bytedance.android.ec.core.address.api;

import io.reactivex.Observable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AddressApi implements IAddressApi {
    public static final Lazy a = null;
    public static final AddressApi b = null;

    public AddressApi() {
    }

    static {
        b = new AddressApi();
        a = LazyKt.lazy(AddressApi$api$2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.core.address.api.IAddressApi
    public final Observable<ReportAddressResponse> reportAddress(String r10, String r11, Integer r12) {
        return ((IAddressApi) a.getValue()).reportAddress(r10, r11, r12);
    }

    @Override // com.bytedance.android.ec.core.address.api.IAddressApi
    public final Observable<GetAddressResponse> getAddress(String r11, boolean r12, String r13, String r14, Integer r15, String r16, String r17, int r18) {
        Intrinsics.checkNotNullParameter(r11, "requestTag");
        Intrinsics.checkNotNullParameter(r13, "changeType");
        return ((IAddressApi) a.getValue()).getAddress(r11, r12, r13, r14, r15, r16, r17, r18);
    }
}
