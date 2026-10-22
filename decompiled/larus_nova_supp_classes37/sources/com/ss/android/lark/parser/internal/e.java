package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.Message;
import com.google.gson.Gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final Gson a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Message.AIInfo.ButtonConfig.Strategy.values().length];
            r0[Message.AIInfo.ButtonConfig.Strategy.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[Message.AIInfo.ButtonConfig.Strategy.CUSTOMIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L6:
            a = r0;
            int[] r1 = new int[Message.AIInfo.ButtonConfig.Button.values().length];
            r1[Message.AIInfo.ButtonConfig.Button.LIKE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L33:
            r1[Message.AIInfo.ButtonConfig.Button.DISLIKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L27:
            r1[Message.AIInfo.ButtonConfig.Button.REGENERATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L29:
            r1[Message.AIInfo.ButtonConfig.Button.SHARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L21:
            r1[Message.AIInfo.ButtonConfig.Button.COPY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L12:
            b = r1;
        }
    }

    static {
        a = new Gson();
    }
}
