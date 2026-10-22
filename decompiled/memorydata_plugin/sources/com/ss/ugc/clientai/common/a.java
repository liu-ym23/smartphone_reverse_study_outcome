package com.ss.ugc.clientai.common;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f15806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static InterfaceC0842a f15807b;

    /* JADX INFO: renamed from: com.ss.ugc.clientai.common.a$a, reason: collision with other inner class name */
    public interface InterfaceC0842a {
        boolean a();

        ScheduledExecutorService b();

        b c();
    }

    public static class b {
        public b() {
        }

        public void a(String r1, String r2) {
        }

        public void a(String r1, String r2, Throwable r3) {
        }

        public void b(String r1, String r2, Throwable r3) {
        }
    }

    static {
    }

    public static boolean a() {
        InterfaceC0842a r0 = f15807b;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.a();
    }
}
