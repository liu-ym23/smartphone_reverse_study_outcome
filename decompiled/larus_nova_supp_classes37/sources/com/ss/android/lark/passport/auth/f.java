package com.ss.android.lark.passport.auth;

import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ Map a(f r1, String r2, String r3) {
            return r1.a(r2, r3, IPassportAuthHeaderService$authHeaders$1.INSTANCE);
        }
    }

    Map<String, String> a(String r1, String r2, Function1<? super Map<String, String>, ? extends Map<String, String>> r3);
}
