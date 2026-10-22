package qh0;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface d<T> {

    public static final class a {
        public static /* synthetic */ void a(d r1) {
            r1.onResult(null);
        }
    }

    void b(BaseCheckException r1);

    void onResult(T r1);
}
