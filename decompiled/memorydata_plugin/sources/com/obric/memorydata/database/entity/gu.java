package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.keva.KevaImpl;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import com.obric.memorydata.database.index.ExtractTime;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u00109\u001a\u00020:H\u0014J\u0014\u0010;\u001a\u00020:2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=J\n\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0018\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010D\u001a\u00020E2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u0005H\u0016J\b\u0010I\u001a\u00020JH\u0014J&\u0010K\u001a\u00020J2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00050M2\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u0001H\u0014J\b\u0010P\u001a\u00020\u0014H\u0016J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\tHÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\tHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u0014HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J×\u0001\u0010d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010e\u001a\u00020\u00142\b\u0010f\u001a\u0004\u0018\u00010gHÖ\u0003J\t\u0010h\u001a\u00020\tHÖ\u0001J\t\u0010i\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010+R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010 \"\u0004\b/\u0010+R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u00102R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010 R \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010 \"\u0004\b5\u0010+R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010 \"\u0004\b7\u0010+R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010 ¨\u0006j"}, d2 = {"Lcom/obric/memorydata/database/entity/RawNoteEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "title", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "textConversion", "formatMode", "noteFolder", "isFavorite", "", KevaImpl.PrivateConstants.FILES_DIR_NAME, "fullContent", "contentWithTime", "recordingIds", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getTitle", "getText", "getTextConversion", "setTextConversion", "getFormatMode", "getNoteFolder", "()Z", "getFiles", "getFullContent", "setFullContent", "getContentWithTime", "setContentWithTime", "getRecordingIds", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToAppEntity", "recordingEntities", "", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", "convertToContentTimeEntity", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "extractTime", "Lcom/obric/memorydata/database/index/ExtractTime;", "convertToImageVectorCopilotEntity", "onFirstIndex", "", "onUpdate", "updateColumns", "", "oldEntity", "newEntity", "delete", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class gu extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9166b;
    private final long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private String i;
    private final String j;
    private final String k;
    private String l;
    private final String m;
    private final String n;
    private final boolean o;
    private final String p;
    private String q;
    private String r;
    private final String s;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends String>> {
        public c() {
        }
    }

    public gu(long r23, String r25, long r26, long r28, int r30, long r31, String r33, int r34, String r35, String r36, String r37, String r38, String r39, String r40, boolean r41, String r42, String r43, String r44, String r45) {
        Intrinsics.checkNotNullParameter(r25, "entityId");
        Intrinsics.checkNotNullParameter(r33, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r36, "title");
        Intrinsics.checkNotNullParameter(r37, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        super(r23, r25, r26, r28, r30, r31, r33, r34, r35, null, null, null, 3584, null);
        this.f9165a = r23;
        this.f9166b = r25;
        this.c = r26;
        this.d = r28;
        this.e = r30;
        this.f = r31;
        this.g = r33;
        this.h = r34;
        this.i = r35;
        this.j = r36;
        this.k = r37;
        this.l = r38;
        this.m = r39;
        this.n = r40;
        this.o = r41;
        this.p = r42;
        this.q = r43;
        this.r = r44;
        this.s = r45;
    }

    public /* synthetic */ gu(long r28, String r30, long r31, long r33, int r35, long r36, String r38, int r39, String r40, String r41, String r42, String r43, String r44, String r45, boolean r46, String r47, String r48, String r49, String r50, int r51, DefaultConstructorMarker r52) {
        if ((r51 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r51 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r51 & 256) == 0) goto L13;
        String r16 = UUID.randomUUID().toString();
    L15:
        if ((r51 & 2048) == 0) goto L17;
        String r19 = null;
    L19:
        if ((65536 & r51) == 0) goto L21;
        String r24 = "";
    L23:
        if ((r51 & 131072) == 0) goto L25;
        String r25 = null;
    L26:
        this(r4, r30, r31, r33, r35, r12, r38, r39, r16, r41, r42, r19, r44, r45, r46, r47, r24, r25, r50);
        return;
    L25:
        r25 = r49;
        goto L26
    L21:
        r24 = r48;
        goto L23
    L17:
        r19 = r43;
        goto L19
    L13:
        r16 = r40;
        goto L15
    L9:
        r12 = r36;
        goto L11
    L5:
        r4 = r28;
        goto L7
    }

    public final AppEntity a(List<RecordingEntity> r14) {
        List<RecordingEntity> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "recordingEntities");
        NoteEntity r0 = new NoteEntity(getEntityId(), getCreateTime(), getModifyTime(), this.j, this.k, FormatModeEnum.Companion.from(this.m), this.n, this.o);
        r0.set_packageName(getPackageName());
        r0.setUuid(getUuid());
        String r13 = this.p;
        if (r13 == null) goto L5;
        List<FileEntity> r16 = com.obric.memorydata.personalcontext.util.f.a(r13);
    L6:
        r0.setFiles(r16);
        r0.setRecordings(r15);
        return (AppEntity) ZeusTransformUtils.preCheckCast(r0, AppEntity.class, "com.obric.memorydata.plugin");
    L5:
        r16 = null;
        goto L6
    }

    public final String a() {
        return this.j;
    }

    public final void a(String r1) {
        this.r = r1;
    }

    public final String b() {
        return this.k;
    }

    public final String c() {
        return this.l;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        String r1 = this.s;
        List<FileEntity> r2 = null;
        if (r1 != null) goto L24;
    L11:
        List<String> r3 = null;
    L12:
        if (r3 == null) goto L18;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRecordingRawDbDao().queryByEntityIdList(r3), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r0.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        AppEntity r6 = ((gw) ZeusTransformUtils.preCheckCast(r5.next(), gw.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.RecordingEntity");
        r4.add((RecordingEntity) ZeusTransformUtils.preCheckCast(r6, RecordingEntity.class, "com.obric.memorydata.plugin"));
        goto L15
    L17:
        List<RecordingEntity> r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    L19:
        NoteEntity r8 = new NoteEntity(getEntityId(), getCreateTime(), getModifyTime(), this.j, this.k, FormatModeEnum.Companion.from(this.m), this.n, this.o);
        r8.set_packageName(getPackageName());
        r8.setUuid(getUuid());
        String r15 = this.p;
        if (r15 == null) goto L22;
        r2 = com.obric.memorydata.personalcontext.util.f.a(r15);
    L22:
        r8.setFiles(r2);
        r8.setRecordings(r7);
        return (AppEntity) ZeusTransformUtils.preCheckCast(r8, AppEntity.class, "com.obric.memorydata.plugin");
    L18:
        r7 = null;
        goto L19
    L24:
        r3 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r1, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L6 JsonSyntaxException -> L8
    L8:
        e = e;
        IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder();
    L10:
        IRunLog.a.b(r9, "GsonExt", r10.append("toListObj error : ").append(e).toString(), null, 4, null);
    L6:
        e = e;
        r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r10 = new StringBuilder();
        goto L10
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.b convertToContentTimeEntity(String r21, ExtractTime r22) {
        Intrinsics.checkNotNullParameter(r21, "column");
        Intrinsics.checkNotNullParameter(r22, "extractTime");
        return (com.obric.memorydata.database.entity.b) ZeusTransformUtils.preCheckCast(new dt(0, getId(), r21, r22.getStartTimestamp(), r22.getEndTimestamp(), r22.getStartDateTimestamp(), r22.getEndDateTimestamp(), r22.getDeltaDay(), r22.getDeltaMonth(), r22.getDeltaYear(), 1, null), com.obric.memorydata.database.entity.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r10) {
        Intrinsics.checkNotNullParameter(r10, "column");
        return (i) ZeusTransformUtils.preCheckCast(new du(0, getId(), r10, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.c convertToRawHistoryEntity() {
        return (com.obric.memorydata.database.entity.c) ZeusTransformUtils.preCheckCast(new dw(0, this, 1, null), com.obric.memorydata.database.entity.c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new dv(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final String d() {
        return this.m;
    }

    @Override // com.obric.memorydata.database.entity.d, com.obric.memorydata.database.a
    public boolean delete() {
        boolean r0 = super.delete();
        if (r0 == false) goto L5;
        gd.f9146a.a(getEntityId(), getType(), getPackageName(), null, CollectionsKt.emptyList());
    L5:
        return r0;
    }

    public final String e() {
        return this.n;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, gu.class) == true) goto L8;
        return false;
    L8:
        gu r10 = (gu) ZeusTransformUtils.preCheckCast(r9, gu.class, "com.obric.memorydata.plugin");
        if (this.f9165a == r10.f9165a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9166b, r10.f9166b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r10.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r10.o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r10.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r10.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r10.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r10.s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final boolean f() {
        return this.o;
    }

    public final String g() {
        return this.p;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9166b;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9165a;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getType() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.i;
    }

    public final String h() {
        return this.q;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.f9165a) * 31) + this.f9166b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31;
        String r1 = this.i;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        String r5 = this.l;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.m;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.n;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + Boolean.hashCode(this.o)) * 31;
        String r14 = this.p;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.q;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.r;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.s;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return r22 + r2;
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String i() {
        return this.r;
    }

    public final String j() {
        return this.s;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void onFirstIndex() {
        super.onFirstIndex();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.p, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        gd.f9146a.a((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin"), KevaImpl.PrivateConstants.FILES_DIR_NAME, this.p);
        return;
    L12:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.memorydata.database.entity.d
    public void onUpdate(Set<String> r11, d r12, d r13) {
        Set<String> r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "updateColumns");
        Intrinsics.checkNotNullParameter(r12, "oldEntity");
        Intrinsics.checkNotNullParameter(r13, "newEntity");
        super.onUpdate(r14, r12, r13);
        gu r10 = (gu) ZeusTransformUtils.preCheckCast(r12, gu.class, "com.obric.memorydata.plugin");
        gu r15 = (gu) ZeusTransformUtils.preCheckCast(r13, gu.class, "com.obric.memorydata.plugin");
        String r16 = r10.s;
        if (r16 != null) goto L60;
    L12:
        List r17 = CollectionsKt.emptyList();
    L13:
        String r1 = r15.s;
        if (r1 != null) goto L58;
    L23:
        List r2 = CollectionsKt.emptyList();
    L24:
        boolean r3 = false;
        if (Intrinsics.areEqual(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")), CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"))) == true) goto L42;
        List<String> r18 = CollectionsKt.minus((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        List<String> r19 = CollectionsKt.minus((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L36;
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRecordingRawDbDao().queryByEntityIdList(r18), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L30:
        if (r110.hasNext() == false) goto L36;
        gw r4 = (gw) ZeusTransformUtils.preCheckCast(r110.next(), gw.class, "com.obric.memorydata.plugin");
        r4.delete();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRecordingTextRawDbDao().queryByParentEntityId(r4.getEntityId()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L33:
        if (r5.hasNext() == false) goto L30;
        ((gy) ZeusTransformUtils.preCheckCast(r5.next(), gy.class, "com.obric.memorydata.plugin")).delete();
    L36:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L41;
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRecordingRawDbDao().queryByEntityIdList(r19), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L39:
        if (r111.hasNext() == false) goto L41;
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast((gw) ZeusTransformUtils.preCheckCast(r111.next(), gw.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
    L41:
        EntityManager.INSTANCE.launchIndexTask();
    L42:
        CharSequence r112 = (CharSequence) ZeusTransformUtils.preCheckCast(r15.p, CharSequence.class, "com.obric.memorydata.plugin");
        if (r112 != null) goto L45;
    L48:
        boolean r113 = true;
    L49:
        boolean r114 = !r113;
        CharSequence r115 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.p, CharSequence.class, "com.obric.memorydata.plugin");
        if (r115 != null) goto L52;
    L53:
        r3 = true;
    L55:
        if (((!r3) | r114) == false) goto L65;
        gd.f9146a.a((d) ZeusTransformUtils.preCheckCast(r15, d.class, "com.obric.memorydata.plugin"), KevaImpl.PrivateConstants.FILES_DIR_NAME, r15.p);
        return;
    L65:
        return;
    L52:
        if (r115.length() != 0) goto L55;
    L45:
        if (r112.length() == 0) goto L48;
        r113 = false;
        goto L49
    L58:
        r2 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r1, new c().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L17 JsonSyntaxException -> L19
    L22:
        if (r2 != null) goto L24;
    L19:
        e = e;
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
    L21:
        IRunLog.a.b(r6, "GsonExt", r7.append("toListObj error : ").append(e).toString(), null, 4, null);
        r2 = null;
    L17:
        e = e;
        r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = new StringBuilder();
        goto L21
    L60:
        r17 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r16, new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L6 JsonSyntaxException -> L8
    L11:
        if (r17 != null) goto L13;
    L8:
        e = e;
        IRunLog r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder();
    L10:
        IRunLog.a.b(r8, "GsonExt", r9.append("toListObj error : ").append(e).toString(), null, 4, null);
        r17 = null;
    L6:
        e = e;
        r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r9 = new StringBuilder();
        goto L10
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9165a = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.i = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawNoteEntity(id=").append(this.f9165a).append(", entityId=").append(this.f9166b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", uuid=").append(this.i).append(", title=").append(this.j).append(", text=").append(this.k).append(", textConversion=");
        r0.append(this.l).append(", formatMode=").append(this.m).append(", noteFolder=").append(this.n).append(", isFavorite=").append(this.o).append(", files=").append(this.p).append(", fullContent=").append(this.q).append(", contentWithTime=").append(this.r).append(", recordingIds=").append(this.s).append(')');
        return r0.toString();
    }
}
