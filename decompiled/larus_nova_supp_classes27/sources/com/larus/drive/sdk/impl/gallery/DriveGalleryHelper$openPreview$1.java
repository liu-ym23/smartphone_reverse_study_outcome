package com.larus.drive.sdk.impl.gallery;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.drive.biz.api.IDriveService;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.gallery.DriveGalleryHelper$openPreview$1", f = "DriveGalleryHelper.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
final class DriveGalleryHelper$openPreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DriveFileItem $file;
    final /* synthetic */ z79.b $galleryContext;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFileType.values().length];
            r0[DriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[DriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[DriveFileType.AI_DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DriveFileType.AI_SLIDES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[DriveFileType.AI_SHEET.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public DriveGalleryHelper$openPreview$1(z79.b r1, DriveFileItem r2, Continuation<? super DriveGalleryHelper$openPreview$1> r3) {
        this.$galleryContext = r1;
        this.$file = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DriveGalleryHelper$openPreview$1(this.$galleryContext, this.$file, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r58) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r58);
    L25:
        DriveFileType r3 = this.$file.j;
        if (r3 == DriveFileType.AI_SLIDES) goto L31;
        if (r3 == DriveFileType.AI_DOC) goto L31;
        String r18 = IDriveService.a.j();
        DriveFileItem r4 = this.$file;
        String r5 = r4.b;
        String r6 = r4.a;
        int r7 = com.larus.drive.sdk.impl.utils.n.a;
        a1.c(null, null, null, null, null, "ai_space_detail", null, null, "ai_space_list", null, null, null, null, null, null, null, r18, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r5, r6, com.larus.drive.sdk.impl.utils.n.e(r4.j), com.larus.drive.sdk.impl.utils.n.d(this.$file), null, null, -1049729, 268435455, 7);
    L31:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r58);
        DriveGalleryHelper.e.l(this.$galleryContext.f);
        int r8 = a.a[this.$file.j.ordinal()];
        if (r8 != 1) goto L11;
    L22:
        DriveGalleryHelper r9 = DriveGalleryHelper.a;
        z79.b r10 = this.$galleryContext;
        this.label = 1;
        if (DriveGalleryHelper.a(r9, r10, this) != r1) goto L25;
        return r1;
    L11:
        if (r8 == 2) goto L22;
        if (r8 != 3) goto L15;
        z79.b r11 = this.$galleryContext;
        com.larus.drive.sdk.impl.utils.k r12 = com.larus.drive.sdk.impl.utils.k.a;
        Context r13 = r11.getContext();
        DriveFileItem r14 = r11.b;
        String r15 = r11.e.getValue();
        r12.getClass();
        com.larus.drive.sdk.impl.utils.k.e(r13, r14, r15);
        goto L25
    L15:
        if (r8 != 4) goto L17;
        z79.b r16 = this.$galleryContext;
        com.larus.drive.sdk.impl.utils.k r17 = com.larus.drive.sdk.impl.utils.k.a;
        Context r20 = r16.getContext();
        DriveFileItem r21 = r16.b;
        String r22 = r16.e.getValue();
        r17.getClass();
        com.larus.drive.sdk.impl.utils.k.e(r20, r21, r22);
        goto L25
    L17:
        if (r8 == 5) goto L19;
        z79.b r23 = this.$galleryContext;
        com.bytedance.router.i r24 = SmartRouter.buildRoute(r23.getContext(), "//flow/drive_preview");
        r24.c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("drive_file", r23.b), TuplesKt.to("drive_preview_from_page", r23.e.getValue())}));
        r24.d = 2130772401;
        r24.e = 2130772399;
        r24.d();
        goto L25
    L19:
        z79.b r25 = this.$galleryContext;
        FLogger.a.i("DriveGalleryHelper", "[openAISheetPreview] token=" + r25.b.b + "， owner=" + r25.b.g());
        com.larus.drive.sdk.impl.utils.k r26 = com.larus.drive.sdk.impl.utils.k.a;
        Context r27 = r25.getContext();
        DriveFileItem r28 = r25.b;
        String r30 = r25.e.getValue();
        r26.getClass();
        com.larus.drive.sdk.impl.utils.k.e(r27, r28, r30);
        goto L25
    }
}
