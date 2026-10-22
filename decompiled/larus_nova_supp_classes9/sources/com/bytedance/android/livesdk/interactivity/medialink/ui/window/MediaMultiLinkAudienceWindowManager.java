package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.MaybeSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.logs.MediaMultiEnterRoomTracer;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorTitleView;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.AnchorInteractInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import y82.m;
import y82.n;
import y82.o;
import zg1.f0;
import zg1.h1;
import zg1.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0001\u000eJ\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/MediaMultiLinkAudienceWindowManager;", "Lhy/f$a;", "Lmd0/a$a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Ly82/o;", "Ly82/a;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/a;", "Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/l;", "Lzg1/h1;", "event", BuildConfig.FLAVOR, "onEvent", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkAudienceWindowManager extends hy.f.a implements md0.a.a, Observer<KVData>, o, y82.a, com.bytedance.android.livesdk.interactivity.medialink.ui.window.a, l {
    public static final /* synthetic */ int C = 0;
    public final hy.e A;
    public final MediaMultiAnchorLinkContext B;
    public final float a;
    public final float b;
    public final com.bytedance.android.live.liveinteract.api.utils.j c;
    public final ArrayList<MediaMultiAnchorWindowV2> d;
    public y82.b e;
    public MediaMultiAnchorTitleView f;
    public final CompositeDisposable g;
    public Room h;
    public h1 i;
    public final LifecycleOwner j;
    public boolean k;
    public int l;
    public String m;
    public SeiAppData n;
    public Integer o;
    public Integer p;
    public boolean q;
    public final HashMap<String, Boolean> r;
    public int s;
    public n t;
    public final e92.n u;
    public final com.bytedance.android.livesdk.interactivity.medialink.contract.h v;
    public final b w;
    public final FrameLayout x;
    public final RoomContext y;
    public final DataCenter z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ MediaMultiLinkAudienceWindowManager a;

        public b(MediaMultiLinkAudienceWindowManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            KVData r9 = (KVData) r8;
            if (r9 != null) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual("cmd_gift_dialog_switch", r9.getKey()) == false) goto L41;
            MediaMultiLinkAudienceWindowManager r0 = this.a;
            f0 r10 = (f0) r9.getData();
            int r2 = MediaMultiLinkAudienceWindowManager.C;
            r0.getClass();
            if (r10 != null) goto L10;
            return;
        L10:
            if (FoldScreenUtils.f() == false) goto L12;
            return;
        L12:
            if (PadConfigUtils.c() == false) goto L15;
            return;
        L15:
            if (r0.d.size() != 3) goto L17;
            int r3 = r10.a;
            u1 r4 = (u1) r0.z.get("cmd_multi_state_change", null);
            int r5 = s1.w();
            if (r4 == null) goto L25;
            int r6 = r4.g;
        L26:
            int r7 = r5 - r6;
            if (r7 < r3) goto L29;
        L33:
            if (r3 == 0) goto L35;
        L39:
            r0.s = r3;
            return;
        L35:
            if (r10.b == true) goto L39;
            MediaMultiAnchorWindowV2 r11 = r0.j();
            if (r11 == null) goto L39;
            r11.l.getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.livesdk.interactivity.medialink.ui.g(r11, 0));
            goto L39
        L29:
            if (r3 == r0.s) goto L33;
            int r13 = r3 - r7;
            MediaMultiAnchorWindowV2 r14 = r0.j();
            if (r14 == null) goto L33;
            r14.l.getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.livesdk.interactivity.medialink.ui.g(r14, r13));
            goto L33
        L25:
            r6 = 0;
            goto L26
        L17:
            if ((!r0.d.isEmpty()) == false) goto L21;
            MediaMultiAnchorWindowV2 r15 = r0.j();
            if (r15 == null) goto L21;
            r15.l.getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.livesdk.interactivity.medialink.ui.g(r15, 0));
        L21:
            r0.s = 0;
            return;
        L41:
            if (Intrinsics.areEqual("data_video_size_pair", r9.getKey()) == false) goto L64;
            Pair r16 = (Pair) this.a.z.get("data_video_size_pair", new Pair(0, 0));
            int r1 = ((Number) r16.component1()).intValue();
            int r17 = ((Number) r16.component2()).intValue();
            Integer r18 = this.a.o;
            if (r18 != null) goto L46;
        L53:
            MediaMultiLinkAudienceWindowManager r19 = this.a;
            String r20 = r19.m;
            if (r20 == null) goto L65;
            y82.b r21 = r19.e;
            if (r21 == null) goto L58;
            r21.b(r19, r20);
        L58:
            this.a.s();
            this.a.o = Integer.valueOf(r1);
            this.a.p = Integer.valueOf(r17);
            return;
        L65:
            return;
        L46:
            if (r1 != r18.intValue()) goto L53;
            Integer r23 = this.a.p;
            if (r23 == null) goto L53;
            if (r17 != r23.intValue()) goto L53;
            return;
        }
    }

    static {
    }

    public final boolean isVersionSupported(int r1, int r2) {
        if (r1 != 19) goto L5;
        return true;
    L5:
        return false;
    }

    public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r1) {
    }

    @Override // y82.a
    public final com.bytedance.android.livesdk.interactivity.medialink.ui.o f() {
        if (PadConfigUtils.c() == true) goto L6;
        return new com.bytedance.android.livesdk.interactivity.medialink.ui.o(false, 0, null, null, null);
    L6:
        if (this.q == false) goto L9;
        return new com.bytedance.android.livesdk.interactivity.medialink.ui.o(true, s1.f(this.a), 2131249584, Integer.valueOf(UtilityKotlinExtentionsKt.i(32)), Integer.valueOf(UtilityKotlinExtentionsKt.i(112)));
    L9:
        return new com.bytedance.android.livesdk.interactivity.medialink.ui.o(true, s1.f(this.b), 2131249584, Integer.valueOf(UtilityKotlinExtentionsKt.i(32)), Integer.valueOf(UtilityKotlinExtentionsKt.i(112)));
    }

    @Override // y82.a
    public final int h() {
        return this.d.size();
    }

    @Override // y82.a
    public final boolean isPortrait() {
        int r0 = this.l;
        if (r0 != (-1)) goto L8;
        if (e5.n() == false) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (e5.o(r0) == true) goto L10;
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.window.a
    public final MediaMultiAnchorWindowV2 j() {
        Iterator<MediaMultiAnchorWindowV2> r0 = this.d.iterator();
    L3:
        String r2 = null;
        if (r0.hasNext() == false) goto L17;
        MediaMultiAnchorWindowV2 r1 = r0.next();
        AnchorLinkUser r3 = r1.getAnchorLinkUser();
        if (r3 == null) goto L10;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L10;
        String r5 = r4.getIdString();
    L11:
        Room r6 = this.h;
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
        if (this.q == false) goto L6;
        return s1.f(this.a);
    L6:
        return s1.f(this.b);
    }

    @Override // y82.a
    public final boolean m() {
        Activity r0 = ContextUtil.contextToActivity(this.x.getContext());
        if (r0 != null) goto L6;
        return false;
    L6:
        if ((r0.getWindow().getAttributes().flags & 1024) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final void s() {
        y82.b r0 = this.e;
        if (r0 == null) goto L14;
        u1 r1 = r0.c(this);
        if (r1 == null) goto L16;
        Pair r2 = new Pair(Integer.valueOf(r1.g), this.z.get("data_pk_renderview_width", 0));
        this.z.put("cmd_multi_state_change", r1);
        this.z.put("cmd_adjust_video_interact_stream_bottom", r2);
        View r3 = (HSImageView) this.x.findViewById(2131389668);
        if (r3 == null) goto L10;
        this.x.removeView(r3);
    L10:
        View r4 = (HSImageView) this.x.findViewById(2131389666);
        if (r4 == null) goto L15;
        this.x.removeView(r4);
        return;
    L15:
        return;
    L16:
        return;
    }

    @Override // y82.a
    public final List<MediaMultiAnchorWindowV2> n() {
        return this.d;
    }

    @Override // y82.o
    public final void i(m r1) {
        this.e = r1;
        onSeiUpdated(this.n);
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
        if (wt2.a.f(Boolean.FALSE) == false) goto L43;
        Boolean r8 = (Boolean) r7.getData();
        if (r8 == null) goto L40;
        Iterator<MediaMultiAnchorWindowV2> r2 = this.d.iterator();
    L20:
        if (r2.hasNext() == false) goto L44;
        MediaMultiAnchorWindowV2 r3 = r2.next();
        AnchorLinkUser r4 = r3.getAnchorLinkUser();
        if (r4 == null) goto L26;
        User r5 = r4.getMUser();
        if (r5 == null) goto L26;
        String r9 = r5.getIdString();
    L27:
        Room r10 = this.h;
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
        if (r9 == null) goto L20;
        this.i = r9;
        int r10 = r9.a;
        if (r10 != 30) goto L12;
        if (Lists.isEmpty(this.d) == true) goto L10;
        MediaMultiAnchorWindowV2 r11 = j();
        if (r11 == null) goto L10;
        r11.r(false, this.d.size());
    L10:
        HashMap r13 = new HashMap();
        r13.put("interact_function", "anchor_connect");
        r13.put("anchor_status", "background");
        u.l().sendLog("livesdk_anchor_suspend_reminder_show", r13, new Object[]{x.class, Room.class});
        return;
    L12:
        if (r10 == 31) goto L14;
        return;
    L14:
        if (Lists.isEmpty(this.d) == true) goto L18;
        MediaMultiAnchorWindowV2 r14 = j();
        if (r14 == null) goto L18;
        r14.r(true, this.d.size());
    L18:
        HashMap r15 = new HashMap();
        r15.put("interact_function", "anchor_connect");
        r15.put("anchor_status", "suspend");
        u.l().sendLog("livesdk_anchor_suspend_reminder_show", r15, new Object[]{x.class, Room.class});
        return;
    }

    public final void onSeiUpdated(SeiAppData r19) {
        SeiAppData r1 = r19;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r1, "$this$sortGrids");
        List r3 = r19.getGrids();
        if (r3 == null) goto L7;
        CollectionsKt.sortWith(r3, e92.o.a);
    L7:
        Unit r4 = Unit.INSTANCE;
    L9:
        boolean r5 = isPortrait();
        this.q = r5;
        n r6 = this.t;
        if (r6 == null) goto L12;
        r6.b(r5);
    L12:
        y82.b r7 = this.e;
        this.k = true;
        this.n = r1;
        if (r1 == null) goto L179;
        MediaMultiEnterRoomTracer.MultiLoadSource r8 = MediaMultiEnterRoomTracer.a;
        MediaMultiEnterRoomTracer.g = System.currentTimeMillis();
        ALogger.w("MediaLinkEnterRoomTracer", "seiUpdateStart source=" + MediaMultiEnterRoomTracer.a);
        Iterator<Map.Entry<String, Boolean>> r9 = this.r.entrySet().iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        this.r.put(r9.next().getKey(), Boolean.FALSE);
        goto L16
    L18:
        x82.e.A2.getClass();
        x82.e r10 = x82.e.a.a();
        if (r10 == null) goto L22;
        r10.Oe(r1);
    L22:
        if (r1.getGrids() == null) goto L98;
        Iterator r11 = r1.getGrids().iterator();
        int r13 = 0;
    L25:
        if (r11.hasNext() == false) goto L98;
        SeiRegion r14 = (SeiRegion) r11.next();
        if (this.r.containsKey(r14.getInteractId()) == false) goto L96;
        MediaMultiAnchorWindowV2 r15 = q(r14.getInteractId());
        if (r15 == null) goto L31;
        SeiRegion r16 = r15.getMSeiRegion();
    L32:
        if (r16 != null) goto L35;
    L44:
        boolean r17 = true;
    L45:
        if (r17 == false) goto L51;
        this.x.removeView(r15);
        ArrayList<MediaMultiAnchorWindowV2> r18 = this.d;
        if (r18 == null) goto L50;
        TypeIntrinsics.asMutableCollection(r18).remove(r15);
        p(r14, r1, r13);
    L93:
        if (r15 == null) goto L95;
        r15.setMSeiRegion(r14);
        r15.setMPosition(Integer.valueOf(r13));
    L95:
        this.r.put(r14.getInteractId(), Boolean.TRUE);
    L97:
        r13 = r13 + 1;
        goto L25
    L50:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L51:
        if (r15 == null) goto L93;
        hy.e r110 = this.A;
        if (r110 == null) goto L55;
        AnchorLinkUser r111 = r110.f(r14.getInteractId(), false);
    L56:
        hy.e r112 = this.A;
        if (r112 == null) goto L61;
        List r113 = r112.getOnlineUserList();
        if (r113 == null) goto L61;
        r113.size();
    L61:
        r15.s(r111);
        if (r15.p == false) goto L64;
    L72:
        r15.p(r14.isMuteAudio());
        AnchorLinkUser r114 = r15.getAnchorLinkUser();
        if (r114 == null) goto L77;
        User r115 = r114.getMUser();
        if (r115 == null) goto L77;
        String r116 = r115.getIdString();
    L78:
        Room r117 = this.h;
        if (r117 == null) goto L81;
        String r118 = r117.getOwnerUserIdString();
    L83:
        if ((!Intrinsics.areEqual(r116, r118)) == false) goto L93;
        AnchorInteractInfo r119 = r1.getAnchorInteractInfo();
        if (r119 == null) goto L89;
        if (r13 == r119.getOwnerIndex()) goto L93;
    L89:
        if (r14.getStatus() != 0) goto L91;
        boolean r120 = true;
    L92:
        r15.r(r120, r1.getGrids().size());
        goto L93
    L91:
        r120 = false;
        goto L92
    L81:
        r118 = null;
    L77:
        r116 = null;
        goto L78
    L64:
        if (r14.isMuteAudio() == false) goto L72;
        Object[] r121 = new Object[1];
        AnchorLinkUser r122 = r15.getAnchorLinkUser();
        if (r122 == null) goto L70;
        IBaseUser r123 = r122.getUser();
        if (r123 == null) goto L70;
        String r124 = r123.getRealNickName();
    L71:
        r121[0] = r124;
        f2.c(s1.C(2131920252, r121), 0);
    L70:
        r124 = null;
        goto L71
    L55:
        r111 = null;
        goto L56
    L35:
        if (r16.getX() != r14.getX()) goto L44;
        if (r16.getY() != r14.getY()) goto L44;
        if (r16.getWidth() != r14.getWidth()) goto L44;
        if (r16.getHeight() != r14.getHeight()) goto L44;
        r17 = false;
        goto L45
    L31:
        r16 = null;
        goto L32
    L96:
        p(r14, r1, r13);
    L98:
        String r20 = this.m;
        if (r20 == null) goto L102;
        if (r7 == null) goto L102;
        r7.b(this, r20);
    L102:
        Iterator<Map.Entry<String, Boolean>> r21 = this.r.entrySet().iterator();
    L104:
        if (r21.hasNext() == false) goto L116;
        Map.Entry<String, Boolean> r23 = r21.next();
        String r24 = r23.getKey();
        if (r23.getValue().booleanValue() == true) goto L104;
        MediaMultiAnchorWindowV2 r25 = q(r24);
        this.x.removeView(r25);
        ArrayList<MediaMultiAnchorWindowV2> r26 = this.d;
        if (r26 == null) goto L115;
        TypeIntrinsics.asMutableCollection(r26).remove(r25);
        StringBuilder r27 = new StringBuilder("remove ");
        if (r25 == null) goto L112;
        String r28 = r25.g();
    L113:
        r27.append(r28);
        r27.append(" not in windowsMap ");
        r27.append(this.r);
        ALogger.w("ttlive_anchor_link_wm", r27.toString());
        goto L104
    L112:
        r28 = null;
        goto L113
    L115:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L116:
        List r2 = r1.getGrids();
        if (r2 == null) goto L150;
        Iterator r29 = r2.iterator();
    L120:
        if (r29.hasNext() == false) goto L150;
        SeiRegion r30 = (SeiRegion) r29.next();
        MediaMultiAnchorWindowV2 r31 = q(r30.getInteractId());
        if (r31 == null) goto L148;
        String r33 = r30.getInteractId();
        AnchorInteractInfo r34 = r1.getAnchorInteractInfo();
        if (r34 == null) goto L126;
        int r35 = r34.getLayoutType();
    L127:
        if (r35 == 1) goto L129;
        UILayout r36 = UILayout.Normal;
    L130:
        AnchorInteractInfo r37 = r1.getAnchorInteractInfo();
        if (r37 == null) goto L134;
        String r38 = r37.getFocusID();
        if (r38 == null) goto L134;
    L135:
        if (r33 != null) goto L141;
        if (r36 != UILayout.Enlarge) goto L139;
        WindowLayoutType r39 = WindowLayoutType.EnlargeSmall;
    L147:
        r31.setWindowLayoutType(r39);
        goto L148
    L139:
        r39 = WindowLayoutType.Normal;
        goto L147
    L141:
        if (r36 == UILayout.Enlarge) goto L143;
        r39 = WindowLayoutType.Normal;
        goto L147
    L143:
        if (Intrinsics.areEqual(r33, r38) == false) goto L145;
        r39 = WindowLayoutType.EnlargeBig;
        goto L147
    L145:
        r39 = WindowLayoutType.EnlargeSmall;
    L134:
        r38 = BuildConfig.FLAVOR;
        goto L135
    L129:
        r36 = UILayout.Enlarge;
        goto L130
    L126:
        r35 = 0;
    L148:
        if (r31 == null) goto L120;
        r31.setTotalWindowCount(this.d.size());
    L150:
        MediaMultiAnchorLinkContext r40 = this.B;
        if (r40 == null) goto L157;
        com.bytedance.live.datacontext.m<Integer> r41 = r40.getWindowCount();
        if (r41 == null) goto L157;
        if (this.d.size() == ((Number) r41.getValue()).intValue()) goto L157;
        r41.setValue(Integer.valueOf(this.d.size()));
    L157:
        s();
        onEvent(this.i);
        if (this.d.size() > 0) goto L160;
        return;
    L160:
        if (MediaMultiEnterRoomTracer.h != 0) goto L181;
        MediaMultiEnterRoomTracer.h = System.currentTimeMillis();
        ALogger.w("MediaLinkEnterRoomTracer", "seiUpdateDone source=" + MediaMultiEnterRoomTracer.a);
        MediaMultiEnterRoomTracer.a();
        return;
    L181:
        return;
    L179:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final MediaMultiAnchorWindowV2 q(String r5) {
        Iterator<MediaMultiAnchorWindowV2> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        MediaMultiAnchorWindowV2 r1 = r0.next();
        o0.a.getClass();
        if (o0.a.b("0") == false) goto L11;
        if (Intrinsics.areEqual(r1.getUid(), "0") == false) goto L11;
        return r1;
    L11:
        if (TextUtils.equals(r1.getInteractId(), r5) == false) goto L4;
        return r1;
    L13:
        return null;
    }

    public final void d(int r6, List<AnchorLinkUser> r7) {
        if (r7 == null) goto L12;
        int r8 = r7.size();
        int r0 = 0;
    L4:
        if (r0 >= r8) goto L18;
        Iterator<MediaMultiAnchorWindowV2> r1 = this.d.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        MediaMultiAnchorWindowV2 r2 = r1.next();
        if (TextUtils.equals(((AnchorLinkUser) ListProtector.get(r7, r0)).getInteractId(), r2.getInteractId()) == false) goto L7;
        AnchorLinkUser r3 = (AnchorLinkUser) ListProtector.get(r7, r0);
        this.d.size();
        r2.s(r3);
    L11:
        r0 = r0 + 1;
        goto L4
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.window.a
    public final void g(UILayout r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "uiLayout");
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r3, "uiLayout");
        Intrinsics.checkNotNullParameter(r4, "source");
    }

    public final void p(SeiRegion r11, SeiAppData r13, int r14) {
        Context r2 = this.x.getContext();
        String r4 = r11.getInteractId();
        hy.e r0 = this.A;
        String r8 = null;
        if (r0 == null) goto L5;
        AnchorLinkUser r1 = r0.f(r11.getInteractId(), false);
    L6:
        MediaMultiAnchorWindowV2 r9 = new MediaMultiAnchorWindowV2(r2, this.z, r4, jm2.a.d(r1), this);
        hy.e r3 = this.A;
        if (r3 == null) goto L9;
        AnchorLinkUser r5 = r3.f(r11.getInteractId(), false);
    L10:
        hy.e r6 = this.A;
        if (r6 == null) goto L15;
        List r7 = r6.getOnlineUserList();
        if (r7 == null) goto L15;
        r7.size();
    L15:
        r9.s(r5);
        r9.p(r11.isMuteAudio());
        AnchorLinkUser r10 = r9.getAnchorLinkUser();
        if (r10 == null) goto L20;
        IBaseUser r15 = r10.getUser();
        if (r15 == null) goto L20;
        String r16 = r15.getIdString();
    L21:
        Room r17 = this.h;
        if (r17 == null) goto L24;
        r8 = r17.getOwnerUserIdString();
    L24:
        boolean r18 = true;
        if ((!Intrinsics.areEqual(r16, r8)) == false) goto L35;
        AnchorInteractInfo r19 = r13.getAnchorInteractInfo();
        if (r19 == null) goto L31;
        if (r14 == r19.getOwnerIndex()) goto L35;
    L31:
        if (r11.getStatus() == 0) goto L34;
        r18 = false;
    L34:
        r9.r(r18, r13.getGrids().size());
    L35:
        this.x.addView(r9, 0);
        if (PadConfigUtils.c() == false) goto L38;
        boolean r20 = this.q;
        r13.getGrids().size();
        r9.q = r20;
        r9.k();
    L38:
        this.d.add(r9);
        r9.setMSeiRegion(r11);
        r9.setMPosition(Integer.valueOf(r14));
        this.r.put(r11.getInteractId(), Boolean.TRUE);
        return;
    L20:
        r16 = null;
        goto L21
    L9:
        r5 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // y82.a
    public final void k(y82.d r4, final Integer r5, final Integer r6, final Integer r7) {
        Intrinsics.checkNotNullParameter(r4, "layoutData");
        MediaMultiAnchorTitleView r0 = this.f;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getView().getParent() != null) goto L8;
        this.x.addView(r0.getView());
    L8:
        y82.c.b(r0.getView(), r4);
        Function1<com.bytedance.android.livesdk.interactivity.medialink.contract.h, Unit> r8 = new MediaMultiLinkAudienceWindowManager$layoutTitleView$1(r5, r6, r7);
        Intrinsics.checkNotNullParameter(r8, "procedure");
        r8.invoke(this.v);
        MediaMultiAnchorTitleView r9 = this.f;
        if (r9 == null) goto L12;
        r9.setState(this.v);
        return;
    }

    public static void r(MediaMultiLinkAudienceWindowManager r16, String r17, boolean r18, boolean r19, int r20) {
        if ((r20 & 2) == 0) goto L5;
        boolean r2 = false;
    L7:
        if ((r20 & 4) == 0) goto L9;
        boolean r4 = false;
    L10:
        r16.u.getClass();
        if (r17 != null) goto L14;
    L50:
        Integer r5 = null;
    L51:
        if (r5 != null) goto L54;
    L56:
        r16.c.d(r17);
        if (r4 == true) goto L63;
        if (r2 == true) goto L63;
        if (r16.k == false) goto L74;
        ((MaybeSubscribeProxy) Single.just(r17).map(new f(r17)).filter(g.a).as(AutoDispose.bind(r16.j))).subscribe(new h(r16), i.a);
        return;
    L74:
        return;
    L63:
        ALogger.e("ttlive_anchor_link_wm", "onSei: isInit:" + r2 + " isFirstSei:" + r4 + ' ' + r17);
        if (r17 != null) goto L66;
        return;
    L66:
        if (StringsKt.contains$default(r17, "TTLiveSDK_Android", false, 2, null) == false) goto L68;
        return;
    L68:
        if (StringsKt.contains$default(r17, "TTLiveSDK_IOS", false, 2, null) == true) goto L78;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.d(r17) == true) goto L79;
        StringsKt.contains$default(r17, "TTLiveSDK_Windows", false, 2, null);
        return;
    L79:
        return;
    L78:
        return;
    L54:
        if (r5.intValue() != 19) goto L56;
        r16.m = r17;
        goto L56
    L14:
        if (TextUtils.isEmpty(r17) == true) goto L50;
        LiveSeiUtil.i.getClass();     // Catch: JSONException -> L42
        JSONObject r13 = LiveSeiUtil.c(r17);     // Catch: JSONException -> L42
        if (r13.has("info") == false) goto L28;
        if (r13.has("source") == false) goto L28;
        if (TextUtils.equals(r13.optString("source"), "zego") == false) goto L28;
        Object r8 = r13.get("info");     // Catch: JSONException -> L42
        if (r8 == null) goto L26;
        r13 = (JSONObject) r8;     // Catch: JSONException -> L42
        goto L28
    L26:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: JSONException -> L42
    L28:
        if (r13.has("app_data") == false) goto L34;
        JSONObject r7 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r13, "app_data"), BuildConfig.FLAVOR));     // Catch: JSONException -> L42
        if (r7.has("ver") == false) goto L50;
        r5 = Integer.valueOf(r7.optInt("ver"));     // Catch: JSONException -> L42
        goto L51
    L34:
        if (TextUtils.equals(r13.optString("source"), "TTLiveSDK_Android") == true) goto L44;
        if (TextUtils.equals(r13.optString("source"), "TTLiveSDK_IOS") == true) goto L44;
        if (LiveSeiUtil.d(r13.optString("source")) == true) goto L44;
        if (TextUtils.equals(r13.optString("source"), "TTLiveSDK_Windows") == false) goto L50;
    L44:
        if (r13.has("stream_type") == true) goto L46;
    L48:
        r5 = 0;     // Catch: JSONException -> L42
        goto L51
    L46:
        if (JSONObjectProtectorUtils.getInt(r13, "stream_type") != 1) goto L48;
        r5 = -1;     // Catch: JSONException -> L42
        goto L51
    L9:
        r4 = r19;
        goto L10
    L5:
        r2 = r18;
        goto L7
    }

    public MediaMultiLinkAudienceWindowManager(FrameLayout r2, RoomContext r3, DataCenter r4, hy.e r5, MediaMultiAnchorLinkContext r6, LifecycleOwner r7) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "lifecycleOwner");
        this.x = r2;
        this.y = r3;
        this.z = r4;
        this.A = r5;
        this.B = r6;
        this.a = 16.0f;
        this.b = 40.0f;
        this.c = new com.bytedance.android.live.liveinteract.api.utils.j(this);
        this.d = new ArrayList();
        this.g = new CompositeDisposable();
        this.j = r7;
        this.l = -1;
        this.q = true;
        this.r = new HashMap();
        System.currentTimeMillis();
        this.u = new e92.n();
        this.v = new com.bytedance.android.livesdk.interactivity.medialink.contract.h(false);
        this.w = new b(this);
    }
}
