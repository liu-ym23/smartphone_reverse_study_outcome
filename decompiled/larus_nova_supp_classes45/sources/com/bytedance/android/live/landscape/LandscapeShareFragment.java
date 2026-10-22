package com.bytedance.android.live.landscape;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.LiveShareBaseFragment;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.helper.LiveShareHelper;
import com.bytedance.android.live.room.share.ui.ScreenShotAutoObserveLandscapeDialog;
import com.bytedance.android.livehostapi.business.depend.share.MatchShareViewModel;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.view.PreviewType;
import com.bytedance.android.livesdk.chatroom.view.f;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdk.vs.model.PublishParam;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerFrameLayout;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.MatchShareBackground;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchShareBackground;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/landscape/LandscapeShareFragment;", "Lcom/bytedance/android/live/LiveShareBaseFragment;", "<init>", "()V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeShareFragment extends LiveShareBaseFragment {
    public static final /* synthetic */ int m = 0;
    public MatchShareParam d;
    public View e;
    public HSImageView f;
    public RoundCornerFrameLayout g;
    public TextView h;
    public DouyinLoadingLayout i;
    public long j;
    public Disposable k;
    public final f l;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LandscapeShareFragment a;

        public static final class a implements ea1.a {
            public final /* synthetic */ b a;

            public final void onDismiss() {
                LandscapeShareFragment r0 = this.a.a;
                if ((r0.getContext() instanceof Activity) == false) goto L9;
                MatchShareViewModel.Companion r1 = MatchShareViewModel.Companion;
                Context r2 = r0.getContext();
                if (r2 == null) goto L8;
                r1.updateClosePageStatus((Activity) r2, true);
                return;
            L8:
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }

            public a(b r1) {
                this.a = r1;
            }
        }

        public b(LandscapeShareFragment r1) {
            this.a = r1;
        }

        public final void a() {
            int r0 = ScreenShotAutoObserveLandscapeDialog.j;
            MatchShareParam r1 = this.a.d;
            Intrinsics.checkNotNull(r1);
            a r2 = new a(this);
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r2, "dismissCallback");
            ScreenShotAutoObserveLandscapeDialog r3 = new ScreenShotAutoObserveLandscapeDialog();
            PublishParam r4 = r1.l;
            if (r4 == null) goto L6;
            String r5 = r4.a;
            if (r5 == null) goto L6;
        L7:
            r3.e = r5;
            r3.g = r1;
            r3.h = r2;
            r3.setAnimationType("right");
            r3.setShouldUseNewPanel(true);
            FragmentManager r6 = this.a.getChildFragmentManager();     // Catch: Exception -> L14
            LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Exception -> L14
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "ScreenShotAutoObserveLandscapeDialog", r7);     // Catch: Exception -> L14
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r3, r7) == true) goto L22;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
        L12:
            r3.showNow(r6, "ScreenShotAutoObserveLandscapeDialog");     // Catch: Exception -> L14
            return;
        L22:
            return;
        L14:
            e = move-exception;
            ALogger.e("match_live_share", e);
            return;
        L6:
            r5 = "";
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ LandscapeShareFragment c;
        public final /* synthetic */ Ref.ObjectRef d;

        public c(FragmentActivity r1, HashMap r2, LandscapeShareFragment r3, Ref.ObjectRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r21) {
            ((j22.a) r21).getClass();
            MatchShareParam r1 = this.c.d;
            if (r1 != null) goto L5;
            return;
        L5:
            if (0 != r1.p) goto L32;
            List r2 = r1.d;
            if (r2 == null) goto L11;
            CollectionItem r3 = (CollectionItem) ListProtector.get(r2, 0);
            if (r3 == null) goto L11;
            r3.setLocalImagePath(null);
        L11:
            MatchShareParam r4 = this.c.d;
            if (r4 == null) goto L14;
            PublishParam r5 = new PublishParam(UriProtector.parse(null).toString(), GamePromoteDataContext.GAME_TYPE_MINI, 4, 0);
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r4.l = r5;
        L14:
            FragmentActivity r6 = this.a;
            MatchShareParam r7 = this.c.d;
            if (r7 != null) goto L17;
            r7 = new MatchShareParam(null, null, null, null, null, null, 0, null, null, null, false, 0, 65535);
        L17:
            LiveShareHelper.b(r6, r7, (CollectionItem) this.d.element, this.b);
            DouyinLoadingLayout r8 = this.c.i;
            if (r8 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        L20:
            if (r8 == null) goto L22;
            r8.c();
        L22:
            DouyinLoadingLayout r9 = this.c.i;
            if (r9 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        L25:
            if (r9 == null) goto L27;
            UtilityKotlinExtentionsKt.t(r9);
        L27:
            Disposable r11 = this.c.k;
            if (r11 == null) goto L33;
            r11.dispose();
            return;
        L33:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LandscapeShareFragment a;

        public d(LandscapeShareFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            FragmentActivity r4 = this.a.getActivity();
            if (r4 == null) goto L5;
            r4.finish();
        L5:
            f2.c("分享失败", 0);
        }
    }

    public static final class e implements com.bytedance.android.livesdk.chatroom.view.c {
        public final /* synthetic */ LandscapeShareFragment a;

        public final void a() {
            MatchShareParam r0 = this.a.d;
            if (r0 == null) goto L6;
            String r1 = r0.b;
            if (r1 == null) goto L6;
        L7:
            jl0.a.c(r1);
            return;
        L6:
            r1 = "";
            goto L7
        }

        public final void onPause() {
            MatchShareParam r0 = this.a.d;
            if (r0 == null) goto L6;
            String r1 = r0.b;
            if (r1 == null) goto L6;
        L7:
            jl0.a.b(r1, System.currentTimeMillis() - this.a.j);
            this.a.j = 0;
            return;
        L6:
            r1 = "";
            goto L7
        }

        public final void onPlay() {
            MatchShareParam r0 = this.a.d;
            String r1 = "";
            if (r0 == null) goto L6;
            String r2 = r0.b;
            if (r2 == null) goto L6;
        L7:
            if (r0 == null) goto L12;
            String r3 = r0.a;
            if (r3 == null) goto L12;
            r1 = r3;
        L12:
            jl0.a.a(r2, r1);
            LandscapeShareFragment r4 = this.a;
            r4.j = System.currentTimeMillis();
            return;
        L6:
            r2 = "";
            goto L7
        }

        public e(LandscapeShareFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public LandscapeShareFragment() {
        this.d = new MatchShareParam(null, null, null, null, null, null, 0, null, null, null, false, 0, 65535);
        this.l = new f(new e(this));
    }

    @Override // com.bytedance.android.live.LiveShareBaseFragment
    public final void onDestroy() {
        super.onDestroy();
        f r0 = this.l;
        SimpleMediaView r1 = r0.b;
        if (r1 == null) goto L5;
        r1.j();
    L5:
        SimpleMediaView r2 = r0.b;
        if (r2 == null) goto L8;
        r2.p(r0.j);
    L8:
        View r3 = r0.a;
        if (r3 == null) goto L16;
        ViewParent r4 = r3.getParent();
        if ((r4 instanceof ViewGroup) == true) goto L13;
        r4 = null;
    L13:
        ViewGroup r5 = (ViewGroup) r4;
        if (r5 == null) goto L16;
        r5.removeView(r0.a);
    L16:
        f r6 = this.l;
        SimpleMediaView r7 = r6.b;
        if (r7 == null) goto L19;
        r7.setAsyncRelease(true);
    L19:
        SimpleMediaView r8 = r6.b;
        if (r8 == null) goto L22;
        r8.m();
    L22:
        Disposable r9 = this.k;
        if (r9 == null) goto L26;
        r9.dispose();
        return;
    }

    @Override // com.bytedance.android.live.LiveShareBaseFragment
    public final void onStop() {
        super.onStop();
        this.l.b();
    }

    public final void onViewCreated(View r25, Bundle r26) {
        Intrinsics.checkNotNullParameter(r25, "view");
        super.onViewCreated(r25, r26);
        View r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        this.f = (HSImageView) r1.findViewById(2131389927);
        View r2 = this.e;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L8:
        this.g = r2.findViewById(2131389928);
        View r3 = this.e;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L11:
        this.h = (TextView) r3.findViewById(2131389929);
        View r4 = this.e;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L14:
        this.i = r4.findViewById(2131382929);
        MatchShareParam r5 = this.d;
        if (r5 == null) goto L19;
        List r6 = r5.d;
        if (r6 == null) goto L19;
        int r7 = r6.size();
    L20:
        String r8 = "";
        String r9 = null;
        if (r7 <= 0) goto L78;
        MatchShareParam r11 = this.d;
        if (r11 == null) goto L29;
        List r12 = r11.d;
        if (r12 == null) goto L29;
        CollectionItem r13 = (CollectionItem) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L29;
        String r14 = r13.getLocalPreviewTopTitle();
    L31:
        if ((!TextUtils.isEmpty(r14)) == false) goto L50;
        TextView r15 = this.h;
        if (r15 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("shareContentTitle");
    L35:
        r15.setGravity(17);
        TextView r16 = this.h;
        if (r16 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("shareContentTitle");
    L38:
        r16.setTextColor(ColorProtector.parseColor("#7FFFFFFF"));
        TextView r17 = this.h;
        if (r17 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("shareContentTitle");
    L41:
        MatchShareParam r18 = this.d;
        if (r18 == null) goto L48;
        List r19 = r18.d;
        if (r19 == null) goto L48;
        CollectionItem r21 = (CollectionItem) CollectionsKt.firstOrNull(r19);
        if (r21 == null) goto L48;
        String r22 = r21.getLocalPreviewTopTitle();
    L49:
        r17.setText(r22);
    L48:
        r22 = null;
        goto L49
    L50:
        TextView r23 = this.h;
        if (r23 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("shareContentTitle");
    L53:
        r23.setGravity(8388611);
        TextView r24 = this.h;
        if (r24 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("shareContentTitle");
    L56:
        MatchShareParam r27 = this.d;
        if (r27 == null) goto L76;
        List r28 = r27.d;
        if (r28 == null) goto L76;
        Iterator r29 = r28.iterator();
    L62:
        if (r29.hasNext() == false) goto L70;
        Object r31 = r29.next();
        String r32 = ((CollectionItem) r31).getCollectionId();
        MatchShareParam r110 = this.d;
        if (r110 == null) goto L66;
        String r111 = r110.b;
    L68:
        if (Intrinsics.areEqual(r32, r111) == false) goto L62;
    L71:
        CollectionItem r33 = (CollectionItem) r31;
        if (r33 == null) goto L76;
        String r34 = r33.getTitle();
        if (r34 == null) goto L76;
    L77:
        r24.setText(r34);
        goto L78
    L66:
        r111 = null;
        goto L68
    L70:
        r31 = null;
    L76:
        r34 = "";
    L29:
        r14 = null;
    L78:
        int r35 = s1.t() / 2;
        if (r35 >= UtilityKotlinExtentionsKt.i(375)) goto L81;
        r35 = s1.t() - UtilityKotlinExtentionsKt.i(375);
    L81:
        View r36 = this.e;
        if (r36 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L84:
        View r37 = r36.findViewById(2131377810);
        if (r37 == null) goto L87;
        a1.p(r37, r35);
    L87:
        MatchShareParam r38 = this.d;
        if (r38 == null) goto L90;
        IRoom r39 = r38.f;
    L92:
        if ((r39 instanceof Room) == true) goto L94;
        r39 = null;
    L94:
        Room r41 = (Room) r39;
        if (r41 == null) goto L108;
        EpisodeExtraInfo r42 = r41.getEpisodeExtra2();
        if (r42 == null) goto L108;
        IMatchRoomInfo r43 = r42.getMatchRoomInfo();
        if (r43 == null) goto L108;
        IMatchShareBackground r44 = r43.getMatchShareBackground();
        if (r44 == null) goto L108;
        k r45 = r44.getHorizontalBackground();
        if (r45 == null) goto L108;
        SimpleDraweeView r46 = this.f;
        if (r46 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("sharePageBgView");
    L107:
        ImageUtil.loadImage(r46, r45, 0);
    L108:
        MatchShareParam r47 = this.d;
        if (r47 == null) goto L122;
        Episode r48 = r47.g;
        if (r48 == null) goto L122;
        EpisodeBasicInfo r49 = r48.episodeBasicInfo;
        if (r49 == null) goto L122;
        MatchShareBackground r51 = r49.getMatchShareBackground();
        if (r51 == null) goto L122;
        k r52 = r51.getHorizontalBackground();
        if (r52 == null) goto L122;
        SimpleDraweeView r53 = this.f;
        if (r53 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("sharePageBgView");
    L121:
        ImageUtil.loadImage(r53, r52, 0);
    L122:
        MatchShareParam r54 = this.d;
        if (r54 == null) goto L148;
        List r55 = r54.d;
        if (r55 == null) goto L148;
        Iterator r56 = r55.iterator();
    L128:
        if (r56.hasNext() == false) goto L136;
        Object r57 = r56.next();
        String r58 = ((CollectionItem) r57).getCollectionId();
        MatchShareParam r112 = this.d;
        if (r112 == null) goto L132;
        String r113 = r112.b;
    L134:
        if (Intrinsics.areEqual(r58, r113) == false) goto L128;
    L137:
        CollectionItem r59 = (CollectionItem) r57;
        if (r59 == null) goto L148;
        RoundCornerFrameLayout r61 = this.g;
        if (r61 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("shareContentContainer");
    L142:
        com.bytedance.android.live.c.b(true, r61, this.l, r35 - UtilityKotlinExtentionsKt.i(48), r59);
        f r62 = this.l;
        if (r62.i != PreviewType.VIDEO) goto L148;
        SimpleMediaView r63 = r62.b;
        if (r63 == null) goto L147;
        r63.setLoop(true);
    L147:
        r62.a(false);
        goto L148
    L132:
        r113 = null;
        goto L134
    L136:
        r57 = null;
    L148:
        Ref.ObjectRef r64 = new Ref.ObjectRef();
        r64.element = null;
        MatchShareParam r65 = this.d;
        if (r65 == null) goto L151;
        List r66 = r65.d;
    L153:
        if (CollectionUtils.isEmpty(r66) == true) goto L178;
        MatchShareParam r67 = this.d;
        if (r67 == null) goto L171;
        List r68 = r67.d;
        if (r68 == null) goto L171;
        Iterator r69 = r68.iterator();
    L160:
        if (r69.hasNext() == false) goto L168;
        Object r71 = r69.next();
        String r72 = ((CollectionItem) r71).getCollectionId();
        MatchShareParam r73 = this.d;
        if (r73 == null) goto L164;
        String r74 = r73.b;
    L166:
        if (Intrinsics.areEqual(r72, r74) == false) goto L160;
    L169:
        CollectionItem r75 = (CollectionItem) r71;
        if (r75 == null) goto L171;
    L177:
        r64.element = r75;
        goto L178
    L164:
        r74 = null;
        goto L166
    L168:
        r71 = null;
    L171:
        MatchShareParam r76 = this.d;
        if (r76 == null) goto L176;
        List r77 = r76.d;
        if (r77 == null) goto L176;
        r75 = (CollectionItem) CollectionsKt.firstOrNull(r77);
    L176:
        r75 = null;
    L178:
        MatchShareParam r78 = this.d;
        if (r78 != null) goto L181;
        return;
    L181:
        if (r78.k != 0) goto L268;
        FragmentActivity r79 = getActivity();
        if (r79 == null) goto L269;
        HashMap r81 = new HashMap();
        MatchShareParam r82 = this.d;
        if (r82 == null) goto L200;
        List r83 = r82.d;
        if (r83 == null) goto L200;
        Iterator r84 = r83.iterator();
    L190:
        if (r84.hasNext() == false) goto L198;
        Object r85 = r84.next();
        String r114 = ((CollectionItem) r85).getCollectionId();
        MatchShareParam r115 = this.d;
        if (r115 == null) goto L194;
        String r116 = r115.b;
    L196:
        if (Intrinsics.areEqual(r114, r116) == false) goto L190;
    L199:
        CollectionItem r86 = (CollectionItem) r85;
    L201:
        if (r86 == null) goto L203;
        String r87 = r86.getCollectionId();
    L205:
        if (TextUtils.isEmpty(r87) == true) goto L212;
        if (r86 == null) goto L211;
        String r88 = r86.getCollectionId();
        if (r88 == null) goto L211;
        r8 = r88;
    L211:
        r81.put("collection_id", r8);
        r81.put("multitab_select_tabid", "4");
    L212:
        MatchShareParam r89 = this.d;
        if (r89 == null) goto L220;
        Intrinsics.checkNotNull(r89);
        if (r89.o == false) goto L220;
        View r91 = this.e;
        if (r91 != null) goto L219;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L219:
        r91.post(new b(this));
        return;
    L220:
        MatchShareParam r92 = this.d;
        if (r92 != null) goto L223;
    L250:
        MatchShareParam r93 = this.d;
        if (r93 != null) goto L253;
        r93 = new MatchShareParam(null, null, null, null, null, null, 0, null, null, null, false, 0, 65535);
    L253:
        LiveShareHelper.b(r79, r93, (CollectionItem) r64.element, r81);
        return;
    L223:
        if (Intrinsics.areEqual("screenshot", r92.a) == false) goto L250;
        MatchShareParam r94 = this.d;
        if (r94 == null) goto L227;
        List r95 = r94.d;
    L229:
        if (CollectionUtils.isEmpty(r95) == true) goto L250;
        MatchShareParam r96 = this.d;
        if (r96 == null) goto L238;
        List r97 = r96.d;
        if (r97 == null) goto L238;
        CollectionItem r98 = (CollectionItem) ListProtector.get(r97, 0);
        if (r98 == null) goto L238;
        r9 = r98.getLocalImagePath();
    L238:
        if (TextUtils.isEmpty(r9) == false) goto L250;
        DouyinLoadingLayout r99 = this.i;
        if (r99 != null) goto L242;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L242:
        if (r99 == null) goto L244;
        UtilityKotlinExtentionsKt.w(r99);
    L244:
        DouyinLoadingLayout r100 = this.i;
        if (r100 != null) goto L247;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L247:
        if (r100 == null) goto L249;
        r100.b();
    L249:
        this.k = xs2.b.a().b(j22.a.class).subscribe(new c(r79, r81, this, r64), new d(this));
        return;
    L227:
        r95 = null;
        goto L229
    L203:
        r87 = null;
        goto L205
    L194:
        r116 = null;
        goto L196
    L198:
        r85 = null;
    L200:
        r86 = null;
        goto L201
    L269:
        return;
    L268:
        return;
    L151:
        r66 = null;
        goto L153
    L90:
        r39 = null;
    L19:
        r7 = 0;
        goto L20
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131567982, r3, false);
        this.e = r5;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        return r5;
    }
}
