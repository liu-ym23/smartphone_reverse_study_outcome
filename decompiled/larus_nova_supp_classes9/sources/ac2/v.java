package ac2;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.interactivity.service.uplink.IUplinkApi;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements com.ss.ugc.live.sdk.msg.network.i {
    public final IUplinkApi a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ v a;
        public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.e b;

        public a(v r1, com.ss.ugc.live.sdk.msg.network.e r2) {
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

    public static final class b<T> implements Consumer {
        public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.e a;

        public b(com.ss.ugc.live.sdk.msg.network.e r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.ss.ugc.live.sdk.msg.network.e r0 = this.a;
            int r1 = com.ss.ugc.live.sdk.msg.utils.g.a;
            r0.a(com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception((Throwable) r3)));
        }
    }

    public v() {
        this.a = (IUplinkApi) com.bytedance.android.live.network.c.b().e(IUplinkApi.class);
    }

    public final com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, Exception> a(com.ss.ugc.live.sdk.msg.network.f r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        int r3 = com.ss.ugc.live.sdk.msg.utils.g.a;
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(new RuntimeException("not support"));
    }

    public final List<Header> e(Map<String, String> r5) {
        if (r5 == null) goto L4;
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Map.Entry<String, String> r1 = r6.next();
        r0.add(new Header(r1.getKey(), r1.getValue()));
        goto L7
    L9:
        return r0;
    L4:
        return new ArrayList();
    }

    public static final String d(v r2, Response r3) {
        r2.getClass();
        List r4 = r3.getHeaders();
        if (r4 == null) goto L15;
        Iterator r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Object r6 = r5.next();
        if (Intrinsics.areEqual("x-tt-logid", ((Header) r6).getName()) == false) goto L6;
    L11:
        Header r7 = (Header) r6;
        if (r7 == null) goto L15;
        String r8 = r7.getValue();
        if (r8 == null) goto L15;
        return r8;
    L10:
        r6 = null;
    L15:
        return BuildConfig.FLAVOR;
    }

    public final void b(com.ss.ugc.live.sdk.msg.network.f r5, com.ss.ugc.live.sdk.msg.network.e r6) {
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "callback");
        TypedOutput r0 = new TypedByteArray(r5.g, r5.a(), new String[0]);
        IUplinkApi r1 = this.a;
        String r2 = r5.b;
        List<Header> r3 = e(r5.c);
        Map<String, String> r7 = r5.d;
        if (r7 != null) goto L5;
        r7 = new HashMap();
    L5:
        r1.doPostAsync(r2, r3, r7, r0).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r6), new b(r6));
    }

    public final void c(com.ss.ugc.live.sdk.msg.network.f r4, lmc.a.f r5) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "callback");
        IUplinkApi r0 = this.a;
        String r1 = r4.b;
        List<Header> r2 = e(r4.c);
        Map<String, String> r6 = r4.d;
        if (r6 != null) goto L5;
        r6 = new HashMap();
    L5:
        r0.doGetAsync(r1, r2, r6).compose(RxUtil.rxSchedulerHelper()).subscribe(new t(this, r5), new u(r5));
    }
}
