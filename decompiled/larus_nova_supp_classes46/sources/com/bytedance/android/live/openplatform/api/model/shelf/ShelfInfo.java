package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.ShelfInfo")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\"\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0014\u0010!\u001a\u00020 8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0018R\u0016\u0010$\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u0016\u0010%\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0018¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "Landroid/os/Parcelable;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/b;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "appInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "cardInfoList", "Ljava/util/List;", "", "startId", "J", "source", "status", "", "punishStatus", "I", "mountType", "", "", "startPageQuery", "Ljava/util/Map;", "imExtra", "Ljava/lang/String;", "logExtra", "clientExtra", "coexistRoom", "coexistKAAnchor", "coexistLogExtra", "shelfInfoToken", "schema", "", "isAutoMount", "Z", "openExtra", "entryPagePath", "mpLiveChannel", "MountType", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfInfo implements Parcelable, b, h {
    public static final Parcelable.Creator<ShelfInfo> CREATOR = null;
    public JSONObject a;

    @SerializedName("app_info")
    public ShelfMicroAppInfo appInfo;

    @SerializedName("card_info_list")
    public List<ShelfCardInfo> cardInfoList;

    @SerializedName("client_extra")
    public String clientExtra;

    @SerializedName("coexist_ka_anchor")
    public int coexistKAAnchor;

    @SerializedName("coexist_log_extra")
    public String coexistLogExtra;

    @SerializedName("coexist_room")
    public int coexistRoom;

    @IgnoreProtoFieldCheck
    @SerializedName("entry_page_path")
    public final String entryPagePath;

    @SerializedName("im_extra")
    public String imExtra;

    @IgnoreProtoFieldCheck
    @SerializedName("is_auto_mount")
    public final boolean isAutoMount;

    @SerializedName("log_extra")
    public String logExtra;

    @SerializedName("mount_type")
    public int mountType;

    @IgnoreProtoFieldCheck
    @SerializedName("mp_live_channel")
    public final String mpLiveChannel;

    @IgnoreProtoFieldCheck
    @SerializedName("open_extra")
    public final String openExtra;

    @SerializedName("punish_status")
    public int punishStatus;

    @SerializedName("schema")
    public String schema;

    @SerializedName("shelf_info_token")
    public String shelfInfoToken;

    @SerializedName("source")
    public long source;

    @SerializedName("start_id")
    public long startId;

    @SerializedName("start_page_query")
    public Map<String, String> startPageQuery;

    @SerializedName("status")
    public long status;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo$MountType;", "", "", "value", "I", "getValue", "()I", "UnsetMount", "NormalMount", "AdStarMount", "TalentMount", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MountType extends Enum<MountType> {
        public static final MountType AdStarMount = null;
        public static final MountType NormalMount = null;
        public static final MountType TalentMount = null;
        public static final MountType UnsetMount = null;
        public static final /* synthetic */ MountType[] a = null;
        private final int value;

        static {
            MountType r1 = new MountType("UnsetMount", 0, 0);
            UnsetMount = r1;
            MountType r2 = new MountType("NormalMount", 1, 1);
            NormalMount = r2;
            MountType r3 = new MountType("AdStarMount", 2, 2);
            AdStarMount = r3;
            MountType r4 = new MountType("TalentMount", 3, 3);
            TalentMount = r4;
            a = new MountType[]{r1, r2, r3, r4};
        }

        public static MountType valueOf(String r1) {
            return (MountType) r27.a.a(MountType.class, r1);
        }

        public static MountType[] values() {
            return (MountType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public MountType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class a implements Parcelable.Creator<ShelfInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShelfInfo createFromParcel(Parcel r28) {
            Intrinsics.checkNotNullParameter(r28, "in");
            LinkedHashMap r3 = null;
            if (r28.readInt() == 0) goto L5;
            ShelfMicroAppInfo r4 = ShelfMicroAppInfo.CREATOR.createFromParcel(r28);
        L7:
            if (r28.readInt() == 0) goto L11;
            int r2 = r28.readInt();
            ArrayList r5 = new ArrayList(r2);
        L9:
            if (r2 == 0) goto L12;
            r5.add(ShelfCardInfo.CREATOR.createFromParcel(r28));
            r2 = r2 - 1;
        L12:
            long r6 = r28.readLong();
            long r8 = r28.readLong();
            long r10 = r28.readLong();
            int r12 = r28.readInt();
            int r13 = r28.readInt();
            if (r28.readInt() == 0) goto L17;
            int r7 = r28.readInt();
            r3 = new LinkedHashMap(r7);
        L15:
            if (r7 == 0) goto L17;
            r3.put(r28.readString(), r28.readString());
            r7 = r7 - 1;
        L17:
            LinkedHashMap r14 = r3;
            String r15 = r28.readString();
            String r16 = r28.readString();
            String r17 = r28.readString();
            int r18 = r28.readInt();
            int r19 = r28.readInt();
            String r20 = r28.readString();
            String r21 = r28.readString();
            String r22 = r28.readString();
            if (r28.readInt() == 0) goto L20;
            boolean r26 = true;
        L22:
            return new ShelfInfo(r4, r5, r6, r8, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r26, r28.readString(), r28.readString(), r28.readString());
        L20:
            r26 = false;
            goto L22
        L11:
            r5 = null;
            goto L12
        L5:
            r4 = null;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ShelfInfo[] newArray(int r1) {
            return new ShelfInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ShelfInfo(ShelfMicroAppInfo r4, List<ShelfCardInfo> r5, long r6, long r8, long r10, int r12, int r13, Map<String, String> r14, String r15, String r16, String r17, int r18, int r19, String r20, String r21, String r22, boolean r23, String r24, String r25, String r26) {
        this.appInfo = r4;
        this.cardInfoList = r5;
        this.startId = r6;
        this.source = r8;
        this.status = r10;
        this.punishStatus = r12;
        this.mountType = r13;
        this.startPageQuery = r14;
        this.imExtra = r15;
        this.logExtra = r16;
        this.clientExtra = r17;
        this.coexistRoom = r18;
        this.coexistKAAnchor = r19;
        this.coexistLogExtra = r20;
        this.shelfInfoToken = r21;
        this.schema = r22;
        this.isAutoMount = r23;
        this.openExtra = r24;
        this.entryPagePath = r25;
        this.mpLiveChannel = r26;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof ShelfInfo) == false) goto L46;
        ShelfInfo r7 = (ShelfInfo) r6;
        if (Intrinsics.areEqual(this.appInfo, r7.appInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cardInfoList, r7.cardInfoList) == true) goto L10;
        return false;
    L10:
        if (this.startId == r7.startId) goto L12;
        return false;
    L12:
        if (this.source == r7.source) goto L14;
        return false;
    L14:
        if (this.status == r7.status) goto L16;
        return false;
    L16:
        if (this.punishStatus == r7.punishStatus) goto L18;
        return false;
    L18:
        if (this.mountType == r7.mountType) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.startPageQuery, r7.startPageQuery) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.imExtra, r7.imExtra) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.logExtra, r7.logExtra) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.clientExtra, r7.clientExtra) == true) goto L28;
        return false;
    L28:
        if (this.coexistRoom == r7.coexistRoom) goto L30;
        return false;
    L30:
        if (this.coexistKAAnchor == r7.coexistKAAnchor) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.coexistLogExtra, r7.coexistLogExtra) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.shelfInfoToken, r7.shelfInfoToken) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.schema, r7.schema) == true) goto L38;
        return false;
    L38:
        if (this.isAutoMount == r7.isAutoMount) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.openExtra, r7.openExtra) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.entryPagePath, r7.entryPagePath) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.mpLiveChannel, r7.mpLiveChannel) == true) goto L70;
        return false;
    L70:
        return true;
    L46:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35, types: [int] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v54 */
    public final int hashCode() {
        ShelfMicroAppInfo r0 = this.appInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<ShelfCardInfo> r4 = this.cardInfoList;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.startId;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.source;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        long r11 = this.status;
        int r12 = (((((r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31) + this.punishStatus) * 31) + this.mountType) * 31;
        Map<String, String> r13 = this.startPageQuery;
        if (r13 == null) goto L13;
        int r14 = r13.hashCode();
    L14:
        int r15 = (r12 + r14) * 31;
        String r16 = this.imExtra;
        if (r16 == null) goto L17;
        int r17 = r16.hashCode();
    L18:
        int r18 = (r15 + r17) * 31;
        String r19 = this.logExtra;
        if (r19 == null) goto L21;
        int r20 = r19.hashCode();
    L22:
        int r21 = (r18 + r20) * 31;
        String r22 = this.clientExtra;
        if (r22 == null) goto L25;
        int r23 = r22.hashCode();
    L26:
        int r24 = (((((r21 + r23) * 31) + this.coexistRoom) * 31) + this.coexistKAAnchor) * 31;
        String r25 = this.coexistLogExtra;
        if (r25 == null) goto L29;
        int r26 = r25.hashCode();
    L30:
        int r27 = (r24 + r26) * 31;
        String r28 = this.shelfInfoToken;
        if (r28 == null) goto L33;
        int r29 = r28.hashCode();
    L34:
        int r30 = (r27 + r29) * 31;
        String r31 = this.schema;
        if (r31 == null) goto L37;
        int r32 = r31.hashCode();
    L38:
        int r33 = (r30 + r32) * 31;
        boolean r34 = this.isAutoMount;
        ?? r35 = r34;
        if (r34 == false) goto L41;
        r35 = 1;
    L41:
        int r36 = (r33 + r35) * 31;
        String r37 = this.openExtra;
        if (r37 == null) goto L44;
        int r38 = r37.hashCode();
    L45:
        int r39 = (r36 + r38) * 31;
        String r40 = this.entryPagePath;
        if (r40 == null) goto L48;
        int r41 = r40.hashCode();
    L49:
        int r42 = (r39 + r41) * 31;
        String r43 = this.mpLiveChannel;
        if (r43 == null) goto L53;
        r1 = r43.hashCode();
    L53:
        return r42 + r1;
    L48:
        r41 = 0;
        goto L49
    L44:
        r38 = 0;
        goto L45
    L37:
        r32 = 0;
        goto L38
    L33:
        r29 = 0;
        goto L34
    L29:
        r26 = 0;
        goto L30
    L25:
        r23 = 0;
        goto L26
    L21:
        r20 = 0;
        goto L22
    L17:
        r17 = 0;
        goto L18
    L13:
        r14 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ShelfInfo(appInfo=" + this.appInfo + ", cardInfoList=" + this.cardInfoList + ", startId=" + this.startId + ", source=" + this.source + ", status=" + this.status + ", punishStatus=" + this.punishStatus + ", mountType=" + this.mountType + ", startPageQuery=" + this.startPageQuery + ", imExtra=" + this.imExtra + ", logExtra=" + this.logExtra + ", clientExtra=" + this.clientExtra + ", coexistRoom=" + this.coexistRoom + ", coexistKAAnchor=" + this.coexistKAAnchor + ", coexistLogExtra=" + this.coexistLogExtra + ", shelfInfoToken=" + this.shelfInfoToken + ", schema=" + this.schema + ", isAutoMount=" + this.isAutoMount + ", openExtra=" + this.openExtra + ", entryPagePath=" + this.entryPagePath + ", mpLiveChannel=" + this.mpLiveChannel + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        ShelfMicroAppInfo r7 = this.appInfo;
        if (r7 == null) goto L5;
        r5.writeInt(1);
        r7.writeToParcel(r5, 0);
    L6:
        List<ShelfCardInfo> r8 = this.cardInfoList;
        if (r8 == null) goto L12;
        r5.writeInt(1);
        r5.writeInt(r8.size());
        Iterator<ShelfCardInfo> r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L13;
        r9.next().writeToParcel(r5, 0);
    L13:
        r5.writeLong(this.startId);
        r5.writeLong(this.source);
        r5.writeLong(this.status);
        r5.writeInt(this.punishStatus);
        r5.writeInt(this.mountType);
        Map<String, String> r10 = this.startPageQuery;
        if (r10 == null) goto L19;
        r5.writeInt(1);
        r5.writeInt(r10.size());
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();
    L17:
        if (r11.hasNext() == false) goto L20;
        Map.Entry<String, String> r0 = r11.next();
        r5.writeString(r0.getKey());
        r5.writeString(r0.getValue());
    L20:
        r5.writeString(this.imExtra);
        r5.writeString(this.logExtra);
        r5.writeString(this.clientExtra);
        r5.writeInt(this.coexistRoom);
        r5.writeInt(this.coexistKAAnchor);
        r5.writeString(this.coexistLogExtra);
        r5.writeString(this.shelfInfoToken);
        r5.writeString(this.schema);
        r5.writeInt(this.isAutoMount ? 1 : 0);
        r5.writeString(this.openExtra);
        r5.writeString(this.entryPagePath);
        r5.writeString(this.mpLiveChannel);
        return;
    L19:
        r5.writeInt(0);
        goto L20
    L12:
        r5.writeInt(0);
        goto L13
    L5:
        r5.writeInt(0);
        goto L6
    }

    public final String b() {
        Intrinsics.checkNotNullParameter("coexist_module", "key");
        if (this.a != null) goto L9;
        String r2 = this.coexistLogExtra;     // Catch: JSONException -> L15
        if (r2 != null) goto L8;
        r2 = "{}";
    L8:
        this.a = new JSONObject(r2);     // Catch: JSONException -> L15
    L9:
        JSONObject r0 = this.a;     // Catch: JSONException -> L15
        if (r0 == null) goto L13;
        String r1 = r0.optString("coexist_module");     // Catch: JSONException -> L15
        if (r1 == null) goto L13;
        return r1;
    L13:
        return "";
    }

    public final String c() {
        SchemaInfo.b r0 = SchemaInfo.s;
        List<ShelfCardInfo> r1 = this.cardInfoList;
        if (r1 == null) goto L7;
        ShelfCardInfo r2 = (ShelfCardInfo) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L7;
        String r3 = r2.schema;
    L8:
        r0.getClass();
        SchemaInfo r4 = SchemaInfo.b.b(r3);
        if (r4 == null) goto L14;
        JSONObject r5 = r4.b();
        if (r5 == null) goto L14;
        String r6 = r5.optString("enter_position");
        if (r6 == null) goto L14;
        return r6;
    L14:
        return "";
    L7:
        r3 = null;
        goto L8
    }

    public final boolean d() {
        if (this.mountType != MountType.AdStarMount.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e() {
        if (this.mountType != MountType.TalentMount.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public ShelfInfo() {
        this.appInfo = null;
        this.cardInfoList = null;
        this.startId = 0;
        this.source = 0;
        this.status = 0;
        this.punishStatus = 0;
        this.mountType = MountType.UnsetMount.getValue();
        this.startPageQuery = null;
        this.imExtra = null;
        this.logExtra = null;
        this.clientExtra = null;
        this.coexistRoom = 0;
        this.coexistKAAnchor = 0;
        this.coexistLogExtra = null;
        this.shelfInfoToken = null;
        this.schema = null;
    }

    public ShelfInfo(am3.g r12) {
        this.cardInfoList = new ArrayList();
        this.startPageQuery = new HashMap();
        long r0 = r12.c();
        int r3 = 0;
    L3:
        int r4 = r12.f();
        String r6 = null;
        if (r4 == (-1)) goto L42;
        switch(r4) {
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L35;
            default: goto L6;
        };
    L35:
        this.mountType = r12.i();
        r3 = r3 | 16;
        goto L3
    L36:
        this.punishStatus = r12.i();
        r3 = r3 | 8;
        goto L3
    L37:
        this.status = r12.i();
        r3 = r3 | 4;
        goto L3
    L38:
        this.source = r12.i();
        r3 = r3 | 2;
        goto L3
    L39:
        this.startId = r12.j();
        r3 = r3 | 1;
        goto L3
    L40:
        this.cardInfoList.add(new ShelfCardInfo(r12));
        goto L3
    L41:
        this.appInfo = new ShelfMicroAppInfo(r12);
        goto L3
    L6:
        switch(r4) {
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L32;
            default: goto L7;
        };
    L32:
        this.coexistKAAnchor = r12.i();
        r3 = r3 | 64;
        goto L3
    L33:
        this.coexistRoom = r12.i();
        r3 = r3 | 32;
        goto L3
    L34:
        this.clientExtra = am3.h.c(r12);
        goto L3
    L7:
        switch(r4) {
            case 95: goto L31;
            case 96: goto L13;
            case 97: goto L12;
            case 98: goto L11;
            case 99: goto L10;
            case 100: goto L9;
            default: goto L8;
        };
    L9:
        this.schema = am3.h.c(r12);
        goto L3
    L10:
        this.shelfInfoToken = am3.h.c(r12);
        goto L3
    L11:
        this.logExtra = am3.h.c(r12);
        goto L3
    L12:
        this.imExtra = am3.h.c(r12);
        goto L3
    L13:
        long r7 = r12.c();
        String r5 = null;
    L14:
        int r9 = r12.f();
        if (r9 == (-1)) goto L23;
        if (r9 != 1) goto L19;
        r6 = am3.h.c(r12);
        goto L14
    L19:
        if (r9 != 2) goto L20;
        r5 = am3.h.c(r12);
        goto L14
    L20:
        am3.h.e(r12);
        goto L14
    L23:
        r12.d(r7);
        Map<String, String> r8 = this.startPageQuery;
        if (r6 == null) goto L30;
        if (r5 == null) goto L28;
        r8.put(r6, r5);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L31:
        this.coexistLogExtra = am3.h.c(r12);
        goto L3
    L8:
        am3.h.e(r12);
        goto L3
    L42:
        r12.d(r0);
        if (this.appInfo != null) goto L46;
        this.appInfo = null;
    L46:
        if (this.cardInfoList.isEmpty() == false) goto L49;
        this.cardInfoList = null;
    L49:
        if ((r3 & 1) != 0) goto L52;
        this.startId = 0;
    L52:
        if ((r3 & 2) != 0) goto L55;
        this.source = 0;
    L55:
        if ((r3 & 4) != 0) goto L58;
        this.status = 0;
    L58:
        if ((r3 & 8) != 0) goto L61;
        this.punishStatus = 0;
    L61:
        if ((r3 & 16) != 0) goto L64;
        this.mountType = MountType.UnsetMount.getValue();
    L64:
        if (this.startPageQuery != null) goto L67;
        this.startPageQuery = null;
    L67:
        if (this.imExtra != null) goto L70;
        this.imExtra = null;
    L70:
        if (this.logExtra != null) goto L73;
        this.logExtra = null;
    L73:
        if (this.clientExtra != null) goto L76;
        this.clientExtra = null;
    L76:
        if ((r3 & 32) != 0) goto L79;
        this.coexistRoom = 0;
    L79:
        if ((r3 & 64) != 0) goto L82;
        this.coexistKAAnchor = 0;
    L82:
        if (this.coexistLogExtra != null) goto L85;
        this.coexistLogExtra = null;
    L85:
        if (this.shelfInfoToken != null) goto L88;
        this.shelfInfoToken = null;
    L88:
        if (this.schema != null) goto L140;
        this.schema = null;
        return;
    }

    public /* synthetic */ ShelfInfo(ShelfMicroAppInfo r27, List r28, int r29, String r30, String r31, String r32, int r33) {
        if ((r33 & 1) == 0) goto L5;
        ShelfMicroAppInfo r3 = null;
    L7:
        if ((r33 & 2) == 0) goto L9;
        List r4 = null;
    L11:
        if ((r33 & 64) == 0) goto L13;
        int r12 = MountType.UnsetMount.getValue();
    L15:
        if ((r33 & 131072) == 0) goto L17;
        String r23 = null;
    L19:
        if ((r33 & 262144) == 0) goto L21;
        String r24 = null;
    L23:
        if ((r33 & 524288) == 0) goto L25;
        String r25 = null;
    L26:
        this(r3, r4, 0, 0, 0, 0, r12, null, null, null, null, 0, 0, null, null, null, false, r23, r24, r25);
        return;
    L25:
        r25 = r32;
        goto L26
    L21:
        r24 = r31;
        goto L23
    L17:
        r23 = r30;
        goto L19
    L13:
        r12 = r29;
        goto L15
    L9:
        r4 = r28;
        goto L11
    L5:
        r3 = r27;
        goto L7
    }

    public static ShelfInfo a(ShelfInfo r27, ShelfMicroAppInfo r28, List r29, boolean r30, String r31, String r32, String r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        ShelfMicroAppInfo r4 = r27.appInfo;
    L7:
        if ((r34 & 2) == 0) goto L9;
        List r5 = r27.cardInfoList;
    L11:
        if ((r34 & 4) == 0) goto L13;
        long r8 = r27.startId;
    L15:
        if ((r34 & 8) == 0) goto L17;
        long r10 = r27.source;
    L19:
        if ((r34 & 16) == 0) goto L21;
        long r12 = r27.status;
    L23:
        if ((r34 & 32) == 0) goto L25;
        int r2 = r27.punishStatus;
    L27:
        if ((r34 & 64) == 0) goto L29;
        int r14 = r27.mountType;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Map<String, String> r15 = r27.startPageQuery;
    L35:
        if ((r34 & 256) == 0) goto L37;
        String r16 = r27.imExtra;
    L39:
        if ((r34 & 512) == 0) goto L41;
        String r17 = r27.logExtra;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        String r18 = r27.clientExtra;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        int r19 = r27.coexistRoom;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        int r20 = r27.coexistKAAnchor;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        String r21 = r27.coexistLogExtra;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        String r22 = r27.shelfInfoToken;
    L63:
        if ((32768 & r34) == 0) goto L65;
        String r23 = r27.schema;
    L67:
        if ((65536 & r34) == 0) goto L69;
        boolean r24 = r27.isAutoMount;
    L71:
        if ((131072 & r34) == 0) goto L73;
        String r25 = r27.openExtra;
    L75:
        if ((262144 & r34) == 0) goto L77;
        String r26 = r27.entryPagePath;
    L79:
        if ((r34 & 524288) == 0) goto L81;
        String r1 = r27.mpLiveChannel;
    L82:
        r27.getClass();
        return new ShelfInfo(r4, r5, r8, r10, r12, r2, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r1);
    L81:
        r1 = r33;
        goto L82
    L77:
        r26 = r32;
        goto L79
    L73:
        r25 = r31;
        goto L75
    L69:
        r24 = r30;
        goto L71
    L65:
        r23 = null;
        goto L67
    L61:
        r22 = null;
        goto L63
    L57:
        r21 = null;
        goto L59
    L53:
        r20 = 0;
        goto L55
    L49:
        r19 = 0;
        goto L51
    L45:
        r18 = null;
        goto L47
    L41:
        r17 = null;
        goto L43
    L37:
        r16 = null;
        goto L39
    L33:
        r15 = null;
        goto L35
    L29:
        r14 = 0;
        goto L31
    L25:
        r2 = 0;
        goto L27
    L21:
        r12 = 0;
        goto L23
    L17:
        r10 = 0;
        goto L19
    L13:
        r8 = 0;
        goto L15
    L9:
        r5 = r29;
        goto L11
    L5:
        r4 = r28;
        goto L7
    }
}
