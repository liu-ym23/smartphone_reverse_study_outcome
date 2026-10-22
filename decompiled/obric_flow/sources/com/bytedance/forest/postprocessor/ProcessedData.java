package com.bytedance.forest.postprocessor;

import ai.j0;
import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.p;
import com.bytedance.forest.model.w;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\u00020\tH\u0010¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0010¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\tH\u0010¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u000bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010%\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130!H\u0010¢\u0006\u0004\b#\u0010$J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010\u001eR\u0017\u0010\u0006\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/bytedance/forest/postprocessor/ProcessedData;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/forest/model/p;", "", "size", "data", "<init>", "(ILjava/lang/Object;)V", "", "isCacheProvided$forest_release", "()Z", "isCacheProvided", "isCacheReady$forest_release", "isCacheReady", "isCacheClear$forest_release", "isCacheClear", "Lcom/bytedance/forest/model/w;", "response", "", "tryLoadToMemory$forest_release", "(Lcom/bytedance/forest/model/w;)V", "tryLoadToMemory", "", "provideBytes", "()[B", "Ljava/io/InputStream;", "provideInputStream", "(Lcom/bytedance/forest/model/w;)Ljava/io/InputStream;", "supportReuse", "()I", "close", "()V", "Lkotlin/Function0;", "onFulFilled", "fulfillListener$forest_release", "(Lkotlin/jvm/functions/Function0;)V", "fulfillListener", "", "toString", "()Ljava/lang/String;", "I", "getSize", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "forest_release"}, k = 1, mv = {1, 4, 0})
public final class ProcessedData<T> extends p {
    private final T data;
    private final int size;

    public ProcessedData(int r5, T r10) {
        this.size = r5;
        this.data = r10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.forest.model.p
    public void fulfillListener$forest_release(Function0<Unit> r5) {
        r5.invoke();
    }

    public final T getData() {
        return this.data;
    }

    public final int getSize() {
        return this.size;
    }

    @Override // com.bytedance.forest.model.p
    public boolean isCacheClear$forest_release() {
        return false;
    }

    @Override // com.bytedance.forest.model.p
    public boolean isCacheProvided$forest_release() {
        return true;
    }

    @Override // com.bytedance.forest.model.p
    public boolean isCacheReady$forest_release() {
        return true;
    }

    @Override // com.bytedance.forest.model.p
    public byte[] provideBytes() {
        return null;
    }

    @Override // com.bytedance.forest.model.p
    public InputStream provideInputStream(w r5) {
        return null;
    }

    @Override // com.bytedance.forest.model.p
    public int size() {
        return this.size;
    }

    @Override // com.bytedance.forest.model.p
    public boolean supportReuse() {
        return true;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(super.toString());
        r5.append("{data=");
        r5.append(this.data.getClass().getCanonicalName());
        r5.append(", size=");
        return j0.n(r5, this.size, '}');
    }

    @Override // com.bytedance.forest.model.p
    public void tryLoadToMemory$forest_release(w r5) {
    }
}
