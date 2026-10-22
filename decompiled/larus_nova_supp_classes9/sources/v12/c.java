package v12;

import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface c {
    String b();

    boolean c();

    String getDescription();

    long getEffectId();

    IBaseUser getFromUser();

    long getGiftId();

    String getInteractGiftInfo();

    String getLogId();

    long getMsgId();

    int getPriority();

    long getRepeatCount();

    IBaseUser getToUser();

    String getTraceId();

    boolean isLocal();
}
