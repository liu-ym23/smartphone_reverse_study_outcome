package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public DRCommonHeader(Context r4, InstallOptions r5, Env r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mLoaders = new LinkedHashMap(32);
        this.hasInitLoader = false;
        this.mCountPermission = 0;
        this.mHeader = new JSONObject();
        this.mApp = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.mEnv = r6;
        this.mOptions = r5;
    }

    private boolean needSyncFromSub(BaseLoader r3) {
        if (Utils.isMainProcess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (DrLog.debug() == false) goto L11;
        DrLog.d("needSyncFromSub " + r3 + " " + r2);
    L11:
        return r2;
    L5:
        if (r3.syncFromSub == false) goto L7;
        r2 = true;
        goto L9
    }

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
        DrLog.d("DRCommonHeaderload: mAllReady is true  header : " + getConstHeader());     // Catch: Throwable -> L35
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
        JSONObject r0 = getConstHeader();     // Catch: Throwable -> L35
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L35
        Utils.copy(r2, r0);     // Catch: Throwable -> L35
        Iterator<BaseLoader> r1 = this.mLoaders.values().iterator();     // Catch: Throwable -> L35
        boolean r3 = true;
    L13:
        if (r1.hasNext() == false) goto L32;
        BaseLoader r4 = (BaseLoader) ZeusTransformUtils.preCheckCast(r1.next(), BaseLoader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        if (r4.mReady == true) goto L17;
    L40:
        r4.remove(r2);     // Catch: JSONException -> L22 SecurityException -> L38 Throwable -> L35
        r4.mReady = r4.doLoad(r2);     // Catch: JSONException -> L22 SecurityException -> L38 Throwable -> L35
    L22:
        e = move-exception;
        DrLog.ysnp(e);     // Catch: Throwable -> L35
    L25:
        if (r4.mReady == false) goto L27;
    L30:
        boolean r5 = true;
    L31:
        r3 = r3 & r5;     // Catch: Throwable -> L35
        this.mHeader = r2;     // Catch: Throwable -> L35
        DrLog.d("DRCommonHeaderload: allReady : " + r3 + " mHeader : " + this.mHeader);     // Catch: Throwable -> L35
        this.mAllReady = r3;     // Catch: Throwable -> L35
        goto L13
    L27:
        if (r4.mOptional == true) goto L30;
        r5 = false;
        goto L31
    L17:
        if (r4.mShouldUpdate == true) goto L40;
        if (needSyncFromSub(r4) == false) goto L25;
    L32:
        boolean r6 = this.mAllReady;     // Catch: Throwable -> L35
        monitor-exit(this);
        return r6;
    }
}
