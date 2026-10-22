package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.InputStream;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$onAlbumSelected$1", f = "ImageSelectorComponent.kt", i = {0, 0, 1, 2, 2, 2}, l = {1699, 1700, 1714}, m = "invokeSuspend", n = {"$this$launch", "preprocessJob", "$this$launch", "$this$launch", "preprocessResult", "imageUri"}, s = {"L$0", "L$1", "L$0", "L$0", "L$1", "L$3"})
public final class ImageSelectorComponent$onAlbumSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromInit;
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProcessFileResultCode.values().length];
            r0[ProcessFileResultCode.PREPARE_OVER_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ProcessFileResultCode.PREPARE_TYPE_NO_MATCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public ImageSelectorComponent$onAlbumSelected$1(ImageSelectorComponent r1, Uri r2, boolean r3, Continuation<? super ImageSelectorComponent$onAlbumSelected$1> r4) {
        this.this$0 = r1;
        this.$uri = r2;
        this.$fromInit = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ImageSelectorComponent$onAlbumSelected$1 r0 = new ImageSelectorComponent$onAlbumSelected$1(this.this$0, this.$uri, this.$fromInit, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r14 = "";
        String r15 = null;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L13;
        String r1 = (String) this.L$3;
        ImageSelectorComponent r3 = (ImageSelectorComponent) this.L$2;
        ic8.n0 r4 = (ic8.n0) this.L$1;
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r23);     // Catch: Throwable -> L10
        Object r11 = r23;
    L66:
        CloseableReference<CloseableImage> r12 = (CloseableReference) r11;     // Catch: Throwable -> L10
        if (r12 == null) goto L77;
        Lazy<Long> r5 = ImageSelectorComponent.X;     // Catch: Throwable -> L10
        r3.V3().a(String.valueOf(r1), r12);     // Catch: Throwable -> L10
        Object r6 = r12.get();     // Catch: Throwable -> L10
        if ((r6 instanceof CloseableStaticBitmap) == false) goto L71;
        CloseableStaticBitmap r8 = (CloseableStaticBitmap) r6;     // Catch: Throwable -> L10
    L72:
        if (r8 == null) goto L74;
        Bitmap r9 = r8.getUnderlyingBitmap();     // Catch: Throwable -> L10
    L75:
        if (r9 == null) goto L77;
    L80:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L10
        ic8.n0 r13 = r4;
    L85:
        if (Result.isFailure-impl(r10) == false) goto L87;
        r10 = null;
    L87:
        Bitmap r16 = (Bitmap) r10;
        if (r16 == null) goto L90;
        ImageSelectorComponent r17 = this.this$0;
        Lazy<Long> r18 = ImageSelectorComponent.X;
        r17.X3().V5(new sy9.b.e(r16, r17.h5(), null, 12));
    L90:
        nz9.b.h("upload", "creation_page/album_upload", null, null, 28);
        ic8.m0 r19 = r13.a;
        if (r19 == null) goto L93;
        String r20 = Boxing.boxLong(r19.c).toString();
    L94:
        if (r20 != null) goto L96;
        r20 = "";
    L96:
        nz9.b.c("upload", "file_size", r20, null);
        ic8.m0 r21 = r13.a;
        if (r21 == null) goto L99;
        String r22 = Boxing.boxLong(r21.c).toString();
    L100:
        if (r22 != null) goto L102;
        r22 = "";
    L102:
        nz9.b.c("creation_page/album_upload", "file_size", r22, null);
        ic8.m0 r24 = r13.a;
        if (r24 == null) goto L105;
        String r25 = r24.d;
    L106:
        if (r25 != null) goto L108;
        r25 = "";
    L108:
        nz9.b.c("creation_page/album_upload", "file_type", r25, null);
        String r26 = this.this$0.E;
        if (r26 == null) goto L111;
        tx9.l0.d(r26);
    L112:
        ImageSelectorComponent r27 = this.this$0;
        ic8.m0 r28 = r13.a;
        if (r28 == null) goto L115;
        r15 = r28.e;
    L115:
        if (r15 == null) goto L118;
        r14 = r15;
    L118:
        r27.F4(r14, r13.a);
    L138:
        return Unit.INSTANCE;
    L111:
        FLogger.a.i("ImageSelectorComponent", "curUploadTaskId is null before recordUploadStartTime");
        goto L112
    L105:
        r25 = null;
        goto L106
    L99:
        r22 = null;
        goto L100
    L93:
        r20 = null;
        goto L94
    L74:
        r9 = null;
        goto L75
    L71:
        r8 = null;
    L77:
        BitmapFactory.Options r29 = new BitmapFactory.Options();     // Catch: Throwable -> L10
        r29.inSampleSize = 1;     // Catch: Throwable -> L10
        r29.inJustDecodeBounds = false;     // Catch: Throwable -> L10
        InputStream r30 = ContentResolverWrapper.openInputStream(AppHost.a.getApplication().getContentResolver(), UriProtector.parse(r1));     // Catch: Throwable -> L10
        r9 = BitmapFactory.decodeStream(r30, null, r29);     // Catch: Throwable -> L10
        if (r30 == null) goto L80;
        r30.close();     // Catch: Throwable -> L10
    L10:
        th = th;
    L58:
        r13 = r4;
    L83:
        Result.Companion r31 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L85
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        CoroutineScope r32 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r23);
        Object r33 = r23;
    L22:
        r13 = (ic8.n0) r33;
        ProcessFileResultCode r34 = r13.b;
        if (r34 != null) goto L25;
    L27:
        boolean r35 = false;
    L28:
        if (r35 == false) goto L119;
        ic8.m0 r36 = r13.a;
        if (r36 == null) goto L32;
        String r37 = r36.e;
    L34:
        if (com.larus.utils.o0.d(r37) == false) goto L119;
        Pair[] r38 = new Pair[2];
        ic8.m0 r110 = r13.a;
        if (r110 == null) goto L38;
        String r111 = Boxing.boxLong(r110.c).toString();
    L39:
        if (r111 != null) goto L41;
        r111 = "";
    L41:
        r38[0] = TuplesKt.to("file_size", r111);
        ic8.m0 r112 = r13.a;
        if (r112 == null) goto L44;
        String r113 = r112.d;
    L45:
        if (r113 != null) goto L47;
        r113 = "";
    L47:
        r38[1] = TuplesKt.to("file_type", r113);
        nz9.b.d("preprocess", CollectionsKt.listOf(r38), null);
        nz9.b.e("preprocess", "0", null);
        this.this$0.E = UUID.randomUUID().toString();
        if (r13.b != ProcessFileResultCode.PREPARE_GIF_PROCESS_SUCCESS) goto L50;
    L51:
        this.this$0.m.setValue(ry9.j.h.b);
        ImageSelectorComponent r39 = this.this$0;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L82
        ic8.m0 r114 = r13.a;     // Catch: Throwable -> L82
        if (r114 != null) goto L139;
        String r115 = null;
    L60:
        if (r115 != null) goto L62;
        r115 = "";
    L62:
        String r41 = com.larus.utils.y0.k(Uri.fromFile(new PolarisFileWrapper(r115)));     // Catch: Throwable -> L82
        Function1 r116 = new y0();     // Catch: Throwable -> L82
        this.L$0 = r32;     // Catch: Throwable -> L82
        this.L$1 = r13;     // Catch: Throwable -> L82
        this.L$2 = r39;     // Catch: Throwable -> L82
        this.L$3 = r41;     // Catch: Throwable -> L82
        this.label = 3;     // Catch: Throwable -> L82
        r11 = ImageLoaderKt.i(r41, "instruction_image_selector", r116, this, 28);     // Catch: Throwable -> L82
        if (r11 != r0) goto L65;
        return r0;
    L65:
        r3 = r39;
        r4 = r13;
        r1 = r41;
        goto L66
    L139:
        r115 = r114.e;     // Catch: Throwable -> L56
    L56:
        th = th;
        r4 = r13;
    L82:
        th = th;
        goto L83
    L50:
        if (this.this$0.X3().getCurBitmap() != null) goto L90;
    L44:
        r113 = null;
        goto L45
    L38:
        r111 = null;
        goto L39
    L32:
        r37 = null;
    L119:
        FLogger r42 = FLogger.a;
        r42.e("ImageSelectorComponent", "preprocess albumImg failed");
        ProcessFileResultCode r43 = r13.b;
        if (r43 != null) goto L122;
        int r44 = -1;
    L123:
        if (r44 != 1) goto L125;
        r42.e("ImageSelectorComponent", "tryAttachmentUpload ProcessResult for OverSize");
        t19.s r45 = t19.s.a;
        Context r46 = this.this$0.getContext();
        r45.getClass();
        t19.s.s(r46, 2131906513);
    L129:
        ImageSelectorComponent r47 = this.this$0;
        Lazy<Long> r48 = ImageSelectorComponent.X;
        r47.X3().V5(new sy9.b.a(this.this$0.h5()));
        this.this$0.m.setValue(ry9.j.b.b);
        this.this$0.v4(false, "upload");
        ProcessFileResultCode r49 = r13.b;
        if (r49 == null) goto L132;
        String r50 = r49.getValue();
    L133:
        if (r50 == null) goto L136;
        r14 = r50;
    L136:
        nz9.b.e("preprocess", r14, null);
        nz9.b.e("creation_page/album_upload", "-101", null);
        goto L138
    L132:
        r50 = null;
        goto L133
    L125:
        if (r44 == 2) goto L127;
        t19.s r51 = t19.s.a;
        Context r52 = this.this$0.getContext();
        r51.getClass();
        t19.s.s(r52, 2131908214);
        goto L129
    L127:
        r42.e("ImageSelectorComponent", "tryAttachmentUpload ProcessResult for PREPARE_TYPE_NO_MATCH");
        t19.s r53 = t19.s.a;
        Context r54 = this.this$0.getContext();
        r53.getClass();
        t19.s.s(r54, 2131906526);
        goto L129
    L122:
        r44 = a.a[r43.ordinal()];
        goto L123
    L25:
        if (r34.isSuccess() != true) goto L27;
        r35 = true;
        goto L28
    L15:
        Deferred r55 = (Deferred) this.L$1;
        CoroutineScope r56 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r23);
        Deferred r57 = r55;
        r32 = r56;
    L19:
        this.L$0 = r32;
        this.L$1 = null;
        this.label = 2;
        r33 = r57.await(this);
        if (r33 != r0) goto L22;
        return r0;
    L16:
        ResultKt.throwOnFailure(r23);
        r32 = (CoroutineScope) this.L$0;
        nz9.b.h("preprocess", "creation_page/album_upload", null, null, 28);
        r57 = BuildersKt.async$default(r32, Dispatchers.getIO(), null, new ImageSelectorComponent$onAlbumSelected$1$preprocessJob$1(this.$uri, this.this$0, null), 2, null);
        ImageSelectorComponent r58 = this.this$0;
        Uri r117 = this.$uri;
        boolean r118 = this.$fromInit;
        this.L$0 = r32;
        this.L$1 = r57;
        this.label = 1;
        if (ImageSelectorComponent.m3(r58, r117, r118, this) != r0) goto L19;
        return r0;
    }
}
