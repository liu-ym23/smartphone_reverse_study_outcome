package com.bytedance.android.live.revlink.impl.pk.ui;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.k0;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.h1;
import com.bytedance.android.livesdk.link.model.j8;
import com.bytedance.android.livesdk.link.model.k1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u001b\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0019B#\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0015\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PkRandomView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "txt", "", "setRandomBtnTxt", "Lcom/bytedance/android/livesdk/link/model/b0;", "autoMatchInfo", "", "isNewPkAnchor", "update", "Lcom/bytedance/android/live/revlink/impl/pk/ui/x;", "b", "Lcom/bytedance/android/live/revlink/impl/pk/ui/x;", "getListener", "()Lcom/bytedance/android/live/revlink/impl/pk/ui/x;", "setListener", "(Lcom/bytedance/android/live/revlink/impl/pk/ui/x;)V", "listener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkRandomView extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;
    public Map<Integer, View> a;
    public x b;
    public final View c;
    public final LinkCrossRoomDataHolder d;
    public final String e;
    public final String f;
    public final String g;
    public AnimatorSet h;
    public boolean i;

    public final x getListener() {
        x r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listener");
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        AnimatorSet r0 = this.h;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkRandomView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.a = new LinkedHashMap();
        this.c = LayoutInflater.from(getContext()).inflate(2131566359, this);
        this.d = com.bytedance.android.live.revlink.impl.global.b.j();
        StringBuilder r5 = new StringBuilder("https://");
        String r1 = k0.a;
        String r2 = k0.a;
        r5.append(r2);
        r5.append("/obj/live-android/pk_random_new_bg.png");
        this.e = r5.toString();
        this.f = "https://" + r2 + "/obj/live-android/pk_random_guest_avatar.webp";
        this.g = "https://" + r2 + "/obj/live-android/pk_random_btn_anim.webp";
        l51.a.M(l51.a.p() + 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setListener(x r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setRandomBtnTxt(String r3) {
        Intrinsics.checkNotNullParameter(r3, "txt");
        View r0 = this.c;
        if (r0 == null) goto L5;
        View r1 = r0.findViewById(2131364840);
    L6:
        TextView r2 = (TextView) r1;
        if (r2 == null) goto L10;
        r2.setText(r3);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkRandomView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.a = new LinkedHashMap();
        this.c = LayoutInflater.from(getContext()).inflate(2131566359, this);
        this.d = com.bytedance.android.live.revlink.impl.global.b.j();
        StringBuilder r5 = new StringBuilder("https://");
        String r0 = k0.a;
        String r1 = k0.a;
        r5.append(r1);
        r5.append("/obj/live-android/pk_random_new_bg.png");
        this.e = r5.toString();
        this.f = "https://" + r1 + "/obj/live-android/pk_random_guest_avatar.webp";
        this.g = "https://" + r1 + "/obj/live-android/pk_random_btn_anim.webp";
        l51.a.M(l51.a.p() + 1);
    }

    public final void update(b0 r7, boolean r8) {
        if (r7 == null) goto L7;
        String r1 = r7.getMainTitle();
        if (r1 == null) goto L7;
        ((TextView) _$_findCachedViewById(2131383633)).setText(r1);
    L7:
        View r2 = this.c;
        ImageRequest[] r3 = null;
        if (r2 == null) goto L10;
        View r4 = r2.findViewById(2131383621);
    L11:
        a1.s((HSImageView) r4, this.e);
        View r5 = this.c;
        if (r5 == null) goto L14;
        View r6 = r5.findViewById(2131383626);
    L15:
        com.bytedance.android.live.revlink.impl.pk.utils.w.a((SimpleDraweeView) r6, this.f);
        View r9 = this.c;
        if (r9 == null) goto L18;
        View r10 = r9.findViewById(2131364840);
    L19:
        TextView r12 = (TextView) r10;
        if (r12 == null) goto L22;
        r12.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L22:
        View r13 = this.c;
        if (r13 == null) goto L25;
        View r14 = r13.findViewById(2131364644);
    L26:
        if (r14 == null) goto L28;
        r14.setBackgroundResource(2131249455);
    L28:
        View r15 = this.c;
        if (r15 == null) goto L31;
        View r16 = r15.findViewById(2131364842);
    L32:
        TextView r17 = (TextView) r16;
        if (r17 == null) goto L35;
        r17.setVisibility(8);
    L35:
        IBaseUser r18 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        View r19 = this.c;
        if (r19 == null) goto L38;
        View r20 = r19.findViewById(2131383620);
    L39:
        ImageView r22 = (ImageView) r20;
        if (r18 == null) goto L42;
        py.k r23 = r18.getAvatarThumbKt();
    L43:
        ImageUtil.loadRoundImage(r22, r23);
        if (r7 == null) goto L48;
        String r24 = r7.getMainTitle();
        if (r24 == null) goto L48;
        ((TextView) _$_findCachedViewById(2131383633)).setText(r24);
    L48:
        String r0 = s1.B(2131917850);
        ((TextView) _$_findCachedViewById(2131383632)).setText(r0 + " ");
        TextView r25 = (TextView) _$_findCachedViewById(2131383629);
        ur2.a r26 = vh6.c.b(ur2.a.class);
        if (r7 == null) goto L63;
        Intrinsics.checkNotNullParameter(r7, "$this$matchText");
        if ((r7 instanceof h1) == false) goto L61;
        h1 r27 = (h1) r7;
        KProperty[] r28 = k1.a;
        Intrinsics.checkNotNullParameter(r27, "$this$_matchText");
        vh7.i r29 = k1.b;
        KProperty r30 = k1.a[0];
        if ((r27 instanceof FlexModelBase) == true) goto L55;
        r27 = null;
    L55:
        FlexModelBase r32 = (FlexModelBase) r27;
        if (r32 == null) goto L58;
        Object r33 = r32.get(r29.a);
    L59:
        a5 r34 = (a5) r33;
    L64:
        r25.setText(r26.Lf(r34, ""));
        if (r8 == true) goto L67;
        return;
    L67:
        if (l51.a.p() <= 3) goto L69;
        return;
    L69:
        if (this.i == true) goto L79;
        this.i = true;
        PipelineDraweeControllerBuilder r35 = Fresco.newDraweeControllerBuilder().setOldController(this.c.findViewById(2131383619).getController());
        String r36 = this.g;
        ArrayList r37 = new ArrayList();
        ImageNetworkRequestsMonitor r38 = new ImageNetworkRequestsMonitor();
        ImageRequestBuilder r39 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r36));
        r38.monitor(r39);
        r37.add(r39.build());
        if (r37.size() == 0) goto L75;
        r3 = (ImageRequest[]) r37.toArray(new ImageRequest[r37.size()]);
    L75:
        this.c.findViewById(2131383619).setController(r35.setFirstAvailableImageRequests(r3).setControllerListener(new p(this)).setAutoPlayAnimations(true).build());
        return;
    L79:
        return;
    L58:
        r33 = null;
        goto L59
    L61:
        if ((r7 instanceof j8) == false) goto L63;
        r34 = ((j8) r7).get_matchText();
    L63:
        r34 = null;
        goto L64
    L42:
        r23 = null;
        goto L43
    L38:
        r20 = null;
        goto L39
    L31:
        r16 = null;
        goto L32
    L25:
        r14 = null;
        goto L26
    L18:
        r10 = null;
        goto L19
    L14:
        r6 = null;
        goto L15
    L10:
        r4 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkRandomView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.c = LayoutInflater.from(getContext()).inflate(2131566359, this);
        this.d = com.bytedance.android.live.revlink.impl.global.b.j();
        StringBuilder r5 = new StringBuilder("https://");
        String r6 = k0.a;
        String r7 = k0.a;
        r5.append(r7);
        r5.append("/obj/live-android/pk_random_new_bg.png");
        this.e = r5.toString();
        this.f = "https://" + r7 + "/obj/live-android/pk_random_guest_avatar.webp";
        this.g = "https://" + r7 + "/obj/live-android/pk_random_btn_anim.webp";
        l51.a.M(l51.a.p() + 1);
    }
}
