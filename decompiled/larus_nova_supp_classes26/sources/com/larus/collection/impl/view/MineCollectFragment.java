package com.larus.collection.impl.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.router.SmartRouter;
import com.collection.profile.api.CollectServiceDelegate;
import com.ixigua.lib.track.TrackParams;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.home.api.main.HomeService;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.y0;
import com.larus.platform.model.CollectionDetail;
import com.larus.platform.model.MessageCollection;
import com.larus.profile.impl.databinding.LarusFragmentMineCollectListBinding;
import com.larus.profile.impl.databinding.LarusPageCollectErrorBinding;
import com.larus.profile.impl.databinding.LarusPageCollectListEmptyBinding;
import com.larus.profile.impl.databinding.LarusPageCollectLoadingSkeletonBinding;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import com.skydoves.balloon.Balloon;
import hq9.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001d\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0006\u0010!\u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u0006J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u00103\u001a\u00020$H\u0002J\b\u00104\u001a\u00020$H\u0016J\b\u00105\u001a\u00020$H\u0016J\n\u00106\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u00020$H\u0002J\b\u00109\u001a\u00020$H\u0016J\b\u0010:\u001a\u00020$H\u0002J\u0010\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0016J\u0012\u0010>\u001a\u00020$2\b\u0010?\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010@\u001a\u00020$H\u0016J\b\u0010A\u001a\u00020$H\u0002J\b\u0010D\u001a\u00020$H\u0002J\b\u0010E\u001a\u00020$H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/larus/collection/impl/view/MineCollectFragment;", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "Lcom/larus/platform/api/IMineCollectFragment;", "<init>", "()V", "tag", "", "scene", "", "trackTabName", "isLikeTab", "", "binding", "Lcom/larus/profile/impl/databinding/LarusFragmentMineCollectListBinding;", "loadMoreManager", "Lcom/larus/bmhome/utils/LoadMoreManager;", "viewModel", "Lcom/larus/collection/impl/view/MineCollectViewModel;", "getViewModel", "()Lcom/larus/collection/impl/view/MineCollectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mBalloon", "Lcom/skydoves/balloon/Balloon;", "listAdapter", "Lcom/larus/collection/impl/view/CollectionListAdapter;", "needReloadCollectionList", "needForceReloadCollectionList", "collectionListCallback", "com/larus/collection/impl/view/MineCollectFragment$collectionListCallback$1", "Lcom/larus/collection/impl/view/MineCollectFragment$collectionListCallback$1;", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "profileTabKey", "getEnterPageName", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "isFragmentVisible", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "onResume", "onPause", "getCollectionListAdapter", "initData", "observeData", "onDestroyView", "releaseBalloon", "getCollections", "", "Lcom/larus/platform/model/MessageCollection;", "updateCollectionsExpiredStatus", "lastCanceledCollectionId", "refreshCollections", "resetReloadStatue", "hideCoverAnimator", "Landroid/animation/ObjectAnimator;", "showItemAnimationIfNeed", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MineCollectFragment extends ProfileInfoBaseFragment implements y0 {
    public static Integer x;
    public static Integer y;
    public final String j;
    public int k;
    public String l;
    public boolean m;
    public LarusFragmentMineCollectListBinding n;
    public LoadMoreManager o;
    public final Lazy p;
    public Balloon q;
    public CollectionListAdapter r;
    public boolean s;
    public boolean t;
    public final b u;
    public boolean v;
    public ObjectAnimator w;

    public static final class a {
    }

    public static final class b implements com.larus.collection.impl.view.a {
        public final /* synthetic */ MineCollectFragment a;

        public b(MineCollectFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.collection.impl.view.a
        public final void a(MessageCollection r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "item");
            FLogger.a.i("MineCollectFragment", "onItemClick, position=" + r12 + ", item=" + r11);
            Integer r0 = r11.getCollectionType();
            String r4 = null;
            if (r0 != null) goto L6;
        L7:
            if (r0 != null) goto L10;
        L11:
            if (r0 != null) goto L14;
        L15:
            if (r0 != null) goto L18;
        L20:
            String r1 = r11.getSchema();
            if (o0.d(r1) == false) goto L38;
            SmartRouter.buildRoute(this.a.getContext(), r1).d();
        L38:
            String r2 = this.a.l;
            Integer r13 = Integer.valueOf(r12 + 1);
            String r3 = r11.getCollectionId();
            Integer r5 = r11.getCollectionType();
            List r6 = r11.getCollectionDetails();
            if (r6 == null) goto L45;
            CollectionDetail r7 = (CollectionDetail) CollectionsKt.firstOrNull(r6);
            if (r7 == null) goto L45;
            Message r8 = k0.a(r7);
            if (r8 == null) goto L45;
            String r9 = r8.getConversationId();
        L46:
            List r10 = r11.getCollectionDetails();
            if (r10 == null) goto L53;
            CollectionDetail r14 = (CollectionDetail) CollectionsKt.firstOrNull(r10);
            if (r14 == null) goto L53;
            Message r15 = k0.a(r14);
            if (r15 == null) goto L53;
            String r16 = r15.getSenderId();
        L54:
            List r17 = r11.getCollectionDetails();
            if (r17 == null) goto L61;
            CollectionDetail r18 = (CollectionDetail) CollectionsKt.firstOrNull(r17);
            if (r18 == null) goto L61;
            Message r19 = k0.a(r18);
            if (r19 == null) goto L61;
            r4 = r19.getMessageId();
        L61:
            JSONObject r110 = new JSONObject();
            Intrinsics.checkNotNullParameter(r110, "params");
            r110.put("current_page", "bot_list_profile");     // Catch: JSONException -> L78
            if (r2 == null) goto L65;
            r110.put("tab_name", r2);     // Catch: JSONException -> L78
        L65:
            if (r13 == null) goto L67;
            r110.put("position", r13.toString());     // Catch: JSONException -> L78
        L67:
            if (r3 == null) goto L69;
            r110.put("collect_id", r3);     // Catch: JSONException -> L78
        L69:
            if (r5 == null) goto L71;
            r110.put("type", r5.intValue());     // Catch: JSONException -> L78
        L71:
            if (r9 == null) goto L73;
            r110.put(MusicAppletPage.KEY_CONVERSATION_ID, r9);     // Catch: JSONException -> L78
        L73:
            if (r16 == null) goto L75;
            r110.put("bot_id", r16);     // Catch: JSONException -> L78
        L75:
            if (r4 == null) goto L80;
            r110.put(MusicAppletPage.KEY_MESSAGE_ID, r4);     // Catch: JSONException -> L78
        L80:
            TrackParams r111 = new TrackParams().merge(r110);
            by7.a r112 = new by7.a("my_info_tab_element_click");
            r112.a.merge(r111);
            r112.b();
            return;
        L78:
            e = move-exception;
            FLogger.a.e("MyEventHelper", "error in MyEventHelper myInfoTabElementClick " + e.getLocalizedMessage());
        L53:
            r16 = null;
        L45:
            r9 = null;
            goto L46
        L18:
            if (r0.intValue() != 4) goto L20;
        L23:
            String r20 = r11.getCollectionId();
            if (r20 == null) goto L38;
            MineCollectFragment r21 = this.a;
            com.bytedance.router.i r22 = SmartRouter.buildRoute(r21.getContext(), "//flow/chat_page");
            Pair[] r23 = new Pair[5];
            boolean r24 = false;
            r23[0] = TuplesKt.to("preview_collection_id", r20);
            r23[1] = TuplesKt.to("preview_from_like_revisit", Boolean.valueOf(r21.m));
            Intrinsics.checkNotNullParameter(r11, "<this>");
            Integer r25 = r11.getCollectionType();
            if (r25 != null) goto L29;
        L31:
            r23[2] = TuplesKt.to("preview_like_revisit_item", Boolean.valueOf(r24));
            r23[3] = TuplesKt.to("is_need_fixed_bottom_tab", Boolean.FALSE);
            r23[4] = TuplesKt.to("ignore_side_bar", "1");
            Bundle r26 = BundleKt.bundleOf(r23);
            by7.e r27 = r21.getParentFragment();
            if ((r27 instanceof by7.e) == false) goto L34;
            by7.e r28 = r27;
        L35:
            if (r28 == null) goto L37;
            by7.h.k(r26, r28);
        L37:
            r22.c.putExtras(r26);
            r22.d = 2130772401;
            r22.e = 2130772399;
            r22.d();
            goto L38
        L34:
            r28 = null;
            goto L35
        L29:
            if (r25.intValue() != 4) goto L31;
            r24 = true;
            goto L31
        L14:
            if (r0.intValue() == 5) goto L23;
        L10:
            if (r0.intValue() == 2) goto L23;
        L6:
            if (r0.intValue() == 1) goto L23;
            goto L7
        }

        @Override // com.larus.collection.impl.view.a
        public final void b(final View r56, int r57, int r58, final MessageCollection r59, int r60) {
            Intrinsics.checkNotNullParameter(r56, "view");
            Intrinsics.checkNotNullParameter(r59, "item");
            FLogger r2 = FLogger.a;
            r2.i("MineCollectFragment", "onLongClick, xOffset == " + r57 + ", yOffset == " + r58 + ", position=" + r60);
            if (Intrinsics.areEqual(r59.getNotAllowedCancel(), Boolean.TRUE) == false) goto L6;
            r2.i("MineCollectFragment", "onLongClick, notAllowedCancel == true");
            return;
        L6:
            Intrinsics.checkNotNullParameter(r59, "<this>");
            Integer r3 = r59.getCollectionType();
            if (r3 != null) goto L10;
        L12:
            boolean r4 = false;
        L13:
            if (r4 == false) goto L15;
            int r16 = 2131908557;
        L16:
            if (r4 == false) goto L18;
            int r5 = 2131241921;
        L19:
            ArrayList r6 = new ArrayList();
            r6.add(new l0(r16, r16, null, null, null, null, null, Integer.valueOf(r5), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -132, 127));
            MineCollectFragment r7 = this.a;
            Integer r8 = MineCollectFragment.x;
            final MineCollectViewModel r9 = r7.aa0();
            View r10 = CreateMenu.f(new CreateMenu(r56.getContext()), r6, 0, false, null, null, null, null, new f(r9, r59, r56), 510);
            final RecyclerView r14 = this.a.getRecyclerView();
            Balloon r1 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r56, r10, false, null, null, ViewTreeLifecycleOwner.get(r56), new g(r14), 28);
            r1.v(r56, r57 - (r56.getWidth() / 2), r58);
            if (r14 == null) goto L22;
            r14.requestDisallowInterceptTouchEvent(true);
        L22:
            this.a.q = r1;
            return;
        L18:
            r5 = 2131241918;
            goto L19
        L15:
            r16 = 2131910857;
            goto L16
        L10:
            if (r3.intValue() != 4) goto L12;
            r4 = true;
            goto L13
        }
    }

    public static final class c implements LoadMoreManager.b {
        public final /* synthetic */ MineCollectFragment a;

        public c(MineCollectFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.utils.LoadMoreManager.b
        public final View a(FrameLayout r4) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return LayoutInflater.from(this.a.getContext()).inflate(2131561886, r4, false);
        }

        @Override // com.larus.bmhome.utils.LoadMoreManager.b
        public final View b(FrameLayout r4) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return LayoutInflater.from(this.a.getContext()).inflate(2131561885, r4, false);
        }

        @Override // com.larus.bmhome.utils.LoadMoreManager.b
        public final View c(FrameLayout r4) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return LayoutInflater.from(this.a.getContext()).inflate(2131563192, r4, false);
        }
    }

    static {
    }

    public final MineCollectViewModel aa0() {
        return (MineCollectViewModel) this.p.getValue();
    }

    public final RecyclerView getRecyclerView() {
        LarusFragmentMineCollectListBinding r0 = this.n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final List<MessageCollection> jn() {
        CollectionListAdapter r0 = this.r;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentList();
    }

    public final void onDestroyView() {
        ObjectAnimator r0 = this.w;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.w = null;
        Balloon r1 = this.q;
        if (r1 != null) goto L17;
    L15:
        this.q = null;
        super.onDestroyView();
        this.n = null;
        return;
    L17:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        r1.onDestroy(getViewLifecycleOwner());     // Catch: Throwable -> L9
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r3) == null) goto L14;
        r1.h();
    L14:
        Result.box-impl(r3);
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void w10() {
        FLogger.a.i(this.j, "refreshCollections isLikeTab=" + this.m);
        this.s = true;
    }

    public MineCollectFragment() {
        this.j = "MineCollectFragment" + hashCode();
        this.k = 1;
        this.l = "collection";
        final Function0<Fragment> r1 = new MineCollectFragment$special$$inlined$viewModels$default$1(this);
        this.p = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MineCollectViewModel.class), new MineCollectFragment$special$$inlined$viewModels$default$2(r1), new MineCollectFragment$special$$inlined$viewModels$default$3(r1, this));
        this.s = true;
        this.u = new b(this);
    }

    public final CollectionListAdapter Z90() {
        RecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L5;
        RecyclerView.Adapter r1 = r0.getAdapter();
    L7:
        if ((r1 instanceof ConcatAdapter) == false) goto L9;
        ConcatAdapter r2 = (ConcatAdapter) r1;
    L10:
        if (r2 == null) goto L20;
        List r3 = r2.getAdapters();
        if (r3 == null) goto L20;
        Iterator r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L20;
        CollectionListAdapter r5 = (RecyclerView.Adapter) r4.next();
        if ((r5 instanceof CollectionListAdapter) == false) goto L15;
        return r5;
    L20:
        FLogger.a.e(this.j, "[getCollectionListAdapter] Fail");
        return null;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final void onDestroy() {
        super.onDestroy();
        ObjectAnimator r0 = this.w;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.w = null;
    }

    public final void onPause() {
        super.onPause();
        this.v = false;
    }

    public final void onResume() {
        super.onResume();
        FLogger.a.i(this.j, "[onResume], needReloadCollectionList = " + this.s);
        if (this.m == false) goto L5;
        CollectServiceDelegate.b.d(this);
    L7:
        if (this.s == false) goto L9;
    L10:
        MineCollectViewModel r0 = aa0();
        if (((ProfileInfoBaseFragment) this).i == false) goto L13;
        DowngradeSource r1 = DowngradeSource.HOT_LAUNCH;
    L14:
        r0.queryCollectList(r1);
    L15:
        ((ProfileInfoBaseFragment) this).i = false;
        this.v = true;
        return;
    L13:
        r1 = DowngradeSource.ENTER_PAGE;
        goto L14
    L9:
        if (this.t == false) goto L15;
    L5:
        CollectServiceDelegate.b.c(this);
        goto L7
    }

    public final String tag() {
        return this.j;
    }

    public final void Of(String r6) {
        if (isAdded() == true) goto L5;
    L27:
        FLogger.a.w(this.j, "updateCollectionsExpiredStatus fail: fragment is detached");
        return;
    L5:
        if (isDetached() == true) goto L27;
        FLogger.a.i(this.j, "updateCollectionsExpiredStatus, lastCanceledCollectionId = " + r6);
        this.s = true;
        aa0().setLastCancelCollectionId(r6);
        if (r6 == null) goto L32;
        CollectionListAdapter r0 = this.r;
        Object r1 = null;
        if (r0 == null) goto L14;
        List r2 = r0.getCurrentList();
        if (r2 == null) goto L14;
        List r3 = CollectionsKt.toMutableList(r2);
    L15:
        if (r3 == null) goto L23;
        Iterator r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L22;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((MessageCollection) r5).getCollectionId(), r6) == false) goto L18;
        r1 = r5;
    L22:
        r3.remove(r1);
    L23:
        CollectionListAdapter r7 = Z90();
        if (r7 == null) goto L33;
        r7.submitList(r3);
        return;
    L33:
        return;
    L14:
        r3 = null;
        goto L15
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        if (isResumed() == false) goto L10;
        LarusFragmentMineCollectListBinding r3 = this.n;
        if (r3 == null) goto L11;
        RecyclerView r4 = r3.d;
        if (r4 == null) goto L12;
        r4.post(new d(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onCreate(Bundle r4) {
        super/*androidx.fragment.app.Fragment*/.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L5;
        this.k = r5.getInt("arg_scene", this.k);
        this.l = r5.getString("arg_track_tab_name", this.l);
        this.m = r5.getBoolean("arg_is_like_tab", false);
    L5:
        MineCollectViewModel r6 = aa0();
        if (r6 == null) goto L8;
        r6.setScene(this.k);
    L8:
        Context r7 = getContext();
        if (r7 != null) goto L11;
        return;
    L11:
        this.o = new LoadMoreManager(r7, new com.larus.collection.impl.view.c(this), new c(this));
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        if (this.m == false) goto L11;
        LarusFragmentMineCollectListBinding r10 = this.n;
        if (r10 == null) goto L11;
        LarusPageCollectListEmptyBinding r11 = r10.b;
        if (r11 == null) goto L11;
        AppCompatTextView r12 = r11.b;
        if (r12 == null) goto L11;
        r12.setText(2131908558);
    L11:
        FLogger r13 = FLogger.a;
        r13.i(this.j, "[initView]");
        LarusFragmentMineCollectListBinding r14 = this.n;
        if (r14 == null) goto L20;
        RecyclerView r1 = r14.d;
        if (r1 == null) goto L20;
        r1.setLayoutManager(new LinearLayoutManager(r1.getContext()));
        r1.setItemAnimator(null);
        RecyclerView.Adapter r15 = new CollectionListAdapter(this.u);
        this.r = r15;
        LoadMoreManager r2 = this.o;
        if (r2 == null) goto L18;
        ConcatAdapter r16 = r2.d(r1, r15);
    L19:
        boolean r17 = r16 instanceof ConcatAdapter;
        r1.setItemViewCacheSize(10);
        r1.addItemDecoration(new MineCollectFragment$initView$1$2());
        y6.d(r1, null, null, null, new e(this), 15);
        goto L20
    L18:
        r16 = null;
    L20:
        X90();
        r13.i(this.j, "[initData]");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new MineCollectFragment$observeData$1(this, null), 3, null);
        int r18 = this.k;
        Integer r19 = y;
        if (r19 != null) goto L24;
    L25:
        boolean r20 = false;
    L27:
        MineCollectViewModel r21 = aa0();
        if (r21 == null) goto L37;
        if (r20 == false) goto L31;
    L34:
        DowngradeSource r22 = DowngradeSource.ENTER_PAGE;
    L35:
        r21.queryCollectList(r22);
        return;
    L31:
        if (HomeService.a.o() == true) goto L34;
        r22 = DowngradeSource.ENTER_CONVERSATION_LIST;
        goto L35
    L37:
        return;
    L24:
        if (r19.intValue() != r18) goto L25;
        y = null;
        r20 = true;
        goto L27
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        FLogger.a.i(this.j, "[onCreateView]");
        ConstraintLayout r14 = r11.inflate(2131562406, r12, false);
        int r15 = 2131367139;
        ConstraintLayout r16 = ViewBindings.findChildViewById(r14, 2131367139);
        if (r16 == null) goto L27;
        ConstraintLayout r17 = r16;
        int r1 = 2131375135;
        if (ViewBindings.findChildViewById(r16, 2131375135) == null) goto L25;
        r1 = 2131390331;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r16, 2131390331);
        if (r2 == null) goto L25;
        LarusPageCollectListEmptyBinding r5 = new LarusPageCollectListEmptyBinding(r17, r2);
        r15 = 2131367140;
        ConstraintLayout r18 = ViewBindings.findChildViewById(r14, 2131367140);
        if (r18 == null) goto L27;
        int r19 = 2131383232;
        if (ViewBindings.findChildViewById(r18, 2131383232) == null) goto L23;
        r19 = 2131383234;
        if (ViewBindings.findChildViewById(r18, 2131383234) == null) goto L23;
        LarusPageCollectErrorBinding r6 = new LarusPageCollectErrorBinding(r18);
        r15 = 2131367149;
        RecyclerView r7 = ViewBindings.findChildViewById(r14, 2131367149);
        if (r7 == null) goto L27;
        r15 = 2131367152;
        ConstraintLayout r110 = ViewBindings.findChildViewById(r14, 2131367152);
        if (r110 == null) goto L27;
        LarusPageCollectLoadingSkeletonBinding r8 = new LarusPageCollectLoadingSkeletonBinding(r110);
        r15 = 2131367163;
        View r9 = ViewBindings.findChildViewById(r14, 2131367163);
        if (r9 == null) goto L27;
        ConstraintLayout r111 = r14;
        this.n = new LarusFragmentMineCollectListBinding(r111, r5, r6, r7, r8, r9);
        return r111;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r19)));
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r1)));
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
