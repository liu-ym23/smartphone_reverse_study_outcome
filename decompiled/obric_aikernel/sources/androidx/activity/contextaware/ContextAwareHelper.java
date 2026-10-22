package androidx.activity.contextaware;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    public void addOnContextAvailableListener(@NonNull OnContextAvailableListener r10) {
        if (this.mContext == null) goto L5;
        r10.onContextAvailable(this.mContext);
    L5:
        this.mListeners.add(r10);
    }

    public void clearAvailableContext() {
        this.mContext = null;
    }

    public void dispatchOnContextAvailable(@NonNull Context r10) {
        this.mContext = r10;
        Iterator<OnContextAvailableListener> r11 = this.mListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onContextAvailable(r10);
        goto L4
    }

    @Nullable
    public Context peekAvailableContext() {
        return this.mContext;
    }

    public void removeOnContextAvailableListener(@NonNull OnContextAvailableListener r10) {
        this.mListeners.remove(r10);
    }
}
