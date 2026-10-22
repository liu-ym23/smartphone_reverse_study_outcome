package com.larus.bmhome.bigimg;

import android.content.Context;
import android.content.res.Resources;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.im.bean.message.AICreationTaskDurationInfo;
import com.larus.im.bean.message.Message;
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
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.e2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$setCreationPrivacy$1", f = "BigImagePhotoViewerDialog.kt", i = {1}, l = {432, 433, 450}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
public final class BigImagePhotoViewerDialog$setCreationPrivacy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $buttonStatus;
    final /* synthetic */ int $previousStatus;
    final /* synthetic */ boolean $private;
    final /* synthetic */ int $privateStatus;
    Object L$0;
    int label;
    final /* synthetic */ BigImagePhotoViewerDialog this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$setCreationPrivacy$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$setCreationPrivacy$1$1", f = "BigImagePhotoViewerDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $previousStatus;
        int label;
        final /* synthetic */ BigImagePhotoViewerDialog this$0;

        public AnonymousClass1(BigImagePhotoViewerDialog r1, int r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$previousStatus = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$previousStatus, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            BigImagePhotoViewerDialog r4 = this.this$0;
            int r0 = this.$previousStatus;
            int r1 = BigImagePhotoViewerDialog.V0;
            r4.p(r0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BigImagePhotoViewerDialog$setCreationPrivacy$1(BigImagePhotoViewerDialog r1, int r2, boolean r3, int r4, int r5, Continuation<? super BigImagePhotoViewerDialog$setCreationPrivacy$1> r6) {
        this.this$0 = r1;
        this.$privateStatus = r2;
        this.$private = r3;
        this.$buttonStatus = r4;
        this.$previousStatus = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new BigImagePhotoViewerDialog$setCreationPrivacy$1(this.this$0, this.$privateStatus, this.$private, this.$buttonStatus, this.$previousStatus, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r31) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r4 = "";
        String r8 = null;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r31);
    L108:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Boolean r3 = (Boolean) this.L$0;
        ResultKt.throwOnFailure(r31);
        Object r9 = r31;
    L34:
        Message r10 = (Message) r9;
    L36:
        BigImagePhotoViewerDialog r11 = this.this$0;
        Map<String, Pair<String, Integer>> r13 = r11.Z;
        if (r13 == null) goto L41;
        Pair<String, Integer> r12 = r13.get(String.valueOf(((PhotoViewerDialog) r11).f));
        if (r12 == null) goto L41;
        String r14 = (String) r12.getFirst();
    L42:
        if (r10 == null) goto L48;
        List r15 = ap8.a.a(r10);
        if (r15 == null) goto L48;
        AICreationTaskDurationInfo r16 = (AICreationTaskDurationInfo) CollectionsKt.firstOrNull(r15);
        if (r16 == null) goto L48;
        String r17 = r16.taskId;
    L49:
        String r18 = this.this$0.t;
        if (r10 == null) goto L54;
        Map r7 = r10.getExt();
        if (r7 == null) goto L54;
        String r19 = (String) r7.get("creativity_scene");
    L56:
        if (Intrinsics.areEqual(r19, "avatar_image") == false) goto L59;
        String r5 = "replica";
    L58:
        String r110 = r5;
        boolean r6 = this.$private;
        if (r6 == false) goto L71;
        String r111 = "1";
    L72:
        if (r6 == false) goto L74;
        String r112 = "0";
    L75:
        e2.a.b(new tx9.o0("creation_detail", null, r14, r17, r18, r110, r111, r112, null, null, null, null, null, null, null, null, null, null, 523781), null, 3);
        if (Intrinsics.areEqual(r3, Boxing.boxBoolean(true)) == true) goto L81;
        MainCoroutineDispatcher r20 = Dispatchers.getMain();
        AnonymousClass1 r21 = new AnonymousClass1(this.this$0, this.$previousStatus, null);
        this.L$0 = null;
        this.label = 3;
        if (BuildersKt.withContext(r20, r21, this) != r1) goto L108;
        return r1;
    L81:
        if (this.$privateStatus != 2) goto L87;
        Context r22 = this.this$0.q;
        if (r22 == null) goto L93;
        Resources r23 = r22.getResources();
        if (r23 == null) goto L93;
        int r24 = 2131899198;
    L92:
        r8 = r23.getString(r24);
    L93:
        t19.s r25 = t19.s.a;
        Context r26 = this.this$0.q;
        if (r8 != null) goto L96;
        r8 = "";
    L96:
        r25.getClass();
        t19.s.p(r26, r8);
        BigImagePhotoViewerDialog r27 = this.this$0;
        r27.H0 = this.$buttonStatus;
        Map<String, Pair<String, Integer>> r28 = r27.Z;
        if (r28 == null) goto L108;
        String r29 = String.valueOf(((PhotoViewerDialog) r27).f);
        BigImagePhotoViewerDialog r30 = this.this$0;
        Map<String, Pair<String, Integer>> r32 = r30.Z;
        if (r32 == null) goto L106;
        Pair<String, Integer> r33 = r32.get(String.valueOf(((PhotoViewerDialog) r30).f));
        if (r33 == null) goto L106;
        String r34 = (String) r33.getFirst();
        if (r34 == null) goto L106;
        r4 = r34;
    L106:
        Pair<String, Integer> r35 = r28.put(r29, TuplesKt.to(r4, Boxing.boxInt(this.$privateStatus)));
        goto L108
    L87:
        Context r36 = this.this$0.q;
        if (r36 == null) goto L93;
        r23 = r36.getResources();
        if (r23 == null) goto L93;
        r24 = 2131899194;
        goto L92
    L74:
        r112 = "1";
        goto L75
    L71:
        r111 = "0";
        goto L72
    L59:
        if (r10 == null) goto L63;
        Map r37 = r10.getExt();
        if (r37 == null) goto L63;
        String r38 = (String) r37.get("creativity_scene");
    L65:
        if (Intrinsics.areEqual(r38, "ai_beautify_image") == false) goto L67;
        r5 = "image_edit";
        goto L58
    L67:
        r5 = "pic";
    L63:
        r38 = null;
    L54:
        r19 = null;
    L48:
        r17 = null;
    L41:
        r14 = null;
        goto L42
    L11:
        ResultKt.throwOnFailure(r31);
        Object r39 = r31;
    L22:
        Pair r40 = (Pair) r39;
        if (r40 == null) goto L25;
        r3 = (Boolean) r40.getFirst();
    L26:
        IChatRepoService r41 = RepoDispatcherDelegate.b.e();
        if (r41 == null) goto L35;
        String r113 = this.this$0.t;
        if (r113 != null) goto L31;
        r113 = "0";
    L31:
        this.L$0 = r3;
        this.label = 2;
        r9 = r41.E1(r113, this);
        if (r9 != r1) goto L34;
        return r1;
    L35:
        r10 = null;
        goto L36
    L25:
        r3 = null;
        goto L26
    L12:
        ResultKt.throwOnFailure(r31);
        com.larus.platform.service.e0 r42 = com.larus.platform.service.e0.a;
        BigImagePhotoViewerDialog r43 = this.this$0;
        Map<String, Pair<String, Integer>> r114 = r43.Z;
        if (r114 == null) goto L18;
        Pair<String, Integer> r44 = r114.get(String.valueOf(((PhotoViewerDialog) r43).f));
        if (r44 == null) goto L18;
        String r45 = (String) r44.getFirst();
        if (r45 == null) goto L18;
    L19:
        int r115 = this.$privateStatus;
        this.label = 1;
        r39 = r42.h(r45, r115, this);
        if (r39 != r1) goto L22;
        return r1;
    L18:
        r45 = "";
        goto L19
    }
}
