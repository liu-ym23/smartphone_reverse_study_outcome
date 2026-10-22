package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/AppPrivilege;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "BIND_SELF_MOUNT", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AppPrivilege extends Enum<AppPrivilege> {
    public static final AppPrivilege BIND_SELF_MOUNT = null;
    public static final /* synthetic */ AppPrivilege[] a = null;
    private final String value;

    static {
        AppPrivilege r1 = new AppPrivilege();
        BIND_SELF_MOUNT = r1;
        a = new AppPrivilege[]{r1};
    }

    public static AppPrivilege valueOf(String r1) {
        return (AppPrivilege) r27.a.a(AppPrivilege.class, r1);
    }

    public static AppPrivilege[] values() {
        return (AppPrivilege[]) a.clone();
    }

    public AppPrivilege() {
        super("BIND_SELF_MOUNT", 0);
        this.value = "bind_self";
    }

    public final String getValue() {
        return this.value;
    }
}
