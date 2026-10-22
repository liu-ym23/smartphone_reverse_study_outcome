package com.obric.memorydata.init.tasks.pitaya;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/init/tasks/pitaya/APIInfo;", "", "module", "", "apiName", TrackerImpl.PARAMS, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getModule", "()Ljava/lang/String;", "getApiName", "getParams", "()Ljava/util/List;", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class APIInfo {

    @SerializedName("api_name")
    private final String apiName;
    private final String module;
    private final List<Object> params;

    public APIInfo(String r3, String r4, List<? extends Object> r5) {
        List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r4, "apiName");
        Intrinsics.checkNotNullParameter(r6, TrackerImpl.PARAMS);
        this.module = r3;
        this.apiName = r4;
        this.params = r6;
    }

    public static /* synthetic */ APIInfo copy$default(APIInfo r1, String r2, String r3, List r4, int r5, Object r6) {
        List<? extends Object> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.module;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.apiName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r7 = r1.params;
    L12:
        return r1.copy(r2, r3, r7);
    }

    public static /* synthetic */ CharSequence lambda$2nAkEyxaOL4H_KjEkXMCb31Zoe8(Object r0) {
        return toString$lambda$1(r0);
    }

    private static final CharSequence toString$lambda$1(Object r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Class<?> r5 = r4.getClass();
        String r0 = null;
        if (r5 == null) goto L12;
        String r2 = r5.getSimpleName();
        if (r2 == null) goto L12;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        Object r6 = ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
    L20:
        return (CharSequence) r6;
    L12:
        if (r5 == null) goto L15;
        r0 = r5.getName();
    L15:
        if (r0 != null) goto L18;
        r0 = "null";
    L18:
        r6 = ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        goto L20
    }

    public final String component1() {
        return this.module;
    }

    public final String component2() {
        return this.apiName;
    }

    public final List<Object> component3() {
        return this.params;
    }

    public final APIInfo copy(String r2, String r3, List<? extends Object> r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r3, "apiName");
        Intrinsics.checkNotNullParameter(r1, TrackerImpl.PARAMS);
        return new APIInfo(r2, r3, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, APIInfo.class) == true) goto L8;
        return false;
    L8:
        APIInfo r6 = (APIInfo) ZeusTransformUtils.preCheckCast(r5, APIInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.module, r6.module) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.apiName, r6.apiName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getApiName() {
        return this.apiName;
    }

    public final String getModule() {
        return this.module;
    }

    public final List<Object> getParams() {
        return this.params;
    }

    public int hashCode() {
        return (((this.module.hashCode() * 31) + this.apiName.hashCode()) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "APIInfo(module=" + this.module + ", apiName=" + this.apiName + ", paramsSize=" + this.params.size() + ", paramTypes=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(this.params, Iterable.class, "com.obric.memorydata.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$APIInfo$2nAkEyxaOL4H_KjEkXMCb31Zoe8.INSTANCE, 25, null) + ')';
    }
}
