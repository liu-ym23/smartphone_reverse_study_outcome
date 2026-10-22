package s3;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.method.datamanager.StorageInputParam;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import d3.a0;
import e3.d;
import k2.j;
import kotlin.jvm.internal.Intrinsics;
import u4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {

    /* JADX INFO: renamed from: s3.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0193a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WORKER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ContainerType.WIDGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ContainerType.PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final u4.a a(d r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        a0 r0 = r10.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r1 = r0.getContainerType();
    L6:
        if (r1 != null) goto L8;
        int r11 = -1;
    L10:
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L21;
        if (r11 == 3) goto L20;
        return null;
    L20:
        return (u4.a) r10.d(j.class);
    L21:
        return (u4.a) r10.d(WidgetContainer.class);
    L19:
        return (u4.a) r10.d(AppletRuntime.class);
    L8:
        r11 = C0193a.a[r1.ordinal()];
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static final b b(d r10, StorageInputParam r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        u4.a r12 = a(r10);
        g r0 = g.a;
        r0.d("AbsAIStorageMethod", "dataManager " + r12);
        if (r12 == null) goto L5;
        a6.a r13 = r12.getViewModel(r11.isShared(), r11.getGroupId());
    L6:
        r0.d("AbsAIStorageMethod", "viewModel " + r13);
        if (r13 != null) goto L9;
        return null;
    L9:
        return r13.getIStorage();
    L5:
        r13 = null;
        goto L6
    }
}
