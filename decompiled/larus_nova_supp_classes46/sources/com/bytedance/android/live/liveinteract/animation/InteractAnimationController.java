package com.bytedance.android.live.liveinteract.animation;

import android.graphics.PointF;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.MultiLinkScriptInfo;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomInteractEmoji;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TaskState;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.config.i8;
import com.bytedance.android.livesdk.config.j8;
import com.bytedance.android.livesdk.config.mb0;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/animation/InteractAnimationController;", "Lvlc/l;", "Lcom/bytedance/android/live/liveinteract/animation/k0$c;", "Ltf0/h;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "b", "c", "d", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAnimationController implements vlc.l, k0.c, tf0.h, Observer<KVData> {
    public static final /* synthetic */ int g = 0;
    public e a;
    public final ConcurrentHashMap<String, h> b;
    public ArrayList<ILinkPlayerInfoBridge> c;
    public boolean d;
    public final CompositeDisposable e;
    public final DataCenter f;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ILinkPlayerInfoBridge) r1).getUserPosition()), Integer.valueOf(((ILinkPlayerInfoBridge) r2).getUserPosition()));
        }
    }

    public static final class b {
    }

    public static final class c {
        public final com.bytedance.android.live.liveinteract.videotalk.emoji.model.j a;
        public final String b;
        public boolean c;
        public final boolean d;

        public c(com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r2, String r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "emoji");
            Intrinsics.checkNotNullParameter(r3, "fromUid");
            Intrinsics.checkNotNullParameter(r4, "toUid");
            this.a = r2;
            this.b = r4;
            this.c = false;
            this.d = r5;
        }
    }

    public interface d extends e {

        public static final class a {
            public static void a(EPointF r1, EPointF r2, EPointF r3) {
                Intrinsics.checkNotNullParameter(r1, "currentPoint");
                Intrinsics.checkNotNullParameter(r2, "startPoint");
                Intrinsics.checkNotNullParameter(r3, "endPoint");
                e.a.a(r1, r2, r3);
            }

            public static void b(EPointF r1, EPointF r2, EPointF r3) {
                Intrinsics.checkNotNullParameter(r1, "currentPoint");
                Intrinsics.checkNotNullParameter(r2, "startPoint");
                Intrinsics.checkNotNullParameter(r3, "endPoint");
                e.a.b(r1, r2, r3);
            }

            public static /* synthetic */ EmojiSoundManager c(d r1) {
                return r1.I8("", "");
            }
        }

        EmojiSoundManager I8(String r1, String r2);
    }

    static {
    }

    public final void m() {
        this.d = true;
        Iterator<h> r0 = this.b.values().iterator();
    L3:
        Integer r2 = null;
        if (r0.hasNext() == false) goto L34;
        h r1 = r0.next();
        if (r1 == null) goto L3;
        k0 r3 = r1.a;
        monitor-enter(r3);
        Iterator<f> r4 = r3.a.iterator();     // Catch: Throwable -> L31
    L11:
        if (r4.hasNext() == false) goto L13;
        r4.next().recycle();     // Catch: Throwable -> L31
        goto L11
    L13:
        r3.a.clear();     // Catch: Throwable -> L31
        Object r5 = CollectionsKt.toHashSet(r3.b.a.keySet()).clone();     // Catch: Throwable -> L31
        if (r5 == null) goto L30;
        r3.f = (HashSet) r5;     // Catch: Throwable -> L31
        String r6 = "InteractAnimation.InteractionAnimationExecutor_" + r3.e;     // Catch: Throwable -> L31
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L31
        r7.append("stop waitingTaskType size : ");     // Catch: Throwable -> L31
        HashSet<Integer> r8 = r3.f;     // Catch: Throwable -> L31
        if (r8 == null) goto L18;
        r2 = Integer.valueOf(r8.size());     // Catch: Throwable -> L31
    L18:
        r7.append(r2);     // Catch: Throwable -> L31
        ALogger.d(r6, r7.toString());     // Catch: Throwable -> L31
        HashSet<Integer> r9 = r3.f;     // Catch: Throwable -> L31
        if (r9 == null) goto L27;
        Iterator<Integer> r10 = r9.iterator();     // Catch: Throwable -> L31
    L22:
        if (r10.hasNext() == false) goto L27;
        Integer r11 = r10.next();     // Catch: Throwable -> L31
        Handler r12 = r3.d;     // Catch: Throwable -> L31
        if (r12 == null) goto L22;
        r12.removeMessages(r11.intValue() | 256);     // Catch: Throwable -> L31
    L27:
        monitor-exit(r3);
        goto L3
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashSet<kotlin.Int> /* = java.util.HashSet<kotlin.Int> */");     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L34:
        this.a = null;
        Iterator<h> r13 = this.b.values().iterator();
    L36:
        if (r13.hasNext() == false) goto L40;
        h r14 = r13.next();
        if (r14 == null) goto L36;
        r14.d();
        goto L36
    }

    @Override // tf0.h
    public final boolean a() {
        XplayExternalContext r0 = XplayExternalContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getXplayRunning();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        boolean r2 = true;
    L10:
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r3 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (this.a == null) goto L24;
        if (r2 == false) goto L19;
        IGameDataService r4 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r4 == null) goto L19;
        com.bytedance.live.datacontext.m r5 = r4.getClearScreen();
        if (r5 == null) goto L19;
        if (((Boolean) r5.getValue()).booleanValue() != true) goto L19;
        return false;
    L19:
        if (r3 != null) goto L21;
    L22:
        return true;
    L21:
        if (com.bytedance.android.live.liveinteract.animation.universalwidget.a.b.a(r3) != true) goto L22;
        return false;
    L24:
        return false;
    L9:
        r2 = false;
        goto L10
    }

    @Override // tf0.h
    public final boolean c() {
        return ((i8) vm2.d.J5.getValue(null, vm2.d.a[345(0x159, float:4.83E-43)])).a().contains(Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
    }

    public final void l() {
        Iterator<h> r0 = this.b.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        h r1 = r0.next();
        if (r1 == null) goto L4;
        r1.c();
        goto L4
    L8:
        List<HSImageView> r2 = l0.a;
        ((ArrayList) l0.a).clear();
        com.bytedance.android.livesdk.chatroom.t r3 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r3 == null) goto L13;
        com.bytedance.live.datacontext.j r4 = r3.getMessageManager();
        if (r4 == null) goto L13;
        r4.c(new InteractAnimationController$release$1(this));
    L13:
        this.a = null;
        this.b.clear();
    }

    public InteractAnimationController(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.f = r3;
        this.b = new ConcurrentHashMap();
        this.e = new CompositeDisposable();
        com.bytedance.android.livesdk.chatroom.t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L7;
        r1.c(new AnonymousClass1(this));
    L7:
        r3.observe("data_online_changed_list", this);
        ArrayList<ILinkPlayerInfoBridge> r4 = (ArrayList) r3.get("data_online_changed_list", new ArrayList());
        if (r4 != null) goto L10;
    L12:
        this.c = r4;
        return;
    L10:
        if (r4.size() <= 1) goto L12;
        CollectionsKt.sortWith(r4, new a());
        goto L12
    }

    @Override // tf0.h
    public final void b(int r7) {
        Iterator<h> r0 = this.b.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L25;
        h r1 = r0.next();
        if (r1 == null) goto L4;
        k0 r2 = r1.a;
        Iterator<f> r3 = r2.a.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        f r4 = r3.next();
        if (r4.getType() != r7) goto L9;
        r4.recycle();
        r2.a.remove(r4);
        goto L9
    L13:
        Iterator<CopyOnWriteArrayList<f>> r5 = r2.b.a.values().iterator();
    L15:
        if (r5.hasNext() == false) goto L4;
        CopyOnWriteArrayList<f> r6 = r5.next();
        if (r6 == null) goto L15;
        Iterator<f> r8 = r6.iterator();
    L21:
        if (r8.hasNext() == false) goto L15;
        f r9 = r8.next();
        if (r9.getType() != r7) goto L21;
        r9.recycle();
        r6.remove(r9);
        goto L21
    }

    @Override // tf0.h
    public final PointF d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        e r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Mj(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.k0.c
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        h r0 = this.b.get(r2);
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.b.remove(r2);
        if (this.b.size() != 0) goto L9;
        jc1.k.n(IHostFrescoHelper.class).updateAnimatedFrameScheduler(false);
        return;
    }

    public final void g(e r7) {
        Intrinsics.checkNotNullParameter(r7, "provider");
        this.a = r7;
        Iterator<h> r8 = this.b.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        h r0 = r8.next();
        if (r0 == null) goto L4;
        r0.a(this.a);
        goto L4
    L9:
        if (this.d == false) goto L37;
        this.d = false;
        Iterator<h> r1 = this.b.values().iterator();
    L12:
        if (r1.hasNext() == false) goto L57;
        h r2 = r1.next();
        if (r2 == null) goto L12;
        k0 r3 = r2.a;
        r3.getClass();
        String r4 = "InteractAnimation.InteractionAnimationExecutor_" + r3.e;
        StringBuilder r5 = new StringBuilder("resume waitingTaskType size : ");
        HashSet<Integer> r6 = r3.f;
        if (r6 == null) goto L18;
        Integer r9 = Integer.valueOf(r6.size());
    L19:
        r5.append(r9);
        ALogger.d(r4, r5.toString());
        if (r3.b.b() <= 0) goto L12;
        HashSet<Integer> r10 = r3.f;
        if (r10 != null) goto L24;
    L27:
        boolean r11 = true;
    L28:
        if (r11 == true) goto L12;
        HashSet<Integer> r12 = r3.f;
        Intrinsics.checkNotNull(r12);
        Iterator<Integer> r13 = r12.iterator();
    L32:
        if (r13.hasNext() == false) goto L36;
        Integer r14 = r13.next();
        Handler r15 = r3.d;
        if (r15 == null) goto L32;
        r15.sendEmptyMessage(r14.intValue() | 256);
        goto L32
    L36:
        r3.f = null;
        goto L12
    L24:
        if (r10.isEmpty() == true) goto L27;
        r11 = false;
        goto L28
    L18:
        r9 = null;
        goto L19
    L57:
        return;
    }

    public final void i(int r6) {
        Iterator<h> r0 = this.b.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        h r1 = r0.next();
        if (r1 == null) goto L4;
        k0 r2 = r1.a;
        Iterator<f> r3 = r2.a.iterator();
    L9:
        if (r3.hasNext() == false) goto L4;
        f r4 = r3.next();
        if (r4.getType() != r6) goto L9;
        r4.recycle();
        r2.a.remove(r4);
        goto L9
    }

    public final h j(String r3) {
        Intrinsics.checkNotNullParameter(r3, "animationId");
        if (this.b.get(r3) == null) goto L6;
        h r4 = this.b.get(r3);
        Intrinsics.checkNotNull(r4);
        return r4;
    L6:
        h r0 = new h(r3, this);
        r0.a(this.a);
        this.b.put(r3, r0);
        return r0;
    }

    public final boolean k(int r4) {
        Iterator<h> r0 = this.b.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        h r1 = r0.next();
        if (r1 == null) goto L4;
        if (r1.a.b(r4) != true) goto L4;
        return true;
    L10:
        return false;
    }

    public final void onChanged(Object r13) {
        KVData r14 = (KVData) r13;
        if (r14 == null) goto L5;
        String r1 = r14.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "data_online_changed_list") == false) goto L111;
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        ArrayList r15 = (ArrayList) r14.getData();
        if (r15 != null) goto L11;
        r15 = new ArrayList();
    L11:
        r2.element = r15;
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        r16.element = new ArrayList();
        ArrayList r3 = (ArrayList) r2.element;
        if (r3 != null) goto L14;
    L16:
        ArrayList<ILinkPlayerInfoBridge> r4 = this.c;
        if (r4 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == true) goto L49;
        ArrayList<ILinkPlayerInfoBridge> r6 = this.c;
        Intrinsics.checkNotNull(r6);
        Iterator<ILinkPlayerInfoBridge> r7 = r6.iterator();
    L26:
        if (r7.hasNext() == false) goto L49;
        ILinkPlayerInfoBridge r8 = r7.next();
        ArrayList r9 = (ArrayList) r2.element;
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L29:
        if (r11.hasNext() == false) goto L47;
        Object r12 = r11.next();
        ILinkPlayerInfoBridge r17 = (ILinkPlayerInfoBridge) r12;
        if (r17.getUserPosition() != r8.getUserPosition()) goto L43;
        IBaseUser r18 = r17.getUser();
        if (r18 == null) goto L35;
        String r19 = r18.getIdString();
    L36:
        IBaseUser r110 = r8.getUser();
        if (r110 == null) goto L39;
        String r111 = r110.getIdString();
    L41:
        if (Intrinsics.areEqual(r19, r111) == false) goto L43;
        boolean r20 = true;
    L44:
        if (r20 == false) goto L29;
        r10.add(r12);
        goto L29
    L39:
        r111 = null;
        goto L41
    L35:
        r19 = null;
    L43:
        r20 = false;
        goto L44
    L47:
        if (r10.isEmpty() == false) goto L26;
        ((ArrayList) r16.element).add(r8);
    L49:
        ALogger.d("InteractAnimation.InteractAnimationController", new k(this, r2, r16));
        Iterator<h> r0 = this.b.values().iterator();
    L51:
        if (r0.hasNext() == false) goto L79;
        h r21 = r0.next();
        Iterator<String> r22 = l.a((ArrayList) r16.element).iterator();
    L54:
        if (r22.hasNext() == false) goto L51;
        String r23 = r22.next();
        if (r21 == null) goto L54;
        Intrinsics.checkNotNullParameter(r23, "toUserId");
        k0 r24 = r21.a;
        r24.getClass();
        Intrinsics.checkNotNullParameter(r23, "toUserId");
        Iterator<f> r25 = r24.a.iterator();
    L59:
        if (r25.hasNext() == false) goto L63;
        f r26 = r25.next();
        if (Intrinsics.areEqual(r26.getToUserId(), r23) == false) goto L59;
        r26.recycle();
        goto L59
    L63:
        m r27 = r24.b;
        r27.getClass();
        Intrinsics.checkNotNullParameter(r23, "toUserId");
        ArrayList r28 = new ArrayList();
        Iterator<CopyOnWriteArrayList<f>> r29 = r27.a.values().iterator();
    L65:
        if (r29.hasNext() == false) goto L75;
        CopyOnWriteArrayList<f> r30 = r29.next();
        if (r30 == null) goto L65;
        Iterator<f> r31 = r30.iterator();
    L71:
        if (r31.hasNext() == false) goto L65;
        f r32 = r31.next();
        if (Intrinsics.areEqual(r32.getToUserId(), r23) == false) goto L71;
        r30.remove(r32);
        r28.add(r32);
        goto L71
    L75:
        Iterator r33 = r28.iterator();
    L77:
        if (r33.hasNext() == false) goto L54;
        ((f) r33.next()).recycle();
        goto L77
    L79:
        this.c = (ArrayList) r2.element;
        return;
    L19:
        if (r4.isEmpty() == true) goto L22;
        r5 = false;
        goto L23
    L14:
        if (r3.size() <= 1) goto L16;
        CollectionsKt.sortWith(r3, new j());
        goto L16
    L111:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void onMessage(tlc.d r8) {
        if (k(3) == false) goto L5;
        return;
    L5:
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCleanMode();
        if (r0 == null) goto L10;
        Integer r1 = (Integer) r0.getValue();
        if (r1 == null) goto L10;
        int r2 = r1.intValue();
    L11:
        if (r2 == 0) goto L14;
        return;
    L14:
        if ((r8 instanceof w8) == false) goto L69;
        w8 r9 = (w8) r8;
        if (r9.isInteractEmoji() == false) goto L47;
        StringBuilder r3 = new StringBuilder("consumeInteractEmojiMessage fromUser ");
        IBaseUser r4 = r9.getFromUser();
        Boolean r5 = null;
        if (r4 == null) goto L20;
        String r6 = r4.getIdString();
    L21:
        r3.append(r6);
        r3.append(" toUserId ");
        IBaseUser r7 = r9.getToUser();
        if (r7 == null) goto L24;
        String r10 = r7.getIdString();
    L25:
        r3.append(r10);
        i.a("InteractAnimation.InteractAnimationController", r3.toString());
        IBaseUser r11 = r9.getFromUser();
        if (r11 == null) goto L62;
        String r12 = r11.getIdString();
        if (r12 == null) goto L67;
        IBaseUser r13 = r9.getToUser();
        if (r13 == null) goto L63;
        String r14 = r13.getIdString();
        if (r14 == null) goto L68;
        StringBuilder r15 = new StringBuilder("consumeInteractEmojiMessage isCanConsume : ");
        e r16 = this.a;
        if (r16 == null) goto L38;
        r5 = Boolean.valueOf(r16.K5(r12, r14));
    L38:
        r15.append(r5);
        i.a("InteractAnimation.InteractAnimationController", r15.toString());
        e r17 = this.a;
        if (r17 != null) goto L41;
        return;
    L41:
        if (r17.K5(r12, r14) != true) goto L65;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.i r18 = r9.getDynamicEmoji();
        if (r18 == null) goto L66;
        n r19 = j(r12).b(r18);
        r19.e = 1;
        Intrinsics.checkNotNullParameter(r12, "userId");
        r19.a = r12;
        Intrinsics.checkNotNullParameter(r14, "userId");
        r19.b = r14;
        r19.a();
        return;
    L66:
        return;
    L65:
        return;
    L68:
        return;
    L63:
        return;
    L67:
        return;
    L62:
        return;
    L24:
        r10 = null;
        goto L25
    L20:
        r6 = null;
        goto L21
    L47:
        if (r9.isFriendTreeInteractEmoji() == false) goto L70;
        IBaseUser r20 = r9.getFromUser();
        if (r20 == null) goto L71;
        String r21 = r20.getIdString();
        if (r21 == null) goto L74;
        IBaseUser r22 = r9.getToUser();
        if (r22 == null) goto L72;
        String r23 = r22.getIdString();
        if (r23 == null) goto L75;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.i r24 = r9.getDynamicEmoji();
        if (r24 == null) goto L73;
        n r25 = j(r21).b(r24);
        r25.e = 2;
        Intrinsics.checkNotNullParameter(r21, "userId");
        r25.a = r21;
        Intrinsics.checkNotNullParameter(r23, "userId");
        r25.b = r23;
        r25.a();
        return;
    L73:
        return;
    L75:
        return;
    L72:
        return;
    L74:
        return;
    L71:
        return;
    L70:
        return;
    L69:
        return;
    L10:
        r2 = 0;
        goto L11
    }

    public final void h(com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r3, com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r4, com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r5, com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r6, int r7) {
        r3.setRevenueData(new com.bytedance.android.live.liveinteract.videotalk.emoji.model.p(r4, r2, r5, r6));
        n r8 = j(r2.a).b(r3);
        List<String> r9 = r6.b;
        Intrinsics.checkNotNullParameter(r9, "userIDs");
        ((ArrayList) r8.c).clear();
        ArrayList r10 = (ArrayList) r8.c;
        r10.addAll(r9);
        r8.h = r6.c;
        if (r7 != 1) goto L5;
        r8.e = 3;
    L9:
        r8.a();
        return;
    L5:
        if (r7 != 2) goto L9;
        r8.e = 4;
        goto L9
    }

    @Override // tf0.h
    public final void f(final dq2.n r18, final com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r19, final com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r20, TalkRoomInteractEmoji r21, String r22, MultiLinkScriptInfo r23, com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r24) {
        Intrinsics.checkNotNullParameter(r19, "giftInfo");
        Intrinsics.checkNotNullParameter(r24, "positionInfo");
        if (((List) mb0.a.getValue()).contains(Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentUiLayout())) == true) goto L125;
        int r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentUiLayout();
        String r6 = je0.d.a();
        Iterator<T> r8 = r19.c.iterator();
    L5:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r10 = null;
        if (r8.hasNext() == false) goto L10;
        Object r9 = r8.next();
        if (Intrinsics.areEqual((String) r9, r6) == false) goto L5;
    L11:
        String r11 = (String) r9;
        ILinkPlayerInfoBridge r12 = ((IInteractService) jc1.k.n(IInteractService.class)).getGuestInfo(r6, "");
        ArrayList<ILinkPlayerInfoBridge> r13 = this.c;
        if (r13 == null) goto L14;
        int r14 = r13.size();
    L15:
        StringBuilder r15 = new StringBuilder("isAnchorGiftOnFactionClash, giftType: ");
        r15.append(r19.d);
        r15.append(", uiLayout: ");
        r15.append(r1);
        r15.append(", anchor position: ");
        if (r12 == null) goto L18;
        Integer r16 = Integer.valueOf(r12.getUserPosition());
    L19:
        r15.append(r16);
        r15.append(", anchorId: ");
        r15.append(r6);
        r15.append(", send Id: ");
        r15.append(r19.b);
        r15.append(", to Id: ");
        r15.append(r11);
        r15.append(", user List size: ");
        r15.append(r14);
        ALogger.i("InteractAnimation.InteractAnimationController", r15.toString());
        if (r1 == 66) goto L22;
    L32:
        boolean r2 = false;
    L33:
        if (r2 == true) goto L125;
        final int r7 = r19.d;
        if (r7 == 2) goto L38;
    L41:
        ArrayList<String> r17 = l.a((ArrayList) this.f.get("data_online_changed_list", new ArrayList()));
        e r110 = this.a;
        if (r110 == null) goto L47;
        String r111 = (String) CollectionsKt.getOrNull(r19.c, 0);
        if (r111 != null) goto L46;
        r111 = "0";
    L46:
        int r112 = r110.zl(r111);
    L48:
        e r113 = this.a;
        if (r113 != null) goto L51;
    L54:
        xc0.b.a.getClass();
        ReadOnlyProperty r114 = vm2.d.t7;
        KProperty[] r115 = vm2.d.a;
        if (((Boolean) r114.getValue(null, r115[432(0x1b0, float:6.05E-43)])).booleanValue() == false) goto L57;
        xc0.b r116 = xc0.c.b;
    L58:
        final com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r0 = r116.a(this.a, r19, r24, r17);
        List<String> r117 = r0.b;
        List<String> r3 = CollectionsKt.toList(CollectionsKt.intersect(r117, CollectionsKt.toSet(r17)));
        if (r3.isEmpty() == false) goto L62;
        i.a("InteractAnimation.InteractAnimationController", "executeFlyMicAnimation#no receiver.gift:" + r19 + ".onlineList:" + r17 + ",receiverList:" + r117);
        r18.c(r19, TaskState.CANCEL);
        MultiLinkEventModule r4 = yc0.a.a;
        yc0.b.a r5 = new yc0.b.a();
        Intrinsics.checkNotNullParameter("no_receiver", "reason");
        r5.a = "no_receiver";
        r5.e = r19;
        r5.b = r19.k;
        yc0.a.b(new yc0.b(r5));
        return;
    L62:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r19.c = r3;
        if (r2.a(r19.j) == true) goto L65;
    L91:
        String r25 = r19.h;
        if (r25 == null) goto L107;
        if (r25.length() <= 0) goto L96;
        boolean r118 = true;
    L97:
        if (r118 != true) goto L107;
        ALogger.e("InteractAnimation.InteractAnimationController", "buildAndExecuteTask.start InteractEffect");
        if (k(1) == false) goto L102;
        ALogger.d("InteractAnimation.InteractAnimationController", "cancel emoji animation when play 3D gift");
        i(1);
    L102:
        if (k(2) == false) goto L104;
        ALogger.d("InteractAnimation.InteractAnimationController", "cancel reward emoji animation when play 3D gift");
        i(2);
    L104:
        int r26 = s0.a;
        ((IInteractService) jc1.k.n(IInteractService.class)).start3DAnim(r18, r19, r20, r21, r22, r0, r23, this.a);
        return;
    L96:
        r118 = false;
    L107:
        if (TextUtils.isEmpty(r22) == false) goto L111;
        if (r21 != null) goto L111;
        i.a("InteractAnimation.InteractAnimationController", "executeFlyMicAnimation#no resources.gift:" + r19);
        r18.c(r19, TaskState.CANCEL);
        MultiLinkEventModule r27 = yc0.a.a;
        yc0.b.a r28 = new yc0.b.a();
        Intrinsics.checkNotNullParameter("no_resource", "reason");
        r28.a = "no_resource";
        r28.e = r19;
        r28.b = r19.k;
        yc0.a.b(new yc0.b(r28));
        return;
    L111:
        if (r21 != null) goto L123;
        xc0.d r29 = new xc0.d();
        Intrinsics.checkNotNull(r22);
        CompositeDisposable r30 = this.e;
        Function2<Boolean, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m, Unit> r119 = new InteractAnimationController$executeFlyMicAnimation$1(this, r19, r18, r20, r0, r7);
        Intrinsics.checkNotNullParameter(r22, "path");
        Intrinsics.checkNotNullParameter("extra.json", "name");
        Intrinsics.checkNotNullParameter(r30, "dis");
        Intrinsics.checkNotNullParameter(r119, "onResult");
        String r31 = r22 + "extra.json";
        LruCache<String, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m> r32 = xc0.h.a;
        Intrinsics.checkNotNullParameter(r31, "key");
        if (TextUtils.isEmpty(r31) == true) goto L119;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r33 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.m) xc0.h.a.get(r31);
        if (r33 == null) goto L119;
        r10 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.m) vh7.f.c(com.bytedance.android.live.liveinteract.videotalk.emoji.model.m.class);
        r10.setReceiverEmoji(r33.getReceiverEmoji());
        r10.setSenderEmoji(r33.getSenderEmoji());
        r10.setPathEmoji(r33.getPathEmoji());
    L119:
        if (r10 == null) goto L121;
        r119.invoke(Boolean.TRUE, r10);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#hit cache key:".concat(r31));
        return;
    L121:
        r30.add(Observable.create(new xc0.e(r29, r31)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new xc0.f(r29, r119, r31, r22), new xc0.g(r119, r31)));
        return;
    L123:
        i.a("InteractAnimation.InteractAnimationController", "executeFlyMicAnimation#exe sync success.gift:" + r19 + ",data:" + r21);
        h(r19, r21, r18, r20, r0, r7);
        return;
    L65:
        if (r2.a(r19.l) == true) goto L75;
        String r34 = r19.h;
        if (r34 != null) goto L69;
    L72:
        boolean r35 = true;
    L73:
        if (r35 == false) goto L91;
    L69:
        if (r34.length() == 0) goto L72;
        r35 = false;
    L75:
        if (((Boolean) vm2.d.r7.getValue(null, r115[430(0x1ae, float:6.03E-43)])).booleanValue() == false) goto L86;
        String r36 = r19.h;
        if (r36 != null) goto L79;
    L82:
        boolean r120 = true;
    L83:
        if (r120 == false) goto L86;
        r18.c(r19, TaskState.COMPLETE);
        MultiLinkEventModule r37 = yc0.a.a;
        yc0.b.a r38 = new yc0.b.a();
        Intrinsics.checkNotNullParameter("doulite_ban", "reason");
        r38.a = "doulite_ban";
        r38.e = r19;
        r38.b = r19.k;
        yc0.a.b(new yc0.b(r38));
        return;
    L79:
        if (r36.length() == 0) goto L82;
        r120 = false;
    L86:
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r39 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r39 == null) goto L89;
        r39.m9(r18, r19, r20, r21, r22, r0, r23, this.a);
        return;
    L89:
        r18.c(r19, TaskState.COMPLETE);
        MultiLinkEventModule r40 = yc0.a.a;
        yc0.b.a r41 = new yc0.b.a();
        Intrinsics.checkNotNullParameter("service_empty", "reason");
        r41.a = "service_empty";
        r41.e = r19;
        r41.b = r19.k;
        yc0.a.b(new yc0.b(r41));
        return;
    L57:
        r116 = xc0.a.b;
        goto L58
    L51:
        if (r113.lo(r112) == true) goto L54;
        r18.c(r19, TaskState.CANCEL);
        return;
    L47:
        r112 = 0;
        goto L48
    L38:
        if (((j8) vm2.d.s7.getValue(null, vm2.d.a[431(0x1af, float:6.04E-43)])).a().contains(Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene())) == true) goto L41;
        i.a("InteractAnimation.InteractAnimationController", "executeFlyMicAnimation#animation not enable,gift:" + r19);
        r18.c(r19, TaskState.CANCEL);
        MultiLinkEventModule r42 = yc0.a.a;
        yc0.b.a r43 = new yc0.b.a();
        Intrinsics.checkNotNullParameter("performance_ban", "reason");
        r43.a = "performance_ban";
        r43.b = r19.k;
        r43.e = r19;
        yc0.a.b(new yc0.b(r43));
        return;
    L22:
        if (r14 <= 8) goto L32;
        if (Intrinsics.areEqual(r19.b, r6) == false) goto L26;
    L27:
        if (r12 == null) goto L29;
        int r44 = r12.getUserPosition();
    L30:
        if (r44 >= 0) goto L32;
        r2 = true;
        goto L33
    L29:
        r44 = -1;
        goto L30
    L26:
        if (Intrinsics.areEqual(r11, r6) == false) goto L32;
    L18:
        r16 = null;
        goto L19
    L14:
        r14 = 0;
        goto L15
    L10:
        r9 = null;
    L125:
        i.a("InteractAnimation.InteractAnimationController", "executeFlyMicAnimation#animation not support");
        r18.c(r19, TaskState.CANCEL);
    }
}
