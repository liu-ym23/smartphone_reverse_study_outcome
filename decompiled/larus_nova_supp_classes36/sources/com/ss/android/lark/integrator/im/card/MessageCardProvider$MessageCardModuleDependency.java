package com.ss.android.lark.integrator.im.card;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.basic.v1.RichText;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.MsgBubbleUtil;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.im.base.ImBaseBizModule;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.parser.internal.z;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.usersetting.service.e;
import com.ss.android.lark.usersetting.service.timeformat.TimeFormatSetting;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import omb.c;
import omb.d;
import org.json.JSONObject;
import u2b.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(hrb.a.class)
public class MessageCardProvider$MessageCardModuleDependency implements hrb.a {

    public class a implements hrb.a.b {
        public a() {
        }
    }

    public class b implements hrb.a.InterfaceC0276a {
        public b() {
        }
    }

    public MessageCardProvider$MessageCardModuleDependency() {
    }

    public static /* synthetic */ Pair a(String r0, String r1) {
        return lambda$startContactsProfileActivityByChatterId$0(r0, r1);
    }

    public static /* synthetic */ void b(Context r0, String r1, String r2, Pair r3) {
        lambda$startContactsProfileActivityByChatterId$1(r0, r1, r2, r3);
    }

    @Override // hrb.a
    public void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
    }

    public hrb.a.InterfaceC0276a getChatDependency() {
        return new b();
    }

    public hrb.a.b getDocDependency() {
        return new a();
    }

    @Override // hrb.a
    public String getLoginTenantId() {
        User r0 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.getTenantId() != null) goto L8;
        return "";
    L8:
        return r0.getTenantId();
    }

    @Override // hrb.a
    public String getLoginUserId() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
    }

    @Override // hrb.a
    public boolean is12HourClock() {
        if (e.a.a.f().getTimeFormat() != TimeFormatSetting.TimeFormat.TWELVE_HOUR) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // hrb.a
    public Context getContext() {
        return LarkContext.getApplication();
    }

    @Override // hrb.a
    public Locale getLanguageSetting() {
        yob.e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        return com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting();
    }

    public boolean isStagingEnv() {
        if (nmb.a.a().getEnvDependency().envType() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // hrb.a
    public RichTextElement.AtProperty getAtProperty(com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty r1) throws Exception {
        return z.b(r1);
    }

    @Override // hrb.a
    public int getChatThreadLynxCardMessageWidth(Integer r3) {
        Context r0 = getContext();
        int r1 = j.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        return j.n(r0, r3) - (j.f * 2);
    }

    @Override // hrb.a
    public String getDynamicDomain(String r2) {
        return jcb.b.c().a(r2);
    }

    @Override // hrb.a
    public boolean getFgValue(String r2) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2);
    }

    @Override // hrb.a
    public RichTextElement.ImageProperty getImageProperty(com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty r1) throws Exception {
        return z.j(r1);
    }

    @Override // hrb.a
    public int getMaxMessageWidth(int r2) {
        return j.d(getContext(), Integer.valueOf(r2));
    }

    @Override // hrb.a
    public RichText parsePbFromRichText(com.ss.android.lark.widget.richtext.RichText r1) {
        return g0.d(r1);
    }

    @Override // hrb.a
    public com.ss.android.lark.widget.richtext.RichText parseRichTextFromPb(RichText r2) {
        return g0.e(r2, null);
    }

    private static Pair lambda$startContactsProfileActivityByChatterId$0(String r2, String r3) {
        Chatter r4 = ImSdkService.d().ue(r2);
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.isBot() == false) goto L8;
        return null;
    L8:
        return new Pair(r4, ChatService.c.a.getChatById(r3));
    }

    @Override // hrb.a
    public boolean getFgValue(String r2, boolean r3) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2, r3);
    }

    @Override // hrb.a
    public int getLynxCardMessageWidth(boolean r5, Integer r6) {
        Context r0 = getContext();
        int r1 = j.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        int r2 = zz7.b.g(r0, 32);
        int r3 = UIHelper.dp2px(32.0f);
        int r4 = j.a + (r2 - r3);
        int r7 = (((j.n(r0, r6) - r4) - j.d) - zz7.b.g(r0, j.b)) - j.c;
        if (r5 == false) goto L5;
        int r8 = j.e * 2;
    L7:
        return r7 - r8;
    L5:
        r8 = 0;
        goto L7
    }

    @Override // hrb.a
    public int getThreadDetailLynxCardMessageWidth(boolean r3, Integer r4) {
        Context r0 = getContext();
        int r1 = j.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        if (r3 == false) goto L6;
        return (j.n(r0, r4) - j.i) - j.h;
    L6:
        return j.m(r0, true, null);
    }

    @Override // hrb.a
    public int getThreadLynxCardMessageWidth(boolean r2, Integer r3) {
        return j.m(getContext(), r2, r3);
    }

    @Override // hrb.a
    public com.ss.android.lark.widget.richtext.RichText parseRichTextFromPbWithStyleMerge(RichText r1, HashMap r2) {
        return g0.e(r1, r2);
    }

    @Override // hrb.a
    public void setBgForCustomHeader(View r7, View r8, int[] r9) {
        int r0 = MsgBubbleUtil.a;
        Intrinsics.checkNotNullParameter(r7, "view");
        MsgBubbleUtil.c(r7, 13, r8, 0, r9, false);
    }

    public void startContactsProfileActivityByChatterId(final Context r3, final String r4, final String r5) {
        RxScheduledExecutor.execInIO(new c(r4, r5), new d(r3, r4, r5));
    }

    private static void lambda$startContactsProfileActivityByChatterId$1(Context r0, String r1, String r2, Pair r3) {
        if (r3 != null) goto L5;
        nmb.a.a().getCoreDependency().i();
        return;
    L5:
        Chatter r4 = (Chatter) r3.first;
        Chat r5 = (Chat) r3.second;
        pmb.d r6 = nmb.a.a().getCoreDependency();
        r4.getType();
        ContactSource.a r7 = new ContactSource.a();
        r7.b = 2;
        if (r5 == null) goto L8;
        String r8 = r5.getName();
    L9:
        r7.c = r8;
        new ContactSource(r7);
        r6.d();
        return;
    L8:
        r8 = null;
        goto L9
    }

    @Override // hrb.a
    public void openUrl(Context r7, String r8, boolean r9, boolean r10, Boolean r11, String r12) {
        if (r10 == false) goto L4;
        int r3 = 12;
    L14:
        if (r10 == false) goto L17;
        int r13 = IImBrowserService.SCENE_MESSAGE_CARD_FOOTER_LINK;
    L20:
        Bundle r4 = new Bundle();
        r4.putInt(IImBrowserService.KEY_WEB_SCENE, r13);
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).sendLinkClickEvent(IImBrowserService.LINK_SCENE_MESSENGER, IImBrowserService.LINK_LOCATION_MESSAGE_CARD);
        Map<String, String> r5 = ((ImBaseBizModule) ImBaseBizModule.c.getValue()).b.d();
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).openUrl(r7, r8, r3, r4, r5);
        owa.a.a().b(r8);
        owa.a.a().a(r12, r8);
        return;
    L17:
        if (r11.booleanValue() == false) goto L19;
        r13 = IImBrowserService.SCENE_FROM_CARD_LINK_GROUP;
        goto L20
    L19:
        r13 = IImBrowserService.SCENE_FROM_CARD_LINK_SINGLE;
        goto L20
    L4:
        if (r9 == false) goto L10;
        if (r11.booleanValue() == false) goto L8;
        int r14 = 11;
    L13:
        r3 = r14;
        goto L14
    L8:
        r14 = 10;
        goto L13
    L10:
        if (r11.booleanValue() == false) goto L12;
        r14 = 9;
        goto L13
    L12:
        r14 = 8;
        goto L13
    }

    @Override // hrb.a
    public void pickGroupMember(Activity r9, String r10, List<String> r11, boolean r12, String r13, IGetDataCallback<List<ChatChatter>> r14) {
        nmb.a.a().getChatMemberPickerDependency().pickGroupMember(r9, r10, r11, r12, r13, r14);
    }

    @Override // hrb.a
    public void pickTargetMember(Activity r9, List<String> r10, List<String> r11, boolean r12, String r13, IGetDataCallback<List<ChatChatter>> r14) {
        nmb.a.a().getChatMemberPickerDependency().pickTargetMember(r9, r10, r11, r12, r13, r14);
    }

    public void showAvatarInImageView(Context r2, String r3, String r4, ImageView r5, int r6, int r7) {
        LoadParams r0 = new LoadParams();
        r0.a = r6;
        r0.b = r7;
        ImageModule.a(r2, r5, r3, r4, r0);
    }
}
