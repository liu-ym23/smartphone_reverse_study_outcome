package com.larus.bmhome.chat.service;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.t1;
import com.larus.bmhome.chat.list.cell.nested_file.NestedFileClickHelper;
import com.larus.bmhome.chat.list.cell.nested_file.NestedFileDownloader;
import com.larus.bmhome.nestedfile.INestFileService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.office.base.w;
import com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010JH\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016JH\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016JR\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/service/NestFileServiceImpl;", "Lcom/larus/bmhome/nestedfile/INestFileService;", "<init>", "()V", "createNestedFileView", "Lcom/larus/NestedFileViewInterface;", "context", "Landroid/content/Context;", "openResourceOnClick", "", "params", "Lcom/larus/bmhome/nestedfile/OpenResourceOnClickParams;", "requireFileUrl", "", "fileInfo", "Lcom/larus/im/bean/message/UplinkFileInfo;", "(Landroid/content/Context;Lcom/larus/im/bean/message/UplinkFileInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFile", "Lcom/larus/bmhome/nestedfile/StepResult;", "openAudio", "key", "path", "message", "Lcom/larus/im/bean/message/Message;", "cxt", "botId", "delegate", "Lcom/larus/bmhome/nestedfile/INestedFileClickDelegate;", "openFile", "targetFileName", "openFileAfterSign", "previewUrl", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NestFileServiceImpl implements INestFileService {
    public NestFileServiceImpl() {
    }

    public final void c(lr8.f r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        NestedFileClickHelper.a.getClass();
        NestedFileClickHelper.i(r2);
    }

    public final h38.d e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new t1(r2);
    }

    public final Object a(Context r9, UplinkFileInfo r10, Continuation<? super String> r11) {
        if ((r11 instanceof NestFileServiceImpl$requireFileUrl$1) == false) goto L7;
        NestFileServiceImpl$requireFileUrl$1 r0 = (NestFileServiceImpl$requireFileUrl$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L17:
        Context r4 = r9;
        lr8.g r13 = (lr8.g) r12;
        Integer r14 = r13.b;
        if (r14 == null) goto L25;
        if (r14.intValue() != 14007) goto L25;
        s.j(s.a, r4, r4.getString(2131898024), null, false, 28);
        return null;
    L25:
        return r13.c;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        NestedFileDownloader r15 = NestedFileDownloader.a;
        r0.L$0 = r9;
        r0.label = 1;
        r12 = r15.f(r10, r0);
        if (r12 != r2) goto L17;
        return r2;
    L7:
        r0 = new NestFileServiceImpl$requireFileUrl$1(this, r11);
        goto L8
    }

    public final Object f(Context r12, UplinkFileInfo r13, Continuation<? super lr8.g> r14) {
        if ((r14 instanceof NestFileServiceImpl$downloadFile$1) == false) goto L7;
        NestFileServiceImpl$downloadFile$1 r0 = (NestFileServiceImpl$downloadFile$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        NestFileServiceImpl$downloadFile$1 r6 = r0;
        Object r15 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L17:
        NestedFileDownloader.a r16 = (NestedFileDownloader.a) r15;
        return new lr8.g(r16.a, null, null, null, null, r16.b, r16.c, r16.d, null, 286);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        NestedFileDownloader r4 = NestedFileDownloader.a;
        r6.label = 1;
        r15 = r4.c(r12, r13, null, null, r6);
        if (r15 != r2) goto L17;
        return r2;
    L7:
        r0 = new NestFileServiceImpl$downloadFile$1(this, r14);
        goto L8
    }

    public final void d(Context r9, String r10, UplinkFileInfo r11, Message r12, String r13, w.a r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r14, "delegate");
        NestedFileClickHelper.a.getClass();
        NestedFileClickHelper.g(r9, r10, r11, null, r12, null, r13, r14);
    }

    public final void b(Context r2, String r3, String r4, UplinkFileInfo r5, Message r6, String r7, w.a r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r6, "message");
        Intrinsics.checkNotNullParameter(r8, "delegate");
        NestedFileClickHelper.a.getClass();
        NestedFileClickHelper.h(r2, r3, r4, r5, r6, r7, r8);
    }

    public final void g(String r2, String r3, Message r4, Context r5, UplinkFileInfo r6, String r7, OmniDetailContentComponent.b r8) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "cxt");
        Intrinsics.checkNotNullParameter(r8, "delegate");
        NestedFileClickHelper.a.getClass();
        NestedFileClickHelper.f(r2, r3, r4, r5, r6, r7, r8);
    }
}
