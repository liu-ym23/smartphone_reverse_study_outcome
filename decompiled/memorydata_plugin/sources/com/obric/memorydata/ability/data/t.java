package com.obric.memorydata.ability.data;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\tHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/ability/data/TimeStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", OaidModel.KEY_TIME, "", "<init>", "(J)V", "getTime", "()J", "dataId", "", "dataVersion", "timestamp", "getDataId", "getDataVersion", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8351b;
    private final int c;
    private final long d;

    public t(long r1) {
        this.f8350a = r1;
        this.f8351b = 100000006;
        this.c = 1;
        this.d = System.currentTimeMillis();
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, t.class) == true) goto L8;
        return false;
    L8:
        t r8 = (t) ZeusTransformUtils.preCheckCast(r7, t.class, "com.obric.memorydata.plugin");
        if (this.f8350a == r8.f8350a) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return this.f8351b;
    }

    public int hashCode() {
        return Long.hashCode(this.f8350a);
    }

    public String toString() {
        return "TimeStandardData(time=" + this.f8350a + ')';
    }
}
