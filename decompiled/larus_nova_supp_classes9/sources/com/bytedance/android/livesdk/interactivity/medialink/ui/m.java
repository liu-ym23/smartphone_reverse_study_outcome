package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkMicIdInfo;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.config.ga1;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.MediaMuteCheckDialogFragment;
import com.bytedance.android.livesdk.interactivity.medialink.network.LinkCrossRoomApi;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements b {
    public final CompositeDisposable a;
    public final List<n> b;
    public MediaMuteCheckDialogFragment c;
    public final HashSet<String> d;
    public final boolean e;
    public gy.f f;
    public hy.e g;
    public IRoom h;
    public Context i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ m a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public a(m r1, String r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            MediaMuteCheckDialogFragment r5 = this.a.c;
            if (r5 != null) goto L12;
        L10:
            this.a.c(this.b, this.c, r.b.a);
            return;
        L12:
            r5.dismiss();     // Catch: Exception -> L6
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L10;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L10
        }
    }

    public final void b(n r2) {
        Intrinsics.checkNotNullParameter(r2, "listenerMedia");
        if (((ArrayList) this.b).contains(r2) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.b).add(r2);
    }

    public final void f(n r2) {
        Intrinsics.checkNotNullParameter(r2, "listenerMedia");
        ((ArrayList) this.b).remove(r2);
    }

    public final AnchorLinkUser d(String r5, String r6) {
        hy.e r0 = this.g;
        if (r0 == null) goto L21;
        List r1 = r0.getOnlineUserList();
        if (r1 == null) goto L21;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L16;
        Object r3 = r2.next();
        IBaseUser r4 = ((AnchorLinkUser) r3).getUser();
        if (r4 == null) goto L12;
        String r7 = r4.getIdString();
    L14:
        if (Intrinsics.areEqual(r7, r5) == false) goto L8;
    L17:
        AnchorLinkUser r8 = (AnchorLinkUser) r3;
        if (r8 == null) goto L21;
        return r8;
    L12:
        r7 = null;
        goto L14
    L16:
        r3 = null;
    L21:
        hy.e r9 = this.g;
        if (r9 != null) goto L24;
        return null;
    L24:
        return r9.f(r6, true);
    }

    public final boolean e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        AnchorLinkUser r4 = d(r2, r3);
        gy.f r5 = this.f;
        if (r5 == null) goto L13;
        nc0.s r6 = r5.L();
        if (r6 == null) goto L13;
        if (r4 == null) goto L9;
        String r7 = r4.getInteractId();
        if (r7 == null) goto L9;
    L10:
        nc0.r r8 = r6.e(r7);
        if (r8 == null) goto L13;
        return r8.a.g;
    L9:
        r7 = BuildConfig.FLAVOR;
    L13:
        return false;
    }

    public final void c(String r11, boolean r13, r.b r14) {
        if (e(r11, null) != r13) goto L5;
        return;
    L5:
        AnchorLinkUser r15 = d(r11, null);
        if (r15 == null) goto L9;
        String r1 = r15.getInteractId();
        if (r1 == null) goto L9;
    L10:
        if (r15 == null) goto L15;
        IBaseUser r2 = r15.getUser();
        if (r2 == null) goto L15;
        String r3 = r2.getIdString();
        if (r3 == null) goto L15;
    L16:
        String r7 = r3;
        IRoom r4 = this.h;
        if (r4 == null) goto L19;
        long r5 = r4.getRoomId();
    L20:
        long r6 = r5;
        gy.f r8 = this.f;
        if (r8 == null) goto L23;
        r8.h(r1, r13, BuildConfig.FLAVOR);
    L23:
        if (r13 == false) goto L25;
        this.d.add(r1);
    L27:
        if (this.e == false) goto L44;
        if (r15 == null) goto L44;
        AnchorLinkMicIdInfo r16 = r15.getAnchorLinkMicIdInfo();
        if (r16 == null) goto L44;
        if (Intrinsics.areEqual(r1, r16.mainLinkMicId) == false) goto L37;
        gy.f r0 = this.f;
        if (r0 == null) goto L37;
        r0.h(r16.backupLinkMicId, r13, "syncMainToBack");
    L37:
        if (Intrinsics.areEqual(r1, r16.backupLinkMicId) == false) goto L41;
        gy.f r9 = this.f;
        if (r9 == null) goto L41;
        r9.h(r16.mainLinkMicId, r13, "syncBackToMain");
    L41:
        if (r13 == false) goto L43;
        this.d.add(r16.mainLinkMicId);
        this.d.add(r16.backupLinkMicId);
        goto L44
    L43:
        this.d.remove(r16.mainLinkMicId);
        this.d.remove(r16.backupLinkMicId);
    L44:
        Iterator r17 = ((ArrayList) this.b).iterator();
    L46:
        if (r17.hasNext() == false) goto L48;
        ((n) r17.next()).b(r7, r13, r14);
        goto L46
    L48:
        if (r13 == false) goto L52;
        RxUtilKt.c(((LinkCrossRoomApi) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApi.class)).mute(r6, 17, r7, MediaMultiAnchorLinkContext.Companion.a()).compose(RxUtil.rxSchedulerHelper()).subscribe(k.a, l.a), this.a);
        return;
    L52:
        return;
    L25:
        this.d.remove(r1);
        goto L27
    L19:
        r5 = 0;
    L15:
        r3 = "0";
    L9:
        r1 = BuildConfig.FLAVOR;
        goto L10
    }

    public m(gy.f r1, hy.e r2, Room r3, Context r4) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.a = new CompositeDisposable();
        this.b = new ArrayList();
        this.d = new HashSet();
        this.e = !((Boolean) ga1.a.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.b
    public final void a(String r2, String r3, boolean r4, r r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r5, "source");
        if (r4 == true) goto L5;
    L40:
        c(r2, r4, r.b.a);
        return;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.c0.getValue()).booleanValue() == false) goto L40;
        if (r6 == true) goto L40;
        MediaMuteCheckDialogFragment r7 = this.c;
        if (r7 != null) goto L10;
    L19:
        MediaMuteCheckDialogFragment r8 = new MediaMuteCheckDialogFragment();
        this.c = r8;
        r8.k = new a(this, r2, r4);
        AnchorLinkUser r9 = d(r2, r3);
        MediaMuteCheckDialogFragment r10 = this.c;
        if (r10 == null) goto L28;
        if (r9 == null) goto L26;
        IBaseUser r11 = r9.getUser();
        if (r11 == null) goto L26;
        String r13 = r11.getNickName();
        if (r13 == null) goto L26;
    L27:
        r10.j = r13;
    L26:
        r13 = BuildConfig.FLAVOR;
    L28:
        FragmentActivity r14 = ContextUtil.contextToFragmentActivity(this.i);
        if (r14 == null) goto L47;
        FragmentManager r15 = r14.getSupportFragmentManager();
        if (r15 == null) goto L48;
        MediaMuteCheckDialogFragment r16 = this.c;
        if (r16 == null) goto L49;
        LandscapeRestrictionOperation r17 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r16, BuildConfig.FLAVOR, r17);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r16, r17) == true) goto L50;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
    L38:
        r16.show(r15, BuildConfig.FLAVOR);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L10:
        if (r7.isShowing() != true) goto L19;
        MediaMuteCheckDialogFragment r18 = this.c;
        if (r18 == null) goto L19;
        r18.dismiss();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r19 = DialogFragmentLancet.sLastShowStack;
        if (r19 == null) goto L19;
        com.bytedance.crash.d.d(r19, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L19
    }
}
