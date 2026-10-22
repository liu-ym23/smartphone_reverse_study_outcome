package com.bytedance.bpea.basics;

import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
import qc4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\u000e\u001a\u00020\t2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016J\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R&\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/bpea/basics/BaseCert;", "Lcom/bytedance/bpea/basics/Cert;", "", "certToken", "certType", "Lorg/json/JSONObject;", "toJSON", "Lqc4/c;", "context", "", "validate", "", "", "customInfo", "attachCustomInfo", "authKey", "toString", "Ljava/util/Map;", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "basics_release"}, k = 1, mv = {1, 4, 0})
public abstract class BaseCert implements Cert {
    private final String certToken;
    private final String certType;
    private Map<String, ? extends Object> customInfo;

    @Override // com.bytedance.bpea.basics.Cert
    public String authKey() {
        return null;
    }

    @Override // com.bytedance.bpea.basics.Cert
    public JSONObject toJSON() {
        JSONObject r0 = new JSONObject();
        r0.put("certToken", this.certToken);     // Catch: Throwable -> L5
        r0.put("certType", this.certType);     // Catch: Throwable -> L5
    L7:
        return r0;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public String toString() {
        return toJSON().toString();
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
    public void attachCustomInfo(Map<String, ? extends Object> r1) {
        this.customInfo = r1;
    }

    @Override // com.bytedance.bpea.basics.Cert
    public void validate(c r3) throws BPEAException {
        String r4 = this.certToken;
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L12;
        return;
    L12:
        throw new BPEAException(-1, "certToken is empty");
    L5:
        if (r4.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public BaseCert(String r1, String r2) {
        this.certToken = r1;
        this.certType = r2;
    }
}
