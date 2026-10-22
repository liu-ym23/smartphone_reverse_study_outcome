package com.google.gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface ReflectionAccessFilter {
    public static final ReflectionAccessFilter BLOCK_ALL_ANDROID = null;
    public static final ReflectionAccessFilter BLOCK_ALL_JAVA = null;
    public static final ReflectionAccessFilter BLOCK_ALL_PLATFORM = null;
    public static final ReflectionAccessFilter BLOCK_INACCESSIBLE_JAVA = null;

    FilterResult check(Class<?> r1);

    static {
        BLOCK_INACCESSIBLE_JAVA = new 1();
        BLOCK_ALL_JAVA = new 2();
        BLOCK_ALL_ANDROID = new 3();
        BLOCK_ALL_PLATFORM = new 4();
    }
}
