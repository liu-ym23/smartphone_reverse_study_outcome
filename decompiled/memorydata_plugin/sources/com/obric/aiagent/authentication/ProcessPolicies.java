package com.obric.aiagent.authentication;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B=\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JE\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/aiagent/authentication/ProcessPolicies;", "", "subject", "", "", TypedValues.AttributesType.S_TARGET, "actions", "", "Lcom/obric/aiagent/authentication/ActionPolicy;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getSubject", "()Ljava/util/List;", "getTarget", "getActions", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "authentication_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProcessPolicies {
    private final Map<String, ActionPolicy> actions;
    private final List<String> subject;
    private final List<String> target;

    public ProcessPolicies(List<String> r3, List<String> r4, Map<String, ActionPolicy> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Map<String, ActionPolicy> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.subject = r6;
        this.target = r7;
        this.actions = r8;
    }

    public static /* synthetic */ ProcessPolicies copy$default(ProcessPolicies r1, List r2, List r3, Map r4, int r5, Object r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Map<String, ActionPolicy> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.subject;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = r1.target;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r9 = r1.actions;
    L12:
        return r1.copy(r7, r8, r9);
    }

    public final List<String> component1() {
        return this.subject;
    }

    public final List<String> component2() {
        return this.target;
    }

    public final Map<String, ActionPolicy> component3() {
        return this.actions;
    }

    public final ProcessPolicies copy(List<String> r2, List<String> r3, Map<String, ActionPolicy> r4) {
        return new ProcessPolicies((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ProcessPolicies.class) == true) goto L8;
        return false;
    L8:
        ProcessPolicies r6 = (ProcessPolicies) ZeusTransformUtils.preCheckCast(r5, ProcessPolicies.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.subject, r6.subject) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final Map<String, ActionPolicy> getActions() {
        return this.actions;
    }

    public final List<String> getSubject() {
        return this.subject;
    }

    public final List<String> getTarget() {
        return this.target;
    }

    public int hashCode() {
        List<String> r0 = this.subject;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.target;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, ActionPolicy> r7 = this.actions;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ProcessPolicies(subject=" + this.subject + ", target=" + this.target + ", actions=" + this.actions + ')';
    }
}
