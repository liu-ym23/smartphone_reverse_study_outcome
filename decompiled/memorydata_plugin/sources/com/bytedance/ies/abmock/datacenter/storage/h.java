package com.bytedance.ies.abmock.datacenter.storage;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0010J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0006\u0010\u0013\u001a\u00020\u000eJ\u001a\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J,\u0010\u001e\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u0001R+\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/storage/LaunchConfigDataManager;", "", "()V", "configSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getConfigSet", "()Ljava/util/HashSet;", "configSet$delegate", "Lkotlin/Lazy;", "launchEnd", "", "addConfig", "", "keys", "", "isLaunchKey", "key", "notifyABRepoLoadEnd", "saveBooleanValue", "jsonObject", "Lcom/google/gson/JsonObject;", "saveCustomTypeValue", "saveDoubleValue", "saveFloatValue", "saveIntValue", "saveLongValue", "saveStringArrayValue", "saveStringValue", "saveValue", "item", "Lcom/bytedance/ies/abmock/ConfigItem;", "data", "mockData", "LaunchRepoInterceptor", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f2719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f2720b = null;
    private static volatile boolean c;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0014H\u0016J\u001f\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\u0018\u0010#\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0014H\u0016J'\u0010$\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010%J\u0018\u0010&\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/storage/LaunchConfigDataManager$LaunchRepoInterceptor;", "Lcom/bytedance/ies/abmock/datacenter/storage/IRepoInterceptor;", "()V", "repo", "Lcom/bytedance/ies/abmock/datacenter/storage/LaunchConfigCenterRepo;", "contains", "", "key", "", "erase", "", "getBooleanValue", "defaultValue", "getDoubleValue", "", "getFloatValue", "", "getIntValue", "", "getLongValue", "", "getStringArrayValue", "", "(Ljava/lang/String;)[Ljava/lang/String;", "getStringValue", "getValue", "", "targetType", "Ljava/lang/Class;", "needIntercept", "storeBooleanValue", EventBody.KEY_VALUE, "storeDoubleValue", "storeFloatValue", "storeIntValue", "storeLongValue", "storeStringArrayValue", "(Ljava/lang/String;[Ljava/lang/String;)V", "storeStringValue", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private g f2721a;

        public a() {
            this.f2721a = g.f2718b;
        }

        @Override // com.bytedance.ies.abmock.datacenter.storage.f
        public void a(String r2, double r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.f2721a.b(r2, r3);
        }

        @Override // com.bytedance.ies.abmock.datacenter.storage.f
        public void a(String r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.f2721a.b(r2, r3);
        }

        @Override // com.bytedance.ies.abmock.datacenter.storage.f
        public void a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.f2721a.b(r2, r3);
        }

        @Override // com.bytedance.ies.abmock.datacenter.storage.f
        public void a(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.f2721a.b(r2, r3);
        }

        @Override // com.bytedance.ies.abmock.datacenter.storage.f
        public void a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
            this.f2721a.b(r2, r3);
        }

        @Override // com.bytedance.ies.abmock.datacenter.storage.f
        public void a(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.f2721a.b(r2, r3);
        }

        @Override // com.bytedance.ies.abmock.datacenter.storage.f
        public void a(String r2, String[] r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.f2721a.a(r2, r3);
        }

        @Override // com.bytedance.ies.abmock.datacenter.storage.f
        public boolean a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "key");
            return h.a(h.f2719a, r1);
        }

        @Override // com.bytedance.ies.abmock.datacenter.storage.f
        public void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.f2721a.c(r2);
        }
    }

    static {
        f2719a = new h();
        f2720b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(LaunchConfigDataManager$configSet$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private h() {
    }

    public static final /* synthetic */ boolean a(h r0, String r1) {
        return r0.a(r1);
    }

    private final boolean a(String r5) {
        boolean r4 = b().contains(r5);
        if (r4 == false) goto L5;
    L7:
        return r4;
    L5:
        if (c == true) goto L7;
        com.bytedance.ies.abmock.datacenter.event.a.f2680a.a(new Throwable("launch_key:" + r5), "IConfigRepo");
        goto L7
    }

    private final HashSet<String> b() {
        return (HashSet) ZeusTransformUtils.preCheckCast(f2720b.getValue(), HashSet.class, "com.obric.memorydata.plugin");
    }

    public final void a() {
        c = true;
    }
}
