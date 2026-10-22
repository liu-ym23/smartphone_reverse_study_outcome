package com.bytedance.android.live.browser.jsbridge.state.annieObservable;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.bl.LiveMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h extends com.bytedance.android.annie.api.data.subscribe.a<JsonObject> {
    public final ConcurrentHashMap<MessageType, Pair<Subject<JsonObject>, Function0<Unit>>> c;
    public final Gson d;
    public final DataCenter e;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r4) {
            JsonObject r5 = (JsonObject) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            int r0 = com.bytedance.android.live.browser.jsbridge.d.a;
            String r1 = com.bytedance.android.live.browser.jsbridge.d.b(r5.get("message_method").getAsString());
            JsonObject r2 = new JsonObject();
            com.bytedance.android.live.browser.jsbridge.d.c(r5, r1);
            r2.add("data_v2", GsonProtectorUtils.toJsonTree(GsonHelper.getLynxWorkaround(), r5));
            r2.addProperty("messageType", r1);
            return r2;
        }
    }

    public final /* bridge */ /* synthetic */ Object g() {
        return null;
    }

    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.e.f r0 = com.bytedance.android.live.browser.jsbridge.i.e.f.b;
        return "room_message";
    }

    public final void onRelease() {
        Iterator<T> r0 = this.c.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function0) ((Pair) r0.next()).getSecond()).invoke();
        goto L4
    }

    public final Observable<JsonObject> j(String r11) {
        Intrinsics.checkNotNullParameter(r11, "path");
        MessageType[] r0 = MessageType.values();
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L19;
        final MessageType r5 = r0[r3];
        if (Intrinsics.areEqual(r5.getWsMethod(), r11) == false) goto L8;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == true) goto L20;
        r3 = r3 + 1;
    L20:
        if (r5 != null) goto L22;
        return null;
    L22:
        Pair<Subject<JsonObject>, Function0<Unit>> r12 = this.c.get(r5);
        if (r12 == null) goto L25;
        Observable r13 = (Observable) r12.getFirst();
    L39:
        if (r13 != null) goto L41;
        return null;
    L41:
        return r13.map(a.a);
    L25:
        r13 = PublishSubject.create();
        if (IStreamMessage.class.isAssignableFrom(LiveMessage.getMessageClass(r5.getWsMethod())) == false) goto L35;
        ALogger.i("RoomMessageState", "register stream listener for " + r5.getWsMethod());
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, this.e, 0, 2);
        if (r2 == null) goto L37;
        com.bytedance.live.datacontext.j r4 = r2.getStreamMessageManager();
        if (r4 == null) goto L37;
        final emc.a r7 = (emc.a) r4.getValue();
        if (r7 == null) goto L37;
        final j r8 = new j(this, r13);
        r7.addMessageListener(r5.getIntType(), r8);
        this.c.put(r5, new Pair(r13, new RoomMessageState$obtainObservable$$inlined$also$lambda$1(this, r5, r7, r8)));
    L37:
        r13 = null;
        goto L39
    L35:
        final vlc.d r9 = (vlc.d) this.e.get("data_message_manager", null);
        if (r9 == null) goto L37;
        final i r14 = new i(this, r13);
        r9.addMessageListener(r5.getIntType(), r14);
        this.c.put(r5, new Pair(r13, new RoomMessageState$obtainObservable$$inlined$also$lambda$2(this, r5, r9, r14)));
        goto L39
    L8:
        if (Intrinsics.areEqual(r5.getWsMethod(), "Webcast" + r11) == true) goto L15;
        if (Intrinsics.areEqual(r5.getWsMethod(), "WebcastOpen" + r11) == true) goto L15;
        if (Intrinsics.areEqual(r5.getWsMethod(), "WebcastContentOpen" + r11) == true) goto L15;
        r6 = false;
        goto L16
    L19:
        r5 = null;
        goto L20
    }

    public h(Gson r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "jsGson");
        Intrinsics.checkNotNullParameter(r3, "mDataCenter");
        super(true);
        this.d = r2;
        this.e = r3;
        this.c = new ConcurrentHashMap();
    }
}
