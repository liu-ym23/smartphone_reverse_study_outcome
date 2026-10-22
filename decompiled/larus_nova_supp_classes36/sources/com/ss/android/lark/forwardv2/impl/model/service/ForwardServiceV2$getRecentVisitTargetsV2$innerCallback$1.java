package com.ss.android.lark.forwardv2.impl.model.service;

import android.os.SystemClock;
import com.bytedance.lark.pb.feed.v1.ForwardCommonData;
import com.bytedance.lark.pb.feed.v1.GetRecentVisitTargetsResponseV2;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/forwardv2/impl/model/service/ForwardServiceV2$getRecentVisitTargetsV2$innerCallback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/bytedance/lark/pb/feed/v1/GetRecentVisitTargetsResponseV2;", "onSuccess", "", "response", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardServiceV2$getRecentVisitTargetsV2$innerCallback$1 implements IGetDataCallback<GetRecentVisitTargetsResponseV2> {
    final /* synthetic */ IGetDataCallback<List<SearchBaseInfo>> $callback;
    final /* synthetic */ boolean $isLocal;
    final /* synthetic */ long $startRequestVisitTime;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        this.$callback.onSuccess(new ArrayList());
        Log.e("Android_Recent_Visit_V2", "from local: " + this.$isLocal + ", GetRecentVisitTargetsResponseV2 + " + r3, r3.getCause());
    }

    public void onSuccess(GetRecentVisitTargetsResponseV2 r9) {
        Log.i("Android_Recent_Visit_V2", "load recent visit successful, sdk cost: " + (SystemClock.elapsedRealtime() - this.$startRequestVisitTime) + ", from local: " + this.$isLocal);
        if (r9 == null) goto L18;
        List r0 = r9.targets;
        if (r0 == null) goto L18;
        ArrayList r3 = new ArrayList();
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        ForwardCommonData r4 = (ForwardCommonData) r1.next();
        WeakReference<Message> r5 = ForwardDataUtils.a;
        Intrinsics.checkNotNull(r4);
        SearchBaseInfo r6 = ForwardDataUtils.e(r4);
        if (r6 == null) goto L8;
        r3.add(r6);
        goto L8
    L12:
        com.ss.android.lark.forwardv3.utils.b.d();
        List r2 = CollectionsKt.take(r3, 30);
        if (r2 == null) goto L18;
        IGetDataCallback<List<SearchBaseInfo>> r7 = this.$callback;
        WeakReference<Message> r8 = ForwardDataUtils.a;
        Map r10 = r9.can_not_select_chatter_map;
        if (r10 != null) goto L17;
        r10 = MapsKt.emptyMap();
    L17:
        ForwardDataUtils.b(r2, r10);
        r7.onSuccess(r2);
        return;
    L18:
        boolean r11 = this.$isLocal;
        IGetDataCallback<List<SearchBaseInfo>> r12 = this.$callback;
        StringBuilder r13 = new StringBuilder("GetRecentVisitTargetsResponseV2 is null: ");
        boolean r14 = false;
        if (r9 != null) goto L21;
        boolean r15 = true;
    L22:
        r13.append(r15);
        r13.append(", target is null: ");
        if (r9 == null) goto L25;
        List r16 = r9.targets;
    L26:
        if (r16 != null) goto L28;
        r14 = true;
    L28:
        r13.append(r14);
        r13.append(", from local: ");
        r13.append(r11);
        Log.e("Android_Recent_Visit_V2", r13.toString());
        r12.onSuccess(new ArrayList());
        return;
    L25:
        r16 = null;
        goto L26
    L21:
        r15 = false;
        goto L22
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((GetRecentVisitTargetsResponseV2) r1);
    }

    public ForwardServiceV2$getRecentVisitTargetsV2$innerCallback$1(long r1, boolean r3, IGetDataCallback<List<SearchBaseInfo>> r4) {
        this.$startRequestVisitTime = r1;
        this.$isLocal = r3;
        this.$callback = r4;
    }
}
