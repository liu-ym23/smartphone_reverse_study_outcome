package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.reader;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2.MessageListViewModelV2;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.team.TeamUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import s2b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ReplyInThreadMessageReader extends o {
    public final LiveData<Chat> j;
    public final ThreadTopic k;
    public final LiveData<Boolean> l;
    public final b m;
    public final boolean n;

    public static final class a {
    }

    public interface b {
        MessageInfo a();
    }

    static {
    }

    @Override // s2b.o
    public final boolean d() {
        return this.n;
    }

    public final void a(final MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        Function1<ThreadTopic, Unit> r0 = new ReplyInThreadMessageReader$readAudioMessage$1(this, r2);
        Chat r3 = (Chat) this.j.getValue();
        if (r3 == null) goto L8;
        TeamUtils.b(r3);
        ThreadTopic r4 = this.k;
        if (r4 == null) goto L9;
        r0.invoke(r4);
        return;
    L9:
        return;
    }

    @Override // s2b.o
    public final void c(final List<? extends MessageInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Function1<ThreadTopic, Unit> r0 = new ReplyInThreadMessageReader$readMessages$1(this, r2);
        Chat r3 = (Chat) this.j.getValue();
        if (r3 == null) goto L8;
        TeamUtils.b(r3);
        ThreadTopic r4 = this.k;
        if (r4 == null) goto L9;
        r0.invoke(r4);
        return;
    L9:
        return;
    }

    public static final void f(ReplyInThreadMessageReader r2, MessageInfo r3) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        r2.a.m5(r3.getMessage(), r2.d(), r3.getMessageFoldDetail());
    }

    public static final /* synthetic */ void g(ReplyInThreadMessageReader r0, List r1) {
        super.c(r1);
    }

    public ReplyInThreadMessageReader(String r2, MutableLiveData r3, ThreadTopic r4, MutableLiveData r5, MessageListViewModelV2.a r6) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "currentChat");
        Intrinsics.checkNotNullParameter(r5, "messageReadable");
        Intrinsics.checkNotNullParameter(r6, "lastMessageFetcher");
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        Chat r7 = (Chat) r3.getValue();
        if (r7 == null) goto L5;
        boolean r8 = r7.isSuper();
    L6:
        this.n = r8;
        return;
    L5:
        r8 = false;
        goto L6
    }
}
