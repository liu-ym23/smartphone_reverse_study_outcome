package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableSet;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class BaseProducerContext implements ProducerContext {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ImmutableSet f8256n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageRequest f8257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InternalRequestListener f8259c;
    public final ForwardingRequestListener d;
    public final Object e;
    public final ImageRequest.RequestLevel f;
    public final HashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Priority f8261i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8262j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8263k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f8264l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImagePipelineConfig f8265m;

    static {
        int r5 = ImmutableSet.f7651a;
        HashSet r10 = new HashSet(2);
        Collections.addAll(r10, new String[]{"id", "uri_source"});
        f8256n = new ImmutableSet(r10);
    }

    public BaseProducerContext(ImageRequest r5, String r10, InternalRequestListener r11, ForwardingRequestListener r12, Object r13, ImageRequest.RequestLevel r14, boolean r15, boolean r16, Priority r17, ImagePipelineConfig r18) {
        this.f8257a = r5;
        this.f8258b = r10;
        HashMap r19 = new HashMap();
        this.g = r19;
        r19.put("id", r10);
        if (r5 != null) goto L5;
        Object r20 = "null-request";
    L6:
        r19.put("uri_source", r20);
        this.f8259c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.f8260h = r15;
        this.f8261i = r17;
        this.f8262j = r16;
        this.f8263k = false;
        this.f8264l = new ArrayList();
        this.f8265m = r18;
        return;
    L5:
        r20 = r5.f8415b;
        goto L6
    }

    public final void a(BaseProducerContextCallbacks r5) {
        monitor-enter(this);
        this.f8264l.add(r5);     // Catch: Throwable -> L8
        boolean r10 = this.f8263k;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r10 == false) goto L13;
        r5.a();
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized Priority b() {
        monitor-enter(this);
        Priority r5 = this.f8261i;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c() {
        monitor-enter(this);
        boolean r5 = this.f8262j;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean d() {
        monitor-enter(this);
        boolean r5 = this.f8260h;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public static void c(ArrayList r5) {
        if (r5 == null) goto L8;
        Iterator r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        ((ProducerContextCallbacks) r10.next()).c();
        goto L6
    L10:
        return;
    }

    public final synchronized ArrayList b(boolean r5) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r5 != this.f8260h) goto L8;
        monitor-exit(this);
        return null;
    L8:
        this.f8260h = r5;     // Catch: Throwable -> L11
        ArrayList r10 = new ArrayList(this.f8264l);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r10;
    }

    public static void b(ArrayList r5) {
        if (r5 == null) goto L8;
        Iterator r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        ((ProducerContextCallbacks) r10.next()).d();
        goto L6
    L10:
        return;
    }

    public final void a() {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.f8263k == false) goto L8;
        monitor-exit(this);
        ArrayList r5 = null;
    L11:
        if (r5 == null) goto L17;
        Iterator r10 = r5.iterator();
    L15:
        if (r10.hasNext() == false) goto L24;
        ((ProducerContextCallbacks) r10.next()).a();
        goto L15
    L24:
        return;
    L17:
        return;
    L8:
        this.f8263k = true;     // Catch: Throwable -> L18
        ArrayList r11 = new ArrayList(this.f8264l);     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        r5 = r11;
        goto L11
    }

    public final synchronized ArrayList a(Priority r5) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r5 != this.f8261i) goto L8;
        monitor-exit(this);
        return null;
    L8:
        this.f8261i = r5;     // Catch: Throwable -> L11
        ArrayList r10 = new ArrayList(this.f8264l);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r10;
    }

    public final synchronized ArrayList a(boolean r5) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r5 != this.f8262j) goto L8;
        monitor-exit(this);
        return null;
    L8:
        this.f8262j = r5;     // Catch: Throwable -> L11
        ArrayList r10 = new ArrayList(this.f8264l);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r10;
    }

    public static void a(ArrayList r5) {
        if (r5 == null) goto L8;
        Iterator r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        ((ProducerContextCallbacks) r10.next()).b();
        goto L6
    L10:
        return;
    }

    public final void a(String r5, Object r10) {
        if (f8256n.contains(r5) == false) goto L5;
        return;
    L5:
        this.g.put(r5, r10);
    }

    public final void a(String r5, String r10) {
        this.g.put("origin", r5);
        this.g.put("origin_sub", r10);
    }
}
