package com.ss.android.lark.flow.threadwindow;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class FlowThreadWindowMediaRootStateHandler$createUploadPushHandler$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public FlowThreadWindowMediaRootStateHandler$createUploadPushHandler$2(Object r8) {
        super(1, r8, FlowThreadWindowMediaRootStateHandler.class, "onPushMediaUploadFailed", "onPushMediaUploadFailed(Ljava/lang/String;)V", 0);
    }

    public final void invoke(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        final FlowThreadWindowMediaRootStateHandler r0 = (FlowThreadWindowMediaRootStateHandler) ((CallableReference) this).receiver;
        if (((Boolean) r0.f.invoke()).booleanValue() == true) goto L7;
        CoreThreadPool.getDefault().getUIExecutor().execute(new FlowThreadWindowMediaRootStateHandler$onPushMediaUploadFailed$1(r0, r4));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
