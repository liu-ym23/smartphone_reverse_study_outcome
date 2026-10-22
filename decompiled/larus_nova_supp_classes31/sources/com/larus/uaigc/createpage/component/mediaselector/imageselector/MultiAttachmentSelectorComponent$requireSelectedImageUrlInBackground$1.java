package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0}, l = {2362}, m = "invokeSuspend", n = {"liveData", "tosKey"}, s = {"L$0", "L$1"})
public final class MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $resourceKey;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1(MultiAttachmentSelectorComponent r1, String r2, Continuation<? super MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1> r3) {
        this.this$0 = r1;
        this.$resourceKey = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1(this.this$0, this.$resourceKey, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r4 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$1;
        MutableLiveData<ry9.k> r3 = (MutableLiveData) this.L$0;
        ResultKt.throwOnFailure(r8);
    L48:
        com.larus.network.http.y r9 = (com.larus.network.http.a) r8;
        if ((r9 instanceof com.larus.network.http.y) == false) goto L101;
        com.larus.network.http.y r10 = r9;
        FileUrlRespData r5 = (FileUrlRespData) ((com.larus.network.http.a) r10).b;
        if (r5 == null) goto L57;
        List r6 = r5.getFileUrlList();
        if (r6 == null) goto L57;
        FileUrlData r7 = (FileUrlData) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L57;
        String r11 = r7.getMainUrl();
    L59:
        if (com.larus.utils.o0.d(r11) == false) goto L101;
        ry9.k r12 = (ry9.k) r3.getValue();
        if (r12 == null) goto L63;
        ry9.j r13 = r12.b;
    L65:
        if ((r13 instanceof ry9.j.c) == false) goto L101;
        ry9.k r14 = (ry9.k) r3.getValue();
        if (r14 == null) goto L69;
        ry9.j r15 = r14.b;
    L70:
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.larus.uaigc.bean.createpage.component.mediacontainer.MediaSelectorStatus.Filled");
        ry9.i r16 = ((ry9.j.c) r15).b;
        if ((r16 instanceof ry9.i.a) == false) goto L73;
        ry9.i.a r17 = (ry9.i.a) r16;
    L74:
        if (r17 == null) goto L78;
        MediaAttachment r18 = r17.a;
        if (r18 == null) goto L78;
        String r19 = r18.getUri();
    L80:
        if (Intrinsics.areEqual(r19, r2) == false) goto L101;
        ry9.k r20 = (ry9.k) r3.getValue();
        if (r20 == null) goto L84;
        ry9.j r21 = r20.b;
    L85:
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type com.larus.uaigc.bean.createpage.component.mediacontainer.MediaSelectorStatus.Filled");
        ry9.i r22 = ((ry9.j.c) r21).b;
        if ((r22 instanceof ry9.i.a) == false) goto L88;
        ry9.i.a r23 = (ry9.i.a) r22;
    L89:
        if (r23 == null) goto L101;
        MediaAttachment r24 = r23.a;
        if (r24 == null) goto L101;
        FileUrlRespData r25 = (FileUrlRespData) ((com.larus.network.http.a) r10).b;
        if (r25 == null) goto L99;
        List r26 = r25.getFileUrlList();
        if (r26 == null) goto L99;
        FileUrlData r27 = (FileUrlData) CollectionsKt.firstOrNull(r26);
        if (r27 == null) goto L99;
        r4 = r27.getMainUrl();
    L99:
        r24.setUrl(r4);
        goto L101
    L88:
        r23 = null;
        goto L89
    L84:
        r21 = null;
    L78:
        r19 = null;
        goto L80
    L73:
        r17 = null;
        goto L74
    L69:
        r15 = null;
        goto L70
    L63:
        r13 = null;
    L57:
        r11 = null;
    L101:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        MultiAttachmentSelectorComponent r28 = this.this$0;
        String r29 = this.$resourceKey;
        int r30 = MultiAttachmentSelectorComponent.Z;
        r3 = r28.X3(r29);
        if (r3 == null) goto L11;
        ry9.k r31 = (ry9.k) r3.getValue();
        if (r31 == null) goto L15;
        ry9.j r32 = r31.b;
    L17:
        if ((r32 instanceof ry9.j.c) == false) goto L101;
        ry9.k r33 = (ry9.k) r3.getValue();
        if (r33 == null) goto L21;
        ry9.j r34 = r33.b;
    L22:
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type com.larus.uaigc.bean.createpage.component.mediacontainer.MediaSelectorStatus.Filled");
        ry9.i r35 = ((ry9.j.c) r34).b;
        if ((r35 instanceof ry9.i.a) == false) goto L25;
        ry9.i.a r36 = (ry9.i.a) r35;
    L26:
        if (r36 == null) goto L28;
        MediaAttachment r37 = r36.a;
    L29:
        if (r37 == null) goto L31;
        String r38 = r37.getUri();
    L33:
        if (com.larus.utils.o0.d(r38) == false) goto L101;
        if (r37 == null) goto L36;
        String r39 = r37.getUrl();
    L37:
        if (r39 != null) goto L39;
    L42:
        boolean r40 = true;
    L43:
        if (r40 == false) goto L101;
        CoroutineDispatcher r41 = Dispatchers.getIO();
        MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1 r42 = new MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1$resp$1(r38, null);
        this.L$0 = r3;
        this.L$1 = r38;
        this.label = 1;
        r8 = BuildersKt.withContext(r41, r42, this);
        if (r8 != r0) goto L47;
        return r0;
    L47:
        r2 = r38;
        goto L48
    L39:
        if (r39.length() == 0) goto L42;
        r40 = false;
        goto L43
    L36:
        r39 = null;
        goto L37
    L31:
        r38 = null;
        goto L33
    L28:
        r37 = null;
        goto L29
    L25:
        r36 = null;
        goto L26
    L21:
        r34 = null;
        goto L22
    L15:
        r32 = null;
        goto L17
    L11:
        return Unit.INSTANCE;
    }
}
