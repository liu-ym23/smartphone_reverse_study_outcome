package com.bytedance.android.livesdk.dslservice;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.android.livesdk.dsl.api.IDSLManagerService;
import com.bytedance.android.livesdk.dslservice.slice.cache.e;
import com.bytedance.android.livesdk.dslservice.slice.cache.f;
import com.bytedance.android.livesdk.dslservice.util.DSLTemplateCenter;
import com.bytedance.android.livesdk.dslservice.util.q;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import j70.h;
import java.util.HashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J0\u0010\u0013\u001a\u00020\u0012\"\b\b\u0000\u0010\f*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/dslservice/DSLServiceImpl;", "Lcom/bytedance/android/livesdk/dsl/api/IDSLManagerService;", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lyt1/n;", "createDSLManager", "createDummy", "Lzt1/c;", "createDSLTemplateCenter", "Landroid/view/View;", "T", "", LiveEndPageData.TAG_NAME, "Lyt1/f;", "customProvider", "type", "", "registerCustomViewManger", "Lj70/h;", "Lh70/b;", "getDescriptor", "Lyt1/q;", "key", "", "hasLocalGlobalCache", "onClear", "<init>", "()V", "dslservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DSLServiceImpl implements IDSLManagerService {
    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public void onClear() {
        com.bytedance.android.livesdk.dslservice.util.a.d.d(AnonymousClass1.INSTANCE);     // Catch: Throwable -> L8
        SlcRenderContext r1 = com.bytedance.android.livesdk.dslservice.slice.cache.b.a;     // Catch: Throwable -> L8
        if (r1 == null) goto L6;
        r1.d();     // Catch: Throwable -> L8
    L6:
        com.bytedance.android.livesdk.dslservice.slice.cache.b.a = null;     // Catch: Throwable -> L8
        f.b.b().evictAll();     // Catch: Throwable -> L8
        cu1.b.b.b().evictAll();     // Catch: Throwable -> L8
        DSLTemplateCenter.e.clear();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        SafetyGuard.a(null, th, "SliceLoadError");
    }

    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public n createDummy() {
        return new q();
    }

    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public h<? extends h70.b> getDescriptor() {
        return new d();
    }

    public DSLServiceImpl() {
        k.l(IDSLManagerService.class, this);
    }

    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public zt1.c createDSLTemplateCenter(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return new DSLTemplateCenter(r2);
    }

    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public boolean hasLocalGlobalCache(yt1.q r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (e.b.a(r2) == null) goto L5;
    L8:
        return true;
    L5:
        if (cu1.a.b.a(r2) != null) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public n createDSLManager(Context r1, DataCenter r2) {
        return new c();
    }

    @Override // com.bytedance.android.livesdk.dsl.api.IDSLManagerService
    public <T extends View> void registerCustomViewManger(String r4, yt1.f<T> r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r5, "customProvider");
        Intrinsics.checkNotNullParameter(r6, "type");
        int r1 = r6.hashCode();
        if (r1 == (-1994808941)) goto L11;
        if (r1 == 79973746) goto L8;
    L16:
        com.bytedance.android.livesdk.dslservice.view.b.a(r4, r5);
        return;
    L8:
        if (r6.equals(DSLType.Slice) == false) goto L16;
        com.bytedance.android.livesdk.dslservice.view.b.b(r4, r5);
        return;
    L11:
        if (r6.equals(DSLType.LynxAir) == false) goto L16;
        HashMap<String, yt1.f<? extends View>> r7 = com.bytedance.android.livesdk.dslservice.view.b.a;
        Intrinsics.checkNotNullParameter(r4, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r5, "provider");
        HashMap<String, yt1.f<? extends View>> r8 = com.bytedance.android.livesdk.dslservice.view.b.b;
        if (r8.containsKey(r4) == true) goto L20;
        r8.put(r4, r5);
        return;
    }
}
