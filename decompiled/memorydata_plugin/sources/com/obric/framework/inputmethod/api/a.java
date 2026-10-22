package com.obric.framework.inputmethod.api;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH&J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0018H&¨\u0006\u001b"}, d2 = {"Lcom/obric/framework/inputmethod/api/IObricInputmethodManager;", "", "updateSelection", "", "imm", "Landroid/view/inputmethod/InputMethodManager;", "view", "Landroid/view/View;", "selStart", "", "selEnd", "candidatesStart", "candidatesEnd", "injectText", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "replace", "clearInputMethodState", "registerObricInjectEventCallback", "listener", "Lcom/obric/framework/inputmethod/api/ObricInjectEventCallback;", "unregisterObricInjectEventCallback", "registerInjectTextResponseCallback", "Lcom/obric/framework/inputmethod/api/ObricInjectTextResponseCallback;", "unregisterInjectTextResponseCallback", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0395a f8043a = null;

    /* JADX INFO: renamed from: com.obric.framework.inputmethod.api.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/framework/inputmethod/api/IObricInputmethodManager$Companion;", "", "<init>", "()V", "AUTO_IME_TAG", "", "getAUTO_IME_TAG", "()Ljava/lang/String;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0395a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0395a f8044a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f8045b = null;

        static {
            f8044a = new C0395a();
            com.obric.aiagent.product.a.a.f5964a.a();
            f8045b = "AUTO_IME_TAG";
        }

        private C0395a() {
        }
    }

    static {
        f8043a = C0395a.f8044a;
    }
}
