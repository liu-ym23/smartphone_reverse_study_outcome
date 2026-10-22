package com.larksuite.framework.http.call;

import com.larksuite.framework.http.response.ErrorResult;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements Callback {
    public final /* synthetic */ z18.b a;
    public final /* synthetic */ b b;

    public a(b r1, z18.b r2) {
        this.b = r1;
        this.a = r2;
    }

    public final void onFailure(Call r3, IOException r4) {
        ErrorResult r5 = new ErrorResult(-1, 0, r4.getMessage());
        z18.b r6 = this.a;
        if (r6 == null) goto L5;
        r6.a(r5);
    L5:
        c.a(this.b.a, r5.getErrorMessage());
    }

    public final void onResponse(Call r2, Response r3) throws IOException {
        Type r4 = this.a.getClass().getGenericSuperclass();
        if ((r4 instanceof ParameterizedType) == true) goto L5;
        Class<Object> r5 = Object.class;
    L12:
        this.b.a.b();
        c.a r6 = c.b(r5, this.b.a, r3);
        ErrorResult r7 = r6.b;
        if (r7 == null) goto L15;
        c.a(this.b.a, r7.getErrorMessage());
        this.a.a(r6.b);
        return;
    L15:
        c.a(this.b.a, null);
        this.a.onSuccess(r6.a);
        return;
    L5:
        Type[] r8 = ((ParameterizedType) r4).getActualTypeArguments();
        if (r8.length <= 0) goto L11;
        Type r9 = r8[0];
        if ((r9 instanceof Class) == true) goto L10;
        r5 = Object.class;
        goto L12
    L10:
        r5 = (Class) r9;
        goto L12
    L11:
        r5 = Object.class;
        goto L12
    }
}
