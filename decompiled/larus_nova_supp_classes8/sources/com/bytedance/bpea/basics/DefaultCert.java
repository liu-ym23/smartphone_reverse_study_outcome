package com.bytedance.bpea.basics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u001d\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/bpea/basics/DefaultCert;", "Lcom/bytedance/bpea/basics/BaseCert;", "", "authKey", "token", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "auth", "getAuth", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "basics_release"}, k = 1, mv = {1, 4, 0})
public final class DefaultCert extends BaseCert {
    public static final String CERT_TYPE = "DefaultCert";
    public static final a Companion = null;
    private final String auth;
    private final String token;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.bpea.basics.BaseCert, com.bytedance.bpea.basics.Cert
    public String authKey() {
        return this.auth;
    }

    public final String getAuth() {
        return this.auth;
    }

    public final String getToken() {
        return this.token;
    }

    public DefaultCert(String r2, String r3) {
        super(r2, CERT_TYPE);
        this.token = r2;
        this.auth = r3;
    }

    public /* synthetic */ DefaultCert(String r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
