package com.ss.android.lark.message.card.parser;

import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UniversalCardEntity.DataSource.values().length];
            r0[UniversalCardEntity.DataSource.IM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[UniversalCardEntity.DataSource.CARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[UniversalCardEntity.DataSource.STREAMING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }
}
