package com.larus.bmhome.upload.audio;

import com.bytedance.apm.util.u;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z;
import com.larus.voicecall.impl.component.picture.x;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final g a = null;
    public static final Map<String, l> b = null;

    public g() {
    }

    static {
        a = new g();
        b = new LinkedHashMap();
    }

    public static final Object a(g r17, c r18, Function2 r19, e r20, Continuation r21) {
        r17.getClass();
        if ((r21 instanceof AudioResourceUploader$upload$1) == false) goto L7;
        AudioResourceUploader$upload$1 r1 = (AudioResourceUploader$upload$1) r21;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        String r13 = "AudioImageUploader";
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        com.larus.network.http.a r4 = (com.larus.network.http.a) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r13 = "AudioImageUploader";
    L37:
        FLogger.a.e(r13, "api(/alice/audio/upload_file) error, msg:" + ((com.larus.network.http.f) r4).d);
    L44:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function2 r5 = (Function2) r1.L$0;
        ResultKt.throwOnFailure(r0);
        Object r6 = r0;
    L31:
        com.larus.network.http.a r7 = (com.larus.network.http.a) r6;
        if ((r7 instanceof com.larus.network.http.f) == false) goto L39;
        AsyncThrowable r8 = ((com.larus.network.http.f) r7).d;
        r1.L$0 = r7;
        r1.label = 2;
        if (r5.invoke(r8, r1) == r14) goto L48;
        r4 = r7;
        goto L37
    L48:
        return r14;
    L39:
        if ((r7 instanceof y) == false) goto L44;
        FLogger.a.d(r13, "api(/alice/audio/upload_file) success");
        Object r9 = ((com.larus.network.http.a) ((y) r7)).b;
        if ((r9 instanceof k) == false) goto L44;
        return (k) r9;
    L16:
        ResultKt.throwOnFailure(r0);
        String r10 = z.c(r18);
        if (r10 != null) goto L19;
    L22:
        boolean r11 = true;
    L23:
        if (r11 == false) goto L25;
    L43:
        FLogger.a.e("AudioImageUploader", "input nothing!");
        goto L44
    L25:
        if (StringsKt.isBlank(r10) == true) goto L43;
        JSONObject r12 = new JSONObject(r10);
        f r15 = new f(r20);
        r1.L$0 = r19;
        r1.label = 1;
        Object r16 = HttpExtKt.k("Audio", i.class, "/alice/audio/upload_file", r12, null, null, false, null, null, r15, r1, 496);
        if (r16 == r14) goto L47;
        r6 = r16;
        r5 = r19;
        goto L31
    L47:
        return r14;
    L19:
        if (r10.length() == 0) goto L22;
        r11 = false;
    L7:
        r1 = new AudioResourceUploader$upload$1(r17, r21);
        goto L8
    }

    public static Object b(List r9, String r10, String r11, x r12, com.larus.voicecall.impl.component.picture.y r13, Continuation r14) {
        AudioResourceUploader$upLoadImage$task$1 r8 = new AudioResourceUploader$upLoadImage$task$1(r10, r11, r9, r13, new d(), r12, null);
        if (u.a() == false) goto L8;
        Object r15 = BuildersKt.withContext(Dispatchers.getIO(), new AudioResourceUploader$upLoadImage$5(r8, null), r14);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r15;
    L13:
        return Unit.INSTANCE;
    L8:
        Object r16 = r8.invoke(r14);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r16;
    L12:
        return Unit.INSTANCE;
    }
}
