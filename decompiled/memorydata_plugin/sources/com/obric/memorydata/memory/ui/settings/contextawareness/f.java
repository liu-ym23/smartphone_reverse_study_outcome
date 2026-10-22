package com.obric.memorydata.memory.ui.settings.contextawareness;

import android.content.Context;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import kotlin.Metadata;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\b\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H&J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0004H&J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0004H&J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H&J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H&J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H&J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H&J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H&J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsGateway;", "", "screenContentVisible", "Lkotlinx/coroutines/flow/StateFlow;", "", "getScreenContentVisible", "()Lkotlinx/coroutines/flow/StateFlow;", "screenContentEnabled", "getScreenContentEnabled", "ambientVoiceVisible", "getAmbientVoiceVisible", "ambientVoiceEnabled", "getAmbientVoiceEnabled", "cellularUploadEnabled", "getCellularUploadEnabled", "enhancedTimelinessCloudEnabled", "getEnhancedTimelinessCloudEnabled", "smartGlassesConnected", "Lkotlinx/coroutines/flow/Flow;", "getSmartGlassesConnected", "()Lkotlinx/coroutines/flow/Flow;", "readSnapshot", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsSnapshot;", "setSystemAppEnabled", "app", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSystemApp;", "enabled", "setGlobalSourceEnabled", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessGlobalSource;", "setCellularUploadEnabled", "", "setEnhancedTimelinessEnabled", "setRecorderAmbientVoiceCollectionDebugEnabled", "openScreenContentSettings", "context", "Landroid/content/Context;", "openRecorderSettings", "openSmartGlassesSettings", "openBlockMemorySettings", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface f {
    ar<Boolean> a();

    void a(Context r1);

    void a(boolean r1);

    boolean a(ContextAwarenessGlobalSource r1, boolean r2);

    boolean a(ContextAwarenessSystemApp r1, boolean r2);

    ar<Boolean> b();

    boolean b(Context r1);

    boolean b(boolean r1);

    ar<Boolean> c();

    boolean c(Context r1);

    boolean c(boolean r1);

    ar<Boolean> d();

    void d(Context r1);

    ar<Boolean> e();

    ar<Boolean> f();

    kotlinx.coroutines.flow.i<Boolean> g();

    i h();
}
