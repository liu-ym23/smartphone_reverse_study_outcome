package com.obric.feature.miniapp.widget.jsb;

import android.util.Log;
import android.view.View;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import com.obric.feature.miniapp.widget.MiniAppHostView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/WidgetUpdateMethod;", "Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetUpdateMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetUpdateMethodIDL$WidgetUpdateParamsModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetUpdateMethodIDL$WidgetUpdateResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetUpdateMethodIDL$WidgetUpdateParamsModel;Lo1/f;)V", "Companion", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetUpdateMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetUpdateMethod.kt\ncom/obric/feature/miniapp/widget/jsb/WidgetUpdateMethod\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,69:1\n1#2:70\n*E\n"})
public final class WidgetUpdateMethod extends AbsWidgetUpdateMethodIDL {
    public static final Companion Companion = null;
    private static final String TAG = "OMiniApp-WidgetUpdate";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/WidgetUpdateMethod$Companion;", "", "<init>", "()V", "TAG", "", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public WidgetUpdateMethod() {
    }

    public static /* synthetic */ Unit b(f r5, String r10) {
        return handle$lambda$3(r5, r10);
    }

    public static /* synthetic */ Unit c(f r5, String r10) {
        return handle$lambda$2(r5, r10);
    }

    private static final Unit handle$lambda$2(f r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "$callback");
        if (r10 == null) goto L5;
        int r11 = r10.length();
    L6:
        Log.d(TAG, "updateWidget success dataLength=" + r11);
        Intrinsics.checkNotNullParameter(AbsWidgetUpdateMethodIDL.WidgetUpdateResultModel.class, "<this>");
        BaseModel r12 = e.c(AbsWidgetUpdateMethodIDL.WidgetUpdateResultModel.class);
        ((AbsWidgetUpdateMethodIDL.WidgetUpdateResultModel) r12).setWidgetData(r10);
        r5.b((ResultModel) r12, "");
        return Unit.INSTANCE;
    L5:
        r11 = 0;
        goto L6
    }

    private static final Unit handle$lambda$3(f r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "$callback");
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        Log.w(TAG, "updateWidget failure " + r10);
        r5.a(r10);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsWidgetUpdateMethodIDL.WidgetUpdateParamsModel) r10, r11);
    }

    public void handle(c r5, AbsWidgetUpdateMethodIDL.WidgetUpdateParamsModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        Log.d(TAG, "handle obric.widget.update");
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
        ((MiniAppHostView) r13).updateWidget(new a(r11, 3), new a(r11, 4));
    }
}
