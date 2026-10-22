package com.obric.aiagent.ipc.control;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0004\u0016\u0017\u0018\u0019B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\n\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\rH&R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/obric/aiagent/ipc/control/IPCControl;", i.m, "S", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "get", "()Ljava/lang/Object;", "create", "Lcom/obric/aiagent/ipc/control/IPCControl$CreateResult;", f.c, "Lcom/obric/aiagent/ipc/control/IPCControl$Callback;", "destroy", "", "appStateChange", "isForeground", "", "forceRebind", "Callback", "CreateResult", "Companion", "RetryStrategy", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class c<P, S> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f5931b = null;
    private static final ConcurrentHashMap<String, c<Intent, IBinder>> c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5932a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/ipc/control/IPCControl$Callback;", "S", "", "onCreate", "", "onReady", "service", "(Ljava/lang/Object;)V", "onDied", "onDestroy", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a<S> {
        void a();

        void a(S r1);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\tJ\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\tJ,\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J)\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\t2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0000¢\u0006\u0002\b\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/ipc/control/IPCControl$Companion;", "", "<init>", "()V", "TAG", "", "intentControl", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/aiagent/ipc/control/IPCControl;", "Landroid/content/Intent;", "Landroid/os/IBinder;", "intentKey", MemorySourceLinkType.INTENT, "explicitIntent", "context", "Landroid/content/Context;", "ofBinder", "config", "Lcom/obric/aiagent/ipc/control/BinderControlConfig;", "releaseBinder", "", "control", "releaseBinder$ipc_base_release", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        public final Intent a(Context r2, Intent r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
            if (r3.getComponent() == null) goto L6;
            return r3;
        L6:
            if (r3.getPackage() == null) goto L8;
            return r3;
        L8:
            List<ResolveInfo> r4 = r1.getPackageManager().queryIntentServices(r3, 0);
            Intrinsics.checkNotNullExpressionValue(r4, "queryIntentServices(...)");
            if (r4.isEmpty() == false) goto L12;
            return null;
        L12:
            Intent r5 = new Intent(r3);
            r5.setPackage(((ResolveInfo) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r4), ResolveInfo.class, "com.obric.memorydata.plugin")).serviceInfo.packageName);
            return r5;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.ipc.control.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/obric/aiagent/ipc/control/IPCControl$CreateResult;", "", "isSuccess", "", "errMsg", "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getErrMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0238c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f5933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f5934b;

        public C0238c(boolean r1, String r2) {
            this.f5933a = r1;
            this.f5934b = r2;
        }

        public /* synthetic */ C0238c(boolean r1, String r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0238c.class) == true) goto L8;
            return false;
        L8:
            C0238c r6 = (C0238c) ZeusTransformUtils.preCheckCast(r5, C0238c.class, "com.obric.memorydata.plugin");
            if (this.f5933a == r6.f5933a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f5934b, r6.f5934b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f5933a) * 31;
            String r1 = this.f5934b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "CreateResult(isSuccess=" + this.f5933a + ", errMsg=" + this.f5934b + ')';
        }
    }

    static {
        f5931b = new b(null);
        c = new ConcurrentHashMap();
    }

    public final Context getContext() {
        return this.f5932a;
    }
}
