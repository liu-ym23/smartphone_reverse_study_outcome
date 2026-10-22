package org.apache.logging.log4j.spi;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class j implements n {
    public j() {
    }

    @Override // org.apache.logging.log4j.spi.n
    public Map<String, String> getCopy() {
        return new HashMap();
    }

    @Override // org.apache.logging.log4j.spi.n
    public Map<String, String> getImmutableMapOrNull() {
        return null;
    }
}
