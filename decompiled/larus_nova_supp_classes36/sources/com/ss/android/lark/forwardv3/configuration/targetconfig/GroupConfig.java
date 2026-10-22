package com.ss.android.lark.forwardv3.configuration.targetconfig;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/GroupConfig;", "Ljava/io/Serializable;", "<init>", "()V", "value", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Tenant;", "tenant", "getTenant", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Tenant;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$GroupType;", "groupType", "getGroupType", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$GroupType;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Status;", "status", "getStatus", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Status;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Shield;", "shield", "getShield", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Shield;", "Builder", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class GroupConfig implements Serializable {
    private Condition$GroupType groupType;
    private Condition$Shield shield;
    private Condition$Status status;
    private Condition$Tenant tenant;

    public static final class a {
        public Condition$Tenant a;
        public Condition$GroupType b;
        public Condition$Status c;
        public Condition$Shield d;

        public final GroupConfig a() {
            GroupConfig r0 = new GroupConfig();
            GroupConfig.access$setTenant$p(r0, this.a);
            GroupConfig.access$setGroupType$p(r0, this.b);
            GroupConfig.access$setStatus$p(r0, this.c);
            GroupConfig.access$setShield$p(r0, this.d);
            return r0;
        }

        public a() {
            this.a = Condition$Tenant.ALL;
            this.b = Condition$GroupType.ALL;
            this.c = Condition$Status.ALL;
            this.d = Condition$Shield.ALL;
        }

        public final void b(Condition$Tenant r2) {
            Intrinsics.checkNotNullParameter(r2, "tenant");
            this.a = r2;
        }
    }

    public GroupConfig() {
        this.tenant = Condition$Tenant.ALL;
        this.groupType = Condition$GroupType.ALL;
        this.status = Condition$Status.ALL;
        this.shield = Condition$Shield.ALL;
    }

    public final Condition$GroupType getGroupType() {
        return this.groupType;
    }

    public final Condition$Shield getShield() {
        return this.shield;
    }

    public final Condition$Status getStatus() {
        return this.status;
    }

    public final Condition$Tenant getTenant() {
        return this.tenant;
    }

    public static final /* synthetic */ void access$setGroupType$p(GroupConfig r0, Condition$GroupType r1) {
        r0.groupType = r1;
    }

    public static final /* synthetic */ void access$setShield$p(GroupConfig r0, Condition$Shield r1) {
        r0.shield = r1;
    }

    public static final /* synthetic */ void access$setStatus$p(GroupConfig r0, Condition$Status r1) {
        r0.status = r1;
    }

    public static final /* synthetic */ void access$setTenant$p(GroupConfig r0, Condition$Tenant r1) {
        r0.tenant = r1;
    }
}
