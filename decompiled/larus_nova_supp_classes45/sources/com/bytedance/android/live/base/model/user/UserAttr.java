package com.bytedance.android.live.base.model.user;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/base/model/user/UserAttr;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/t;", "", "o", "", "equals", "", "hashCode", "isMuted", "Z", "()Z", "setMuted", "(Z)V", "isAdmin", "setAdmin", "", "adminPrivileges", "Ljava/util/List;", "getAdminPrivileges", "()Ljava/util/List;", "setAdminPrivileges", "(Ljava/util/List;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UserAttr extends FlexModelBase<py.t> implements py.t, vh7.h {

    @SerializedName("admin_privileges")
    protected List<Integer> adminPrivileges;

    @SerializedName("is_admin")
    protected boolean isAdmin;

    @SerializedName("is_muted")
    protected boolean isMuted;

    public UserAttr() {
        super(py.t.class);
    }

    public int hashCode() {
        return ((isMuted() ? 1 : 0) * 31) + (isAdmin() ? 1 : 0);
    }

    @Override // py.t
    public List<Integer> getAdminPrivileges() {
        return this.adminPrivileges;
    }

    @Override // py.t
    public boolean isAdmin() {
        return this.isAdmin;
    }

    @Override // py.t
    public boolean isMuted() {
        return this.isMuted;
    }

    public UserAttr(am3.g r6) {
        super(py.t.class);
        this.adminPrivileges = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.isMuted = am3.h.a(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.isAdmin = am3.h.a(r6);
        goto L3
    L10:
        if (r2 != 4) goto L11;
        this.adminPrivileges.add(Integer.valueOf(r6.i()));
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L18:
        return false;
    L8:
        if ((!Intrinsics.areEqual(UserAttr.class, r5.getClass())) == true) goto L18;
        UserAttr r6 = (UserAttr) r5;
        if (isMuted() == r6.isMuted()) goto L14;
        return false;
    L14:
        if (isAdmin() == r6.isAdmin()) goto L19;
        return false;
    L19:
        return true;
    }

    @Override // py.t
    public void setAdmin(boolean r1) {
        this.isAdmin = r1;
    }

    @Override // py.t
    public void setAdminPrivileges(List<Integer> r1) {
        this.adminPrivileges = r1;
    }

    @Override // py.t
    public void setMuted(boolean r1) {
        this.isMuted = r1;
    }
}
