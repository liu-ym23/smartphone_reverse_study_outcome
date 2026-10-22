package wh8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface b {

    public static final class a {
        public static void a(List r1, List r2) {
            Intrinsics.checkNotNullParameter(r1, "list");
            Intrinsics.checkNotNullParameter(r2, "changedConversations");
            Intrinsics.checkNotNullParameter("IMConversationUpdate", "source");
        }
    }

    void IJ(int r1);

    void R70(List r1, List r2);

    void Yo(List<wh8.a> r1);
}
