package com.bytedance.ai.bridge.method.media;

import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import com.byted.cast.sink.api.ServerInfo;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.media.image.AbsGetImageInfoMethodIDL;
import com.bytedance.ai.file.AppletFileError;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.utils.g;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import e3.d;
import f3.h;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import k3.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/method/media/GetImageInfoMethod;", "Lcom/bytedance/ai/bridge/media/image/AbsGetImageInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/media/image/AbsGetImageInfoMethodIDL$GetImageInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/media/image/AbsGetImageInfoMethodIDL$GetImageInfoResultModel;", "handleLocalImage", "src", "", "handleNetworkImage", "getOrientation", "filePath", "getImageType", "mimeType", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetImageInfoMethod extends AbsGetImageInfoMethodIDL {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.media.GetImageInfoMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.media.GetImageInfoMethod$handle$1", f = "GetImageInfoMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ d $bridgeContext;
        final /* synthetic */ h<AbsGetImageInfoMethodIDL.b> $callback;
        final /* synthetic */ AbsGetImageInfoMethodIDL.a $params;
        int label;
        final /* synthetic */ GetImageInfoMethod this$0;

        public AnonymousClass1(AbsGetImageInfoMethodIDL.a r1, GetImageInfoMethod r10, h<AbsGetImageInfoMethodIDL.b> r11, d r12, Continuation<? super AnonymousClass1> r13) {
            this.$params = r1;
            this.this$0 = r10;
            this.$callback = r11;
            this.$bridgeContext = r12;
            super(2, r13);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$params, this.this$0, this.$callback, this.$bridgeContext, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r10);
            String r0 = this.$params.getSrc();     // Catch: Exception -> L14
            boolean r11 = false;
            if (StringsKt.startsWith$default(r0, "http://", false, 2, null) == false) goto L8;
        L9:
            r11 = true;
        L10:
            if (r11 == false) goto L12;
            GetImageInfoMethod.d(this.this$0, r0, this.$callback);     // Catch: Exception -> L14
        L20:
            return Unit.INSTANCE;
        L12:
            GetImageInfoMethod.c(this.this$0, this.$bridgeContext, r0, this.$callback);     // Catch: Exception -> L14
            goto L20
        L8:
            if (StringsKt.startsWith$default(r0, "https://", false, 2, null) == false) goto L10;
        L14:
            e = move-exception;
            g r1 = g.a;
            StringBuilder r12 = new StringBuilder("call failed, errNo=");
            f3.a r13 = f3.a.f;
            r12.append(r13.a);
            r12.append(", msg=");
            r12.append(e.getMessage());
            r1.e("AISDK_JSB_GetImageInfoMethod", r12.toString());
            h<AbsGetImageInfoMethodIDL.b> r14 = this.$callback;
            String r15 = e.getMessage();
            if (r15 != null) goto L18;
            r15 = "unknown error";
        L18:
            h.a.a(r14, r15, r13, null, 10);
            goto L20
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public GetImageInfoMethod() {
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection b(URL r10) throws IOException {
        String r11 = r10.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r12 = r10.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r11, r12) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r11 + " path=" + r12);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r11, r12), r11, r12);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r10);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r10.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public static int e(ExifInterface r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {"Orientation", 1};
        f06.b r13 = new f06.b();
        g06.a r10 = (g06.a) ApiHookConfig.b.get(100022);
        if (r10 == null) goto L5;
        f06.a[] r11 = r10.i;
    L6:
        f06.a[] r12 = r11;
        int r14 = r12.length;
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L15;
        f06.a r16 = r12[r15];
        int r17 = r15;
        int r18 = r14;
        f06.a[] r19 = r12;
        f06.d r21 = r16.preInvoke(100022, "android/media/ExifInterface", "getAttributeInt", r20, r1, "int", r13);     // Catch: Exception -> L22
        if (r21.a == true) goto L17;
        r0.add(r16);     // Catch: Exception -> L22
    L17:
        if (r21.a == false) goto L21;
        return ((Integer) r21.b).intValue();
    L21:
        return r20.getAttributeInt("Orientation", 1);
    L14:
        r15 = r17 + 1;
        r14 = r18;
        r12 = r19;
        goto L8
    L15:
        r21 = new f06.d(false, null);
        goto L17
    L5:
        r11 = ApiHookConfig.d;
        goto L6
    }

    public static String f(String r10) {
        if (r10 == null) goto L31;
        String r1 = "jpeg";
        if (StringsKt.contains$default(r10, "jpeg", false, 2, null) == true) goto L29;
        if (StringsKt.contains$default(r10, "jpg", false, 2, null) == true) goto L29;
        r1 = "png";
        if (StringsKt.contains$default(r10, "png", false, 2, null) == true) goto L29;
        r1 = "gif";
        if (StringsKt.contains$default(r10, "gif", false, 2, null) == true) goto L29;
        r1 = "webp";
        if (StringsKt.contains$default(r10, "webp", false, 2, null) == true) goto L29;
        r1 = "bmp";
        if (StringsKt.contains$default(r10, "bmp", false, 2, null) == true) goto L29;
        r1 = "heif";
        if (StringsKt.contains$default(r10, "heif", false, 2, null) == true) goto L29;
        if (StringsKt.contains$default(r10, "heic", false, 2, null) == true) goto L29;
        return StringsKt.substringAfter(r10, "/", "unknown");
    L29:
        return r1;
    L31:
        return "unknown";
    }

    public static final void d(GetImageInfoMethod r10, String r11, h r12) {
        r10.getClass();
        InputStream r1 = null;
        URLConnection r13 = b(new URL(r11));     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.net.HttpURLConnection");     // Catch: Throwable -> L24
        HttpURLConnection r14 = (HttpURLConnection) r13;     // Catch: Throwable -> L24
        r14.setConnectTimeout(ServerInfo.ERROR_BIND_SERVICE);     // Catch: Throwable -> L22
        r14.setReadTimeout(ServerInfo.ERROR_BIND_SERVICE);     // Catch: Throwable -> L22
        r14.connect();     // Catch: Throwable -> L22
        InputStream r15 = r14.getInputStream();     // Catch: Throwable -> L22
        BitmapFactory.Options r16 = new BitmapFactory.Options();     // Catch: Throwable -> L20
        r16.inJustDecodeBounds = true;     // Catch: Throwable -> L20
        BitmapFactory.decodeStream(r15, null, r16);     // Catch: Throwable -> L20
        if (r16.outWidth > 0) goto L10;
    L15:
        g r17 = g.a;     // Catch: Throwable -> L20
        StringBuilder r18 = new StringBuilder("call failed, errNo=");     // Catch: Throwable -> L20
        f3.a r0 = f3.a.f;     // Catch: Throwable -> L20
        r18.append(r0.a);     // Catch: Throwable -> L20
        r18.append(", msg=cannot decode network image");     // Catch: Throwable -> L20
        r17.e("AISDK_JSB_GetImageInfoMethod", r18.toString());     // Catch: Throwable -> L20
        h.a.a(r12, "cannot decode network image", r0, null, 10);     // Catch: Throwable -> L20
        if (r15 == null) goto L18;
    L17:
        r15.close();
    L18:
        r14.disconnect();
        return;
    L10:
        if (r16.outHeight <= 0) goto L15;
        String r19 = f(r16.outMimeType);     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(AbsGetImageInfoMethodIDL.b.class, "<this>");     // Catch: Throwable -> L20
        AbsGetImageInfoMethodIDL.b r20 = (AbsGetImageInfoMethodIDL.b) c.a(AbsGetImageInfoMethodIDL.b.class);     // Catch: Throwable -> L20
        r20.setWidth(r16.outWidth);     // Catch: Throwable -> L20
        r20.setHeight(r16.outHeight);     // Catch: Throwable -> L20
        r20.setPath(r11);     // Catch: Throwable -> L20
        r20.setType(r19);     // Catch: Throwable -> L20
        r20.setOrientation("up");     // Catch: Throwable -> L20
        g.a.i("AISDK_JSB_GetImageInfoMethod", "call success, width=" + r16.outWidth + ", height=" + r16.outHeight + ", type=" + r19);     // Catch: Throwable -> L20
        r12.b(r20, "");     // Catch: Throwable -> L20
        if (r15 == null) goto L18;
    L20:
        th = th;
        r1 = r15;
    L26:
        if (r1 == null) goto L28;
        r1.close();
    L28:
        if (r14 == null) goto L30;
        r14.disconnect();
    L30:
        throw th;
    L22:
        th = th;
    L24:
        th = th;
        r14 = null;
        goto L26
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetImageInfoMethodIDL.a r1 = (AbsGetImageInfoMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r13 = g.a;
        r13.i("AISDK_JSB_GetImageInfoMethod", "call start, src length=" + r1.getSrc().length());
        if (StringsKt.isBlank(r1.getSrc()) == false) goto L5;
        StringBuilder r14 = new StringBuilder("call failed, errNo=");
        f3.a r0 = f3.a.h;
        r14.append(r0.a);
        r14.append(", msg=src is empty");
        r13.w("AISDK_JSB_GetImageInfoMethod", r14.toString());
        h.a.a(r12, "src cannot be empty", r0, null, 10);
        return;
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r1, this, r12, r10, null), 3, null);
    }

    public static final void c(GetImageInfoMethod r10, d r11, String r12, h r13) {
        r10.getClass();
        AppletFileManager r14 = x3.a.d(r11);
        if (r14 != null) goto L36;
        g r15 = g.a;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r1 = f3.a.f;
        r16.append(r1.a);
        r16.append(", msg=file manager not available");
        r15.e("AISDK_JSB_GetImageInfoMethod", r16.toString());
        h.a.a(r13, "file manager not available", r1, null, 10);
        return;
    L36:
        int r17 = com.bytedance.ai.file.a.b;     // Catch: AppletFileError -> L29
        File r18 = r14.n(com.bytedance.ai.file.a.C0040a.a(r12));     // Catch: AppletFileError -> L29
        if (r18.exists() == true) goto L9;
        g r19 = g.a;
        StringBuilder r20 = new StringBuilder("call failed, errNo=");
        f3.a r21 = f3.a.t;
        r20.append(r21.a);
        r20.append(", msg=file not found");
        r19.e("AISDK_JSB_GetImageInfoMethod", r20.toString());
        h.a.a(r13, "file does not exist", r21, null, 10);
        return;
    L9:
        BitmapFactory.Options r22 = new BitmapFactory.Options();
        r22.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r18.getAbsolutePath(), r22);
        if (r22.outWidth > 0) goto L12;
    L28:
        g r23 = g.a;
        StringBuilder r24 = new StringBuilder("call failed, errNo=");
        f3.a r25 = f3.a.f;
        r24.append(r25.a);
        r24.append(", msg=cannot decode image dimensions");
        r23.e("AISDK_JSB_GetImageInfoMethod", r24.toString());
        h.a.a(r13, "cannot decode image dimensions", r25, null, 10);
        return;
    L12:
        if (r22.outHeight <= 0) goto L28;
        switch(e(new ExifInterface(r18.getAbsolutePath()))) {
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            default: goto L26;
        };     // Catch: Exception -> L35
    L18:
        String r26 = "left";
    L27:
        String r27 = f(r22.outMimeType);
        Intrinsics.checkNotNullParameter(AbsGetImageInfoMethodIDL.b.class, "<this>");
        AbsGetImageInfoMethodIDL.b r0 = (AbsGetImageInfoMethodIDL.b) c.a(AbsGetImageInfoMethodIDL.b.class);
        r0.setWidth(r22.outWidth);
        r0.setHeight(r22.outHeight);
        r0.setPath(r12);
        r0.setType(r27);
        r0.setOrientation(r26);
        g.a.i("AISDK_JSB_GetImageInfoMethod", "call success, width=" + r22.outWidth + ", height=" + r22.outHeight + ", type=" + r27);
        r13.b(r0, "");
        return;
    L19:
        r26 = "right-mirrored";
        goto L27
    L20:
        r26 = "right";
        goto L27
    L21:
        r26 = "left-mirrored";
        goto L27
    L22:
        r26 = "down-mirrored";
        goto L27
    L23:
        r26 = "down";
        goto L27
    L24:
        r26 = "up-mirrored";
    L26:
        r26 = "up";
    L29:
        e = move-exception;
        g r28 = g.a;
        StringBuilder r29 = new StringBuilder("call failed, errNo=");
        f3.a r30 = f3.a.v;
        r29.append(r30.a);
        r29.append(", msg=");
        r29.append(e.getMessage());
        r28.e("AISDK_JSB_GetImageInfoMethod", r29.toString());
        String r31 = e.getMessage();
        if (r31 != null) goto L33;
        r31 = "invalid file path";
    L33:
        h.a.a(r13, r31, r30, null, 10);
    }
}
