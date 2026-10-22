package com.ss.android.lark.location_ui.picklocation;

import android.graphics.Bitmap;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.location.dto.LocationImageData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ LocationView.j b;

    public class a implements Runnable {
        public final /* synthetic */ g a;

        @Override // java.lang.Runnable
        public final void run() {
            LKUIToast.show(((q) this.a.b).b.b, 2131890398);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(g r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ VFSFile b;
        public final /* synthetic */ g c;

        public final void a() {
            if (this.a == false) goto L5;
            LocationImageData r0 = new LocationImageData();
            r0.setImagePath(this.b.getPath());
            r0.setWidth(this.c.a.getWidth());
            r0.setHeight(this.c.a.getHeight());
            q r1 = (q) this.c.b;
            r1.a.setLocationImageData(r0);
            com.ss.android.lark.location_ui.picklocation.a.InterfaceC0170a r2 = r1.b.a;
            LocationFragment.a r3 = (LocationFragment.a) r2;
            r3.a(r1.a);
            return;
        L5:
            LKUIToast.show(((q) this.c.b).b.b, 2131890398);
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

        public b(g r1, boolean r2, VFSFile r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public final void a() {
    L15:
        e = move-exception;
        Log.e("LocationModel", "failed to saveSnapshot", e);
        LKUIToast.show(((q) this.b).b.b, 2131890398);
        return;
    L4:
        if (this.a != null) goto L7;
        CoreThreadPool.getDefault().getUIExecutor().execute(new a(this));     // Catch: Exception -> L15
        return;
    L7:
        int r2 = jqb.a.a;     // Catch: Exception -> L15
        int r3 = com.suite.lark.platform.component.storage.file.dirs.h.c;     // Catch: Exception -> L15
        com.suite.lark.platform.component.storage.file.dirs.h r4 = com.suite.lark.platform.component.storage.file.dirs.h.a.a(com.larksuite.framework.utils.b.a);     // Catch: Exception -> L15
        VFSFiles.b.getClass();     // Catch: Exception -> L15
        r4.c(VFSFiles.b(true));     // Catch: Exception -> L15
        jqb.b r5 = new jqb.b();     // Catch: Exception -> L15
        Intrinsics.checkNotNullParameter(r5, "pathProvider");     // Catch: Exception -> L15
        VFSFile r6 = r4.a(r5).a().subPath("/snapshot_temp.png").toFile();     // Catch: Exception -> L15
        if (r6.isDirectory() == false) goto L11;
        r6.delete();     // Catch: Exception -> L15
    L11:
        if (r6.exists() == true) goto L13;
        r6.getParentFile().mkdirs();     // Catch: Exception -> L15
    L13:
        Log.i("LocationModel", "save snap shot at path " + r6.getPath());     // Catch: Exception -> L15
        OutputStream r1 = r6.newOutputStream();     // Catch: Exception -> L15
        boolean r7 = this.a.compress(Bitmap.CompressFormat.PNG, 100, r1);     // Catch: Exception -> L15
        r1.flush();     // Catch: Exception -> L15
        r1.close();     // Catch: Exception -> L15
        CoreThreadPool.getDefault().getUIExecutor().execute(new b(this, r7, r6));     // Catch: Exception -> L15
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

    public g(Bitmap r1, q r2) {
        this.a = r1;
        this.b = r2;
    }
}
