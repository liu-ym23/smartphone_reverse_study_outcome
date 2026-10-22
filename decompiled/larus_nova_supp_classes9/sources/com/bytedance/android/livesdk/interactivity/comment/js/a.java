package com.bytedance.android.livesdk.interactivity.comment.js;

import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.android.livesdk.event.d0;
import com.bytedance.android.livesdk.event.y;
import com.bytedance.android.livesdk.event.z;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import n56.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements n56.c {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.js.a$a, reason: collision with other inner class name */
    public static final class C0115a {
    }

    public static final class b<T> implements Predicate {
        public final /* synthetic */ Object a;

        public b(Object r1) {
            this.a = r1;
        }

        public final boolean test(Object r2) {
            z r3 = (z) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3.a != this.a) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Object a;
        public final /* synthetic */ JSONObject b;

        public c(Object r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            if (((z) r3).b == false) goto L5;
            JSONObject r4 = this.b;
            int r0 = 1;
        L6:
            r4.put("code", r0);
            return;
        L5:
            r4 = this.b;
            r0 = 0;
            goto L6
        }
    }

    static {
    }

    public a() {
    }

    public void call(f r10, JSONObject r11) {
        if (r10 == null) goto L38;
        if (r11 == null) goto L39;
        JSONObject r13 = r10.d;
        if (r13 == null) goto L40;
        String r0 = r13.optString("sender");
        if (r0 != null) goto L11;
    L16:
        ISendCommentEvent.Sender r1 = ISendCommentEvent.Sender.Unknown;
    L17:
        ISendCommentEvent.Sender r3 = r1;
        final JSONObject r2 = r13.optJSONObject("args");
        if (r2 == null) goto L21;
        Map r4 = MapsKt.toMap(SequencesKt.map(SequencesKt.asSequence(r2.keys()), new CommentIJavaMethod$asMap$1(r2)));
        if (r4 == null) goto L21;
    L22:
        Map r5 = r4;
        String r6 = r13.optString("type");
        if (r6 == null) goto L37;
        int r7 = r6.hashCode();
        if (r7 == (-333150752)) goto L32;
        if (r7 != 3556653) goto L37;
        if (r6.equals("text") == false) goto L37;
        d0 r8 = new d0(r13.optString("content"), r3, r5, null, null, false, 56);
    L34:
        xs2.b r14 = xs2.b.a();
        r14.b(z.class).filter(new b(r8)).firstElement().subscribe(new c(r8, r11));
        r14.post(r8);
        return;
    L32:
        if (r6.equals("barrage") == false) goto L37;
        r8 = new y(r13.optString("content"), r3, r5);
    L37:
        throw new IllegalArgumentException("unsupported comment type");
    L21:
        r4 = MapsKt.emptyMap();
        goto L22
    L11:
        if (r0.hashCode() != 354670409) goto L16;
        if (r0.equals("lottery") == false) goto L16;
        r1 = ISendCommentEvent.Sender.Lottery;
        goto L17
    L40:
        return;
    L39:
        return;
    }
}
