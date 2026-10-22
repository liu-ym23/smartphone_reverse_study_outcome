package com.bytedance.ai.bridge.protocol.model;

import ai.j0;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0011\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;", "", "Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Scope;", "a", "Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Scope;", "b", "()Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Scope;", "scope", "Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Target;", "Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Target;", "c", "()Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Target;", "target", "", "Ljava/lang/String;", "()Ljava/lang/String;", "instance", "Scope", "Target", "applet-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TargetEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("scope")
    private final Scope f2030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("target")
    private final Target f2031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("instance")
    private final String f2032c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Scope;", "", "a", "b", "c", "d", "applet-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Scope extends Enum<Scope> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("system")
        public static final Scope f2033a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("view")
        public static final Scope f2034b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName(JvmProtoBufUtil.DEFAULT_MODULE_NAME)
        public static final Scope f2035c = null;

        @SerializedName(OpenPageMethod.APP_FLOATING)
        public static final Scope d = null;
        public static final /* synthetic */ Scope[] e = null;

        static {
            Scope r5 = new Scope("System", 0);
            f2033a = r5;
            Scope r10 = new Scope("View", 1);
            f2034b = r10;
            Scope r11 = new Scope("Main", 2);
            f2035c = r11;
            Scope r12 = new Scope("Floating", 3);
            d = r12;
            Scope[] r13 = {r5, r10, r11, r12};
            e = r13;
            EnumEntriesKt.enumEntries(r13);
        }

        public Scope(String r5, int r10) {
            super(r5, r10);
        }

        public static Scope valueOf(String r5) {
            return (Scope) Enum.valueOf(Scope.class, r5);
        }

        public static Scope[] values() {
            return (Scope[]) e.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Target;", "", "a", "b", "c", "d", "e", "applet-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Target extends Enum<Target> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("bridge")
        public static final Target f2036a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("with_instance_id")
        public static final Target f2037b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("self")
        public static final Target f2038c = null;

        @SerializedName("current")
        public static final Target d = null;

        @SerializedName("all")
        public static final Target e = null;
        public static final /* synthetic */ Target[] f = null;

        static {
            Target r5 = new Target("Bridge", 0);
            f2036a = r5;
            Target r10 = new Target("InstanceId", 1);
            f2037b = r10;
            Target r11 = new Target("Self", 2);
            f2038c = r11;
            Target r12 = new Target("Current", 3);
            d = r12;
            Target r13 = new Target("All", 4);
            e = r13;
            Target[] r14 = {r5, r10, r11, r12, r13};
            f = r14;
            EnumEntriesKt.enumEntries(r14);
        }

        public Target(String r5, int r10) {
            super(r5, r10);
        }

        public static Target valueOf(String r5) {
            return (Target) Enum.valueOf(Target.class, r5);
        }

        public static Target[] values() {
            return (Target[]) f.clone();
        }
    }

    public TargetEntity() {
        this.f2030a = null;
        this.f2031b = null;
        this.f2032c = null;
    }

    public final String a() {
        return this.f2032c;
    }

    public final Scope b() {
        return this.f2030a;
    }

    public final Target c() {
        return this.f2031b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TargetEntity) == true) goto L8;
        return false;
    L8:
        TargetEntity r10 = (TargetEntity) r5;
        if (this.f2030a == r10.f2030a) goto L12;
        return false;
    L12:
        if (this.f2031b == r10.f2031b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f2032c, r10.f2032c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Scope r5 = this.f2030a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Target r13 = this.f2031b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f2032c;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return r15 + r10;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("TargetEntity(scope=");
        r5.append(this.f2030a);
        r5.append(", target=");
        r5.append(this.f2031b);
        r5.append(", instance=");
        return j0.p(r5, this.f2032c, ')');
    }
}
