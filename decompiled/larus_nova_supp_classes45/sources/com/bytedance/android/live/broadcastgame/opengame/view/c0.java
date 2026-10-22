package com.bytedance.android.live.broadcastgame.opengame.view;

import com.bytedance.android.live.broadcastgame.opengame.message.m0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c0 implements h {
    public final ArrayDeque<m0> a;
    public final ArrayList<m0> b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.h
    public final m0 poll() {
        return this.a.poll();
    }

    public c0() {
        this.a = new ArrayDeque();
        this.b = new ArrayList();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.h
    public final List<m0> getAll() {
        return this.b;
    }
}
