package u10;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedString;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements LiveCall<HttpResponse> {
    public final Call<?> a;

    public final HttpResponse a() {
        SsResponse r0 = this.a.execute();     // Catch: Exception -> L43
        if (r0.body() == null) goto L6;
        Object r1 = r0.body();     // Catch: Exception -> L43
    L10:
        String r3 = "";
        if ((r1 instanceof TypedByteArray) == false) goto L14;
        byte[] r2 = ((TypedByteArray) r1).getBytes();     // Catch: Exception -> L43
    L21:
        Response r4 = r0.raw();     // Catch: Exception -> L43
        if (r4 == null) goto L25;
        String r5 = r4.getReason();     // Catch: Exception -> L43
        if (r5 == null) goto L25;
    L26:
        Response r6 = r0.raw();     // Catch: Exception -> L43
        if (r6 == null) goto L30;
        String r7 = r6.getUrl();     // Catch: Exception -> L43
        if (r7 == null) goto L30;
    L31:
        List r8 = r0.headers();     // Catch: Exception -> L43
        ArrayList r9 = new ArrayList();     // Catch: Exception -> L43
        Iterator r11 = r8.iterator();     // Catch: Exception -> L43
    L33:
        if (r11.hasNext() == false) goto L35;
        Header r12 = (Header) r11.next();     // Catch: Exception -> L43
        r9.add(new NameValuePair(r12.getName(), r12.getValue()));     // Catch: Exception -> L43
        goto L33
    L35:
        HttpResponse r13 = new HttpResponse().setUrl(r7).setReason(r5).setStatusCode(r0.code()).setHeaders(r9).setBody(r2);     // Catch: Exception -> L43
        if ((r1 instanceof TypedInput) == false) goto L41;
        String r14 = ((TypedInput) r1).mimeType();     // Catch: Exception -> L43
        if (r14 == null) goto L41;
        r3 = r14;
    L41:
        return r13.setMimeType(r3);
    L30:
        r7 = "";
    L25:
        r5 = "";
        goto L26
    L14:
        if ((r1 instanceof TypedInput) == false) goto L20;
        InputStream r15 = ((TypedInput) r1).in();     // Catch: Exception -> L43
        if (r15 == null) goto L19;
        r2 = d.a(r15);     // Catch: Exception -> L43
        if (r2 != null) goto L21;
    L19:
        r2 = "".getBytes(Charsets.UTF_8);     // Catch: Exception -> L43
        goto L21
    L20:
        r2 = "".getBytes(Charsets.UTF_8);     // Catch: Exception -> L43
        goto L21
    L6:
        if (r0.errorBody() == null) goto L8;
        r1 = r0.errorBody();     // Catch: Exception -> L43
        goto L10
    L8:
        r1 = new TypedString("empty");     // Catch: Exception -> L43
    L43:
        e = move-exception;
        throw e;
    }

    public final void cancel() {
        this.a.cancel();
    }

    public final /* bridge */ /* synthetic */ Object execute() {
        return a();
    }

    public c(Call<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "call");
        this.a = r2;
    }
}
