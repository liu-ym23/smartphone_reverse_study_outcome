package com.ss.android.lark.money_export;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.chat.api.IChatterParser;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IMoneyModuleDependency {

    public interface IAuditDependency {
        int getLoginUserAuthorityDeniedCode();

        int getOtherUserAuthorityDeniedCode();

        String getUserAuthorityControledTip();

        void onUserAuthorityDenied(Context r1, String r2);
    }

    public interface IChatDependency {
        IChatParser getChatParser();

        IChatterParser getChatterParser();

        String getDisplayNameByName(Chatter r1);

        Chatter getLoginChatter();

        void getLoginChatter(IGetDataCallback<Chatter> r1);

        boolean isGooglePlay();

        boolean isOverseaTenant();
    }

    public interface IContactDependency {
        void showApplyCollabDialog(Context r1, String r2, String r3, String r4, IDialogCallback r5);
    }

    public interface IDialogCallback {
        void onCancel();

        void onConfirm(boolean r1, String r2);

        void onDismiss();
    }

    public interface IDynamicConfigDependency {
        String getDomain();
    }

    public interface IFeatureGatingDependency {
        boolean isEnable(String r1);

        boolean isEnable(String r1, boolean r2);
    }

    public interface IGroupMemberManageDependency {
        List<SelectChatterDTO> getSelectedMemberFromIntent(Intent r1);

        void selectDesignatedRedPacketReceiver(Activity r1, Fragment r2, String r3, List<String> r4, int r5);
    }

    public interface IImageDependency {
        void loadAvatarImage(Context r1, String r2, String r3, ImageView r4, int r5, int r6);
    }

    public interface ILanguageDependency {
        Locale getCacheLanguageSetting();

        Locale getLanguageSetting();
    }

    public interface ILoginDependency {
        String getLoginUserId();

        boolean isPrimaryHost();
    }

    public interface IMoneyDependency {
        void onWebViewCreate(WebView r1);
    }

    public interface a {
    }

    public interface b {
    }

    a getAppConfigDependency();

    String getAppId();

    IAuditDependency getAuditDependency();

    b getBrowserDependency();

    String getCaijingHost();

    IChatDependency getChatDependency();

    IContactDependency getContactDependency();

    Context getContext();

    String getDeviceId();

    IDynamicConfigDependency getDynamicConfigDependency();

    IFeatureGatingDependency getFeatureGatingDependency();

    IGroupMemberManageDependency getGroupMemberManageDependency();

    IImageDependency getImageDependency();

    String getInstallId();

    ILanguageDependency getLanguageDependency();

    ILoginDependency getLoginDependency();

    IMoneyDependency getMoneyDependency();

    String getUserId();

    void initBytecertSdk();

    void initDefaultNetworkClient();

    boolean isBoe();

    boolean isTtp();

    void openBulletSchema(Context r1, String r2);
}
