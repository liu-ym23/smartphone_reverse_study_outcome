package com.bytedance.android.live.liveinteract.manager;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IKtvInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IKtvRoomFeedView;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.android.livesdkapi.feed.manager.IInteractFeedViewListener;
import com.bytedance.android.livesdkapi.feed.manager.IInteractFeedViewManager;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PreviewInteractFeedViewManager implements IInteractFeedViewManager {
    public LivePlayerView a;
    public IInteractFeedView b;
    public final HashMap<String, Boolean> c;
    public IRoom d;
    public int e;
    public int f;
    public int g;
    public Disposable h;
    public SeiAppData i;
    public List<? extends SeiRegion> j;
    public final List<IInteractFeedViewListener> k;
    public final Lazy l;
    public final ViewGroup m;
    public final int n;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            String r3 = (String) r2;
            return new JSONObject(this.a);
        }
    }

    public static final class b<T> implements Predicate {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean test(Object r4) {
            JSONObject r5 = (JSONObject) r4;
            Intrinsics.checkNotNullParameter(r5, "jsonObject");
            if (TextUtils.equals(r5.optString("source"), "TTLiveSDK_Android") == false) goto L5;
        L12:
            return true;
        L5:
            if (TextUtils.equals(r5.optString("source"), "TTLiveSDK_IOS") == true) goto L12;
            LiveSeiUtil r1 = LiveSeiUtil.i;
            String r2 = r5.optString("source");
            r1.getClass();
            if (LiveSeiUtil.d(r2) == true) goto L12;
            if (TextUtils.equals(r5.optString("source"), "TTLiveSDK_Windows") == true) goto L12;
            return false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PreviewInteractFeedViewManager a;

        public c(PreviewInteractFeedViewManager r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            JSONObject r4 = (JSONObject) r3;
            PreviewInteractFeedViewManager r5 = this.a;
            if (r5.e == (-1)) goto L6;
            r5.a();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ PreviewInteractFeedViewManager a;

        public e(PreviewInteractFeedViewManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.m.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final /* bridge */ /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r1) {
        IInteractFeedViewManager.-CC.$default$onBusinessAppSeiUpdate(this, r1);
    }

    public final void a() {
        IInteractFeedView r0 = this.b;
        if (r0 == null) goto L13;
        if (r0 == null) goto L6;
        r0.reset();
    L6:
        ViewGroup r1 = this.m;
        if ((r0 instanceof View) == true) goto L9;
        r0 = null;
    L9:
        r1.removeView((View) r0);
        this.b = null;
        if (this.m.getVisibility() != 0) goto L14;
        this.m.setVisibility(8);
        this.f = 0;
        this.g = 0;
        this.e = 0;
        return;
    L14:
        return;
    }

    public final View getFeedView() {
        IInteractFeedView r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getViewCompat();
    }

    public final void onDestroy() {
        Disposable r0 = this.h;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void onOnlineListChangeBySei() {
        IInteractFeedView r0 = this.b;
        if (r0 == null) goto L6;
        r0.onOnlineListChanged();
        return;
    }

    public final LivePlayerView getMLivePlayerView() {
        return this.a;
    }

    public final int getSeiVersion() {
        return this.e;
    }

    public final void onAudioMvControllerUpdate(String r2) {
        if (r2 == null) goto L7;
        IInteractFeedView r0 = this.b;
        if (r0 == null) goto L8;
        r0.updateMvControllerSei(r2);
        return;
    L8:
        return;
    }

    public final void onAudioSubtitleUpdate(String r2) {
        if (r2 == null) goto L7;
        IInteractFeedView r0 = this.b;
        if (r0 == null) goto L8;
        r0.updateSubtitleSei(r2);
        return;
    L8:
        return;
    }

    public final void onKtvSeiUpdate(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        IKtvInteractFeedView r0 = this.b;
        if (r0 != null) goto L7;
    L19:
        Iterator r1 = CollectionsKt.toList(this.k).iterator();
    L21:
        if (r1.hasNext() == false) goto L23;
        ((IInteractFeedViewListener) r1.next()).onSeiUpdateRaw(r3);
        goto L21
    L23:
        return;
    L7:
        if ((r0 instanceof IKtvInteractFeedView) == false) goto L10;
        r0.onKtvRoomSeiModel(r3);
        goto L19
    L10:
        if ((r0 instanceof IKtvRoomFeedView) == false) goto L13;
        ((IKtvRoomFeedView) r0).onSeiUpdatedRaw(r3);
        goto L19
    L13:
        if (r0.getIKtvInteractFeedView() == null) goto L19;
        IInteractFeedView r2 = this.b;
        if (r2 == null) goto L19;
        IKtvInteractFeedView r4 = r2.getIKtvInteractFeedView();
        if (r4 == null) goto L19;
        r4.onKtvRoomSeiModel(r3);
        goto L19
    }

    public final void onRadioSeiUpdate(JSONObject r2) {
        if (r2 == null) goto L7;
        IInteractFeedView r0 = this.b;
        if (r0 == null) goto L8;
        r0.updateRadioSei(r2);
        return;
    L8:
        return;
    }

    public final void onRadioTextSeiUpdate(JSONObject r2) {
        if (r2 == null) goto L7;
        IInteractFeedView r0 = this.b;
        if (r0 == null) goto L8;
        r0.updateRadioTextSei(r2);
        return;
    L8:
        return;
    }

    public final void onSeiUpdated(SeiAppData r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        this.i = r9;
        updateSceneByVer(r9);
        IInteractFeedView r0 = this.b;
        if (r0 == null) goto L7;
        r0.onSeiUpdated(r9);
    L7:
        List r1 = r9.getGrids();
        if (r1 != null) goto L10;
        return;
    L10:
        if ((!r1.isEmpty()) != true) goto L52;
        List<? extends SeiRegion> r10 = r9.getGrids();
        List<? extends SeiRegion> r2 = this.j;
        if (r2 == null) goto L32;
        if (r2 == null) goto L32;
        if (r2.size() != r10.size()) goto L32;
        List<? extends SeiRegion> r3 = this.j;
        if (r3 != null) goto L19;
        r3 = CollectionsKt.emptyList();
    L19:
        List<? extends SeiRegion> r4 = r3;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L21:
        if (r6.hasNext() == false) goto L23;
        r5.add(((SeiRegion) r6.next()).uidStr);
        goto L21
    L23:
        Set r7 = CollectionsKt.toMutableSet(r5);
        int r8 = r7.size();
        List<? extends SeiRegion> r11 = r10;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L25:
        if (r13.hasNext() == false) goto L27;
        r12.add(((SeiRegion) r13.next()).uidStr);
        goto L25
    L27:
        r7.addAll(r12);
        if (r7.size() == r8) goto L30;
        boolean r14 = true;
    L31:
        if (r14 == true) goto L32;
    L33:
        this.j = r10;
        int r15 = r10.size();
        String[] r16 = new String[r15];
        int r17 = 0;
    L34:
        if (r17 >= r15) goto L36;
        r16[r17] = "";
        r17 = r17 + 1;
        goto L34
    L36:
        boolean[] r18 = new boolean[r15];
        int r19 = 0;
    L37:
        if (r19 >= r15) goto L43;
        SeiRegion r20 = (SeiRegion) ListProtector.get(r10, r19);
        r16[r19] = r20.getInteractId().toString();
        if (r20.talk <= 0) goto L41;
        boolean r21 = true;
    L42:
        r18[r19] = r21;
        r19 = r19 + 1;
        goto L37
    L41:
        r21 = false;
        goto L42
    L43:
        onTalkStateUpdated(r16, r18);
        return;
    L30:
        r14 = false;
    L32:
        onOnlineListChangeBySei();
        goto L33
    }

    public final void onSpeechRecognitionSeiUpdate(String r2) {
        if (r2 == null) goto L7;
        IInteractFeedView r0 = this.b;
        if (r0 == null) goto L8;
        r0.updateSpeechRecognitionSei(r2);
        return;
    L8:
        return;
    }

    public final void onSpeechRhythm(String r2) {
        if (r2 == null) goto L7;
        IInteractFeedView r0 = this.b;
        if (r0 == null) goto L8;
        r0.updateSpeechRhythmSei(r2);
        return;
    L8:
        return;
    }

    public final void onVideoStateSeiUpdate(ld0.a r3) {
        if (r3 == null) goto L9;
        IInteractFeedView r0 = this.b;
        if ((r0 instanceof IKtvRoomFeedView) == true) goto L6;
        r0 = null;
    L6:
        IKtvRoomFeedView r1 = (IKtvRoomFeedView) r0;
        if (r1 == null) goto L9;
        r1.onKtvVideoStateChange(r3);
    L9:
        if (r3 == null) goto L14;
        Iterator r2 = CollectionsKt.toList(this.k).iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        ((IInteractFeedViewListener) r2.next()).onKtvVideoStateChange(r3);
        goto L12
    L16:
        return;
    }

    public final void parseSeiData(String r3) {
        Intrinsics.checkNotNullParameter(r3, "sei");
        Disposable r0 = this.h;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.h = Single.just(r3).map(new a(r3)).filter(b.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.a);
    }

    public final void registerFeedViewListener(IInteractFeedViewListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.k.contains(r2) == true) goto L8;
        this.k.add(r2);
        return;
    }

    public final void setMLivePlayerView(LivePlayerView r2) {
        this.a = r2;
        IInteractFeedView r0 = this.b;
        if (r0 == null) goto L8;
        if (r2 == null) goto L6;
        IRenderView r3 = r2.getRenderView();
    L7:
        r0.setLivePlayerView(r3);
        goto L8
    L6:
        r3 = null;
    L8:
        SeiAppData r4 = this.i;
        if (r4 == null) goto L14;
        IInteractFeedView r1 = this.b;
        if (r1 == null) goto L15;
        r1.onSeiUpdated(r4);
        return;
    L15:
        return;
    }

    public final void unregisterFeedViewListener(IInteractFeedViewListener r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.k.remove(r2);
    }

    public final void updateSceneByVer(SeiAppData r9) {
        Intrinsics.checkNotNullParameter(r9, "seiAppData");
        int r0 = r9.getVersion();
        int r1 = r9.getSubScene();
        int r2 = r9.getUiLayout();
        int r3 = this.g;
        boolean r5 = true;
        if (r3 != r2) goto L5;
    L7:
        boolean r4 = false;
    L8:
        int r7 = this.g;
        if (r7 != r2) goto L11;
    L13:
        r5 = false;
    L15:
        if (this.e == r0) goto L17;
    L20:
        a();
        Context r6 = this.m.getContext();
        FeedViewRoomInfoStore r8 = (FeedViewRoomInfoStore) this.l.getValue();
        if (r8 == null) goto L23;
        r8.setOnlineList(new ArrayList());
    L23:
        IInteractFeedView r10 = ((IInteractService) k.n(IInteractService.class)).getInteractFeedView(r6, r9, r2, this.n);
        this.b = r10;
        IRenderView r11 = null;
        if ((r10 instanceof View) == true) goto L26;
        r10 = null;
    L26:
        View r12 = (View) r10;
        if (r12 == null) goto L55;
        Iterator r13 = UtilityKotlinExtentionsKt.g(this.m).iterator();
    L30:
        if (r13.hasNext() == false) goto L34;
        Object r14 = r13.next();
        if ((((View) r14) instanceof IInteractFeedView) == false) goto L30;
    L35:
        View r15 = (View) r14;
        if (r15 == null) goto L38;
        this.m.removeView(r15);
    L38:
        this.m.setVisibility(0);
        this.m.addView(r12);
        IRoom r16 = this.d;
        if (r16 == null) goto L43;
        IInteractFeedView r17 = this.b;
        if (r17 == null) goto L43;
        r17.updateRoom(r16);
    L43:
        IInteractFeedView r18 = this.b;
        if (r18 == null) goto L49;
        LivePlayerView r19 = this.a;
        if (r19 == null) goto L48;
        r11 = r19.getRenderView();
    L48:
        r18.setLivePlayerView(r11);
    L49:
        SeiAppData r20 = this.i;
        if (r20 == null) goto L54;
        IInteractFeedView r21 = this.b;
        if (r21 == null) goto L54;
        r21.onSeiUpdated(r20);
    L54:
        this.m.post(new e(this));
        goto L55
    L34:
        r14 = null;
    L55:
        this.e = r0;
        this.f = r1;
        this.g = r2;
        return;
    L17:
        if (this.f != r1) goto L20;
        if (r4 == true) goto L20;
        if (r5 == true) goto L20;
        return;
    L11:
        if (CollectionsKt.listOf(new Integer[]{Integer.valueOf(r7), Integer.valueOf(r2)}).contains(61) == false) goto L13;
    L5:
        if (CollectionsKt.listOf(new Integer[]{Integer.valueOf(r3), Integer.valueOf(r2)}).contains(24) == false) goto L7;
        r4 = true;
        goto L8
    }

    public PreviewInteractFeedViewManager(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.m = r2;
        this.n = r3;
        this.c = new HashMap();
        this.k = Collections.synchronizedList(new ArrayList());
        this.l = LazyKt.lazy(PreviewInteractFeedViewManager$feedViewRoomInfoStore$2.INSTANCE);
    }

    public final boolean isVersionSupported(int r3, int r4) {
        IRoom r5 = this.d;
        if (r5 != null) goto L5;
    L8:
        if (r3 != (-1)) goto L10;
        SeiAppData r6 = new SeiAppData();
        r6.setVersion(r3);
        r6.setSubScene(0);
        updateSceneByVer(r6);
    L10:
        return true;
    L5:
        if (r5.isLiveTypeAudio() != true) goto L8;
        if (r3 != 0) goto L8;
        r3 = -1;
        goto L8
    }

    public final void onTalkStateUpdated(String[] r6, boolean[] r7) {
        if (r6 == null) goto L8;
        int r0 = r6.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L8;
        if (r7 == null) goto L7;
        boolean r2 = r7[r1];
        Boolean r3 = this.c.put(r6[r1], Boolean.valueOf(r2));
    L7:
        r1 = r1 + 1;
    L8:
        IInteractFeedView r8 = this.b;
        if (r8 == null) goto L15;
        r8.updateTalkState(this.c);
        return;
    }

    public final void bind(IRoom r1, boolean r2, String r3, String r4, Runnable r5) {
        Intrinsics.checkNotNullParameter(r1, PbRequest.SwitchType.ROOM);
        this.d = r1;
        FeedViewRoomInfoStore r6 = (FeedViewRoomInfoStore) this.l.getValue();
        if (r6 == null) goto L5;
        r6.setRoom(r1);
    L5:
        a();
        this.e = 0;
        this.f = 0;
        this.g = 0;
        if (r5 == null) goto L9;
        r5.run();
        return;
    }
}
