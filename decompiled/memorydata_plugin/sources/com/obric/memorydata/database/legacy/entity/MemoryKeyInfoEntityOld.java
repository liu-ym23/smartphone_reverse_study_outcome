package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/MemoryKeyInfoEntityOld;", "", OaidModel.KEY_ID, "", "sourceEntityId", "", "key", EventBody.KEY_VALUE, "", "personalDbSplitMigrated", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/Set;Z)V", "getId", "()J", "getSourceEntityId", "()Ljava/lang/String;", "getKey", "getValue", "()Ljava/util/Set;", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryKeyInfoEntityOld {
    private final long id;
    private final String key;
    private final boolean personalDbSplitMigrated;
    private final String sourceEntityId;
    private final Set<String> value;

    public MemoryKeyInfoEntityOld(long r3, String r5, String r6, Set<String> r7, boolean r8) {
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "sourceEntityId");
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r9, EventBody.KEY_VALUE);
        this.id = r3;
        this.sourceEntityId = r5;
        this.key = r6;
        this.value = r9;
        this.personalDbSplitMigrated = r8;
    }

    public /* synthetic */ MemoryKeyInfoEntityOld(long r8, String r10, String r11, Set r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        Set r16 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = 0;
    L5:
        long r1 = r8;
        if ((r14 & 8) == 0) goto L8;
        r16 = SetsKt.emptySet();
    L8:
        Set r5 = r16;
        if ((r14 & 16) == 0) goto L11;
        r13 = false;
    L11:
        this(r1, r10, r11, r5, r13);
    }

    public static /* synthetic */ MemoryKeyInfoEntityOld copy$default(MemoryKeyInfoEntityOld r7, long r8, String r10, String r11, Set r12, boolean r13, int r14, Object r15) {
        Set<String> r16 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.id;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = r7.sourceEntityId;
    L8:
        String r3 = r10;
        if ((r14 & 4) == 0) goto L11;
        r11 = r7.key;
    L11:
        String r4 = r11;
        if ((r14 & 8) == 0) goto L14;
        r16 = r7.value;
    L14:
        Set<String> r5 = r16;
        if ((r14 & 16) == 0) goto L18;
        r13 = r7.personalDbSplitMigrated;
    L18:
        return r7.copy(r1, r3, r4, r5, r13);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.sourceEntityId;
    }

    public final String component3() {
        return this.key;
    }

    public final Set<String> component4() {
        return this.value;
    }

    public final boolean component5() {
        return this.personalDbSplitMigrated;
    }

    public final MemoryKeyInfoEntityOld copy(long r8, String r10, String r11, Set<String> r12, boolean r13) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "sourceEntityId");
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        return new MemoryKeyInfoEntityOld(r8, r10, r11, r5, r13);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, MemoryKeyInfoEntityOld.class) == true) goto L8;
        return false;
    L8:
        MemoryKeyInfoEntityOld r10 = (MemoryKeyInfoEntityOld) ZeusTransformUtils.preCheckCast(r9, MemoryKeyInfoEntityOld.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceEntityId, r10.sourceEntityId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r10.key) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.value, r10.value) == true) goto L21;
        return false;
    L21:
        if (this.personalDbSplitMigrated == r10.personalDbSplitMigrated) goto L23;
        return false;
    L23:
        return true;
    }

    public final long getId() {
        return this.id;
    }

    public final String getKey() {
        return this.key;
    }

    public final boolean getPersonalDbSplitMigrated() {
        return this.personalDbSplitMigrated;
    }

    public final String getSourceEntityId() {
        return this.sourceEntityId;
    }

    public final Set<String> getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.id) * 31) + this.sourceEntityId.hashCode()) * 31) + this.key.hashCode()) * 31) + this.value.hashCode()) * 31) + Boolean.hashCode(this.personalDbSplitMigrated);
    }

    public String toString() {
        return "MemoryKeyInfoEntityOld(id=" + this.id + ", sourceEntityId=" + this.sourceEntityId + ", key=" + this.key + ", value=" + this.value + ", personalDbSplitMigrated=" + this.personalDbSplitMigrated + ')';
    }
}
