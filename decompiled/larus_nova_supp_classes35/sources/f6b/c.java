package f6b;

import android.os.SystemClock;
import com.ss.android.lark.biz.im.api.page.ChatDestination;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregating.interfaces.IFeatureGatingService;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import u3b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.chat.chatwindow.chat.perload.loader.c<b, e<ChatDestination>> {
    public final ImSdkChatService a;
    public final h b;
    public final IFeatureGatingService c;

    public static final class a {
    }

    static {
    }

    public c() {
        ImSdkChatService r0 = ImSdkService.b();
        h r1 = ImSdkService.d();
        IFeatureGatingService r2 = FeatureGatingModule.getFeatureGatingService();
        Intrinsics.checkNotNullParameter(r0, "chatService");
        Intrinsics.checkNotNullParameter(r1, "chatterService");
        Intrinsics.checkNotNullParameter(r2, "fgService");
        this.a = r0;
        this.b = r1;
        this.c = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.chat.chatwindow.chat.perload.loader.c
    public final e a(u3b.a r8) {
        b r9 = (b) r8;
        Intrinsics.checkNotNullParameter(r9, "task");
        e r0 = new e();
        long r1 = SystemClock.elapsedRealtime();
        String r3 = r9.a;
        if (this.c.isCurrentEnable("im.chat.secret_chat_isolate") == false) goto L14;
        d r4 = r9.b;
        if (r4 == null) goto L11;
        fxa.b r5 = r4.b;
        if (r5 == null) goto L11;
        boolean r6 = true;
        if (r5.isSecretChat() != true) goto L11;
    L12:
        if (r6 == false) goto L14;
        T r10 = ChatDestination.SECRET_CHAT;
    L44:
        r0.a = r10;
        Log.i("ChatDestinationPreLoader", "getChatDestination du:" + (SystemClock.elapsedRealtime() - r1));
        return r0;
    L11:
        r6 = false;
    L14:
        d r11 = r9.b;
        if (r11 == null) goto L18;
        Chat r12 = r11.a;
        if (r12 == null) goto L18;
    L22:
        if (this.c.isCurrentEnable("im.chat.secret_chat_isolate") == false) goto L27;
        if (r12.isSecret() == false) goto L27;
        r10 = ChatDestination.SECRET_CHAT;
    L27:
        if (r12.isP2PChat() == true) goto L30;
        r10 = ChatDestination.CHAT_WINDOW;
        goto L44
    L30:
        if (r12.isFake() == false) goto L36;
        if (this.c.isCurrentEnable("im.chat.fake_chat_isolate") == false) goto L34;
        r10 = ChatDestination.FAKE_CHAT;
        goto L44
    L34:
        r10 = ChatDestination.CHAT_WINDOW;
        goto L44
    L36:
        if (this.c.isCurrentEnable("messenger.im.bot_isolate") == false) goto L43;
        ChatChatter r13 = this.b.He(r3, r12.getP2pChatterId());
        Chatter.ChatterType r7 = Chatter.ChatterType.BOT;
        if (r13 == null) goto L40;
        Chatter.ChatterType r14 = r13.getType();
    L41:
        if (r7 != r14) goto L43;
        r10 = ChatDestination.BOT_CHAT;
        goto L44
    L40:
        r14 = null;
    L43:
        r10 = ChatDestination.CHAT_WINDOW;
    L18:
        r12 = this.a.we(r3);
        if (r12 != null) goto L22;
        r10 = ChatDestination.CHAT_WINDOW;
        goto L44
    }
}
