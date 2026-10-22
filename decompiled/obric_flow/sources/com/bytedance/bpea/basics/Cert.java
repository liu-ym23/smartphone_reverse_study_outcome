package com.bytedance.bpea.basics;

import b8.a;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u00020\u000b2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0014\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/bytedance/bpea/basics/Cert;", "Ljava/io/Serializable;", "", "certToken", "()Ljava/lang/String;", "certType", "Lorg/json/JSONObject;", "toJSON", "()Lorg/json/JSONObject;", "Lb8/a;", "context", "", "validate", "(Lb8/a;)V", "", "", "customInfo", "attachCustomInfo", "(Ljava/util/Map;)V", "()Ljava/util/Map;", "authKey", "basics_release"}, k = 1, mv = {1, 4, 0})
public interface Cert extends Serializable {
    void attachCustomInfo(Map<String, ? extends Object> r5);

    String authKey();

    String certToken();

    String certType();

    Map<String, Object> customInfo();

    JSONObject toJSON();

    void validate(a r5);
}
