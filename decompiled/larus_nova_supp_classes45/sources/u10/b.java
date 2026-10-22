package u10;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface b {
    void a(String r1, String r2, String r3, Map<String, String> r4, byte[] r5, String r6, long r7, Function3<? super Integer, ? super JSONObject, ? super String, Unit> r9, Function1<? super Throwable, Unit> r11, boolean r12);

    void b(String r1, String r2, String r3, Map<String, String> r4, Map<String, String> r5, long r6, Function3<? super Integer, ? super JSONObject, ? super String, Unit> r8, Function1<? super Throwable, Unit> r9, boolean r11);

    boolean c();
}
