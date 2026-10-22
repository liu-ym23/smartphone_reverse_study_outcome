package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "comment")
public final class f2 extends com.bytedance.ies.web.jsbridge2.f<a, Object> {
    public final CompositeDisposable a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/f2$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "content", "b", "requestSource", "c", "version", "f", "roomId", "d", "sender", "e", "Lorg/json/JSONObject;", "args", "Lorg/json/JSONObject;", "a", "()Lorg/json/JSONObject;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("args")
        private final JSONObject args;

        @SerializedName("content")
        private final String content;

        @SerializedName("request_source")
        private final String requestSource;

        @SerializedName("room_id")
        private final String roomId;

        @SerializedName("sender")
        private final String sender;

        @SerializedName("type")
        private final String type;

        @SerializedName("version")
        private final String version;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L20;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.content, r4.content) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.requestSource, r4.requestSource) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.version, r4.version) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.sender, r4.sender) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.args, r4.args) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            String r0 = this.type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.content;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.requestSource;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r11 = this.version;
            if (r11 == null) goto L17;
            int r12 = r11.hashCode();
        L18:
            int r13 = (r9 + r12) * 31;
            String r14 = this.roomId;
            if (r14 == null) goto L21;
            int r15 = r14.hashCode();
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.sender;
            if (r17 == null) goto L25;
            int r18 = r17.hashCode();
        L26:
            int r19 = (r16 + r18) * 31;
            JSONObject r21 = this.args;
            if (r21 == null) goto L30;
            r1 = r21.hashCode();
        L30:
            return r19 + r1;
        L25:
            r18 = 0;
            goto L26
        L21:
            r15 = 0;
            goto L22
        L17:
            r12 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(type=" + this.type + ", content=" + this.content + ", requestSource=" + this.requestSource + ", version=" + this.version + ", roomId=" + this.roomId + ", sender=" + this.sender + ", args=" + this.args + ")";
        }

        public final JSONObject a() {
            return this.args;
        }

        public final String b() {
            return this.content;
        }

        public final String c() {
            return this.requestSource;
        }

        public final String d() {
            return this.roomId;
        }

        public final String e() {
            return this.sender;
        }

        public final String f() {
            return this.version;
        }

        public final String getType() {
            return this.type;
        }
    }

    public final void onTerminate() {
        this.a.dispose();
    }

    public f2() {
        this.a = new CompositeDisposable();
    }

    public final void invoke(Object r11, CallContext r12) {
        a r13 = (a) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        com.bytedance.android.livesdk.interactivity.api.settings.config.n r14 = com.bytedance.android.livesdk.interactivity.api.monitor.b.a;
        com.bytedance.android.livesdk.interactivity.api.monitor.b.d(r13.c(), r13.b());
        String r15 = r13.e();
        if (r15 != null) goto L6;
    L11:
        ISendCommentEvent.Sender r16 = ISendCommentEvent.Sender.Unknown;
    L12:
        ISendCommentEvent.Sender r2 = r16;
        final JSONObject r17 = r13.a();
        if (r17 == null) goto L16;
        Map r18 = MapsKt.toMap(SequencesKt.map(SequencesKt.asSequence(r17.keys()), new CommentMethod$asMap$1(r17)));
        if (r18 == null) goto L16;
    L17:
        Map r3 = MapsKt.toMutableMap(r18);
        r3.put("request_source", r13.c());
        r3.put("comment_jsb_room_id", r13.d());
        r3.put("comment_jsb_version", r13.f());
        String r19 = r13.getType();
        int r0 = r19.hashCode();
        if (r0 == (-333150752)) goto L25;
        if (r0 != 3556653) goto L43;
        if (r19.equals("text") == false) goto L43;
        com.bytedance.android.livesdk.event.d0 r110 = new com.bytedance.android.livesdk.event.d0(r13.b(), r2, r3, null, null, true, 24);
    L28:
        if (((Boolean) com.bytedance.android.livesdk.s4.a.getValue()).booleanValue() == false) goto L40;
        LinkedHashMap r1 = new LinkedHashMap();
        String r4 = r13.e();
        String r5 = "";
        if (r4 != null) goto L32;
        r4 = "";
    L32:
        r1.put("sender", r4);
        r1.put("type", r13.getType());
        String r6 = r13.c();
        if (r6 != null) goto L35;
        r6 = "";
    L35:
        r1.put("request_source", r6);
        String r111 = r13.f();
        if (r111 == null) goto L39;
        r5 = r111;
    L39:
        r1.put("version", r5);
        r1.put("jsb_name", "comment");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_jsb_usage_stat", r1, new Object[0]);
    L40:
        xs2.b r112 = xs2.b.a();
        Disposable r7 = r112.b(com.bytedance.android.livesdk.event.z.class).filter(new g2(r110)).firstElement().subscribe(new h2(this, r110));
        this.a.add(r7);
        r112.post(r110);
        return;
    L43:
        throw new IllegalArgumentException("unsupported comment type");
    L25:
        if (r19.equals("barrage") == false) goto L43;
        r110 = new com.bytedance.android.livesdk.event.y(r13.b(), r2, r3);
    L16:
        r18 = MapsKt.emptyMap();
        goto L17
    L6:
        if (r15.hashCode() != 354670409) goto L11;
        if (r15.equals("lottery") == false) goto L11;
        r16 = ISendCommentEvent.Sender.Lottery;
        goto L12
    }
}
