package com.ss.android.lark.officewebview.util;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static final class a implements zwb.c {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // zwb.c
        public final void release() {
        }

        @Override // zwb.c
        public final zwb.f a(String r2, JSONObject r3, xwb.c r4) {
            Intrinsics.checkNotNullParameter(r2, "api");
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r4, "callback");
            return new zwb.f();
        }
    }

    static {
    }
}
