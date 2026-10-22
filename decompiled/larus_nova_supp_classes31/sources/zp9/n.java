package zp9;

import com.larus.platform.api.creation.CreationFeedCacheEntity;
import kotlin.Pair;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface n {

    public static final class a {
        public static /* synthetic */ Object a(n r6, Long r7, Continuation r8) {
            return r6.a(1, null, r7, null, r8);
        }
    }

    Object a(int r1, String r2, Long r3, String r4, Continuation<? super Pair<c, ? extends dm9.a<?>>> r5);

    CreationFeedCacheEntity b();
}
