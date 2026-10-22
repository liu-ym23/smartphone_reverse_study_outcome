package org.bouncycastle.crypto;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class CryptoServicesPermission extends Permission {
    public static final String CONSTRAINTS = "constraints";
    public static final String DEFAULT_RANDOM = "defaultRandomConfig";
    public static final String GLOBAL_CONFIG = "globalConfig";
    public static final String THREAD_LOCAL_CONFIG = "threadLocalConfig";
    private final Set<String> actions;

    public CryptoServicesPermission(String r2) {
        super(r2);
        HashSet r0 = new HashSet();
        this.actions = r0;
        r0.add(r2);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, CryptoServicesPermission.class) == false) goto L8;
        CryptoServicesPermission r4 = (CryptoServicesPermission) ZeusTransformUtils.preCheckCast(r3, CryptoServicesPermission.class, "com.obric.memorydata.plugin");
        if (this.actions.equals(r4.actions) == false) goto L10;
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // java.security.Permission
    public String getActions() {
        return this.actions.toString();
    }

    public int hashCode() {
        return this.actions.hashCode();
    }

    @Override // java.security.Permission
    public boolean implies(Permission r3) {
        if (ZeusTransformUtils.instanceOf(r3, CryptoServicesPermission.class) == false) goto L10;
        CryptoServicesPermission r4 = (CryptoServicesPermission) ZeusTransformUtils.preCheckCast(r3, CryptoServicesPermission.class, "com.obric.memorydata.plugin");
        if (getName().equals(r4.getName()) == false) goto L8;
        return true;
    L8:
        if (this.actions.containsAll(r4.actions) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
