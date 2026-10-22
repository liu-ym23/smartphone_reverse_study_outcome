package com.larus.bmhome.auth.douyin;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bg\u0018\u00002\u00020\u0001:\u0002'(J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\u000bH&J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H&J$\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u000eH&J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0012H&J\n\u0010\u001e\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\fH&J\u0012\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\fH&J*\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u0012H&¨\u0006)"}, d2 = {"Lcom/larus/bmhome/auth/douyin/IAiChatOpenDouyinAuthService;", "", "removeAiChatDouyinAuthResultHandler", "", "handler", "Lcom/larus/bmhome/auth/douyin/IAiChatDouyinAuthResultHandler;", "addAiChatDouyinAuthResultHandler", "addOnMessageNeedAuthListener", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "listener", "Lkotlin/Function1;", "Lcom/larus/im/bean/message/Message;", "showPreAskingDialog", "", "json", "Lorg/json/JSONObject;", "title", "", "cancel", "confirm", "callback", "Lcom/larus/bmhome/auth/douyin/IAiChatOpenDouyinAuthService$IDouyinAuthPreAskingCallback;", "handleSchema", "parse", "Landroid/net/Uri;", "traceInfo", "ignore", "handleTraceInfo", "jumpUrl", "currentMessage", "checkIfAuthMessage", "message", "setAuthMessage", "requestAuthorizeCardMessage", "messageId", "musicPlatform", "cvsId", "botId", "IAiChatDouyinAuthCallback", "IDouyinAuthPreAskingCallback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IAiChatOpenDouyinAuthService {

    public static final class a {
        public static /* synthetic */ void a(IAiChatOpenDouyinAuthService r1, Uri r2, JSONObject r3, boolean r4, int r5) {
            if ((r5 & 2) == 0) goto L6;
            r3 = new JSONObject();
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = false;
        L8:
            r1.l(r2, r3, r4);
        }
    }

    public interface b {

        public static final class a {
            public static /* synthetic */ void a(b r0, boolean r1, Integer r2, String r3, String r4, String r5, String r6, int r7) {
                if ((r7 & 2) == 0) goto L5;
                r2 = null;
            L5:
                r0.a(r1, r2);
            }
        }

        void a(boolean r1, Integer r2);
    }

    public interface c {
        void onResult(boolean r1);
    }

    void f(Message r1);

    void g();

    JSONObject h(String r1);

    Message i();

    void j(ya8.a r1);

    void k(String r1, String r2, String r3, String r4);

    void l(Uri r1, JSONObject r2, boolean r3);

    void m(ya8.a r1);

    boolean n(JSONObject r1, String r2, String r3, String r4, c r5);

    void o(LifecycleOwner r1, Function1<? super Message, Unit> r2);
}
