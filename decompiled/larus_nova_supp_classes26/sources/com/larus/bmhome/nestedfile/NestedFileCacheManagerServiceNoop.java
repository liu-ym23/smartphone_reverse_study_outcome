package com.larus.bmhome.nestedfile;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lr8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\"\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\t2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010!\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&H\u0016J@\u0010'\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010/\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0018\u00100\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0018\u00101\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\n\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/bmhome/nestedfile/NestedFileCacheManagerServiceNoop;", "Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService;", "<init>", "()V", "nestedFileCache", "", "", "Lcom/larus/im/bean/message/NestedFileContent;", "nestedFileLiveDataCache", "Landroidx/lifecycle/MutableLiveData;", "fileLiveDataCache", "Lkotlin/Pair;", "Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService$FileEvent;", "Lcom/larus/im/bean/message/UplinkFileEntity;", "removedFilesCache", "", "getOrCreateNestedFileLiveData", "localMsgID", "insertOrReplaceNestedFile", "", "content", "removeNestedFile", "getNestedFile", "getOrCreateFileLiveData", "insertFile", "removeFile", "fileIdentifier", "replaceFile", "updateUplinkFileEntity", "updateFileEntity", "updateUplinkFileInfo", "updateFileInfo", "Lcom/larus/bmhome/nestedfile/NestedFileUplinkUpdateInfo;", "updateFileUpLinkProcess", "process", "", "updateFileStateFromCMD", "info", "Lcom/larus/bmhome/nestedfile/UpdateNestedMessageDownLinkInfo;", "updateFileState", "upLinkState", "Lcom/larus/im/bean/message/UpLinkState;", "fileReviewState", "Lcom/larus/im/bean/message/FileReviewState;", "fileParseState", "Lcom/larus/im/bean/message/FileParseState;", "audioDetailUrl", "getFile", "insertRemovedFile", "removeRemovedFile", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedFileCacheManagerServiceNoop implements INestedFileCacheManagerService {
    public final Map<String, NestedFileContent> a;
    public final Map<String, MutableLiveData<NestedFileContent>> b;
    public final Map<String, MutableLiveData<Pair<INestedFileCacheManagerService.FileEvent, UplinkFileEntity>>> c;
    public final Map<String, Set<String>> d;

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void e(UpdateNestedMessageDownLinkInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
    }

    public NestedFileCacheManagerServiceNoop() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void b2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        this.a.remove(r2);
        j(r2).postValue(null);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final NestedFileContent b6(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        return (NestedFileContent) ((LinkedHashMap) this.a).get(r2);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final MutableLiveData<Pair<INestedFileCacheManagerService.FileEvent, UplinkFileEntity>> g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "localMsgID");
        LinkedHashMap r0 = (LinkedHashMap) this.c;
        Object r1 = r0.get(r3);
        if (r1 != null) goto L6;
        r1 = new MutableLiveData();
        r0.put(r3, r1);
    L6:
        return (MutableLiveData) r1;
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final MutableLiveData<NestedFileContent> j(String r3) {
        Intrinsics.checkNotNullParameter(r3, "localMsgID");
        LinkedHashMap r0 = (LinkedHashMap) this.b;
        Object r1 = r0.get(r3);
        if (r1 != null) goto L6;
        r1 = new MutableLiveData();
        r0.put(r3, r1);
    L6:
        return (MutableLiveData) r1;
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final UplinkFileEntity a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "localMsgID");
        Intrinsics.checkNotNullParameter(r5, "fileIdentifier");
        NestedFileContent r6 = (NestedFileContent) ((LinkedHashMap) this.a).get(r4);
        Object r0 = null;
        if (r6 == null) goto L17;
        List r7 = r6.getEntities();
        if (r7 == null) goto L18;
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L13;
        Object r1 = r8.next();
        if (Intrinsics.areEqual(((UplinkFileEntity) r1).getFileIdentifier(), r5) == false) goto L8;
        r0 = r1;
    L13:
        return (UplinkFileEntity) r0;
    L18:
        return null;
    L17:
        return null;
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void b(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "localMsgID");
        Intrinsics.checkNotNullParameter(r6, "fileIdentifier");
        LinkedHashMap r0 = (LinkedHashMap) this.d;
        Object r1 = r0.get(r5);
        if (r1 != null) goto L5;
        r1 = new LinkedHashSet();
        r0.put(r5, r1);
    L5:
        ((Set) r1).add(r6);
        NestedFileContent r2 = (NestedFileContent) ((LinkedHashMap) this.a).get(r5);
        if (r2 == null) goto L16;
        List r3 = r2.getEntities();
        if (r3 == null) goto L22;
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L23;
        UplinkFileEntity r7 = (UplinkFileEntity) r4.next();
        if (Intrinsics.areEqual(r7.getFileIdentifier(), r6) == false) goto L12;
        r4.remove();
        g(r5).postValue(TuplesKt.to(INestedFileCacheManagerService.FileEvent.REMOVE, r7));
        goto L12
    L23:
        return;
    L22:
        return;
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void c(String r12, UplinkFileEntity r13) {
        Intrinsics.checkNotNullParameter(r12, "localMsgID");
        Intrinsics.checkNotNullParameter(r13, "content");
        Set r0 = (Set) ((LinkedHashMap) this.d).get(r12);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        LinkedHashMap r3 = (LinkedHashMap) this.a;
        Object r4 = r3.get(r12);
        if (r4 != null) goto L13;
        r4 = new NestedFileContent(new ArrayList(), null, false, null, 14, null);
        r3.put(r12, r4);
    L13:
        NestedFileContent r5 = (NestedFileContent) r4;
        List r6 = r5.getEntities();
        if (r6 != null) goto L16;
        r6 = new ArrayList();
        r5.setEntities(r6);
    L16:
        List r7 = r6;
        if ((r7 instanceof Collection) == true) goto L19;
    L21:
        Iterator r8 = r7.iterator();
    L23:
        if (r8.hasNext() == false) goto L27;
        if (Intrinsics.areEqual(((UplinkFileEntity) r8.next()).getFileIdentifier(), r13.getFileIdentifier()) == false) goto L23;
    L28:
        if (r1 == false) goto L34;
        r6.add(r13);
        g(r12).postValue(TuplesKt.to(INestedFileCacheManagerService.FileEvent.INSERT, r13));
        return;
    L34:
        return;
    L27:
        r1 = true;
        goto L28
    L19:
        if (r7.isEmpty() == false) goto L21;
    L5:
        if (CollectionsKt.contains(r0, r13.getFileIdentifier()) != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void f(String r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "updateFileInfo");
        UplinkFileEntity r0 = a(r2, r3.a);
        if (r0 == null) goto L6;
        r0.setInstantUploadInfoJson(r3.e);
        g(r2).postValue(TuplesKt.to(INestedFileCacheManagerService.FileEvent.UPDATE, r0));
        return;
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void h(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        Set r0 = (Set) ((LinkedHashMap) this.d).get(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r3);
        if (r0.isEmpty() == false) goto L9;
        this.d.remove(r2);
        return;
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void i(String r2, NestedFileContent r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "content");
        this.a.put(r2, r3);
        j(r2).postValue(r3);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void k(String r6, UplinkFileEntity r7) {
        Intrinsics.checkNotNullParameter(r6, "localMsgID");
        Intrinsics.checkNotNullParameter(r7, "content");
        Set r0 = (Set) ((LinkedHashMap) this.d).get(r6);
        int r1 = 0;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (CollectionsKt.contains(r0, r7.getFileIdentifier()) != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        NestedFileContent r3 = (NestedFileContent) ((LinkedHashMap) this.a).get(r6);
        if (r3 == null) goto L28;
        List r4 = r3.getEntities();
        if (r4 == null) goto L30;
        Iterator r5 = r4.iterator();
    L17:
        if (r5.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(((UplinkFileEntity) r5.next()).getFileIdentifier(), r7.getFileIdentifier()) == true) goto L23;
        r1 = r1 + 1;
    L23:
        if (r1 < 0) goto L29;
        ListProtector.set(r4, r1, r7);
        g(r6).postValue(TuplesKt.to(INestedFileCacheManagerService.FileEvent.UPDATE, r7));
        return;
    L29:
        return;
    L22:
        r1 = -1;
        goto L23
    L30:
        return;
    L28:
        return;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void l(String r2, UplinkFileEntity r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "updateFileEntity");
        k(r2, r3);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void n(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "localMsgID");
        Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
        LinkedHashMap r0 = (LinkedHashMap) this.d;
        Object r1 = r0.get(r3);
        if (r1 != null) goto L5;
        r1 = new LinkedHashSet();
        r0.put(r3, r1);
    L5:
        ((Set) r1).add(r4);
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void m(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        UplinkFileEntity r5 = a(r2, r3);
        if (r5 == null) goto L6;
        r5.setUpLinkProcess(Integer.valueOf(r4));
        g(r2).postValue(TuplesKt.to(INestedFileCacheManagerService.FileEvent.UPDATE, r5));
        return;
    }

    @Override // com.larus.bmhome.nestedfile.INestedFileCacheManagerService
    public final void d(String r1, String r2, UpLinkState r3, FileReviewState r4, FileParseState r5, String r6) {
        Intrinsics.checkNotNullParameter(r1, "localMsgID");
        Intrinsics.checkNotNullParameter(r2, "fileIdentifier");
        UplinkFileEntity r7 = a(r1, r2);
        if (r7 == null) goto L12;
        if (r3 == null) goto L6;
        r7.setUpLinkStatus(Integer.valueOf(r3.getValue()));
    L6:
        if (r4 == null) goto L8;
        r7.setFileReviewStatus(Integer.valueOf(r4.getValue()));
    L8:
        if (r5 == null) goto L10;
        r7.setFileParsedStatus(Integer.valueOf(r5.getValue()));
    L10:
        g(r1).postValue(TuplesKt.to(INestedFileCacheManagerService.FileEvent.UPDATE, r7));
        return;
    }
}
