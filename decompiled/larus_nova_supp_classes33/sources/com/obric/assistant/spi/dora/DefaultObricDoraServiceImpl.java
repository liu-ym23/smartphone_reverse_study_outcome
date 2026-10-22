package com.obric.assistant.spi.dora;

import android.app.Application;
import android.content.Context;
import android.view.View;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016JF\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 H\u0016J2\u0010#\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H\u0016J$\u0010(\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0014\u0010/\u001a\u0004\u0018\u0001002\b\u0010\u0017\u001a\u0004\u0018\u000100H\u0016J&\u00101\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010 2\b\u00103\u001a\u0004\u0018\u00010 2\b\u00104\u001a\u0004\u0018\u00010 H\u0016¨\u00066"}, d2 = {"Lcom/obric/assistant/spi/dora/DefaultObricDoraServiceImpl;", "Lcom/obric/assistant/spi/dora/IObricDoraService;", "<init>", "()V", "needHideDoraOwenSetting", "", "needHideDoraProactiveSetting", "needHideDoraKeepAliveBalloon", "doraUseObricLogic", "isDoraKeepAliveEnableForObric", "isDoraNewDeviceManageEnable", "isObricWakeupModelEngine", "isCurrentMainUser", "hideDoraVoiceWakeupSettingItems", "", "view", "", "Landroid/view/View;", "showDoraVoiceWakeupSettingItems", "listOf", "disableDoraInLiveTutor", "isObricSmartNotificationEnable", "openDoraGRecordMinutesPage", "context", "Landroid/content/Context;", "handleDoraGRecordMinutes", "state", "", "mode", "query", "vuiId", "kw", "", "requestId", "source", "handleDoraGRecordMinutesWakeOff", "isDoraGOnObric", "onMainProcessDoraStarted", "application", "Landroid/app/Application;", "getObricContext", "", "roundId", "", "forceUpdateFull", "getPersonalContext", "Lorg/json/JSONObject;", "getDoraObricPlugin", "", "updateBtHeadsetEnrollModelPaths", "firstKwsModelPath", "sidEnrollModelPath", "silentFilePath", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricDoraServiceImpl implements IObricDoraService {

    public static final class a {
    }

    static {
    }

    public DefaultObricDoraServiceImpl() {
    }

    public final void b(String r1, String r2, String r3) {
    }

    public final JSONObject c() {
        return null;
    }

    public final void d(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
    }

    public final boolean e() {
        return true;
    }

    public final boolean f(int r1, int r2, int r3, int r4, String r5) {
        return false;
    }

    public final boolean g() {
        return false;
    }

    public final boolean h() {
        return false;
    }

    public final boolean i(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return false;
    }

    public final boolean j() {
        return false;
    }

    public final boolean k() {
        return false;
    }

    public final void l(List<? extends View> r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public final boolean m() {
        return false;
    }

    public final boolean n() {
        return false;
    }

    public final Object o(Object r1) {
        return null;
    }

    public final void p(List<? extends View> r2) {
        Intrinsics.checkNotNullParameter(r2, "listOf");
    }

    public final boolean q() {
        return false;
    }

    public final boolean r() {
        return true;
    }

    public final boolean s(int r1, int r2, int r3, int r4, String r5, String r6, String r7) {
        return false;
    }

    public final boolean t() {
        return false;
    }

    public final Map<String, String> a(long r1, boolean r3) {
        return MapsKt.emptyMap();
    }
}
