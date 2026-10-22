package com.obric.assistant.agent;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/agent/ObricSemanticServiceImpl;", "Lcom/obric/assistant/agent/IObricSemanticApi;", "<init>", "()V", "deleted", "Lcom/obric/assistant/agent/ObricSemanticServiceImpl$EvictingLinkedBlockingDeque;", "Lcom/larus/im/bean/message/Message;", "markDeleted", NameKeys.UnloadStrategy_No_Strategy, "message", "getDeleted", NameKeys.UnloadStrategy_No_Strategy, "Companion", "EvictingLinkedBlockingDeque", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSemanticServiceImpl implements IObricSemanticApi {
    public final EvictingLinkedBlockingDeque<Message> a;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/agent/ObricSemanticServiceImpl$EvictingLinkedBlockingDeque;", "E", "Ljava/util/concurrent/LinkedBlockingDeque;", "capacity", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(I)V", "offerFirstWithEviction", NameKeys.UnloadStrategy_No_Strategy, "e", "(Ljava/lang/Object;)Z", "putFirstWithEviction", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/Object;)V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EvictingLinkedBlockingDeque<E> extends LinkedBlockingDeque<E> {
        private final int capacity;

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingDeque, java.util.Deque
        public final /* bridge */ int size() {
            return getSize();
        }

        public EvictingLinkedBlockingDeque(int r1) {
            super(r1);
            this.capacity = r1;
        }

        public final boolean offerFirstWithEviction(E r5) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (remainingCapacity() != 0) goto L7;
            pollLast();     // Catch: Throwable -> L10
            FLogger.a.d("ObricSemanticServiceImp", "队列已满，丢弃队尾元素，剩余容量：" + remainingCapacity());     // Catch: Throwable -> L10
        L7:
            boolean r6 = offerFirst(r5);     // Catch: Throwable -> L10
            monitor-exit(this);
            return r6;
        }

        public final void putFirstWithEviction(E r5) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (remainingCapacity() != 0) goto L7;
            pollLast();     // Catch: Throwable -> L10
            FLogger.a.d("ObricSemanticServiceImp", "队列已满，丢弃队尾元素，剩余容量：" + remainingCapacity());     // Catch: Throwable -> L10
        L7:
            putFirst(r5);     // Catch: Throwable -> L10
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(this);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.agent.IObricSemanticApi
    public final List<Message> getDeleted() {
        List r0 = CollectionsKt.toList(this.a);
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((Message) r3) == null) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        return r1;
    }

    public ObricSemanticServiceImpl() {
        this.a = new EvictingLinkedBlockingDeque(10);
    }

    @Override // com.obric.assistant.agent.IObricSemanticApi
    public final void a(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        this.a.offerFirstWithEviction(r3);
        FLogger.a.d("ObricSemanticServiceImp", "deleted：" + this.a);
    }
}
