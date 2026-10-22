package com.obric.assistant.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jw\u0010\t\u001a\u00020\n2#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\f2#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\f2#\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0016Jw\u0010\u0017\u001a\u00020\n2#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\f2#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\f2#\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0016J+\u0010\u0018\u001a\u00020\n2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\n0\fH\u0016J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0016J\u001a\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\""}, d2 = {"Lcom/obric/assistant/agent/ObricAgentService;", "Lcom/obric/assistant/agent/IObricAgentApi;", "<init>", "()V", "imp", "getImp", "()Lcom/obric/assistant/agent/IObricAgentApi;", "imp$delegate", "Lkotlin/Lazy;", "screenShot", NameKeys.UnloadStrategy_No_Strategy, "bitmapCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "bitmap", "uriCallback", "Landroid/net/Uri;", LynxResourceModule.URI_KEY, "errorCallback", NameKeys.UnloadStrategy_No_Strategy, "error", "screenShotForScreenPerception", "webUrl", "callback", LynxEventReporter.PROP_NAME_URL, "supplyDebugItemGroup", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "messageId", "supplyDebugItemTitle", "Landroidx/appcompat/widget/AppCompatTextView;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAgentService implements IObricAgentApi {
    public static final ObricAgentService a = null;
    public static final Lazy b = null;

    private ObricAgentService() {
    }

    static {
        a = new ObricAgentService();
        b = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.agent.IObricAgentApi
    public final LinearLayout b(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        IObricAgentApi r0 = (IObricAgentApi) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b(r2, r3);
    }

    @Override // com.obric.assistant.agent.IObricAgentApi
    public final AppCompatTextView c(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        IObricAgentApi r0 = (IObricAgentApi) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c(r2, r3);
    }

    @Override // com.obric.assistant.agent.IObricAgentApi
    public final void a(Function1<? super Bitmap, Unit> r2, Function1<? super Uri, Unit> r3, Function1<? super String, Unit> r4) {
        IObricAgentApi r0 = (IObricAgentApi) b.getValue();
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4);
        return;
    }
}
