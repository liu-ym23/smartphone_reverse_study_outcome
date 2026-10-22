package rs1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lrs1/f;", "", "", "enable", "I", "d", "()I", "setEnable", "(I)V", "recordVolume", "getRecordVolume", "setRecordVolume", "", "editVoiceVolumeScale", "F", "c", "()F", "setEditVoiceVolumeScale", "(F)V", "editBgmVolumeScale", "b", "setEditBgmVolumeScale", "", "deviceAlgDelay", "Z", "a", "()Z", "setDeviceAlgDelay", "(Z)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f {

    @SerializedName("deviceAlgDelay")
    private boolean deviceAlgDelay;

    @SerializedName("editBgmVolumeScale")
    private float editBgmVolumeScale;

    @SerializedName("editVoiceVolumeScale")
    private float editVoiceVolumeScale;

    @SerializedName("enable")
    private int enable;

    @SerializedName("recordVolume")
    private int recordVolume;

    public f() {
        this.recordVolume = 100;
        this.editVoiceVolumeScale = 3.0f;
        this.editBgmVolumeScale = 2.0f;
    }

    public final boolean a() {
        return this.deviceAlgDelay;
    }

    public final float b() {
        return this.editBgmVolumeScale;
    }

    public final float c() {
        return this.editVoiceVolumeScale;
    }

    public final int d() {
        return this.enable;
    }
}
