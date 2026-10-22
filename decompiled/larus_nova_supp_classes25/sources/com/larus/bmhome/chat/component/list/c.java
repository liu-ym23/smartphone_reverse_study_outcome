package com.larus.bmhome.chat.component.list;

import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static int k;
    public final Fragment a;
    public final com.larus.bmhome.chat.component.cvs.y b;
    public final ChatListComponentViewModel c;
    public boolean d;
    public boolean e;
    public long f;
    public boolean g;
    public long h;
    public final long i;
    public MessageAdapter j;

    public static final class a {
    }

    static {
    }

    public c(Fragment r2, com.larus.bmhome.chat.component.cvs.y r3, ChatListComponentViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        k++;
        this.i = SystemClock.elapsedRealtime();
    }
}
