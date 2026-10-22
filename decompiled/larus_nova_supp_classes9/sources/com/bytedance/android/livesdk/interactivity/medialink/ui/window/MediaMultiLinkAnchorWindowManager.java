package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import am2.x;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkMicIdInfo;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.utils.r1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorTitleView;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.WindowsPosition;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.AnchorUpdateLayoutContent;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import e92.p;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import nc0.r;
import nc0.s;
import uf2.m1;
import uf2.z;
import zg1.h1;
import zg1.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001\fJ\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/MediaMultiLinkAnchorWindowManager;", "Lhy/f$a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lf92/b;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/a;", "Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/l;", "Lzg1/h1;", "event", BuildConfig.FLAVOR, "onEvent", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkAnchorWindowManager extends hy.f.a implements Observer<KVData>, f92.b, com.bytedance.android.livesdk.interactivity.medialink.ui.window.a, l {
    public final String a;
    public final ArrayList<MediaMultiAnchorWindowV2> b;
    public final HashMap<String, z.a> c;
    public final int d;
    public final int e;
    public final double f;
    public final double g;
    public MediaMultiAnchorWindowV2 h;
    public ViewGroup i;
    public MediaMultiAnchorTitleView j;
    public final CompositeDisposable k;
    public Room l;
    public final LifecycleOwner m;
    public final HashMap<String, Boolean> n;
    public final p o;
    public Disposable p;
    public int q;
    public final com.bytedance.android.livesdk.interactivity.medialink.contract.h r;
    public Map<String, ? extends WindowsPosition> s;
    public final FrameLayout t;
    public final RoomContext u;
    public final DataCenter v;
    public final hy.e w;
    public final MediaMultiEnlargeWidget x;
    public final MediaMultiAnchorLinkContext y;

    public static final class a {
    }

    static {
    }

    public static f92.f r() {
        x82.e.A2.getClass();
        x82.e r0 = x82.e.a.a();
        if (r0 == null) goto L7;
        f92.f r1 = r0.Q8();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new f92.g();
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.window.a
    public final MediaMultiAnchorWindowV2 j() {
        Iterator<MediaMultiAnchorWindowV2> r0 = this.b.iterator();
    L3:
        String r2 = null;
        if (r0.hasNext() == false) goto L17;
        MediaMultiAnchorWindowV2 r1 = r0.next();
        AnchorLinkUser r3 = r1.getAnchorLinkUser();
        if (r3 == null) goto L10;
        User r4 = r3.getMUser();
        if (r4 == null) goto L10;
        String r5 = r4.getIdStr();
    L11:
        Room r6 = this.l;
        if (r6 == null) goto L15;
        r2 = r6.getOwnerUserIdString();
    L15:
        if (Intrinsics.areEqual(r5, r2) == false) goto L3;
        return r1;
    L10:
        r5 = null;
        goto L11
    L17:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.window.l
    public final int l() {
        return s1.f(16.0f);
    }

    public final String u() {
        hy.e r0 = this.w;
        if (r0 == null) goto L27;
        List r1 = r0.getOnlineUserList();
        if (r1 == null) goto L27;
        Iterator r2 = r1.iterator();
    L7:
        Object r3 = null;
        if (r2.hasNext() == false) goto L23;
        Object r4 = r2.next();
        IBaseUser r5 = ((AnchorLinkUser) r4).getUser();
        if (r5 == null) goto L12;
        String r6 = r5.getIdString();
    L13:
        RoomContext.a r7 = RoomContext.Companion;
        DataCenter r8 = this.v;
        r7.getClass();
        RoomContext r9 = RoomContext.a.a(r8, 0);
        if (r9 == null) goto L21;
        m r10 = r9.getRoom();
        if (r10 == null) goto L21;
        Room r11 = (Room) r10.getValue();
        if (r11 == null) goto L21;
        r3 = r11.getOwnerUserIdString();
    L21:
        if (Intrinsics.areEqual(r6, r3) == false) goto L7;
        r3 = r4;
        goto L23
    L12:
        r6 = null;
    L23:
        AnchorLinkUser r13 = (AnchorLinkUser) r3;
        if (r13 == null) goto L27;
        String r14 = r13.getInteractId();
        if (r14 == null) goto L27;
        return r14;
    L27:
        return BuildConfig.FLAVOR;
    }

    public final List<String> v() {
        ArrayList r0 = new ArrayList();
        Iterator<MediaMultiAnchorWindowV2> r1 = this.b.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        String r2 = r1.next().getInteractId();
        if (r2 == null) goto L4;
        if (TextUtils.isEmpty(r2) == true) goto L4;
        r0.add(r2);
        goto L4
    L11:
        return r0;
    }

    public final int s() {
        return (int) (r().a(RangesKt.coerceAtLeast(this.b.size(), 2)).c() * ((double) this.e));
    }

    @Override // f92.b
    public final Map<String, WindowsPosition> e() {
        return this.s;
    }

    public final void A(Function1<? super com.bytedance.android.livesdk.interactivity.medialink.contract.h, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "procedure");
        r2.invoke(this.r);
        MediaMultiAnchorTitleView r3 = this.j;
        if (r3 == null) goto L6;
        r3.setState(this.r);
        return;
    }

    @Override // f92.b
    public final WindowsPosition o(String r4) {
        Intrinsics.checkNotNullParameter(r4, "interactId");
        hy.e r0 = this.w;
        if (r0 == null) goto L5;
        AnchorLinkUser r1 = r0.g(r4);
    L6:
        if (r1 != null) goto L11;
        Map<String, ? extends WindowsPosition> r2 = this.s;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.get(r4);
    L11:
        MediaMultiAnchorWindowV2 r3 = t(r4);
        if (r3 == null) goto L27;
        String r5 = r3.getInteractId();
        if (Intrinsics.areEqual(r3.getLinkMicId(), r4) == false) goto L28;
        if (r5 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == true) goto L29;
        Map<String, ? extends WindowsPosition> r7 = this.s;
        if (r7 != null) goto L25;
        return null;
    L25:
        return r7.get(r5);
    L29:
        return null;
    L17:
        if (r5.length() == 0) goto L20;
        r6 = false;
        goto L21
    L28:
        return null;
    L27:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L5;
        String r1 = r7.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == (-2068819755)) goto L12;
        return;
    L12:
        if (r1.equals("DATA_IS_HIDE_INTERACTION") == true) goto L14;
        return;
    L14:
        if (wt2.a.f(Boolean.TRUE) == false) goto L43;
        A(AnonymousClass1.INSTANCE);
        Boolean r8 = (Boolean) r7.getData();
        if (r8 == null) goto L40;
        Iterator<MediaMultiAnchorWindowV2> r2 = this.b.iterator();
    L20:
        if (r2.hasNext() == false) goto L44;
        MediaMultiAnchorWindowV2 r3 = r2.next();
        AnchorLinkUser r4 = r3.getAnchorLinkUser();
        if (r4 == null) goto L26;
        User r5 = r4.getMUser();
        if (r5 == null) goto L26;
        String r9 = r5.getIdStr();
    L27:
        Room r10 = this.l;
        if (r10 == null) goto L30;
        String r11 = r10.getOwnerUserIdString();
    L32:
        if ((!Intrinsics.areEqual(r9, r11)) == false) goto L20;
        r3.f(r8.booleanValue());
        goto L20
    L30:
        r11 = null;
    L26:
        r9 = null;
        goto L27
    L44:
        return;
    L40:
        return;
    L43:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onEvent(h1 r9) {
        if (r9 == null) goto L16;
        int r10 = r9.a;
        if (r10 != 30) goto L10;
        if (Lists.isEmpty(this.b) == true) goto L8;
        ((MediaMultiAnchorWindowV2) ListProtector.get(this.b, 0)).r(false, this.b.size());
    L8:
        HashMap r11 = new HashMap();
        r11.put("interact_function", "anchor_connect");
        r11.put("anchor_status", "background");
        u.l().sendLog("livesdk_anchor_suspend_reminder_show", r11, new Object[]{x.class, Room.class});
        return;
    L10:
        if (r10 == 31) goto L12;
        return;
    L12:
        if (Lists.isEmpty(this.b) == true) goto L14;
        ((MediaMultiAnchorWindowV2) ListProtector.get(this.b, 0)).r(true, this.b.size());
    L14:
        HashMap r13 = new HashMap();
        r13.put("interact_function", "anchor_connect");
        r13.put("anchor_status", "suspend");
        u.l().sendLog("livesdk_anchor_suspend_reminder_show", r13, new Object[]{x.class, Room.class});
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.util.Map, java.util.Map<java.lang.String, ? extends com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.WindowsPosition>] */
    /* JADX WARN: Type inference failed for: r5v27, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.util.HashMap] */
    public final void p(String r25) {
        StringBuilder r1 = new StringBuilder("adjustWindowList ");
        r1.append(r25);
        r1.append(" windowCnt:");
        r1.append(this.b.size());
        r1.append(' ');
        ArrayList<MediaMultiAnchorWindowV2> r2 = this.b;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<MediaMultiAnchorWindowV2> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r3.add("Window" + r4.next().getLinkMicId());
        goto L4
    L6:
        r1.append(r3);
        ALogger.w("ttlive_media_anchor_link_wm", r1.toString());
        this.t.removeAllViews();
        MediaMultiAnchorTitleView r5 = this.j;
        if (r5 == null) goto L10;
        this.t.removeView(r5.getView());
        A(MediaMultiLinkAnchorWindowManager$reLayoutTitleView$1.INSTANCE);
        FrameLayout r6 = this.t;
        View r7 = r5.getView();
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -2);
        r8.gravity = 1;
        r8.topMargin = s();
        r6.addView(r7, r8);
    L10:
        MediaMultiAnchorTitleView r9 = this.j;
        if (r9 == null) goto L16;
        View r10 = r9.getView();
        if (r10 == null) goto L16;
        r10.bringToFront();
    L16:
        if (this.b.size() == 1) goto L18;
    L24:
        List<String> r11 = v();
        gy.c.c2.getClass();
        gy.c r13 = gy.c.a.a();
        if (r13 == null) goto L27;
        gy.f r14 = r13.getRtcManager();
    L28:
        ArrayList r15 = (ArrayList) r11;
        Iterator r16 = r15.iterator();
    L30:
        if (r16.hasNext() == false) goto L42;
        String r17 = (String) r16.next();
        if (r14 == null) goto L30;
        s r18 = r14.L();
        if (r18 == null) goto L30;
        r r19 = r18.e(r17);
        if (r19 == null) goto L30;
        Pair r110 = r19.a.i;
        if (r110 == null) goto L30;
        MediaMultiAnchorWindowV2 r20 = t(r17);
        if (r20 == null) goto L30;
        r20.setDebugText(((Number) r110.getFirst()).intValue() + " x " + ((Number) r110.getSecond()).intValue());
        goto L30
    L42:
        x82.d.z2.getClass();
        x82.d r21 = x82.d.a.a();
        if (r21 == null) goto L47;
        ?? r23 = r21.gc(r11);
        if (r23 == 0) goto L47;
    L91:
        Iterator<MediaMultiAnchorWindowV2> r24 = this.b.iterator();
    L93:
        if (r24.hasNext() == false) goto L161;
        MediaMultiAnchorWindowV2 r26 = r24.next();
        WindowsPosition r111 = (WindowsPosition) r23.get(r26.getInteractId());
        f92.f r112 = r();
        if (r111 != null) goto L97;
    L149:
        MediaMultiAnchorWindowV2 r27 = r26;
    L150:
        String r28 = r27.getInteractId();
        if (r28 != null) goto L153;
        String r113 = "0";
    L154:
        WindowsPosition r29 = (WindowsPosition) r23.get(r113);
        if (r29 == null) goto L93;
        WindowLayoutType r30 = (WindowLayoutType) ArraysKt.getOrNull(WindowLayoutType.values(), r().c(r29).b());
        if (r30 != null) goto L159;
        r30 = WindowLayoutType.Normal;
    L159:
        r27.setWindowLayoutType(r30);
        goto L93
    L153:
        r113 = r28;
        goto L154
    L97:
        if (r111 == WindowsPosition.IGNORE) goto L149;
        f92.i r114 = r112.c(r111);
        Intrinsics.checkNotNullParameter(r111, "windowsPosition");
        double r115 = r112.b(r111).c();
        Intrinsics.checkNotNullParameter(r111, "windowsPosition");
        double r116 = r112.b(r111).b();
        WindowsPosition r31 = WindowsPosition.SINGLE;
        if (r111 != r31) goto L102;
        WindowsPosition r117 = WindowsPosition.TWO_LEFT;
        f92.i r118 = r112.c(r117);
        Intrinsics.checkNotNullParameter(r117, "windowsPosition");
        double r119 = r112.b(r117).c();
        Intrinsics.checkNotNullParameter(r117, "windowsPosition");
        double r120 = r112.b(r117).b();
        r114 = r118;
        r115 = r119;
    L103:
        FrameLayout.LayoutParams r121 = new FrameLayout.LayoutParams((int) (((double) this.d) * r114.d()), (int) (((double) this.e) * r114.a()));
        r121.topMargin = (int) (((double) this.e) * r114.f());
        r121.leftMargin = (int) (((double) this.d) * r114.e());
        this.t.addView(r26, 0, r121);
        if (r111 == r31) goto L149;
        String r33 = r26.getInteractId();
        float r34 = (float) r114.e();
        float r35 = (float) (r114.e() + r114.d());
        float r36 = (float) r120;
        float r37 = ((float) (r114.f() - r115)) / r36;
        double r122 = r114.f() + r114.a();
        r27 = r26;
        f92.i r123 = r114;
        StringBuilder r124 = new StringBuilder("updateLayer ");
        r124.append(r33);
        r124.append("---  left: ");
        r124.append(r34);
        r124.append(", right: ");
        r124.append(r35);
        r124.append(", top:");
        r124.append(r37);
        r124.append(", bottom: ");
        r124.append(((float) (r122 - r115)) / r36);
        r124.append("---");
        gy.c.c2.getClass();
        gy.c r38 = gy.c.a.a();
        if (r38 == null) goto L112;
        gy.f r39 = r38.getRtcManager();
        if (r39 == null) goto L112;
        if (r39.G() != true) goto L112;
        boolean r40 = true;
    L113:
        r124.append(r40);
        ALogger.d("ttlive_media_anchor_link_wm", r124.toString());
        gy.c r41 = gy.c.a.a();
        if (r41 == null) goto L120;
        gy.f r43 = r41.getRtcManager();
        if (r43 == null) goto L120;
        if (r43.G() == true) goto L120;
    L148:
        ALogger.e("ttlive_media_anchor_link_wm", "windowPosition: " + r111 + ", left: " + ((float) r123.e()) + ", right:" + ((float) (r123.e() + r123.d())) + ", top: " + (((float) (r123.f() - r115)) / r36) + ", bottom: " + (((float) ((r123.f() + r123.a()) - r115)) / r36));
    L120:
        if (r33 == null) goto L148;
        z.a r44 = this.c.get(r33);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r45 = ILiveWrappedLivePusher.a.b();
        if (r45 == null) goto L126;
        m1.b r46 = null;
        m1.b r125 = r45.newVideoMixerDescription(null);
        if (r125 == null) goto L127;
        r125.e();
        r125.c();
        r125.b();
        r125.f();
        r125.i();
        r125.g();
        r125.h();
    L128:
        if (r44 == null) goto L148;
        m1.b r47 = r44.Y();
        if (r47 == null) goto L148;
        if (r125 == null) goto L148;
        if (r47.getLeft() == r125.getLeft()) goto L137;
    L146:
        r44.b();
        goto L148
    L137:
        if (r47.getTop() != r125.getTop()) goto L146;
        if (r47.getRight() != r125.getRight()) goto L146;
        if (r47.getBottom() != r125.getBottom()) goto L146;
        if (r47.isVisible() != r125.isVisible()) goto L146;
        if (r47.getMode() == r125.getMode()) goto L148;
    L127:
        r125 = r46;
        goto L128
    L126:
        r46 = null;
    L112:
        r40 = false;
        goto L113
    L102:
        r120 = r116;
        goto L103
    L161:
        MediaMultiAnchorWindowV2 r48 = this.h;
        if (r48 == null) goto L167;
        String r49 = r48.getInteractId();
        if (r49 == null) goto L167;
        String r126 = r49;
    L168:
        WindowsPosition r50 = (WindowsPosition) r23.get(r126);
        if (r50 == null) goto L173;
        x82.e.A2.getClass();
        x82.e r51 = x82.e.a.a();
        if (r51 == null) goto L173;
        r51.of(r().c(r50).c());
    L173:
        this.s = r23;
        View r53 = new HSImageView(this.t.getContext());
        GenericDraweeHierarchy r54 = r53.getHierarchy();
        ScalingUtils.ScaleType r55 = ScalingUtils.ScaleType.FIT_XY;
        r54.setActualImageScaleType(r55);
        this.t.addView(r53, new FrameLayout.LayoutParams(-1, s()));
        ImageLoader.bindImage(r53, "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_top_bg_denoise2.png");
        View r56 = new HSImageView(this.t.getContext());
        r56.getHierarchy().setActualImageScaleType(r55);
        int r57 = (this.t.getHeight() - s()) - ((int) (r().d(this.b.size()) * ((double) this.e)));
        if (r57 > 0) goto L176;
        r57 = (s1.w() - s()) - ((int) (r().d(this.b.size()) * ((double) this.e)));
    L176:
        FrameLayout.LayoutParams r58 = new FrameLayout.LayoutParams(-1, r57);
        r58.topMargin = s() + ((int) (r().d(this.b.size()) * ((double) this.e)));
        this.t.addView(r56, r58);
        ImageLoader.bindImage(r56, "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_bottom_bg.png");
        Iterator<MediaMultiAnchorWindowV2> r59 = this.b.iterator();
    L178:
        if (r59.hasNext() == false) goto L191;
        MediaMultiAnchorWindowV2 r60 = r59.next();
        if (Intrinsics.areEqual(r60, this.h) == false) goto L188;
        if (this.b.size() != 3) goto L188;
        if (this.p != null) goto L189;
        r60.setCoverVisible(0);
        this.p = Observable.timer(5, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r60));
    L189:
        r60.q(this.b.size());
        r60.setTotalWindowCount(this.b.size());
    L188:
        r60.setCoverVisible(4);
        goto L189
    L191:
        if (this.b.size() <= 0) goto L225;
        ViewGroup.LayoutParams r61 = ((MediaMultiAnchorWindowV2) ListProtector.get(this.b, 0)).getLayoutParams();
        if (r61 == null) goto L224;
        FrameLayout.LayoutParams r63 = (FrameLayout.LayoutParams) r61;
        FrameLayout.LayoutParams r64 = new FrameLayout.LayoutParams(r63.width, r63.height);
        r64.topMargin = r63.topMargin;
        r64.leftMargin = r63.leftMargin;
        u1 r65 = new u1();
        r65.i = this.b.size();
        r65.f = 1;
        r65.h = r63.topMargin;
        r65.g = s() + ((int) (r().d(this.b.size()) * ((double) this.e)));
        r65.k = e92.m.a().ordinal();
        if (e92.m.a() != UILayout.Enlarge) goto L213;
        x82.d.z2.getClass();
        x82.d r66 = x82.d.a.a();
        if (r66 == null) goto L199;
        String r67 = r66.zd();
    L200:
        MediaMultiAnchorWindowV2 r68 = t(r67);
        if (r68 == null) goto L203;
        ViewGroup.LayoutParams r69 = r68.getLayoutParams();
    L205:
        if ((r69 instanceof FrameLayout.LayoutParams) == true) goto L207;
        ViewGroup.LayoutParams r70 = null;
    L208:
        FrameLayout.LayoutParams r71 = (FrameLayout.LayoutParams) r70;
        if (r71 == null) goto L211;
        int r73 = RangesKt.coerceAtLeast(((this.d - r71.width) - r71.leftMargin) - UtilityKotlinExtentionsKt.i(24), 0);
    L212:
        r65.l = r73;
        goto L213
    L211:
        r73 = 0;
        goto L212
    L207:
        r70 = r69;
        goto L208
    L203:
        r69 = null;
        goto L205
    L199:
        r67 = null;
    L213:
        gy.c.c2.getClass();
        gy.c r74 = gy.c.a.a();
        if (r74 == null) goto L220;
        gy.f r75 = r74.getRtcManager();
        if (r75 == null) goto L220;
        if (r75.G() == false) goto L220;
        r75.G();
        r64.height = (int) (r().d(this.b.size()) * ((double) this.e));
        r64.topMargin = s();
    L220:
        this.v.put("cmd_multi_state_change", r65);
        x82.e.A2.getClass();
        x82.e r76 = x82.e.a.a();
        if (r76 == null) goto L225;
        r76.ah();
        goto L225
    L224:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L225:
        MediaMultiAnchorLinkContext r77 = this.y;
        if (r77 == null) goto L232;
        m<Integer> r78 = r77.getWindowCount();
        if (r78 == null) goto L232;
        if (this.b.size() == ((Number) r78.getValue()).intValue()) goto L232;
        r78.setValue(Integer.valueOf(this.b.size()));
    L232:
        x82.b.u2.getClass();
        x82.b r79 = x82.b.a.a();
        if (r79 == null) goto L277;
        r79.f();
        return;
    L277:
        return;
    L167:
        r126 = "0";
    L47:
        p r80 = this.o;
        String r127 = u();
        r80.getClass();
        Intrinsics.checkNotNullParameter(r11, "linkIdList");
        if (TextUtils.isEmpty(r127) == true) goto L50;
    L52:
        r23 = new HashMap();
        if (r15.size() != 1) goto L56;
        r23.put(ListProtector.get(r11, 0), WindowsPosition.SINGLE);
        goto L91
    L56:
        if (r15.size() != 2) goto L65;
        Iterator r81 = r15.iterator();
    L59:
        if (r81.hasNext() == false) goto L91;
        String r83 = (String) r81.next();
        if (TextUtils.equals(r127, r83) == true) goto L62;
        r23.put(r83, WindowsPosition.TWO_RIGHT);
        goto L59
    L62:
        r23.put(r83, WindowsPosition.TWO_LEFT);
        goto L59
    L65:
        if (r15.size() != 3) goto L76;
        Iterator r84 = r15.iterator();
        boolean r85 = false;
    L68:
        if (r84.hasNext() == false) goto L91;
        String r128 = (String) r84.next();
        if (TextUtils.equals(r127, r128) == true) goto L71;
        if (r85 == false) goto L73;
        r23.put(r128, WindowsPosition.THREE_RIGHT_BOTTOM);
        goto L68
    L73:
        r23.put(r128, WindowsPosition.THREE_RIGHT_TOP);
        r85 = true;
        goto L68
    L71:
        r23.put(r128, WindowsPosition.THREE_LEFT);
        goto L68
    L76:
        if (r15.size() < 4) goto L91;
        Iterator r86 = r15.iterator();
        int r87 = 0;
    L79:
        if (r86.hasNext() == false) goto L91;
        String r129 = (String) r86.next();
        if (TextUtils.equals(r127, r129) == true) goto L82;
        if (r87 != 0) goto L85;
        r23.put(r129, WindowsPosition.FOUR_RIGHT_TOP);
    L90:
        r87 = r87 + 1;
        goto L79
    L85:
        if (r87 != 1) goto L87;
        r23.put(r129, WindowsPosition.FOUR_RIGHT_BOTTOM);
        goto L90
    L87:
        if (r87 != 2) goto L89;
        r23.put(r129, WindowsPosition.FOUR_LEFT_BOTTOM);
        goto L90
    L89:
        r23.put(r129, WindowsPosition.IGNORE);
        goto L90
    L82:
        r23.put(r129, WindowsPosition.FOUR_LEFT_TOP);
        goto L79
    L50:
        if (Lists.isEmpty(r11) == true) goto L52;
        r127 = (String) ListProtector.get(r11, 0);
        goto L52
    L27:
        r14 = null;
        goto L28
    L18:
        if (this.i != null) goto L24;
        f92.f r88 = r();
        View r89 = LayoutInflater.from(this.t.getContext()).inflate(2131567776, this.t, false);
        if (r89 == null) goto L23;
        ViewGroup r90 = (ViewGroup) r89;
        this.i = r90;
        r1.b(r90.findViewById(2131362934), this.a);
        f92.i r91 = r88.c(WindowsPosition.TWO_RIGHT);
        FrameLayout.LayoutParams r93 = new FrameLayout.LayoutParams((int) this.f, (int) this.g);
        r93.topMargin = (int) (((double) this.e) * r91.f());
        r93.leftMargin = (int) (((double) this.d) * r91.e());
        this.t.addView(this.i, 0, r93);
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final MediaMultiAnchorWindowV2 t(String r5) {
        Iterator<MediaMultiAnchorWindowV2> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        MediaMultiAnchorWindowV2 r1 = r0.next();
        if (q0.a("0") == false) goto L11;
        if (Intrinsics.areEqual(r1.getUid(), "0") == false) goto L11;
        return r1;
    L11:
        if (TextUtils.equals(r1.getInteractId(), r5) == false) goto L4;
        return r1;
    L13:
        return null;
    }

    public final void w(String r9) {
        int r0 = ((ArrayList) v()).size();
        if (r0 == this.q) goto L22;
        this.q = r0;
        MediaMultiEnlargeWidget r2 = this.x;
        if (r2 == null) goto L22;
        AnchorUpdateLayoutContent.AnchorLayoutRange r1 = AnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        AnchorUpdateLayoutContent.UpdateAnchorLayoutType r3 = AnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown;
        if (r0 < 4) goto L19;
        x82.e.a r4 = x82.e.A2;
        r4.getClass();
        x82.e r5 = x82.e.a.a();
        if (r5 == null) goto L12;
        UILayout r6 = r5.getDefaultUILayout();
    L14:
        if (r6 != UILayout.Enlarge) goto L16;
        r2.xq(true, ey.c.b(), true, "default enlarge", false);
        goto L22
    L16:
        r2.d = false;
        r2.c = BuildConfig.FLAVOR;
        r2.e = false;
        r4.getClass();
        x82.e r7 = x82.e.a.a();
        if (r7 == null) goto L22;
        r7.kg(UILayout.Normal, "default UILayout is normal", false);
        goto L22
    L12:
        r6 = null;
        goto L14
    L19:
        r2.d = false;
        r2.c = BuildConfig.FLAVOR;
        r2.e = false;
        x82.e.A2.getClass();
        x82.e r8 = x82.e.a.a();
        if (r8 == null) goto L22;
        r8.kg(UILayout.Normal, "windowCount < 4", false);
    L22:
        p(r9);
    }

    public final void z(String r5) {
        MediaMultiAnchorWindowV2 r0 = t(r5);
        ArrayList<MediaMultiAnchorWindowV2> r1 = this.b;
        if (r1 == null) goto L23;
        boolean r2 = TypeIntrinsics.asMutableCollection(r1).remove(r0);
        StringBuilder r3 = new StringBuilder("remove window removed:");
        r3.append(r2);
        r3.append(' ');
        r3.append(r5);
        r3.append(' ');
        if (r0 == null) goto L7;
        String r4 = r0.g();
    L8:
        r3.append(r4);
        ALogger.i("ttlive_media_anchor_link_wm", r3.toString());
        z.a r6 = this.c.get(r5);
        if (r6 == null) goto L20;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r7 = ILiveWrappedLivePusher.a.b();
        if (r7 == null) goto L15;
        m1.b r8 = r7.newVideoMixerDescription(null);
        if (r8 == null) goto L15;
        r8.i();
    L15:
        r6.b();
        HashMap<String, z.a> r9 = this.c;
        if (r9 == null) goto L19;
        z.a r10 = (z.a) TypeIntrinsics.asMutableMap(r9).remove(r5);
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L20:
        w("rtcUserLeave");
        return;
    L7:
        r4 = null;
        goto L8
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    public final void d(int r14, List<AnchorLinkUser> r15) {
        if (r15 == null) goto L56;
        int r16 = r15.size();
        int r1 = 0;
    L4:
        if (r1 >= r16) goto L73;
        AnchorLinkUser r2 = (AnchorLinkUser) ListProtector.get(r15, r1);
        AnchorLinkMicIdInfo r3 = r2.getAnchorLinkMicIdInfo();
        if (r3 == null) goto L34;
        ArrayList<MediaMultiAnchorWindowV2> r6 = this.b;
        ArrayList r7 = new ArrayList();
        Iterator<MediaMultiAnchorWindowV2> r8 = r6.iterator();
    L8:
        boolean r9 = true;
        if (r8.hasNext() == false) goto L19;
        MediaMultiAnchorWindowV2 r10 = r8.next();
        MediaMultiAnchorWindowV2 r11 = r10;
        if (Intrinsics.areEqual(r3.mainLinkMicId, r11.getInteractId()) == false) goto L13;
    L16:
        if (r9 == false) goto L8;
        r7.add(r10);
        goto L8
    L13:
        if (Intrinsics.areEqual(r3.backupLinkMicId, r11.getInteractId()) == true) goto L16;
        r9 = false;
        goto L16
    L19:
        if (r7.size() <= 1) goto L34;
        Iterator r13 = r7.iterator();
    L22:
        if (r13.hasNext() == false) goto L34;
        MediaMultiAnchorWindowV2 r17 = (MediaMultiAnchorWindowV2) r13.next();
        if ((!Intrinsics.areEqual(r17.getInteractId(), r3.getInUseLinkMicId())) == false) goto L22;
        ALogger.e("ttlive_media_anchor_link_wm", "remove duplicate window " + r17.g() + " when onlineListChanged, " + r3);
        this.b.remove(r17);
        z.a r18 = this.c.get(r17.getInteractId());
        if (r18 == null) goto L33;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r19 = ILiveWrappedLivePusher.a.b();
        if (r19 == null) goto L32;
        m1.b r110 = r19.newVideoMixerDescription(null);
        if (r110 == null) goto L32;
        r110.i();
    L32:
        r18.b();
    L33:
        w("removeDuplicateWindow_" + r17.getInteractId());
    L34:
        Iterator<MediaMultiAnchorWindowV2> r4 = this.b.iterator();
    L36:
        if (r4.hasNext() == false) goto L55;
        MediaMultiAnchorWindowV2 r20 = r4.next();
        if (TextUtils.equals(r2.getInteractId(), r20.getInteractId()) == true) goto L46;
        AnchorLinkMicIdInfo r21 = r2.getAnchorLinkMicIdInfo();
        if (r21 == null) goto L42;
        String r23 = r21.backupLinkMicId;
    L44:
        if (TextUtils.equals(r23, r20.getInteractId()) == false) goto L36;
    L42:
        r23 = null;
    L46:
        if (r20.getAnchorLinkUser() == null) goto L48;
    L54:
        AnchorLinkUser r5 = (AnchorLinkUser) ListProtector.get(r15, r1);
        this.b.size();
        r20.s(r5);
        goto L55
    L48:
        if (r2.getAnchorLinkMicIdInfo() == null) goto L54;
        AnchorLinkMicIdInfo r24 = r2.getAnchorLinkMicIdInfo();
        if (r24 == null) goto L54;
        ALogger.e("ttlive_media_anchor_link_wm", "ensureStreamStateWhenFirstSetLinkUser " + r20.g() + ' ' + r2.toSimpleString() + ' ' + r24);
        x82.b.u2.getClass();
        x82.b r25 = x82.b.a.a();
        if (r25 == null) goto L54;
        r25.D6();
    L55:
        r1 = r1 + 1;
        goto L4
    L73:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.window.a
    public final void g(UILayout r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uiLayout");
        Intrinsics.checkNotNullParameter(r3, "source");
        p(r3);
    }

    public final MediaMultiAnchorWindowV2 q(Context r9, String r10, AnchorLinkUser r11) {
        if (r11 == null) goto L12;
        Intrinsics.checkNotNullParameter(r11, "$this$backupLinkMicIdEquals");
        AnchorLinkMicIdInfo r0 = r11.getAnchorLinkMicIdInfo();
        if (r0 != null) goto L6;
    L9:
        boolean r1 = false;
    L10:
        if (r1 != true) goto L12;
        String r2 = r11.getInteractId();
        ALogger.e("ttlive_media_anchor_link_wm", "backup window must use mainLinkMicId " + r10 + " -> " + r2);
        String r5 = r2;
    L14:
        return new MediaMultiAnchorWindowV2(r9, this.v, r5, jm2.a.d(r11), this);
    L6:
        if (Intrinsics.areEqual(r0.backupLinkMicId, r10) == false) goto L9;
        if (r10 == null) goto L9;
        r1 = true;
    L12:
        r5 = r10;
        goto L14
    }

    public final void x(String r6, View r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "reqSrc");
        AnchorLinkUser r0 = null;
        if (r7 == null) goto L5;
        String r1 = r7.getClass().getSimpleName();
    L6:
        hy.e r2 = this.w;
        if (r2 == null) goto L9;
        r0 = r2.f(r6, true);
    L9:
        MediaMultiAnchorWindowV2 r3 = q(this.t.getContext(), r6, r0);
        hy.e r4 = this.w;
        if (r4 == null) goto L14;
        List r5 = r4.getOnlineUserList();
        if (r5 == null) goto L14;
        r5.size();
    L14:
        r3.s(r0);
        if (r7 != null) goto L17;
        this.h = r3;
    L17:
        MediaMultiAnchorWindowV2 r9 = t(r6);
        if (r9 == null) goto L20;
        ALogger.e("ttlive_media_anchor_link_wm", "onUserJoin" + r1 + ' ' + r8 + ", remove " + r6 + ' ' + r3.g());
        this.b.remove(r9);
    L20:
        if (r7 == null) goto L28;
        r3.removeView(r3.a);
        ViewParent r10 = r7.getParent();
        if (r10 != null) goto L25;
    L27:
        r7.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Unit r11 = Unit.INSTANCE;
        r3.a = r7;
        r3.addView(r7, 0);
        goto L28
    L25:
        if ((r10 instanceof ViewGroup) == false) goto L27;
        ((ViewGroup) r10).removeView(r7);
    L28:
        this.b.add(r3);
        w("onFirstFrame");
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void y(String r4, z.a r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "reqSrc");
        if (r4 == null) goto L5;
        this.c.put(r4, r5);
    L5:
        hy.e r7 = this.w;
        if (r7 == null) goto L8;
        AnchorLinkUser r8 = r7.f(r4, true);
    L9:
        MediaMultiAnchorWindowV2 r0 = q(this.t.getContext(), r4, r8);
        hy.e r1 = this.w;
        if (r1 == null) goto L14;
        List r2 = r1.getOnlineUserList();
        if (r2 == null) goto L14;
        r2.size();
    L14:
        r0.s(r8);
        String r9 = MediaMultiAnchorLinkContext.Companion.b();
        if (r9 != null) goto L18;
        r9 = u();
    L18:
        if (TextUtils.equals(r9, r4) == false) goto L20;
        this.h = r0;
    L20:
        MediaMultiAnchorWindowV2 r10 = t(r4);
        if (r10 == null) goto L23;
        ALogger.e("ttlive_media_anchor_link_wm", "onUserJoinLayer " + r6 + ", remove " + r4 + ' ' + r0.g());
        this.b.remove(r10);
    L23:
        this.b.add(r0);
        w("onFirstLayer_".concat(r6));
        return;
    L8:
        r8 = null;
        goto L9
    }

    public MediaMultiLinkAnchorWindowManager(FrameLayout r1, RoomContext r2, DataCenter r3, hy.e r4, gy.f r5, MediaMultiEnlargeWidget r6, MediaMultiAnchorLinkContext r7, LifecycleOwner r8) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "lifecycleOwner");
        this.t = r1;
        this.u = r2;
        this.v = r3;
        this.w = r4;
        this.x = r6;
        this.y = r7;
        this.a = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/dy_pk_rematch_loading.webp";
        this.b = new ArrayList();
        this.c = new HashMap();
        int r9 = Math.min(UIUtils.getScreenWidth(s1.getContext()), UIUtils.getScreenHeight(s1.getContext()));
        this.d = r9;
        int r10 = (r9 * 16) / 9;
        this.e = r10;
        this.f = ((double) r9) * 0.49583333333333335d;
        int r11 = f92.c.i;
        this.g = ((double) r10) * 0.40286458333333336d;
        this.k = new CompositeDisposable();
        this.m = r8;
        this.n = new HashMap();
        this.o = new p();
        new f92.g();
        this.r = new com.bytedance.android.livesdk.interactivity.medialink.contract.h(true);
    }
}
