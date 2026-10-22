package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c1 {
    public float a;
    public final PublishSubject<Float> b;
    public final List<a> c;

    public static final class a {
        public float a;
        public final float b;

        public a(float r1) {
            this.b = r1;
        }
    }

    public c1() {
        this.b = PublishSubject.create();
        this.c = new ArrayList();
    }
}
