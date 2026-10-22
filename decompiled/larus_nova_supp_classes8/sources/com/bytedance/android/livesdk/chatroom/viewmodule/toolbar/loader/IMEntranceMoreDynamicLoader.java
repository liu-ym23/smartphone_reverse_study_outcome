package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.e81;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.im.IMIndustryServiceInfo;
import com.bytedance.android.livesdkapi.model.CommunityFoldFixConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/IMEntranceMoreDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMEntranceMoreDynamicLoader extends AbsDynamicLoader {
    public boolean h;
    public IMIndustryServiceInfo i;

    public final class a implements s<Object> {
        public final /* synthetic */ IMEntranceMoreDynamicLoader a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.IMEntranceMoreDynamicLoader$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0074a implements View.OnClickListener {
            public final /* synthetic */ x3 a;
            public final /* synthetic */ Object b;

            public ViewOnClickListenerC0074a(g3 r1, Object r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r3) {
                x3 r0 = this.a;
                if (r0 == null) goto L8;
                c0.b r1 = r0.s(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) this.b).m);
                if (r1 == null) goto L9;
                r1.onClick(r3);
                return;
            L9:
                return;
            }
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
        public final void j() {
        }

        public a(IMEntranceMoreDynamicLoader r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
        public final View x(ViewGroup r4, float r5, com.bytedance.android.livesdk.chatroom.e r6) {
            Intrinsics.checkNotNullParameter(r4, "parentView");
            MoreMixSharePanelUtils r7 = MoreMixSharePanelUtils.INSTANCE;
            IMEntranceMoreDynamicLoader r0 = this.a;
            if (r7.isMoreMixShareMode(r0.c, r0.d) == false) goto L6;
            int r8 = UtilityKotlinExtentionsKt.i(76);
        L30:
            View r9 = LayoutInflater.from(r4.getContext()).inflate(2131567872, r4, false);
            ViewGroup.LayoutParams r10 = r9.getLayoutParams();
            r10.width = r8;
            r9.setLayoutParams(r10);
            return r9;
        L6:
            if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.a(this.a.f.a) == false) goto L25;
            if (PadConfigUtils.c() == false) goto L10;
        L23:
            float r11 = s1.e(369.0f);
        L29:
            r8 = (int) (r11 / r5);
            goto L30
        L10:
            if (FoldScreenUtils.e() == true) goto L12;
        L14:
            DataCenter r12 = this.a.a;
            if (r12 == null) goto L19;
            Boolean r13 = (Boolean) r12.get("data_is_morepanel_average_width", Boolean.FALSE);
            if (r13 == null) goto L19;
            boolean r14 = r13.booleanValue();
        L20:
            if (r14 == false) goto L22;
            r5 = 5.0f;
        L22:
            int r15 = s1.y();
            int r1 = UtilityKotlinExtentionsKt.i(6);
        L28:
            r11 = r15 - r1;
        L19:
            r14 = false;
            goto L20
        L12:
            if (((CommunityFoldFixConfig) e81.b.getValue()).getEnableExperience() == false) goto L14;
        L25:
            if (PadConfigUtils.c() == false) goto L27;
            r11 = s1.e(375.0f);
            goto L29
        L27:
            r15 = s1.y();
            r1 = UtilityKotlinExtentionsKt.i(10);
            goto L28
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
        public final void o(WeakReference<b2> r5, Object r6, View r7, int r8) {
            Intrinsics.checkNotNullParameter(r6, "button");
            Intrinsics.checkNotNullParameter(r7, "itemView");
            if (u40.a.b() == true) goto L5;
        L16:
            TextView r9 = (TextView) r7.findViewById(2131380593);
            View r10 = r7.findViewById(2131392440);
            View r0 = r7.findViewById(2131389071);
            View r11 = r7.findViewById(2131374718);
            MoreMixSharePanelUtils r1 = MoreMixSharePanelUtils.INSTANCE;
            IMEntranceMoreDynamicLoader r2 = this.a;
            boolean r3 = r1.isMoreMixShareMode(r2.c, r2.d);
            if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.a(this.a.f.a) == false) goto L65;
            if (r9 == null) goto L20;
            ViewGroup.LayoutParams r4 = r9.getLayoutParams();
        L22:
            if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L24;
            r4 = null;
        L24:
            ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r4;
            if (r12 == null) goto L29;
            r12.topMargin = UtilityKotlinExtentionsKt.i(12);
            if (r3 == false) goto L29;
            r12.topMargin = UtilityKotlinExtentionsKt.i(16);
        L29:
            if (r0 == null) goto L32;
            r0.setBackgroundDrawable(null);
        L32:
            if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == false) goto L34;
            int r13 = (int) 4279638051L;
            int r14 = 2131249574;
            int r15 = 2132154403;
        L35:
            if (r3 == true) goto L37;
        L52:
            if (r10 == null) goto L54;
            r10.setBackgroundResource(r14);
        L54:
            if (r10 == null) goto L56;
            r10.setVisibility(0);
        L56:
            if (r9 == null) goto L58;
            r9.setTextColor(r15);
        L58:
            if (r11 == null) goto L66;
            Drawable r16 = r11.getBackground();
            if (r16 == null) goto L67;
            Drawable r17 = r16.mutate();
            if (r17 == null) goto L68;
            r17.setColorFilter(r13, PorterDuff.Mode.SRC_ATOP);
            return;
        L68:
            return;
        L67:
            return;
        L66:
            return;
        L37:
            if (r10 == null) goto L39;
            a1.p(r10, UtilityKotlinExtentionsKt.i(56));
        L39:
            if (r10 == null) goto L41;
            a1.k(r10, UtilityKotlinExtentionsKt.i(56));
        L41:
            if (r11 == null) goto L44;
            r11.setAlpha(1.0f);
        L44:
            if (r11 == null) goto L46;
            a1.p(r11, UtilityKotlinExtentionsKt.i(36));
        L46:
            if (r11 == null) goto L48;
            a1.k(r11, UtilityKotlinExtentionsKt.i(36));
        L48:
            r15 = s1.h(2131107010);
            if (r9 == null) goto L51;
            r9.setTextSize(1, 12.0f);
        L51:
            r14 = 2131249575;
            goto L52
        L34:
            r14 = 2131249573;
            r15 = Integer.MAX_VALUE;
            r13 = -1;
            goto L35
        L20:
            r4 = null;
            goto L22
        L65:
            return;
        L5:
            if ((r6 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) == false) goto L16;
            r7.setTag(r6);
            g3 r18 = y3.f(this.a.a);
            if ((r18 instanceof x3) == true) goto L9;
            r18 = null;
        L9:
            if (r18 == null) goto L13;
            Map<ExtendedToolbarButton, View> r19 = r18.c;
            if (r19 == null) goto L13;
            View r20 = (View) ((HashMap) r19).put(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r6).m, r7);
        L13:
            if (r18 == null) goto L15;
            r18.D(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r6).m, r7);
        L15:
            r7.setOnClickListener(new ViewOnClickListenerC0074a(r18, r6));
            goto L16
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        HashSet r0 = new HashSet();
        if (this.h == false) goto L14;
        IMIndustryServiceInfo r1 = this.i;
        if (r1 == null) goto L9;
        ImageModel r2 = r1.get_icon();
        if (r2 == null) goto L9;
        List<String> r3 = r2.getUrls();
    L10:
        if (r1 == null) goto L14;
        if (r3 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r4 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e(ToolbarButton.LIVE_IM_ENTRANCE_MORE.extended());
        r4.a = true;
        r4.c = r3;
        r4.f(s1.B(2131917397));
        r4.k = new a(this);
        r0.add(r4);
    L9:
        r3 = null;
    L14:
        return CollectionsKt.toList(r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        IMIndustryServiceInfo r0 = z.o(this.f.a).imIndustryServiceInfo;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isEntranceOpen() != true) goto L7;
    L8:
        this.h = r1;
        this.i = z.o(this.f.a).imIndustryServiceInfo;
        return;
    L7:
        r1 = false;
        goto L8
    }

    public IMEntranceMoreDynamicLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
    }
}
