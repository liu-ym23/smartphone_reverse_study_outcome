package obric.flow.externalcard;

import android.os.Bundle;
import android.view.View;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.i2;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i2 f20437a = null;

    static {
        f20437a = i.a(0, 7, null);
    }

    public static void a(View r10, Bundle r11) {
        BuildersKt.launch$default(h0.b(), null, null, new ExternalCardEventService$longClickMenuClicked$1(r10, r11, null), 3, null);
    }

    public static void b(boolean r10) {
        BuildersKt.launch$default(h0.b(), null, null, new ExternalCardEventService$minusOneExit$1(r10, null), 3, null);
    }

    public static void c(boolean r10) {
        BuildersKt.launch$default(h0.b(), null, null, new ExternalCardEventService$onResumeOrPause$1(r10, null), 3, null);
    }

    public static void d(boolean r10) {
        BuildersKt.launch$default(h0.b(), null, null, new ExternalCardEventService$screenChange$1(r10, null), 3, null);
    }

    public static void e(View r10, Bundle r11) {
        BuildersKt.launch$default(h0.b(), null, null, new ExternalCardEventService$showLongClickMenu$1(r10, r11, null), 3, null);
    }
}
