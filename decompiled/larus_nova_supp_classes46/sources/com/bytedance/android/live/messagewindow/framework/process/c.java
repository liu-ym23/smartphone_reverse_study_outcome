package com.bytedance.android.live.messagewindow.framework.process;

import com.bytedance.android.live.room.api.messagewindow.process.MsgWindowAdjustSource;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements h71.b {
    public final HashMap<MsgWindowAdjustSource, h71.a> a;
    public final CompositeDisposable b;

    public c() {
        this.a = new HashMap();
        this.b = new CompositeDisposable();
    }

    public final HashMap<MsgWindowAdjustSource, h71.a> k() {
        return this.a;
    }
}
