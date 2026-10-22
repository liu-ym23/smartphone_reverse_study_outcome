package com.larus.bmhome.chat.model.repo;

import android.app.Application;
import android.net.Uri;
import ch8.a;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.dora.DoraEVisionExt;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.LocalImageData;
import com.larus.im.bean.message.LocalImageMeta;
import com.larus.im.bean.message.LocalVideoData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.FileSource;
import com.larus.im.bean.message.block.LocalFileBlock;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatRepo$reportDeleteMessage$3$onSuccess$1", f = "ChatRepo.kt", i = {}, l = {489, 490}, m = "invokeSuspend", n = {}, s = {})
final class ChatRepo$reportDeleteMessage$3$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ List<Message> $messages;
    final /* synthetic */ List<Message> $result;
    Object L$0;
    int label;
    final /* synthetic */ ChatRepo this$0;

    public ChatRepo$reportDeleteMessage$3$onSuccess$1(List<Message> r1, ChatRepo r2, String r3, List<Message> r4, Continuation<? super ChatRepo$reportDeleteMessage$3$onSuccess$1> r5) {
        this.$result = r1;
        this.this$0 = r2;
        this.$conversationId = r3;
        this.$messages = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatRepo$reportDeleteMessage$3$onSuccess$1(this.$result, this.this$0, this.$conversationId, this.$messages, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L279:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r14);
    L269:
        wc9.e r15 = (wc9.e) r14;
        if (r15 == null) goto L272;
        String r16 = r15.B;
    L274:
        if (Intrinsics.areEqual(r2, r16) == false) goto L279;
        RepoDispatcher.a.getClass();
        ConversationRepo r17 = RepoDispatcher.f;
        String r3 = this.$conversationId;
        this.L$0 = null;
        this.label = 2;
        if (r17.n(r3, 3, "dora_e_pic", this) != r0) goto L279;
        return r0;
    L272:
        r16 = null;
        goto L274
    L10:
        ResultKt.throwOnFailure(r14);
        List<Message> r18 = this.$result;
        List<Message> r4 = this.$messages;
        if (r18.isEmpty() == false) goto L13;
        r18 = r4;
    L13:
        ChatRepo r5 = this.this$0;
        int r6 = ChatRepo.f;
        r5.getClass();
        List<Message> r19 = r18;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r19.iterator();
    L15:
        if (r8.hasNext() == false) goto L23;
        Message r9 = (Message) r8.next();
        List r10 = r9.getContentBlock();
        if (r10 != null) goto L19;
        r10 = CollectionsKt.emptyList();
    L19:
        List r11 = r10;
        if (r11.isEmpty() == false) goto L22;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        r11 = vd9.r.a(r9);
    L22:
        CollectionsKt.addAll(r7, r11);
        goto L15
    L23:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r7.iterator();
    L24:
        boolean r20 = false;
        if (r13.hasNext() == false) goto L31;
        Object r21 = r13.next();
        if (((Block) r21).getBlockType() != BlockType.BLOCK_TYPE_LOCAL_FILE.getValue()) goto L29;
        r20 = true;
    L29:
        if (r20 == false) goto L24;
        r12.add(r21);
        goto L24
    L31:
        ArrayList r22 = new ArrayList();
        Iterator r23 = r12.iterator();
    L33:
        if (r23.hasNext() == false) goto L61;
        BlockContent r24 = ((Block) r23.next()).getContent();
        if (r24 == null) goto L58;
        LocalFileBlock r25 = r24.getLocalFileBlock();
        if (r25 == null) goto L58;
        if (r25.fileSource != FileSource.FILE_SOURCE_O) goto L41;
        boolean r26 = true;
    L42:
        if (r26 == true) goto L45;
        r25 = null;
    L45:
        if (r25 == null) goto L58;
        String r27 = r25.path;
        if (r27 != null) goto L49;
    L53:
        r27 = r25.uri;
        if (r27 == null) goto L58;
        if ((!StringsKt.isBlank(r27)) == false) goto L58;
    L59:
        if (r27 == null) goto L33;
        r22.add(r27);
        goto L33
    L49:
        if ((!StringsKt.isBlank(r27)) == true) goto L52;
        r27 = null;
    L52:
        if (r27 != null) goto L59;
    L41:
        r26 = false;
    L58:
        r27 = null;
        goto L59
    L61:
        Iterator r28 = CollectionsKt.distinct(r22).iterator();
    L63:
        if (r28.hasNext() == false) goto L89;
        String r29 = (String) r28.next();
        a.a.getClass();
        ch8.b r30 = a.a(r29);
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L78
        if ((r30 instanceof ch8.b.a) == false) goto L71;
        if (ChatRepo.b(AppHost.a.getApplication().getContentResolver(), ((ch8.b.a) r30).a) <= 0) goto L74;
        boolean r31 = true;
    L75:
        Object r32 = Result.constructor-impl(Boolean.valueOf(r31));     // Catch: Throwable -> L78
    L81:
        if (Result.isSuccess-impl(r32) == true) goto L83;
    L86:
        Throwable r33 = Result.exceptionOrNull-impl(r32);
        if (r33 == null) goto L63;
        FLogger.a.e("ChatRepo", "delete local file block failed, path=".concat(r29), r33);
        goto L63
    L83:
        if (((Boolean) r32).booleanValue() == false) goto L85;
        FLogger.a.i("ChatRepo", "delete local file block success, path=".concat(r29));
        goto L86
    L85:
        FLogger.a.i("ChatRepo", "skip or fail to delete local file block, path=".concat(r29));
    L74:
        r31 = false;
        goto L75
    L71:
        if ((r30 instanceof ch8.b.C0003b) == false) goto L73;
        r31 = ((ch8.b.C0003b) r30).a.delete();     // Catch: Throwable -> L78
        goto L75
    L73:
        if (r30 == null) goto L74;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L81
    L89:
        this.this$0.getClass();
        ArrayList r34 = new ArrayList();
        Iterator<T> r112 = r19.iterator();
    L91:
        if (r112.hasNext() == false) goto L93;
        CollectionsKt.addAll(r34, com.larus.im.bean.message.a.l((Message) r112.next()));
        goto L91
    L93:
        ArrayList r113 = new ArrayList();
        Iterator r35 = r34.iterator();
    L95:
        if (r35.hasNext() == false) goto L170;
        CreationItem r36 = (CreationItem) r35.next();
        Integer r37 = r36.type;
        if (r37 != null) goto L100;
    L128:
        if (r37 != null) goto L131;
    L162:
        List r38 = CollectionsKt.emptyList();
    L163:
        List r39 = CollectionsKt.distinct(r38);
        ArrayList r40 = new ArrayList();
        Iterator r41 = r39.iterator();
    L165:
        if (r41.hasNext() == false) goto L169;
        Object r114 = r41.next();
        if ((!StringsKt.isBlank((String) r114)) == false) goto L165;
        r40.add(r114);
        goto L165
    L169:
        CollectionsKt.addAll(r113, r40);
        goto L95
    L131:
        if (r37.intValue() != 4) goto L162;
        String[] r42 = new String[3];
        LocalVideoData r43 = r36.localVideo;
        if (r43 == null) goto L135;
        String r115 = r43.videoPath;
    L136:
        r42[0] = r115;
        if (r43 == null) goto L143;
        Cover r116 = r43.cover;
        if (r116 == null) goto L143;
        LocalImageMeta r117 = r116.localImagePreview;
        if (r117 == null) goto L143;
        String r118 = r117.path;
    L144:
        r42[1] = r118;
        if (r43 == null) goto L160;
        String r119 = r43.uri;
        if (r119 == null) goto L160;
        String r44 = r43.videoPath;
        if (r44 != null) goto L151;
    L154:
        boolean r45 = true;
    L155:
        if (r45 != true) goto L157;
        boolean r46 = true;
    L158:
        if (r46 == false) goto L160;
    L161:
        r42[2] = r119;
        r38 = CollectionsKt.listOfNotNull(r42);
        goto L163
    L157:
        r46 = false;
        goto L158
    L151:
        if (StringsKt.isBlank(r44) == true) goto L154;
        r45 = false;
    L160:
        r119 = null;
    L143:
        r118 = null;
        goto L144
    L135:
        r115 = null;
        goto L136
    L100:
        if (r37.intValue() != 3) goto L128;
        String[] r47 = new String[2];
        LocalImageData r48 = r36.localImage;
        if (r48 == null) goto L106;
        LocalImageMeta r120 = r48.localImageOriRaw;
        if (r120 == null) goto L106;
        String r121 = r120.path;
    L107:
        r47[0] = r121;
        if (r48 == null) goto L126;
        String r122 = r48.uri;
        if (r122 == null) goto L126;
        LocalImageMeta r49 = r48.localImageOriRaw;
        if (r49 == null) goto L114;
        String r50 = r49.path;
    L115:
        if (r50 != null) goto L117;
    L120:
        boolean r51 = true;
    L121:
        if (r51 != true) goto L123;
        boolean r52 = true;
    L124:
        if (r52 == false) goto L126;
    L127:
        r47[1] = r122;
        r38 = CollectionsKt.listOfNotNull(r47);
        goto L163
    L123:
        r52 = false;
        goto L124
    L117:
        if (StringsKt.isBlank(r50) == true) goto L120;
        r51 = false;
        goto L121
    L114:
        r50 = null;
    L126:
        r122 = null;
    L106:
        r121 = null;
        goto L107
    L170:
        List r123 = CollectionsKt.distinct(r113);
        if (r123.isEmpty() == true) goto L238;
        uh8.c r53 = uh8.c.a;
        Application r54 = AppHost.a.getApplication();
        r53.getClass();
        Intrinsics.checkNotNullParameter(r54, "context");
        Intrinsics.checkNotNullParameter(r123, "targets");
        if (r123.isEmpty() == true) goto L234;
        Iterator r55 = r123.iterator();
        boolean r56 = false;
        boolean r124 = true;
    L178:
        if (r55.hasNext() == false) goto L231;
        String r125 = (String) r55.next();
        uh8.c.a.getClass();
        if (r125 == null) goto L189;
        String r126 = StringsKt.trim(r125).toString();
        if (r126 == null) goto L189;
        if (r126.length() <= 0) goto L186;
        boolean r127 = true;
    L187:
        if (r127 == false) goto L189;
    L190:
        if (r126 == null) goto L178;
        if (StringsKt.startsWith$default(r126, "content://", false, 2, null) == false) goto L208;
        Uri r57 = UriProtector.parse(r126);
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L201
        if (uh8.c.a(r54.getContentResolver(), r57) < 0) goto L198;
        boolean r58 = true;
    L199:
        Object r59 = Result.constructor-impl(Boolean.valueOf(r58));     // Catch: Throwable -> L201
    L203:
        Boolean r129 = Boolean.FALSE;
        if (Result.isFailure-impl(r59) == false) goto L206;
        r59 = r129;
    L206:
        boolean r60 = ((Boolean) r59).booleanValue();
    L228:
        if (r60 == true) goto L230;
        r124 = false;
    L230:
        r56 = true;
        goto L178
    L198:
        r58 = false;
    L201:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r59 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L203
    L208:
        if (StringsKt.startsWith$default(r126, "file://", false, 2, null) == false) goto L210;
        r126 = UriProtector.parse(r126).getPath();
    L210:
        if (r126 != null) goto L212;
    L227:
        r60 = false;
        goto L228
    L212:
        if ((!StringsKt.isBlank(r126)) == true) goto L215;
        r126 = null;
    L215:
        if (r126 == null) goto L227;
        PolarisFileWrapper r61 = new PolarisFileWrapper(r126);
        if (r61.exists() == true) goto L284;
        r60 = true;
        goto L228
    L284:
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L221
        Object r62 = Result.constructor-impl(Boolean.valueOf(r61.delete()));     // Catch: Throwable -> L221
    L223:
        Boolean r132 = Boolean.FALSE;
        if (Result.isFailure-impl(r62) == false) goto L226;
        r62 = r132;
    L226:
        r60 = ((Boolean) r62).booleanValue();
    L221:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r62 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L223
    L186:
        r127 = false;
    L189:
        r126 = null;
        goto L190
    L231:
        if (r56 == false) goto L234;
        if (r124 == false) goto L234;
        boolean r63 = true;
    L235:
        if (r63 == false) goto L237;
        FLogger.a.i("ChatRepo", "delete local creation media success, targets=" + r123);
        goto L238
    L237:
        FLogger.a.w("ChatRepo", "delete local creation media partial failed, targets=" + r123);
    L234:
        r63 = false;
    L238:
        List<Message> r134 = this.$result;
        ListIterator<Message> r135 = r134.listIterator(r134.size());
    L240:
        if (r135.hasPrevious() == false) goto L263;
        Message r64 = r135.previous();
        Message r65 = r64;
        if (r65 != null) goto L245;
    L260:
        boolean r66 = false;
    L261:
        if (r66 == false) goto L240;
    L264:
        Message r67 = r64;
        if (r67 == null) goto L279;
        r2 = r67.getSectionId();
        RepoDispatcher.a.getClass();
        ConversationRepo r68 = RepoDispatcher.f;
        String r69 = this.$conversationId;
        this.L$0 = r2;
        this.label = 1;
        r14 = IConversationRepoService$a.c(r68, r69, false, null, this, 6);
        if (r14 != r0) goto L269;
        return r0;
    L245:
        if (hp8.a.d(r65) == false) goto L260;
        Map r70 = r65.getExt();
        if (r70 == null) goto L260;
        String r71 = (String) r70.get("dora_vision_ext");
        if (r71 == null) goto L260;
        Integer r72 = ((DoraEVisionExt) new Gson().fromJson(r71, DoraEVisionExt.class)).getRealTime();
        if (r72 == null) goto L260;
        if (r72.intValue() != 1) goto L260;
        r66 = true;
        goto L261
    L263:
        r64 = null;
        goto L264
    }
}
