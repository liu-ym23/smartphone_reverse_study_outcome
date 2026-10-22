package com.larus.drive.sdk.impl.gallery;

import androidx.appcompat.app.AppCompatActivity;
import com.larus.bmhome.bigimg.m1;
import com.larus.chat.gallery.api.IChatGalleryService;
import com.larus.chat.gallery.api.PreviewMediaType;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.gallery.DriveGalleryHelper$tryOpenUnifiedMediaPreview$2", f = "DriveGalleryHelper.kt", i = {0}, l = {247}, m = "invokeSuspend", n = {"activity"}, s = {"L$0"})
final class DriveGalleryHelper$tryOpenUnifiedMediaPreview$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ z79.b $galleryContext;
    private /* synthetic */ Object L$0;
    int label;

    public DriveGalleryHelper$tryOpenUnifiedMediaPreview$2(z79.b r1, Continuation<? super DriveGalleryHelper$tryOpenUnifiedMediaPreview$2> r2) {
        this.$galleryContext = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DriveGalleryHelper$tryOpenUnifiedMediaPreview$2 r0 = new DriveGalleryHelper$tryOpenUnifiedMediaPreview$2(this.$galleryContext, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        Integer r5 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        AppCompatActivity r4 = (AppCompatActivity) this.L$0;
        ResultKt.throwOnFailure(r24);
        Object r6 = r24;
    L45:
        List r7 = CollectionsKt.filterNotNull((Iterable) r6);
        ArrayList r11 = new ArrayList();
        Iterator r8 = r7.iterator();
    L47:
        if (r8.hasNext() == false) goto L89;
        z79.c r9 = (z79.c) r8.next();
        DriveFileItem r10 = r9.a;
        if (r10 != null) goto L52;
    L86:
        com.larus.chat.gallery.api.o r12 = null;
    L87:
        if (r12 == null) goto L47;
        r11.add(r12);
        goto L47
    L52:
        if (r10.j != DriveFileType.VIDEO) goto L54;
        boolean r13 = true;
    L55:
        if (r13 == false) goto L59;
        nr9.g r14 = r9.c;
        if (r14 == null) goto L62;
        String r15 = r14.c;
    L63:
        if (r15 == null) goto L86;
        if ((!StringsKt.isBlank(r15)) == false) goto L67;
        String r16 = r15;
    L68:
        if (r16 == null) goto L86;
        String r17 = r10.b;
        if (r13 == false) goto L72;
        PreviewMediaType r18 = PreviewMediaType.VIDEO;
    L73:
        PreviewMediaType r110 = r18;
        if (r13 == false) goto L80;
        nr9.g r20 = r9.c;
        if (r20 == null) goto L84;
        nr9.f r21 = r20.g;
        if (r21 == null) goto L84;
        String r22 = r21.b;
    L83:
        String r111 = r22;
    L85:
        r12 = new com.larus.chat.gallery.api.o(r17, r16, r110, r111, 0, 0, 0, 112);
    L84:
        r111 = null;
        goto L85
    L80:
        m1 r23 = r9.b;
        if (r23 == null) goto L84;
        r22 = r23.b;
        goto L83
    L72:
        r18 = PreviewMediaType.IMAGE;
        goto L73
    L67:
        r16 = null;
    L62:
        r15 = null;
        goto L63
    L59:
        m1 r112 = r9.b;
        if (r112 == null) goto L62;
        r15 = r112.a;
        goto L63
    L54:
        r13 = false;
        goto L55
    L89:
        z79.b r25 = this.$galleryContext;
        Iterator r26 = r11.iterator();
        int r27 = 0;
    L91:
        if (r26.hasNext() == false) goto L96;
        if (Intrinsics.areEqual(((com.larus.chat.gallery.api.o) r26.next()).a, r25.b.b) == true) goto L97;
        r27 = r27 + 1;
    L97:
        Integer r28 = Boxing.boxInt(r27);
        if (r28.intValue() >= 0) goto L101;
        r3 = false;
    L101:
        if (r3 == false) goto L103;
        r5 = r28;
    L103:
        if (r5 == null) goto L107;
        int r113 = r5.intValue();
        DriveGalleryHelper.DrivePreviewMediaSession r114 = new DriveGalleryHelper.DrivePreviewMediaSession(this.$galleryContext, r7, r11);
        return Boxing.boxBoolean(IChatGalleryService.a.b(IChatGalleryService.a, this.$galleryContext.getContext(), r4.getSupportFragmentManager(), PreviewScene.CLOUD_DRIVE, r11, r113, r114, r114.p, null, 128));
    L107:
        return Boxing.boxBoolean(false);
    L96:
        r27 = -1;
        goto L97
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r24);
        CoroutineScope r30 = (CoroutineScope) this.L$0;
        AppCompatActivity r31 = this.$galleryContext.getContext();
        if ((r31 instanceof AppCompatActivity) == false) goto L11;
        AppCompatActivity r115 = r31;
    L12:
        if (r115 != null) goto L16;
        return Boxing.boxBoolean(false);
    L16:
        if (IChatGalleryService.a.n(PreviewScene.CLOUD_DRIVE, false) == false) goto L18;
        List<DriveFileItem> r32 = this.$galleryContext.d;
        if (r32 != null) goto L22;
        r32 = CollectionsKt.emptyList();
    L22:
        ArrayList r33 = new ArrayList();
        Iterator<T> r34 = r32.iterator();
    L24:
        if (r34.hasNext() == false) goto L34;
        Object r35 = r34.next();
        DriveFileType r36 = ((DriveFileItem) r35).j;
        if (r36 != DriveFileType.IMAGE) goto L28;
    L31:
        boolean r37 = true;
    L32:
        if (r37 == false) goto L24;
        r33.add(r35);
        goto L24
    L28:
        if (r36 == DriveFileType.VIDEO) goto L31;
        r37 = false;
        goto L32
    L34:
        z79.b r38 = this.$galleryContext;
        boolean r40 = r33.isEmpty();
        List r41 = r33;
        if (r40 == false) goto L37;
        r41 = CollectionsKt.listOf(r38.b);
    L37:
        List r42 = r41;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r42, 10));
        Iterator r117 = r42.iterator();
    L39:
        if (r117.hasNext() == false) goto L41;
        r116.add(BuildersKt.async$default(r30, null, null, new DriveGalleryHelper$tryOpenUnifiedMediaPreview$2$galleryData$1$1((DriveFileItem) r117.next(), null), 3, null));
        goto L39
    L41:
        this.L$0 = r115;
        this.label = 1;
        r6 = AwaitKt.a(r116, this);
        if (r6 != r1) goto L44;
        return r1;
    L44:
        r4 = r115;
        goto L45
    L18:
        return Boxing.boxBoolean(false);
    L11:
        r115 = null;
        goto L12
    }
}
