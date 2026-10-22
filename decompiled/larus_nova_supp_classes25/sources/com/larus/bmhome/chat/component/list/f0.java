package com.larus.bmhome.chat.component.list;

import androidx.lifecycle.Observer;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f0 implements Observer {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ MessageAdapter b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ Function0 e;

    public /* synthetic */ f0(Ref.BooleanRef r1, MessageAdapter r2, Ref.ObjectRef r3, Ref.ObjectRef r4, Function0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void onChanged(Object r7) {
        Ref.BooleanRef r0 = this.a;
        MessageAdapter r1 = this.b;
        Ref.ObjectRef r2 = this.c;
        Ref.ObjectRef r3 = this.d;
        Function0 r4 = this.e;
        int r5 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter((List) r7, "it");
        ChatListComponent.s7(r0, r1, r2, r3, r4);
    }
}
