package com.obric.memorydata.ability.data;

import com.obric.memorydata.database.entity.ce;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\fHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/ability/data/LanguageChangeEventStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", "previousLanguage", "", "currentLanguage", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPreviousLanguage", "()Ljava/lang/String;", "getCurrentLanguage", "dataVersion", "", "dataId", "timestamp", "", "getDataId", "getDataVersion", "collectNewData", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j implements h, com.obric.memorydata.ability.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8332b;
    private final int c;
    private final int d;
    private final long e;

    public j(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "previousLanguage");
        Intrinsics.checkNotNullParameter(r3, "currentLanguage");
        this.f8331a = r2;
        this.f8332b = r3;
        this.c = 1;
        this.d = 100000009;
        this.e = System.currentTimeMillis();
    }

    public int a() {
        return this.c;
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLanguageChangeEventDao().insert(new ce(getDataId(), a(), this.e, this.f8331a, this.f8332b, 0, 32, null));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8331a, r6.f8331a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8332b, r6.f8332b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return this.d;
    }

    public int hashCode() {
        return (this.f8331a.hashCode() * 31) + this.f8332b.hashCode();
    }

    public String toString() {
        return "LanguageChangeEventStandardData(previousLanguage=" + this.f8331a + ", currentLanguage=" + this.f8332b + ')';
    }
}
