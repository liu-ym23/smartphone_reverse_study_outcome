package com.obric.assistant.interaction.impl.toast;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.common.spi.toast.IToastHelper;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/ToastHelperImpl;", "Lcom/obric/assistant/common/spi/toast/IToastHelper;", "<init>", "()V", "resolveContext", "Landroid/content/Context;", "context", "createToastHolder", "Lcom/larus/common_ui/toast/abs/IToastHolder;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToastHelperImpl implements IToastHelper {
    public static final Companion Companion = null;
    private static WeakReference<Context> activeWindowContext;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/ToastHelperImpl$Companion;", "", "<init>", "()V", "activeWindowContext", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "registerWindowContext", "", "context", "unregisterWindowContext", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final void registerWindowContext(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            if (IWindowContextKt.isWindowContext(r2) == false) goto L6;
            ToastHelperImpl.access$setActiveWindowContext$cp(new WeakReference(r2));
            return;
        }

        public final void unregisterWindowContext(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            WeakReference r0 = ToastHelperImpl.access$getActiveWindowContext$cp();
            if (r0 == null) goto L5;
            Context r1 = (Context) r0.get();
        L6:
            if (r1 != r3) goto L9;
            ToastHelperImpl.access$setActiveWindowContext$cp(null);
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ToastHelperImpl() {
    }

    public static final /* synthetic */ WeakReference access$getActiveWindowContext$cp() {
        return activeWindowContext;
    }

    public static final /* synthetic */ void access$setActiveWindowContext$cp(WeakReference r0) {
        activeWindowContext = r0;
    }

    /* JADX INFO: renamed from: createToastHolder, reason: collision with other method in class */
    public f m2createToastHolder(Context r1) {
        if (IWindowContextKt.isWindowContext(r1) == true) goto L5;
        return null;
    L5:
        return new WindowToastHolder();
    }

    public Context resolveContext(Context r2) {
        if (r2 != null) goto L5;
        r2 = AppHost.a.getApplication();
    L5:
        if (IWindowContextKt.isWindowContext(r2) == false) goto L7;
        return r2;
    L7:
        WeakReference<Context> r0 = activeWindowContext;
        if (r0 == null) goto L14;
        Context r1 = r0.get();
        if (r1 != null) goto L13;
        return r2;
    L13:
        return r1;
    L14:
        return r2;
    }

    public /* bridge */ /* synthetic */ Object createToastHolder(Context r1) {
        return m2createToastHolder(r1);
    }
}
