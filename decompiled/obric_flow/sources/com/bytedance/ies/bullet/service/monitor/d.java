package com.bytedance.ies.bullet.service.monitor;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f6039a = null;

    static {
        f6039a = Executors.newSingleThreadExecutor();
    }

    public static void a(String r5, String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "field");
        Intrinsics.checkNotNullParameter(r11, "data");
        com.bytedance.android.anniex.scene.core.i r12 = new com.bytedance.android.anniex.scene.core.i(10, r5, r11, r10);
        f6039a.execute(r12);
    }

    public static void b(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r11, "value");
        a9.a r12 = new a9.a(r5, r10, r11, 1);
        f6039a.execute(r12);
    }
}
