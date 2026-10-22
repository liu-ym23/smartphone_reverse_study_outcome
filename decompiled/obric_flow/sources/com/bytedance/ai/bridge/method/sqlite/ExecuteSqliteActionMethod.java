package com.bytedance.ai.bridge.method.sqlite;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.s;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.ui.image.f0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/method/sqlite/ExecuteSqliteActionMethod;", "Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL;", "<init>", "()V", "", "appletId", "Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL$ExecuteSqliteActionParamsModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL$ExecuteSqliteActionResultModel;", "callback", "", "doActon", "(Ljava/lang/String;Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL$ExecuteSqliteActionParamsModel;Lo1/f;)V", "handleAppletIsNull", "(Lo1/f;)V", "Ln1/c;", "bridgeContext", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL$ExecuteSqliteActionParamsModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/sqlite/e", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExecuteSqliteActionMethod extends AbsExecuteSqliteActionMethodIDL {
    public static final e Companion = null;
    private static final String TAG = "ExecuteSqliteActionMethod";

    static {
        Companion = new e();
    }

    public ExecuteSqliteActionMethod() {
    }

    public static /* synthetic */ Unit b(ExecuteSqliteActionMethod r5, o1.f r10, AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionParamsModel r11, AppletRuntime r12) {
        return handle$lambda$0(r5, r10, r11, r12);
    }

    private final void doActon(String r5, AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionParamsModel r10, o1.f r11) {
        i.a(s0.c.a(), r5, r10, r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r12 = f0.d(e, new StringBuilder("Exception is ExecuteSqliteActionMethod: "), TAG);
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L8;
        r13.e(TAG, r12);
    L8:
        r11.a(r12);
    }

    private static final Unit handle$lambda$0(ExecuteSqliteActionMethod r5, o1.f r10, AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionParamsModel r11, AppletRuntime r12) {
        if (r12 == null) goto L6;
        Applet r13 = r12.f2197h;
        if (r13 == null) goto L6;
        String r14 = r13.F;
    L7:
        if (r14 != null) goto L9;
    L12:
        r5.handleAppletIsNull(r10);
    L14:
        return Unit.INSTANCE;
    L9:
        if (r14.length() == 0) goto L12;
        r5.doActon(r14, r11, r10);
    L6:
        r14 = null;
        goto L7
    }

    private final void handleAppletIsNull(o1.f r5) {
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L5;
        r10.e(TAG, "This method is only allowed to be called by applet");
    L5:
        r5.a("This method is only allowed to be called by applet");
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionParamsModel) r10, r11);
    }

    public void handle(n1.c r5, AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionParamsModel r10, o1.f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        n1.a r12 = (n1.a) r5;
        AppletRuntime r13 = (AppletRuntime) r12.b(AppletRuntime.class);
        if (r13 == null) goto L7;
        Applet r14 = r13.f2197h;
        if (r14 == null) goto L7;
        String r15 = r14.F;
    L8:
        if (r15 != null) goto L10;
    L14:
        s r16 = (s) r12.b(s.class);
        if (r16 == null) goto L18;
        r16.a(new b(this, 1, r11, r10));
        return;
    L18:
        handleAppletIsNull(r11);
        return;
    L10:
        if (r15.length() == 0) goto L14;
        doActon(r15, r10, r11);
        return;
    L7:
        r15 = null;
        goto L8
    }
}
