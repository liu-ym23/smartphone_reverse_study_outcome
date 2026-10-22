package dp8;

import android.os.Build;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.Image;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final CreationMsgContentData a(String r5) {
        Object r0 = null;
        if (r5 == null) goto L19;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        h.a.getClass();     // Catch: Throwable -> L6
        Object r6 = Result.constructor-impl((CreationMsgContentData) h.b.fromJson(r5, CreationMsgContentData.class));     // Catch: Throwable -> L6
    L8:
        Throwable r2 = Result.exceptionOrNull-impl(r6);
        if (r2 == null) goto L12;
        FLogger.a.e("CreationDataConverter", "convertToCreationContentData failed", r2);
    L12:
        if (Result.isFailure-impl(r6) == true) goto L16;
        r0 = r6;
    L16:
        return (CreationMsgContentData) r0;
    L6:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    L19:
        return null;
    }

    public static final String b(Image r4) {
        if (z2.a.imageGenerateHeicConfig().a == false) goto L19;
        if (r4 == null) goto L6;
        String r0 = r4.b;
    L8:
        if (o0.d(r0) == false) goto L19;
        if (Build.VERSION.SDK_INT <= 26) goto L19;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("use urlV2 is ");
        if (r4 == null) goto L14;
        String r3 = r4.b;
    L15:
        r2.append(r3);
        r1.d("data converter", r2.toString());
        if (r4 != null) goto L18;
        return null;
    L18:
        return r4.b;
    L14:
        r3 = null;
        goto L15
    L6:
        r0 = null;
    L19:
        if (r4 != null) goto L21;
        return null;
    L21:
        return r4.a;
    }

    public static final CreationMsgContentData c(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Pair<String, CreationMsgContentData> r0 = b.a;
        return b.a(r1.getContent(), new c());
    }
}
