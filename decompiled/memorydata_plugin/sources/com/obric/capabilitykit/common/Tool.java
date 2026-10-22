package com.obric.capabilitykit.common;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/Tool;", "", ActivityLifecycle.NAME, "", "desc", "register2cloud", "", TrackerImpl.PARAMS, "", "Lcom/obric/capabilitykit/common/Parameter;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getDesc", "()Ljava/lang/String;", "getName", "getParams", "()Ljava/util/List;", "getRegister2cloud", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Tool {
    private final String desc;
    private final String name;
    private final List<Parameter> params;
    private final boolean register2cloud;

    public Tool(String r3, String r4, boolean r5, List<Parameter> r6) {
        List<Parameter> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "desc");
        Intrinsics.checkNotNullParameter(r7, TrackerImpl.PARAMS);
        this.name = r3;
        this.desc = r4;
        this.register2cloud = r5;
        this.params = r7;
    }

    public /* synthetic */ Tool(String r2, String r3, boolean r4, List r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r8 = new ArrayList();
    L8:
        this(r2, r3, r4, r8);
    }

    public static /* synthetic */ Tool copy$default(Tool r1, String r2, String r3, boolean r4, List r5, int r6, Object r7) {
        List<Parameter> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.name;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.desc;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.register2cloud;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.params;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.desc;
    }

    public final boolean component3() {
        return this.register2cloud;
    }

    public final List<Parameter> component4() {
        return this.params;
    }

    public final Tool copy(String r2, String r3, boolean r4, List<Parameter> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, "desc");
        Intrinsics.checkNotNullParameter(r1, TrackerImpl.PARAMS);
        return new Tool(r2, r3, r4, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Tool.class) == true) goto L8;
        return false;
    L8:
        Tool r6 = (Tool) ZeusTransformUtils.preCheckCast(r5, Tool.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L15;
        return false;
    L15:
        if (this.register2cloud == r6.register2cloud) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Parameter> getParams() {
        return this.params;
    }

    public final boolean getRegister2cloud() {
        return this.register2cloud;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int r0 = ((this.name.hashCode() * 31) + this.desc.hashCode()) * 31;
        boolean r1 = this.register2cloud;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return ((r0 + r2) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "Tool(name=" + this.name + ", desc=" + this.desc + ", register2cloud=" + this.register2cloud + ", params=" + this.params + ')';
    }
}
