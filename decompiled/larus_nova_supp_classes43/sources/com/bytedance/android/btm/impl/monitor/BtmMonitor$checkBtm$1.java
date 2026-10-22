package com.bytedance.android.btm.impl.monitor;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class BtmMonitor$checkBtm$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $btm;
    final /* synthetic */ boolean $enterPage;
    final /* synthetic */ Boolean $isJsb;
    final /* synthetic */ Object $page;
    final /* synthetic */ PageInfo $pageInfo;
    final /* synthetic */ String $type;

    public BtmMonitor$checkBtm$1(String r1, boolean r10, String r11, Object r12, PageInfo r13, Boolean r14) {
        this.$btm = r1;
        this.$enterPage = r10;
        this.$type = r11;
        this.$page = r12;
        this.$pageInfo = r13;
        this.$isJsb = r14;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m647invoke() {
        BtmMonitor r0 = BtmMonitor.c;
        String r1 = this.$btm;
        boolean r10 = this.$enterPage;
        String r11 = this.$type;
        Object r12 = this.$page;
        if (r12 != null) goto L6;
        CopyOnWriteArrayList<com.bytedance.android.btm.impl.util.f<Object>> r13 = com.bytedance.android.btm.impl.page.b.a;
        r12 = com.bytedance.android.btm.impl.page.b.b;
    L6:
        r0.h(r1, r10, r11, r12, this.$pageInfo, this.$isJsb);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m647invoke();
        return Unit.INSTANCE;
    }
}
