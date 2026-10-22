package com.bytedance.android.ec.core.address;

import com.bytedance.android.ec.core.address.api.AddressItemVO;
import com.bytedance.android.ec.core.address.api.GetAddressResponse;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public k(Function2 r1, String r10, int r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void accept(Object r10) {
        GetAddressResponse r11 = (GetAddressResponse) r10;
        List<AddressItemVO> r0 = r11.getAddressList();
        if (r0 == null) goto L9;
        AddressItemVO r1 = (AddressItemVO) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L9;
        JSONObject r12 = r1.getAddressVO();
        if (r12 == null) goto L9;
        this.a.invoke(r12, null);
        return;
    L9:
        int r13 = s.a;
        s.b(true, Integer.valueOf(r11.getStatusCode()), "read_address", r11.getLogId());
        w r14 = AddressSDK.a;
        AddressSDK.g("fetch address fail id=" + this.b + " type=" + this.c + " status_code=" + Integer.valueOf(r11.getStatusCode()), null, 6);
        Function2 r15 = this.a;
        StringBuilder r16 = new StringBuilder("fetch 地址为空，status_code=");
        r16.append(Integer.valueOf(r11.getStatusCode()));
        r15.invoke(null, r16.toString());
    }
}
