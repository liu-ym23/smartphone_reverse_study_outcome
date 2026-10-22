package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.keva.KevaImpl;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.dao.MessageHistoryEntity;
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
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\b\u00108\u001a\u000209H\u0014J\b\u0010:\u001a\u00020;H\u0014J&\u0010<\u001a\u00020;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050>2\u0006\u0010?\u001a\u00020\u00012\u0006\u0010@\u001a\u00020\u0001H\u0014J\b\u0010A\u001a\u00020BH\u0016J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0012\u0010F\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020\u0005H\u0016J\n\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0018\u0010I\u001a\u00020J2\u0006\u0010E\u001a\u00020\u00052\u0006\u0010K\u001a\u00020LH\u0016J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\tHÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\tHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÙ\u0001\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010a\u001a\u00020B2\b\u0010b\u001a\u0004\u0018\u00010cHÖ\u0003J\t\u0010d\u001a\u00020\tHÖ\u0001J\t\u0010e\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010*R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010*R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001f\"\u0004\b5\u0010*R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010*¨\u0006f"}, d2 = {"Lcom/obric/memorydata/database/entity/RawMessageEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "telephones", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "contentWithTime", "textConversion", KevaImpl.PrivateConstants.FILES_DIR_NAME, "contactIds", "messageType", "messageStatusType", "fullContent", "telephoneStandardMap", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getTelephones", "getText", "getContentWithTime", "setContentWithTime", "getTextConversion", "getFiles", "getContactIds", "getMessageType", "getMessageStatusType", "getFullContent", "setFullContent", "getTelephoneStandardMap", "setTelephoneStandardMap", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "onFirstIndex", "", "onUpdate", "updateColumns", "", "oldEntity", "newEntity", "delete", "", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", "convertToImageVectorCopilotEntity", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "convertToContentTimeEntity", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "extractTime", "Lcom/obric/memorydata/database/index/ExtractTime;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class go extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9160b;
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
    private final String o;
    private final String p;
    private final String q;
    private String r;
    private String s;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    public go(long r23, String r25, long r26, long r28, int r30, long r31, String r33, int r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45) {
        Intrinsics.checkNotNullParameter(r25, "entityId");
        Intrinsics.checkNotNullParameter(r33, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r36, "telephones");
        Intrinsics.checkNotNullParameter(r37, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        super(r23, r25, r26, r28, r30, r31, r33, r34, r35, null, null, null, 3584, null);
        this.f9159a = r23;
        this.f9160b = r25;
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

    public /* synthetic */ go(long r28, String r30, long r31, long r33, int r35, long r36, String r38, int r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, int r51, DefaultConstructorMarker r52) {
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
        if ((r51 & 4096) == 0) goto L21;
        String r20 = null;
    L23:
        if ((131072 & r51) == 0) goto L25;
        String r25 = null;
    L27:
        if ((r51 & 262144) == 0) goto L29;
        String r26 = null;
    L30:
        this(r4, r30, r31, r33, r35, r12, r38, r39, r16, r41, r42, r19, r20, r45, r46, r47, r48, r25, r26);
        return;
    L29:
        r26 = r50;
        goto L30
    L25:
        r25 = r49;
        goto L27
    L21:
        r20 = r44;
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

    public final String a() {
        return this.j;
    }

    public final void a(String r1) {
        this.l = r1;
    }

    public final String b() {
        return this.k;
    }

    public final String c() {
        return this.l;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        List<FileEntity> r4 = null;
        List r0 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(this.j, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L5 JsonSyntaxException -> L7
    L10:
        if (r0 != null) goto L12;
        r0 = CollectionsKt.emptyList();
    L12:
        List<String> r2 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"));
        Map<String, com.obric.memorydata.utils.au> r5 = com.obric.memorydata.utils.t.f13260a.b(this.s);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        r6.add(com.obric.memorydata.utils.t.f13260a.a((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"), null, r5));
        goto L14
    L16:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao().queryByPhoneNumber(r2, AppInfo.Contact.getPackageName()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L18:
        if (r9.hasNext() == false) goto L20;
        AppEntity r10 = ((fx) ZeusTransformUtils.preCheckCast(r9.next(), fx.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ContactEntity");
        r8.add((ContactEntity) ZeusTransformUtils.preCheckCast(r10, ContactEntity.class, "com.obric.memorydata.plugin"));
        goto L18
    L20:
        MessageEntity r11 = new MessageEntity(getEntityId(), getCreateTime(), getModifyTime(), r14, this.k, (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"));
        r11.set_packageName(getPackageName());
        r11.setUuid(getUuid());
        r11.setMessageType(MessageTypeEnum.Companion.from(this.p));
        String r12 = this.n;
        if (r12 == null) goto L23;
        r4 = com.obric.memorydata.personalcontext.util.f.a(r12);
    L23:
        r11.setFiles(r4);
        r11.setMessageStatusType(MessageStatusTypeEnum.Companion.from(this.q));
        return (AppEntity) ZeusTransformUtils.preCheckCast(r11, AppEntity.class, "com.obric.memorydata.plugin");
    L7:
        e = e;
        IRunLog r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r15 = new StringBuilder();
    L9:
        IRunLog.a.b(r13, "GsonExt", r15.append("toListObj error : ").append(e).toString(), null, 4, null);
        r0 = null;
    L5:
        e = e;
        r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r15 = new StringBuilder();
        goto L9
    }

    @Override // com.obric.memorydata.database.entity.d
    public b convertToContentTimeEntity(String r21, ExtractTime r22) {
        Intrinsics.checkNotNullParameter(r21, "column");
        Intrinsics.checkNotNullParameter(r22, "extractTime");
        return (b) ZeusTransformUtils.preCheckCast(new di(0, getId(), r21, r22.getStartTimestamp(), r22.getEndTimestamp(), r22.getStartDateTimestamp(), r22.getEndDateTimestamp(), r22.getDeltaDay(), r22.getDeltaMonth(), r22.getDeltaYear(), 1, null), b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r10) {
        Intrinsics.checkNotNullParameter(r10, "column");
        return (i) ZeusTransformUtils.preCheckCast(new dj(0, getId(), r10, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public c convertToRawHistoryEntity() {
        return (c) ZeusTransformUtils.preCheckCast(new MessageHistoryEntity(0, this, 1, null), c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new dk(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
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
        if (ZeusTransformUtils.instanceOf(r9, go.class) == true) goto L8;
        return false;
    L8:
        go r10 = (go) ZeusTransformUtils.preCheckCast(r9, go.class, "com.obric.memorydata.plugin");
        if (this.f9159a == r10.f9159a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9160b, r10.f9160b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.s, r10.s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final String f() {
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
        return this.f9160b;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9159a;
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
        int r0 = ((((((((((((((Long.hashCode(this.f9159a) * 31) + this.f9160b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31;
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
        int r13 = (r10 + r12) * 31;
        String r14 = this.o;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.p;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.q;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.r;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.s;
        if (r26 == null) goto L39;
        r2 = r26.hashCode();
    L39:
        return r25 + r2;
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

    @Override // com.obric.memorydata.database.entity.d
    public void onFirstIndex() {
        super.onFirstIndex();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.n, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        gd.f9146a.a((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin"), KevaImpl.PrivateConstants.FILES_DIR_NAME, this.n);
        return;
    L12:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.memorydata.database.entity.d
    public void onUpdate(Set<String> r5, d r6, d r7) {
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "updateColumns");
        Intrinsics.checkNotNullParameter(r6, "oldEntity");
        Intrinsics.checkNotNullParameter(r7, "newEntity");
        super.onUpdate(r8, r6, r7);
        if (ZeusTransformUtils.instanceOf(r7, go.class) == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r6, go.class) == false) goto L23;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(((go) ZeusTransformUtils.preCheckCast(r7, go.class, "com.obric.memorydata.plugin")).n, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r9 = false;
        if (r4 != null) goto L9;
    L12:
        boolean r10 = true;
    L13:
        boolean r11 = !r10;
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(((go) ZeusTransformUtils.preCheckCast(r6, go.class, "com.obric.memorydata.plugin")).n, CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L16;
    L17:
        r9 = true;
    L19:
        if ((r11 | (!r9)) == false) goto L24;
        gd.f9146a.a(r7, KevaImpl.PrivateConstants.FILES_DIR_NAME, ((go) ZeusTransformUtils.preCheckCast(r7, go.class, "com.obric.memorydata.plugin")).n);
        return;
    L24:
        return;
    L16:
        if (r12.length() != 0) goto L19;
    L9:
        if (r4.length() == 0) goto L12;
        r10 = false;
        goto L13
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9159a = r1;
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
        r0.append("RawMessageEntity(id=").append(this.f9159a).append(", entityId=").append(this.f9160b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", uuid=").append(this.i).append(", telephones=").append(this.j).append(", text=").append(this.k).append(", contentWithTime=");
        r0.append(this.l).append(", textConversion=").append(this.m).append(", files=").append(this.n).append(", contactIds=").append(this.o).append(", messageType=").append(this.p).append(", messageStatusType=").append(this.q).append(", fullContent=").append(this.r).append(", telephoneStandardMap=").append(this.s).append(')');
        return r0.toString();
    }
}
