package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.graphics.Bitmap;
import com.larus.bot.impl.bean.AvatarHeadLocation;
import com.larus.bot.impl.bean.HeadLocation;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository$cropAvatarFromImage$3", f = "AIGenBgImageRepository.kt", i = {0, 1, 1}, l = {154, 172}, m = "invokeSuspend", n = {"$this$withContext", "firstAvatar", "detectedAvatarSizePercent"}, s = {"L$0", "L$0", "D$0"})
public final class AIGenBgImageRepository$cropAvatarFromImage$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $onLocationReturn;
    final /* synthetic */ String $uri;
    final /* synthetic */ String $url;
    double D$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIGenBgImageRepository this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AIGenBgImageRepository$cropAvatarFromImage$3(AIGenBgImageRepository r1, String r2, Function1<? super Boolean, Unit> r3, String r4, Continuation<? super AIGenBgImageRepository$cropAvatarFromImage$3> r5) {
        this.this$0 = r1;
        this.$uri = r2;
        this.$onLocationReturn = r3;
        this.$url = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        AIGenBgImageRepository$cropAvatarFromImage$3 r6 = new AIGenBgImageRepository$cropAvatarFromImage$3(this.this$0, this.$uri, this.$onLocationReturn, this.$url, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L14;
        if (r3 == 1) goto L13;
        if (r3 != 2) goto L12;
        double r4 = this.D$0;
        HeadLocation r6 = (HeadLocation) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L9
        double r10 = r4;
        Object r5 = r19;
    L57:
        Object r1 = Result.constructor-impl((Bitmap) r5);     // Catch: Throwable -> L59
    L62:
        Object r7 = r1;
        Throwable r2 = Result.exceptionOrNull-impl(r7);
        if (r2 == null) goto L66;
        FLogger.a.e("cropAvatarFromImageUrl", "getBitmapFromUrl error", r2);
    L66:
        if (Result.isSuccess-impl(r7) == false) goto L81;
        Bitmap r8 = (Bitmap) r7;
        if (r8 == null) goto L81;
        int r9 = (int) ((r10 * ((double) RangesKt.coerceAtMost(r8.getWidth(), r8.getHeight()))) * ((double) 2.0f));     // Catch: Throwable -> L75
        double r11 = ((double) r8.getWidth()) * r6.getCenterX();     // Catch: Throwable -> L75
        double r12 = ((double) r8.getHeight()) * r6.getCenterY();     // Catch: Throwable -> L75
        int r13 = (int) RangesKt.coerceAtMost(RangesKt.coerceAtMost(RangesKt.coerceAtMost(RangesKt.coerceAtMost(((double) r9) * 0.5d, r11), ((double) r8.getWidth()) - r11), r12), ((double) r8.getHeight()) - r12);
        int r14 = r13 * 2;
        double r15 = r13;
        int r16 = (int) RangesKt.coerceAtLeast(0.0d, r11 - r15);     // Catch: Throwable -> L73
        int r17 = (int) RangesKt.coerceAtLeast(0.0d, r12 - r15);     // Catch: Throwable -> L73
        FLogger.a.d("cropAvatarFromImageUrl", "width: " + r8.getWidth() + ", height :" + r8.getHeight() + ", centerX: " + r11 + ", centerY: " + r12 + ", left: " + r16 + ", top: " + r17 + ", avatarSize:" + r14 + '.');     // Catch: Throwable -> L73
        return Bitmap.createBitmap(r8, r16, r17, r14, r14);
    L73:
        th = th;
    L77:
        Result.Companion r18 = Result.Companion;
        Object r20 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L80;
        FLogger.a.e("cropAvatarFromImageUrl", "failed to create bitmap", r21);
    L80:
        Result.box-impl(r20);
    L82:
        Result.box-impl(r7);
        return null;
    L75:
        th = th;
    L81:
        r7 = r7;
    L59:
        Throwable th = th;
        r4 = r10;
    L61:
        Result.Companion r110 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        r10 = r4;
    L9:
        th = th;
        goto L61
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        CoroutineScope r22 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r23 = r19;
    L17:
        AvatarHeadLocation r24 = (AvatarHeadLocation) ((com.larus.network.http.a) r23).b;
        if (r24 == null) goto L26;
        List<List<HeadLocation>> r25 = r24.getAvatars();
        if (r25 == null) goto L26;
        List r26 = CollectionsKt.filterNotNull(r25);
        if (r26 == null) goto L26;
        List r27 = (List) CollectionsKt.firstOrNull(r26);
        if (r27 == null) goto L26;
        List r28 = CollectionsKt.filterNotNull(r27);
    L27:
        if (r28 != null) goto L29;
        r28 = CollectionsKt.emptyList();
    L29:
        List r111 = r28;
        this.$onLocationReturn.invoke(Boxing.boxBoolean(!r111.isEmpty()));
        if ((true ^ r111.isEmpty()) == false) goto L85;
        r6 = (HeadLocation) CollectionsKt.first(r28);
        FLogger r29 = FLogger.a;
        r29.d("cropAvatarFromImageUrl", "location: " + r6);
        if (r6.isValidLocation() == false) goto L84;
        Double r112 = r6.getX2();
        if (r112 == null) goto L36;
        double r113 = r112.doubleValue();
    L37:
        Double r114 = r6.getX1();
        if (r114 == null) goto L40;
        double r115 = r114.doubleValue();
    L41:
        double r116 = r113 - r115;
        Double r117 = r6.getY2();
        if (r117 == null) goto L44;
        double r118 = r117.doubleValue();
    L45:
        Double r119 = r6.getY1();
        if (r119 == null) goto L48;
        double r120 = r119.doubleValue();
    L49:
        r10 = RangesKt.coerceAtMost(1.0d, RangesKt.coerceAtLeast(r116, r118 - r120));
        if (0.1d <= r10) goto L53;
        r29.e("cropAvatarFromImageUrl", "not reach cropPercentageLowerBound");
        return null;
    L53:
        String r30 = this.$url;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L59
        this.L$0 = r6;     // Catch: Throwable -> L59
        this.D$0 = r10;     // Catch: Throwable -> L59
        this.label = 2;     // Catch: Throwable -> L59
        r5 = BitmapHelperKt.c(r30, this);     // Catch: Throwable -> L59
        if (r5 != r0) goto L57;
        return r0;
    L48:
        r120 = 0.0d;
        goto L49
    L44:
        r118 = 0.0d;
        goto L45
    L40:
        r115 = 0.0d;
        goto L41
    L36:
        r113 = 0.0d;
        goto L37
    L84:
        r29.e("cropAvatarFromImageUrl", "invalid avatar location");
        return null;
    L85:
        FLogger.a.e("cropAvatarFromImageUrl", "return empty avatar location");
        return null;
    L26:
        r28 = null;
        goto L27
    L14:
        ResultKt.throwOnFailure(r19);
        CoroutineScope r31 = (CoroutineScope) this.L$0;
        AIGenBgImageRepository r122 = this.this$0;
        List r123 = CollectionsKt.listOf(this.$uri);
        this.L$0 = r31;
        this.label = 1;
        r122.getClass();
        r23 = BuildersKt.withContext(Dispatchers.getIO(), new AIGenBgImageRepository$getAvatarHeadLocation$2(r123, null), this);
        if (r23 != r0) goto L17;
        return r0;
    }
}
