package com.obric.aikernel.res.utils;

import com.bytedance.apm6.util.proc.CommonProcUtil;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class MemoryUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MemoryUtils f5219a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f5220b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f5221c = null;

    static {
        f5219a = new MemoryUtils();
        f5220b = LazyKt.lazy(MemoryUtils$memSize$2.INSTANCE);
        f5221c = LazyKt.lazy(MemoryUtils$memSizeFormattedStr$2.INSTANCE);
    }

    private MemoryUtils() {
    }

    public static final /* synthetic */ int a(MemoryUtils r10) {
        return r10.d();
    }

    private final int d() {
        Matcher r10 = Pattern.compile("MemTotal:\\s+(\\d+) kB").matcher((CharSequence) CollectionsKt.first(FilesKt.readLines$default(new File(CommonProcUtil.MEMORY_INFO_PATH), null, 1, null)));
        r10.find();
        String r11 = r10.group(1);
        Intrinsics.checkNotNull(r11);
        return (int) Math.ceil(((double) Integer.parseInt(r11)) / 1000000.0d);
    }

    public final int b() {
        return ((Number) f5220b.getValue()).intValue();
    }

    public final String c() {
        return (String) f5221c.getValue();
    }
}
