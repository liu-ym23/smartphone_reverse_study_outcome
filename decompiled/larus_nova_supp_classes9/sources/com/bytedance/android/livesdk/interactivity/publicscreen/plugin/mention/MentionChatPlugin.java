package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.mention;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$InterceptorType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.h;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.n;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import u42.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MentionChatPlugin extends x {
    public c b;
    public final Lazy c;
    public e52.a d;
    public final boolean e;
    public final a f;
    public final DataCenter g;

    public static final class a implements h {
        public final PublicScreenConfig$InterceptorType a;
        public final /* synthetic */ MentionChatPlugin b;

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.h
        public final void a(i r2) {
            Intrinsics.checkNotNullParameter(r2, "model");
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.h
        public final void d(i r2) {
            Intrinsics.checkNotNullParameter(r2, "model");
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.h
        public PublicScreenConfig$InterceptorType getType() {
            return this.a;
        }

        public a(MentionChatPlugin r1) {
            this.b = r1;
            this.a = PublicScreenConfig$InterceptorType.MentionChat;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.h
        public final boolean c(f<?> r2) {
            return MentionChatPlugin.r(this.b, r2);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.h
        public final boolean b(f<?> r8, ShowArea r9) {
            Intrinsics.checkNotNullParameter(r9, "showArea");
            c r0 = this.b.b;
            if (r0 != null) goto L6;
            return false;
        L6:
            if (r9 != ShowArea.Fold) goto L8;
        L47:
            return false;
        L8:
            if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.h.b(r8) == false) goto L47;
            if (MentionChatPlugin.r(this.b, r8) == false) goto L13;
            return true;
        L13:
            Lazy r10 = PublicScreenABHelper.a;
            if (this.b.e == false) goto L16;
            Integer r11 = (Integer) PublicScreenABHelper.O.getValue();
        L17:
            int r13 = r11.intValue();
            if (r13 == 1) goto L25;
            if (r13 != 2) goto L26;
            e52.a r14 = this.b.d;
            if (r14 == null) goto L26;
            boolean r15 = r0.a(new com.bytedance.android.livesdk.interactivity.publicscreen.pin.a(r8, r14));
        L27:
            this.b.getClass();
            IBaseUser r16 = r8.x();
            String r1 = BuildConfig.FLAVOR;
            if (r16 == null) goto L31;
            String r17 = r16.getIdString();
            if (r17 == null) goto L31;
        L32:
            IMiddlewareUserService r4 = k.f(IMiddlewareUserService.class);
            if (r4 == null) goto L42;
            e r5 = r4.user();
            if (r5 == null) goto L42;
            IBaseUser r6 = r5.b();
            if (r6 == null) goto L42;
            String r7 = r6.getIdString();
            if (r7 == null) goto L42;
            r1 = r7;
        L42:
            if (r15 == false) goto L44;
            String r18 = "suspend";
        L45:
            LinkedHashMap r19 = new LinkedHashMap();
            r19.put("mention_user_id", r17);
            r19.put("to_user_id", r1);
            r19.put("message_style", r18);
            j0.l().sendLog("livesdk_audience_mentioned_message", r19, new Object[]{IRoom.class, am2.x.class});
            return r15;
        L44:
            r18 = "normal";
        L31:
            r17 = BuildConfig.FLAVOR;
        L26:
            r15 = false;
            goto L27
        L25:
            this.b.g.put("data_mention_message_show_in_public_screen", Unit.INSTANCE);
            goto L26
        L16:
            r11 = (Integer) PublicScreenABHelper.N.getValue();
            goto L17
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
    }

    public MentionChatPlugin(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.g = r4;
        this.c = LazyKt.lazy(MentionChatPlugin$repeatHistoryMentionChatIds$2.INSTANCE);
        Boolean r0 = Boolean.FALSE;
        if (r4 == null) goto L13;
        Object r2 = null;
        Object r5 = r4.get("data_is_anchor", null);
        if ((r5 instanceof Boolean) == false) goto L9;
        r2 = r5;
    L9:
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L13;
        r0 = r3;
    L13:
        this.e = r0.booleanValue();
        this.f = new a(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(l r4) {
        Intrinsics.checkNotNullParameter(r4, "publicScreenContext");
        if ((r4 instanceof PublicScreenContext) == true) goto L5;
        l r0 = null;
    L6:
        PublicScreenContext r1 = (PublicScreenContext) r0;
        if (r1 == null) goto L9;
        r1.getPinManager().c(new MentionChatPlugin$onLoad$$inlined$apply$lambda$1(this));
        r1.getConfig().c(new MentionChatPlugin$onLoad$$inlined$apply$lambda$2(this));
    L9:
        this.d = r4.getTextConfig();
        PublicScreenConfig$InterceptorType r2 = PublicScreenConfig$InterceptorType.MentionChat;
        a r3 = this.f;
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "interceptor");
        n r5 = this.a;
        if (r5 == null) goto L12;
        r5.addMessageInterceptor(r2, r3);
    L12:
        r4.getHistoryMentionChat().c(new MentionChatPlugin$onLoad$2(this));
        return;
    L5:
        r0 = r4;
        goto L6
    }

    public static final boolean r(MentionChatPlugin r4, f r5) {
        r4.getClass();
        T r0 = r5.b;
        if (r0 != 0) goto L6;
    L7:
        return true;
    L6:
        if (((Set) r4.c.getValue()).contains(Long.valueOf(r0.getMessageId())) == true) goto L7;
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.h.b(r5) == false) goto L11;
        ((Set) r4.c.getValue()).add(Long.valueOf(r0.getMessageId()));
    L11:
        return false;
    }
}
