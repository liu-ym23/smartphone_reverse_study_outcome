package com.ss.android.lark.lynxkit.xbridge.depend;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostRouterDepend;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import g66.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ova.f;
import r56.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J@\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/depend/XHostRouterDependImpl;", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostRouterDepend;", "<init>", "()V", "closeView", "", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "containerID", "", "animated", "openSchema", "schema", "extraParams", "", "", "platformType", "context", "Landroid/content/Context;", "Companion", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class XHostRouterDependImpl implements IHostRouterDepend {
    public static final Companion Companion = null;
    private static final String TAG = "XHostRouterDependImpl";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/depend/XHostRouterDependImpl$Companion;", "", "<init>", "()V", "TAG", "", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public XHostRouterDependImpl() {
    }

    public a provideRouteOpenExceptionHandler(c r1) {
        return null;
    }

    public List<a> provideRouteOpenHandlerList(c r1) {
        return CollectionsKt.emptyList();
    }

    public boolean closeView(c r1, XBridgePlatformType r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (r1 == null) goto L6;
        Activity r5 = (Activity) r1.c(Activity.class);
        if (r5 == null) goto L6;
    L13:
        if (r5 == null) goto L16;
        r5.finish();
        return true;
    L16:
        Log.w(TAG, "closeView failed: no ownerActivity for container=" + r3);
        return false;
    L6:
        r5 = null;
        if (r1 == null) goto L9;
        Context r6 = (Context) r1.c(Context.class);
    L11:
        if ((r6 instanceof Activity) == false) goto L13;
        r5 = (Activity) r6;
        goto L13
    L9:
        r6 = null;
        goto L11
    }

    public boolean openSchema(c r7, String r8, Map<String, ? extends Object> r9, XBridgePlatformType r10, Context r11) {
        Intrinsics.checkNotNullParameter(r8, "schema");
        Intrinsics.checkNotNullParameter(r9, "extraParams");
        Intrinsics.checkNotNullParameter(r10, "platformType");
        if (r11 != null) goto L16;
        if (r7 == null) goto L6;
        Context r12 = (Context) r7.c(Context.class);
    L7:
        r11 = r12;
        if (r11 != null) goto L16;
        return false;
    L6:
        r12 = null;
    L16:
        return f.m().C(r11, r8, 13, null, null);
    L13:
        th = move-exception;
        Log.e(TAG, "openSchema failed: " + r8, th);
        return false;
    }
}
