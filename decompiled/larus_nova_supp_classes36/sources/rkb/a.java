package rkb;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a<T> {

    /* JADX INFO: renamed from: rkb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0322a<T> {
        void onDataReady(T r1);

        void onLoadFailed(Exception r1);
    }

    void cancel();

    void cleanup();

    Class<T> getDataClass();

    DataSource getDataSource();

    void loadData(Priority r1, InterfaceC0322a<? super T> r2);
}
