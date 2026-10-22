package com.ss.android.lark.chat.component.task;

import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.i;
import com.ss.android.lark.passportc.task.d;
import io.reactivex.Observable;
import j0c.b;
import j0c.c;
import j0c.e;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SetLoginChatterTask implements d {
    public static final b b = null;
    public final i a;

    public static final class a {
    }

    public final boolean G() {
        return false;
    }

    public final /* synthetic */ Observable H(e r1) {
        return com.ss.android.lark.passportc.task.e.a(this, r1);
    }

    public final List<b> dependencies() {
        return CollectionsKt.mutableListOf(new b[]{new b("switch_user")});
    }

    static {
        b = new b("set_login_chatter");
    }

    public final b F() {
        return b;
    }

    @Inject
    public SetLoginChatterTask(i r2) {
        Intrinsics.checkNotNullParameter(r2, "multiOnlineFG");
        this.a = r2;
    }

    public final Observable<c> I(e r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r6.b == Scene.FAST_ONLINE) goto L5;
        ImSdkService.d().pd(r6.a.a.userId, new SetLoginChatterTask$execute$1());
        return Observable.just(new c(b, true, null, 12));
    L5:
        return Observable.just(new c(b, true, null, 12));
    }
}
