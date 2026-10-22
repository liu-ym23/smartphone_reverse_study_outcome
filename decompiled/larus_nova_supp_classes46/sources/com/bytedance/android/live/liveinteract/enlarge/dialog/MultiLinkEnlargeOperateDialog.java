package com.bytedance.android.live.liveinteract.enlarge.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.livesdk.chatroom.interact.model.e0;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/dialog/MultiLinkEnlargeOperateDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkEnlargeOperateDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int D = 0;
    public long B;
    public String C;

    public static final class a {
        public static MultiLinkEnlargeOperateDialog a(Context r1, long r2, String r4) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r4, "targetUserId");
            MultiLinkEnlargeOperateDialog r0 = new MultiLinkEnlargeOperateDialog(r1);
            r0.B = r2;
            r0.C = r4;
            return r0;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565650;
    }

    public MultiLinkEnlargeOperateDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false);
        this.C = "";
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        ((TextView) findViewById(2131381550)).setOnClickListener(x0.a(new MultiLinkEnlargeOperateDialog$initView$1(this)));
        ((TextView) findViewById(2131381543)).setOnClickListener(x0.a(new MultiLinkEnlargeOperateDialog$initView$2(this)));
        ((TextView) findViewById(2131381549)).setOnClickListener(x0.a(new MultiLinkEnlargeOperateDialog$initView$3(this)));
        int r1 = ((IInteractService) k.n(IInteractService.class)).getAnchorManualUiLayout();
        m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L15;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L15;
        if (r3.isLiveTypeAudio() != true) goto L15;
        if (Intrinsics.areEqual(this.C, je0.d.a()) == false) goto L15;
        if (CPositionContext.Companion.d() != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Single.ordinal()) goto L15;
        if (e0.b(r1) == false) goto L15;
        ((TextView) findViewById(2131381550)).setVisibility(8);
    L15:
        Integer r7 = je0.d.h();
        if (r7 != null) goto L19;
        return;
    L19:
        if (r7.intValue() != 26) goto L26;
        CPositionContext.a r8 = CPositionContext.Companion;
        if (r8.d() == EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L23;
        return;
    L23:
        if (r8.e().size() != 1) goto L28;
        ((TextView) findViewById(2131381543)).setText(s1.B(2131916179));
        return;
    L28:
        return;
    }

    public static final void W0(MultiLinkEnlargeOperateDialog r7, long r8, String r10, long r11, String r13) {
        r7.getClass();
        if (je0.d.D() == false) goto L14;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L9;
        rj0.k r0 = rj0.k.a.a();
        if (r0 == null) goto L25;
        rj0.k.b.g(r0, r8, r10, r11, r13);
        return;
    L25:
        return;
    L9:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L27;
        com.bytedance.android.live.liveinteract.voicechat.d r1 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r1 == null) goto L28;
        r1.updateMultiEnlargePosition(r8, r10, r11, r13);
        return;
    L28:
        return;
    L27:
        return;
    L14:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L19;
        com.bytedance.android.live.liveinteract.plantform.base.k r2 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r2 == null) goto L30;
        r2.updateMultiEnlargePosition(r8, r10, r11, r13);
        return;
    L30:
        return;
    L19:
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() == null) goto L32;
        IVoiceChatAdminService r3 = IVoiceChatAdminService.a.a();
        if (r3 == null) goto L33;
        r3.updateMultiEnlargePosition(r8, r10, r11, r13);
        return;
    L33:
        return;
    }
}
