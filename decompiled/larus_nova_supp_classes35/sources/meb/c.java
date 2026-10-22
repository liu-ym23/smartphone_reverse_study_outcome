package meb;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final meb.a a;
    public final List<a<? extends UIFeedCard>> b;

    public static final class a<T extends UIFeedCard> {
        public final String a;
        public final Class<T> b;
        public final b<T> c;

        public a(Class r3, wh9.b r4) {
            Intrinsics.checkNotNullParameter("DouBaoConversationFeedCard", "runtimeTypeName");
            Intrinsics.checkNotNullParameter(r3, "clazz");
            Intrinsics.checkNotNullParameter(r4, "adapter");
            this.a = "DouBaoConversationFeedCard";
            this.b = r3;
            this.c = r4;
        }
    }

    public c(meb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "helpers");
        this.a = r2;
        this.b = new ArrayList();
    }
}
