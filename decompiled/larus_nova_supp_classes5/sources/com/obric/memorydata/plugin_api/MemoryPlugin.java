package com.obric.memorydata.plugin_api;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assist.service.MemoryAccessibilityService;
import com.obric.lifelog.data.LifelogContentProvider_Stub;
import com.obric.memorydata.CapabilityHandleService;
import com.obric.memorydata.awareness.ContextAwarenessService_Stub;
import com.obric.memorydata.awareness.MemoryDataAwarenessProvider_Stub;
import com.obric.memorydata.memory.provider.AILabProvider_Stub;
import com.obric.memorydata.memory.provider.MemoryProvider_Stub;
import com.obric.memorydata.personalcontext.GlobalSearchService_Stub;
import com.obric.memorydata.personalcontext.InAppSearchService_Stub;
import com.obric.memorydata.plugin_api.stub.activity.AILabActivity;
import com.obric.memorydata.plugin_api.stub.activity.ContextAwarenessSettingsActivity;
import com.obric.memorydata.plugin_api.stub.activity.MemorySettingsActivity;
import com.obric.memorydata.plugin_api.stub.activity.MemoryShareActivity;
import com.obric.memorydata.plugin_api.stub.activity.RecommendMemoryListActivity;
import com.obric.memorydata.plugin_api.stub.activity.ScreenObservationDisableDialogActivity;
import com.obric.memorydata.plugin_api.stub.activity.ScreenObservationSettingsActivity;
import com.obric.memorydata.plugin_api.stub.activity.SmartMemorySettingsActivity;
import com.obric.memorydata.plugin_api.stub.provider.EntityProvider_Stub;
import com.obric.memorydata.plugin_api.stub.receiver.AILabPackageInstallReceiver;
import com.obric.memorydata.plugin_api.stub.receiver.VendorGeoCallbackBroadcast;
import com.obric.memorydata.screencapture.service.ScreenCaptureService_Stub;
import com.obric.memorydata.sdk.server.MemoryDataService_Stub;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lka.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class MemoryPlugin {
    private static final String[] EXPORTED_COMPONENTS = null;
    private static final String MEMORY_COMMON_URI = "content://com.obric.memorydata.provider.MemoryCommonProvider";
    private static final Set<String> ONLY_EXECUTE_ON_DISABLE_COMPONENTS = null;
    public static final String PLUGIN_PKG_NAME = "com.obric.memorydata.plugin";
    public static a api;

    public MemoryPlugin() {
    }

    static {
        ONLY_EXECUTE_ON_DISABLE_COMPONENTS = Collections.unmodifiableSet(new HashSet());
        EXPORTED_COMPONENTS = new String[]{VendorGeoCallbackBroadcast.class.getName(), AILabPackageInstallReceiver.class.getName(), MemorySettingsActivity.class.getName(), ContextAwarenessSettingsActivity.class.getName(), MemoryShareActivity.class.getName(), AILabActivity.class.getName(), SmartMemorySettingsActivity.class.getName(), RecommendMemoryListActivity.class.getName(), ScreenObservationSettingsActivity.class.getName(), ScreenObservationDisableDialogActivity.class.getName(), InAppSearchService_Stub.class.getName(), ContextAwarenessService_Stub.class.getName(), ScreenCaptureService_Stub.class.getName(), MemoryDataService_Stub.class.getName(), CapabilityHandleService.class.getName(), EntityProvider_Stub.class.getName(), MemoryProvider_Stub.class.getName(), MemoryDataAwarenessProvider_Stub.class.getName(), LifelogContentProvider_Stub.class.getName(), AILabProvider_Stub.class.getName(), MemoryAccessibilityService.class.getName(), GlobalSearchService_Stub.class.getName(), "com.obric.memorydata.plugin_api.stub.activity.DebugMainActivity", "com.obric.memorydata.plugin_api.stub.service.AdbService"};
    }

    public static void disable(Context r1) {
        setComponentEnabled(r1, false);
    }

    public static void enable(Context r1) {
        setComponentEnabled(r1, true);
    }

    private static void setComponentEnabled(Context r6, boolean r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        PackageManager r0 = r6.getPackageManager();
        String r8 = r6.getPackageName();
        if (r7 == false) goto L7;
        int r2 = 1;
    L8:
        LinkedHashSet r3 = new LinkedHashSet();
        Collections.addAll(r3, EXPORTED_COMPONENTS);
        if (r7 == true) goto L11;
        r3.addAll(ONLY_EXECUTE_ON_DISABLE_COMPONENTS);
    L11:
        Iterator r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L23;
        String r5 = (String) r4.next();
        if (r7 == false) goto L24;
        if (ONLY_EXECUTE_ON_DISABLE_COMPONENTS.contains(r5) == true) goto L13;
    L24:
        r0.setComponentEnabledSetting(new ComponentName(r8, r5), r2, 1);     // Catch: Throwable -> L22
        goto L13
    L23:
        return;
    L7:
        r2 = 2;
        goto L8
    }

    public List<File> getALogFiles(Context r6, long r7, long r9) {
        ArrayList r0 = new ArrayList();
        Uri r1 = UriProtector.parse(MEMORY_COMMON_URI);
        Bundle r3 = new Bundle();
        r3.putLong("start_time", r7);
        r3.putLong("end_time", r9);
        Bundle r8 = r6.getContentResolver().call(r1, "getALogFiles", null, r3);     // Catch: Exception -> L12
        if (r8 == null) goto L14;
        ArrayList<String> r10 = r8.getStringArrayList("alog_files_path");     // Catch: Exception -> L12
        if (r10 == null) goto L14;
        Iterator<String> r11 = r10.iterator();     // Catch: Exception -> L12
    L9:
        if (r11.hasNext() == false) goto L14;
        r0.add(new PolarisFileWrapper(r11.next()));     // Catch: Exception -> L12
    L14:
        return r0;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
