package com.larksuite.framework.http.request;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class FormBody extends RequestBody {
    private final Charset charset;
    private final Map<String, String> name2Value;

    public Map<String, String> getName2Value() {
        return new HashMap(this.name2Value);
    }

    public Charset getCharset() {
        return this.charset;
    }

    public FormBody(Map<String, String> r2, Charset r3) {
        HashMap r0 = new HashMap();
        this.name2Value = r0;
        r0.clear();
        r0.putAll(r2);
        this.charset = r3;
    }
}
