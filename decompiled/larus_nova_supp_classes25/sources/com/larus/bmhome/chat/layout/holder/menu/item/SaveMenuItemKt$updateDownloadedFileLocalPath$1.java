package com.larus.bmhome.chat.layout.holder.menu.item;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SendFile;
import com.larus.im.bean.message.SendFileContent;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.menu.item.SaveMenuItemKt$updateDownloadedFileLocalPath$1", f = "SaveMenuItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SaveMenuItemKt$updateDownloadedFileLocalPath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ef8.b $menuContext;
    final /* synthetic */ String $targetFilePath;
    int label;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ ef8.b a;

        public final boolean mustInMain() {
            return true;
        }

        public a(ef8.b r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r3) {
            Message r4 = (Message) r3;
            Intrinsics.checkNotNullParameter(r4, "result");
            com.larus.bmhome.chat.api.q0 r0 = this.a.c;
            if (r0 == null) goto L9;
            String r1 = r4.getMessageId();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            r0.x7(r1, r4.getContentType());
            return;
        }
    }

    public SaveMenuItemKt$updateDownloadedFileLocalPath$1(ef8.b r1, String r2, Continuation<? super SaveMenuItemKt$updateDownloadedFileLocalPath$1> r3) {
        this.$menuContext = r1;
        this.$targetFilePath = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SaveMenuItemKt$updateDownloadedFileLocalPath$1(this.$menuContext, this.$targetFilePath, r4);
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
        RepoDispatcher.a.getClass();
        ChatRepo r6 = RepoDispatcher.d;
        String r0 = this.$menuContext.a.getMessageId();
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        SendFileContent r1 = com.larus.bmhome.chat.sendimage.e.f(this.$menuContext.a.getContent());
        String r2 = this.$targetFilePath;
        List r3 = r1.getFileList();
        if (r3 == null) goto L12;
        SendFile r4 = (SendFile) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L12;
        r4.setLocalResPath(r2);
    L12:
        Unit r7 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "content");
        r6.J1(r0, GsonProtectorUtils.toJson(com.larus.bmhome.chat.sendimage.e.i(), r1), new a(this.$menuContext));
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
