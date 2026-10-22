package com.obric.aiagent.product.platform.api.notification;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/obric/aiagent/product/platform/api/notification/ObricToastShowListener;", "", "<init>", "()V", "obricStub", "getObricStub", "()Ljava/lang/Object;", "obricStub$delegate", "Lkotlin/Lazy;", "assistantStub", "getAssistantStub", "assistantStub$delegate", "onToastShown", "", "info", "Lcom/obric/aiagent/product/platform/api/notification/ToastShowInfo;", "newFrameworkToastShowListenerProxy", "listenerClassName", "", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObricToastShowListener {
    private static final String ASSISTANT_TOAST_LISTENER_CLASS = "android.app.AssistantNotificationManager$OnToastShowListener";
    private static final Companion Companion = null;
    private static final String OBRIC_TOAST_LISTENER_CLASS = "android.app.ObricNotificationManager$OnToastShowListener";
    private final Lazy assistantStub$delegate;
    private final Lazy obricStub$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/product/platform/api/notification/ObricToastShowListener$Companion;", "", "<init>", "()V", "OBRIC_TOAST_LISTENER_CLASS", "", "ASSISTANT_TOAST_LISTENER_CLASS", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ObricToastShowListener() {
        this.obricStub$delegate = LazyKt.lazy(new $$Lambda$ObricToastShowListener$LyumCMb_y0WKTJrKzS8GrsO_nk(this));
        this.assistantStub$delegate = LazyKt.lazy(new $$Lambda$ObricToastShowListener$XzON_ow1vWlVpPyiY5AjlnAvS4(this));
    }

    private static final Object assistantStub_delegate$lambda$1(ObricToastShowListener r1) {
        return r1.newFrameworkToastShowListenerProxy(ASSISTANT_TOAST_LISTENER_CLASS);
    }

    /* JADX INFO: renamed from: lambda$LyumCMb_y-0WKTJrKzS8GrsO_nk, reason: not valid java name */
    public static /* synthetic */ Object m165lambda$LyumCMb_y0WKTJrKzS8GrsO_nk(ObricToastShowListener r0) {
        return obricStub_delegate$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$W9ioXGQQ-enLzJHXlYmqk_xb_kk, reason: not valid java name */
    public static /* synthetic */ Unit m166lambda$W9ioXGQQenLzJHXlYmqk_xb_kk(ObricToastShowListener r0, ToastShowInfo r1) {
        return newFrameworkToastShowListenerProxy$lambda$3$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$XzON_ow1vW-lVpPyiY5AjlnAvS4, reason: not valid java name */
    public static /* synthetic */ Object m167lambda$XzON_ow1vWlVpPyiY5AjlnAvS4(ObricToastShowListener r0) {
        return assistantStub_delegate$lambda$1(r0);
    }

    private final Object newFrameworkToastShowListenerProxy(String r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        final ObricToastShowListener r2 = (ObricToastShowListener) ZeusTransformUtils.preCheckCast(this, ObricToastShowListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Class r4 = ZeusTransformUtils.forName(r3, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L5
        Object r5 = Result.m1421constructorimpl(ObricToastShowListenerKt.newObricToastShowListenerProxy(r4, new $$Lambda$ObricToastShowListener$W9ioXGQQenLzJHXlYmqk_xb_kk(r2)));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r5) == false) goto L13;
        return null;
    L13:
        return r5;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final Unit newFrameworkToastShowListenerProxy$lambda$3$lambda$2(ObricToastShowListener r1, ToastShowInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        r1.onToastShown(r2);
        return Unit.INSTANCE;
    }

    private static final Object obricStub_delegate$lambda$0(ObricToastShowListener r1) {
        return r1.newFrameworkToastShowListenerProxy(OBRIC_TOAST_LISTENER_CLASS);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.getValue();
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.getValue();
    }

    public abstract void onToastShown(ToastShowInfo r1);
}
