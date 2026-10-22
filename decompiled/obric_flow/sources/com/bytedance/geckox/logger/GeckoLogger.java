package com.bytedance.geckox.logger;

import android.util.Log;
import com.bytedance.iesgurd.core.ReportNode;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/geckox/logger/GeckoLogger;", "", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public abstract class GeckoLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f4756a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DefaultLogger f4757b = null;

    static {
        f4756a = new CopyOnWriteArrayList();
        f4757b = new DefaultLogger();
    }

    public static final void a(String r5) {
        CopyOnWriteArrayList r10 = f4756a;
        if (r10.size() != 0) goto L6;
        f4757b.a("gecko-debug-tag", new Object[]{r5});
        return;
    L6:
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        DefaultLogger r12 = (DefaultLogger) ((Logger) r11.next());
        r12.a("gecko-debug-tag", new Object[]{r5});
        goto L8
    }

    public static final void b(String r5) {
        CopyOnWriteArrayList r10 = f4756a;
        if (r10.size() != 0) goto L6;
        f4757b.a(r5);
        return;
    L6:
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        ((DefaultLogger) ((Logger) r11.next())).a(r5);
        goto L8
    }

    public static void a(ReportNode r5, String r10) {
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        String r12 = String.format("%s|xParam:{\"name\":\"%s\",\"message\":\"%s\"}", Arrays.copyOf(new Object[]{r5.getTag(), r5.getTag(), r10}, 3));
        CopyOnWriteArrayList r13 = f4756a;
        if (r13.size() != 0) goto L6;
        f4757b.a("gecko-debug-tag", new Object[]{r12});
        return;
    L6:
        Iterator r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        DefaultLogger r15 = (DefaultLogger) ((Logger) r14.next());
        r15.a("gecko-debug-tag", new Object[]{r12});
        goto L8
    }

    public static final void a(String r5, Throwable r10) {
        CopyOnWriteArrayList r11 = f4756a;
        if (r11.size() != 0) goto L6;
        f4757b.getClass();
        Log.w("gecko-debug-tag", r5, r10);
        return;
    L6:
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((DefaultLogger) ((Logger) r12.next())).getClass();
        Log.w("gecko-debug-tag", r5, r10);
        goto L8
    }
}
