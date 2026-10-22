package com.obric.aiagent.product.platform.impl.inputmethod;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.ObricInputMethodManager;
import com.obric.aiagent.platform.a.d;
import com.obric.framework.inputmethod.api.a;
import com.obric.framework.inputmethod.api.b;
import com.obric.framework.inputmethod.api.c;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u001aH\u0016¨\u0006\u001d"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/inputmethod/CommonObricInputmethodManager;", "Lcom/obric/framework/inputmethod/api/IObricInputmethodManager;", "<init>", "()V", "updateSelection", "", "imm", "Landroid/view/inputmethod/InputMethodManager;", "view", "Landroid/view/View;", "selStart", "", "selEnd", "candidatesStart", "candidatesEnd", "injectText", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "replace", "clearInputMethodState", "registerObricInjectEventCallback", "listener", "Lcom/obric/framework/inputmethod/api/ObricInjectEventCallback;", "unregisterObricInjectEventCallback", "registerInjectTextResponseCallback", "Lcom/obric/framework/inputmethod/api/ObricInjectTextResponseCallback;", "unregisterInjectTextResponseCallback", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonObricInputmethodManager implements a {
    public static final Companion Companion = null;
    public static final String TAG = "CommonObricInputmethodManager";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/inputmethod/CommonObricInputmethodManager$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CommonObricInputmethodManager() {
    }

    public void clearInputMethodState() {
        ObricInputMethodManager.clearInputMethodState();
    }

    public boolean injectText(CharSequence r2, boolean r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return ObricInputMethodManager.injectText(r1, r3);
    }

    public boolean registerInjectTextResponseCallback(c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        return InjectTextResponseBridge.INSTANCE.register(r3);
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "registerInjectTextResponseCallback failed", th);
        return false;
    }

    public boolean registerObricInjectEventCallback(b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        return InjectEventResponseBridge.INSTANCE.registerObric(r3);
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "registerObricInjectEventCallback failed", th);
        return false;
    }

    public boolean unregisterInjectTextResponseCallback(c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        return InjectTextResponseBridge.INSTANCE.unregister(r3);
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "unregisterInjectTextResponseCallback failed", th);
        return false;
    }

    public boolean unregisterObricInjectEventCallback(b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        return InjectEventResponseBridge.INSTANCE.unregisterObric(r3);
    L5:
        th = move-exception;
        d.f5954a.b(TAG, "unregisterObricInjectEventCallback failed", th);
        return false;
    }

    public void updateSelection(InputMethodManager r1, View r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "imm");
        Intrinsics.checkNotNullParameter(r2, "view");
        ObricInputMethodManager.updateSelection(r1, r2, r3, r4, r5, r6);
    }
}
