package com.bytedance.android.livesdk.drawer.relax;

import android.content.Context;
import com.bytedance.salamander.anniex.a4;
import com.bytedance.salamander.anniex.b4;
import com.bytedance.salamander.anniex.c4;
import com.bytedance.salamander.anniex.d3;
import com.bytedance.salamander.anniex.i4;
import com.bytedance.salamander.anniex.m2;
import com.bytedance.salamander.anniex.o2;
import com.bytedance.salamander.anniex.r3;
import com.bytedance.salamander.anniex.s3;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<no name provided>", "", "anchorId", "", "isOnline", "", "roomId", "invoke"}, k = 3, mv = {1, 4, 3})
public final class MainpageDrawerHistoryKt$LiveDrawerMainHistory$1$deleteHistory$1 extends Lambda implements Function3<String, Boolean, String, Unit> {
    final /* synthetic */ Function1 $getAnchorId;
    final /* synthetic */ e $globalData;
    final /* synthetic */ u $props;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageDrawerHistoryKt$LiveDrawerMainHistory$1$deleteHistory$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/salamander/anniex/b4;", "res", "", "invoke", "(Lcom/bytedance/salamander/anniex/b4;)V", "<no name provided>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<b4, Unit> {
        final /* synthetic */ String $anchorId;
        final /* synthetic */ MainpageDrawerHistoryKt$LiveDrawerMainHistory$1$deleteHistory$1 this$0;

        public AnonymousClass1(MainpageDrawerHistoryKt$LiveDrawerMainHistory$1$deleteHistory$1 r1, String r2) {
            this.this$0 = r1;
            this.$anchorId = r2;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((b4) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(b4 r4) {
            Intrinsics.checkNotNullParameter(r4, "res");
            int r1 = c03.a.a;
            c4 r5 = r4.b;
            Context r2 = null;
            if (r5 == null) goto L5;
            String r6 = r5.d;
        L6:
            LinkedHashMap r7 = (LinkedHashMap) c03.a.a(r6, Boolean.FALSE, Object.class, Object.class);
            if (r7.get("data") == null) goto L17;
            Object r8 = r7.get("status_code");
            if (r8 == null) goto L16;
            if (((Integer) r8).intValue() != 0) goto L17;
            this.this$0.$props.c.invoke(new AnonymousClass2(this));
            return;
        L16:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L17:
            int r9 = o2.a;
            i4 r10 = new i4("网络错误");
            C01581 r0 = C01581.INSTANCE;
            e r3 = this.this$0.$globalData;
            if (r3 == null) goto L20;
            r2 = r3.getContext();
        L20:
            o2.a.a(r10, r0, r2);
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public MainpageDrawerHistoryKt$LiveDrawerMainHistory$1$deleteHistory$1(e r1, u r2, Function1 r3) {
        this.$globalData = r1;
        this.$props = r2;
        this.$getAnchorId = r3;
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((String) r1, ((Boolean) r2).booleanValue(), (String) r3);
        return Unit.INSTANCE;
    }

    public final void invoke(String r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "anchorId");
        Intrinsics.checkNotNullParameter(r14, "roomId");
        LinkedHashMap r5 = new LinkedHashMap();
        e r0 = this.$globalData;
        String r9 = "";
        if (r0 == null) goto L14;
        Function0<? extends r3> r1 = r0.d;
        if (r1 == null) goto L14;
        r3 r2 = (r3) r1.invoke();
        if (r2 == null) goto L14;
        s3 r3 = r2.b;
        if (r3 == null) goto L14;
        d3 r4 = r3.b;
        if (r4 == null) goto L14;
        String r6 = r4.a;
        if (r6 == null) goto L14;
    L15:
        com.bytedance.rts.foundation.m.e(r5, "user_id", r6);
        com.bytedance.rts.foundation.m.e(r5, "anchor_ids", r12);
        int r7 = m2.a;
        m2.a.a(new a4("https://webcast.amemv.com/webcast/distribution/delete_story/", "GET", null, r5, null, null, 8176), new AnonymousClass1(this, r12));
        LinkedHashMap r8 = new LinkedHashMap();
        e r10 = this.$globalData;
        if (r10 == null) goto L29;
        Function0<? extends r3> r11 = r10.d;
        if (r11 == null) goto L29;
        r3 r15 = (r3) r11.invoke();
        if (r15 == null) goto L29;
        s3 r16 = r15.b;
        if (r16 == null) goto L29;
        d3 r17 = r16.b;
        if (r17 == null) goto L29;
        String r18 = r17.a;
        if (r18 == null) goto L29;
        r9 = r18;
    L29:
        com.bytedance.rts.foundation.m.e(r8, "user_id", r9);
        com.bytedance.rts.foundation.m.e(r8, "history_is_on_live", Integer.valueOf(r13 ? 1 : 0));
        com.bytedance.rts.foundation.m.e(r8, "enter_from_merge", "drawer_hot");
        com.bytedance.rts.foundation.m.e(r8, "enter_method", "live_history_card");
        com.bytedance.rts.foundation.m.e(r8, "anchor_id", r12);
        com.bytedance.rts.foundation.m.e(r8, "room_id", r14);
        LiveDrawerLog.a.getClass();
        LiveDrawerLog.Companion.a("livesdk_history_delete", r8, null);
        return;
    L14:
        r6 = "";
        goto L15
    }
}
