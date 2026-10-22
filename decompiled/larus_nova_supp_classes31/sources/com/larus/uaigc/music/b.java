package com.larus.uaigc.music;

import android.content.Context;
import android.os.Bundle;
import android.util.LruCache;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.createpage.v;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kr8.q;
import vp8.g;
import vp8.j;
import wy9.c;
import xt7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b extends g implements c, wy9.b {
    public final BaseContentWidget h;
    public final j i;
    public com.larus.bmhome.music.instructions.g j;
    public com.larus.bmhome.view.actionbar.edit.c k;
    public String l;

    public final void d() {
    }

    public final void i() {
        com.larus.bmhome.music.instructions.g r0 = this.j;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public final void l() {
        com.larus.bmhome.music.instructions.g r0 = this.j;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public final void o() {
        com.larus.bmhome.music.instructions.g r0 = this.j;
        if (r0 == null) goto L6;
        r0.f(r0.j);
        return;
    }

    public final void p() {
        s1a.a.f(((g) this).g, wy9.b.class);
    }

    @Override // wy9.c
    public final com.larus.bmhome.music.instructions.g b() {
        return this.j;
    }

    public final boolean f(z0 r15) {
        boolean r0 = true;
        if (r15 == null) goto L12;
        r r2 = r15.q;
        if (r2 == null) goto L12;
        Integer r3 = r2.a;
        if (r3 == null) goto L12;
        if (r3.intValue() != 1) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        return false;
    L16:
        if (z2.a.V3() == true) goto L18;
        return false;
    L18:
        j r5 = this.i;
        if (r5 == null) goto L48;
        ChatParam r6 = r5.c();
        if (r6 == null) goto L48;
        String r7 = r6.a;
        if (r7 == null) goto L48;
        if (r7.length() <= 0) goto L28;
        boolean r8 = true;
    L29:
        if (r8 == false) goto L31;
        String r9 = r7;
    L32:
        if (r9 == null) goto L48;
        String r10 = r6.b;
        if (r10 != null) goto L37;
        String r11 = "";
    L38:
        String r12 = r6.e;
        String r13 = r6.c;
        if (r13 != null) goto L41;
        String r14 = "";
    L42:
        Bundle r16 = new Bundle();
        r16.putString("argBotId", r11);
        r16.putString("argConversationId", r9);
        r16.putString("arg_chat_type", r12);
        r16.putString("argPreviousPage", r14);
        r16.putParcelable("chat_param", new ChatParam(r9, r11, r14, "chat", r12, 224));
        r16.putString("custom_action_bar_item", d.b.a(z0.Companion.serializer(), r15));
        if (s1a.d.a(this.h).getAbility(v.class) != null) goto L46;
        r0 = false;
    L46:
        if (r0 == false) goto L50;
        r16.putString("source_creation_session_id", UUID.randomUUID().toString());
    L50:
        if (r16 != null) goto L53;
        FLogger.a.e("MusicInstructionBizAdapter", "open music template applet failed, target chat param is invalid");
        return false;
    L53:
        String r1 = r16.getString("source_creation_session_id");
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L56
        Object r18 = Result.constructor-impl(Boolean.valueOf(IUgcAIGCService.a.Y(r16)));     // Catch: Throwable -> L56
    L58:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L62;
        FLogger.a.e("MusicInstructionBizAdapter", "open music template applet failed", r19);
        r18 = Boolean.FALSE;
    L62:
        boolean r20 = ((Boolean) r18).booleanValue();
        if (r20 == false) goto L66;
        if (r1 == null) goto L66;
        this.l = r1;
    L68:
        FLogger.a.i("MusicInstructionBizAdapter", "open music template applet from actionbar, handled=" + r20);
        return r20;
    L66:
        if (r1 == null) goto L68;
        this.l = null;
    L56:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L41:
        r14 = r13;
        goto L42
    L37:
        r11 = r10;
        goto L38
    L31:
        r9 = null;
        goto L32
    L28:
        r8 = false;
    L48:
        r16 = null;
    L12:
        r4 = false;
        goto L13
    }

    @Override // wy9.b
    public final boolean oX(List<u> r4) {
        wy9.d r0 = (wy9.d) s1a.d.a(this.h).getAbility(wy9.d.class);
        if (r0 != null) goto L6;
        return false;
    L6:
        com.larus.bmhome.music.instructions.g r1 = this.j;
        if (r1 == null) goto L9;
        r1.f(2);
    L9:
        r0.AA(r4, this.j);
        return true;
    }

    public final void r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r2, "text");
        if (this.j == null) goto L6;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        return;
    }

    public final void t(com.larus.bmhome.view.actionbar.edit.c r10) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        this.k = r10;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.h), null, null, new MusicInstructionBizAdapter$initObserver$1(r10, this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.h), null, null, new MusicInstructionBizAdapter$initObserver$2(r10, this, null), 3, null);
        com.larus.bmhome.music.instructions.g r0 = this.j;
        if (r0 == null) goto L6;
        r0.l = r10;
        return;
    }

    public final void u(ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r9, "viewGroup");
        Intrinsics.checkNotNullParameter(r9, "viewGroup");
        this.j = new com.larus.bmhome.music.instructions.g(s1a.d.a(this.h), this.h.getContext(), this.h.F2());
        s1a.a.a(((g) this).g, this, wy9.b.class);
        ImageView r10 = (ImageView) this.h.F2().findViewById(2131362038);
        if (r10 == null) goto L5;
        e1.d(r10, new a(this));
    L5:
        LruCache r11 = q.a;
        j r12 = this.i;
        if (r12 == null) goto L10;
        de8.c r13 = r12.f1();
        if (r13 == null) goto L10;
        String r14 = r13.p();
    L11:
        WeakReference r1 = new WeakReference(this.j);
        Intrinsics.checkNotNullParameter(r1, "createTypeManager");
        HashSet r3 = q.b;
        monitor-enter(r3);
    L25:
        th = move-exception;
        throw th;
    L14:
        if (q.c == false) goto L30;
        monitor-exit(r3);
    L23:
        androidx.collection.LruCache r2 = ko8.a.a;
        kr8.r r4 = new kr8.r(r1, r14);
        Intrinsics.checkNotNullParameter("MusicCreateMob", "key");
        Intrinsics.checkNotNullParameter(r4, "listener");
        IAIChatControlTraceService.a.Yb(r4);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.h), null, null, new MusicInstructionBizAdapter$observeMusicAppletSendFinishedEvent$1(this, null), 3, null);
        return;
    L30:
        NativeMessageServiceImpl r5 = com.larus.im.d.e();     // Catch: Exception -> L19 Throwable -> L25
        q.a r6 = q.d;     // Catch: Exception -> L19 Throwable -> L25
        r5.registerOnGlobalMessageObserver(r6);     // Catch: Exception -> L19 Throwable -> L25
        com.larus.im.d.e().registerOnThreadGlobalMessageObserver(r6);     // Catch: Exception -> L19 Throwable -> L25
        q.c = true;     // Catch: Exception -> L19 Throwable -> L25
    L21:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r3);
        goto L23
    L19:
        e = move-exception;
        FLogger.a.e("MusicCreateMob", "register music result observer failed: " + e.getMessage());     // Catch: Throwable -> L25
    L10:
        r14 = null;
        goto L11
    }

    @Override // wy9.c
    public final boolean x(String r9) {
        Intrinsics.checkNotNullParameter(r9, "input");
        IChatDoubleTabAbility r0 = (IChatDoubleTabAbility) ((g) this).e.getValue();
        if (r0 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        com.larus.bmhome.instruction.j r2 = IAIChatUgcAIGCService.a.e0();
        Context r3 = this.h.getContext();
        com.larus.bmhome.view.actionbar.edit.c r6 = this.k;
        com.larus.bmhome.music.instructions.g r1 = this.j;
        if (r1 == null) goto L11;
        Integer r4 = Integer.valueOf(r1.j);
    L13:
        return r2.d(r3, r9, r5, r6, r4);
    L11:
        r4 = null;
        goto L13
    L5:
        if (r0.getBizType() != 2) goto L7;
        r5 = true;
        goto L8
    }

    public b(BaseContentWidget r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "component");
        super(r2);
        this.h = r2;
        this.i = r3;
    }
}
