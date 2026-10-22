package com.larus.bmhome.chat.standarduikit.browsercontrol.vm;

import com.larus.bmhome.chat.standarduikit.browsercontrol.view.ButtonStatus;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BrowserControlViewModel {
    public a a;
    public b b;
    public ButtonStatus c;
    public boolean d;
    public boolean e;
    public String f;
    public final Lazy g;

    public BrowserControlViewModel() {
        this.c = ButtonStatus.ENABLED;
        this.g = LazyKt.lazy(new d(this));
    }
}
