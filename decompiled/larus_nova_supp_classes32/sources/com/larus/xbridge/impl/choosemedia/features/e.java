package com.larus.xbridge.impl.choosemedia.features;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.StringUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements j4a.i {
    public final Function3<FragmentActivity, Intent, Integer, Unit> a;
    public final WeakReference<Activity> b;
    public final j4a.f c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;
    public final ExecutorService h;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final Activity a;
        public final List<Uri> b;
        public final int c;
        public final Function1<List<String>, Unit> d;

        public final void a() {
            if (this.c == (-1)) goto L16;
            List<Uri> r0 = this.b;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator<T> r2 = r0.iterator();
        L6:
            if (r2.hasNext() == false) goto L20;
            Uri r3 = (Uri) r2.next();
            int r4 = j4a.e.a;
            Long r5 = j4a.e.b(this.a, r3);
            if (r5 == null) goto L10;
            long r6 = r5.longValue();
        L12:
            if ((r6 / ((long) 1024)) <= this.c) goto L14;
            boolean r7 = true;
        L15:
            r1.add(new c(r7, r3.toString()));
            goto L6
        L14:
            r7 = false;
            goto L15
        L10:
            r6 = 0;
        L20:
            ArrayList r8 = new ArrayList();
            ArrayList r9 = new ArrayList();
            Iterator r10 = r1.iterator();
        L22:
            if (r10.hasNext() == false) goto L26;
            String r11 = ((c) r10.next()).b;
            if (r11 == null) goto L22;
            r9.add(r11);
            goto L22
        L26:
            r8.addAll(r9);
            this.d.invoke(r8);
            return;
        L16:
            List<Uri> r12 = this.b;
            r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
            Iterator<T> r13 = r12.iterator();
        L18:
            if (r13.hasNext() == false) goto L20;
            r1.add(new c(true, ((Uri) r13.next()).toString()));
            goto L18
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public final Activity getContext() {
            return this.a;
        }

        public b(Activity r2, List r3, j4a.f r4, int r5, com.larus.xbridge.impl.choosemedia.features.c r6) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "uriList");
            Intrinsics.checkNotNullParameter(r4, "callback");
            Intrinsics.checkNotNullParameter(r6, "cb");
            this.a = r2;
            this.b = r3;
            this.c = r5;
            this.d = r6;
            new WeakReference(r4);
        }
    }

    public static final class c {
        public final boolean a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (r0 * 31) + this.b.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "InputFilePath(isNeedCompress=" + this.a + ", path=" + this.b + ')';
        }

        public c(boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, SVGRenderEngine.PATH);
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public e(WeakReference r2, h4a.d r3, i4a.a r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "onFileSelected");
        this.a = r4;
        this.b = r2;
        this.c = r3;
        this.d = 1;
        this.g = -1;
        this.h = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("BDXPickPhotosFeature"));
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.xbridge.impl.choosemedia.features.c] */
    @Override // j4a.i
    public final boolean onActivityResult(int r9, int r10, Intent r11) {
        if (r9 == 1311212) goto L7;
        FLogger.a.i("BDXPickPhotosFeature", "Do not handle this requestCode");
        return false;
    L7:
        if (r10 == 0) goto L51;
        if (r11 == null) goto L51;
        final Activity r3 = this.b.get();
        if (r3 != null) goto L14;
        this.c.onFailed(0, "Activity not found");
        return true;
    L14:
        Uri r12 = r11.getData();
        if (r12 == null) goto L17;
        List r13 = CollectionsKt.listOf(r12);
    L18:
        List r4 = r13;
        Intrinsics.checkNotNullParameter(r3, "ctx");
        Intrinsics.checkNotNullParameter(r4, "uris");
        if (r4.isEmpty() == true) goto L49;
        List r14 = r4;
        if ((r14 instanceof Collection) == true) goto L23;
    L25:
        Iterator r0 = r14.iterator();
    L27:
        if (r0.hasNext() == false) goto L31;
        if (StringUtils.isEmpty(((Uri) r0.next()).toString()) == false) goto L27;
        boolean r1 = true;
    L32:
        if (r1 == true) goto L49;
        if (this.e == false) goto L37;
    L48:
        this.h.execute(new b(r3, r4, this.c, this.g, new com.larus.xbridge.impl.choosemedia.features.c(r3, this)));
    L50:
        return true;
    L37:
        if (this.g != (-1)) goto L48;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L41:
        if (r16.hasNext() == false) goto L47;
        Uri r2 = (Uri) r16.next();
        int r5 = j4a.e.a;
        Long r6 = j4a.e.b(AppHost.a.getApplication(), r2);
        if (r6 == null) goto L45;
        long r7 = r6.longValue();
    L46:
        r15.add(new hx7.k.a(r2.toString(), r7, "image"));
        goto L41
    L45:
        r7 = 0;
        goto L46
    L47:
        j4a.f r17 = this.c;
        hx7.k r8 = new hx7.k();
        r8.a = r15;
        r17.a(r8);
    L31:
        r1 = false;
        goto L32
    L23:
        if (r14.isEmpty() == false) goto L25;
    L49:
        this.c.onFailed(0, "Path empty");
        goto L50
    L17:
        this.c.onFailed(0, "Path empty");
        r13 = CollectionsKt.emptyList();
    L51:
        this.c.onFailed(-7, "User cancelled");
        return true;
    }
}
