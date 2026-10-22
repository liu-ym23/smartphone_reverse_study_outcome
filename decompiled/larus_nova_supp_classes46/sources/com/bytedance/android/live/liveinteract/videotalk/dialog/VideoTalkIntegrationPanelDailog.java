package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/VideoTalkIntegrationPanelDailog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoTalkIntegrationPanelDailog extends CommonStandardBottomDialog {

    public static final class a implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ VideoTalkIntegrationPanelDailog a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.dialog.VideoTalkIntegrationPanelDailog$a$a, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC0098a implements DialogInterface.OnClickListener {
            public final /* synthetic */ a a;

            public DialogInterfaceOnClickListenerC0098a(a r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r2, int r3) {
                ((Switch) this.a.a.findViewById(2131387914)).setChecked(false);
                ((FrameLayout) this.a.a.findViewById(2131372864)).setVisibility(4);
                ((FrameLayout) this.a.a.findViewById(2131372798)).setVisibility(4);
                this.a.a.getClass();
                throw null;
            }
        }

        public static final class b implements DialogInterface.OnClickListener {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                this.a.a.getClass();
                throw null;
            }
        }

        public a(VideoTalkIntegrationPanelDailog r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r1, boolean r2) {
            this.a.getClass();
            throw null;
        }
    }

    public static final class b implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ VideoTalkIntegrationPanelDailog a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ b a;
            public final /* synthetic */ Ref.ObjectRef b;
            public final /* synthetic */ boolean c;

            public a(b r1, Ref.ObjectRef r2, boolean r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void accept(Object r3) {
                com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
                ALogger.i("ttlive_link", "videoTalk update_setting " + ((HashMap) this.b.element));
                com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.c.s1;
                Boolean r0 = Boolean.valueOf(this.c);
                r5.getClass();
                com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
                xs2.b.a().post(new jd0.m(this.c));
                TalkRoomLogUtils.j0(((Switch) this.a.a.findViewById(2131387914)).isChecked(), ((Switch) this.a.a.findViewById(2131387923)).isChecked(), this.c);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.dialog.VideoTalkIntegrationPanelDailog$b$b, reason: collision with other inner class name */
        public static final class C0099b<T> implements Consumer {
            public static final C0099b a = null;

            static {
                a = new C0099b();
            }

            public C0099b() {
            }

            public final void accept(Object r1) {
                ((Throwable) r1).printStackTrace();
            }
        }

        public b(VideoTalkIntegrationPanelDailog r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r5, boolean r6) {
            Ref.ObjectRef r7 = new Ref.ObjectRef();
            HashMap r0 = new HashMap();
            r7.element = r0;
            r0.put("scene", 4);
            JSONArray r1 = new JSONArray();
            JSONObject r2 = new JSONObject();
            r2.put("key", 40);
            if (r6 == false) goto L5;
            int r8 = 1;
        L6:
            r2.put("value", r8);
            r1.put(r2);
            ((HashMap) r7.element).put("incremental_update", r1);
            LinkApi r9 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
            this.a.getClass();
            throw null;
        L5:
            r8 = 2;
            goto L6
        }
    }

    public static final class c implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ VideoTalkIntegrationPanelDailog a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ c a;
            public final /* synthetic */ boolean b;

            public a(c r1, boolean r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r4) {
                com.bytedance.android.live.network.response.a r5 = (com.bytedance.android.live.network.response.a) r4;
                com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.c.p1;
                Boolean r0 = Boolean.valueOf(this.b);
                r6.getClass();
                com.bytedance.android.livesdk.sharedpref.f.d(r6, r0);
                TalkRoomLogUtils.j0(((Switch) this.a.a.findViewById(2131387914)).isChecked(), this.b, ((Switch) this.a.a.findViewById(2131387924)).isChecked());
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final void accept(Object r1) {
                ((Throwable) r1).printStackTrace();
            }
        }

        public c(VideoTalkIntegrationPanelDailog r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r6, boolean r7) {
            HashMap r8 = new HashMap();
            int r0 = 1;
            r8.put("scene", 1);
            JSONArray r1 = new JSONArray();
            JSONObject r2 = new JSONObject();
            r2.put("key", 10);
            if (r7 == true) goto L6;
            r0 = 2;
        L6:
            r2.put("value", r0);
            r1.put(r2);
            r8.put("incremental_update", r1);
            r8.put("big_party_accept_need_verified", com.bytedance.android.livesdk.sharedpref.c.t1.getValue());
            r8.put("big_party_only_accept_follower_apply", Boolean.valueOf(r7));
            LinkApi r9 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
            this.a.getClass();
            throw null;
        }
    }

    public final int getLayoutId() {
        return 2131565381;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L18:
        throw null;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L18
    }

    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        ((Switch) findViewById(2131387914)).setChecked(((Boolean) b6.k.getValue()).booleanValue());
        ((Switch) findViewById(2131387924)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue());
        ((Switch) findViewById(2131387923)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.p1.getValue()).booleanValue());
        if (((Switch) findViewById(2131387914)).isChecked() == false) goto L5;
        ((FrameLayout) findViewById(2131372864)).setVisibility(0);
        ((FrameLayout) findViewById(2131372798)).setVisibility(0);
    L6:
        ((Switch) findViewById(2131387914)).setOnCheckedChangeListener(new a(this));
        ((Switch) findViewById(2131387924)).setOnCheckedChangeListener(new b(this));
        ((Switch) findViewById(2131387923)).setOnCheckedChangeListener(new c(this));
        boolean r9 = ((Switch) findViewById(2131387914)).isChecked();
        boolean r1 = ((Switch) findViewById(2131387923)).isChecked();
        boolean r0 = ((Switch) findViewById(2131387924)).isChecked();
        i0 r2 = TalkRoomLogUtils.a;
        LinkedHashMap r3 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r3);
        TalkRoomLogUtils.B0(r3, null, null, 6);
        TalkRoomLogUtils.V0(r3);
        String r4 = "1";
        if (r9 == false) goto L9;
        Object r10 = "1";
    L10:
        r3.put("is_guest_apply_allowed", r10);
        if (r1 == false) goto L13;
        Object r11 = "1";
    L14:
        r3.put("is_fans_only", r11);
        if (r0 == true) goto L18;
        r4 = "0";
    L18:
        r3.put("is_invite_only", r4);
        j0.l().sendLog("livesdk_anchor_link_setting_change_show", r3, new Object[]{IRoom.class});
        return;
    L13:
        r11 = "0";
        goto L14
    L9:
        r10 = "0";
        goto L10
    L5:
        ((FrameLayout) findViewById(2131372864)).setVisibility(4);
        ((FrameLayout) findViewById(2131372798)).setVisibility(4);
        goto L6
    }

    public static final void W0(VideoTalkIntegrationPanelDailog r5, boolean r6) {
        r5.getClass();
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        HashMap r1 = new HashMap();
        r0.element = r1;
        r1.put("scene", 4);
        JSONArray r2 = new JSONArray();
        JSONObject r3 = new JSONObject();
        r3.put("key", 61);
        if (r6 == false) goto L5;
        int r7 = 1;
    L6:
        r3.put("value", r7);
        r2.put(r3);
        ((HashMap) r0.element).put("incremental_update", r2);
        LinkApi r8 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        r5.getClass();
        throw null;
    L5:
        r7 = 2;
        goto L6
    }
}
