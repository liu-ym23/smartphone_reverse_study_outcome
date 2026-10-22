package com.larus.bmhome.chat.api;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/api/RenderLiteDelegate;", "Lcom/larus/bmhome/chat/api/IRenderLiteService;", "<init>", "()V", "impl", "createLiteView", "Landroid/view/View;", "context", "Landroid/content/Context;", "templateUrl", "", "lifecycle", "Lcom/larus/bmhome/chat/bean/IRenderLiteLifeCycle;", "initData", "updateLiteViewData", "", "liteView", "renderData", "destroyLiteView", "openPage", "uri", "Landroid/net/Uri;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RenderLiteDelegate implements IRenderLiteService {
    public static final RenderLiteDelegate a = null;
    public static final IRenderLiteService b = null;

    private RenderLiteDelegate() {
    }

    static {
        a = new RenderLiteDelegate();
        b = (IRenderLiteService) ServiceManager.get().getService(IRenderLiteService.class);
    }

    @Override // com.larus.bmhome.chat.api.IRenderLiteService
    public final void d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "liteView");
        IRenderLiteService r0 = b;
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IRenderLiteService
    public final void a(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "liteView");
        Intrinsics.checkNotNullParameter(r3, "renderData");
        IRenderLiteService r0 = b;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IRenderLiteService
    public final void b(Context r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        IRenderLiteService r0 = b;
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IRenderLiteService
    public final View c(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "templateUrl");
        IRenderLiteService r0 = b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c(r2, r3, r4);
    }
}
