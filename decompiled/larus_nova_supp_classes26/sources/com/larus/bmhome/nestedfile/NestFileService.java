package com.larus.bmhome.nestedfile;

import android.content.Context;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.office.base.w;
import com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h38.d;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import lr8.f;
import lr8.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096A¢\u0006\u0002\u0010\fJI\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0096\u0001JI\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0096\u0001JS\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J \u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096A¢\u0006\u0002\u0010\f¨\u0006 "}, d2 = {"Lcom/larus/bmhome/nestedfile/NestFileService;", "Lcom/larus/bmhome/nestedfile/INestFileService;", "<init>", "()V", "createNestedFileView", "Lcom/larus/NestedFileViewInterface;", "context", "Landroid/content/Context;", "downloadFile", "Lcom/larus/bmhome/nestedfile/StepResult;", "fileInfo", "Lcom/larus/im/bean/message/UplinkFileInfo;", "(Landroid/content/Context;Lcom/larus/im/bean/message/UplinkFileInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openAudio", "", "key", "", MusicAppletPage.KEY_PATH, "message", "Lcom/larus/im/bean/message/Message;", "cxt", "botId", "delegate", "Lcom/larus/bmhome/nestedfile/INestedFileClickDelegate;", "openFile", "targetFileName", "openFileAfterSign", "previewUrl", "openResourceOnClick", "params", "Lcom/larus/bmhome/nestedfile/OpenResourceOnClickParams;", "requireFileUrl", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestFileService implements INestFileService {
    public static final NestFileService b = null;
    public final /* synthetic */ INestFileService a;

    static {
        b = new NestFileService();
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final Object a(Context r2, UplinkFileInfo r3, Continuation<? super String> r4) {
        return this.a.a(r2, r3, r4);
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final void b(Context r10, String r11, String r12, UplinkFileInfo r13, Message r14, String r15, w.a r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r14, "message");
        Intrinsics.checkNotNullParameter(r16, "delegate");
        this.a.b(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final void c(f r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.c(r2);
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final void d(Context r9, String r10, UplinkFileInfo r11, Message r12, String r13, w.a r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r14, "delegate");
        this.a.d(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final d e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.e(r2);
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final Object f(Context r2, UplinkFileInfo r3, Continuation<? super g> r4) {
        return this.a.f(r2, r3, r4);
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final void g(String r10, String r11, Message r12, Context r13, UplinkFileInfo r14, String r15, OmniDetailContentComponent.b r16) {
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r13, "cxt");
        Intrinsics.checkNotNullParameter(r16, "delegate");
        this.a.g(r10, r11, r12, r13, r14, r15, r16);
    }

    private NestFileService() {
        INestFileService r0 = (INestFileService) ServiceManager.get().getService(INestFileService.class);
        if (r0 != null) goto L5;
        r0 = new NestFileServiceNoop();
    L5:
        this.a = r0;
    }
}
