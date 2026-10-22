package com.ss.android.lark.chat.chatwindow.chat.v2.extension;

import androidx.lifecycle.MutableLiveData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007J\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/extension/PausableLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "paused", "Ljava/util/concurrent/atomic/AtomicBoolean;", "proxyLiveData", "pendingValue", "Ljava/lang/Object;", "pause", BuildConfig.FLAVOR, "resume", "postValue", "value", "(Ljava/lang/Object;)V", "setValue", "unPausedLiveData", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PausableLiveData<T> extends MutableLiveData<T> {
    public final AtomicBoolean a;
    public final MutableLiveData<T> b;
    public T c;

    public PausableLiveData() {
        this.a = new AtomicBoolean(false);
        this.b = new MutableLiveData();
    }

    public final void postValue(T r2) {
        this.b.postValue(r2);
        if (this.a.get() == false) goto L11;
        monitor-enter(this);
        this.c = r2;     // Catch: Throwable -> L8
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        super.postValue(r2);
    }

    public final void setValue(T r2) {
        this.b.setValue(r2);
        if (this.a.get() == false) goto L5;
        this.c = r2;
        return;
    L5:
        super.setValue(r2);
    }
}
