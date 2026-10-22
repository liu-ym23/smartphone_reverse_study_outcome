package com.larus.bot.impl.service;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bot.api.IBotMakerService;
import com.larus.bot.impl.feature.botmaker.f;
import com.larus.bot.impl.feature.botmaker.k;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.bot.BotMakerDataModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nq9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/larus/bot/impl/service/BotMakerServiceImpl;", "Lcom/larus/bot/api/IBotMakerService;", "<init>", "()V", "parseBotMakerDataFromMsgContent", "Lcom/larus/platform/model/bot/BotMakerDataModel;", "msgContent", "", "fillBotMakerData", "", "msg", "Lcom/larus/im/bean/message/Message;", "botMakerEventListener", "Lcom/larus/platform/model/bot/IBotMakerEventListener;", "fragment", "Landroidx/fragment/app/Fragment;", "curArgument", "Landroid/os/Bundle;", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotMakerServiceImpl implements IBotMakerService {
    public BotMakerServiceImpl() {
    }

    @Override // com.larus.bot.api.IBotMakerService
    public final BotMakerDataModel g(String r2) {
        k r0 = k.a;
        return k.d(r2);
    }

    @Override // com.larus.bot.api.IBotMakerService
    public final void n(Message r4) {
        k r0 = k.a;
        String r1 = null;
        if (r4 == null) goto L5;
        String r2 = r4.getContent();
    L6:
        BotMakerDataModel r3 = k.d(r2);
        if (r3 == null) goto L9;
        String r5 = r3.getIcon_url();
    L10:
        if (r5 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == false) goto L19;
        if (r4 == null) goto L19;
        k.b(r4);
    L19:
        if (r4 == null) goto L21;
        String r7 = r4.getMessageId();
    L22:
        if (r3 == null) goto L24;
        r1 = r3.getNick_name();
    L24:
        k.c(r7, r1);
        return;
    L21:
        r7 = null;
        goto L22
    L12:
        if (r5.length() == 0) goto L15;
        r6 = false;
        goto L16
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.bot.api.IBotMakerService
    public final e f(Fragment r2, Bundle r3, by7.e r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "trackNode");
        return new f(r2, r3, r4);
    }
}
