package com.bytedance.android.live.browser;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0002\u0010\"\n\u0002\b\u0004*\u0001\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "com/bytedance/android/live/browser/ReadonlyJSONObjectMap$entries$2$1$a", "invoke", "()Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class ReadonlyJSONObjectMap$entries$2 extends Lambda implements Function0<Set<? extends AnonymousClass1.a>> {
    final /* synthetic */ ReadonlyJSONObjectMap this$0;

    public ReadonlyJSONObjectMap$entries$2(ReadonlyJSONObjectMap r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Set<AnonymousClass1.a> m470invoke() {
        return SequencesKt.toSet(SequencesKt.map(SequencesKt.asSequence(this.this$0.b.keys()), new AnonymousClass1(this)));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m470invoke();
    }
}
