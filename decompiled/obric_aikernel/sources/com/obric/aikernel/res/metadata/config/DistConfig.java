package com.obric.aikernel.res.metadata.config;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.downloader.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class DistConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f5015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f5016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f5017e;

    public DistConfig(String r10, String r11, k r12) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "json");
        this.f5013a = r10;
        this.f5014b = r11;
        this.f5015c = r12;
        this.f5016d = LazyKt.lazy(new DistConfig$version$2(this));
        this.f5017e = LazyKt.lazy(new DistConfig$from$2(this));
    }

    public static /* synthetic */ List c(DistConfig r10, String r11, String r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L7;
        r13 = 0;
    L7:
        return r10.b(r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDownloadFiles");
    }

    public void a(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "downloadRoot");
        Intrinsics.checkNotNullParameter(r11, "targetRoot");
    }

    public List<DownloadTask.b> b(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "savePath");
        Intrinsics.checkNotNullParameter(r11, "tmpPath");
        List<b> r13 = d();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        CollectionsKt.addAll(r14, ((b) r15.next()).b(r10, r11, r12));
        goto L4
    L6:
        return r14;
    }

    public List<b> d() {
        return CollectionsKt.emptyList();
    }

    public final String e() {
        return (String) this.f5017e.getValue();
    }

    public final k f() {
        return this.f5015c;
    }

    public final String g() {
        return this.f5014b;
    }

    public final String h() {
        return this.f5013a;
    }

    public String i() {
        return (String) this.f5016d.getValue();
    }

    public boolean j(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return true;
    }

    public String toString() {
        return '[' + this.f5013a + ':' + this.f5014b + '@' + i() + ']';
    }
}
