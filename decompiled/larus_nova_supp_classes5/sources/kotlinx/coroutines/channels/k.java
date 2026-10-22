package kotlinx.coroutines.channels;

import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface k<E> extends CoroutineScope, SendChannel<E> {
    SendChannel<E> getChannel();
}
