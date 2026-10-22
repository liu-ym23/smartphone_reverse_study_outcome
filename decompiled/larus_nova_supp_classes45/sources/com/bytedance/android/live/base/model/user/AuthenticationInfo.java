package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.User.AuthenticationInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R,\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\t¨\u0006("}, d2 = {"Lcom/bytedance/android/live/base/model/user/AuthenticationInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/c;", "", "customVerify", "Ljava/lang/String;", "getCustomVerify", "()Ljava/lang/String;", "setCustomVerify", "(Ljava/lang/String;)V", "enterpriseVerifyReason", "getEnterpriseVerifyReason", "setEnterpriseVerifyReason", "Lpy/k;", "authenticationBadge", "Lpy/k;", "getAuthenticationBadge", "()Lpy/k;", "setAuthenticationBadge", "(Lpy/k;)V", "", "", "levelList", "Ljava/util/List;", "getLevelList", "()Ljava/util/List;", "setLevelList", "(Ljava/util/List;)V", "Lpy/a;", "accountTypeInfo", "Lpy/a;", "getAccountTypeInfo", "()Lpy/a;", "setAccountTypeInfo", "(Lpy/a;)V", "verifyContent", "getVerifyContent", "setVerifyContent", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuthenticationInfo extends FlexModelBase<py.c> implements py.c, vh7.h {

    @SerializedName("account_type_info")
    protected py.a accountTypeInfo;

    @SerializedName("authentication_badge")
    protected py.k authenticationBadge;

    @SerializedName("custom_verify")
    protected String customVerify;

    @SerializedName("enterprise_verify_reason")
    protected String enterpriseVerifyReason;

    @SerializedName("level_list")
    protected List<Integer> levelList;

    @IgnoreProtoFieldCheck
    @SerializedName("verify_content")
    private String verifyContent;

    public AuthenticationInfo() {
        super(py.c.class);
    }

    @Override // py.c
    public py.a getAccountTypeInfo() {
        return this.accountTypeInfo;
    }

    @Override // py.c
    public py.k getAuthenticationBadge() {
        return this.authenticationBadge;
    }

    @Override // py.c
    public String getCustomVerify() {
        return this.customVerify;
    }

    @Override // py.c
    public String getEnterpriseVerifyReason() {
        return this.enterpriseVerifyReason;
    }

    @Override // py.c
    public List<Integer> getLevelList() {
        return this.levelList;
    }

    public final String getVerifyContent() {
        return this.verifyContent;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.a] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public AuthenticationInfo(am3.g r6) {
        super(py.c.class);
        this.levelList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.customVerify = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.enterpriseVerifyReason = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.authenticationBadge = vh7.f.a(r6, py.k.class);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.levelList.add(Integer.valueOf(r6.i()));
        goto L3
    L14:
        if (r2 != 10) goto L15;
        this.accountTypeInfo = vh7.f.a(r6, py.a.class);
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // py.c
    public void setAccountTypeInfo(py.a r1) {
        this.accountTypeInfo = r1;
    }

    @Override // py.c
    public void setAuthenticationBadge(py.k r1) {
        this.authenticationBadge = r1;
    }

    @Override // py.c
    public void setCustomVerify(String r1) {
        this.customVerify = r1;
    }

    @Override // py.c
    public void setEnterpriseVerifyReason(String r1) {
        this.enterpriseVerifyReason = r1;
    }

    @Override // py.c
    public void setLevelList(List<Integer> r1) {
        this.levelList = r1;
    }

    public final void setVerifyContent(String r1) {
        this.verifyContent = r1;
    }
}
