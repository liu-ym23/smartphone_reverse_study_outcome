package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/ToolbarAudioCommentBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarAudioCommentBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, Observer<KVData> {
    public DataCenter a;
    public View b;
    public View c;
    public boolean d;
    public DataCenter e;
    public String f;
    public final Lazy g;
    public final Context h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final void a() {
        DataCenter r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r0);
        boolean r2 = false;
        Integer r1 = (Integer) r0.get("data_link_state", 0);
        DataCenter r3 = this.a;
        Intrinsics.checkNotNull(r3);
        Object r4 = r3.get("data_room");
        if ((r4 instanceof Room) == true) goto L8;
        r4 = null;
    L8:
        Room r5 = (Room) r4;
        if (r5 == null) goto L11;
        boolean r6 = r5.isScreenshot();
    L13:
        if (gd0.v.a(r1.intValue(), 8) == true) goto L16;
        if (r6 == true) goto L16;
        r2 = true;
    L16:
        this.d = r2;
        int r7 = 2131250859;
        if (r2 == false) goto L25;
        View r8 = this.c;
        if (r8 == null) goto L36;
        DataCenter r9 = this.a;
        Intrinsics.checkNotNull(r9);
        if (((Boolean) r9.get("data_room_audio_comment_enable", Boolean.TRUE)).booleanValue() == false) goto L23;
        r7 = 2131250858;
    L23:
        r8.setBackgroundResource(r7);
        return;
    L36:
        return;
    L25:
        if (gd0.v.a(r1.intValue(), 8) == false) goto L27;
        this.f = com.bytedance.android.live.core.utils.s1.B(2131915092);
    L29:
        View r10 = this.c;
        if (r10 == null) goto L32;
        r10.setBackgroundResource(2131250859);
    L32:
        View r11 = this.b;
        if (r11 == null) goto L38;
        r11.setAlpha(0.4f);
        return;
    L38:
        return;
    L27:
        if (r6 == false) goto L29;
        this.f = com.bytedance.android.live.core.utils.s1.B(2131915108);
        goto L29
    L11:
        r6 = false;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return !((Boolean) com.bytedance.android.livesdk.sharedpref.b.g0.getValue()).booleanValue();
    }

    public ToolbarAudioCommentBehavior(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.h = r2;
        this.d = true;
        this.f = "";
        this.g = LazyKt.lazy(new ToolbarAudioCommentBehavior$mSettingDialog$2(this));
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4.getKey()) == true) goto L19;
        Object r0 = r4.getData();
        if ((r0 instanceof Object) == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L21;
        String r5 = r4.getKey();
        if (r5.hashCode() == 872172481) goto L15;
        return;
    L15:
        if (r5.equals("data_link_state") == false) goto L20;
        a();
        return;
    L20:
        return;
    L21:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.b.g0;
        Boolean r0 = Boolean.TRUE;
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.e).b(ToolbarButton.MORE, new pp1.j(false));
        if (this.d == false) goto L5;
        com.bytedance.android.livesdk.interactivity.api.anchorsetting.p r6 = (com.bytedance.android.livesdk.interactivity.api.anchorsetting.p) this.g.getValue();
        r6.setDataCenter(this.a);
        r6.a();
        com.bytedance.android.livesdk.log.u.l().d("livesdk_anchor_audio_comment_click", new Object[]{Room.class});
        return;
    L5:
        if (TextUtils.isEmpty(this.f) == false) goto L7;
        com.bytedance.android.live.core.utils.f2.b(2131915096, 0);
        return;
    L7:
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.C(2131915097, new Object[]{this.f}), 0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        r3.removeObserver(this);
        this.a = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.b = r2;
        this.e = r3;
        this.c = r2.findViewById(2131374718);
        this.a = r3.observe("data_link_state", this);
        a();
    }
}
