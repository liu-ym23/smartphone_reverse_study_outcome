package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.image.loader.ImageLoaderKt;
import com.tencent.open.log.TraceLevel;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$initPassedImage$1$3", f = "ImageSelectorComponent.kt", i = {0, 3}, l = {1248, 1251, 1259, 1271}, m = "invokeSuspend", n = {"resizeThreshold", "bitmap"}, s = {"I$0", "L$0"})
final class ImageSelectorComponent$initPassedImage$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Image $it;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$initPassedImage$1$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$initPassedImage$1$3$1", f = "ImageSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        int label;
        final /* synthetic */ ImageSelectorComponent this$0;

        public AnonymousClass1(ImageSelectorComponent r1, Bitmap r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$bitmap = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$bitmap, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            ImageSelectorComponent r5 = this.this$0;
            Lazy<Long> r0 = ImageSelectorComponent.X;
            r5.X3().V5(new sy9.b.c(this.$bitmap, this.this$0.h5()));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ImageSelectorComponent$initPassedImage$1$3(ImageSelectorComponent r1, Image r2, Continuation<? super ImageSelectorComponent$initPassedImage$1$3> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImageSelectorComponent$initPassedImage$1$3(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r29) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r5 = false;
        String r10 = "";
        if (r0 == 0) goto L20;
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        Bitmap r1 = (Bitmap) this.L$0;
        ResultKt.throwOnFailure(r29);
    L115:
        ImageSelectorComponent r3 = this.this$0;
        Lazy<Long> r4 = ImageSelectorComponent.X;
        ny9.s r6 = r3.G3();
        if (r6 != null) goto L118;
    L120:
        boolean r7 = false;
    L121:
        if (r7 == true) goto L132;
        ny9.s r8 = this.this$0.G3();
        if (r8 != null) goto L125;
    L127:
        boolean r9 = false;
    L128:
        if (r9 == false) goto L132;
        ys8.a r11 = this.this$0.Z3();
        if (r11 == null) goto L132;
        r11.selectRatio(ImageSelectorComponent.a.a());
        goto L132
    L125:
        if (r8.B() != true) goto L127;
        r9 = true;
    L132:
        ImageObj r12 = this.$it.imageOri;
        if (r12 == null) goto L139;
        String r13 = r12.url;
        if (r13 == null) goto L139;
        if (com.larus.utils.o0.d(r13) == false) goto L139;
        String r21 = r13;
    L140:
        ImageObj r14 = this.$it.previewImage;
        if (r14 == null) goto L147;
        String r15 = r14.url;
        if (r15 == null) goto L147;
        if (com.larus.utils.o0.d(r15) == false) goto L147;
        String r22 = r15;
    L148:
        ny9.s r16 = this.this$0.G3();
        if (r16 != null) goto L151;
    L153:
        boolean r17 = false;
    L154:
        if (r17 == false) goto L156;
    L157:
        r5 = true;
    L158:
        StateFlowImpl r18 = this.this$0.m;
        if (r5 == false) goto L162;
        if (r22 == null) goto L164;
    L163:
        String r19 = r22;
    L165:
        String r110 = this.$it.key;
        ImageObj r20 = this.$it.imageOri;
        if (r20 == null) goto L168;
        int r23 = r20.width;
    L169:
        Long r24 = Boxing.boxLong(r23);
        ImageObj r25 = this.$it.imageOri;
        if (r25 == null) goto L172;
        int r26 = r25.height;
    L173:
        ImageUploadInfo r111 = new ImageUploadInfo(r24, Boxing.boxLong(r26));
        Image r27 = this.$it;
        String r28 = r27.localResPath;
        String r30 = this.this$0.L;
        if (r5 == false) goto L176;
        Boolean r31 = Boxing.boxBoolean(true);
    L177:
        r18.setValue(new ry9.j.c(new ry9.i.a(new MediaAttachment(r19, r110, r111, null, r28, null, null, r30, r21, r22, null, r31, 1128, null), null)));
        this.this$0.V4();
        return Unit.INSTANCE;
    L176:
        r31 = r27.aiCreationImage;
        goto L177
    L172:
        r26 = r1.getHeight();
        goto L173
    L168:
        r23 = r1.getWidth();
    L164:
        r19 = r21;
        goto L165
    L162:
        if (r21 != null) goto L164;
    L156:
        if (Intrinsics.areEqual(this.$it.aiCreationImage, Boxing.boxBoolean(true)) == false) goto L158;
    L151:
        if (r16.x() != true) goto L153;
        r17 = true;
    L147:
        r22 = null;
    L139:
        r21 = null;
        goto L140
    L118:
        if (r6.D() != true) goto L120;
        r7 = true;
        goto L121
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ImageSelectorComponent r32 = (ImageSelectorComponent) this.L$1;
        Image r33 = (Image) this.L$0;
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L103
        Image r34 = r33;
        Object r35 = r29;
    L88:
        CloseableReference<CloseableImage> r36 = (CloseableReference) r35;     // Catch: Throwable -> L103
        Image r112 = r34;
    L89:
        if (r36 == null) goto L100;
        Lazy<Long> r37 = ImageSelectorComponent.X;     // Catch: Throwable -> L103
        c r38 = r32.V3();     // Catch: Throwable -> L103
        String r39 = r112.localResPath;     // Catch: Throwable -> L103
        if (r39 == null) goto L94;
        r10 = r39;
    L94:
        r38.a(r10, r36);     // Catch: Throwable -> L103
        Object r40 = r36.get();     // Catch: Throwable -> L103
        if ((r40 instanceof CloseableStaticBitmap) == false) goto L97;
        CloseableStaticBitmap r41 = (CloseableStaticBitmap) r40;     // Catch: Throwable -> L103
    L98:
        if (r41 == null) goto L100;
        Bitmap r42 = r41.getUnderlyingBitmap();     // Catch: Throwable -> L103
    L101:
        Object r43 = Result.constructor-impl(r42);     // Catch: Throwable -> L103
    L106:
        if (Result.isFailure-impl(r43) == false) goto L108;
        r43 = null;
    L108:
        r1 = (Bitmap) r43;
        if (r1 == null) goto L111;
        MainCoroutineDispatcher r44 = Dispatchers.getMain();
        AnonymousClass1 r45 = new AnonymousClass1(this.this$0, r1, null);
        this.L$0 = r1;
        this.L$1 = null;
        this.label = 4;
        if (BuildersKt.withContext(r44, r45, this) != r2) goto L115;
        return r2;
    L111:
        return Unit.INSTANCE;
    L97:
        r41 = null;
    L100:
        r42 = null;
        goto L101
    L14:
        r32 = (ImageSelectorComponent) this.L$1;
        Image r46 = (Image) this.L$0;
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L103
        r112 = r46;
        Object r47 = r29;
    L66:
        r36 = (CloseableReference) r47;     // Catch: Throwable -> L103
        goto L89
    L17:
        int r48 = this.I$0;
        ImageSelectorComponent r49 = (ImageSelectorComponent) this.L$1;
        r112 = (Image) this.L$0;
        ResultKt.throwOnFailure(r29);     // Catch: Throwable -> L103
        final int r113 = r48;
        r32 = r49;
        Object r50 = r29;
    L38:
        r36 = (CloseableReference) r50;     // Catch: Throwable -> L103
        if (r36 != null) goto L89;
        ImageObj r51 = r112.imageThumb;     // Catch: Throwable -> L103
        if (r51 == null) goto L43;
        String r52 = r51.url;     // Catch: Throwable -> L103
    L44:
        if (r52 != null) goto L47;
        r52 = "";
    L47:
        if (r52.length() != 0) goto L49;
        boolean r114 = true;
    L50:
        if (r114 == false) goto L63;
        ImageObj r53 = r112.imageOri;     // Catch: Throwable -> L103
        if (r53 == null) goto L54;
        r52 = r53.url;     // Catch: Throwable -> L103
    L55:
        if (r52 != null) goto L58;
        r52 = "";
    L58:
        if (r52.length() != 0) goto L60;
        boolean r115 = true;
    L61:
        if (r115 == false) goto L63;
        r52 = r112.localResPath;     // Catch: Throwable -> L103
        goto L63
    L60:
        r115 = false;
        goto L61
    L54:
        r52 = null;
    L63:
        Function1 r116 = new q0(r113);     // Catch: Throwable -> L103
        this.L$0 = r112;     // Catch: Throwable -> L103
        this.L$1 = r32;     // Catch: Throwable -> L103
        this.label = 2;     // Catch: Throwable -> L103
        r47 = ImageLoaderKt.i(r52, "instruction_image_selector", r116, this, 28);     // Catch: Throwable -> L103
        if (r47 != r2) goto L66;
        return r2;
    L49:
        r114 = false;
        goto L50
    L43:
        r52 = null;
        goto L44
    L20:
        ResultKt.throwOnFailure(r29);
        Image r54 = this.$it;
        ImageSelectorComponent r117 = this.this$0;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L103
        r113 = com.larus.platform.service.z2.a.getImageEditUploadConfig().b;     // Catch: Throwable -> L103
        if (com.larus.utils.o0.d(r54.localResPath) == false) goto L67;
        String r119 = r54.localResPath;     // Catch: Throwable -> L103
        if (r119 != null) goto L26;
        r119 = "";
    L26:
        Lazy<Long> r120 = ImageSelectorComponent.X;     // Catch: Throwable -> L103
        r117.getClass();     // Catch: Throwable -> L103
        String r121 = ImageSelectorComponent.a4(r119).getPath();     // Catch: Throwable -> L103
        if (r121 != null) goto L30;
        r121 = "";
    L30:
        if (new PolarisFileWrapper(r121).exists() == false) goto L67;
        String r55 = r54.localResPath;     // Catch: Throwable -> L103
        if (r55 != null) goto L34;
        r55 = "";
    L34:
        String r56 = com.larus.utils.y0.k(ImageSelectorComponent.a4(r55));     // Catch: Throwable -> L103
        this.L$0 = r54;     // Catch: Throwable -> L103
        this.L$1 = r117;     // Catch: Throwable -> L103
        this.I$0 = r113;     // Catch: Throwable -> L103
        this.label = 1;     // Catch: Throwable -> L103
        r50 = ImageLoaderKt.i(r56, "instruction_image_selector", null, this, 60);     // Catch: Throwable -> L103
        if (r50 != r2) goto L37;
        return r2;
    L37:
        r112 = r54;
        r32 = r117;
    L67:
        ImageObj r57 = r54.imageThumb;     // Catch: Throwable -> L103
        if (r57 == null) goto L70;
        String r58 = r57.url;     // Catch: Throwable -> L103
    L71:
        if (r58 != null) goto L74;
        r58 = "";
    L74:
        if (r58.length() != 0) goto L76;
        boolean r122 = true;
    L77:
        if (r122 == false) goto L84;
        ImageObj r59 = r54.imageOri;     // Catch: Throwable -> L103
        if (r59 == null) goto L81;
        r58 = r59.url;     // Catch: Throwable -> L103
    L82:
        if (r58 != null) goto L84;
        r58 = "";
        goto L84
    L81:
        r58 = null;
    L84:
        Function1 r123 = new r0(r113);     // Catch: Throwable -> L103
        this.L$0 = r54;     // Catch: Throwable -> L103
        this.L$1 = r117;     // Catch: Throwable -> L103
        this.label = 3;     // Catch: Throwable -> L103
        r35 = ImageLoaderKt.i(r58, "instruction_image_selector", r123, this, 28);     // Catch: Throwable -> L103
        if (r35 != r2) goto L87;
        return r2;
    L87:
        r34 = r54;
        r32 = r117;
        goto L88
    L76:
        r122 = false;
        goto L77
    L70:
        r58 = null;
    L103:
        th = move-exception;
        Result.Companion r60 = Result.Companion;
        r43 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L106
    }
}
