package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
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
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 r2\u00020\u0001:\u0001rB×\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010>\u001a\u00020?H\u0014J\u0018\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0016J\u0012\u0010D\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u0005H\u0016J\n\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0016J&\u0010K\u001a\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00050N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020PH\u0014J\b\u0010R\u001a\u00020LH\u0014J\u0006\u0010S\u001a\u00020\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\tHÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\tHÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\tHÆ\u0003J\t\u0010^\u001a\u00020\u0005HÆ\u0003J\t\u0010_\u001a\u00020\tHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jþ\u0001\u0010j\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010kJ\u0013\u0010l\u001a\u00020m2\b\u0010n\u001a\u0004\u0018\u00010oHÖ\u0003J\t\u0010p\u001a\u00020\tHÖ\u0001J\t\u0010q\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\"\"\u0004\b:\u0010;R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\"\"\u0004\b=\u0010;¨\u0006s"}, d2 = {"Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawFileDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", ActivityLifecycle.NAME, "state", "file", "duration", "transcript", "summary", "todoList", "markers", "sourceAppName", "sourceAppPackage", "requestTime", "did", "docNodeJson", Api.KEY_UUID, "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getName", "getState", "getFile", "getDuration", "getTranscript", "getSummary", "getTodoList", "getMarkers", "getSourceAppName", "getSourceAppPackage", "getRequestTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDid", "getDocNodeJson", "setDocNodeJson", "(Ljava/lang/String;)V", "getUuid", "setUuid", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "createFileTextEntity", "Lcom/obric/memorydata/database/entity/AbstractRawFileTextDbEntity;", "passageMaterial", "Lcom/obric/memorydata/database/util/file_utils/PassageGenerator$PassageMaterial;", "onUpdate", "", "updateColumns", "", "oldEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "newEntity", "onFirstIndex", "getEndTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;", "equals", "", "other", "", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class fj extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9123b;
    private final String c;
    private final long d;
    private final long e;
    private final int f;
    private long g;
    private final String h;
    private final int i;
    private final String j;
    private final int k;
    private final String l;
    private final int m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final Long t;
    private final String u;
    private String v;
    private String w;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity$Companion;", "", "<init>", "()V", "KEY_REQUEST_TIME", "", "KEY_DID", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends Integer>> {
        public c() {
        }
    }

    static {
        f9122a = new a(null);
    }

    public fj(long r17, String r19, long r20, long r22, int r24, long r25, String r27, int r28, String r29, int r30, String r31, int r32, String r33, String r34, String r35, String r36, String r37, String r38, Long r39, String r40, String r41, String r42) {
        Intrinsics.checkNotNullParameter(r19, "entityId");
        Intrinsics.checkNotNullParameter(r27, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r29, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r31, "file");
        super(r17, r19, r20, r22, r24, r25, r27, r28, r42, r41);
        this.f9123b = r17;
        this.c = r19;
        this.d = r20;
        this.e = r22;
        this.f = r24;
        this.g = r25;
        this.h = r27;
        this.i = r28;
        this.j = r29;
        this.k = r30;
        this.l = r31;
        this.m = r32;
        this.n = r33;
        this.o = r34;
        this.p = r35;
        this.q = r36;
        this.r = r37;
        this.s = r38;
        this.t = r39;
        this.u = r40;
        this.v = r41;
        this.w = r42;
    }

    public /* synthetic */ fj(long r30, String r32, long r33, long r35, int r37, long r38, String r40, int r41, String r42, int r43, String r44, int r45, String r46, String r47, String r48, String r49, String r50, String r51, Long r52, String r53, String r54, String r55, int r56, DefaultConstructorMarker r57) {
        if ((r56 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r56 & 32) == 0) goto L9;
        long r11 = System.currentTimeMillis();
    L11:
        if ((r56 & 262144) == 0) goto L13;
        Long r25 = null;
    L15:
        if ((r56 & 524288) == 0) goto L17;
        String r26 = null;
    L19:
        if ((r56 & 1048576) == 0) goto L21;
        String r27 = null;
    L23:
        if ((r56 & 2097152) == 0) goto L25;
        String r28 = UUID.randomUUID().toString();
    L26:
        this(r3, r32, r33, r35, r37, r11, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r25, r26, r27, r28);
        return;
    L25:
        r28 = r55;
        goto L26
    L21:
        r27 = r54;
        goto L23
    L17:
        r26 = r53;
        goto L19
    L13:
        r25 = r52;
        goto L15
    L9:
        r11 = r38;
        goto L11
    L5:
        r3 = r30;
        goto L7
    }

    @Override // com.obric.memorydata.database.entity.e
    public f a(com.obric.memorydata.database.util.file_utils.s.a r21) {
        Intrinsics.checkNotNullParameter(r21, "passageMaterial");
        long r8 = System.currentTimeMillis();
        long r3 = 0;
        int r10 = -313;
        long r11 = 0;
        return (f) ZeusTransformUtils.preCheckCast(new fm(r3, gd.f9146a.a(), r8, r8, r10, r11, getPackageName(), getHashCodeValue(), getEntityId(), r21.a(), r21.b(), 33, null), f.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.e
    public String a() {
        return this.v;
    }

    @Override // com.obric.memorydata.database.entity.e
    public void a(String r1) {
        this.v = r1;
    }

    public final String c() {
        return this.j;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        AuditoryRecordingEntity r12 = new AuditoryRecordingEntity(getEntityId(), getCreateTime(), getModifyTime(), this.j, this.k, com.obric.memorydata.personalcontext.util.f.b(this.l), this.m);
        r12.set_packageName(getPackageName());
        r12.setUuid(getUuid());
        String r0 = this.n;
        String r2 = null;
        if (r0 != null) goto L5;
        FileEntity r1 = null;
    L6:
        r12.setTranscript(r1);
        r12.setSummary(this.o);
        String r3 = this.p;
        if (r3 != null) goto L47;
    L15:
        List<String> r4 = null;
    L16:
        r12.setTodoList(r4);
        String r5 = this.q;
        if (r5 != null) goto L49;
    L25:
        List<Integer> r6 = null;
    L26:
        r12.setMarkers(r6);
        r12.setSourceAppName(this.r);
        r12.setSourceAppPackage(this.s);
        JSONObject r7 = new JSONObject();
        Long r8 = this.t;
        if (r8 == null) goto L29;
        r7.put("requestTime", ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).longValue());
    L29:
        String r9 = this.u;
        if (r9 == null) goto L32;
        r7.put("did", r9);
    L32:
        List<String> r10 = b();
        if (r10 == null) goto L36;
        r7.put("relevantTextContent", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")));
    L36:
        if (r7.length() <= 0) goto L38;
        boolean r11 = true;
    L40:
        if (Boolean.valueOf(r11).booleanValue() == true) goto L43;
        r7 = null;
    L43:
        if (r7 == null) goto L45;
        r2 = r7.toString();
    L45:
        r12.setExtraData(r2);
        return (AppEntity) ZeusTransformUtils.preCheckCast(r12, AppEntity.class, "com.obric.memorydata.plugin");
    L38:
        r11 = false;
        goto L40
    L49:
        r6 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r5, new c().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L20 JsonSyntaxException -> L22
    L22:
        e = e;
        IRunLog r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r14 = new StringBuilder();
    L24:
        IRunLog.a.b(r13, "GsonExt", r14.append("toListObj error : ").append(e).toString(), null, 4, null);
    L20:
        e = e;
        r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r14 = new StringBuilder();
        goto L24
    L47:
        r4 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r3, new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L10 JsonSyntaxException -> L12
    L12:
        e = e;
        IRunLog r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder();
    L14:
        IRunLog.a.b(r15, "GsonExt", r16.append("toListObj error : ").append(e).toString(), null, 4, null);
    L10:
        e = e;
        r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r16 = new StringBuilder();
        goto L14
    L5:
        r1 = com.obric.memorydata.personalcontext.util.f.c(r0);
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.c convertToRawHistoryEntity() {
        return (com.obric.memorydata.database.entity.c) ZeusTransformUtils.preCheckCast(new fl(0, this, 1, null), com.obric.memorydata.database.entity.c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new q(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final int d() {
        return this.k;
    }

    public final String e() {
        return this.l;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, fj.class) == true) goto L8;
        return false;
    L8:
        fj r10 = (fj) ZeusTransformUtils.preCheckCast(r9, fj.class, "com.obric.memorydata.plugin");
        if (this.f9123b == r10.f9123b) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L15;
        return false;
    L15:
        if (this.d == r10.d) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L24;
        return false;
    L24:
        if (this.g == r10.g) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L30;
        return false;
    L30:
        if (this.i == r10.i) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L36;
        return false;
    L36:
        if (this.k == r10.k) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L42;
        return false;
    L42:
        if (this.m == r10.m) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.n, r10.n) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.p, r10.p) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.q, r10.q) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.r, r10.r) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.s, r10.s) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.t, r10.t) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.u, r10.u) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.v, r10.v) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.w, r10.w) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public final int f() {
        return this.m;
    }

    public final String g() {
        return this.n;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9123b;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public int getType() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.w;
    }

    public final String h() {
        return this.o;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((((((Long.hashCode(this.f9123b) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + Integer.hashCode(this.i)) * 31) + this.j.hashCode()) * 31) + Integer.hashCode(this.k)) * 31) + this.l.hashCode()) * 31) + Integer.hashCode(this.m)) * 31;
        String r1 = this.n;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.o;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.p;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.q;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.r;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.s;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Long r20 = this.t;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.u;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.v;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.w;
        if (r29 == null) goto L43;
        r2 = r29.hashCode();
    L43:
        return r28 + r2;
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
        return this.p;
    }

    public final String j() {
        return this.q;
    }

    public final String k() {
        return this.r;
    }

    public final String l() {
        return this.s;
    }

    public final Long m() {
        return this.t;
    }

    public final String n() {
        return this.u;
    }

    public final long o() {
        return Math.max(getCreateTime() + (((long) this.m) * 1000), getCreateTime());
    }

    @Override // com.obric.memorydata.database.entity.d
    public void onFirstIndex() {
        super.onFirstIndex();
    }

    @Override // com.obric.memorydata.database.entity.d
    public void onUpdate(Set<String> r8, d r9, d r10) {
        Set<String> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "updateColumns");
        Intrinsics.checkNotNullParameter(r9, "oldEntity");
        Intrinsics.checkNotNullParameter(r10, "newEntity");
        super.onUpdate(r11, r9, r10);
        fj r12 = (fj) ZeusTransformUtils.preCheckCast(r9, fj.class, "com.obric.memorydata.plugin");
        fj r13 = (fj) ZeusTransformUtils.preCheckCast(r10, fj.class, "com.obric.memorydata.plugin");
        if (r11.contains("summary") == false) goto L5;
    L10:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingTextRawDbDao().queryByParentEntityId(getEntityId()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        ((fm) ZeusTransformUtils.preCheckCast(r7.next(), fm.class, "com.obric.memorydata.plugin")).delete();
        goto L12
    L14:
        r11.add("transcript");
        return;
    L5:
        if (r11.contains("transcript") == true) goto L10;
        if (r12.getModifyTime() != r13.getModifyTime()) goto L10;
        if (r12.m != r13.m) goto L10;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9123b = r1;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.g = r1;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.w = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawAuditoryRecordingEntity(id=").append(this.f9123b).append(", entityId=").append(this.c).append(", createTime=").append(this.d).append(", modifyTime=").append(this.e).append(", type=").append(this.f).append(", timestamp=").append(this.g).append(", packageName=").append(this.h).append(", hashCodeValue=").append(this.i).append(", name=").append(this.j).append(", state=").append(this.k).append(", file=").append(this.l).append(", duration=");
        r0.append(this.m).append(", transcript=").append(this.n).append(", summary=").append(this.o).append(", todoList=").append(this.p).append(", markers=").append(this.q).append(", sourceAppName=").append(this.r).append(", sourceAppPackage=").append(this.s).append(", requestTime=").append(this.t).append(", did=").append(this.u).append(", docNodeJson=").append(this.v).append(", uuid=").append(this.w).append(')');
        return r0.toString();
    }
}
