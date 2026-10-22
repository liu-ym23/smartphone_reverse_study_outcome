package wia;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.obric.capabilitykit.ErrorCodeCallback;
import com.obric.capabilitykit.TaskStateChangeCallback;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface n {
    void a(long r1);

    void a(String r1, TaskStateInfo r2, TaskStateChangeCallback r3, Long r4);

    void a(String r1, String r2);

    void a(String r1, String r2, String r3);

    boolean a();

    void b(long r1);

    void b(IMAppAction r1);

    Boolean c(long r1);

    void c(Uri r1, String r2);

    void d(Uri r1, String r2, IUriFileReceiver r3);

    PendingIntent e(long r1, Intent r3, FloatingIntentParams r4);

    void f(IntentResult<?> r1, long r2, boolean r4, Map<String, String> r5);

    void g(ErrorCodeCallback r1);

    void h(ErrorCodeCallback r1);

    void i(IntentResult<?> r1, IMAppAction r2);
}
