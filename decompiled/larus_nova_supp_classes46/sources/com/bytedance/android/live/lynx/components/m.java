package com.bytedance.android.live.lynx.components;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements Callback<TypedInput> {
    public final /* synthetic */ n a;
    public final /* synthetic */ k7a.a.a b;
    public final /* synthetic */ String c;

    public final void onFailure(Call<TypedInput> r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r11, "t");
        k7a.a.a r12 = this.b;
        if (r12 == null) goto L5;
        r12.a(null, r11);
    L5:
        n r13 = this.a;
        String r3 = this.c;
        r13.getClass();
        JSONObject r6 = new JSONObject();
        r6.put("path", r3);
        JSONObject r7 = new JSONObject();
        r7.put("virtual_aid", "88888");
        if (r13.a == false) goto L8;
        int r14 = rl0.b.a;
        rl0.a.b.k(null, "lynx_dynamic_fetch_error", r3, null, null, r6, r7, 0);
        return;
    L8:
        int r15 = rl0.b.a;
        rl0.a.b.j(null, "lynx_dynamic_fetch_error", r3, null, null, r6, r7, false);
    }

    public final void onResponse(Call<TypedInput> r5, SsResponse<TypedInput> r6) {
        Intrinsics.checkNotNullParameter(r6, "response");
        BufferedInputStream r7 = new BufferedInputStream(((TypedInput) r6.body()).in());
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "bufferedInputStream");
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();
        byte[] r0 = new byte[4096];     // Catch: Throwable -> L9 Exception -> L11
        int r2 = r7.read(r0);     // Catch: Throwable -> L9 Exception -> L11
    L5:
        if (r2 == (-1)) goto L7;
        r8.write(r0, 0, r2);     // Catch: Throwable -> L9 Exception -> L11
        r2 = r7.read(r0);     // Catch: Throwable -> L9 Exception -> L11
        goto L5
    L7:
        byte[] r1 = r8.toByteArray();     // Catch: Throwable -> L9 Exception -> L11
        r7.close();
        r8.close();
    L14:
        k7a.a.a r9 = this.b;
        if (r9 == null) goto L23;
        r9.a(r1, null);
        return;
    L23:
        return;
    L9:
        th = move-exception;
        r7.close();
        r8.close();
        throw th;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        r7.close();
        r8.close();
        r1 = new byte[0];
        goto L14
    }

    public m(n r1, k7a.a.a r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
