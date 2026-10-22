package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.standarduikit.floatingthink.view.FloatingThinkView;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.ThinkingBlock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l extends jc8.b<g> {
    public el8.c d;
    public String e;
    public g f;
    public int g;
    public boolean h;
    public boolean i;
    public Lifecycle j;
    public final i k;
    public final a l;

    public static final class a implements gl8.b {
        public final /* synthetic */ l a;

        public a(l r1) {
            this.a = r1;
        }

        @Override // gl8.b
        public final void a(g r6) {
            if (r6 == null) goto L34;
            l r0 = this.a;
            r0.getClass();
            if (Intrinsics.areEqual(l.k(r6), l.k(r0.f)) == true) goto L7;
            return;
        L7:
            if (l.l(r6.j()) == true) goto L10;
            r0.p(r6);
            return;
        L10:
            if (r0.h == false) goto L12;
            return;
        L12:
            if (r6.j().getMessageStatusLocal() != 21) goto L40;
            String r1 = r6.j().getConversationId();
            if (r1 == null) goto L37;
            String r4 = null;
            if ((!StringsKt.isBlank(r1)) == true) goto L20;
            r1 = null;
        L20:
            if (r1 == null) goto L41;
            String r7 = r6.j().getMessageId();
            if (r7 != null) goto L25;
            return;
        L25:
            if ((!StringsKt.isBlank(r7)) == false) goto L27;
            r4 = r7;
        L27:
            if (r4 == null) goto L42;
            int r8 = r0.g;
            WeakReference r2 = new WeakReference(r0);
            r0.h = true;
            g r3 = r0.f;
            if (r3 == null) goto L32;
            r0.m(r3);
        L32:
            com.larus.im.d.e().s(r1, r4, new k(r2, r8, r4, r1));
            return;
        L42:
            return;
        L41:
            return;
        L37:
            return;
        L40:
            return;
        }
    }

    public final String c() {
        return "FloatingThinkBlockHolder";
    }

    public final void i() {
        Lifecycle r0 = this.j;
        if (r0 == null) goto L5;
        r0.removeObserver(this.k);
    L5:
        this.j = null;
        this.g++;
        this.h = false;
        this.i = false;
        this.e = null;
        this.f = null;
        el8.c r1 = this.d;
        if (r1 == null) goto L9;
        ((FloatingThinkView) r1.b.getValue()).c();
        return;
    }

    public final void o() {
        g r0 = this.f;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.i == true) goto L8;
        return;
    L8:
        if (l(r0.j()) == true) goto L44;
        Message r1 = r0.j();
        if (com.larus.bmhome.chat.bean.d.i0(r1) == false) goto L15;
        if (com.larus.bmhome.chat.bean.d.w(r1) == true) goto L15;
    L34:
        boolean r4 = false;
    L35:
        if (r4 == true) goto L37;
        return;
    L37:
        if (r0.j().getMessageStatusLocal() != 21) goto L47;
        this.i = false;
        if (h.a(r0) == false) goto L46;
        p(r0);
        return;
    L46:
        return;
    L47:
        return;
    L15:
        if (com.larus.bmhome.chat.bean.d.T(r1) == true) goto L34;
        if (com.larus.bmhome.chat.bean.d.p0(r1) == true) goto L34;
        if (com.larus.bmhome.chat.bean.d.C0(r1) == true) goto L22;
    L24:
        MessageStatus r2 = r1.getMessageStatus();
        r4 = true;
        if (r2 != null) goto L27;
    L29:
        boolean r3 = false;
    L30:
        if (r3 == true) goto L35;
        if (b0.f(r1) == false) goto L34;
    L27:
        if (r2.isVisible() != true) goto L29;
        r3 = true;
        goto L30
    L22:
        if (r1.getRegenVisible() == true) goto L24;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter.i] */
    public l() {
        this.k = new i(this);
        this.l = new a(this);
    }

    public static boolean j(Fragment r5) {
        FragmentActivity r0 = r5.getActivity();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r5.isAdded() == true) goto L8;
        return false;
    L8:
        if (r5.getView() != null) goto L10;
        return false;
    L10:
        if (r5.isDetached() == false) goto L12;
        return false;
    L12:
        if (r5.isRemoving() == false) goto L15;
        return false;
    L15:
        if (r0.isFinishing() == false) goto L17;
        return false;
    L17:
        if (r0.isDestroyed() == false) goto L19;
        return false;
    L19:
        if (r0.getSupportFragmentManager().isStateSaved() == false) goto L21;
        return false;
    L21:
        if (r0.getSupportFragmentManager().isDestroyed() == true) goto L56;
        Lifecycle.State r2 = r5.getLifecycle().getCurrentState();
        Lifecycle.State r3 = Lifecycle.State.RESUMED;
        if (r2.isAtLeast(r3) == false) goto L51;
        LifecycleOwner r4 = (LifecycleOwner) r5.getViewLifecycleOwnerLiveData().getValue();
        if (r4 == null) goto L34;
        Lifecycle r6 = r4.getLifecycle();
        if (r6 == null) goto L34;
        Lifecycle.State r7 = r6.getCurrentState();
        if (r7 == null) goto L34;
        if (r7.isAtLeast(r3) != true) goto L34;
        boolean r8 = true;
    L35:
        if (r8 == true) goto L37;
        return false;
    L37:
        if (r0.getLifecycle().getCurrentState().isAtLeast(r3) == false) goto L57;
        FragmentManager r9 = r5.getChildFragmentManager();
        if (r9.isStateSaved() == false) goto L42;
        return false;
    L42:
        if (r9.isDestroyed() == true) goto L54;
        return true;
    L54:
        return false;
    L57:
        return false;
    L34:
        r8 = false;
        goto L35
    L51:
        return false;
    L56:
        return false;
    }

    public static Triple k(g r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return new Triple(r3.j().getConversationId(), r3.j().getMessageId(), ((jc8.a) r3).a.getBlockId());
    }

    public static boolean l(Message r2) {
        Set r0 = SetsKt.setOf(new String[]{"1", "true"});
        Map r3 = r2.getExt();
        if (r3 == null) goto L5;
        String r4 = (String) r3.get("need_lazy_load");
    L7:
        return CollectionsKt.contains(r0, r4);
    L5:
        r4 = null;
        goto L7
    }

    public final jc8.d f(jc8.a r2) {
        g r3 = (g) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    public final /* bridge */ /* synthetic */ void g(jc8.a r1) {
        m((g) r1);
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        el8.c r0 = new el8.c(r2.getContext());
        this.d = r0;
        return (FloatingThinkView) r0.b.getValue();
    }

    public final void m(g r23) {
        Intrinsics.checkNotNullParameter(r23, "blockModel");
        kc8.b r1 = jc8.c.a(this, kc8.b.class);
        FloatingThinkDetailRootFragment r10 = null;
        if (r1 == null) goto L13;
        kc8.y r2 = r1.a;
        if (r2 == null) goto L13;
        Fragment r3 = r2.a;
        if (r3 == null) goto L13;
        LiveData r4 = r3.getViewLifecycleOwnerLiveData();
        if (r4 == null) goto L13;
        LifecycleOwner r5 = (LifecycleOwner) r4.getValue();
        if (r5 == null) goto L13;
        Lifecycle r6 = r5.getLifecycle();
    L14:
        Lifecycle r7 = this.j;
        if (r7 == r6) goto L22;
        if (r7 == null) goto L18;
        r7.removeObserver(this.k);
    L18:
        this.j = r6;
        if (r6 == null) goto L22;
        r6.addObserver(this.k);
    L22:
        if (Intrinsics.areEqual(k(this.f), k(r23)) == true) goto L24;
        this.g++;
        this.h = false;
        this.i = false;
        this.e = null;
    L24:
        this.f = r23;
        Message r8 = r23.j();
        Block r9 = ((jc8.a) r23).a;
        if (com.larus.im.bean.message.a.f0(r8) == true) goto L27;
    L35:
        boolean r11 = false;
    L36:
        el8.c r14 = this.d;
        if (r14 == null) goto L102;
        BlockContent r12 = r9.getContent();
        if (r12 == null) goto L41;
        ThinkingBlock r13 = r12.getThinkingBlock();
    L42:
        gl8.a r15 = new gl8.a(r8, r9, r13, r11, this.h, r23.i(), r23);
        a r16 = this.l;
        Intrinsics.checkNotNullParameter(r15, "vmData");
        gl8.d r17 = (gl8.d) r14.c.getValue();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r15, "vmData");
        r17.a = r15;
        r17.b = r16;
        gl8.a r18 = ((gl8.d) r14.c.getValue()).a;
        if (r18 != null) goto L45;
        fl8.d r19 = new fl8.d(null, false, false, false, null, 63);
    L101:
        final gl8.d r20 = (gl8.d) r14.c.getValue();
        r20.getClass();
        ((FloatingThinkView) r14.b.getValue()).a(r19, new fl8.e(new gl8.c(r20)));
        goto L102
    L45:
        Message r21 = r18.a;
        if (r21 != null) goto L48;
        r19 = new fl8.d(null, false, false, false, null, 63);
        goto L101
    L48:
        com.larus.bmhome.utils.z r22 = com.larus.bmhome.utils.z.a;
        boolean r24 = r18.d;
        ThinkingBlock r25 = r18.c;
        List<jc8.a> r26 = r18.f;
        DeepThinkFoldStatus r27 = DeepThinkFoldStatus.CompleteFold;
        r22.getClass();
        String r110 = com.larus.bmhome.utils.z.d(r21, r24, r25, r26, r27);
        String r28 = com.larus.bmhome.utils.z.c(r21, r18.d, r18.c, r18.f, r27);
        if ((!StringsKt.isBlank(r28)) == true) goto L52;
        r28 = null;
    L52:
        if (r28 != null) goto L62;
        boolean r29 = v19.h.a;
        if (v19.h.a(null) == false) goto L58;
        ThinkingBlock r30 = r18.c;
        if (r30 == null) goto L61;
        r28 = r30.iconUrlDark;
    L61:
        String r210 = null;
    L64:
        if (r21.getMessageStatusLocal() != 21) goto L72;
        Set r31 = SetsKt.setOf(new String[]{"1", "true"});
        Map r32 = r21.getExt();
        if (r32 == null) goto L68;
        String r33 = (String) r32.get("need_lazy_load");
    L70:
        if (CollectionsKt.contains(r31, r33) == false) goto L72;
        boolean r34 = true;
    L73:
        List<jc8.a> r35 = r18.f;
        if ((r35 instanceof Collection) == true) goto L76;
    L78:
        Iterator<T> r36 = r35.iterator();
    L80:
        if (r36.hasNext() == false) goto L84;
        if ((!h.b((jc8.a) r36.next())) == false) goto L80;
        boolean r37 = true;
    L85:
        if (r37 == true) goto L89;
        if (r34 == true) goto L89;
        boolean r211 = false;
    L90:
        if (r34 == true) goto L92;
    L94:
        boolean r111 = false;
    L96:
        if (r211 == false) goto L99;
        if (r34 == true) goto L99;
        boolean r112 = true;
    L100:
        r19 = new fl8.d(r110, r112, r111, r18.d, r211, r210);
    L99:
        r112 = false;
        goto L100
    L92:
        if (r18.e == false) goto L94;
        r111 = true;
    L89:
        r211 = true;
    L84:
        r37 = false;
        goto L85
    L76:
        if (r35.isEmpty() == false) goto L78;
    L68:
        r33 = null;
    L72:
        r34 = false;
        goto L73
    L58:
        ThinkingBlock r38 = r18.c;
        if (r38 == null) goto L61;
        r28 = r38.iconUrl;
    L62:
        r210 = r28;
        goto L64
    L41:
        r13 = null;
    L102:
        kc8.b r39 = jc8.c.a(this, kc8.b.class);
        if (r39 == null) goto L107;
        kc8.y r40 = r39.a;
        if (r40 == null) goto L107;
        Fragment r41 = r40.a;
    L108:
        Fragment r42 = r41;
    L109:
        if (r42 == null) goto L114;
        if ((r42 instanceof u) == true) goto L112;
        r42 = r42.getParentFragment();
        goto L109
    L112:
        u r43 = (u) r42;
    L115:
        if (r43 == null) goto L117;
        r43.cf(r23);
    L117:
        if (r41 == null) goto L125;
        String r44 = this.e;
        if (r44 == null) goto L125;
        Fragment r45 = r41.getChildFragmentManager().findFragmentByTag(r44);
        if ((r45 instanceof FloatingThinkDetailRootFragment) == false) goto L125;
        r10 = (FloatingThinkDetailRootFragment) r45;
    L125:
        if (r10 == null) goto L127;
        r10.U90(r23);
    L127:
        o();
        return;
    L114:
        r43 = null;
    L107:
        r41 = null;
        goto L108
    L27:
        if (r9.isFinish() == true) goto L35;
        if (r8.getMessageStatusLocal() == 23) goto L35;
        if (r8.getMessageStatusLocal() == 21) goto L35;
        if (r8.getMessageStatusLocal() == 22) goto L35;
        r11 = true;
    L13:
        r6 = null;
        goto L14
    }

    public final void p(g r15) {
        if (h.a(r15) == true) goto L5;
        return;
    L5:
        kc8.b r0 = jc8.c.a(this, kc8.b.class);
        if (r0 == null) goto L69;
        kc8.y r1 = r0.a;
        if (r1 == null) goto L70;
        Fragment r2 = r1.a;
        if (r2 != null) goto L13;
        return;
    L13:
        if (j(r2) == true) goto L15;
        return;
    L15:
        Fragment r3 = r2;
    L17:
        if (r3 == null) goto L22;
        if ((r3 instanceof u) == true) goto L20;
        r3 = r3.getParentFragment();
        goto L17
    L20:
        u r4 = (u) r3;
    L23:
        if (r4 != null) goto L25;
    L27:
        FragmentManager r5 = r2.getChildFragmentManager();
        int r6 = FloatingThinkDetailRootFragment.j;
        Intrinsics.checkNotNullParameter(r15, "blockModel");
        String[] r7 = new String[4];
        r7[0] = "FloatingThinkDetailFragment";
        String r8 = r15.j().getConversationId();
        String r9 = "";
        if (r8 != null) goto L30;
        r8 = "";
    L30:
        r7[1] = r8;
        String r10 = r15.j().getMessageId();
        if (r10 != null) goto L33;
        r10 = "";
    L33:
        r7[2] = r10;
        String r11 = ((jc8.a) r15).a.getBlockId();
        if (r11 == null) goto L37;
        r9 = r11;
    L37:
        r7[3] = r9;
        final String r12 = CollectionsKt.joinToString$default(CollectionsKt.listOf(r7), ":", null, null, 0, null, null, 62, null);
        if (Intrinsics.areEqual(this.e, r12) == false) goto L40;
        return;
    L40:
        if (r5.findFragmentByTag(r12) != null) goto L74;
        el8.c r13 = this.d;
        if (r13 == null) goto L65;
        ((FloatingThinkView) r13.b.getValue()).b();
    L65:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L56
        kc8.y r16 = r0.a;     // Catch: Throwable -> L56
        Intrinsics.checkNotNullParameter(r15, "blockModel");     // Catch: Throwable -> L56
        FloatingThinkDetailRootFragment r17 = new FloatingThinkDetailRootFragment();     // Catch: Throwable -> L56
        r17.d = r15;     // Catch: Throwable -> L56
        if (r16 == null) goto L48;
        kc8.y.a r18 = r16.b();     // Catch: Throwable -> L56
        r18.C = r17;     // Catch: Throwable -> L56
        kc8.y r19 = r18.a();     // Catch: Throwable -> L56
    L49:
        r17.e = r19;     // Catch: Throwable -> L56
        r17.i = new j(this, r12);     // Catch: Throwable -> L56
        this.e = r12;     // Catch: Throwable -> L56
        LandscapeRestrictionOperation r20 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L56
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r17, r12, r20);     // Catch: Throwable -> L56
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r17, r20) == false) goto L63;
    L54:
        r17.U90(r15);     // Catch: Throwable -> L56
        Object r110 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L56
    L58:
        Throwable r111 = Result.exceptionOrNull-impl(r110);
        if (r111 == null) goto L72;
        this.e = null;
        FLogger.a.e("FloatingThinkBlockHolder", "unable show detail dialog", r111);
        return;
    L72:
        return;
    L63:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L62 Throwable -> L56
    L53:
        r17.show(r5, r12);     // Catch: Throwable -> L56
        goto L54
    L48:
        r19 = null;
    L56:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L74:
        return;
    L25:
        if (r4.FT(r15, r0.a) == false) goto L27;
        return;
    L22:
        r4 = null;
        goto L23
    L70:
        return;
    }
}
