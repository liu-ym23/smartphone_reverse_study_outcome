package com.ss.android.lark.chameleon.api;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012(\b\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ)\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J)\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003Jg\u0010\u0017\u001a\u00020\u00002(\b\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0004H\u0016R:\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR:\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chameleon/api/ChameleonGeckoConfig;", "Ljava/io/Serializable;", "accessKey", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "channels", "enable", BuildConfig.FLAVOR, "(Ljava/util/HashMap;Ljava/util/HashMap;Z)V", "getAccessKey", "()Ljava/util/HashMap;", "setAccessKey", "(Ljava/util/HashMap;)V", "getChannels", "setChannels", "getEnable", "()Z", "setEnable", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonGeckoConfig implements Serializable {
    private HashMap<String, String> accessKey;
    private HashMap<String, String> channels;
    private boolean enable;

    public ChameleonGeckoConfig() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChameleonGeckoConfig copy$default(ChameleonGeckoConfig r0, HashMap r1, HashMap r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.accessKey;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.channels;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.enable;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final HashMap<String, String> component1() {
        return this.accessKey;
    }

    public final HashMap<String, String> component2() {
        return this.channels;
    }

    public final boolean component3() {
        return this.enable;
    }

    public final ChameleonGeckoConfig copy(HashMap<String, String> r2, HashMap<String, String> r3, boolean r4) {
        return new ChameleonGeckoConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChameleonGeckoConfig) == true) goto L8;
        return false;
    L8:
        ChameleonGeckoConfig r6 = (ChameleonGeckoConfig) r5;
        if (Intrinsics.areEqual(this.accessKey, r6.accessKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.channels, r6.channels) == true) goto L15;
        return false;
    L15:
        if (this.enable == r6.enable) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        HashMap<String, String> r0 = this.accessKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        HashMap<String, String> r4 = this.channels;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.enable;
        ?? r7 = r6;
        if (r6 == false) goto L14;
        r7 = 1;
    L14:
        return r5 + r7;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ChameleonGeckoConfig(accessKey=" + this.accessKey + ", channels=" + this.channels + ", enable=" + this.enable + ')';
    }

    public final HashMap<String, String> getAccessKey() {
        return this.accessKey;
    }

    public final HashMap<String, String> getChannels() {
        return this.channels;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final void setAccessKey(HashMap<String, String> r1) {
        this.accessKey = r1;
    }

    public final void setChannels(HashMap<String, String> r1) {
        this.channels = r1;
    }

    public final void setEnable(boolean r1) {
        this.enable = r1;
    }

    public ChameleonGeckoConfig(HashMap<String, String> r1, HashMap<String, String> r2, boolean r3) {
        this.accessKey = r1;
        this.channels = r2;
        this.enable = r3;
    }

    public /* synthetic */ ChameleonGeckoConfig(HashMap r2, HashMap r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = true;
    L11:
        this(r2, r3, r4);
    }
}
