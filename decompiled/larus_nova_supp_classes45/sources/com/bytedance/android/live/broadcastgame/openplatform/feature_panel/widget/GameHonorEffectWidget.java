package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget;

import android.content.SharedPreferences;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.IGameHonorEffectWidget;
import com.bytedance.android.live.broadcastgame.opengame.utils.Sp;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.message.model.ja;
import com.bytedance.android.livesdk.message.model.ka;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u0005\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/widget/GameHonorEffectWidget;", "Lcom/bytedance/android/live/broadcastgame/api/IGameHonorEffectWidget;", "Lvlc/l;", "<init>", "()V", "a", "b", "c", "d", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameHonorEffectWidget extends IGameHonorEffectWidget implements l {
    public final CompositeDisposable a;
    public final LinkedList<c> b;
    public ViewGroup c;
    public a d;
    public final Map<Long, d> e;
    public long f;

    public final class a implements Disposable {
        public zy0.b a;
        public final ViewGroup b;
        public final /* synthetic */ GameHonorEffectWidget c;

        public final void dispose() {
            this.b.removeAllViews();
            UtilityKotlinExtentionsKt.z(this.b, false);
            this.a = null;
        }

        public final boolean isDisposed() {
            if (this.a != null) goto L5;
            return true;
        L5:
            return false;
        }

        public a(GameHonorEffectWidget r2, ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r3, KtvSubElement.CONTAINER);
            this.c = r2;
            this.b = r3;
        }
    }

    public abstract class b implements d, Runnable {
        public final long a;
        public final ja b;
        public final a c;

        public final boolean isDisposed() {
            return false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.c) this).b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.GameHonorEffectWidget.d
        public final void stopPlay() {
            ((com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.c) this).b();
        }

        public final void dispose() {
            MainThreadPostUtils.d(this);
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.GameHonorEffectWidget.d
        public final long getId() {
            return this.a;
        }

        public b(long r2, ja r4, a r5) {
            Intrinsics.checkNotNullParameter(r4, "honorInfo");
            Intrinsics.checkNotNullParameter(r5, "provider");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class c {
        public final ja a;
        public final long b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L4;
            return true;
        L4:
            if ((r5 instanceof c) == false) goto L10;
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r6.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ja r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            long r2 = this.b;
            return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "HonorInfoWrapper(info=" + this.a + ", messageId=" + this.b + ")";
        }

        public c(ja r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "info");
            this.a = r2;
            this.b = r3;
        }
    }

    public interface d extends Disposable {
        long getId();

        void stopPlay();
    }

    public static final class e implements Action {
        public final /* synthetic */ vlc.d a;
        public final /* synthetic */ GameHonorEffectWidget b;

        public e(vlc.d r1, GameHonorEffectWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            this.a.removeMessageListener(this.b);
        }
    }

    public static final class f implements Action {
        public final /* synthetic */ GameHonorEffectWidget a;

        public f(GameHonorEffectWidget r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.wq();
        }
    }

    public final int getLayoutId() {
        return 2131567103;
    }

    public final boolean isMergeMode() {
        return true;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        ALogger.i("GameHonorEffectWidget", "unload widget");
        SharedPreferences r0 = (SharedPreferences) Sp.a.getValue();
        Long r1 = Long.valueOf(this.f);
        Intrinsics.checkNotNullParameter(r0, "$this$set");
        Intrinsics.checkNotNullParameter("ttlive_open_platform_honor_prev_message", "key");
        Intrinsics.checkNotNullParameter(r1, "value");
        SharedPreferences.Editor r2 = r0.edit();
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r1.getClass()), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L11;
        boolean r3 = r1 instanceof String;
        Object r4 = r1;
        if (r3 == true) goto L7;
        r4 = null;
    L7:
        String r5 = (String) r4;
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r2.putString("ttlive_open_platform_honor_prev_message", r5);
    L51:
        r2.apply();
        this.a.clear();
        return;
    L11:
        int r6 = 0;
        boolean r7 = false;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r1.getClass()), Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L21;
        boolean r8 = r1 instanceof Boolean;
        Object r9 = r1;
        if (r8 == true) goto L16;
        r9 = null;
    L16:
        Boolean r11 = (Boolean) r9;
        if (r11 == null) goto L19;
        r7 = r11.booleanValue();
    L19:
        r2.putBoolean("ttlive_open_platform_honor_prev_message", r7);
        goto L51
    L21:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r1.getClass()), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L31;
        boolean r12 = r1 instanceof Float;
        Object r13 = r1;
        if (r12 == true) goto L25;
        r13 = null;
    L25:
        Float r14 = (Float) r13;
        if (r14 == null) goto L28;
        float r15 = r14.floatValue();
    L29:
        r2.putFloat("ttlive_open_platform_honor_prev_message", r15);
        goto L51
    L28:
        r15 = 0.0f;
        goto L29
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r1.getClass()), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L34;
        r2.putLong("ttlive_open_platform_honor_prev_message", r1.longValue());
        goto L51
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r1.getClass()), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L43;
        boolean r16 = r1 instanceof Integer;
        Object r17 = r1;
        if (r16 == true) goto L38;
        r17 = null;
    L38:
        Integer r18 = (Integer) r17;
        if (r18 == null) goto L41;
        r6 = r18.intValue();
    L41:
        r2.putInt("ttlive_open_platform_honor_prev_message", r6);
        goto L51
    L43:
        if (Set.class.isAssignableFrom(r1.getClass()) == false) goto L51;
        boolean r19 = r1 instanceof Set;
        Object r21 = r1;
        if (r19 == true) goto L47;
        r21 = null;
    L47:
        Set<String> r22 = (Set) r21;
        if (r22 != null) goto L50;
        r22 = new HashSet();
    L50:
        r2.putStringSet("ttlive_open_platform_honor_prev_message", r22);
        goto L51
    }

    public final void wq() {
        ALogger.i("GameHonorEffectWidget", "clear resource");
        this.b.clear();
        ((LinkedHashMap) this.e).clear();
        a r0 = this.d;
        if (r0 == null) goto L5;
        this.a.remove(r0);
    L5:
        this.d = null;
    }

    public final void xq() {
        if (isAlive() == true) goto L5;
        return;
    L5:
        c r1 = this.b.peek();
        ALogger.i("GameHonorEffectWidget", "handle next message, next item " + r1);
        if (r1 == null) goto L8;
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        if ((!this.e.isEmpty()) == true) goto L28;
        this.b.poll();
        this.f = r1.b;
        ja r14 = r1.a;
        long r12 = System.currentTimeMillis() / ((long) 1000);
        if ((((long) r14.getDuration()) + r12) > r14.getPlayEndTimestamp()) goto L17;
        boolean r2 = true;
    L18:
        ALogger.i("GameHonorEffectWidget", "play animation, can play " + r2);
        if (r2 == false) goto L24;
        Function1<d, Unit> r11 = new GameHonorEffectWidget$playAnimation$1(this);
        a r3 = this.d;
        if (r3 != null) goto L23;
        ViewGroup r4 = this.c;
        Intrinsics.checkNotNull(r4);
        r3 = new a(this, r4);
        this.d = r3;
        RxUtilKt.c(r3, this.a);
    L23:
        final com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.c r5 = new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.c(r12, r11, r14, r12, r14, r3);
        RxUtilKt.c(r5, this.a);
        this.e.put(Long.valueOf(r5.a), r5);
        a r6 = r5.c;
        r6.getClass();
        com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.b r7 = new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.b(r6);
        Map r8 = MapsKt.mapOf(new Pair[]{TuplesKt.to("honor_scene", Integer.valueOf(r5.b.getHonorScene())), TuplesKt.to("container_payload", r5.b.getBody()), TuplesKt.to("id", String.valueOf(r5.a))});
        Intrinsics.checkNotNullParameter(r8, "data");
        RxUtilKt.n(Observable.create(new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.a(r7, r8)), new GameHonorEffectWidget$HonorAnimationPlaySession$startPlay$1(r5));
        return;
    L24:
        xq();
        return;
    L17:
        r2 = false;
        goto L18
    L28:
        return;
    L8:
        if (this.e.isEmpty() == false) goto L10;
        wq();
        goto L10
    }

    public GameHonorEffectWidget() {
        this.a = new CompositeDisposable();
        this.b = new LinkedList();
        this.e = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r2) {
        this.c = (ViewGroup) ((Widget) this).contentView.findViewById(2131379281);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r18) {
        ALogger.i("GameHonorEffectWidget", "load widget");
        SharedPreferences r1 = (SharedPreferences) Sp.a.getValue();
        float r5 = 0.0f;
        int r12 = 0;
        boolean r13 = false;
        int r14 = 0;
        int r15 = 0;
        boolean r16 = false;
        int r17 = 0;
        boolean r19 = false;
        int r110 = 0;
        boolean r111 = false;
        int r112 = 0;
        boolean r113 = false;
        int r114 = 0;
        boolean r115 = false;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(String.class)) == true) goto L5;
        KClass r2 = Reflection.getOrCreateKotlinClass(Long.class);
        Class r116 = Boolean.TYPE;
        if (Intrinsics.areEqual(r2, Reflection.getOrCreateKotlinClass(r116)) == false) goto L155;
        Boolean r3 = Boolean.FALSE;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L95;
        boolean r6 = r3 instanceof String;
        Object r4 = r3;
        if (r6 == true) goto L86;
        r4 = null;
    L86:
        String r7 = (String) r4;
        String r11 = "";
        if (r7 == null) goto L90;
        r11 = r7;
    L90:
        Object r8 = r1.getString("ttlive_open_platform_honor_prev_message", r11);
        if ((r8 instanceof Boolean) == true) goto L93;
        r8 = null;
    L93:
        Object r9 = (Boolean) r8;
    L150:
        if ((r9 instanceof Long) == true) goto L152;
        r9 = null;
    L152:
        Long r21 = (Long) r9;
    L551:
        if (r21 == null) goto L553;
        long r22 = r21.longValue();
    L554:
        this.f = r22;
        xlc.a r23 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        if (r23 != null) goto L557;
    L564:
        RxUtilKt.c(RxUtilKt.n(com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).B0("interactive_honor_close"), new AnonymousClass2(this)), this.a);
        RxUtilKt.c(Disposables.fromAction(new f(this)), this.a);
        return;
    L557:
        if ((r23 instanceof xlc.a) == true) goto L559;
        xlc.a r24 = null;
    L560:
        xlc.a r25 = r24;
        if (r25 == null) goto L563;
        r25.y(MessageType.OPEN_PLATFORM_LIVE_PLAY_HONOR_MESSAGE.getIntType(), this);
    L563:
        RxUtilKt.c(Disposables.fromAction(new e(r23, this)), this.a);
        goto L564
    L559:
        r24 = r23;
        goto L560
    L553:
        r22 = 0;
        goto L554
    L95:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(r116)) == false) goto L98;
        r9 = Boolean.valueOf(r1.getBoolean("ttlive_open_platform_honor_prev_message", false));
        goto L150
    L98:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L110;
        boolean r26 = r3 instanceof Float;
        Object r27 = r3;
        if (r26 == true) goto L102;
        r27 = null;
    L102:
        Float r28 = (Float) r27;
        if (r28 == null) goto L105;
        r5 = r28.floatValue();
    L105:
        Object r29 = Float.valueOf(r1.getFloat("ttlive_open_platform_honor_prev_message", r5));
        if ((r29 instanceof Boolean) == true) goto L108;
        r29 = null;
    L108:
        r9 = (Boolean) r29;
        goto L150
    L110:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L123;
        boolean r31 = r3 instanceof Long;
        Object r32 = r3;
        if (r31 == true) goto L114;
        r32 = null;
    L114:
        Long r33 = (Long) r32;
        if (r33 == null) goto L117;
        long r34 = r33.longValue();
    L118:
        Object r35 = Long.valueOf(r1.getLong("ttlive_open_platform_honor_prev_message", r34));
        if ((r35 instanceof Boolean) == true) goto L121;
        r35 = null;
    L121:
        r9 = (Boolean) r35;
        goto L150
    L117:
        r34 = 0;
        goto L118
    L123:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L135;
        boolean r36 = r3 instanceof Integer;
        Object r37 = r3;
        if (r36 == true) goto L127;
        r37 = null;
    L127:
        Integer r38 = (Integer) r37;
        if (r38 == null) goto L130;
        r15 = r38.intValue();
    L130:
        Object r39 = Integer.valueOf(r1.getInt("ttlive_open_platform_honor_prev_message", r15));
        if ((r39 instanceof Boolean) == true) goto L133;
        r39 = null;
    L133:
        r9 = (Boolean) r39;
        goto L150
    L135:
        if (Set.class.isAssignableFrom(Boolean.class) == false) goto L146;
        boolean r41 = r3 instanceof Set;
        Object r42 = r3;
        if (r41 == true) goto L139;
        r42 = null;
    L139:
        Set<String> r43 = (Set) r42;
        if (r43 != null) goto L142;
        r43 = new HashSet();
    L142:
        Object r44 = r1.getStringSet("ttlive_open_platform_honor_prev_message", r43);
        if ((r44 instanceof Boolean) == true) goto L145;
        r44 = null;
    L145:
        r9 = (Boolean) r44;
        goto L150
    L146:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(Boolean.class));
        if (v.a() == true) goto L154;
        r9 = Boolean.class.newInstance();
        goto L150
    L154:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(Boolean.class) + '}');
    L155:
        KClass r45 = Reflection.getOrCreateKotlinClass(Long.class);
        Class r46 = Float.TYPE;
        if (Intrinsics.areEqual(r45, Reflection.getOrCreateKotlinClass(r46)) == false) goto L234;
        Float r47 = Float.valueOf(0.0f);
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L171;
        boolean r48 = r47 instanceof String;
        Object r49 = r47;
        if (r48 == true) goto L162;
        r49 = null;
    L162:
        String r51 = (String) r49;
        String r117 = "";
        if (r51 == null) goto L166;
        r117 = r51;
    L166:
        Object r52 = r1.getString("ttlive_open_platform_honor_prev_message", r117);
        if ((r52 instanceof Float) == true) goto L169;
        r52 = null;
    L169:
        Object r53 = (Float) r52;
    L229:
        if ((r53 instanceof Long) == true) goto L231;
        r53 = null;
    L231:
        r21 = (Long) r53;
        goto L551
    L171:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(r116)) == false) goto L183;
        boolean r54 = r47 instanceof Boolean;
        Object r55 = r47;
        if (r54 == true) goto L175;
        r55 = null;
    L175:
        Boolean r56 = (Boolean) r55;
        if (r56 == null) goto L178;
        r16 = r56.booleanValue();
    L178:
        Object r57 = Boolean.valueOf(r1.getBoolean("ttlive_open_platform_honor_prev_message", r16));
        if ((r57 instanceof Float) == true) goto L181;
        r57 = null;
    L181:
        r53 = (Float) r57;
        goto L229
    L183:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(r46)) == false) goto L189;
        if (r47 == null) goto L186;
        float r58 = r47.floatValue();
    L187:
        r53 = Float.valueOf(r1.getFloat("ttlive_open_platform_honor_prev_message", r58));
        goto L229
    L186:
        r58 = 0.0f;
        goto L187
    L189:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L202;
        boolean r59 = r47 instanceof Long;
        Object r61 = r47;
        if (r59 == true) goto L193;
        r61 = null;
    L193:
        Long r62 = (Long) r61;
        if (r62 == null) goto L196;
        long r63 = r62.longValue();
    L197:
        Object r64 = Long.valueOf(r1.getLong("ttlive_open_platform_honor_prev_message", r63));
        if ((r64 instanceof Float) == true) goto L200;
        r64 = null;
    L200:
        r53 = (Float) r64;
        goto L229
    L196:
        r63 = 0;
        goto L197
    L202:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Float.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L214;
        boolean r65 = r47 instanceof Integer;
        Object r66 = r47;
        if (r65 == true) goto L206;
        r66 = null;
    L206:
        Integer r67 = (Integer) r66;
        if (r67 == null) goto L209;
        r17 = r67.intValue();
    L209:
        Object r68 = Integer.valueOf(r1.getInt("ttlive_open_platform_honor_prev_message", r17));
        if ((r68 instanceof Float) == true) goto L212;
        r68 = null;
    L212:
        r53 = (Float) r68;
        goto L229
    L214:
        if (Set.class.isAssignableFrom(Float.class) == false) goto L225;
        boolean r69 = r47 instanceof Set;
        Object r71 = r47;
        if (r69 == true) goto L218;
        r71 = null;
    L218:
        Set<String> r72 = (Set) r71;
        if (r72 != null) goto L221;
        r72 = new HashSet();
    L221:
        Object r73 = r1.getStringSet("ttlive_open_platform_honor_prev_message", r72);
        if ((r73 instanceof Float) == true) goto L224;
        r73 = null;
    L224:
        r53 = (Float) r73;
        goto L229
    L225:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(Float.class));
        if (v.a() == true) goto L233;
        r53 = Float.class.newInstance();
        goto L229
    L233:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(Float.class) + '}');
    L234:
        KClass r74 = Reflection.getOrCreateKotlinClass(Long.class);
        Class r75 = Long.TYPE;
        if (Intrinsics.areEqual(r74, Reflection.getOrCreateKotlinClass(r75)) == false) goto L313;
        Long r76 = 0L;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L250;
        boolean r77 = r76 instanceof String;
        Object r78 = r76;
        if (r77 == true) goto L241;
        r78 = null;
    L241:
        String r79 = (String) r78;
        String r118 = "";
        if (r79 == null) goto L245;
        r118 = r79;
    L245:
        Object r81 = r1.getString("ttlive_open_platform_honor_prev_message", r118);
        if ((r81 instanceof Long) == true) goto L248;
        r81 = null;
    L248:
        Object r82 = (Long) r81;
    L308:
        if ((r82 instanceof Long) == true) goto L310;
        r82 = null;
    L310:
        r21 = (Long) r82;
        goto L551
    L250:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(r116)) == false) goto L262;
        boolean r83 = r76 instanceof Boolean;
        Object r84 = r76;
        if (r83 == true) goto L254;
        r84 = null;
    L254:
        Boolean r85 = (Boolean) r84;
        if (r85 == null) goto L257;
        r19 = r85.booleanValue();
    L257:
        Object r86 = Boolean.valueOf(r1.getBoolean("ttlive_open_platform_honor_prev_message", r19));
        if ((r86 instanceof Long) == true) goto L260;
        r86 = null;
    L260:
        r82 = (Long) r86;
        goto L308
    L262:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(r46)) == false) goto L275;
        boolean r87 = r76 instanceof Float;
        Object r88 = r76;
        if (r87 == true) goto L266;
        r88 = null;
    L266:
        Float r89 = (Float) r88;
        if (r89 == null) goto L269;
        float r91 = r89.floatValue();
    L270:
        Object r92 = Float.valueOf(r1.getFloat("ttlive_open_platform_honor_prev_message", r91));
        if ((r92 instanceof Long) == true) goto L273;
        r92 = null;
    L273:
        r82 = (Long) r92;
        goto L308
    L269:
        r91 = 0.0f;
        goto L270
    L275:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(r75)) == false) goto L281;
        if (r76 == null) goto L278;
        long r93 = r76.longValue();
    L279:
        r82 = Long.valueOf(r1.getLong("ttlive_open_platform_honor_prev_message", r93));
        goto L308
    L278:
        r93 = 0;
        goto L279
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L293;
        boolean r94 = r76 instanceof Integer;
        Object r95 = r76;
        if (r94 == true) goto L285;
        r95 = null;
    L285:
        Integer r96 = (Integer) r95;
        if (r96 == null) goto L288;
        r110 = r96.intValue();
    L288:
        Object r97 = Integer.valueOf(r1.getInt("ttlive_open_platform_honor_prev_message", r110));
        if ((r97 instanceof Long) == true) goto L291;
        r97 = null;
    L291:
        r82 = (Long) r97;
        goto L308
    L293:
        if (Set.class.isAssignableFrom(Long.class) == false) goto L304;
        boolean r98 = r76 instanceof Set;
        Object r99 = r76;
        if (r98 == true) goto L297;
        r99 = null;
    L297:
        Set<String> r100 = (Set) r99;
        if (r100 != null) goto L300;
        r100 = new HashSet();
    L300:
        Object r101 = r1.getStringSet("ttlive_open_platform_honor_prev_message", r100);
        if ((r101 instanceof Long) == true) goto L303;
        r101 = null;
    L303:
        r82 = (Long) r101;
        goto L308
    L304:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(Long.class));
        if (v.a() == true) goto L312;
        r82 = Long.class.newInstance();
        goto L308
    L312:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(Long.class) + '}');
    L313:
        KClass r102 = Reflection.getOrCreateKotlinClass(Long.class);
        Class r103 = Integer.TYPE;
        if (Intrinsics.areEqual(r102, Reflection.getOrCreateKotlinClass(r103)) == false) goto L392;
        Integer r104 = 0;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L329;
        boolean r105 = r104 instanceof String;
        Object r106 = r104;
        if (r105 == true) goto L320;
        r106 = null;
    L320:
        String r107 = (String) r106;
        String r119 = "";
        if (r107 == null) goto L324;
        r119 = r107;
    L324:
        Object r108 = r1.getString("ttlive_open_platform_honor_prev_message", r119);
        if ((r108 instanceof Integer) == true) goto L327;
        r108 = null;
    L327:
        Object r109 = (Integer) r108;
    L387:
        if ((r109 instanceof Long) == false) goto L549;
    L550:
        r21 = (Long) r109;
    L549:
        r109 = null;
        goto L550
    L329:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(r116)) == false) goto L341;
        boolean r120 = r104 instanceof Boolean;
        Object r121 = r104;
        if (r120 == true) goto L333;
        r121 = null;
    L333:
        Boolean r122 = (Boolean) r121;
        if (r122 == null) goto L336;
        r111 = r122.booleanValue();
    L336:
        Object r123 = Boolean.valueOf(r1.getBoolean("ttlive_open_platform_honor_prev_message", r111));
        if ((r123 instanceof Integer) == true) goto L339;
        r123 = null;
    L339:
        r109 = (Integer) r123;
        goto L387
    L341:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(r46)) == false) goto L354;
        boolean r124 = r104 instanceof Float;
        Object r125 = r104;
        if (r124 == true) goto L345;
        r125 = null;
    L345:
        Float r126 = (Float) r125;
        if (r126 == null) goto L348;
        float r127 = r126.floatValue();
    L349:
        Object r128 = Float.valueOf(r1.getFloat("ttlive_open_platform_honor_prev_message", r127));
        if ((r128 instanceof Integer) == true) goto L352;
        r128 = null;
    L352:
        r109 = (Integer) r128;
        goto L387
    L348:
        r127 = 0.0f;
        goto L349
    L354:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(r75)) == false) goto L367;
        boolean r129 = r104 instanceof Long;
        Object r130 = r104;
        if (r129 == true) goto L358;
        r130 = null;
    L358:
        Long r131 = (Long) r130;
        if (r131 == null) goto L361;
        long r132 = r131.longValue();
    L362:
        Object r133 = Long.valueOf(r1.getLong("ttlive_open_platform_honor_prev_message", r132));
        if ((r133 instanceof Integer) == true) goto L365;
        r133 = null;
    L365:
        r109 = (Integer) r133;
        goto L387
    L361:
        r132 = 0;
        goto L362
    L367:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(r103)) == false) goto L372;
        if (r104 == null) goto L370;
        r112 = r104.intValue();
    L370:
        r109 = Integer.valueOf(r1.getInt("ttlive_open_platform_honor_prev_message", r112));
        goto L387
    L372:
        if (Set.class.isAssignableFrom(Integer.class) == false) goto L383;
        boolean r134 = r104 instanceof Set;
        Object r135 = r104;
        if (r134 == true) goto L376;
        r135 = null;
    L376:
        Set<String> r136 = (Set) r135;
        if (r136 != null) goto L379;
        r136 = new HashSet();
    L379:
        Object r137 = r1.getStringSet("ttlive_open_platform_honor_prev_message", r136);
        if ((r137 instanceof Integer) == true) goto L382;
        r137 = null;
    L382:
        r109 = (Integer) r137;
        goto L387
    L383:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(Integer.class));
        if (v.a() == true) goto L390;
        r109 = Integer.class.newInstance();
        goto L387
    L390:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(Integer.class) + '}');
    L392:
        if (Set.class.isAssignableFrom(Long.class) == false) goto L469;
        HashSet r138 = new HashSet();
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Set.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L407;
        boolean r139 = r138 instanceof String;
        Object r140 = r138;
        if (r139 == true) goto L398;
        r140 = null;
    L398:
        String r141 = (String) r140;
        String r142 = "";
        if (r141 == null) goto L402;
        r142 = r141;
    L402:
        Object r143 = r1.getString("ttlive_open_platform_honor_prev_message", r142);
        if ((r143 instanceof Set) == true) goto L405;
        r143 = null;
    L405:
        r109 = (Set) r143;
    L465:
        if ((r109 instanceof Long) == true) goto L550;
    L407:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Set.class), Reflection.getOrCreateKotlinClass(r116)) == false) goto L419;
        boolean r144 = r138 instanceof Boolean;
        Object r145 = r138;
        if (r144 == true) goto L411;
        r145 = null;
    L411:
        Boolean r146 = (Boolean) r145;
        if (r146 == null) goto L414;
        r113 = r146.booleanValue();
    L414:
        Object r147 = Boolean.valueOf(r1.getBoolean("ttlive_open_platform_honor_prev_message", r113));
        if ((r147 instanceof Set) == true) goto L417;
        r147 = null;
    L417:
        r109 = (Set) r147;
        goto L465
    L419:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Set.class), Reflection.getOrCreateKotlinClass(r46)) == false) goto L432;
        boolean r148 = r138 instanceof Float;
        Object r149 = r138;
        if (r148 == true) goto L423;
        r149 = null;
    L423:
        Float r150 = (Float) r149;
        if (r150 == null) goto L426;
        float r151 = r150.floatValue();
    L427:
        Object r152 = Float.valueOf(r1.getFloat("ttlive_open_platform_honor_prev_message", r151));
        if ((r152 instanceof Set) == true) goto L430;
        r152 = null;
    L430:
        r109 = (Set) r152;
        goto L465
    L426:
        r151 = 0.0f;
        goto L427
    L432:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Set.class), Reflection.getOrCreateKotlinClass(r75)) == false) goto L445;
        boolean r153 = r138 instanceof Long;
        Object r154 = r138;
        if (r153 == true) goto L436;
        r154 = null;
    L436:
        Long r155 = (Long) r154;
        if (r155 == null) goto L439;
        long r156 = r155.longValue();
    L440:
        Object r157 = Long.valueOf(r1.getLong("ttlive_open_platform_honor_prev_message", r156));
        if ((r157 instanceof Set) == true) goto L443;
        r157 = null;
    L443:
        r109 = (Set) r157;
        goto L465
    L439:
        r156 = 0;
        goto L440
    L445:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Set.class), Reflection.getOrCreateKotlinClass(r103)) == false) goto L457;
        boolean r158 = r138 instanceof Integer;
        Object r159 = r138;
        if (r158 == true) goto L449;
        r159 = null;
    L449:
        Integer r160 = (Integer) r159;
        if (r160 == null) goto L452;
        r114 = r160.intValue();
    L452:
        Object r161 = Integer.valueOf(r1.getInt("ttlive_open_platform_honor_prev_message", r114));
        if ((r161 instanceof Set) == true) goto L455;
        r161 = null;
    L455:
        r109 = (Set) r161;
        goto L465
    L457:
        if (Set.class.isAssignableFrom(Set.class) == false) goto L461;
        r109 = r1.getStringSet("ttlive_open_platform_honor_prev_message", r138);
        if ((r109 instanceof Set) == true) goto L465;
        r109 = null;
        goto L465
    L461:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(Set.class));
        if (v.a() == true) goto L468;
        r109 = Set.class.newInstance();
        goto L465
    L468:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(Set.class) + '}');
    L469:
        Unit r162 = Unit.INSTANCE;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L483;
        if ((r162 instanceof String) == true) goto L474;
        r162 = null;
    L474:
        String r163 = (String) r162;
        String r164 = "";
        if (r163 == null) goto L478;
        r164 = r163;
    L478:
        String r165 = r1.getString("ttlive_open_platform_honor_prev_message", r164);
        if ((r165 instanceof Unit) == true) goto L481;
        r165 = null;
    L481:
        r109 = (Unit) r165;
    L548:
        if ((r109 instanceof Long) == true) goto L550;
    L483:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(r116)) == false) goto L495;
        if ((r162 instanceof Boolean) == true) goto L487;
        r162 = null;
    L487:
        Boolean r166 = (Boolean) r162;
        if (r166 == null) goto L490;
        r115 = r166.booleanValue();
    L490:
        Boolean r167 = Boolean.valueOf(r1.getBoolean("ttlive_open_platform_honor_prev_message", r115));
        if ((r167 instanceof Unit) == true) goto L493;
        r167 = null;
    L493:
        r109 = (Unit) r167;
        goto L548
    L495:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(r46)) == false) goto L508;
        if ((r162 instanceof Float) == true) goto L499;
        r162 = null;
    L499:
        Float r168 = (Float) r162;
        if (r168 == null) goto L502;
        float r169 = r168.floatValue();
    L503:
        Float r170 = Float.valueOf(r1.getFloat("ttlive_open_platform_honor_prev_message", r169));
        if ((r170 instanceof Unit) == true) goto L506;
        r170 = null;
    L506:
        r109 = (Unit) r170;
        goto L548
    L502:
        r169 = 0.0f;
        goto L503
    L508:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(r75)) == false) goto L521;
        if ((r162 instanceof Long) == true) goto L512;
        r162 = null;
    L512:
        Long r171 = (Long) r162;
        if (r171 == null) goto L515;
        long r172 = r171.longValue();
    L516:
        Long r173 = Long.valueOf(r1.getLong("ttlive_open_platform_honor_prev_message", r172));
        if ((r173 instanceof Unit) == true) goto L519;
        r173 = null;
    L519:
        r109 = (Unit) r173;
        goto L548
    L515:
        r172 = 0;
        goto L516
    L521:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(r103)) == false) goto L533;
        if ((r162 instanceof Integer) == true) goto L525;
        r162 = null;
    L525:
        Integer r174 = (Integer) r162;
        if (r174 == null) goto L528;
        r12 = r174.intValue();
    L528:
        Integer r175 = Integer.valueOf(r1.getInt("ttlive_open_platform_honor_prev_message", r12));
        if ((r175 instanceof Unit) == true) goto L531;
        r175 = null;
    L531:
        r109 = (Unit) r175;
        goto L548
    L533:
        if (Set.class.isAssignableFrom(Unit.class) == true) goto L535;
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(Unit.class));
        if (v.a() == true) goto L567;
        r109 = Unit.class.newInstance();
        goto L548
    L567:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(Unit.class) + '}');
    L535:
        if ((r162 instanceof Set) == true) goto L537;
        r162 = null;
    L537:
        Set<String> r176 = (Set) r162;
        if (r176 != null) goto L540;
        r176 = new HashSet();
    L540:
        Set<String> r177 = r1.getStringSet("ttlive_open_platform_honor_prev_message", r176);
        if ((r177 instanceof Unit) == true) goto L543;
        r177 = null;
    L543:
        r109 = (Unit) r177;
        goto L548
    L5:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L10;
        Object r178 = r1.getString("ttlive_open_platform_honor_prev_message", "");
        if ((r178 instanceof String) == true) goto L74;
        r178 = null;
    L74:
        if ((r178 instanceof Long) == true) goto L76;
        r178 = null;
    L76:
        r21 = (Long) r178;
        goto L551
    L10:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L22;
        Object r179 = "";
        if (("" instanceof Boolean) == true) goto L14;
        r179 = null;
    L14:
        Boolean r180 = (Boolean) r179;
        if (r180 == null) goto L17;
        r13 = r180.booleanValue();
    L17:
        Object r181 = Boolean.valueOf(r1.getBoolean("ttlive_open_platform_honor_prev_message", r13));
        if ((r181 instanceof String) == true) goto L20;
        r181 = null;
    L20:
        r178 = (String) r181;
        goto L74
    L22:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L34;
        Object r182 = "";
        if (("" instanceof Float) == true) goto L26;
        r182 = null;
    L26:
        Float r183 = (Float) r182;
        if (r183 == null) goto L29;
        r5 = r183.floatValue();
    L29:
        Object r184 = Float.valueOf(r1.getFloat("ttlive_open_platform_honor_prev_message", r5));
        if ((r184 instanceof String) == true) goto L32;
        r184 = null;
    L32:
        r178 = (String) r184;
        goto L74
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L47;
        Object r185 = "";
        if (("" instanceof Long) == true) goto L38;
        r185 = null;
    L38:
        Long r186 = (Long) r185;
        if (r186 == null) goto L41;
        long r187 = r186.longValue();
    L42:
        Object r188 = Long.valueOf(r1.getLong("ttlive_open_platform_honor_prev_message", r187));
        if ((r188 instanceof String) == true) goto L45;
        r188 = null;
    L45:
        r178 = (String) r188;
        goto L74
    L41:
        r187 = 0;
        goto L42
    L47:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L59;
        Object r189 = "";
        if (("" instanceof Integer) == true) goto L51;
        r189 = null;
    L51:
        Integer r190 = (Integer) r189;
        if (r190 == null) goto L54;
        r14 = r190.intValue();
    L54:
        Object r191 = Integer.valueOf(r1.getInt("ttlive_open_platform_honor_prev_message", r14));
        if ((r191 instanceof String) == true) goto L57;
        r191 = null;
    L57:
        r178 = (String) r191;
        goto L74
    L59:
        if (Set.class.isAssignableFrom(String.class) == false) goto L70;
        Set<String> r192 = "";
        if (("" instanceof Set) == true) goto L63;
        r192 = null;
    L63:
        Set<String> r193 = r192;
        if (r193 != null) goto L66;
        r193 = new HashSet();
    L66:
        Object r194 = r1.getStringSet("ttlive_open_platform_honor_prev_message", r193);
        if ((r194 instanceof String) == true) goto L69;
        r194 = null;
    L69:
        r178 = (String) r194;
        goto L74
    L70:
        ALogger.e("Sp", "return type no support " + Reflection.getOrCreateKotlinClass(String.class));
        if (v.a() == true) goto L78;
        r178 = String.class.newInstance();
        goto L74
    L78:
        throw new Exception("get ttlive_open_platform_honor_prev_message sp is  no support " + Reflection.getOrCreateKotlinClass(String.class) + '}');
    }

    public final void onMessage(tlc.d r7) {
        StringBuilder r0 = new StringBuilder("receive message, message id: ");
        if (r7 == null) goto L5;
        Long r1 = Long.valueOf(r7.getMessageId());
    L6:
        r0.append(r1);
        r0.append(", water level: ");
        r0.append(this.f);
        ALogger.i("GameHonorEffectWidget", r0.toString());
        if (r7 != null) goto L9;
        return;
    L9:
        if (this.f != r7.getMessageId()) goto L12;
        return;
    L12:
        if ((r7 instanceof ka) == false) goto L21;
        Iterator r2 = ((ka) r7).getHonorInfos().iterator();
    L15:
        if (r2.hasNext() == false) goto L17;
        ja r3 = (ja) r2.next();
        this.b.offer(new c(r3, r7.getMessageId()));
        goto L15
    L17:
        xq();
        return;
    L21:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
