package com.obric.aiagent.authentication;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/authentication/ActionPolicy;", "", "policy", "Lcom/obric/aiagent/authentication/PolicyItem;", "subActions", "", "", "<init>", "(Lcom/obric/aiagent/authentication/PolicyItem;Ljava/util/Map;)V", "getPolicy", "()Lcom/obric/aiagent/authentication/PolicyItem;", "getSubActions", "()Ljava/util/Map;", "getSubActionPolicy", "subAction", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "authentication_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ActionPolicy {
    private final PolicyItem policy;

    @SerializedName("sub_actions")
    private final Map<String, PolicyItem> subActions;

    public ActionPolicy(PolicyItem r3, Map<String, PolicyItem> r4) {
        Map<String, PolicyItem> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "policy");
        this.policy = r3;
        this.subActions = r5;
    }

    public static /* synthetic */ ActionPolicy copy$default(ActionPolicy r1, PolicyItem r2, Map r3, int r4, Object r5) {
        Map<String, PolicyItem> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.policy;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.subActions;
    L9:
        return r1.copy(r2, r6);
    }

    public final PolicyItem component1() {
        return this.policy;
    }

    public final Map<String, PolicyItem> component2() {
        return this.subActions;
    }

    public final ActionPolicy copy(PolicyItem r2, Map<String, PolicyItem> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "policy");
        return new ActionPolicy(r2, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ActionPolicy.class) == true) goto L8;
        return false;
    L8:
        ActionPolicy r6 = (ActionPolicy) ZeusTransformUtils.preCheckCast(r5, ActionPolicy.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.policy, r6.policy) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subActions, r6.subActions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final PolicyItem getPolicy() {
        return this.policy;
    }

    public final PolicyItem getSubActionPolicy(String r6) {
        Map<String, PolicyItem> r0 = this.subActions;
        if (r0 == null) goto L18;
        Set<Map.Entry<String, PolicyItem>> r1 = r0.entrySet();
        if (r1 == null) goto L18;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        if (StringsKt.equals((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin"), r6, true) == false) goto L8;
    L13:
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L18;
        PolicyItem r8 = (PolicyItem) ZeusTransformUtils.preCheckCast(r7.getValue(), PolicyItem.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L18;
        return r8;
    L12:
        r3 = null;
    L18:
        return this.policy;
    }

    public final Map<String, PolicyItem> getSubActions() {
        return this.subActions;
    }

    public int hashCode() {
        int r0 = this.policy.hashCode() * 31;
        Map<String, PolicyItem> r1 = this.subActions;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionPolicy(policy=" + this.policy + ", subActions=" + this.subActions + ')';
    }
}
