package com.obric.cae.location.geosdk.poi;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f7225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StarPoiManager f7226b;

    public g(StarPoiManager r3, Handler r4, Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.f7226b = r3;
        this.f7225a = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        super(r4);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r1) {
        StarPoiManager.a(this.f7226b, this.f7225a);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r1, Uri r2) {
        StarPoiManager.a(this.f7226b, this.f7225a);
    }
}
