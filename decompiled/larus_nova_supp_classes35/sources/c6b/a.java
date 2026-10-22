package c6b;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.chat.service.impl.a1;
import com.ss.android.lark.parser.internal.r;
import com.ss.android.lark.utils.UIHelper;
import f5b.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements gya.a<MergeForwardContent> {
    public a() {
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final MessageType a() {
        return MessageType.MERGE_FORWARD;
    }

    public final String d(Context r2, Content r3) {
        MergeForwardContent r4 = (MergeForwardContent) r3;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "content");
        if (r4.isFromPrivateTopic() == false) goto L6;
        return r4.getSubtitle();
    L6:
        return a1.a(r4).a;
    }

    public final String f(Context r2, Content r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter((MergeForwardContent) r3, "content");
        return UIHelper.getString(2131891921);
    }

    public final String h(Context r1, b r2) {
        gya.a.a.a(r1, r2);
        return null;
    }

    public final Content g(Entity r2, Message r3, com.bytedance.lark.pb.basic.v1.Content r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "pbContent");
        return r.h(r2, r3, r4);
    }

    public final Content e(Entity r1, Message r2, com.bytedance.lark.pb.basic.v1.Content r3, TranslateInfo r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "pbContent");
        return r.h(r1, r2, r3);
    }

    public final void i(com.bytedance.lark.pb.basic.v1.Content r1, BaseTextContent<?> r2, String r3, Entity r4) {
        gya.a.a.b(r1, r2, r3);
    }
}
