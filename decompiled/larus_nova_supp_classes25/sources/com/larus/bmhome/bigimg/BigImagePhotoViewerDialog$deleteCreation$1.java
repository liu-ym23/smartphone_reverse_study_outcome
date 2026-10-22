package com.larus.bmhome.bigimg;

import android.content.Context;
import android.content.res.Resources;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.e2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$deleteCreation$1", f = "BigImagePhotoViewerDialog.kt", i = {1}, l = {480, 481, 496}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
final class BigImagePhotoViewerDialog$deleteCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ BigImagePhotoViewerDialog this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$deleteCreation$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$deleteCreation$1$1", f = "BigImagePhotoViewerDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            r3.p(r3.H0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BigImagePhotoViewerDialog$deleteCreation$1(BigImagePhotoViewerDialog r1, Continuation<? super BigImagePhotoViewerDialog$deleteCreation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BigImagePhotoViewerDialog$deleteCreation$1(this.this$0, r3);
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
        String r6 = "";
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r23);
    L106:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Boolean r3 = (Boolean) this.L$0;
        ResultKt.throwOnFailure(r23);
        Object r4 = r23;
    L32:
        Message r5 = (Message) r4;
        String r7 = "image_edit";
        if (Intrinsics.areEqual(r3, Boxing.boxBoolean(true)) == true) goto L63;
        BigImagePhotoViewerDialog r13 = this.this$0;
        Map<String, Pair<String, Integer>> r8 = r13.Z;
        if (r8 == null) goto L42;
        Pair<String, Integer> r9 = r8.get(String.valueOf(((PhotoViewerDialog) r13).f));
        if (r9 == null) goto L42;
        String r10 = (String) r9.getFirst();
        if (r10 == null) goto L42;
        String r17 = r10;
    L43:
        if (r5 == null) goto L47;
        Map r11 = r5.getExt();
        if (r11 == null) goto L47;
        String r12 = (String) r11.get("creativity_scene");
    L49:
        if (Intrinsics.areEqual(r12, "avatar_image") == false) goto L51;
        String r18 = "replica";
    L60:
        e2.a.b(new tx9.u("chat", "creation_detail", "0", r17, r18, null, null, 193), null, 3);
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass1 r15 = new AnonymousClass1(this.this$0, null);
        this.L$0 = null;
        this.label = 3;
        if (BuildersKt.withContext(r14, r15, this) != r1) goto L106;
        return r1;
    L51:
        if (r5 == null) goto L55;
        Map r16 = r5.getExt();
        if (r16 == null) goto L55;
        String r19 = (String) r16.get("creativity_scene");
    L57:
        if (Intrinsics.areEqual(r19, "ai_beautify_image") == false) goto L59;
        r18 = "image_edit";
        goto L60
    L59:
        r18 = "pic";
    L55:
        r19 = null;
    L47:
        r12 = null;
    L42:
        r17 = "";
        goto L43
    L63:
        BigImagePhotoViewerDialog r110 = this.this$0;
        Map<String, Pair<String, Integer>> r111 = r110.Z;
        if (r111 == null) goto L69;
        Pair<String, Integer> r112 = r111.get(String.valueOf(((PhotoViewerDialog) r110).f));
        if (r112 == null) goto L69;
        String r113 = (String) r112.getFirst();
        if (r113 == null) goto L69;
    L70:
        if (r5 == null) goto L74;
        Map r114 = r5.getExt();
        if (r114 == null) goto L74;
        String r115 = (String) r114.get("creativity_scene");
    L76:
        if (Intrinsics.areEqual(r115, "avatar_image") == false) goto L78;
        r7 = "replica";
    L87:
        e2.a.b(new tx9.u("chat", "creation_detail", "1", r113, r7, null, null, 193), null, 3);
        com.larus.platform.service.e0 r20 = com.larus.platform.service.e0.a;
        BigImagePhotoViewerDialog r21 = this.this$0;
        Map<String, Pair<String, Integer>> r22 = r21.Z;
        if (r22 == null) goto L93;
        Pair<String, Integer> r24 = r22.get(String.valueOf(((PhotoViewerDialog) r21).f));
        if (r24 == null) goto L93;
        String r25 = (String) r24.getFirst();
        if (r25 == null) goto L93;
    L94:
        r20.X0(r25);
        t19.s r26 = t19.s.a;
        Context r27 = this.this$0.q;
        if (r27 == null) goto L102;
        Resources r28 = r27.getResources();
        if (r28 == null) goto L102;
        String r29 = r28.getString(2131900648);
        if (r29 == null) goto L102;
        r6 = r29;
    L102:
        r26.getClass();
        t19.s.p(r27, r6);
        BigImagePhotoViewerDialog r30 = this.this$0;
        Map<String, Pair<String, Integer>> r31 = r30.Z;
        if (r31 == null) goto L106;
        Pair<String, Integer> r32 = r31.remove(String.valueOf(((PhotoViewerDialog) r30).f));
    L93:
        r25 = "";
        goto L94
    L78:
        if (r5 == null) goto L82;
        Map r33 = r5.getExt();
        if (r33 == null) goto L82;
        String r34 = (String) r33.get("creativity_scene");
    L84:
        if (Intrinsics.areEqual(r34, "ai_beautify_image") == true) goto L87;
        r7 = "pic";
    L82:
        r34 = null;
    L74:
        r115 = null;
    L69:
        r113 = "";
        goto L70
    L11:
        ResultKt.throwOnFailure(r23);
        Object r35 = r23;
    L22:
        Pair r36 = (Pair) r35;
        if (r36 == null) goto L25;
        r3 = (Boolean) r36.getFirst();
    L26:
        IChatRepoService r37 = RepoDispatcherDelegate.b.e();
        String r38 = this.this$0.t;
        if (r38 != null) goto L29;
        r38 = "";
    L29:
        this.L$0 = r3;
        this.label = 2;
        r4 = r37.E1(r38, this);
        if (r4 != r1) goto L32;
        return r1;
    L25:
        r3 = null;
        goto L26
    L12:
        ResultKt.throwOnFailure(r23);
        com.larus.platform.service.e0 r39 = com.larus.platform.service.e0.a;
        BigImagePhotoViewerDialog r40 = this.this$0;
        Map<String, Pair<String, Integer>> r41 = r40.Z;
        if (r41 == null) goto L18;
        Pair<String, Integer> r42 = r41.get(String.valueOf(((PhotoViewerDialog) r40).f));
        if (r42 == null) goto L18;
        String r43 = (String) r42.getFirst();
        if (r43 == null) goto L18;
    L19:
        this.label = 1;
        r35 = r39.g(r43, this);
        if (r35 != r1) goto L22;
        return r1;
    L18:
        r43 = "";
        goto L19
    }
}
