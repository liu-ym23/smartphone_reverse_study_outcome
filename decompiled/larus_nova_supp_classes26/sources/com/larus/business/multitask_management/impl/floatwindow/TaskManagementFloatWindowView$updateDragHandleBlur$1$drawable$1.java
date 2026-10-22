package com.larus.business.multitask_management.impl.floatwindow;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.imagepipeline.postprocessors.BlurPostProcessor;
import com.larus.business.multitask_management.impl.view.MultitaskDefaultIcons;
import com.larus.business.multitask_management.impl.view.MultitaskLottieIcon;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.j0;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.floatwindow.TaskManagementFloatWindowView$updateDragHandleBlur$1$drawable$1", f = "TaskManagementFloatWindowView.kt", i = {0}, l = {524}, m = "invokeSuspend", n = {"targetSize"}, s = {"I$0"})
public final class TaskManagementFloatWindowView$updateDragHandleBlur$1$drawable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Drawable>, Object> {
    final /* synthetic */ TaskManagementFloatWindowView.b $config;
    int I$0;
    int label;
    final /* synthetic */ TaskManagementFloatWindowView this$0;

    public TaskManagementFloatWindowView$updateDragHandleBlur$1$drawable$1(TaskManagementFloatWindowView.b r1, TaskManagementFloatWindowView r2, Continuation<? super TaskManagementFloatWindowView$updateDragHandleBlur$1$drawable$1> r3) {
        this.$config = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TaskManagementFloatWindowView$updateDragHandleBlur$1$drawable$1(this.$config, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Drawable> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        int r1 = this.I$0;
        ResultKt.throwOnFailure(r17);
        final int r10 = r1;
        Object r2 = r17;
    L44:
        Bitmap r3 = (Bitmap) r2;
    L45:
        if (r3 == null) goto L67;
        TaskManagementFloatWindowView r4 = this.this$0;
        TaskManagementFloatWindowView.b r5 = this.$config;
        int r6 = TaskManagementFloatWindowView.G;
        r4.getClass();
        Bitmap r8 = Bitmap.createBitmap(r10, r10, Bitmap.Config.ARGB_8888);
        Canvas r9 = new Canvas(r8);
        r9.drawColor(ContextCompat.getColor(r4.getContext(), v19.c.b(2130970534, r4.getContext(), 2131102545)));
        String r11 = r5.b;
        if (r11 != null) goto L49;
    L52:
        boolean r12 = true;
    L53:
        if (r12 == true) goto L55;
        Paint r13 = new Paint(1);
        r13.setColor(com.larus.business.multitask_management.impl.view.f.d(r5.b, true, ContextCompat.getColor(r4.getContext(), v19.c.b(2130970534, r4.getContext(), 2131102545))));
        float r14 = r10;
        r9.drawRect(new RectF(0.0f, 0.0f, r14, r14), r13);
    L55:
        int r15 = RangesKt.coerceIn(r5.c, 0, (r10 - 1) / 2);
        int r16 = r10 - r15;
        r9.drawBitmap(r3, null, new Rect(r15, r15, r16, r16), new Paint(3));
        float r18 = 512;
        float r19 = Math.min(r18 / r8.getWidth(), r18 / r8.getHeight());
        if (r19 >= 1.0d) goto L59;
        r8 = Bitmap.createScaledBitmap(r8, (int) (r8.getWidth() * r19), (int) (r8.getHeight() * r19), true);
    L59:
        new BlurPostProcessor(20, r4.getContext()).process(r8);
        int r20 = RangesKt.coerceIn((int) (r8.getWidth() * 0.5f), 1, r8.getWidth());
        int r21 = RangesKt.coerceIn((int) (r8.getHeight() * 0.5f), 1, r8.getHeight());
        return new BitmapDrawable(r4.getResources(), Bitmap.createBitmap(r8, RangesKt.coerceAtLeast((r8.getWidth() - r20) / 2, 0), RangesKt.coerceAtLeast((r8.getHeight() - r21) / 2, 0), r20, r21));
    L49:
        if (r11.length() == 0) goto L52;
        r12 = false;
        goto L53
    L67:
        return null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        r10 = c7.b(Boxing.boxInt(64));
        String r22 = this.$config.a;
        Iterator r23 = MultitaskDefaultIcons.getEntries().iterator();
    L10:
        if (r23.hasNext() == false) goto L14;
        Object r24 = r23.next();
        if (Intrinsics.areEqual(((MultitaskDefaultIcons) r24).getUri(), r22) == false) goto L10;
    L15:
        MultitaskDefaultIcons r25 = (MultitaskDefaultIcons) r24;
        if (r25 == null) goto L18;
        Integer r26 = Integer.valueOf(r25.getResId());
    L39:
        if (r26 == null) goto L41;
        int r27 = j0.a;
        r3 = DrawableKt.toBitmap(j0.c(r26.intValue()), r10, r10, Bitmap.Config.ARGB_8888);
        goto L45
    L41:
        String r28 = this.$config.a;
        Bitmap.Config r29 = Bitmap.Config.ARGB_8888;
        Function1 r30 = new p(r10);
        this.I$0 = r10;
        this.label = 1;
        r2 = ImageLoaderKt.n(r28, "mtm.drag_handle_blur", r29, r30, this, 28);
        if (r2 != r7) goto L44;
        return r7;
    L18:
        Iterator r31 = MultitaskLottieIcon.getEntries().iterator();
    L20:
        if (r31.hasNext() == false) goto L24;
        Object r32 = r31.next();
        if (Intrinsics.areEqual(((MultitaskLottieIcon) r32).getIdentifier(), r22) == false) goto L20;
    L25:
        MultitaskLottieIcon r33 = (MultitaskLottieIcon) r32;
        if (r33 == null) goto L28;
        r26 = Integer.valueOf(r33.getStaticResId());
        goto L39
    L28:
        if (r22 == null) goto L38;
        Uri r34 = UriProtector.parse(r22);
        if (r34 == null) goto L38;
        if (Intrinsics.areEqual(r34.getScheme(), "res") == false) goto L38;
        String r35 = r34.getLastPathSegment();
        if (r35 == null) goto L38;
        r26 = StringsKt.toIntOrNull(r35);
    L38:
        r26 = null;
        goto L39
    L24:
        r32 = null;
        goto L25
    L14:
        r24 = null;
        goto L15
    }
}
