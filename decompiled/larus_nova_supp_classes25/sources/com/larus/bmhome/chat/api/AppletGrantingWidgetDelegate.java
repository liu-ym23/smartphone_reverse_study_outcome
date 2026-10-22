package com.larus.bmhome.chat.api;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J&\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/api/AppletGrantingWidgetDelegate;", "Lcom/larus/bmhome/chat/api/IAppletGrantingWidgetService;", "<init>", "()V", "impl", "bindData", "Lcom/larus/bmhome/chat/api/CardModel;", "permissionData", "", "msgData", "Lcom/larus/bmhome/chat/api/MsgData;", "delegate", "Ljava/lang/ref/WeakReference;", "Lcom/larus/bmhome/chat/api/Delegate;", "unbindData", "", "onExpose", "onUnexpose", "operateResult", "agree", "", "weakReference", "Landroid/content/Context;", "cardModel", "onNewMessageInput", "latestMsgID", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AppletGrantingWidgetDelegate implements IAppletGrantingWidgetService {
    public static final AppletGrantingWidgetDelegate a = null;
    public static final IAppletGrantingWidgetService b = null;

    private AppletGrantingWidgetDelegate() {
    }

    static {
        a = new AppletGrantingWidgetDelegate();
        b = (IAppletGrantingWidgetService) ServiceManager.get().getService(IAppletGrantingWidgetService.class);
    }

    @Override // com.larus.bmhome.chat.api.IAppletGrantingWidgetService
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "latestMsgID");
        IAppletGrantingWidgetService r0 = b;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IAppletGrantingWidgetService
    public final void d(r0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msgData");
        IAppletGrantingWidgetService r0 = b;
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IAppletGrantingWidgetService
    public final void e(r0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msgData");
        IAppletGrantingWidgetService r0 = b;
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IAppletGrantingWidgetService
    public final void b(boolean r2, WeakReference<Context> r3, f r4) {
        Intrinsics.checkNotNullParameter(r3, "weakReference");
        Intrinsics.checkNotNullParameter(r4, "cardModel");
        IAppletGrantingWidgetService r0 = b;
        if (r0 == null) goto L6;
        r0.b(r2, r3, r4);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IAppletGrantingWidgetService
    public final f c(String r2, r0 r3, WeakReference<k> r4) {
        Intrinsics.checkNotNullParameter(r2, "permissionData");
        Intrinsics.checkNotNullParameter(r3, "msgData");
        Intrinsics.checkNotNullParameter(r4, "delegate");
        IAppletGrantingWidgetService r0 = b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c(r2, r3, r4);
    }
}
