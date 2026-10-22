package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.s2;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import nz.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class SyncCommerceExplainingToProductDetailPage extends mx.l {
    public final Context p;
    public final boolean q;
    public final ListDialogAbility r;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ SyncCommerceExplainingToProductDetailPage a;
        public final /* synthetic */ SwitchSettingViewHolder b;

        public a(SyncCommerceExplainingToProductDetailPage r1, SwitchSettingViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dialog");
            this.a.g(false);
            int r5 = mx.l.o;
            mx.l.a.a(this.a, this.b, false);
            r3.dismiss();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public final boolean b(boolean r1) {
        return !r1;
    }

    public final void d() {
        IUserService r0 = jc1.k.f(IUserService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L7;
        String r2 = r1.n();
    L8:
        com.bytedance.android.livesdk.log.u.l().f("livesdk_live_replay_product_detail_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("anchor_id", String.valueOf(r2)), TuplesKt.to("action_type", m2.b(((mx.l) this).l))}), new Object[]{Reflection.getOrCreateKotlinClass(am2.x.class)});
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final Context getContext() {
        return this.p;
    }

    public final void g(final boolean r13) {
        FragmentActivity r2 = null;
        long r3 = 0;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        final Room r4 = (Room) r1.getValue();
    L8:
        com.bytedance.android.livesdk.log.u.l().f("livesdk_live_replay_product_detail_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("anchor_id", jc1.k.n(IUserService.class).user().n()), TuplesKt.to("action_type", m2.b(r13))}), new Object[]{Reflection.getOrCreateKotlinClass(am2.x.class)});
        FragmentActivity r5 = s2.a(this.p);
        if ((r5 instanceof FragmentActivity) == false) goto L12;
        r2 = r5;
    L12:
        FragmentActivity r6 = r2;
        if (r6 == null) goto L19;
        int r7 = a0.a;
        if (r4 == null) goto L17;
        r3 = r4.id;
    L17:
        a0.c(r6, 3, r13, r3, new SyncCommerceExplainingToProductDetailPage$doCheckStateChanged$$inlined$let$lambda$1(this, r13, r4), SyncCommerceExplainingToProductDetailPage$doCheckStateChanged$1$2.INSTANCE);
        return;
    L19:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public SyncCommerceExplainingToProductDetailPage(Context r10, ListDialogAbility r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "ability");
        super(s1.B(2131918940), null, ((Boolean) com.bytedance.android.livesdk.sharedpref.b.Q0.getValue()).booleanValue(), false, false, null, 122);
        this.p = r10;
        this.q = false;
        this.r = r11;
        FragmentActivity r12 = ContextUtil.contextToFragmentActivity(r10);
        if (r12 == null) goto L6;
        int r13 = a0.a;
        a0.a(r12, new AnonymousClass1(this), AnonymousClass2.INSTANCE);
        return;
    }

    public final void c(SwitchSettingViewHolder r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r3, "holder");
        ((mx.l) this).l = r4;
        if ((!r4) == false) goto L9;
        Context r5 = this.p;
        c9.b r0 = new c9.b();
        r0.a = r5;
        r0.b = 2;
        r0.c = 2131565759;
        r0.f = r5.getText(2131922827);
        r0.g = 17;
        r0.p = true;
        r0.q = true;
        r0.r = 2131954724;
        a r6 = new a(this, r3);
        r0.j = r0.a.getText(2131915913);
        r0.k = r6;
        b r7 = b.a;
        r0.l = r0.a.getText(2131919682);
        r0.m = r7;
        c9 r8 = new c9(r0.a, r0);
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r8);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L8:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        return;
    L9:
        g(r4);
        if (this.q == false) goto L18;
        f2.b(2131919683, 0);
        return;
    }
}
