package tu1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.parse.ExpressNodeType;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static final Map<String, ExpressNodeType> a = null;

    static {
        ExpressNodeType r1 = ExpressNodeType.OPERATOR_COMPARE;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to("(", ExpressNodeType.LEFT_BRACKET), TuplesKt.to(")", ExpressNodeType.RIGHT_BRACKET), TuplesKt.to("&&", ExpressNodeType.OPERATOR_AND), TuplesKt.to("||", ExpressNodeType.OPERATOR_OR), TuplesKt.to("==", r1), TuplesKt.to("!=", r1), TuplesKt.to(">=", r1), TuplesKt.to(">", r1), TuplesKt.to("<=", r1), TuplesKt.to("<", r1)});
    }
}
