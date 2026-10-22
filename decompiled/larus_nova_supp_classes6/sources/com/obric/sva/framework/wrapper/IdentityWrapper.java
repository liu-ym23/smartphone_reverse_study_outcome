package com.obric.sva.framework.wrapper;

import android.media.permission.Identity;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IdentityWrapper {
    public Identity identity;

    public String getPackageName() {
        return this.identity.packageName;
    }

    public int getPid() {
        return this.identity.pid;
    }

    public int getUid() {
        return this.identity.uid;
    }

    public IdentityWrapper() {
        this.identity = new Identity();
    }

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return Identity.class;
    }

    public void setPackageName(String r2) {
        this.identity.packageName = r2;
    }

    public void setPid(int r2) {
        this.identity.pid = r2;
    }

    public void setUid(int r2) {
        this.identity.uid = r2;
    }
}
