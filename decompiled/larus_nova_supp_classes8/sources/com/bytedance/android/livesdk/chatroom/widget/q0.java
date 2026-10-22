package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q0<T> implements Consumer {
    public final /* synthetic */ LiveGiftMenuStickerServiceWidget a;

    public q0(LiveGiftMenuStickerServiceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        JSONObject r9 = (JSONObject) r8;
        if (this.a.h == false) goto L14;
        long r0 = System.currentTimeMillis();
        this.a.f.put(new JSONObject(r9.toString()));
        long r2 = r0 - this.a.e;
        SettingKey r10 = LiveEffectSettings.LIVE_EFFECT_GIFT_MENU_EVENT_FREQUENCY_CONTROL_TIME;
        if (r2 >= ((Long) r10.getValue()).longValue()) goto L10;
        this.a.getClass();
        long r3 = ((Long) r10.getValue()).longValue();
        LiveGiftMenuStickerServiceWidget r11 = this.a;
        long r4 = r3 - (r0 - r11.e);
        if (r11.g != null) goto L12;
        Disposable r1 = Observable.timer(r4, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new p0(this));
        RxUtilKt.c(r1, this.a.a);
        r11.g = r1;
        return;
    L12:
        return;
    L10:
        LiveGiftMenuStickerServiceWidget.wq(this.a);
        return;
    }
}
