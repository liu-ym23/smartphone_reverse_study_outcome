package com.ss.android.lark.officesdk.api.init;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H&J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKConfigProvider;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "getAppId", "", "getHostAppVersion", "getAppName", "isDebug", "", "getEnv", "", "()Ljava/lang/Integer;", "getTTEnv", "getJournalPaths", "", "getHostAppHeaderProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;", "getRequestTagBase", "isEnableNewTtnetLogReporter", "()Ljava/lang/Boolean;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface IOfficeSDKConfigProvider extends IOfficeSDKProtocol {
    String getAppId();

    String getAppName();

    Integer getEnv();

    IOfficeSDKHostAppHeaderProvider getHostAppHeaderProvider();

    String getHostAppVersion();

    List<String> getJournalPaths();

    String getRequestTagBase();

    String getTTEnv();

    boolean isDebug();

    Boolean isEnableNewTtnetLogReporter();
}
