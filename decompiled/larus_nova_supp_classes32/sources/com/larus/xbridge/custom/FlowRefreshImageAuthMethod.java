package com.larus.xbridge.custom;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "flow.refreshImageAuth")
public final class FlowRefreshImageAuthMethod extends XCoreIDLBridgeMethod<e, f> {
    public final String a;
    public final int b;

    @XBridgeMethodName(name = "flow.refreshImageAuth", params = {LynxEventReporter.PROP_NAME_URL})
    public final String c;
    public final Lazy d;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bb\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH'¨\u0006\n"}, d2 = {"Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshImageAuthApi;", NameKeys.UnloadStrategy_No_Strategy, "refreshFileUrl", "Lcom/bytedance/retrofit2/Call;", "Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlResp;", "body", "Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlReq;", "headers", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface RefreshImageAuthApi {
        @POST("/alice/upload/refresh_file_url")
        Call<d> refreshFileUrl(@Body c r1, @HeaderMap Map<String, String> r2);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrl;", NameKeys.UnloadStrategy_No_Strategy, "mainUrl", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;)V", "getMainUrl", "()Ljava/lang/String;", "component1", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("main_url")
        private final String mainUrl;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.mainUrl, ((a) r4).mainUrl) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.mainUrl;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "RefreshFileUrl(mainUrl=" + this.mainUrl + ')';
        }

        public a() {
            this.mainUrl = null;
        }

        public final String a() {
            return this.mainUrl;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlData;", NameKeys.UnloadStrategy_No_Strategy, "fileUrls", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrl;", "<init>", "(Ljava/util/List;)V", "getFileUrls", "()Ljava/util/List;", "component1", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", NameKeys.UnloadStrategy_No_Strategy, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("file_urls")
        private final List<a> fileUrls;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.fileUrls, ((b) r4).fileUrls) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<a> r0 = this.fileUrls;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "RefreshFileUrlData(fileUrls=" + this.fileUrls + ')';
        }

        public b() {
            this.fileUrls = null;
        }

        public final List<a> a() {
            return this.fileUrls;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlReq;", NameKeys.UnloadStrategy_No_Strategy, LynxEventReporter.PROP_NAME_URL, NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        @SerializedName(LynxEventReporter.PROP_NAME_URL)
        private final String url;

        public c() {
            this(null);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.url, ((c) r4).url) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r0 = this.url;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "RefreshFileUrlReq(url=" + this.url + ')';
        }

        public c(String r1) {
            this.url = r1;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlResp;", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.CODE_KEY, NameKeys.UnloadStrategy_No_Strategy, "msg", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.DATA_KEY, "Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlData;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlData;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlData;)Lcom/larus/xbridge/custom/FlowRefreshImageAuthMethod$RefreshFileUrlResp;", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d {

        @SerializedName(LynxResourceModule.CODE_KEY)
        private final Integer code;

        @SerializedName(LynxResourceModule.DATA_KEY)
        private final b data;

        @SerializedName("msg")
        private final String msg;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.code, r6.code) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.data, r6.data) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.code;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.msg;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            b r7 = this.data;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "RefreshFileUrlResp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public d() {
            this.code = null;
            this.msg = null;
            this.data = null;
        }

        public final Integer a() {
            return this.code;
        }

        public final b b() {
            return this.data;
        }

        public final String c() {
            return this.msg;
        }
    }

    @XBridgeParamModel
    public interface e extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = LynxEventReporter.PROP_NAME_URL, required = true)
        String getUrl();
    }

    @XBridgeResultModel
    public interface f extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = LynxEventReporter.PROP_NAME_URL, required = true)
        String getUrl();

        @XBridgeParamField(isGetter = false, keyPath = LynxEventReporter.PROP_NAME_URL, required = true)
        void setUrl(String r1);
    }

    /* JADX INFO: renamed from: com.larus.xbridge.custom.FlowRefreshImageAuthMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.xbridge.custom.FlowRefreshImageAuthMethod$handle$1", f = "FlowRefreshImageAuthMethod.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletionBlock<f> $callback;
        final /* synthetic */ String $originUrl;
        final /* synthetic */ String $safeOriginUrl;
        int label;
        final /* synthetic */ FlowRefreshImageAuthMethod this$0;

        /* JADX INFO: renamed from: com.larus.xbridge.custom.FlowRefreshImageAuthMethod$handle$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.xbridge.custom.FlowRefreshImageAuthMethod$handle$1$1", f = "FlowRefreshImageAuthMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CompletionBlock<f> $callback;
            final /* synthetic */ String $refreshedUrl;
            final /* synthetic */ String $safeOriginUrl;
            int label;
            final /* synthetic */ FlowRefreshImageAuthMethod this$0;

            public C00261(String r1, FlowRefreshImageAuthMethod r2, String r3, CompletionBlock<f> r4, Continuation<? super C00261> r5) {
                this.$refreshedUrl = r1;
                this.this$0 = r2;
                this.$safeOriginUrl = r3;
                this.$callback = r4;
                super(2, r5);
            }

            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new C00261(this.$refreshedUrl, this.this$0, this.$safeOriginUrl, this.$callback, r8);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r9) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L17;
                ResultKt.throwOnFailure(r9);
                String r10 = this.$refreshedUrl;
                if (r10 != null) goto L7;
            L10:
                boolean r11 = true;
            L11:
                if (r11 == false) goto L14;
                FLogger.a.e(this.this$0.a, "[handle] refresh failed, url=" + this.$safeOriginUrl);
                CompletionBlock.DefaultImpls.onFailure$default(this.$callback, 0, "refresh failed", null, 4, null);
                return Unit.INSTANCE;
            L14:
                FLogger.a.i(this.this$0.a, "[handle] refresh success, url=" + this.$safeOriginUrl);
                f r12 = ne7.e.b(f.class);
                r12.setUrl(this.$refreshedUrl);
                CompletionBlock.DefaultImpls.onSuccess$default(this.$callback, r12, null, 2, null);
                return Unit.INSTANCE;
            L7:
                if (StringsKt.isBlank(r10) == true) goto L10;
                r11 = false;
                goto L11
            L17:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(FlowRefreshImageAuthMethod r1, String r2, String r3, CompletionBlock<f> r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$originUrl = r2;
            this.$safeOriginUrl = r3;
            this.$callback = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$originUrl, this.$safeOriginUrl, this.$callback, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L23:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            FlowRefreshImageAuthMethod r11 = this.this$0;
            String r2 = this.$originUrl;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
            Object r12 = Result.constructor-impl(FlowRefreshImageAuthMethod.a(r11, r2));     // Catch: Throwable -> L11
        L13:
            FlowRefreshImageAuthMethod r4 = this.this$0;
            String r5 = this.$safeOriginUrl;
            Throwable r6 = Result.exceptionOrNull-impl(r12);
            if (r6 == null) goto L17;
            FLogger.a.e(r4.a, "[handle] refresh exception, url=" + r5, r6);
        L17:
            if (Result.isFailure-impl(r12) == false) goto L19;
            r12 = null;
        L19:
            String r7 = (String) r12;
            MainCoroutineDispatcher r13 = Dispatchers.getMain();
            C00261 r8 = new C00261(r7, this.this$0, this.$safeOriginUrl, this.$callback, null);
            this.label = 1;
            if (BuildersKt.withContext(r13, r8, this) != r0) goto L23;
            return r0;
        L11:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L13
        }
    }

    public FlowRefreshImageAuthMethod() {
        this.a = "FlowRefreshImageAuth";
        this.b = 1;
        this.c = "flow.refreshImageAuth";
        this.d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new m1());
    }

    public final String getName() {
        return this.c;
    }

    public static final String a(FlowRefreshImageAuthMethod r8, String r9) {
        Call<d> r10 = ((RefreshImageAuthApi) r8.d.getValue()).refreshFileUrl(new c(r9), MapsKt.emptyMap());
        if (r10 == null) goto L5;
        SsResponse r11 = r10.execute();
    L6:
        boolean r1 = true;
        if (r11 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L18;
        FLogger r2 = FLogger.a;
        String r12 = r8.a;
        StringBuilder r4 = new StringBuilder("[refreshUrl] request failed, httpCode=");
        if (r11 == null) goto L16;
        Integer r13 = Integer.valueOf(r11.code());
    L17:
        r4.append(r13);
        r2.e(r12, r4.toString());
        return null;
    L16:
        r13 = null;
        goto L17
    L18:
        d r14 = (d) r11.body();
        if (r14 == null) goto L33;
        b r5 = r14.b();
        if (r5 == null) goto L33;
        List<a> r6 = r5.a();
        if (r6 == null) goto L33;
        a r7 = (a) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L33;
        String r15 = r7.a();
        if (r15 == null) goto L33;
        String r16 = StringsKt.trim(r15).toString();
        if (r16 == null) goto L33;
        String r17 = StringsKt.trim(r16, new char[]{'`'});
        if (r17 == null) goto L33;
        String r18 = StringsKt.trim(r17).toString();
    L34:
        FLogger r19 = FLogger.a;
        String r20 = r8.a;
        StringBuilder r21 = new StringBuilder("[refreshUrl] serverCode=");
        if (r14 == null) goto L37;
        Integer r22 = r14.a();
    L38:
        r21.append(r22);
        r21.append(", serverMsg=");
        if (r14 == null) goto L41;
        String r23 = r14.c();
    L42:
        r21.append(r23);
        r21.append(", hasUrl=");
        if (r18 != null) goto L45;
    L48:
        boolean r24 = true;
    L49:
        r21.append(!r24);
        r19.i(r20, r21.toString());
        if (r18 != null) goto L52;
    L55:
        boolean r25 = true;
    L56:
        if (r25 == false) goto L78;
        if (r14 == null) goto L65;
        Integer r26 = r14.a();
        int r27 = r8.b;
        if (r26 == null) goto L65;
        if (r26.intValue() != r27) goto L65;
    L66:
        if (r1 == true) goto L79;
        String r28 = r8.a;
        StringBuilder r29 = new StringBuilder("[refreshUrl] server error, code=");
        if (r14 == null) goto L70;
        Integer r30 = r14.a();
    L71:
        r29.append(r30);
        r29.append(", msg=");
        if (r14 == null) goto L74;
        String r31 = r14.c();
    L75:
        r29.append(r31);
        r19.e(r28, r29.toString());
        return null;
    L74:
        r31 = null;
        goto L75
    L70:
        r30 = null;
        goto L71
    L79:
        return null;
    L65:
        r1 = false;
        goto L66
    L78:
        return r18;
    L52:
        if (StringsKt.isBlank(r18) == true) goto L55;
        r25 = false;
        goto L56
    L45:
        if (StringsKt.isBlank(r18) == true) goto L48;
        r24 = false;
        goto L49
    L41:
        r23 = null;
        goto L42
    L37:
        r22 = null;
    L33:
        r18 = null;
        goto L34
    L9:
        if (r11.isSuccessful() != true) goto L11;
        r3 = true;
        goto L12
    L5:
        r11 = null;
        goto L6
    }

    public final void handle(IBDXBridgeContext r11, XBaseParamModel r12, CompletionBlock r13) {
        e r14 = (e) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r13, "callback");
        String r2 = r14.getUrl();
        if (StringsKt.isBlank(r2) == false) goto L5;
        FLogger.a.e(this.a, "[handle] invalid url");
        CompletionBlock.DefaultImpls.onFailure$default(r13, 0, "invalid url", null, 4, null);
        return;
    L5:
        String r15 = StringsKt.substringBefore$default(r2, '?', null, 2, null);
        if (r15.length() == r2.length()) goto L9;
        r15 = r15.concat("?…");
    L9:
        String r3 = r15;
        FLogger.a.i(this.a, "[handle] start, url=" + r3);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass1(this, r2, r3, r13, null), 2, null);
    }
}
