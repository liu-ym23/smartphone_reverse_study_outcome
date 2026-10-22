package com.obric.aikernel.service;

import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.service.res.PythonRuntimeService;
import com.obric.aikernel.service.session.ClientSessionService;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5440a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f5441a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final ServiceFactoryImpl f5442b = null;

        static {
            f5441a = new a();
            f5442b = new ServiceFactoryImpl();
        }

        private a() {
        }

        public final c a() {
            return f5442b;
        }
    }

    static {
        f5440a = a.f5441a;
    }

    boolean a(RequestParams r10);

    void b(FileDescriptor r10, PrintWriter r11, String[] r12);

    ClientSessionService c();

    PythonRuntimeService d();
}
