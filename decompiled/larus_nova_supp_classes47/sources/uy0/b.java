package uy0;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.h2;
import dy0.c;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b extends f80.a, c {
    com.bytedance.android.live.revenue.platform.file.impl.a H2(String r1, h2 r2);

    boolean J(String r1);

    void L(String r1);

    Single<String> V2(String r1);

    boolean Y4(String r1);

    List<String> c(String r1);

    boolean k3(String r1);

    long l4(String r1);

    String o(String r1);

    long q5();

    Observable<Unit> unZipFolder(String r1, String r2);
}
