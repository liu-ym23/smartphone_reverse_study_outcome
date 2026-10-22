package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.platform.depend.im.IMEmoji;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ ChatChannelGreetingManager a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;
    public final /* synthetic */ IMEmoji d;

    public p(ChatChannelGreetingManager r1, long r2, String r4, IMEmoji r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    public final void accept(Object r14) {
        com.bytedance.android.livesdk.interactivity.api.chatchannel.model.b r15 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.model.b) ((BaseResponse) ((Response) r14)).data;
        s22.a r1 = null;
        if (r15 != null) goto L5;
        com.bytedance.android.livesdk.interactivity.api.monitor.a.d("room_channel_comment", "empty data", null);
    L41:
        this.a.j = false;
        return;
    L5:
        int r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.d.a;
        long r3 = this.b;
        Intrinsics.checkNotNullParameter(r15, "response");
        long r4 = r15.e();
        IBaseUser r6 = r15.h();
        if ((r6 instanceof User) == true) goto L8;
        r6 = null;
    L8:
        User r7 = (User) r6;
        String r8 = r15.d();
        String r9 = r15.a();
        a5 r10 = r15.b();
        if ((r10 instanceof Text) == true) goto L11;
        r10 = null;
    L11:
        int r11 = r15.f();
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.i r13 = new com.bytedance.android.livesdk.interactivity.api.chatchannel.message.i();
        CommonMessageData r16 = new CommonMessageData();
        r16.messageId = r4;
        r16.channelId = r3;
        r16.setDisplayText((Text) r10);
        Unit r5 = Unit.INSTANCE;
        ((BaseMessage) r13).baseMessage = r16;
        r13.user = r7;
        r13.displayName = r8;
        r13.defaultContent = r9;
        r13.showIdentity = r11;
        r13.b = true;
        r13.setHttpSendTime(this.a.k);
        s22.e r17 = ChatChannelUtils.b(this.a.t);
        if (r17 == null) goto L14;
        r17.insertLocalMessage(r13);
    L14:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.d(this.b, BuildConfig.FLAVOR, 0, this.c);
        int r18 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
        if (r17 == null) goto L17;
        r1 = r17.getChannel(this.b);
    L17:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.b(r1, "IMEmoji", String.valueOf(r15.e()), this.a.k);
        int r19 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.a;
        long r20 = this.d.getId();
        s22.e r110 = ChatChannelUtils.b(this.a.t);
        if (r110 == null) goto L22;
        s22.a r111 = r110.getChannel(this.b);
        if (r111 == null) goto L22;
        long r21 = r111.y();
    L23:
        s22.e r112 = ChatChannelUtils.b(this.a.t);
        if (r112 == null) goto L32;
        s22.a r113 = r112.getChannel(this.b);
        if (r113 == null) goto L32;
        PropertyOwner r114 = r113.v();
        if (r114 == null) goto L32;
        if (((Boolean) r114.a).booleanValue() != true) goto L32;
        boolean r23 = true;
    L33:
        String r115 = String.valueOf(this.b);
        s22.e r116 = ChatChannelUtils.b(this.a.t);
        if (r116 == null) goto L39;
        s22.a r117 = r116.getChannel(this.b);
        if (r117 == null) goto L39;
        String r118 = String.valueOf(r117.f());
        if (r118 == null) goto L39;
    L40:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.k(BuildConfig.FLAVOR, "emoji", r20, r21, r23, r115, r118, null);
    L39:
        r118 = BuildConfig.FLAVOR;
    L32:
        r23 = false;
    L22:
        r21 = 0;
        goto L23
    }
}
