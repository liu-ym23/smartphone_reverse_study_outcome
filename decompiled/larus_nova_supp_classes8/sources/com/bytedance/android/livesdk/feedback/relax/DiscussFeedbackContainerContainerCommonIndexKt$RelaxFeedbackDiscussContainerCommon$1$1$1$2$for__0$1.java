package com.bytedance.android.livesdk.feedback.relax;

import com.relax.relaxframework.j5;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "", "Lcom/bytedance/android/livesdk/feedback/relax/OptionArrayItem;", "item", "", "index", "Lcom/relax/relaxframework/j5;", "invoke", "(Ljava/util/Map;I)Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class DiscussFeedbackContainerContainerCommonIndexKt$RelaxFeedbackDiscussContainerCommon$1$1$1$2$for__0$1 extends Lambda implements Function2<Map<String, Object>, Integer, j5> {
    final /* synthetic */ DiscussFeedbackContainerContainerCommonIndexKt$RelaxFeedbackDiscussContainerCommon$1.AnonymousClass1.C03181.AnonymousClass2 this$0;

    public DiscussFeedbackContainerContainerCommonIndexKt$RelaxFeedbackDiscussContainerCommon$1$1$1$2$for__0$1(DiscussFeedbackContainerContainerCommonIndexKt$RelaxFeedbackDiscussContainerCommon$1.AnonymousClass1.C03181.AnonymousClass2 r1) {
        this.this$0 = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Map) r1, ((Number) r2).intValue());
    }

    public final j5 invoke(final Map<String, Object> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "item");
        return (j5) new AnonymousClass1(this, r1).invoke();
    }
}
