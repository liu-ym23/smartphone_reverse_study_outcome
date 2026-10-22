package com.obric.aikernel.service;

import com.obric.aikernel.sdk.config.RequestParams;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    public static final class a {
        public static void a(b r10, FileDescriptor r11, PrintWriter r12, List<String> r13) {
            Intrinsics.checkNotNullParameter(r11, "fd");
            Intrinsics.checkNotNullParameter(r12, "fout");
            Intrinsics.checkNotNullParameter(r13, "args");
        }
    }

    void a(RequestParams r10);

    int b();

    void c(FileDescriptor r10, PrintWriter r11, List<String> r12);

    String name();
}
