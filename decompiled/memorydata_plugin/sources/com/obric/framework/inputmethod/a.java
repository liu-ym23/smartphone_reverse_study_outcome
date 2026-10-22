package com.obric.framework.inputmethod;

import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.impl.inputmethod.AssistantInputmethodManagerImpl;
import com.obric.aiagent.product.platform.impl.inputmethod.CommonObricInputmethodManager;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.ss.android.ugc.aweme.framework.services.f;
import com.ss.android.ugc.aweme.framework.services.g;
import com.ss.android.ugc.aweme.framework.services.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/framework/inputmethod/ObricInputmethodManager;", "", "<init>", "()V", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0394a f8041a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.obric.framework.inputmethod.api.a f8042b;

    /* JADX INFO: renamed from: com.obric.framework.inputmethod.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0017J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0017J\b\u0010\u0017\u001a\u00020\bH\u0017J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001dH\u0017J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001dH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/framework/inputmethod/ObricInputmethodManager$Companion;", "Lcom/obric/framework/inputmethod/api/IObricInputmethodManager;", "<init>", "()V", "TAG", "", "instance", "updateSelection", "", "imm", "Landroid/view/inputmethod/InputMethodManager;", "view", "Landroid/view/View;", "selStart", "", "selEnd", "candidatesStart", "candidatesEnd", "injectText", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "replace", "clearInputMethodState", "registerObricInjectEventCallback", "listener", "Lcom/obric/framework/inputmethod/api/ObricInjectEventCallback;", "unregisterObricInjectEventCallback", "registerInjectTextResponseCallback", "Lcom/obric/framework/inputmethod/api/ObricInjectTextResponseCallback;", "unregisterInjectTextResponseCallback", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0394a implements com.obric.framework.inputmethod.api.a {
        private C0394a() {
        }

        public /* synthetic */ C0394a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8041a = new C0394a(null);
    L10:
        th = move-exception;
        d.f5954a.b("ObricInputmethodManager", "bind ObricInputmethodManager failed", th);
    L12:
        f8042b = (com.obric.framework.inputmethod.api.a) ZeusTransformUtils.preCheckCast(f.a().a(com.obric.framework.inputmethod.api.a.class, false), com.obric.framework.inputmethod.api.a.class, "com.obric.memorydata.plugin");
        d.f5954a.b("ObricInputmethodManager", "ObricInputmethodManager instance: " + f8042b);
        return;
    L4:
        if (com.obric.aiagent.product.a.a.f5964a.a() == false) goto L7;
        f r2 = f.a();     // Catch: Throwable -> L10
        Class<com.obric.framework.inputmethod.api.a> r3 = com.obric.framework.inputmethod.api.a.class;
        g r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$a$9_grWZVr8IFe16zvpDTZepcf4uw.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L6:
        r2.a(r3, r4);     // Catch: Throwable -> L10
        d.f5954a.b("ObricInputmethodManager", "bind InputmethodManager assistantApi=" + com.obric.aiagent.product.a.a.f5964a.a());     // Catch: Throwable -> L10
        goto L12
    L7:
        r2 = f.a();     // Catch: Throwable -> L10
        r3 = com.obric.framework.inputmethod.api.a.class;
        r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$a$81JzTwvWaUwoeLvhufcADzl56io.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        goto L6
    }

    private static final Object a() {
        return new AssistantInputmethodManagerImpl();
    }

    private static final Object b() {
        return new CommonObricInputmethodManager();
    }

    public static /* synthetic */ Object lambda$81JzTwvWaUwoeLvhufcADzl56io() {
        return b();
    }

    public static /* synthetic */ Object lambda$9_grWZVr8IFe16zvpDTZepcf4uw() {
        return a();
    }
}
