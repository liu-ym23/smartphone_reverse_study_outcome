package com.larus.bot.api;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.bot.BotMakerDataModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nq9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0013"}, d2 = {"Lcom/larus/bot/api/IBotMakerService;", "", "parseBotMakerDataFromMsgContent", "Lcom/larus/platform/model/bot/BotMakerDataModel;", "msgContent", "", "fillBotMakerData", "", "msg", "Lcom/larus/im/bean/message/Message;", "botMakerEventListener", "Lcom/larus/platform/model/bot/IBotMakerEventListener;", "fragment", "Landroidx/fragment/app/Fragment;", "curArgument", "Landroid/os/Bundle;", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBotMakerService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001¨\u0006\u0014"}, d2 = {"Lcom/larus/bot/api/IBotMakerService$Companion;", "Lcom/larus/bot/api/IBotMakerService;", "<init>", "()V", "botMakerEventListener", "Lcom/larus/platform/model/bot/IBotMakerEventListener;", "fragment", "Landroidx/fragment/app/Fragment;", "curArgument", "Landroid/os/Bundle;", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "fillBotMakerData", "", "msg", "Lcom/larus/im/bean/message/Message;", "parseBotMakerDataFromMsgContent", "Lcom/larus/platform/model/bot/BotMakerDataModel;", "msgContent", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IBotMakerService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IBotMakerService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.bot.api.IBotMakerService
        public final e f(Fragment r2, Bundle r3, by7.e r4) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            Intrinsics.checkNotNullParameter(r4, "trackNode");
            return this.b.f(r2, r3, r4);
        }

        @Override // com.larus.bot.api.IBotMakerService
        public final BotMakerDataModel g(String r2) {
            return this.b.g(r2);
        }

        @Override // com.larus.bot.api.IBotMakerService
        public final void n(Message r2) {
            this.b.n(r2);
        }

        private Companion() {
            this.b = (IBotMakerService) ServiceManager.get().getService(IBotMakerService.class);
        }
    }

    static {
        a = Companion.c;
    }

    e f(Fragment r1, Bundle r2, by7.e r3);

    BotMakerDataModel g(String r1);

    void n(Message r1);
}
