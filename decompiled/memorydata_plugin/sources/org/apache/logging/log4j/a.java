package org.apache.logging.log4j;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.util.t;

/* JADX INFO: loaded from: classes6.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17883a = null;

    static {
        f17883a = new AnonymousClass1();
    }

    default a a(Throwable r1) {
        return this;
    }

    default void a(String r1) {
    }

    default void a(String r1, Object r2) {
    }

    default void a(String r1, Object r2, Object r3) {
    }

    default void a(String r1, Object r2, Object r3, Object r4) {
    }

    default void a(String r1, Object r2, Object r3, Object r4, Object r5) {
    }

    default void a(String r1, t<?>... r2) {
    }

    default void a(t<Message> r2) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.memorydata.plugin");
    }
}
