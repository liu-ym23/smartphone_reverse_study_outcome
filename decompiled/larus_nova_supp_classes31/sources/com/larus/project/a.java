package com.larus.project;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(ProjectListDataSourceImpl r2) {
        return ProjectListDataSourceImpl.class.getName() + '@' + Integer.toHexString(r2.hashCode());
    }

    public static void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "detail");
        FLogger.a.i("FlowFeedArch", r2 + ' ' + r3);
    }
}
