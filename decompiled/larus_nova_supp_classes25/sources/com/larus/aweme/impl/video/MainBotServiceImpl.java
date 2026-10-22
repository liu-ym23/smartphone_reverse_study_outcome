package com.larus.aweme.impl.video;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.aweme.api.video.service.AwemeVideoFeedDelegate;
import com.larus.aweme.impl.main_bot.e;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.require.IMainBotService;
import com.larus.minor.api.IMinorService;
import ic8.l0;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/aweme/impl/video/MainBotServiceImpl;", "Lcom/larus/bmhome/chat/require/IMainBotService;", "<init>", "()V", "openMainBot", "", "context", "Landroid/content/Context;", "param", "Lcom/larus/bmhome/chat/require/IMainBotService$MainBotParam;", "isEnableDouYinSdk", "", "getSearchSceneId", "", "isEnableDouyinFeedCocoEntrance", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MainBotServiceImpl implements IMainBotService {
    public MainBotServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.require.IMainBotService
    public final String a() {
        return AwemeVideoFeedDelegate.b.a();
    }

    @Override // com.larus.bmhome.chat.require.IMainBotService
    public final boolean b() {
        return AwemeVideoFeedDelegate.b.b();
    }

    @Override // com.larus.bmhome.chat.require.IMainBotService
    public final void c(Context r5, IMainBotService.a r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "param");
        int r1 = e.a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "param");
        if (IMinorService.a.a() == false) goto L11;
        i r0 = SmartRouter.buildRoute(r5, "//flow/chat_page");
        Bundle r3 = r6.a;
        r3.putInt("argBotConversationType", 1);
        r0.c.putExtras(r3);
        int r2 = r6.e;
        int r7 = r6.f;
        r0.d = r2;
        r0.e = r7;
        r0.c.addFlags(268468224);
        r0.d();
        if ((r5 instanceof Activity) == false) goto L7;
        Activity r8 = (Activity) r5;
    L8:
        if (r8 == null) goto L20;
        r8.finish();
        return;
    L20:
        return;
    L7:
        r8 = null;
        goto L8
    L11:
        if (l0.a(r6.c) == false) goto L13;
        i r9 = SmartRouter.buildRoute(r5, "//flow/chat_multi_tab");
        Bundle r4 = r6.a;
        ArrayList<Integer> r10 = new ArrayList();
        r10.addAll(r6.c);
        Unit r11 = Unit.INSTANCE;
        r4.putIntegerArrayList("argument_multi_tab_list", r10);
        r4.putInt("argument_multi_tab_default_tab", r6.b);
        r4.putInt("argument_multi_tab_title_style", r6.d);
        r9.c.putExtras(r4);
        int r12 = r6.e;
        int r13 = r6.f;
        r9.d = r12;
        r9.e = r13;
        r9.d();
        return;
    L13:
        i r14 = SmartRouter.buildRoute(r5, "//flow/chat_page");
        Bundle r15 = r6.a;
        r15.putInt("argBotConversationType", 1);
        r14.c.putExtras(r15);
        int r16 = r6.e;
        int r17 = r6.f;
        r14.d = r16;
        r14.e = r17;
        if (Intrinsics.areEqual(r6.a.getString("is_side_bar"), "1") == false) goto L18;
        Integer r18 = r6.g;
        if (r18 == null) goto L18;
        r14.a(r18.intValue());
    L18:
        r14.d();
    }
}
