package com.larus.community.impl.detail.image;

import android.graphics.Bitmap;
import com.larus.bmhome.actionbar.model.j1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.platform.api.creation.UserCreation;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.image.CreationDetailImageComponent$detectCreationImage$1", f = "CreationDetailImageComponent.kt", i = {}, l = {150, 171}, m = "invokeSuspend", n = {}, s = {})
final class CreationDetailImageComponent$detectCreationImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserCreation $creation;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationDetailImageComponent this$0;

    public CreationDetailImageComponent$detectCreationImage$1(UserCreation r1, CreationDetailImageComponent r2, Continuation<? super CreationDetailImageComponent$detectCreationImage$1> r3) {
        this.$creation = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CreationDetailImageComponent$detectCreationImage$1 r0 = new CreationDetailImageComponent$detectCreationImage$1(this.$creation, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r21);
    L52:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r21);
        Object r3 = r21;
    L13:
        Bitmap r4 = (Bitmap) r3;
        int r6 = 0;
        if (r4 == null) goto L23;
        zp9.i r7 = this.this$0.l;
        if (r7 == null) goto L20;
        zp9.b r8 = r7.a(r4);
        if (r8 == null) goto L20;
        Integer r9 = Boxing.boxInt(r8.a);
    L21:
        if (r9 == null) goto L23;
        int r10 = r9.intValue();
    L24:
        if (r4 == null) goto L26;
        int r11 = r4.getWidth();
    L27:
        if (r4 == null) goto L29;
        r6 = r4.getHeight();
    L29:
        FLogger r5 = FLogger.a;
        r5.i("CreationDetailImageComponent", "refFaceCount:" + r10 + ", refWidth:" + r11 + ", refHeight:" + r6 + ", imgUrl:" + this.$creation.h());
        z0 r12 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(11);
        StringBuilder r13 = new StringBuilder("avatarActionBarItemExt:");
        if (r12 == null) goto L34;
        com.larus.bmhome.actionbar.model.r r14 = r12.q;
        if (r14 == null) goto L34;
        j1 r15 = r14.e;
    L35:
        r13.append(r15);
        r5.d("CreationDetailImageComponent", r13.toString());
        if (r12 == null) goto L52;
        com.larus.bmhome.actionbar.model.r r16 = r12.q;
        if (r16 == null) goto L52;
        j1 r17 = r16.e;
        if (r17 == null) goto L52;
        String r18 = this.$creation.h();
        String r110 = String.valueOf(r11);
        String r111 = String.valueOf(r6);
        if (r10 != 1) goto L45;
        String r20 = "single";
    L48:
        j1 r22 = j1.a(r17, null, null, null, r18, r20, r110, r111, null, null, 16285695);
        CreationDetailImageComponent r23 = this.this$0;
        MainCoroutineDispatcher r24 = Dispatchers.getMain();
        CreationDetailImageComponent$detectCreationImage$1$1$1 r25 = new CreationDetailImageComponent$detectCreationImage$1$1$1(r23, r22, null);
        this.label = 2;
        if (BuildersKt.withContext(r24, r25, this) != r1) goto L52;
        return r1;
    L45:
        if (r10 <= 1) goto L47;
        r20 = "multi";
        goto L48
    L47:
        r20 = "";
    L34:
        r15 = null;
        goto L35
    L26:
        r11 = 0;
    L20:
        r9 = null;
    L23:
        r10 = 0;
        goto L24
    L10:
        ResultKt.throwOnFailure(r21);
        Deferred r26 = BuildersKt.async$default((CoroutineScope) this.L$0, null, null, new CreationDetailImageComponent$detectCreationImage$1$refImageBitmap$1(this.this$0, this.$creation, null), 3, null);
        this.label = 1;
        r3 = r26.await(this);
        if (r3 != r1) goto L13;
        return r1;
    }
}
