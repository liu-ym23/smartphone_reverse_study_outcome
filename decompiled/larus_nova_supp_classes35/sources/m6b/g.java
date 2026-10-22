package m6b;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.service.impl.b2;
import com.ss.android.lark.dto.draft.Draft;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface g {
    Draft Ea(String r1);

    void M8(String r1, int r2);

    void Mb(String r1, String r2);

    Draft Na(String r1);

    Draft Pc(String r1);

    void a8(String r1);

    Draft b6(String r1);

    Draft b8(String r1);

    Executor getExecutor();

    void o5(b2.a r1, String r2, String r3, com.ss.android.lark.chat.service.impl.r.a r4);

    Map<String, Draft> se(List<String> r1);

    void tc(String r1, Draft r2, boolean r3, String r4);

    String x8(Chat r1, Draft r2, boolean r3);
}
