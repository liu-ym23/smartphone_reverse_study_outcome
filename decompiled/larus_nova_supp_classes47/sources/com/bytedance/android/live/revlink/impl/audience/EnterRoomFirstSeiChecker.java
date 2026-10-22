package com.bytedance.android.live.revlink.impl.audience;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import or2.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class EnterRoomFirstSeiChecker {
    public a a;
    public Disposable b;
    public Disposable c;
    public final ld.a d;
    public final com.bytedance.android.live.revlink.impl.global.c e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/audience/EnterRoomFirstSeiChecker$MismatchError;", "", "", "scene", "I", "getScene", "()I", Constants.OperatorKey.CODE, "getCode", "", Constants.OperatorKey.MSG, "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "SeiPkButRoomMulti", "SeiPkButRoomEmpty", "SeiMultiButRoomPk", "SeiMultiButRoomEmpty", "SeiEmptyButRoomPk", "SeiEmptyButRoomMulti", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum MismatchError extends Enum<MismatchError> {
        public static final MismatchError SeiEmptyButRoomMulti = null;
        public static final MismatchError SeiEmptyButRoomPk = null;
        public static final MismatchError SeiMultiButRoomEmpty = null;
        public static final MismatchError SeiMultiButRoomPk = null;
        public static final MismatchError SeiPkButRoomEmpty = null;
        public static final MismatchError SeiPkButRoomMulti = null;
        public static final /* synthetic */ MismatchError[] a = null;
        private final int code;
        private final String msg;
        private final int scene;

        static {
            MismatchError r7 = new MismatchError("SeiPkButRoomMulti", 0, 1, 1007, "sei=pk,room=multi");
            SeiPkButRoomMulti = r7;
            MismatchError r1 = new MismatchError("SeiPkButRoomEmpty", 1, 1, WebcastRedirectException.UNKNOWN, "sei=pk,room=empty");
            SeiPkButRoomEmpty = r1;
            MismatchError r2 = new MismatchError("SeiMultiButRoomPk", 2, 7, 7001, "sei=multi,room=pk");
            SeiMultiButRoomPk = r2;
            MismatchError r3 = new MismatchError("SeiMultiButRoomEmpty", 3, 7, 7000, "sei=multi,room=empty");
            SeiMultiButRoomEmpty = r3;
            MismatchError r4 = new MismatchError("SeiEmptyButRoomPk", 4, 1, 10001, "sei=empty,room=pk");
            SeiEmptyButRoomPk = r4;
            MismatchError r5 = new MismatchError("SeiEmptyButRoomMulti", 5, 7, 10007, "sei=empty,room=multi");
            SeiEmptyButRoomMulti = r5;
            a = new MismatchError[]{r7, r1, r2, r3, r4, r5};
        }

        public static MismatchError valueOf(String r1) {
            return (MismatchError) r27.a.a(MismatchError.class, r1);
        }

        public static MismatchError[] values() {
            return (MismatchError[]) a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final int getScene() {
            return this.scene;
        }

        public MismatchError(String r1, int r2, int r3, int r4, String r5) {
            super(r1, r2);
            this.scene = r3;
            this.code = r4;
            this.msg = r5;
        }
    }

    public static final class a {
        public final MismatchError a;
        public final String b;
        public final boolean c;
        public final boolean d;
        public final boolean e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L16;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public final int hashCode() {
            MismatchError r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            r1 = r4.hashCode();
        L9:
            int r5 = (r3 + r1) * 31;
            boolean r6 = this.c;
            ?? r7 = 1;
            ?? r8 = r6;
            if (r6 == false) goto L12;
            r8 = 1;
        L12:
            int r9 = (r5 + r8) * 31;
            boolean r10 = this.d;
            ?? r12 = r10;
            if (r10 == false) goto L15;
            r12 = 1;
        L15:
            int r13 = (r9 + r12) * 31;
            boolean r14 = this.e;
            if (r14 == true) goto L20;
            r7 = r14;
        L20:
            return r13 + r7;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ErrorInfo(error=" + this.a + ", firstSei=" + this.b + ", isFallbackSei=" + this.c + ", playerFirstFrame=" + this.d + ", playerIsPlaying=" + this.e + ")";
        }

        public a(MismatchError r2, String r3, boolean r4, boolean r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r3, "firstSei");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class b {
        public final String a;
        public final boolean b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            String r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = r1 * 31;
            boolean r3 = this.b;
            ?? r4 = r3;
            if (r3 == false) goto L10;
            r4 = 1;
        L10:
            return r2 + r4;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "FirstSEI(rawSei=" + this.a + ", isFallback=" + this.b + ")";
        }

        public b(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "rawSei");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ EnterRoomFirstSeiChecker a;

        public c(EnterRoomFirstSeiChecker r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            EnterRoomFirstSeiChecker r4 = this.a;
            a r0 = r4.a;
            if (r0 == null) goto L5;
            EnterRoomFirstSeiChecker.a(r4, r0);
        L5:
            this.a.a = null;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ EnterRoomFirstSeiChecker a;
        public final /* synthetic */ com.bytedance.android.live.revlink.impl.control.c b;

        public d(EnterRoomFirstSeiChecker r1, com.bytedance.android.live.revlink.impl.control.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            Long r10 = (Long) r9;
            b r12 = this.a.d();
            if (r12.a.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L8;
            jy0.b.d("ttlive_revlink_sei", "sei ready after delay");
            return;
        L8:
            com.bytedance.android.live.revlink.impl.control.c r1 = this.b;
            if (r1.c == null) goto L12;
            MismatchError r3 = MismatchError.SeiEmptyButRoomPk;
            String r4 = r12.a;
            boolean r5 = r12.b;
            this.a.getClass();
            boolean r6 = EnterRoomFirstSeiChecker.e().getHasFirstFrame();
            this.a.getClass();
            a r2 = new a(r3, r4, r5, r6, EnterRoomFirstSeiChecker.e().isPlaying());
        L15:
            if (r2 == null) goto L19;
            EnterRoomFirstSeiChecker.a(this.a, r2);
            return;
        L19:
            return;
        L12:
            if (r1.d == null) goto L14;
            MismatchError r7 = MismatchError.SeiEmptyButRoomMulti;
            String r8 = r12.a;
            boolean r13 = r12.b;
            this.a.getClass();
            boolean r14 = EnterRoomFirstSeiChecker.e().getHasFirstFrame();
            this.a.getClass();
            r2 = new a(r7, r8, r13, r14, EnterRoomFirstSeiChecker.e().isPlaying());
            goto L15
        L14:
            r2 = null;
            goto L15
        L5:
            r0 = false;
            goto L6
        }
    }

    public static or2.d e() {
        cy0.e.a.getClass();
        j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r0 = m.b(r1).b(or2.d.class);
        Intrinsics.checkNotNull(r0);
        return (com.bytedance.live.kmp.core.c) r0;
    }

    public final b d() {
        ld.a r0 = this.d;
        String r1 = "";
        if (r0 == null) goto L8;
        NextLiveData r2 = r0.h4();
        if (r2 == null) goto L8;
        String r3 = (String) r2.getValue();
        if (r3 == null) goto L8;
    L10:
        if (StringsKt.contains$default(r3, "app_data", false, 2, null) == true) goto L12;
        com.bytedance.android.live.revlink.impl.settings.live.c r6 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r6.getClass();
        long r7 = ((Number) com.bytedance.android.live.revlink.impl.settings.live.c.r.getValue(r6, com.bytedance.android.live.revlink.impl.settings.live.c.a[16])).longValue();
        k r8 = e().v5();
        if (r8 == null) goto L34;
        String r9 = r8.b;
        if (r9 == null) goto L34;
        if (StringsKt.contains$default(r9, "app_data", false, 2, null) != true) goto L34;
        i97.a r4 = i97.a.a;
        long r10 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r8, "$this$tsLong");
        String r5 = r8.a;
        if (r5 == null) goto L24;
        Long r12 = StringsKt.toLongOrNull(r5);
        if (r12 == null) goto L24;
        long r13 = r12.longValue();
    L26:
        if ((r10 - r13) >= r7) goto L34;
        jy0.b.d("ttlive_revlink_sei", "use player sei, inner=" + r3 + " player=" + r8.b);
        String r14 = r8.b;
        if (r14 == null) goto L32;
        r1 = r14;
    L32:
        return new b(r1, true);
    L24:
        r13 = 0;
    L34:
        return new b(r3, false);
    L12:
        return new b(r3, false);
    L8:
        r3 = "";
        goto L10
    }

    public final void c(com.bytedance.android.live.revlink.impl.control.c r5) {
        jy0.b.d("ttlive_revlink_sei", "start empty sei delay check");
        l r0 = l.a;
        long r1 = WebcastRedirectException.UNKNOWN;
        int r2 = p.a;
        this.c = Observable.timer(r1, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r5));
    }

    public EnterRoomFirstSeiChecker(ld.a r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        this.d = r1;
        this.e = r2;
    }

    public static final void a(EnterRoomFirstSeiChecker r13, a r14) {
        r13.getClass();
        JSONObject r0 = new JSONObject();
        if (r14.c == false) goto L6;
        r0.put("is_fallback_sei", true);
    L6:
        if (r14.d == true) goto L9;
        r0.put("player_first_frame", false);
    L9:
        if (r14.e == true) goto L11;
        r0.put("player_is_playing", false);
    L11:
        MismatchError r1 = r14.a;
        com.bytedance.android.live.revlink.impl.global.c r15 = r13.e;
        d31.f r2 = null;
        if (r15 == null) goto L14;
        g r16 = r15.Ee();
    L15:
        if (r16 == null) goto L30;
        int r10 = r1.getScene();
        int r12 = r1.getCode();
        String r3 = r1.getMsg();
        String r17 = r14.b;
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.ERROR);
        Intrinsics.checkNotNullParameter(r17, "firstSei");
        Intrinsics.checkNotNullParameter(r0, "extraParams");
        JSONObject r5 = new JSONObject();
        int r4 = y50.b.a;
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter("extras", "key");
        r5.put("extras", r0);     // Catch: Throwable -> L19
    L21:
        y50.b.a.d(r5, "first_sei", r17);
        g.m(r16, "enter_room_link_info_mismatch_sei", r5, r10, r12, r3, 32);
        com.bytedance.android.live.revlink.impl.global.c r18 = r16.d;
        if (r18 == null) goto L24;
        r2 = r18.y2();
    L24:
        d31.f r6 = r2;
        if (r6 == null) goto L31;
        d31.f.f(r6, "enter_room_link_info_mismatch_sei", r12, r3, r10, 0, null, null, null, 240);
        return;
    L31:
        return;
    L19:
        th = move-exception;
        jy0.b.b("BaseMonitor", "", th);
        goto L21
    L30:
        return;
    L14:
        r16 = null;
        goto L15
    }

    public final void b(MismatchError r9, b r10) {
        jy0.b.d("ttlive_revlink_sei", "start delay check for " + r9);
        this.a = new a(r9, r10.a, r10.b, e().getHasFirstFrame(), e().isPlaying());
        l r12 = l.a;
        int r0 = p.a;
        this.b = Observable.timer(4000, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
    }
}
