package com.ss.android.lark.flow.threadwindow;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class FlowThreadWindowMediaRootStateHandler$createUploadPushHandler$1 extends FunctionReferenceImpl implements Function3<String, Integer, Long, Unit> {
    public FlowThreadWindowMediaRootStateHandler$createUploadPushHandler$1(Object r8) {
        super(3, r8, FlowThreadWindowMediaRootStateHandler.class, "onPushMediaUploadProgress", "onPushMediaUploadProgress(Ljava/lang/String;IJ)V", 0);
    }

    public final void invoke(final String r9, final int r10, final long r11) {
        Intrinsics.checkNotNullParameter(r9, "p0");
        final FlowThreadWindowMediaRootStateHandler r2 = (FlowThreadWindowMediaRootStateHandler) ((CallableReference) this).receiver;
        if (((Boolean) r2.f.invoke()).booleanValue() == true) goto L7;
        CoreThreadPool.getDefault().getUIExecutor().execute(new FlowThreadWindowMediaRootStateHandler$onPushMediaUploadProgress$1(r2, r9, r10, r11));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
        invoke((String) r3, ((Number) r4).intValue(), ((Number) r5).longValue());
        return Unit.INSTANCE;
    }
}
