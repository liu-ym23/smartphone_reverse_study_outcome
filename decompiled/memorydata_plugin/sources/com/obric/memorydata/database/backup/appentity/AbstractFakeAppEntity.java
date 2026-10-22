package com.obric.memorydata.database.backup.appentity;

import android.os.Parcel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.d;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0006\u0010\u0013\u001a\u00020\u0003¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/backup/appentity/AbstractFakeAppEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "id", "", "createTime", "", "modifyTime", "type", "", "packageName", "<init>", "(Ljava/lang/String;JJILjava/lang/String;)V", "onReadSubClassExtensionField", "", "parcel", "Landroid/os/Parcel;", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "toExtraJsonString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractFakeAppEntity extends AppEntity {
    public static final a Companion = null;
    public static final String FAKE_ENTITY_FLAG = "isFakeAppEntity";
    private static final String ID_KEY = "id";
    private static final String PACKAGE_NAME_KEY = "packageName";
    private static final String TAG = "AbstractFakeAppEntity";
    private static final String TYPE_KEY = "type";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/database/backup/appentity/AbstractFakeAppEntity$Companion;", "", "<init>", "()V", "FAKE_ENTITY_FLAG", "", "TAG", "ID_KEY", "PACKAGE_NAME_KEY", "TYPE_KEY", "createFakeEntityFromJsonString", "Lcom/obric/memorydata/database/backup/appentity/AbstractFakeAppEntity;", "jsonObject", "Lcom/google/gson/JsonObject;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final AbstractFakeAppEntity a(JsonObject r15) {
            Intrinsics.checkNotNullParameter(r15, "jsonObject");
            JsonElement r14 = r15.get("id");
            String r0 = "";
            if (r14 == null) goto L6;
            String r16 = r14.getAsString();
            if (r16 == null) goto L6;
        L7:
            JsonElement r1 = r15.get("type");
            boolean r2 = false;
            if (r1 == null) goto L10;
            int r3 = r1.getAsInt();
        L11:
            JsonElement r17 = r15.get("packageName");
            if (r17 == null) goto L18;
            String r18 = r17.getAsString();
            if (r18 == null) goto L18;
            r0 = r18;
        L18:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L20;
            boolean r19 = true;
        L22:
            if (r19 == true) goto L42;
            if (r3 == 0) goto L42;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L27;
            r2 = true;
        L27:
            if (r2 == true) goto L42;
            IAppEntityRawDbDao<d> r110 = s.a().getRawDaoByEntityType(r3);
            if (r110 != null) goto L34;
            IRunLog r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r111 = new StringBuilder().append("createFakeEntityFromJsonString, rawDao is null, type = ").append(r3);
        L32:
            IRunLog.a.a(r8, AbstractFakeAppEntity.TAG, r111.toString(), null, 4, null);
            return null;
        L34:
            d r112 = (d) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r110.queryByEntityId(r16, r0)), d.class, "com.obric.memorydata.plugin");
            if (r112 != null) goto L38;
            r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r113 = new StringBuilder();
            String r4 = "createFakeEntityFromJsonString, rawDbEntity is null, id = ";
        L37:
            r111 = r113.append(r4).append(r16).append(", type = ").append(r3).append(", packageName = ").append(r0);
            goto L32
        L38:
            AbstractFakeAppEntity r114 = r112.convertToFakeAppEntity();
            if (r114 != null) goto L41;
            r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r113 = new StringBuilder();
            r4 = "createFakeEntityFromJsonString, convert fakeAppEntity is null, id = ";
            goto L37
        L41:
            return r114;
        L42:
            r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r113 = new StringBuilder();
            r4 = "createFakeEntityFromJsonString, invalid params, id = ";
            goto L37
        L20:
            r19 = false;
            goto L22
        L10:
            r3 = 0;
        L6:
            r16 = "";
            goto L7
        }
    }

    static {
        Companion = new a(null);
    }

    public AbstractFakeAppEntity(String r2, long r3, long r5, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r8, "packageName");
        super(r2, r3, r5, r7);
        set_packageName(r8);
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final String toExtraJsonString() {
        JsonObject r0 = new JsonObject();
        r0.addProperty(FAKE_ENTITY_FLAG, true);
        r0.addProperty("id", getId());
        r0.addProperty("type", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(getType()), Number.class, "com.obric.memorydata.plugin"));
        r0.addProperty("packageName", get_packageName());
        String r4 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        return r4;
    }
}
