package com.ss.android.lark.feed.shared.page.unreadAI;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "old", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "new", "invoke", "(Ljava/util/List;Ljava/util/List;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class UnreadAIFeedListener$1 extends Lambda implements Function2<List<? extends String>, List<? extends String>, Boolean> {
    public static final UnreadAIFeedListener$1 INSTANCE = null;

    static {
        INSTANCE = new UnreadAIFeedListener$1();
    }

    public UnreadAIFeedListener$1() {
        super(2);
    }

    public final Boolean invoke(List<String> r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "old");
        Intrinsics.checkNotNullParameter(r3, "new");
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        if (r2.contains((String) r4.next()) == true) goto L4;
        return Boolean.FALSE;
    L10:
        return Boolean.TRUE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((List) r1, (List) r2);
    }
}
