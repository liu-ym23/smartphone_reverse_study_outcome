package com.obric.aee.impl;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class ScriptBootstrap {
    public static final ScriptBootstrap INSTANCE = null;

    static {
        INSTANCE = new ScriptBootstrap();
    }

    private ScriptBootstrap() {
    }

    private final String a(Map<String, String> r10) {
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
        if (r12.hasNext() == false) goto L14;
        Map.Entry<String, String> r13 = r12.next();
        if (StringsKt.contains$default(r13.getKey(), Typography.quote, false, 2, null) == false) goto L7;
        return "";
    L7:
        if (StringsKt.contains$default(r13.getValue(), Typography.quote, false, 2, null) == false) goto L10;
        return "";
    L10:
        return "env.host_config[\"" + r13.getKey() + "\"] = \"" + r13.getValue() + Typography.quote;
    L14:
        return CollectionsKt.joinToString$default(r11, "\n", null, null, 0, null, null, 62, null);
    }

    public final String b(Context r10, Map<String, String> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Intrinsics.checkNotNullParameter(r11, "cfgs");
        StringBuilder r13 = new StringBuilder();
        r13.append("import marshal\nimport sys\nimport _aee_core\nimport os\n");
        r13.append(c("BeforeLoader", r12));
        r13.append("exec(marshal.loads(_aee_core.fmod_get('pap_loader')[0]), globals())\n");
        r13.append(c("AfterLoader", r12));
        r13.append("from pap import env\n");
        r13.append(c("AfterImportPap", r12));
        r13.append("env.package_name=\"");
        r13.append(r10.getPackageName());
        r13.append("\"\nenv.file_dir=\"");
        File r14 = r10.getExternalFilesDir("pap-files");
        if (r14 == null) goto L5;
        String r15 = r14.getAbsolutePath();
    L7:
        if (r15 != null) goto L9;
        r15 = "";
    L9:
        r13.append(r15);
        r13.append("\"\nenv.enable_frozen = True\nenv.local_ips = [");
        r13.append("");
        r13.append("]\nos.makedirs(env.file_dir, exist_ok=True)\n");
        r13.append(a(r11));
        r13.append('\n');
        return r13.toString();
    L5:
        r15 = null;
        goto L7
    }

    public final String c(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (r11 == true) goto L7;
        return "";
    L7:
        return "print(f\"MemTrace(" + r10 + ") = {tracemalloc.get_traced_memory()[0]/1048576:.2f}MB\")\n";
    }
}
