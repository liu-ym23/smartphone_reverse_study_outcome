package com.bytedance.android.anniex.detect.snapshot;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import com.bytedance.android.anniex.ability.f;
import com.bytedance.android.anniex.detect.detection.a;
import com.bytedance.android.anniex.detect.j;
import com.bytedance.android.anniex.detect.k;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/anniex/detect/k;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.detect.snapshot.PixelCopyStep$execute$2", f = "PixelCopyStep.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
public final class PixelCopyStep$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super k>, Object> {
    final /* synthetic */ StringBuilder $captureLog;
    final /* synthetic */ j $context;
    int label;
    final /* synthetic */ PixelCopyStep this$0;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.detect.snapshot.PixelCopyStep$execute$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/anniex/detect/k;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.anniex.detect.snapshot.PixelCopyStep$execute$2$1", f = "PixelCopyStep.kt", i = {0}, l = {49}, m = "invokeSuspend", n = {"start"}, s = {"J$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super k>, Object> {
        final /* synthetic */ StringBuilder $captureLog;
        final /* synthetic */ j $context;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ PixelCopyStep this$0;

        public AnonymousClass1(j r1, PixelCopyStep r10, StringBuilder r11, Continuation<? super AnonymousClass1> r12) {
            this.$context = r1;
            this.this$0 = r10;
            this.$captureLog = r11;
            super(2, r12);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$context, this.this$0, this.$captureLog, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super k> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            long r11 = this.J$0;
            j r1 = (j) this.L$1;
            StringBuilder r12 = (StringBuilder) this.L$0;
            ResultKt.throwOnFailure(r18);
            j r13 = r1;
            Object r14 = r18;
        L53:
            Bitmap r15 = (Bitmap) r14;
            if (r15 != null) goto L57;
            HybridLogger r16 = HybridLogger.a;
            HybridLogger.i("AnnieXBlankDetect", "capture result is null, " + r12, null, 12);
            return new k(false, "capture result is null," + r12);
        L57:
            long r17 = System.currentTimeMillis() - r11;
            r12.append("capture took " + r17 + "ms");
            r12.append('\n');
            r15.setHasAlpha(false);
            r13.b = r15;
            r13.c.b = Boxing.boxLong(r17);
            r13.c.a = true;
            HybridLogger.f("AnnieXBlankDetect", "截图完成", null, 12);
            return new k(true, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r18);
            View r19 = this.$context.a.get();
            if (r19 != null) goto L12;
            HybridLogger.i("AnnieXBlankDetect", "View is null", null, 12);
            return new k(false, "WeakRef View is null");
        L12:
            Intrinsics.checkNotNullParameter(r19, "view");
            if (r19.isAttachedToWindow() == true) goto L15;
        L19:
            boolean r20 = false;
        L20:
            if (r20 == true) goto L22;
            HybridLogger.i("AnnieXBlankDetect", "View is not attached", null, 12);
        L22:
            r11 = System.currentTimeMillis();
            View r21 = this.$context.a.get();
            if (r21 == null) goto L60;
            PixelCopyStep r110 = this.this$0;
            StringBuilder r111 = this.$captureLog;
            r13 = this.$context;
            float r112 = r110.b;
            Context r113 = r21.getContext();
            float r22 = 1.0f;
            if (r112 > 0) goto L27;
        L32:
            this.L$0 = r111;
            this.L$1 = r13;
            this.J$0 = r11;
            this.label = 1;
            SafeContinuation r23 = new SafeContinuation(IntrinsicsKt.intercepted(this));
            int[] r24 = new int[2];     // Catch: Exception -> L45
            r21.getLocationInWindow(r24);     // Catch: Exception -> L45
            int r114 = r24[0];     // Catch: Exception -> L45
            int r25 = r24[1];     // Catch: Exception -> L45
            int r115 = RangesKt.coerceAtLeast((int) (r21.getWidth() * r22), 1);     // Catch: Exception -> L45
            int r116 = RangesKt.coerceAtLeast((int) (r21.getHeight() * r22), 1);     // Catch: Exception -> L45
            Rect r26 = new Rect(r114, r25, r21.getWidth() + r114, r21.getHeight() + r25);     // Catch: Exception -> L45
            Context r27 = r21.getContext();     // Catch: Exception -> L45
            Intrinsics.checkNotNullParameter(r27, "context");     // Catch: Exception -> L45
        L35:
            if ((r27 instanceof ContextWrapper) == false) goto L40;
            if ((r27 instanceof Activity) == true) goto L38;
            r27 = ((ContextWrapper) r27).getBaseContext();     // Catch: Exception -> L45
            goto L35
        L38:
            Activity r28 = (Activity) r27;     // Catch: Exception -> L45
        L41:
            if (r28 != null) goto L43;
            r111.append("PixelCopy error: Activity not found");     // Catch: Exception -> L45
            r111.append('\n');     // Catch: Exception -> L45
            r23.resumeWith(Result.constructor-impl(null));     // Catch: Exception -> L45
        L47:
            r14 = r23.getOrThrow();
            if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L50;
            DebugProbesKt.probeCoroutineSuspended(this);
        L50:
            if (r14 != r10) goto L52;
            return r10;
        L52:
            r12 = r111;
            goto L53
        L43:
            Bitmap r29 = Bitmap.createBitmap(r115, r116, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L45
            new Canvas(r29).scale(r22, r22);     // Catch: Exception -> L45
            PixelCopy.request(r28.getWindow(), r26, r29, new a(r111, r23, r29), new Handler(Looper.getMainLooper()));     // Catch: Exception -> L45
            goto L47
        L40:
            r28 = null;
        L45:
            e = move-exception;
            HybridLogger r30 = HybridLogger.a;
            HybridLogger.i("AnnieXBlankDetect", "captureAViewBitmap exception:" + e.getMessage(), null, 12);
            r111.append("PixelCopy EXCEPTION: " + e.getMessage());
            r111.append('\n');
            r23.resumeWith(Result.constructor-impl(null));
            goto L47
        L27:
            if ((r113 instanceof Activity) == false) goto L32;
            ConcurrentHashMap<String, Object> r117 = f.a;
            Map r118 = f.o(r113, null);
            if (r118 == null) goto L32;
            Object r119 = r118.get("screenWidth");
            Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type kotlin.Int");
            int r120 = ((Integer) r119).intValue();
            Object r31 = r118.get("screenHeight");
            Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type kotlin.Int");
            r22 = Math.min(r112 / Math.min(r120, ((Integer) r31).intValue()), 1.0f);
            goto L32
        L60:
            return new k(false, "view  context is null");
        L15:
            if (r19.getWidth() <= 0) goto L19;
            if (r19.getHeight() <= 0) goto L19;
            r20 = true;
            goto L20
        }
    }

    public PixelCopyStep$execute$2(j r1, PixelCopyStep r10, StringBuilder r11, Continuation<? super PixelCopyStep$execute$2> r12) {
        this.$context = r1;
        this.this$0 = r10;
        this.$captureLog = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PixelCopyStep$execute$2(this.$context, this.this$0, this.$captureLog, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super k> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        MainCoroutineDispatcher r11 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r12 = new AnonymousClass1(this.$context, this.this$0, this.$captureLog, null);
        this.label = 1;
        r10 = BuildersKt.withContext(r11, r12, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
