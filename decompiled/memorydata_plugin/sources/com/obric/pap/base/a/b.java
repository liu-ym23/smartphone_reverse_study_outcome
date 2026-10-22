package com.obric.pap.base.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/obric/pap/base/util/ScriptBootstrap;", "", "()V", "getSoFiles", "", "context", "Landroid/content/Context;", "soLoaders", "PythonBase_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14919a = null;

    static {
        f14919a = new b();
    }

    private b() {
    }

    private final String b(Context r19) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder("{\n");
        String[] r3 = r0.getAssets().list("pap/packages");
        if (r3 == null) goto L31;
        int r5 = r3.length;
        int r7 = 0;
    L5:
        if (r7 >= r5) goto L31;
        String r8 = r3[r7];
        Intrinsics.checkNotNullExpressionValue(r8, "it");
        if (StringsKt.endsWith$default(r8, ".somap", false, 2, null) == false) goto L24;
        InputStream r9 = r0.getAssets().open("pap/packages/" + r8);
        Intrinsics.checkNotNullExpressionValue(r9, "context.assets.open(\"$packagePrefix/$it\")");
        Reader r10 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r9, Charsets.UTF_8), Reader.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, BufferedReader.class) == false) goto L12;
        BufferedReader r11 = (BufferedReader) ZeusTransformUtils.preCheckCast(r10, BufferedReader.class, "com.obric.memorydata.plugin");
    L13:
        Reader r12 = (Reader) ZeusTransformUtils.preCheckCast(r11, Reader.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, BufferedReader.class) == false) goto L16;
        BufferedReader r13 = (BufferedReader) ZeusTransformUtils.preCheckCast(r12, BufferedReader.class, "com.obric.memorydata.plugin");
    L17:
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(r13, Closeable.class, "com.obric.memorydata.plugin");
        Iterator<String> r15 = TextStreamsKt.lineSequence((BufferedReader) ZeusTransformUtils.preCheckCast(r14, BufferedReader.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L25
    L20:
        if (r15.hasNext() == false) goto L22;
        List r16 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"="}, false, 0, 6, null);     // Catch: Throwable -> L25
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.get(0), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        r2.append(Typography.quote + ((String) ZeusTransformUtils.preCheckCast(r16.get(1), String.class, "com.obric.memorydata.plugin")) + "\":\"" + r17 + "\",");     // Catch: Throwable -> L25
        goto L20
    L22:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r14, null);
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L16:
        r13 = new BufferedReader(r12, 8192);
        goto L17
    L12:
        r11 = new BufferedReader(r10, 8192);
    L24:
        r7 = r7 + 1;
    L31:
        r2.append("}");
        String r1 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "builder.toString()");
        return r1;
    }

    public final String a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return "from importlib._bootstrap_external import _builtin_mods\n_builtin_mods.update(" + b(r4) + ")\n";
    }
}
