package com.larus.uploader.impl.preheat;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.upload.ResourceUploadTokenProvider;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IImageUploadPreheatService;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDUploadUtil;
import com.tencent.open.log.TraceLevel;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.ranges.RangesKt;
import mr9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/larus/uploader/impl/preheat/ImageUploadPreheatServiceImpl;", "Lcom/larus/platform/api/IImageUploadPreheatService;", "<init>", "()V", "preheat", "", "context", "Landroid/content/Context;", "targetCount", "", "threshold", "scene", "", "dataType", "Lcom/larus/platform/model/upload/UploadDataType;", "(Landroid/content/Context;IILjava/lang/String;Lcom/larus/platform/model/upload/UploadDataType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageUploadPreheatServiceImpl implements IImageUploadPreheatService {
    public static final AtomicLong a = null;

    public static final class a {
    }

    public ImageUploadPreheatServiceImpl() {
    }

    static {
        a = new AtomicLong(0);
    }

    @Override // com.larus.platform.api.IImageUploadPreheatService
    public final Object a(int r19, int r20, String r21, UploadDataType r22, Continuation r23) {
        if ((r23 instanceof ImageUploadPreheatServiceImpl$preheat$1) == false) goto L7;
        ImageUploadPreheatServiceImpl$preheat$1 r1 = (ImageUploadPreheatServiceImpl$preheat$1) r23;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r5 = r1.J$0;
        int r6 = r1.I$1;
        int r7 = r1.I$0;
        BDImageXUploader r8 = (BDImageXUploader) r1.L$1;
        String r9 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        int r10 = r6;
    L36:
        m r11 = (m) r0;
        if (r11 == null) goto L39;
        com.larus.uploader.impl.c.a(r8, r11);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L43
        r8.setServerParameter(c.a(r9));     // Catch: Throwable -> L43
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L43
    L45:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L48;
        FLogger.a.e("ImgUploadPreheat", "setServerParameter failed", r14);
    L48:
        r8.setFileNum(RangesKt.coerceAtLeast(r7, r7), RangesKt.coerceAtLeast(r10, r10));
        r8.setPreheatUploader(2);
        FLogger.a.i("ImgUploadPreheat", "preheat trigger, targetCount=" + r7 + ", threshold=" + r10);
        r8.setListener(new com.larus.uploader.impl.preheat.a(r5));
        r8.startPreHeat();
        return Unit.INSTANCE;
    L43:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L39:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        String r16 = AccountService.a.getUserId();
        if (r16.length() != 0) goto L17;
        boolean r17 = true;
    L18:
        if (r17 == true) goto L20;
        long r18 = System.currentTimeMillis();
        AtomicLong r24 = a;
        long r25 = r24.get();
        if ((r18 - r25) >= 5000) goto L26;
        return Unit.INSTANCE;
    L26:
        if (r24.compareAndSet(r25, r18) == false) goto L28;
        long r26 = System.currentTimeMillis();
        PolarisFileWrapper r27 = new PolarisFileWrapper(AppHost.a.getApplication().getCacheDir(), "BDUploadConfig");
        if (r27.exists() == true) goto L32;
        r27.mkdirs();
    L32:
        BDUploadUtil.setSDKConfigDir(r27.getAbsolutePath());
        BDImageXUploader r28 = new BDImageXUploader();
        ResourceUploadTokenProvider r29 = ResourceUploadTokenProvider.a;
        r1.L$0 = r16;
        r1.L$1 = r28;
        r1.I$0 = r19;
        r10 = r20;
        r1.I$1 = r10;
        r1.J$0 = r26;
        r1.label = 1;
        Object r30 = r29.a(r21, r22, r1);
        if (r30 != r3) goto L35;
        return r3;
    L35:
        r9 = r16;
        r0 = r30;
        r8 = r28;
        r5 = r26;
        r7 = r19;
        goto L36
    L28:
        return Unit.INSTANCE;
    L20:
        return Unit.INSTANCE;
    L17:
        r17 = false;
    L7:
        r1 = new ImageUploadPreheatServiceImpl$preheat$1(this, r23);
        goto L8
    }
}
