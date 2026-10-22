package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import android.content.Context;
import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import com.bytedance.android.livesdkapi.service.IPreviewBarrageService;
import com.bytedance.android.livesdkapi.service.OpenParams;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements IPreviewBarrageService {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public final boolean isDanmakuOpen() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = SimpleSettingManager.a;
        return SimpleSettingManager.b().f();
    }

    public final void openDanmakuSettingDialog(Context r2, OpenParams r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        IBarrageService r0 = (IBarrageService) k.f(IBarrageService.class);
        if (r0 == null) goto L6;
        r0.openPortraitSimpleBarrageSettingDialog(r2, r3);
        return;
    }

    public final void switchDanmaKu(boolean r2, ChangeSettingSource r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = SimpleSettingManager.a;
        o r1 = SimpleSettingManager.b();
        r1.h(r2);
        SimpleSettingManager.f(r1, r3);
        SimpleSettingManager.e(null);
    }
}
