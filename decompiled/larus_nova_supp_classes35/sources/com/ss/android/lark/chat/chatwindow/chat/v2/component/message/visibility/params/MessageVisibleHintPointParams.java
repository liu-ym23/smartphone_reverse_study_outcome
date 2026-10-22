package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params;

import com.ss.android.lark.chat.entity.message.Message;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aBK\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00122\u0010\u0005\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\b\b\u0000\u0010\u000f*\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0007¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR:\u0010\u0005\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MessageVisibleHintPointParams;", "Ljava/io/Serializable;", "unTrackedMessageTypes", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/chat/entity/message/Message$Type;", "bizParams", "Ljava/util/LinkedHashMap;", "Ljava/lang/Class;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MessageVisibleBizParams;", "Lkotlin/collections/LinkedHashMap;", "<init>", "(Ljava/util/LinkedList;Ljava/util/LinkedHashMap;)V", "getUnTrackedMessageTypes", "()Ljava/util/LinkedList;", "get", "T", "clazz", "(Ljava/lang/Class;)Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MessageVisibleBizParams;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Builder", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageVisibleHintPointParams implements Serializable {
    private final LinkedHashMap<Class<? extends MessageVisibleBizParams>, MessageVisibleBizParams> bizParams;
    private final LinkedList<Message.Type> unTrackedMessageTypes;

    public static final class Builder {
        public final m2b.a a;
        public LinkedList<Message.Type> b;
        public Function0<a> c;

        public Builder(m2b.a r1) {
            this.a = r1;
            this.b = new LinkedList();
            this.c = MessageVisibleHintPointParams$Builder$summaryInfoProvider$1.INSTANCE;
        }
    }

    public MessageVisibleHintPointParams() {
        throw null;
    }

    public int hashCode() {
        return (this.unTrackedMessageTypes.hashCode() * 31) + this.bizParams.hashCode();
    }

    public String toString() {
        return "MessageVisibleHintPointParams(unTrackedMessageTypes=" + this.unTrackedMessageTypes + ", bizParams=" + this.bizParams + ')';
    }

    public final LinkedList<Message.Type> getUnTrackedMessageTypes() {
        return this.unTrackedMessageTypes;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(MessageVisibleHintPointParams.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.MessageVisibleHintPointParams");
        MessageVisibleHintPointParams r6 = (MessageVisibleHintPointParams) r5;
        if (Intrinsics.areEqual(this.unTrackedMessageTypes, r6.unTrackedMessageTypes) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bizParams, r6.bizParams) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final <T extends MessageVisibleBizParams> T get(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        MessageVisibleBizParams r0 = this.bizParams.get(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r2.cast(r0);
    }

    public MessageVisibleHintPointParams(LinkedList r1, LinkedHashMap r2, DefaultConstructorMarker r3) {
        this.unTrackedMessageTypes = r1;
        this.bizParams = r2;
    }
}
