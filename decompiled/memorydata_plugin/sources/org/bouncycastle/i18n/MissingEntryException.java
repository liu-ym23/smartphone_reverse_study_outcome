package org.bouncycastle.i18n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class MissingEntryException extends RuntimeException {
    private String debugMsg;
    protected final String key;
    protected final ClassLoader loader;
    protected final Locale locale;
    protected final String resource;

    public MissingEntryException(String r1, String r2, String r3, Locale r4, ClassLoader r5) {
        super(r1);
        this.resource = r2;
        this.key = r3;
        this.locale = r4;
        this.loader = r5;
    }

    public MissingEntryException(String r1, Throwable r2, String r3, String r4, Locale r5, ClassLoader r6) {
        super(r1, r2);
        this.resource = r3;
        this.key = r4;
        this.locale = r5;
        this.loader = r6;
    }

    public ClassLoader getClassLoader() {
        return this.loader;
    }

    public String getDebugMsg() {
        if (this.debugMsg != null) goto L11;
        this.debugMsg = "Can not find entry " + this.key + " in resource file " + this.resource + " for the locale " + this.locale + ".";
        if (ZeusTransformUtils.instanceOf(this.loader, URLClassLoader.class) == false) goto L11;
        URL[] r0 = ((URLClassLoader) ZeusTransformUtils.preCheckCast(this.loader, URLClassLoader.class, "com.obric.memorydata.plugin")).getURLs();
        this.debugMsg += " The following entries in the classpath were searched: ";
        int r1 = 0;
    L8:
        if (r1 == r0.length) goto L11;
        this.debugMsg += r0[r1] + " ";
        r1 = r1 + 1;
    L11:
        return this.debugMsg;
    }

    public String getKey() {
        return this.key;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getResource() {
        return this.resource;
    }
}
