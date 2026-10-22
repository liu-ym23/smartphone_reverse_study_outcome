package com.obric.aikernel.utils;

/* JADX INFO: loaded from: classes2.dex */
public final class DmaBufUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DmaBufUtils f5578a = null;

    static {
        f5578a = new DmaBufUtils();
        System.loadLibrary("aikernel_utils");
    }

    private DmaBufUtils() {
    }

    public final native int getDmaBufRssSize();
}
