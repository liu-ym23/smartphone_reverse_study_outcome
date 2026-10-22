package com.bytedance.common.wschannel.app;

import android.app.Application;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.j;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends PluginService implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected WeakHandler f2005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Messenger f2006b;

    public a() {
    }

    private void a() {
        j.a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), null);
    }

    static /* synthetic */ void a(a r2) {
        ((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin")).a();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    public IBinder onBind(Intent r2) {
        Logger.d("AbsMessengerService", "onBind " + this);
        return this.f2006b.getBinder();
    }

    public void onCreate() {
        com.bytedance.common.utility.a.c.a(new AnonymousClass1(this));
        Logger.d("AbsMessengerService", "onCreate " + this);
        this.f2005a = new WeakHandler(this);
        this.f2006b = new Messenger(this.f2005a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Service*/.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onUnbind(Intent r3) {
        Logger.d("AbsMessengerService", "onUnBind " + this);
        return super/*android.app.Service*/.onUnbind(r3);
    }
}
