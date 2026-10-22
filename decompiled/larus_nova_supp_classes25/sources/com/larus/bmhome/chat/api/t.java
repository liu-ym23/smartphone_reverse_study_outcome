package com.larus.bmhome.chat.api;

import com.larus.bmhome.ability.ContainerExceptionType;
import com.larus.bmhome.ability.MessageMonitorItemType;
import kotlin.Deprecated;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "do not use appreciable trace outside chat core")
public interface t {

    public static final class a {
        public static /* synthetic */ void a(t r6, String r7, ContainerExceptionType r8, String r9, JSONObject r10) {
            r6.a(r7, r8, r9, r10, null);
        }
    }

    void a(String r1, ContainerExceptionType r2, String r3, JSONObject r4, Long r5);

    void b(String r1, Object r2);

    long c(MessageMonitorItemType r1);

    boolean d(MessageMonitorItemType r1);

    void e(String r1, MessageMonitorItemType r2);

    void f(String r1, Object r2);

    void g(String r1, String r2, String r3, String r4);

    void h(String r1, String r2, String r3, String r4);
}
