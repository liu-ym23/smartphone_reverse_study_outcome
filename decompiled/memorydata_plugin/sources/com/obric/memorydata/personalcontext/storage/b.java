package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.entity.AlarmSwitchStatus;
import com.obric.memorydata.database.entity.fe;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/AlarmEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "index", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "delete", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "isLazyIndex", "getRawDbEntityFromEntityId", "isEnableLazyIndex", "type", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends com.obric.memorydata.personalcontext.storage.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12342a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/AlarmEntityStorage$Companion;", "", "<init>", "()V", "getDefaultStatus", "", "extraData", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ String a(a r0, String r1) {
            return r0.a(r1);
        }

        private final String a(final String r3) {
            if (r3 != null) goto L5;
            return "default";
        L5:
            String r4 = (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a(null, new $$Lambda$b$a$K_M3poXYcivxMQOad_3GOYkzftQ(r3), 1, null), String.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L9;
            return "default";
        L9:
            return r4;
        }

        private static final String b(String r2) {
            return new JSONObject(r2).optString("alarmState", "default");
        }

        public static /* synthetic */ String lambda$K_M3poXYcivxMQOad_3GOYkzftQ(String r0) {
            return b(r0);
        }
    }

    static {
        f12342a = new a(null);
    }

    public b() {
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r28, boolean r29) {
        Intrinsics.checkNotNullParameter(r28, "appEntity");
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r28, AlarmEntity.class) == true) goto L5;
        return null;
    L5:
        if (((AlarmEntity) ZeusTransformUtils.preCheckCast(r28, AlarmEntity.class, "com.obric.memorydata.plugin")).isEnabled() == false) goto L7;
        AlarmSwitchStatus r1 = AlarmSwitchStatus.ON;
    L8:
        String r7 = r28.getId();
        long r8 = r28.getCreateTime();
        long r10 = r28.getLastModifiedTime();
        int r12 = r28.getType();
        String r15 = r28.get_packageName();
        String r18 = ((AlarmEntity) ZeusTransformUtils.preCheckCast(r28, AlarmEntity.class, "com.obric.memorydata.plugin")).getName();
        String r19 = ((AlarmEntity) ZeusTransformUtils.preCheckCast(r28, AlarmEntity.class, "com.obric.memorydata.plugin")).getStartTime();
        String r20 = r1.name();
        List<Integer> r3 = ((AlarmEntity) ZeusTransformUtils.preCheckCast(r28, AlarmEntity.class, "com.obric.memorydata.plugin")).getRepeatDayOfWeek();
        if (r3 == null) goto L11;
        r2 = com.obric.memorydata.utils.u.a(r3);
    L11:
        boolean r22 = ((AlarmEntity) ZeusTransformUtils.preCheckCast(r28, AlarmEntity.class, "com.obric.memorydata.plugin")).getCloseInHoliday();
        int r16 = r28.getHashCodeValue();
        long r5 = 0;
        long r13 = 0;
        String r17 = null;
        String r23 = "";
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new fe(r5, r7, r8, r10, r12, r13, r15, r16, r17, r18, r19, r20, r2, r22, r23, ((AlarmEntity) ZeusTransformUtils.preCheckCast(r28, AlarmEntity.class, "com.obric.memorydata.plugin")).getRepeatType(), 289, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L7:
        r1 = AlarmSwitchStatus.OFF;
        goto L8
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlarmRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return false;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "appEntity");
        boolean r2 = super.a(r3);
        if (r2 == true) goto L5;
    L9:
        return r2;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, AlarmEntity.class) == false) goto L9;
        if (Intrinsics.areEqual(r3.get_packageName(), AppInfo.Alarm.getPackageName()) == false) goto L9;
        String r0 = a.a(f12342a, r3.getExtraData());
        com.obric.memorydata.personalcontext.realcontext.a.f12258a.a(r3.getId(), r0);
        goto L9
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean delete(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (Intrinsics.areEqual(r3, AppInfo.Alarm.getPackageName()) == false) goto L6;
        com.obric.memorydata.personalcontext.realcontext.a.f12258a.a(r2);
    L6:
        return super.delete(r2, r3);
    }
}
