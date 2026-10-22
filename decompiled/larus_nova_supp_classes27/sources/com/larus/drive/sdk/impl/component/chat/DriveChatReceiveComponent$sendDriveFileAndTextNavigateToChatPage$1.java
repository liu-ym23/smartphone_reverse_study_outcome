package com.larus.drive.sdk.impl.component.chat;

import android.content.Context;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.service.DriveLocalConversationHelper;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$sendDriveFileAndTextNavigateToChatPage$1", f = "DriveChatReceiveComponent.kt", i = {1}, l = {313, 318, 334}, m = "invokeSuspend", n = {"conversationId"}, s = {"L$0"})
public final class DriveChatReceiveComponent$sendDriveFileAndTextNavigateToChatPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $chatContext;
    final /* synthetic */ DriveFileItem $driveFile;
    final /* synthetic */ boolean $isSpeak;
    final /* synthetic */ String $sendText;
    Object L$0;
    int label;
    final /* synthetic */ DriveChatReceiveComponent this$0;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$sendDriveFileAndTextNavigateToChatPage$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$sendDriveFileAndTextNavigateToChatPage$1$1", f = "DriveChatReceiveComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ Context $chatContext;
        final /* synthetic */ String $conversationId;
        final /* synthetic */ String $sendDriveFileInfo;
        int label;
        final /* synthetic */ DriveChatReceiveComponent this$0;

        public AnonymousClass1(DriveChatReceiveComponent r1, Context r2, String r3, String r4, String r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$chatContext = r2;
            this.$conversationId = r3;
            this.$botId = r4;
            this.$sendDriveFileInfo = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$chatContext, this.$conversationId, this.$botId, this.$sendDriveFileInfo, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            DriveChatReceiveComponent.L2(this.this$0, this.$chatContext, this.$conversationId, this.$botId, this.$sendDriveFileInfo);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DriveChatReceiveComponent$sendDriveFileAndTextNavigateToChatPage$1(Context r1, DriveChatReceiveComponent r2, String r3, DriveFileItem r4, boolean r5, Continuation<? super DriveChatReceiveComponent$sendDriveFileAndTextNavigateToChatPage$1> r6) {
        this.$chatContext = r1;
        this.this$0 = r2;
        this.$sendText = r3;
        this.$driveFile = r4;
        this.$isSpeak = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DriveChatReceiveComponent$sendDriveFileAndTextNavigateToChatPage$1(this.$chatContext, this.this$0, this.$sendText, this.$driveFile, this.$isSpeak, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r5 = 2;
        boolean r6 = true;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r17);
    L72:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r17);
        String r10 = r3;
        Object r4 = r17;
    L23:
        String r7 = (String) r4;
        if (r7 != null) goto L26;
    L29:
        boolean r8 = true;
    L30:
        if (r8 == false) goto L33;
        r4 = null;
    L33:
        String r9 = (String) r4;
        if (r9 != null) goto L41;
        DriveChatReceiveComponent r11 = this.this$0;
        int r12 = DriveChatReceiveComponent.j;
        r11.getClass();
        e0 r13 = (e0) AuthModelDelegate.b.e().getValue();
        if (r13 == null) goto L40;
        LaunchInfo r14 = r13.a;
        if (r14 == null) goto L40;
        r9 = r14.W();
    L40:
        r9 = null;
    L41:
        String r15 = r9;
        if (r10 != null) goto L44;
    L47:
        boolean r16 = true;
    L48:
        if (r16 == true) goto L73;
        if (r15 != null) goto L51;
    L54:
        boolean r18 = true;
    L55:
        if (r18 == true) goto L73;
        DriveChatReceiveComponent r20 = this.this$0;
        Object r21 = this.$sendText;
        DriveFileItem r22 = this.$driveFile;
        boolean r110 = this.$isSpeak;
        int r111 = DriveChatReceiveComponent.j;
        r20.getClass();
        JSONArray r23 = new JSONArray();
        JSONObject r112 = new JSONObject();
        r112.put("file_name", r22.a);
        r112.put("file_uri", r22.b);
        JSONObject r113 = new JSONObject();
        r113.put("url", r22.e);
        Unit r114 = Unit.INSTANCE;
        r112.put("image_ori", r113);
        JSONObject r115 = new JSONObject();
        r115.put("url", r22.e);
        r112.put("image_thumb", r115);
        r112.put("file_size", r22.e());
        int r24 = DriveChatReceiveComponent.b.a[r22.j.ordinal()];
        if (r24 == 1) goto L63;
        if (r24 == 2) goto L64;
        if (r24 == 3) goto L62;
        r5 = 0;
        goto L64
    L62:
        r5 = 3;
    L64:
        r112.put("file_type", r5);
        r23.put(r112);
        if (r110 == false) goto L67;
        Object r25 = "speak";
    L68:
        JSONObject r26 = new JSONObject();
        JSONObject r27 = new JSONObject();
        r27.put("collection_id", r22.b);
        r27.put("collection_name", r22.a);
        int r116 = com.larus.drive.sdk.impl.utils.n.a;
        r27.put("content_type", com.larus.drive.sdk.impl.utils.n.e(r22.j));
        r27.put("content_sec_type", com.larus.drive.sdk.impl.utils.n.d(r22));
        r26.put("text", r21);
        r26.put("txt_scene", r25);
        r26.put("from_scene", r25);
        r26.put("file_list", r23);
        r26.put("drive_file_send_info", r27);
        String r117 = r26.toString();
        MainCoroutineDispatcher r28 = Dispatchers.getMain();
        AnonymousClass1 r30 = new AnonymousClass1(this.this$0, this.$chatContext, r10, r15, r117, null);
        this.L$0 = null;
        this.label = 3;
        if (BuildersKt.withContext(r28, r30, this) != r1) goto L72;
        return r1;
    L67:
        r25 = "keyboard";
        goto L68
    L63:
        r5 = 1;
        goto L64
    L51:
        if (StringsKt.isBlank(r15) == true) goto L54;
        r18 = false;
    L73:
        FLogger r31 = FLogger.a;
        StringBuilder r32 = new StringBuilder("[sendDriveFileAndTextNavigateToChatPage] create local conversation failed, conversationIdEmpty=");
        if (r10 != null) goto L76;
    L79:
        boolean r33 = true;
    L80:
        r32.append(r33);
        r32.append(", botIdEmpty=");
        if (r15 != null) goto L83;
    L86:
        r32.append(r6);
        r31.i("DriveChatReceiveComponent", r32.toString());
        return Unit.INSTANCE;
    L83:
        if (StringsKt.isBlank(r15) == true) goto L86;
        r6 = false;
        goto L86
    L76:
        if (StringsKt.isBlank(r10) == true) goto L79;
        r33 = false;
        goto L80
    L44:
        if (StringsKt.isBlank(r10) == true) goto L47;
        r16 = false;
        goto L48
    L26:
        if (StringsKt.isBlank(r7) == true) goto L29;
        r8 = false;
        goto L30
    L11:
        ResultKt.throwOnFailure(r17);
        Object r34 = r17;
    L15:
        wc9.e r35 = (wc9.e) r34;
        if (r35 == null) goto L18;
        String r36 = r35.a;
    L19:
        LocalSubConvHelper r37 = LocalSubConvHelper.a;
        this.L$0 = r36;
        this.label = 2;
        r4 = r37.f(r35, this);
        if (r4 != r1) goto L22;
        return r1;
    L22:
        r10 = r36;
        goto L23
    L18:
        r36 = null;
        goto L19
    L12:
        ResultKt.throwOnFailure(r17);
        DriveLocalConversationHelper r38 = DriveLocalConversationHelper.a;
        Context r40 = this.$chatContext;
        Integer r41 = Boxing.boxInt(1);
        this.label = 1;
        r34 = DriveLocalConversationHelper.b(r40, r41, this);
        if (r34 != r1) goto L15;
        return r1;
    }
}
