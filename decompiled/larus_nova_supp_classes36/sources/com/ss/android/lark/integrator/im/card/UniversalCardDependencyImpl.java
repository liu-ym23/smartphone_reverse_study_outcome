package com.ss.android.lark.integrator.im.card;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v1.MGetChattersRequest;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.api.service.impl.p0;
import com.ss.android.lark.chat.api.service.impl.q0;
import com.ss.android.lark.chat.api.service.impl.r0;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.z0;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.im.base.ImBaseBizModule;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.usersetting.service.e;
import com.ss.android.lark.usersetting.service.timeformat.TimeFormatSetting;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import jcb.b;
import omb.f;
import org.json.JSONObject;
import wy7.c;
import yy7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(a.class)
public class UniversalCardDependencyImpl implements a {
    private static final String DOC_SOURCE_FROM_QUERY_MESSAGE_CARD = "message_card";
    private static final String TAG = "UniversalCardDependencyImpl";

    public UniversalCardDependencyImpl() {
    }

    public static /* synthetic */ void a(String r0) {
        lambda$startContactsProfileActivityByChatterId$0(r0);
    }

    public void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
    }

    public a.a getAccountInfo() {
        return new a.a(nmb.a.a().getPassportDependency().getDeviceId(), nmb.a.a().getPassportDependency().getTenantId(), nmb.a.a().getPassportDependency().getTenantBrand(), nmb.a.a().getPassportDependency().isFeishuBrand(), nmb.a.a().getPassportDependency().isChinaMainlandGeo(), nmb.a.a().getPassportDependency().getUserId(), nmb.a.a().getPassportDependency().b());
    L5:
        return new a.a("", getLoginTenantId(), "", false, false, getLoginUserId(), "");
    }

    public boolean is12HourClock() {
        if (e.a.a.f().getTimeFormat() != TimeFormatSetting.TimeFormat.TWELVE_HOUR) goto L5;
        return true;
    L5:
        return false;
    }

    public Context getContext() {
        return LarkContext.getApplication();
    }

    public Locale getLanguageSetting() {
        yob.e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        return com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting();
    }

    public String getLoginTenantId() {
        return nmb.a.a().getPassportDependency().getTenantId();
    }

    public String getLoginUserId() {
        return nmb.a.a().getPassportDependency().getUserId();
    }

    public Long getNtpTime() {
        return Long.valueOf(nmb.a.a().getCoreDependency().a());
    }

    public String getDebugUrl() {
        return ce6.a.a;
    }

    private static /* synthetic */ void lambda$startContactsProfileActivityByChatterId$0(String r0) {
        nmb.a.a().getCoreDependency().r();
    }

    public Map<String, c> getChatterByIds(List<String> r8) {
        int r0 = r0.a.a;
        ArrayList r1 = new ArrayList(r8);
        if (CollectionUtils.isEmpty(r1) == false) goto L5;
        Map r2 = new HashMap();
    L8:
        r1.removeAll(r2.keySet());
        if (r1.isEmpty() == true) goto L15;
        z0.a();
        Map r3 = (Map) SdkSender.sendRequest(Command.MGET_CHATTERS, new MGetChattersRequest.Builder().chatter_ids(r1), new q0());
        if (r3 == null) goto L15;
        r2.putAll(r3);
    L15:
        HashMap r4 = new HashMap();
        Iterator r5 = r2.keySet().iterator();
    L17:
        if (r5.hasNext() == false) goto L25;
        String r6 = (String) r5.next();
        if (TextUtils.isEmpty(r6) == true) goto L17;
        if (r8.contains(r6) == false) goto L17;
        Chatter r7 = (Chatter) r2.get(r6);
        if (r7 == null) goto L17;
        r4.put(r6, new c(r7.getAvatarKey(), r7.getLocalizedName()));
        goto L17
    L25:
        return r4;
    L5:
        z0.a();
        r2 = (Map) SdkSender.syncSend(Command.MGET_CHATTERS, new MGetChattersRequest.Builder().chatter_ids(r1), new p0());
        if (r2 != null) goto L8;
        r2 = new HashMap(0);
        goto L8
    }

    public String getDynamicDomain(String r2) {
        return b.c().a(r2);
    }

    public boolean getFgValue(String r2) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2);
    }

    private HashMap<String, String> getSecLinkParams(Bundle r4, String r5) {
        HashMap<String, String> r0 = new HashMap();
        r0.put("scene", "im");     // Catch: Exception -> L5
        r0.put("location", INotificationHitPoint.NoticeType.MESSAGE);     // Catch: Exception -> L5
        r0.put("object_id", r4.getString("messageId"));     // Catch: Exception -> L5
        r0.put("object_type", "msg");     // Catch: Exception -> L5
        r0.put("group_id", r5);     // Catch: Exception -> L5
        r0.put("send_user_id", r4.getString("senderId"));     // Catch: Exception -> L5
        r0.put("send_time", String.valueOf(r4.getLong("createTime")));     // Catch: Exception -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        Log.e(TAG, "getSecLinkParams error e: ", e);
        goto L7
    }

    public void showProfile(Context r1, String r2) {
        nmb.a.a().getCoreDependency().q();
    }

    public void startContactsProfileActivityByChatterId(Context r1, final String r2, String r3) {
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new f(r2));
    }

    public void pickGroupMember(Activity r9, String r10, List<String> r11, boolean r12, String r13, IGetDataCallback<List<ChatChatter>> r14) {
        nmb.a.a().getChatMemberPickerDependency().pickGroupMember(r9, r10, r11, r12, r13, r14);
    }

    public void pickTargetMember(Activity r9, List<String> r10, List<String> r11, boolean r12, String r13, IGetDataCallback<List<ChatChatter>> r14) {
        nmb.a.a().getChatMemberPickerDependency().pickTargetMember(r9, r10, r11, r12, r13, r14);
    }

    public void showAvatarInImageView(Context r2, String r3, String r4, ImageView r5, int r6, int r7) {
        LoadParams r0 = new LoadParams();
        r0.a = r6;
        r0.b = r7;
        ImageModule.a(r2, r5, r3, r4, r0);
    }

    public void openUrl(Context r11, String r12, boolean r13, boolean r14, Boolean r15, String r16, Bundle r17) {
        if (TextUtils.isEmpty(r12) == false) goto L5;
    L14:
        if (r14 == false) goto L16;
        int r4 = 12;
    L27:
        if (r15.booleanValue() == false) goto L29;
        int r2 = IImBrowserService.SCENE_FROM_CARD_LINK_GROUP;
    L30:
        Bundle r5 = new Bundle();
        r5.putInt(IImBrowserService.KEY_WEB_SCENE, r2);
        if (r17 == null) goto L34;
        r5.putAll(r17);
        r5.putSerializable(IImBrowserService.EXTRA_SEC_LINK_PARAMS, getSecLinkParams(r17, r16));
    L34:
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).sendLinkClickEvent(IImBrowserService.LINK_SCENE_MESSENGER, IImBrowserService.LINK_LOCATION_MESSAGE_CARD);
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).openUrl(r11, r12, r4, r5, ((ImBaseBizModule) ImBaseBizModule.c.getValue()).b.d());
        owa.a.a().b(r12);
        owa.a.a().a(r16, r12);
        return;
    L29:
        r2 = IImBrowserService.SCENE_FROM_CARD_LINK_SINGLE;
        goto L30
    L16:
        if (r13 == false) goto L22;
        if (r15.booleanValue() == false) goto L20;
        int r3 = 11;
    L25:
        r4 = r3;
        goto L27
    L20:
        r3 = 10;
        goto L25
    L22:
        if (r15.booleanValue() == false) goto L24;
        r3 = 9;
        goto L25
    L24:
        r3 = 8;
        goto L25
    L5:
        if (r12.startsWith("lark://client/profile") == false) goto L14;
        String r0 = UriProtector.getQueryParameter(UriProtector.parse(r12), "uid");     // Catch: Exception -> L8
    L10:
        String r6 = r0;
        if (TextUtils.isEmpty(r6) == true) goto L38;
        IProfileLauncherV2.a.getClass();
        IProfileLauncherV2 r1 = IProfileLauncherV2.Companion.a();
        ContactSource.a r7 = new ContactSource.a();
        r7.b = 7;
        r1.openUserProfileV2(r11, null, r6, null, null, null, new ContactSource(r7), null);
        return;
    L38:
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "parse url error: " + e.getMessage());
        r0 = null;
        goto L10
    }
}
