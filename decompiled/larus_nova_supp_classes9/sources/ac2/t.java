package ac2;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ v a;
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.e b;

    public t(v r1, lmc.a.f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Response r8 = ((SsResponse) r7).raw();
        if (r8.isSuccessful() == false) goto L16;
        TypedByteArray r0 = r8.getBody();
        if (r0 == null) goto L15;
        byte[] r1 = r0.getBytes();
        List r2 = r8.getHeaders();
        if (r2 != null) goto L9;
        r2 = CollectionsKt.emptyList();
    L9:
        List r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        Header r6 = (Header) r5.next();
        r4.add(new com.ss.ugc.live.sdk.msg.network.d(r6.getName(), r6.getValue()));
        goto L11
    L13:
        com.ss.ugc.live.sdk.msg.network.g r9 = new com.ss.ugc.live.sdk.msg.network.g();
        r9.a = r8.getStatus();
        r9.b = r8.getReason();
        r9.c = r4;
        r9.d = r1;
        int r10 = com.ss.ugc.live.sdk.msg.utils.g.a;
        com.ss.ugc.live.sdk.msg.utils.g.c r11 = new com.ss.ugc.live.sdk.msg.utils.g.c(r9);
    L17:
        this.b.a(r11);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.retrofit2.mime.TypedByteArray");
    L16:
        bc2.c.e("http post response failed, code: " + r8.getStatus() + ". logId: " + v.d(this.a, r8));
        int r13 = com.ss.ugc.live.sdk.msg.utils.g.a;
        r11 = com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception("response failed"));
        goto L17
    }
}
