package oy7;

import com.alibaba.fastjson.JSON;
import com.larksuite.component.blockit.entity.BatchGetItemTagsRequest;
import com.larksuite.component.blockit.entity.BatchGetItemTagsResponseWrap;
import com.larksuite.component.blockit.entity.BatchTagActionRequest;
import com.larksuite.component.blockit.entity.BatchTagActionResponseWrap;
import com.larksuite.component.blockit.entity.BlockitEnv;
import com.larksuite.component.blockit.props.i;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.http.request.HttpMethod;
import com.larksuite.framework.http.request.RequestBody;
import com.larksuite.framework.http.response.BaseResponse;
import com.larksuite.framework.http.response.ErrorResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Collections;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {

    /* JADX INFO: renamed from: oy7.a$a, reason: collision with other inner class name */
    public class C0118a extends z18.b<BaseResponse> {
        public final /* synthetic */ String a;
        public final /* synthetic */ IGetDataCallback b;

        @Override // z18.b
        public final void a(ErrorResult r4) {
            Log.w("HashTagService", r4.toString());
            IGetDataCallback r0 = this.b;
            if (r0 == null) goto L6;
            r0.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r4.getHttpStatusCode(), r4.getErrorMessage()));
            return;
        }

        @Override // z18.c
        public final void onSuccess(Object r6) {
            BaseResponse r7 = (BaseResponse) r6;
            if (r7 == null) goto L28;
            String r8 = r7.message();     // Catch: Exception -> L16
            BatchGetItemTagsResponseWrap r2 = (BatchGetItemTagsResponseWrap) JSON.parseObject(r8, BatchGetItemTagsResponseWrap.class);     // Catch: Exception -> L14
            if (r2.code != 0) goto L10;
            i.b.a.a(this.a, r2.data.itemsTags);     // Catch: Exception -> L14
            IGetDataCallback r1 = this.b;     // Catch: Exception -> L14
            if (r1 == null) goto L24;
            r1.onSuccess(r2.data);     // Catch: Exception -> L14
        L24:
            return;
        L10:
            Log.w("HashTagService", "result:" + r8);     // Catch: Exception -> L14
            IGetDataCallback r3 = this.b;     // Catch: Exception -> L14
            if (r3 == null) goto L24;
            r3.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r2.code, r2.msg));     // Catch: Exception -> L14
        L14:
            e = e;
        L18:
            Log.w("HashTagService", "getTagList result:" + r8, e);
            IGetDataCallback r9 = this.b;
            if (r9 == null) goto L29;
            r9.onError(new com.larksuite.framework.callback.Entity.ErrorResult("Error"));
            return;
        L29:
            return;
        L16:
            e = e;
            r8 = null;
            goto L18
        }

        public C0118a(String r1, IGetDataCallback r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public class b extends z18.b<BaseResponse> {
        public final /* synthetic */ String a;
        public final /* synthetic */ IGetDataCallback b;

        @Override // z18.b
        public final void a(ErrorResult r4) {
            Log.w("HashTagService", r4.toString());
            IGetDataCallback r0 = this.b;
            if (r0 == null) goto L6;
            r0.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r4.getHttpStatusCode(), r4.getErrorMessage()));
            return;
        }

        @Override // z18.c
        public final void onSuccess(Object r6) {
            BaseResponse r7 = (BaseResponse) r6;
            if (r7 == null) goto L28;
            String r8 = r7.message();     // Catch: Exception -> L16
            BatchTagActionResponseWrap r2 = (BatchTagActionResponseWrap) JSON.parseObject(r8, BatchTagActionResponseWrap.class);     // Catch: Exception -> L14
            if (r2.code != 0) goto L10;
            i.b.a.a(this.a, r2.data.latestItemTags);     // Catch: Exception -> L14
            IGetDataCallback r1 = this.b;     // Catch: Exception -> L14
            if (r1 == null) goto L24;
            r1.onSuccess(r2.data);     // Catch: Exception -> L14
        L24:
            return;
        L10:
            Log.w("HashTagService", "result:" + r8);     // Catch: Exception -> L14
            IGetDataCallback r3 = this.b;     // Catch: Exception -> L14
            if (r3 == null) goto L24;
            r3.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r2.code, r2.msg));     // Catch: Exception -> L14
        L14:
            e = e;
        L18:
            Log.w("HashTagService", "batchTagAction result:" + r8, e);
            IGetDataCallback r9 = this.b;
            if (r9 == null) goto L29;
            r9.onError(new com.larksuite.framework.callback.Entity.ErrorResult("Error"));
            return;
        L29:
            return;
        L16:
            e = e;
            r8 = null;
            goto L18
        }

        public b(String r1, IGetDataCallback r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BlockitEnv.values().length];
            a = r0;
            r0[BlockitEnv.STAGING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[BlockitEnv.PRE_RELEASE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[BlockitEnv.ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final class d {
        public static final /* synthetic */ int a = 0;

        static {
            new a();
        }
    }

    public a() {
    }

    public static String b() {
        int r0 = c.a[((com.larksuite.component.blockit.d) ApiUtils.getApi(com.larksuite.component.blockit.d.class)).getEnv().ordinal()];
        if (r0 != 2) goto L5;
        return "https://oa.feishu-pre.cn/pano";
    L5:
        if (r0 == 3) goto L8;
        return "https://oa.feishu-boe.cn/pano";
    L8:
        return "https://oa.feishu.cn/pano";
    }

    public static void a(String r3, BatchTagActionRequest r4, IGetDataCallback r5) {
        Log.i("HashTagService", "batchTagAction: " + r3);
        String r6 = JSON.toJSONString(r4);
        z18.a r1 = new z18.a(HttpMethod.POST, b().concat("/api/BatchTagAction"));
        r1.e = RequestBody.create("application/json", r6);
        r1.b = ry7.a.a();
        r1.c(new b(r3, r5));
    }

    public static void c(String r2, boolean r3, boolean r4, String r5, IGetDataCallback r6) {
        Log.i("HashTagService", "getTagList blockId: " + r2);
        BatchGetItemTagsRequest r0 = new BatchGetItemTagsRequest();
        r0.fetchDeletePerm = r3;
        r0.fetchSubscribe = r4;
        r0.uniqIds = Collections.singletonList(r2);
        r0.context = r5;
        r0.needTeamworkerCount = true;
        String r7 = JSON.toJSONString(r0);
        z18.a r8 = new z18.a(HttpMethod.POST, b().concat("/api/BatchGetItemTags"));
        r8.e = RequestBody.create("application/json", r7);
        r8.b = ry7.a.a();
        r8.c(new C0118a(r2, r6));
    }
}
