package com.obric.aiagent.product.platform.api.vibratefeedback;

import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.feature.b.a;
import com.obric.aiagent.product.platform.impl.vibratefeedback.CommonVibrateFeedback;
import com.obric.aiagent.product.platform.impl.vibratefeedback.PacificVibrateFeedback;
import com.ss.android.ugc.aweme.framework.services.f;
import com.ss.android.ugc.aweme.framework.services.g;
import com.ss.android.ugc.aweme.framework.services.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/aiagent/product/platform/api/vibratefeedback/VibrateFeedback;", "Lcom/obric/aiagent/product/platform/api/vibratefeedback/IVibrateFeedback;", "<init>", "()V", "TAG", "", "instance", "performVibratorSmtFeedback", "", "feedbackType", "Lcom/obric/aiagent/product/platform/api/vibratefeedback/FeedbackType;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VibrateFeedback implements IVibrateFeedback {
    public static final VibrateFeedback INSTANCE = null;
    private static final String TAG = "VibrateFeedback";
    private static IVibrateFeedback instance;

    static {
        INSTANCE = new VibrateFeedback();
    L16:
        th = move-exception;
        d.f5954a.b(TAG, "init failed", th);
    L18:
        instance = (IVibrateFeedback) ZeusTransformUtils.preCheckCast(f.a().a(IVibrateFeedback.class, false), IVibrateFeedback.class, "com.obric.memorydata.plugin");
        return;
    L4:
        if (a.f5977b.a().e() == true) goto L23;
        f.a().a(IVibrateFeedback.class, (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$VibrateFeedback$xW0kwk1IGDr3iVWoa76uHsAVL6c.INSTANCE), g.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
        d.f5954a.b(TAG, "bind CommonVibrateFeedback");     // Catch: Throwable -> L13
    L13:
        th = th;
        d.b r3 = d.f5954a;     // Catch: Throwable -> L16
        String r4 = "bind CommonVibrateFeedback failed";
    L9:
        r3.b(TAG, r4, th);     // Catch: Throwable -> L16
        goto L18
    L23:
        f.a().a(IVibrateFeedback.class, (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$VibrateFeedback$_0GDTAL9ODdt9wweCpMmvF5fJIg.INSTANCE), g.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        d.f5954a.b(TAG, "bind PacificVibrateFeedback");     // Catch: Throwable -> L7
    L7:
        th = th;
        r3 = d.f5954a;     // Catch: Throwable -> L16
        r4 = "bind PacificVibrateFeedback failed";
        goto L9
    }

    private VibrateFeedback() {
    }

    private static final Object _init_$lambda$0() {
        return new PacificVibrateFeedback();
    }

    private static final Object _init_$lambda$1() {
        return new CommonVibrateFeedback();
    }

    public static /* synthetic */ Object lambda$_0GDTAL9ODdt9wweCpMmvF5fJIg() {
        return _init_$lambda$0();
    }

    public static /* synthetic */ Object lambda$xW0kwk1IGDr3iVWoa76uHsAVL6c() {
        return _init_$lambda$1();
    }

    @Override // com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback
    public void performVibratorSmtFeedback(FeedbackType r1) {
        Intrinsics.checkNotNullParameter(r1, "feedbackType");
        IVibrateFeedback r0 = instance;
        if (r0 == null) goto L6;
        r0.performVibratorSmtFeedback(r1);
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback
    public void performVibratorSmtFeedback(String r1) {
        IVibrateFeedback.DefaultImpls.performVibratorSmtFeedback(this, r1);
    }
}
