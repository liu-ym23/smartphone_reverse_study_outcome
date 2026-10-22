package q3b;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements com.ss.android.lark.chat.core.model.b.a<y6b.c<?>> {
    public p() {
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void a(List<y6b.c<?>> r1, int r2, int r3) {
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void b(List<y6b.c<?>> r1, int r2, int r3) {
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void c(List r6, int r7) {
        if (r6 == null) goto L13;
        int r1 = 1 + r7;
    L4:
        if (r7 >= r1) goto L19;
        y6b.c r2 = (y6b.c) ListProtector.get(r6, r7);
        if (r2.getType() != Message.Type.SYSTEM) goto L12;
        T r3 = r2.o.a;
        if ((r3 instanceof SystemContent) == false) goto L12;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.SystemContent");
        if (((SystemContent) r3).isMyAINewTopic() == false) goto L12;
        r2.T2 = true;
    L12:
        r7 = r7 + 1;
        goto L4
    L19:
        return;
    }
}
