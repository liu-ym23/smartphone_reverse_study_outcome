package com.bytedance.bpea.basics;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
import qc4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J \u0010\u000e\u001a\u00020\t2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH&J\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/bpea/basics/Cert;", "Ljava/io/Serializable;", "", "certToken", "certType", "Lorg/json/JSONObject;", "toJSON", "Lqc4/c;", "context", "", "validate", "", "", "customInfo", "attachCustomInfo", "authKey", "basics_release"}, k = 1, mv = {1, 4, 0})
public interface Cert extends Serializable {
    void attachCustomInfo(Map<String, ? extends Object> r1);

    String authKey();

    String certToken();

    String certType();

    Map<String, Object> customInfo();

    JSONObject toJSON();

    void validate(c r1) throws BPEAException;
}
