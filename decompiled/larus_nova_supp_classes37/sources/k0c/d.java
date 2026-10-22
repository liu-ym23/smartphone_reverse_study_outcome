package k0c;

import com.ss.android.lark.passportc.api.ExecuteStrategy;
import com.ss.android.lark.passportc.task.f;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface d {
    Observable<j0c.c> a(j0c.e r1, ExecuteStrategy r2);

    void b(d r1);

    j0c.b c();

    List<d> children();

    void d(d r1);

    int getOrder();

    f getTask();

    List<d> parents();
}
