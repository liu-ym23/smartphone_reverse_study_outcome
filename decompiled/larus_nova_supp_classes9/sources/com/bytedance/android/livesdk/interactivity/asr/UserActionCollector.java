package com.bytedance.android.livesdk.interactivity.asr;

import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.interactivity.api.asr.UserActionType;
import com.bytedance.android.livesdk.interactivity.api.asr.utils.AnchorAsrUtils;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.message.model.MemberMessage;
import com.bytedance.android.livesdk.message.model.ek;
import com.bytedance.android.livesdk.message.model.fk;
import com.bytedance.android.livesdk.message.model.gk;
import com.bytedance.android.livesdk.message.model.kl;
import com.bytedance.android.livesdk.message.model.l4;
import com.bytedance.android.livesdk.message.model.n5;
import com.bytedance.android.livesdk.message.model.yd;
import com.bytedance.android.livesdkapi.message.IRoomMessageExtra;
import com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l22.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class UserActionCollector implements l22.e {
    public final boolean a;
    public final ReentrantLock b;
    public volatile boolean c;
    public final LinkedList<Pair<h, f<?>>> d;
    public Disposable e;
    public Disposable f;
    public m22.b g;
    public final CacheMode h;
    public final long i;
    public final int j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ UserActionCollector a;

        public a(UserActionCollector r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            ReentrantLock r6 = this.a.b;
            r6.lock();
            this.a.e(System.currentTimeMillis());     // Catch: Throwable -> L6
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
            r6.unlock();
            return;
        L6:
            th = move-exception;
            r6.unlock();
            throw th;
        }
    }

    @Override // l22.e
    public final void init() {
        if (this.a == true) goto L5;
        return;
    L5:
        if (this.c == true) goto L13;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("UserActionCollector init");
        this.c = true;
        this.e = com.bytedance.android.livesdk.interactivity.api.asr.utils.e.c(true, new AnonymousClass1(this));
        if (this.h != CacheMode.TIME) goto L12;
        this.f = Observable.interval(this.i, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        return;
    L12:
        return;
    }

    @Override // l22.e
    public final void release() {
        if (this.c == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("UserActionCollector release");
        this.c = false;
        Disposable r0 = this.e;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        this.e = null;
        Disposable r1 = this.f;
        if (r1 == null) goto L11;
        r1.dispose();
    L11:
        this.f = null;
        this.g = null;
        ReentrantLock r2 = this.b;
        r2.lock();
        this.d.clear();     // Catch: Throwable -> L15
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r2.unlock();
        return;
    L15:
        th = move-exception;
        r2.unlock();
        throw th;
    }

    public static com.bytedance.android.livesdk.interactivity.api.asr.model.b g(f r10) {
        n5 r0 = r10.b;
        if (r0 != null) goto L5;
        return null;
    L5:
        com.bytedance.android.livesdk.interactivity.api.asr.model.b r2 = new com.bytedance.android.livesdk.interactivity.api.asr.model.b();
        Long r3 = StringsKt.toLongOrNull(r10.y());
        long r4 = 0;
        if (r3 == null) goto L8;
        long r6 = r3.longValue();
    L9:
        r2.userId = r6;
        IBaseUser r11 = r10.x();
        if (r11 == null) goto L12;
        String r13 = r11.getNickName();
    L13:
        r2.userName = r13;
        if ((r0 instanceof MemberMessage) == false) goto L16;
        r2.textType = 1;
    L87:
        return r2;
    L16:
        boolean r14 = r0 instanceof n5;
        String r7 = BuildConfig.FLAVOR;
        int r8 = 4;
        if (r14 == false) goto L26;
        r2.textType = 4;
        n5 r1 = r0;
        long r5 = r1.getRepeatCount();
        h1 r15 = r1.getGift();
        if (r15 == null) goto L24;
        String r16 = r15.getName();
        if (r16 == null) goto L24;
        r7 = r16;
    L24:
        r2.extra = f(r5, r7);
        goto L87
    L26:
        if ((r0 instanceof kc2.b) == false) goto L35;
        r2.textType = 4;
        kc2.b r9 = (kc2.b) r0;
        long r17 = r9.f;
        h2 r18 = r9.d();
        if (r18 == null) goto L33;
        String r19 = r18.getName();
        if (r19 == null) goto L33;
        r7 = r19;
    L33:
        r2.extra = f(r17, r7);
        goto L87
    L35:
        if ((r0 instanceof yd) == false) goto L38;
        r2.textType = 5;
        goto L87
    L38:
        if ((r0 instanceof kl) == false) goto L47;
        int r110 = (int) ((kl) r0).getAction();
        if (r110 == 1) goto L44;
        int r20 = 3;
        if (r110 == 3) goto L45;
        return null;
    L45:
        r2.textType = r20;
        goto L87
    L44:
        r20 = 2;
        goto L45
    L47:
        if ((r0 instanceof l4) == false) goto L49;
        r2.textType = 6;
        goto L87
    L49:
        boolean r111 = r0 instanceof ek;
        if (r111 == false) goto L87;
        String r21 = ((ek) r0).getBizScene();
        if (r21 == null) goto L86;
        int r23 = r21.hashCode();
        if (r23 == (-895171796)) goto L83;
        if (r23 == 26331015) goto L65;
        if (r23 != 1483949304) goto L86;
        if (r21.equals("level_up_msg") == false) goto L86;
        r8 = 7;
    L85:
        r2.textType = r8;
        goto L87
    L65:
        if (r21.equals("send_gift") == false) goto L86;
        if (r111 == true) goto L68;
        r0 = null;
    L68:
        ek r24 = (ek) r0;
        if (r24 == null) goto L85;
        fk r112 = r24.getExtra();
        if (r112 == null) goto L85;
        gk r113 = r112.getGiftExtra();
        if (r113 == null) goto L85;
        gk r114 = r113;
        String r25 = r114.getGiftCount();
        if (r25 == null) goto L77;
        r4 = CastLongProtector.parseLong(r25);
    L77:
        String r115 = r114.giftName;
        if (r115 == null) goto L81;
        r7 = r115;
    L81:
        r2.extra = f(r4, r7);
        Unit r116 = Unit.INSTANCE;
        goto L85
    L83:
        if (r21.equals("sound_waves_msg") == false) goto L86;
        r8 = 8;
    L86:
        return null;
    L12:
        r13 = null;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    @Override // l22.d
    public final void b(f<?> r9) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (this.c == true) goto L7;
        return;
    L7:
        m22.b r0 = this.g;
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.a == true) goto L13;
        return;
    L13:
        IBaseUser r1 = r9.x();
        l22.c r2 = null;
        if (r1 == null) goto L64;
        c4 r4 = r9.b;
        if (r4 == null) goto L61;
        c4 r5 = (tlc.d) r4;
        if (((Boolean) PublicScreenABHelper.B.getValue()).booleanValue() == true) goto L22;
    L26:
        boolean r6 = false;
    L27:
        if (r6 == false) goto L30;
        UserActionType r7 = UserActionType.Thanks;
    L63:
        if (r7 == null) goto L64;
        h r8 = new h(r1, System.currentTimeMillis(), r7);
    L66:
        if (r8 != null) goto L68;
        return;
    L68:
        UserActionType r3 = r8.getType();
        if (r3 != UserActionType.Welcome) goto L73;
        if (r0.b == true) goto L73;
        return;
    L73:
        if (r3 != UserActionType.Thanks) goto L77;
        if (r0.c == true) goto L77;
        return;
    L77:
        if (r3 == UserActionType.Congrats) goto L79;
    L81:
        ReentrantLock r10 = this.b;
        r10.lock();
        this.d.add(TuplesKt.to(r8, r9));     // Catch: Throwable -> L105
        if (this.h == CacheMode.NUM) goto L85;
        e(r8.b);     // Catch: Throwable -> L105
    L90:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L105
        r10.unlock();
        StringBuilder r13 = new StringBuilder("onUserAction type=");
        T r14 = r9.b;
        if (r14 == 0) goto L94;
        String r15 = r14.getMessageMethod();
    L95:
        r13.append(r15);
        r13.append(" actionType=");
        r13.append(r3);
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c(r13.toString());
        int r16 = AnchorAsrUtils.a;
        com.bytedance.android.livesdk.interactivity.api.f r17 = o.b();
        if (r17 == null) goto L102;
        j<l22.a> r18 = r17.getAnchorAsrContext();
        if (r18 == null) goto L102;
        l22.a r19 = (l22.a) r18.getValue();
        if (r19 == null) goto L102;
        r2 = r19.getAnchorAsrManager();
    L102:
        if (r2 == null) goto L114;
        r2.b(r8);
        return;
    L114:
        return;
    L94:
        r15 = null;
    L85:
        if ((!this.d.isEmpty()) == false) goto L90;
        if (this.d.size() <= this.j) goto L90;
        this.d.poll();     // Catch: Throwable -> L105
    L105:
        th = move-exception;
        r10.unlock();
        throw th;
    L79:
        if (r0.d == true) goto L81;
        return;
    L30:
        if ((r4 instanceof MemberMessage) == false) goto L35;
        if (((int) ((MemberMessage) r4).getAction()) != 1) goto L35;
        r7 = UserActionType.Welcome;
    L35:
        if ((r4 instanceof n5) == false) goto L37;
    L62:
        r7 = UserActionType.Thanks;
        goto L63
    L37:
        if ((r4 instanceof kc2.b) == true) goto L62;
        if ((r4 instanceof yd) == false) goto L43;
        r7 = UserActionType.Thanks;
        goto L63
    L43:
        if ((r4 instanceof kl) == false) goto L50;
        kl r20 = (kl) r4;
        if (((int) r20.getAction()) != 1) goto L47;
    L48:
        r7 = UserActionType.Thanks;
        goto L63
    L47:
        if (((int) r20.getAction()) == 3) goto L48;
    L50:
        if ((r4 instanceof l4) == false) goto L55;
        if (((l4) r4).getAction() != 2) goto L55;
        r7 = UserActionType.Thanks;
    L55:
        if ((r4 instanceof ek) == false) goto L61;
        ek r21 = (ek) r4;
        if (Intrinsics.areEqual(r21.getBizScene(), "level_up_msg") == false) goto L59;
    L60:
        r7 = UserActionType.Congrats;
        goto L63
    L59:
        if (Intrinsics.areEqual(r21.getBizScene(), "sound_waves_msg") == false) goto L61;
    L22:
        if ((r5 instanceof c4) == false) goto L26;
        if (r5.isGiftTypeMessage() == false) goto L26;
        r6 = true;
    L61:
        r7 = null;
    L64:
        r8 = null;
        goto L66
    }

    public final void e(long r6) {
    L3:
        if ((!this.d.isEmpty()) == false) goto L12;
        Pair<h, f<?>> r0 = this.d.peek();
        if (r0 == null) goto L17;
        h r1 = (h) r0.getFirst();
        if (r1 == null) goto L18;
        if ((r6 - r1.b) < this.i) goto L19;
        this.d.poll();
        goto L3
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public static String f(long r2, String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("gift_num", r2);     // Catch: JSONException -> L5
        r0.put("gift_name", r4);     // Catch: JSONException -> L5
    L8:
        return r0.toString();
    L5:
        e = move-exception;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("getGiftExtra error", e);
        goto L8
    }

    @Override // l22.e
    public final List<String> a(long r9, long r11) {
        if (this.c == false) goto L62;
        if (r9 > r11) goto L62;
        ArrayList r0 = new ArrayList();
        ReentrantLock r1 = this.b;
        r1.lock();
        Iterator<Pair<h, f<?>>> r2 = this.d.iterator();     // Catch: Throwable -> L58
    L10:
        if (r2.hasNext() == false) goto L55;
        Pair<h, f<?>> r3 = r2.next();     // Catch: Throwable -> L58
        h r4 = (h) r3.component1();     // Catch: Throwable -> L58
        f r5 = (f) r3.component2();     // Catch: Throwable -> L58
        long r6 = r4.b;     // Catch: Throwable -> L58
        if (r6 < r9) goto L10;
        if (r6 > r11) goto L55;
        String r7 = r4.a.getNickName();     // Catch: Throwable -> L58
        if (r7 == null) goto L20;
        r0.add(r7);     // Catch: Throwable -> L58
    L20:
        c4 r8 = r5.b;     // Catch: Throwable -> L58
        c4 r10 = (tlc.d) r8;     // Catch: Throwable -> L58
        if (((Boolean) PublicScreenABHelper.B.getValue()).booleanValue() == true) goto L23;
    L27:
        boolean r13 = false;
    L28:
        if (r13 == true) goto L30;
        if ((r8 instanceof n5) == true) goto L43;
        if ((r8 instanceof kc2.b) == false) goto L10;
        h2 r14 = ((kc2.b) r8).d();     // Catch: Throwable -> L58
        if (r14 == null) goto L10;
        String r15 = r14.getName();     // Catch: Throwable -> L58
        if (r15 == null) goto L10;
        r0.add(r15);     // Catch: Throwable -> L58
        goto L10
    L43:
        h1 r16 = ((n5) r8).getGift();     // Catch: Throwable -> L58
        if (r16 == null) goto L10;
        String r17 = r16.getName();     // Catch: Throwable -> L58
        if (r17 == null) goto L10;
        r0.add(r17);     // Catch: Throwable -> L58
        goto L10
    L30:
        if ((r8 instanceof c4) == true) goto L32;
        r8 = null;
    L32:
        c4 r18 = r8;     // Catch: Throwable -> L58
        if (r18 == null) goto L10;
        IRoomMessageExtra r19 = r18.getRoomMessageExtra();     // Catch: Throwable -> L58
        if (r19 == null) goto L10;
        IRoomMessageGiftExtra r20 = r19.getGiftExtra();     // Catch: Throwable -> L58
        if (r20 == null) goto L10;
        String r21 = r20.getGiftName();     // Catch: Throwable -> L58
        if (r21 == null) goto L10;
        r0.add(r21);     // Catch: Throwable -> L58
        goto L10
    L23:
        if ((r10 instanceof c4) == false) goto L27;
        if (r10.isGiftTypeMessage() == false) goto L27;
        r13 = true;
    L55:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L58
        r1.unlock();
        return r0;
    L58:
        th = move-exception;
        r1.unlock();
        throw th;
    L62:
        return CollectionsKt.emptyList();
    }

    @Override // l22.e
    public final List<com.bytedance.android.livesdk.interactivity.api.asr.model.b> c(long r7, int r9) {
        if (this.c == false) goto L23;
        if (r9 <= 0) goto L23;
        ReentrantLock r0 = this.b;
        r0.lock();
        LinkedList r1 = new LinkedList();     // Catch: Throwable -> L19
        int r2 = CollectionsKt.getLastIndex(this.d);     // Catch: Throwable -> L19
    L8:
        if (r2 < 0) goto L18;
        if (((h) this.d.get(r2).getFirst()).b > r7) goto L15;
        com.bytedance.android.livesdk.interactivity.api.asr.model.b r3 = g((f) this.d.get(r2).getSecond());     // Catch: Throwable -> L19
        if (r3 == null) goto L15;
        r1.addFirst(r3);     // Catch: Throwable -> L19
    L15:
        if (r1.size() >= r9) goto L18;
        r2 = r2 - 1;
    L18:
        r0.unlock();
        return r1;
    L19:
        th = move-exception;
        r0.unlock();
        throw th;
    L23:
        return CollectionsKt.emptyList();
    }

    @Override // l22.e
    public final List<com.bytedance.android.livesdk.interactivity.api.asr.model.b> d(long r8, long r10) {
        if (this.c == false) goto L25;
        if (r8 > r10) goto L25;
        ReentrantLock r0 = this.b;
        r0.lock();
        LinkedList<Pair<h, f<?>>> r1 = this.d;     // Catch: Throwable -> L21
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L21
        Iterator<T> r3 = r1.iterator();     // Catch: Throwable -> L21
    L9:
        if (r3.hasNext() == false) goto L20;
        Pair r4 = (Pair) r3.next();     // Catch: Throwable -> L21
        if (((h) r4.getFirst()).b >= r8) goto L14;
    L16:
        com.bytedance.android.livesdk.interactivity.api.asr.model.b r5 = null;
    L17:
        if (r5 == null) goto L9;
        r2.add(r5);     // Catch: Throwable -> L21
        goto L9
    L14:
        if (((h) r4.getFirst()).b > r10) goto L16;
        r5 = g((f) r4.getSecond());     // Catch: Throwable -> L21
        goto L17
    L20:
        r0.unlock();
        return r2;
    L21:
        th = move-exception;
        r0.unlock();
        throw th;
    L25:
        return CollectionsKt.emptyList();
    }

    public UserActionCollector(CacheMode r5, long r6, int r8, int r9) {
        if ((r9 & 2) == 0) goto L5;
        r6 = 0;
    L5:
        boolean r0 = false;
        if ((r9 & 4) == 0) goto L8;
        r8 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r5, "cacheMode");
        this.h = r5;
        this.i = r6;
        this.j = r8;
        if (r5 != CacheMode.TIME) goto L14;
        if (r6 > 0) goto L14;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("timeWindow " + r6 + " is negative");
    L18:
        this.a = r0;
        this.b = new ReentrantLock();
        this.d = new LinkedList();
        return;
    L14:
        if (r5 != CacheMode.NUM) goto L17;
        if (r8 > 0) goto L17;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a("cacheCnt " + r8 + " is negative");
    L17:
        r0 = true;
        goto L18
    }
}
