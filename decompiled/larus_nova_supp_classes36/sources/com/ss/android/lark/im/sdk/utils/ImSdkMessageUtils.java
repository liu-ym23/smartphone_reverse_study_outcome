package com.ss.android.lark.im.sdk.utils;

import android.content.Context;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkMessageUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ImSdkMessageUtils$appProxy$2.INSTANCE);
    }

    @JvmStatic
    public static final String a(Message r2) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        if (r2.getType() != Message.Type.TEXT) goto L6;
        return r2.getContent().getText();
    L6:
        if (r2.getType() == Message.Type.POST) goto L11;
        return "";
    L11:
        return r2.getContent().getText();
    }

    @JvmStatic
    public static final boolean c(Message r9) {
        Intrinsics.checkNotNullParameter(r9, INotificationHitPoint.NoticeType.MESSAGE);
        if (r9.isOnTimeDel() == false) goto L6;
    L10:
        boolean r0 = false;
    L12:
        if (r9.isBurned() == true) goto L18;
        if (r0 == true) goto L18;
        if (r9.getBurnTime() > 0) goto L17;
        return false;
    L17:
        if (r9.getBurnTime() <= ((okb.a) a.getValue()).a()) goto L18;
        return false;
    L18:
        return true;
    L6:
        if (r9.getBurnLife() <= 0) goto L10;
        if ((((okb.a) a.getValue()).a() - ((long) 604800000)) < (r9.getCreateTime() * ((long) AudioViewModel.ASR_SESSION_IDLE))) goto L10;
        r0 = true;
        goto L12
    }

    @JvmStatic
    public static final void d(Message r7) {
        if (c(r7) == false) goto L8;
        long r0 = ((okb.a) a.getValue()).a();
        if ((r0 - r7.getBurnTime()) >= 7200000) goto L9;
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        Log.i("MessageUtils", String.format("%s id:%s, create:%s, life:%s, burn:%s, ntp:%s", Arrays.copyOf(new Object[]{"get burned pb message ", r7.getId(), Long.valueOf(r7.getCreateTime()), Integer.valueOf(r7.getBurnLife()), Long.valueOf(r7.getBurnTime()), Long.valueOf(r0)}, 6)));
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final Message.b b(Context r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, INotificationHitPoint.NoticeType.MESSAGE);
        Message.b r0 = new Message.b();
        r0.a = r3.getcId();
        r0.c = r3.getPreprocessKey();
        r0.d = r3.getType();
        FileContent r4 = r3.getContent();
        if ((r4 instanceof FileContent) == false) goto L7;
        Long r5 = r4.getFd(r2);
        if (r5 == null) goto L7;
        r0.b = r5;
    L7:
        return r0;
    }
}
