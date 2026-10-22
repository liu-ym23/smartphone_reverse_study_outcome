package fpa;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public static final ExecutorService a = null;

    static {
        a = PThreadExecutorsUtils.newFixedThreadPool(10, new DefaultThreadFactory("GlobalThreadExecutor"));
    }
}
