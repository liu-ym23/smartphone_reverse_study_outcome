package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.CompatKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.player.VideoEngineMusicPlayerViewImpl;
import com.larus.common_ui.widget.CircleProgressBar;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MusicBox extends xc8.h implements com.larus.bmhome.music.player.a.a {
    public String A;
    public CoroutineScope B;
    public final ImageView C;
    public final CircleProgressBar D;
    public final ProgressBar E;
    public boolean F;
    public final MusicBox$actLifecycleObserver$1 G;
    public final Context p;
    public final TextView q;
    public final TextView r;
    public final View s;
    public final View t;
    public final TextView u;
    public final TextView v;
    public final SimpleDraweeView w;
    public final int x;
    public final VideoEngineMusicPlayerViewImpl y;
    public Message z;

    public static final class a {
    }

    static {
    }

    public final void Pe(float r1, boolean r2) {
    }

    public final void FK() {
        ImageView r0 = this.C;
        if (r0 == null) goto L6;
        r0.setBackgroundResource(2131243613);
        return;
    }

    public final void Lr() {
        ImageView r0 = this.C;
        if (r0 == null) goto L6;
        com.larus.utils.e1.x(r0);
        return;
    }

    public final void OK() {
        ImageView r0 = this.C;
        if (r0 == null) goto L6;
        com.larus.utils.e1.o(r0);
        return;
    }

    public final void UY() {
        CircleProgressBar r0 = this.D;
        if (r0 == null) goto L6;
        com.larus.utils.e1.x(r0);
        return;
    }

    public final void f20() {
        ImageView r0 = this.C;
        if (r0 == null) goto L6;
        r0.setBackgroundResource(2131243612);
        return;
    }

    public CoroutineScope getScope() {
        CoroutineScope r0 = this.B;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return GlobalScope.INSTANCE;
    }

    public final void hideLoadingView() {
        ProgressBar r0 = this.E;
        if (r0 == null) goto L5;
        com.larus.utils.e1.o(r0);
    L5:
        ImageView r1 = this.C;
        if (r1 == null) goto L9;
        com.larus.utils.e1.x(r1);
        return;
    }

    public final void showLoadingView() {
        ProgressBar r0 = this.E;
        if (r0 == null) goto L6;
        com.larus.utils.e1.x(r0);
        return;
    }

    public final void Lf() {
        BuildersKt.launch$default(getScope(), Dispatchers.getMain(), null, new MusicBox$hideProgressBarView$1(this, null), 2, null);
    }

    @Override // com.larus.bmhome.chat.layout.item.i, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        VideoEngineMusicPlayerViewImpl r0 = this.y;
        if (r0 == null) goto L6;
        r0.onAttachedToWindow();
    L6:
        if (this.F == true) goto L9;
        CompatKt.findFragment(this).getLifecycle().addObserver(this.G);
        this.F = true;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VideoEngineMusicPlayerViewImpl r0 = this.y;
        if (r0 == null) goto L6;
        r0.onDetachedFromWindow();
        return;
    }

    public final void F6() {
        com.larus.bmhome.music.player.a.a.a.b();
    }

    public Context getViewContext() {
        return this.p;
    }

    /* JADX WARN: Type inference failed for: r5v11, types: [com.larus.bmhome.chat.layout.item.MusicBox$actLifecycleObserver$1] */
    public MusicBox(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "mContext");
        super(r5);
        this.p = r5;
        int r6 = (int) (com.larus.utils.i.d(getContext()) / 2.0f);
        this.x = r6;
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(r6, -2);
        View r7 = LayoutInflater.from(getContext()).inflate(2131562976, null);
        r0.setMarginStart(getResources().getDimensionPixelSize(2131167550));
        addView(r7, r0);
        this.u = (TextView) r7.findViewById(2131386543);
        this.v = (TextView) r7.findViewById(2131386979);
        this.q = (TextView) r7.findViewById(2131392378);
        SimpleDraweeView r1 = r7.findViewById(2131363091);
        this.w = r7.findViewById(2131368153);
        this.r = (TextView) r7.findViewById(2131371761);
        this.s = r7.findViewById(2131380483);
        this.t = r7.findViewById(2131382465);
        com.larus.bmhome.music.player.f r2 = com.larus.bmhome.music.player.f.a;
        Intrinsics.checkNotNullParameter(this, "parent");
        this.y = new VideoEngineMusicPlayerViewImpl(this, null);
        this.C = (ImageView) r7.findViewById(2131382435);
        this.D = r7.findViewById(2131383286);
        this.E = (ProgressBar) r7.findViewById(2131379091);
        this.G = new MusicBox$actLifecycleObserver$1(this);
    }

    public final void GP(Map<String, String> r1) {
        com.larus.bmhome.music.player.a.a.a.d(r1);
    }

    public final void Ij(Map<String, String> r1) {
        com.larus.bmhome.music.player.a.a.a.c(r1);
    }

    public final void eb(Map<String, String> r1) {
        com.larus.bmhome.music.player.a.a.a.a(r1);
    }

    public final void mP(int r1, boolean r2) {
        CircleProgressBar r3 = this.D;
        if (r3 == null) goto L6;
        r3.setProgress(r1);
        return;
    }

    public final void r30(String r1, Map<String, String> r2) {
        com.larus.bmhome.music.player.a.a.a.e(r1, r2);
    }

    public final void n(Message r37, String r38, CoroutineScope r39) {
        this.z = r37;
        this.A = r38;
        this.B = r39;
        CommonVideoModel.a r2 = CommonVideoModel.Companion;
        if (r37 == null) goto L5;
        String r4 = r37.getContent();
    L6:
        r2.getClass();
        MediaEntityContainer r3 = CommonVideoModel.a.a(r4);
        if (r3 == null) goto L9;
        ArrayList r5 = r3.getMusic_list();
    L11:
        if (r37 == null) goto L16;
        String r6 = com.larus.bmhome.chat.bean.d.x(r37).getShowFrom();
        if (r6 == null) goto L16;
        String r10 = r6;
    L18:
        if (r5 != null) goto L20;
    L23:
        boolean r7 = true;
    L25:
        if (r7 == true) goto L96;
        if (r37 == null) goto L96;
        MediaEntity r8 = (MediaEntity) CollectionsKt.firstOrNull(r5);
        if (r8 == null) goto L86;
        String r9 = r37.getMessageId();
        if (r9 != null) goto L33;
        String r11 = "";
    L34:
        String r12 = r37.getConversationId();
        if (r12 != null) goto L37;
        String r13 = "";
    L38:
        String r14 = this.A;
        if (r14 != null) goto L41;
        String r15 = "";
    L42:
        CoroutineScope r16 = this.B;
        Integer r17 = r8.getSource_from();
        if (r17 == null) goto L45;
        int r18 = r17.intValue();
    L46:
        String r19 = r8.getSourceId();
        if (r19 != null) goto L49;
        String r110 = "";
    L50:
        String r20 = r8.getMedia_id();
        if (r20 != null) goto L53;
        String r111 = "";
    L54:
        String r21 = r8.getVideo_model();
        if (r21 != null) goto L57;
        String r112 = "";
    L58:
        Boolean r22 = r8.getVideo_auto_play();
        if (r22 == null) goto L61;
        boolean r23 = r22.booleanValue();
    L62:
        com.larus.bmhome.music.player.j r24 = new com.larus.bmhome.music.player.j(r11, r13, r15, r10, r110, r18, r112, r111, r23, false, r16, 0, null, null, null, false, null, null, null, false, true, null, false, false, this.z, null, 49281536);
        VideoEngineMusicPlayerViewImpl r25 = this.y;
        if (r25 == null) goto L65;
        r25.d(r24);
    L65:
        FLogger r26 = FLogger.a;
        r26.d("MusicBox", "Message id " + r37.getMessageId() + "  Music singer " + r8.getMedia_account_name() + " => [addContentView]");
        ImageLoaderKt.v(this.w, r8.getMedia_cover_image(), "chat.music", com.larus.image.loader.b0.e("im_fresco_cache"), new i1(this));
        SimpleDraweeView r1 = this.w;
        if (r1 == null) goto L68;
        ViewGroup.LayoutParams r27 = r1.getLayoutParams();
    L69:
        if (r27 == null) goto L71;
        r27.width = this.x;
    L71:
        if (r27 == null) goto L73;
        r27.height = this.x;
    L73:
        SimpleDraweeView r28 = this.w;
        if (r28 == null) goto L76;
        r28.setLayoutParams(r27);
    L76:
        r26.d("MusicBox", "[loadCoverImage] width=" + this.x + " height=" + getHeight() + " uri= " + r8.getMedia_cover_image());
        TextView r29 = this.u;
        if (r29 == null) goto L79;
        r29.setText(r8.getMedia_account_name());
    L79:
        TextView r30 = this.v;
        if (r30 == null) goto L82;
        r30.setText(r8.getMedia_des());
    L82:
        TextView r31 = this.q;
        if (r31 == null) goto L85;
        r31.setText(r8.getMedia_from());
    L85:
        getLayoutParams().height = -2;
        setOnClickListener(new g1(this));
        goto L86
    L68:
        r27 = null;
        goto L69
    L61:
        r23 = false;
        goto L62
    L57:
        r112 = r21;
        goto L58
    L53:
        r111 = r20;
        goto L54
    L49:
        r110 = r19;
        goto L50
    L45:
        r18 = -1;
        goto L46
    L41:
        r15 = r14;
        goto L42
    L37:
        r13 = r12;
        goto L38
    L33:
        r11 = r9;
    L86:
        TextView r32 = this.r;
        if (r32 == null) goto L89;
        com.larus.utils.e1.o(r32);
    L89:
        View r33 = this.s;
        if (r33 == null) goto L92;
        com.larus.utils.e1.x(r33);
    L92:
        View r34 = this.t;
        if (r34 == null) goto L104;
        r34.setOnClickListener(new h1(this));
        return;
    L104:
        return;
    L96:
        TextView r35 = this.r;
        if (r35 == null) goto L99;
        com.larus.utils.e1.x(r35);
    L99:
        View r36 = this.s;
        if (r36 == null) goto L102;
        com.larus.utils.e1.o(r36);
    L102:
        FLogger.a.d("MusicBox", "mediaEntityList is null ");
        return;
    L20:
        if (r5.isEmpty() == true) goto L23;
        r7 = false;
    L16:
        r10 = "";
        goto L18
    L9:
        r5 = null;
        goto L11
    L5:
        r4 = null;
        goto L6
    }
}
