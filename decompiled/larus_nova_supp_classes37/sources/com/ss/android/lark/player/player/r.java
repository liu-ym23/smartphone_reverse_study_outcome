package com.ss.android.lark.player.player;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.android.lark.statistics.Statistics;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r implements IPreLoaderItemCallBackListener {
    public final DataSource a;
    public final int b;
    public final WeakReference<s> c;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ r a;

        public b(r r1) {
            this.a = r1;
        }

        public final void a() {
            this.a.a.getShowPreloading().setValue(Boolean.FALSE);
            Log.i("PreloadCallBack", "restart play, and seek to: " + this.a.b);
            s r0 = this.a.c.get();
            if (r0 == null) goto L5;
            r0.i(this.a.a);
        L5:
            s r1 = this.a.c.get();
            if (r1 == null) goto L8;
            r1.k(this.a.b);
        L8:
            Statistics.sendEvent("download_success_interlaced_video_dev");
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
    }

    static {
    }

    public final void preloadItemInfo(PreLoaderItemCallBackInfo r6) {
        StringBuilder r0 = new StringBuilder("preload back code: ");
        Long r1 = null;
        if (r6 == null) goto L5;
        Integer r2 = Integer.valueOf(r6.getKey());
    L6:
        r0.append(r2);
        Log.i("PreloadCallBack", r0.toString());
        boolean r3 = false;
        if (r6 != null) goto L9;
    L11:
        if (r3 == false) goto L25;
        DataLoaderHelper.DataLoaderTaskProgressInfo r7 = r6.preloadDataInfo;
        StringBuilder r4 = new StringBuilder("preload success, cache info: ");
        if (r7 == null) goto L15;
        String r5 = r7.mKey;
    L16:
        r4.append(r5);
        r4.append(", ");
        if (r7 == null) goto L19;
        String r8 = r7.mLocalFilePath;
    L20:
        r4.append(r8);
        r4.append(", ");
        if (r7 == null) goto L23;
        r1 = Long.valueOf(r7.mMediaSize);
    L23:
        r4.append(r1);
        r4.append('}');
        Log.i("PreloadCallBack", r4.toString());
        UICallbackExecutor.execute(new b(this));
        return;
    L19:
        r8 = null;
        goto L20
    L15:
        r5 = null;
        goto L16
    L25:
        return;
    L9:
        if (r6.getKey() != 2) goto L11;
        r3 = true;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public r(s r2, DataSource r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "player");
        Intrinsics.checkNotNullParameter(r3, "dataSource");
        this.a = r3;
        this.b = r4;
        this.c = new WeakReference(r2);
    }
}
