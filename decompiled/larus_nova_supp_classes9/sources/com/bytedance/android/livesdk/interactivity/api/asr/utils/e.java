package com.bytedance.android.livesdk.interactivity.api.asr.utils;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> a = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.chatroom.model.b> b = null;

    public final class a implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
        a = new com.bytedance.android.livesdk.sharedpref.e("live_anchor_asr_auth_status", 0);
        b = new com.bytedance.android.livesdk.sharedpref.e("live_anchor_asr_switch_status", new com.bytedance.android.livesdk.chatroom.model.b());
    }

    public static boolean b() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = a;
        Integer r1 = (Integer) r0.getValue();
        if (r1 != null) goto L6;
    L7:
        Integer r2 = (Integer) r0.getValue();
        if (r2 != null) goto L11;
    L13:
        return false;
    L11:
        if (r2.intValue() != 1) goto L13;
        return true;
    L6:
        if (r1.intValue() != 0) goto L7;
        return true;
    }

    public static m22.b a() {
        boolean r1 = false;
        if (b() == false) goto L21;
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.chatroom.model.b> r2 = b;
        if (((com.bytedance.android.livesdk.chatroom.model.b) r2.getValue()).status != 1) goto L7;
        boolean r3 = true;
    L9:
        if (((com.bytedance.android.livesdk.chatroom.model.b) r2.getValue()).switchWelcome != 1) goto L11;
        boolean r5 = true;
    L13:
        if (((com.bytedance.android.livesdk.chatroom.model.b) r2.getValue()).switchThanks != 1) goto L15;
        boolean r6 = true;
    L17:
        if (((com.bytedance.android.livesdk.chatroom.model.b) r2.getValue()).switchCongrats != 1) goto L22;
        r1 = true;
    L22:
        return new m22.b(r3, r5, r6, r1);
    L15:
        r6 = false;
        goto L17
    L11:
        r5 = false;
        goto L13
    L7:
        r3 = false;
        goto L9
    L21:
        return new m22.b(false, false, false, false);
    }

    @JvmStatic
    public static final Disposable c(boolean r1, Function1<? super m22.b, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        r2.invoke(a());
        if (r1 == false) goto L6;
        return xs2.b.a().b(m22.b.class).subscribe(new a(r2));
    L6:
        return xs2.b.a().c(m22.b.class).subscribe(new a(r2));
    }
}
