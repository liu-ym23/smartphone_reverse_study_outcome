package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.nio.charset.Charset;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements Converter<TypedInput, NativePrefetchResponse> {

    public static final class a {
    }

    public m() {
    }

    public final /* synthetic */ Object convertWithRequestBuilder(Object r1, RequestBuilder r10) {
        return Converter.-CC.$default$convertWithRequestBuilder(this, r1, r10);
    }

    public final /* synthetic */ boolean needRequestBuilder() {
        return Converter.-CC.$default$needRequestBuilder(this);
    }

    static {
    }

    public final Object convert(Object r10) {
        TypedByteArray r11 = (TypedInput) r10;
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        if ((r11 instanceof TypedByteArray) == false) goto L9;
        String r1 = "UTF-8";
        if (r11.mimeType() == null) goto L8;
        r1 = MimeUtil.parseCharset(r11.mimeType(), "UTF-8");     // Catch: Throwable -> L11
    L8:
        NativePrefetchResponse r12 = new NativePrefetchResponse();     // Catch: Throwable -> L11
        r12.setData(new String(r11.getBytes(), Charset.forName(r1)));     // Catch: Throwable -> L11
        return r12;
    L9:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        return null;
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
