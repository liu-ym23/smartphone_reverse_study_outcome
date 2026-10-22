package com.bytedance.retrofit2;

import com.bytedance.retrofit2.mime.TypedInput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.Continuation;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    final RequestFactory<ReturnT> requestFactory;

    static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        CallAdapted(RequestFactory r3, CallAdapter<ResponseT, ReturnT> r4) {
            CallAdapter<ResponseT, ReturnT> r5 = (CallAdapter) ZeusTransformUtils.wrapperContextForParams(r4, CallAdapter.class, "com.obric.memorydata.plugin");
            super(r3);
            this.callAdapter = r5;
        }

        @Override // com.bytedance.retrofit2.HttpServiceMethod
        public ReturnT adapt(Call<ResponseT> r2, Object[] r3) {
            Call<ResponseT> r4 = (Call) ZeusTransformUtils.wrapperContextForParams(r2, Call.class, "com.obric.memorydata.plugin");
            return this.callAdapter.adapt(r4);
        }
    }

    static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        private final boolean isNullable;

        SuspendForBody(RequestFactory r3, CallAdapter<ResponseT, Call<ResponseT>> r4, boolean r5) {
            CallAdapter<ResponseT, Call<ResponseT>> r6 = (CallAdapter) ZeusTransformUtils.wrapperContextForParams(r4, CallAdapter.class, "com.obric.memorydata.plugin");
            super(r3);
            this.callAdapter = r6;
            this.isNullable = r5;
        }

        @Override // com.bytedance.retrofit2.HttpServiceMethod
        public Object adapt(Call<ResponseT> r3, Object[] r4) {
            Call r5 = (Call) ZeusTransformUtils.preCheckCast(this.callAdapter.adapt((Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin")), Call.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(r4[r4.length - 1], Continuation.class, "com.obric.memorydata.plugin");
        L8:
            e = move-exception;
            return KotlinExtensions.suspendAndThrow(e, r6);
        L4:
            if (this.isNullable == false) goto L7;
            return KotlinExtensions.awaitNullable(r5, r6);
        L7:
            return KotlinExtensions.await(r5, r6);
        }
    }

    static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        SuspendForResponse(RequestFactory r3, CallAdapter<ResponseT, Call<ResponseT>> r4) {
            CallAdapter<ResponseT, Call<ResponseT>> r5 = (CallAdapter) ZeusTransformUtils.wrapperContextForParams(r4, CallAdapter.class, "com.obric.memorydata.plugin");
            super(r3);
            this.callAdapter = r5;
        }

        @Override // com.bytedance.retrofit2.HttpServiceMethod
        public Object adapt(Call<ResponseT> r3, Object[] r4) {
            Call r2 = (Call) ZeusTransformUtils.preCheckCast(this.callAdapter.adapt((Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin")), Call.class, "com.obric.memorydata.plugin");
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(r4[r4.length - 1], Continuation.class, "com.obric.memorydata.plugin");
            return KotlinExtensions.awaitResponse(r2, r5);
        L5:
            e = move-exception;
            return KotlinExtensions.suspendAndThrow(e, r5);
        }
    }

    HttpServiceMethod(RequestFactory<ReturnT> r1) {
        this.requestFactory = r1;
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit r2, Method r3, Type r4, Annotation[] r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        return (CallAdapter<ResponseT, ReturnT>) r2.callAdapter(r6, r5);
    L5:
        e = move-exception;
        throw Utils.methodError(r3, e, "Unable to create call adapter for %s", new Object[]{r6});
    }

    private static <ResponseT> Converter<TypedInput, ResponseT> createResponseConverter(Retrofit r2, Method r3, Type r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        return r2.responseBodyConverter(r5, r3.getAnnotations());
    L5:
        e = move-exception;
        throw Utils.methodError(r3, e, "Unable to create converter for %s", new Object[]{r5});
    }

    static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit r9, Method r10, RequestFactory r11) {
        boolean r0 = r11.isKotlinSuspendFunction;
        Annotation[] r1 = r10.getAnnotations();
        if (r0 == false) goto L11;
        Type[] r3 = r10.getGenericParameterTypes();
        Type r4 = Utils.getParameterLowerBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r3[r3.length - 1], ParameterizedType.class, "com.obric.memorydata.plugin"));
        if (Utils.getRawType(r4) == SsResponse.class) goto L7;
    L9:
        boolean r5 = false;
    L10:
        Type r6 = new Utils.ParameterizedTypeImpl(null, Call.class, new Type[]{r4});
        r1 = SkipCallbackExecutorImpl.ensurePresent(r1);
    L12:
        CallAdapter r2 = createCallAdapter(r9, r10, r6, r1);
        Type r7 = r2.responseType();
        if (r7 == Response.class) goto L39;
        if (r7 == SsResponse.class) goto L37;
        if (r7 == com.bytedance.retrofit2.client.Response.class) goto L35;
        if (r11.httpMethod.equals(HttpMethodContrants.HEAD) == true) goto L21;
    L25:
        r11.responseConverter = createResponseConverter(r9, r10, r7);
        if (r0 == false) goto L28;
        if (r5 == false) goto L33;
        return new SuspendForResponse(r11, r2);
    L33:
        return new SuspendForBody(r11, r2, false);
    L28:
        return new CallAdapted(r11, r2);
    L21:
        if (Void.class.equals(r7) == true) goto L25;
        throw Utils.methodError(r10, "HEAD method must use Void as response type.", new Object[0]);
    L35:
        throw Utils.methodError(r10, "'" + Utils.getRawType(r7).getName() + "' is not a valid response body type.", new Object[0]);
    L37:
        throw Utils.methodError(r10, "Response must include generic type (e.g., SsResponse<String>)", new Object[0]);
    L39:
        throw Utils.methodError(r10, "'" + Utils.getRawType(r7).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == false) goto L9;
        r4 = Utils.getParameterUpperBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.memorydata.plugin"));
        r5 = true;
        goto L10
    L11:
        r6 = r10.getGenericReturnType();
        r5 = false;
        goto L12
    }

    public abstract ReturnT adapt(Call<ResponseT> r1, Object[] r2);

    @Override // com.bytedance.retrofit2.ServiceMethod
    final ReturnT invoke(Object[] r3) {
        return adapt(new SsHttpCall(this.requestFactory, r3), r3);
    }
}
