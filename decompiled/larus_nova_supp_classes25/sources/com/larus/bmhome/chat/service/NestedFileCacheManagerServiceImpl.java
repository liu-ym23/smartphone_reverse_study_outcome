package com.larus.bmhome.chat.service;

import androidx.collection.LruCache;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.nestedfile.EntityState;
import com.larus.bmhome.nestedfile.FieldType;
import com.larus.bmhome.nestedfile.INestedFileCacheManagerService;
import com.larus.bmhome.nestedfile.UpdateNestedMessageDownLinkInfo;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\"\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\t2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u001e\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\rH\u0016J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0016J \u0010%\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u001bH\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0016J@\u0010*\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u00102\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u000204H\u0002J\u0018\u00105\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u00107\u001a\u00020\u0007H\u0002J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0018\u00109\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0018\u0010:\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\n\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/bmhome/chat/service/NestedFileCacheManagerServiceImpl;", "Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService;", "<init>", "()V", "cache", "Landroidx/collection/LruCache;", "", "Lcom/larus/im/bean/message/NestedFileContent;", "nestedFileLiveDataCache", "Landroidx/lifecycle/MutableLiveData;", "fileLiveDataCache", "Lkotlin/Pair;", "Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService$FileEvent;", "Lcom/larus/im/bean/message/UplinkFileEntity;", "removedFileListCache", "", "getOrCreateNestedFileLiveData", "localMsgID", "insertOrReplaceNestedFile", "", "content", "removeNestedFile", "getNestedFile", "getOrCreateFileLiveData", "insertFile", "replaceFile", "findEntityIndex", "", "entities", "", "removeFile", "fileIdentifier", "updateUplinkFileEntity", "updateFileEntity", "updateUplinkFileInfo", "updateFileInfo", "Lcom/larus/bmhome/nestedfile/NestedFileUplinkUpdateInfo;", "updateFileUpLinkProcess", "process", "updateFileStateFromCMD", "info", "Lcom/larus/bmhome/nestedfile/UpdateNestedMessageDownLinkInfo;", "updateFileState", "upLinkState", "Lcom/larus/im/bean/message/UpLinkState;", "fileReviewState", "Lcom/larus/im/bean/message/FileReviewState;", "fileParseState", "Lcom/larus/im/bean/message/FileParseState;", "audioDetailUrl", "getFile", "isUseConcurrentEntitiesEnabled", "", "getOrCreateThreadSafeEntities", "ensureThreadSafeEntities", "nestedFile", "getOrCreateRemovedFileList", "insertRemovedFile", "removeRemovedFile", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NestedFileCacheManagerServiceImpl implements INestedFileCacheManagerService {
    public static final /* synthetic */ int e = 0;
    public final LruCache<String, NestedFileContent> a;
    public final LruCache<String, MutableLiveData<NestedFileContent>> b;
    public final LruCache<String, MutableLiveData<Pair<INestedFileCacheManagerService.FileEvent, UplinkFileEntity>>> c;
    public final LruCache<String, List<String>> d;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FieldType.values().length];
            r0[FieldType.PARSE_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FieldType.REVIEW_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static boolean q() {
        return z2.a.getSlardarCrashNestedFileCmeConfig().a();
    }

    public NestedFileCacheManagerServiceImpl() {
        this.a = new LruCache(10);
        this.b = new LruCache(10);
        this.c = new LruCache(10);
        this.d = new LruCache(10);
    }

    public static List o(NestedFileContent r2) {
        List r0 = r2.getEntities();
        if ((r0 instanceof CopyOnWriteArrayList) == false) goto L5;
        return r0;
    L5:
        CopyOnWriteArrayList r1 = new CopyOnWriteArrayList();
        if (r0 == null) goto L8;
        r1.addAll(r0);
    L8:
        r2.setEntities(r1);
        return r1;
    }

    public final void b2(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "localMsgID");
        FLogger.a.i("NestedFileCacheManagerServiceImpl", "removeNestedFile, localMsgID:" + r4);
        if (((NestedFileContent) this.a.remove(r4)) == null) goto L6;
        t0.e(new k(this, r4));
        return;
    }

    public final NestedFileContent b6(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        return (NestedFileContent) this.a.get(r2);
    }

    public final void e(UpdateNestedMessageDownLinkInfo r17) {
        Intrinsics.checkNotNullParameter(r17, "info");
        FLogger.a.i("NestedFileCacheManagerServiceImpl", "updateFileStateFromCMD, info:" + r17);
        String r1 = r17.getLocalMsgId();
        if (o0.d(r1) == false) goto L63;
        List r0 = r17.getEntityStateList();
        if (r0 == null) goto L88;
        List r2 = CollectionsKt.filterNotNull(r0);
        if (r2 == null) goto L89;
        Iterator r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L90;
        EntityState r4 = (EntityState) r3.next();
        String r5 = r4.getFileIdentifier();
        if (o0.d(r5) == false) goto L10;
        if (com.larus.bmhome.nestedfile.a.a(r4) == false) goto L10;
        List r6 = r4.getUpdateFields();
        if (r6 == null) goto L10;
        Iterator r11 = r6.iterator();
    L19:
        if (r11.hasNext() == false) goto L10;
        int r7 = ((Number) r11.next()).intValue();
        FieldType.a r8 = FieldType.Companion;
        Integer r9 = Integer.valueOf(r7);
        r8.getClass();
        int r10 = b.a[FieldType.a.a(r9).ordinal()];
        if (r10 != 1) goto L23;
        Integer r12 = r4.getParseState();
        if (r12 == null) goto L19;
        int r13 = r12.intValue();
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNull(r5);
        FileParseState.a r14 = FileParseState.Companion;
        Integer r15 = Integer.valueOf(r13);
        r14.getClass();
        FileParseState[] r16 = FileParseState.values();
        int r18 = r16.length;
        int r19 = 0;
    L47:
        if (r19 >= r18) goto L58;
        FileParseState r110 = r16[r19];
        int r111 = r110.getValue();
        if (r15 != null) goto L52;
    L54:
        boolean r20 = false;
    L55:
        if (r20 == true) goto L56;
        r19 = r19 + 1;
        goto L47
    L56:
        FileParseState r21 = r110;
    L59:
        if (r21 != null) goto L61;
        FileParseState r112 = FileParseState.DEFAULT;
    L62:
        INestedFileCacheManagerService.a.a(this, r1, r5, null, null, r112, 44);
        goto L19
    L61:
        r112 = r21;
        goto L62
    L52:
        if (r111 != r15.intValue()) goto L54;
        r20 = true;
        goto L55
    L58:
        r21 = null;
        goto L59
    L23:
        if (r10 != 2) goto L19;
        Integer r22 = r4.getReviewState();
        if (r22 == null) goto L19;
        int r23 = r22.intValue();
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNull(r5);
        FileReviewState.a r24 = FileReviewState.Companion;
        Integer r25 = Integer.valueOf(r23);
        r24.getClass();
        FileReviewState[] r26 = FileReviewState.values();
        int r113 = r26.length;
        int r114 = 0;
    L28:
        if (r114 >= r113) goto L39;
        FileReviewState r115 = r26[r114];
        int r116 = r115.getValue();
        if (r25 != null) goto L33;
    L35:
        boolean r117 = false;
    L36:
        if (r117 == true) goto L37;
        r114 = r114 + 1;
        goto L28
    L37:
        FileReviewState r27 = r115;
    L40:
        if (r27 != null) goto L42;
        FileReviewState r28 = FileReviewState.DEFAULT;
    L43:
        INestedFileCacheManagerService.a.a(this, r1, r5, null, r28, null, 52);
        goto L19
    L42:
        r28 = r27;
        goto L43
    L33:
        if (r116 != r25.intValue()) goto L35;
        r117 = true;
        goto L36
    L39:
        r27 = null;
        goto L40
    L90:
        return;
    L89:
        return;
    L88:
        return;
    }

    public final MutableLiveData<Pair<INestedFileCacheManagerService.FileEvent, UplinkFileEntity>> g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "localMsgID");
        MutableLiveData<Pair<INestedFileCacheManagerService.FileEvent, UplinkFileEntity>> r0 = (MutableLiveData) this.c.get(r3);
        if (r0 != null) goto L6;
        MutableLiveData<Pair<INestedFileCacheManagerService.FileEvent, UplinkFileEntity>> r1 = new MutableLiveData();
        this.c.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public final MutableLiveData<NestedFileContent> j(String r3) {
        Intrinsics.checkNotNullParameter(r3, "localMsgID");
        MutableLiveData<NestedFileContent> r0 = (MutableLiveData) this.b.get(r3);
        if (r0 != null) goto L6;
        MutableLiveData<NestedFileContent> r1 = new MutableLiveData();
        this.b.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public static int p(List r3, UplinkFileEntity r4) {
        UplinkEntityContent r0 = r4.getUplinkEntityContent();
        if (r0 == null) goto L7;
        Image r1 = r0.getUplinkImageInfo();
        if (r1 == null) goto L7;
        String r2 = r1.identifier;
    L8:
        int r5 = 0;
        if (r2 == null) goto L23;
        Iterator r6 = r3.iterator();
    L12:
        if (r6.hasNext() == false) goto L32;
        UplinkEntityContent r7 = ((UplinkFileEntity) r6.next()).getUplinkEntityContent();
        if (r7 == null) goto L18;
        Image r8 = r7.getUplinkImageInfo();
        if (r8 == null) goto L18;
        String r9 = r8.identifier;
    L20:
        if (Intrinsics.areEqual(r9, r2) == true) goto L38;
        r5 = r5 + 1;
        goto L12
    L38:
        return r5;
    L18:
        r9 = null;
    L32:
        return -1;
    L23:
        String r10 = r4.getFileIdentifier();
        if (r10 == null) goto L32;
        Iterator r11 = r3.iterator();
    L27:
        if (r11.hasNext() == false) goto L32;
        if (Intrinsics.areEqual(((UplinkFileEntity) r11.next()).getFileIdentifier(), r10) == true) goto L39;
        r5 = r5 + 1;
        goto L27
    L39:
        return r5;
    L7:
        r2 = null;
        goto L8
    }

    public final UplinkFileEntity a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "localMsgID");
        Intrinsics.checkNotNullParameter(r5, "fileIdentifier");
        Object r1 = null;
        if (q() == false) goto L16;
        NestedFileContent r6 = b6(r4);
        if (r6 != null) goto L7;
        List r7 = null;
    L8:
        if (r7 == null) goto L34;
        Iterator r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L35;
        Object r0 = r8.next();
        if (Intrinsics.areEqual(((UplinkFileEntity) r0).getFileIdentifier(), r5) == false) goto L11;
        r1 = r0;
    L35:
        return (UplinkFileEntity) r1;
    L34:
        return null;
    L7:
        r7 = o(r6);
        goto L8
    L16:
        NestedFileContent r9 = b6(r4);
        if (r9 == null) goto L36;
        List r10 = r9.getEntities();
        if (r10 == null) goto L37;
        Iterator r11 = r10.iterator();
    L22:
        if (r11.hasNext() == false) goto L27;
        Object r2 = r11.next();
        if (Intrinsics.areEqual(((UplinkFileEntity) r2).getFileIdentifier(), r5) == false) goto L22;
        r1 = r2;
    L27:
        return (UplinkFileEntity) r1;
    L37:
        return null;
    L36:
        return null;
    }

    public final void b(final String r6, final String r7) {
        Intrinsics.checkNotNullParameter(r6, "localMsgID");
        Intrinsics.checkNotNullParameter(r7, "fileIdentifier");
        FLogger.a.i("NestedFileCacheManagerServiceImpl", "removeFile, localMsgID:" + r6 + ", fileIdentifier:" + r7);
        if (q() == false) goto L22;
        NestedFileContent r0 = b6(r6);
        if (r0 != null) goto L7;
        List r1 = null;
    L8:
        if (r1 != null) goto L10;
        return;
    L10:
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L12:
        if (r3.hasNext() == false) goto L16;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((UplinkFileEntity) r4).getFileIdentifier(), r7) == false) goto L12;
        r2.add(r4);
        goto L12
    L16:
        Iterator r8 = r2.iterator();
    L18:
        if (r8.hasNext() == false) goto L40;
        final UplinkFileEntity r5 = (UplinkFileEntity) r8.next();
        if (r1.remove(r5) == false) goto L18;
        t0.e(new r(this, r6, r5));
        goto L18
    L40:
        return;
    L7:
        r1 = o(r0);
        goto L8
    L22:
        NestedFileContent r9 = b6(r6);
        if (r9 == null) goto L38;
        List r10 = r9.getEntities();
        if (r10 == null) goto L39;
        CollectionsKt.removeAll(r10, new g(r7, this, r6));
        return;
    L39:
        return;
    }

    public final void c(final String r21, final UplinkFileEntity r22) {
        Intrinsics.checkNotNullParameter(r21, "localMsgID");
        Intrinsics.checkNotNullParameter(r22, "content");
        FLogger r3 = FLogger.a;
        r3.i("NestedFileCacheManagerServiceImpl", "insertFile, localMsgID:" + r21 + ", content:" + r22);
        boolean r4 = q();
        r3.i("NestedFileCacheManagerServiceImpl", "nested_file_cme_fix: use_concurrent=" + r4 + ", scene=insertFile, localMsgID=" + r21 + ", fileIdentifier=" + r22.getFileIdentifier());
        NestedFileContent r5 = b6(r21);
        if (r5 != null) goto L8;
        if (r4 == false) goto L6;
        r5 = new NestedFileContent(new CopyOnWriteArrayList(), null, false, null, 14, null);
    L7:
        this.a.put(r21, r5);
        goto L8
    L6:
        r5 = new NestedFileContent(new ArrayList(), null, false, null, 14, null);
    L8:
        boolean r6 = false;
        if (r4 == false) goto L25;
        List r10 = o(r5);
        if ((r10 instanceof Collection) == true) goto L13;
    L15:
        Iterator r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(((UplinkFileEntity) r11.next()).getFileIdentifier(), r22.getFileIdentifier()) == false) goto L17;
        boolean r12 = true;
    L22:
        if (r12 == false) goto L45;
        FLogger.a.w("NestedFileCacheManagerServiceImpl", "insertFile exist, localMsgID:" + r21 + ", fileIdentifier:" + r22.getFileIdentifier());
        return;
    L45:
        Iterable r8 = (List) this.d.get(r21);
        if (r8 != null) goto L48;
        r8 = new ArrayList();
        this.d.put(r21, r8);
    L48:
        Iterable r9 = r8;
        if ((r9 instanceof Collection) == true) goto L51;
    L53:
        Iterator r13 = r9.iterator();
    L55:
        if (r13.hasNext() == false) goto L59;
        if (Intrinsics.areEqual((String) r13.next(), r22.getFileIdentifier()) == false) goto L55;
        r6 = true;
    L59:
        if (r6 == false) goto L62;
        FLogger.a.i("NestedFileCacheManagerServiceImpl", "insertFile has been removed, localMsgID:" + r21 + ", fileIdentifier:" + r22.getFileIdentifier());
        return;
    L62:
        if (r4 == false) goto L64;
        o(r5).add(r22);
    L67:
        t0.e(new p(this, r21, r22));
        return;
    L64:
        List r7 = r5.getEntities();
        if (r7 == null) goto L67;
        r7.add(r22);
        goto L67
    L51:
        if (((Collection) r9).isEmpty() == false) goto L53;
    L21:
        r12 = false;
        goto L22
    L13:
        if (r10.isEmpty() == false) goto L15;
    L25:
        List r14 = r5.getEntities();
        if (r14 == null) goto L41;
        List r15 = r14;
        if ((r15 instanceof Collection) == true) goto L30;
    L32:
        Iterator r16 = r15.iterator();
    L34:
        if (r16.hasNext() == false) goto L38;
        if (Intrinsics.areEqual(((UplinkFileEntity) r16.next()).getFileIdentifier(), r22.getFileIdentifier()) == false) goto L34;
        boolean r17 = true;
    L39:
        if (r17 != true) goto L41;
        boolean r18 = true;
    L42:
        if (r18 == false) goto L45;
        FLogger.a.w("NestedFileCacheManagerServiceImpl", "insertFile exist, localMsgID:" + r21 + ", fileIdentifier:" + r22.getFileIdentifier());
        return;
    L38:
        r17 = false;
        goto L39
    L30:
        if (r15.isEmpty() == false) goto L32;
    L41:
        r18 = false;
        goto L42
    }

    public final void f(final String r14, lr8.d r15) {
        Intrinsics.checkNotNullParameter(r14, "localMsgID");
        Intrinsics.checkNotNullParameter(r15, "updateFileInfo");
        FLogger.a.i("NestedFileCacheManagerServiceImpl", "[updateFileUpLinkInfo], localMsgID:" + r14 + ", updateFileInfo:" + r15);
        final UplinkFileEntity r0 = a(r14, r15.a);
        if (r0 == null) goto L55;
        Integer r2 = null;
        Boolean r3 = null;
        if (n1.d(r0) == false) goto L30;
        r0.setInstantUploadInfoJson(r15.e);
        UplinkEntityContent r1 = r0.getUplinkEntityContent();
        if (r1 == null) goto L53;
        Image r4 = r1.getUplinkImageInfo();
        if (r4 == null) goto L53;
        r4.key = r15.c;
        r4.md5 = r15.b;
        lr8.b r5 = r15.f;
        if (r5 == null) goto L13;
        int r7 = r5.a;
    L14:
        if (r5 == null) goto L16;
        int r8 = r5.b;
    L17:
        ImageObj r6 = r4.imageOri;
        if (r6 == null) goto L20;
        String r10 = r6.format;
    L21:
        r4.imageOri = new ImageObj(null, r7, r8, null, r10, 9, null);
        r4.resourceId = r15.d;
        lr8.b r9 = r15.f;
        if (r9 == null) goto L24;
        Boolean r11 = r9.c;
    L25:
        r4.setMarked(r11);
        lr8.b r16 = r15.f;
        if (r16 == null) goto L28;
        r3 = r16.d;
    L28:
        r4.setCropped(r3);
        goto L53
    L24:
        r11 = null;
        goto L25
    L20:
        r10 = null;
        goto L21
    L16:
        r8 = 0;
        goto L17
    L13:
        r7 = 0;
    L53:
        t0.e(new n(this, r14, r0));
        return;
    L30:
        if (n1.c(r0) == false) goto L53;
        r0.setInstantUploadInfoJson(r15.e);
        UplinkEntityContent r12 = r0.getUplinkEntityContent();
        if (r12 == null) goto L53;
        UplinkFileInfo r13 = r12.getUplinkFileInfo();
        if (r13 == null) goto L53;
        r13.setMd5(r15.b);
        r13.setTosKey(r15.c);
        r13.setResourceId(r15.d);
        VideoExtension r17 = r13.getVideo();
        if (r17 == null) goto L53;
        lr8.h r18 = r15.g;
        if (r18 == null) goto L40;
        String r19 = r18.a;
    L41:
        r17.setVid(r19);
        lr8.h r20 = r15.g;
        if (r20 == null) goto L44;
        String r21 = r20.b;
    L45:
        r17.setFormat(r21);
        lr8.h r22 = r15.g;
        if (r22 == null) goto L48;
        Integer r23 = Integer.valueOf(r22.d);
    L49:
        r17.setWidth(r23);
        lr8.h r110 = r15.g;
        if (r110 == null) goto L52;
        r2 = Integer.valueOf(r110.c);
    L52:
        r17.setHeight(r2);
        goto L53
    L48:
        r23 = null;
        goto L49
    L44:
        r21 = null;
        goto L45
    L40:
        r19 = null;
        goto L41
    }

    public final void h(String r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        List r4 = (List) this.d.get(r2);
        if (r4 == null) goto L6;
        CollectionsKt.removeAll(r4, new i(r3));
        return;
    }

    public final void i(final String r6, final NestedFileContent r7) {
        Intrinsics.checkNotNullParameter(r6, "localMsgID");
        Intrinsics.checkNotNullParameter(r7, "content");
        FLogger r0 = FLogger.a;
        r0.i("NestedFileCacheManagerServiceImpl", "insertOrReplaceNestedFile, localMsgID:" + r6 + ", content:" + r7);
        boolean r1 = q();
        r0.i("NestedFileCacheManagerServiceImpl", "nested_file_cme_fix: use_concurrent=" + r1 + ", scene=insertOrReplaceNestedFile, localMsgID=" + r6);
        if (r1 == false) goto L5;
        o(r7);
    L5:
        this.a.put(r6, r7);
        t0.e(new o(this, r6, r7));
    }

    public final void k(final String r20, final UplinkFileEntity r21) {
        Intrinsics.checkNotNullParameter(r20, "localMsgID");
        Intrinsics.checkNotNullParameter(r21, "content");
        FLogger r3 = FLogger.a;
        r3.i("NestedFileCacheManagerServiceImpl", "replaceFile, localMsgID:" + r20 + ", content:" + r21);
        boolean r4 = q();
        r3.i("NestedFileCacheManagerServiceImpl", "nested_file_cme_fix: use_concurrent=" + r4 + ", scene=replaceFile, localMsgID=" + r20 + ", fileIdentifier=" + r21.getFileIdentifier());
        NestedFileContent r5 = b6(r20);
        if (r5 != null) goto L8;
        if (r4 == false) goto L6;
        r5 = new NestedFileContent(new CopyOnWriteArrayList(), null, false, null, 14, null);
    L7:
        this.a.put(r20, r5);
        goto L8
    L6:
        r5 = new NestedFileContent(new ArrayList(), null, false, null, 14, null);
    L8:
        if (r4 == false) goto L13;
        List r6 = o(r5);
        int r7 = p(r6, r21);
        if (r7 < 0) goto L26;
        ListProtector.remove(r6, r7);
        ListProtector.add(r6, r7, r21);
        t0.e(new f(this, r20, r21));
        return;
    L26:
        return;
    L13:
        List r8 = r5.getEntities();
        if (r8 == null) goto L16;
        int r9 = p(r8, r21);
    L17:
        if (r9 < 0) goto L27;
        List r10 = r5.getEntities();
        if (r10 == null) goto L21;
        UplinkFileEntity r11 = (UplinkFileEntity) ListProtector.remove(r10, r9);
    L21:
        List r12 = r5.getEntities();
        if (r12 == null) goto L24;
        ListProtector.add(r12, r9, r21);
    L24:
        t0.e(new j(this, r20, r21));
        return;
    L27:
        return;
    L16:
        r9 = -1;
        goto L17
    }

    public final void l(final String r4, UplinkFileEntity r5) {
        Intrinsics.checkNotNullParameter(r4, "localMsgID");
        Intrinsics.checkNotNullParameter(r5, "updateFileEntity");
        FLogger.a.i("NestedFileCacheManagerServiceImpl", "[updateFileUpLinkInfo], localMsgID:" + r4 + ", updateFileEntity:" + r5);
        String r0 = r5.getFileIdentifier();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        final UplinkFileEntity r1 = a(r4, r0);
        if (r1 == null) goto L9;
        r1.setUplinkEntityContent(r5.getUplinkEntityContent());
        r1.setUpLinkProcess(r5.getUpLinkProcess());
        r1.setUpLinkStatus(r5.getUpLinkStatus());
        r1.setFileReviewStatus(r5.getFileReviewStatus());
        r1.setFileParsedStatus(r5.getFileParsedStatus());
        r1.setExtra(r5.getExtra());
        t0.e(new m(this, r4, r1));
        return;
    }

    public final void n(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "localMsgID");
        Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
        List r0 = (List) this.d.get(r3);
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        this.d.put(r3, r0);
    L5:
        r0.add(r4);
        if (r0.size() <= 10) goto L9;
        ListProtector.remove(r0, 0);
        return;
    }

    public final void m(final String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "localMsgID");
        Intrinsics.checkNotNullParameter(r5, "fileIdentifier");
        FLogger.a.i("NestedFileCacheManagerServiceImpl", "updateFileUpLinkProcess, localMsgID:" + r4 + ", fileIdentifier:" + r5);
        final UplinkFileEntity r7 = a(r4, r5);
        if (r7 == null) goto L9;
        r7.setUpLinkProcess(Integer.valueOf(r6));
        if (r6 < 0) goto L7;
        r7.setUpLinkStatus(Integer.valueOf(UpLinkState.PROCESSING.getValue()));
    L7:
        t0.e(new l(this, r4, r7));
        return;
    }

    public final void d(final String r3, String r4, UpLinkState r5, FileReviewState r6, FileParseState r7, String r8) {
        Intrinsics.checkNotNullParameter(r3, "localMsgID");
        Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
        FLogger.a.i("NestedFileCacheManagerServiceImpl", "updateFileState, localMsgID:" + r3 + ", fileIdentifier:" + r4 + ", upLinkState:" + r5 + ", reviewState:" + r6 + ", parseState:" + r7);
        final UplinkFileEntity r9 = a(r3, r4);
        if (r9 == null) goto L15;
        if (r5 == null) goto L6;
        r9.setUpLinkStatus(Integer.valueOf(r5.getValue()));
    L6:
        if (r6 == null) goto L8;
        r9.setFileReviewStatus(Integer.valueOf(r6.getValue()));
    L8:
        if (r7 == null) goto L11;
        r9.setFileParsedStatus(Integer.valueOf(r7.getValue()));
    L11:
        if (r5 != UpLinkState.SUCCESS) goto L13;
        r9.setUpLinkProcess(100);
    L13:
        t0.e(new q(this, r3, r9));
        return;
    }
}
