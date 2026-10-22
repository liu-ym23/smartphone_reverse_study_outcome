package com.obric.aikernel.res.legacy;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.aikernel.runtime.utils.c;
import com.obric.aikernel.runtime.utils.d;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/obric/aikernel/res/legacy/TTNetHttpClientImpl;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addHeaderInter", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "getAddHeaderInter", "()Lcom/bytedance/retrofit2/intercept/Interceptor;", "isNewUser", "", "()Z", "setNewUser", "(Z)V", CozeCloudExt.API_KEY_HTTP_POST_METHOD, "", "url", "", "body", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6054a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6055b;
    private final Interceptor c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/res/legacy/TTNetHttpClientImpl$Companion;", "", "()V", "EMPTY_URL_ERROR", "", "HAS_SET_USER", "", "NETWORK_TIME_OUT", "", "TAG", "UNKNOWN_ERROR", "USER_TYPE_SP_NAME", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6054a = new a(null);
    }

    public b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        SharedPreferences r6 = r5.getSharedPreferences("pty_user_types", 0);
        if (r6.getInt("has_set_user", 0) != 0) goto L5;
        this.f6055b = true;
    L5:
        r6.edit().putInt("has_set_user", 1).apply();
        this.c = new $$Lambda$b$xCUEQfGj6hbqcuSADHMLMxAUaw(this);
    }

    private static final SsResponse a(b r4, Interceptor.Chain r5) {
        Interceptor.Chain r6 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r5, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "this$0");
        List<Header> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<Header> r2 = r6.request().getHeaders();
        Intrinsics.checkNotNullExpressionValue(r2, "chain.request().headers");
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin"));
        r0.add(new Header(BDNetworkTagManager.KEY_BD_NETWORK_REQUEST_TAG, "t=0;n=" + (r4.f6055b ? 1 : 0)));
        r0.add(new Header("X-Distribute", "ai_kernel"));
        r0.add(new Header("x-use-ppe", "1"));
        return r6.proceed(r6.request().newBuilder().headers(r0).build());
    }

    /* JADX INFO: renamed from: lambda$xCUEQfGj6h-bqcuSADHMLMxAUaw, reason: not valid java name */
    public static /* synthetic */ SsResponse m204lambda$xCUEQfGj6hbqcuSADHMLMxAUaw(b r0, Interceptor.Chain r1) {
        return a(r0, r1);
    }

    public final byte[] a(String r19, byte[] r20) {
        Intrinsics.checkNotNullParameter(r19, "url");
        Intrinsics.checkNotNullParameter(r20, "body");
        Retrofit r3 = RetrofitUtils.b(r19);
        if (r3 != null) goto L7;
        d.f6216a.b("TTNetHttpClientImpl", "url is empty");
        return null;
    L7:
        if (r3.interceptors().contains(this.c) == true) goto L9;
        r3.interceptors().add(this.c);
    L9:
        com.bytedance.ttnet.b.d r0 = new com.bytedance.ttnet.b.d();
        r0.c = 30000;
        r0.d = 30000;
        r0.e = 30000;
        r0.j = true;
        Call<TypedInput> r1 = ((CommonPostService) ZeusTransformUtils.preCheckCast(r3.create(CommonPostService.class), CommonPostService.class, "com.obric.memorydata.plugin")).request(r19, RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r20), r0);
        d.f6216a.b("TTNetHttpClientImpl", "start post " + r19);
        SsResponse<TypedInput> r2 = r1.execute();
        int r4 = r2.code();
        c r8 = (c) ZeusTransformUtils.preCheckCast(d.f6216a, c.class, "com.obric.memorydata.plugin");
        StringBuilder r5 = new StringBuilder().append("end post header info: ");
        List<Header> r6 = r2.headers();
        Intrinsics.checkNotNullExpressionValue(r6, "rawResponse.headers()");
        c.a.a(r8, "TTNetHttpClientImpl", r5.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null)).toString(), 0, 4, null);
        if (r2.isSuccessful() == true) goto L13;
        InputStream r7 = r2.errorBody().in();
        Intrinsics.checkNotNullExpressionValue(r7, "rawResponse.errorBody().`in`()");
        d.f6216a.b("TTNetHttpClientImpl", r4 + ", " + r2.message() + "\n " + new String(ByteStreamsKt.readBytes(r7), Charsets.UTF_8));
        return null;
    L13:
        InputStream r9 = ((TypedInput) ZeusTransformUtils.preCheckCast(r2.body(), TypedInput.class, "com.obric.memorydata.plugin")).in();
        Intrinsics.checkNotNullExpressionValue(r9, "rawResponse.body().`in`()");
        byte[] r10 = ByteStreamsKt.readBytes(r9);
        d.f6216a.b("TTNetHttpClientImpl", "post success " + r4 + ' ' + r10.length);
        return r10;
    }
}
