package com.obric.assistant.security.provision.check.impl;

import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0001&BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/assistant/security/provision/check/impl/InnerCheckStateResult;", "", "status", "", "version", "dev_key_provisioned", "", "dev_cert_provisioned", "tls_key_provisioned", "tls_cert_provisioned", "attk_key_provisioned", "platform_param_provisioned", "<init>", "(IIZZZZZZ)V", "getStatus", "()I", "getVersion", "getDev_key_provisioned", "()Z", "getDev_cert_provisioned", "getTls_key_provisioned", "getTls_cert_provisioned", "getAttk_key_provisioned", "getPlatform_param_provisioned", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InnerCheckStateResult {
    public static final a Companion = null;
    private static final Gson gson = null;
    private final boolean attk_key_provisioned;
    private final boolean dev_cert_provisioned;
    private final boolean dev_key_provisioned;
    private final boolean platform_param_provisioned;
    private final int status;
    private final boolean tls_cert_provisioned;
    private final boolean tls_key_provisioned;
    private final int version;

    public static final class a {
        public a() {
        }

        public static InnerCheckStateResult a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "json");
            return (InnerCheckStateResult) InnerCheckStateResult.access$getGson$cp().fromJson(r4, InnerCheckStateResult.class);
        L5:
            e = move-exception;
            FLogger.a.e("CheckStateResult", "parseCheckStateFromJson() json=" + r4, e);
            return null;
        }
    }

    public static /* synthetic */ InnerCheckStateResult copy$default(InnerCheckStateResult r9, int r10, int r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        int r2 = r9.status;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r3 = r9.version;
    L11:
        if ((r18 & 4) == 0) goto L13;
        boolean r4 = r9.dev_key_provisioned;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = r9.dev_cert_provisioned;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.tls_key_provisioned;
    L23:
        if ((r18 & 32) == 0) goto L25;
        boolean r7 = r9.tls_cert_provisioned;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = r9.attk_key_provisioned;
    L31:
        if ((r18 & 128) == 0) goto L33;
        boolean r1 = r9.platform_param_provisioned;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final int component1() {
        return this.status;
    }

    public final int component2() {
        return this.version;
    }

    public final boolean component3() {
        return this.dev_key_provisioned;
    }

    public final boolean component4() {
        return this.dev_cert_provisioned;
    }

    public final boolean component5() {
        return this.tls_key_provisioned;
    }

    public final boolean component6() {
        return this.tls_cert_provisioned;
    }

    public final boolean component7() {
        return this.attk_key_provisioned;
    }

    public final boolean component8() {
        return this.platform_param_provisioned;
    }

    public final InnerCheckStateResult copy(int r11, int r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18) {
        return new InnerCheckStateResult(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InnerCheckStateResult) == true) goto L8;
        return false;
    L8:
        InnerCheckStateResult r6 = (InnerCheckStateResult) r5;
        if (this.status == r6.status) goto L12;
        return false;
    L12:
        if (this.version == r6.version) goto L15;
        return false;
    L15:
        if (this.dev_key_provisioned == r6.dev_key_provisioned) goto L18;
        return false;
    L18:
        if (this.dev_cert_provisioned == r6.dev_cert_provisioned) goto L21;
        return false;
    L21:
        if (this.tls_key_provisioned == r6.tls_key_provisioned) goto L24;
        return false;
    L24:
        if (this.tls_cert_provisioned == r6.tls_cert_provisioned) goto L27;
        return false;
    L27:
        if (this.attk_key_provisioned == r6.attk_key_provisioned) goto L30;
        return false;
    L30:
        if (this.platform_param_provisioned == r6.platform_param_provisioned) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.status * 31) + this.version) * 31;
        int r2 = 1231;
        if (this.dev_key_provisioned == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.dev_cert_provisioned == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.tls_key_provisioned == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.tls_cert_provisioned == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.attk_key_provisioned == false) goto L21;
        int r10 = 1231;
    L22:
        int r11 = (r9 + r10) * 31;
        if (this.platform_param_provisioned == true) goto L27;
        r2 = 1237;
    L27:
        return r11 + r2;
    L21:
        r10 = 1237;
        goto L22
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "InnerCheckStateResult(status=" + this.status + ", version=" + this.version + ", dev_key_provisioned=" + this.dev_key_provisioned + ", dev_cert_provisioned=" + this.dev_cert_provisioned + ", tls_key_provisioned=" + this.tls_key_provisioned + ", tls_cert_provisioned=" + this.tls_cert_provisioned + ", attk_key_provisioned=" + this.attk_key_provisioned + ", platform_param_provisioned=" + this.platform_param_provisioned + ')';
    }

    static {
        Companion = new a();
        gson = new Gson();
    }

    public static final /* synthetic */ Gson access$getGson$cp() {
        return gson;
    }

    public final boolean getAttk_key_provisioned() {
        return this.attk_key_provisioned;
    }

    public final boolean getDev_cert_provisioned() {
        return this.dev_cert_provisioned;
    }

    public final boolean getDev_key_provisioned() {
        return this.dev_key_provisioned;
    }

    public final boolean getPlatform_param_provisioned() {
        return this.platform_param_provisioned;
    }

    public final int getStatus() {
        return this.status;
    }

    public final boolean getTls_cert_provisioned() {
        return this.tls_cert_provisioned;
    }

    public final boolean getTls_key_provisioned() {
        return this.tls_key_provisioned;
    }

    public final int getVersion() {
        return this.version;
    }

    public InnerCheckStateResult(int r1, int r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        this.status = r1;
        this.version = r2;
        this.dev_key_provisioned = r3;
        this.dev_cert_provisioned = r4;
        this.tls_key_provisioned = r5;
        this.tls_cert_provisioned = r6;
        this.attk_key_provisioned = r7;
        this.platform_param_provisioned = r8;
    }
}
