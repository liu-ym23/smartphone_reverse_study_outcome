package com.bytedance.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TTMultiNetwork$1 implements Callback<TypedInput> {
    public TTMultiNetwork$1() {
    }

    public void onFailure(Call<TypedInput> r2, Throwable r3) {
        TTMultiNetwork.access$100(false);
        r3.printStackTrace();
        r2.cancel();
    }

    public void onResponse(Call<TypedInput> r4, SsResponse<TypedInput> r5) {
        Iterator r6 = r5.headers().iterator();     // Catch: Throwable -> L11
    L4:
        if (r6.hasNext() == false) goto L8;
        Header r0 = (Header) r6.next();     // Catch: Throwable -> L11
        if ("ActiveResult".equalsIgnoreCase(r0.getName()) == false) goto L4;
        String r7 = r0.getValue();     // Catch: Throwable -> L11
    L9:
        TTMultiNetwork.access$002(TTMultiNetwork.ActiveResult.convertToResult(r7));     // Catch: Throwable -> L11
        TTMultiNetwork.access$100("1".equals(r7));     // Catch: Throwable -> L11
    L13:
        r4.cancel();
        return;
    L8:
        r7 = null;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r4.cancel();
        throw th;
    }
}
