package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.enums.CallTypeEnum;
import com.obric.memorydata.database.dao.CallHistoryHistoryEntity;
import com.obric.memorydata.database.index.ExtractTime;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010E\u001a\u00020FH\u0014J\u0018\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u0005H\u0016J\u0012\u0010K\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020\u0005H\u0016J\n\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0018\u0010N\u001a\u00020O2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010P\u001a\u00020QH\u0016J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\tHÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\tHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\t\u0010^\u001a\u00020\tHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010`\u001a\u00020\u0014HÆ\u0003J\t\u0010a\u001a\u00020\u0014HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u008f\u0002\u0010j\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010k\u001a\u00020\u00142\b\u0010l\u001a\u0004\u0018\u00010mHÖ\u0003J\t\u0010n\u001a\u00020\tHÖ\u0001J\t\u0010o\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010%\"\u0004\b/\u00100R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b4\u0010)R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u00106R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b7\u00106R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010%\"\u0004\b:\u00100R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010%\"\u0004\b=\u00100R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010%\"\u0004\b?\u00100R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010%\"\u0004\bA\u00100R \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010%\"\u0004\bC\u00100R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010%¨\u0006p"}, d2 = {"Lcom/obric/memorydata/database/entity/RawCallHistoryEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "telephones", "contactIds", "callType", "duration", LocationMonitorConst.TAG, "isAIPickup", "", "hasTranscript", "transcript", "contentWithTime", "carriers", "fullContent", "telephoneStandardMap", "todoList", "transcriptTitle", "sourceNumber", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getTelephones", "getContactIds", "getCallType", "getDuration", "getTag", "()Z", "getHasTranscript", "getTranscript", "getContentWithTime", "setContentWithTime", "getCarriers", "getFullContent", "setFullContent", "getTelephoneStandardMap", "setTelephoneStandardMap", "getTodoList", "setTodoList", "getTranscriptTitle", "setTranscriptTitle", "getSourceNumber", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "convertToContentTimeEntity", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "extractTime", "Lcom/obric/memorydata/database/index/ExtractTime;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class fq extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9131b;
    private final long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private String i;
    private final String j;
    private final String k;
    private final String l;
    private final int m;
    private final String n;
    private final boolean o;
    private final boolean p;
    private final String q;
    private String r;
    private final String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private final String x;

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

    public fq(long r23, String r25, long r26, long r28, int r30, long r31, String r33, int r34, String r35, String r36, String r37, String r38, int r39, String r40, boolean r41, boolean r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50) {
        Intrinsics.checkNotNullParameter(r25, "entityId");
        Intrinsics.checkNotNullParameter(r33, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r36, "telephones");
        Intrinsics.checkNotNullParameter(r38, "callType");
        super(r23, r25, r26, r28, r30, r31, r33, r34, r35, null, null, null, 3584, null);
        this.f9130a = r23;
        this.f9131b = r25;
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
        this.t = r46;
        this.u = r47;
        this.v = r48;
        this.w = r49;
        this.x = r50;
    }

    public /* synthetic */ fq(long r33, String r35, long r36, long r38, int r40, long r41, String r43, int r44, String r45, String r46, String r47, String r48, int r49, String r50, boolean r51, boolean r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, String r60, int r61, DefaultConstructorMarker r62) {
        if ((r61 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r61 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r61 & 256) == 0) goto L13;
        String r16 = UUID.randomUUID().toString();
    L15:
        if ((131072 & r61) == 0) goto L17;
        String r25 = null;
    L19:
        if ((524288 & r61) == 0) goto L21;
        String r27 = null;
    L23:
        if ((r61 & 8388608) == 0) goto L25;
        String r31 = null;
    L26:
        this(r4, r35, r36, r38, r40, r12, r43, r44, r16, r46, r47, r48, r49, r50, r51, r52, r53, r25, r55, r27, r57, r58, r59, r31);
        return;
    L25:
        r31 = r60;
        goto L26
    L21:
        r27 = r56;
        goto L23
    L17:
        r25 = r54;
        goto L19
    L13:
        r16 = r45;
        goto L15
    L9:
        r12 = r41;
        goto L11
    L5:
        r4 = r33;
        goto L7
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
        List<String> r4 = null;
        List r0 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(this.j, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L5 JsonSyntaxException -> L7
    L10:
        if (r0 != null) goto L12;
        r0 = CollectionsKt.emptyList();
    L12:
        List<String> r5 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"));
        Map<String, com.obric.memorydata.utils.au> r6 = com.obric.memorydata.utils.t.f13260a.b(this.u);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        r7.add(com.obric.memorydata.utils.t.f13260a.a((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin"), null, r6));
        goto L14
    L16:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao().queryByPhoneNumber(r5, getPackageName()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r3.iterator();
    L18:
        if (r9.hasNext() == false) goto L20;
        AppEntity r10 = ((fx) ZeusTransformUtils.preCheckCast(r9.next(), fx.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ContactEntity");
        r8.add((ContactEntity) ZeusTransformUtils.preCheckCast(r10, ContactEntity.class, "com.obric.memorydata.plugin"));
        goto L18
    L20:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        String r11 = getEntityId();
        long r12 = getCreateTime();
        long r13 = getModifyTime();
        CallTypeEnum r14 = CallTypeEnum.Companion.from(this.l);
        if (r14 != null) goto L23;
        r14 = CallTypeEnum.INCOMING_CALL_ANSWERED;
    L23:
        CallHistoryEntity r17 = new CallHistoryEntity(r11, r12, r13, r15, r16, r14, this.m);
        r17.set_packageName(getPackageName());
        r17.setUuid(getUuid());
        r17.setTag(this.n);
        r17.setAIPickup(this.o);
        r17.setHasTranscript(this.p);
        r17.setTranscript(this.q);
        String r18 = this.s;
        if (r18 != null) goto L48;
    L32:
        List<String> r19 = null;
    L33:
        r17.setCarriers(r19);
        String r20 = this.v;
        if (r20 != null) goto L44;
    L42:
        r17.setTodoList(r4);
        r17.setTranscriptTitle(this.w);
        r17.setSourceNumber(this.x);
        return (AppEntity) ZeusTransformUtils.preCheckCast(r17, AppEntity.class, "com.obric.memorydata.plugin");
    L44:
        r4 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r20, new c().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L37 JsonSyntaxException -> L39
        goto L42
    L39:
        e = e;
        IRunLog r21 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r22 = new StringBuilder();
    L41:
        IRunLog.a.b(r21, "GsonExt", r22.append("toListObj error : ").append(e).toString(), null, 4, null);
    L37:
        e = e;
        r21 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r22 = new StringBuilder();
        goto L41
    L48:
        r19 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r18, new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L27 JsonSyntaxException -> L29
    L29:
        e = e;
        IRunLog r23 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r24 = new StringBuilder();
    L31:
        IRunLog.a.b(r23, "GsonExt", r24.append("toListObj error : ").append(e).toString(), null, 4, null);
    L27:
        e = e;
        r23 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r24 = new StringBuilder();
        goto L31
    L7:
        e = e;
        IRunLog r25 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r26 = new StringBuilder();
    L9:
        IRunLog.a.b(r25, "GsonExt", r26.append("toListObj error : ").append(e).toString(), null, 4, null);
        r0 = null;
    L5:
        e = e;
        r25 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r26 = new StringBuilder();
        goto L9
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.b convertToContentTimeEntity(String r21, ExtractTime r22) {
        Intrinsics.checkNotNullParameter(r21, "column");
        Intrinsics.checkNotNullParameter(r22, "extractTime");
        return (com.obric.memorydata.database.entity.b) ZeusTransformUtils.preCheckCast(new ah(0, getId(), r21, r22.getStartTimestamp(), r22.getEndTimestamp(), r22.getStartDateTimestamp(), r22.getEndDateTimestamp(), r22.getDeltaDay(), r22.getDeltaMonth(), r22.getDeltaYear(), 1, null), com.obric.memorydata.database.entity.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.c convertToRawHistoryEntity() {
        return (com.obric.memorydata.database.entity.c) ZeusTransformUtils.preCheckCast(new CallHistoryHistoryEntity(0, this, 1, null), com.obric.memorydata.database.entity.c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new ai(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final int d() {
        return this.m;
    }

    public final String e() {
        return this.n;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, fq.class) == true) goto L8;
        return false;
    L8:
        fq r10 = (fq) ZeusTransformUtils.preCheckCast(r9, fq.class, "com.obric.memorydata.plugin");
        if (this.f9130a == r10.f9130a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9131b, r10.f9131b) == true) goto L15;
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
        if (this.m == r10.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r10.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r10.o) goto L54;
        return false;
    L54:
        if (this.p == r10.p) goto L57;
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
        if (Intrinsics.areEqual(this.v, r10.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r10.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r10.x) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public final boolean f() {
        return this.o;
    }

    public final boolean g() {
        return this.p;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9131b;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9130a;
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
        int r0 = ((((((((((((((Long.hashCode(this.f9130a) * 31) + this.f9131b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31;
        String r1 = this.i;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.j.hashCode()) * 31;
        String r5 = this.k;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + this.l.hashCode()) * 31) + Integer.hashCode(this.m)) * 31;
        String r8 = this.n;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((r7 + r9) * 31) + Boolean.hashCode(this.o)) * 31) + Boolean.hashCode(this.p)) * 31;
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
        String r20 = this.t;
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
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.x;
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
        return this.r;
    }

    public final String j() {
        return this.s;
    }

    public final String k() {
        return this.t;
    }

    public final String l() {
        return this.u;
    }

    public final String m() {
        return this.v;
    }

    public final String n() {
        return this.w;
    }

    public final String o() {
        return this.x;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9130a = r1;
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
        r0.append("RawCallHistoryEntity(id=").append(this.f9130a).append(", entityId=").append(this.f9131b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", uuid=").append(this.i).append(", telephones=").append(this.j).append(", contactIds=").append(this.k).append(", callType=");
        r0.append(this.l).append(", duration=").append(this.m).append(", tag=").append(this.n).append(", isAIPickup=").append(this.o).append(", hasTranscript=").append(this.p).append(", transcript=").append(this.q).append(", contentWithTime=").append(this.r).append(", carriers=").append(this.s).append(", fullContent=").append(this.t).append(", telephoneStandardMap=").append(this.u).append(", todoList=").append(this.v).append(", transcriptTitle=").append(this.w);
        r0.append(", sourceNumber=").append(this.x).append(')');
        return r0.toString();
    }
}
