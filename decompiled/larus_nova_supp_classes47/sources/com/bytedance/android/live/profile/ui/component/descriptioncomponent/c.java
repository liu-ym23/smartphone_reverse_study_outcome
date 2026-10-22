package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.LiveAgentInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends com.bytedance.android.live.profile.ui.base.k {
    public View b;
    public TextView c;
    public HSImageView d;
    public final com.bytedance.android.live.profile.ui.base.h e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LiveAgentInfo a;
        public final /* synthetic */ c b;

        public b(LiveAgentInfo r1, c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            String r8 = this.a.getSchema();
            if (r8 != null) goto L5;
            return;
        L5:
            if (r8.length() <= 0) goto L7;
            boolean r0 = true;
        L8:
            Context r3 = null;
            if (r0 == true) goto L12;
            r8 = null;
        L12:
            if (r8 == null) goto L29;
            com.bytedance.android.live.profile.ui.base.d r1 = this.b.a;
            if (r1 == null) goto L16;
            r3 = r1.getContext();
        L16:
            Activity r2 = ContextUtil.contextToActivity(r3);
            if (r2 == null) goto L30;
            Pair[] r4 = new Pair[2];
            if (this.a.opened() == false) goto L22;
            String r5 = "2";
        L23:
            r4[0] = TuplesKt.to("room_avatar_status", r5);
            r4[1] = TuplesKt.to("click_position", "avatar_image");
            this.b.e.recordBusinessClick("room_avatar_status", MapsKt.mutableMapOf(r4));
            IBaseLiveActionHandler r6 = jc1.k.f(IBaseLiveActionHandler.class);
            if (r6 == null) goto L26;
            r6.handle(r2, r8);
        L26:
            this.b.e.dismiss();
            return;
        L22:
            r5 = DataType.FALSE;
            goto L23
        L30:
            return;
        L29:
            return;
        L7:
            r0 = false;
            goto L8
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.AnchorImageEntry.INSTANCE;
    }

    public c(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.e = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r3) {
        if (((com.bytedance.android.live.profile.ui.base.e) r3).f(2131567171, true) == null) goto L6;
        this.b = i(2131383187);
        this.d = i(2131383186);
        this.c = (TextView) i(2131383185);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        ALogger.i("ProfileAnchorImageEntryComponent", "profile anchor image entry bindData:" + r4.liveAgentInfo);
        LiveAgentInfo r5 = r4.liveAgentInfo;
        if (r5 == null) goto L55;
        String r0 = r5.getContent();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L15;
        TextView r2 = this.c;
        if (r2 == null) goto L18;
        UtilityKotlinExtentionsKt.z(r2, false);
    L18:
        py.k r3 = r5.getVirtualAvatarImg();
        if (r3 == null) goto L22;
        ImageUtil.loadImage(this.d, r3, 0);
    L22:
        if (r5.opened() == false) goto L34;
        View r6 = this.b;
        if (r6 == null) goto L27;
        a1.m(r6, UtilityKotlinExtentionsKt.i(-20));
    L27:
        if (com.bytedance.android.live.profile.ui.base.i.e(this.e) == false) goto L31;
        View r7 = this.b;
        if (r7 == null) goto L51;
        a1.l(r7, UtilityKotlinExtentionsKt.i(55));
    L51:
        View r8 = this.b;
        if (r8 == null) goto L56;
        r8.setOnClickListener(new b(r5, this));
        return;
    L56:
        return;
    L31:
        View r9 = this.b;
        if (r9 == null) goto L51;
        a1.l(r9, 0);
        goto L51
    L34:
        View r10 = this.b;
        if (r10 == null) goto L37;
        a1.p(r10, UtilityKotlinExtentionsKt.i(94));
    L37:
        View r12 = this.b;
        if (r12 == null) goto L40;
        a1.k(r12, UtilityKotlinExtentionsKt.i(94));
    L40:
        View r13 = this.b;
        if (r13 == null) goto L44;
        a1.m(r13, UtilityKotlinExtentionsKt.i(12));
    L44:
        if (com.bytedance.android.live.profile.ui.base.i.e(this.e) == false) goto L48;
        View r14 = this.b;
        if (r14 == null) goto L51;
        a1.l(r14, UtilityKotlinExtentionsKt.i(160));
        goto L51
    L48:
        View r15 = this.b;
        if (r15 == null) goto L51;
        a1.l(r15, UtilityKotlinExtentionsKt.i(72));
        goto L51
    L15:
        TextView r16 = this.c;
        if (r16 == null) goto L18;
        r16.setText(r5.getContent());
        goto L18
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r3, "newUser");
        ALogger.i("ProfileAnchorImageEntryComponent", "profile anchor image entry update:" + r3.liveAgentInfo);
        g(r3);
    }
}
