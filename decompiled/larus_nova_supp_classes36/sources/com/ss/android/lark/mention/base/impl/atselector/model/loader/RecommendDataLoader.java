package com.ss.android.lark.mention.base.impl.atselector.model.loader;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RecommendDataLoader {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    public class NetLoader {
        public final IGetDataCallback<List<BaseAtBean>> a;
        public final /* synthetic */ RecommendDataLoader b;

        public final void a(String r8) {
            Log.i("RecommendDataLoader", "NetLoader load start, chatId: " + r8);
            if (r8 != null) goto L5;
            r8 = "";
        L5:
            String r1 = r8;
            final Chat r9 = ImSdkService.b().we(r1);
            ChatService.c.a.m(r1, null, com.ss.android.lark.sdk.a.a(), true, this.b.d, new AnonymousClass1(this, r9));
        }

        public NetLoader(RecommendDataLoader r1, IGetDataCallback<List<BaseAtBean>> r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public RecommendDataLoader(String r1, boolean r2, boolean r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
