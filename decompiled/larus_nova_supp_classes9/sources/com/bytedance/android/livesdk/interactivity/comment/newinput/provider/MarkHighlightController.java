package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.HighlightPreviewDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MarkHighlightController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
    public final int c;
    public final int d;
    public final RecyclerView e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final HSImageView i;
    public final View j;
    public final LiveDoubleColorBallAnimationView k;
    public final View l;
    public final HighlightViewAdapter m;
    public Disposable n;
    public Disposable o;
    public final CompositeDisposable p;
    public HighlightPreviewDialog q;
    public List<com.bytedance.android.livesdk.interactivity.comment.highlight.b> r;
    public boolean s;
    public final List<String> t;
    public final b u;
    public final String v;
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g w;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/MarkHighlightController$HighlightViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/MarkHighlightController$HighlightViewAdapter$HighlightPreviewViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/MarkHighlightController;", "HighlightPreviewViewHolder", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class HighlightViewAdapter extends RecyclerView.Adapter<HighlightPreviewViewHolder> {
        public int a;
        public final List<com.bytedance.android.livesdk.interactivity.comment.highlight.b> b;
        public final /* synthetic */ MarkHighlightController c;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/MarkHighlightController$HighlightViewAdapter$HighlightPreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public final class HighlightPreviewViewHolder extends RecyclerView.ViewHolder {
            public final HSImageView a;
            public final TextView b;
            public final ImageView c;
            public final RelativeLayout d;
            public final float e;
            public final float f;
            public final /* synthetic */ HighlightViewAdapter g;

            public static final class a implements View.OnClickListener {
                public final /* synthetic */ HighlightPreviewViewHolder a;
                public final /* synthetic */ Function0 b;
                public final /* synthetic */ Function1 c;

                public a(HighlightPreviewViewHolder r1, Function0 r2, Function1 r3) {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View r2) {
                    if (((Boolean) this.b.invoke()).booleanValue() == false) goto L5;
                    return;
                L5:
                    this.c.invoke(Integer.valueOf(this.a.getAdapterPosition()));
                }
            }

            public static final class b implements View.OnClickListener {
                public final /* synthetic */ HighlightPreviewViewHolder a;
                public final /* synthetic */ Function0 b;

                public b(HighlightPreviewViewHolder r1, Function0 r2) {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View r6) {
                    if (((Boolean) this.b.invoke()).booleanValue() == false) goto L5;
                    return;
                L5:
                    int r7 = this.a.getAdapterPosition();
                    HighlightViewAdapter r0 = this.a.g;
                    int r1 = r0.a;
                    r0.a = r7;
                    Bundle r2 = new Bundle();
                    r2.putBoolean("SELECTED", true);
                    Unit r3 = Unit.INSTANCE;
                    r0.notifyItemChanged(r7, r2);
                    if (r1 == (-1)) goto L9;
                    HighlightViewAdapter r8 = this.a.g;
                    Bundle r4 = new Bundle();
                    r4.putBoolean("SELECTED", false);
                    r8.notifyItemChanged(r1, r4);
                    return;
                }
            }

            public HighlightPreviewViewHolder(HighlightViewAdapter r2, View r3, CompositeDisposable r4, Function0<Boolean> r5, Function1<? super Integer, Unit> r6) {
                Intrinsics.checkNotNullParameter(r3, "itemView");
                Intrinsics.checkNotNullParameter(r4, "dispose");
                Intrinsics.checkNotNullParameter(r5, "blockAction");
                Intrinsics.checkNotNullParameter(r6, "previewAction");
                this.g = r2;
                super(r3);
                HSImageView r7 = r3.findViewById(2131382942);
                this.a = r7;
                this.b = (TextView) r3.findViewById(2131379478);
                this.c = (ImageView) r3.findViewById(2131374353);
                RelativeLayout r8 = (RelativeLayout) r3.findViewById(2131364437);
                this.d = r8;
                this.e = 1.33f;
                this.f = 0.67f;
                r7.setOnClickListener(new a(this, r5, r6));
                r8.setOnClickListener(new b(this, r5));
            }
        }

        public final int getItemCount() {
            return ((ArrayList) this.b).size();
        }

        public HighlightViewAdapter(MarkHighlightController r1) {
            this.c = r1;
            this.b = new ArrayList();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
            HighlightPreviewViewHolder r8 = (HighlightPreviewViewHolder) r6;
            Intrinsics.checkNotNullParameter(r8, "vh");
            com.bytedance.android.livesdk.interactivity.comment.highlight.b r0 = (com.bytedance.android.livesdk.interactivity.comment.highlight.b) ListProtector.get(this.b, r7);
            if (r7 != this.a) goto L5;
            boolean r9 = true;
        L6:
            r8.getClass();
            Intrinsics.checkNotNullParameter(r0, "data");
            Ref.FloatRef r1 = new Ref.FloatRef();
            r1.element = r8.f;
            IInteractivityInjectService r3 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            if (r3 == null) goto L13;
            ILivePlayerClient r4 = r3.currentClient();
            if (r4 == null) goto L13;
            IRenderView r5 = r4.getRenderView();
            if (r5 == null) goto L13;
            int r10 = r5.getWidth();
        L14:
            IInteractivityInjectService r11 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            if (r11 == null) goto L21;
            ILivePlayerClient r13 = r11.currentClient();
            if (r13 == null) goto L21;
            IRenderView r14 = r13.getRenderView();
            if (r14 == null) goto L21;
            int r15 = r14.getHeight();
        L22:
            if (r10 <= 0) goto L28;
            if (r15 <= 0) goto L28;
            if (r10 < r15) goto L26;
            float r16 = r8.e;
        L27:
            r1.element = r16;
            goto L28
        L26:
            r16 = r8.f;
        L28:
            r8.a.post(new q0(r8, r1));
            ImageUtil.loadImage(r8.a, r0.c(), 0);
            r8.b.setText(r0.h());
            if (r9 == false) goto L31;
            r8.c.setBackgroundResource(2131252302);
            return;
        L31:
            r8.c.setBackgroundResource(2131252305);
            return;
        L21:
            r15 = 0;
        L13:
            r10 = 0;
            goto L14
        L5:
            r9 = false;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "parent");
            return new HighlightPreviewViewHolder(this, LayoutInflater.from(r9.getContext()).inflate(2131567712, r9, false), this.c.p, new MarkHighlightController$HighlightViewAdapter$onCreateViewHolder$1(this), new MarkHighlightController$HighlightViewAdapter$onCreateViewHolder$2(this));
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5, List r6) {
            HighlightPreviewViewHolder r7 = (HighlightPreviewViewHolder) r4;
            Intrinsics.checkNotNullParameter(r7, "holder");
            Intrinsics.checkNotNullParameter(r6, "payloads");
            if (r6.isEmpty() == false) goto L5;
            super.onBindViewHolder(r7, r5, r6);
            return;
        L5:
            Object r8 = ListProtector.get(r6, 0);
            if (r8 == null) goto L24;
            Bundle r9 = (Bundle) r8;
            Iterator<T> r10 = r9.keySet().iterator();
        L9:
            if (r10.hasNext() == false) goto L37;
            String r0 = (String) r10.next();
            if (r0 == null) goto L9;
            if (r0.hashCode() != 1974198939) goto L9;
            if (r0.equals("SELECTED") == false) goto L9;
            if (r9.getBoolean(r0) == true) goto L20;
            r7.c.setBackgroundResource(2131252305);
            goto L9
        L20:
            r7.c.setBackgroundResource(2131252302);
            goto L9
        L37:
            return;
        L24:
            throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/MarkHighlightController$SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        public final int a;

        public SpaceItemDecoration(int r1) {
            this.a = r1;
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            int r6 = r4.getChildAdapterPosition(r3);
            int r7 = r5.getItemCount();
            if (r6 != 0) goto L5;
            r2.left = UtilityKotlinExtentionsKt.i(16);
        L7:
            if (r6 != (r7 - 1)) goto L10;
            r2.right = UtilityKotlinExtentionsKt.i(16);
            return;
        L10:
            return;
        L5:
            r2.left = this.a;
            goto L7
        }
    }

    public interface a {
        void onDismiss();

        void onShow();
    }

    public static final class b implements a {
        public final /* synthetic */ MarkHighlightController a;

        @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.provider.MarkHighlightController.a
        public final void onDismiss() {
            MarkHighlightController.g(this.a, false);
            this.a.q = null;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.provider.MarkHighlightController.a
        public final void onShow() {
            MarkHighlightController.g(this.a, true);
        }

        public b(MarkHighlightController r1) {
            this.a = r1;
        }
    }

    public final IBaseUser h() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, this.b.R(), 0, 2);
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L11;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L11;
        return r3.getOwner();
    L11:
        return null;
    }

    public final String i() {
        IBaseUser r0 = h();
        if (r0 == null) goto L6;
        String r1 = r0.getUserId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return BuildConfig.FLAVOR;
    }

    public final void j(boolean r10) {
        if (r10 == false) goto L11;
        UtilityKotlinExtentionsKt.w(this.i);
        this.l.setClickable(false);
        View r11 = this.j;
        if (r11 == null) goto L7;
        r11.setClickable(false);
    L7:
        LiveScreenRecordGuideConfig.a r13 = LiveScreenRecordGuideConfig.c;
        DataCenter r0 = this.b.R();
        r13.getClass();
        if (LiveScreenRecordGuideConfig.a.a(r0) == true) goto L10;
        UtilityKotlinExtentionsKt.u(this.l);
    L10:
        RotateAnimation r14 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r14.setRepeatCount(-1);
        r14.setDuration(400);
        Unit r1 = Unit.INSTANCE;
        this.i.startAnimation(r14);
        this.s = true;
        return;
    L11:
        this.i.clearAnimation();
        UtilityKotlinExtentionsKt.t(this.i);
        this.l.setClickable(true);
        View r15 = this.j;
        if (r15 == null) goto L14;
        r15.setClickable(true);
    L14:
        UtilityKotlinExtentionsKt.w(this.l);
        this.s = false;
    }

    public final void k(int r2) {
        if (r2 != 0) goto L5;
        UtilityKotlinExtentionsKt.w(this.e);
        UtilityKotlinExtentionsKt.t(this.f);
        this.k.c();
        UtilityKotlinExtentionsKt.t(this.g);
        UtilityKotlinExtentionsKt.w(this.h);
        return;
    L5:
        if (r2 != this.c) goto L7;
        UtilityKotlinExtentionsKt.t(this.e);
        UtilityKotlinExtentionsKt.t(this.f);
        UtilityKotlinExtentionsKt.w(this.g);
        this.k.b();
        UtilityKotlinExtentionsKt.t(this.h);
        return;
    L7:
        UtilityKotlinExtentionsKt.t(this.e);
        UtilityKotlinExtentionsKt.w(this.f);
        this.k.c();
        UtilityKotlinExtentionsKt.t(this.g);
        UtilityKotlinExtentionsKt.t(this.h);
    }

    public MarkHighlightController(View r4, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "panelBridge");
        super(r4, r5);
        this.w = r5;
        this.c = 1;
        this.d = 2;
        r5.R();
        ViewStub r0 = (ViewStub) r4.findViewById(2131374363);
        LiveScreenRecordGuideConfig.a r1 = LiveScreenRecordGuideConfig.c;
        DataCenter r2 = this.b.R();
        r1.getClass();
        if (LiveScreenRecordGuideConfig.a.a(r2) == false) goto L5;
        int r3 = 2131567844;
    L6:
        r0.setLayoutResource(r3);
        r0.inflate();
        this.e = r4.findViewById(2131374358);
        this.f = (LinearLayout) r4.findViewById(2131380959);
        this.g = (LinearLayout) r4.findViewById(2131379045);
        this.h = (LinearLayout) r4.findViewById(2131381542);
        this.i = r4.findViewById(2131383431);
        this.j = r4.findViewById(2131378592);
        this.k = r4.findViewById(2131379000);
        this.l = r4.findViewById(2131373834);
        this.m = new HighlightViewAdapter(this);
        this.p = new CompositeDisposable();
        this.t = new ArrayList();
        this.u = new b(this);
        int r6 = e72.c.a;
        this.v = e72.c.c(r5.getContext());
        return;
    L5:
        r3 = 2131567843;
        goto L6
    }

    public static final void g(MarkHighlightController r4, boolean r5) {
        r4.getClass();
        if (r5 == false) goto L7;
        IInteractivityInjectService r6 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r6 == null) goto L11;
        r6.muteLivePlayerClient();
    L11:
        if (v22.a.b.booleanValue() == true) goto L13;
        return;
    L13:
        if (hd0.c.f().h() == true) goto L15;
        return;
    L15:
        if (r5 == false) goto L21;
        IPushStreamService r7 = jc1.k.f(IPushStreamService.class);
        if (r7 == null) goto L29;
        com.bytedance.android.live.pushstream.d r8 = r7.getPushLiveStream();
        if (r8 == null) goto L30;
        r8.J0("live highlight preview", new uv0.a(LiveRequestSourceRole.Business, "MarkHighlightController.mutePlayerClient", null));
        return;
    L30:
        return;
    L29:
        return;
    L21:
        IPushStreamService r9 = jc1.k.f(IPushStreamService.class);
        if (r9 == null) goto L32;
        com.bytedance.android.live.pushstream.d r10 = r9.getPushLiveStream();
        if (r10 == null) goto L33;
        r10.q1("live highlight preview", new uv0.a(LiveRequestSourceRole.Business, "MarkHighlightController.mutePlayerClient", null));
        return;
    L33:
        return;
    L32:
        return;
    L7:
        IInteractivityInjectService r11 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r11 == null) goto L11;
        r11.unmuteLivePlayerClient();
        goto L11
    }
}
