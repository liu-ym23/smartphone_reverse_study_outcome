package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import com.obric.capabilitykit.entity.meta.MetaLocation;
import com.obric.memorydata.database.index.ExtractTime;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b2\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bí\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001f\u0010 J\b\u0010G\u001a\u00020HH\u0014J\n\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0010\u0010K\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u0005H\u0014J\u0018\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u0005H\u0016J\u0012\u0010Q\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020\u0005H\u0016J\u001a\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010T\u001a\u00020UH\u0016J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\tHÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\tHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\t\u0010c\u001a\u00020\u0005HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0015HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0097\u0002\u0010o\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010p\u001a\u00020\u00152\b\u0010q\u001a\u0004\u0018\u00010rHÖ\u0003J\t\u0010s\u001a\u00020\tHÖ\u0001J\t\u0010t\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u00101R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u0016\u0010\u000f\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&R\u0014\u0010\u0010\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u00108R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010&\"\u0004\b:\u00101R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u00101R \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010&\"\u0004\b?\u00101R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010&\"\u0004\bA\u00101R \u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010&\"\u0004\bC\u00101R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010&R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010&R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010&¨\u0006u"}, d2 = {"Lcom/obric/memorydata/database/entity/RawPhotoEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawPhotoEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, ActivityLifecycle.NAME, "file", "assetType", "inAlbum", "resolution", "fileSize", "isFavorite", "", "tags", "faces", "location", "caption", "contentWithTime", "ocr", "sourceAppName", "sourcePackageName", "sourceDevice", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getName", "getFile", "getAssetType", "getInAlbum", "getResolution", "getFileSize", "()Z", "getTags", "setTags", "getFaces", "getLocation", "setLocation", "getCaption", "setCaption", "getContentWithTime", "setContentWithTime", "getOcr", "setOcr", "getSourceAppName", "getSourcePackageName", "getSourceDevice", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "isValidateValue", "columnsName", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToContentTimeEntity", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "extractTime", "Lcom/obric/memorydata/database/index/ExtractTime;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class hb extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9175b;
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
    private final String m;
    private final String n;
    private final long o;
    private final boolean p;
    private String q;
    private final String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private final String w;
    private final String x;
    private final String y;

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

    public hb(long r27, String r29, long r30, long r32, int r34, long r35, String r37, int r38, String r39, String r40, String r41, String r42, String r43, String r44, long r45, boolean r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, String r55, String r56) {
        Intrinsics.checkNotNullParameter(r29, "entityId");
        Intrinsics.checkNotNullParameter(r37, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r40, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r41, "file");
        Intrinsics.checkNotNullParameter(r42, "assetType");
        Intrinsics.checkNotNullParameter(r43, "inAlbum");
        Intrinsics.checkNotNullParameter(r44, "resolution");
        super(r27, r29, r30, r32, r34, r35, r37, r38, r41, r42, r51, r53, r39);
        this.f9174a = r27;
        this.f9175b = r29;
        this.c = r30;
        this.d = r32;
        this.e = r34;
        this.f = r35;
        this.g = r37;
        this.h = r38;
        this.i = r39;
        this.j = r40;
        this.k = r41;
        this.l = r42;
        this.m = r43;
        this.n = r44;
        this.o = r45;
        this.p = r47;
        this.q = r48;
        this.r = r49;
        this.s = r50;
        this.t = r51;
        this.u = r52;
        this.v = r53;
        this.w = r54;
        this.x = r55;
        this.y = r56;
    }

    public /* synthetic */ hb(long r35, String r37, long r38, long r40, int r42, long r43, String r45, int r46, String r47, String r48, String r49, String r50, String r51, String r52, long r53, boolean r55, String r56, String r57, String r58, String r59, String r60, String r61, String r62, String r63, String r64, int r65, DefaultConstructorMarker r66) {
        if ((r65 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r65 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r65 & 256) == 0) goto L13;
        String r16 = UUID.randomUUID().toString();
    L15:
        if ((1048576 & r65) == 0) goto L17;
        String r29 = null;
    L19:
        if ((r65 & 16777216) == 0) goto L21;
        String r33 = null;
    L22:
        this(r4, r37, r38, r40, r42, r12, r45, r46, r16, r48, r49, r50, r51, r52, r53, r55, r56, r57, r58, r59, r29, r61, r62, r63, r33);
        return;
    L21:
        r33 = r64;
        goto L22
    L17:
        r29 = r60;
        goto L19
    L13:
        r16 = r47;
        goto L15
    L9:
        r12 = r43;
        goto L11
    L5:
        r4 = r35;
        goto L7
    }

    @Override // com.obric.memorydata.database.entity.g
    public String a() {
        return this.k;
    }

    @Override // com.obric.memorydata.database.entity.g
    public void a(String r1) {
        this.t = r1;
    }

    @Override // com.obric.memorydata.database.entity.g
    public String b() {
        return this.l;
    }

    @Override // com.obric.memorydata.database.entity.g
    public void b(String r1) {
        this.v = r1;
    }

    @Override // com.obric.memorydata.database.entity.g
    public String c() {
        return this.t;
    }

    public final void c(String r1) {
        this.q = r1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v21, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v38, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v60, types: [T, java.util.List] */
    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = CollectionsKt.emptyList();
        MetaLocation r5 = null;
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(this.m, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L5 JsonSyntaxException -> L7
    L11:
        if (r0 == null) goto L17;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlbumRawDbDao().queryByEntityIdList(r0), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        AppEntity r8 = ((fg) ZeusTransformUtils.preCheckCast(r2.next(), fg.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AlbumEntity");
        r7.add((AlbumEntity) ZeusTransformUtils.preCheckCast(r8, AlbumEntity.class, "com.obric.memorydata.plugin"));
        goto L14
    L16:
        r4.element = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    L17:
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        String r3 = this.r;
        if (r3 != null) goto L61;
    L32:
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        String r6 = this.q;
        if (r6 != null) goto L57;
    L47:
        String r11 = this.s;
        if (r11 == null) goto L52;
        gq r12 = (gq) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaLocationRawDbDao().queryByEntityId(r11, getPackageName())), gq.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L52;
        r5 = new MetaLocation(r12.b(), r12.c(), r12.d(), r12.e(), r12.f(), r12.g(), r12.h(), r12.i(), r12.j(), r12.k(), r12.l());
    L52:
        AssetTypeEnum r13 = AssetTypeEnum.Companion.from(b());
        if (r13 != null) goto L55;
        r13 = AssetTypeEnum.PHOTO;
    L55:
        PhotoEntity r14 = new PhotoEntity(getEntityId(), getCreateTime(), getModifyTime(), this.j, com.obric.memorydata.personalcontext.util.f.b(a()), r13, (List) ZeusTransformUtils.preCheckCast(r4.element, List.class, "com.obric.memorydata.plugin"), this.n, this.o, this.p);
        r14.set_packageName(getPackageName());
        r14.setUuid(getUuid());
        r14.setTags((List) ZeusTransformUtils.preCheckCast(r10.element, List.class, "com.obric.memorydata.plugin"));
        r14.setFaces((List) ZeusTransformUtils.preCheckCast(r9.element, List.class, "com.obric.memorydata.plugin"));
        r14.setLocation(r5);
        r14.setCaption(c());
        r14.setOcr(d());
        r14.setSourceAppName(this.w);
        r14.setSourcePackageName(this.x);
        r14.setSourceDevice(this.y);
        return (AppEntity) ZeusTransformUtils.preCheckCast(r14, AppEntity.class, "com.obric.memorydata.plugin");
    L57:
        List<String> r15 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r6, new c().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L36 JsonSyntaxException -> L38
    L41:
        if (r15 == null) goto L47;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaTagRawDbDao().queryByEntityIdList(r15), Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L44:
        if (r18.hasNext() == false) goto L46;
        r17.add(((gs) ZeusTransformUtils.preCheckCast(r18.next(), gs.class, "com.obric.memorydata.plugin")).b());
        goto L44
    L46:
        r10.element = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
        goto L47
    L38:
        e = e;
        IRunLog r19 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r20 = new StringBuilder();
    L40:
        IRunLog.a.b(r19, "GsonExt", r20.append("toListObj error : ").append(e).toString(), null, 4, null);
        r15 = null;
    L36:
        e = e;
        r19 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r20 = new StringBuilder();
        goto L40
    L61:
        List<String> r21 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r3, new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L21 JsonSyntaxException -> L23
    L26:
        if (r21 == null) goto L32;
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoFaceRawDbDao().queryByEntityIdList(r21), Iterable.class, "com.obric.memorydata.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r24 = r22.iterator();
    L29:
        if (r24.hasNext() == false) goto L31;
        AppEntity r25 = ((hc) ZeusTransformUtils.preCheckCast(r24.next(), hc.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.PhotoFaceEntity");
        r23.add((PhotoFaceEntity) ZeusTransformUtils.preCheckCast(r25, PhotoFaceEntity.class, "com.obric.memorydata.plugin"));
        goto L29
    L31:
        r9.element = (List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin");
        goto L32
    L23:
        e = e;
        IRunLog r26 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r27 = new StringBuilder();
    L25:
        IRunLog.a.b(r26, "GsonExt", r27.append("toListObj error : ").append(e).toString(), null, 4, null);
        r21 = null;
    L21:
        e = e;
        r26 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r27 = new StringBuilder();
    L7:
        e = e;
        IRunLog r28 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r29 = new StringBuilder();
    L9:
        IRunLog.a.b(r28, "GsonExt", r29.append("toListObj error : ").append(e).toString(), null, 4, null);
        r0 = null;
    L5:
        e = e;
        r28 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r29 = new StringBuilder();
        goto L9
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.b convertToContentTimeEntity(String r21, ExtractTime r22) {
        Intrinsics.checkNotNullParameter(r21, "column");
        Intrinsics.checkNotNullParameter(r22, "extractTime");
        return (com.obric.memorydata.database.entity.b) ZeusTransformUtils.preCheckCast(new eh(0, getId(), r21, r22.getStartTimestamp(), r22.getEndTimestamp(), r22.getStartDateTimestamp(), r22.getEndDateTimestamp(), r22.getDeltaDay(), r22.getDeltaMonth(), r22.getDeltaYear(), 1, null), com.obric.memorydata.database.entity.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r10) {
        Intrinsics.checkNotNullParameter(r10, "column");
        return (i) ZeusTransformUtils.preCheckCast(new ei(0, getId(), r10, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.c convertToRawHistoryEntity() {
        return (com.obric.memorydata.database.entity.c) ZeusTransformUtils.preCheckCast(new he(0, this, 1, null), com.obric.memorydata.database.entity.c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new ej(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.g
    public String d() {
        return this.v;
    }

    public final void d(String r1) {
        this.s = r1;
    }

    public final String e() {
        return this.j;
    }

    public final void e(String r1) {
        this.u = r1;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, hb.class) == true) goto L8;
        return false;
    L8:
        hb r10 = (hb) ZeusTransformUtils.preCheckCast(r9, hb.class, "com.obric.memorydata.plugin");
        if (this.f9174a == r10.f9174a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9175b, r10.f9175b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.x, r10.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r10.y) == true) goto L83;
        return false;
    L83:
        return true;
    }

    public final String f() {
        return this.m;
    }

    public final String g() {
        return this.n;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9175b;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9174a;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public int getType() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.i;
    }

    public final long h() {
        return this.o;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.f9174a) * 31) + this.f9175b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31;
        String r1 = this.i;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((((((((r0 + r3) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + Long.hashCode(this.o)) * 31) + Boolean.hashCode(this.p)) * 31;
        String r5 = this.q;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.r;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.s;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.t;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.u;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.v;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.w;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.x;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.y;
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

    public final boolean i() {
        return this.p;
    }

    @Override // com.obric.memorydata.database.entity.d
    public boolean isValidateValue(String r4) {
        Intrinsics.checkNotNullParameter(r4, "columnsName");
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L21;
        if (Intrinsics.areEqual(b(), "PHOTO") == false) goto L21;
        if (Intrinsics.areEqual(r4, "ocr") == false) goto L14;
        if (d() == null) goto L12;
        return true;
    L12:
        return false;
    L14:
        if (Intrinsics.areEqual(r4, "caption") == false) goto L21;
        if (c() == null) goto L19;
        return true;
    L19:
        return false;
    L21:
        return super.isValidateValue(r4);
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

    public final String m() {
        return this.u;
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

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9174a = r1;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.i = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawPhotoEntity(id=").append(this.f9174a).append(", entityId=").append(this.f9175b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", uuid=").append(this.i).append(", name=").append(this.j).append(", file=").append(this.k).append(", assetType=");
        r0.append(this.l).append(", inAlbum=").append(this.m).append(", resolution=").append(this.n).append(", fileSize=").append(this.o).append(", isFavorite=").append(this.p).append(", tags=").append(this.q).append(", faces=").append(this.r).append(", location=").append(this.s).append(", caption=").append(this.t).append(", contentWithTime=").append(this.u).append(", ocr=").append(this.v).append(", sourceAppName=").append(this.w);
        r0.append(", sourcePackageName=").append(this.x).append(", sourceDevice=").append(this.y).append(')');
        return r0.toString();
    }
}
