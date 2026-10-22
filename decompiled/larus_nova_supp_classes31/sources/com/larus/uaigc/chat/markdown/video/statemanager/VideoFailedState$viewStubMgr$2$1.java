package com.larus.uaigc.chat.markdown.video.statemanager;

import android.view.View;
import android.widget.FrameLayout;
import com.larus.uaigc.impl.databinding.LarusLayoutVideoGenerateFailedBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class VideoFailedState$viewStubMgr$2$1 extends FunctionReferenceImpl implements Function1<View, LarusLayoutVideoGenerateFailedBinding> {
    public static final VideoFailedState$viewStubMgr$2$1 INSTANCE = null;

    static {
        INSTANCE = new VideoFailedState$viewStubMgr$2$1();
    }

    public VideoFailedState$viewStubMgr$2$1() {
        super(1, LarusLayoutVideoGenerateFailedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/uaigc/impl/databinding/LarusLayoutVideoGenerateFailedBinding;", 0);
    }

    public final LarusLayoutVideoGenerateFailedBinding invoke(View r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        if (r2 == null) goto L7;
        return new LarusLayoutVideoGenerateFailedBinding((FrameLayout) r2);
    L7:
        throw new NullPointerException("rootView");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }
}
