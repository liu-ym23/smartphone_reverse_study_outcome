package com.obric.assistant.oauto;

import android.content.SharedPreferences;
import com.obric.assistant.shortcut.IObricShortCutsService;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"Lcom/obric/assistant/oauto/ObricShortCutsServiceImpl;", "Lcom/obric/assistant/shortcut/IObricShortCutsService;", "<init>", "()V", "checkIsDefaultAssistant", "", "enableAllPinnedShortcuts", "disableAllPinnedShortcuts", "removeAllDynamicShortcuts", "enableAllActivityAliases", "disableAllActivityAliases", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricShortCutsServiceImpl implements IObricShortCutsService {
    public static final List<String> a = null;
    public static final Lazy<SharedPreferences> b = null;

    public ObricShortCutsServiceImpl() {
    }

    static {
        new a();
        a = CollectionsKt.listOf(new String[]{"com.obric.miniapp.view.CalendarMiniAppActivityLauncher", "com.obric.autoaction.app.launcherpage.LauncherPageActivityForLauncher", "com.obric.memorydata.plugin_api.stub.activity.StartupActivity", "com.obric.memorydata.plugin_api.stub.activity.AutoMemoryShortcutActivity"});
        b = LazyKt.lazy(new g());
    }

    public final void a() {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ObricShortCutsServiceImpl$checkIsDefaultAssistant$1(this, null), 2, null);
    }
}
