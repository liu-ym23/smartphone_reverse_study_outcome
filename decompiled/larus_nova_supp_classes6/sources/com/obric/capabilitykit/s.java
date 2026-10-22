package com.obric.capabilitykit;

import android.app.Application;
import androidx.profileinstaller.ProfileVerifier;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseResultExt;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.sva.sdk.data.ISmModel;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import wia.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class s {
    public static final s a = null;
    public static final CoroutineScope b = null;

    static {
        a = new s();
        b = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new x())));
    }

    public s() {
    }

    public final Object a(IntentCalling r38, String r39, Continuation<? super Pair<? extends IntentResult<?>, IMAppAction>> r40) {
        IntentCalling r0 = r38;
        if ((r40 instanceof a) == false) goto L7;
        a r2 = (a) r40;
        int r3 = r2.f;
        if ((r3 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r2.f = r3 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r1 = r2.d;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.f;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r6 = r2.c;
        Application r7 = (Application) r2.b;
        IntentCalling r8 = (IntentCalling) r2.a;
        ResultKt.throwOnFailure(r1);
        Application r9 = r7;
        r0 = r8;
        Object r10 = r1;
    L18:
        IntentResult r11 = (IntentResult) r10;
        long r12 = System.currentTimeMillis() - r6;
        String r13 = r9.getString(2131911939);
        String r14 = r9.getString(2131911937);
        if (r11.getRet() != 0) goto L25;
        String r15 = r11.getDetails();
        if (r15 == null) goto L24;
        r13 = r15;
    L24:
        r11.setDetails(r13);
    L25:
        Gson r16 = UtilsKt.a();
        int r17 = r11.getRet();
        String r18 = r11.getDetails();
        if (r18 != null) goto L28;
        String r19 = r14;
    L29:
        String r26 = GsonProtectorUtils.toJson(r16, new FeedbackResult(r17, r19, null, r11.getUiType(), String.valueOf(r0.e), false, 36, null));
        if ((r11.getUiType() & 32) == 0) goto L32;
    L69:
        String r21 = UUID.randomUUID().toString();
        long r20 = r0.b;
        long r110 = r0.a;
        long r111 = r0.c;
        long r22 = r0.d;
        IMAppActionExt r23 = new IMAppActionExt();
        ConcurrentHashMap<String, String> r112 = r11.getExt();
        if (r112 == null) goto L72;
        BaseResultExt r113 = new BaseResultExt();
        r113.putAll(r112);
        String r114 = r113.getResultDetailExtras();
    L73:
        r23.setActionDetailExtras(r114);
        r23.put("app_cost", String.valueOf(r12));
        ConcurrentHashMap<String, String> r24 = r11.getExt();
        if (r24 == null) goto L77;
        r23.putAll(r24);
    L77:
        return new Pair(r11, new IMAppAction(0, Boxing.boxLong(r20), r21, r20, Boxing.boxLong(r110), null, r26, null, r111, r22, 0, r23, 1185, null));
    L72:
        r114 = null;
        goto L73
    L32:
        if ((r11.getUiType() & 64) != 0) goto L69;
        if ((r11.getUiType() & 128) != 0) goto L69;
        if ((r11.getUiType() & ISmModel.VERSION_0200) != 0) goto L69;
        if ((r11.getUiType() & ISmModel.VERSION_0400) != 0) goto L69;
        if ((r11.getUiType() & 2048) != 0) goto L69;
        if ((r11.getUiType() & 4096) != 0) goto L69;
        if ((r11.getUiType() & 8192) != 0) goto L69;
        if ((r11.getUiType() & 16384) != 0) goto L69;
        if ((r11.getUiType() & 32768) != 0) goto L69;
        if ((r11.getUiType() & 524288) != 0) goto L69;
        if ((r11.getUiType() & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) != 0) goto L69;
        if ((r11.getUiType() & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ) != 0) goto L69;
        if ((r11.getUiType() & 1048576) != 0) goto L69;
        if ((r11.getUiType() & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION) != 0) goto L69;
        if ((r11.getUiType() & 2097152) != 0) goto L69;
        if ((r11.getUiType() & 8388608) != 0) goto L69;
        String r25 = UUID.randomUUID().toString();
        long r27 = r0.b;
        long r115 = r0.a;
        long r116 = r0.c;
        long r28 = r0.d;
        IMAppActionExt r29 = new IMAppActionExt();
        r29.put("app_cost", String.valueOf(r12));
        ConcurrentHashMap<String, String> r30 = r11.getExt();
        if (r30 == null) goto L68;
        r29.putAll(r30);
    L68:
        return new Pair(r11, new IMAppAction(0, Boxing.boxLong(r27), r25, r27, Boxing.boxLong(r115), null, r26, null, r116, r28, 0, r29, 1185, null));
    L28:
        r19 = r18;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r9 = AppHost.Companion.getApplication();
        long r31 = System.currentTimeMillis();
        t r32 = t.a;
        r2.a = r0;
        r2.b = r9;
        r2.c = r31;
        r2.f = 1;
        r10 = r32.d(r9, r0, r39, r2);
        if (r10 != r4) goto L17;
        return r4;
    L17:
        r6 = r31;
    L7:
        r2 = new a(this, r40);
        goto L8
    }
}
