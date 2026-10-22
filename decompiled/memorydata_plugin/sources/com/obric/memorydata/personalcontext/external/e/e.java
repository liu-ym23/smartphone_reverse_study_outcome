package com.obric.memorydata.personalcontext.external.e;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.personalcontext.external.g;
import com.obric.memorydata.personalcontext.external.i;
import com.obric.memorydata.personalcontext.external.message.f;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/sms/SmsMmsSubCollector;", "Lcom/obric/memorydata/personalcontext/external/sms/AbstractExternalSmsSubCollector;", "<init>", "()V", LocationMonitorConst.TAG, "", "getTag", "()Ljava/lang/String;", "createObserver", "Lcom/obric/memorydata/personalcontext/external/sms/IExternalSmsInitFetcher;", "context", "Landroid/content/Context;", "indexUpdater", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "hasPermission", "", "supportDonateEntityTypeList", "", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12126a;

    public e() {
        this.f12126a = "External_SmsMms";
    }

    @Override // com.obric.memorydata.personalcontext.external.e.a
    public String a() {
        return this.f12126a;
    }

    @Override // com.obric.memorydata.personalcontext.external.e.a
    public d b(Context r5, i r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "indexUpdater");
        com.obric.memorydata.personalcontext.external.message.c r7 = new com.obric.memorydata.personalcontext.external.message.c(r4, r6);
        ZeusProviderTransform.registerContentObserver(r4.getContentResolver(), com.obric.memorydata.personalcontext.external.message.a.a(), true, (ContentObserver) ZeusTransformUtils.preCheckCast(r7, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        ZeusProviderTransform.registerContentObserver(r4.getContentResolver(), com.obric.memorydata.personalcontext.external.message.a.b(), true, (ContentObserver) ZeusTransformUtils.preCheckCast(r7, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        ZeusProviderTransform.registerContentObserver(r4.getContentResolver(), com.obric.memorydata.personalcontext.external.message.a.c(), true, (ContentObserver) ZeusTransformUtils.preCheckCast(r7, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        com.obric.memorydata.personalcontext.external.message.e r8 = f.f12159a.a();     // Catch: Exception -> L11
        if (r8 == null) goto L6;
        Uri r9 = r8.a();     // Catch: Exception -> L11
    L7:
        if (r9 == null) goto L10;
        ZeusProviderTransform.registerContentObserver(r4.getContentResolver(), r9, true, (ContentObserver) ZeusTransformUtils.preCheckCast(r7, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Exception -> L11
        goto L10
    L6:
        r9 = null;
    L10:
        return (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.external.e.a
    public boolean d() {
        return g.f12138a.c();
    }

    @Override // com.obric.memorydata.personalcontext.external.e.a
    public List<Integer> e() {
        return CollectionsKt.listOf(101);
    }
}
