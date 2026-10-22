package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.graphics.Bitmap;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$handleResourceAccessSuccess$1", f = "ImageSelectorComponent.kt", i = {0}, l = {2009}, m = "invokeSuspend", n = {"finalLocalFilePath"}, s = {"L$0"})
final class ImageSelectorComponent$handleResourceAccessSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.resource.access.f0 $accessArtifact;
    final /* synthetic */ String $localFilePath;
    final /* synthetic */ mr9.l $result;
    Object L$0;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$handleResourceAccessSuccess$1(com.larus.bmhome.resource.access.f0 r1, String r2, ImageSelectorComponent r3, mr9.l r4, Continuation<? super ImageSelectorComponent$handleResourceAccessSuccess$1> r5) {
        this.$accessArtifact = r1;
        this.$localFilePath = r2;
        this.this$0 = r3;
        this.$result = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ImageSelectorComponent$handleResourceAccessSuccess$1(this.$accessArtifact, this.$localFilePath, this.this$0, this.$result, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r23);
        Object r4 = r23;
    L44:
        Bitmap r5 = (Bitmap) r4;
        String r10 = r3;
    L47:
        ImageSelectorComponent r6 = this.this$0;
        Lazy<Long> r7 = ImageSelectorComponent.X;
        ImageSelectorUploadPreviewHelper r8 = r6.h4();
        r8.a.V5(new sy9.b.c(r5, ((Boolean) r8.c.invoke()).booleanValue()));
        ImageSelectorComponent r9 = this.this$0;
        r9.C = null;
        r9.D = null;
        r9.E = null;
        StateFlowImpl r11 = r9.m;
        String r12 = this.$result.a;
        mr9.d r13 = this.$result.d;
        if (r13 == null) goto L50;
        long r14 = r13.b;
    L51:
        Long r15 = Boxing.boxLong(r14);
        mr9.d r16 = this.$result.d;
        if (r16 == null) goto L54;
        long r17 = r16.a;
    L55:
        ImageUploadInfo r18 = new ImageUploadInfo(r15, Boxing.boxLong(r17));
        ImageSelectorComponent r19 = this.this$0;
        MediaAttachment r110 = new MediaAttachment(null, r12, r18, null, r10, r19.J, this.$result.c, r19.L, null, null, null, null, 3848, null);
        com.larus.bmhome.resource.access.f0 r20 = this.$accessArtifact;
        if (r20 == null) goto L60;
        Map r21 = r20.f;
        if (r21 == null) goto L60;
        String r22 = (String) r21.get("face_detected");
    L61:
        r11.setValue(new ry9.j.c(new ry9.i.a(r110, Boxing.boxBoolean(Intrinsics.areEqual(r22, "true")))));
        this.this$0.V4();
        this.this$0.v4(true, null);
        nz9.b.e("creation_page/album_upload", "0", null);
        return Unit.INSTANCE;
    L60:
        r22 = null;
        goto L61
    L54:
        r17 = 0;
        goto L55
    L50:
        r14 = 0;
        goto L51
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        com.larus.uaigc.helper.f.a.getClass();
        boolean r24 = com.larus.uaigc.helper.f.a();
        com.larus.bmhome.resource.access.f0 r25 = this.$accessArtifact;
        if (r25 == null) goto L11;
        com.larus.bmhome.resource.access.j0 r26 = r25.b;
    L13:
        if ((r26 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L15;
        com.larus.bmhome.resource.access.j0.b r27 = (com.larus.bmhome.resource.access.j0.b) r26;
    L16:
        if (r27 == null) goto L19;
        String r28 = r27.b;
        if (r28 == null) goto L19;
    L20:
        String r29 = this.this$0.C;
        if (r29 != null) goto L25;
        return Unit.INSTANCE;
    L25:
        if (Intrinsics.areEqual(r29, this.$localFilePath) == false) goto L64;
        if (r24 == false) goto L28;
    L30:
        r5 = this.this$0.X3().getCurBitmap();
        if (r5 == null) goto L33;
    L46:
        r10 = r28;
        goto L47
    L33:
        if (r28.length() <= 0) goto L35;
        boolean r30 = true;
    L36:
        if (r30 == false) goto L38;
        String r31 = r28;
    L39:
        if (r31 == null) goto L45;
        ImageSelectorComponent r32 = this.this$0;
        CoroutineDispatcher r33 = Dispatchers.getIO();
        ImageSelectorComponent$handleResourceAccessSuccess$1$displayBitmap$2$1 r34 = new ImageSelectorComponent$handleResourceAccessSuccess$1$displayBitmap$2$1(r32, r31, null);
        this.L$0 = r28;
        this.label = 1;
        r4 = BuildersKt.withContext(r33, r34, this);
        if (r4 != r1) goto L43;
        return r1;
    L43:
        r3 = r28;
        goto L44
    L45:
        r5 = null;
        goto L46
    L38:
        r31 = null;
        goto L39
    L35:
        r30 = false;
        goto L36
    L28:
        if ((this.this$0.X3().getCurState().getValue() instanceof sy9.b.e) == true) goto L30;
    L64:
        return Unit.INSTANCE;
    L19:
        r28 = this.$localFilePath;
        goto L20
    L15:
        r27 = null;
        goto L16
    L11:
        r26 = null;
        goto L13
    }
}
