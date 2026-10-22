package kotlin.text;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class StringsKt__StringsKt$rangesDelimitedBy$2 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ List<String> $delimitersList;
    final /* synthetic */ boolean $ignoreCase;

    public StringsKt__StringsKt$rangesDelimitedBy$2(List<String> r1, boolean r2) {
        this.$delimitersList = r1;
        this.$ignoreCase = r2;
        super(2);
    }

    public final Pair<Integer, Integer> invoke(CharSequence r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$$receiver");
        Pair r6 = StringsKt__StringsKt.access$findAnyOf(r4, this.$delimitersList, r5, this.$ignoreCase, false);
        if (r6 != null) goto L7;
        return null;
    L7:
        return TuplesKt.to(r6.getFirst(), Integer.valueOf(((String) r6.getSecond()).length()));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CharSequence) r1, ((Number) r2).intValue());
    }
}
