package com.obric.aikernel.res.utils;

import com.bytedance.apm6.util.proc.CommonProcUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/obric/aikernel/res/utils/MemoryUtils;", "", "()V", "memSize", "", "getMemSize", "()I", "memSize$delegate", "Lkotlin/Lazy;", "memSizeFormattedStr", "", "getMemSizeFormattedStr", "()Ljava/lang/String;", "memSizeFormattedStr$delegate", "getMemorySize", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f6159b = null;
    private static final Lazy c = null;

    static {
        f6158a = new b();
        f6159b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MemoryUtils$memSize$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MemoryUtils$memSizeFormattedStr$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private b() {
    }

    public static final /* synthetic */ int a(b r0) {
        return r0.c();
    }

    private final int c() {
        Matcher r4 = Pattern.compile("MemTotal:\\s+(\\d+) kB").matcher((CharSequence) ZeusTransformUtils.preCheckCast(CollectionsKt.first(FilesKt.readLines$default(new File(CommonProcUtil.MEMORY_INFO_PATH), null, 1, null)), CharSequence.class, "com.obric.memorydata.plugin"));
        r4.find();
        String r5 = r4.group(1);
        Intrinsics.checkNotNull(r5);
        return (int) Math.ceil(((double) Integer.parseInt(r5)) / 1000000.0d);
    }

    public final int a() {
        return ((Number) ZeusTransformUtils.preCheckCast(f6159b.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public final String b() {
        return (String) ZeusTransformUtils.preCheckCast(c.getValue(), String.class, "com.obric.memorydata.plugin");
    }
}
