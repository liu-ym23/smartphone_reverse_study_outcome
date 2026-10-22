package com.obric.memorydata.personalcontext;

import android.net.Uri;
import com.bytedance.crash.Ensure;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.index.ao;
import com.obric.memorydata.database.index.t;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.EntityVideoExtractHelper;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/personalcontext/VlmEmbeddingIndexUpdateHelper;", "", "<init>", "()V", "TAG", "", "isDoneCache", "", "isAddPendingRefreshTask", "refreshEmbeddingVectorUpdateTaskDoneAfterTwentySeconds", "", "updateImageVector", "entityType", "", "rawDbId", "", "updateTextVector", "insertVideoFrameEntity", "videoFrameEntity", "Lcom/obric/memorydata/database/entity/AbstractVideoFrameEntity;", "copilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "vectorTableName", "pictureToVector", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "uri", "Landroid/net/Uri;", "textEmbeddingToVector", "sentence", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f12268a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12269b;
    private static boolean c;

    static {
        f12268a = new s();
    }

    private s() {
    }

    private final boolean a(com.obric.memorydata.database.entity.j r19, com.obric.memorydata.database.entity.i r20, String r21) {
        String r0 = r20.c();
        long r1 = r19.getId();
        int r3 = r19.getType();
        if (Intrinsics.areEqual(r0, "file") == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "failed to updateImageVector, video frame column must be \"file\", rawDbId: " + r1 + ", entityType: " + r3, null, 4, null);
        return true;
    L6:
        long r8 = r19.c();
        String r4 = r19.g();
        if (r4 != null) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "failed to updateImageVector, video frame time or file entity json is null, rawDbId: " + r1 + ", entityType: " + r3, null, 4, null);
        return true;
    L11:
        if (r8 >= 0) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "failed to updateImageVector, video frame time must be >= 0, rawDbId: " + r1 + ", entityType: " + r3, null, 4, null);
        return true;
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "embeddingVideoFrame id: " + r19.getEntityId() + " type: " + r19.getType() + " column: " + r0, false, 4, null);
        long r10 = System.currentTimeMillis();
        FileEntity r2 = com.obric.memorydata.personalcontext.util.f.b(r4);
        if (Intrinsics.areEqual(t.f9438a.a(r2.getMimeType()), "video") == true) goto L18;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "embeddingVideoFrame id: " + r19.getEntityId() + " mimeType: " + r2.getMimeType() + " not supported", null, 4, null);
        return true;
    L18:
        Uri r5 = EntityVideoExtractHelper.INSTANCE.extractFrame(r19.getPackageName(), r2.getContentUrl(), r8);
        if (r5 != null) goto L32;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "embeddingVideoFrame id: " + r19.getEntityId() + " pic is null", null, 4, null);
        return false;
    L32:
        float[] r16 = a("", r5);     // Catch: Throwable -> L29
        EntityVideoExtractHelper.INSTANCE.deleteTempPicPath(r5);
        if (r16 != null) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "embeddingVideoFrame id: " + r19.getEntityId() + " vector is null", null, 4, null);
        return false;
    L27:
        t.f9438a.a(r21, r20.a(), r16, true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "embeddingVideoFrame success, id: " + r19.getEntityId() + " type: " + r19.getType() + " column: " + r0 + " cost: " + (System.currentTimeMillis() - r10), false, 4, null);
        return true;
    L29:
        th = move-exception;
        EntityVideoExtractHelper.INSTANCE.deleteTempPicPath(r5);
        throw th;
    }

    private static final float[] a(Uri r2, String r3) {
        return (float[]) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new VlmEmbeddingIndexUpdateHelper$pictureToVector$1$1(r2, r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), float[].class, "com.obric.memorydata.plugin");
    }

    private final float[] a(final String r2) {
        return (float[]) ZeusTransformUtils.preCheckCast(ao.f9372a.a(new $$Lambda$s$CYWGb5TPaxr1ae0GT95VBdY333Y(r2)), float[].class, "com.obric.memorydata.plugin");
    }

    private final float[] a(final String r2, final Uri r3) {
        return (float[]) ZeusTransformUtils.preCheckCast(ao.f9372a.a(new $$Lambda$s$wNo_jRdcfM9RcXwNavb5m389e1I(r3, r2)), float[].class, "com.obric.memorydata.plugin");
    }

    private static final void b() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "refreshEmbeddingVectorUpdateTaskDoneAfterTenSeconds", false, 4, null);
        t.f9438a.a(true);
        c = false;
    }

    private static final float[] b(String r3) {
        return (float[]) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new VlmEmbeddingIndexUpdateHelper$textEmbeddingToVector$1$1(r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), float[].class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ float[] lambda$CYWGb5TPaxr1ae0GT95VBdY333Y(String r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$hph3omkQtV-cNQ9fGa8kLP8hkl0, reason: not valid java name */
    public static /* synthetic */ void m1087lambda$hph3omkQtVcNQ9fGa8kLP8hkl0() {
        b();
    }

    public static /* synthetic */ float[] lambda$wNo_jRdcfM9RcXwNavb5m389e1I(Uri r0, String r1) {
        return a(r0, r1);
    }

    public final synchronized void a() {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L4:
        if (t.f9438a.b() == false) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", "isDisableRefreshVlmVectorUpdateState is true, refreshEmbeddingVectorUpdateTaskDoneAfterTwentySeconds end", false, 4, null);     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L9:
        if (f12269b == false) goto L13;
        monitor-exit(this);
        return;
    L13:
        if (t.f9438a.c() == false) goto L18;
        f12269b = true;     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L18:
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("check_existing_data_embedding_vector_update_task", false) == true) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "refreshEmbeddingVectorUpdateTaskDoneAfterTenSeconds, isFinishInsertTask is false", false, 4, null);     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L23:
        if (c == false) goto L26;
        monitor-exit(this);
        return;
    L26:
        c = true;     // Catch: Throwable -> L29
        GlobalHandlerUtil.Companion.getInstance().postDelay(20000, $$Lambda$s$hph3omkQtVcNQ9fGa8kLP8hkl0.INSTANCE);     // Catch: Throwable -> L29
        monitor-exit(this);
    }

    public final boolean a(int r22, long r23) {
        IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r3 = com.obric.memorydata.database.index.s.a().getImageVectorCopilotDao(r22);
        boolean r4 = true;
        if (r3 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "failed to updateImageVector, imageVectorCopilotDao is null, entityType: " + r22, null, 4, null);
        return true;
    L6:
        List<T> r6 = r3.queryByRawDbId(r23);
        if (r6.isEmpty() == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "imageVectorCopilotEntities is empty, no need to update, rawDbId: " + r23 + ", entityType: " + r22, false, 4, null);
        return true;
    L10:
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r7 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(r22);
        if (r7 != null) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "failed to updateImageVector, rawDbDao is null, entityType: " + r22, null, 4, null);
        return true;
    L14:
        com.obric.memorydata.database.entity.d r8 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r7.queryById(r23), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "failed to updateImageVector, entity is null, rawDbId: " + r23 + ", entityType: " + r22, false, 4, null);
        return true;
    L18:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r9.hasNext() == false) goto L53;
        com.obric.memorydata.database.entity.i r10 = (com.obric.memorydata.database.entity.i) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.memorydata.database.entity.i.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L20;
        String r11 = r10.c();
        if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.database.entity.j.class) == true) goto L26;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.database.entity.g.class) == false) goto L32;
        if (Intrinsics.areEqual(((com.obric.memorydata.database.entity.g) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.database.entity.g.class, "com.obric.memorydata.plugin")).b(), "VIDEO") == false) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "updateImageVector, video class data, rawDbId: " + r23 + ", entityType: " + r22, false, 4, null);
    L32:
        com.obric.memorydata.database.index.e r12 = (com.obric.memorydata.database.index.e) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.index.s.a().getEntityIndexImplMap().get(Integer.valueOf(r22)), com.obric.memorydata.database.index.e.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L35;
        Object r13 = r12.getValueByColumn(r8, r11);
    L36:
        String r15 = "";
        if (ZeusTransformUtils.instanceOf(r13, String.class) == false) goto L39;
        FileEntity r14 = com.obric.memorydata.personalcontext.util.f.c((String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin"));
        if (r14 == null) goto L46;
        float[] r19 = f12268a.a(r8.getPackageName(), r14.getContentUrl());
        if (r19 == null) goto L51;
        t.f9438a.a(r3.getTableName(), r10.a(), r19, true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "embeddingPicture success, rawDbId: " + r23 + ", entityType: " + r22 + ", columnName: " + r11, false, 4, null);
        goto L20
    L51:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "pictureToVector return null, rawDbId: " + r23 + ", entityType: " + r22 + ", columnName: " + r11, null, 4, null);
        r4 = false;
        goto L20
    L46:
        if (AppContext.INSTANCE.isDebug() == false) goto L48;
        r15 = ", filedValue: " + ((String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin"));
    L48:
        StringBuilder r16 = new StringBuilder();
        String r17 = "fileEntity convert from json is null, rawDbId: ";
    L42:
        String r18 = r16.append(r17).append(r23).append(", entityType: ").append(r22).append(", columnName: ").append(r11).append(' ').append(r15).toString();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", r18, null, 4, null);
        Ensure.ensureNotReachHere(r18);
        goto L20
    L39:
        if (AppContext.INSTANCE.isDebug() == false) goto L41;
        r15 = ", filedValue: " + r13;
    L41:
        r16 = new StringBuilder();
        r17 = "filedValue is not String, rawDbId: ";
        goto L42
    L35:
        r13 = null;
        goto L36
    L26:
        r4 = f12268a.a((com.obric.memorydata.database.entity.j) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.database.entity.j.class, "com.obric.memorydata.plugin"), r10, r3.getTableName());
        goto L20
    L53:
        return r4;
    }

    public final boolean b(int r20, long r21) {
        IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r3 = com.obric.memorydata.database.index.s.a().getTextVectorCopilotDao(r20);
        if (r3 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "failed to updateTextVector, textVectorCopilotDao is null, entityType: " + r20, null, 4, null);
        return true;
    L6:
        List<T> r6 = r3.queryByRawDbId(r21);
        if (r6.isEmpty() == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "textVectorCopilotEntities is empty, no need to update, rawDbId: " + r21 + ", entityType: " + r20, false, 4, null);
        return true;
    L10:
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r7 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(r20);
        if (r7 != null) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "failed to updateImageVector, rawDbDao is null, entityType: " + r20, null, 4, null);
        return true;
    L15:
        if (((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r7.queryById(r21), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")) != null) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "failed to updateImageVector, entity is null, rawDbId: " + r21 + ", entityType: " + r20, false, 4, null);
        return true;
    L18:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r9 = true;
    L20:
        if (r8.hasNext() == false) goto L38;
        com.obric.memorydata.database.entity.i r10 = (com.obric.memorydata.database.entity.i) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.memorydata.database.entity.i.class, "com.obric.memorydata.plugin");
        if (r9 == false) goto L20;
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.database.entity.h.class) == false) goto L26;
        String r11 = ((com.obric.memorydata.database.entity.h) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.database.entity.h.class, "com.obric.memorydata.plugin")).d();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L30;
        boolean r12 = true;
    L31:
        if (r12 == true) goto L32;
        float[] r17 = f12268a.a(r11);
        if (r17 != null) goto L37;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", "textToVector return null, rawDbId: " + r21 + ", entityType: " + r20, null, 4, null);
        r9 = false;
        goto L20
    L37:
        t.f9438a.a(r3.getTableName(), ((com.obric.memorydata.database.entity.h) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.database.entity.h.class, "com.obric.memorydata.plugin")).a(), r17, true);
        IRunLog r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r14 = new StringBuilder();
        String r15 = "embeddingText success, rawDbId: ";
    L33:
        IRunLog.a.a(r13, "VlmEmbeddingIndexUpdateHelper", r14.append(r15).append(r21).append(", entityType: ").append(r20).toString(), false, 4, null);
        goto L20
    L32:
        r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r14 = new StringBuilder();
        r15 = "textValue is empty, no need to update, rawDbId: ";
        goto L33
    L30:
        r12 = false;
        goto L31
    L26:
        String r16 = "textVectorCopilotEntity is not AbstractTextVectorCopilotEntity, rawDbId: " + r21 + ", entityType: " + r20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VlmEmbeddingIndexUpdateHelper", r16, null, 4, null);
        Ensure.ensureNotReachHere(r16);
        goto L20
    L38:
        return r9;
    }
}
