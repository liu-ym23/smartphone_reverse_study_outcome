package com.larus.bmhome.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.auth.LandingConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/utils/LaunchLandingConfigHelper;", "Lcom/larus/bmhome/utils/ILaunchLandingConfigHelper;", "<init>", "()V", "landingConfig", "Lcom/larus/bmhome/auth/LandingConfig;", "getLandingConfig", "setLandingConfig", "", "config", "findOrCreateConversationByBot", "Lcom/larus/bmhome/utils/SimpleConvInfo;", "botId", "", "conversationInfo", "Lcom/larus/network/http/Async;", "Lcom/larus/im/bean/conversation/Conversation;", "(Ljava/lang/String;Lcom/larus/network/http/Async;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIsFromUgArguments", "", "arguments", "Landroid/os/Bundle;", "sendLandingSchemaEvent", "schema", "stage", "tryHandleLaunchLandingScheme", "context", "Landroid/content/Context;", "handleDiscoveryLandingScheme", "landingScheme", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LaunchLandingConfigHelper implements ILaunchLandingConfigHelper {
    public LandingConfig a;

    public LaunchLandingConfigHelper() {
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final LandingConfig b() {
        return this.a;
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final void a(Context r15) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("tryHandleLaunchLandingScheme : ");
        LaunchLandingConfigHelperDelegate r2 = LaunchLandingConfigHelperDelegate.b;
        LandingConfig r3 = r2.b();
        if (r3 == null) goto L5;
        String r4 = r3.a();
    L6:
        r1.append(r4);
        r0.d("BotUtils", r1.toString());
        LandingConfig r5 = r2.b();
        if (r5 == null) goto L33;
        String r8 = r5.a();
        if (r8 != null) goto L12;
        return;
    L12:
        if (r8.length() != 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
        return;
    L17:
        f(r8, "receive");
        if (StringsKt.contains$default(r8, "conversation_list", false, 2, null) == false) goto L21;
        LandingRedBadgeHelperDelegate.b.a();
        f(r8, "success");
    L31:
        r0.d("BotUtils", "ConversationPageFragment set landing null ！");
        r2.e(null);
        return;
    L21:
        if (StringsKt.contains$default(r8, "discovery", false, 2, null) == false) goto L26;
        LandingRedBadgeHelperDelegate.b.a();
        Uri.Builder r7 = UriProtector.parse("sslocal://flow/home").buildUpon();
        r7.appendQueryParameter("is_from_ug", "true").appendQueryParameter("select_tab", "bot_discovery");
        if (FeatureKitDelegate.b.o0().b() == false) goto L25;
        r7.appendQueryParameter("tag", UriProtector.getQueryParameter(UriProtector.parse(r8), "tag"));
    L25:
        i r16 = SmartRouter.buildRoute(r15, r7.build().toString());
        r16.d = 2130772399;
        r16.e = 2130772399;
        r16.d();
        r0.d("BotUtils", "tryHandleLaunchLandingScheme discover");
        f(r8, "success");
        goto L31
    L26:
        String r9 = UriProtector.getQueryParameter(UriProtector.parse(r8), "bot_id");
        if (r9 != null) goto L30;
        i r17 = SmartRouter.buildRoute(r15, r8);
        r17.d = 2130772401;
        r17.e = 2130772399;
        r17.d();
        return;
    L30:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new LaunchLandingConfigHelper$tryHandleLaunchLandingScheme$1(r9, this, r8, r15, null), 2, null);
        goto L31
    L14:
        r6 = false;
        goto L15
    L33:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final boolean c(Bundle r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return r2.getBoolean("is_from_ug");
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final void e(LandingConfig r1) {
        this.a = r1;
    }

    public static void f(String r3, String r4) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;
        JSONObject r2 = new JSONObject();
        r2.put("schema", r3);
        r2.put("stage", r4);
        Unit r5 = Unit.INSTANCE;
        r1.reportEvent("rd_landing_schema_event", r2);
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final Object d(String r4, Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LaunchLandingConfigHelper$findOrCreateConversationByBot$2(r4, null), r5);
    }
}
