package com.larus.bmhome.chat.standarduikit.taskcard.blockadapter;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.standarduikit.taskcard.view.TaskCardView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TaskCardBlock;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import un8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class TaskCardBlockHolder extends jc8.b<com.larus.bmhome.chat.standarduikit.taskcard.blockadapter.a> {
    public static final /* synthetic */ int i = 0;
    public kc8.b d;
    public final Lazy e;
    public final Lazy f;
    public tn8.c g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public final String c() {
        return "TaskCardBlockHolder";
    }

    public final void i() {
        kc8.b r0 = this.d;
        if (r0 == null) goto L10;
        y r1 = r0.a;
        if (r1 == null) goto L11;
        Function1 r2 = r1.D;
        if (r2 == null) goto L12;
        r2.invoke(Boolean.FALSE);
        return;
    L12:
        return;
    L11:
        return;
    }

    public TaskCardBlockHolder() {
        this.e = LazyKt.lazy(new b(this));
        this.f = LazyKt.lazy(new c(this));
        this.h = LazyKt.lazy(new d(this));
    }

    public final jc8.d f(jc8.a r2) {
        com.larus.bmhome.chat.standarduikit.taskcard.blockadapter.a r3 = (com.larus.bmhome.chat.standarduikit.taskcard.blockadapter.a) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    public final void g(jc8.a r6) {
        com.larus.bmhome.chat.standarduikit.taskcard.blockadapter.a r7 = (com.larus.bmhome.chat.standarduikit.taskcard.blockadapter.a) r6;
        Intrinsics.checkNotNullParameter(r7, "blockModel");
        this.d = jc8.c.a(this, kc8.b.class);
        boolean r1 = ((jc8.a) r7).a.isFinish();
        Message r2 = r7.j();
        kc8.b r3 = this.d;
        TaskCardBlock r4 = null;
        if (r3 == null) goto L11;
        y r5 = r3.a;
        if (r5 == null) goto L11;
        Function0 r8 = r5.l;
        if (r8 == null) goto L11;
        BotModel r9 = (BotModel) r8.invoke();
        if (r9 == null) goto L11;
        String r10 = r9.getBotId();
    L12:
        BlockContent r11 = ((jc8.a) r7).a.getContent();
        if (r11 == null) goto L15;
        r4 = r11.getTaskCardBlock();
    L15:
        vn8.a r0 = new vn8.a(r1, r2, r10, r4);
        tn8.c r12 = this.g;
        if (r12 == null) goto L22;
        TaskCardBlockHolder$taskCardVMDependencyImpl$2$1 r13 = (TaskCardBlockHolder$taskCardVMDependencyImpl$2$1) this.h.getValue();
        Intrinsics.checkNotNullParameter(r0, "vmData");
        vn8.c r14 = (vn8.c) r12.b.getValue();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r0, "vmData");
        r14.a = r0;
        r14.b = r13;
        vn8.a r15 = ((vn8.c) r12.b.getValue()).a;
        if (r15 != null) goto L20;
        r15 = new vn8.a(0);
    L20:
        ((TaskCardView) r12.a.getValue()).b(new l(r15.a, r15.c, r15.b, r15.d), ((vn8.c) r12.b.getValue()).c);
        return;
    L22:
        return;
    L11:
        r10 = null;
        goto L12
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        tn8.c r0 = new tn8.c(r4.getContext());
        this.g = r0;
        TaskCardView r5 = (TaskCardView) r0.a.getValue();
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r5;
    }
}
