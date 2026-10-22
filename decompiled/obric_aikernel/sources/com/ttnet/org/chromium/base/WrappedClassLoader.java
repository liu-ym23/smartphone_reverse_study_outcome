package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public class WrappedClassLoader extends ClassLoader {
    private ClassLoader mPrimaryClassLoader;
    private ClassLoader mSecondaryClassLoader;

    public WrappedClassLoader(ClassLoader r10, ClassLoader r11) {
        this.mPrimaryClassLoader = r10;
        this.mSecondaryClassLoader = r11;
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String r10) {
        return this.mPrimaryClassLoader.loadClass(r10);
    L5:
        return this.mSecondaryClassLoader.loadClass(r10);
    }

    @Override // java.lang.ClassLoader
    public String findLibrary(String r10) {
        return null;
    }
}
