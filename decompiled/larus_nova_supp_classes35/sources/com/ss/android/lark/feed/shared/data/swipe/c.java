package com.ss.android.lark.feed.shared.data.swipe;

import com.bytedance.lark.pb.feed.v1.FeedSlideActionSetting;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ FeedSlideActionSetting b;

    public c(a r1, FeedSlideActionSetting r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        a r0 = this.a;
        FeedSlideActionSetting r1 = this.b;
        r0.b.setValue(r1);
        ((ArrayList) r0.c).clear();
        ((ArrayList) r0.d).clear();
        List r2 = r1.left_slide_action;
        Map<FeedSlideActionSetting.FeedSlideActionType, List<FeedActionType>> r3 = a.f;
        boolean r4 = false;
        if (r2 == null) goto L10;
        FeedSlideActionSetting r5 = (FeedSlideActionSetting) r0.b.getValue();
        if (r5 == null) goto L7;
        boolean r6 = Intrinsics.areEqual(r5.left_slide_action_on, Boolean.TRUE);
    L8:
        if (r6 == false) goto L10;
        List<FeedActionType> r7 = r0.c;
        ArrayList r8 = (ArrayList) r7;
        r8.addAll(a.C0202a.a(r2));
        goto L10
    L7:
        r6 = false;
    L10:
        List r9 = r1.right_slide_action;
        if (r9 == null) goto L18;
        FeedSlideActionSetting r10 = (FeedSlideActionSetting) r0.b.getValue();
        if (r10 == null) goto L15;
        r4 = Intrinsics.areEqual(r10.right_slide_action_on, Boolean.TRUE);
    L15:
        if (r4 == false) goto L19;
        List<FeedActionType> r11 = r0.d;
        ArrayList r12 = (ArrayList) r11;
        r12.addAll(a.C0202a.a(r9));
        return;
    L19:
        return;
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
}
