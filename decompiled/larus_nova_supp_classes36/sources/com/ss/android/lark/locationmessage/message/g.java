package com.ss.android.lark.locationmessage.message;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.LocationContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements gya.a<LocationContent> {
    public g() {
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final MessageType a() {
        return MessageType.LOCATION;
    }

    public final String d(Context r3, Content r4) {
        LocationContent r5 = (LocationContent) r4;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "content");
        return UIHelper.mustacheFormat(2131890400, "title", r5.getName());
    }

    public final String f(Context r2, Content r3) {
        LocationContent r4 = (LocationContent) r3;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "content");
        return UIHelper.mustacheFormat(2131890400, "title", r4.getName());
    }

    public final String h(Context r1, f5b.b r2) {
        gya.a.a.a(r1, r2);
        return null;
    }

    public final Content g(Entity r1, Message r2, com.bytedance.lark.pb.basic.v1.Content r3) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r3, "pbContent");
        return i.a(r3);
    }

    public final Content e(Entity r1, Message r2, com.bytedance.lark.pb.basic.v1.Content r3, TranslateInfo r4) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r3, "pbContent");
        return i.a(r3);
    }

    public final void i(com.bytedance.lark.pb.basic.v1.Content r1, BaseTextContent<?> r2, String r3, Entity r4) {
        gya.a.a.b(r1, r2, r3);
    }
}
