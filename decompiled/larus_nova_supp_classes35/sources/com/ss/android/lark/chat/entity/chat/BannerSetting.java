package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ)\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003JP\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR1\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/BannerSetting;", "Ljava/io/Serializable;", "chatMessagePosition", BuildConfig.FLAVOR, "chatThreadPosition", "i18nNamesMap", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/HashMap;)V", "getChatMessagePosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChatThreadPosition", "getI18nNamesMap", "()Ljava/util/HashMap;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/HashMap;)Lcom/ss/android/lark/chat/entity/chat/BannerSetting;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BannerSetting implements Serializable {
    private final Integer chatMessagePosition;
    private final Integer chatThreadPosition;
    private final HashMap<String, String> i18nNamesMap;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BannerSetting copy$default(BannerSetting r0, Integer r1, Integer r2, HashMap r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.chatMessagePosition;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.chatThreadPosition;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.i18nNamesMap;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.chatMessagePosition;
    }

    public final Integer component2() {
        return this.chatThreadPosition;
    }

    public final HashMap<String, String> component3() {
        return this.i18nNamesMap;
    }

    public final BannerSetting copy(Integer r2, Integer r3, HashMap<String, String> r4) {
        return new BannerSetting(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BannerSetting) == true) goto L8;
        return false;
    L8:
        BannerSetting r6 = (BannerSetting) r5;
        if (Intrinsics.areEqual(this.chatMessagePosition, r6.chatMessagePosition) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatThreadPosition, r6.chatThreadPosition) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.i18nNamesMap, r6.i18nNamesMap) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.chatMessagePosition;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.chatThreadPosition;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        HashMap<String, String> r7 = this.i18nNamesMap;
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

    public String toString() {
        return "BannerSetting(chatMessagePosition=" + this.chatMessagePosition + ", chatThreadPosition=" + this.chatThreadPosition + ", i18nNamesMap=" + this.i18nNamesMap + ')';
    }

    public final Integer getChatMessagePosition() {
        return this.chatMessagePosition;
    }

    public final Integer getChatThreadPosition() {
        return this.chatThreadPosition;
    }

    public final HashMap<String, String> getI18nNamesMap() {
        return this.i18nNamesMap;
    }

    public BannerSetting(Integer r1, Integer r2, HashMap<String, String> r3) {
        this.chatMessagePosition = r1;
        this.chatThreadPosition = r2;
        this.i18nNamesMap = r3;
    }
}
