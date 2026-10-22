package com.obric.aee.impl;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J*\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b¨\u0006\u000f"}, d2 = {"Lcom/obric/aee/impl/ScriptBootstrap;", "", "()V", "buildConfigs", "", "cfgs", "", "initBuiltins", "ctx", "Landroid/content/Context;", "enableTraceMem", "", "traceMemtrack", "key", "enable", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScriptBootstrap {
    public static final ScriptBootstrap INSTANCE = null;

    static {
        INSTANCE = new ScriptBootstrap();
    }

    private ScriptBootstrap() {
    }

    private final String a(Map<String, String> r11) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r10.size()), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r10.entrySet().iterator();
        if (r13.hasNext() == false) goto L14;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r14.getKey(), CharSequence.class, "com.obric.memorydata.plugin"), Typography.quote, false, 2, null) == false) goto L7;
        return "";
    L7:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r14.getValue(), CharSequence.class, "com.obric.memorydata.plugin"), Typography.quote, false, 2, null) == false) goto L10;
        return "";
    L10:
        return "env.host_config[\"" + ((String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.memorydata.plugin")) + "\"] = \"" + ((String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.memorydata.plugin")) + Typography.quote;
    L14:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    public final String a(Context r3, Map<String, String> r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "ctx");
        Intrinsics.checkNotNullParameter(r7, "cfgs");
        StringBuilder r8 = new StringBuilder().append("import marshal\nimport sys\nimport _aee_core\nimport os\n").append(a("BeforeLoader", r5)).append("exec(marshal.loads(_aee_core.fmod_get('pap_loader')[0]), globals())\n").append(a("AfterLoader", r5)).append("from pap import env\n").append(a("AfterImportPap", r5)).append("env.package_name=\"").append(r6.getPackageName()).append("\"\nenv.file_dir=\"");
        File r9 = r6.getExternalFilesDir("pap-files");
        if (r9 == null) goto L5;
        String r10 = r9.getAbsolutePath();
    L7:
        if (r10 != null) goto L10;
        r10 = "";
    L10:
        return r8.append(r10).append("\"\nenv.enable_frozen = True\nenv.local_ips = [").append("").append("]\nos.makedirs(env.file_dir, exist_ok=True)\n").append(a(r7)).append('\n').toString();
    L5:
        r10 = null;
        goto L7
    }

    public final String a(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        if (r2 == true) goto L7;
        return "";
    L7:
        return "print(f\"MemTrace(" + r1 + ") = {tracemalloc.get_traced_memory()[0]/1048576:.2f}MB\")\n";
    }
}
