package com.ss.android.lark.chat.export.entity.chatter;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\fH&J\b\u0010\u0011\u001a\u00020\u0012H'J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\b\b\u0000\u0010\u0019*\u00020\u001aH&¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chat/export/entity/chatter/OpenChatter;", "Ljava/io/Serializable;", "getId", BuildConfig.FLAVOR, "getName", "getNamePy", "getEnName", "getNameWithAnotherName", "getAlias", "getLocalizedName", "getAvatarKey", "isBot", BuildConfig.FLAVOR, "isDimission", "isFrozen", "getTenantId", "isRegistered", "getZenModeEndTime", BuildConfig.FLAVOR, "getAccess", "Lcom/ss/android/lark/chat/export/entity/chatter/IAccess;", "getDesc", "Lcom/ss/android/lark/chat/export/entity/chatter/IChatterDesc;", "getCustomStatus", BuildConfig.FLAVOR, "T", "Lcom/ss/android/lark/chat/export/entity/chatter/IChatterCustomStatus;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OpenChatter extends Serializable {
    o5b.a getAccess();

    String getAlias();

    String getAvatarKey();

    <T> List<T> getCustomStatus();

    IChatterDesc getDesc();

    String getEnName();

    String getId();

    String getLocalizedName();

    String getName();

    String getNamePy();

    String getNameWithAnotherName();

    String getTenantId();

    @Deprecated(message = "use custom status")
    long getZenModeEndTime();

    boolean isBot();

    boolean isDimission();

    boolean isFrozen();

    boolean isRegistered();
}
