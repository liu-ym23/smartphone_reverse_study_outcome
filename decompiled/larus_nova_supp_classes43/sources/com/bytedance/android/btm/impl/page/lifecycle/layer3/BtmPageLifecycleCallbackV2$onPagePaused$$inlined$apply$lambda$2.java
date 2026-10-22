package com.bytedance.android.btm.impl.page.lifecycle.layer3;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.lifecycle.PauseFuncOrigin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/btm/impl/page/lifecycle/layer3/BtmPageLifecycleCallbackV2$onPagePaused$4$3"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmPageLifecycleCallbackV2$onPagePaused$$inlined$apply$lambda$2 extends Lambda implements Function0<String> {
    final /* synthetic */ Object $page$inlined;
    final /* synthetic */ String $pageClassName$inlined;
    final /* synthetic */ PauseFuncOrigin $pauseFuncOrigin$inlined;
    final /* synthetic */ boolean $shouldResumePre;

    public BtmPageLifecycleCallbackV2$onPagePaused$$inlined$apply$lambda$2(boolean r1, Object r10, PauseFuncOrigin r11, String r12) {
        this.$shouldResumePre = r1;
        this.$page$inlined = r10;
        this.$pauseFuncOrigin$inlined = r11;
        this.$pageClassName$inlined = r12;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m847invoke() {
        return this.$pageClassName$inlined + ", node.tree.mResumed=true, shouldResumePre=" + this.$shouldResumePre;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m847invoke();
    }
}
