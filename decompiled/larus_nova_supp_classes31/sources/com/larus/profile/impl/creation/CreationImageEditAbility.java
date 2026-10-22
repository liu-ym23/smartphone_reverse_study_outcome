package com.larus.profile.impl.creation;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.router.SmartRouter;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationImageEditAbility {
    public static final /* synthetic */ int d = 0;
    public final Context a;
    public final LifecycleCoroutineScope b;
    public final fs9.g c;

    public static final class a {
    }

    public static final class b extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        public final /* synthetic */ Function1<Bitmap, Unit> a;
        public final /* synthetic */ Function1<String, Unit> b;

        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r2) {
            Intrinsics.checkNotNullParameter(r2, "dataSource");
            Function1<String, Unit> r3 = this.b;
            if (r3 == null) goto L6;
            r3.invoke("Bitmap download fails.");
            return;
        }

        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r4) {
            Intrinsics.checkNotNullParameter(r4, "dataSource");
            if (r4.isFinished() == false) goto L21;
            CloseableReference r5 = (CloseableReference) r4.getResult();
            if (r5 == null) goto L26;
            Object r0 = r5.get();     // Catch: Throwable -> L12 Exception -> L14
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.facebook.imagepipeline.image.CloseableBitmap");     // Catch: Throwable -> L12 Exception -> L14
            Bitmap r1 = ((CloseableBitmap) r0).getUnderlyingBitmap();     // Catch: Throwable -> L12 Exception -> L14
            if (r1 != null) goto L9;
        L18:
            r5.close();
            return;
        L9:
            if (r1.isRecycled() == true) goto L18;
            Bitmap r2 = r1.copy(com.larus.utils.z0.b(r1.getConfig()), r1.isMutable());     // Catch: Throwable -> L12 Exception -> L14
            Function1<Bitmap, Unit> r3 = this.a;     // Catch: Throwable -> L12 Exception -> L14
            Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L12 Exception -> L14
            r3.invoke(r2);     // Catch: Throwable -> L12 Exception -> L14
        L14:
            e = move-exception;
            Function1<String, Unit> r6 = this.b;     // Catch: Throwable -> L12
            if (r6 == null) goto L18;
            r6.invoke(e.toString());     // Catch: Throwable -> L12
            goto L18
        L26:
            return;
        L12:
            th = move-exception;
            r5.close();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Bitmap, Unit> r1, Function1<? super String, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void c() {
        LifecycleCoroutineScope r0 = this.b;
        if (r0 == null) goto L6;
        BuildersKt.launch$default(r0, null, null, new CreationImageEditAbility$doImageEditAction$1(this, null), 3, null);
        return;
    }

    public static final void b(CreationImageEditAbility r4, Bundle r5) {
        r4.getClass();
        if (ICreationWorkflowService.a.U(r4.a, false, r5, true) == true) goto L7;
        com.bytedance.router.i r6 = SmartRouter.buildRoute(r4.a, "//flow/chat_page");
        r6.c.putExtras(r5);
        r6.d = 2130772401;
        r6.e = 2130772399;
        r6.d();
        return;
    }

    public CreationImageEditAbility(Context r2, LifecycleCoroutineScope r3, fs9.g r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "doImageEditInitParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final Object d(String r6, Function1<? super Bitmap, Unit> r7, Function1<? super String, Unit> r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof CreationImageEditAbility$downloadByUrl$3) == false) goto L7;
        CreationImageEditAbility$downloadByUrl$3 r0 = (CreationImageEditAbility$downloadByUrl$3) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        b r11 = (b) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L18:
        ImageRequest r12 = ImageRequestBuilder.newBuilderWithSource((Uri) r10).build();
        Fresco.getImagePipeline().fetchDecodedImage(r12, AppHost.a.getApplication()).subscribe(r11, UiThreadImmediateExecutorService.getInstance());
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        b r13 = new b(r7, r8);
        r0.L$0 = r13;
        r0.label = 1;
        Object r14 = ImageLoaderKt.r(r6, "bitmap_downloader", r0);
        if (r14 != r2) goto L17;
        return r2;
    L17:
        r10 = r14;
        r11 = r13;
    L7:
        r0 = new CreationImageEditAbility$downloadByUrl$3(this, r9);
        goto L8
    }

    public static final Object a(CreationImageEditAbility r16, String r17, String r18, Map r19, int r20, CreationImageEditAbility$doImageEditAction$1.a r21, Continuation r22) {
        r16.getClass();
        if ((r22 instanceof CreationImageEditAbility$buildImageRemoveSendMessageConfig$1) == false) goto L7;
        CreationImageEditAbility$buildImageRemoveSendMessageConfig$1 r1 = (CreationImageEditAbility$buildImageRemoveSendMessageConfig$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        boolean r9 = true;
        String r12 = "";
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        int r4 = r1.I$0;
        String r5 = (String) r1.L$4;
        zs8.a r6 = (zs8.a) r1.L$3;
        Map r7 = (Map) r1.L$2;
        String r10 = (String) r1.L$1;
        String r11 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L34:
        wc9.e r13 = (wc9.e) r0;
        if (r13 != null) goto L37;
        r13 = (wc9.e) AuthModelDelegate.b.u().getValue();
    L37:
        String r14 = r11;
        Map r15 = r7;
        String r110 = r10;
    L38:
        if (r13 == null) goto L40;
        String r23 = r13.a;
    L41:
        if (r23 == null) goto L45;
        r12 = r23;
    L45:
        if (r12.length() != 0) goto L47;
        boolean r24 = true;
    L48:
        if (r24 == true) goto L52;
        r5 = r12;
    L52:
        if (r5.length() == 0) goto L55;
        r9 = false;
    L55:
        if (r9 == false) goto L57;
        FLogger.a.e("creationImageEditAbility", "buildImageRemoveSendMessageConfig cvsId is empty");
        return null;
    L57:
        CreationSendMessageConfig.Companion.getClass();
        CreationSendMessageConfig.a r25 = new CreationSendMessageConfig.a();
        r25.l(r5);
        r25.f(r14);
        r25.i(r110);
        r25.s("edit");
        r25.u("edit");
        r25.m(r6.getEnterMethod());
        r25.r(r6.b());
        r25.d(Boxing.boxInt(r4));
        r25.c(r15);
        r25.b("image_edit");
        return r25.a;
    L47:
        r24 = false;
        goto L48
    L40:
        r23 = null;
        goto L41
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r4 = r1.I$0;
        r5 = (String) r1.L$4;
        r6 = (zs8.a) r1.L$3;
        Map r26 = (Map) r1.L$2;
        String r27 = (String) r1.L$1;
        String r28 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r15 = r26;
        r110 = r27;
        r14 = r28;
    L28:
        r13 = (wc9.e) r0;
        if (r13 != null) goto L38;
        RepoDispatcher.a.getClass();
        ConversationRepo r29 = RepoDispatcher.f;
        r1.L$0 = r14;
        r1.L$1 = r110;
        r1.L$2 = r15;
        r1.L$3 = r6;
        r1.L$4 = r5;
        r1.I$0 = r4;
        r1.label = 2;
        r0 = r29.f(r1);
        if (r0 == r8) goto L61;
        r11 = r14;
        r10 = r110;
        r7 = r15;
        goto L34
    L61:
        return r8;
    L16:
        ResultKt.throwOnFailure(r0);
        com.larus.bmhome.chat.api.e0 r30 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r30 == null) goto L21;
        LaunchInfo r31 = r30.a;
        if (r31 == null) goto L21;
        String r32 = r31.Y();
    L22:
        if (r32 != null) goto L24;
        r32 = "";
    L24:
        RepoDispatcher.a.getClass();
        ConversationRepo r33 = RepoDispatcher.f;
        r14 = r17;
        r1.L$0 = r14;
        r110 = r18;
        r1.L$1 = r110;
        r15 = r19;
        r1.L$2 = r15;
        r1.L$3 = r21;
        r1.L$4 = r32;
        r1.I$0 = r20;
        r1.label = 1;
        Object r34 = IConversationRepoService.a.c(r33, r32, false, null, r1, 6);
        if (r34 == r8) goto L60;
        r6 = r21;
        r5 = r32;
        r0 = r34;
        r4 = r20;
        goto L28
    L60:
        return r8;
    L21:
        r32 = null;
    L7:
        r1 = new CreationImageEditAbility$buildImageRemoveSendMessageConfig$1(r16, r22);
        goto L8
    }
}
