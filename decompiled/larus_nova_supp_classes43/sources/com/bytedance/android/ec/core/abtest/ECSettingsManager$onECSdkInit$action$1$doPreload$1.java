package com.bytedance.android.ec.core.abtest;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.host.api.service.IECHostService;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECSettingsManager$onECSdkInit$action$1$doPreload$1 extends Lambda implements Function0<Unit> {
    public static final ECSettingsManager$onECSdkInit$action$1$doPreload$1 INSTANCE = null;

    static {
        INSTANCE = new ECSettingsManager$onECSdkInit$action$1$doPreload$1();
    }

    public ECSettingsManager$onECSdkInit$action$1$doPreload$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1133invoke() {
        if (h.a() == true) goto L5;
        return;
    L5:
        if (h.a() == false) goto L46;
        boolean r0 = ECServiceManager.a;
        if (((IECHostService) ECServiceManager.c(IECHostService.class)).getIECHostUserService().isLogin() == false) goto L47;
        long r1 = System.currentTimeMillis();
        int r10 = 0;
        List r11 = CollectionsKt.listOf(new Function0[]{ECSettingsManager$getPreloadSettingsList$1.INSTANCE, ECSettingsManager$getPreloadSettingsList$2.INSTANCE, ECSettingsManager$getPreloadSettingsList$3.INSTANCE, ECSettingsManager$getPreloadSettingsList$4.INSTANCE, ECSettingsManager$getPreloadSettingsList$5.INSTANCE, ECSettingsManager$getPreloadSettingsList$6.INSTANCE, ECSettingsManager$getPreloadSettingsList$7.INSTANCE, ECSettingsManager$getPreloadSettingsList$8.INSTANCE, ECSettingsManager$getPreloadSettingsList$9.INSTANCE, ECSettingsManager$getPreloadSettingsList$10.INSTANCE, ECSettingsManager$getPreloadSettingsList$11.INSTANCE, ECSettingsManager$getPreloadSettingsList$12.INSTANCE, ECSettingsManager$getPreloadSettingsList$13.INSTANCE, ECSettingsManager$getPreloadSettingsList$14.INSTANCE, ECSettingsManager$getPreloadSettingsList$15.INSTANCE, ECSettingsManager$getPreloadSettingsList$16.INSTANCE, ECSettingsManager$getPreloadSettingsList$17.INSTANCE, ECSettingsManager$getPreloadSettingsList$18.INSTANCE, ECSettingsManager$getPreloadSettingsList$19.INSTANCE, ECSettingsManager$getPreloadSettingsList$20.INSTANCE, ECSettingsManager$getPreloadSettingsList$21.INSTANCE, ECSettingsManager$getPreloadSettingsList$22.INSTANCE, ECSettingsManager$getPreloadSettingsList$23.INSTANCE, ECSettingsManager$getPreloadSettingsList$24.INSTANCE, ECSettingsManager$getPreloadSettingsList$25.INSTANCE, ECSettingsManager$getPreloadSettingsList$26.INSTANCE, ECSettingsManager$getPreloadSettingsList$27.INSTANCE, ECSettingsManager$getPreloadSettingsList$28.INSTANCE, ECSettingsManager$getPreloadSettingsList$29.INSTANCE, ECSettingsManager$getPreloadSettingsList$30.INSTANCE, ECSettingsManager$getPreloadSettingsList$31.INSTANCE, ECSettingsManager$getPreloadSettingsList$32.INSTANCE, ECSettingsManager$getPreloadSettingsList$33.INSTANCE, ECSettingsManager$getPreloadSettingsList$34.INSTANCE, ECSettingsManager$getPreloadSettingsList$35.INSTANCE, ECSettingsManager$getPreloadSettingsList$36.INSTANCE, ECSettingsManager$getPreloadSettingsList$37.INSTANCE, ECSettingsManager$getPreloadSettingsList$38.INSTANCE, ECSettingsManager$getPreloadSettingsList$39.INSTANCE, ECSettingsManager$getPreloadSettingsList$40.INSTANCE, ECSettingsManager$getPreloadSettingsList$41.INSTANCE, ECSettingsManager$getPreloadSettingsList$42.INSTANCE, ECSettingsManager$getPreloadSettingsList$43.INSTANCE, ECSettingsManager$getPreloadSettingsList$44.INSTANCE, ECSettingsManager$getPreloadSettingsList$45.INSTANCE, ECSettingsManager$getPreloadSettingsList$46.INSTANCE, ECSettingsManager$getPreloadSettingsList$47.INSTANCE, ECSettingsManager$getPreloadSettingsList$48.INSTANCE, ECSettingsManager$getPreloadSettingsList$49.INSTANCE, ECSettingsManager$getPreloadSettingsList$50.INSTANCE, ECSettingsManager$getPreloadSettingsList$51.INSTANCE, ECSettingsManager$getPreloadSettingsList$52.INSTANCE, ECSettingsManager$getPreloadSettingsList$53.INSTANCE, ECSettingsManager$getPreloadSettingsList$54.INSTANCE, ECSettingsManager$getPreloadSettingsList$55.INSTANCE});
        ECSettingsConfig r12 = h.b();
        if (r12 == null) goto L12;
        int r13 = r12.getBatchSize();
    L13:
        ECSettingsConfig r14 = h.b();
        if (r14 == null) goto L16;
        long r15 = r14.getSleepTime();
    L17:
        Iterator r16 = r11.iterator();
    L19:
        if (r16.hasNext() == false) goto L34;
        Object r17 = r16.next();
        int r18 = r10 + 1;
        if (r10 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        ((Function0) r17).invoke();
        if (r13 <= 0) goto L33;
        if (r10 <= 0) goto L33;
        if ((r10 % r13) != 0) goto L33;
        if (r15 <= 0) goto L33;
        Thread.sleep(r15);     // Catch: Exception -> L32
    L33:
        r10 = r18;
        goto L19
    L34:
        long r19 = System.currentTimeMillis() - r1;
        Set<String> r20 = ECProcessMonitor.a;
        JSONObject r110 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r110, com.bytedance.android.ec.core.event.a.KEY_MSG, "batchSize " + r13 + ", sleepTime:" + r15);
        Unit r21 = Unit.INSTANCE;
        ECProcessMonitor.k("preload_setting", r19, r110, null, 16);
        return;
    L16:
        r15 = 200;
        goto L17
    L12:
        r13 = 0;
        goto L13
    L47:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1133invoke();
        return Unit.INSTANCE;
    }
}
