package com.ss.android.lark.flow.chat.mediapreview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.flow.chat.message.image.FlowYunPanFileUtils;
import com.ss.android.lark.flow.chat.message.image.f;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.utils.ChatImageSettings;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.entity.PhotoState;
import java.io.File;
import java.io.Serializable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kza.j;
import nlb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowLargeImageLoadController {
    public final Context a;
    public final FlowLargeImageView b;
    public final GallerySource c;
    public final b d;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.widget.photo.preview.utils.b {
        public b() {
        }

        public final File a(IRequestCreator r2, com.ss.android.lark.image.entity.b r3) {
            Intrinsics.checkNotNullParameter(r2, "requestCreator");
            Intrinsics.checkNotNullParameter(r3, "imageKey");
            f r4 = f.a;
            return f.d(r3);
        }
    }

    public static final class c implements FlowLargeImageView.b {
        public final /* synthetic */ j a;

        @Override // com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView.b
        public final void onLoadFailed() {
            j r0 = this.a;
            if (r0 == null) goto L6;
            r0.a("");
            return;
        }

        @Override // com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView.b
        public final void onLoadSuccess() {
            j r0 = this.a;
            if (r0 == null) goto L6;
            r0.onLoadSuccess();
            return;
        }

        public c(j r1) {
            this.a = r1;
        }
    }

    static {
    }

    public static String d(PhotoItem r2) {
        return "photoItem:" + r2.getMessageId() + ", ";
    }

    public FlowLargeImageLoadController(Context r2, FlowLargeImageView r3, GallerySource r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "largeImageView");
        Intrinsics.checkNotNullParameter(r4, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new b();
    }

    public final Object c(PhotoItem r9, FlowLargeImageView.b r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof FlowLargeImageLoadController$downloadOrigin$1) == false) goto L7;
        FlowLargeImageLoadController$downloadOrigin$1 r0 = (FlowLargeImageLoadController$downloadOrigin$1) r11;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        FlowLargeImageView.b r13 = (FlowLargeImageView.b) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L33:
        if (((Boolean) r12).booleanValue() == true) goto L37;
        if (r13 == null) goto L37;
        r13.onLoadFailed();
    L37:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r12);
    L27:
        return Unit.INSTANCE;
    L17:
        r10 = (FlowLargeImageView.b) r0.L$1;
        r9 = (PhotoItem) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L21:
        File r14 = (File) r12;
        r9.getPhotoState().setOriginFile(r14);
        if (r14 == null) goto L28;
        Log.i("FlowLargeImageLoadController", d(r9) + "has downloaded origin success");
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (g(r9, r14, r10, r0) != r2) goto L27;
        return r2;
    L28:
        Log.i("FlowLargeImageLoadController", d(r9) + "has downloaded origin failed");
        CoroutineDispatcher r15 = Dispatchers.getIO();
        FlowLargeImageLoadController$downloadOrigin$hasCache$1 r4 = new FlowLargeImageLoadController$downloadOrigin$hasCache$1(this, r9, null);
        r0.L$0 = r10;
        r0.L$1 = null;
        r0.label = 3;
        r12 = BuildersKt.withContext(r15, r4, r0);
        if (r12 != r2) goto L31;
        return r2;
    L31:
        r13 = r10;
        goto L33
    L18:
        ResultKt.throwOnFailure(r12);
        Log.i("FlowLargeImageLoadController", d(r9) + "download origin file");
        CoroutineDispatcher r16 = Dispatchers.getIO();
        FlowLargeImageLoadController$downloadOrigin$originFile$1 r5 = new FlowLargeImageLoadController$downloadOrigin$originFile$1(this, r9, null);
        r0.L$0 = r9;
        r0.L$1 = r10;
        r0.label = 1;
        r12 = BuildersKt.withContext(r16, r5, r0);
        if (r12 != r2) goto L21;
        return r2;
    L7:
        r0 = new FlowLargeImageLoadController$downloadOrigin$1(this, r11);
        goto L8
    }

    public final Object e(PhotoItem r23, FlowLargeImageView$loadDefault$1.AnonymousClass1.a r24, Continuation r25) {
        PhotoItem r1 = r23;
        FlowLargeImageView.b r2 = r24;
        if ((r25 instanceof FlowLargeImageLoadController$loadPhoto$1) == false) goto L7;
        FlowLargeImageLoadController$loadPhoto$1 r4 = (FlowLargeImageLoadController$loadPhoto$1) r25;
        int r5 = r4.label;
        if ((r5 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r4.label = r5 - Target.SIZE_ORIGINAL;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L22;
        if (r7 == 1) goto L21;
        if (r7 == 2) goto L20;
        if (r7 == 3) goto L19;
        if (r7 == 4) goto L18;
        if (r7 != 5) goto L17;
        ResultKt.throwOnFailure(r3);
    L81:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r3);
    L86:
        return Unit.INSTANCE;
    L19:
        FlowLargeImageView.b r8 = (FlowLargeImageView.b) r4.L$1;
        PhotoItem r9 = (PhotoItem) r4.L$0;
        ResultKt.throwOnFailure(r3);
        Object r10 = r6;
    L72:
        File r11 = (File) r3;
        if (r11 != null) goto L75;
    L82:
        r4.L$0 = null;
        r4.L$1 = null;
        r4.label = 4;
        if (c(r9, r8, r4) != r10) goto L86;
        return r10;
    L75:
        if (r11.exists() == false) goto L82;
        r9.getPhotoState().setMiddleFile(r11);
        r4.L$0 = null;
        r4.L$1 = null;
        r4.label = 5;
        if (g(r9, r11, r8, r4) != r10) goto L81;
        return r10;
    L20:
        ResultKt.throwOnFailure(r3);
    L96:
        return Unit.INSTANCE;
    L21:
        FlowLargeImageView.b r12 = (FlowLargeImageView.b) r4.L$1;
        PhotoItem r13 = (PhotoItem) r4.L$0;
        ResultKt.throwOnFailure(r3);
        r2 = r12;
        r1 = r13;
    L25:
        boolean r14 = ((Boolean) r3).booleanValue();
        if (r1.getPhotoState().getOriginFile() == null) goto L28;
        boolean r15 = true;
    L29:
        Context r16 = this.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r16, "context");
        PhotoState r17 = r1.getPhotoState();
        PhotoItem.PicInfo r18 = r1.getOriginPicInfo();
        if (r18 == null) goto L32;
        Serializable r19 = r18.loadModel;
    L33:
        PhotoItem.PicInfo r20 = r1.getMiddlePicInfo();
        if (r20 == null) goto L36;
        Serializable r21 = r20.loadModel;
    L37:
        ChatImageSettings.LargeImageRemoteTarget r110 = ChatImageSettings.getLargeImageRemote().getTarget();
        long r22 = ((long) r110.getAutoOriginMax()) * 1024;
        boolean r111 = r17.isLoadOrigin();
        boolean r112 = Intrinsics.areEqual("origin", r110.getDefaultTarget());
        if (r17.getOriginFile() == null) goto L40;
        boolean r113 = true;
    L41:
        boolean r26 = r15;
        boolean r27 = !r1.isOriginSource();
        boolean r28 = Intrinsics.areEqual(r19, r21);
        if (NetworkUtils.d(r16) == true) goto L44;
    L46:
        boolean r114 = false;
    L47:
        boolean r115 = r17.isFromMe();
        if (r1.getOriginSize() > r22) goto L50;
        boolean r29 = true;
    L51:
        if (r111 == true) goto L61;
        if (r112 == true) goto L61;
        if (r113 == true) goto L61;
        if (r27 == true) goto L61;
        if (r28 == true) goto L61;
        if (r114 == false) goto L60;
        if (r115 == true) goto L61;
        if (r29 == true) goto L61;
    L60:
        boolean r30 = false;
    L62:
        Log.i("needAutoLoadOrigin", r1.getMessageId() + ":  needShowOrigin:" + r30 + " --> isLoadOrigin:" + r111 + ", remoteConfigOrigin:" + r112 + ", hasOriginCache:" + r113 + ", isSendCommonMode:" + r27 + ", origin and middle is same key:" + r28 + ", isNetGood:" + r114 + ", isFromMe:" + r115 + ", is small icon:" + r29);
        if (r30 == true) goto L88;
        if (this.c == GallerySource.ReplayThread) goto L88;
        if (r14 == true) goto L98;
        Log.i("FlowLargeImageLoadController", d(r1) + "no any cache, auto download middle file");
        CoroutineDispatcher r31 = Dispatchers.getIO();
        FlowLargeImageLoadController$loadPhoto$middleFile$1 r32 = new FlowLargeImageLoadController$loadPhoto$middleFile$1(this, r1, null);
        r4.L$0 = r1;
        r4.L$1 = r2;
        r4.label = 3;
        r3 = BuildersKt.withContext(r31, r32, r4);
        r10 = r6;
        if (r3 != r10) goto L71;
        return r10;
    L71:
        FlowLargeImageView.b r210 = r2;
        r9 = r1;
        r8 = r210;
    L98:
        return Unit.INSTANCE;
    L88:
        if (r26 == true) goto L98;
        Log.i("FlowLargeImageLoadController", d(r1) + "no origin cache, auto download origin file");
        if (r14 == false) goto L92;
        r2 = null;
    L92:
        r4.L$0 = null;
        r4.L$1 = null;
        r4.label = 2;
        if (b(r14, r1, r2, r4) != r6) goto L96;
        return r6;
    L61:
        r30 = true;
        goto L62
    L50:
        r29 = false;
        goto L51
    L44:
        if (pac.a.a() == true) goto L46;
        r114 = true;
        goto L47
    L40:
        r113 = false;
        goto L41
    L36:
        r21 = null;
        goto L37
    L32:
        r19 = null;
        goto L33
    L28:
        r15 = false;
        goto L29
    L22:
        ResultKt.throwOnFailure(r3);
        CoroutineDispatcher r33 = Dispatchers.getIO();
        FlowLargeImageLoadController$loadPhoto$hasCache$1 r34 = new FlowLargeImageLoadController$loadPhoto$hasCache$1(this, r1, r2, null);
        r4.L$0 = r1;
        r4.L$1 = r2;
        r4.label = 1;
        r3 = BuildersKt.withContext(r33, r34, r4);
        if (r3 != r6) goto L25;
        return r6;
    L7:
        r4 = new FlowLargeImageLoadController$loadPhoto$1(this, r25);
        goto L8
    }

    public final Object f(ogb.a r7, j r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof FlowLargeImageLoadController$loadYunPanPhoto$1) == false) goto L7;
        FlowLargeImageLoadController$loadYunPanPhoto$1 r0 = (FlowLargeImageLoadController$loadYunPanPhoto$1) r9;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        File r11 = (File) r0.L$1;
        ogb.a r12 = (ogb.a) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L33:
        r12.b = r11;
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = (j) r0.L$1;
        r7 = (ogb.a) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L24:
        File r13 = (File) r10;
        if (r13 != null) goto L27;
    L35:
        if (r8 == null) goto L38;
        r8.a("loadYunPanPhoto failed");
    L38:
        return Unit.INSTANCE;
    L27:
        if (r13.exists() == false) goto L35;
        VFSPath r4 = VFSFiles.b.t(r13);
        FlowLargeImageView r5 = this.b;
        g r6 = new g();
        r6.a = r4;
        c r14 = new c(r8);
        r0.L$0 = r7;
        r0.L$1 = r13;
        r0.label = 2;
        if (r5.x(r6, r14, r0) != r2) goto L32;
        return r2;
    L32:
        r12 = r7;
        r11 = r13;
        goto L33
    L16:
        ResultKt.throwOnFailure(r10);
        FlowYunPanFileUtils r15 = FlowYunPanFileUtils.a;
        Context r16 = this.a;
        DocImageProperty r17 = r7.a;
        if (r17 == null) goto L20;
        String r18 = r17.getToken();
        if (r18 == null) goto L20;
    L21:
        r0.L$0 = r7;
        r0.L$1 = r8;
        r0.label = 1;
        r10 = r15.e(r16, r18, false, r0);
        if (r10 != r2) goto L24;
        return r2;
    L20:
        r18 = "";
    L7:
        r0 = new FlowLargeImageLoadController$loadYunPanPhoto$1(this, r9);
        goto L8
    }

    public static final Object a(FlowLargeImageLoadController r16, PhotoItem r17, FlowLargeImageView.b r18, Continuation r19) {
        r16.getClass();
        if ((r19 instanceof FlowLargeImageLoadController$showPhotoCache$1) == false) goto L7;
        FlowLargeImageLoadController$showPhotoCache$1 r3 = (FlowLargeImageLoadController$showPhotoCache$1) r19;
        int r4 = r3.label;
        if ((r4 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r3.label = r4 - Target.SIZE_ORIGINAL;
    L8:
        FlowLargeImageLoadController$showPhotoCache$1 r6 = r3;
        Object r2 = r6.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r6.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r2);
    L70:
        return Boxing.boxBoolean(true);
    L13:
        PhotoState r0 = (PhotoState) r6.L$2;
        FlowLargeImageView.b r5 = (FlowLargeImageView.b) r6.L$1;
        PhotoItem r8 = (PhotoItem) r6.L$0;
        ResultKt.throwOnFailure(r2);
        FlowLargeImageView.b r10 = r5;
    L57:
        File r9 = (File) r2;
        r0.setThumbnailFile(r9);
        if (r9 == null) goto L64;
        MainCoroutineDispatcher r11 = Dispatchers.getMain().getImmediate();
        FlowLargeImageLoadController$showPhotoCache$4 r12 = new FlowLargeImageLoadController$showPhotoCache$4(r16, r8, r9, r10, null);
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.label = 6;
        if (BuildersKt.withContext(r11, r12, r6) != r7) goto L70;
        return r7;
    L64:
        return Boxing.boxBoolean(false);
    L14:
        ResultKt.throwOnFailure(r2);
    L69:
        return Boxing.boxBoolean(true);
    L15:
        IRequestCreator r1 = (IRequestCreator) r6.L$3;
        PhotoState r13 = (PhotoState) r6.L$2;
        FlowLargeImageView.b r14 = (FlowLargeImageView.b) r6.L$1;
        PhotoItem r15 = (PhotoItem) r6.L$0;
        ResultKt.throwOnFailure(r2);
    L45:
        File r110 = (File) r2;
        r13.setMiddleFile(r110);
        if (r110 != null) goto L48;
    L53:
        CoroutineDispatcher r20 = Dispatchers.getIO();
        FlowLargeImageLoadController$showPhotoCache$thumbnailFile$1 r111 = new FlowLargeImageLoadController$showPhotoCache$thumbnailFile$1(r16, r1, r15, null);
        r6.L$0 = r15;
        r6.L$1 = r14;
        r6.L$2 = r13;
        r6.L$3 = null;
        r6.label = 5;
        r2 = BuildersKt.withContext(r20, r111, r6);
        if (r2 == r7) goto L75;
        r0 = r13;
        PhotoItem r112 = r15;
        r10 = r14;
        r8 = r112;
        goto L57
    L75:
        return r7;
    L48:
        if (r110.exists() == false) goto L53;
        MainCoroutineDispatcher r113 = Dispatchers.getMain().getImmediate();
        FlowLargeImageLoadController$showPhotoCache$3 r114 = new FlowLargeImageLoadController$showPhotoCache$3(r16, r15, r110, r14, null);
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.label = 4;
        if (BuildersKt.withContext(r113, r114, r6) != r7) goto L69;
        return r7;
    L16:
        ResultKt.throwOnFailure(r2);
    L67:
        return Boxing.boxBoolean(true);
    L17:
        r1 = (IRequestCreator) r6.L$3;
        r13 = (PhotoState) r6.L$2;
        FlowLargeImageView.b r115 = (FlowLargeImageView.b) r6.L$1;
        PhotoItem r116 = (PhotoItem) r6.L$0;
        ResultKt.throwOnFailure(r2);
        FlowLargeImageView.b r117 = r115;
    L30:
        File r118 = (File) r2;
        r13.setOriginFile(r118);
        if (r118 == null) goto L39;
        if (r118.exists() == false) goto L39;
        MainCoroutineDispatcher r119 = Dispatchers.getMain().getImmediate();
        FlowLargeImageLoadController$showPhotoCache$2 r120 = new FlowLargeImageLoadController$showPhotoCache$2(r16, r116, r118, r117, null);
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.label = 2;
        if (BuildersKt.withContext(r119, r120, r6) != r7) goto L67;
        return r7;
    L39:
        if (com.ss.android.lark.image.utils.a.c == false) goto L41;
        Log.i("FlowLargeImageLoadController", "Cipher on, stop find cache");
        return Boxing.boxBoolean(false);
    L41:
        CoroutineDispatcher r21 = Dispatchers.getIO();
        FlowLargeImageLoadController$showPhotoCache$middleFile$1 r22 = new FlowLargeImageLoadController$showPhotoCache$middleFile$1(r16, r1, r116, null);
        r6.L$0 = r116;
        r6.L$1 = r117;
        r6.L$2 = r13;
        r6.L$3 = r1;
        r6.label = 3;
        r2 = BuildersKt.withContext(r21, r22, r6);
        if (r2 == r7) goto L73;
        r15 = r116;
        r14 = r117;
        goto L45
    L73:
        return r7;
    L18:
        ResultKt.throwOnFailure(r2);
        if (com.ss.android.lark.image.utils.a.b() == true) goto L65;
        r13 = r17.getPhotoState();
        Serializable r23 = r17.getLoadModel();
        Serializable r121 = r17.getOriginPicInfo().loadModel;
        if (com.ss.android.lark.image.utils.a.c == true) goto L24;
    L26:
        IRequestCreator r24 = ImageLoader.with(r16.a);
        CoroutineDispatcher r122 = Dispatchers.getIO();
        FlowLargeImageLoadController$showPhotoCache$originFile$1 r123 = new FlowLargeImageLoadController$showPhotoCache$originFile$1(r16, r24, r17, null);
        r6.L$0 = r17;
        r117 = r18;
        r6.L$1 = r117;
        r6.L$2 = r13;
        r6.L$3 = r24;
        r6.label = 1;
        Object r124 = BuildersKt.withContext(r122, r123, r6);
        if (r124 == r7) goto L71;
        r116 = r17;
        r1 = r24;
        r2 = r124;
        goto L30
    L71:
        return r7;
    L24:
        if (Intrinsics.areEqual(r23, r121) == true) goto L26;
        Log.i("FlowLargeImageLoadController", "Cipher on && loadModel not origin, stop find cache");
        return Boxing.boxBoolean(false);
    L65:
        return Boxing.boxBoolean(false);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r3 = new FlowLargeImageLoadController$showPhotoCache$1(r16, r19);
        goto L8
    }

    public final Object b(boolean r18, PhotoItem r19, FlowLargeImageView.b r20, Continuation<? super Unit> r21) {
        PhotoItem r1 = r19;
        FlowLargeImageView.b r2 = r20;
        if ((r21 instanceof FlowLargeImageLoadController$autoDownloadOrigin$1) == false) goto L7;
        FlowLargeImageLoadController$autoDownloadOrigin$1 r4 = (FlowLargeImageLoadController$autoDownloadOrigin$1) r21;
        int r5 = r4.label;
        if ((r5 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r4.label = r5 - Target.SIZE_ORIGINAL;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L20;
        if (r7 == 1) goto L19;
        if (r7 == 2) goto L18;
        if (r7 == 3) goto L17;
        if (r7 != 4) goto L16;
        ResultKt.throwOnFailure(r3);
    L53:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r3);
    L48:
        return Unit.INSTANCE;
    L18:
        File r8 = (File) r4.L$2;
        r2 = (FlowLargeImageView.b) r4.L$1;
        PhotoItem r9 = (PhotoItem) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L40:
        PhotoItem r16 = r9;
        File r10 = r8;
        r1 = r16;
    L41:
        if (r10 == null) goto L44;
        r2 = null;
    L44:
        r4.L$0 = null;
        r4.L$1 = null;
        r4.L$2 = null;
        r4.label = 3;
        if (c(r1, r2, r4) != r6) goto L48;
        return r6;
    L19:
        PhotoState r11 = (PhotoState) r4.L$2;
        r2 = (FlowLargeImageView.b) r4.L$1;
        PhotoItem r12 = (PhotoItem) r4.L$0;
        ResultKt.throwOnFailure(r3);
        PhotoState r13 = r11;
        r1 = r12;
        Object r14 = r3;
    L34:
        r10 = (File) r14;
        Log.i("FlowLargeImageLoadController", d(r1) + "first download thumb file success");
        r13.setThumbnailFile(r10);
        if (r10 == null) goto L41;
        r4.L$0 = r1;
        r4.L$1 = r2;
        r4.L$2 = r10;
        r4.label = 2;
        if (g(r1, r10, r2, r4) != r6) goto L39;
        return r6;
    L39:
        r9 = r1;
        r8 = r10;
        goto L40
    L20:
        ResultKt.throwOnFailure(r3);
        r13 = r19.getPhotoState();
        if (r18 == true) goto L49;
        long r15 = r19.getOriginSize();
        ChatImageSettings.LargeImageRemoteFirstThumb r17 = ChatImageSettings.getLargeImageRemote().getFirstThumb();
        if (pac.a.a() == false) goto L25;
        float r22 = r17.getAutoOriginWeakMax();
    L26:
        float r110 = 1024;
        if (r15 <= ((long) ((r22 * r110) * r110))) goto L29;
        boolean r23 = true;
    L30:
        if (r23 == false) goto L49;
        CoroutineDispatcher r24 = Dispatchers.getIO();
        FlowLargeImageLoadController$autoDownloadOrigin$thumbFile$1 r25 = new FlowLargeImageLoadController$autoDownloadOrigin$thumbFile$1(this, r1, null);
        r4.L$0 = r1;
        r4.L$1 = r2;
        r4.L$2 = r13;
        r4.label = 1;
        r14 = BuildersKt.withContext(r24, r25, r4);
        if (r14 != r6) goto L34;
        return r6;
    L29:
        r23 = false;
        goto L30
    L25:
        r22 = r17.getAutoOriginMax();
    L49:
        r4.label = 4;
        if (c(r1, r2, r4) != r6) goto L53;
        return r6;
    L7:
        r4 = new FlowLargeImageLoadController$autoDownloadOrigin$1(this, r21);
        goto L8
    }

    public final Object g(PhotoItem r4, File r5, FlowLargeImageView.b r6, Continuation<? super Unit> r7) {
        PhotoState r0 = r4.getPhotoState();
        r0.getShowFile().setValue(r5);
        Drawable r1 = r0.getInlinePreviewDrawable();
        if (r1 != null) goto L5;
        r1 = r4.getThumbnail();
    L5:
        Log.i("FlowLargeImageLoadController", d(r4) + "showFile:" + r5.getPath());
        VFSPath r8 = VFSFiles.b.t(r5);
        if (r4.getType() != 4) goto L8;
        boolean r9 = true;
    L9:
        FlowLargeImageView r2 = this.b;
        g r3 = new g();
        r3.a = r8;
        r3.b = r1;
        r3.i = r9;
        Object r10 = r2.x(r3, r6, r7);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r10;
    L13:
        return Unit.INSTANCE;
    L8:
        r9 = false;
        goto L9
    }
}
