package h6b;

import com.ss.android.lark.export.entity.preview.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Type.values().length];
            r0[Type.HEADER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Type.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }
}
