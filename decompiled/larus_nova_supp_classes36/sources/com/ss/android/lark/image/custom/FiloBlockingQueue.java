package com.ss.android.lark.image.custom;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/image/custom/FiloBlockingQueue;", "E", "Ljava/util/concurrent/LinkedBlockingDeque;", "<init>", "()V", "offer", "", "e", "(Ljava/lang/Object;)Z", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FiloBlockingQueue<E> extends LinkedBlockingDeque<E> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingDeque, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }

    public FiloBlockingQueue() {
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
    public boolean offer(E r1) {
        return offerFirst(r1);
    }
}
