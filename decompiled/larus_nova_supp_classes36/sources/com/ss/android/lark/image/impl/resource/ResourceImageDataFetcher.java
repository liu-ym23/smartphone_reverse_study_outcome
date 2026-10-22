package com.ss.android.lark.image.impl.resource;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.larksuite.framework.utils.d;
import com.ss.android.lark.log.Log;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import rkb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class ResourceImageDataFetcher<Model> implements a<InputStream> {
    private InputStream mInputStream;
    private volatile boolean mIsCancelled;
    protected Model model;

    @Override // rkb.a
    public void cancel() {
        this.mIsCancelled = true;
    }

    @Override // rkb.a
    public void cleanup() {
        d.b(new Closeable[]{this.mInputStream});
    }

    public abstract String getLogTag();

    public abstract InputStream getResourceStream(Model r1) throws FileNotFoundException;

    @Override // rkb.a
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // rkb.a
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public ResourceImageDataFetcher(Model r1) {
        this.model = r1;
    }

    @Override // rkb.a
    public void loadData(Priority r2, a.InterfaceC0322a<? super InputStream> r3) {
        loadDataWithRetry(r2, r3, 0);
    }

    private void loadDataWithRetry(Priority r10, a.InterfaceC0322a<? super InputStream> r11, int r12) {
        Log.i(getLogTag(), "loading image：" + this.model);
    L13:
        e = move-exception;
        handleError(r10, r11, e, r12);
        return;
    L4:
        if (this.mIsCancelled == false) goto L7;
        r11.onLoadFailed(new Exception("Request has been canceled：" + this.model));     // Catch: Exception -> L13
        return;
    L7:
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L13
        this.mInputStream = getResourceStream(this.model);     // Catch: Exception -> L13
        long r5 = System.currentTimeMillis();     // Catch: Exception -> L13
        Log.i(getLogTag(), "loading image :" + this.model + " rust time cost:" + (r5 - r3) + " ms");     // Catch: Exception -> L13
        if (this.mInputStream != null) goto L11;
        Log.e(getLogTag(), "load image failed:" + this.model);     // Catch: Exception -> L13
        handleError(r10, r11, new Exception("load image failed:" + this.model), r12);     // Catch: Exception -> L13
        return;
    L11:
        Log.i(getLogTag(), "load image succeed：" + this.model);     // Catch: Exception -> L13
        r11.onDataReady(this.mInputStream);     // Catch: Exception -> L13
    }

    private void handleError(Priority r2, a.InterfaceC0322a<? super InputStream> r3, Exception r4, int r5) {
        if (r5 >= 1) goto L5;
        loadDataWithRetry(r2, r3, r5 + 1);
        return;
    L5:
        r3.onLoadFailed(r4);
    }
}
