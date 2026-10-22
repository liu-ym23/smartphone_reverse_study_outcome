package com.obric.feature.miniapp.widget.jsb;

import android.util.Log;
import android.view.View;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.widgets.l;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import com.obric.feature.miniapp.widget.MiniAppHostView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/WidgetRefreshAffectedMethod;", "Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetRefreshAffectedMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetRefreshAffectedMethodIDL$WidgetRefreshAffectedParamsModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetRefreshAffectedMethodIDL$WidgetRefreshAffectedResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetRefreshAffectedMethodIDL$WidgetRefreshAffectedParamsModel;Lo1/f;)V", "Companion", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetRefreshAffectedMethod extends AbsWidgetRefreshAffectedMethodIDL {
    public static final Companion Companion = null;
    private static final String TAG = "OMiniApp-RefreshAffected";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/WidgetRefreshAffectedMethod$Companion;", "", "<init>", "()V", "TAG", "", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WidgetRefreshAffectedMethod() {
    }

    public static /* synthetic */ Unit b(f r5, int r10, List r11) {
        return handle$lambda$2(r5, r10, r11);
    }

    public static /* synthetic */ Unit c(f r5, String r10) {
        return handle$lambda$3(r5, r10);
    }

    private static final Unit handle$lambda$2(f r5, int r10, List r11) {
        Intrinsics.checkNotNullParameter(r5, "$callback");
        Intrinsics.checkNotNullParameter(r11, "updatedWidgetIds");
        Log.d(TAG, "refreshAffected success acceptedCount=" + r10 + " updatedWidgetIds=" + r11);
        Intrinsics.checkNotNullParameter(AbsWidgetRefreshAffectedMethodIDL.WidgetRefreshAffectedResultModel.class, "<this>");
        BaseModel r12 = e.c(AbsWidgetRefreshAffectedMethodIDL.WidgetRefreshAffectedResultModel.class);
        AbsWidgetRefreshAffectedMethodIDL.WidgetRefreshAffectedResultModel r13 = (AbsWidgetRefreshAffectedMethodIDL.WidgetRefreshAffectedResultModel) r12;
        r13.setAcceptedCount(r10);
        r13.setUpdatedWidgetIds(r11);
        r5.b((ResultModel) r12, "");
        return Unit.INSTANCE;
    }

    private static final Unit handle$lambda$3(f r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "$callback");
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        Log.w(TAG, "refreshAffected failure " + r10);
        r5.a(r10);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsWidgetRefreshAffectedMethodIDL.WidgetRefreshAffectedParamsModel) r10, r11);
    }

    public void handle(c r5, AbsWidgetRefreshAffectedMethodIDL.WidgetRefreshAffectedParamsModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        Log.d(TAG, "handle obric.widget.refreshAffected changedDomains=" + r10.getChangedDomains());
        View r12 = ((n1.a) r5).a();
        Object r13 = null;
        if (r12 == null) goto L12;
    L4:
        if (r12 == null) goto L12;
        if ((r12 instanceof MiniAppHostView) == true) goto L7;
        Object r14 = r12.getParent();
        if ((r14 instanceof View) == true) goto L10;
        r12 = null;
        goto L4
    L10:
        r12 = (View) r14;
        goto L4
    L7:
        r13 = r12;
    L12:
        if (r13 != null) goto L15;
        Log.w(TAG, "hostView not found");
        r11.a("hostView not found");
        return;
    L15:
        ((MiniAppHostView) r13).refreshAffected(r10.getChangedDomains(), r10.getReason(), new l(r11, 1), new a(r11, 0));
    }
}
