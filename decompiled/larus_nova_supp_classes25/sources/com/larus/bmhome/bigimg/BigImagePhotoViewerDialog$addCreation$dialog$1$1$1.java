package com.larus.bmhome.bigimg;

import android.content.Context;
import android.content.res.Resources;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.im.bean.message.AICreationTaskDurationInfo;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.g2;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.e2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$addCreation$dialog$1$1$1", f = "BigImagePhotoViewerDialog.kt", i = {1, 2, 2}, l = {529, 530, 532}, m = "invokeSuspend", n = {"result", "result", "message"}, s = {"L$0", "L$0", "L$1"})
final class BigImagePhotoViewerDialog$addCreation$dialog$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $buttonStatus;
    final /* synthetic */ Context $fragmentContext;
    final /* synthetic */ int $privateStatus;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BigImagePhotoViewerDialog this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$addCreation$dialog$1$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$addCreation$dialog$1$1$1$1", f = "BigImagePhotoViewerDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BigImagePhotoViewerDialog this$0;

        public AnonymousClass1(BigImagePhotoViewerDialog r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            BigImagePhotoViewerDialog r3 = this.this$0;
            int r0 = BigImagePhotoViewerDialog.V0;
            r3.p(1);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BigImagePhotoViewerDialog$addCreation$dialog$1$1$1(BigImagePhotoViewerDialog r1, int r2, Context r3, int r4, Continuation<? super BigImagePhotoViewerDialog$addCreation$dialog$1$1$1> r5) {
        this.this$0 = r1;
        this.$privateStatus = r2;
        this.$fragmentContext = r3;
        this.$buttonStatus = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BigImagePhotoViewerDialog$addCreation$dialog$1$1$1(this.this$0, this.$privateStatus, this.$fragmentContext, this.$buttonStatus, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r38) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r10 = false;
        String r13 = "";
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        Message r1 = (Message) this.L$1;
        zp9.a r2 = (zp9.a) this.L$0;
        ResultKt.throwOnFailure(r38);
    L35:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BigImagePhotoViewerDialog$reportPicAddCreation$1(this.this$0.t, false, "", null), 3, null);
        zp9.a r36 = r2;
        Message r3 = r1;
        zp9.a r4 = r36;
    L60:
        if (r4 != null) goto L62;
    L64:
        if (r10 == false) goto L70;
        if (r4 == null) goto L69;
        UserCreation r5 = r4.b;
        if (r5 == null) goto L69;
        r13 = r5.a;
    L69:
        String r19 = null;
    L71:
        if (r3 == null) goto L77;
        List r6 = ap8.a.a(r3);
        if (r6 == null) goto L77;
        AICreationTaskDurationInfo r7 = (AICreationTaskDurationInfo) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L77;
        String r20 = r7.taskId;
    L78:
        String r8 = this.this$0.t;
        if (r3 == null) goto L83;
        Map r11 = r3.getExt();
        if (r11 == null) goto L83;
        String r12 = (String) r11.get("creativity_scene");
    L85:
        if (Intrinsics.areEqual(r12, "avatar_image") == false) goto L88;
        String r14 = "replica";
    L87:
        String r22 = r14;
        if (this.$privateStatus != 2) goto L100;
        String r15 = "0";
    L101:
        e2.a.b(new tx9.o0("creation_detail", null, r19, r20, r8, r22, "-1", r15, null, null, null, null, null, null, null, null, null, null, 523781), null, 3);
        return Unit.INSTANCE;
    L100:
        r15 = "1";
        goto L101
    L88:
        if (r3 == null) goto L92;
        Map r16 = r3.getExt();
        if (r16 == null) goto L92;
        String r17 = (String) r16.get("creativity_scene");
    L94:
        if (Intrinsics.areEqual(r17, "ai_beautify_image") == false) goto L96;
        r14 = "image_edit";
        goto L87
    L96:
        r14 = "pic";
    L92:
        r17 = null;
    L83:
        r12 = null;
    L77:
        r20 = null;
    L70:
        r19 = r13;
        goto L71
    L62:
        if (r4.a != true) goto L64;
        r10 = true;
        goto L64
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r4 = (zp9.a) this.L$0;
        ResultKt.throwOnFailure(r38);
        Object r18 = r38;
    L24:
        r3 = (Message) r18;
        if (r4 != null) goto L27;
    L29:
        boolean r21 = false;
    L30:
        if (r21 == true) goto L36;
        MainCoroutineDispatcher r23 = Dispatchers.getMain();
        AnonymousClass1 r24 = new AnonymousClass1(this.this$0, null);
        this.L$0 = r4;
        this.L$1 = r3;
        this.label = 3;
        if (BuildersKt.withContext(r23, r24, this) != r9) goto L34;
        return r9;
    L34:
        r2 = r4;
        r1 = r3;
        goto L35
    L36:
        String r25 = this.this$0.t;
        if (r4 == null) goto L41;
        UserCreation r26 = r4.b;
        if (r26 == null) goto L41;
        String r27 = r26.a;
    L42:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BigImagePhotoViewerDialog$reportPicAddCreation$1(r25, true, r27, null), 3, null);
        t19.s r28 = t19.s.a;
        Context r29 = this.$fragmentContext;
        if (r29 == null) goto L48;
        Resources r30 = r29.getResources();
        if (r30 == null) goto L48;
        String r31 = r30.getString(2131899190);
        if (r31 == null) goto L48;
    L49:
        r28.getClass();
        t19.s.p(r29, r31);
        BigImagePhotoViewerDialog r32 = this.this$0;
        r32.H0 = this.$buttonStatus;
        Map<String, Pair<String, Integer>> r33 = r32.Z;
        if (r33 == null) goto L60;
        String r34 = String.valueOf(((PhotoViewerDialog) r32).f);
        if (r4 == null) goto L57;
        UserCreation r35 = r4.b;
        if (r35 == null) goto L57;
        String r37 = r35.a;
        if (r37 == null) goto L57;
    L58:
        r33.put(r34, TuplesKt.to(r37, Boxing.boxInt(this.$privateStatus)));
    L57:
        r37 = "";
    L48:
        r31 = "";
    L41:
        r27 = null;
        goto L42
    L27:
        if (r4.a != true) goto L29;
        r21 = true;
        goto L30
    L11:
        ResultKt.throwOnFailure(r38);
        Object r39 = r38;
    L18:
        r4 = (zp9.a) r39;
        IChatRepoService r40 = RepoDispatcherDelegate.b.e();
        String r41 = this.this$0.t;
        if (r41 != null) goto L21;
        r41 = "";
    L21:
        this.L$0 = r4;
        this.label = 2;
        r18 = r40.E1(r41, this);
        if (r18 != r9) goto L24;
        return r9;
    L12:
        ResultKt.throwOnFailure(r38);
        com.larus.platform.service.e0 r42 = com.larus.platform.service.e0.a;
        BigImagePhotoViewerDialog r43 = this.this$0;
        String r44 = r43.t;
        if (r44 != null) goto L15;
        r44 = "";
    L15:
        String r45 = String.valueOf(((PhotoViewerDialog) r43).f);
        int r46 = this.$privateStatus;
        this.label = 1;
        r39 = g2.a.a(r44, 2, r45, r46, null, 0, this, DoraCallStateCode.DOUBAO_CMD_12);
        if (r39 != r9) goto L18;
        return r9;
    }
}
