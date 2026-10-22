package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ClassNameReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final EarlyExitException f352a = null;

    private static class EarlyExitException extends RuntimeException {
        private EarlyExitException() {
        }

        /* synthetic */ EarlyExitException(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        f352a = new EarlyExitException(null);
    }

    static /* synthetic */ EarlyExitException a() {
        return f352a;
    }

    public static String a(com.alibaba.excel.support.asm.e r1) {
        return b(r1)[0];
    }

    public static String[] b(com.alibaba.excel.support.asm.e r4) {
        final ArrayList r0 = new ArrayList();
        final int r2 = i.h;     // Catch: EarlyExitException -> L6
        final com.alibaba.excel.support.asm.f r3 = null;
        r4.a(new AnonymousClass1(r2, r3, r0), 6);     // Catch: EarlyExitException -> L6
    L5:
        return (String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin");
    }
}
