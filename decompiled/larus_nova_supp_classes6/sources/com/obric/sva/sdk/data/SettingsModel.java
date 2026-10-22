package com.obric.sva.sdk.data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.utils.LogUtils;
import com.obric.sva.sdk.utils.Utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SettingsModel implements ISettingsModel {
    private final String TAG;
    private SharedPreferences mGlobalPrefs;
    private String mSmName;
    private SharedPreferences mSmPrefs;
    private ISmModel.ModelVersion mSmVersion;

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setCurrentSoundModel(String r1) {
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int get1stKeyphraseConfidenceLevel() {
        return SettingsDAO.get1stKeyphraseConfidenceLevel(this.mSmPrefs, this.mGlobalPrefs, this.mSmVersion);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int get1stUserConfidenceLevel() {
        return SettingsDAO.get1stUserConfidenceLevel(this.mSmPrefs, this.mGlobalPrefs, this.mSmVersion);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int get2ndKeyphraseConfidenceLevel() {
        return SettingsDAO.get2ndKeyphraseConfidenceLevel(this.mSmPrefs, this.mGlobalPrefs, this.mSmVersion);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int get2ndUserConfidenceLevel() {
        return SettingsDAO.get2ndUserConfidenceLevel(this.mSmPrefs, this.mGlobalPrefs, this.mSmVersion);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public Intent getActionIntent() {
        return SettingsDAO.getActionIntent(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public String getActionName() {
        return SettingsDAO.getActionName(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public String getBaseSoundModel() {
        return SettingsDAO.getBaseSoundModel(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public boolean getGlobalDetectionToneEnabled() {
        return SettingsDAO.getGlobalDetectionToneEnabled(this.mGlobalPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getGlobalGMMTrainingConfidenceLevel() {
        return SettingsDAO.getGlobalGMMTrainingConfidenceLevel(this.mGlobalPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public boolean getGlobalIsDisplayAdvancedDetails() {
        return SettingsDAO.getGlobalIsDisplayAdvancedDetails(this.mGlobalPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getGlobalTrainingPath() {
        return SettingsDAO.getGlobalTrainingPath(this.mGlobalPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getHistBufferTime() {
        return SettingsDAO.getHistBufferTime(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public boolean getOpaqueDataTransferEnabled() {
        return SettingsDAO.getOpaqueDataTransferEnabled(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getPreRollDuration() {
        return SettingsDAO.getPreRollDuration(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public boolean getUserVerificationEnabled() {
        return SettingsDAO.getUserVerificationEnabled(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public boolean getVoiceRequestEnabled() {
        if (TextUtils.isEmpty(this.mSmName) == false) goto L7;
        return false;
    L7:
        return SettingsDAO.getVoiceRequestEnabled(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getVoiceRequestLength() {
        return SettingsDAO.getVoiceRequestLength(this.mSmPrefs);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public String getCurrentSoundModel() {
        return this.mSmName;
    }

    private SharedPreferences getGlobalSharedPrefs(Context r6) {
        if (Utils.isAtLeastN() == false) goto L9;
        Context r0 = r6.createDeviceProtectedStorageContext();
        if (r0.moveSharedPreferencesFrom(r6, ISettingsModel.NAME_OF_GLOBAL_PREFERENCES) == true) goto L7;
        LogUtils.e(this.TAG, "Failed to migrate global shared preferences", new Object[0]);
    L7:
        r6 = r0;
    L9:
        return r6.getSharedPreferences(ISettingsModel.NAME_OF_GLOBAL_PREFERENCES, 0);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getGlobal1stKeyphraseConfidenceLevel(ISmModel.ModelVersion r2) {
        return SettingsDAO.getGlobal1stKeyphraseConfidenceLevel(this.mGlobalPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getGlobal1stUserConfidenceLevel(ISmModel.ModelVersion r2) {
        return SettingsDAO.getGlobal1stUserConfidenceLevel(this.mGlobalPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getGlobal2ndKeyphraseConfidenceLevel(ISmModel.ModelVersion r2) {
        return SettingsDAO.getGlobal2ndKeyphraseConfidenceLevel(this.mGlobalPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public int getGlobal2ndUserConfidenceLevel(ISmModel.ModelVersion r2) {
        return SettingsDAO.getGlobal2ndUserConfidenceLevel(this.mGlobalPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void set1stKeyphraseConfidenceLevel(int r2) {
        SettingsDAO.set1stKeyphraseConfidenceLevel(this.mSmPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void set1stUserConfidenceLevel(int r2) {
        SettingsDAO.set1stUserConfidenceLevel(this.mSmPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void set2ndKeyphraseConfidenceLevel(int r2) {
        SettingsDAO.set2ndKeyphraseConfidenceLevel(this.mSmPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void set2ndUserConfidenceLevel(int r2) {
        SettingsDAO.set2ndUserConfidenceLevel(this.mSmPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setActionIntent(Intent r2) {
        SettingsDAO.setActionIntent(this.mSmPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setActionName(String r2) {
        SettingsDAO.setActionName(this.mSmPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setBaseSoundModel(String r2) {
        SettingsDAO.setBaseSoundModel(this.mSmPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobalDetectionToneEnabled(boolean r2) {
        SettingsDAO.setGlobalDetectionToneEnabled(this.mGlobalPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobalGMMTrainingConfidenceLevel(int r2) {
        SettingsDAO.setGlobalGMMTrainingConfidenceLevel(this.mGlobalPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobalIsDisplayAdvancedDetails(boolean r2) {
        SettingsDAO.setGlobalIsDisplayAdvancedDetails(this.mGlobalPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobalTrainingPath(int r2) {
        SettingsDAO.setGlobalTrainingPath(this.mGlobalPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setHistBufferTime(int r2) {
        SettingsDAO.setHistBufferTime(this.mSmPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setOpaqueDataTransferEnabled(boolean r2) {
        SettingsDAO.setOpaqueDataTransferEnabled(this.mSmPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setPreRollDuration(int r2) {
        SettingsDAO.setPreRollDuration(this.mSmPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setUserVerificationEnabled(boolean r2) {
        SettingsDAO.setUserVerificationEnabled(this.mSmPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setVoiceRequestEnabled(boolean r2) {
        SettingsDAO.setVoiceRequestEnabled(this.mSmPrefs, r2);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setVoiceRequestLength(int r2) {
        SettingsDAO.setVoiceRequestLength(this.mSmPrefs, r2);
    }

    public SettingsModel(Context r2, String r3) {
        this.TAG = "SettingsModel";
        this.mSmVersion = ISmModel.ModelVersion.VERSION_2_0;
        this.mSmName = r3;
        if (r3 != null) goto L5;
        this.mGlobalPrefs = getGlobalSharedPrefs(r2);
    L6:
        IExtendedSmModel r4 = Global.getInstance().getExtendedSmMgr().getSoundModel(r3);
        if (r4 == null) goto L10;
        this.mSmVersion = r4.getSoundModelVersion();
        return;
    L10:
        return;
    L5:
        this.mSmPrefs = getSmSharedPrefs(r2, r3);
        this.mGlobalPrefs = getGlobalSharedPrefs(r2);
        goto L6
    }

    private SharedPreferences getSmSharedPrefs(Context r5, String r6) {
        String r7 = ISettingsModel.PREFIX_OF_SOUND_MODEL_PREFERENCES + r6;
        if (Utils.isAtLeastN() == false) goto L9;
        Context r0 = r5.createDeviceProtectedStorageContext();
        if (r0.moveSharedPreferencesFrom(r5, r7) == true) goto L7;
        LogUtils.e(this.TAG, "Failed to migrate sound model shared preferences", new Object[0]);
    L7:
        r5 = r0;
    L9:
        return r5.getSharedPreferences(r7, 0);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobal1stKeyphraseConfidenceLevel(ISmModel.ModelVersion r2, int r3) {
        SettingsDAO.setGlobal1stKeyphraseConfidenceLevel(this.mGlobalPrefs, r2, r3);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobal1stUserConfidenceLevel(ISmModel.ModelVersion r2, int r3) {
        SettingsDAO.setGlobal1stUserConfidenceLevel(this.mGlobalPrefs, r2, r3);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobal2ndKeyphraseConfidenceLevel(ISmModel.ModelVersion r2, int r3) {
        SettingsDAO.setGlobal2ndKeyphraseConfidenceLevel(this.mGlobalPrefs, r2, r3);
    }

    @Override // com.obric.sva.sdk.data.ISettingsModel
    public void setGlobal2ndUserConfidenceLevel(ISmModel.ModelVersion r2, int r3) {
        SettingsDAO.setGlobal2ndUserConfidenceLevel(this.mGlobalPrefs, r2, r3);
    }
}
