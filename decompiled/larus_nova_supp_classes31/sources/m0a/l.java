package m0a;

import com.larus.ugc.feed.api.model.CommonCreationFeedDataKmp;
import com.larus.ugc.feed.api.model.CreationFeedCacheEntityKmp;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface l {
    Object a(int r1, String r2, Long r3, String r4, Continuation<? super Pair<CommonCreationFeedDataKmp, ? extends j<Unit>>> r5);

    CreationFeedCacheEntityKmp b();

    Object c(CreationFeedCacheEntityKmp r1, Continuation<? super Unit> r2);
}
