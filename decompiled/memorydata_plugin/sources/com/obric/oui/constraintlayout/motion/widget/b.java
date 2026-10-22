package com.obric.oui.constraintlayout.motion.widget;

import android.util.Pair;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final HashMap<Pair<Integer, Integer>, String> f13683a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final HashMap<String, String> f13684b = null;
    private final MotionLayout c;
    private String d;
    private String e;
    private int f;
    private int g;

    static {
        HashMap<Pair<Integer, Integer>, String> r0 = new HashMap();
        f13683a = r0;
        HashMap<String, String> r1 = new HashMap();
        f13684b = r1;
        r0.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        r0.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        r0.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        r0.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        r0.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        r0.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        r0.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        r0.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        r0.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        r0.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        r0.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        r0.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        r0.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        r1.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        r1.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        r1.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        r1.put("layout_constraintTop_toTopOf", "layout_marginTop");
        r1.put("layout_constraintStart_toStartOf", "layout_marginStart");
        r1.put("layout_constraintStart_toEndOf", "layout_marginStart");
        r1.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        r1.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        r1.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        r1.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        r1.put("layout_constraintRight_toRightOf", "layout_marginRight");
        r1.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public b(MotionLayout r2) {
        this.d = null;
        this.e = null;
        this.f = -1;
        this.g = -1;
        this.c = r2;
    }
}
