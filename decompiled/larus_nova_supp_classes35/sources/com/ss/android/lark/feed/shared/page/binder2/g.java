package com.ss.android.lark.feed.shared.page.binder2;

import android.content.DialogInterface;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements Runnable {
    public final /* synthetic */ ueb.a a;
    public final /* synthetic */ FeedCommonViewHolder b;
    public final /* synthetic */ UIFeedCard c;
    public final /* synthetic */ LinkedHashMap<FeedActionType, aeb.c> d;
    public final /* synthetic */ aeb.a e;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ ueb.a a;
        public final /* synthetic */ FeedCommonViewHolder b;

        public a(ueb.a r1, g r2, FeedCommonViewHolder r3) {
            this.a = r1;
            this.b = r3;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            zeb.a r3 = this.a.z();
            if (r3 == null) goto L5;
            r3.b();
        L6:
            zeb.b r4 = this.a.f2();
            if (r4 == null) goto L9;
            r4.b();
        L9:
            this.b.E = null;
            return;
        L5:
            Log.w("FeedSharedModule_FeedCommonViewHolder", "FeedDataListener is null!");
            goto L6
        }
    }

    public final void a() {
        zeb.a r0 = this.a.z();
        UDDialog r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r0.a());
    L7:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L25;
        FeedCommonViewHolder r3 = this.b;
        n r4 = FeedCommonViewHolder.M;
        o r5 = FeedCommonViewHolder.N;
        if (r5 == null) goto L11;
        r1 = r5.a(r3.s, this.c, this.a, this.d, this.e, UIHelper.dp2px(8.0f));
    L11:
        r3.E = r1;
        UDDialog r6 = this.b.E;
        if (r6 != null) goto L14;
    L18:
        this.b.V3(this.c, this.a);
        FeedCommonViewHolder r7 = this.b;
        UDDialog r8 = r7.E;
        if (r8 == null) goto L26;
        r8.setOnDismissListener(new a(this.a, this, r7));
        return;
    L26:
        return;
    L14:
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L23;
        DialogLancet.handleBlockedDialogShow(r6);
        goto L18
    L23:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L17:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        goto L18
    L25:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(ueb.a r1, FeedCommonViewHolder r2, UIFeedCard r3, LinkedHashMap<FeedActionType, aeb.c> r4, aeb.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
