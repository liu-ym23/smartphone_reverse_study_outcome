package com.larus.ugc.feed.impl.spi;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.FlowLiveDataConversions;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.f;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import g0a.k;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.spi.CommunityCreateNavigatorAndroidImpl$openMixCreationPage$1", f = "CommunityCreateNavigatorAndroidImpl.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
public final class CommunityCreateNavigatorAndroidImpl$openMixCreationPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ k $params;
    final /* synthetic */ z0 $targetImageItem;
    int label;
    final /* synthetic */ CommunityCreateNavigatorAndroidImpl this$0;

    public static final class a implements zs8.a {
        public final /* synthetic */ k a;
        public final /* synthetic */ boolean b;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getChatType() {
            return "default";
        }

        public final String getClickFrom() {
            return "ai_generate_feed_image";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String b() {
            return this.a.b;
        }

        public final String getBotId() {
            e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
            if (r0 == null) goto L7;
            LaunchInfo r1 = r0.a;
            if (r1 == null) goto L7;
            return r1.W();
        L7:
            return null;
        }

        public final String getEnterMethod() {
            if (this.b == false) goto L5;
            return "create_button_panel";
        L5:
            return "click_tab";
        }

        public a(k r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public CommunityCreateNavigatorAndroidImpl$openMixCreationPage$1(CommunityCreateNavigatorAndroidImpl r1, k r2, z0 r3, Continuation<? super CommunityCreateNavigatorAndroidImpl$openMixCreationPage$1> r4) {
        this.this$0 = r1;
        this.$params = r2;
        this.$targetImageItem = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CommunityCreateNavigatorAndroidImpl$openMixCreationPage$1(this.this$0, this.$params, this.$targetImageItem, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r62) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r3 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r62);
        Object r4 = r62;
    L15:
        e r5 = (e) r4;
    L16:
        if (r5 == null) goto L18;
        String r6 = r5.a;
    L19:
        WeakReference<Activity> r7 = this.this$0.a;
        if (r7 == null) goto L37;
        Activity r8 = r7.get();
        if (r8 == null) goto L37;
        if ((!r8.isFinishing()) == true) goto L27;
        r8 = null;
    L27:
        if (r8 == null) goto L37;
        boolean r9 = z2.a.f1().f();
        IUgcAIGCService.Companion r15 = IUgcAIGCService.a;
        e0 r10 = (e0) AuthModelDelegate.b.e().getValue();
        if (r10 == null) goto L34;
        LaunchInfo r11 = r10.a;
        if (r11 == null) goto L34;
        r3 = r11.W();
    L34:
        String r12 = r3;
        k r13 = this.$params;
        boolean r14 = r13.f;
        Bundle r31 = f.c(new Pair[]{TuplesKt.to("suppress_action_bar_item_id_on_send", Boxing.boxBoolean(true))});
        Activity r16 = r8;
        r15.W(new ny9.b(true, r16, this.$targetImageItem, new ChatParam(r6, r12, r13.b, r13.a, "default", 224), r14, false, null, null, null, null, null, null, null, Boxing.boxInt(4), null, null, null, null, null, false, false, new a(this.$params, r9), null, r31, false, null, null, null, !r9, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -278929440, 262143));
        return Unit.INSTANCE;
    L37:
        return Unit.INSTANCE;
    L18:
        r6 = null;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r62);
        ILaunchCacheService r17 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r17 == null) goto L12;
        r5 = r17.b();
        if (r5 != null) goto L16;
    L12:
        Flow r18 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        CommunityCreateNavigatorAndroidImpl$openMixCreationPage$1$cvsId$1 r19 = new CommunityCreateNavigatorAndroidImpl$openMixCreationPage$1$cvsId$1(null);
        this.label = 1;
        r4 = kotlinx.coroutines.flow.e.t(r18, r19, this);
        if (r4 != r1) goto L15;
        return r1;
    }
}
