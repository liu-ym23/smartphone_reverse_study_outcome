package com.bytedance.android.live.broadcastgame.opengame;

import android.app.Activity;
import android.app.Dialog;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.widget.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenOpenPlatformGameUtils {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Boolean r8 = (Boolean) r7;
            ALogger.i("OpenOpenPlatformGameUtils", String.valueOf(r8));
            if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L6;
            UtilityKotlinExtentionsKt.s(200, false, false, new OpenOpenPlatformGameUtils$showLoading$1$1(this), 6);
            return;
        }
    }

    public static void a() {
        Activity r0 = com.bytedance.android.live.core.utils.a.d();
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        Disposable r2 = null;
        r1.element = null;
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        e1 r4 = new e1(r0);
        r3.element = r4;
        r4.c = "加载中";
        ALogger.i("OpenOpenPlatformGameUtils", String.valueOf(r0));
        Dialog r5 = (Dialog) r3.element;
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(r5);
    L7:
        final Function0<Unit> r6 = new OpenOpenPlatformGameUtils$showLoading$finalHide$1(r1, r3);
        InteractGameContext r7 = InteractGameContext.Companion.getContext();
        if (r7 == null) goto L16;
        com.bytedance.live.datacontext.m<Boolean> r8 = r7.getPanelShowing();
        if (r8 == null) goto L16;
        Observable r9 = r8.a();
        if (r9 == null) goto L16;
        Observable r11 = r9.observeOn(AndroidSchedulers.mainThread());
        if (r11 == null) goto L16;
        r2 = r11.subscribe(new a(r6));
    L16:
        r1.element = r2;
        UtilityKotlinExtentionsKt.s(3000, false, false, new OpenOpenPlatformGameUtils$showLoading$2(r6), 6);
        return;
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L6:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        goto L7
    }

    static {
    }
}
