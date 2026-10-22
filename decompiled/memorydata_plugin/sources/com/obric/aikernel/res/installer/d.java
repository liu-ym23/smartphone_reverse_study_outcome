package com.obric.aikernel.res.installer;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PrmContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0010J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0007H&¨\u0006\u0011"}, d2 = {"Lcom/obric/aikernel/res/installer/IInstaller;", "", "install", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "type", "", ActivityLifecycle.NAME, "version", "installAll", "", "installAllWithInfos", "", "Lcom/obric/aikernel/res/installer/IInstaller$InstallDetails;", LocationMonitorConst.TAG, "InstallDetails", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface d {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static void a(d r2, PrmContext r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
        }

        public static boolean a(d r2, PrmContext r3, String r4, String r5, String r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "type");
            Intrinsics.checkNotNullParameter(r5, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r6, "version");
            return false;
        }

        public static List<Object> b(d r2, PrmContext r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            r4.a(r3);
            return CollectionsKt.emptyList();
        }
    }

    String a();

    void a(PrmContext r1);

    boolean a(PrmContext r1, String r2, String r3, String r4);

    List<Object> b(PrmContext r1);
}
