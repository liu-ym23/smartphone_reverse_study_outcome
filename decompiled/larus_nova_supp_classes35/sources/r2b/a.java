package r2b;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.biz.plugin.watermark.ChatWatermarkViewModel;
import com.ss.android.lark.chat.chatwindow.biz.plugin.watermark.WaterMarkPlugin;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public final /* synthetic */ Chat a;
    public final /* synthetic */ WaterMarkPlugin b;

    public final void a() {
        boolean r1 = true;
        if (ljb.a.a().s() != 0) goto L17;
        Log.i("WaterMarkPlugin", "global watermark is on chatId: " + this.a.getId());
        ChatWatermarkViewModel r0 = this.b.h;
        if (r0 != null) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == false) goto L13;
        Log.i("WaterMarkPlugin", "global watermark is on reAttach: " + this.a.getId());
        this.b.F();
        return;
    L13:
        ChatWatermarkViewModel r2 = this.b.h;
        if (r2 == null) goto L32;
        r2.updateWatermarkState(3);
        return;
    L32:
        return;
    L7:
        if (r0.getWatermarkState() != 2) goto L9;
    L17:
        Log.i("WaterMarkPlugin", "global watermark is off chatId: " + this.a.getId());
        WaterMarkPlugin r3 = this.b;
        Chat r4 = this.a;
        r3.getClass();
        boolean r5 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin_security_myai_watermark");
        boolean r6 = r4.isAIChat();
        Log.i("WaterMarkPlugin", "isFgOn: " + r5 + ", isAIChat: " + r6);
        if (r5 == false) goto L21;
        if (r6 == false) goto L21;
    L22:
        if (r1 == false) goto L25;
        r3.F();
        return;
    L25:
        if (r4.isCrossTenant() == true) goto L28;
        Log.i("WaterMarkPlugin", "chat is not cross tenant, not show watermark chatId: " + r4.getId());
        return;
    L28:
        if (r4.isHasWatermark() == true) goto L30;
        Log.i("WaterMarkPlugin", "chat is cross tenant, not hasWatermark chatId: " + r4.getId());
        return;
    L30:
        Log.i("WaterMarkPlugin", "chat is cross tenant, hasWatermark chatId: " + r4.getId());
        r3.F();
        return;
    L21:
        r1 = false;
        goto L22
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(Chat r1, WaterMarkPlugin r2) {
        this.a = r1;
        this.b = r2;
    }
}
