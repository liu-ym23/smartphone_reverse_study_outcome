package com.bytedance.android.live.service.grouppurchasetip;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.ProfileStyleParams;
import com.bytedance.android.live.base.model.user.d0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements SingleObserver<IBaseUser> {
    public final /* synthetic */ a a;
    public final /* synthetic */ View b;

    public final void onError(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        Disposable r0 = this.a.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a.c = null;
        ALogger.e("AnchorGroupPurchaseTipManager", "query anchor profile style error: " + r3.getMessage());
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.a.c = r2;
    }

    public final void onSuccess(Object r7) {
        IBaseUser r8 = (IBaseUser) r7;
        Intrinsics.checkNotNullParameter(r8, "user");
        Disposable r0 = this.a.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a.c = null;
        d0 r1 = r8.getProfileStyleParams();
        if (r1 != null) goto L8;
    L10:
        d0 r9 = r8.getProfileStyleParams();
        if (r9 != null) goto L13;
    L15:
        a r10 = this.a;
        View r2 = this.b;
        r10.getClass();
        if (r2 == null) goto L18;
        Context r3 = r2.getContext();
    L19:
        Activity r4 = ContextUtil.contextToActivity(r3);
        if (r4 == null) goto L31;
        View r5 = LayoutInflater.from(r4).inflate(2131565137, null);
        if (r5 == null) goto L27;
        View r6 = r5.findViewById(2131388733);
        if (r6 == null) goto L27;
        r6.setOnClickListener(new d(new AnchorGroupPurchaseTipManager$showPopupWindow$1(r10)));
    L27:
        r10.a = true;
        c90.a.a r12 = new c90.a.a(r4);
        r12.f = false;
        Intrinsics.checkNotNullParameter(r5, "view");
        r12.g = r5;
        r12.e = 5000;
        r12.b = false;
        r12.a = ColorProtector.parseColor("#393B44");
        r12.c = UtilityKotlinExtentionsKt.i(-5);
        r12.d = UtilityKotlinExtentionsKt.i(-13);
        new c90.a(r12).i(r2, 80, false);
        j0.l().sendLog("livesdk_showcase_notice_show", MapsKt.emptyMap(), new Object[]{IRoom.class});
        e<us0.a> r13 = ts0.a.a;
        us0.a r14 = (us0.a) r13.getValue();
        r14.c(false);
        r14.d(r14.b() + 1);
        f.d(r13, r14);
        return;
    L31:
        return;
    L18:
        r3 = null;
        goto L19
    L13:
        if (r9.getProfileStyle() != ProfileStyleParams.LOCAL_LIFE) goto L15;
        return;
    L8:
        if (r1.getSmartSwitch() != 1) goto L10;
    }

    public c(a r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
