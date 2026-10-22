package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.bytedance.android.live.base.model.r;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.c1;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import j40.f4;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/shortterm/BubbleComponent;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "f", "I", "getType", "()I", "type", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BubbleComponent implements Observer<KVData> {
    public final String a;
    public com.bytedance.android.livesdk.chatroom.view.k b;
    public final Context c;
    public final View d;
    public final com.bytedance.android.live.base.model.p e;
    public final int f;
    public long g;
    public final DataCenter h;

    public final void a() {
        if (((Boolean) c1.a.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (e5.n() == false) goto L10;
        ALogger.d(this.a, "landcape dont allow show");
        return;
    L10:
        if (this.g != 0) goto L13;
        this.g = System.currentTimeMillis();
    L13:
        if (this.e != null) goto L16;
        return;
    L16:
        if (this.d.getParent() != null) goto L18;
        return;
    L18:
        com.bytedance.android.live.base.model.p r0 = this.e;
        r r1 = r0.uIModel;
        if (r1 != null) goto L21;
        return;
    L21:
        int r2 = r0.strategy;
        if (r2 == (-1)) goto L52;
        String r7 = "";
        if (r2 != 4) goto L26;
        int r3 = this.f;
        String r4 = r0.id;
        if (r4 == null) goto L43;
        r7 = r4;
    L43:
        String r5 = String.valueOf(r3) + r7;
        long r6 = this.g;
        int r8 = q.a;
        Intrinsics.checkNotNullParameter(r5, "key");
        com.bytedance.android.livesdk.sharedpref.e r9 = f4.p;
        Pair r10 = (Pair) ((Map) r9.getValue()).get(r5);
        if (r10 != null) goto L46;
    L50:
        int r11 = 1;
    L51:
        ((Map) r9.getValue()).put(r5, new Pair(Long.valueOf(r6), Integer.valueOf(r11)));
        goto L52
    L46:
        if (TimeUtils.isToday(((Number) r10.getFirst()).longValue(), r6) == false) goto L50;
        r11 = ((Number) r10.getSecond()).intValue() + 1;
        if (r11 <= 1) goto L51;
    L49:
        boolean r12 = false;
    L53:
        if (r12 == true) goto L56;
        ALogger.d(this.a, "should not show,strategy is " + this.e.strategy);
        return;
    L56:
        View r13 = this.d.getRootView();
        if (r13 == null) goto L66;
        View r14 = r13.findViewById(2131386365);
        if (r14 == null) goto L66;
        int[] r15 = new int[2];
        int[] r16 = new int[2];
        r14.getLocationOnScreen(r15);
        this.d.getLocationOnScreen(r16);
        int r17 = r15[0];
        if (r17 > r16[0]) goto L66;
        if ((r17 + r14.getWidth()) < (r16[0] + this.d.getWidth())) goto L66;
        boolean r18 = true;
    L67:
        if (r18 == true) goto L78;
        ALogger.d(this.a, "is not visible");
        return;
    L78:
        Context r19 = this.c;     // Catch: Throwable -> L75
        if (r19 == null) goto L74;
        com.bytedance.android.livesdk.chatroom.view.k.a r20 = new com.bytedance.android.livesdk.chatroom.view.k.a((Activity) r19);     // Catch: Throwable -> L75
        String r21 = r1.text;     // Catch: Throwable -> L75
        Intrinsics.checkNotNullParameter(r21, "str");     // Catch: Throwable -> L75
        ((om3.e.a) r20).e = r21;     // Catch: Throwable -> L75
        ((om3.e.a) r20).a = Color.parseColor(r1.bgColor);     // Catch: Throwable -> L75
        ((om3.e.a) r20).g = UtilityKotlinExtentionsKt.h(r1.textSize);     // Catch: Throwable -> L75
        ((om3.e.a) r20).h = Color.parseColor(r1.textColor);     // Catch: Throwable -> L75
        ((om3.e.a) r20).d = this.e.duration;     // Catch: Throwable -> L75
        c r22 = new c(this);     // Catch: Throwable -> L75
        Intrinsics.checkNotNullParameter(r22, "listener");     // Catch: Throwable -> L75
        ((om3.e.a) r20).i = r22;     // Catch: Throwable -> L75
        ((om3.e.a) r20).c = false;     // Catch: Throwable -> L75
        ((om3.e.a) r20).l = false;     // Catch: Throwable -> L75
        com.bytedance.android.livesdk.chatroom.view.k r23 = new com.bytedance.android.livesdk.chatroom.view.k(r20);     // Catch: Throwable -> L75
        this.b = r23;     // Catch: Throwable -> L75
        r23.d(this.d);     // Catch: Throwable -> L75
        Ref.IntRef r110 = new Ref.IntRef();     // Catch: Throwable -> L75
        r110.element = -1;     // Catch: Throwable -> L75
        Ref.IntRef r111 = new Ref.IntRef();     // Catch: Throwable -> L75
        r111.element = -1;     // Catch: Throwable -> L75
        this.d.getViewTreeObserver().addOnGlobalLayoutListener(new b(this, r23, new int[2], r110, r111));     // Catch: Throwable -> L75
        return;
    L74:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        ALogger.e(this.a, th);
        return;
    L66:
        r18 = false;
        goto L67
    L26:
        if (r2 != 5) goto L49;
        int r24 = this.f;
        String r25 = r0.id;
        if (r25 == null) goto L32;
        r7 = r25;
    L32:
        String r26 = String.valueOf(r24) + r7;
        long r27 = this.g;
        int r28 = q.a;
        Intrinsics.checkNotNullParameter(r26, "key");
        com.bytedance.android.livesdk.sharedpref.e r29 = f4.p;
        Pair r30 = (Pair) ((Map) r29.getValue()).get(r26);
        if (r30 == null) goto L37;
        int r31 = ((Number) r30.getSecond()).intValue() + 1;
        if (r31 > 1) goto L49;
    L38:
        ((Map) r29.getValue()).put(r26, new Pair(Long.valueOf(r27), Integer.valueOf(r31)));
        goto L52
    L37:
        r31 = 1;
    L52:
        r12 = true;
        goto L53
    }

    public final Context getContext() {
        return this.c;
    }

    public final int getType() {
        return this.f;
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.getKey().length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L44;
        String r1 = r6.getKey();
        int r2 = r1.hashCode();
        if (r2 == (-1357019912)) goto L19;
        if (r2 == 1060055221) goto L16;
        return;
    L16:
        if (r1.equals("data_keyboard_status") == false) goto L37;
    L20:
        Boolean r7 = (Boolean) r6.getData();
        if (r7 != null) goto L24;
        return;
    L24:
        if (r7.booleanValue() == false) goto L30;
        om3.e r8 = this.b;
        if (r8 == null) goto L39;
        View r9 = r8.getContentView();
        if (r9 == null) goto L40;
        r9.setVisibility(8);
        return;
    L40:
        return;
    L39:
        return;
    L30:
        om3.e r10 = this.b;
        if (r10 == null) goto L42;
        View r11 = r10.getContentView();
        if (r11 == null) goto L43;
        r11.setVisibility(0);
        return;
    L43:
        return;
    L42:
        return;
    L37:
        return;
    L19:
        if (r1.equals("data_pre_show_keyboard") == true) goto L20;
        return;
    L44:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public BubbleComponent(Context r2, CommonIconTemplate r3, com.bytedance.android.live.base.model.p r4, int r5, long r6, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r8;
        this.a = "BubbleComponent";
        r8.observe("data_pre_show_keyboard", this).observe("data_keyboard_status", this);
    }
}
