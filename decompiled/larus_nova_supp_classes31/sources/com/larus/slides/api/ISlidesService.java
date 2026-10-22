package com.larus.slides.api;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kw9.h;
import org.json.JSONObject;
import tc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&JS\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000e2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192#\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bH¦@¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\fH&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020#H&J\b\u0010$\u001a\u00020\u0003H&J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H&J\u000f\u0010*\u001a\u0004\u0018\u00010+H&¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\n\u0018\u00010.j\u0004\u0018\u0001`/H&¨\u00060"}, d2 = {"Lcom/larus/slides/api/ISlidesService;", "", "preloadWebViewIfNeeded", "", "initSdkIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSlides", "context", "Landroid/content/Context;", "params", "Landroid/os/Bundle;", "page", "", "tryPrefetchData", "", "openSlidesAndChat", "switchConversationParams", "Lcom/larus/bmhome/chat/resp/SwitchConversationParams;", "triggerInnerNotification", "inAppBannerNotify", "Lcom/larus/im/bean/InAppBannerNotify;", "setSlidesPermission", "slidesToken", "public", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSlidesPermission", "clearReference", "getSlidesTrackInfo", "Lorg/json/JSONObject;", "clearPPTTemplateCache", "showSlidesDownloadFragment", "fragment", "Landroidx/fragment/app/Fragment;", "downloadParams", "Lcom/larus/share/bean/SlideDownloadParams;", "getFloatChatShowPercent", "", "()Ljava/lang/Integer;", "getActionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/custom/bean/CustomActionBarItem;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ISlidesService {
    Integer A();

    Object a(Continuation<? super Unit> r1);

    void b(e r1);

    boolean c(Bundle r1);

    void clearReference();

    void d();

    JSONObject e();

    void e0();

    boolean f(String r1);

    void g(Context r1, Bundle r2, String r3);

    void h(Context r1, ni8.e r2);

    Unit i(String r1, boolean r2, Function0 r3, Function1 r4);

    void j(Fragment r1, h r2);
}
