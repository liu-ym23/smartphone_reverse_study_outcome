package com.larus.camera.impl.utils;

import android.graphics.Bitmap;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.vlm.VLMFileDataType;
import com.larus.camera.api.vlm.VLMIntentTrackSource;
import com.larus.camera.api.vlm.VLMSceneType;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.platform.model.camera.ICameraEventExt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CaptureResultDetectLogic {
    public static final CaptureResultDetectLogic a = null;
    public static final Lazy b = null;
    public static a c;

    public static final class a {
        public final int a;
        public final long b;
        public final long c;
        public final int d;
        public final int e;
        public final String f;
        public final ix8.d g;

        public a() {
            this(0);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            long r1 = this.b;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r3 = this.c;
            return ((((((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
        }

        public final String toString() {
            return "IntentDetectAppLogInfo(status=" + this.a + ", totalDuration=" + this.b + ", preProcessDuration=" + this.c + ", originImageSize=" + this.d + ", compressedImageSize=" + this.e + ", errMsg=" + this.f + ", detectResult=" + this.g + ')';
        }

        public /* synthetic */ a(int r11) {
            this(0, 0, 0, 0, 0, "", new ix8.d.a(ix8.e.c.a));
        }

        public a(int r2, long r3, long r5, int r7, int r8, String r9, ix8.d r10) {
            Intrinsics.checkNotNullParameter(r9, "errMsg");
            Intrinsics.checkNotNullParameter(r10, "detectResult");
            this.a = r2;
            this.b = r3;
            this.c = r5;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r10;
        }

        public static a a(a r10, int r11, long r12, long r14, int r16, int r17, String r18, ix8.d r19, int r20) {
            if ((r20 & 1) == 0) goto L5;
            int r1 = r10.a;
        L7:
            if ((r20 & 2) == 0) goto L9;
            long r2 = r10.b;
        L11:
            if ((r20 & 4) == 0) goto L13;
            long r4 = r10.c;
        L15:
            if ((r20 & 8) == 0) goto L17;
            int r6 = r10.d;
        L19:
            if ((r20 & 16) == 0) goto L21;
            int r7 = r10.e;
        L23:
            if ((r20 & 32) == 0) goto L25;
            String r8 = r10.f;
        L27:
            if ((r20 & 64) == 0) goto L29;
            ix8.d r9 = r10.g;
        L30:
            r10.getClass();
            Intrinsics.checkNotNullParameter(r8, "errMsg");
            Intrinsics.checkNotNullParameter(r9, "detectResult");
            return new a(r1, r2, r4, r6, r7, r8, r9);
        L29:
            r9 = r19;
            goto L30
        L25:
            r8 = r18;
            goto L27
        L21:
            r7 = r17;
            goto L23
        L17:
            r6 = r16;
            goto L19
        L13:
            r4 = r14;
            goto L15
        L9:
            r2 = r12;
            goto L11
        L5:
            r1 = r11;
            goto L7
        }
    }

    public CaptureResultDetectLogic() {
    }

    static {
        a = new CaptureResultDetectLogic();
        b = LazyKt.lazy(new t());
        c = new a(0);
    }

    public static boolean a(CameraData r5) {
        Intrinsics.checkNotNullParameter(r5, "cameraData");
        boolean r0 = r5.getEnableCaptureDetectModeList().contains(r5.getCaptureMode());
        int r1 = od8.h0.a;
        ICameraEventExt r2 = r5.getEventExt();
        Integer r3 = null;
        if (r2 == null) goto L7;
        JSONObject r4 = r2.enterCameraEventExt();
        if (r4 == null) goto L7;
        Integer r6 = Integer.valueOf(r4.optInt("action_bar_instruction_type"));
    L8:
        boolean r7 = od8.h0.f(r6);
        ICameraEventExt r8 = r5.getEventExt();
        if (r8 == null) goto L13;
        JSONObject r9 = r8.enterCameraEventExt();
        if (r9 == null) goto L13;
        r3 = Integer.valueOf(r9.optInt("action_bar_instruction_type"));
    L13:
        boolean r10 = od8.h0.i(r3);
        if (Intrinsics.areEqual(PollingConfigService.a.f("edu_dg"), "1") == false) goto L16;
    L25:
        return false;
    L16:
        if (((oq9.j) b.getValue()).c() == false) goto L25;
        if (r0 == false) goto L25;
        if (r5.getAddedAttachmentCount() > 0) goto L25;
        if (r7 == true) goto L25;
        if (r10 == true) goto L25;
        if (r5.getDisableCaptureDetect() == true) goto L25;
        return true;
    L7:
        r6 = null;
        goto L8
    }

    public final Object b(Bitmap r16, VLMSceneType r17, Continuation<? super ix8.d> r18) {
        if ((r18 instanceof CaptureResultDetectLogic$requestServerDetect$1) == false) goto L7;
        CaptureResultDetectLogic$requestServerDetect$1 r1 = (CaptureResultDetectLogic$requestServerDetect$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L19:
        ix8.d r5 = (ix8.d) r0;
        if (r5 != null) goto L23;
    L22:
        r5 = new ix8.d.a(new ix8.e.b("vlm service unavailable"));
    L23:
        ix8.g r6 = r5.a();
        c = a.a(c, 0, 0, r6.a, r6.b, r6.c, null, null, 99);
        return r5;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        c = new a(0);
        List r7 = CollectionsKt.listOf(new ix8.b(r16, VLMFileDataType.IMAGE));
        Lazy r8 = b;
        ix8.c r9 = new ix8.c(r7, r17, new ix8.a(Boxing.boxLong(((oq9.j) r8.getValue()).a()), 720.0f, ((oq9.j) r8.getValue()).d(), w.b.b(), true, 8), VLMIntentTrackSource.MAIN_CAMERA, 8);
        IFlowCamera r10 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r10 == null) goto L22;
        r1.label = 1;
        r0 = r10.d(r9, r1);
        if (r0 != r3) goto L19;
        return r3;
    L7:
        r1 = new CaptureResultDetectLogic$requestServerDetect$1(this, r18);
        goto L8
    }
}
