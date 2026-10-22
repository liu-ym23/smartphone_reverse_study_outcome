package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.graphics.Bitmap;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingMapReadHelper {
    public final String a;
    public JSONObject b;
    public JSONObject c;

    public MmRecordingMapReadHelper() {
        this.a = "MmRecordingMapReadHelper";
    }

    public final Object b(boolean r6, Continuation<? super JSONObject> r7) {
        if ((r7 instanceof MmRecordingMapReadHelper$readFromCache$1) == false) goto L7;
        MmRecordingMapReadHelper$readFromCache$1 r0 = (MmRecordingMapReadHelper$readFromCache$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L13
    L25:
        return (JSONObject) r8;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r9 = Dispatchers.getIO();     // Catch: Exception -> L13
        if (r6 == false) goto L21;
        boolean r10 = true;
    L22:
        MmRecordingMapReadHelper$readFromCache$2 r4 = new MmRecordingMapReadHelper$readFromCache$2(r10, this, null);     // Catch: Exception -> L13
        r0.label = 1;     // Catch: Exception -> L13
        r8 = BuildersKt.withContext(r9, r4, r0);     // Catch: Exception -> L13
        if (r8 != r2) goto L25;
        return r2;
    L21:
        r10 = false;
    L13:
        e = move-exception;
        lvb.a.b(this.a, "readFromCache error: " + e.getMessage());
        return null;
    L7:
        r0 = new MmRecordingMapReadHelper$readFromCache$1(this, r7);
        goto L8
    }

    public static final Object a(MmRecordingMapReadHelper r8, Bitmap r9, Continuation r10) {
        r8.getClass();
        if ((r10 instanceof MmRecordingMapReadHelper$encodeBitMap$1) == false) goto L7;
        MmRecordingMapReadHelper$encodeBitMap$1 r1 = (MmRecordingMapReadHelper$encodeBitMap$1) r10;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r11 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 != 1) goto L15;
        long r5 = r1.J$0;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L23
    L21:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L23
        r12.put("backgroundBg", (String) r11);     // Catch: Exception -> L23
        lvb.a.e(r8.a, "[encodeBitMap] encoded, cost=" + (System.currentTimeMillis() - r5) + "ms");     // Catch: Exception -> L23
        return r12;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r11);
        long r6 = System.currentTimeMillis();     // Catch: Exception -> L23
        CoroutineDispatcher r13 = Dispatchers.getIO();     // Catch: Exception -> L23
        MmRecordingMapReadHelper$encodeBitMap$bitmapString$1 r7 = new MmRecordingMapReadHelper$encodeBitMap$bitmapString$1(r9, null);     // Catch: Exception -> L23
        r1.J$0 = r6;     // Catch: Exception -> L23
        r1.label = 1;     // Catch: Exception -> L23
        r11 = BuildersKt.withContext(r13, r7, r1);     // Catch: Exception -> L23
        if (r11 == r3) goto L28;
        r5 = r6;
        goto L21
    L28:
        return r3;
    L23:
        e = move-exception;
        lvb.a.b(r8.a, "[encodeBitMap] error=" + e.getMessage());
        return null;
    L7:
        r1 = new MmRecordingMapReadHelper$encodeBitMap$1(r8, r10);
        goto L8
    }
}
