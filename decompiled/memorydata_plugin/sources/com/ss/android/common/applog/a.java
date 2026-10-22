package com.ss.android.common.applog;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f15041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<C0806a> f15042b;

    /* JADX INFO: renamed from: com.ss.android.common.applog.a$a, reason: collision with other inner class name */
    class C0806a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f15044b;
        String c;
        long d;
        long e;
        boolean f;
        JSONObject g;
        final /* synthetic */ a h;

        C0806a(a r1, String r2, String r3, String r4, long r5, long r7, boolean r9, JSONObject r10) {
            this.h = r1;
            this.f15043a = r2;
            this.f15044b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r7;
            this.f = r9;
            this.g = r10;
        }
    }

    public a() {
        this.f15042b = new LinkedList();
    }

    static a a() {
        if (f15041a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15041a != null) goto L9;
        f15041a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f15041a;
    }

    void a(String r16, String r17, String r18, long r19, long r21, boolean r23, JSONObject r24) {
        LinkedList<C0806a> r12 = this.f15042b;
        monitor-enter(r12);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f15042b.size() <= 200) goto L9;
        C0806a r1 = (C0806a) ZeusTransformUtils.preCheckCast(this.f15042b.poll(), C0806a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        x.a(1, 1, null);     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        b.a(r1.f15043a, MonitorState.f_cache);     // Catch: Throwable -> L12
    L9:
        this.f15042b.add(new C0806a(this, r16, r17, r18, r19, r21, r23, r24));     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
    }
}
