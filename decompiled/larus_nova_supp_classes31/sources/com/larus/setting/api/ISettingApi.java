package com.larus.setting.api;

import android.app.Application;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.setting.api.trace.ISettingTrackApi;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&JJ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\b\u0010\u0010\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0013H&J \u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH¦@¢\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H&J\u0012\u0010\"\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J,\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\u000bH&¨\u0006*"}, d2 = {"Lcom/larus/setting/api/ISettingApi;", "", "getSettingTrackImpl", "Lcom/larus/setting/api/trace/ISettingTrackApi;", "openChangeAppIconPage", "", "context", "Landroid/content/Context;", "enterFrom", "", "iTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "localConversationId", "conversationId", "previousPage", "pendingDeeplinkSchema", "preloadAppDynamicIcons", "setEnableBackGroundUpdate", "enableBackGroundUpdate", "", "initRegisterAppBackGroundListener", "setEnableShowSynDialog", "enable", "getFindSettingsItemList", "", "Lcom/larus/setting/api/data/SettingsSection;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotifySettingItems", "isAppNotifyEnable", "application", "Landroid/app/Application;", "isAppNotifyDetailEnable", "jumpPrivacyModelTrainingPage", "bindManualCacheCleanEntry", "fragment", "Landroidx/fragment/app/Fragment;", "entryView", "Landroid/view/View;", "currentPage", "trackNode", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ISettingApi {
    List<zs9.c> a(FragmentActivity r1);

    void b(Context r1, String r2, by7.e r3, String r4, String r5, String r6, String r7);

    void c(Fragment r1, View r2, String r3, by7.e r4);

    Object d(FragmentActivity r1, Continuation<? super List<zs9.c>> r2);

    boolean e(Application r1);

    ISettingTrackApi f();

    void g();

    boolean h(Application r1);

    void i();

    void j(Context r1);

    void k();
}
