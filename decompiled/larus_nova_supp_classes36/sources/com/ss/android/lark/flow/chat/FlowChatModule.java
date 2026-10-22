package com.ss.android.lark.flow.chat;

import a2b.f;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatBundleInput;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils;
import com.ss.android.lark.chat.utils.o1;
import com.ss.android.lark.chatwindow.launcher.c;
import com.ss.android.lark.flow.group.page.FlowQRCodeGroupCardActivity$onCreate$1$onJoinGroupButtonClick$1$joinGroupChatSuccess$1;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.f0;
import dagger.hilt.android.EntryPointAccessors;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import whb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatModule {
    public static final /* synthetic */ int d = 0;
    public final c a;

    @Inject
    public uza.a b;
    public final Lazy c;

    public static final class a {
        public static FlowChatModule a() {
            return ((b) EntryPointAccessors.fromApplication(LarkContext.getApplication(), b.class)).k();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/flow/chat/FlowChatModule$FlowChatModuleEntryPoint;", "", "flowChatModule", "Lcom/ss/android/lark/flow/chat/FlowChatModule;", "getFlowChatModule", "()Lcom/ss/android/lark/flow/chat/FlowChatModule;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public interface b {
        FlowChatModule k();
    }

    static {
    }

    public final egb.b a() {
        return (egb.b) this.c.getValue();
    }

    @Inject
    public FlowChatModule(c r2) {
        Intrinsics.checkNotNullParameter(r2, "chatLauncherV2");
        this.a = r2;
        this.c = LazyKt.lazy(FlowChatModule$dependency$2.INSTANCE);
    }

    public static boolean c(String r3) {
        if (r3 == null) goto L12;
        gza.b r1 = OfficeSDKManager.getHostGlobalService(gza.b.class);
        if (r1 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L12;
        return true;
    L7:
        if (r1.k0(r3) != true) goto L9;
        r4 = true;
    L12:
        return false;
    }

    public static void g(Context r1, l1 r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "bundle");
        KeyboardUtils.hideKeyboard(r1);
        if (r2.B == true) goto L5;
    L7:
        d.a(r1, r2);
        return;
    L5:
        if (c(r2.a) == false) goto L7;
    }

    public final void e(Context r3, ChatBundle r4, IGetDataCallback<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "chatBundle");
        KeyboardUtils.hideKeyboard(r3);
        if (r4.G == true) goto L5;
    L7:
        c r0 = this.a;
        int r1 = ChatBundleInput.j;
        r0.U7(r3, null, ChatBundleInput.Companion.a(r4), r5);
        return;
    L5:
        if (c(r4.a) == false) goto L7;
    }

    public final void f(Context r3, String r4, FlowQRCodeGroupCardActivity$onCreate$1$onJoinGroupButtonClick$1$joinGroupChatSuccess$1 r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "chatId");
        KeyboardUtils.hideKeyboard(r3);
        this.a.U7(r3, null, com.ss.android.lark.biz.im.api.bundle.v2.base.input.a.a(r4), r5);
    }

    public final void d(Context r3, Fragment r4, ChatBundle r5, IGetDataCallback<Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "chatBundle");
        KeyboardUtils.hideKeyboard(r3);
        c r0 = this.a;
        int r1 = ChatBundleInput.j;
        r0.U7(r3, r4, ChatBundleInput.Companion.a(r5), r6);
    }

    public static void b(String r16, String r17, SyncDataStrategy r18, ChatHitPointExtraParams.UrlAnalysisScene r19, Long r20, hpc.a r21) {
        Intrinsics.checkNotNullParameter(r18, "syncDataStrategy");
        Intrinsics.checkNotNullParameter(r21, "callBack");
        f r9 = ChatAppContainerV1.a.P();
        int r1 = UserStatusParseUrlPreViewUtils.a;
        Intrinsics.checkNotNullParameter(r9, "previewService");
        Intrinsics.checkNotNullParameter(r18, "syncDataStrategy");
        Intrinsics.checkNotNullParameter(r21, "callback");
        boolean r2 = true;
        if (r17 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        Log.i("[URLPreview]UserStatusParseUtils", "userID is null, abnormal data ");
        return;
    L11:
        if (r16 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
    L35:
        Log.i("[URLPreview]UserStatusParseUtils", "personal sign is null or not contains http,request return");
        f0 r3 = f0.a.a;
        String r0 = r17 + UrlPreViewEntries.UrlPreViewSourceType.PERSONAL_SIG.getValue();
        monitor-enter(r3);
    L44:
        th = move-exception;
        throw th;
    L38:
        if (r0.isEmpty() == false) goto L41;
        monitor-exit(r3);
        return;
    L41:
        RecogniseSpansResult r6 = (RecogniseSpansResult) r3.a.remove(Integer.valueOf(r0.hashCode()));     // Catch: Throwable -> L44
        monitor-exit(r3);
        return;
    L19:
        if (StringsKt.contains$default(r16, TrafficMetrics.FROM_HTTP, false, 2, null) == false) goto L35;
        long r7 = System.currentTimeMillis();
        ConcurrentHashMap r10 = o1.a;
        o1.d(r17, Long.valueOf(r7));
        String r8 = new String(w28.a.a(x28.a.a(r16)));
        if (r20 != null) goto L24;
    L26:
        r2 = false;
    L27:
        if (r2 == false) goto L29;
        UrlPreViewEntries.UrlPreViewSourceType r11 = UrlPreViewEntries.UrlPreViewSourceType.PRIVATE_DESCRIPTION;
    L30:
        UrlPreViewEntries.UrlPreViewSourceType r12 = r11;
        if (r2 == false) goto L33;
        List r13 = CollectionsKt.listOf(r20);
    L34:
        r9.r4(CollectionsKt.listOf(r17), CollectionsKt.listOf(r8), r18, r12, r13, new UIGetDataCallback(new UserStatusParseUrlPreViewUtils.getRecogniseSpansResult.1(r16, r17, r8, r20, r19, r21)));
        return;
    L33:
        r13 = null;
        goto L34
    L29:
        r11 = UrlPreViewEntries.UrlPreViewSourceType.PERSONAL_SIG;
        goto L30
    L24:
        if (r20.longValue() <= 0) goto L26;
    L13:
        if (r16.length() == 0) goto L16;
        r5 = false;
        goto L17
    L5:
        if (r17.length() == 0) goto L8;
        r4 = false;
        goto L9
    }
}
