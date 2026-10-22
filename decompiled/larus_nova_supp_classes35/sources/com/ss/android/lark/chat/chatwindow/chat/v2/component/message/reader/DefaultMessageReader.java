package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.reader;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.MessageListViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.team.TeamUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import s2b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DefaultMessageReader extends o {
    public final String j;
    public final LiveData<Chat> k;
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
        Function1<Chat, Unit> r0 = new DefaultMessageReader$readAudioMessage$1(this, r2);
        Chat r3 = (Chat) this.k.getValue();
        if (r3 == null) goto L6;
        TeamUtils.b(r3);
        r0.invoke(r3);
        return;
    }

    @Override // s2b.o
    public final void c(final List<? extends MessageInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Function1<Chat, Unit> r0 = new DefaultMessageReader$readMessages$1(this, r2);
        Chat r3 = (Chat) this.k.getValue();
        if (r3 == null) goto L6;
        TeamUtils.b(r3);
        r0.invoke(r3);
        return;
    }

    public static final void f(DefaultMessageReader r2, MessageInfo r3) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        r2.a.m5(r3.getMessage(), r2.d(), r3.getMessageFoldDetail());
    }

    public static final /* synthetic */ void g(DefaultMessageReader r0, List r1) {
        super.c(r1);
    }

    public DefaultMessageReader(String r2, MutableLiveData r3, MutableLiveData r4, MessageListViewModel.a r5) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "currentChat");
        Intrinsics.checkNotNullParameter(r4, "messageReadable");
        Intrinsics.checkNotNullParameter(r5, "lastMessageFetcher");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        Chat r6 = (Chat) r3.getValue();
        if (r6 == null) goto L5;
        boolean r7 = r6.isSuper();
    L6:
        this.n = r7;
        return;
    L5:
        r7 = false;
        goto L6
    }
}
