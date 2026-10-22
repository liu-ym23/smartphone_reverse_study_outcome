package androidx.activity.contextaware;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface ContextAware {
    void addOnContextAvailableListener(OnContextAvailableListener r1);

    Context peekAvailableContext();

    void removeOnContextAvailableListener(OnContextAvailableListener r1);
}
