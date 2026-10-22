package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.ParseServerMessagesRequest;
import com.bytedance.lark.pb.im.v1.ParseServerMessagesResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.mergeforward.ParseMergeForwardDataUtils$wrapCallback$1;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u implements Runnable {
    public final /* synthetic */ List<ByteString> a;
    public final /* synthetic */ ImSdkMessageServiceImplV2 b;
    public final /* synthetic */ IGetDataCallback<Message> c;

    public static final class a<T, R> implements Function {
        public static final a<T, R> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r6) {
            com.bytedance.lark.rustclient.api.x r7 = (com.bytedance.lark.rustclient.api.x) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            Entity r8 = ((ParseServerMessagesResponse) r7.c).entity;
            if (r8 != null) goto L5;
            return null;
        L5:
            if (r8.messages.values().size() <= 1) goto L19;
            Iterator<T> r0 = r8.messages.values().iterator();
        L8:
            if (r0.hasNext() == false) goto L18;
            com.bytedance.lark.pb.basic.v1.Message r2 = (com.bytedance.lark.pb.basic.v1.Message) r0.next();
            if (r2.type == com.bytedance.lark.pb.basic.v1.Message.Type.MERGE_FORWARD) goto L12;
        L14:
            boolean r3 = false;
        L15:
            if (r3 == false) goto L8;
        L28:
            return ModelParserMessage.f(r8, r2);
        L12:
            if (r2.thread_message_type != com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType.UNKNOWN_THREAD_MESSAGE) goto L14;
            r3 = true;
            goto L15
        L18:
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        L19:
            r2 = (com.bytedance.lark.pb.basic.v1.Message) CollectionsKt.first(r8.messages.values());
            goto L28
        }
    }

    public u(List r1, ImSdkMessageServiceImplV2 r2, ParseMergeForwardDataUtils$wrapCallback$1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        ParseServerMessagesRequest.Builder r3 = new ParseServerMessagesRequest.Builder().ser_messages(this.a);
        Intrinsics.checkNotNull(r3);
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r3, ParseServerMessagesResponse.ADAPTER, Command.PARSE_SERVER_MESSAGES, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.b.c.h(r0).a()).map(a.a), this.c);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
