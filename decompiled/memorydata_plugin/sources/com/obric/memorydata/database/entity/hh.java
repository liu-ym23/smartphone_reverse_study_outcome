package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.memorydata.database.index.ExtractTime;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BÛ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010>\u001a\u00020?H\u0014J\u0018\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0016J\u0012\u0010D\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u0005H\u0016J\u0018\u0010E\u001a\u00020F2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010G\u001a\u00020HH\u0016J\n\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0016J&\u0010O\u001a\u00020P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00050R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020TH\u0014J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\tHÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\tHÆ\u0003J\t\u0010^\u001a\u00020\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\t\u0010`\u001a\u00020\tHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jû\u0001\u0010l\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010pHÖ\u0003J\t\u0010q\u001a\u00020\tHÖ\u0001J\t\u0010r\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\"\"\u0004\b1\u00102R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\"\"\u0004\b8\u00102R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\"\"\u0004\b:\u00102R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\"\"\u0004\b<\u00102R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\"¨\u0006s"}, d2 = {"Lcom/obric/memorydata/database/entity/RawRecordingEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawFileDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", ActivityLifecycle.NAME, "file", "duration", "transcript", "summary", "contentWithTime", "todoList", "markers", "sourceAppName", "sourceAppPackage", "fullContent", "docNodeJson", Api.KEY_UUID, "sourceDevice", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getName", "getFile", "getDuration", "getTranscript", "getSummary", "getContentWithTime", "setContentWithTime", "(Ljava/lang/String;)V", "getTodoList", "getMarkers", "getSourceAppName", "getSourceAppPackage", "getFullContent", "setFullContent", "getDocNodeJson", "setDocNodeJson", "getUuid", "setUuid", "getSourceDevice", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToContentTimeEntity", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "extractTime", "Lcom/obric/memorydata/database/index/ExtractTime;", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "createFileTextEntity", "Lcom/obric/memorydata/database/entity/AbstractRawFileTextDbEntity;", "passageMaterial", "Lcom/obric/memorydata/database/util/file_utils/PassageGenerator$PassageMaterial;", "onUpdate", "", "updateColumns", "", "oldEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "newEntity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class hh extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9182b;
    private final long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private final String i;
    private final String j;
    private final int k;
    private final String l;
    private final String m;
    private String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private String s;
    private String t;
    private String u;
    private final String v;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends Integer>> {
        public b() {
        }
    }

    public hh(long r17, String r19, long r20, long r22, int r24, long r25, String r27, int r28, String r29, String r30, int r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42) {
        Intrinsics.checkNotNullParameter(r19, "entityId");
        Intrinsics.checkNotNullParameter(r27, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r29, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r30, "file");
        super(r17, r19, r20, r22, r24, r25, r27, r28, r41, r40);
        this.f9181a = r17;
        this.f9182b = r19;
        this.c = r20;
        this.d = r22;
        this.e = r24;
        this.f = r25;
        this.g = r27;
        this.h = r28;
        this.i = r29;
        this.j = r30;
        this.k = r31;
        this.l = r32;
        this.m = r33;
        this.n = r34;
        this.o = r35;
        this.p = r36;
        this.q = r37;
        this.r = r38;
        this.s = r39;
        this.t = r40;
        this.u = r41;
        this.v = r42;
    }

    public /* synthetic */ hh(long r31, String r33, long r34, long r36, int r38, long r39, String r41, int r42, String r43, String r44, int r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, String r55, String r56, int r57, DefaultConstructorMarker r58) {
        if ((r57 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r57 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r57 & 8192) == 0) goto L13;
        String r21 = null;
    L15:
        if ((262144 & r57) == 0) goto L17;
        String r26 = null;
    L19:
        if ((524288 & r57) == 0) goto L21;
        String r27 = null;
    L23:
        if ((1048576 & r57) == 0) goto L25;
        String r28 = UUID.randomUUID().toString();
    L27:
        if ((r57 & 2097152) == 0) goto L29;
        String r29 = null;
    L30:
        this(r4, r33, r34, r36, r38, r12, r41, r42, r43, r44, r45, r46, r47, r21, r49, r50, r51, r52, r26, r27, r28, r29);
        return;
    L29:
        r29 = r56;
        goto L30
    L25:
        r28 = r55;
        goto L27
    L21:
        r27 = r54;
        goto L23
    L17:
        r26 = r53;
        goto L19
    L13:
        r21 = r48;
        goto L15
    L9:
        r12 = r39;
        goto L11
    L5:
        r4 = r31;
        goto L7
    }

    @Override // com.obric.memorydata.database.entity.e
    public f a(com.obric.memorydata.database.util.file_utils.s.a r21) {
        Intrinsics.checkNotNullParameter(r21, "passageMaterial");
        long r8 = System.currentTimeMillis();
        return (f) ZeusTransformUtils.preCheckCast(new hj(0, gd.f9146a.a(), r8, r8, -309, 0, getPackageName(), getHashCodeValue(), getEntityId(), r21.a(), r21.b(), 33, null), f.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.e
    public String a() {
        return this.t;
    }

    @Override // com.obric.memorydata.database.entity.e
    public void a(String r1) {
        this.t = r1;
    }

    public final void b(String r1) {
        this.n = r1;
    }

    public final String c() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        RecordingEntity r11 = new RecordingEntity(getEntityId(), getCreateTime(), getModifyTime(), this.i, com.obric.memorydata.personalcontext.util.f.b(this.j), this.k);
        r11.set_packageName(getPackageName());
        r11.setUuid(getUuid());
        String r0 = this.l;
        List<Integer> r2 = null;
        if (r0 != null) goto L5;
        FileEntity r1 = null;
    L6:
        r11.setTranscript(r1);
        r11.setSummary(this.m);
        String r3 = this.o;
        if (r3 != null) goto L30;
    L15:
        List<String> r4 = null;
    L16:
        r11.setTodoList(r4);
        String r5 = this.p;
        if (r5 != null) goto L32;
    L25:
        r11.setMarkers(r2);
        r11.setSourceAppName(this.q);
        r11.setSourceAppPackage(this.r);
        r11.setSourceDevice(this.v);
        JSONObject r6 = new JSONObject();
        List<String> r7 = b();
        if (r7 == null) goto L28;
        r6.put("relevantTextContent", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")));
    L28:
        r11.setExtraData(r6.toString());
        return (AppEntity) ZeusTransformUtils.preCheckCast(r11, AppEntity.class, "com.obric.memorydata.plugin");
    L32:
        r2 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r5, new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L20 JsonSyntaxException -> L22
        goto L25
    L22:
        e = e;
        IRunLog r12 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r8 = new StringBuilder();
    L24:
        IRunLog.a.b(r12, "GsonExt", r8.append("toListObj error : ").append(e).toString(), null, 4, null);
    L20:
        e = e;
        r12 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r8 = new StringBuilder();
        goto L24
    L30:
        r4 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r3, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L10 JsonSyntaxException -> L12
    L12:
        e = e;
        IRunLog r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder();
    L14:
        IRunLog.a.b(r13, "GsonExt", r9.append("toListObj error : ").append(e).toString(), null, 4, null);
    L10:
        e = e;
        r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r9 = new StringBuilder();
        goto L14
    L5:
        r1 = com.obric.memorydata.personalcontext.util.f.c(r0);
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.b convertToContentTimeEntity(String r21, ExtractTime r22) {
        Intrinsics.checkNotNullParameter(r21, "column");
        Intrinsics.checkNotNullParameter(r22, "extractTime");
        return (com.obric.memorydata.database.entity.b) ZeusTransformUtils.preCheckCast(new hu(0, getId(), r21, r22.getStartTimestamp(), r22.getEndTimestamp(), r22.getStartDateTimestamp(), r22.getEndDateTimestamp(), r22.getDeltaDay(), r22.getDeltaMonth(), r22.getDeltaYear(), 1, null), com.obric.memorydata.database.entity.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public c convertToRawHistoryEntity() {
        return (c) ZeusTransformUtils.preCheckCast(new hw(0, this, 1, null), c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new hv(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final String d() {
        return this.j;
    }

    public final int e() {
        return this.k;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, hh.class) == true) goto L8;
        return false;
    L8:
        hh r10 = (hh) ZeusTransformUtils.preCheckCast(r9, hh.class, "com.obric.memorydata.plugin");
        if (this.f9181a == r10.f9181a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9182b, r10.f9182b) == true) goto L15;
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
        if (this.k == r10.k) goto L42;
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
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L54;
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
        if (Intrinsics.areEqual(this.s, r10.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r10.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r10.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r10.v) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public final String f() {
        return this.l;
    }

    public final String g() {
        return this.m;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9182b;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9181a;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public int getType() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.u;
    }

    public final String h() {
        return this.n;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((((Long.hashCode(this.f9181a) * 31) + this.f9182b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + Integer.hashCode(this.k)) * 31;
        String r1 = this.l;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.m;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.n;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.o;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
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
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.t;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.u;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.v;
        if (r32 == null) goto L47;
        r2 = r32.hashCode();
    L47:
        return r31 + r2;
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
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
        return this.o;
    }

    public final String j() {
        return this.p;
    }

    public final String k() {
        return this.q;
    }

    public final String l() {
        return this.r;
    }

    public final String m() {
        return this.s;
    }

    public final String n() {
        return this.v;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void onUpdate(Set<String> r8, d r9, d r10) {
        Set<String> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "updateColumns");
        Intrinsics.checkNotNullParameter(r9, "oldEntity");
        Intrinsics.checkNotNullParameter(r10, "newEntity");
        super.onUpdate(r11, r9, r10);
        hh r12 = (hh) ZeusTransformUtils.preCheckCast(r9, hh.class, "com.obric.memorydata.plugin");
        hh r13 = (hh) ZeusTransformUtils.preCheckCast(r10, hh.class, "com.obric.memorydata.plugin");
        if (r11.contains("summary") == false) goto L5;
    L10:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRecordingTextRawDbDao().queryByParentEntityId(getEntityId()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        ((hj) ZeusTransformUtils.preCheckCast(r7.next(), hj.class, "com.obric.memorydata.plugin")).delete();
        goto L12
    L14:
        r11.add("transcript");
        return;
    L5:
        if (r11.contains("transcript") == true) goto L10;
        if (r12.getModifyTime() != r13.getModifyTime()) goto L10;
        if (r12.k != r13.k) goto L10;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9181a = r1;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.u = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawRecordingEntity(id=").append(this.f9181a).append(", entityId=").append(this.f9182b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", name=").append(this.i).append(", file=").append(this.j).append(", duration=").append(this.k).append(", transcript=");
        r0.append(this.l).append(", summary=").append(this.m).append(", contentWithTime=").append(this.n).append(", todoList=").append(this.o).append(", markers=").append(this.p).append(", sourceAppName=").append(this.q).append(", sourceAppPackage=").append(this.r).append(", fullContent=").append(this.s).append(", docNodeJson=").append(this.t).append(", uuid=").append(this.u).append(", sourceDevice=").append(this.v).append(')');
        return r0.toString();
    }
}
