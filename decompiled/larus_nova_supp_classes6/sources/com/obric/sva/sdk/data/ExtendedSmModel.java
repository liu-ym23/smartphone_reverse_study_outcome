package com.obric.sva.sdk.data;

import android.content.Intent;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper;
import com.obric.sva.sdk.session.SessionType;
import com.obric.sva.sdk.utils.LogUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ExtendedSmModel extends SmModel implements IExtendedSmModel {
    private final String DEFAULT_ACTION_NAME;
    private final String TAG;
    private SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] mKpRecognitionExtraArray;
    private SoundTriggerWrapper.RecognitionConfigWrapper mRecognitionConfig;
    private int mSessionId;
    private IExtendedSmModel.SessionStatus mSessionStatus;
    private Intent mSmActionIntent;
    private String mSmActionName;
    private int mSoundModelHandle;

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public SessionType getSessionType() {
        String r0 = this.mSmFullFileName;
        if (r0 != null) goto L7;
        return SessionType.VOICE;
    L7:
        if (r0.contains("voice") == false) goto L11;
        return SessionType.VOICE;
    L11:
        return SessionType.BREATH;
    }

    public String toString() {
        return "sessionId:" + this.mSessionId + " status:" + this.mSessionStatus + " type:" + getSessionType() + " handle:" + getSoundModelHandle() + " name:" + getSoundModelFullFileName();
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] getKeyphraseRecognitionExtra() {
        return this.mKpRecognitionExtraArray;
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public SoundTriggerWrapper.RecognitionConfigWrapper getRecognitionConfig() {
        return this.mRecognitionConfig;
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public int getSessionId() {
        return this.mSessionId;
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public IExtendedSmModel.SessionStatus getSessionStatus() {
        return this.mSessionStatus;
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public Intent getSoundModelActionIntent() {
        return this.mSmActionIntent;
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public String getSoundModelActionName() {
        return this.mSmActionName;
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public int getSoundModelHandle() {
        return this.mSoundModelHandle;
    }

    public ExtendedSmModel(String r1) {
        super(r1);
        this.TAG = "ExtendedSmModel";
        this.DEFAULT_ACTION_NAME = "None";
        this.mSmActionName = "None";
        this.mSessionStatus = IExtendedSmModel.SessionStatus.UNLOADED;
        this.mSoundModelHandle = -1;
        this.mSessionId = 0;
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public void setKeyphraseRecognitionExtra(SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] r1) {
        this.mKpRecognitionExtraArray = (SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[]) r1.clone();
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public void setRecognitionConfig(SoundTriggerWrapper.RecognitionConfigWrapper r1) {
        this.mRecognitionConfig = r1;
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public void setSessionId(int r5) {
        LogUtils.d(this.TAG, "setSessionId: id = " + r5, new Object[0]);
        if (r5 > 0) goto L5;
        LogUtils.d(this.TAG, "setSessionId: invalid input param", new Object[0]);
    L5:
        this.mSessionId = r5;
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public void setSessionStatus(IExtendedSmModel.SessionStatus r1) {
        this.mSessionStatus = r1;
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public void setSoundModelActionIntent(Intent r1) {
        this.mSmActionIntent = r1;
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public void setSoundModelActionName(String r1) {
        if (r1 != null) goto L4;
        this.mSmActionName = "None";
        return;
    L4:
        this.mSmActionName = r1;
    }

    @Override // com.obric.sva.sdk.data.IExtendedSmModel
    public void setSoundModelHandle(int r1) {
        this.mSoundModelHandle = r1;
    }
}
