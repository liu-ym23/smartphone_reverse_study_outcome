package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DRCommonHeader {
    private static final String KEY_INSTALL_VERSION_CODE = "dr_install_vc";
    private static final int MAX_PERMISSION = 10;
    public static final int STATE_DIFF = 2;
    public static final int STATE_EMPTY = 0;
    public static final int STATE_SAME = 1;
    private static final String TAG = "DRCommonHeader";
    private boolean hasInitLoader;
    private boolean mAllReady;
    protected final Context mApp;
    private int mCountPermission;
    private Env mEnv;
    private JSONObject mHeader;
    private final Map<Class<?>, BaseLoader> mLoaders;
    protected final InstallOptions mOptions;

    public DRCommonHeader(Context r10, InstallOptions r11, Env r12) {
        this.mLoaders = new LinkedHashMap(32);
        this.hasInitLoader = false;
        this.mCountPermission = 0;
        this.mHeader = new JSONObject();
        this.mApp = r10;
        this.mEnv = r12;
        this.mOptions = r11;
    }

    private boolean needSyncFromSub(BaseLoader r10) {
        if (Utils.isMainProcess(this.mOptions.getContext()) == false) goto L5;
    L7:
        boolean r11 = false;
    L9:
        if (DrLog.debug() == false) goto L11;
        DrLog.d("needSyncFromSub " + r10 + " " + r11);
    L11:
        return r11;
    L5:
        if (r10.syncFromSub == false) goto L7;
        r11 = true;
        goto L9
    }

    @NonNull
    public JSONObject getConstHeader() {
        return this.mHeader;
    }

    public boolean isFinishload() {
        return this.mAllReady;
    }

    public synchronized boolean load() {
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L4:
        if (isFinishload() == false) goto L9;
        Log.d(TAG, "load: mAllReady is true  header : " + getConstHeader().toString());     // Catch: Throwable -> L35
        monitor-exit(this);
        return true;
    L9:
        if (this.hasInitLoader == true) goto L11;
        this.hasInitLoader = true;     // Catch: Throwable -> L35
        this.mLoaders.put(BuildLoader.class, new BuildLoader(this.mApp));     // Catch: Throwable -> L35
        this.mLoaders.put(DisplayLoader.class, new DisplayLoader(this.mApp));     // Catch: Throwable -> L35
        this.mLoaders.put(NetLoader.class, new NetLoader(this.mApp));     // Catch: Throwable -> L35
        this.mLoaders.put(RomLoader.class, new RomLoader());     // Catch: Throwable -> L35
        this.mLoaders.put(LocaleLoader.class, new LocaleLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L35
        this.mLoaders.put(SimCountryLoader.class, new SimCountryLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L35
        this.mLoaders.put(DeviceParamsLoader.class, new DeviceParamsLoader(this.mApp, this.mOptions, this.mEnv));     // Catch: Throwable -> L35
        this.mLoaders.put(FlavorSpecialLoader.class, new FlavorSpecialLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L35
    L11:
        JSONObject r10 = getConstHeader();     // Catch: Throwable -> L35
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L35
        Utils.copy(r11, r10);     // Catch: Throwable -> L35
        Iterator<BaseLoader> r12 = this.mLoaders.values().iterator();     // Catch: Throwable -> L35
        boolean r13 = true;
    L13:
        if (r12.hasNext() == false) goto L32;
        BaseLoader r14 = r12.next();     // Catch: Throwable -> L35
        if (r14.mReady == true) goto L17;
    L40:
        r14.remove(r11);     // Catch: JSONException -> L22 SecurityException -> L38 Throwable -> L35
        r14.mReady = r14.doLoad(r11);     // Catch: JSONException -> L22 SecurityException -> L38 Throwable -> L35
    L22:
        e = move-exception;
        DrLog.ysnp(e);     // Catch: Throwable -> L35
    L25:
        if (r14.mReady == false) goto L27;
    L30:
        boolean r15 = true;
    L31:
        r13 = r13 & r15;     // Catch: Throwable -> L35
        this.mHeader = r11;     // Catch: Throwable -> L35
        Log.d(TAG, "load: allReady : " + r13 + " mHeader : " + this.mHeader.toString());     // Catch: Throwable -> L35
        this.mAllReady = r13;     // Catch: Throwable -> L35
        goto L13
    L27:
        if (r14.mOptional == true) goto L30;
        r15 = false;
        goto L31
    L17:
        if (r14.mShouldUpdate == true) goto L40;
        if (needSyncFromSub(r14) == false) goto L25;
    L32:
        boolean r16 = this.mAllReady;     // Catch: Throwable -> L35
        monitor-exit(this);
        return r16;
    }
}
