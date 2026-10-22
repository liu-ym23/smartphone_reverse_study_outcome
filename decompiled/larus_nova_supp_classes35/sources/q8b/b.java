package q8b;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.handler.MatchRegulate;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MatchRegulate.values().length];
            r0[MatchRegulate.ACCURATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MatchRegulate.ANY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MatchRegulate.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    boolean b(DecisionData.Action r1);

    List<i> getRules();
}
