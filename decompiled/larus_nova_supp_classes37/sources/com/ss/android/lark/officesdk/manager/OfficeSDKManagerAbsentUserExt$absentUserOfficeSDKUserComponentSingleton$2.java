package com.ss.android.lark.officesdk.manager;

import android.app.Application;
import android.content.Context;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.UserComponentEntryPoint;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.picker.base.view.ItemViewType;
import dagger.hilt.EntryPoints;
import e0c.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponent;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class OfficeSDKManagerAbsentUserExt$absentUserOfficeSDKUserComponentSingleton$2 extends Lambda implements Function0<OfficeSDKUserComponent> {
    public static final OfficeSDKManagerAbsentUserExt$absentUserOfficeSDKUserComponentSingleton$2 INSTANCE = null;

    static {
        INSTANCE = new OfficeSDKManagerAbsentUserExt$absentUserOfficeSDKUserComponentSingleton$2();
    }

    public OfficeSDKManagerAbsentUserExt$absentUserOfficeSDKUserComponentSingleton$2() {
        super(0);
    }

    public final OfficeSDKUserComponent invoke() {
        Context r0 = OfficeSDKManager.getContext();
        if (r0 == null) goto L5;
        Context r1 = r0.getApplicationContext();
    L6:
        if (r1 == null) goto L13;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.Application");
        OfficeSDKUserComponent r2 = ((UserComponentEntryPoint) EntryPoints.get(((v) k.a((Application) r1, v.class)).c(ContainerConstsKt.a()), UserComponentEntryPoint.class)).getOfficeSDKUserComponentManager().generatedComponent();
        if (r2 == null) goto L11;
        return r2;
    L11:
        throw new IllegalStateException("Failed to create OfficeSDK absent user component".toString());
    L13:
        throw new IllegalStateException("OfficeSDK not initialized".toString());
    L5:
        r1 = null;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m154invoke() {
        return invoke();
    }
}
