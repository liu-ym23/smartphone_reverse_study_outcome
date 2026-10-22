package com.ss.android.lark.forwardv3;

import android.os.SystemClock;
import androidx.lifecycle.Observer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchCustomInfo;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w<T> implements Observer {
    public final /* synthetic */ ForwardNewFragment a;

    public w(ForwardNewFragment r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onChanged(Object r8) {
        sib.a r9 = (sib.a) r8;
        Log.i("NewForward", "recommend data change");
        IGetDataCallback<List<SearchBaseInfo>> r3 = null;
        if ((r9 instanceof sib.a.b) == false) goto L24;
        StringBuilder r0 = new StringBuilder("recommend data is ready, hide skeleton, from local: ");
        sib.a.b r10 = (sib.a.b) r9;
        r0.append(((rib.b) r10.a).d);
        Log.i("NewForward", r0.toString());
        tib.e r1 = this.a.e;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r1 = null;
    L7:
        r1.a();
        ForwardV3ViewModel r2 = this.a.f;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L11:
        if (r2.getEnableRecentForward() == true) goto L13;
    L18:
        IGetDataCallback<List<SearchBaseInfo>> r4 = this.a.i;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("callback");
    L22:
        r3.onSuccess(((rib.b) r10.a).a);
        long r5 = SystemClock.elapsedRealtime() - this.a.o;
        boolean r6 = zib.b.d;
        rib.b r7 = (rib.b) r10.a;
        zib.b.c(r7.d, r5, r7.c);
        Log.i("NewForward", "from start activity to ui success cost: " + r5 + "\ndata is from local: " + ((rib.b) r10.a).d + "\nfrom get data to data success cost: " + ((rib.b) r10.a).c + "\nfrom local: " + ((rib.b) r10.a).d + '\n');
        return;
    L21:
        r3 = r4;
        goto L22
    L13:
        if ((!((rib.b) r10.a).b.isEmpty()) == false) goto L18;
        ListProtector.add(((rib.b) r10.a).a, 0, new SearchCustomInfo());
        RecentForwardAdapterV3 r11 = this.a.h;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("recentForwardAdapter");
        r11 = null;
    L17:
        r11.diff(((rib.b) r10.a).b);
        goto L18
    L24:
        if ((r9 instanceof sib.a.C0325a) == false) goto L32;
        Log.i("NewForward", "recommend data is loading, show skeleton");
        IGetDataCallback<List<SearchBaseInfo>> r12 = this.a.e;
        if (r12 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
    L29:
        r3.d();
        return;
    L28:
        r3 = r12;
        goto L29
    L32:
        throw new NoWhenBranchMatchedException();
    }
}
