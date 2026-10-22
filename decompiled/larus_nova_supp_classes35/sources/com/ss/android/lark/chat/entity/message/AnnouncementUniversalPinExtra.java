package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/AnnouncementUniversalPinExtra;", "Lcom/ss/android/lark/chat/entity/message/UniversalPinExtra;", "pinId", BuildConfig.FLAVOR, "pinChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "<init>", "(Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;)V", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "toString", BuildConfig.FLAVOR, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnouncementUniversalPinExtra extends UniversalPinExtra {
    @Override // com.ss.android.lark.chat.entity.message.UniversalPinExtra
    public String toString() {
        return "AnnouncementUniversalPinExtra(" + super.toString() + ')';
    }

    @Override // com.ss.android.lark.chat.entity.message.UniversalPinExtra
    public boolean isContentSame(UniversalPinExtra r2) {
        if ((r2 instanceof AnnouncementUniversalPinExtra) == true) goto L7;
        return false;
    L7:
        return super.isContentSame(r2);
    }

    @Override // com.ss.android.lark.chat.entity.message.UniversalPinExtra
    public boolean isItemSame(UniversalPinExtra r2) {
        if ((r2 instanceof AnnouncementUniversalPinExtra) == true) goto L7;
        return false;
    L7:
        return super.isItemSame(r2);
    }

    @Override // com.ss.android.lark.chat.entity.message.UniversalPinExtra
    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((UniversalPinExtra) r1);
    }

    @Override // com.ss.android.lark.chat.entity.message.UniversalPinExtra
    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((UniversalPinExtra) r1);
    }

    public AnnouncementUniversalPinExtra(Long r2, ChatChatter r3) {
        super(r2, r3, UniversalPinExtraType.ANNOUNCEMENT_PIN);
    }
}
