package com.ss.android.lark.integrator.flow.chat;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.biz.im.api.extension.message.ContentListener;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.flow.chat.multi_select.ContentListenerImpl;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.integrator.flow.chat.forward.MergeForward;
import com.ss.android.lark.integrator.flow.chat.forward.MessageForward;
import com.ss.android.lark.integrator.flow.chat.forward.OneByOneForward;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.utils.LarkContext;
import egb.g;
import egb.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(egb.b.class)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/integrator/flow/chat/FlowChatDependencyImpl;", "Lcom/ss/android/lark/flow/chat/dependency/IFlowChatDependency;", "<init>", "()V", "getPerfEnterChatMonitor", "Lcom/ss/android/lark/chat/api/IPerfEnterChatMonitor;", "loginDependency", "Lcom/ss/android/lark/flow/chat/dependency/IFlowChatLoginDependency;", "getLoginDependency", "()Lcom/ss/android/lark/flow/chat/dependency/IFlowChatLoginDependency;", "feedDependency", "Lcom/ss/android/lark/flow/chat/dependency/IFlowChatFeedDependency;", "getFeedDependency", "()Lcom/ss/android/lark/flow/chat/dependency/IFlowChatFeedDependency;", "forwardDependency", "Lcom/ss/android/lark/flow/chat/dependency/IFlowChatForwardDependency;", "getForwardDependency", "()Lcom/ss/android/lark/flow/chat/dependency/IFlowChatForwardDependency;", "profileDependency", "Lcom/ss/android/lark/flow/chat/dependency/IFlowChatProfileDependency;", "getProfileDependency", "()Lcom/ss/android/lark/flow/chat/dependency/IFlowChatProfileDependency;", "guideDependency", "Lcom/ss/android/lark/flow/chat/dependency/IFlowGuideDependency;", "getGuideDependency", "()Lcom/ss/android/lark/flow/chat/dependency/IFlowGuideDependency;", "browserDependency", "Lcom/ss/android/lark/flow/chat/dependency/IFlowBrowserDependency;", "getBrowserDependency", "()Lcom/ss/android/lark/flow/chat/dependency/IFlowBrowserDependency;", "Companion", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowChatDependencyImpl implements egb.b {
    public static final a Companion = null;
    private static final String TAG = "FlowChatDependencyImpl";
    private final egb.a browserDependency;
    private final egb.c feedDependency;
    private final egb.e forwardDependency;
    private final h guideDependency;
    private final egb.f loginDependency;
    private final g profileDependency;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements egb.a {
        public b() {
        }

        @Override // egb.a
        public final String getAppLinkDomain() {
            List r0 = jcb.b.c().b("applink");
            if (r0 == null) goto L5;
            String r1 = (String) CollectionsKt.firstOrNull(r0);
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // egb.a
        public final void openUrl(Context r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "url");
            ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).sendLinkClickEvent(IImBrowserService.LINK_SCENE_MESSENGER, IImBrowserService.LINK_LOCATION_CHAT);
            ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).openUrl(r4, r5);
        }
    }

    public static final class c implements egb.e {
        public c() {
        }

        @Override // egb.e
        public final void b(Context r3, Chat r4, ArrayList r5, ContentListenerImpl r6) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "chat");
            Intrinsics.checkNotNullParameter(r5, "messageIds");
            Intrinsics.checkNotNullParameter("", "originMergeForwardId");
            OneByOneForward.a(r3, r4, r5, r6);
        }

        @Override // egb.e
        public final void a(Context r3, Chat r4, ArrayList r5, int r6, ContentListener r7) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "chat");
            Intrinsics.checkNotNullParameter(r5, "messageIds");
            Intrinsics.checkNotNullParameter("", "originMergeForwardId");
            int r0 = MergeForward.a;
            MergeForward.c(r3, r4, r5, r6, r7);
        }

        @Override // egb.e
        public final void c(Context r1, Chat r2, String r3, String r4, Fragment r5) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r3, "threadId");
            Intrinsics.checkNotNullParameter(r4, "threadOwnerChatterId");
            MergeForward.b(r1, r2, r3, r4);
        }

        @Override // egb.e
        public final void d(Context r2, int r3, Message r4, String r5, boolean r6, ContentListener r7) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, INotificationHitPoint.NoticeType.MESSAGE);
            Intrinsics.checkNotNullParameter(r5, "originMergeForwardId");
            MessageForward.a(r2, r3, r4, r5, r6, r7);
        }
    }

    public static final class d implements h {
        public d() {
        }
    }

    public static final class e implements egb.f {
        public e() {
        }

        @Override // egb.f
        public final void a(Context r2, ozb.b r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "scene");
        }

        @Override // egb.f
        public final boolean isLogin() {
            return nmb.a.a().getPassportDependency().isLogin();
        }
    }

    public static final class f implements g {
        public f() {
        }

        @Override // egb.g
        public final void a(Context r8, String r9, String r10, ContactSource r11) {
            Intrinsics.checkNotNullParameter(r8, "context");
            Intrinsics.checkNotNullParameter(r9, "userId");
            Intrinsics.checkNotNullParameter(r11, "contactSource");
            IProfileLauncherV2.a.getClass();
            IProfileLauncherV2.a.a(IProfileLauncherV2.Companion.a(), r8, r9, r10, r11, 154);
        }
    }

    static {
        Companion = new a();
    }

    @Override // egb.b
    public x1b.c getPerfEnterChatMonitor() {
        return ((okb.d) ImSdkProxy.g.getValue()).a();
    }

    public FlowChatDependencyImpl() {
        this.loginDependency = new e();
        this.feedDependency = new FlowChatDependencyImpl$feedDependency$1();
        this.forwardDependency = new c();
        this.profileDependency = new f();
        this.guideDependency = new d();
        this.browserDependency = new b();
    }

    @Override // egb.b
    public egb.a getBrowserDependency() {
        return this.browserDependency;
    }

    @Override // egb.b
    public egb.c getFeedDependency() {
        return this.feedDependency;
    }

    @Override // egb.b
    public egb.e getForwardDependency() {
        return this.forwardDependency;
    }

    public h getGuideDependency() {
        return this.guideDependency;
    }

    @Override // egb.b
    public egb.f getLoginDependency() {
        return this.loginDependency;
    }

    @Override // egb.b
    public g getProfileDependency() {
        return this.profileDependency;
    }
}
