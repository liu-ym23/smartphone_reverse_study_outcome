package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteImagePreviewHelper$createBitmapProvider$1", f = "MmAINoteImagePreviewHelper.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
final class MmAINoteImagePreviewHelper$createBitmapProvider$1 extends SuspendLambda implements Function1<Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Context $context;
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h $source;
    int label;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteImagePreviewHelper$createBitmapProvider$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteImagePreviewHelper$createBitmapProvider$1$1", f = "MmAINoteImagePreviewHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ Context $context;
        final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h $source;
        int label;

        public AnonymousClass1(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h r1, Context r2, Context r3, Continuation<? super AnonymousClass1> r4) {
            this.$source = r1;
            this.$context = r2;
            this.$appContext = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$source, this.$context, this.$appContext, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L86;
            ResultKt.throwOnFailure(r10);
            d r11 = d.a;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h r0 = this.$source;
            r11.getClass();
            Object r12 = d.b(r0);
            boolean r1 = false;
            Object r2 = null;
            if ((r12 instanceof String) == false) goto L43;
            String r13 = (String) r12;
            final Context r4 = this.$appContext;
            Function1<Uri, InputStream> r3 = new C00551(r4);
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L34
            if (StringsKt.startsWith$default(r13, "content://", false, 2, null) == false) goto L20;
            InputStream r6 = (InputStream) r3.invoke(UriProtector.parse(r13));     // Catch: Throwable -> L34
            if (r6 != null) goto L90;
        L31:
            Bitmap r7 = null;
        L32:
            Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L34
        L36:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L40;
            int r14 = bwb.b.a;
            bwb.b.d(MmUiLogScene.FOUNDATION, "decodeBitmap", "failed, source=" + r13 + ", error=" + r9.getMessage(), null);
        L40:
            if (Result.isFailure-impl(r8) == false) goto L42;
            r8 = null;
        L42:
            Bitmap r15 = (Bitmap) r8;
        L44:
            if (r15 != null) goto L94;
            d r16 = d.a;
            Context r17 = this.$context;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h r18 = this.$source;
            r16.getClass();
            Object r19 = d.b(r18);
            if (r19 == null) goto L84;
            Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L70
            IRequestCreator r110 = ImageLoader.with(r17).load(r19);     // Catch: Throwable -> L70
            Integer r21 = Integer.valueOf(r18.e);     // Catch: Throwable -> L70
            if (r21.intValue() <= 0) goto L51;
            boolean r22 = true;
        L53:
            if (Boolean.valueOf(r22).booleanValue() == true) goto L56;
            r21 = null;
        L56:
            int r23 = Integer.MIN_VALUE;
            if (r21 == null) goto L59;
            int r24 = r21.intValue();     // Catch: Throwable -> L70
        L60:
            Integer r25 = Integer.valueOf(r18.f);     // Catch: Throwable -> L70
            if (r25.intValue() <= 0) goto L63;
            r1 = true;
        L63:
            if (r1 == true) goto L66;
            r25 = null;
        L66:
            if (r25 == null) goto L68;
            r23 = r25.intValue();     // Catch: Throwable -> L70
        L68:
            Object r111 = Result.constructor-impl(r110.getBitmap(r24, r23));     // Catch: Throwable -> L70
        L72:
            Throwable r26 = Result.exceptionOrNull-impl(r111);
            if (r26 == null) goto L79;
            int r27 = bwb.b.a;
            MmUiLogScene r28 = MmUiLogScene.FOUNDATION;
            StringBuilder r29 = new StringBuilder("failed, sourceType=");
            r29.append(r18.g);
            r29.append(", uri=");
            String r30 = r18.b;
            if (r30 != null) goto L77;
            r30 = r18.a;
        L77:
            r29.append(r30);
            r29.append(", error=");
            r29.append(r26.getMessage());
            bwb.b.d(r28, "loadBitmapByImageLoader", r29.toString(), null);
        L79:
            if (Result.isFailure-impl(r111) == true) goto L82;
            r2 = r111;
        L82:
            r2 = (Bitmap) r2;
            goto L84
        L59:
            r24 = Integer.MIN_VALUE;
            goto L60
        L51:
            r22 = false;
        L70:
            th = move-exception;
            Result.Companion r31 = Result.Companion;
            r111 = Result.constructor-impl(ResultKt.createFailure(th));
        L84:
            return r2;
        L94:
            return r15;
        L90:
            r7 = BitmapFactory.decodeStream(r6);     // Catch: Throwable -> L14
            CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L34
            goto L32
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L34
            throw th;     // Catch: Throwable -> L34
        L20:
            if (StringsKt.startsWith$default(r13, "file://", false, 2, null) == false) goto L26;
            String r32 = UriProtector.parse(r13).getPath();     // Catch: Throwable -> L34
            if (r32 != null) goto L24;
            r32 = "";
        L24:
            r7 = BitmapFactory.decodeFile(r32);     // Catch: Throwable -> L34
            goto L32
        L26:
            if (StringsKt.startsWith$default(r13, "http://", false, 2, null) == true) goto L31;
            if (StringsKt.startsWith$default(r13, "https://", false, 2, null) == true) goto L31;
            r7 = BitmapFactory.decodeFile(r13);     // Catch: Throwable -> L34
        L34:
            th = move-exception;
            Result.Companion r33 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L36
        L43:
            r15 = null;
            goto L44
        L86:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MmAINoteImagePreviewHelper$createBitmapProvider$1(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h r1, Context r2, Context r3, Continuation<? super MmAINoteImagePreviewHelper$createBitmapProvider$1> r4) {
        this.$source = r1;
        this.$context = r2;
        this.$appContext = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmAINoteImagePreviewHelper$createBitmapProvider$1(this.$source, this.$context, this.$appContext, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Bitmap> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$source, this.$context, this.$appContext, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r9, r2, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
