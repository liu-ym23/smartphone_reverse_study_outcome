package com.larus.business.arc.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p {
    public static final List<String> a = null;
    public static final Regex b = null;
    public static final Regex c = null;
    public static final Regex d = null;
    public static final Regex e = null;
    public static final Regex f = null;
    public static final Regex g = null;
    public static final Regex h = null;
    public static final Regex i = null;
    public static final Regex j = null;
    public static final Set<String> k = null;

    static {
        ArcFrameworkFailure[] r0 = ArcFrameworkFailure.values();
        ArrayList r1 = new ArrayList(r0.length);
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1.add(r0[r3].getCode());
        r3 = r3 + 1;
        goto L3
    L5:
        a = CollectionsKt.listOf(new String[]{"tool_group", "tool_name", "biz_status", "failure_code", "biz_code", "arc_duration_ms", "stage_prepare_start_offset_ms", "stage_prepare_end_offset_ms", "stage_execute_start_offset_ms", "stage_execute_end_offset_ms", "stage_finalize_start_offset_ms", "stage_finalize_end_offset_ms"});
        b = new Regex("^\\+?[0-9][0-9(). -]{5,}[0-9]$");
        c = new Regex("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$");
        d = new Regex("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
        e = new Regex("^[A-Za-z0-9_-]{8,}\\.[A-Za-z0-9_-]{8,}\\.[A-Za-z0-9_-]{8,}$");
        f = new Regex("^[0-9a-fA-F]+$");
        g = new Regex("^[A-Za-z0-9_-]+$");
        h = new Regex("^(?:(?:AKIA|ASIA)[A-Z0-9]{16}|(?:gh[opusr]|github_pat)_[A-Za-z0-9_]{16,}|xox[baprs]-[A-Za-z0-9-]{10,}|(?:sk|pk)_(?:live|test)_[A-Za-z0-9_-]{8,})$");
        i = new Regex("^(?i:https?|wss?|ftp|file|content):");
        j = new Regex("^(?i:token|password|passwd|secret|cookie|authorization|bearer|credential|verification_code)[:.-].+");
        k = SetsKt.setOf(new String[]{"token", "password", "passwd", "secret", "cookie", "authorization", "bearer", "credential", "verification_code"});
    }
}
