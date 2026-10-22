package com.ss.android.lark.forwardv3.configuration.targetconfig;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/UserConfig;", "Ljava/io/Serializable;", "<init>", "()V", "value", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Tenant;", "tenant", "getTenant", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Tenant;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$UserType;", "userType", "getUserType", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$UserType;", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Shield;", "shield", "getShield", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Shield;", "Builder", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class UserConfig implements Serializable {
    private Condition$Shield shield;
    private Condition$Tenant tenant;
    private Condition$UserType userType;

    public static final class a {
        public Condition$Tenant a;
        public Condition$UserType b;
        public Condition$Shield c;

        public final UserConfig a() {
            UserConfig r0 = new UserConfig();
            UserConfig.access$setTenant$p(r0, this.a);
            UserConfig.access$setUserType$p(r0, this.b);
            UserConfig.access$setShield$p(r0, this.c);
            return r0;
        }

        public a() {
            this.a = Condition$Tenant.ALL;
            this.b = Condition$UserType.ALL;
            this.c = Condition$Shield.ALL;
        }

        public final void b(Condition$Tenant r2) {
            Intrinsics.checkNotNullParameter(r2, "tenant");
            this.a = r2;
        }
    }

    public UserConfig() {
        this.tenant = Condition$Tenant.ALL;
        this.userType = Condition$UserType.ALL;
        this.shield = Condition$Shield.ALL;
    }

    public final Condition$Shield getShield() {
        return this.shield;
    }

    public final Condition$Tenant getTenant() {
        return this.tenant;
    }

    public final Condition$UserType getUserType() {
        return this.userType;
    }

    public static final /* synthetic */ void access$setShield$p(UserConfig r0, Condition$Shield r1) {
        r0.shield = r1;
    }

    public static final /* synthetic */ void access$setTenant$p(UserConfig r0, Condition$Tenant r1) {
        r0.tenant = r1;
    }

    public static final /* synthetic */ void access$setUserType$p(UserConfig r0, Condition$UserType r1) {
        r0.userType = r1;
    }
}
