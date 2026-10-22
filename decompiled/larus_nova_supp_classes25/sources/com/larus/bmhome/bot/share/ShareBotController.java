package com.larus.bmhome.bot.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ShareBotController {
    public static final /* synthetic */ int g = 0;
    public final Fragment a;
    public final by7.e b;
    public final boolean c;
    public final Context d;
    public final Lazy e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    public ShareBotController(CommonSettingFragment r1, CommonSettingFragment r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r1.getContext();
        this.e = LazyKt.lazy(new f(this));
        this.f = LazyKt.lazy(new g(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(jr9.a r37, wc9.e r38, BotModel r39, Continuation<? super i> r40) {
        if ((r40 instanceof ShareBotController$doShareBotWithPic$1) == false) goto L7;
        ShareBotController$doShareBotWithPic$1 r2 = (ShareBotController$doShareBotWithPic$1) r40;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        Object r6 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        jr9.a r7 = (jr9.a) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L20:
        Bitmap r8 = (Bitmap) r0;
    L22:
        if (r8 != null) goto L24;
    L43:
        Bitmap r9 = r6;
        if (r8 == null) goto L48;
        if (r9 != 0) goto L48;
        return i.b.a;
    L48:
        IShareService.a.d(ShareServiceDelegate.b, this.d, r7.b(), r7.c(), new com.larus.bmhome.share.panel.b(null, r9, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108861), null, 48);
        if (r8 == null) goto L52;
        return new i.c(r8);
    L52:
        return i.b.a;
    L24:
        if ((!r8.isRecycled()) == false) goto L26;
        Bitmap r1 = r8;
    L27:
        if (r1 == null) goto L43;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L33
        Bitmap.Config r11 = r1.getConfig();     // Catch: Throwable -> L33
        if (r11 != null) goto L31;
        r11 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L33
    L31:
        Object r12 = Result.constructor-impl(r1.copy(r11, false));     // Catch: Throwable -> L33
    L35:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L39;
        FLogger.a.e("ShareBotController", "copy share bitmap failed", r13);
    L39:
        if (Result.isFailure-impl(r12) == true) goto L42;
        r6 = r12;
    L42:
        r6 = (Bitmap) r6;
    L33:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L26:
        r1 = null;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        ShareBotBitmapGenerator r15 = (ShareBotBitmapGenerator) this.f.getValue();
        if (r15 == null) goto L21;
        r2.L$0 = r37;
        r2.label = 1;
        r0 = r15.a(r38, r39, r2);
        if (r0 != r4) goto L19;
        return r4;
    L19:
        r7 = r37;
        goto L20
    L21:
        r7 = r37;
        r8 = null;
    L7:
        r2 = new ShareBotController$doShareBotWithPic$1(this, r40);
        goto L8
    }

    public static final Object a(ShareBotController r7, Context r8, jr9.a r9, wc9.e r10, BotModel r11, Continuation r12) {
        r7.getClass();
        if ((r12 instanceof ShareBotController$shareBotWithPic$1) == false) goto L7;
        ShareBotController$shareBotWithPic$1 r0 = (ShareBotController$shareBotWithPic$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L17;
        if (r3 == 3) goto L18;
        if (r3 == 4) goto L18;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r11 = (BotModel) r0.L$2;
        r10 = (wc9.e) r0.L$1;
        r9 = (jr9.a) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L32:
        if (((Boolean) r13).booleanValue() == false) goto L42;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 3;
        r13 = r7.b(r9, r10, r11, r0);
        if (r13 != r2) goto L41;
        return r2;
    L41:
        return r13;
    L42:
        return i.a.a;
    L18:
        ResultKt.throwOnFailure(r13);
        goto L41
    L19:
        ResultKt.throwOnFailure(r13);
        if (Build.VERSION.SDK_INT <= 29) goto L22;
        r0.label = 4;
        r13 = r7.b(r9, r10, r11, r0);
        if (r13 != r2) goto L41;
        return r2;
    L22:
        if (ContextCompat.checkSelfPermission(r8, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L26;
        r0.label = 1;
        r13 = r7.b(r9, r10, r11, r0);
        if (r13 != r2) goto L41;
        return r2;
    L26:
        r0.L$0 = r9;
        r0.L$1 = r10;
        r0.L$2 = r11;
        r0.label = 2;
        SafeContinuation r14 = new SafeContinuation(IntrinsicsKt.intercepted(r0));
        i2 r4 = i2.b;
        i2.q(r7.a, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new h(r14));
        r13 = r14.getOrThrow();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L29:
        if (r13 != r2) goto L32;
        return r2;
    L7:
        r0 = new ShareBotController$shareBotWithPic$1(r7, r12);
        goto L8
    }
}
