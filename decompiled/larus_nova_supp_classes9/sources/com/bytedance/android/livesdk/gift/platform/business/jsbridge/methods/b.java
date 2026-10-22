package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.ChangeGiftReceiverResultModel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.ChangeReceiverSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GroupLiveReceiverService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.v7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends wy0.b<v7, ChangeGiftReceiverResultModel> {
    public final com.bytedance.android.scope.j a;

    public final void onTerminate() {
    }

    public final Type k() {
        return TypesJVMKt.getJavaType(Reflection.typeOf(v7.class));
    }

    public b(com.bytedance.android.scope.j r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
    }

    public final void l(vh7.j r9, CallContext r10) {
        v7 r11 = (v7) r9;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "callContext");
        String r13 = r11.R0();     // Catch: Exception -> L65
        List r0 = r11.j5();     // Catch: Exception -> L65
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L11;
        List r3 = r11.j5();     // Catch: Exception -> L65
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L65
        List<String> r4 = CollectionsKt.toList(r3);     // Catch: Exception -> L65
    L12:
        if (r2 == false) goto L16;
        Boolean r5 = r11.F0();     // Catch: Exception -> L65
        if (r5 == null) goto L16;
        boolean r6 = r5.booleanValue();     // Catch: Exception -> L65
    L17:
        String r7 = r11.A8();     // Catch: Exception -> L65
        if (r7 != null) goto L20;
    L23:
        boolean r8 = true;
    L25:
        if (r8 == true) goto L27;
        String r14 = r11.A8();     // Catch: Exception -> L65
        Intrinsics.checkNotNull(r14);     // Catch: Exception -> L65
        IBaseUser r15 = (IBaseUser) l97.a.a.fromJson(r14, TypesJVMKt.getJavaType(Reflection.typeOf(IBaseUser.class)));     // Catch: Exception -> L65
    L28:
        Boolean r16 = r11.W6();     // Catch: Exception -> L65
        if (r16 == null) goto L31;
        r1 = r16.booleanValue();     // Catch: Exception -> L65
    L31:
        i12.e r17 = i12.o.b();     // Catch: Exception -> L65
        if (r17 == null) goto L34;
        com.bytedance.android.scope.m.e.getClass();     // Catch: Exception -> L65
        com.bytedance.android.scope.o r18 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class));     // Catch: Exception -> L65
    L35:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r19 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r18;     // Catch: Exception -> L65
        if (r19 == null) goto L38;
        r19.c.setValue(r19, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.h[1], Boolean.valueOf(r1));     // Catch: Exception -> L65
    L38:
        if (r15 == null) goto L48;
        i12.e r20 = i12.o.b();     // Catch: Exception -> L65
        if (r20 == null) goto L42;
        com.bytedance.android.scope.m.e.getClass();     // Catch: Exception -> L65
        com.bytedance.android.scope.o r21 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(GroupLiveReceiverService.class));     // Catch: Exception -> L65
    L43:
        GroupLiveReceiverService r23 = (GroupLiveReceiverService) r21;     // Catch: Exception -> L65
        if (r23 != null) goto L46;
    L63:
        j(null);     // Catch: Exception -> L65
        return;
    L46:
        if (r23.i() != true) goto L63;
        r23.c(r15, ChangeReceiverSource.ReceiverPanel);     // Catch: Exception -> L65
        goto L63
    L42:
        r21 = null;
        goto L43
    L48:
        if (r6 == false) goto L56;
        i12.e r24 = i12.o.b();     // Catch: Exception -> L65
        if (r24 == null) goto L52;
        com.bytedance.android.scope.m.e.getClass();     // Catch: Exception -> L65
        com.bytedance.android.scope.o r25 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class));     // Catch: Exception -> L65
    L53:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r26 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r25;     // Catch: Exception -> L65
        if (r26 == null) goto L63;
        r26.d(r4);     // Catch: Exception -> L65
        goto L63
    L52:
        r25 = null;
        goto L53
    L56:
        i12.e r27 = i12.o.b();     // Catch: Exception -> L65
        if (r27 == null) goto L59;
        com.bytedance.android.scope.m.e.getClass();     // Catch: Exception -> L65
        com.bytedance.android.scope.o r28 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r27).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y.class));     // Catch: Exception -> L65
    L60:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y r29 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y) r28;     // Catch: Exception -> L65
        if (r29 == null) goto L63;
        r29.a(String.valueOf(r13), ChangeReceiverSource.ReceiverPanel);     // Catch: Exception -> L65
        goto L63
    L59:
        r28 = null;
        goto L60
    L34:
        r18 = null;
        goto L35
    L27:
        r15 = null;
        goto L28
    L20:
        if (r7.length() == 0) goto L23;
        r8 = false;
    L16:
        r6 = false;
        goto L17
    L11:
        r4 = CollectionsKt.emptyList();     // Catch: Exception -> L65
        goto L12
    L6:
        if (r0.isEmpty() == true) goto L8;
        r2 = true;
    L65:
        e = move-exception;
        finishWithFailure(e);
    }
}
