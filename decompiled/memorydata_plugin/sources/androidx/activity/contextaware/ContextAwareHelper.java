package androidx.activity.contextaware;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareHelper {
    private volatile Context mContext;
    private final Set<OnContextAvailableListener> mListeners;

    public ContextAwareHelper() {
        this.mListeners = new CopyOnWriteArraySet();
    }

    public void addOnContextAvailableListener(OnContextAvailableListener r3) {
        OnContextAvailableListener r4 = (OnContextAvailableListener) ZeusTransformUtils.wrapperContextForParams(r3, OnContextAvailableListener.class, "com.obric.memorydata.plugin");
        if (this.mContext == null) goto L5;
        r4.onContextAvailable(this.mContext);
    L5:
        this.mListeners.add(r4);
    }

    public void clearAvailableContext() {
        this.mContext = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
    }

    public void dispatchOnContextAvailable(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        Iterator<OnContextAvailableListener> r3 = this.mListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((OnContextAvailableListener) ZeusTransformUtils.preCheckCast(r3.next(), OnContextAvailableListener.class, "com.obric.memorydata.plugin")).onContextAvailable(r5);
        goto L4
    }

    public Context peekAvailableContext() {
        return this.mContext;
    }

    public void removeOnContextAvailableListener(OnContextAvailableListener r3) {
        OnContextAvailableListener r4 = (OnContextAvailableListener) ZeusTransformUtils.wrapperContextForParams(r3, OnContextAvailableListener.class, "com.obric.memorydata.plugin");
        this.mListeners.remove(r4);
    }
}
