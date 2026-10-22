package com.obric.aikernel.sdk;

import android.os.Parcel;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aikernel.core.log.AIKLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005\u001a2\u0010\u0006\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00072\u0019\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\t¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"resume", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "ret", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "safeRead", "Landroid/os/Parcel;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/os/Parcel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ExtsKt {
    public static final <T> void resume(Continuation<? super T> r2, T r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        r4.resumeWith(Result.m1421constructorimpl(r3));     // Catch: Throwable -> L5
        Object r5 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L13;
        AIKLog.INSTANCE.w("Continuation", "resume failed, " + r6);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final <T> T safeRead(Parcel r2, Function1<? super Parcel, ? extends T> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "block");
        if (r2.dataAvail() > 0) goto L7;
        return null;
    L7:
        return (T) r4.invoke(r2);
    }
}
