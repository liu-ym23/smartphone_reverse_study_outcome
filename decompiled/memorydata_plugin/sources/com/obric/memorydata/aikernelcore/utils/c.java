package com.obric.memorydata.aikernelcore.utils;

import android.content.Context;
import android.net.Uri;
import com.google.gson.JsonSyntaxException;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.OcrLineResult;
import com.obric.memorydata.utils.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0005J2\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/aikernelcore/utils/OcrUtils;", "", "<init>", "()V", "TAG", "", "PACKAGE_NAME_AIKERNEL", "processImageWithOptions", "Lcom/obric/memorydata/aikernelcore/utils/OcrResult;", "imagePath", "args", "Lorg/json/JSONObject;", "foregroundCallerPkg", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseOcrResult", "", "Lcom/obric/memorydata/utils/OcrLineResult;", "jsonString", "getOcrDetectResizeShape", "Lkotlin/Pair;", "", "oriWidth", "oriHeight", "targetWidth", "targetHeight", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8488a = null;

    static {
        f8488a = new c();
    }

    private c() {
    }

    public final Object a(String r8, JSONObject r9, String r10, Continuation<? super b> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, OcrUtils$processImageWithOptions$1.class) == false) goto L7;
        OcrUtils$processImageWithOptions$1 r0 = (OcrUtils$processImageWithOptions$1) ZeusTransformUtils.preCheckCast(r12, OcrUtils$processImageWithOptions$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        List<OcrLineResult> r4 = null;
        boolean r5 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        c this = (c) ZeusTransformUtils.preCheckCast(r0.L$0, c.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L21:
        JSONObject r14 = (JSONObject) ZeusTransformUtils.preCheckCast(r13, JSONObject.class, "com.obric.memorydata.plugin");
        int r15 = r14.optInt("errorCode");
        String r16 = r14.optString("errorInfo");
        if (r16 != null) goto L24;
        r16 = "";
    L24:
        String r17 = r14.optString("data");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L27;
    L30:
        if (r5 == true) goto L34;
        r4 = this.a(r17);
    L34:
        return new b(r15, r16, r4);
    L27:
        if (r1.length() == 0) goto L30;
        r5 = false;
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        Uri r18 = ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.fileprovider", new File(r8), "com.obric.memorydata.plugin");
        if (r18 == null) goto L17;
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).grantUriPermission("com.obric.aikernel", r18, 3);
        com.obric.memorydata.aikernelcore.a r19 = com.obric.memorydata.aikernelcore.a.INSTANCE;
        r0.L$0 = this;
        r0.label = 1;
        r13 = r19.a(r18, r9, r10, r0);
        if (r13 != r2) goto L21;
        return r2;
    L17:
        return new b(OcrErrorCode.FILE_AUTHORITY_ERROR.getCode(), "文件授权失败", null);
    L7:
        r0 = new OcrUtils$processImageWithOptions$1(this, r12);
        goto L8
    }

    public final List<OcrLineResult> a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "jsonString");
        Object r4 = ab.a().fromJson(r3, OcrLineResult[].class);     // Catch: JsonSyntaxException -> L5
        Intrinsics.checkNotNullExpressionValue(r4, "fromJson(...)");     // Catch: JsonSyntaxException -> L5
        return ArraysKt.toList((Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("OcrUtils", "Json syntax error while parsing OCR result", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }
}
