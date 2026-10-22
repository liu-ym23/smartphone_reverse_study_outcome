package com.obric.memorydata.database.legacy.entity;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\bC\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bû\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010#J\n\u0010^\u001a\u0004\u0018\u00010_H\u0014J\u001a\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010b\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u0005H\u0016J\u0012\u0010d\u001a\u0004\u0018\u00010a2\u0006\u0010b\u001a\u00020\u0005H\u0016J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\tHÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0005HÆ\u0003J\t\u0010l\u001a\u00020\tHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\t\u0010o\u001a\u00020\u0005HÆ\u0003J\t\u0010p\u001a\u00020\u0005HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\t\u0010s\u001a\u00020\u0005HÆ\u0003J\t\u0010t\u001a\u00020\u0015HÆ\u0003J\t\u0010u\u001a\u00020\tHÆ\u0003J\t\u0010v\u001a\u00020\tHÆ\u0003J\t\u0010w\u001a\u00020\u0015HÆ\u0003J\t\u0010x\u001a\u00020\u0015HÆ\u0003J\t\u0010y\u001a\u00020\u001bHÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010{\u001a\u00020\u0005HÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\t\u0010}\u001a\u00020\u0005HÆ\u0003J\t\u0010~\u001a\u00020\u0005HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0015HÆ\u0003J\u009c\u0002\u0010\u0080\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u0015HÆ\u0001J\u0016\u0010\u0081\u0001\u001a\u00020\u00152\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001HÖ\u0003J\n\u0010\u0084\u0001\u001a\u00020\tHÖ\u0001J\n\u0010\u0085\u0001\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u001a\u0010\u0007\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010%\"\u0004\b,\u0010'R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010)R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010)\"\u0004\b4\u00105R\u001e\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u00105R\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u00105R\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010)\"\u0004\b;\u00105R\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010)\"\u0004\b=\u00105R\u001e\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010)\"\u0004\b?\u00105R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010)\"\u0004\bA\u00105R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010.\"\u0004\bG\u0010HR\u001e\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010.\"\u0004\bJ\u0010HR\u001e\u0010\u0018\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010C\"\u0004\bL\u0010ER\u001e\u0010\u0019\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010C\"\u0004\bN\u0010ER\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010)\"\u0004\bT\u00105R\u001e\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010)\"\u0004\bV\u00105R\u001e\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010)\"\u0004\bX\u00105R\u001e\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010)\"\u0004\bZ\u00105R\u001e\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010)\"\u0004\b\\\u00105R\u0016\u0010!\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010C¨\u0006\u0086\u0001"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/UnionSemanticMemoryEntityOld;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "semanticType", "tagPath", "keyPhrase", "description", "embeddingContent", "sources", "userEdit", "", "evidenceCount", "productType", "useForInsight", "useForPersona", "confidence", "", "logId", "importantRawRefIds", "sourceRawRefIds", "sceneIds", "sourcePackageName", "personalDbSplitMigrated", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIIZZFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "setModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getSemanticType", "setSemanticType", "getTagPath", "setTagPath", "getKeyPhrase", "setKeyPhrase", "getDescription", "setDescription", "getEmbeddingContent", "setEmbeddingContent", "getSources", "setSources", "getUserEdit", "()Z", "setUserEdit", "(Z)V", "getEvidenceCount", "setEvidenceCount", "(I)V", "getProductType", "setProductType", "getUseForInsight", "setUseForInsight", "getUseForPersona", "setUseForPersona", "getConfidence", "()F", "setConfidence", "(F)V", "getLogId", "setLogId", "getImportantRawRefIds", "setImportantRawRefIds", "getSourceRawRefIds", "setSourceRawRefIds", "getSceneIds", "setSceneIds", "getSourcePackageName", "setSourcePackageName", "getPersonalDbSplitMigrated", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ac extends com.obric.memorydata.database.entity.d {
    private final boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9483b;
    private final long c;
    private long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private boolean p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private float u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public ac(long r31, String r33, long r34, long r36, int r38, long r39, String r41, int r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, boolean r50, int r51, int r52, boolean r53, boolean r54, float r55, String r56, String r57, String r58, String r59, String r60, boolean r61) {
        Intrinsics.checkNotNullParameter(r33, "entityId");
        Intrinsics.checkNotNullParameter(r41, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r44, "semanticType");
        Intrinsics.checkNotNullParameter(r45, "tagPath");
        Intrinsics.checkNotNullParameter(r46, "keyPhrase");
        Intrinsics.checkNotNullParameter(r47, "description");
        Intrinsics.checkNotNullParameter(r48, "embeddingContent");
        Intrinsics.checkNotNullParameter(r49, "sources");
        Intrinsics.checkNotNullParameter(r57, "importantRawRefIds");
        Intrinsics.checkNotNullParameter(r58, "sourceRawRefIds");
        Intrinsics.checkNotNullParameter(r59, "sceneIds");
        Intrinsics.checkNotNullParameter(r60, "sourcePackageName");
        Integer r10 = null;
        super(r31, r33, r34, r36, r38, r39, r41, r42, r43, r10, r10, null, 3584, null);
        this.f9482a = r31;
        this.f9483b = r33;
        this.c = r34;
        this.d = r36;
        this.e = r38;
        this.f = r39;
        this.g = r41;
        this.h = r42;
        this.i = r43;
        this.j = r44;
        this.k = r45;
        this.l = r46;
        this.m = r47;
        this.n = r48;
        this.o = r49;
        this.p = r50;
        this.q = r51;
        this.r = r52;
        this.s = r53;
        this.t = r54;
        this.u = r55;
        this.v = r56;
        this.w = r57;
        this.x = r58;
        this.y = r59;
        this.z = r60;
        this.A = r61;
    }

    public /* synthetic */ ac(long r36, String r38, long r39, long r41, int r43, long r44, String r46, int r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, boolean r55, int r56, int r57, boolean r58, boolean r59, float r60, String r61, String r62, String r63, String r64, String r65, boolean r66, int r67, DefaultConstructorMarker r68) {
        if ((r67 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r67 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r67 & 256) == 0) goto L13;
        String r16 = UUID.randomUUID().toString();
    L15:
        if ((262144 & r67) == 0) goto L17;
        boolean r26 = false;
    L19:
        if ((524288 & r67) == 0) goto L21;
        boolean r27 = false;
    L23:
        if ((1048576 & r67) == 0) goto L25;
        float r28 = 0.0f;
    L27:
        if ((2097152 & r67) == 0) goto L29;
        String r29 = null;
    L31:
        if ((4194304 & r67) == 0) goto L33;
        String r30 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L35:
        if ((8388608 & r67) == 0) goto L37;
        String r31 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L39:
        if ((16777216 & r67) == 0) goto L41;
        String r32 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L43:
        if ((33554432 & r67) == 0) goto L45;
        String r33 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L47:
        if ((r67 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L49;
        boolean r34 = false;
    L50:
        this(r4, r38, r39, r41, r43, r12, r46, r47, r16, r49, r50, r51, r52, r53, r54, r55, r56, r57, r26, r27, r28, r29, r30, r31, r32, r33, r34);
        return;
    L49:
        r34 = r66;
        goto L50
    L45:
        r33 = r65;
        goto L47
    L41:
        r32 = r64;
        goto L43
    L37:
        r31 = r63;
        goto L39
    L33:
        r30 = r62;
        goto L35
    L29:
        r29 = r61;
        goto L31
    L25:
        r28 = r60;
        goto L27
    L21:
        r27 = r59;
        goto L23
    L17:
        r26 = r58;
        goto L19
    L13:
        r16 = r48;
        goto L15
    L9:
        r12 = r44;
        goto L11
    L5:
        r4 = r36;
        goto L7
    }

    public final String a() {
        return this.j;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    public final String b() {
        return this.k;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.n = r2;
    }

    public final String c() {
        return this.l;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.i convertToTextVectorCopilotEntity(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "column");
        Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return null;
    }

    public final String d() {
        return this.m;
    }

    public final String e() {
        return this.n;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ac.class) == true) goto L8;
        return false;
    L8:
        ac r10 = (ac) ZeusTransformUtils.preCheckCast(r9, ac.class, "com.obric.memorydata.plugin");
        if (this.f9482a == r10.f9482a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9483b, r10.f9483b) == true) goto L15;
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
        if (this.p == r10.p) goto L57;
        return false;
    L57:
        if (this.q == r10.q) goto L60;
        return false;
    L60:
        if (this.r == r10.r) goto L63;
        return false;
    L63:
        if (this.s == r10.s) goto L66;
        return false;
    L66:
        if (this.t == r10.t) goto L69;
        return false;
    L69:
        if (Float.compare(this.u, r10.u) == 0) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r10.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r10.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r10.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r10.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r10.z) == true) goto L87;
        return false;
    L87:
        if (this.A == r10.A) goto L89;
        return false;
    L89:
        return true;
    }

    public final String f() {
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
        return this.f9483b;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9482a;
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

    public final int h() {
        return this.q;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.f9482a) * 31) + this.f9483b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31;
        String r1 = this.i;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((((((((((((((((((r0 + r3) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + Boolean.hashCode(this.p)) * 31) + Integer.hashCode(this.q)) * 31) + Integer.hashCode(this.r)) * 31) + Boolean.hashCode(this.s)) * 31) + Boolean.hashCode(this.t)) * 31) + Float.hashCode(this.u)) * 31;
        String r5 = this.v;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((((((((r4 + r2) * 31) + this.w.hashCode()) * 31) + this.x.hashCode()) * 31) + this.y.hashCode()) * 31) + this.z.hashCode()) * 31) + Boolean.hashCode(this.A);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final int i() {
        return this.r;
    }

    public final boolean j() {
        return this.s;
    }

    public final boolean k() {
        return this.t;
    }

    public final float l() {
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

    public final String p() {
        return this.y;
    }

    public final String q() {
        return this.z;
    }

    public final boolean r() {
        return this.A;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9482a = r1;
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
        r0.append("UnionSemanticMemoryEntityOld(id=").append(this.f9482a).append(", entityId=").append(this.f9483b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", uuid=").append(this.i).append(", semanticType=").append(this.j).append(", tagPath=").append(this.k).append(", keyPhrase=");
        r0.append(this.l).append(", description=").append(this.m).append(", embeddingContent=").append(this.n).append(", sources=").append(this.o).append(", userEdit=").append(this.p).append(", evidenceCount=").append(this.q).append(", productType=").append(this.r).append(", useForInsight=").append(this.s).append(", useForPersona=").append(this.t).append(", confidence=").append(this.u).append(", logId=").append(this.v).append(", importantRawRefIds=").append(this.w);
        r0.append(", sourceRawRefIds=").append(this.x).append(", sceneIds=").append(this.y).append(", sourcePackageName=").append(this.z).append(", personalDbSplitMigrated=").append(this.A).append(')');
        return r0.toString();
    }
}
