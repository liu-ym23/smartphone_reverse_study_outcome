package com.bytedance.android.ec.core.address;

import com.bytedance.android.ec.core.address.api.AddressItemVO;
import com.bytedance.android.ec.core.address.api.GetAddressResponse;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j<T, R> implements Function {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final Object apply(Object r10) {
        GetAddressResponse r11 = (GetAddressResponse) r10;
        Intrinsics.checkNotNullParameter(r11, "it");
        List<AddressItemVO> r0 = r11.getAddressList();
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((AddressItemVO) r1.next()).parseAddress();
    L8:
        return r11;
    }
}
