package cn;

import android.content.Context;
import android.view.View;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.n0;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.u;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.l0;
import com.lynx.tasm.ui.image.v;
import com.lynx.tasm.utils.j;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends UIBody.UIBodyView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxTemplateRender f1220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference f1222c;

    public a(Context r5) {
        super(r5);
        this.f1222c = null;
        UIBody.UIBodyView r10 = ((LynxContext) r5).l();
        if (r10 == null) goto L15;
        l0 r11 = r10.getLynxViewBuilder();
        r11.f10912t.getClass();
        LynxUIRenderer r12 = new LynxUIRenderer();
        ThreadStrategyForRendering r13 = r11.f10910q;
        if (r13 == null) goto L7;
        r11.f10910q = r13;
    L7:
        this.mLynxUIRender = r12;
        this.f1220a = new LynxTemplateRender(r5, this, r11);
        if ((r10 instanceof LynxView) == false) goto L12;
        this.f1222c = new WeakReference((LynxView) r10);
        return;
    L12:
        if ((r10 instanceof a) == false) goto L16;
        this.f1222c = new WeakReference(((a) r10).getRootView());
        return;
    L16:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public l0 getLynxViewBuilder() {
        LynxTemplateRender r5 = this.f1220a;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.u0();
    }

    @Override // android.view.View
    public /* bridge */ /* synthetic */ View getRootView() {
        return getRootView();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        this.f1220a.x0();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        this.f1220a.g(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public final void runOnTasmThread(Runnable r5) {
        LynxEngineProxy r10 = this.f1220a.Z;
        if (r10 != null) goto L6;
        LynxLog.b(2, "LynxTemplateRender", "runOnTasmThread failed, engine proxy is null.");
        return;
    L6:
        j.f(new v(20, r10, r5));
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public void setAttachLynxPageUICallback(u r5) {
        LynxTemplateRender r10 = this.f1220a;
        if (r10 == null) goto L10;
        b0 r11 = r10.e;
        if (r11 != null) goto L7;
        return;
    L7:
        if (((n0) r11.f10147o.get()) == null) goto L12;
        ((n0) r10.e.f10147o.get()).s = r5;
        return;
    L12:
        return;
    }

    public void setUrl(String r5) {
        this.f1221b = r5;
    }

    @Override // android.view.View
    public LynxView getRootView() {
        WeakReference r5 = this.f1222c;
        if (r5 != null) goto L7;
        return null;
    L7:
        return (LynxView) r5.get();
    }
}
