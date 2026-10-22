package com.bytedance.android.live.browser.jsbridge.state.observable;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.jsbridge.state.BaseObservableState;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends BaseObservableState<JsonObject> {
    public final ConcurrentHashMap<MessageType, Pair<Subject<JsonObject>, Function0<Unit>>> e;
    public final Gson f;
    public final DataCenter g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ f a;
        public final /* synthetic */ String b;

        public a(f r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            JsonObject r5 = (JsonObject) r4;
            int r0 = com.bytedance.android.live.browser.jsbridge.d.a;
            String r1 = com.bytedance.android.live.browser.jsbridge.d.b(r5.get("message_method").getAsString());
            JsonObject r2 = new JsonObject();
            com.bytedance.android.live.browser.jsbridge.d.c(r5, this.b);
            r2.add("data_v2", GsonProtectorUtils.toJsonTree(GsonHelper.getLynxWorkaround(), r5));
            r2.addProperty("messageType", r1);
            this.a.h(r2);
        }
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final /* bridge */ /* synthetic */ Object b() {
        return null;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.BaseObservableState
    public final void i() {
        Iterator<T> r0 = this.e.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function0) ((Pair) r0.next()).getSecond()).invoke();
        goto L4
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final i.f d() {
        return i.e.f.b;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.BaseObservableState, com.bytedance.android.live.browser.jsbridge.i.b
    public final Observable<JsonElement> a(String r11) {
        Intrinsics.checkNotNullParameter(r11, "keyParam");
        List r0 = StringsKt.split$default(r11, new String[]{"."}, false, 0, 6, null);
        Observable r2 = null;
        if (r0.size() <= 1) goto L5;
        String r1 = (String) ListProtector.get(r0, 1);
    L6:
        if (r1 == null) goto L8;
        MessageType[] r3 = MessageType.values();
        int r4 = r3.length;
        int r6 = 0;
    L10:
        if (r6 >= r4) goto L25;
        final MessageType r7 = r3[r6];
        if (Intrinsics.areEqual(r7.getWsMethod(), r1) == false) goto L14;
    L21:
        boolean r8 = true;
    L22:
        if (r8 == true) goto L26;
        r6 = r6 + 1;
    L26:
        if (r7 == null) goto L28;
        Pair<Subject<JsonObject>, Function0<Unit>> r5 = this.e.get(r7);
        if (r5 == null) goto L32;
        r2 = (Observable) r5.getFirst();
    L36:
        if (r2 == null) goto L39;
        r2.subscribe(new a(this, r1));
    L39:
        return super.a(r11);
    L32:
        final vlc.d r9 = (vlc.d) this.g.get("data_message_manager", null);
        if (r9 == null) goto L36;
        r2 = PublishSubject.create();
        final g r12 = new g(this, r2);
        r9.addMessageListener(r7.getIntType(), r12);
        this.e.put(r7, new Pair(r2, new RoomMessageState$obtainObservable$$inlined$also$lambda$1(this, r7, r9, r12)));
        goto L36
    L28:
        return super.a(r11);
    L14:
        if (Intrinsics.areEqual(r7.getWsMethod(), "Webcast".concat(r1)) == true) goto L21;
        if (Intrinsics.areEqual(r7.getWsMethod(), "WebcastOpen".concat(r1)) == true) goto L21;
        if (Intrinsics.areEqual(r7.getWsMethod(), "WebcastContentOpen".concat(r1)) == true) goto L21;
        r8 = false;
        goto L22
    L25:
        r7 = null;
        goto L26
    L8:
        return super.a(r11);
    L5:
        r1 = null;
        goto L6
    }

    public f(Gson r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "jsGson");
        Intrinsics.checkNotNullParameter(r3, "mDataCenter");
        super(true);
        this.f = r2;
        this.g = r3;
        this.e = new ConcurrentHashMap();
    }
}
