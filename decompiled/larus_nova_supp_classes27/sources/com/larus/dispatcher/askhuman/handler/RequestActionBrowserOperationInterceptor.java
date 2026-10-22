package com.larus.dispatcher.askhuman.handler;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.browsertakeover.api.BrowserTakeoverOpenResult;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.internal.jni.bean.DispatchCommand;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class RequestActionBrowserOperationInterceptor implements IQuickReplyClickInterceptor {

    public static final class CompletionDelegate implements hv8.d {
        public final String a;
        public final WeakReference<Function1<com.larus.bmhome.taskskill.service.k, Unit>> b;

        public CompletionDelegate(String r1, Function1<? super com.larus.bmhome.taskskill.service.k, Unit> r2) {
            this.a = r1;
            if (r2 == null) goto L5;
            WeakReference<Function1<com.larus.bmhome.taskskill.service.k, Unit>> r3 = new WeakReference(r2);
        L6:
            this.b = r3;
            return;
        L5:
            r3 = null;
            goto L6
        }

        public final Object a(hv8.a r9, Continuation<? super Boolean> r10) {
            if ((r10 instanceof RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$1) == false) goto L7;
            RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$1 r0 = (RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$1) r10;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r11 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L18;
            if (r3 == 1) goto L17;
            if (r3 == 2) goto L16;
            if (r3 != 3) goto L15;
            boolean r12 = r0.Z$0;
            ResultKt.throwOnFailure(r11);
        L36:
            return Boxing.boxBoolean(r12);
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            r9 = (hv8.a) r0.L$0;
            ResultKt.throwOnFailure(r11);
        L30:
            boolean r13 = ((Boolean) r11).booleanValue();
        L24:
            boolean r7 = r13;
            hv8.a r14 = r9;
            r12 = r7;
            if (r12 == false) goto L36;
            MainCoroutineDispatcher r4 = Dispatchers.getMain();
            RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$2 r5 = new RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$2(this, r14, null);
            r0.L$0 = null;
            r0.Z$0 = r12;
            r0.label = 3;
            if (BuildersKt.withContext(r4, r5, r0) != r2) goto L36;
            return r2;
        L17:
            r9 = (hv8.a) r0.L$0;
            ResultKt.throwOnFailure(r11);
        L23:
            r13 = ((Boolean) r11).booleanValue();
            goto L24
        L18:
            ResultKt.throwOnFailure(r11);
            hv8.c r15 = r9.g;
            if ((r15 instanceof hv8.c.a) == false) goto L26;
            r0.L$0 = r9;
            r0.label = 1;
            r11 = BuildersKt.withContext(Dispatchers.getIO(), new RequestActionBrowserOperationInterceptor$CompletionDelegate$completeCloud$2(r9, null), r0);
            if (r11 != r2) goto L23;
            return r2;
        L26:
            if ((r15 instanceof hv8.c.b) == false) goto L38;
            r0.L$0 = r9;
            r0.label = 2;
            r11 = b(r9, (hv8.c.b) r15, r0);
            if (r11 != r2) goto L30;
            return r2;
        L38:
            throw new NoWhenBranchMatchedException();
        L7:
            r0 = new RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$1(this, r10);
            goto L8
        }

        public final Object b(hv8.a r5, hv8.c.b r6, Continuation<? super Boolean> r7) {
            if ((r7 instanceof RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$1) == false) goto L7;
            RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$1 r0 = (RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$1) r7;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            ResultKt.throwOnFailure(r8);
        L17:
            Boolean r9 = (Boolean) r8;
            if (r9 == null) goto L20;
            boolean r10 = r9.booleanValue();
        L22:
            return Boxing.boxBoolean(r10);
        L20:
            r10 = false;
            goto L22
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r8);
            RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$2 r11 = new RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$2(r6, this, r5, null);
            r0.label = 1;
            r8 = TimeoutKt.c(65000, r11, r0);
            if (r8 != r2) goto L17;
            return r2;
        L7:
            r0 = new RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$1(this, r7);
            goto L8
        }
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final String c() {
        return "interaction.request_action";
    }

    public RequestActionBrowserOperationInterceptor() {
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final boolean e(k r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptorContext");
        Integer r3 = r2.b.getActionType();
        int r0 = ActionType.CUA_REQUEST_ACTION_BROWSER_OPERATION.getValue();
        if (r3 != null) goto L6;
    L8:
        return false;
    L6:
        if (r3.intValue() != r0) goto L8;
        return true;
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final void f(String r1) {
        IQuickReplyClickInterceptor.DefaultImpls.a(r1);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final p g(o r32) {
        Intrinsics.checkNotNullParameter(r32, "interceptorContext");
        BrowserTakeoverEntryMonitor r0 = r32.p;
        FragmentActivity r3 = r32.c;
        if (r3 == null) goto L225;
        if (r3.isDestroyed() == false) goto L7;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == false) goto L225;
        t r8 = r32.d;
        String r9 = r8.a;
        if (r9 != null) goto L19;
    L26:
        String r17 = null;
    L27:
        if (r17 == null) goto L217;
        if (StringsKt.isBlank(r32.g) == true) goto L217;
        f r4 = r8.f;
        if (r4 != null) goto L34;
    L36:
        boolean r5 = false;
    L37:
        if (r5 == false) goto L47;
        String r6 = r4.b;
        if (r6 != null) goto L41;
    L44:
        boolean r10 = true;
    L45:
        if (r10 == true) goto L47;
        hv8.c.a r11 = new hv8.c.a(r4.b, r4.c);
    L76:
        String r13 = r32.b.a;
        String r14 = r32.g;
        String r15 = r32.h;
        int r12 = r32.i;
        String r16 = r8.b;
        if (r0 == null) goto L80;
        String r18 = r0.b;
        if (r18 == null) goto L80;
    L81:
        String r20 = r18;
        if (r0 == null) goto L84;
        RequestActionBrowserOperationInterceptor$handleClick$request$1$1 r21 = new RequestActionBrowserOperationInterceptor$handleClick$request$1$1(r0);
    L85:
        hv8.a r22 = new hv8.a(r13, r14, r15, r12, r17, r16, r11, r20, r21);
        CompletionDelegate r23 = new CompletionDelegate(r32.f, r32.k);
        if ((r11 instanceof hv8.c.b) == false) goto L200;
        hv8.c.b r24 = (hv8.c.b) r11;
        String r25 = r24.b;
        if (r25 == null) goto L232;
        Integer r26 = StringsKt.toIntOrNull(r25);
        if (r26 != null) goto L92;
    L97:
        boolean r27 = false;
    L98:
        if (r27 == true) goto L232;
        return h(r32, BrowserTakeoverEntryMonitor.Reason.INVALID_APP_ID);
    L92:
        if (r26.intValue() <= 0) goto L94;
        boolean r28 = true;
    L95:
        if (r28 != true) goto L97;
        r27 = true;
        goto L98
    L94:
        r28 = false;
    L232:
        GetAllDevicesRepo r30 = GetAllDevicesRepo.a;     // Catch: Exception -> L197
        AllDeviceResponse r31 = GetAllDevicesRepo.d();     // Catch: Exception -> L197
        if (r31 == null) goto L104;
        List<PcDevice> r110 = r31.getDevices();
    L105:
        if (r110 != null) goto L107;
        r110 = CollectionsKt.emptyList();
    L107:
        List r111 = CollectionsKt.filterNotNull(r110);
        ArrayList r112 = new ArrayList();
        Iterator r113 = r111.iterator();
    L109:
        if (r113.hasNext() == false) goto L120;
        Object r114 = r113.next();
        PcDevice r115 = (PcDevice) r114;
        if (Intrinsics.areEqual(r115.getDeviceId(), r24.a) == true) goto L113;
    L117:
        boolean r33 = false;
    L118:
        if (r33 == false) goto L109;
        r112.add(r114);
        goto L109
    L113:
        if (r24.b != null) goto L115;
    L116:
        r33 = true;
        goto L118
    L115:
        if (Intrinsics.areEqual(r115.b(), r24.b) == false) goto L117;
    L120:
        PcDevice r34 = (PcDevice) CollectionsKt.singleOrNull(r112);
        if (r34 == null) goto L123;
        boolean r116 = Intrinsics.areEqual(r34.r(), Boolean.TRUE);
    L124:
        if (r116 == false) goto L137;
        Boolean r117 = r34.c();
        Boolean r118 = Boolean.TRUE;
        if (Intrinsics.areEqual(r117, r118) == false) goto L137;
        if (Intrinsics.areEqual(r34.g(), r118) == false) goto L137;
        List r119 = r34.q();
        if (r119 != null) goto L132;
    L134:
        boolean r120 = false;
    L135:
        if (r120 == false) goto L137;
        boolean r121 = true;
    L138:
        String r122 = r24.b;
        if (r122 != null) goto L143;
        if (r34 == null) goto L142;
        r122 = r34.b();
        goto L143
    L142:
        r122 = null;
    L143:
        if (r121 == false) goto L170;
        if (r122 == null) goto L153;
        Integer r123 = StringsKt.toIntOrNull(r122);
        if (r123 == null) goto L153;
        if (r123.intValue() <= 0) goto L150;
        boolean r124 = true;
    L151:
        if (r124 != true) goto L153;
        boolean r125 = true;
    L154:
        if (r125 == false) goto L170;
        boolean r1 = hv8.b.a(r3, new hv8.a(r22.a, r22.b, r22.c, r22.d, r22.e, r22.f, new hv8.c.b(r24.a, r122, r24.c), r22.h, r22.i), r23);
        if (r1 == false) goto L159;
        if (r0 != null) goto L162;
    L165:
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r2 = r32.k;
        if (r2 == null) goto L169;
        r2.invoke(com.larus.bmhome.taskskill.service.k.a.a);
    L169:
        return new p(r1, false);
    L162:
        if (r0.d != BrowserTakeoverOpenResult.REUSED) goto L164;
        r0.b("reused", BrowserTakeoverEntryMonitor.Reason.ALREADY_OPEN);
        goto L165
    L164:
        r0.b("opened", BrowserTakeoverEntryMonitor.Reason.NONE);
        goto L165
    L159:
        return h(r32, null);
    L150:
        r124 = false;
    L153:
        r125 = false;
    L170:
        if (r31 != null) goto L173;
        BrowserTakeoverEntryMonitor.Reason r35 = BrowserTakeoverEntryMonitor.Reason.DEVICE_CACHE_MISSING;
    L196:
        return h(r32, r35);
    L173:
        if (r112.size() <= 1) goto L175;
        r35 = BrowserTakeoverEntryMonitor.Reason.DEVICE_AMBIGUOUS;
        goto L196
    L175:
        if (r34 != null) goto L177;
        r35 = BrowserTakeoverEntryMonitor.Reason.DEVICE_NOT_FOUND;
        goto L196
    L177:
        Boolean r36 = r34.r();
        Boolean r37 = Boolean.TRUE;
        if (Intrinsics.areEqual(r36, r37) == true) goto L181;
        r35 = BrowserTakeoverEntryMonitor.Reason.DEVICE_OFFLINE;
        goto L196
    L181:
        if (Intrinsics.areEqual(r34.c(), r37) == true) goto L184;
        r35 = BrowserTakeoverEntryMonitor.Reason.NOT_AUTHORIZED;
        goto L196
    L184:
        if (Intrinsics.areEqual(r34.g(), r37) == true) goto L186;
        r35 = BrowserTakeoverEntryMonitor.Reason.CONTROL_DISABLED;
        goto L196
    L186:
        List r38 = r34.q();
        if (r38 != null) goto L189;
    L191:
        boolean r40 = false;
    L192:
        if (r40 == true) goto L194;
        r35 = BrowserTakeoverEntryMonitor.Reason.CAPABILITY_MISSING;
        goto L196
    L194:
        r35 = BrowserTakeoverEntryMonitor.Reason.INVALID_APP_ID;
        goto L196
    L189:
        if (r38.contains(Integer.valueOf(DispatchCommand.RTC_START_ROOM_REQUEST.value)) != true) goto L191;
        r40 = true;
        goto L192
    L132:
        if (r119.contains(Integer.valueOf(DispatchCommand.RTC_START_ROOM_REQUEST.value)) != true) goto L134;
        r120 = true;
    L137:
        r121 = false;
        goto L138
    L123:
        r116 = false;
        goto L124
    L104:
        r110 = null;
    L197:
        e = move-exception;
        IQuickReplyClickInterceptor.DefaultImpls.a("[browserTakeover] device cache read failed, type=".concat(e.getClass().getSimpleName()));
        return h(r32, BrowserTakeoverEntryMonitor.Reason.DEVICE_CACHE_ERROR);
    L200:
        boolean r41 = hv8.b.a(r3, r22, r23);
        if (r41 == false) goto L203;
        if (r0 != null) goto L206;
    L209:
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r42 = r32.k;
        if (r42 == null) goto L213;
        r42.invoke(com.larus.bmhome.taskskill.service.k.a.a);
    L213:
        return new p(r41, false);
    L206:
        if (r0.d != BrowserTakeoverOpenResult.REUSED) goto L208;
        r0.b("reused", BrowserTakeoverEntryMonitor.Reason.ALREADY_OPEN);
        goto L209
    L208:
        r0.b("opened", BrowserTakeoverEntryMonitor.Reason.NONE);
        goto L209
    L203:
        return h(r32, null);
    L84:
        r21 = null;
    L80:
        r18 = UUID.randomUUID().toString();
        goto L81
    L41:
        if (StringsKt.isBlank(r6) == true) goto L44;
        r10 = false;
    L47:
        if (r4 != null) goto L49;
    L51:
        boolean r43 = false;
    L52:
        if (r43 == true) goto L215;
        if (r32.b.a() == false) goto L215;
        String r44 = r32.e;
        if (r44 != null) goto L58;
    L60:
        r44 = null;
    L61:
        if (r44 == null) goto L63;
        bs8.a r45 = r32.b.b;
        if (r45 == null) goto L71;
        String r46 = r45.g;
        if (r46 == null) goto L71;
        if ((!StringsKt.isBlank(r46)) == false) goto L71;
    L72:
        if (r4 == null) goto L74;
        String r47 = r4.c;
    L75:
        r11 = new hv8.c.b(r44, r46, r47);
        goto L76
    L74:
        r47 = null;
    L71:
        r46 = null;
        goto L72
    L63:
        return h(r32, BrowserTakeoverEntryMonitor.Reason.DEVICE_ID_MISSING);
    L58:
        if ((!StringsKt.isBlank(r44)) == false) goto L60;
    L215:
        return h(r32, BrowserTakeoverEntryMonitor.Reason.TARGET_UNAVAILABLE);
    L49:
        if (r4.a != true) goto L51;
        r43 = true;
        goto L52
    L34:
        if (r4.a != true) goto L36;
        r5 = true;
    L217:
        if (r0 == null) goto L219;
        BrowserTakeoverEntryMonitor.Reason r48 = BrowserTakeoverEntryMonitor.Reason.INVALID_REQUEST;
        Intrinsics.checkNotNullParameter(r48, "reason");
        r0.b("fail", r48);
    L219:
        t19.s.a.getClass();
        t19.s.s(r3, 2131910487);
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r50 = r32.k;
        if (r50 == null) goto L223;
        r50.invoke(new com.larus.bmhome.taskskill.service.k.b("invalid_browser_request"));
    L223:
        return new p(false, false);
    L19:
        if ((!StringsKt.isBlank(r9)) == true) goto L21;
    L23:
        boolean r126 = false;
    L24:
        if (r126 == false) goto L26;
        r17 = r9;
        goto L27
    L21:
        if (Intrinsics.areEqual(r9, "null") == true) goto L23;
        r126 = true;
        goto L24
    L7:
        if (r3.isFinishing() == true) goto L13;
        if (r3.getSupportFragmentManager().isStateSaved() == true) goto L13;
        if (r3.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L13;
        r7 = true;
    L225:
        if (r0 == null) goto L227;
        BrowserTakeoverEntryMonitor.Reason r51 = BrowserTakeoverEntryMonitor.Reason.ACTIVITY_UNAVAILABLE;
        Intrinsics.checkNotNullParameter(r51, "reason");
        r0.b("fail", r51);
    L227:
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r52 = r32.k;
        if (r52 == null) goto L231;
        r52.invoke(new com.larus.bmhome.taskskill.service.k.b("activity_unavailable"));
    L231:
        return new p(false, false);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final void a(o r1, Function1<? super Continuation<? super dm9.a<Unit>>, ? extends Object> r2) {
        IQuickReplyClickInterceptor.DefaultImpls.e(r1, r2);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final p b(o r1, boolean r2) {
        return IQuickReplyClickInterceptor.DefaultImpls.b(r1, r2);
    }

    public final p h(o r8, BrowserTakeoverEntryMonitor.Reason r9) {
        boolean r0 = IQuickReplyClickInterceptor.DefaultImpls.d(this, r8.c, r8.h, r8.j, r8.m, r8.n, r8.o);
        BrowserTakeoverEntryMonitor r1 = r8.p;
        if (r1 == null) goto L21;
        if (r9 != null) goto L19;
        BrowserTakeoverOpenResult r10 = r1.d;
        if (r10 != null) goto L8;
        int r11 = -1;
    L9:
        switch(r11) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L10:
        BrowserTakeoverEntryMonitor.Reason r12 = BrowserTakeoverEntryMonitor.Reason.OPEN_REJECTED;
    L18:
        r1.a(r0, r12);
        goto L21
    L11:
        r12 = BrowserTakeoverEntryMonitor.Reason.SERVICE_UNAVAILABLE;
        goto L18
    L12:
        r12 = BrowserTakeoverEntryMonitor.Reason.PAGE_OPEN_FAILED;
        goto L18
    L13:
        r12 = BrowserTakeoverEntryMonitor.Reason.SESSION_BUSY;
        goto L18
    L14:
        r12 = BrowserTakeoverEntryMonitor.Reason.INVALID_REQUEST;
        goto L18
    L15:
        r12 = BrowserTakeoverEntryMonitor.Reason.TARGET_DISABLED;
        goto L18
    L16:
        r12 = BrowserTakeoverEntryMonitor.Reason.EXPERIMENT_DISABLED;
        goto L18
    L17:
        r12 = BrowserTakeoverEntryMonitor.Reason.ACTIVITY_UNAVAILABLE;
        goto L18
    L8:
        r11 = BrowserTakeoverEntryMonitor.b.a[r10.ordinal()];
        goto L9
    L19:
        r1.a(r0, r9);
    L21:
        return IQuickReplyClickInterceptor.DefaultImpls.b(r8, r0);
    }

    @Override // com.larus.dispatcher.askhuman.handler.IQuickReplyClickInterceptor
    public final boolean d(FragmentActivity r1, String r2, Integer r3, String r4, String r5, String r6) {
        return IQuickReplyClickInterceptor.DefaultImpls.d(this, r1, r2, r3, r4, r5, r6);
    }
}
