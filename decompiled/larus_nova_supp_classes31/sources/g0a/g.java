package g0a;

import com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface g extends m1a.a {

    public static final class a {
        public static /* synthetic */ Object a(CreationFeedAbilityImpl r2, boolean r3, boolean r4, boolean r5, Continuation r6, int r7) {
            if ((r7 & 1) == 0) goto L6;
            r3 = false;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r4 = false;
        L9:
            if ((r7 & 4) == 0) goto L12;
            r5 = false;
        L12:
            return r2.l(r3, r4, r5, r6);
        }
    }
}
