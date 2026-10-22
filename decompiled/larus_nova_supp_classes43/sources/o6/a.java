package o6;

import com.google.gson.Gson;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a<T> {
    private volatile c settingsManager;
    private volatile T settingsModel;

    public a() {
    }

    public final synchronized T get() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.settingsModel != null) goto L6;
        updateSettingsModel();     // Catch: Throwable -> L9
    L6:
        T r0 = this.settingsModel;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public abstract String getSettingsKey();

    public abstract Class<T> getSettingsModelClass();

    public abstract c obtainSettingsManager();

    public void onSettingsUpdateFail(int r1, String r10, Throwable r11) {
    }

    private final void updateSettingsModel() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        getSettingsManager();     // Catch: Throwable -> L4
        this.settingsModel = (T) new Gson().fromJson(null, getSettingsModelClass());     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final c getSettingsManager() {
        obtainSettingsManager();
        return null;
    }

    public void onSettingsUpdateSuccess(JSONObject r1) {
        updateSettingsModel();
    }
}
