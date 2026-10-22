package org.slf4j.event;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;
import org.slf4j.helpers.h;

/* JADX INFO: loaded from: classes8.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Level f20262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    List<Marker> f20263b;
    String c;
    h d;
    String e;
    String f;
    Object[] g;
    long h;
    Throwable i;

    public b() {
    }

    public Level a() {
        return this.f20262a;
    }

    public void a(long r1) {
        this.h = r1;
    }

    public void a(String r1) {
        this.c = r1;
    }

    public void a(Throwable r1) {
        this.i = r1;
    }

    public void a(Marker r3) {
        Marker r4 = (Marker) ZeusTransformUtils.wrapperContextForParams(r3, Marker.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.f20263b != null) goto L8;
        this.f20263b = new ArrayList(2);
    L8:
        this.f20263b.add(r4);
    }

    public void a(Level r1) {
        this.f20262a = r1;
    }

    public void a(h r1) {
        this.d = r1;
    }

    public void a(Object[] r1) {
        this.g = r1;
    }

    public h b() {
        return this.d;
    }

    public void b(String r1) {
        this.f = r1;
    }

    public void c(String r1) {
        this.e = r1;
    }
}
