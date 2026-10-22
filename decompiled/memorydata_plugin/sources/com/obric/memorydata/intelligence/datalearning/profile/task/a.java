package com.obric.memorydata.intelligence.datalearning.profile.task;

import com.obric.memorydata.database.entity.dn;
import com.obric.memorydata.database.entity.je;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.intelligence.api.ProfileLabel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0007J\u001e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0007J\u001a\u0010\u0019\u001a\u00020\u00072\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c0\u001bJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/task/BaseProfileTask;", "", "profileTaskInfo", "Lcom/obric/memorydata/intelligence/datalearning/profile/task/ProfileTaskInfo;", "<init>", "(Lcom/obric/memorydata/intelligence/datalearning/profile/task/ProfileTaskInfo;)V", "computeLongTermProfile", "", "startTimestamp", "endTimestamp", "computeMidTermProfile", "taskIndex", "", "getTaskIndex", "()I", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "upsertLongProfile", "", "uriKey", "uriValue", "timestamp", "upsertMidProfile", "labelUpdateOrInsert", "data", "", "Lcom/obric/memorydata/intelligence/datalearning/profile/data/LabelValue;", "midProfileInsert", "profile", "Lcom/obric/memorydata/intelligence/datalearning/profile/data/MidProfile;", "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0483a f9966b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f9967a;

    /* JADX INFO: renamed from: com.obric.memorydata.intelligence.datalearning.profile.task.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/task/BaseProfileTask$Companion;", "", "<init>", "()V", "TAG", "", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0483a {
        private C0483a() {
        }

        public /* synthetic */ C0483a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9966b = new C0483a(null);
    }

    public a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "profileTaskInfo");
        this.f9967a = r2;
    }

    public final int a() {
        return this.f9967a.a();
    }

    public abstract long a(long r1, long r3);

    public final void a(com.obric.memorydata.intelligence.datalearning.profile.data.b r7) {
        Intrinsics.checkNotNullParameter(r7, "profile");
        long r0 = r7.b();
        Iterator<Map.Entry<ProfileLabel, String>> r8 = r7.a().entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        b(((ProfileLabel) ZeusTransformUtils.preCheckCast(r2.getKey(), ProfileLabel.class, "com.obric.memorydata.plugin")).toString(), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"), r0);
        goto L4
    }

    public final void a(String r11, String r12, long r13) {
        Intrinsics.checkNotNullParameter(r11, "uriKey");
        Intrinsics.checkNotNullParameter(r12, "uriValue");
        je r10 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().queryOneRecordBy(r11);
        if (r10 == null) goto L5;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().update(new je(r10.a(), r12, r13, r10.d()));
        return;
    L5:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().insert(new je(r11, r12, r13, 0, 8, null));
    }

    public abstract long b(long r1, long r3);

    public final String b() {
        String r1 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r1, "getSimpleName(...)");
        return r1;
    }

    public final void b(String r11, String r12, long r13) {
        Intrinsics.checkNotNullParameter(r11, "uriKey");
        Intrinsics.checkNotNullParameter(r12, "uriValue");
        dn r10 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMiddleUserProfileDao().queryOneRecordBy(r11, r13);
        if (r10 == null) goto L5;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMiddleUserProfileDao().update(new dn(r13, r10.b(), r12, r10.d()));
        return;
    L5:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMiddleUserProfileDao().insert(new dn(r13, r11, r12, 0, 8, null));
    }
}
