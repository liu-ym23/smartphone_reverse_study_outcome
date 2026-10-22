package oca;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.assistant.IObricAvailableManager;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class b extends xc8.h implements z19.j, pca.a {
    public boolean p;
    public boolean q;
    public String r;
    public final Keva s;
    public final z19.r t;
    public Bundle u;
    public View.OnLongClickListener v;
    public AttachReceiver w;

    public static final class a {
    }

    static {
    }

    public abstract void o(AppIntentMessage r1, Message r2);

    public Float getLastMotionX() {
        return this.t.a;
    }

    public Float getLastMotionY() {
        return this.t.b;
    }

    @Override // pca.a
    public AttachReceiver getAttachReceiver() {
        return this.w;
    }

    public final View.OnLongClickListener getMOnLongClickListener() {
        return this.v;
    }

    public final String getMessageId() {
        return this.r;
    }

    public final Bundle getTraceInfo() {
        return this.u;
    }

    public b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        boolean r6 = true;
        this.p = true;
        this.s = xg9.b.a();
        this.t = new z19.r();
        this.u = new Bundle();
        setBoxType(0);
        IObricAvailableManager r1 = (IObricAvailableManager) ServiceManager.get().getService(IObricAvailableManager.class);
        if (r1 != null) goto L5;
    L7:
        r6 = false;
    L8:
        FLogger.a.d("AppEntityBox", "checkIsDefaultAssistant isDefaultAssistant=" + r6);
        if (r6 == true) goto L12;
        setEnable(false);
        return;
    L12:
        return;
    L5:
        if (r1.a() != true) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        this.t.a(r2);
        if (this.p == true) goto L6;
        return true;
    L6:
        return super/*android.widget.LinearLayout*/.onInterceptTouchEvent(r2);
    }

    public Map<String, String> q(AppIntentMessage r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return MapsKt.emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setEnable(boolean r4) {
        IObricAvailableManager r0 = (IObricAvailableManager) ServiceManager.get().getService(IObricAvailableManager.class);
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        if (r4 == false) goto L11;
    L12:
        this.p = r1;
        if (r1 == false) goto L15;
        float r5 = 1.0f;
    L16:
        setAlpha(r5);
        return;
    L15:
        r5 = 0.3f;
    L11:
        r1 = false;
        goto L12
    L5:
        if (r0.a() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void setMOnLongClickListener(View.OnLongClickListener r1) {
        this.v = r1;
    }

    public final void setTraceInfo(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.u = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(View r3, int r4) {
        if (IWindowContextKt.isWindowContext(getContext()) == false) goto L6;
        r4 = 0;
    L6:
        if ((r3 instanceof RoundRelativeLayout) == false) goto L9;
        ((RoundRelativeLayout) r3).getDelegate().a(r4);
        return;
    L9:
        if ((r3 instanceof RoundLinearLayout) == false) goto L11;
        ((RoundLinearLayout) r3).getDelegate().a(r4);
        return;
    L11:
        FLogger.a.w("AppEntityBox", "applyWindowAwareCardBackground: unsupported root=" + r3);
    }

    public final void r(Message r18, AppIntentMessage r19, String r20, String r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r19, "newData");
        Intrinsics.checkNotNullParameter(r20, "text");
        Intrinsics.checkNotNullParameter(r21, "tag");
        final String r1 = GsonProtectorUtils.toJson(EntityExtKt.a(), r19);
        xca.b.a r4 = xca.b.a;
        Intrinsics.checkNotNull(r1);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r1, "newContent");
        String r5 = r18.getLocalMessageId();
        if (r5 == null) goto L5;
        com.larus.im.d.e().x(r5, new xca.a(r1), null);
    L5:
        String r7 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r20, LynxAccessibilityModule.MSG_CONTENT);
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r7, "traceId");
        Intrinsics.checkNotNullParameter(r21, "funcChannel");
        String r3 = r18.getConversationId();
        if (r3 == null) goto L8;
        u1.a.f(RepoDispatcherDelegate.b.e().u1(), r20, r3, "card", null, null, null, r7, false, null, r21, null, null, null, false, 27512);
    L8:
        gda.a r0 = gda.a.a;
        Bundle r2 = this.u;
        if (r22 == false) goto L11;
        String r6 = "delete";
    L12:
        r2.putString("click_result", r6);
        gda.b.a(r2);
        return;
    L11:
        r6 = "cancel";
        goto L12
    }
}
