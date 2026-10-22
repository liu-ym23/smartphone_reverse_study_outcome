package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.linkpanel.vm.VideoRoomAudiencePreApplyViewModel;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Metadata;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/widget/GuestPreApplyContentWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lvlc/l;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestPreApplyContentWidget extends LiveWidget implements vlc.l {
    public RecyclerView a;
    public FrameLayout b;
    public TextView c;
    public HSImageView d;
    public TextView e;
    public TextView f;
    public View g;
    public final MultiTypeAdapter h;
    public final VideoRoomAudiencePreApplyViewModel i;
    public final IRoom j;

    public static final class a<T> implements Observer {
        public final /* synthetic */ GuestPreApplyContentWidget a;

        public a(GuestPreApplyContentWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            c1 r10 = (c1) r9;
            if (r10 == null) goto L48;
            GuestPreApplyContentWidget r1 = this.a;
            View r2 = r1.g;
            if (r2 == null) goto L7;
            r2.setVisibility(0);
        L7:
            IBaseUser r3 = r10.b();
            String r4 = null;
            if (r3 == null) goto L10;
            py.k r5 = r3.getAvatarThumbKt();
        L11:
            PipelineDraweeControllerBuilder r6 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r5, -1)).setAutoPlayAnimations(false);
            HSImageView r7 = r1.d;
            if (r7 == null) goto L14;
            DraweeController r8 = r7.getController();
        L15:
            AbstractDraweeController r11 = r6.setOldController(r8).build();
            HSImageView r12 = r1.d;
            if (r12 == null) goto L18;
            r12.setController(r11);
        L18:
            TextView r13 = r1.e;
            if (r13 == null) goto L24;
            IBaseUser r14 = r10.b();
            if (r14 == null) goto L23;
            r4 = r14.getNickName();
        L23:
            r13.setText(r4);
        L24:
            String r15 = "-";
            if (hd0.c.f().j() == false) goto L42;
            int r0 = r10.d();
            TextView r16 = r1.c;
            if (r16 != null) goto L29;
        L36:
            TextView r17 = r1.f;
            if (r17 == null) goto L39;
            r17.setVisibility(0);
        L39:
            TextView r18 = r1.f;
            if (r18 == null) goto L52;
            long r19 = 1000;
            r18.setText(TimeUtils.getTimeDescription(s1.getContext(), r10.a() * r19, r10.b * r19));
            return;
        L52:
            return;
        L29:
            if (r0 < 100) goto L31;
            String r20 = "99+";
        L35:
            r16.setText(r20);
            goto L36
        L31:
            if (r0 == 0) goto L34;
            r15 = String.valueOf(r0);
        L34:
            r20 = r15;
            goto L35
        L42:
            TextView r21 = r1.c;
            if (r21 == null) goto L45;
            r21.setText("-");
        L45:
            TextView r22 = r1.f;
            if (r22 == null) goto L54;
            r22.setVisibility(8);
            return;
        L54:
            return;
        L14:
            r8 = null;
            goto L15
        L10:
            r5 = null;
            goto L11
        L48:
            View r23 = this.a.g;
            if (r23 == null) goto L56;
            r23.setVisibility(8);
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ GuestPreApplyContentWidget a;

        public b(GuestPreApplyContentWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            List r5 = (List) r4;
            if (r5 != null) goto L5;
            FrameLayout r6 = this.a.b;
            if (r6 == null) goto L19;
            r6.setVisibility(0);
        L19:
            RecyclerView r7 = this.a.a;
            if (r7 == null) goto L24;
            r7.setVisibility(4);
            return;
        L24:
            return;
        L5:
            if (r5.isEmpty() == false) goto L9;
            FrameLayout r1 = this.a.b;
            if (r1 == null) goto L15;
            r1.setVisibility(0);
        L15:
            MultiTypeAdapter r0 = this.a.h;
            r0.a = r5;
            r0.notifyDataSetChanged();
            return;
        L9:
            FrameLayout r2 = this.a.b;
            if (r2 == null) goto L12;
            r2.setVisibility(8);
        L12:
            RecyclerView r3 = this.a.a;
            if (r3 == null) goto L15;
            r3.setVisibility(0);
            goto L15
        }
    }

    public static final class c implements View.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            IBaseUser r4 = jc1.k.n(IMiddlewareUserService.class).user().b();
            xs2.b.a().post(new UserProfileEvent(r4));
        }
    }

    public final int getLayoutId() {
        return 2131565485;
    }

    public final void onMessage(tlc.d r1) {
    }

    public final void onCreate() {
        super.onCreate();
        this.a = ((Widget) this).contentView.findViewById(2131392990);
        this.b = (FrameLayout) ((Widget) this).contentView.findViewById(2131392989);
        this.c = (TextView) ((Widget) this).contentView.findViewById(2131390468);
        this.d = ((Widget) this).contentView.findViewById(2131376019);
        this.e = (TextView) ((Widget) this).contentView.findViewById(2131391677);
        this.f = (TextView) ((Widget) this).contentView.findViewById(2131391674);
        View r0 = ((Widget) this).contentView.findViewById(2131392991);
        this.g = r0;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.h.z2(c1.class, new zf0.l());
        this.h.z2(zf0.o.a.class, new zf0.o());
        this.h.z2(zf0.d.class, new zf0.k());
        RecyclerView r1 = this.a;
        if (r1 == null) goto L8;
        r1.setAdapter(this.h);
        r1.setLayoutManager(new LinearLayoutManager(r1.getContext()));
        r1.addOnScrollListener(new GuestPreApplyContentWidget$onCreate$$inlined$apply$lambda$1(this));
    L8:
        VideoRoomAudiencePreApplyViewModel r2 = this.i;
        if (r2 == null) goto L13;
        LiveData<c1> r3 = r2.getUserWaitingData();
        if (r3 == null) goto L13;
        r3.observe(this, new a(this));
    L13:
        VideoRoomAudiencePreApplyViewModel r4 = this.i;
        if (r4 == null) goto L18;
        LiveData<List<Object>> r5 = r4.getWaitingListData();
        if (r5 == null) goto L18;
        r5.observe(this, new b(this));
    L18:
        HSImageView r6 = this.d;
        if (r6 == null) goto L21;
        r6.setOnClickListener(c.a);
    L21:
        int r7 = com.bytedance.android.live.liveinteract.utils.c1.a;
        if (e5.n() == false) goto L31;
        RecyclerView r8 = this.a;
        if (r8 == null) goto L32;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L33;
        r9.height = (s1.w() - s1.f(56.0f)) - s1.f(98.0f);
        RecyclerView r10 = this.a;
        if (r10 == null) goto L34;
        r10.setLayoutParams(r9);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    }

    public GuestPreApplyContentWidget(VideoRoomAudiencePreApplyViewModel r1, IRoom r2) {
        this.i = r1;
        this.j = r2;
        this.h = new MultiTypeAdapter();
    }
}
