package bc;

import com.bytedance.ies.bullet.service.base.a0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import wc.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f903a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f904b = null;

    static {
        f903a = new ArrayList();
        f904b = new ArrayList();
    }

    public static void a(a0 r5, g r10) {
        Intrinsics.checkNotNullParameter(r5, "resInfo");
        Intrinsics.checkNotNullParameter(r10, "taskConfig");
        Iterator r11 = f904b.iterator();
        if (r11.hasNext() == true) goto L6;
        return;
    L6:
        throw androidx.constraintlayout.motion.widget.a.g(r11);
    }
}
