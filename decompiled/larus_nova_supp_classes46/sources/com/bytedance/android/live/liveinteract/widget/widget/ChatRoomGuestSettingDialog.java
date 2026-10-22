package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.h1;
import com.bytedance.android.livesdk.chatroom.model.i1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/ChatRoomGuestSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatRoomGuestSettingDialog extends CommonBottomDialog {
    public static final /* synthetic */ int f = 0;
    public final CompositeDisposable a;
    public final DataCenter b;
    public final boolean c;
    public final String d;
    public final int e;

    public static final class a {
        public static void a() {
            LinkedHashMap r0 = new LinkedHashMap();
            int r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
            TalkRoomLogUtils.B0(r0, Integer.valueOf(r1), null, 4);
            TalkRoomLogUtils.I0(r0, r1);
            j0.l().sendLog("livesdk_link_setting_click", r0, new Object[]{IRoom.class, am2.x.class});
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ChatRoomGuestSettingDialog a;

        public b(ChatRoomGuestSettingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            h1 r5 = (h1) ((com.bytedance.android.live.network.response.e) r4).data;
            if (r5 == null) goto L21;
            List r6 = r5.getSettings();
            if (r6 == null) goto L35;
            Iterator<T> r7 = r6.iterator();
        L8:
            if (r7.hasNext() == false) goto L36;
            ILinkmicAudienceSetting r0 = (ILinkmicAudienceSetting) r7.next();
            Integer r1 = r0.getKey();
            int r2 = ILinkmicAudienceSetting.LinkmicAudienceSettingKey.ENABLE_DELEGATED_TO_FRIENDS.getValue();
            if (r1 == null) goto L8;
            if (r1.intValue() != r2) goto L8;
            com.bytedance.android.live.liveinteract.voicechat.util.d.a.getClass();
            if (com.bytedance.android.live.liveinteract.voicechat.util.d.a.a() != 1) goto L8;
            i1 r3 = r0.getValue();
            if (r3 == null) goto L8;
            String r8 = r3.getExtra();
            if (r8 == null) goto L8;
            ((TextView) this.a.findViewById(2131391601)).setText(r8);
            goto L8
        L36:
            return;
        L35:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            r3.printStackTrace();
            ALogger.e("ChatRoomGuestSettingDialog", "onCreate getAudienceSettings error");
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565420;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CompositeDisposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void M0(int r3) {
        if (r3 != ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.getValue()) goto L6;
        ((TextView) findViewById(2131390873)).setText(s1.B(2131919502));
        return;
    L6:
        if (r3 != ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_DELEGATED_TO_EVERYONE.getValue()) goto L9;
        ((TextView) findViewById(2131390873)).setText(s1.B(2131919501));
        return;
    L9:
        if (r3 != ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.getValue()) goto L14;
        ((TextView) findViewById(2131390873)).setText(s1.B(2131919504));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        int r11 = c1.a;
        c1.b(getWindow(), 0, 14);
        setCanceledOnTouchOutside(true);
        com.bytedance.android.live.liveinteract.voicechat.util.d.a.getClass();
        int r0 = com.bytedance.android.live.liveinteract.voicechat.util.d.a.a();
        if (r0 == 1) goto L7;
        if (r0 != 2) goto L8;
        ((LinearLayout) findViewById(2131378735)).setVisibility(0);
        findViewById(2131382393).setVisibility(0);
        ((TextView) findViewById(2131390874)).setText(s1.B(2131915779));
        ((TextView) findViewById(2131391601)).setVisibility(8);
        ((Switch) findViewById(2131387897)).setVisibility(8);
        M0(((ILinkmicAudienceSetting.LinkmicSettingStatus) b6.r.getValue()).getValue());
    L8:
        ((ImageView) findViewById(2131376031)).setOnClickListener(new com.bytedance.android.live.liveinteract.widget.widget.b(this));
        int r1 = com.bytedance.android.live.liveinteract.voicechat.util.d.a.a();
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L14;
        findViewById(2131368306).setOnClickListener(new com.bytedance.android.live.liveinteract.widget.widget.c(this));
    L14:
        JSONArray r12 = new JSONArray();
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L17;
        IRoom r3 = (IRoom) r2.getValue();
    L18:
        LinkAudienceApi r4 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        String r13 = r12.toString();
        if (r3 == null) goto L21;
        long r5 = r3.getId();
    L22:
        Disposable r14 = r4.getAudienceSettings(r13, r5).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), c.a);
        this.a.add(r14);
        return;
    L21:
        r5 = 0;
        goto L22
    L17:
        r3 = null;
        goto L18
    L13:
        ((Switch) findViewById(2131387897)).setOnCheckedChangeListener(new d(this));
        goto L14
    L7:
        ((TextView) findViewById(2131391601)).setVisibility(0);
        ((TextView) findViewById(2131390874)).setText(s1.B(2131915777));
        ((Switch) findViewById(2131387897)).setVisibility(0);
        ((Switch) findViewById(2131387897)).setChecked(((Boolean) b6.q.getValue()).booleanValue());
        ((LinearLayout) findViewById(2131378735)).setVisibility(8);
        findViewById(2131382393).setVisibility(8);
        goto L8
    }

    public ChatRoomGuestSettingDialog(Context r2, DataCenter r3, boolean r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        super(r2);
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.a = new CompositeDisposable();
    }
}
