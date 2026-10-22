package com.bytedance.android.live.browser.jsbridge.state.observable;

import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.jsbridge.state.BaseObservableState;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.n;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends BaseObservableState<JsonObject> {
    public final List<Disposable> e;

    public d() {
        super(false);
        ArrayList r0 = new ArrayList();
        this.e = r0;
        RoomContext.a r1 = RoomContext.Companion;
        RoomContext r6 = RoomContext.a.c(r1, null, 0, 3);
        if (r6 == null) goto L11;
        n r7 = r6.getCurrentMatchInfo();
        if (r7 == null) goto L11;
        Observable r8 = r7.a();
        if (r8 == null) goto L11;
        Disposable r9 = r8.subscribe(new a(this));
        if (r9 == null) goto L11;
        r0.add(r9);
    L11:
        RoomContext r11 = RoomContext.a.c(r1, null, 0, 3);
        if (r11 == null) goto L20;
        n r12 = r11.getCurrentMatchInfo();
        if (r12 == null) goto L20;
        Observable r13 = r12.a();
        if (r13 == null) goto L20;
        Disposable r14 = r13.subscribe(new b(this));
        if (r14 == null) goto L20;
        r0.add(r14);
    L20:
        RoomContext r2 = RoomContext.a.c(r1, null, 0, 3);
        if (r2 == null) goto L30;
        n r3 = r2.getCurrentActiveTabId();
        if (r3 == null) goto L31;
        Observable r4 = r3.a();
        if (r4 == null) goto L32;
        Disposable r5 = r4.subscribe(new c(this));
        if (r5 == null) goto L33;
        r0.add(r5);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
        if (r5 == null) goto L8;
        n r6 = r5.getCurrentMatchInfo();
        if (r6 == null) goto L8;
        JsonObject r7 = (JsonObject) r6.getValue();
        if (r7 == null) goto L8;
    L9:
        RoomContext r8 = RoomContext.a.c(r0, null, 0, 3);
        if (r8 == null) goto L15;
        n r9 = r8.getCurrentActiveTabId();
        if (r9 == null) goto L15;
        JsonObject r11 = (JsonObject) r9.getValue();
        if (r11 == null) goto L15;
    L16:
        RoomContext r1 = RoomContext.a.c(r0, null, 0, 3);
        if (r1 == null) goto L22;
        n r2 = r1.getLastMatchInfo();
        if (r2 == null) goto L22;
        JsonObject r3 = (JsonObject) r2.getValue();
        if (r3 == null) goto L22;
    L23:
        JsonObject r4 = new JsonObject();
        r4.add("matchInfo", r7);
        r4.add("tabInfo", r11);
        r4.add("lastMatchInfo", r3);
        return r4;
    L22:
        r3 = new JsonObject();
    L15:
        r11 = new JsonObject();
    L8:
        r7 = new JsonObject();
        goto L9
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.BaseObservableState
    public final void i() {
        Iterator r0 = CollectionsKt.toList(this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Disposable) r0.next()).dispose();
        goto L4
    L6:
        ((ArrayList) this.e).clear();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final i.f d() {
        return i.e.b.b;
    }
}
