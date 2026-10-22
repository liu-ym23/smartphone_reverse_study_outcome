package c2b;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.n;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final List<Message.Type> e = null;
    public static final Map<String, d> f = null;
    public b a;
    public final String b;
    public boolean c;
    public final ScheduledExecutorService d;

    static {
        e = Arrays.asList(new Message.Type[]{Message.Type.TEXT, Message.Type.POST, Message.Type.FILE, Message.Type.IMAGE, Message.Type.AUDIO, Message.Type.STICKER, Message.Type.MEDIA, Message.Type.RED_PACKET});
        f = new HashMap();
    }

    public d(String r3) {
        new HashSet();
        new HashSet();
        this.b = r3;
        if (r3 != null) goto L5;
        r3 = "unDeclared";
    L5:
        this.d = PThreadExecutorsUtils.newScheduledThreadPool(1, new n("MsgReadIssueTracker_".concat(r3)));
    }

    public static d b(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
        Map<String, d> r0 = f;
        monitor-enter(r0);
        d r1 = (d) ((HashMap) r0).get(r3);     // Catch: Throwable -> L13
        if (r1 != null) goto L11;
        r1 = new d(r3);     // Catch: Throwable -> L13
        ((HashMap) r0).put(r3, r1);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    L5:
        return new d(BuildConfig.FLAVOR);
    }

    public final void c(String r3) {
        if (this.c == true) goto L5;
        return;
    L5:
        c r4 = this.a.a(r3);
        List<MessageInfo> r0 = r4.a;
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L13;
        return;
    L13:
        if (r4.b != null) goto L17;
        r4.b = (MessageInfo) ListProtector.get(r4.a, 0);
        return;
    L17:
        return;
    L8:
        if (r0.isEmpty() == true) goto L10;
        r1 = true;
        goto L11
    }

    public final void a(Chat r3, a r4) {
        if (TextUtils.isEmpty(this.b) == true) goto L16;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.b.equals(r3.getId()) == true) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.b) == false) goto L11;
    L13:
        boolean r0 = false;
    L14:
        this.c = r0;
        this.a = r4;
        r3.getP2pChatterId();
        return;
    L11:
        if (r3.getUserCount() >= 50) goto L13;
        r0 = true;
        goto L14
    }
}
