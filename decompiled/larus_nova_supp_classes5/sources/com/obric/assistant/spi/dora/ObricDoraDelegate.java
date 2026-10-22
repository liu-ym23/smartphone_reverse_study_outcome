package com.obric.assistant.spi.dora;

import android.app.Application;
import android.content.Context;
import android.view.View;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001J%\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001JG\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0096\u0001J3\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0096\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fH\u0096\u0001J\t\u0010!\u001a\u00020\u0005H\u0096\u0001J\t\u0010\"\u001a\u00020\u0005H\u0096\u0001J\t\u0010#\u001a\u00020\u0005H\u0096\u0001J\t\u0010$\u001a\u00020\u0005H\u0096\u0001J\t\u0010%\u001a\u00020\u0005H\u0096\u0001J\t\u0010&\u001a\u00020\u0005H\u0096\u0001J\t\u0010'\u001a\u00020\u0005H\u0096\u0001J\t\u0010(\u001a\u00020\u0005H\u0096\u0001J\t\u0010)\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0096\u0001J\u0011\u0010-\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020.H\u0096\u0001J\u0019\u0010/\u001a\u00020\u001d2\u000e\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fH\u0096\u0001J'\u00101\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u00010\f2\b\u00103\u001a\u0004\u0018\u00010\f2\b\u00104\u001a\u0004\u0018\u00010\fH\u0096\u0001¨\u00065"}, d2 = {"Lcom/obric/assistant/spi/dora/ObricDoraDelegate;", "Lcom/obric/assistant/spi/dora/IObricDoraService;", "<init>", "()V", "disableDoraInLiveTutor", "", "doraUseObricLogic", "getDoraObricPlugin", "", "context", "getObricContext", "", "", "roundId", "", "forceUpdateFull", "getPersonalContext", "Lorg/json/JSONObject;", "handleDoraGRecordMinutes", "state", "", "mode", DownloadConstants.QUERY_KEY, "vuiId", "kw", "requestId", "source", "handleDoraGRecordMinutesWakeOff", "hideDoraVoiceWakeupSettingItems", "", "view", "", "Landroid/view/View;", "isCurrentMainUser", "isDoraGOnObric", "isDoraKeepAliveEnableForObric", "isDoraNewDeviceManageEnable", "isObricSmartNotificationEnable", "isObricWakeupModelEngine", "needHideDoraKeepAliveBalloon", "needHideDoraOwenSetting", "needHideDoraProactiveSetting", "onMainProcessDoraStarted", "application", "Landroid/app/Application;", "openDoraGRecordMinutesPage", "Landroid/content/Context;", "showDoraVoiceWakeupSettingItems", "listOf", "updateBtHeadsetEnrollModelPaths", "firstKwsModelPath", "sidEnrollModelPath", "silentFilePath", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDoraDelegate implements IObricDoraService {
    public static final ObricDoraDelegate b = null;
    public final /* synthetic */ IObricDoraService a;

    static {
        b = new ObricDoraDelegate();
    }

    public final Map<String, String> a(long r2, boolean r4) {
        return this.a.a(r2, r4);
    }

    public final void b(String r2, String r3, String r4) {
        this.a.b(r2, r3, r4);
    }

    public final JSONObject c() {
        return this.a.c();
    }

    public final void d(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        this.a.d(r2);
    }

    public final boolean e() {
        return this.a.e();
    }

    public final boolean f(int r7, int r8, int r9, int r10, String r11) {
        return this.a.f(r7, r8, r9, r10, r11);
    }

    public final boolean g() {
        return this.a.g();
    }

    public final boolean h() {
        return this.a.h();
    }

    public final boolean i(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.i(r2);
    }

    public final boolean j() {
        return this.a.j();
    }

    public final boolean k() {
        return this.a.k();
    }

    public final void l(List<? extends View> r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a.l(r2);
    }

    public final boolean m() {
        return this.a.m();
    }

    public final boolean n() {
        return this.a.n();
    }

    public final Object o(Object r2) {
        return this.a.o(r2);
    }

    public final void p(List<? extends View> r2) {
        Intrinsics.checkNotNullParameter(r2, "listOf");
        this.a.p(r2);
    }

    public final boolean q() {
        return this.a.q();
    }

    public final boolean r() {
        return this.a.r();
    }

    public final boolean s(int r9, int r10, int r11, int r12, String r13, String r14, String r15) {
        return this.a.s(r9, r10, r11, r12, r13, r14, r15);
    }

    public final boolean t() {
        return this.a.t();
    }

    private ObricDoraDelegate() {
        DefaultObricDoraServiceImpl r0 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricDoraServiceImpl();
    L5:
        this.a = r0;
    }
}
