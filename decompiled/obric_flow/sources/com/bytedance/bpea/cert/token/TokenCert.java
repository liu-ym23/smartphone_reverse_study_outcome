package com.bytedance.bpea.cert.token;

import ai.j0;
import com.bytedance.bpea.basics.BaseCert;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/bpea/cert/token/TokenCert;", "Lcom/bytedance/bpea/basics/BaseCert;", "token", "", "(Ljava/lang/String;)V", "authKey", "getToken", "()Ljava/lang/String;", "auth", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "token-cert_release"}, k = 1, mv = {1, 1, 16})
public final class TokenCert extends BaseCert {
    public static final String CERT_TYPE = "TokenCert";
    public static final Companion Companion = null;
    private String authKey;
    private final String token;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/bpea/cert/token/TokenCert$Companion;", "", "()V", "CERT_TYPE", "", "with", "Lcom/bytedance/bpea/cert/token/TokenCert;", "token", "token-cert_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final TokenCert with(String r5) {
            return new TokenCert(r5);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TokenCert(String r5) {
        super(r5);
        this.token = r5;
    }

    public static /* synthetic */ TokenCert copy$default(TokenCert r5, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.token;
    L6:
        return r5.copy(r10);
    }

    @JvmStatic
    public static final TokenCert with(String r5) {
        return Companion.with(r5);
    }

    public final TokenCert auth(String r5) {
        this.authKey = r5;
        return this;
    }

    @Override // com.bytedance.bpea.basics.Cert
    public String authKey() {
        return this.authKey;
    }

    public final String component1() {
        return this.token;
    }

    public final TokenCert copy(String r5) {
        return new TokenCert(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof TokenCert) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.token, ((TokenCert) r5).token) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String r5 = this.token;
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.hashCode();
    }

    public String toString() {
        return j0.q(new StringBuilder("TokenCert(token="), this.token, ")");
    }
}
