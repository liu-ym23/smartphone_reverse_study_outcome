package com.larus.bmhome.nestedfile;

import android.content.Context;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.office.base.w;
import com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent;
import h38.d;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import lr8.e;
import lr8.f;
import lr8.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010JH\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016JH\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016JR\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¨\u0006 "}, d2 = {"Lcom/larus/bmhome/nestedfile/NestFileServiceNoop;", "Lcom/larus/bmhome/nestedfile/INestFileService;", "<init>", "()V", "createNestedFileView", "Lcom/larus/NestedFileViewInterface;", "context", "Landroid/content/Context;", "openResourceOnClick", "", "params", "Lcom/larus/bmhome/nestedfile/OpenResourceOnClickParams;", "requireFileUrl", "", "fileInfo", "Lcom/larus/im/bean/message/UplinkFileInfo;", "(Landroid/content/Context;Lcom/larus/im/bean/message/UplinkFileInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFile", "Lcom/larus/bmhome/nestedfile/StepResult;", "openAudio", "key", MusicAppletPage.KEY_PATH, "message", "Lcom/larus/im/bean/message/Message;", "cxt", "botId", "delegate", "Lcom/larus/bmhome/nestedfile/INestedFileClickDelegate;", "openFile", "targetFileName", "openFileAfterSign", "previewUrl", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestFileServiceNoop implements INestFileService {
    public NestFileServiceNoop() {
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final Object a(Context r1, UplinkFileInfo r2, Continuation<? super String> r3) {
        return null;
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final void b(Context r1, String r2, String r3, UplinkFileInfo r4, Message r5, String r6, w.a r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r7, "delegate");
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final void c(f r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final void d(Context r1, String r2, UplinkFileInfo r3, Message r4, String r5, w.a r6) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r6, "delegate");
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final void g(String r1, String r2, Message r3, Context r4, UplinkFileInfo r5, String r6, OmniDetailContentComponent.b r7) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "cxt");
        Intrinsics.checkNotNullParameter(r7, "delegate");
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final d e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new e(r2);
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final Object f(Context r12, UplinkFileInfo r13, Continuation<? super g> r14) {
        return new g(-1, null, null, null, null, null, null, null, null, 510);
    }
}
