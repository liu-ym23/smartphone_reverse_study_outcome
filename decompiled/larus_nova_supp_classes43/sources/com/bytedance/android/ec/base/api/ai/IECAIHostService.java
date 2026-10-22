package com.bytedance.android.ec.base.api.ai;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ECApiServices;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\t\bg\u0018\u0000 42\u00020\u0001:\u00015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H&J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H&J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0016H&J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010%\u001a\u00020$H\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010%\u001a\u00020$H\u0016J<\u0010/\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00182\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010-H&J\u0010\u00100\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0002H&J&\u00103\u001a\u00020\r2\u0006\u00101\u001a\u00020\u00022\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010-H&¨\u00066"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/IECAIHostService;", "", "", "pageName", "", "isChatComponentEnabled", "isAIInputDelayAttachEnabled", "Lcom/bytedance/android/ec/base/api/ai/AIChatComponentParam;", "param", "Lcom/bytedance/android/ec/base/api/ai/AIChatComponentHandle;", "createChatComponent", "Lcom/bytedance/android/ec/base/api/ai/AISnapshotRequest;", "request", "", "capture", "Landroid/view/View;", "view", "excluded", "setExcludedFromCapture", "snapshotId", "messageId", "associateSnapshot", "Lcom/bytedance/android/ec/base/api/ai/AIStateLogRequest;", "reportLog", "", "", "getHostActivityStyleRes", "Landroid/app/Activity;", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "applyHostStyle", "Lcom/bytedance/android/ec/base/api/ai/MiniAppConfig;", "getMiniAppConfig", "isInApplet", "isInAppletAnim", "isLandingPage", "isGoToLandingPage", "Landroid/content/Context;", "context", "Lcom/bytedance/android/ec/base/api/ai/framework/component/BackComponent;", "createBackComponent", "Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent;", "createCapsuleComponent", "scene", "Lcom/bytedance/android/ec/base/api/ai/framework/model/PanelItem;", "items", "", "extra", "showAppletPanel", "closeApplet", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "params", "sendAppletLog", "Companion", "a", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public interface IECAIHostService {
    public static final a Companion = null;

    /* JADX INFO: renamed from: com.bytedance.android.ec.base.api.ai.IECAIHostService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            a r0 = IECAIHostService.Companion;
        }

        @JvmStatic
        public static IECAIHostService get() {
            IECAIHostService.Companion.getClass();
            return a.a();
        }

        @JvmStatic
        public static void register(Application r1, IECAIHostService r10) {
            IECAIHostService.Companion.getClass();
            a.b(r1, r10);
        }
    }

    public static final class a {
        public static final AtomicBoolean a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = new AtomicBoolean(false);
        }

        @JvmStatic
        public static IECAIHostService a() {
            return (IECAIHostService) ECApiServices.getServiceOrDefault(IECAIHostService.class, DefaultECAIHostService.INSTANCE);
        }

        @JvmStatic
        public static void b(Application r10, IECAIHostService r11) {
            Intrinsics.checkNotNullParameter(r10, "application");
            Intrinsics.checkNotNullParameter(r11, "impl");
            ECApiServices.registerService(IECAIHostService.class, r11);
            if (a.compareAndSet(false, true) == false) goto L6;
            r10.registerActivityLifecycleCallbacks(xe.a.b);
            return;
        }
    }

    public static final class b {
        public static void a(IECAIHostService r10, Activity r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            Intrinsics.checkNotNullParameter(r12, "pageName");
            if (r10.isChatComponentEnabled(r12) == false) goto L8;
            Iterator<T> r13 = r10.getHostActivityStyleRes().iterator();
        L6:
            if (r13.hasNext() == false) goto L10;
            int r14 = ((Number) r13.next()).intValue();
            r11.getTheme().applyStyle(r14, true);
            goto L6
        L10:
            return;
        }
    }

    static {
        Companion = a.b;
    }

    void applyHostStyle(Activity r1, String r10);

    void associateSnapshot(String r1, String r10);

    void capture(AISnapshotRequest r1);

    void closeApplet(String r1);

    BackComponent createBackComponent(Context r1);

    CapsuleComponent createCapsuleComponent(Context r1);

    AIChatComponentHandle createChatComponent(AIChatComponentParam r1);

    List<Integer> getHostActivityStyleRes();

    MiniAppConfig getMiniAppConfig();

    boolean isAIInputDelayAttachEnabled(String r1);

    boolean isChatComponentEnabled(String r1);

    boolean isGoToLandingPage();

    boolean isInApplet();

    boolean isInAppletAnim();

    boolean isLandingPage();

    void reportLog(AIStateLogRequest r1);

    void sendAppletLog(String r1, Map<String, String> r10);

    void setExcludedFromCapture(View r1, boolean r10);

    void showAppletPanel(Context r1, String r10, List<PanelItem> r11, Map<String, ? extends Object> r12);
}
