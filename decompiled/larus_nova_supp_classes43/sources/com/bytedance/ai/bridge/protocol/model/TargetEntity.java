package com.bytedance.ai.bridge.protocol.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;", "", "scope", "Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Scope;", "target", "Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Target;", "instance", "", "<init>", "(Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Scope;Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Target;Ljava/lang/String;)V", "getScope", "()Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Scope;", "getTarget", "()Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Target;", "getInstance", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Scope", "Target", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TargetEntity {

    @SerializedName("instance")
    private final String instance;

    @SerializedName("scope")
    private final Scope scope;

    @SerializedName("target")
    private final Target target;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Scope;", "", "<init>", "(Ljava/lang/String;I)V", "System", "View", "Main", "Floating", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Scope extends Enum<Scope> {

        @SerializedName("floating")
        public static final Scope Floating = null;

        @SerializedName("main")
        public static final Scope Main = null;

        @SerializedName("system")
        public static final Scope System = null;

        @SerializedName("view")
        public static final Scope View = null;
        public static final /* synthetic */ Scope[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Scope> getEntries() {
            return b;
        }

        static {
            Scope r0 = new Scope("System", 0);
            System = r0;
            Scope r1 = new Scope("View", 1);
            View = r1;
            Scope r10 = new Scope("Main", 2);
            Main = r10;
            Scope r11 = new Scope("Floating", 3);
            Floating = r11;
            Scope[] r12 = {r0, r1, r10, r11};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static Scope[] values() {
            return (Scope[]) a.clone();
        }

        public static Scope valueOf(String r1) {
            return (Scope) a.a(Scope.class, r1);
        }

        public Scope(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Target;", "", "text", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "Bridge", "InstanceId", "Self", "Current", "All", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Target extends Enum<Target> {

        @SerializedName("all")
        public static final Target All = null;

        @SerializedName("bridge")
        public static final Target Bridge = null;

        @SerializedName("current")
        public static final Target Current = null;

        @SerializedName("with_instance_id")
        public static final Target InstanceId = null;

        @SerializedName("self")
        public static final Target Self = null;
        public static final /* synthetic */ Target[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String text;

        public static EnumEntries<Target> getEntries() {
            return b;
        }

        static {
            Target r0 = new Target("Bridge", 0, "bridge");
            Bridge = r0;
            Target r1 = new Target("InstanceId", 1, "with_instance_id");
            InstanceId = r1;
            Target r10 = new Target("Self", 2, "self");
            Self = r10;
            Target r11 = new Target("Current", 3, "current");
            Current = r11;
            Target r12 = new Target("All", 4, "all");
            All = r12;
            Target[] r13 = {r0, r1, r10, r11, r12};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static Target[] values() {
            return (Target[]) a.clone();
        }

        public final String getText() {
            return this.text;
        }

        public static Target valueOf(String r1) {
            return (Target) a.a(Target.class, r1);
        }

        public Target(String r1, int r10, String r11) {
            super(r1, r10);
            this.text = r11;
        }
    }

    public TargetEntity() {
        this(null, null, 7);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TargetEntity) == true) goto L8;
        return false;
    L8:
        TargetEntity r11 = (TargetEntity) r10;
        if (this.scope == r11.scope) goto L12;
        return false;
    L12:
        if (this.target == r11.target) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.instance, r11.instance) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Scope r0 = this.scope;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        Target r12 = this.target;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.instance;
        if (r15 == null) goto L15;
        r1 = r15.hashCode();
    L15:
        return r14 + r1;
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TargetEntity(scope=" + this.scope + ", target=" + this.target + ", instance=" + this.instance + ')';
    }

    public final String a() {
        return this.instance;
    }

    public final Scope b() {
        return this.scope;
    }

    public final Target c() {
        return this.target;
    }

    public TargetEntity(Scope r10, Target r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this.scope = r10;
        this.target = r11;
        this.instance = null;
    }
}
