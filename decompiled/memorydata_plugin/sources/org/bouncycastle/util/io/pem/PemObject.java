package org.bouncycastle.util.io.pem;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class PemObject implements PemObjectGenerator {
    private static final List EMPTY_LIST = null;
    private byte[] content;
    private List headers;
    private String type;

    static {
        EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
    }

    public PemObject(String r3, List r4, byte[] r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.type = r3;
        this.headers = Collections.unmodifiableList(r6);
        this.content = r5;
    }

    public PemObject(String r2, byte[] r3) {
        this(r2, EMPTY_LIST, r3);
    }

    @Override // org.bouncycastle.util.io.pem.PemObjectGenerator
    public PemObject generate() {
        return this;
    }

    public byte[] getContent() {
        return this.content;
    }

    public List getHeaders() {
        return this.headers;
    }

    public String getType() {
        return this.type;
    }
}
