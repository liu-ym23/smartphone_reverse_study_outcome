package com.obric.memorydata.memory.ui.feedback;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.bn;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.entity.dl;
import com.obric.memorydata.database.entity.es;
import com.obric.memorydata.database.entity.fa;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.memory.ui.list.MemoryTab;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0014\u001a\u00020\u0017H\u0002J,\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0002J \u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J.\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J.\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J9\u0010'\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010+J!\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010-J>\u0010.\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u001c\u00101\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000102\u0018\u00010\fH\u0002J \u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010#\u001a\u00020\u001d2\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u001dH\u0002J\b\u0010:\u001a\u00020\u001dH\u0002J\u0010\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u0005H\u0002J\f\u0010=\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010>\u001a\u00020\u0005*\u000208H\u0002J \u0010?\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001020\f*\u00020\u0015H\u0002J \u0010?\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001020\f*\u00020@H\u0002J \u0010?\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001020\f*\u00020AH\u0002J \u0010?\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001020\f*\u00020BH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackAttachmentProvider;", "", "<init>", "()V", "TAG", "", "DIR_NAME", "FILE_NAME", "ENTITY_JSON_FILE_NAME", "MAX_GENERATION_COUNT", "", "collectForMemoryItem", "", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", MemoryInfoSectionEditActivity.KIND_SCENE, "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackScene;", "readableDesc", "collectForMemoryItem$memory_obricRelease", "collectForScreenMemory", "entity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "collectForAudioMemory", "Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;", "collectEntityJsonAttachment", "entityJson", "Lorg/json/JSONObject;", "collectAdditionalAttachments", "Lkotlin/Function1;", "Ljava/io/File;", "", "collectForMemoryEntity", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "collectForCollectMemory", "outputDir", "tab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "collectForProfileMemory", "writeFeedbackMd", "rawDbId", "", "entityType", "(Ljava/io/File;Lcom/obric/memorydata/memory/ui/list/MemoryTab;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)Ljava/lang/String;", "queryTextVectorIndexText", "(Lcom/obric/memorydata/memory/ui/list/MemoryTab;Ljava/lang/Long;)Ljava/lang/String;", "writeCsv", "fileName", "tableName", "row", "Lkotlin/Pair;", "copySourceImageIfNeeded", "fileEntityJson", "copyContentUrl", "", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "targetFile", "createOutputDir", "cleanupOldGenerations", "excludeDirName", "csvEscape", "safeFileName", "toCsvRow", "Lcom/obric/memorydata/database/entity/ProactiveEpisodicRelevantData;", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "Lcom/obric/memorydata/database/entity/ProactiveSemanticRelevantData;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10935a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10936a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f10937b = null;

        static {
            int[] r0 = new int[MemoryFeedbackAttachmentType.values().length];
            r0[MemoryFeedbackAttachmentType.SCREEN_ENTITY_JSON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[MemoryFeedbackAttachmentType.AUDIO_ENTITY_JSON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L29:
            r0[MemoryFeedbackAttachmentType.COLLECTION_OR_PROFILE_LEGACY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L23:
            r0[MemoryFeedbackAttachmentType.AUTO_MEMORY_PRO_PACKAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L8:
            f10936a = r0;
            int[] r1 = new int[MemoryTab.values().length];
            r1[MemoryTab.COLLECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[MemoryTab.PROFILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L11:
            f10937b = r1;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.memorydata.plugin")).lastModified()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin")).lastModified()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f10935a = new e();
    }

    private e() {
    }

    private final File a() {
        File r4 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "memory_feedback");
        r4.mkdirs();
        File r0 = new File(r4, "memory_feedback_" + System.currentTimeMillis());
        if (r0.exists() == false) goto L5;
        FilesKt.deleteRecursively(r0);
    L5:
        r0.mkdirs();
        return r0;
    }

    private static final CharSequence a(cd r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast("buildType: " + r2.i() + " columnContent: " + r2.h(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(com.obric.memorydata.database.entity.h r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3.b() + ' ' + r3.c() + '\n' + r3.d(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(Object r2) {
        e r0 = f10935a;
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L6:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0.b(r3), CharSequence.class, "com.obric.memorydata.plugin");
    L5:
        r3 = null;
        goto L6
    }

    private final String a(FileEntity r3) {
        String r2 = r3.getFileName();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L11;
        r2 = r3.getContentUrl().getLastPathSegment();
        if (r2 != null) goto L11;
        r2 = "source_image";
    L11:
        return new Regex("[^A-Za-z0-9._-]").replace((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), "_");
    }

    private final String a(MemoryTab r12, Long r13) {
        if (r13 != null) goto L5;
        return null;
    L5:
        int r14 = a.f10937b[r12.ordinal()];
        boolean r0 = true;
        if (r14 != 1) goto L8;
        List<bn> r15 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryTextVectorCopilotDao().queryByRawDbId(r13.longValue());
    L12:
        String r16 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$lhKnm2mIbsQaWiVFSHeQd4mgqY.INSTANCE, 30, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L16;
        r0 = false;
    L16:
        if (r0 == true) goto L18;
        return null;
    L18:
        return r16;
    L8:
        if (r14 == 2) goto L10;
        r15 = CollectionsKt.emptyList();
        goto L12
    L10:
        r15 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticTextCopilotDao().queryByRawDbId(r13.longValue());
        goto L12
    }

    private final String a(File r16, MemoryTab r17, String r18, Long r19, Integer r20) {
        StringBuilder r1 = new StringBuilder();
        r1.append(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_feedback_content_prefix, TypedValues.Custom.S_STRING, "memory_feedback_content_prefix"))).append(" ").append(r18).append("\n\n");
        r1.append("是否在索引Pending表中 ");
        if (r19 == null) goto L6;
        if (r20 == null) goto L6;
        List<cd> r2 = com.obric.memorydata.database.manager.c.f9561a.b(r20.intValue()).queryIndexed(r19.longValue(), r20.intValue());
    L7:
        r1.append(!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()).append("\n\n");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L10;
        r1.append("pending detail: ").append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$VdnweyBgyh8ZoYrwtPAckxnVQ1E.INSTANCE, 30, null)).append("\n\n");
    L10:
        String r3 = a(r17, r19);
        if (r3 == null) goto L13;
        StringBuilder r4 = r1.append("索引成功，内容：\n").append(r3);
    L14:
        r4.append("\n\n");
        if (r19 == null) goto L18;
        if (r20 == null) goto L18;
        List<dl> r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaFullContentKeywordCopilotDao().queryByRawDbIdAndEntityType(r19.longValue(), r20.intValue());
    L19:
        r1.append("关键词索引是否成功 ").append(!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()).append("\n\n");
        File r5 = new File(r16, "feedback.md");
        String r6 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        FilesKt.writeText$default(r5, r6, null, 2, null);
        String r7 = r5.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r7, "getAbsolutePath(...)");
        return r7;
    L18:
        r0 = CollectionsKt.emptyList();
        goto L19
    L13:
        r4 = r1.append("未生成文本向量");
    L6:
        r2 = CollectionsKt.emptyList();
        goto L7
    }

    private final String a(File r26, String r27, String r28, List<? extends Pair<String, ? extends Object>> r29) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
        File r2 = new File(r26, r27);
        if (r0 == null) goto L9;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        r5.add((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), String.class, "com.obric.memorydata.plugin"));
        goto L6
    L8:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    L11:
        if (r0 == null) goto L17;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r1.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        r3.add(((Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond());
        goto L14
    L16:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L18:
        StringBuilder r10 = new StringBuilder();
        r10.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$rQWyuOjwcslKCJryForj3e9MjIM.INSTANCE, 30, null)).append("\n");
        r10.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$3RK6CWKySLkX4Jp1y3LiCzxYmY.INSTANCE, 30, null)).append("\n");
        String r11 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        FilesKt.writeText$default(r2, r11, null, 2, null);
        String r12 = r2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r12, "getAbsolutePath(...)");
        return r12;
    L17:
        r9 = CollectionsKt.listOf(new Object[]{r28, false});
        goto L18
    L9:
        r7 = CollectionsKt.listOf(new String[]{"table", "row_found"});
        goto L11
    }

    private final List<String> a(MemoryEntity r6, String r7) {
        MemoryTab r0 = com.obric.memorydata.memory.utils.f.f11537a.a((AppEntity) ZeusTransformUtils.preCheckCast(r6, AppEntity.class, "com.obric.memorydata.plugin"));
        if (r0 != MemoryTab.COLLECT) goto L5;
    L7:
        File r1 = a();
        int r3 = a.f10937b[r0.ordinal()];
        if (r3 != 1) goto L10;
        List<String> r8 = a(r1, r6, r0, r7);
    L15:
        if (r8.isEmpty() == false) goto L17;
        return null;
    L17:
        String r9 = r1.getName();
        Intrinsics.checkNotNullExpressionValue(r9, "getName(...)");
        a(r9);
        RunLog.INSTANCE.debug("MemoryFeedbackAttachment", "generate feedback attachment success: " + r1.getAbsolutePath());
        return CollectionsKt.listOf(r1.getAbsolutePath());
    L10:
        if (r3 == 2) goto L12;
        r8 = CollectionsKt.emptyList();
        goto L15
    L12:
        r8 = b(r1, r6, r0, r7);
        goto L15
    L5:
        if (r0 == MemoryTab.PROFILE) goto L7;
        return null;
    }

    private final List<String> a(final EpisodicMemoryEntity r3) {
        return a(g.f10949a.a(r3), new $$Lambda$e$e8yI3swlfiWBW4I4oM4t8PVlqbw(r3));
    }

    private final List<Pair<String, Object>> a(es r3) {
        return CollectionsKt.listOf(new Pair[]{TuplesKt.to(OaidModel.KEY_ID, Long.valueOf(r3.a())), TuplesKt.to("episodic_id", r3.b()), TuplesKt.to("source_query", r3.c()), TuplesKt.to("source_text", r3.d()), TuplesKt.to("source_link", r3.e()), TuplesKt.to("source_link_type", r3.f()), TuplesKt.to("screenshot", r3.g()), TuplesKt.to("source_package_name", r3.h()), TuplesKt.to("source_app_name", r3.i()), TuplesKt.to("product_type", Integer.valueOf(r3.j())), TuplesKt.to(EventBody.KEY_CATEGORY, r3.k()), TuplesKt.to("tag_list", r3.l()), TuplesKt.to("summary", r3.m()), TuplesKt.to("detail_status", Integer.valueOf(r3.n()))});
    }

    private final List<Pair<String, Object>> a(fa r3) {
        return CollectionsKt.listOf(new Pair[]{TuplesKt.to(OaidModel.KEY_ID, Long.valueOf(r3.a())), TuplesKt.to("semantic_id", r3.b()), TuplesKt.to("source_query", r3.c()), TuplesKt.to("source_text", r3.d()), TuplesKt.to("source_screenshot", r3.e()), TuplesKt.to("source_app_name", r3.f()), TuplesKt.to("source_package_name", r3.g()), TuplesKt.to("detail_status", Integer.valueOf(r3.h())), TuplesKt.to("product_type", Integer.valueOf(r3.i()))});
    }

    private final List<String> a(fj r3) {
        String r0 = n.f10961a.a(r3.g());
        return a(this, g.f10949a.a(r3, r0), null, 2, null);
    }

    private final List<Pair<String, Object>> a(ip r3) {
        return CollectionsKt.listOf(new Pair[]{TuplesKt.to(OaidModel.KEY_ID, Long.valueOf(r3.getId())), TuplesKt.to("entityId", r3.getEntityId()), TuplesKt.to("createTime", Long.valueOf(r3.getCreateTime())), TuplesKt.to("modifyTime", Long.valueOf(r3.getModifyTime())), TuplesKt.to("type", Integer.valueOf(r3.getType())), TuplesKt.to("timestamp", Long.valueOf(r3.getTimestamp())), TuplesKt.to(ObricMemoryConstants.KEY_PACKAGE_NAME, r3.getPackageName()), TuplesKt.to("hashCodeValue", Integer.valueOf(r3.getHashCodeValue())), TuplesKt.to(Api.KEY_UUID, r3.getUuid()), TuplesKt.to("semantic_type", r3.a()), TuplesKt.to("tag_path", r3.b()), TuplesKt.to("key_phrase", r3.c()), TuplesKt.to("description", r3.d()), TuplesKt.to("embedding_content", r3.e()), TuplesKt.to("sources", r3.f()), TuplesKt.to("user_edit", Boolean.valueOf(r3.g())), TuplesKt.to("evidence_count", Integer.valueOf(r3.h())), TuplesKt.to("product_type", Integer.valueOf(r3.i())), TuplesKt.to("use_for_insight", Boolean.valueOf(r3.j())), TuplesKt.to("confidence", Float.valueOf(r3.l())), TuplesKt.to("logId", r3.m())});
    }

    private static final List a(MemoryFeedbackScene r3, com.obric.memorydata.memory.ui.data.a r4, String r5) {
        int r6 = a.f10936a[r3.getAttachmentType().ordinal()];
        if (r6 == 1) goto L29;
        if (r6 == 2) goto L23;
        if (r6 == 3) goto L14;
        if (r6 != 4) goto L12;
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L17;
        MemoryEntity r7 = ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b();
    L20:
        if (r7 != null) goto L36;
        return null;
    L36:
        return f10935a.a(r7, r5);
    L17:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L19;
        r7 = ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b();
        goto L20
    L19:
        r7 = null;
        goto L20
    L23:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L25;
        com.obric.memorydata.memory.ui.data.a.C0539a r8 = (com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin");
    L26:
        if (r8 != null) goto L38;
        return null;
    L38:
        return f10935a.a(r8.b());
    L25:
        r8 = null;
        goto L26
    L29:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L31;
        com.obric.memorydata.memory.ui.data.a.i r9 = (com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin");
    L32:
        if (r9 != null) goto L34;
        return null;
    L34:
        return f10935a.a(r9.b());
    L31:
        r9 = null;
        goto L32
    }

    static /* synthetic */ List a(e r1, JSONObject r2, Function1 r3, int r4, Object r5) {
        Function1<? super File, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r6 = $$Lambda$e$fAYGeDuL218XZwuRS9qYhdaFUQI.INSTANCE;
    L6:
        return r1.a(r2, r6);
    }

    private static final List a(File r3, FileEntity r4) {
        File r0 = new File(r3, "images");
        r0.mkdirs();
        e r1 = f10935a;
        File r5 = new File(r0, r1.a(r4));
        if (r1.a(r4, r5) == false) goto L6;
        return CollectionsKt.listOf(r5.getAbsolutePath());
    L6:
        return CollectionsKt.emptyList();
    }

    private final List<String> a(File r11, MemoryEntity r12, MemoryTab r13, String r14) {
        EpisodicMemoryEntity r15 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r12.getId());
        Integer r0 = null;
        if (r15 == null) goto L5;
        es r2 = (es) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveEpisodicRelevantDataDao().queryByEpisodicId(r15.getEntityId())), es.class, "com.obric.memorydata.plugin");
    L6:
        List<String> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L9;
        List<Pair<String, Object>> r5 = b(r15);
    L10:
        r4.add(a(r11, "raw_table.csv", "ShortMemory", r5));
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
        List<Pair<String, Object>> r7 = a(r2);
    L14:
        r6.add(a(r11, "relevant_table.csv", "ProactiveEpisodicRelevantData", r7));
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L17;
        String r9 = r2.g();
    L18:
        CollectionsKt.addAll(r8, (Iterable) ZeusTransformUtils.preCheckCast(a(r11, r9), Iterable.class, "com.obric.memorydata.plugin"));
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L21;
        Long r10 = Long.valueOf(r15.getId());
    L22:
        if (r15 == null) goto L24;
        r0 = Integer.valueOf(r15.getType());
    L24:
        r1.add(a(r11, r13, r14, r10, r0));
        return r3;
    L21:
        r10 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private final List<String> a(final File r2, String r3) {
        final FileEntity r1 = com.obric.memorydata.personalcontext.util.f.c(r3);
        if (r1 == null) goto L5;
        List<String> r4 = (List) ZeusTransformUtils.preCheckCast(y.a($$Lambda$e$auljBuG1br5DpupPYmbsnx0zZ0Y.INSTANCE, new $$Lambda$e$LmD3bwPbIWr5ODWCw_Cx_pxgU3c(r2, r1)), List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        return r4;
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    private static final List a(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        RunLog.INSTANCE.error("MemoryFeedbackAttachment", "collect feedback attachment failed", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    private final List<String> a(JSONObject r5, Function1<? super File, Unit> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        File r0 = a();
        File r1 = new File(r0, "entity.json");
        String r8 = r5.toString(2);
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
        FilesKt.writeText$default(r1, r8, null, 2, null);
        r7.invoke(r0);
        String r9 = r0.getName();
        Intrinsics.checkNotNullExpressionValue(r9, "getName(...)");
        a(r9);
        RunLog.INSTANCE.debug("MemoryFeedbackAttachment", "generate entity json feedback attachment success: " + r0.getAbsolutePath());
        return CollectionsKt.listOf(r0.getAbsolutePath());
    }

    private static final Unit a(EpisodicMemoryEntity r1, File r2) {
        Intrinsics.checkNotNullParameter(r2, "outputDir");
        m.f10959a.a(r2, r1);
        return Unit.INSTANCE;
    }

    private static final Unit a(File r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private final void a(final String r4) {
        File[] r3 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "memory_feedback").listFiles(new $$Lambda$e$Vuzda0pJAUBpBIgimn_Gennhy8(r4));
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.length > 5) goto L8;
        return;
    L8:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.sortedWith(r3, (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), r3.length - 5), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        File r6 = (File) ZeusTransformUtils.preCheckCast(r5.next(), File.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r6);
        FilesKt.deleteRecursively(r6);
        goto L10
    }

    private final boolean a(FileEntity r11, File r12) {
        Uri r10 = r11.getContentUrl();
        String r0 = r10.getPath();
        String r1 = null;
        if (r0 == null) goto L5;
        File r3 = new File(r0);
    L7:
        if (r10.getScheme() != null) goto L9;
    L10:
        if (r3 != null) goto L12;
    L14:
        boolean r13 = false;
    L15:
        if (r13 == false) goto L18;
        FilesKt.copyTo$default(r3, r12, true, 0, 4, null);
        return true;
    L18:
        UriFileAccessSession r14 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryFeedbackAttachmentProvider$copyContentUrl$accessSession$1(r11, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), UriFileAccessSession.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L21;
        AssetFileDescriptor r15 = r14.getFd();
    L22:
        if (r15 != null) goto L32;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder().append("open source image failed, status: ");
        if (r14 == null) goto L26;
        Integer r17 = Integer.valueOf(r14.getStatus());
    L27:
        StringBuilder r18 = r16.append(r17).append(", message: ");
        if (r14 == null) goto L30;
        r1 = r14.getMessage();
    L30:
        IRunLog.a.a(r4, "MemoryFeedbackAttachment", r18.append(r1).toString(), null, 4, null);
        return false;
    L26:
        r17 = null;
        goto L27
    L32:
        Closeable r19 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.memorydata.plugin");
        Closeable r110 = (Closeable) ZeusTransformUtils.preCheckCast(((AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r19, AssetFileDescriptor.class, "com.obric.memorydata.plugin")).createInputStream(), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        FileInputStream r5 = (FileInputStream) ZeusTransformUtils.preCheckCast(r110, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        Closeable r111 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r12), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        FileOutputStream r6 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r111, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L40
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r5, InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r6, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L40
        CloseableKt.closeFinally(r111, null);     // Catch: Throwable -> L45
        CloseableKt.closeFinally(r110, null);     // Catch: Throwable -> L50
        CloseableKt.closeFinally(r19, null);
        return true;
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r111, th);     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        CloseableKt.closeFinally(r110, th);     // Catch: Throwable -> L50
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        CloseableKt.closeFinally(r19, th);
        throw th;
    L21:
        r15 = null;
        goto L22
    L12:
        if (r3.exists() != true) goto L14;
        r13 = true;
        goto L15
    L9:
        if (Intrinsics.areEqual(r10.getScheme(), "file") == false) goto L18;
    L5:
        r3 = null;
        goto L7
    }

    private static final boolean a(String r5, File r6) {
        if (r6.isDirectory() == false) goto L10;
        String r0 = r6.getName();
        Intrinsics.checkNotNullExpressionValue(r0, "getName(...)");
        if (StringsKt.startsWith$default(r0, "memory_feedback_", false, 2, null) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r6.getName(), r5) == true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private final String b(String r8) {
        return Typography.quote + StringsKt.replace$default(r8, "\"", "\"\"", false, 4, null) + Typography.quote;
    }

    private final List<Pair<String, Object>> b(EpisodicMemoryEntity r3) {
        return CollectionsKt.listOf(new Pair[]{TuplesKt.to(OaidModel.KEY_ID, Long.valueOf(r3.getId())), TuplesKt.to("actionTimestamp", Long.valueOf(r3.getActionTimestamp())), TuplesKt.to("uid", Long.valueOf(r3.getUid())), TuplesKt.to("title", r3.getTitle()), TuplesKt.to(Params.CONTENT, r3.getContent()), TuplesKt.to("contentWithTime", r3.getContentWithTime()), TuplesKt.to("fullContent", r3.getFullContent()), TuplesKt.to("observation", r3.getObservation()), TuplesKt.to("location", r3.getLocation()), TuplesKt.to("appNames", r3.getAppNames()), TuplesKt.to(EventBody.KEY_CATEGORY, r3.getCategory()), TuplesKt.to("profileType", r3.getProfileType()), TuplesKt.to("profileTag", r3.getProfileTag()), TuplesKt.to("tagOther", r3.getTagOther()), TuplesKt.to("logId", r3.getLogId()), TuplesKt.to("usedForPortrait", r3.getUsedForPortrait()), TuplesKt.to("useLocation", r3.getUseLocation()), TuplesKt.to("useForUserKeyword", Boolean.valueOf(r3.getUseForUserKeyword())), TuplesKt.to("startTimestamp", Long.valueOf(r3.getStartTimestamp())), TuplesKt.to("endTimestamp", Long.valueOf(r3.getEndTimestamp())), TuplesKt.to("useForTopic", r3.getUseForTopic()), TuplesKt.to("entityId", r3.getEntityId()), TuplesKt.to("createTime", Long.valueOf(r3.getCreateTime())), TuplesKt.to("modifyTime", Long.valueOf(r3.getModifyTime())), TuplesKt.to("type", Integer.valueOf(r3.getType())), TuplesKt.to("timestamp", Long.valueOf(r3.getTimestamp())), TuplesKt.to(ObricMemoryConstants.KEY_PACKAGE_NAME, r3.getPackageName()), TuplesKt.to("hashCodeValue", Integer.valueOf(r3.getHashCodeValue())), TuplesKt.to(Api.KEY_UUID, r3.getUuid()), TuplesKt.to("userEdit", r3.getUserEdit()), TuplesKt.to("productType", Integer.valueOf(r3.getProductType()))});
    }

    private final List<String> b(File r11, MemoryEntity r12, MemoryTab r13, String r14) {
        ip r15 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityId(r12.getId());
        Integer r0 = null;
        if (r15 == null) goto L5;
        fa r2 = (fa) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveSemanticRelevantDataDao().queryByMemoryId(r15.getEntityId())), fa.class, "com.obric.memorydata.plugin");
    L6:
        List<String> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L9;
        List<Pair<String, Object>> r5 = a(r15);
    L10:
        r4.add(a(r11, "raw_table.csv", "UnionSemanticMemory", r5));
        if (r2 == null) goto L13;
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        e r7 = f10935a;
        r6.add(r7.a(r11, "relevant_table.csv", "ProactiveSemanticRelevantData", r7.a(r2)));
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r7.a(r11, r2.e()), Iterable.class, "com.obric.memorydata.plugin"));
    L13:
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L16;
        Long r8 = Long.valueOf(r15.getId());
    L17:
        if (r15 == null) goto L19;
        r0 = Integer.valueOf(r15.getType());
    L19:
        r1.add(a(r11, r13, r14, r8, r0));
        return r3;
    L16:
        r8 = null;
        goto L17
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private static final List b(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        RunLog.INSTANCE.error("MemoryFeedbackAttachment", "copy source image failed", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.emptyList();
    }

    private static final CharSequence c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(f10935a.b(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$3RK6CWKySLkX4Jp1y3L-iCzxYmY, reason: not valid java name */
    public static /* synthetic */ CharSequence m856lambda$3RK6CWKySLkX4Jp1y3LiCzxYmY(Object r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$FSiD_j9wU9qUbmfvPdRg-407niM, reason: not valid java name */
    public static /* synthetic */ List m857lambda$FSiD_j9wU9qUbmfvPdRg407niM(MemoryFeedbackScene r0, com.obric.memorydata.memory.ui.data.a r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ List lambda$KwZZ3xbk6KdvLnntdMVP5hgyYhc(Exception r0) {
        return a(r0);
    }

    public static /* synthetic */ List lambda$LmD3bwPbIWr5ODWCw_Cx_pxgU3c(File r0, FileEntity r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$VdnweyBgyh8ZoYrwtPAckxnVQ1E(cd r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$Vuzda0pJAUBpBIgimn_Gen-nhy8, reason: not valid java name */
    public static /* synthetic */ boolean m858lambda$Vuzda0pJAUBpBIgimn_Gennhy8(String r0, File r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ List lambda$auljBuG1br5DpupPYmbsnx0zZ0Y(Exception r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$e8yI3swlfiWBW4I4oM4t8PVlqbw(EpisodicMemoryEntity r0, File r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$fAYGeDuL218XZwuRS9qYhdaFUQI(File r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$lhKnm2mIbsQaWi-VFSHeQd4mgqY, reason: not valid java name */
    public static /* synthetic */ CharSequence m859lambda$lhKnm2mIbsQaWiVFSHeQd4mgqY(com.obric.memorydata.database.entity.h r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$rQWyuOjwcslKCJryForj3e9MjIM(String r0) {
        return c(r0);
    }

    public final List<String> a(final com.obric.memorydata.memory.ui.data.a r2, final MemoryFeedbackScene r3, final String r4) {
        Intrinsics.checkNotNullParameter(r2, "memoryItem");
        Intrinsics.checkNotNullParameter(r3, MemoryInfoSectionEditActivity.KIND_SCENE);
        Intrinsics.checkNotNullParameter(r4, "readableDesc");
        return (List) ZeusTransformUtils.preCheckCast(y.a($$Lambda$e$KwZZ3xbk6KdvLnntdMVP5hgyYhc.INSTANCE, new $$Lambda$e$FSiD_j9wU9qUbmfvPdRg407niM(r3, r2, r4)), List.class, "com.obric.memorydata.plugin");
    }
}
