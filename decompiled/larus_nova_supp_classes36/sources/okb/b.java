package okb;

import android.app.Activity;
import com.bytedance.lark.pb.basic.v1.Chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b extends ikb.b {
    boolean a();

    boolean b(String r1);

    int getUnifiedStorageLimitErrorCode();

    boolean isCalendarAbbrHighlightEnabled(String r1, Chat r2);

    boolean isFeatureGatingEnable(String r1);

    boolean isHitStorageQuotaLimit(int r1);

    boolean isInterceptSendCallback(int r1);

    boolean showQuotaLimitDialog(Activity r1, int r2);

    void showUnifiedStorageLimitCTADialog(Activity r1);
}
