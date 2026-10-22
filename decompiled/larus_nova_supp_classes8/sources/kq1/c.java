package kq1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.paid.PrivilegeClarityEventHub;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface c {
    void a(String r1, Function0<Unit> r2);

    void b();

    void c(Map<String, String> r1, boolean r2);

    Map<String, String> d();

    PrivilegeClarityEventHub getEventHub();

    String y1();
}
