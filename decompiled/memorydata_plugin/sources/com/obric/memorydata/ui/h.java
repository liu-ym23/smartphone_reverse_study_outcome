package com.obric.memorydata.ui;

import android.app.Activity;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/ui/TransitAnimHelper;", "", "<init>", "()V", "TAG", "", "openActivityAnim", "", "activity", "Landroid/app/Activity;", "openActivityAnimOpaqueSource", "closeActivityAnim", "closeActivityAnimOpaqueSource", "openSearchAnim", "closeSearchAnim", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f13009a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f13010b = null;

    static {
        f13009a = new h();
        f13010b = "TransitAnimHelper";
    }

    private h() {
    }

    public final void a(Activity r4) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "activity");
        r3.overridePendingTransition(ZeusTransformUtils.mapRes(R.anim.host_oui_activity_open_enter, "anim", "host_oui_activity_open_enter"), ZeusTransformUtils.mapRes(R.anim.host_oui_activity_open_exit, "anim", "host_oui_activity_open_exit"));
    }

    public final void b(Activity r3) {
        Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "activity");
        r2.overridePendingTransition(ZeusTransformUtils.mapRes(R.anim.host_oui_activity_open_enter, "anim", "host_oui_activity_open_enter"), 0);
    }

    public final void c(Activity r4) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "activity");
        r3.overridePendingTransition(ZeusTransformUtils.mapRes(R.anim.host_oui_activity_close_enter, "anim", "host_oui_activity_close_enter"), ZeusTransformUtils.mapRes(R.anim.host_oui_activity_close_exit, "anim", "host_oui_activity_close_exit"));
    }

    public final void d(Activity r3) {
        Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "activity");
        r2.overridePendingTransition(0, ZeusTransformUtils.mapRes(R.anim.host_oui_activity_close_exit, "anim", "host_oui_activity_close_exit"));
    }
}
