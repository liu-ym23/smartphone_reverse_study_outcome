package com.obric.memorydata.personalcontext.search.entity;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/entity/ValueWrapper;", "", EventBody.KEY_VALUE, "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ValueWrapper {

    @SerializedName(EventBody.KEY_VALUE)
    private final Object value;

    public ValueWrapper(Object r1) {
        this.value = r1;
    }

    public static /* synthetic */ ValueWrapper copy$default(ValueWrapper r0, Object r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.value;
    L6:
        return r0.copy(r1);
    }

    public final Object component1() {
        return this.value;
    }

    public final ValueWrapper copy(Object r1) {
        return new ValueWrapper(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ValueWrapper.class) == true) goto L8;
        return false;
    L8:
        ValueWrapper r6 = (ValueWrapper) ZeusTransformUtils.preCheckCast(r5, ValueWrapper.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.value, r6.value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        Object r0 = this.value;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ValueWrapper(value=" + this.value + ')';
    }
}
