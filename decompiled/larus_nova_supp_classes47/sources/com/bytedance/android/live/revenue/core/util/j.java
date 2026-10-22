package com.bytedance.android.live.revenue.core.util;

import com.bytedance.live.datacontext.DataContext;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Deprecated(message = "https://bytedance.larkoffice.com/docx/QAEhdrRcmoh0dfx0uAhcctoTnQg")
public interface j {
    public static final a C0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        @Deprecated(message = "https://bytedance.larkoffice.com/docx/QAEhdrRcmoh0dfx0uAhcctoTnQg")
        public final com.bytedance.android.live.revenue.core.b a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(this);
            if ((r0 instanceof j) == true) goto L5;
            r0 = null;
        L5:
            j r1 = (j) r0;
            if (r1 != null) goto L8;
            return null;
        L8:
            return r1.getInst();
        }
    }

    static {
        C0 = a.a;
    }

    com.bytedance.android.live.revenue.core.b getInst();
}
