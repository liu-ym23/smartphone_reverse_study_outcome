package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B±\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\b\u00103\u001a\u000204H\u0014J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005H\u0016J\u0012\u00109\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u0005H\u0016J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016J&\u0010>\u001a\u00020?2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CH\u0014R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u00102¨\u0006E"}, d2 = {"Lcom/obric/memorydata/database/entity/RawNoteRecordingEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawFileDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", ActivityLifecycle.NAME, "file", "duration", "transcript", "summary", "todoList", "markers", "sourceAppName", "sourceAppPackage", "docNodeJson", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getName", "getFile", "getDuration", "getTranscript", "getSummary", "getTodoList", "getMarkers", "getSourceAppName", "getSourceAppPackage", "getDocNodeJson", "setDocNodeJson", "(Ljava/lang/String;)V", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "createFileTextEntity", "Lcom/obric/memorydata/database/entity/AbstractRawFileTextDbEntity;", "passageMaterial", "Lcom/obric/memorydata/database/util/file_utils/PassageGenerator$PassageMaterial;", "onUpdate", "", "updateColumns", "", "oldEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "newEntity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class gw extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9168b;
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
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private String r;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends Integer>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    public gw(long r21, String r23, long r24, long r26, int r28, long r29, String r31, int r32, String r33, String r34, int r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42) {
        Intrinsics.checkNotNullParameter(r23, "entityId");
        Intrinsics.checkNotNullParameter(r31, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r33, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r34, "file");
        super(r21, r23, r24, r26, r28, r29, r31, r32, r42, null, 512, null);
        this.f9167a = r21;
        this.f9168b = r23;
        this.c = r24;
        this.d = r26;
        this.e = r28;
        this.f = r29;
        this.g = r31;
        this.h = r32;
        this.i = r33;
        this.j = r34;
        this.k = r35;
        this.l = r36;
        this.m = r37;
        this.n = r38;
        this.o = r39;
        this.p = r40;
        this.q = r41;
        this.r = r42;
    }

    public /* synthetic */ gw(long r27, String r29, long r30, long r32, int r34, long r35, String r37, int r38, String r39, String r40, int r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, int r49, DefaultConstructorMarker r50) {
        if ((r49 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r49 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r49 & 2048) == 0) goto L13;
        String r19 = null;
    L15:
        if ((32768 & r49) == 0) goto L17;
        String r23 = null;
    L19:
        if ((65536 & r49) == 0) goto L21;
        String r24 = null;
    L23:
        if ((r49 & 131072) == 0) goto L25;
        String r25 = null;
    L26:
        this(r4, r29, r30, r32, r34, r12, r37, r38, r39, r40, r41, r19, r43, r44, r45, r23, r24, r25);
        return;
    L25:
        r25 = r48;
        goto L26
    L21:
        r24 = r47;
        goto L23
    L17:
        r23 = r46;
        goto L19
    L13:
        r19 = r42;
        goto L15
    L9:
        r12 = r35;
        goto L11
    L5:
        r4 = r27;
        goto L7
    }

    @Override // com.obric.memorydata.database.entity.e
    public f a(com.obric.memorydata.database.util.file_utils.s.a r21) {
        Intrinsics.checkNotNullParameter(r21, "passageMaterial");
        long r8 = System.currentTimeMillis();
        return (f) ZeusTransformUtils.preCheckCast(new gy(0, gd.f9146a.a(), r8, r8, NetError.ERR_TOO_MANY_REDIRECTS, 0, getPackageName(), getHashCodeValue(), getEntityId(), r21.a(), r21.b(), 33, null), f.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.e
    public String a() {
        return this.r;
    }

    @Override // com.obric.memorydata.database.entity.e
    public void a(String r1) {
        this.r = r1;
    }

    public final String c() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        RecordingEntity r11 = new RecordingEntity(getEntityId(), getCreateTime(), getModifyTime(), this.i, com.obric.memorydata.personalcontext.util.f.b(this.j), this.k);
        String r0 = this.l;
        String r2 = null;
        if (r0 != null) goto L5;
        FileEntity r1 = null;
    L6:
        r11.setTranscript(r1);
        r11.setSummary(this.m);
        String r3 = this.o;
        if (r3 != null) goto L31;
    L15:
        List<Integer> r4 = null;
    L16:
        r11.setMarkers(r4);
        String r5 = this.n;
        if (r5 != null) goto L33;
    L25:
        List<String> r6 = null;
    L26:
        r11.setTodoList(r6);
        r11.setSourceAppName(this.p);
        r11.setSourceAppPackage(this.q);
        List<String> r7 = b();
        if (r7 == null) goto L29;
        JSONObject r8 = new JSONObject();
        r8.put("relevantTextContent", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")));
        r2 = r8.toString();
    L29:
        r11.setExtraData(r2);
        return (AppEntity) ZeusTransformUtils.preCheckCast(r11, AppEntity.class, "com.obric.memorydata.plugin");
    L33:
        r6 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r5, new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L20 JsonSyntaxException -> L22
    L22:
        e = e;
        IRunLog r12 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder();
    L24:
        IRunLog.a.b(r12, "GsonExt", r9.append("toListObj error : ").append(e).toString(), null, 4, null);
    L20:
        e = e;
        r12 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r9 = new StringBuilder();
        goto L24
    L31:
        r4 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r3, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L10 JsonSyntaxException -> L12
    L12:
        e = e;
        IRunLog r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder();
    L14:
        IRunLog.a.b(r13, "GsonExt", r10.append("toListObj error : ").append(e).toString(), null, 4, null);
    L10:
        e = e;
        r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r10 = new StringBuilder();
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
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new dy(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final String d() {
        return this.j;
    }

    public final int e() {
        return this.k;
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
        return this.f9168b;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9167a;
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

    public final String h() {
        return this.n;
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

    @Override // com.obric.memorydata.database.entity.d
    public void onUpdate(Set<String> r6, d r7, d r8) {
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "updateColumns");
        Intrinsics.checkNotNullParameter(r7, "oldEntity");
        Intrinsics.checkNotNullParameter(r8, "newEntity");
        super.onUpdate(r9, r7, r8);
        gw r5 = (gw) ZeusTransformUtils.preCheckCast(r7, gw.class, "com.obric.memorydata.plugin");
        gw r10 = (gw) ZeusTransformUtils.preCheckCast(r8, gw.class, "com.obric.memorydata.plugin");
        if (r9.contains("summary") == false) goto L5;
    L10:
        r5.delete();
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
        EntityManager.INSTANCE.launchIndexTask();
        return;
    L5:
        if (r9.contains("transcript") == true) goto L10;
        if (r5.getModifyTime() != r10.getModifyTime()) goto L10;
        if (r5.k != r10.k) goto L10;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9167a = r1;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }
}
