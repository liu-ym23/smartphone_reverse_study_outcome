package org.apache.poi.util;

import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;

/* JADX INFO: loaded from: classes7.dex */
public class Configurator {
    private static final c LOG = null;

    static {
        LOG = b.a(Configurator.class);
    }

    public Configurator() {
    }

    public static int getIntValue(String r3, int r4) {
        String r0 = System.getProperty(r3);
        if (r0 != null) goto L5;
    L12:
        return r4;
    L5:
        if ("".equals(r0) == true) goto L12;
        if ("null".equals(r0) == true) goto L12;
        return Integer.parseInt(r0);
    L11:
        LOG.atError().a("System property -D{} does not contains a valid integer: {}", r3, r0);
        goto L12
    }
}
