package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.common.apphost.AppHost;
import com.tencent.open.log.TraceLevel;
import java.io.InputStream;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$preShowUploadingUri$2", f = "ImageSelectorComponent.kt", i = {0, 1}, l = {1667, 1669}, m = "invokeSuspend", n = {"delayShowEmptyUploadingJob", "delayShowEmptyUploadingJob"}, s = {"L$0", "L$0"})
final class ImageSelectorComponent$preShowUploadingUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $fromInit;
    final /* synthetic */ boolean $reportDecodeFailure;
    final /* synthetic */ Uri $uri;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$preShowUploadingUri$2(Uri r1, ImageSelectorComponent r2, boolean r3, boolean r4, Continuation<? super ImageSelectorComponent$preShowUploadingUri$2> r5) {
        this.$uri = r1;
        this.this$0 = r2;
        this.$fromInit = r3;
        this.$reportDecodeFailure = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ImageSelectorComponent$preShowUploadingUri$2(this.$uri, this.this$0, this.$fromInit, this.$reportDecodeFailure, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v23, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    public final Object invokeSuspend(Object r23) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L10;
        Ref.ObjectRef r3 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r23);     // Catch: Throwable -> L73
        Object r4 = r23;
        ?? r5 = r3;
    L71:
        Object r1 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r4).booleanValue()));     // Catch: Throwable -> L73
        ?? r6 = r5;
    L76:
        Job r7 = (Job) ((Ref.ObjectRef) r6).element;
        if (r7 == null) goto L80;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L80:
        if (Result.isFailure-impl(r1) == false) goto L83;
        return null;
    L83:
        return r1;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        boolean r8 = this.Z$0;
        ImageSelectorComponent r9 = (ImageSelectorComponent) this.L$1;
        ?? r10 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r23);     // Catch: Throwable -> L14
        boolean r14 = r8;
        ImageSelectorComponent r13 = r9;
        ?? r11 = r10;
        Object r12 = r23;
    L65:
        Bitmap r15 = (Bitmap) r12;     // Catch: Throwable -> L73
        Job r16 = (Job) ((Ref.ObjectRef) r11).element;     // Catch: Throwable -> L73
        if (r16 == null) goto L68;
        Job.DefaultImpls.cancel$default(r16, null, 1, null);     // Catch: Throwable -> L73
    L68:
        MainCoroutineDispatcher r17 = Dispatchers.getMain();     // Catch: Throwable -> L73
        ImageSelectorComponent$preShowUploadingUri$2$1$2 r18 = new ImageSelectorComponent$preShowUploadingUri$2$1$2(r15, r13, r14, null);     // Catch: Throwable -> L73
        this.L$0 = r11;     // Catch: Throwable -> L73
        this.L$1 = null;     // Catch: Throwable -> L73
        this.label = 2;     // Catch: Throwable -> L73
        r4 = BuildersKt.withContext(r17, r18, this);     // Catch: Throwable -> L73
        r5 = r11;
        if (r4 != r0) goto L71;
        return r0;
    L14:
        th = th;
    L75:
        Result.Companion r19 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        r6 = r10;
        goto L76
    L16:
        ResultKt.throwOnFailure(r23);
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        Uri r21 = this.$uri;
        r13 = this.this$0;
        boolean r22 = this.$fromInit;
        r14 = this.$reportDecodeFailure;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L73
        AppHost.Companion r25 = AppHost.a;     // Catch: Throwable -> L73
        InputStream r26 = ContentResolverWrapper.openInputStream(r25.getApplication().getContentResolver(), r21);     // Catch: Throwable -> L73
        BitmapFactory.Options r110 = new BitmapFactory.Options();     // Catch: Throwable -> L73
        r110.inJustDecodeBounds = true;     // Catch: Throwable -> L73
        BitmapFactory.decodeStream(r26, null, r110);     // Catch: Throwable -> L73
        if (r26 == null) goto L20;
        r26.close();     // Catch: Throwable -> L73
    L20:
        String r27 = r110.outMimeType;     // Catch: Throwable -> L73
        if (r27 == null) goto L23;
        String r28 = r27.toLowerCase(Locale.US);     // Catch: Throwable -> L73
    L25:
        if (Intrinsics.areEqual(r28, "image/gif") == false) goto L28;
        r13.m.setValue(ry9.j.h.b);     // Catch: Throwable -> L73
        return Boxing.boxBoolean(true);
    L28:
        InputStream r29 = ContentResolverWrapper.openInputStream(r25.getApplication().getContentResolver(), r21);     // Catch: Throwable -> L73
        if (r29 == null) goto L31;
        ExifInterface r30 = new ExifInterface(r29);     // Catch: Throwable -> L73
    L32:
        if (r30 == null) goto L34;
        Integer r31 = Boxing.boxInt(r30.getAttributeInt("Orientation", 1));     // Catch: Throwable -> L73
    L35:
        if (r29 == null) goto L37;
        r29.close();     // Catch: Throwable -> L73
    L37:
        boolean r111 = false;
        if (r31 != null) goto L41;
    L42:
        if (r31 != null) goto L45;
    L47:
        boolean r32 = false;
    L49:
        LifecycleCoroutineScope r112 = LifecycleOwnerKt.getLifecycleScope(r13);     // Catch: Throwable -> L73
        if (r32 == false) goto L52;
        boolean r113 = true;
    L53:
        r20.element = BuildersKt.launch$default(r112, null, null, new ImageSelectorComponent$preShowUploadingUri$2$1$1(r22, r13, r113, r110, null), 3, null);     // Catch: Throwable -> L73
        r13.m.setValue(ry9.j.h.b);     // Catch: Throwable -> L73
        ny9.s r33 = r13.G3();     // Catch: Throwable -> L73
        if (r33 != null) goto L56;
    L58:
        if (r111 == false) goto L62;
        ys8.a r34 = r13.Z3();     // Catch: Throwable -> L73
        if (r34 == null) goto L62;
        Lazy<Long> r35 = ImageSelectorComponent.X;     // Catch: Throwable -> L73
        r34.selectRatio(ImageSelectorComponent.a.a());     // Catch: Throwable -> L73
    L62:
        ImageSelectorUploadPreviewHelper r36 = r13.h4();     // Catch: Throwable -> L73
        String r37 = r21.toString();     // Catch: Throwable -> L73
        this.L$0 = r20;     // Catch: Throwable -> L73
        this.L$1 = r13;     // Catch: Throwable -> L73
        this.Z$0 = r14;     // Catch: Throwable -> L73
        this.label = 1;     // Catch: Throwable -> L73
        r12 = r36.a(r37, this);     // Catch: Throwable -> L73
        r11 = r20;
        if (r12 != r0) goto L65;
        return r0;
    L56:
        if (r33.B() != true) goto L58;
        r111 = true;
        goto L58
    L52:
        r113 = false;
        goto L53
    L45:
        if (r31.intValue() != 8) goto L47;
    L48:
        r32 = true;
        goto L49
    L41:
        if (r31.intValue() == 6) goto L48;
    L34:
        r31 = null;
        goto L35
    L31:
        r30 = null;
        goto L32
    L23:
        r28 = null;
    L73:
        th = th;
        r10 = r2;
        goto L75
    }
}
