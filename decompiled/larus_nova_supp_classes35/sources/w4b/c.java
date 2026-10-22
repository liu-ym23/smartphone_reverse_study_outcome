package w4b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Range;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.core.dependency.ChatSettingDependency;
import com.ss.android.lark.chat.core.dependency.StickerDependency;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c {

    public interface a {
    }

    public interface b {
        Dialog a(Context r1, String r2, String r3, String r4, String r5, String r6, Map<String, String> r7);
    }

    /* JADX INFO: renamed from: w4b.c$c, reason: collision with other inner class name */
    public interface InterfaceC0316c {
        UniversalUserSetting a();

        void isOn();
    }

    public interface d {
    }

    public interface e {
        l a();
    }

    public interface f {
        void a(psb.a r1);

        void b();

        void c(psb.a r1);

        void d();

        Range<Integer> e();
    }

    public interface g {
        void a(Chat r1);
    }

    public interface h {
        void a(Context r1, String r2);
    }

    public interface i {
    }

    public interface j {
        void a();

        void b(String r1, String r2, String[] r3, IGetDataCallback<List<String>> r4);
    }

    public interface k {
        boolean a(int r1);

        void isInMeeting();
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
        void isPluginInstalled(String r1);

        void isPluginLoaded(String r1);
    }

    public interface o {
        String Fc();

        String fe();

        String userId();
    }

    public static class p {
    }

    boolean canShowSingleUrlCard(y6b.a<?> r1, m2b.a r2, g3b.v r3);

    b getAiDependency();

    InterfaceC0316c getAppConfigDependency();

    w4b.a getAuditDependency();

    BrowserDependency getBrowserDependency();

    w4b.b getCcmDependency();

    w4b.g getChatDependency();

    ChatSettingDependency getChatSettingDependency();

    Context getContext();

    String getDeviceId();

    w4b.i getDingDependency();

    w4b.j getDownloadDependency();

    d getEnterpriseTopicDependency();

    w4b.d getExtensionDependency();

    w4b.k getFeatureConfigDependency();

    w4b.l getFeatureGatingDependency();

    w4b.m getFeedDependency();

    vab.b getFileDetailDependency();

    w4b.o getGroupMemberManageDependency();

    w4b.p getGuideDependency();

    i getIRecommendEventAiDependency();

    s getImageDependency();

    t getLanguageDependency();

    m getLeanModeDependency();

    u getLoginDependency();

    v getMainDependency();

    w getMergeForwardDependnecy();

    n getMiraDependency();

    x getMoneyDependency();

    e getMultiTaskDependency();

    f getMyAIDependency();

    g getOpenPlatformDependency();

    Chatter.ChatterCustomStatus getOpenedUserStatus(List<Chatter.ChatterCustomStatus> r1);

    Drawable getOpenedUserStatusSmallDrawable(Context r1, List<Chatter.ChatterCustomStatus> r2, boolean r3);

    o getPassportDependency();

    x1b.c getPerfEnterChatMonitor();

    h getPhoneDependency();

    p getProfile();

    b0 getProfileDependency();

    c0 getPushDependency();

    void getResource(Set<String> r1, String r2, String r3, String r4, IGetDataCallback<Map<String, String>> r5);

    r getSecurityComplianceDependency();

    d0 getSettingDependency();

    StickerDependency getStickerDependency();

    w4b.e getTeamDependency();

    e0 getThreadDependency();

    f0 getTimeFormatDependency();

    j getTranslateDependency();

    w4b.f getUrlPreviewDependency();

    k getVcDependency();

    g0 getWschannelDependency();

    boolean isAutoTranslateEnableViaBilling();

    boolean isHideRichTextView(y6b.a<?> r1, m2b.a r2, v4b.d r3);

    boolean isLarkPkg();

    void launchMainWindow(Context r1, String r2, Bundle r3);

    boolean openAppLinkUrl(Context r1, String r2);

    void openReadStateDetailPage(Context r1, String r2, Message.Type r3, String r4, ArrayList<String> r5, boolean r6);

    void registerSourceMessageRecalledEventListener(aqb.i r1);

    void startPhotoEditorActivityFromPreview(Context r1, Fragment r2, int r3, String r4, String r5, boolean r6, boolean r7, String r8, String r9, String r10);

    void unRegisterSourceMessageRecalledEventListener(aqb.i r1);
}
