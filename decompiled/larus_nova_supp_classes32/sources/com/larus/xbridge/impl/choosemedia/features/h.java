package com.larus.xbridge.impl.choosemedia.features;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h implements j4a.i {
    public final Function3<FragmentActivity, Intent, Integer, Unit> a;
    public final WeakReference<Activity> b;
    public final j4a.f c;
    public final ExecutorService d;
    public final ExecutorService e;
    public Uri f;
    public String g;
    public c h;
    public String i;
    public boolean j;
    public boolean k;
    public boolean l;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final boolean a;
        public final String b;
        public final WeakReference<j4a.f> c;

        public final void a() {
            String r0 = this.b;
            if (r0 != null) goto L5;
            return;
        L5:
            hx7.k.a r3 = new hx7.k.a(r0, new PolarisFileWrapper(r0).length(), "image");
            if (this.a == true) goto L19;
        L10:
            List r1 = CollectionsKt.listOf(r3);
            j4a.f r2 = this.c.get();
            if (r2 == null) goto L13;
            hx7.k r4 = new hx7.k();
            r4.a = r1;
            r2.a(r4);
            Unit r5 = Unit.INSTANCE;
        L14:
            if (r5 != null) goto L21;
            j4a.f r6 = this.c.get();
            if (r6 == null) goto L22;
            r6.onFailed(0, "CompressFilePath is null");
            Unit r7 = Unit.INSTANCE;
            return;
        L22:
            return;
        L21:
            return;
        L13:
            r5 = null;
            goto L14
        L19:
            r3.d = j4a.h.a(r0);     // Catch: IOException -> L9
        L9:
            r3.d = NameKeys.UnloadStrategy_No_Strategy;
            goto L10
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

        public b(WeakReference<Activity> r2, String r3, j4a.f r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "ctxRef");
            Intrinsics.checkNotNullParameter(r4, "callback");
            this.a = r5;
            this.b = r3;
            this.c = new WeakReference(r4);
        }
    }

    public static final class c extends PthreadAsyncTask<Unit, Unit, Uri> {
        public final Function3<FragmentActivity, Intent, Integer, Unit> h;
        public final WeakReference<Activity> i;
        public final WeakReference<h> j;

        public final void onCancelled() {
            h r0 = this.j.get();
            if (r0 != null) goto L5;
            return;
        L5:
            r0.c.onFailed(-7, "Take photo cancelled");
        }

        public final Uri a(Context r5) throws IOException {
            String r0 = "Dou_fsm_" + new SimpleDateFormat("yyyy-MMdd_HHmmss").format(new Date());
            File r1 = r5.getCacheDir();
            if (r1.exists() == false) goto L5;
        L7:
            PolarisFileWrapper r2 = new PolarisFileWrapper(r1, "xbridge_temp");
            r2.mkdirs();
            File r3 = File.createTempFile(r0, ".jpg", r2);
            h r4 = this.j.get();
            if (r4 == null) goto L11;
            r4.g = r3.getAbsolutePath();
        L11:
            return j4a.k.a(r5, r3);
        L5:
            if (r1.mkdirs() == true) goto L7;
            r1 = r5.getFilesDir();
            goto L7
        }

        public final Object doInBackground(Object[] r2) {
            Intrinsics.checkNotNullParameter((Unit[]) r2, LynxResourceModule.PARAMS_KEY);
            Activity r3 = this.i.get();
            if (r3 != null) goto L9;
        L6:
            return null;
        L9:
            return a(r3);
        }

        public final void onPostExecute(Object r5) {
            Uri r6 = (Uri) r5;
            h r0 = this.j.get();
            Activity r1 = this.i.get();
            if (r0 == null) goto L22;
            if (r1 == null) goto L25;
            if (r6 != null) goto L8;
            r0.c.onFailed(0, "Take photo failed");
            return;
        L8:
            r0.f = r6;
            Intent r2 = new Intent("android.media.action.IMAGE_CAPTURE");
            String r3 = r0.i;
            if (Intrinsics.areEqual(r3, "front") == false) goto L12;
            j4a.j.b(r2);
        L15:
            r2.putExtra("output", r6);
            r2.addFlags(3);
            Function3<FragmentActivity, Intent, Integer, Unit> r7 = this.h;
            if (r7 != null) goto L18;
        L20:
            r1.startActivityForResult(r2, 1311210);
            return;
        L18:
            if ((r1 instanceof FragmentActivity) == false) goto L20;
            r7.invoke(r1, r2, 1311210);
            return;
        L12:
            if (Intrinsics.areEqual(r3, "back") == false) goto L14;
            j4a.j.a(r2);
            goto L15
        L14:
            j4a.j.a(r2);
            goto L15
        L25:
            return;
        }

        public c(Activity r2, h r3, Function3 r4) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "feature");
            this.h = r4;
            this.i = new WeakReference(r2);
            this.j = new WeakReference(r3);
        }
    }

    static {
    }

    public h(WeakReference r2, h4a.d r3, i4a.a r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "onFileSelected");
        this.a = r4;
        this.b = r2;
        this.c = r3;
        this.d = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("BDXTakePhotoFeature"));
        this.e = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("BDXTakePhotoFeature"));
        this.i = NameKeys.UnloadStrategy_No_Strategy;
    }

    @Override // j4a.i
    public final boolean onActivityResult(int r5, int r6, Intent r7) {
        if (r6 != 0) goto L7;
        this.c.onFailed(-7, "User cancel");
        return true;
    L7:
        if (r6 == (-1)) goto L9;
    L22:
        return true;
    L9:
        if (this.j == false) goto L14;
        ExecutorService r8 = this.e;
        WeakReference<Activity> r0 = this.b;
        String r1 = this.g;
        if (r1 != null) goto L13;
        r1 = String.valueOf(this.f);
    L13:
        r8.execute(new b(r0, r1, this.c, this.k));
        goto L22
    L14:
        int r9 = j4a.e.a;
        Long r10 = j4a.e.b(this.b.get(), this.f);
        if (r10 == null) goto L17;
        long r11 = r10.longValue();
    L18:
        String r2 = this.g;
        if (r2 != null) goto L21;
        r2 = String.valueOf(this.f);
    L21:
        List r12 = CollectionsKt.listOf(new hx7.k.a(r2, r11, "image"));
        j4a.f r13 = this.c;
        hx7.k r3 = new hx7.k();
        r3.a = r12;
        r13.a(r3);
        goto L22
    L17:
        r11 = 0;
        goto L18
    }
}
