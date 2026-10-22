package com.obric.memorydata.database.entity;

import androidx.fragment.app.FragmentTransaction;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.UserProfileEntity;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.backup.appentity.FakeUserProfileAppEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0001IB}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\n\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u001a\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0016J\u0012\u00101\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000205H\u0016J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0011HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u008f\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010D\u001a\u00020\u00112\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020\tHÖ\u0001J\t\u0010H\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010(R \u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010%¨\u0006J"}, d2 = {"Lcom/obric/memorydata/database/entity/RawUserProfileEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "profileKey", "profileValue", "isFromAutoLearn", "", "fullContent", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getProfileKey", "getProfileValue", "()Z", "getFullContent", "setFullContent", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/FakeUserProfileAppEntity;", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class hn extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9188b;
    private final String c;
    private final long d;
    private final long e;
    private final int f;
    private long g;
    private final String h;
    private final int i;
    private String j;
    private final String k;
    private final String l;
    private final boolean m;
    private String n;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/RawUserProfileEntity$Companion;", "", "<init>", "()V", "TAG", "", "donateUserProfileEntity", "", "profileKey", "Lcom/obric/memorydata/database/entity/ProfileKey;", "profileValue", "isFromAutoLearn", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(ProfileKey r22, String r23, boolean r24) {
            Intrinsics.checkNotNullParameter(r22, "profileKey");
            Intrinsics.checkNotNullParameter(r23, "profileValue");
            long r9 = System.currentTimeMillis();
            int r12 = (r22.name() + r23).hashCode();
            if (ho.a(r22) == false) goto L5;
            String r0 = r22.name();
        L6:
            com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new hn(0, r0, r9, r9, EntityType.USER_PROFILE, r9, AppContext.INSTANCE.getPackageName(), r12, UUID.randomUUID().toString(), r22.name(), r23, r24, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
            EntityManager.INSTANCE.launchIndexTask();
            return;
        L5:
            r0 = gd.f9146a.a();
            goto L6
        }
    }

    static {
        f9187a = new a(null);
    }

    public hn(long r23, String r25, long r26, long r28, int r30, long r31, String r33, int r34, String r35, String r36, String r37, boolean r38, String r39) {
        Intrinsics.checkNotNullParameter(r25, "entityId");
        Intrinsics.checkNotNullParameter(r33, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r36, "profileKey");
        Intrinsics.checkNotNullParameter(r37, "profileValue");
        Integer r2 = null;
        super(r23, r25, r26, r28, r30, r31, r33, r34, r35, r2, r2, null, 3584, null);
        this.f9188b = r23;
        this.c = r25;
        this.d = r26;
        this.e = r28;
        this.f = r30;
        this.g = r31;
        this.h = r33;
        this.i = r34;
        this.j = r35;
        this.k = r36;
        this.l = r37;
        this.m = r38;
        this.n = r39;
    }

    public /* synthetic */ hn(long r22, String r24, long r25, long r27, int r29, long r30, String r32, int r33, String r34, String r35, String r36, boolean r37, String r38, int r39, DefaultConstructorMarker r40) {
        if ((r39 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r39 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r39 & 256) == 0) goto L13;
        String r16 = UUID.randomUUID().toString();
    L15:
        if ((r39 & 2048) == 0) goto L17;
        boolean r19 = false;
    L19:
        if ((r39 & 4096) == 0) goto L21;
        String r20 = null;
    L22:
        this(r4, r24, r25, r27, r29, r12, r32, r33, r16, r35, r36, r19, r20);
        return;
    L21:
        r20 = r38;
        goto L22
    L17:
        r19 = r37;
        goto L19
    L13:
        r16 = r34;
        goto L15
    L9:
        r12 = r30;
        goto L11
    L5:
        r4 = r22;
        goto L7
    }

    public final String a() {
        return this.k;
    }

    public final String b() {
        return this.l;
    }

    public final boolean c() {
        return this.m;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        return (AppEntity) ZeusTransformUtils.preCheckCast(new UserProfileEntity(getEntityId(), getCreateTime(), getModifyTime(), this.k, this.l, this.m), AppEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public /* synthetic */ AbstractFakeAppEntity convertToFakeAppEntity() {
        return (AbstractFakeAppEntity) ZeusTransformUtils.preCheckCast(e(), AbstractFakeAppEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public c convertToRawHistoryEntity() {
        return (c) ZeusTransformUtils.preCheckCast(new hp(0, this, 1, null), c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new jf(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final String d() {
        return this.n;
    }

    public FakeUserProfileAppEntity e() {
        return new FakeUserProfileAppEntity(this);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, hn.class) == true) goto L8;
        return false;
    L8:
        hn r10 = (hn) ZeusTransformUtils.preCheckCast(r9, hn.class, "com.obric.memorydata.plugin");
        if (this.f9188b == r10.f9188b) goto L12;
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
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L42;
        return false;
    L42:
        if (this.m == r10.m) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.n, r10.n) == true) goto L47;
        return false;
    L47:
        return true;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9188b;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getType() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.j;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.f9188b) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + Integer.hashCode(this.i)) * 31;
        String r1 = this.j;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + Boolean.hashCode(this.m)) * 31;
        String r5 = this.n;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9188b = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.g = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.j = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawUserProfileEntity(id=").append(this.f9188b).append(", entityId=").append(this.c).append(", createTime=").append(this.d).append(", modifyTime=").append(this.e).append(", type=").append(this.f).append(", timestamp=").append(this.g).append(", packageName=").append(this.h).append(", hashCodeValue=").append(this.i).append(", uuid=").append(this.j).append(", profileKey=").append(this.k).append(", profileValue=").append(this.l).append(", isFromAutoLearn=");
        r0.append(this.m).append(", fullContent=").append(this.n).append(')');
        return r0.toString();
    }
}
