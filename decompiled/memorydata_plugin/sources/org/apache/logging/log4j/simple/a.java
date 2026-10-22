package org.apache.logging.log4j.simple;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.message.d;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.c;
import org.apache.logging.log4j.spi.f;
import org.apache.logging.log4j.spi.h;
import org.apache.logging.log4j.util.PropertiesUtil;

/* JADX INFO: loaded from: classes6.dex */
public class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a f17892a = null;
    private final PropertiesUtil c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final String h;
    private final Level i;
    private final PrintStream j;
    private final h<c> k;

    static {
        f17892a = new a();
    }

    public a() {
        this.k = new h();
        PropertiesUtil r0 = new PropertiesUtil("log4j2.simplelog.properties");
        this.c = r0;
        this.g = r0.a("org.apache.logging.log4j.simplelog.showContextMap", false);
        this.d = r0.a("org.apache.logging.log4j.simplelog.showlogname", false);
        this.e = r0.a("org.apache.logging.log4j.simplelog.showShortLogname", true);
        boolean r1 = r0.a("org.apache.logging.log4j.simplelog.showdatetime", false);
        this.f = r1;
        this.i = Level.toLevel(r0.b("org.apache.logging.log4j.simplelog.level"), Level.ERROR);
        if (r1 == false) goto L5;
        String r2 = r0.a("org.apache.logging.log4j.simplelog.dateTimeFormat", "yyyy/MM/dd HH:mm:ss:SSS zzz");
    L6:
        this.h = r2;
        String r3 = r0.a("org.apache.logging.log4j.simplelog.logFile", "system.err");
        if ("system.err".equalsIgnoreCase(r3) == false) goto L10;
    L8:
        PrintStream r4 = System.err;
    L14:
        this.j = r4;
        return;
    L10:
        if ("system.out".equalsIgnoreCase(r3) == false) goto L17;
        r4 = System.out;
        goto L14
    L17:
        r4 = new PrintStream(new FileOutputStream(r3));     // Catch: FileNotFoundException -> L16
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    @Override // org.apache.logging.log4j.spi.f
    public c a(String r2) {
        return a(r2, null);
    }

    public c a(String r13, d r14) {
        d r15 = (d) ZeusTransformUtils.wrapperContextForParams(r14, d.class, "com.obric.memorydata.plugin");
        c r0 = this.k.a(r13, r15);
        if (r0 == null) goto L6;
        AbstractLogger.checkMessageFactory(r0, r15);
        return r0;
    L6:
        SimpleLogger r11 = new SimpleLogger(r13, this.i, this.d, this.e, this.f, this.g, this.h, r15, this.c, this.j);
        this.k.a(r13, r15, r11);
        return this.k.a(r13, r15);
    }
}
