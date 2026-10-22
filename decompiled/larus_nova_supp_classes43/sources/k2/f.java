package k2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.assem.arch.extensions.AssembleExtKt;
import com.google.gson.JsonObject;
import d3.b0;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements k {
    public final j a;
    public WeakReference<Fragment> b;
    public WeakReference<m> c;

    @Override // k2.o
    public final View engineView() {
        WeakReference<m> r0 = this.c;
        if (r0 == null) goto L9;
        m r1 = r0.get();
        if (r1 == null) goto L9;
        q r10 = r1.h();
        if (r10 == null) goto L9;
        return r10.engineView();
    L9:
        return null;
    }

    @Override // k2.h
    public final b0 getAIBridge() {
        WeakReference<m> r0 = this.c;
        if (r0 == null) goto L9;
        m r1 = r0.get();
        if (r1 == null) goto L9;
        q r10 = r1.h();
        if (r10 == null) goto L9;
        return r10.getAIBridge();
    L9:
        return null;
    }

    @Override // k2.k
    public final m getContainerViewService() {
        WeakReference<m> r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // k2.o
    public final View realView() {
        WeakReference<m> r0 = this.c;
        if (r0 == null) goto L9;
        m r1 = r0.get();
        if (r1 == null) goto L9;
        q r10 = r1.h();
        if (r10 == null) goto L9;
        return r10.realView();
    L9:
        return null;
    }

    public f(com.bytedance.ai.model.widgets.f r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        this.a = r10;
    }

    @Override // k2.r
    public final void onMessageToJS(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        String r1 = "ViewProvider-" + this.a.getPageInfo().getPageType();
        StringBuilder r11 = new StringBuilder("onMessageToJS service ");
        WeakReference<m> r12 = this.c;
        if (r12 == null) goto L5;
        m r13 = r12.get();
    L6:
        r11.append(r13);
        r11.append(" msg ");
        r11.append(r10);
        r0.d(r1, r11.toString());
        WeakReference<m> r14 = this.c;
        if (r14 == null) goto L14;
        m r15 = r14.get();
        if (r15 == null) goto L15;
        q r16 = r15.h();
        if (r16 == null) goto L16;
        r16.onMessageToJS(r10);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // u4.a
    public final a6.a getViewModel(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "groupId");
        WeakReference<m> r0 = this.c;
        if (r0 == null) goto L7;
        m r1 = r0.get();
        if (r1 == null) goto L7;
        return r1.getViewModel(r10, r11);
    L7:
        return null;
    }

    @Override // k2.o
    public final void handleWebViewDrawEnd(long r10, long r11) {
        WeakReference<m> r0 = this.c;
        if (r0 == null) goto L10;
        m r1 = r0.get();
        if (r1 == null) goto L11;
        q r12 = r1.h();
        if (r12 == null) goto L12;
        r12.handleWebViewDrawEnd(r10, r11);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // k2.r
    public final void onMessageToAIBridge(String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        WeakReference<m> r0 = this.c;
        if (r0 == null) goto L10;
        m r1 = r0.get();
        if (r1 == null) goto L11;
        q r12 = r1.h();
        if (r12 == null) goto L12;
        r12.onMessageToAIBridge(r10, r11);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // k2.k
    public final void createContainer(final ViewGroup r10, final b r11, Activity r12, final Fragment r13) {
        Intrinsics.checkNotNullParameter(r10, "root");
        Intrinsics.checkNotNullParameter(r11, "params");
        com.bytedance.ai.utils.g.a.d("ViewProvider-" + this.a.getPageInfo().getPageType(), "createContainer " + this.a.getAppletRuntime().h.o());
        j r14 = this.a;
        r11.n = r14;
        if (r14.getPageInfo().getPageType() != PageType.POPUP_PAGE) goto L5;
        boolean r15 = true;
    L6:
        r11.p = r15;
        r11.o = this.a.getRenderClass();
        if (r13 == null) goto L16;
        this.b = new WeakReference(r13);
        AssembleExtKt.a(r13, new c(r13, r11, r10));
        WeakReference<Fragment> r16 = this.b;
        if (r16 == null) goto L13;
        Fragment r17 = r16.get();
        if (r17 == null) goto L13;
        m r18 = (m) com.bytedance.assem.arch.service.e.a(r17, Reflection.getOrCreateKotlinClass(m.class));
    L14:
        this.c = new WeakReference(r18);
        return;
    L13:
        r18 = null;
        goto L14
    L16:
        return;
    L5:
        r15 = false;
        goto L6
    }
}
