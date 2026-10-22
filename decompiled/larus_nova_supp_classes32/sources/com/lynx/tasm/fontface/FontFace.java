package com.lynx.tasm.fontface;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FontFace {
    public final List<Pair<TYPE, String>> a;
    public h b;

    public static final enum TYPE extends Enum<TYPE> {
        public static final TYPE LOCAL = null;
        public static final TYPE URL = null;
        public static final /* synthetic */ TYPE[] a = null;

        static {
            TYPE r0 = new TYPE("URL", 0);
            URL = r0;
            TYPE r1 = new TYPE("LOCAL", 1);
            LOCAL = r1;
            a = new TYPE[]{r0, r1};
        }

        public static TYPE[] values() {
            return (TYPE[]) a.clone();
        }

        public static TYPE valueOf(String r1) {
            return (TYPE) r27.a.a(TYPE.class, r1);
        }

        public TYPE(String r1, int r2) {
            super(r1, r2);
        }
    }

    public FontFace() {
        this.a = new ArrayList();
    }
}
