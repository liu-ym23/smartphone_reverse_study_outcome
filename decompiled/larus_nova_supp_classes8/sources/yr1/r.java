package yr1;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LandscapeTopMoreAdapter;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.z;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface r {
    void a(LifecycleOwner r1, Function0<Unit> r2);

    LandscapeTopMoreAdapter c(Context r1, DataCenter r2, List r3, int r4, int r5, Function1 r6);

    z<pp1.c> createToolbarBubble(DataCenter r1, Context r2, View r3);

    boolean d(String r1);

    void f(LifecycleOwner r1, Function3<? super Uri, ? super Integer, ? super DialogInterface.OnDismissListener, Unit> r2);

    void g(String r1);

    boolean h(String r1);

    boolean i(boolean r1);

    void j(List<String> r1);

    void k();

    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e n(ExtendedToolbarButton r1, List r2);
}
