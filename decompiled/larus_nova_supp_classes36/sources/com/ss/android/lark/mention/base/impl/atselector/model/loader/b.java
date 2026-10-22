package com.ss.android.lark.mention.base.impl.atselector.model.loader;

import ccb.d;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.MentionUtils;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ IGetDataCallback a;
    public final /* synthetic */ RecommendDataLoader b;

    public final void a() {
        RecommendDataLoader r1 = this.b;
        IGetDataCallback r2 = this.a;
        String r3 = com.ss.android.lark.mention.base.impl.statistics.a.a;
        AppreciableKit.Companion r4 = AppreciableKit.Companion;
        r4.getInstance().spanStart(com.ss.android.lark.mention.base.impl.statistics.a.a, "sdk_cost");
        String r5 = this.b.a;
        Log.i("RecommendDataLoader", "LocalLoader load start, chatId: " + r5);
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        Chat r6 = ImSdkService.b().getLocalChat(r5);
        boolean r14 = false;
        if (r6 != null) goto L8;
        Log.e("RecommendDataLoader", "cannot get chat when at someone. chatid: ".concat(r5));
        r4.getInstance().error(new ErrorParams(Biz.Messenger, Scene.Chat, Event.at_user_list, ErrorType.SDK, ErrorLevel.Fatal, 1, null, "AtSelect", null, Boolean.FALSE, null, null, com.ss.android.lark.mention.base.impl.statistics.a.a(), 3392, null));
    L30:
        com.ss.android.lark.mention.base.impl.statistics.a.d = r14;
        if (r14 == false) goto L33;
        RecommendDataLoader r7 = this.b;
        new RecommendDataLoader.NetLoader(r7, this.a).a(r7.a);
        return;
    L33:
        r4.getInstance().spanEnd(com.ss.android.lark.mention.base.impl.statistics.a.a, "sdk_cost");
        RecommendDataLoader r8 = this.b;
        new RecommendDataLoader.NetLoader(r8, 0).a(r8.a);
        return;
    L8:
        d r9 = ChatService.c.a.o(r5, null, com.ss.android.lark.sdk.a.a(), false, r1.d);
        if (r9 != null) goto L12;
        Log.e("RecommendDataLoader", "syncSearchMentionChatChatters response is empty: ".concat(r5));
        goto L30
    L12:
        List r10 = r9.a;
        if (r10 != null) goto L15;
        r10 = new ArrayList();
    L15:
        List r11 = r9.b;
        if (r11 != null) goto L18;
        r11 = new ArrayList();
    L18:
        boolean r12 = true;
        if (r11.size() == 0) goto L26;
        if (r6.getMemberCount() <= r11.size()) goto L24;
        r14 = true;
    L24:
        r12 = r14;
    L26:
        if (com.ss.android.lark.mention.base.a.a() == false) goto L28;
        int r13 = MentionUtils.a;
        List r15 = MentionUtils.c(r10, com.ss.android.lark.mention.base.b.a().d());
        Log.i("RecommendDataLoader", "wantedMentionUsers after filter size = " + ((ArrayList) r15).size());
        List r16 = MentionUtils.c(r11, null);
        List r17 = r16;
        List r18 = r15;
        boolean r19 = CollectionUtils.isEmpty(r16);
    L29:
        List<BaseAtBean> r20 = new a(r6, r18, r17, r9.d, r9.g, r9.e, r1.b, r1.c, r1.d).a();
        Log.i("RecommendDataLoader", "LocalLoader load success, composedData size: " + ((ArrayList) r20).size());
        r2.onSuccess(r20);
        r14 = r19;
        goto L30
    L28:
        r18 = r10;
        r19 = r12;
        r17 = r11;
        goto L29
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(RecommendDataLoader r1, IGetDataCallback r2) {
        this.b = r1;
        this.a = r2;
    }
}
