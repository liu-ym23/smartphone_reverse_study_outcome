package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.retry;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.b;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadRetryConfigSetting;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadTaskRetryConfig;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadResponse;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingRetryPolicy {
    public final b a;
    public final MmUploadTaskRetryConfig b;
    public final MmUploadTaskRetryConfig c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingUploadResponse.values().length];
            r0[MmRecordingUploadResponse.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[MmRecordingUploadResponse.NETWORK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[MmRecordingUploadResponse.TOS_UPLOAD_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[MmRecordingUploadResponse.ENCRYPTION_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[MmRecordingUploadResponse.GET_TENANT_KEY_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[MmRecordingUploadResponse.ABASE_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[MmRecordingUploadResponse.TRANSCODING_FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[MmRecordingUploadResponse.SERVER_DOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public MmRecordingRetryPolicy(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentContextImpl");
        b r3 = r2.getSettingsService();
        this.a = r3;
        this.b = r3.c.getLinearRetryConfig();
        this.c = r3.c.getExponentialRetryConfig();
    }

    public final Object a(MmRecordingUploadResponse r16, long r17, Continuation<? super Boolean> r19) {
        long r1 = r17;
        if ((r19 instanceof MmRecordingRetryPolicy$canRetry$1) == false) goto L7;
        MmRecordingRetryPolicy$canRetry$1 r4 = (MmRecordingRetryPolicy$canRetry$1) r19;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L20;
        if (r7 == 1) goto L19;
        if (r7 == 2) goto L18;
        if (r7 == 3) goto L17;
        if (r7 != 4) goto L16;
        r1 = r4.J$0;
        ResultKt.throwOnFailure(r3);
    L27:
        if (r1 < this.c.getMaxCount()) goto L48;
    L49:
        boolean r8 = false;
    L51:
        return Boxing.boxBoolean(r8);
    L48:
        r8 = true;
        goto L51
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r1 = r4.J$0;
        ResultKt.throwOnFailure(r3);
    L41:
        if (r1 >= this.c.getMaxCount()) goto L49;
    L18:
        r1 = r4.J$0;
        ResultKt.throwOnFailure(r3);
    L35:
        if (r1 >= this.b.getMaxCount()) goto L49;
    L19:
        r1 = r4.J$0;
        ResultKt.throwOnFailure(r3);
    L47:
        if (r1 >= this.b.getMaxCount()) goto L49;
    L20:
        ResultKt.throwOnFailure(r3);
        switch(a.a[r16.ordinal()]) {
            case 1: goto L43;
            case 2: goto L43;
            case 3: goto L30;
            case 4: goto L23;
            case 5: goto L23;
            case 6: goto L23;
            case 7: goto L23;
            case 8: goto L23;
            default: goto L49;
        };
    L23:
        long r9 = RangesKt.coerceAtMost(((long) Math.pow(2.0d, ((int) r1) + 1)) + Random.Default.nextLong(0, 2000), MmUploadRetryConfigSetting.MAX_INTERVAL_MS);
        r4.J$0 = r1;
        r4.label = 4;
        if (DelayKt.delay(r9, r4) != r6) goto L27;
        return r6;
    L43:
        long r10 = RangesKt.coerceAtMost(((long) (this.b.getInterval() * 1000)) + Random.Default.nextLong(0, 2000), MmUploadRetryConfigSetting.MAX_INTERVAL_MS);
        r4.J$0 = r1;
        r4.label = 1;
        if (DelayKt.delay(r10, r4) != r6) goto L47;
        return r6;
    L30:
        if (this.a.h.getTosErrorIntervalRetry() == false) goto L37;
        long r11 = RangesKt.coerceAtMost(((long) (this.b.getInterval() * 1000)) + Random.Default.nextLong(0, 2000), MmUploadRetryConfigSetting.MAX_INTERVAL_MS);
        r4.J$0 = r1;
        r4.label = 2;
        if (DelayKt.delay(r11, r4) != r6) goto L35;
        return r6;
    L37:
        long r12 = RangesKt.coerceAtMost(((long) Math.pow(2.0d, ((int) r1) + 1)) + Random.Default.nextLong(0, 2000), MmUploadRetryConfigSetting.MAX_INTERVAL_MS);
        r4.J$0 = r1;
        r4.label = 3;
        if (DelayKt.delay(r12, r4) != r6) goto L41;
        return r6;
    L7:
        r4 = new MmRecordingRetryPolicy$canRetry$1(this, r19);
        goto L8
    }
}
