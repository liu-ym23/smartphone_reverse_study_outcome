package com.bytedance.gkfs.storage;

import android.system.Os;
import android.system.OsConstants;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f4929a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function0 f4930b = null;

    static {
        f4929a = (int) Os.sysconf(OsConstants._SC_PAGE_SIZE);
        f4930b = GkFSChunkStorageKt$UnReadableChunkProvider$1.f4911a;
    }
}
