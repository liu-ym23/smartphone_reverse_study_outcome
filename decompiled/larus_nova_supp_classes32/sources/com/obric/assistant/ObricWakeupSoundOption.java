package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JY\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/obric/assistant/ObricWakeupSoundOption;", NameKeys.UnloadStrategy_No_Strategy, "id", NameKeys.UnloadStrategy_No_Strategy, "type", LynxResourceModule.AUDIO_TYPE, "audioPool", NameKeys.UnloadStrategy_No_Strategy, "resourceSource", "trackName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "getAudio", "getAudioPool", "()Ljava/util/List;", "getResourceSource", "getTrackName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWakeupSoundOption {

    @SerializedName(LynxResourceModule.AUDIO_TYPE)
    private final String audio;

    @SerializedName(alternate = {"audioPool"}, value = "audio_pool")
    private final List<String> audioPool;

    @SerializedName("id")
    private final String id;

    @SerializedName(alternate = {"resourceSource"}, value = "resource_source")
    private final String resourceSource;

    @SerializedName(alternate = {"trackName"}, value = "track_name")
    private final String trackName;

    @SerializedName("type")
    private final String type;

    public ObricWakeupSoundOption() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricWakeupSoundOption copy$default(ObricWakeupSoundOption r4, String r5, String r6, String r7, List r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.id;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.type;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.audio;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.audioPool;
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.resourceSource;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.trackName;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.audio;
    }

    public final List<String> component4() {
        return this.audioPool;
    }

    public final String component5() {
        return this.resourceSource;
    }

    public final String component6() {
        return this.trackName;
    }

    public final ObricWakeupSoundOption copy(String r9, String r10, String r11, List<String> r12, String r13, String r14) {
        return new ObricWakeupSoundOption(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricWakeupSoundOption) == true) goto L8;
        return false;
    L8:
        ObricWakeupSoundOption r6 = (ObricWakeupSoundOption) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.audio, r6.audio) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.audioPool, r6.audioPool) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resourceSource, r6.resourceSource) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.trackName, r6.trackName) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.type;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.audio;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.audioPool;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.resourceSource;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.trackName;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricWakeupSoundOption(id=" + this.id + ", type=" + this.type + ", audio=" + this.audio + ", audioPool=" + this.audioPool + ", resourceSource=" + this.resourceSource + ", trackName=" + this.trackName + ')';
    }

    public final String getAudio() {
        return this.audio;
    }

    public final List<String> getAudioPool() {
        return this.audioPool;
    }

    public final String getId() {
        return this.id;
    }

    public final String getResourceSource() {
        return this.resourceSource;
    }

    public final String getTrackName() {
        return this.trackName;
    }

    public final String getType() {
        return this.type;
    }

    public ObricWakeupSoundOption(String r1, String r2, String r3, List<String> r4, String r5, String r6) {
        this.id = r1;
        this.type = r2;
        this.audio = r3;
        this.audioPool = r4;
        this.resourceSource = r5;
        this.trackName = r6;
    }

    public /* synthetic */ ObricWakeupSoundOption(String r6, String r7, String r8, List r9, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        List r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        String r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
