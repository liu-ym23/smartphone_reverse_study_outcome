package cn.nubia.neopush.commons.deviceid;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.jarjarred.org.antlr.runtime.a;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class DeviceId {
    public static final String APPID_PROVIDER = "content://cn.nubia.provider.deviceid.dataid/aaid";
    public static final String DATAID_PROVIDER = "content://cn.nubia.provider.deviceid.dataid/oaid";
    public static final String DEVICEID_PROVIDER = "content://cn.nubia.provider.DeviceId";
    public static final String GRNDID_PROVIDER = "content://cn.nubia.provider.deviceid.dataid/grndid";
    static final String KEY_ALTID = "device_ids_altid";
    private static final String KEY_DID = "device_ids_did";
    static final String KEY_GRNDID = "device_ids_grndid";
    static final String KEY_IMEIS = "device_ids_imeis";
    private static final String KEY_LRNDID = "device_ids_lrndid";
    static final String KEY_MEIDS = "device_ids_meids";
    static final String KEY_SERIAL = "device_ids_serial";
    static final String KEY_UDID = "device_ids_udid";
    public static final int POLICY_CACHE_USE_FILE = 128;
    public static final int POLICY_DONT_COLLECT_MID = 64;
    public static final int POLICY_FORCE_UPDATE_REMOTE_RNDID = 1;
    public static final int POLICY_HASH_MID = 16;
    public static final int POLICY_NO_SERIAL = 32;
    public static final int POLICY_REMOTE_GRNDID_FIRST = 8;
    public static final int POLICY_USE_MID = 4;
    public static final int POLICY_USE_UDID = 2;
    private static final String TAG = "DeviceId";
    public static final String VENDORID_PROVIDER = "content://cn.nubia.provider.deviceid.dataid/vaid";
    private String mALTID;
    private String mCacheName;
    private String mDeviceId;
    private ArrayList<String> mIMEIs;
    private IdCache mIdCache;
    private int mIdPolicy;
    private IdChangedListener mListener;
    private String mLocalRNDID;
    private ArrayList<String> mMEIDs;
    private String mRemoteProviderUri;
    private String mRemoteRNDID;
    private String mSerial;
    private String mUDID;

    public interface IdChangedListener {
        void onIdChanged(String r5, String r10, boolean r11);
    }

    public DeviceId(String r5, int r10) {
        this.mIdCache = new IdCache();
        this.mCacheName = "device_ids_cache";
        this.mIMEIs = new ArrayList();
        this.mMEIDs = new ArrayList();
        this.mSerial = IdCodecer.FAKE_ID;
        this.mLocalRNDID = IdCodecer.FAKE_ID;
        this.mDeviceId = IdCodecer.FAKE_ID;
        this.mRemoteProviderUri = r5;
        this.mIdPolicy = r10;
    }

    private String generateDeviceId() {
        if (hasPolicy(8) == false) goto L9;
        if (TextUtils.isEmpty(this.mRemoteRNDID) == true) goto L9;
        return this.mRemoteRNDID;
    L9:
        if (hasPolicy(2) == false) goto L15;
        if (TextUtils.isEmpty(this.mUDID) == true) goto L15;
        return this.mUDID;
    L15:
        if (hasPolicy(4) == false) goto L33;
        boolean r5 = hasPolicy(16);
        boolean r10 = hasPolicy(32);
        if (this.mIMEIs.size() <= 0) goto L25;
        String r11 = this.mIMEIs.get(0);
        if (r10 == true) goto L21;
        r11 = String.valueOf(r11) + "#" + this.mSerial;
    L21:
        if (r5 == true) goto L23;
        return r11;
    L23:
        return IdCodecer.sha256(r11, null);
    L25:
        if (this.mMEIDs.size() <= 0) goto L33;
        String r12 = this.mMEIDs.get(0);
        if (r10 == true) goto L29;
        r12 = String.valueOf(r12) + "#" + this.mSerial;
    L29:
        if (r5 == true) goto L31;
        return r12;
    L31:
        return IdCodecer.sha256(r12, null);
    L33:
        if (TextUtils.isEmpty(this.mRemoteRNDID) == false) goto L35;
        String r13 = this.mLocalRNDID;
        if (r13 == null) goto L39;
        return r13;
    L39:
        return IdCodecer.FAKE_ID;
    L35:
        return this.mRemoteRNDID;
    }

    private boolean hasPolicy(int r5) {
        if ((this.mIdPolicy & r5) != r5) goto L6;
        return true;
    L6:
        return false;
    }

    private void load(Context r10) {
        this.mIMEIs.clear();
        this.mMEIDs.clear();
        this.mSerial = IdCodecer.FAKE_ID;
        this.mUDID = null;
        this.mRemoteRNDID = null;
        this.mLocalRNDID = IdCodecer.FAKE_ID;
        this.mDeviceId = IdCodecer.FAKE_ID;
        String[] r5 = {KEY_IMEIS, KEY_MEIDS, KEY_SERIAL, KEY_UDID, KEY_GRNDID, KEY_LRNDID, KEY_DID};
        String[] r11 = new String[7];
        if (hasPolicy(128) == false) goto L5;
        this.mIdCache.loadFromFile(r10, this.mCacheName, r5, r11);
    L6:
        IdCodecer.unserialize(r11[0], this.mIMEIs, true);
        IdCodecer.unserialize(r11[1], this.mMEIDs, true);
        String r12 = r11[2];
        if (TextUtils.isEmpty(r12) == true) goto L9;
        this.mSerial = r12;
    L9:
        this.mUDID = r11[3];
        this.mRemoteRNDID = r11[4];
        String r13 = r11[5];
        if (TextUtils.isEmpty(r13) == true) goto L12;
        this.mLocalRNDID = r13;
    L12:
        String r14 = r11[6];
        if (TextUtils.isEmpty(r14) == true) goto L16;
        this.mDeviceId = r14;
        return;
    L16:
        return;
    L5:
        this.mIdCache.loadFromSP(r10, this.mCacheName, r5, r11);
        goto L6
    }

    private void save(Context r10) {
        String[] r5 = {KEY_MEIDS, KEY_SERIAL, KEY_UDID, KEY_GRNDID, KEY_LRNDID, KEY_DID};
        String[] r11 = {"", this.mSerial, "", this.mRemoteRNDID, this.mLocalRNDID, this.mDeviceId};
        if (hasPolicy(128) == false) goto L5;
        this.mIdCache.saveToFile(r10, this.mCacheName, r5, r11);
        return;
    L5:
        this.mIdCache.saveToSP(r10, this.mCacheName, r5, r11);
    }

    private void updateFromDevice(Context r5, boolean r10) {
        if (hasPolicy(64) == true) goto L9;
        if (r10 == false) goto L9;
        HwId.getTelephonyIds(r5, this.mIMEIs, this.mMEIDs);
        String r11 = HwId.getSerial();
        if (TextUtils.isEmpty(r11) == true) goto L9;
        this.mSerial = r11;
    L9:
        if (IdCodecer.FAKE_ID.equals(this.mLocalRNDID) == false) goto L17;
        String r12 = "";
        if (TextUtils.isEmpty("") == true) goto L13;
    L15:
        this.mLocalRNDID = SwId.generateRandomId(r12);
        return;
    L13:
        if (IdCodecer.FAKE_ID.equals(this.mSerial) == true) goto L15;
        r12 = this.mSerial;
        goto L15
    }

    private void updateFromRemote(Context r15) {
        if (TextUtils.isEmpty(this.mRemoteProviderUri) == true) goto L61;
        if (r15 == null) goto L75;
        int r5 = 0;
        Cursor r10 = null;
    L7:
        if (r5 >= 3) goto L24;
        Uri r11 = Uri.parse(this.mRemoteProviderUri);     // Catch: Exception -> L21
        if (r15.getPackageManager().resolveContentProvider(r11.getAuthority(), 0) == null) goto L24;
        ContentProviderClient r12 = r15.getContentResolver().acquireUnstableContentProviderClient(r11);     // Catch: Exception -> L21
        if (r12 != null) goto L63;
    L23:
        if (r10 != null) goto L24;
        if (r5 >= 2) goto L60;
        Thread.sleep(10);     // Catch: Exception -> L62
    L60:
        r5 = r5 + 1;
        goto L7
    L63:
        r10 = r12.query(r11, null, null, null, null);     // Catch: Exception -> L17
    L19:
        r12.close();     // Catch: Exception -> L21
        goto L23
    L17:
        e = move-exception;
        Log.e(TAG, "Failed to query for remote ids " + e);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        a.A(e, "Failed to get remote ids ", TAG);
    L24:
        if (r10 != null) goto L26;
        return;
    L26:
        if (r10.getCount() <= 0) goto L74;
        String[] r13 = new String[6];
        this.mIdCache.loadFromCursor(r10, new String[]{KEY_IMEIS, KEY_MEIDS, KEY_SERIAL, KEY_UDID, KEY_GRNDID, KEY_ALTID}, r13, true);
        if (hasPolicy(64) == true) goto L33;
        IdCodecer.unserialize(r13[0], this.mIMEIs, true);
        IdCodecer.unserialize(r13[1], this.mMEIDs, true);
        String r16 = r13[2];
        if (TextUtils.isEmpty(r16) == true) goto L33;
        this.mSerial = r16;
    L33:
        String r17 = r13[3];
        if (TextUtils.isEmpty(r17) == true) goto L36;
        this.mUDID = r17;
    L36:
        String r18 = r13[4];
        if (IdCodecer.allZeros(r18) == false) goto L40;
        r18 = null;
    L40:
        if (hasPolicy(1) == false) goto L47;
        if (TextUtils.equals(r18, this.mRemoteRNDID) == true) goto L55;
        String r14 = this.mRemoteRNDID;
        this.mRemoteRNDID = r18;
        IdChangedListener r19 = this.mListener;
        if (r19 == null) goto L55;
        r19.onIdChanged(r14, r18, true);
    L55:
        this.mALTID = r13[5];
        return;
    L47:
        if (TextUtils.isEmpty(this.mRemoteRNDID) == false) goto L55;
        if (IdCodecer.FAKE_ID.equals(this.mLocalRNDID) == false) goto L55;
        if (TextUtils.isEmpty(r18) == true) goto L55;
        this.mRemoteRNDID = r18;
        IdChangedListener r20 = this.mListener;
        if (r20 == null) goto L55;
        r20.onIdChanged(null, r18, true);
        goto L55
    L74:
        return;
    L75:
        return;
    }

    public void enableSPMultiProcess(boolean r5) {
        this.mIdCache.enableSPMultiProcess(r5);
    }

    public String getALTID() {
        return this.mALTID;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getIMEIs() {
        if (this.mIMEIs.size() > 0) goto L5;
        return null;
    L5:
        return IdCodecer.serialize(this.mIMEIs);
    }

    public String getLocalRNDID() {
        return this.mLocalRNDID;
    }

    public String getMEIDs() {
        if (this.mMEIDs.size() > 0) goto L5;
        return null;
    L5:
        return IdCodecer.serialize(this.mMEIDs);
    }

    public String getMobileId(boolean r5) {
        if (this.mIMEIs.size() <= 0) goto L9;
        String r10 = this.mIMEIs.get(0);
        if (r5 == true) goto L7;
        return r10;
    L7:
        return IdCodecer.sha256(r10, null);
    L9:
        if (this.mMEIDs.size() <= 0) goto L14;
        String r11 = this.mMEIDs.get(0);
        if (r5 == true) goto L13;
        return r11;
    L13:
        return IdCodecer.sha256(r11, null);
    L14:
        return null;
    }

    public String getMobileIds() {
        if (this.mIMEIs.size() <= 0) goto L5;
    L9:
        ArrayList r5 = new ArrayList();
        r5.addAll(this.mIMEIs);
        r5.addAll(this.mMEIDs);
        return IdCodecer.serialize(r5);
    L5:
        if (this.mMEIDs.size() > 0) goto L9;
        return null;
    }

    public String getRemoteRNDID() {
        return this.mRemoteRNDID;
    }

    public String getSerial() {
        return this.mSerial;
    }

    public String getUDID() {
        return this.mUDID;
    }

    public void refresh(Context r10, boolean r11, boolean r12) {
        if (r10 == null) goto L32;
        if (r11 == false) goto L5;
        load(r10);
    L5:
        ArrayList r13 = new ArrayList(this.mIMEIs);
        ArrayList r5 = new ArrayList(this.mMEIDs);
        String r14 = this.mSerial;
        String r15 = this.mUDID;
        String r16 = this.mRemoteRNDID;
        String r17 = this.mLocalRNDID;
        String r18 = this.mDeviceId;
        updateFromRemote(r10);
        updateFromDevice(r10, r12);
        if (this.mIMEIs.isEmpty() == true) goto L9;
        Collections.sort(this.mIMEIs);
    L9:
        if (this.mMEIDs.isEmpty() == true) goto L11;
        Collections.sort(this.mMEIDs);
    L11:
        this.mDeviceId = generateDeviceId();
        if (r13.equals(this.mIMEIs) == true) goto L14;
    L25:
        save(r10);
    L27:
        if (this.mListener != null) goto L29;
        return;
    L29:
        if (TextUtils.equals(r18, this.mDeviceId) == true) goto L34;
        this.mListener.onIdChanged(r18, this.mDeviceId, false);
        return;
    L34:
        return;
    L14:
        if (r5.equals(this.mMEIDs) == false) goto L25;
        if (TextUtils.equals(r14, this.mSerial) == false) goto L25;
        if (TextUtils.equals(r15, this.mUDID) == false) goto L25;
        if (TextUtils.equals(r16, this.mRemoteRNDID) == false) goto L25;
        if (TextUtils.equals(r17, this.mLocalRNDID) == false) goto L25;
        if (TextUtils.equals(r18, this.mDeviceId) == true) goto L27;
    }

    public void refreshWithCacheLock(Context r5, boolean r10, boolean r11, boolean r12) {
        if (r5 != null) goto L4;
        return;
    L4:
        monitor-enter(Context.class);
        if (r11 == false) goto L9;
        Object r13 = this.mIdCache.obtainFileLock(r5, this.mCacheName);     // Catch: Throwable -> L7
        refresh(r5, r10, r12);     // Catch: Throwable -> L7
        this.mIdCache.releaseFileLock(r13);     // Catch: Throwable -> L7
    L10:
        monitor-exit(Context.class);     // Catch: Throwable -> L7
        return;
    L9:
        refresh(r5, r10, r12);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void setCacheName(String r5) {
        this.mCacheName = r5;
    }

    public void setFlockTimeout(long r5) {
        this.mIdCache.setFlockTimeout(r5);
    }

    public void setIdChangedListener(IdChangedListener r5) {
        this.mListener = r5;
    }

    public void setSPCommitNow(boolean r5) {
        this.mIdCache.setSPCommitNow(r5);
    }
}
