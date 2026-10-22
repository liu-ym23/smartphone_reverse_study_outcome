package com.ss.android.lark.flow.chat.page.flow.plugin;

import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.feed.v1.PushNavigateToFeed;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.a {
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c g;
    public InterfaceC0034a h;
    public boolean i;
    public final CoroutineScope j;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.page.flow.plugin.a$a, reason: collision with other inner class name */
    public interface InterfaceC0034a {
        @SdkPush(2632)
        RucketJob<PushNavigateToFeed> navigateToFeedPush();
    }

    public a() {
        this.j = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public final void D() {
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.D();
        CoroutineScopeKt.cancel$default(this.j, null, 1, null);
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r12, i7b.a r13) {
        Intrinsics.checkNotNullParameter(r12, "chatApp");
        Intrinsics.checkNotNullParameter(r13, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r12, r13);
        this.g = r12;
        this.h = (InterfaceC0034a) w.a(r12).y().create(InterfaceC0034a.class);
        String r14 = r13.e;
        if (r14 == null) goto L25;
        Long r15 = StringsKt.toLongOrNull(r14);
        if (r15 == null) goto L26;
        long r3 = r15.longValue();
        zhb.a r16 = r12.getFragment();
        zhb.a r1 = null;
        if ((r16 instanceof zhb.a) == false) goto L9;
        zhb.a r17 = r16;
    L10:
        if (r17 == null) goto L16;
        ThreadTopic r18 = r17.N1();
        if (r18 == null) goto L16;
        String r19 = r18.getId();
        if (r19 == null) goto L16;
        Long r2 = StringsKt.toLongOrNull(r19);
    L17:
        Fragment r110 = r12.getFragment();
        if ((r110 instanceof zhb.a) == false) goto L20;
        r1 = (zhb.a) r110;
    L20:
        if (r1 == null) goto L22;
        boolean r111 = r1.Pr();
    L23:
        this.i = r111;
        BuildersKt.launch$default(this.j, Dispatchers.getIO(), null, new BackToFeedPlugin$listenNavigateToFeedPush$1(this, r2, r3, null), 2, null);
        return;
    L22:
        r111 = false;
    L16:
        r2 = null;
        goto L17
    L9:
        r17 = null;
        goto L10
    L26:
        return;
    }
}
