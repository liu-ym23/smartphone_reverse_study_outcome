package s2a;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.bot.IconItem;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011JP\u0010\u0016\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/v2/api/VoiceMaterialResponse;", NameKeys.UnloadStrategy_No_Strategy, "voiceMaterial", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "voiceIconList", "Lcom/larus/im/bean/bot/IconItem;", "hasUgcVoiceRecord", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/util/Map;Ljava/util/List;Ljava/lang/Boolean;)V", "getVoiceMaterial", "()Ljava/util/Map;", "getVoiceIconList", "()Ljava/util/List;", "getHasUgcVoiceRecord", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/util/Map;Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/voice_setting/voice/dialog/v2/api/VoiceMaterialResponse;", "equals", "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("has_ugc_voice_record")
    private final Boolean hasUgcVoiceRecord;

    @SerializedName("voice_icon_list")
    private final List<IconItem> voiceIconList;

    @SerializedName("voice_material")
    private final Map<String, List<String>> voiceMaterial;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.voiceMaterial, r6.voiceMaterial) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.voiceIconList, r6.voiceIconList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hasUgcVoiceRecord, r6.hasUgcVoiceRecord) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Map<String, List<String>> r0 = this.voiceMaterial;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<IconItem> r4 = this.voiceIconList;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.hasUgcVoiceRecord;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceMaterialResponse(voiceMaterial=" + this.voiceMaterial + ", voiceIconList=" + this.voiceIconList + ", hasUgcVoiceRecord=" + this.hasUgcVoiceRecord + ')';
    }

    public a() {
        this.voiceMaterial = null;
        this.voiceIconList = null;
        this.hasUgcVoiceRecord = null;
    }

    public final List<IconItem> a() {
        return this.voiceIconList;
    }

    public final Map<String, List<String>> b() {
        return this.voiceMaterial;
    }
}
