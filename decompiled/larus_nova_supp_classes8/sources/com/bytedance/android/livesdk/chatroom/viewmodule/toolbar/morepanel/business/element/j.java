package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.ViewGroup;
import com.bytedance.android.livehostapi.business.shareinter.ILiveImShareCallback;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMContact;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMError;
import com.bytedance.android.livehostapi.business.shareinter.LiveSharePackageWrapper;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements ILiveImShareCallback {
    public final /* synthetic */ AudienceShareIMElement a;
    public final /* synthetic */ ViewGroup b;

    public j(AudienceShareIMElement r1, ViewGroup r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onShareSuccessWithSingleUser(LiveSharePackageWrapper r1, LiveIMContact r2) {
        ILiveImShareCallback.-CC.$default$onShareSuccessWithSingleUser(this, r1, r2);
        if (r2 != null) goto L5;
        return;
    L5:
        AudienceShareIMElement.n(this.a, CollectionsKt.listOf(r2));
        AudienceShareIMElement.o(this.a);
    }

    public final void onShareFailedWithUser(LiveSharePackageWrapper r2, List<? extends LiveIMContact> r3, LiveIMError r4) {
        Intrinsics.checkNotNullParameter(r3, "contractList");
        ILiveImShareCallback.-CC.$default$onShareFailedWithUser(this, r2, r3, r4);
        AudienceShareIMElement.n(this.a, r3);
        AudienceShareIMElement.o(this.a);
    }
}
