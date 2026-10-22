package com.obric.memorydata.personalcontext.api;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0005J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H&J\u0012\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u0005H&J\b\u0010\u0019\u001a\u00020\u001aH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0010H&J\u0012\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\u001fH&J&\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00102\u0006\u0010!\u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\t¨\u0006%"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/AbsEntityCollector;", "", "<init>", "()V", "isInit", "", LocationMonitorConst.TAG, "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "type", "getType$annotations", "getType", "getInitializedTypes", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "syncDataDelay", "onPermissionChanged", "hasPermission", "onInit", "reIndexData", "noNeedDelete", "getEntitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getNeedRequestPermissions", "getDonateEntityTypeList", "", "getPackageNameByEntityType", "entityType", "getDataAndTriggerIndex", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "ids", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12035b;

    public a() {
        this.f12035b = "AbsEntityCollector";
    }

    public String a() {
        return this.f12035b;
    }

    public abstract String a(int r1);

    public abstract List<AppEntity> a(int r1, List<String> r2);

    public final void a(boolean r7) {
        if (d() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "permission not granted", false, 4, null);
        return;
    L7:
        if (this.f12034a == false) goto L9;
        return;
    L9:
        this.f12034a = b(r7);
    }

    public List<String> b() {
        if (this.f12034a == true) goto L7;
        return null;
    L7:
        return CollectionsKt.listOf(getType());
    }

    public abstract boolean b(boolean r1);

    public void c() {
    }

    public abstract void c(boolean r1);

    public final boolean d() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(g(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r3 = true;
    L4:
        if (r0.hasNext() == false) goto L35;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L4;
        if (Intrinsics.areEqual(r4, "android.permission.MANAGE_EXTERNAL_STORAGE") == true) goto L10;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ContextCompat.checkSelfPermission(r6, r4) != 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L21;
    L33:
        if (r7 == true) goto L4;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "permission not granted: " + r4, false, 4, null);
        r3 = false;
        goto L4
    L21:
        if (Build.VERSION.SDK_INT < 34) goto L33;
        if (Intrinsics.areEqual(r4, "android.permission.READ_MEDIA_IMAGES") == false) goto L25;
    L28:
        boolean r8 = true;
    L29:
        if (r8 == true) goto L31;
    L14:
        r7 = false;
        goto L33
    L31:
        if (ContextCompat.checkSelfPermission(r6, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") != 0) goto L14;
    L13:
        r7 = true;
        goto L33
    L25:
        if (Intrinsics.areEqual(r4, "android.permission.READ_MEDIA_VIDEO") == true) goto L28;
        r8 = false;
        goto L29
    L18:
        r7 = false;
        goto L19
    L10:
        if (Build.VERSION.SDK_INT < 30) goto L14;
        if (Environment.isExternalStorageManager() == false) goto L14;
    L35:
        return r3;
    }

    public abstract EntitySupplier e();

    public EntitySyncDataSupplier f() {
        return null;
    }

    public abstract List<String> g();

    public abstract String getType();

    public abstract List<Integer> h();
}
