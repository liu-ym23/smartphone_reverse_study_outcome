package com.bytedance.bpea.basics;

import b8.a;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u00020\u000b2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0013R&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/bpea/basics/BaseCert;", "Lcom/bytedance/bpea/basics/Cert;", "", "certToken", "()Ljava/lang/String;", "certType", "Lorg/json/JSONObject;", "toJSON", "()Lorg/json/JSONObject;", "Lb8/a;", "context", "", "validate", "(Lb8/a;)V", "", "", "customInfo", "attachCustomInfo", "(Ljava/util/Map;)V", "()Ljava/util/Map;", "Ljava/util/Map;", "Ljava/lang/String;", "basics_release"}, k = 1, mv = {1, 4, 0})
public abstract class BaseCert implements Cert {
    private final String certToken;
    private final String certType;
    private Map<String, ? extends Object> customInfo;

    public BaseCert(String r5) {
        this.certToken = r5;
        this.certType = TokenCert.CERT_TYPE;
    }

    @Override // com.bytedance.bpea.basics.Cert
    public void attachCustomInfo(Map<String, ? extends Object> r5) {
        this.customInfo = r5;
    }

    @Override // com.bytedance.bpea.basics.Cert
    public String certToken() {
        return this.certToken;
    }

    @Override // com.bytedance.bpea.basics.Cert
    public String certType() {
        return this.certType;
    }

    @Override // com.bytedance.bpea.basics.Cert
    public Map<String, Object> customInfo() {
        return this.customInfo;
    }

    @Override // com.bytedance.bpea.basics.Cert
    public JSONObject toJSON() {
        JSONObject r5 = new JSONObject();
        r5.put("certToken", this.certToken);     // Catch: Throwable -> L5
        r5.put("certType", this.certType);     // Catch: Throwable -> L5
        return r5;
    L5:
        th = move-exception;
        th.printStackTrace();
        return r5;
    }

    @Override // com.bytedance.bpea.basics.Cert
    public void validate(a r5) {
        String r10 = this.certToken;
        if (r10 == null) goto L8;
        if (r10.length() == 0) goto L8;
        return;
    L8:
        throw new BPEAException();
    }
}
