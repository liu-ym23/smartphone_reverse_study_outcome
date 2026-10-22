package com.larus.bmhome.chat.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0019\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001f\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001c\u0010 \u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J \u0010#\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0%H\u0016J\u0012\u0010&\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010'\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010(\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010)\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010,\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010\u0006H\u0016J\u0016\u0010-\u001a\u00020\u00142\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0016J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u000202H\u0016J\u0018\u00103\u001a\u00020\u00142\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050/H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/bmhome/chat/api/WidgetRenderDelegate;", "Lcom/larus/bmhome/chat/api/IWidgetRenderService;", "<init>", "()V", "impl", "getItemKey", "", "msgId", "renderData", "getBoxType", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "compareData", "", "oldRenderData", "newRenderData", "getSavedHeight", "defValue", "getArchiveText", "preloadWidgets", "", "context", "Landroid/content/Context;", "bindWidget", "Lcom/larus/bmhome/chat/api/IAppletWidgetContainer;", "host", "Landroidx/fragment/app/Fragment;", "widgetRenderData", "Lcom/larus/bmhome/chat/api/WidgetRenderData;", "(Landroidx/fragment/app/Fragment;Lcom/larus/bmhome/chat/api/WidgetRenderData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidget", "onWidgetRecycled", "onWidgetArchived", "view", "Landroid/view/View;", "onWidgetVisibleChanged", "visibleWidgets", "", "onHostShow", "onHostHide", "onHostDestroy", "onConversationChanged", "convId", "sectionId", "onChatHistoryClear", "onMessageRemoved", "msgIds", "", "setEventCommonParam", "param", "Lcom/larus/bmhome/chat/api/EventParam;", "onMessageRefresh", "messageList", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class WidgetRenderDelegate implements IWidgetRenderService {
    public static final WidgetRenderDelegate a = null;
    public static final IWidgetRenderService b = null;

    private WidgetRenderDelegate() {
    }

    static {
        a = new WidgetRenderDelegate();
        b = (IWidgetRenderService) ServiceManager.get().getService(IWidgetRenderService.class);
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void a(String r2) {
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void c(List<? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "messageList");
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void f(q r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void g(Fragment r2) {
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L6;
        r0.g(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void h(Fragment r2) {
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void j(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "msgIds");
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L6;
        r0.j(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void l(Fragment r2) {
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L6;
        r0.l(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void n(Context r2) {
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L6;
        r0.n(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final Integer o(String r2) {
        IWidgetRenderService r0 = b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.o(r2);
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final String b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L9;
        String r4 = r0.b(r2, r3);
        if (r4 != null) goto L8;
        return r2;
    L8:
        return r4;
    L9:
        return r2;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void d(Fragment r2, v0 r3) {
        Intrinsics.checkNotNullParameter(r3, "widgetRenderData");
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L6;
        r0.d(r2, r3);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void e(Fragment r2, v0 r3) {
        Intrinsics.checkNotNullParameter(r3, "widgetRenderData");
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final int i(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        IWidgetRenderService r0 = b;
        if (r0 != null) goto L5;
        return r3;
    L5:
        return r0.i(r2, r3);
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void k(Fragment r2, Iterable<? extends View> r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleWidgets");
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L6;
        r0.k(r2, r3);
        return;
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final Object m(Fragment r2, v0 r3, Continuation<? super r> r4) {
        IWidgetRenderService r0 = b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.m(r2, r3, r4);
    }

    @Override // com.larus.bmhome.chat.api.IWidgetRenderService
    public final void p(Fragment r2, String r3, String r4) {
        IWidgetRenderService r0 = b;
        if (r0 == null) goto L6;
        r0.p(r2, r3, r4);
        return;
    }
}
