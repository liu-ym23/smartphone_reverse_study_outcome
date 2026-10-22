package ix9;

import com.larus.suggest.impl.wcb.model.WcbSurface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WcbSurface.values().length];
            r0[WcbSurface.MAIN_CONVERSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[WcbSurface.NEW_CONVERSATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[WcbSurface.NOT_SUPPORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }
}
