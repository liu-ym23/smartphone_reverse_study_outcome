package com.ss.android.lark.chat.chatwindow.chat.model.data.decorator;

import a2b.j;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.i;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import q3b.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements i<MessageInfo> {
    public final v a;
    public final Function0<j.a> b;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.a$a, reason: collision with other inner class name */
    public static final class C0047a {
    }

    static {
    }

    @Override // com.ss.android.lark.chatbase.i
    public final void a(f5b.b r3) {
        MessageInfo r4 = (MessageInfo) r3;
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        this.a.G().u3(r4, this.b);
    }

    public a(v r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "mSmartApplyAnswerLoader");
        this.a = r2;
        this.b = r3;
    }
}
