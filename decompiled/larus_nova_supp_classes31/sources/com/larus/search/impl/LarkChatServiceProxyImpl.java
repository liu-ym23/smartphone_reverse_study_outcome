package com.larus.search.impl;

import android.app.Activity;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.search.api.LarkChatServiceProxy;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016JC\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/search/impl/LarkChatServiceProxyImpl;", "Lcom/larus/search/api/LarkChatServiceProxy;", "<init>", "()V", "handleLarkContactClick", "", "chatId", "", "chatterId", "handleLarkMessageClick", "localIndex", "", "openLarkChat", "showPosition", "", "source", "onSuccessLog", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Z", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LarkChatServiceProxyImpl implements LarkChatServiceProxy {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public LarkChatServiceProxyImpl() {
    }

    @Override // com.larus.search.api.LarkChatServiceProxy
    public final boolean a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "chatterId");
        if (StringsKt.isBlank(r3) == false) goto L9;
        if (StringsKt.isBlank(r4) == false) goto L9;
        FLogger.a.w("LarkChatServiceProxy", "handleLarkContactClick: chatId & chatterId are blank");
        return false;
    L9:
        return c(r3, r4, null, SlashMentionConfig.MENTION_CONTENT_CONTACT, null);
    }

    @Override // com.larus.search.api.LarkChatServiceProxy
    public final boolean b(final String r3, final long r4) {
        Intrinsics.checkNotNullParameter(r3, "chatId");
        if (StringsKt.isBlank(r3) == false) goto L7;
        FLogger.a.w("LarkChatServiceProxy", "handleLarkMessageClick: chatId is blank");
        return false;
    L7:
        return c(r3, "", Integer.valueOf((int) r4), "message", new x(r3, r4));
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.larus.search.impl.LarkChatServiceProxyImpl$openLarkChat$1] */
    public static boolean c(final String r5, final String r6, Integer r7, final String r8, final Function0 r9) {
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 != null) goto L5;
        return false;
    L5:
        Object r2 = xp9.o.a;
        dza.b r4 = null;
        if ((r2 instanceof OfficeSDKUserApi) == false) goto L8;
        OfficeSDKUserApi r3 = (OfficeSDKUserApi) r2;
    L9:
        if (r3 == null) goto L13;
        aza.d r10 = r3.getService(aza.d.class);
        if (r10 == null) goto L13;
        r4 = r10.P();
    L13:
        if (r4 != null) goto L16;
        FLogger.a.w("LarkChatServiceProxy", "openLarkChat: officeSdk chatService unavailable, source=".concat(r8));
        return false;
    L16:
        ChatBundle.a r1 = new ChatBundle.a();
        if (com.larus.utils.o0.d(r5) == false) goto L20;
        r1.a = r5;
    L22:
        if (r7 == null) goto L24;
        r1.c = r7.intValue();
    L24:
        r4.c(r0, new ChatBundle(r1), new LarkChatServiceProxyImpl$openLarkChat$1(r9, r5, r6, r8));
        return true;
    L20:
        if (com.larus.utils.o0.d(r6) == false) goto L22;
        r1.b = r6;
        goto L22
    L8:
        r3 = null;
        goto L9
    }
}
