package org.apache.poi.util;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/* JADX INFO: renamed from: org.apache.poi.util.-$$Lambda$XMLHelper$e6ZBpJZpZdbbmsFR25LeglJVBQk, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$XMLHelper$e6ZBpJZpZdbbmsFR25LeglJVBQk implements EntityResolver {
    public static final /* synthetic */ $$Lambda$XMLHelper$e6ZBpJZpZdbbmsFR25LeglJVBQk INSTANCE = null;

    static {
        INSTANCE = new $$Lambda$XMLHelper$e6ZBpJZpZdbbmsFR25LeglJVBQk();
    }

    private /* synthetic */ $$Lambda$XMLHelper$e6ZBpJZpZdbbmsFR25LeglJVBQk() {
    }

    @Override // org.xml.sax.EntityResolver
    public final InputSource resolveEntity(String r1, String r2) {
        return XMLHelper.lambda$e6ZBpJZpZdbbmsFR25LeglJVBQk(r1, r2);
    }
}
