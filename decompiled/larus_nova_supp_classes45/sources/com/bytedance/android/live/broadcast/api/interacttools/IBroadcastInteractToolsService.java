package com.bytedance.android.live.broadcast.api.interacttools;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 '2\u00020\u0001:\u0001(J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J<\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\fH&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H&J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000eH&J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH&J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001dH&J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H&J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\bH&J\u0012\u0010$\u001a\u0004\u0018\u00010 2\u0006\u0010\n\u001a\u00020\bH&J\n\u0010&\u001a\u0004\u0018\u00010%H&¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/interacttools/IBroadcastInteractToolsService;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/bytedance/android/live/broadcast/api/interacttools/IInteractPluginWidget;", "getInteractPluginWidget", "", "schema", "pluginId", "challengeId", "", "pramas", "", "openPluginMiniApp", "", "getRunningInteractToolsIds", "", "getRunningInteractPlugins", "Landroid/view/View;", "cardView", "", "createInteractPluginCard", "exitMiniApp", "closeInteractPluginCard", "closeAllInteractPlugin", "showInteractPluginCard", "hideInteractPluginCard", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getInteractToolPerformanceWidgetClass", "La00/a;", "info", "putInteractToolsMobInfo", "removeInteractToolsMobInfo", "getInteractToolsMobInfo", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "getInteractToolsServiceWidget", "Companion", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBroadcastInteractToolsService {
    public static final a Companion = null;
    public static final String TAG = "InteractToolsService";

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    boolean closeAllInteractPlugin(boolean r1);

    boolean closeInteractPluginCard(String r1, boolean r2);

    void createInteractPluginCard(String r1, View r2);

    IInteractPluginWidget getInteractPluginWidget(Fragment r1, FragmentManager r2);

    Class<? extends Widget> getInteractToolPerformanceWidgetClass();

    a00.a getInteractToolsMobInfo(String r1);

    LiveWidget getInteractToolsServiceWidget();

    Set<String> getRunningInteractPlugins();

    List<String> getRunningInteractToolsIds();

    void hideInteractPluginCard(String r1);

    boolean openPluginMiniApp(String r1, String r2, String r3, Map<String, String> r4);

    void putInteractToolsMobInfo(String r1, a00.a r2);

    void removeInteractToolsMobInfo(String r1);

    boolean showInteractPluginCard(String r1);
}
