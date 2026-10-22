package com.larus.common.account.douyin.ai.chat;

import android.net.Uri;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.provider.IThirdPartyPlatformLoginProvider;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\t0\u0011H\u0016J0\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0014H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0005H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0012H\u0016J\u0012\u0010%\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006+"}, d2 = {"Lcom/larus/common/account/douyin/ai/chat/AiChatOpenDouyinAuthServiceImpl;", "Lcom/larus/bmhome/auth/douyin/IAiChatOpenDouyinAuthService;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "removeAiChatDouyinAuthResultHandler", "", "handler", "Lcom/larus/bmhome/auth/douyin/IAiChatDouyinAuthResultHandler;", "addAiChatDouyinAuthResultHandler", "addOnMessageNeedAuthListener", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "listener", "Lkotlin/Function1;", "Lcom/larus/im/bean/message/Message;", "showPreAskingDialog", "", "traceInfo", "Lorg/json/JSONObject;", "title", "cancel", "confirm", "callback", "Lcom/larus/bmhome/auth/douyin/IAiChatOpenDouyinAuthService$IDouyinAuthPreAskingCallback;", "handleSchema", "parse", "Landroid/net/Uri;", "ignore", "handleTraceInfo", "jumpUrl", "currentMessage", "checkIfAuthMessage", "message", "setAuthMessage", "requestAuthorizeCardMessage", "messageId", "musicPlatform", "cvsId", "botId", "douyinlogin_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiChatOpenDouyinAuthServiceImpl implements IAiChatOpenDouyinAuthService {
    public final String a;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(f r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final void g() {
        com.larus.common.account.douyin.ai.chat.a.c.postValue(null);
    }

    public final Message i() {
        com.larus.common.account.douyin.ai.chat.a r0 = com.larus.common.account.douyin.ai.chat.a.a;
        return (Message) com.larus.common.account.douyin.ai.chat.a.c.getValue();
    }

    public AiChatOpenDouyinAuthServiceImpl() {
        this.a = "AiChatOpenDouyinAuthServiceImpl";
    }

    public final void f(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        com.larus.common.account.douyin.ai.chat.a r1 = com.larus.common.account.douyin.ai.chat.a.a;
        Intrinsics.checkNotNullParameter(r3, "message");
        if (AppHost.a.isOversea() == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r3.getReplyId(), com.larus.common.account.douyin.ai.chat.a.b) == false) goto L9;
        return;
    L9:
        if (com.larus.bmhome.chat.bean.d.G(r3) == null) goto L15;
        com.larus.common.account.douyin.ai.chat.a.b = r3.getReplyId();
        com.larus.common.account.douyin.ai.chat.a.c.postValue(r3);
        return;
    }

    public final JSONObject h(String r4) {
        Intrinsics.checkNotNullParameter(r4, "jumpUrl");
        Set<String> r1 = com.larus.common.account.douyin.d.a;
        Intrinsics.checkNotNullParameter(r4, "jumpUrl");
        String r5 = UriProtector.getQueryParameter(UriProtector.parse(r4), "trace_info");     // Catch: JSONException -> L8
        if (r5 == null) goto L6;
        JSONObject r0 = new JSONObject(r5);     // Catch: JSONException -> L8
    L22:
    L10:
        if (r0.has(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD) == true) goto L13;
        r0.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "query_normal");
    L13:
        if (r0.has("scene") == true) goto L16;
        r0.put("scene", "music");
    L16:
        if (r0.has("page_type") == true) goto L19;
        r0.put("page_type", "other");
    L19:
        if (r0.has("content_type") == true) goto L21;
        r0.put("content_type", "other");
    L21:
        return r0;
    L6:
        r0 = new JSONObject();     // Catch: JSONException -> L8
    L8:
        r0 = new JSONObject();
        goto L10
    }

    public final void j(ya8.a r3) {
        com.larus.common.account.douyin.ai.chat.a r0 = com.larus.common.account.douyin.ai.chat.a.a;
        if (r3 == null) goto L19;
        LinkedList<ya8.a> r1 = com.larus.common.account.douyin.ai.chat.a.d;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (r1.contains(r3) == false) goto L11;
        monitor-exit(r1);
        return;
    L11:
        r1.add(r3);     // Catch: Throwable -> L14
        monitor-exit(r1);
        return;
    }

    public final void m(ya8.a r3) {
        com.larus.common.account.douyin.ai.chat.a r0 = com.larus.common.account.douyin.ai.chat.a.a;
        if (r3 == null) goto L18;
        LinkedList<ya8.a> r1 = com.larus.common.account.douyin.ai.chat.a.d;
        monitor-enter(r1);
        r1.remove(r3);     // Catch: Throwable -> L13
        if (r1.isEmpty() == false) goto L10;
        com.larus.common.account.douyin.ai.chat.a.c.postValue(null);     // Catch: Throwable -> L13
    L10:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r1);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.common.account.douyin.ai.chat.f] */
    public final void o(LifecycleOwner r3, final Function1<? super Message, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Transformations.distinctUntilChanged(com.larus.common.account.douyin.ai.chat.a.c).observe(r3, new a(new f(r4)));
    }

    public final void l(Uri r18, JSONObject r110, boolean r20) {
        Intrinsics.checkNotNullParameter(r18, "parse");
        Intrinsics.checkNotNullParameter(r110, "traceInfo");
        Set<String> r3 = com.larus.common.account.douyin.d.a;
        Intrinsics.checkNotNullParameter(r18, "uri");
        Intrinsics.checkNotNullParameter(r110, "traceInfo");
        if (Intrinsics.areEqual("douyinopen", UriProtector.getQueryParameter(r18, "biz")) == false) goto L63;
        String r2 = UriProtector.getQueryParameter(r18, "client_key");
        if (r2 == null) goto L64;
        FLogger.a.i("DouyinAuthCocoSchemaHandler", "handle schema: " + r18);
        IThirdPartyPlatformLoginProvider r4 = null;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r18, "advanced_mode"), "1") == false) goto L12;
        if (r20 == true) goto L12;
        com.larus.common.account.douyin.a r5 = new com.larus.common.account.douyin.a();
    L13:
        String r6 = "";
        if (Intrinsics.areEqual(r2, "aw730v27vx2bu2qw") == false) goto L24;
        r110.put("page_type", "host");
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L17:
        if (r0.hasNext() == false) goto L21;
        IThirdPartyPlatformLoginProvider r7 = (IThirdPartyPlatformLoginProvider) r0.next();
        if (r7.c() != LoginPlatform.DOUYIN) goto L17;
        r4 = r7;
    L21:
        if (r4 == null) goto L65;
        JSONObject r1 = new JSONObject(r110.toString());
        w0.f(null, "host", null, null, null, null, null, r1, 381);
        r4.z(new com.larus.common.account.douyin.b(r1, r5), "", new Bundle());
        return;
    L65:
        return;
    L24:
        String r8 = UriProtector.getQueryParameter(r18, "scope");
        if (r8 == null) goto L66;
        String r9 = UriProtector.getQueryParameter(r18, "state");
        if (r9 == null) goto L31;
        r6 = r9;
    L31:
        if (r110 != null) goto L33;
        JSONObject r10 = null;
    L35:
        if (com.larus.common.account.douyin.f.b(r2, r8, r6, new com.larus.common.account.douyin.c(r10, r5, r110)) == false) goto L62;
        if (r110 == null) goto L38;
        String r11 = r110.optString("scene");
    L39:
        if (r110 == null) goto L41;
        String r12 = r110.optString("page_type");
    L42:
        if (r110 == null) goto L44;
        String r13 = r110.optString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
    L45:
        if (r110 == null) goto L47;
        String r14 = r110.optString("action");
    L48:
        if (r110 == null) goto L50;
        String r15 = r110.optString("bot_id");
    L51:
        if (r110 == null) goto L53;
        String r16 = r110.optString("message_id");
    L54:
        if (r110 == null) goto L56;
        r4 = r110.optString("sec_enter_method");
    L56:
        w0.f(r11, r12, r13, r16, r4, r15, r14, null, 384);
        return;
    L53:
        r16 = null;
        goto L54
    L50:
        r15 = null;
        goto L51
    L47:
        r14 = null;
        goto L48
    L44:
        r13 = null;
        goto L45
    L41:
        r12 = null;
        goto L42
    L38:
        r11 = null;
        goto L39
    L62:
        return;
    L33:
        r10 = new JSONObject(r110.toString());
        goto L35
    L66:
        return;
    L12:
        r5 = null;
        goto L13
    L64:
        return;
    }

    public final void k(String r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "messageId");
        Intrinsics.checkNotNullParameter(r13, "musicPlatform");
        Intrinsics.checkNotNullParameter(r14, "cvsId");
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AiChatOpenDouyinAuthServiceImpl$requestAuthorizeCardMessage$1(this, r12, r14, r15, r13, null), 3, null);
    }

    public final boolean n(JSONObject r9, String r10, String r11, String r12, IAiChatOpenDouyinAuthService.c r13) {
        Intrinsics.checkNotNullParameter(r9, "traceInfo");
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter(r11, "cancel");
        Intrinsics.checkNotNullParameter(r12, "confirm");
        Intrinsics.checkNotNullParameter(r13, "callback");
        e r0 = e.a;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r9, "traceInfo");     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r10, "title");     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r11, "cancel");     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r12, "confirm");     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r13, "callback");     // Catch: Throwable -> L47
        if ((System.currentTimeMillis() - e.b) >= 3000) goto L9;
        monitor-exit(r0);
        return false;
    L9:
        e.b = System.currentTimeMillis();     // Catch: Throwable -> L47
        AppHost.Companion r1 = AppHost.a;     // Catch: Throwable -> L47
        if (r1.getApplication().getResources() != null) goto L13;
        monitor-exit(r0);
        return false;
    L13:
        FragmentActivity r2 = r1.a().getCurrentActivity();     // Catch: Throwable -> L47
        if ((r2 instanceof FragmentActivity) == false) goto L16;
        FragmentActivity r3 = r2;     // Catch: Throwable -> L47
    L17:
        if (r3 == null) goto L45;
        FragmentManager r4 = r3.getSupportFragmentManager();     // Catch: Throwable -> L47
        if (r4 == null) goto L45;
        WeakReference<CommonDialog> r5 = e.c;     // Catch: Throwable -> L47
        if (r5 == null) goto L28;
        CommonDialog r6 = r5.get();     // Catch: Throwable -> L47
        if (r6 == null) goto L28;
        if (r6.isVisible() != true) goto L28;
        boolean r7 = true;
    L29:
        if (r7 == false) goto L33;
        monitor-exit(r0);
        return false;
    L33:
        if (r4.isStateSaved() == false) goto L37;
        FLogger.a.e("AiChatDouyinAuthPreDialogHelper", "error: isStateSaved %{isStateSaved}");     // Catch: Throwable -> L47
        monitor-exit(r0);
        return false;
    L37:
        CommonDialog.a r8 = new CommonDialog.a();     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r10, "title");     // Catch: Throwable -> L47
        r8.a = r10;     // Catch: Throwable -> L47
        r8.b = false;     // Catch: Throwable -> L47
        CommonDialog.a.e(r8, new c(r13, r9), r11, 4);     // Catch: Throwable -> L47
        Function0<Boolean> r14 = new b();     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r14, "callback");     // Catch: Throwable -> L47
        r8.B = r14;     // Catch: Throwable -> L47
        r8.z = false;     // Catch: Throwable -> L47
        CommonDialog.a.f(r8, new d(r13, r9), r12, false, 12);     // Catch: Throwable -> L47
        CommonDialog r15 = r8.b(ContextCompat.getColor(r3, 2131103203));     // Catch: Throwable -> L47
        e.c = new WeakReference(r15);     // Catch: Throwable -> L47
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L47
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r15, null, r16);     // Catch: Throwable -> L47
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r15, r16) == false) goto L51;
    L42:
        w0.c(r9.optString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD), r9.optString("content_type"), r9.optString("scene"), r9.optString("message_id"), r9.optString("sec_enter_method"));     // Catch: Throwable -> L47
        monitor-exit(r0);
        return true;
    L51:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50 Throwable -> L47
    L41:
        r15.show(r4, null);     // Catch: Throwable -> L47
    L28:
        r7 = false;
    L45:
        monitor-exit(r0);
        return false;
    L16:
        r3 = null;
    L47:
        th = move-exception;
        throw th;
    }
}
