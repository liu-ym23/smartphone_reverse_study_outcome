package com.larus.deeplink.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.larus.platform.api.ExternalRouteEntry;
import com.larus.platform.api.q;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\u001a\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001cH&¨\u0006\u001e"}, d2 = {"Lcom/larus/deeplink/api/IDeeplinkService;", "", "handleIntent", "", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "isPushIntentUri", "", "uri", "Landroid/net/Uri;", "isFromShortcut", "isOuterUri", "isShareBotUri", "isInviteFriendUri", "deeplink", "context", "Landroid/content/Context;", "onHandleDeeplinkStartEvent", "prepareRoute", "startRoute", "Lcom/larus/platform/api/ExternalRouteSession;", "entry", "Lcom/larus/platform/api/ExternalRouteEntry;", "onHandleDeeplinkSuccEvent", "routerFromXOpen", "getDeepLinkHandleActivityClazz", "Ljava/lang/Class;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDeeplinkService {
    boolean a(Uri r1);

    boolean b(Uri r1);

    boolean c(Context r1, Uri r2);

    void d(Intent r1);

    Class<? extends Activity> e();

    boolean f(Uri r1);

    boolean g(Uri r1);

    q h(Intent r1, ExternalRouteEntry r2);

    boolean i(Context r1, Uri r2);

    void j(Uri r1);

    boolean k(Uri r1);
}
