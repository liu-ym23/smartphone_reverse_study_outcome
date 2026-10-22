package com.larus.drive.sdk.impl.component.chat;

import android.content.Context;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.common.apphost.AppHost;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.service.DriveLocalConversationHelper;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2", f = "DriveChatReceiveComponent.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 4, 5, 6}, l = {377, 382, 387, 403, 406, 419, 422, 437}, m = "invokeSuspend", n = {"$this$launch", "terminalReported", "reportFailure", "$this$launch", "terminalReported", "reportFailure", "conversationId", "reportFailure", "terminalReported", "reportFailure", "conversationId", "botId", "reportFailure", "reportFailure", "reportFailure"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$0", "L$0"})
final class DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ List<AttachmentSnapshot> $frozenAttachments;
    final /* synthetic */ boolean $isSpeak;
    final /* synthetic */ Function1<Boolean, Unit> $onResult;
    final /* synthetic */ String $sendText;
    final /* synthetic */ Function0<Boolean> $shouldContinue;
    final /* synthetic */ DriveFileItem $sourceDriveFile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ DriveChatReceiveComponent this$0;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$2", f = "DriveChatReceiveComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ String $conversationId;
        final /* synthetic */ Function1<Boolean, Unit> $onResult;
        final /* synthetic */ String $sendDriveFileInfo;
        final /* synthetic */ Function0<Boolean> $shouldContinue;
        final /* synthetic */ Ref.BooleanRef $terminalReported;
        int label;
        final /* synthetic */ DriveChatReceiveComponent this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function0<Boolean> r1, DriveChatReceiveComponent r2, String r3, String r4, String r5, Ref.BooleanRef r6, Function1<? super Boolean, Unit> r7, Continuation<? super AnonymousClass2> r8) {
            this.$shouldContinue = r1;
            this.this$0 = r2;
            this.$conversationId = r3;
            this.$botId = r4;
            this.$sendDriveFileInfo = r5;
            this.$terminalReported = r6;
            this.$onResult = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass2(this.$shouldContinue, this.this$0, this.$conversationId, this.$botId, this.$sendDriveFileInfo, this.$terminalReported, this.$onResult, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r5);
            if (((Boolean) this.$shouldContinue.invoke()).booleanValue() == false) goto L7;
            DriveChatReceiveComponent r6 = this.this$0;
            int r0 = DriveChatReceiveComponent.j;
            r6.getClass();
            AppHost.Companion r1 = AppHost.a;
            Context r2 = r1.a().getCurrentActivity();
            if (r2 != null) goto L12;
            r2 = r1.getApplication().getApplicationContext();
        L12:
            DriveChatReceiveComponent.L2(r6, r2, this.$conversationId, this.$botId, this.$sendDriveFileInfo);
            this.$terminalReported.element = true;
            this.$onResult.invoke(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2(Function0<Boolean> r1, Context r2, DriveChatReceiveComponent r3, List<AttachmentSnapshot> r4, String r5, DriveFileItem r6, boolean r7, Function1<? super Boolean, Unit> r8, Continuation<? super DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2> r9) {
        this.$shouldContinue = r1;
        this.$applicationContext = r2;
        this.this$0 = r3;
        this.$frozenAttachments = r4;
        this.$sendText = r5;
        this.$sourceDriveFile = r6;
        this.$isSpeak = r7;
        this.$onResult = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2 r10 = new DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2(this.$shouldContinue, this.$applicationContext, this.this$0, this.$frozenAttachments, this.$sendText, this.$sourceDriveFile, this.$isSpeak, this.$onResult, r13);
        r10.L$0 = r12;
        return r10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0096: MOVE (r3 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:16777366), block:B:33:0x0096 */
    public final Object invokeSuspend(Object r24) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r5 = true;
        switch(this.label) {
            case 0: goto L34;
            case 1: goto L29;
            case 2: goto L26;
            case 3: goto L21;
            case 4: goto L16;
            case 5: goto L13;
            case 6: goto L10;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r24);
    L155:
        return Unit.INSTANCE;
    L7:
        Function1 r3 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L24 CancellationException -> L156
        goto L155
    L10:
        Function1 r4 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L24 CancellationException -> L156
    L131:
        return Unit.INSTANCE;
    L13:
        Function1 r6 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L24 CancellationException -> L156
    L119:
        return Unit.INSTANCE;
    L16:
        String r0 = (String) this.L$3;
        String r7 = (String) this.L$2;
        Function1 r8 = (Function1) this.L$1;
        Ref.BooleanRef r9 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L19 CancellationException -> L156
        Object r10 = r24;
        String r11 = r0;
        String r12 = r7;
        Function1 r15 = r8;
        Ref.BooleanRef r13 = r9;
    L165:
        List r14 = (List) r10;     // Catch: Throwable -> L139 CancellationException -> L156
        List r1 = r14;     // Catch: Throwable -> L139 CancellationException -> L156
        if ((r1 instanceof Collection) == true) goto L162;
    L103:
        Iterator r16 = r1.iterator();     // Catch: Throwable -> L139 CancellationException -> L156
    L105:
        if (r16.hasNext() == false) goto L112;
        if (((UplinkFileEntity) r16.next()) != null) goto L109;
        boolean r17 = true;
    L110:
        if (r17 == false) goto L105;
    L113:
        if (r5 == false) goto L121;
        FLogger.a.e("DriveChatReceiveComponent", "[sendPreviewAttachments] materialize failed");     // Catch: Throwable -> L101 CancellationException -> L156
        this.L$0 = r15;     // Catch: Throwable -> L101 CancellationException -> L156
        this.L$1 = null;     // Catch: Throwable -> L101 CancellationException -> L156
        this.L$2 = null;     // Catch: Throwable -> L101 CancellationException -> L156
        this.L$3 = null;     // Catch: Throwable -> L101 CancellationException -> L156
        this.label = 5;     // Catch: Throwable -> L101 CancellationException -> L156
        if (r15.invoke(this) != r2) goto L119;
        return r2;
    L121:
        if (((Boolean) this.$shouldContinue.invoke()).booleanValue() == false) goto L123;
        String r18 = DriveChatReceiveComponent.F2(this.this$0, this.$sendText, CollectionsKt.filterNotNull(r14), this.$sourceDriveFile, this.$isSpeak);     // Catch: Throwable -> L139 CancellationException -> L156
        if (r18 != null) goto L132;
        FLogger.a.e("DriveChatReceiveComponent", "[sendPreviewAttachments] materialized entity is incomplete");     // Catch: Throwable -> L101 CancellationException -> L156
        this.L$0 = r15;     // Catch: Throwable -> L101 CancellationException -> L156
        this.L$1 = null;     // Catch: Throwable -> L101 CancellationException -> L156
        this.L$2 = null;     // Catch: Throwable -> L101 CancellationException -> L156
        this.L$3 = null;     // Catch: Throwable -> L101 CancellationException -> L156
        this.label = 6;     // Catch: Throwable -> L101 CancellationException -> L156
        if (r15.invoke(this) != r2) goto L131;
        return r2;
    L132:
        MainCoroutineDispatcher r20 = Dispatchers.getMain();     // Catch: Throwable -> L139 CancellationException -> L156
        Function1 r21 = r15;
        AnonymousClass2 r22 = new AnonymousClass2(this.$shouldContinue, this.this$0, r12, r11, r18, r13, this.$onResult, null);     // Catch: Throwable -> L137 CancellationException -> L156
        this.L$0 = r21;     // Catch: Throwable -> L137 CancellationException -> L156
        this.L$1 = null;     // Catch: Throwable -> L137 CancellationException -> L156
        this.L$2 = null;     // Catch: Throwable -> L137 CancellationException -> L156
        this.L$3 = null;     // Catch: Throwable -> L137 CancellationException -> L156
        this.label = 7;     // Catch: Throwable -> L137 CancellationException -> L156
        if (BuildersKt.withContext(r20, r22, this) != r2) goto L155;
        return r2;
    L137:
        th = th;
    L141:
        Function1 r23 = r21;
    L148:
        r8 = r23;
    L151:
        FLogger.a.e("DriveChatReceiveComponent", "[sendPreviewAttachments] async send failed", th);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 8;
        if (r8.invoke(this) != r2) goto L155;
        return r2;
    L123:
        return Unit.INSTANCE;
    L109:
        r17 = false;
    L112:
        r5 = false;
        goto L113
    L162:
    L101:
        th = th;
        r23 = r15;
        goto L148
    L99:
        if (r1.isEmpty() == false) goto L103;
    L139:
        th = th;
        r21 = r15;
    L19:
        th = th;
        goto L151
    L21:
        Function1 r25 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L24 CancellationException -> L156
    L147:
        return Unit.INSTANCE;
    L26:
        String r26 = (String) this.L$3;
        Function1 r27 = (Function1) this.L$2;
        Ref.BooleanRef r28 = (Ref.BooleanRef) this.L$1;
        CoroutineScope r30 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L32 CancellationException -> L156
        Function1 r110 = r27;
        Ref.BooleanRef r111 = r28;
        CoroutineScope r112 = r30;
        Object r31 = r24;
    L51:
        String r32 = (String) r31;     // Catch: Throwable -> L149 CancellationException -> L156
        if (r32 != null) goto L54;
    L57:
        boolean r33 = true;
    L58:
        if (r33 == false) goto L61;
        r31 = null;
    L61:
        String r34 = (String) r31;     // Catch: Throwable -> L149 CancellationException -> L156
        if (r34 != null) goto L69;
        DriveChatReceiveComponent r35 = this.this$0;     // Catch: Throwable -> L149 CancellationException -> L156
        int r36 = DriveChatReceiveComponent.j;     // Catch: Throwable -> L149 CancellationException -> L156
        r35.getClass();     // Catch: Throwable -> L149 CancellationException -> L156
        e0 r37 = (e0) AuthModelDelegate.b.e().getValue();     // Catch: Throwable -> L149 CancellationException -> L156
        if (r37 == null) goto L68;
        LaunchInfo r38 = r37.a;     // Catch: Throwable -> L149 CancellationException -> L156
        if (r38 == null) goto L68;
        r34 = r38.W();     // Catch: Throwable -> L149 CancellationException -> L156
    L68:
        r34 = null;
    L69:
        if (r26 != null) goto L71;
    L74:
        boolean r40 = true;
    L75:
        if (r40 == true) goto L142;
        if (r34 != null) goto L78;
    L81:
        boolean r41 = true;
    L82:
        if (r41 == true) goto L142;
        if (((Boolean) this.$shouldContinue.invoke()).booleanValue() == false) goto L87;
        List<AttachmentSnapshot> r42 = this.$frozenAttachments;     // Catch: Throwable -> L149 CancellationException -> L156
        DriveChatReceiveComponent r113 = this.this$0;     // Catch: Throwable -> L149 CancellationException -> L156
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r42, 10));     // Catch: Throwable -> L149 CancellationException -> L156
        Iterator<T> r115 = r42.iterator();     // Catch: Throwable -> L149 CancellationException -> L156
    L90:
        if (r115.hasNext() == false) goto L92;
        ArrayList r43 = r114;
        r43.add(BuildersKt.async$default(r112, null, null, new DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$materialized$1$1((AttachmentSnapshot) r115.next(), r113, r26, r34, null), 3, null));     // Catch: Throwable -> L149 CancellationException -> L156
        r114 = r43;
        r113 = r113;
        goto L90
    L92:
        this.L$0 = r111;     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$1 = r110;     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$2 = r26;     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$3 = r34;     // Catch: Throwable -> L149 CancellationException -> L156
        this.label = 4;     // Catch: Throwable -> L149 CancellationException -> L156
        r10 = AwaitKt.a(r114, this);     // Catch: Throwable -> L149 CancellationException -> L156
        if (r10 != r2) goto L95;
        return r2;
    L95:
        r12 = r26;
        r11 = r34;
        r13 = r111;
        r15 = r110;
        goto L165
    L87:
        return Unit.INSTANCE;
    L78:
        if (StringsKt.isBlank(r34) == true) goto L81;
        r41 = false;
    L142:
        FLogger.a.e("DriveChatReceiveComponent", "[sendPreviewAttachments] create local conversation failed");     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$0 = r110;     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$1 = null;     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$2 = null;     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$3 = null;     // Catch: Throwable -> L149 CancellationException -> L156
        this.label = 3;     // Catch: Throwable -> L149 CancellationException -> L156
        if (r110.invoke(this) != r2) goto L147;
        return r2;
    L71:
        if (StringsKt.isBlank(r26) == true) goto L74;
        r40 = false;
        goto L75
    L54:
        if (StringsKt.isBlank(r32) == true) goto L57;
        r33 = false;
        goto L58
    L29:
        Function1 r44 = (Function1) this.L$2;
        Ref.BooleanRef r45 = (Ref.BooleanRef) this.L$1;
        CoroutineScope r46 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L32 CancellationException -> L156
        r110 = r44;
        CoroutineScope r47 = r46;
        Object r48 = r24;
    L43:
        wc9.e r50 = (wc9.e) r48;     // Catch: Throwable -> L149 CancellationException -> L156
        if (r50 == null) goto L46;
        String r51 = r50.a;     // Catch: Throwable -> L149 CancellationException -> L156
    L47:
        LocalSubConvHelper r116 = LocalSubConvHelper.a;     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$0 = r47;     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$1 = r45;     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$2 = r110;     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$3 = r51;     // Catch: Throwable -> L149 CancellationException -> L156
        this.label = 2;     // Catch: Throwable -> L149 CancellationException -> L156
        r31 = r116.f(r50, this);     // Catch: Throwable -> L149 CancellationException -> L156
        if (r31 != r2) goto L50;
        return r2;
    L50:
        r111 = r45;
        r26 = r51;
        r112 = r47;
        goto L51
    L46:
        r51 = null;
        goto L47
    L34:
        ResultKt.throwOnFailure(r24);
        CoroutineScope r52 = (CoroutineScope) this.L$0;
        Ref.BooleanRef r117 = new Ref.BooleanRef();
        r110 = new DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2$reportFailure$1(r117, this.$shouldContinue, this.$applicationContext, this.$onResult, null);
    L149:
        th = th;
        r8 = r110;
        goto L151
    L36:
        if (((Boolean) this.$shouldContinue.invoke()).booleanValue() == false) goto L38;
        DriveLocalConversationHelper r53 = DriveLocalConversationHelper.a;     // Catch: Throwable -> L149 CancellationException -> L156
        Context r54 = this.$applicationContext;     // Catch: Throwable -> L149 CancellationException -> L156
        Integer r55 = Boxing.boxInt(1);     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$0 = r52;     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$1 = r117;     // Catch: Throwable -> L149 CancellationException -> L156
        this.L$2 = r110;     // Catch: Throwable -> L149 CancellationException -> L156
        this.label = 1;     // Catch: Throwable -> L149 CancellationException -> L156
        r48 = DriveLocalConversationHelper.b(r54, r55, this);     // Catch: Throwable -> L149 CancellationException -> L156
        if (r48 != r2) goto L42;
        return r2;
    L42:
        r47 = r52;
        r45 = r117;
        goto L43
    L38:
        return Unit.INSTANCE;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L24:
        th = th;
    L156:
        e = move-exception;
        throw e;
    L32:
        th = th;
        r23 = r7;
        goto L148
    }
}
