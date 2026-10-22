package com.larus.bmhome.chat.component.share;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.f;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.FileExportTypeChooseDialog$openFileExportH5$2", f = "FileExportTypeChooseDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FileExportTypeChooseDialog$openFileExportH5$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $exportId;
    int label;
    final /* synthetic */ FileExportTypeChooseDialog this$0;

    public FileExportTypeChooseDialog$openFileExportH5$2(FileExportTypeChooseDialog r1, String r2, Continuation<? super FileExportTypeChooseDialog$openFileExportH5$2> r3) {
        this.this$0 = r1;
        this.$exportId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FileExportTypeChooseDialog$openFileExportH5$2(this.this$0, this.$exportId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r12);
        Context r13 = this.this$0.getContext();
        if (r13 == null) goto L7;
        com.larus.platform.service.q r0 = com.larus.platform.service.q.a;
        Pair[] r1 = new Pair[3];
        String r2 = this.$exportId;
        int r3 = this.this$0.f.toH5Type();
        FileExportTypeChooseDialog r4 = this.this$0;
        String r5 = r4.i;
        String r6 = r4.k;
        if (r4.n.isEmpty() == false) goto L11;
        String r7 = "message";
    L12:
        Intrinsics.checkNotNullParameter(r2, "exportId");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r6, "botId");
        Intrinsics.checkNotNullParameter(r7, "exportFrom");
        Uri.Builder r8 = UriProtector.parse(AppHost.a.d() + "/inapp/message-export").buildUpon();
        if (r2.length() <= 0) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L18;
        r8.appendQueryParameter("export_id", r2);
    L18:
        r8.appendQueryParameter("export_type", String.valueOf(r3));
        if (r5.length() <= 0) goto L21;
        boolean r10 = true;
    L22:
        if (r10 == false) goto L25;
        r8.appendQueryParameter("export_action_id", r5);
    L25:
        if (r6.length() <= 0) goto L27;
        boolean r11 = true;
    L28:
        if (r11 == false) goto L31;
        r8.appendQueryParameter("bot_id", r6);
    L31:
        if (r7.length() <= 0) goto L33;
        boolean r14 = true;
    L34:
        if (r14 == false) goto L36;
        r8.appendQueryParameter("export_from", r7);
    L36:
        r8.appendQueryParameter("previous_page", "chat");
        r1[0] = TuplesKt.to("link_url", r8.build().toString());
        r1[1] = TuplesKt.to("enable_bottom_share_style", "0");
        r1[2] = TuplesKt.to("title", "");
        r0.e(r13, f.c(r1), null);
        return Unit.INSTANCE;
    L33:
        r14 = false;
        goto L34
    L27:
        r11 = false;
        goto L28
    L21:
        r10 = false;
        goto L22
    L15:
        r9 = false;
        goto L16
    L11:
        r7 = "block";
        goto L12
    L7:
        return Unit.INSTANCE;
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
