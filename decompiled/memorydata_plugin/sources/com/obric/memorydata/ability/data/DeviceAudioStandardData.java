package com.obric.memorydata.ability.data;

import com.obric.memorydata.database.dao.OsAudioPlayDao;
import com.obric.memorydata.database.entity.eb;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u0019\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/ability/data/DeviceAudioStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", "appList", "", "Lcom/obric/memorydata/ability/data/AudioAppInfo;", "<init>", "(Ljava/util/List;)V", "getAppList", "()Ljava/util/List;", "getDataId", "", "getDataVersion", "collectNewData", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceAudioStandardData implements h, com.obric.memorydata.ability.m {
    private final List<AudioAppInfo> appList;

    public DeviceAudioStandardData(List<AudioAppInfo> r3) {
        List<AudioAppInfo> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "appList");
        this.appList = r4;
    }

    public static /* synthetic */ DeviceAudioStandardData copy$default(DeviceAudioStandardData r1, List r2, int r3, Object r4) {
        List<AudioAppInfo> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.appList;
    L6:
        return r1.copy(r5);
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.appList, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        long r6 = 0;
    L4:
        if (r1.hasNext() == false) goto L20;
        AudioAppInfo r2 = (AudioAppInfo) ZeusTransformUtils.preCheckCast(r1.next(), AudioAppInfo.class, "com.obric.memorydata.plugin");
        if (r2.getActive() == true) goto L4;
        OsAudioPlayDao r7 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOsAudioPlayDao();
        String r8 = r2.getPackageName();
        String r9 = r2.getAudioType();
        int r10 = r2.getOutputType();
        long r11 = r2.getBeginTime();
        Long r12 = r2.getEndTime();
        if (r12 == null) goto L10;
        long r13 = r12.longValue();
    L11:
        Long r14 = r2.getEndTime();
        if (r14 == null) goto L14;
        long r16 = r14.longValue();
    L15:
        Long r15 = r2.getEndTime();
        if (r15 == null) goto L18;
        long r24 = r15.longValue() - r2.getBeginTime();
    L19:
        r6 = r7.insert(new eb(r8, r9, r10, r11, r13, r16, r24, getDataVersion(), 0, 256, null));
        goto L4
    L18:
        r24 = 0;
        goto L19
    L14:
        r16 = 0;
        goto L15
    L10:
        r13 = 0;
        goto L11
    L20:
        return r6;
    }

    public final List<AudioAppInfo> component1() {
        return this.appList;
    }

    public final DeviceAudioStandardData copy(List<AudioAppInfo> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "appList");
        return new DeviceAudioStandardData(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DeviceAudioStandardData.class) == true) goto L8;
        return false;
    L8:
        DeviceAudioStandardData r6 = (DeviceAudioStandardData) ZeusTransformUtils.preCheckCast(r5, DeviceAudioStandardData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.appList, r6.appList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final List<AudioAppInfo> getAppList() {
        return this.appList;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return 100001010;
    }

    public long getDataTimestamp() {
        return h.a.a(this);
    }

    public int getDataVersion() {
        return 1;
    }

    public long getDatabaseItemId() {
        return com.obric.memorydata.ability.m.a.a(this);
    }

    public int hashCode() {
        return this.appList.hashCode();
    }

    public String toString() {
        return "DeviceAudioStandardData(appList=" + this.appList + ')';
    }
}
