package com.bytedance.android.btm.impl.page.lifecycle.layer3;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmPageLifecycleCallbackV2$onPageCreated$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $pageClassName;
    final /* synthetic */ PageProp $prop;
    final /* synthetic */ String $relatedPageBtm;
    final /* synthetic */ String $relatedPageClassName;

    public BtmPageLifecycleCallbackV2$onPageCreated$4(PageProp r1, String r10, String r11, String r12) {
        this.$prop = r1;
        this.$relatedPageClassName = r10;
        this.$relatedPageBtm = r11;
        this.$pageClassName = r12;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m843invoke() {
        g$a.a(BtmMonitor.c, 2312, null, null, new AnonymousClass1(this), 30);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m843invoke();
        return Unit.INSTANCE;
    }
}
