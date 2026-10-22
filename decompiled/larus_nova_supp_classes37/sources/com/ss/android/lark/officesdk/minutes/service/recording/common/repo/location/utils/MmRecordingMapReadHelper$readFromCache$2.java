package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapReadHelper$readFromCache$2", f = "MmRecordingMapReadHelper.kt", i = {0}, l = {63}, m = "invokeSuspend", n = {"bitmap"}, s = {"L$0"})
public final class MmRecordingMapReadHelper$readFromCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JSONObject>, Object> {
    final /* synthetic */ boolean $isDarkMode;
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingMapReadHelper this$0;

    public MmRecordingMapReadHelper$readFromCache$2(boolean r1, MmRecordingMapReadHelper r2, Continuation<? super MmRecordingMapReadHelper$readFromCache$2> r3) {
        this.$isDarkMode = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingMapReadHelper$readFromCache$2(this.$isDarkMode, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super JSONObject> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        JSONObject r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Bitmap r2 = (Bitmap) this.L$0;
        ResultKt.throwOnFailure(r10);
    L37:
        JSONObject r11 = (JSONObject) r10;
        if (r11 == null) goto L44;
        boolean r4 = this.$isDarkMode;
        MmRecordingMapReadHelper r5 = this.this$0;
        if (r4 == false) goto L42;
        r5.b = r11;
    L43:
        r3 = r11;
        goto L44
    L42:
        r5.c = r11;
    L44:
        r2.recycle();
        return r3;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        if (this.$isDarkMode == false) goto L11;
        JSONObject r12 = this.this$0.b;
    L12:
        if (r12 == null) goto L15;
        lvb.a.e(this.this$0.a, "[readFromCache] use cache");
        return r12;
    L15:
        Application r13 = LarkContext.getApplication();
        if (this.$isDarkMode == false) goto L18;
        String r6 = "mm_map_snapshot_dark.png";
    L19:
        Intrinsics.checkNotNull(r13);
        PolarisFileWrapper r7 = new PolarisFileWrapper(MmRecordingMapUtilKt.c(r13), r6);
        if (r7.exists() == true) goto L22;
    L53:
        lvb.a.e(this.this$0.a, "[readFromCache] bitmapFile not exist or empty: " + r7.getAbsolutePath());
        return null;
    L22:
        if (r7.length() == 0) goto L53;
        BitmapFactory.Options r14 = new BitmapFactory.Options();
        r14.inPreferredConfig = Bitmap.Config.RGB_565;
        PolarisFileInputStreamWrapper r8 = new PolarisFileInputStreamWrapper(r7);
        Bitmap r15 = BitmapFactory.decodeStream(r8, null, r14);     // Catch: Throwable -> L48
        CloseableKt.closeFinally(r8, null);
        if (r15 != null) goto L29;
    L46:
        lvb.a.b(this.this$0.a, "[readFromCache] bitmap is invalid");
        return null;
    L29:
        if (r15.getWidth() <= 0) goto L46;
        if (r15.getHeight() <= 0) goto L46;
        lvb.a.e(this.this$0.a, "[readFromCache] bitmap:" + r15.getWidth() + 'x' + r15.getHeight() + ", isDarkMode=" + this.$isDarkMode);
        MmRecordingMapReadHelper r9 = this.this$0;
        this.L$0 = r15;
        this.label = 1;
        Object r16 = MmRecordingMapReadHelper.a(r9, r15, this);
        if (r16 != r0) goto L36;
        return r0;
    L36:
        r2 = r15;
        r10 = r16;
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    L18:
        r6 = "mm_map_snapshot_light.png";
        goto L19
    L11:
        r12 = this.this$0.c;
        goto L12
    }
}
