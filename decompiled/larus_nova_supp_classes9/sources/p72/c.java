package p72;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.emoji.FusionEmojiApi;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u22.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements com.bytedance.android.livesdk.interactivity.api.emoji.e {
    public final String a;
    public final int b;
    public com.bytedance.android.livesdk.interactivity.api.emoji.a c;
    public Disposable d;
    public final List<com.bytedance.android.livesdk.interactivity.api.emoji.a> e;
    public final b f;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r3, Object r4) {
            return (int) (((com.bytedance.android.livesdk.interactivity.api.emoji.a) r4).a - ((com.bytedance.android.livesdk.interactivity.api.emoji.a) r3).a);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.e
    public final void c() {
        Collections.sort(this.e, this.f);
        List r1 = CollectionsKt.toList(CollectionsKt.take(this.e, this.b));     // Catch: Exception -> L5
        f.d(new com.bytedance.android.livesdk.sharedpref.e(this.a, BuildConfig.FLAVOR), GsonHelper.get().toJson(r1));     // Catch: Exception -> L5
    L7:
        Disposable r2 = this.d;
        if (r2 == null) goto L10;
        r2.dispose();
    L10:
        this.d = null;
        return;
    L5:
        e = move-exception;
        SafetyGuard.a(null, e, "FusionEmoji,fun saveFusionEmojiAndQuit occurs error");
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.e
    public final com.bytedance.android.livesdk.interactivity.api.emoji.a d() {
        com.bytedance.android.livesdk.interactivity.api.emoji.a r0 = this.c;
        this.c = null;
        return r0;
    }

    public final void g() {
    L12:
        e = move-exception;
        SafetyGuard.a(null, e, "FusionEmoji,fun getEmojiFromFile occurs error");
        return;
    L3:
        if (((ArrayList) this.e).isEmpty() == false) goto L18;
        List r0 = (List) GsonHelper.get().fromJson((String) new com.bytedance.android.livesdk.sharedpref.e(this.a, BuildConfig.FLAVOR).getValue(), List.class);     // Catch: Exception -> L12
        if (r0 == null) goto L19;
        Iterator r1 = r0.iterator();     // Catch: Exception -> L12
    L8:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();     // Catch: Exception -> L12
        com.bytedance.android.livesdk.interactivity.api.emoji.a r3 = (com.bytedance.android.livesdk.interactivity.api.emoji.a) GsonHelper.get().fromJson(GsonHelper.get().toJson(r2), com.bytedance.android.livesdk.interactivity.api.emoji.a.class);     // Catch: Exception -> L12
        ((ArrayList) this.e).add(r3);     // Catch: Exception -> L12
        goto L8
    L10:
        Collections.sort(this.e, this.f);     // Catch: Exception -> L12
        return;
    L19:
        return;
    }

    public c() {
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L8;
        String r2 = r1.n();
        if (r2 == null) goto L8;
    L9:
        this.a = r2.concat("_fusion_emoji_list");
        this.b = 14;
        this.e = new ArrayList();
        this.f = b.a;
        g();
        return;
    L8:
        r2 = "null";
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.e
    public final List<com.bytedance.android.livesdk.interactivity.api.emoji.a> f() {
        g();
        return CollectionsKt.take(this.e, this.b);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.e
    public final void b(List<Long> r7) {
        List<Long> r1 = r7;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        ArrayList r3 = new ArrayList();
        List r4 = (List) GsonHelper.get().fromJson((String) new com.bytedance.android.livesdk.sharedpref.e(this.a, BuildConfig.FLAVOR).getValue(), List.class);     // Catch: Exception -> L27
        if (r4 == null) goto L38;
        Iterator r5 = r4.iterator();     // Catch: Exception -> L27
    L16:
        if (r5.hasNext() == false) goto L25;
        Object r6 = r5.next();     // Catch: Exception -> L27
        com.bytedance.android.livesdk.interactivity.api.emoji.a r8 = (com.bytedance.android.livesdk.interactivity.api.emoji.a) GsonHelper.get().fromJson(GsonHelper.get().toJson(r6), com.bytedance.android.livesdk.interactivity.api.emoji.a.class);     // Catch: Exception -> L27
        Long r9 = r8.b();     // Catch: Exception -> L27
        if (r9 == null) goto L20;
        long r10 = r9.longValue();     // Catch: Exception -> L27
    L22:
        if (r7.contains(Long.valueOf(r10)) == true) goto L16;
        r3.add(r8);     // Catch: Exception -> L27
        goto L16
    L20:
        r10 = 0;
        goto L22
    L25:
        f.d(new com.bytedance.android.livesdk.sharedpref.e(this.a, BuildConfig.FLAVOR), GsonHelper.get().toJson(r3));     // Catch: Exception -> L27
        return;
    L38:
        return;
    L27:
        e = move-exception;
        SafetyGuard.a(null, e, "FusionEmoji,fun deleteBanList occurs error");
        return;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.e
    public final void a(long r6, com.bytedance.android.livesdk.interactivity.api.emoji.a r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "emoji");
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        Object r1 = r0.next();
        Long r2 = ((com.bytedance.android.livesdk.interactivity.api.emoji.a) r1).b();
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L4;
    L15:
        com.bytedance.android.livesdk.interactivity.api.emoji.a r4 = (com.bytedance.android.livesdk.interactivity.api.emoji.a) r1;
        if (r4 == null) goto L18;
        r4.a = r9;
        return;
    L18:
        List<com.bytedance.android.livesdk.interactivity.api.emoji.a> r7 = this.e;
        r8.a = r9;
        Unit r10 = Unit.INSTANCE;
        ((ArrayList) r7).add(r8);
        return;
    L9:
        if (r2.longValue() != r6) goto L11;
        r3 = true;
        goto L12
    L14:
        r1 = null;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.e
    public final void e(long r5, String r7, String r8) {
        String r0 = null;
        if (r7 != null) goto L26;
    L8:
        com.bytedance.android.livesdk.interactivity.api.emoji.a r9 = null;
    L9:
        if (r9 == null) goto L14;
        this.c = r9;
        xs2.b r6 = xs2.b.a();
        m r10 = new m();
        r10.l = OpenInputSource.InputFusionEmojiEvent;
        if (r8 == null) goto L13;
        r10.f = r8;
    L13:
        Unit r11 = Unit.INSTANCE;
        r6.post(r10);
        return;
    L14:
        IRoomContextService r13 = k.f(IRoomContextService.class);
        if (r13 == null) goto L23;
        o r14 = IRoomContextService.a.a(r13, null, 0, 3);
        if (r14 == null) goto L23;
        com.bytedance.live.datacontext.m r15 = r14.getRoom();
        if (r15 == null) goto L23;
        IRoom r16 = (IRoom) r15.getValue();
        if (r16 == null) goto L23;
        r0 = String.valueOf(r16.getRoomId());
    L23:
        if (r0 == null) goto L29;
        this.d = ((FusionEmojiApi) com.bytedance.android.live.network.c.b().e(FusionEmojiApi.class)).getFusionEmojiInfo(MapsKt.mapOf(new Pair[]{TuplesKt.to("room_id", r0), TuplesKt.to("emoji_id", String.valueOf(r5))})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r8), new e(r5, r0));
        return;
    L29:
        return;
    L26:
        r9 = (com.bytedance.android.livesdk.interactivity.api.emoji.a) GsonHelper.get().fromJson(r7, com.bytedance.android.livesdk.interactivity.api.emoji.a.class);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        SafetyGuard.a(null, e, "FusionEmoji,fun inputFusionEmoji occurs error");
        goto L8
    }
}
