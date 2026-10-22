package com.ss.android.lark.officesdk.launcher.base;

import android.app.Application;
import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.internal.g;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKRuntime;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class BaseWarmupCoordinator$warmup$1 extends Lambda implements Function1<IOfficeSDKRuntime, Unit> {
    final /* synthetic */ Application $application;

    public BaseWarmupCoordinator$warmup$1(Application r1) {
        this.$application = r1;
        super(1);
    }

    public final void invoke(IOfficeSDKRuntime r9) {
        Intrinsics.checkNotNullParameter(r9, "it");
        List<b> r10 = a.a;
        Application r11 = this.$application;
        Intrinsics.checkNotNullParameter(r11, "application");
        Iterator<T> r0 = a.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        b r1 = (b) r0.next();
        long r2 = SystemClock.elapsedRealtime();
        Log.i("BaseWarmupExecutor", "OfficeSDK_Boot_Warmup_Task_Begin: " + r1.name());
        r1.a(r11);
        long r6 = SystemClock.elapsedRealtime() - r2;
        Log.i("BaseWarmupExecutor", "OfficeSDK_Boot_Warmup_Task_End: " + r1.name() + ", cost: " + r6 + "ms");
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r3 = g.a;
        String r4 = r1.name();
        Intrinsics.checkNotNullParameter(r4, AppbrandHostConstants.Schema_Meta.NAME);
        g.a(r4, "warmup", r6);
        goto L4
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IOfficeSDKRuntime) r1);
        return Unit.INSTANCE;
    }
}
