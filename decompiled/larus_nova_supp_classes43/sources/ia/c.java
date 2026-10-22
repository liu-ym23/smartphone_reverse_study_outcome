package ia;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(c r1, boolean r10) {
            r1.onVisibleChange(r10, Boolean.FALSE);
        }
    }

    @Deprecated(message = "迫不得已加的下沉接口，内部重构使用，外部千万不要使用，出了问题不负责修复")
    void bindContainerId(String r1);

    boolean canBackPress();

    boolean canGoBack();

    void close();

    void enterBackground();

    void enterForeground();

    void finish();

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function will be deleted in future")
    t36.d generateSchemaData(String r1);

    LaunchMode getBDXLaunchMode();

    String getBDXTag();

    String getBid();

    String getContainerId();

    m16.b getContextProviderFactory();

    t36.d getCurrentSchema();

    @Deprecated(message = "实现不稳定，仅容器内部使用，外部千万不要使用，出了问题不负责修复")
    String getCurrentUrl();

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function will be deleted in future")
    KitType getKitType();

    View getKitView();

    Map<String, Long> getPerfMap();

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function will be deleted in future")
    t36.d getSchemaData();

    Context getSystemContext();

    String getViewType();

    WeakReference<Context> getWeakContext();

    void goBack();

    void hideError();

    void hideLoading();

    void interceptBackPress(boolean r1);

    void loadSchema(String r1, Map<String, ? extends Object> r10);

    void onAttachToWindow();

    void onCreate(Bundle r1);

    void onEngineReady(m16.b r1);

    void onVisibleChange(boolean r1, Boolean r10);

    <T> void registerWeakHolder(Class<T> r1, T r10);

    void release();

    void reload(Map<String, ? extends Object> r1);

    void reloadTemplate(Map<String, ? extends Object> r1);

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function will be deleted in future")
    void sendEvent(com.bytedance.ies.bullet.core.kit.bridge.h r1);

    void showError();

    void showLoading(String r1);

    void updateData(Map<String, ? extends Object> r1);

    void updateGlobalProps(Map<String, ? extends Object> r1);

    void updateScreenMetrics(int r1, int r10);
}
