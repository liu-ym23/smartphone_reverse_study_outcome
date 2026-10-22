package com.obric.sva.sdk.data;

import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface ISettingsModel {
    public static final String NAME_OF_GLOBAL_PREFERENCES = "global_settings";
    public static final String PREFIX_OF_SOUND_MODEL_PREFERENCES = "settings_";

    int get1stKeyphraseConfidenceLevel();

    int get1stUserConfidenceLevel();

    int get2ndKeyphraseConfidenceLevel();

    int get2ndUserConfidenceLevel();

    Intent getActionIntent();

    String getActionName();

    String getBaseSoundModel();

    String getCurrentSoundModel();

    int getGlobal1stKeyphraseConfidenceLevel(ISmModel.ModelVersion r1);

    int getGlobal1stUserConfidenceLevel(ISmModel.ModelVersion r1);

    int getGlobal2ndKeyphraseConfidenceLevel(ISmModel.ModelVersion r1);

    int getGlobal2ndUserConfidenceLevel(ISmModel.ModelVersion r1);

    boolean getGlobalDetectionToneEnabled();

    int getGlobalGMMTrainingConfidenceLevel();

    boolean getGlobalIsDisplayAdvancedDetails();

    int getGlobalTrainingPath();

    int getHistBufferTime();

    boolean getOpaqueDataTransferEnabled();

    int getPreRollDuration();

    boolean getUserVerificationEnabled();

    boolean getVoiceRequestEnabled();

    int getVoiceRequestLength();

    void set1stKeyphraseConfidenceLevel(int r1);

    void set1stUserConfidenceLevel(int r1);

    void set2ndKeyphraseConfidenceLevel(int r1);

    void set2ndUserConfidenceLevel(int r1);

    void setActionIntent(Intent r1);

    void setActionName(String r1);

    void setBaseSoundModel(String r1);

    void setCurrentSoundModel(String r1);

    void setGlobal1stKeyphraseConfidenceLevel(ISmModel.ModelVersion r1, int r2);

    void setGlobal1stUserConfidenceLevel(ISmModel.ModelVersion r1, int r2);

    void setGlobal2ndKeyphraseConfidenceLevel(ISmModel.ModelVersion r1, int r2);

    void setGlobal2ndUserConfidenceLevel(ISmModel.ModelVersion r1, int r2);

    void setGlobalDetectionToneEnabled(boolean r1);

    void setGlobalGMMTrainingConfidenceLevel(int r1);

    void setGlobalIsDisplayAdvancedDetails(boolean r1);

    void setGlobalTrainingPath(int r1);

    void setHistBufferTime(int r1);

    void setOpaqueDataTransferEnabled(boolean r1);

    void setPreRollDuration(int r1);

    void setUserVerificationEnabled(boolean r1);

    void setVoiceRequestEnabled(boolean r1);

    void setVoiceRequestLength(int r1);
}
