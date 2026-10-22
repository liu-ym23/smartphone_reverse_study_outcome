package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.config.ea0;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/OpenInteractGameLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenInteractGameLoader extends AbsDynamicLoader {
    public final String h;
    public final Function0<Unit> i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ OpenInteractGameLoader a;

        public a(OpenInteractGameLoader r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.i.invoke();
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        if (ea0.a.getValue().booleanValue() == true) goto L23;
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r1 = AudienceGameContext.a.a();
        if (r1 == null) goto L23;
        n r2 = r1.getOpenInteractGameIcon();
        if (r2 == null) goto L23;
        ExtendedToolbarButton.c r3 = (ExtendedToolbarButton.c) r2.getValue();
        if (r3 == null) goto L23;
        AudienceGameContext r4 = AudienceGameContext.a.a();
        if (r4 == null) goto L19;
        m r5 = r4.getOpenInteractGameIconShouldShow();
        if (r5 == null) goto L19;
        Boolean r6 = (Boolean) r5.getValue();
        if (r6 == null) goto L19;
        boolean r7 = r6.booleanValue();
    L20:
        if (r7 == false) goto L22;
        ALogger.d(this.h, "插件玩法显示在第一个icon");
    L24:
        if (r3 == null) goto L26;
        r0.add(r3);
    L26:
        return r0;
    L22:
        ALogger.d(this.h, "插件玩法消失");
    L19:
        r7 = false;
    L23:
        r3 = null;
        goto L24
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        if (ea0.a.getValue().booleanValue() == true) goto L8;
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r0 = AudienceGameContext.a.a();
        if (r0 == null) goto L9;
        r0.getOpenInteractGameIconShouldShow().a().observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        return;
    L9:
        return;
    }

    public OpenInteractGameLoader(e r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "env");
        Intrinsics.checkNotNullParameter(r3, "update");
        super(r2);
        this.i = r3;
        this.h = "OpenInteractGameLoader";
    }
}
