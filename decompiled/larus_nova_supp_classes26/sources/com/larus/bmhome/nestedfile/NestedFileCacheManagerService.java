package com.larus.bmhome.nestedfile;

import androidx.lifecycle.MutableLiveData;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import lr8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J#\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0096\u0001JA\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0096\u0001J!\u0010$\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0096\u0001J\u0019\u0010'\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010)\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+H\u0096\u0001¨\u0006,"}, d2 = {"Lcom/larus/bmhome/nestedfile/NestedFileCacheManagerService;", "Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService;", "<init>", "()V", "getFile", "Lcom/larus/im/bean/message/UplinkFileEntity;", "localMsgID", "", "fileIdentifier", "getNestedFile", "Lcom/larus/im/bean/message/NestedFileContent;", "getOrCreateFileLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService$FileEvent;", "getOrCreateNestedFileLiveData", "insertFile", "", "content", "insertOrReplaceNestedFile", "insertRemovedFile", "removeFile", "removeNestedFile", "removeRemovedFile", "replaceFile", "updateFileState", "upLinkState", "Lcom/larus/im/bean/message/UpLinkState;", "fileReviewState", "Lcom/larus/im/bean/message/FileReviewState;", "fileParseState", "Lcom/larus/im/bean/message/FileParseState;", "audioDetailUrl", "updateFileStateFromCMD", "info", "Lcom/larus/bmhome/nestedfile/UpdateNestedMessageDownLinkInfo;", "updateFileUpLinkProcess", "process", "", "updateUplinkFileEntity", "updateFileEntity", "updateUplinkFileInfo", "updateFileInfo", "Lcom/larus/bmhome/nestedfile/NestedFileUplinkUpdateInfo;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedFileCacheManagerService implements INestedFileCacheManagerService {
    public static final NestedFileCacheManagerService b = null;
    public final /* synthetic */ INestedFileCacheManagerService a;

    static {
        b = new NestedFileCacheManagerService();
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final UplinkFileEntity a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        return this.a.a(r2, r3);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        this.a.b(r2, r3);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void b2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        this.a.b2(r2);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final NestedFileContent b6(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        return this.a.b6(r2);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void c(String r2, UplinkFileEntity r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "content");
        this.a.c(r2, r3);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void d(String r9, String r10, UpLinkState r11, FileReviewState r12, FileParseState r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "localMsgID");
        Intrinsics.checkNotNullParameter(r10, "fileIdentifier");
        this.a.d(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void e(UpdateNestedMessageDownLinkInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        this.a.e(r2);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void f(String r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "updateFileInfo");
        this.a.f(r2, r3);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final MutableLiveData<Pair<INestedFileCacheManagerService.FileEvent, UplinkFileEntity>> g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        return this.a.g(r2);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void h(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        this.a.h(r2, r3);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void i(String r2, NestedFileContent r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "content");
        this.a.i(r2, r3);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final MutableLiveData<NestedFileContent> j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        return this.a.j(r2);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void k(String r2, UplinkFileEntity r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "content");
        this.a.k(r2, r3);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void l(String r2, UplinkFileEntity r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "updateFileEntity");
        this.a.l(r2, r3);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void m(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        this.a.m(r2, r3, r4);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void n(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        this.a.n(r2, r3);
    }

    private NestedFileCacheManagerService() {
        INestedFileCacheManagerService r0 = (INestedFileCacheManagerService) ServiceManager.get().getService(INestedFileCacheManagerService.class);
        if (r0 != null) goto L5;
        r0 = new NestedFileCacheManagerServiceNoop();
    L5:
        this.a = r0;
    }
}
