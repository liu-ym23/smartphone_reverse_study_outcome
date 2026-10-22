package rkb;

import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface g<T, R> {
    boolean onLoadFailed(Exception r1, T r2, Target<R> r3, boolean r4);

    boolean onResourceReady(R r1, T r2, Target<R> r3, DataSource r4, boolean r5);
}
