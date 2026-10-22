package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.timon.permission.storage.TimonMedia;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public boolean a;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.a$a, reason: collision with other inner class name */
    public static final class C0058a {
    }

    static {
    }

    public a() {
    }

    public final void b(View r10, String r11, final com.bytedance.android.live.liveinteract.jsbridge.method.j r12) {
        Intrinsics.checkNotNullParameter(r12, "callback");
        ALogger.i("CaptureLynxCardManager", "captureCardView viewName: " + r11);
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof LynxView) == true) goto L7;
        return;
    L7:
        if (r11 != null) goto L9;
    L15:
        View r13 = r10;
    L17:
        if (r13 != null) goto L19;
        final Bitmap r14 = null;
    L20:
        if (r14 == null) goto L33;
        final Context r15 = r10.getContext();
        if (this.a == false) goto L25;
        return;
    L25:
        if (((Boolean) vm2.d.V3.getValue(null, vm2.d.a[253(0xfd, float:3.55E-43)])).booleanValue() == false) goto L29;
        Activity r3 = ContextUtil.contextToActivity(r15);
        if (r3 == null) goto L34;
        TimonMedia.withWritePermission$default(r3, new TimonMedia.ExtraInfo("bpea-live_CaptureLynxCardManager_doSavePicBefore", true, true, 24), null, new CaptureLynxCardManager$savePic$$inlined$let$lambda$1(this, r15, r14, r12), 4, null);
        return;
    L34:
        return;
    L29:
        Activity r0 = ContextUtil.contextToActivity(r15);
        SettingKey r2 = m60.i.a;
        new m60.i.b(r0).b(new b(this, r15, r14, r12), null, m60.i.b, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        return;
    L33:
        return;
    L19:
        r13.setDrawingCacheEnabled(true);
        r13.buildDrawingCache();
        r14 = r13.getDrawingCache();
        goto L20
    L9:
        if (r11.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L15;
        r13 = ((LynxView) r10).findViewByName(r11);
        goto L17
    L11:
        r1 = false;
        goto L12
    }

    public static final void a(a r3, Context r4, Bitmap r5, ih0.h r6) {
        boolean r0 = true;
        r3.a = true;
        String r7 = com.bytedance.android.livesdk.share.g.d(r4, r5, "adventure");
        ALogger.i("CaptureLynxCardManager", "savePic imgPath: " + r7);
        if (r7.length() == 0) goto L7;
        r0 = false;
    L7:
        if (r0 == false) goto L9;
        r6.a(UpdateLinkmicStatusResultModel.Code.Failed, r4.getResources().getString(2131922316), null);
    L10:
        r3.a = false;
        return;
    L9:
        r6.a(UpdateLinkmicStatusResultModel.Code.Success, r4.getResources().getString(2131922318), null);
        goto L10
    }
}
