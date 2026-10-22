package com.ss.android.lark.message.lynxcard.action;

import com.larksuite.component.card.protocol.CardActionDataSource;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LynxCardActionClient {
    public static final Lazy<LynxCardActionClient> a = null;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CardActionDataSource.values().length];
            r0[CardActionDataSource.IM_CONTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CardActionDataSource.CARD_ENTITY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CardActionDataSource.STREAMING_CARD_ENTITY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public LynxCardActionClient() {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.NONE, LynxCardActionClient$Companion$instance$2.INSTANCE);
    }
}
