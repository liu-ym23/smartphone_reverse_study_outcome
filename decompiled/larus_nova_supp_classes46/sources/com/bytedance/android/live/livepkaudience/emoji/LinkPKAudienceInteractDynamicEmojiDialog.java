package com.bytedance.android.live.livepkaudience.emoji;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.livepkaudience.emoji.panel.LinkPKAudienceInteractPanelItemAdapter;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.config.w7;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/LinkPKAudienceInteractDynamicEmojiDialog;", "Lcom/bytedance/android/live/livepkaudience/emoji/BaseAudienceInteractDynamicEmojiDialog;", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPKAudienceInteractDynamicEmojiDialog extends BaseAudienceInteractDynamicEmojiDialog {
    public static final /* synthetic */ int D = 0;
    public com.bytedance.android.live.livepkaudience.emoji.panel.l B;
    public com.bytedance.android.live.livepkaudience.emoji.panel.a C;

    public static final class a {
        public a() {
        }

        public static LinkPKAudienceInteractDynamicEmojiDialog a(Context r3, DataCenter r4) {
            int r0 = LinkPKAudienceInteractDynamicEmojiDialog.D;
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "dataCenter");
            Intrinsics.checkNotNullParameter("seat", "requestPage");
            ALogger.i("LinkPKAudienceInteractDynamicEmojiDialog", "new instance link pk audience from seat");
            LinkPKAudienceInteractDynamicEmojiDialog r1 = new LinkPKAudienceInteractDynamicEmojiDialog(r3, r4, true);
            Intrinsics.checkNotNullParameter("seat", "<set-?>");
            r1.t = "seat";
            return r1;
        }
    }

    public static final class b implements com.bytedance.android.live.livepkaudience.vm.a {
        public final /* synthetic */ LinkPKAudienceInteractDynamicEmojiDialog a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        @Override // com.bytedance.android.live.livepkaudience.vm.a
        public final void onSuccess() {
            LinkPKAudienceInteractDynamicEmojiDialog r0 = this.a;
            r0.getClass();
            BaseAudienceInteractDynamicEmojiDialog.M0(r0);
            String r1 = "switchCamera onSuccess openCamera : " + this.b + ", skipShowBeauty: " + this.c;
            ALogger.e("LinkPKAudienceInteractDynamicEmojiDialog", r1);
            dl0.m.a.getClass();
            dl0.m.C("LinkPKAudienceInteractDynamicEmojiDialog_switchCamera", r1);
            if (this.b == false) goto L5;
            this.a.getClass();
            HashMap r2 = new HashMap();
            r2.put("user_type", "guest");
            r2.put("filp_status", "before");
            r2.put("scene_type", "normal");
            el0.j.k(r2);
            el0.j.m(r2);
            el0.j.n(r2, 1);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_audience_connection_user_camera_open_success", r2, new Object[]{am2.x.class, Room.class});
        L7:
            if (this.b == false) goto L9;
            return;
        L9:
            if (this.c == false) goto L17;
            LinkPKAudienceInteractDynamicEmojiDialog r3 = this.a;
            r3.getClass();
            com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
            com.bytedance.android.live.livepkaudience.service.d r4 = com.bytedance.android.live.livepkaudience.service.d.a.a();
            if (r4 == null) goto L13;
            m00.g r5 = r4.go();
        L14:
            n r6 = new n(r3, r5);
            LivePluginSPIManager.e.getClass();
            LivePluginSPIManager.a().addOnSuccess(new m(r3, r6)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
            return;
        L13:
            r5 = null;
            goto L14
        L17:
            return;
        L5:
            cl0.a r7 = cl0.a.d;
            LinkedHashMap r8 = new LinkedHashMap();
            com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
            com.bytedance.android.live.core.privacy.av.api.b.a.a r9 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
            com.bytedance.android.live.core.privacy.av.api.a r10 = com.bytedance.android.live.core.privacy.av.api.a.b;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r8, "params");
            Intrinsics.checkNotNullParameter(r9, "callback");
            Intrinsics.checkNotNullParameter(r10, "config");
            r7.e("close_camera_by_self", r8, r9, r10);
            goto L7
        }

        @Override // com.bytedance.android.live.livepkaudience.vm.a
        public final void onError(String r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            LinkPKAudienceInteractDynamicEmojiDialog r3 = this.a;
            r3.getClass();
            BaseAudienceInteractDynamicEmojiDialog.M0(r3);
        }

        public b(LinkPKAudienceInteractDynamicEmojiDialog r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        new a();
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog
    public final boolean Q0() {
        return true;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog
    public final int R0() {
        return 1;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog
    public final void P0() {
        if (this.m == false) goto L6;
        return;
    L6:
        if (this.n == false) goto L8;
        com.bytedance.android.live.livepkaudience.emoji.panel.g r0 = new com.bytedance.android.live.livepkaudience.emoji.panel.n(this);
    L9:
        this.v = r0;
        ((ArrayList) this.u).add(r0);
        return;
    L8:
        r0 = new com.bytedance.android.live.livepkaudience.emoji.panel.k(this);
        goto L9
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog
    public final void T0() {
        o r0 = new o(this.m, this.y);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.g = r0;
        ((q46.b) r0).a = this;
        d r1 = this.g;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L5:
        if (r1 == null) goto L9;
        o r2 = (o) r1;
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.emoji.LinkPKAudienceInteractDynamicEmojiPresenter");
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog
    public final void U0() {
        String r0 = this.t;
        int r1 = r0.hashCode();
        if (r1 != (-1383228885)) goto L5;
        r0.equals("bottom");
    L9:
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r2 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r2 == null) goto L12;
        com.bytedance.android.live.livepkaudience.service.d.b.b(r2);
    L12:
        int r3 = al0.c.b;
        String r4 = tc0.c.h().G;
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        al0.c.c(r4);
        return;
    L5:
        if (r1 != 3526149) goto L9;
        r0.equals("seat");
        goto L9
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog, com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void w5() {
        LifecycleOwner r0 = this.y.lifecycleOwner;
        boolean r1 = r0 instanceof Fragment;
        Context r2 = null;
        if (r1 == false) goto L15;
        if (r1 == true) goto L6;
        r0 = null;
    L6:
        Fragment r3 = (Fragment) r0;
        if (r3 == null) goto L9;
        Context r4 = r3.getContext();
    L11:
        if ((r4 instanceof FragmentActivity) == false) goto L14;
        r2 = r4;
    L14:
        r2 = (FragmentActivity) r2;
    L20:
        if (r2 != null) goto L23;
        ALogger.e("LinkPKAudienceInteractDynamicEmojiDialog", "fragmentActivity is null context:" + this.y.lifecycleOwner.getClass());
        return;
    L23:
        BaseAudienceInteractDynamicEmojiDialog.M0(this);
        z5(2, true);
        return;
    L9:
        r4 = null;
        goto L11
    L15:
        boolean r5 = r0 instanceof FragmentActivity;
        if (r5 == false) goto L20;
        if (r5 == true) goto L19;
        r0 = null;
    L19:
        r2 = (FragmentActivity) r0;
        goto L20
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog
    public final void O0() {
        if (hd0.c.f().h() == false) goto L41;
        boolean r0 = this.m;
        int r1 = dl0.t.a;
        ArrayList r2 = new ArrayList();
        if (r0 == false) goto L7;
        r2.add(1);
    L13:
        if (r2.size() <= 1) goto L42;
        com.bytedance.android.live.livepkaudience.emoji.panel.b r3 = new com.bytedance.android.live.livepkaudience.emoji.panel.b(this, new com.bytedance.android.live.livepkaudience.emoji.panel.c(CollectionsKt.toIntArray(r2), this.o));
        ListProtector.add(this.u, 0, r3);
        int r4 = this.o;
        com.bytedance.android.live.livepkaudience.emoji.panel.c r5 = r3.b;
        if (r5 == null) goto L40;
        r5.b = r4;
        com.bytedance.android.live.livepkaudience.emoji.panel.l r6 = this.B;
        if (r6 == null) goto L19;
        ((ArrayList) this.u).remove(r6);
    L19:
        com.bytedance.android.live.livepkaudience.emoji.panel.a r7 = this.C;
        if (r7 == null) goto L22;
        ((ArrayList) this.u).remove(r7);
    L22:
        if (r4 == 1) goto L25;
    L36:
        LinkPKAudienceInteractPanelItemAdapter r8 = this.e;
        if (r8 == null) goto L43;
        r8.notifyDataSetChanged();
        return;
    L43:
        return;
    L25:
        if (this.m == true) goto L36;
        if (this.B != null) goto L30;
        this.B = new com.bytedance.android.live.livepkaudience.emoji.panel.l(this);
    L30:
        if (this.C != null) goto L32;
        this.C = new com.bytedance.android.live.livepkaudience.emoji.panel.a(this);
    L32:
        com.bytedance.android.live.livepkaudience.emoji.panel.g r9 = this.v;
        com.bytedance.android.live.livepkaudience.emoji.panel.g r10 = r3;
        if (r9 == null) goto L35;
        r10 = r9;
    L35:
        int r11 = CollectionsKt.indexOf(this.u, r10);
        List<com.bytedance.android.live.livepkaudience.emoji.panel.g> r12 = this.u;
        int r13 = r11 + 1;
        com.bytedance.android.live.livepkaudience.emoji.panel.a r14 = this.C;
        Intrinsics.checkNotNull(r14);
        ListProtector.add(r12, r13, r14);
        List<com.bytedance.android.live.livepkaudience.emoji.panel.g> r15 = this.u;
        com.bytedance.android.live.livepkaudience.emoji.panel.l r16 = this.B;
        Intrinsics.checkNotNull(r16);
        ListProtector.add(r15, r13, r16);
        goto L36
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.emoji.panel.DigitShowModeData");
    L42:
        return;
    L7:
        r2.add(2);
        if (((Boolean) w7.a.getValue()).booleanValue() == false) goto L13;
        if (((Boolean) b6.h.getValue()).booleanValue() == false) goto L13;
        r2.add(1);
        goto L13
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog, com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void x5(boolean r10, boolean r11) {
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r1 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r1 == null) goto L6;
        r1.f(r10, false, false, false, r11, false, new b(this, r10, r11));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseAudienceInteractDynamicEmojiDialog, com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void z5(int r5, boolean r6) {
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r0 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        boolean r1 = true;
        if (r0 == null) goto L11;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r2 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r2 == null) goto L7;
        String r3 = r2.getAudienceSelfLinkMicId();
    L9:
        if (r0.d(r3) != true) goto L11;
        int r4 = 1;
    L12:
        this.o = r4;
        String r7 = "switchShowMode selectMode: " + r5 + ", videoMode: " + r4;
        ALogger.e("LinkPKAudienceInteractDynamicEmojiDialog", r7);
        dl0.m.a.getClass();
        dl0.m.C("LinkPKAudienceInteractDynamicEmojiDialog_switchShowMode", r7);
        if (r4 != r5) goto L15;
    L33:
        Handler r8 = DialogLancet.resolveDialogHandler(this);
        if (r8 != null) goto L36;
    L38:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L41 Exception -> L43
    L47:
        DialogLancet.afterDialogDismiss(this);
        return;
    L41:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L43:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L41
        Throwable r9 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L41
        if (r9 == null) goto L47;
        com.bytedance.crash.d.d(r9, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L41
        goto L47
    L36:
        if (Looper.myLooper() == r8.getLooper()) goto L38;
        r8.post(DialogLancet.createDismissRunnable(this));
        return;
    L15:
        if (r5 == 1) goto L17;
    L29:
        if (r5 == 1) goto L32;
        r1 = false;
    L32:
        x5(r1, r6);
        goto L33
    L17:
        if (this.m == true) goto L29;
        com.bytedance.android.live.livepkaudience.vm.c r10 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r10 == null) goto L29;
        if (r10.a() == true) goto L29;
        com.bytedance.android.live.livepkaudience.vm.c r11 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r11 != null) goto L25;
    L27:
        f2.b(2131917478, 0);
        return;
    L25:
        if (r11.e() != true) goto L27;
        f2.b(2131917582, 0);
        return;
    L7:
        r3 = null;
    L11:
        r4 = 2;
        goto L12
    }

    public LinkPKAudienceInteractDynamicEmojiDialog(Context r2, DataCenter r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3, r4);
    }
}
