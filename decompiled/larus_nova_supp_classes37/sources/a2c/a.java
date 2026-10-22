package a2c;

import android.content.Context;
import com.ss.android.lark.biz.core.api.IQRCodeScanResultHandler;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {
    boolean canOpenAppBrand(String r1);

    boolean canOpenAppLink(String r1, Context r2, int r3);

    List<IQRCodeScanResultHandler> getQRCodeHandlers();

    List<IQRCodeScanResultHandler> getQRCodeInterceptHandlers();

    boolean isFeatureGatingEnable(String r1);

    boolean isInMeeting();

    boolean isMatchUrl(String r1);

    void openInviteExternalPage(Context r1, String r2, boolean r3);

    void otherOpenCamera();
}
