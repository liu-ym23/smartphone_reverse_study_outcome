package com.larus.search.impl.global.view.aggregate.kmp;

import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.BotPayload;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements ei9.f {
    public final BotPayload a;

    public static final class a implements ei9.g<ISearchDataPayload, b> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean a(Object r3) {
            ISearchDataPayload r4 = (ISearchDataPayload) r3;
            Intrinsics.checkNotNullParameter(r4, "sourceData");
            if (r4.getType() == 3) goto L5;
        L7:
            return false;
        L5:
            if ((r4 instanceof BotPayload) == false) goto L7;
            return true;
        }

        public final ei9.f b(Object r2) {
            BotPayload r3 = (ISearchDataPayload) r2;
            Intrinsics.checkNotNullParameter(r3, "sourceData");
            return new b(r3);
        }
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "KmpBotSearchCellState(payload=" + this.a + ')';
    }

    public b(BotPayload r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        this.a = r2;
    }
}
