package com.ttnet.org.chromium.net;

import java.io.FileDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AndroidNetworkLibrary$SetFileDescriptor {
    private static final Method sFileDescriptorSetInt = null;

    private AndroidNetworkLibrary$SetFileDescriptor() {
    }

    static {
        sFileDescriptorSetInt = FileDescriptor.class.getMethod("setInt$", new Class[]{Integer.TYPE});     // Catch: Throwable -> L4 NoSuchMethodException -> L6
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("Unable to get FileDescriptor.setInt$", e);
    }

    public static FileDescriptor createWithFd(int r5) {
        FileDescriptor r1 = new FileDescriptor();     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
        sFileDescriptorSetInt.invoke(r1, new Object[]{Integer.valueOf(r5)});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
        return r1;
    L8:
        e = move-exception;
        throw new RuntimeException("FileDescriptor.setInt$() failed", e);
    L5:
        e = move-exception;
        throw new RuntimeException("FileDescriptor.setInt$() failed", e);
    }
}
